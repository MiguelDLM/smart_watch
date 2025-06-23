package com.sma.smartv3.util;

import com.blankj.utilcode.util.DeviceUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import kotlin.oXIO0o0XI;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes12.dex */
public final class EnvDetector {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final EnvDetector f24206oIX0oI = new EnvDetector();

    public final boolean I0Io() {
        boolean oxoX2 = oxoX();
        boolean X0o0xo2 = X0o0xo();
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI("isFridaPortOpen:" + oxoX2);
        oix0oi.oIX0oI("isFridaProcessRunning():" + X0o0xo2);
        if (!X0o0xo2 && !oxoX2) {
            return false;
        }
        return true;
    }

    public final boolean II0xO0() {
        if (!DeviceUtils.isDeviceRooted() && !I0Io()) {
            return false;
        }
        return true;
    }

    public final boolean X0o0xo() {
        String[] strArr = {"ps -A", "ps"};
        for (int i = 0; i < 2; i++) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(strArr[i]).getInputStream()));
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    if (StringsKt__StringsKt.o00xOoIO(readLine, "frida", false, 2, null)) {
                        return true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final void oIX0oI(@OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        xoIXOxX.II0xO0.I0Io(false, false, null, null, 0, new EnvDetector$checkDeviceSecurity$1(action), 31, null);
    }

    public final boolean oxoX() {
        int[] iArr = {27042, 27043};
        for (int i = 0; i < 2; i++) {
            int i2 = iArr[i];
            try {
                Socket socket = new Socket();
                try {
                    continue;
                    socket.connect(new InetSocketAddress("127.0.0.1", i2), 200);
                    kotlin.io.II0xO0.oIX0oI(socket, null);
                    return true;
                } finally {
                    try {
                        continue;
                        break;
                    } catch (Throwable th) {
                    }
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }
}
