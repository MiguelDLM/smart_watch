# Guía para usar imágenes JPEG como fondos de diales

## Problema Resuelto
Las imágenes de fondo (backgrounds) en formato JPG/JPEG ahora funcionan correctamente. Anteriormente, el compilador convertía todas las imágenes a RGBA (con canal alfa), lo que corrompia los diales cuando se usaban JPEGs como fondo.

## Solución Implementada
El compilador `comp_decomp.py` ahora:
1. Lee el campo `colsp` del metadata ANTES de procesar la imagen
2. Convierte la imagen al formato correcto basándose en `colsp`:
   - `"colsp": "RGB"` → Imagen RGB sin transparencia (ideal para backgrounds JPG/JPEG/PNG)
   - `"colsp": "RGBA"` → Imagen RGBA con transparencia (necesario para elementos como dígitos, manecillas, etc.)
3. Comprime correctamente según el formato especificado

## Cómo configurar un dial con background JPEG

### Estructura del dial_desc.json

```json
{
    "dial_name": "mi_dial",
    "blocks": [
        {
            "type": "BLK_PREVI",
            "frms": 1,
            "fname": "preview.png",
            "reuse": false,
            "colsp": "RGBA",
            "width": 280,
            "height": 280,
            "posx": 0,
            "posy": 0,
            "alnx": 0,
            "ctx": 0,
            "cty": 0
        },
        {
            "type": "BLK_BGIMG",
            "frms": 1,
            "fname": "fondo.jpg",
            "reuse": false,
            "colsp": "RGB",
            "width": 466,
            "height": 466,
            "posx": 0,
            "posy": 0,
            "alnx": 0,
            "ctx": 0,
            "cty": 0
        },
        {
            "type": "BLK_HOUR",
            "frms": 10,
            "fname": "digitos.png",
            "reuse": false,
            "colsp": "RGBA",
            "width": 66,
            "height": 96,
            "posx": 88,
            "posy": 74,
            "alnx": 0,
            "ctx": 0,
            "cty": 0
        }
    ]
}
```

### Reglas importantes:

#### Para backgrounds (BLK_BGIMG):
- ✅ **USAR**: `"colsp": "RGB"`
- ✅ **Formatos soportados**: JPG, JPEG, PNG
- ✅ **Ventajas JPG**: Archivos más pequeños, mejor para fotos
- ⚠️ **NO usar transparencia** en la imagen de fondo
- 📱 **Nota**: La app Android automáticamente configura backgrounds como RGB

#### Para preview (BLK_PREVI):
- ⚙️ **Puede ser**: `"colsp": "RGB"` o `"RGBA"` (depende del diseño)
- ✅ **Típicamente RGB** en la app Android (sin transparencia)
- ℹ️ **Usar RGBA** solo si el preview necesita esquinas redondeadas u otros efectos con transparencia

#### Para elementos con transparencia (dígitos, manecillas, iconos):
- ✅ **USAR**: `"colsp": "RGBA"`
- ✅ **Formato requerido**: PNG (con canal alfa)
- ✅ **Necesario para**: BLK_HOUR, BLK_MIN, BLK_SEC, BLK_PREVI, etc.

## Tipos de bloques y formato recomendado

| Tipo de bloque | colsp recomendado | Formato imagen |
|----------------|-------------------|----------------|
| BLK_BGIMG (fondo) | RGB | JPG, JPEG, PNG |
| BLK_PREVI (preview) | RGBA | PNG |
| BLK_HOUR (horas) | RGBA | PNG |
| BLK_MIN (minutos) | RGBA | PNG |
| BLK_SEC (segundos) | RGBA | PNG |
| BLK_ARMH (manecilla hora) | RGBA | PNG |
| BLK_ARMM (manecilla minuto) | RGBA | PNG |
| BLK_ARMS (manecilla segundo) | RGBA | PNG |
| BLK_STEPS (pasos) | RGBA | PNG |
| BLK_BATTERY (batería) | RGBA | PNG |

## Compilación

```bash
# Compilar dial con background JPEG
python3 comp_decomp.py -c mi_dial_carpeta/ mi_dial.bin

# El compilador mostrará conversiones de formato:
#     Converting fondo.jpg from RGB to RGB
#     Converting digitos.png from RGBA to RGBA
```

## Verificación

Después de compilar, el archivo .bin resultante debería:
- Ser más pequeño si usas JPG en vez de PNG para el fondo
- No mostrar corrupción o artifacts en el smartwatch
- Mantener la transparencia correctamente en los elementos RGBA

## Notas técnicas

- Las imágenes RGB se comprimen como RGB565 (2 bytes por píxel)
- Las imágenes RGBA se comprimen como RGBA5658 (3 bytes por píxel: 1 byte alpha + 2 bytes RGB565)
- La compresión RLE es aplicada automáticamente (compression type 4 o 6)
- Los fondos JPG deben tener dimensiones que coincidan con el smartwatch (típicamente 466x466 para pantalla completa)

## Solución de problemas

### El dial se ve corrupto en el reloj:
- ✅ Verifica que BLK_BGIMG use `"colsp": "RGB"`
- ✅ Verifica que las dimensiones coincidan con el JSON
- ✅ Asegúrate de usar la última versión de comp_decomp.py

### Los elementos transparentes no se ven bien:
- ✅ Verifica que usen `"colsp": "RGBA"`
- ✅ Asegúrate de que sean PNG con canal alfa
- ✅ Revisa que el fondo sea opaco (RGB) no transparente

### El archivo .bin es muy grande:
- ✅ Usa JPG para el fondo en vez de PNG (reduce hasta 70% el tamaño)
- ✅ Optimiza las imágenes antes de compilar
- ✅ Asegúrate de usar las dimensiones correctas
