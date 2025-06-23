package com.baidu.tts.webview;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.WebView;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.tools.Utility;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes8.dex */
public class LipWebview {
    public static final String LIFT_HAND = "liftHand";
    public static final String RESET_LIP = "resetLip";
    private static final String TAG = "LipWebview";
    private static final int UI_JS_CLEAR_ANIMATE_BUFFER = 4;
    private static final int UI_JS_DATA = 5;
    private static final int UI_JS_EMIT_EVENT = 7;
    private static final int UI_JS_PLAY_ANIMATE = 3;
    private static final int UI_JS_REST_ANIMATE = 6;
    private WebView webview;
    private boolean isH5Ready = false;
    private boolean isPlay = false;
    private Timer timer = null;
    private Handler mHandler = new b(Looper.getMainLooper());

    /* loaded from: classes8.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LipWebview.this.mHandler.sendMessage(LipWebview.this.mHandler.obtainMessage(3));
        }
    }

    /* loaded from: classes8.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        if (i != 6) {
                            if (i == 7) {
                                String string = message.getData().getString("EventName");
                                String string2 = message.getData().getString("Params");
                                LoggerProxy.d(LipWebview.TAG, "nativeEmitEvent : UI_JS_EMIT_EVENT: " + string + " params: " + string2);
                                if (string2.isEmpty()) {
                                    LipWebview.this.setJsEmitEvent(string, "");
                                    return;
                                } else {
                                    LipWebview.this.setJsEmitEvent(string, string2);
                                    return;
                                }
                            }
                            return;
                        }
                        LipWebview.this.webview.loadUrl("javascript:resetModel()");
                        LoggerProxy.d(LipWebview.TAG, "resetModel()");
                        return;
                    }
                    String encryptBASE64 = Utility.encryptBASE64((byte[]) message.obj);
                    LipWebview.this.webview.loadUrl("javascript:setViewData('" + encryptBASE64 + "')");
                    return;
                }
                LipWebview.this.webview.loadUrl("javascript:clearAnimateBuffer()");
                LoggerProxy.d(LipWebview.TAG, "clearAnimateBuffer()");
                return;
            }
            LipWebview.this.webview.loadUrl("javascript:playAnimate()");
        }
    }

    public LipWebview(WebView webView) {
        this.webview = webView;
    }

    private void clearAnimateBuffer() {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJsEmitEvent(String str, String str2) {
        if (str2.isEmpty()) {
            this.webview.loadUrl("javascript:nativeEmitEvent('" + str + "')");
            return;
        }
        this.webview.loadUrl("javascript:nativeEmitEvent('" + str + "','" + str2 + "')");
    }

    private byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    @TargetApi(19)
    public void initModle(String str, String str2) {
        InputStream inputStream;
        byte[] bArr;
        try {
            if (str.startsWith("file:///android_asset/")) {
                inputStream = getClass().getResourceAsStream(str.replace("file:///android_asset/", "/assets/"));
            } else {
                File file = new File(str);
                if (file.canRead()) {
                    LoggerProxy.d(TAG, "setModleFile model path:" + file.getAbsolutePath());
                    inputStream = new FileInputStream(file);
                } else {
                    LoggerProxy.e(TAG, "setModleFile model Path file is error");
                    inputStream = null;
                }
            }
            if (inputStream != null) {
                bArr = toByteArray(inputStream);
            } else {
                bArr = null;
            }
            if (bArr != null) {
                String replaceAll = Utility.encryptBASE64(bArr).replaceAll("\n", "");
                this.webview.evaluateJavascript("javascript:init('" + replaceAll + "','" + str2 + "')", null);
                return;
            }
            LoggerProxy.e(TAG, "model byte is null");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pauseAnimate() {
        resetAnimate();
    }

    public void resetAnimate() {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(6));
    }

    public void setAnimateEvent(String str, String str2) {
        Message message = new Message();
        message.what = 7;
        Bundle bundle = new Bundle();
        bundle.putString("EventName", str);
        bundle.putString("Params", str2);
        message.setData(bundle);
        this.mHandler.sendMessage(message);
    }

    public void setLipData(byte[] bArr) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(5, bArr));
    }

    public void startAnimate() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
        Timer timer2 = new Timer();
        this.timer = timer2;
        timer2.scheduleAtFixedRate(new a(), 0L, 33L);
    }

    public void stopAnimate() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
        clearAnimateBuffer();
        resetAnimate();
        setAnimateEvent(RESET_LIP, "");
    }
}
