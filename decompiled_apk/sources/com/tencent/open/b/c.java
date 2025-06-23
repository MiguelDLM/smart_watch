package com.tencent.open.b;

import O0x.I0Io;
import O0x.II0xO0;
import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class c extends b {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static boolean f26947IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public I0Io f26948Oo;

    /* renamed from: XO, reason: collision with root package name */
    public KeyEvent f26949XO;

    public c(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            getSettings().setBuiltInZoomControls(true);
            xxIXOIIO.oOoXoXO("openSDK_LOG.SecureWebView", "-->SecureWebView.destroy setBuiltInZoomControls--");
        } catch (Exception e) {
            xxIXOIIO.xxIXOIIO("openSDK_LOG.SecureWebView", "-->SecureWebView.destroy setBuiltInZoomControls", e);
        }
        super.destroy();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int unicodeChar;
        xxIXOIIO.XO("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + f26947IXxxXO);
        if (!f26947IXxxXO) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 4) {
                if (keyCode != 66) {
                    if (keyCode != 67) {
                        if (keyEvent.getUnicodeChar() == 0) {
                            return super.dispatchKeyEvent(keyEvent);
                        }
                        if (II0xO0.f1495II0xO0 && (((unicodeChar = keyEvent.getUnicodeChar()) >= 33 && unicodeChar <= 95) || (unicodeChar >= 97 && unicodeChar <= 125))) {
                            KeyEvent keyEvent2 = new KeyEvent(0, 17);
                            this.f26949XO = keyEvent2;
                            return super.dispatchKeyEvent(keyEvent2);
                        }
                        return super.dispatchKeyEvent(keyEvent);
                    }
                    I0Io.f1493II0xO0 = true;
                    return super.dispatchKeyEvent(keyEvent);
                }
                return super.dispatchKeyEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + II0xO0.f1495II0xO0);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        xxIXOIIO.IXxxXO("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + onCreateInputConnection);
        if (onCreateInputConnection != null) {
            f26947IXxxXO = true;
            I0Io i0Io = new I0Io(super.onCreateInputConnection(editorInfo), false);
            this.f26948Oo = i0Io;
            return i0Io;
        }
        f26947IXxxXO = false;
        return onCreateInputConnection;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int unicodeChar;
        xxIXOIIO.XO("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + f26947IXxxXO);
        if (!f26947IXxxXO) {
            return super.onKeyDown(i, keyEvent);
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 4) {
                if (keyCode != 66) {
                    if (keyCode != 67) {
                        if (keyEvent.getUnicodeChar() == 0) {
                            return super.onKeyDown(i, keyEvent);
                        }
                        if (II0xO0.f1495II0xO0 && (((unicodeChar = keyEvent.getUnicodeChar()) >= 33 && unicodeChar <= 95) || (unicodeChar >= 97 && unicodeChar <= 125))) {
                            KeyEvent keyEvent2 = new KeyEvent(0, 17);
                            this.f26949XO = keyEvent2;
                            return super.onKeyDown(keyEvent2.getKeyCode(), this.f26949XO);
                        }
                        return super.onKeyDown(i, keyEvent);
                    }
                    I0Io.f1493II0xO0 = true;
                    return super.onKeyDown(i, keyEvent);
                }
                return super.onKeyDown(i, keyEvent);
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
