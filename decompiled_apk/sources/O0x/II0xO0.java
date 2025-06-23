package O0x;

import O0OOX0IIx.XO;
import com.tencent.open.web.security.JniInterface;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class II0xO0 extends XO.II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static boolean f1495II0xO0 = false;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f1496oIX0oI;

    public void I0Io() {
        xxIXOIIO.oOoXoXO("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        try {
            JniInterface.clearAllPWD();
        } catch (Exception e) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override // O0OOX0IIx.XO.II0xO0
    public boolean II0xO0() {
        return true;
    }

    public String X0o0xo() {
        xxIXOIIO.oOoXoXO("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
        try {
            String pWDKeyToMD5 = JniInterface.getPWDKeyToMD5(null);
            xxIXOIIO.IXxxXO("openSDK_LOG.SecureJsInterface", "-->getMD5FromNative, MD5= " + pWDKeyToMD5);
            return pWDKeyToMD5;
        } catch (Exception e) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void XO(String str) {
        int i;
        xxIXOIIO.oOoXoXO("openSDK_LOG.SecureJsInterface", "-->is pswd edit, flag: " + str);
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.SecureJsInterface", "-->is pswd edit exception: " + e.getMessage());
            i = -1;
        }
        if (i != 0 && i != 1) {
            throw new RuntimeException("is pswd edit flag is illegal.");
        }
        if (i == 0) {
            f1495II0xO0 = false;
        } else if (i == 1) {
            f1495II0xO0 = true;
        }
    }

    public void oxoX(String str) {
        int i;
        xxIXOIIO.XO("openSDK_LOG.SecureJsInterface", "-->curPosFromJS: " + str);
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            xxIXOIIO.xxIXOIIO("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e);
            i = -1;
        }
        if (i >= 0) {
            boolean z = I0Io.f1492I0Io;
            boolean z2 = I0Io.f1493II0xO0;
            if (z2) {
                if (JniInterface.BackSpaceChar(z2, i)) {
                    I0Io.f1493II0xO0 = false;
                    return;
                }
                return;
            }
            String str2 = I0Io.f1494oIX0oI;
            this.f1496oIX0oI = str2;
            JniInterface.insetTextToArray(i, str2, str2.length());
            xxIXOIIO.IXxxXO("openSDK_LOG.SecureJsInterface", "curPosFromJS mKey: " + this.f1496oIX0oI);
            return;
        }
        throw new RuntimeException("position is illegal.");
    }
}
