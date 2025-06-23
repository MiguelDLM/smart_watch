package com.sma.smartv3.initializer;

import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.pop.xOOOX;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleConnector;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nAGPSInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AGPSInitializer.kt\ncom/sma/smartv3/initializer/AGPSInitializer$aGpsFileSocket$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,380:1\n1#2:381\n*E\n"})
/* loaded from: classes12.dex */
public final class AGPSInitializer$aGpsFileSocket$1 extends Lambda implements Oox.oIX0oI<oXIO0o0XI> {
    final /* synthetic */ String $locationInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AGPSInitializer$aGpsFileSocket$1(String str) {
        super(0);
        this.$locationInfo = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2() {
        xOOOX xooox = AGPSInitializer.f20677xoXoI;
        if (xooox != null) {
            xooox.dismiss();
            ToastUtils.showLong(R.string.request_error);
        }
    }

    @Override // Oox.oIX0oI
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
        invoke2();
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BleKey OOXIXo2;
        try {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AGPS -> aGpsFileSocket socket connect");
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("121.41.40.95", 2621), 5000);
            OutputStream outputStream = socket.getOutputStream();
            byte[] bytes = this.$locationInfo.getBytes(kotlin.text.oxoX.f29581II0xO0);
            IIX0o.oO(bytes, "getBytes(...)");
            outputStream.write(bytes);
            outputStream.flush();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(IXxxXO.XO(X00IoxXI.oIX0oI.f3233oIX0oI)));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
            while (true) {
                byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(bufferedInputStream);
                if (!(x0xO0oo2.length == 0)) {
                    bufferedOutputStream.write(x0xO0oo2);
                } else {
                    bufferedOutputStream.flush();
                    socket.shutdownInput();
                    socket.shutdownOutput();
                    bufferedOutputStream.close();
                    bufferedInputStream.close();
                    outputStream.close();
                    socket.close();
                    BleConnector bleConnector = BleConnector.INSTANCE;
                    OOXIXo2 = AGPSInitializer.f20674XO.OOXIXo();
                    BleConnector.sendStream$default(bleConnector, OOXIXo2, IXxxXO.XO(X00IoxXI.oIX0oI.f3233oIX0oI), 0, 4, (Object) null);
                    return;
                }
            }
        } catch (Exception e) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AGPS -> aGpsFileSocket error: " + e.getMessage());
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.initializer.II0xO0
                @Override // java.lang.Runnable
                public final void run() {
                    AGPSInitializer$aGpsFileSocket$1.invoke$lambda$2();
                }
            });
            AGPSInitializer.f20674XO.Oxx0xo(false);
        }
    }
}
