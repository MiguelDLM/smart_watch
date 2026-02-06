# Dial Sender for Android

Android application to send custom watchfaces (dials) to supported smartwatches (e.g., Kronos Thunder) using the BLE protocol.

## Features

*   **BLE Connectivity**: Connects to supported smartwatches.
*   **Custom Protocol**: Implements the reverse-engineered transfer protocol used by Co-Fit/STF apps.
*   **Optimized Transfer**: Uses 1012-byte payload chunks with correct header alignment for reliable transfer.
*   **Auth & Setup**: Handles the specific handshake, binding, and login sequence required by the device.

## Usage

1.  Build the APK using Android Studio or Gradle (`./gradlew assembleDebug`).
2.  Install on an Android device.
3.  Ensure Bluetooth is enabled and the watch is paired (or discoverable).
4.  Open the app, scan/connect to the watch.
5.  Select a valid `.bin` dial file.
6.  The app will handle authentication and transfer the file.

## Technical Details

*   **Protocol**: STF/Co-Fit proprietary BLE protocol.
*   **Chunk Size**: 1012 bytes payload + 9 bytes header = 1021 bytes (approx).
*   **Verification**: Uses file size as ID in the stream header.

## Disclaimer

This software is for educational and research purposes. Use at your own risk.
