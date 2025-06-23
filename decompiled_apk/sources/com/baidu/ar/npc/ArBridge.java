package com.baidu.ar.npc;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.OrientationEventListener;
import com.baidu.ar.npc.BaiduArView;
import com.huawei.openalliance.ad.constant.bn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes7.dex */
public class ArBridge {
    private static final int INVALID_MESSAGE_ID = -1;
    private static final int MSG_MESSAGE_FROM_ENGINE = 1;
    private static ArBridge self;
    private WeakReference<BaiduArView> mArView;
    private Handler mHandler;
    private List<ArCallback> mMsgHandlers;
    private OrientationEventListener mOrientationEventListener;
    private HandlerThread mThread;
    private VideoUpdateCallback mVideoCallback;
    private long mCurrentGLThreadID = -1;
    private int mDeviceOrientation = -1;
    private TouchOrientation mTouchOrientation = TouchOrientation.SCREEN_ORIENTATION_NOT_DEFINED;
    private int mFPS = 0;
    private boolean mHasResumeByUser = false;

    /* loaded from: classes7.dex */
    public static class ArCallback {
        public MessageHandler mHandler;
        public int mMessageId;
        public int mMessageType;

        public ArCallback(int i, int i2, MessageHandler messageHandler) {
            this.mMessageType = i;
            this.mMessageId = i2;
            this.mHandler = messageHandler;
        }
    }

    /* loaded from: classes7.dex */
    public static class ArMessage {
        public HashMap<String, Object> mData;
        public int mMessageID;
        public int mMessageType;
        public int mResMessageID;

        public ArMessage(int i, int i2, HashMap<String, Object> hashMap, int i3) {
            this.mMessageType = i;
            this.mMessageID = i2;
            this.mData = hashMap;
            this.mResMessageID = i3;
        }
    }

    /* loaded from: classes7.dex */
    public interface CaptureCallback {
        void onSucceed(Bitmap bitmap);
    }

    /* loaded from: classes7.dex */
    public static class LuaSdkBridgeMessageType {
        public static final int MSG_TYPE_SDK_LUA_GAME_CONFIG = 1001;
    }

    /* loaded from: classes7.dex */
    public interface MessageHandler {
        void handleMessage(int i, int i2, HashMap<String, Object> hashMap);
    }

    /* loaded from: classes7.dex */
    public static class MessageParamKeys {
        public static final String MAP_NPC_KEY_NAME = "script";
        public static final String MODEL_COLOR_KEY = "model_color";
        public static final String MODEL_TYPE_KEY = "model_type";
    }

    /* loaded from: classes7.dex */
    public static class MessageType {
        public static final int MSG_ALL = 0;
        public static final int MSG_CASE_INIT_COMPLETED = 9;
        public static final int MSG_MODEL_APPEAR = 201;
        public static final int MSG_MODEL_DISAPPEAR = 202;
        public static final int MSG_NONE = -1;
        public static final int MSG_PLAY_MUSIC = 1001;
        public static final int MSG_PLAY_MUSIC_RES = 1002;
        public static final int MSG_START_CONFIG = 10;
        public static final int MSG_TRACK_FOUND = 101;
        public static final int MSG_TRACK_LOST = 102;
        public static final int MSG_TYPE_IMU_CLOSE = 303;
        public static final int MSG_TYPE_IMU_CLOSE_RES = 304;
        public static final int MSG_TYPE_IMU_OPEN = 301;
        public static final int MSG_TYPE_IMU_OPEN_RES = 302;
        public static final int MSG_TYPE_LUA_SDK_BRIDGE = 1901;
        public static final int MSG_TYPE_MUSIC_FAILED = 1010;
        public static final int MSG_TYPE_MUSIC_FINISHED = 1009;
        public static final int MSG_TYPE_OPEN_URL = 1301;
        public static final int MSG_TYPE_PAUSE_MUSIC = 1003;
        public static final int MSG_TYPE_PAUSE_MUSIC_RES = 1004;
        public static final int MSG_TYPE_PHONE_CALL = 1401;
        public static final int MSG_TYPE_RESUME_MUSIC = 1005;
        public static final int MSG_TYPE_RESUME_MUSIC_RES = 1006;
        public static final int MSG_TYPE_SDK_LUA_BRIDGE = 1902;
        public static final int MSG_TYPE_SDK_RUN_SCRIPT = 2001;
        public static final int MSG_TYPE_SDK_SET_MODEL_COLOR = 2002;
        public static final int MSG_TYPE_SHARE = 1601;
        public static final int MSG_TYPE_STATISTICS = 1801;
        public static final int MSG_TYPE_STOP_MUSIC = 1007;
        public static final int MSG_TYPE_STOP_MUSIC_RES = 1008;
        public static final int MSG_TYPE_VIBERATOR = 1501;
        public static final int MSG_TYPE_VIDEO_PAUSE = 1023;
        public static final int MSG_TYPE_VIDEO_PAUSE_RES = 1024;
        public static final int MSG_TYPE_VIDEO_PLAY = 1021;
        public static final int MSG_TYPE_VIDEO_PLAY_FAILED = 1029;
        public static final int MSG_TYPE_VIDEO_PLAY_FINISH = 1030;
        public static final int MSG_TYPE_VIDEO_PLAY_RES = 1022;
        public static final int MSG_TYPE_VIDEO_RESUME = 1025;
        public static final int MSG_TYPE_VIDEO_RESUME_RES = 1026;
        public static final int MSG_TYPE_VIDEO_STOP = 1027;
        public static final int MSG_TYPE_VIDEO_STOP_RES = 1028;
        public static final int MSG_USR_INTERACTION_CONFIG = 11;
    }

    /* loaded from: classes7.dex */
    public enum TouchOrientation {
        SCREEN_ORIENTATION_PORTRAIT,
        SCREEN_ORIENTATION_LANDSCAPE,
        SCREEN_ORIENTATION_REVERSE_PORTRAIT,
        SCREEN_ORIENTATION_REVERSE_LANDSCAPE,
        SCREEN_ORIENTATION_NOT_DEFINED
    }

    /* loaded from: classes7.dex */
    public interface VideoUpdateCallback {
        void onUpdateVideoFrame(String str, int i, String str2);
    }

    private ArBridge() {
        HandlerThread handlerThread = new HandlerThread("msg_callback_thread");
        this.mThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mThread.getLooper(), new Handler.Callback() { // from class: com.baidu.ar.npc.ArBridge.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == 1) {
                    ArBridge.this.processIncomingMessage((ArMessage) message.obj);
                    return false;
                }
                return false;
            }
        });
        this.mMsgHandlers = new LinkedList();
    }

    public static synchronized ArBridge getInstance() {
        ArBridge arBridge;
        synchronized (ArBridge.class) {
            try {
                if (self == null) {
                    self = new ArBridge();
                }
                arBridge = self;
            } catch (Throwable th) {
                throw th;
            }
        }
        return arBridge;
    }

    public static native boolean libraryHasLoaded();

    /* JADX INFO: Access modifiers changed from: private */
    public void processIncomingMessage(ArMessage arMessage) {
        for (ArCallback arCallback : this.mMsgHandlers) {
            int i = arCallback.mMessageType;
            if (i == 0 || arMessage.mMessageType == i) {
                int i2 = arCallback.mMessageId;
                if (-1 == i2 || arMessage.mResMessageID == i2) {
                    arCallback.mHandler.handleMessage(arMessage.mMessageType, arMessage.mMessageID, arMessage.mData);
                }
            }
        }
    }

    private void receiveMsgFromEngine(int i, int i2, HashMap<String, Object> hashMap, int i3) {
        this.mHandler.obtainMessage(1, new ArMessage(i, i2, hashMap, i3)).sendToTarget();
    }

    private void sendMessageImpl(int i, HashMap<String, Object> hashMap, int i2) {
        sendMessageImpl(i, -1, hashMap, i2);
    }

    public void clearScreen() {
        executeOnGLThread(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.15
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeClearScreen();
            }
        });
    }

    public int createCase(final String str, final HashMap<String, Object> hashMap, final int i, final int i2) {
        WeakReference<BaiduArView> weakReference = this.mArView;
        if (weakReference != null && weakReference.get() != null) {
            this.mArView.get().mNeedDestroy = false;
        }
        final int caseId = getCaseId();
        executeOnGLThread(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.7
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeCreateCase(str, caseId, hashMap, i, i2);
            }
        });
        return caseId;
    }

    public void destroyCase() {
        WeakReference<BaiduArView> weakReference = this.mArView;
        if (weakReference != null && weakReference.get() != null && this.mArView.get().mUpdating) {
            this.mArView.get().mNeedDestroy = true;
        } else {
            nativeDestroyCase();
        }
    }

    public void executeOnGLThread(Runnable runnable) {
        WeakReference<BaiduArView> weakReference = this.mArView;
        if (weakReference != null && weakReference.get() != null) {
            if (this.mCurrentGLThreadID == Thread.currentThread().getId()) {
                runnable.run();
            } else {
                this.mArView.get().queueEvent(runnable);
            }
        }
    }

    public native int getCaseId();

    public int getFps() {
        executeOnGLThread(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.17
            @Override // java.lang.Runnable
            public void run() {
                ArBridge arBridge = ArBridge.this;
                arBridge.mFPS = arBridge.nativeGetFps();
            }
        });
        return this.mFPS;
    }

    public native int getMessageID();

    public native void nativeClearScreen();

    public native void nativeCreateCase(String str, int i, HashMap<String, Object> hashMap, int i2, int i3);

    public native void nativeDestroyCase();

    public native int nativeGetFps();

    public native void nativeOnPause();

    public native void nativeOnPauseByUser();

    public native void nativeOnResume();

    public native void nativeOnResumeByUser();

    public native void nativeReset();

    public native void nativeSetCameraDefaultPos();

    public native void nativeSetEuler(float f, float f2, float f3, String str);

    public native void nativeSetFrustum(float f, float f2);

    public native void nativeSetSize(int i, int i2);

    public native void nativeSetTargetInfo(HashMap<String, Object> hashMap);

    public native void nativeUpdate();

    public native void nativeUpdateRMatrix(float[] fArr);

    public native void nativeUpdateRTMatrix(float[] fArr);

    public native void nativeUpdateSLAMMatrix(float[] fArr);

    public void onPause() {
        OrientationEventListener orientationEventListener = this.mOrientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        executeOnGLThread(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.18
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeOnPause();
            }
        });
    }

    public void onPauseByUser() {
        this.mHasResumeByUser = false;
        executeOnGLThread(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.14
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeOnPauseByUser();
            }
        });
    }

    public void onResume() {
        if (this.mOrientationEventListener == null && this.mArView.get() != null) {
            this.mOrientationEventListener = new OrientationEventListener(this.mArView.get().getContext(), 3) { // from class: com.baidu.ar.npc.ArBridge.19
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i) {
                    ArBridge.this.mDeviceOrientation = i;
                    Log.d(bn.f.V, "orientation " + ArBridge.this.mDeviceOrientation);
                    if (ArBridge.this.mDeviceOrientation < 0) {
                        ArBridge.this.mTouchOrientation = TouchOrientation.SCREEN_ORIENTATION_NOT_DEFINED;
                        return;
                    }
                    int i2 = (ArBridge.this.mDeviceOrientation + 360) % 360;
                    if (i2 > 45 && i2 <= 315) {
                        if (i2 > 45 && i2 <= 135) {
                            ArBridge.this.mTouchOrientation = TouchOrientation.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                            return;
                        } else if (i2 > 135 && i2 <= 225) {
                            ArBridge.this.mTouchOrientation = TouchOrientation.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                            return;
                        } else {
                            if (i2 > 225 && i2 <= 315) {
                                ArBridge.this.mTouchOrientation = TouchOrientation.SCREEN_ORIENTATION_LANDSCAPE;
                                return;
                            }
                            return;
                        }
                    }
                    ArBridge.this.mTouchOrientation = TouchOrientation.SCREEN_ORIENTATION_PORTRAIT;
                }
            };
        }
        OrientationEventListener orientationEventListener = this.mOrientationEventListener;
        if (orientationEventListener != null && orientationEventListener.canDetectOrientation()) {
            this.mOrientationEventListener.enable();
        }
        executeOnGLThread(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.20
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeOnResume();
            }
        });
        if (this.mHasResumeByUser) {
            onResumeByUser();
            this.mHasResumeByUser = false;
        }
    }

    public void onResumeByUser() {
        WeakReference<BaiduArView> weakReference = this.mArView;
        if (weakReference == null || weakReference.get() == null) {
            this.mHasResumeByUser = true;
        }
        executeOnGLThread(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.13
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.mHasResumeByUser = false;
                ArBridge.this.nativeOnResumeByUser();
            }
        });
    }

    public void onTouchEvent(final int i, final int i2, final float f, final float f2, final float f3, final float f4, final int i3, final float f5, final float f6, final float f7, final float f8, final long j) {
        executeOnGLThread(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.21
            @Override // java.lang.Runnable
            public void run() {
                Log.d(bn.f.V, "onTouchEvent the orientation is " + ArBridge.this.mTouchOrientation.name());
                ArBridge arBridge = ArBridge.this;
                arBridge.onTouchEventNative(i, i2, f, f2, f3, f4, i3, f5, f6, f7, f8, j, arBridge.mTouchOrientation.ordinal());
            }
        });
    }

    public native void onTouchEventNative(int i, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, long j, int i4);

    public synchronized void registerMessageHandler(final int i, final MessageHandler messageHandler) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.5
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.mMsgHandlers.add(new ArCallback(i, -1, messageHandler));
            }
        });
    }

    public synchronized void removeMessageHandeler(final MessageHandler messageHandler) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.6
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ArBridge.this.mMsgHandlers.iterator();
                while (it.hasNext()) {
                    if (((ArCallback) it.next()).mHandler == messageHandler) {
                        it.remove();
                    }
                }
            }
        });
    }

    public void reset() {
        executeOnGLThread(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.16
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeReset();
            }
        });
    }

    public void sendLuaScriptToEngine(String str) {
        if (!TextUtils.isEmpty(str)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("script", str);
            sendMessage(2001, hashMap);
        }
    }

    public void sendMessage(int i, HashMap<String, Object> hashMap) {
        sendMessageImpl(i, hashMap, -1);
    }

    public native void sendMessageToEngine(int i, int i2, HashMap<String, Object> hashMap, int i3);

    public void sendResponseMessage(int i, HashMap<String, Object> hashMap, int i2) {
        sendMessageImpl(i, hashMap, i2);
    }

    public void setArView(BaiduArView baiduArView) {
        this.mArView = new WeakReference<>(baiduArView);
    }

    public void setCameraDefaultPos() {
        nativeSetCameraDefaultPos();
    }

    public void setEuler(final float f, final float f2, final float f3, final String str) {
        executeOnGLThread(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.10
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeSetEuler(f, f2, f3, str);
            }
        });
    }

    public void setFrustum(final float f, final float f2) {
        executeOnGLThread(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.11
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeSetFrustum(f, f2);
            }
        });
    }

    public native void setGLJniEnv();

    public void setGLThreadID(long j) {
        this.mCurrentGLThreadID = j;
    }

    public void setModelVirtualColor(int i, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("model_color", Integer.valueOf(i));
        if (!z) {
            hashMap.put("model_type", 1);
        }
        sendMessage(2002, hashMap);
    }

    public void setSize(final int i, final int i2) {
        executeOnGLThread(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.9
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeSetSize(i, i2);
            }
        });
    }

    public void setTargetInfo(final HashMap<String, Object> hashMap) {
        executeOnGLThread(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.8
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeSetTargetInfo(hashMap);
            }
        });
    }

    public synchronized void setVideoUpdateCallback(VideoUpdateCallback videoUpdateCallback) {
        this.mVideoCallback = videoUpdateCallback;
    }

    public void surfaceViewCapture(final CaptureCallback captureCallback) {
        BaiduArView baiduArView = this.mArView.get();
        if (baiduArView != null) {
            baiduArView.takeSnapshot(new BaiduArView.ARPictureCallback() { // from class: com.baidu.ar.npc.ArBridge.2
                @Override // com.baidu.ar.npc.BaiduArView.ARPictureCallback
                public void onPictureTaken(final Bitmap bitmap) {
                    ArBridge.this.mHandler.post(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            captureCallback.onSucceed(bitmap);
                        }
                    });
                }
            });
        } else {
            this.mHandler.post(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.3
                @Override // java.lang.Runnable
                public void run() {
                    captureCallback.onSucceed(null);
                }
            });
        }
    }

    public void switchCase(final String str, final HashMap<String, Object> hashMap, final int i, final int i2) {
        executeOnGLThread(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.12
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeDestroyCase();
                ArBridge.this.setGLJniEnv();
                ArBridge arBridge = ArBridge.this;
                arBridge.nativeCreateCase(str, arBridge.getCaseId(), hashMap, i, i2);
            }
        });
    }

    public void update() {
        nativeUpdate();
    }

    public void updateRMatrix(float[] fArr) {
        nativeUpdateRMatrix(fArr);
    }

    public void updateRTMatrix(float[] fArr) {
        nativeUpdateRTMatrix(fArr);
    }

    public void updateSLAMMatrix(float[] fArr) {
        nativeUpdateSLAMMatrix(fArr);
    }

    public void updateVideoFrame(String str, int i, String str2) {
        VideoUpdateCallback videoUpdateCallback = this.mVideoCallback;
        if (videoUpdateCallback != null) {
            videoUpdateCallback.onUpdateVideoFrame(str, i, str2);
        }
    }

    private void sendMessageImpl(final int i, final int i2, final HashMap<String, Object> hashMap, final int i3) {
        WeakReference<BaiduArView> weakReference = this.mArView;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mArView.get().queueEvent(new Runnable() { // from class: com.baidu.ar.npc.ArBridge.4
            @Override // java.lang.Runnable
            public void run() {
                int i4 = i2;
                if (-1 == i4) {
                    ArBridge arBridge = ArBridge.this;
                    arBridge.sendMessageToEngine(i, arBridge.getMessageID(), hashMap, i3);
                } else {
                    ArBridge.this.sendMessageToEngine(i, i4, hashMap, i3);
                }
            }
        });
    }
}
