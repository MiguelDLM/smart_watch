# Dial-Sender v3.1 - FIX: Conexión y Escaneo

**Estado:** ✅ COMPILADO CORRECTAMENTE
**APK:** `app/build/outputs/apk/debug/app-debug.apk`

---

## 🔧 QUÉ SE ARREGLÓ

1.  **"App no encuentra mi dispositivo":** 
    - Se corrigió un error crítico en el escáner Bluetooth.
    - Ahora busca agresivamente por UUID y Nombres (Kronos, Thunder, Watch, Jieli).
    - Detecta dispositivos ya conectados al sistema.

2.  **"Ningún protocolo funciona":**
    - Se implementó un **Motor Híbrido** que prueba TODOS los protocolos automáticamente:
      1. Intenta v2 (FE DC BA) + Handshake
      2. Intenta v1 (AB BC CD) + Handshake
      3. Intenta v1 Legacy Wake-up
    - Si falla todo, permite transferir en modo "a ciegas".

---

## 🚀 PASOS PARA INSTALAR

1.  **Desinstala la versión anterior** (para limpiar caché Bluetooth):
    ```bash
    adb uninstall com.example.dialsender
    ```

2.  **Instala la nueva v3.1:**
    ```bash
    adb install app/build/outputs/apk/debug/app-debug.apk
    ```

3.  **Abre y da permisos:**
    - "Allow Nearby Devices" (Permitir dispositivos cercanos) es CRÍTICO.

4.  **Escanea:**
    - Tap [Scan]. Debería encontrar tu "Kronos Thunder" casi de inmediato.

---

## 📊 QUÉ VERÁS EN LOS LOGS (ÉXITO)

```
Found: Kronos Thunder [...]
Connecting...
Connected. Discovering services...
Jieli Services Found!
Remote notifications enabled

Trying Protocol v2 Handshake (FE DC BA)...
Tx: FE DC BA ...
✓ v2 Protocol Confirmed!  <-- ¡ESTO ES LO QUE BUSCAMOS!
```

Si ves "v2 Protocol Confirmed" o "v1 Protocol Confirmed", ¡ya ganamos! Puedes transferir.

---

¡Prueba ahora! Esta versión recupera la capacidad de encontrar tu reloj.
