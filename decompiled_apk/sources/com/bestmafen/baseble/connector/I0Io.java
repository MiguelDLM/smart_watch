package com.bestmafen.baseble.connector;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public interface I0Io {

    /* loaded from: classes8.dex */
    public static final class oIX0oI {
        public static void I0Io(@OOXIXo I0Io i0Io, @OOXIXo String characteristicUuid, @OOXIXo byte[] value) {
            IIX0o.x0xO0oo(characteristicUuid, "characteristicUuid");
            IIX0o.x0xO0oo(value, "value");
        }

        public static void II0xO0(@OOXIXo I0Io i0Io, @OOXIXo String characteristicUuid, @OOXIXo byte[] value, @OOXIXo String text) {
            IIX0o.x0xO0oo(characteristicUuid, "characteristicUuid");
            IIX0o.x0xO0oo(value, "value");
            IIX0o.x0xO0oo(text, "text");
        }

        public static void X0o0xo(@OOXIXo I0Io i0Io) {
        }

        public static void oIX0oI(@OOXIXo I0Io i0Io, @OOXIXo byte[] value) {
            IIX0o.x0xO0oo(value, "value");
        }

        public static void oxoX(@OOXIXo I0Io i0Io, boolean z) {
        }
    }

    void onCharacteristicChanged(@OOXIXo byte[] bArr);

    void onCharacteristicRead(@OOXIXo String str, @OOXIXo byte[] bArr, @OOXIXo String str2);

    void onCharacteristicWrite(@OOXIXo String str, @OOXIXo byte[] bArr);

    void onConnectionStateChange(boolean z);

    void onMtuChanged();
}
