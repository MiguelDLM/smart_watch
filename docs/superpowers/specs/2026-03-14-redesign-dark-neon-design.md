# Rediseño UI — Dial Studio Dark Neón

**Fecha:** 2026-03-14
**Alcance:** Rediseño completo de layouts y sistema de color
**Estado:** Aprobado por usuario

---

## Objetivo

Actualizar el diseño visual de Dial Studio a una estética dark neón profesional inspirada en apps de salud de referencia (Huawei Health, Garmin Connect, Whoop). El resultado debe ser coherente en todas las pantallas, con una jerarquía visual clara y métricas de salud prominentes.

---

## Dirección de diseño

- **Estilo:** Dark Neón (Garmin / Whoop)
- **Referencia:** Huawei Health (cards de métricas con gradientes de color por categoría, números grandes)
- **Modo:** Dark permanente (sin modo claro)
- **Navegación:** Bottom Navigation con 4 tabs

---

## Sistema de color

### Fondos (capas de profundidad)

| Token | Hex | Uso |
|-------|-----|-----|
| `bg_primary` | `#060810` | Fondo principal de pantallas |
| `bg_surface` | `#0D1117` | Surface, toolbar, bottom nav |
| `bg_card` | `#111827` | Cards generales |
| `bg_elevated` | `#1C2333` | Inputs, elementos elevados, chips |

### Acentos

| Token | Hex | Uso |
|-------|-----|-----|
| `accent_primary` | `#22D3EE` | Botones primarios, nav activo, links |
| `accent_primary_dark` | `#06B6D4` | Estado pressed del acento |
| `accent_health` | `#34D399` | Pasos, estado conectado, progreso |
| `accent_heart` | `#F87171` | Frecuencia cardíaca |
| `accent_calories` | `#FBBF24` | Calorías, advertencias |
| `accent_danger` | `#F85149` | Errores, desconexión |

### Cards de métricas (gradientes)

| Token | Gradiente | Métrica |
|-------|-----------|---------|
| `card_steps_start/end` | `#064E3B` → `#065F46` | Pasos |
| `card_heart_start/end` | `#7F1D1D` → `#991B1B` | Frecuencia cardíaca |
| `card_calories_start/end` | `#78350F` → `#92400E` | Calorías |
| `card_sleep_start/end` | `#1E3A5F` → `#1E40AF` | Sueño |

### Texto

| Token | Hex | Uso |
|-------|-----|-----|
| `text_primary` | `#F0F6FC` | Texto principal |
| `text_secondary` | `#8B949E` | Subtítulos, labels secundarios |
| `text_muted` | `#484F58` | Placeholders, texto deshabilitado |

---

## Navegación

Bottom Navigation con 4 tabs permanentes:

1. **Inicio** — Dashboard de salud
2. **Carátulas** — Biblioteca y creación de dials
3. **Dispositivo** — Estado BLE, log
4. **Salud** — Métricas detalladas

Tab activo: color `accent_primary` (`#22D3EE`), fondo `rgba(34,211,238,0.15)`, borde `rgba(34,211,238,0.4)`.
Tab inactivo: color `text_muted` (`#484F58`), fondo `bg_elevated`.

---

## Pantallas

### Tab 1 — Inicio

**Estructura (vertical):**
1. Header: saludo dinámico + fecha + chip de estado de conexión
2. Grid 2×2 de metric cards (Pasos, Frecuencia Cardíaca, Calorías, Sueño)
3. Acceso rápido "Enviar carátula" (card horizontal con última carátula usada)

**Metric cards:** cada una con gradiente propio, nombre de métrica en uppercase pequeño, valor numérico en 22sp bold, barra de progreso o dato secundario.

**Chip de estado:**
- Conectado: fondo semitransparente, punto verde `#34D399`, texto verde
- Desconectado: punto rojo `#F85149`, texto rojo

### Tab 2 — Carátulas

**Estructura:**
1. Header: título + subtítulo
2. Segmented tabs: "Mis carátulas" / "Presets"
3. Grid 3 columnas de thumbnails de carátulas (última celda = botón "+")
4. Botón FAB inferior: "Crear nueva carátula" (fondo `accent_primary`, texto oscuro)

**Creación y edición** se abren como Activities separadas (sin cambiar la navegación actual del editor).

### Tab 3 — Dispositivo

**Estructura:**
1. Header: título
2. Card de estado del dispositivo: nombre, estado conexión, batería, RSSI
3. Botón "Scan & Connect" / "Desconectar"
4. Log BLE colapsado con botón "Ver todo" que abre `ActivityLog`

**Card de dispositivo:** círculo con icono de reloj, nombre del dispositivo, indicador de estado, dos chips de stats (batería y RSSI).

### Tab 4 — Salud

**Estructura:**
1. Header: título + botón "Sync ↻"
2. Selector de rango: Día / Semana / Mes (chips horizontales)
3. Lista vertical de metric cards detalladas (mismos gradientes que Home pero con más info: mínimo, máximo, promedio)

**Botón Sync:** dispara la lógica de sincronización existente (sin cambios). No se añade nuevo feedback visual — el comportamiento actual (toast/log) se mantiene tal cual.

---

## Componentes y estilos globales

### Cards generales
- Background: `bg_card` (`#111827`)
- Border: `1dp` sólido `#1F2937`
- Corner radius: `12dp`
- Padding: `16dp`

### Botón primario
- Background: `accent_primary` (`#22D3EE`)
- Texto: `#060810` (negro) — no blanco, para contraste con el cyan
- Corner radius: `12dp`
- Text size: `15sp`, `textAllCaps: false`

### Botón secundario (outlined)
- Border: `accent_primary`
- Texto: `accent_primary`
- Corner radius: `12dp`

### Tipografía
- Font family: sistema por defecto (Roboto) — sin nueva dependencia de fuente
- Títulos de pantalla: `20sp`, bold
- Valores de métricas: `22sp`, `fontWeight: 800`
- Labels de categoría: `9–10sp`, uppercase, `letterSpacing: 0.8`
- Texto secundario: `12sp`, `text_secondary`

### Indicadores de estado BLE
- Conectado: círculo `#34D399`, `indicator_connected.xml`
- Desconectado: círculo `#F85149`, `indicator_disconnected.xml`
- Escaneando: círculo `#FBBF24`, `indicator_scanning.xml`

---

## Archivos a modificar

| Archivo | Cambios |
|---------|---------|
| `values/colors.xml` | Paleta completa nueva |
| `values-night/colors.xml` | Eliminar (dark es el único modo) |
| `values/styles.xml` | Actualizar estilos de botones, toolbar |
| `layout/activity_main.xml` | Bottom nav con 4 items, estilo nuevo |
| `menu/bottom_nav_menu.xml` | Agregar item "Carátulas" |
| `layout/activity_home.xml` | Reemplazar por dashboard con metric cards |
| `layout/fragment_device.xml` | Rediseñar con card de estado + log colapsado |
| `layout/fragment_status.xml` | Este fragment corresponde al Tab 3 — Dispositivo. Consolidar con `fragment_device.xml`: usar `fragment_device.xml` como layout canónico del tab y eliminar `fragment_status.xml` si ya no tiene usos independientes |
| `layout/activity_dial_library.xml` | Adaptar al nuevo estilo |
| `layout/activity_settings.xml` | Adaptar al nuevo estilo |
| `drawable/bg_card.xml` | Actualizar colores |
| `drawable/bg_status.xml` | Actualizar colores |
| `drawable/indicator_*.xml` | Actualizar colores de indicadores |
| `drawable/bg_gradient.xml` | Actualizar a nuevo gradiente |
| `drawable/bg_card_steps.xml` | Nuevo — gradiente `#064E3B` → `#065F46` |
| `drawable/bg_card_heart.xml` | Nuevo — gradiente `#7F1D1D` → `#991B1B` |
| `drawable/bg_card_calories.xml` | Nuevo — gradiente `#78350F` → `#92400E` |
| `drawable/bg_card_sleep.xml` | Nuevo — gradiente `#1E3A5F` → `#1E40AF` |

---

## Fuera de alcance

- Lógica de negocio (BLE, compilación de dials, health sync) — sin cambios
- Actividades de edición de carátulas (`DialEditorActivity`, `FontCreatorActivity`) — solo ajuste de colores, sin cambio de layouts
- Flujo de navegación interno de las activities secundarias
