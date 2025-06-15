#!/usr/bin/env python3
"""
Smartwatch Face Compiler - Versión Completa
===============================================

Compilador completo para crear archivos .bin de faces/diales de smartwatch
basado en el análisis completo de:
- libsmawatchface.so (descompilado con Ghidra)
- CO-FIT_base.apk (código Java descompilado)
- Scripts de descompilación existentes

Autor: Basado en ingeniería inversa de múltiples fuentes
Fecha: 2025
"""

import os
import sys
import json
import struct
import argparse
import time
import logging
from pathlib import Path
from PIL import Image
import numpy as np
from typing import List, Dict, Tuple, Optional, Any
from dataclasses import dataclass
from enum import IntEnum

# Configurar logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

class ElementType(IntEnum):
    """Tipos de elementos según análisis de la APK CO-FIT"""
    PREVIEW = 1
    BACKGROUND = 2
    ARM_HOUR = 3
    ARM_MINUTE = 4
    ARM_SECOND = 5
    YEAR = 6
    MONTH = 7
    DAY = 8
    DIGITAL_HOUR = 9
    DIGITAL_MINUTE = 10
    DIGITAL_SECOND = 11
    DIGITAL_AMPM = 12
    DIGITAL_WEEKDAY = 13
    DIGITAL_STEPS = 14
    DIGITAL_HEART = 15
    DIGITAL_CALORIE = 16
    DIGITAL_DISTANCE = 17
    DIGITAL_BATTERY_NUMBER = 18
    DIGITAL_WEATHER = 25
    DIGITAL_TEMPERATURE = 26
    DIGITAL_BATTERY_STRIP = 24
    BG_IMAGE_ARRAY = 44
    
    # Versiones con alpha (tipo | 0x80)
    PREVIEW_ALPHA = 0x81
    BACKGROUND_ALPHA = 0x82
    ARM_HOUR_ALPHA = 0x83
    ARM_MINUTE_ALPHA = 0x84
    ARM_SECOND_ALPHA = 0x85
    DIGITAL_HOUR_ALPHA = 0x89
    DIGITAL_MINUTE_ALPHA = 0x8A
    DIGITAL_SECOND_ALPHA = 0x8B
    DIGITAL_AMPM_ALPHA = 0x8C
    DIGITAL_WEEKDAY_ALPHA = 0x8D
    DIGITAL_STEPS_ALPHA = 0x8E
    DIGITAL_HEART_ALPHA = 0x8F
    DIGITAL_CALORIE_ALPHA = 0x90
    DIGITAL_BATTERY_STRIP_ALPHA = 0x98

@dataclass
class WatchfaceElement:
    """
    Estructura de elemento basada en análisis de libsmawatchface.so
    Corresponde a la estructura Element.java de la APK
    """
    # Campos básicos del elemento (32 bytes en memoria nativa)
    element_type: int                   # Offset 0x00 (1 byte)
    has_alpha: bool                    # Offset 0x01 (1 byte)  
    width: int                         # Offset 0x02 (2 bytes)
    height: int                        # Offset 0x04 (2 bytes)
    gravity: int                       # Offset 0x06 (1 byte)
    ignore_black: bool                 # Offset 0x07 (1 byte)
    x: int                             # Offset 0x08 (2 bytes)
    y: int                             # Offset 0x0A (2 bytes)
    play_interval: int                 # Offset 0x0C (1 byte)
    bottom_offset: int                 # Offset 0x0D (1 byte)
    left_offset: int                   # Offset 0x0E (1 byte)
    image_count: int                   # Offset 0x0F (1 byte)
    
    # Campos adicionales de configuración
    picidx: int = 0                    # Índice de imagen específico
    align: int = 0                     # Alineación
    compr: int = 4                     # Compresión
    centX: int = 0                     # Centro X
    centY: int = 0                     # Centro Y
    
    # Datos de imagen con valores por defecto
    image_files: List[str] = None      # Archivos de imagen
    image_data: List[bytes] = None     # Datos comprimidos de imágenes
    image_sizes: List[int] = None      # Tamaños de cada imagen
    
    def __post_init__(self):
        """Inicialización después de crear el objeto"""
        if self.image_files is None:
            self.image_files = []
        if self.image_data is None:
            self.image_data = []
        if self.image_sizes is None:
            self.image_sizes = []

class ImageCompressor:
    """Compresor de imágenes compatible con formato HK89/libsmawatchface.so"""
    
    @staticmethod
    def rgb_to_rgb565(r: int, g: int, b: int) -> int:
        """Convierte RGB888 a RGB565"""
        return ((r & 0xF8) << 8) | ((g & 0xFC) << 3) | (b >> 3)
    
    @staticmethod
    def compress_image_rle(image_path: str, has_alpha: bool = False) -> Optional[bytes]:
        """
        Comprime una imagen usando RLE compatible con libsmawatchface.so
        
        Formato RLE detectado en análisis:
        - 0x00: Pixel individual 
        - 0x80 | count: RLE run de 'count' pixels idénticos
        - count (1-127): Literal run de 'count' pixels diferentes
        """
        try:
            # Cargar imagen
            with Image.open(image_path) as img:
                # Convertir a RGBA si es necesario
                if img.mode != 'RGBA':
                    img = img.convert('RGBA')
                
                # Obtener datos como numpy array
                img_array = np.array(img)
                height, width = img_array.shape[:2]
                
                # Crear buffer de salida
                compressed = bytearray()
                
                # Header: offset al inicio de datos (2 bytes)
                header_pos = 0
                compressed.extend(b'\x02\x00')  # Datos empiezan en offset 2
                
                # Procesar pixel por pixel
                pixels = []
                for y in range(height):
                    for x in range(width):
                        r, g, b, a = img_array[y, x]
                        rgb565 = ImageCompressor.rgb_to_rgb565(r, g, b)
                        alpha = a if has_alpha else 255
                        pixels.append((rgb565, alpha))
                
                # Comprimir usando RLE optimizado
                i = 0
                while i < len(pixels):
                    current_rgb, current_alpha = pixels[i]
                    
                    # Buscar run de pixels idénticos
                    rle_count = 1
                    max_rle = min(127, len(pixels) - i)
                    
                    for j in range(1, max_rle):
                        if i + j >= len(pixels):
                            break
                        next_rgb, next_alpha = pixels[i + j]
                        if (current_rgb == next_rgb and 
                            (not has_alpha or current_alpha == next_alpha)):
                            rle_count += 1
                        else:
                            break
                    
                    if rle_count >= 2:
                        # RLE run: 0x80 | count
                        compressed.append(0x80 | rle_count)
                        if has_alpha:
                            compressed.append(current_alpha)
                        compressed.append((current_rgb >> 8) & 0xFF)
                        compressed.append(current_rgb & 0xFF)
                        i += rle_count
                    else:
                        # Pixel individual: 0x00
                        compressed.append(0x00)
                        if has_alpha:
                            compressed.append(current_alpha)
                        compressed.append((current_rgb >> 8) & 0xFF)
                        compressed.append(current_rgb & 0xFF)
                        i += 1
                
                logger.debug(f"Compressed {image_path}: {len(compressed)} bytes")
                return bytes(compressed)
                
        except Exception as e:
            logger.error(f"Error compressing {image_path}: {e}")
            return None

class WatchfaceBinaryBuilder:
    """
    Constructor de binarios basado en análisis de libsmawatchface.so
    
    Formato binario según Ghidra:
    1. Header (4 bytes): total_images (2) + num_elements (2)
    2. Tabla de elementos (20 bytes cada uno)
    3. Tabla de tamaños de imagen (4 bytes cada una)
    4. Datos de imágenes consecutivos
    """
    
    def __init__(self):
        self.elements: List[WatchfaceElement] = []
        self.total_images = 0
    
    def add_element_from_config(self, config: Dict, base_path: str) -> bool:
        """Añade un elemento desde configuración JSON"""
        try:
            # Determinar si tiene alpha basado en blocktype
            element_type = config['blocktype']
            has_alpha = (element_type & 0x80) != 0
              # Crear elemento
            element = WatchfaceElement(
                element_type=element_type,
                has_alpha=has_alpha,
                width=config['sx'],
                height=config['sy'],
                gravity=config.get('align', 0),
                ignore_black=config.get('ignoreBlack', False),
                x=config['posX'],
                y=config['posY'],
                play_interval=config.get('playInterval', 0),
                bottom_offset=config.get('bottomOffset', 0),
                left_offset=config.get('leftOffset', 0),
                image_count=config['parts'],
                picidx=config.get('picidx', 0),
                align=config.get('align', 0),
                compr=config.get('compr', 4), 
                centX=config.get('centX', 0),
                centY=config.get('centY', 0),
                image_files=[]
            )
            
            # Procesar archivos de imagen
            if config['parts'] > 1:
                # Multi-parte: usar part_filenames
                part_filenames = config.get('part_filenames', [])
                if not part_filenames:
                    logger.error(f"Multi-part element missing part_filenames")
                    return False
                element.image_files = part_filenames
            else:
                # Imagen única
                element.image_files = [config['fname']]
            
            # Comprimir imágenes
            for image_file in element.image_files:
                image_path = os.path.join(base_path, image_file)
                if not os.path.exists(image_path):
                    logger.error(f"Image not found: {image_path}")
                    return False
                
                compressed_data = ImageCompressor.compress_image_rle(image_path, has_alpha)
                if compressed_data is None:
                    logger.error(f"Failed to compress: {image_path}")
                    return False
                
                element.image_data.append(compressed_data)
                element.image_sizes.append(len(compressed_data))
            
            self.elements.append(element)
            self.total_images += len(element.image_files)
            
            logger.debug(f"Added element type {element_type}: {len(element.image_files)} images")
            return True
            
        except Exception as e:
            logger.error(f"Error adding element: {e}")
            return False
    
    def build_binary(self, output_path: str) -> bool:
        """
        Construye el archivo binario según el formato de libsmawatchface.so
        
        Algoritmo basado en análisis de Ghidra:
        1. Cálculo de offsets y tamaños
        2. Construcción de header
        3. Tabla de elementos con transformaciones específicas
        4. Tabla de tamaños de imagen
        5. Datos de imagen consecutivos
        """
        try:
            logger.info(f"Building binary with {len(self.elements)} elements, {self.total_images} images")
            
            # 1. Calcular tamaños y offsets
            header_size = 4
            element_table_size = len(self.elements) * 20  # 20 bytes por elemento según Ghidra
            image_sizes_table_size = self.total_images * 4
            metadata_size = header_size + element_table_size + image_sizes_table_size
            
            # Alinear metadatos a 4 bytes
            first_image_offset = metadata_size
            while first_image_offset % 4 != 0:
                first_image_offset += 1
            
            # Calcular offsets de cada imagen
            image_offsets = []
            current_offset = first_image_offset
            
            for element in self.elements:
                for image_data in element.image_data:
                    image_offsets.append(current_offset)
                    current_offset += len(image_data)
                    # Alinear a 4 bytes
                    while current_offset % 4 != 0:
                        current_offset += 1
            
            # 2. Construir binario
            binary_data = bytearray()
            
            # Header (4 bytes): total_images (2) + num_elements (2)
            binary_data.extend(struct.pack('<HH', self.total_images, len(self.elements)))            # 3. Tabla de elementos (20 bytes cada uno)
            image_index = 0
            for element in self.elements:
                # Offset a la primera imagen de este elemento
                first_image_offset_for_element = image_offsets[image_index]
                
                # Estructura de 20 bytes según análisis hkdecomp:
                # Formato: <I2B4H6B = picture_address(4) + picidx(1) + valami2(1) + sx(2) + sy(2) + posX(2) + posY(2) + parts(1) + blocktype(1) + align(1) + compr(1) + centX(1) + centY(1)
                element_data = struct.pack('<I2B4H6B',
                    first_image_offset_for_element,  # picture_address (4 bytes)
                    element.picidx,                  # picidx (1 byte) - índice específico de configuración
                    0,                               # valami2 (1 byte) - siempre 0 según análisis
                    element.width,                   # sx/width (2 bytes)
                    element.height,                  # sy/height (2 bytes)
                    element.x,                       # posX (2 bytes)
                    element.y,                       # posY (2 bytes)
                    element.image_count,             # parts (1 byte) - número de partes/imágenes
                    element.element_type,            # blocktype (1 byte)
                    element.align,                   # align (1 byte) - valor de configuración
                    element.compr,                   # compr (1 byte) - compresión de configuración
                    element.centX,                   # centX (1 byte) - centro X de configuración
                    element.centY                    # centY (1 byte) - centro Y de configuración
                )
                
                binary_data.extend(element_data)
                image_index += len(element.image_data)
            
            # 4. Tabla de tamaños de imagen (4 bytes cada una)
            for element in self.elements:
                for image_size in element.image_sizes:
                    binary_data.extend(struct.pack('<I', image_size))
            
            # 5. Padding hasta primer offset de imagen
            while len(binary_data) < first_image_offset:
                binary_data.append(0x00)
            
            # 6. Datos de imágenes consecutivos con padding
            for element in self.elements:
                for image_data in element.image_data:
                    binary_data.extend(image_data)
                    # Padding a 4 bytes
                    while len(binary_data) % 4 != 0:
                        binary_data.append(0x00)
            
            # 7. Guardar archivo
            with open(output_path, 'wb') as f:
                f.write(binary_data)
            
            logger.info(f"✓ Binary created: {output_path}")
            logger.info(f"  Size: {len(binary_data):,} bytes")
            logger.info(f"  Elements: {len(self.elements)}")
            logger.info(f"  Images: {self.total_images}")
            
            return True
            
        except Exception as e:
            logger.error(f"Error building binary: {e}")
            return False

class SmartWatchFaceCompiler:
    """Compilador principal de faces de smartwatch"""
    
    def __init__(self):
        self.builder = WatchfaceBinaryBuilder()
        self.config = {}
        self.base_path = ""
    
    def load_config(self, config_path: str) -> bool:
        """Carga configuración JSON"""
        try:
            with open(config_path, 'r', encoding='utf-8') as f:
                self.config = json.load(f)
            
            self.base_path = os.path.dirname(os.path.abspath(config_path))
            logger.info(f"Loaded config: {config_path}")
            logger.info(f"Base path: {self.base_path}")
            
            return True
            
        except Exception as e:
            logger.error(f"Error loading config: {e}")
            return False
    
    def validate_config(self) -> bool:
        """Valida la configuración"""
        if 'blocks' not in self.config:
            logger.error("Config missing 'blocks' section")
            return False
        
        if not isinstance(self.config['blocks'], list):
            logger.error("'blocks' must be a list")
            return False
        
        if len(self.config['blocks']) == 0:
            logger.error("'blocks' list is empty")
            return False
        
        # Validar cada bloque
        for i, block in enumerate(self.config['blocks']):
            required_fields = ['blocktype', 'sx', 'sy', 'posX', 'posY', 'parts']
            for field in required_fields:
                if field not in block:
                    logger.error(f"Block {i} missing required field: {field}")
                    return False
            
            # Validar archivos de imagen
            if block['parts'] > 1:
                if 'part_filenames' not in block:
                    logger.error(f"Multi-part block {i} missing 'part_filenames'")
                    return False
                if len(block['part_filenames']) != block['parts']:
                    logger.error(f"Block {i} parts count mismatch")
                    return False
            else:
                if 'fname' not in block:
                    logger.error(f"Single-part block {i} missing 'fname'")
                    return False
        
        logger.info(f"Config validation passed: {len(self.config['blocks'])} blocks")
        return True
    
    def compile(self, config_path: str, output_path: str) -> bool:
        """Función principal de compilación"""
        start_time = time.time()
        
        logger.info("=" * 60)
        logger.info("SMARTWATCH FACE COMPILER")
        logger.info("Based on libsmawatchface.so reverse engineering")
        logger.info("=" * 60)
        
        # 1. Cargar configuración
        if not self.load_config(config_path):
            return False
        
        # 2. Validar configuración
        if not self.validate_config():
            return False
        
        # 3. Procesar elementos
        success_count = 0
        for i, block_config in enumerate(self.config['blocks']):
            logger.info(f"Processing block {i+1}/{len(self.config['blocks'])}: type {block_config['blocktype']}")
            
            if self.builder.add_element_from_config(block_config, self.base_path):
                success_count += 1
                logger.info(f"  ✓ Success")
            else:
                logger.error(f"  ✗ Failed")
        
        if success_count != len(self.config['blocks']):
            logger.error(f"Only {success_count}/{len(self.config['blocks'])} blocks processed successfully")
            return False
        
        # 4. Construir binario
        if not self.builder.build_binary(output_path):
            return False
        
        # 5. Completado
        elapsed = time.time() - start_time
        logger.info("=" * 60)
        logger.info(f"✅ COMPILATION COMPLETED in {elapsed:.2f}s")
        logger.info(f"Output: {output_path}")
        logger.info("=" * 60)
        
        return True

def main():
    """Función principal"""
    parser = argparse.ArgumentParser(
        description='SmartWatch Face Compiler - Basado en análisis de libsmawatchface.so',
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog="""
Ejemplos de uso:
  python smartwatch_face_compiler.py config.json output.bin
  python smartwatch_face_compiler.py --verbose config.json output.bin

Formato de configuración JSON:
{
  "resolution": {"width": 280, "height": 280},
  "blocks": [
    {
      "fname": "background.png",
      "blocktype": 2,
      "sx": 280, "sy": 280,
      "posX": 0, "posY": 0,
      "parts": 1,
      "align": 0,
      "compr": 4,
      "centX": 0, "centY": 0,
      "picidx": 0
    }
  ]
}
        """
    )
    
    parser.add_argument('config', help='Archivo de configuración JSON')
    parser.add_argument('output', help='Archivo binario de salida (.bin)')
    parser.add_argument('--verbose', '-v', action='store_true', 
                       help='Habilitar logging detallado')
    parser.add_argument('--debug', action='store_true',
                       help='Habilitar modo debug completo')
    
    args = parser.parse_args()
    
    # Configurar nivel de logging
    if args.debug:
        logging.getLogger().setLevel(logging.DEBUG)
    elif args.verbose:
        logging.getLogger().setLevel(logging.INFO)
    
    # Validar archivos
    if not os.path.exists(args.config):
        logger.error(f"Config file not found: {args.config}")
        sys.exit(1)
    
    # Compilar
    compiler = SmartWatchFaceCompiler()
    success = compiler.compile(args.config, args.output)
    
    sys.exit(0 if success else 1)

if __name__ == "__main__":
    main()
