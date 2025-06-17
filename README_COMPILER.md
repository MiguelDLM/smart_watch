# SmartWatch Face Compiler

Un compilador completo para crear archivos .bin de faces/diales de smartwatch basado en ingeniería inversa de `libsmawatchface.so` y análisis de APK CO-FIT.

## 🎯 Características

- **Compilación nativa**: Basado en análisis de código descompilado de Ghidra y Hex-Rays
- **Compatibilidad amplia**: Funciona con múltiples modelos de smartwatch HK89/similar
- **Formato completo**: Soporte para todos los tipos de elementos (background, dígitos, agujas, etc.)
- **Compresión RLE**: Algoritmo de compresión optimizado basado en el código original
- **Validación completa**: Verificación de imágenes y configuración antes de compilar
- **Utilidades incluidas**: Herramientas de análisis, conversión y debugging

## 📋 Requisitos

```bash
pip install -r requirements.txt
```

Dependencias principales:
- Python 3.7+
- Pillow (PIL)
- numpy
- struct (incluido en Python)

## 🚀 Uso Rápido

### 1. Compilar una face

```bash
python smartwatch_face_compiler.py config.json output.bin
```

### 2. Validar imágenes antes de compilar

```bash
python watchface_utils.py validate config.json
```

### 3. Analizar un archivo binario existente

```bash
python watchface_utils.py analyze existing_face.bin
```

### 4. Ver ejemplo completo

```bash
python example_usage.py --run
```

## 📁 Estructura de Archivos

```
smart_watch/
├── smartwatch_face_compiler.py    # Compilador principal
├── watchface_utils.py            # Utilidades y herramientas
├── example_usage.py              # Ejemplos de uso
├── requirements.txt              # Dependencias
├── _kronos/                     # Ejemplo de face
│   ├── config.json              # Configuración
│   ├── background.png           # Imágenes
│   ├── digital_hour_0.png       
│   └── ...                      
└── README.md                    # Este archivo
```

## ⚙️ Configuración JSON

Estructura básica de configuración:

```json
{
  "resolution": {
    "width": 280,
    "height": 280
  },
  "blocks": [
    {
      "fname": "background.png",
      "blocktype": 2,
      "sx": 280,
      "sy": 280,
      "posX": 0,
      "posY": 0,
      "parts": 1,
      "align": 0,
      "compr": 4,
      "centX": 0,
      "centY": 0,
      "picidx": 1
    }
  ]
}
```

### Campos de Configuración

| Campo | Tipo | Descripción |
|-------|------|-------------|
| `fname` | string | Nombre del archivo de imagen |
| `blocktype` | int | Tipo de elemento (ver tabla de tipos) |
| `sx`, `sy` | int | Dimensiones de la imagen en píxeles |
| `posX`, `posY` | int | Posición en la pantalla |
| `parts` | int | Número de partes (1 para imagen única, >1 para dígitos) |
| `part_filenames` | array | Lista de archivos para elementos multi-parte |
| `align` | int | Alineación (0=centro) |
| `picidx` | int | Índice de imagen (incremental) |

## 🏷️ Tipos de Elementos

### Tipos Básicos (sin transparencia)

| ID | Tipo | Descripción |
|----|------|-------------|
| 1 | PREVIEW | Vista previa de la face |
| 2 | BACKGROUND | Imagen de fondo |
| 3 | ARM_HOUR | Aguja de horas |
| 4 | ARM_MINUTE | Aguja de minutos |
| 5 | ARM_SECOND | Aguja de segundos |
| 9 | DIGITAL_HOUR | Hora digital |
| 10 | DIGITAL_MINUTE | Minuto digital |
| 12 | DIGITAL_AMPM | AM/PM digital |
| 14 | DIGITAL_STEPS | Contador de pasos |
| 15 | DIGITAL_HEART | Frecuencia cardíaca |
| 16 | DIGITAL_CALORIE | Calorías |
| 18 | DIGITAL_BATTERY_NUMBER | Batería numérica |
| 24 | DIGITAL_BATTERY_STRIP | Barra de batería |

### Tipos con Transparencia (tipo básico | 0x80)

Para elementos que requieren canal alpha, usa el tipo básico + 0x80:
- `0x82` = BACKGROUND con alpha
- `0x89` = DIGITAL_HOUR con alpha
- `0x8A` = DIGITAL_MINUTE con alpha
- etc.

## 🔧 Utilidades Avanzadas

### Análisis de Binarios

```bash
# Analizar estructura de un archivo .bin
python watchface_utils.py analyze face.bin

# Salida ejemplo:
📊 BINARY ANALYSIS RESULTS
==================================================
File size: 215,040 bytes
Total images: 47
Number of elements: 18

🔍 ELEMENTS DETAILS:
--------------------------------------------------
Element 1:
  Type: 0x01 (no alpha)
  Size: 280x280
  Position: (0, 0)
  Image offset: 0x0000B868
  Image count: 1
```

### Validación de Imágenes

```bash
# Validar todas las imágenes de una configuración
python watchface_utils.py validate config.json

# Salida ejemplo:
✅ IMAGE VALIDATION PASSED
==================================================
Images checked: 47
Images found: 47

⚠️  WARNINGS (2):
  • Block 3: digital_hour_0.png size mismatch. Expected 31x41, got 32x41
  • Block 5: background.png has unusual color mode: P
```

### Conversión de Configuraciones

```bash
# Convertir configuración antigua al nuevo formato
python watchface_utils.py convert old_config.json new_config.json
```

### Generación de Configuración Base

```bash
# Generar configuración de ejemplo
python watchface_utils.py generate example_config.json --width 280 --height 280
```

## 🧠 Fundamentos Técnicos

### Formato Binario

El compilador genera archivos .bin con la siguiente estructura (basada en análisis de `libsmawatchface.so`):

1. **Header (4 bytes)**
   - Total de imágenes (2 bytes)
   - Número de elementos (2 bytes)

2. **Tabla de Elementos (20 bytes cada uno)**
   - Offset a imagen (4 bytes)
   - Tipo transformado (2 bytes)
   - Dimensiones (4 bytes)
   - Posición y flags (6 bytes)
   - Contador de imágenes (4 bytes)

3. **Tabla de Tamaños (4 bytes por imagen)**
   - Tamaño comprimido de cada imagen

4. **Datos de Imágenes**
   - Datos comprimidos usando RLE optimizado

### Compresión RLE

El algoritmo de compresión RLE usado es compatible con el formato original:

- `0x00`: Pixel individual
- `0x80 | count`: Run de píxeles idénticos
- `count` (1-127): Run literal de píxeles diferentes

### Transformaciones de Tipo

Los tipos de elemento se transforman según las reglas detectadas en el análisis:
- Si `hasAlpha == true`, entonces `type |= 0x80`
- Los flags se combinan en un byte específico
- Los offsets se empaquetan según el formato original

## 📱 Dispositivos Compatibles

El compilador es compatible con smartwatches que usan el formato HK89/similar. Ver `devices_supported.csv` para una lista completa.

Algunos ejemplos:
- HK89 Series
- CO-FIT Series  
- Y otros modelos compatibles con el formato

## 🛠️ Desarrollo y Debugging

### Logging Detallado

```bash
# Compilar con logs detallados
python smartwatch_face_compiler.py --verbose config.json output.bin

# Compilar con debug completo
python smartwatch_face_compiler.py --debug config.json output.bin
```

### Estructura del Código

- `SmartWatchFaceCompiler`: Clase principal del compilador
- `WatchfaceElement`: Estructura de datos de elementos
- `ImageCompressor`: Compresor de imágenes RLE
- `WatchfaceBinaryBuilder`: Constructor de archivos binarios
- `BinaryAnalyzer`: Analizador de archivos binarios
- `ImageValidator`: Validador de imágenes y configuración

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Áreas de interés:

1. **Soporte para más dispositivos**: Análisis de nuevos formatos
2. **Optimizaciones de compresión**: Mejoras en el algoritmo RLE
3. **Herramientas visuales**: Editor gráfico para faces
4. **Documentación**: Más ejemplos y tutoriales

## ⚖️ Licencia y Disclaimer

Este proyecto es para fines educativos y de investigación únicamente. El uso de ingeniería inversa puede violar los términos de servicio de tu dispositivo. Úsalo bajo tu propia responsabilidad.

## 📚 Referencias

- Análisis de `libsmawatchface.so` con Ghidra
- Descompilación de APK CO-FIT_base.apk
- Ingeniería inversa de archivos .bin existentes
- Documentación de formatos de smartwatch

---

**Versión**: 1.0.0  
**Fecha**: Junio 2025  
**Autor**: Basado en análisis de ingeniería inversa
