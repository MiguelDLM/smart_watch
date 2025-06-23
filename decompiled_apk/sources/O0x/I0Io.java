package O0x;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class I0Io extends InputConnectionWrapper {

    /* renamed from: I0Io, reason: collision with root package name */
    public static boolean f1492I0Io = false;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static boolean f1493II0xO0 = false;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static String f1494oIX0oI;

    public I0Io(InputConnection inputConnection, boolean z) {
        super(inputConnection, z);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        f1492I0Io = true;
        f1494oIX0oI = charSequence.toString();
        xxIXOIIO.IXxxXO("openSDK_LOG.CaptureInputConnection", "-->commitText: " + charSequence.toString());
        return super.commitText(charSequence, i);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            xxIXOIIO.oOoXoXO("openSDK_LOG.CaptureInputConnection", "sendKeyEvent");
            f1494oIX0oI = String.valueOf((char) keyEvent.getUnicodeChar());
            f1492I0Io = true;
            xxIXOIIO.XO("openSDK_LOG.CaptureInputConnection", "s: " + f1494oIX0oI);
        }
        xxIXOIIO.XO("openSDK_LOG.CaptureInputConnection", "-->sendKeyEvent: " + f1494oIX0oI);
        return super.sendKeyEvent(keyEvent);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        f1492I0Io = true;
        f1494oIX0oI = charSequence.toString();
        xxIXOIIO.IXxxXO("openSDK_LOG.CaptureInputConnection", "-->setComposingText: " + charSequence.toString());
        return super.setComposingText(charSequence, i);
    }
}
