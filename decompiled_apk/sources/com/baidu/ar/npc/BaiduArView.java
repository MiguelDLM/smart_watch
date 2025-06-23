package com.baidu.ar.npc;

import XIXIX.OOXIXo;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.ar.npc.ArBridge;
import com.baidu.ar.npc.RendererUtils;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Calendar;
import java.util.HashMap;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes7.dex */
public class BaiduArView extends GLSurfaceView {
    private static final int CLICK_DISTANCE = 20;
    private static final int CLICK_TIME_IN_MILS = 300;
    private static boolean DEBUG = true;
    private static int DEFAULT_FPS = 30;
    private static final int DOUBLE_CLICK_TIME_IN_MILS = 400;
    private static final int LONG_PRESS_TIME_IN_MILS = 600;
    private static final int SCROLL_DISTANCE = 80;
    private static final int SCROLL_MIN_DISTANCE = 20;
    private static final String TAG = "BaiduArView";
    private static final double TWO_FINGER_SCROLL_ANGLE = 0.39269908169872414d;
    private int mFirstFingerId;
    private float mFirstFingerInitX;
    private float mFirstFingerInitY;
    private long mFirstFingerLastTimeInMils;
    private float mFirstFingerLastX;
    private float mFirstFingerLastY;
    private GestureDetector mGestureDetector;
    private GestureDetector.OnGestureListener mGestureListener;
    private MyRenderer mGlRenderer;
    private MyHandler mHandler;
    private boolean mIsDisableAll;
    private boolean mIsDisableClick;
    private boolean mIsDisableDoubleClick;
    private boolean mIsDisableLongPress;
    private boolean mIsDisablePinch;
    private boolean mIsDisableScroll;
    private boolean mIsDisableTwoFingerScroll;
    private boolean mIsFirstFingnerInClickArea;
    private ClickInfo mLastClickInfo;
    private double mLastDistance;
    ArBridge.MessageHandler mMessageHandler;
    public boolean mNeedDestroy;
    private int mSecFingerId;
    private float mSecFingerInitX;
    private float mSecFingerInitY;
    private long mSecFingerLastTimeInMils;
    private float mSecFingerLastX;
    private float mSecFingerLastY;
    private TouchEventStatus mStatus;
    public boolean mUpdating;
    private boolean mUserInteractionEnabled;
    private static final double[] PINCH_ANGLE_RANGE = {1.5707963267948966d, 3.141592653589793d};
    private static int mFrameRate = 0;

    /* renamed from: com.baidu.ar.npc.BaiduArView$6, reason: invalid class name */
    /* loaded from: classes7.dex */
    /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$ar$npc$BaiduArView$TouchEventStatus;

        static {
            int[] iArr = new int[TouchEventStatus.values().length];
            $SwitchMap$com$baidu$ar$npc$BaiduArView$TouchEventStatus = iArr;
            try {
                iArr[TouchEventStatus.EStatSingleFingerCandidate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$ar$npc$BaiduArView$TouchEventStatus[TouchEventStatus.EStatTwoFingersCandidate.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$ar$npc$BaiduArView$TouchEventStatus[TouchEventStatus.EStatScroll.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$ar$npc$BaiduArView$TouchEventStatus[TouchEventStatus.EStatTwoFingersScroll.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$ar$npc$BaiduArView$TouchEventStatus[TouchEventStatus.EStatPinchAndUnpinch.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$ar$npc$BaiduArView$TouchEventStatus[TouchEventStatus.EStatLongPresss.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$baidu$ar$npc$BaiduArView$TouchEventStatus[TouchEventStatus.EScrollAfterLongPress.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$baidu$ar$npc$BaiduArView$TouchEventStatus[TouchEventStatus.EStatPinch.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$baidu$ar$npc$BaiduArView$TouchEventStatus[TouchEventStatus.EStatUnPinch.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$baidu$ar$npc$BaiduArView$TouchEventStatus[TouchEventStatus.EStatUnknown.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface ARPictureCallback {
        void onPictureTaken(Bitmap bitmap);
    }

    /* loaded from: classes7.dex */
    public interface ARRecorder {
        void onContextChanged(EGLContext eGLContext, int i, int i2);

        void onFrameAvailable(int i);
    }

    /* loaded from: classes7.dex */
    public static class ClickInfo {
        public int fingerId;
        public long time;
        public float x;
        public float y;

        private ClickInfo() {
        }
    }

    /* loaded from: classes7.dex */
    public static class ContextFactory implements GLSurfaceView.EGLContextFactory {
        private static int EGL_CONTEXT_CLIENT_VERSION = 12440;

        private ContextFactory() {
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            Log.w(BaiduArView.TAG, "onSurface creating OpenGL ES 2.0 context");
            Log.w("callseq", "onSurface creating OpenGL ES 2.0 context");
            BaiduArView.checkEglError("Before eglCreateContext", egl10);
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
            BaiduArView.checkEglError("After eglCreateContext", egl10);
            Log.d(BaiduArView.TAG, "createContext");
            ArBridge.getInstance().setGLThreadID(Thread.currentThread().getId());
            return eglCreateContext;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            Log.d(BaiduArView.TAG, "onSurface destroyContext");
            Log.d("callseq", "onSurface destroyContext");
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
            ArBridge.getInstance().setGLThreadID(-1L);
        }
    }

    /* loaded from: classes7.dex */
    public static class MyHandler extends Handler {
        public static final int MSG_LONG_PRESS = 1;
        public static final int MSG_SINGLE_CLICK = 2;
        WeakReference<BaiduArView> mView;

        public MyHandler(BaiduArView baiduArView) {
            this.mView = new WeakReference<>(baiduArView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BaiduArView baiduArView;
            Object obj;
            super.handleMessage(message);
            int i = message.what;
            if (i != 1) {
                if (i == 2 && (baiduArView = this.mView.get()) != null && (obj = message.obj) != null) {
                    ClickInfo clickInfo = (ClickInfo) obj;
                    if (!baiduArView.mIsDisableClick) {
                        ArBridge.getInstance().onTouchEvent(TouchEventType.EClick.ordinal(), clickInfo.fingerId, clickInfo.x, clickInfo.y, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, clickInfo.time);
                    }
                    ArBridge.getInstance().onTouchEvent(TouchEventType.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                    return;
                }
                return;
            }
            if (this.mView.get() != null && this.mView.get().mStatus == TouchEventStatus.EStatSingleFingerCandidate && this.mView.get().mIsFirstFingnerInClickArea) {
                this.mView.get().mStatus = TouchEventStatus.EStatLongPresss;
                if (!this.mView.get().mIsDisableAll && !this.mView.get().mIsDisableLongPress) {
                    ArBridge.getInstance().onTouchEvent(TouchEventType.ELongPress.ordinal(), this.mView.get().mFirstFingerId, this.mView.get().mFirstFingerLastX, this.mView.get().mFirstFingerLastY, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, Calendar.getInstance().getTimeInMillis());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class MyRenderer implements GLSurfaceView.Renderer {
        private ARRecorder mArRecorder;
        private volatile ARPictureCallback mCallback;
        private int mFboId;
        private int mHeight;
        private int mInterval;
        private RendererUtils.RenderContext mRenderContext;
        private long mStartTime;
        private int mTextureId;
        private int mWidth;

        private MyRenderer() {
            this.mFboId = -1;
            this.mTextureId = -1;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartTime = System.currentTimeMillis();
            this.mInterval = 0;
        }

        public void onContextDestroy() {
            ARRecorder aRRecorder = this.mArRecorder;
            if (aRRecorder != null) {
                aRRecorder.onContextChanged(null, 0, 0);
            }
            if (this.mCallback != null) {
                this.mCallback.onPictureTaken(null);
                this.mCallback = null;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            BaiduArView.this.mUpdating = true;
            if (this.mInterval > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
                int i = this.mInterval;
                if (currentTimeMillis < i) {
                    try {
                        Thread.sleep(i - currentTimeMillis);
                    } catch (Throwable unused) {
                    }
                }
                this.mStartTime = System.currentTimeMillis();
            }
            if (this.mArRecorder != null) {
                if (this.mFboId == -1) {
                    int createTexture = RendererUtils.createTexture(this.mWidth, this.mHeight);
                    this.mTextureId = createTexture;
                    this.mFboId = RendererUtils.createFBO(createTexture, this.mWidth, this.mHeight, 33189);
                    this.mRenderContext = RendererUtils.createProgram();
                    this.mArRecorder.onContextChanged(((EGL10) EGLContext.getEGL()).eglGetCurrentContext(), this.mWidth, this.mHeight);
                }
                GLES20.glBindFramebuffer(36160, this.mFboId);
                ArBridge.getInstance().update();
                GLES20.glBindFramebuffer(36160, 0);
                RendererUtils.renderTexture(this.mRenderContext, this.mTextureId, this.mWidth, this.mHeight);
                this.mArRecorder.onFrameAvailable(this.mTextureId);
            } else {
                ArBridge.getInstance().update();
            }
            if (this.mCallback != null) {
                this.mCallback.onPictureTaken(takePicture());
                this.mCallback = null;
            }
            BaiduArView baiduArView = BaiduArView.this;
            baiduArView.mUpdating = false;
            if (baiduArView.mNeedDestroy) {
                ArBridge.getInstance().nativeDestroyCase();
                BaiduArView.this.mNeedDestroy = false;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            Log.d(BaiduArView.TAG, String.format("onSurfaceChanged thread name %s id %s width %d height %d", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(i), Integer.valueOf(i2)));
            this.mWidth = i;
            this.mHeight = i2;
            this.mTextureId = -1;
            this.mFboId = -1;
            this.mRenderContext = null;
            ArBridge.getInstance().setSize(i, i2);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Log.d(BaiduArView.TAG, "onSurfaceCreated");
            ArBridge.getInstance().setGLJniEnv();
            ArBridge.getInstance().onResume();
        }

        public void setFrameRate(int i) {
            if (i > 0 && i <= 60) {
                this.mInterval = 1000 / i;
            }
        }

        public void setRecorder(ARRecorder aRRecorder) {
            this.mArRecorder = aRRecorder;
        }

        public void takePicture(ARPictureCallback aRPictureCallback) {
            this.mCallback = aRPictureCallback;
        }

        private Bitmap takePicture() {
            int width = BaiduArView.this.getWidth();
            int height = BaiduArView.this.getHeight();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(width * height * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            GLES20.glReadPixels(0, 0, width, height, 6408, 5121, allocateDirect);
            allocateDirect.rewind();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(allocateDirect);
            return createBitmap;
        }
    }

    /* loaded from: classes7.dex */
    public static class Point {
        float x;
        float y;

        private Point() {
        }
    }

    /* loaded from: classes7.dex */
    public enum TouchEventStatus {
        EStatSingleFingerCandidate,
        EStatTwoFingersCandidate,
        EStatLongPresss,
        EStatScroll,
        EStatTwoFingersScroll,
        EStatPinch,
        EStatUnPinch,
        EScrollAfterLongPress,
        EStatPinchAndUnpinch,
        EStatUnknown
    }

    /* loaded from: classes7.dex */
    public enum TouchEventType {
        EClick,
        ELongPress,
        EScroll,
        ETwoFingerScroll,
        EPinch,
        EUnPinch,
        EScrollAfterLongPress,
        EDoubleClick,
        EClear
    }

    public BaiduArView(Context context) {
        super(context);
        this.mStatus = TouchEventStatus.EStatSingleFingerCandidate;
        this.mIsFirstFingnerInClickArea = true;
        this.mFirstFingerId = -1;
        this.mFirstFingerInitX = -1.0f;
        this.mFirstFingerInitY = -1.0f;
        this.mFirstFingerLastX = -1.0f;
        this.mFirstFingerLastY = -1.0f;
        this.mFirstFingerLastTimeInMils = -1L;
        this.mSecFingerId = -1;
        this.mSecFingerInitX = -1.0f;
        this.mSecFingerInitY = -1.0f;
        this.mSecFingerLastX = -1.0f;
        this.mSecFingerLastY = -1.0f;
        this.mSecFingerLastTimeInMils = -1L;
        this.mLastDistance = -1.0d;
        this.mGlRenderer = null;
        this.mIsDisableAll = false;
        this.mIsDisablePinch = true;
        this.mIsDisableClick = false;
        this.mIsDisableDoubleClick = false;
        this.mIsDisableScroll = true;
        this.mIsDisableTwoFingerScroll = true;
        this.mIsDisableLongPress = true;
        this.mUserInteractionEnabled = true;
        this.mLastClickInfo = null;
        this.mNeedDestroy = false;
        this.mUpdating = false;
        this.mMessageHandler = new ArBridge.MessageHandler() { // from class: com.baidu.ar.npc.BaiduArView.4
            @Override // com.baidu.ar.npc.ArBridge.MessageHandler
            public void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get("disable_all") != null) {
                        if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                            BaiduArView.this.mIsDisableAll = true;
                        } else {
                            BaiduArView.this.mIsDisableAll = false;
                        }
                    }
                    if (hashMap.get("disable_pinch") != null) {
                        if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                            BaiduArView.this.mIsDisablePinch = true;
                        } else {
                            BaiduArView.this.mIsDisablePinch = false;
                        }
                    }
                    if (hashMap.get("disable_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                            BaiduArView.this.mIsDisableClick = true;
                        } else {
                            BaiduArView.this.mIsDisableClick = false;
                        }
                    }
                    if (hashMap.get("disable_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                            BaiduArView.this.mIsDisableScroll = true;
                        } else {
                            BaiduArView.this.mIsDisableScroll = false;
                        }
                    }
                    if (hashMap.get("disable_long_press") != null) {
                        if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                            BaiduArView.this.mIsDisableLongPress = true;
                        } else {
                            BaiduArView.this.mIsDisableLongPress = false;
                        }
                    }
                    if (hashMap.get("disable_double_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                            BaiduArView.this.mIsDisableDoubleClick = true;
                        } else {
                            BaiduArView.this.mIsDisableDoubleClick = false;
                        }
                    }
                    if (hashMap.get("disable_two_finger_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                            BaiduArView.this.mIsDisableTwoFingerScroll = true;
                        } else {
                            BaiduArView.this.mIsDisableTwoFingerScroll = false;
                        }
                    }
                }
            }
        };
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.baidu.ar.npc.BaiduArView.5
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(final MotionEvent motionEvent) {
                BaiduArView.this.queueEvent(new Runnable() { // from class: com.baidu.ar.npc.BaiduArView.5.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.d(BaiduArView.TAG, "touch onLongPress " + motionEvent);
                        long timeInMillis = Calendar.getInstance().getTimeInMillis();
                        if (!BaiduArView.this.mIsDisableAll && !BaiduArView.this.mIsDisableLongPress) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.ELongPress.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
                        }
                    }
                });
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float f, final float f2) {
                BaiduArView.this.queueEvent(new Runnable() { // from class: com.baidu.ar.npc.BaiduArView.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.d(BaiduArView.TAG, String.format("touch onScroll begin motionevent %s and end motion event %s and speed %1.2f, %1.2f ", motionEvent.toString(), motionEvent2.toString(), Float.valueOf(f), Float.valueOf(f2)));
                        long timeInMillis = Calendar.getInstance().getTimeInMillis();
                        if (!BaiduArView.this.mIsDisableAll && BaiduArView.this.mIsDisableScroll) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EScroll.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, motionEvent2.getPointerId(0), motionEvent2.getX(), motionEvent2.getY(), f, f2, timeInMillis);
                        }
                    }
                });
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(final MotionEvent motionEvent) {
                BaiduArView.this.queueEvent(new Runnable() { // from class: com.baidu.ar.npc.BaiduArView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.d(BaiduArView.TAG, "touch on single tap with motionEvnet " + motionEvent);
                        long timeInMillis = Calendar.getInstance().getTimeInMillis();
                        Log.d(BaiduArView.TAG, "touch timeInMils " + timeInMillis);
                        if (!BaiduArView.this.mIsDisableAll && !BaiduArView.this.mIsDisableClick) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EClick.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
                        }
                    }
                });
                return false;
            }
        };
        init(true, 16, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkEglError(String str, EGL10 egl10) {
        while (true) {
            int eglGetError = egl10.eglGetError();
            if (eglGetError != 12288) {
                Log.e(TAG, String.format("%s: EGL error: 0x%x", str, Integer.valueOf(eglGetError)));
            } else {
                return;
            }
        }
    }

    private void clearStatus() {
        this.mStatus = TouchEventStatus.EStatSingleFingerCandidate;
        this.mIsFirstFingnerInClickArea = true;
        this.mLastDistance = -1.0d;
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            ArBridge.getInstance().onTouchEvent(TouchEventType.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
        }
    }

    private double getAngleOfTwoLine(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = f4 - f2;
        float f10 = f3 - f;
        float f11 = f8 - f6;
        float f12 = f7 - f5;
        if (f9 / f10 == f11 / f12) {
            return -1.0d;
        }
        Log.d("touchopt", String.format("vx1 %1.3f vy1 %1.3f vx2 %1.3f vy2 %1.3f", Float.valueOf(f10), Float.valueOf(f9), Float.valueOf(f12), Float.valueOf(f11)));
        double sqrt = ((f10 * f12) + (f9 * f11)) / (Math.sqrt((f10 * f10) + (f9 * f9)) * Math.sqrt((f12 * f12) + (f11 * f11)));
        Log.d("touchopt", String.format("cosAngle is %1.3f", Double.valueOf(sqrt)));
        return Math.acos(sqrt);
    }

    private double getDistance(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return Math.sqrt((f5 * f5) + (f6 * f6));
    }

    private float getFirstVelX(MotionEvent motionEvent) {
        return (motionEvent.getX(motionEvent.findPointerIndex(this.mFirstFingerId)) - this.mFirstFingerLastX) / ((float) (motionEvent.getEventTime() - this.mFirstFingerLastTimeInMils));
    }

    private float getFirstVelY(MotionEvent motionEvent) {
        return (motionEvent.getY(motionEvent.findPointerIndex(this.mFirstFingerId)) - this.mFirstFingerLastY) / ((float) (motionEvent.getEventTime() - this.mFirstFingerLastTimeInMils));
    }

    private float getFirstX(MotionEvent motionEvent) {
        return motionEvent.getX(motionEvent.findPointerIndex(this.mFirstFingerId));
    }

    private float getFirstY(MotionEvent motionEvent) {
        return motionEvent.getY(motionEvent.findPointerIndex(this.mFirstFingerId));
    }

    private Point getIntersectOfTwoLines(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (getAngleOfTwoLine(f, f2, f3, f4, f5, f6, f7, f8) <= OOXIXo.f3760XO) {
            return null;
        }
        float f9 = (f * f4) - (f2 * f3);
        float f10 = f5 - f7;
        float f11 = f - f3;
        float f12 = (f5 * f8) - (f7 * f6);
        float f13 = (f9 * f10) - (f11 * f12);
        float f14 = f6 - f8;
        float f15 = (f11 * f14) - ((f2 - f4) * f10);
        float f16 = f13 / f15;
        float f17 = ((f9 * f14) - ((f2 - (-f4)) * f12)) / f15;
        Point point = new Point();
        point.x = f16;
        point.y = f17;
        return point;
    }

    private float getSecondVelX(MotionEvent motionEvent) {
        return (motionEvent.getX(motionEvent.findPointerIndex(this.mSecFingerId)) - this.mSecFingerLastX) / ((float) (motionEvent.getEventTime() - this.mSecFingerLastTimeInMils));
    }

    private float getSecondVelY(MotionEvent motionEvent) {
        return (motionEvent.getY(motionEvent.findPointerIndex(this.mSecFingerId)) - this.mSecFingerLastY) / ((float) (motionEvent.getEventTime() - this.mSecFingerLastTimeInMils));
    }

    private float getSecondX(MotionEvent motionEvent) {
        return motionEvent.getX(motionEvent.findPointerIndex(this.mSecFingerId));
    }

    private float getSecondY(MotionEvent motionEvent) {
        return motionEvent.getY(motionEvent.findPointerIndex(this.mSecFingerId));
    }

    private void init(boolean z, int i, int i2) {
        ConfigChooser configChooser;
        setZOrderMediaOverlay(true);
        if (z) {
            getHolder().setFormat(-3);
        }
        setEGLContextFactory(new ContextFactory());
        if (z) {
            configChooser = new ConfigChooser(8, 8, 8, 8, i, i2);
        } else {
            configChooser = new ConfigChooser(5, 6, 5, 0, i, i2);
        }
        setEGLConfigChooser(configChooser);
        MyRenderer myRenderer = new MyRenderer();
        this.mGlRenderer = myRenderer;
        int i3 = mFrameRate;
        if (i3 != 0) {
            myRenderer.setFrameRate(i3);
        }
        setRenderer(this.mGlRenderer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.npc.BaiduArView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.mGestureDetector = new GestureDetector(getContext(), this.mGestureListener);
        this.mHandler = new MyHandler(this);
    }

    private void sendDelayedClickEvent() {
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            if (this.mLastClickInfo != null) {
                if (!this.mIsDisableClick) {
                    ArBridge arBridge = ArBridge.getInstance();
                    int ordinal = TouchEventType.EClick.ordinal();
                    ClickInfo clickInfo = this.mLastClickInfo;
                    arBridge.onTouchEvent(ordinal, clickInfo.fingerId, clickInfo.x, clickInfo.y, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, clickInfo.time);
                }
                ArBridge.getInstance().onTouchEvent(TouchEventType.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                this.mLastClickInfo = null;
            }
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        ArBridge.getInstance().removeMessageHandeler(this.mMessageHandler);
        Log.d(TAG, "onPause");
        Log.d("callseq", "BaiduArView::pause()");
        ArBridge.getInstance().onPause();
        ArBridge.getInstance().setArView(null);
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        ArBridge.getInstance().registerMessageHandler(11, this.mMessageHandler);
        super.onResume();
        Log.d(TAG, "onResume");
        Log.d("callseq", "BaiduArView::resume()");
        ArBridge.getInstance().setArView(this);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ClickInfo clickInfo;
        float f;
        float f2;
        float f3;
        float f4;
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (!this.mUserInteractionEnabled) {
            return onTouchEvent;
        }
        switch (AnonymousClass6.$SwitchMap$com$baidu$ar$npc$BaiduArView$TouchEventStatus[this.mStatus.ordinal()]) {
            case 1:
                if (motionEvent.getActionMasked() == 0) {
                    String str = TAG;
                    Log.d(str, "touchinv Action Down when EStatSingleFingerCandidate");
                    this.mFirstFingerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.mFirstFingerInitX = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.mFirstFingerInitY = y;
                    this.mFirstFingerLastX = this.mFirstFingerInitX;
                    this.mFirstFingerLastY = y;
                    this.mFirstFingerLastTimeInMils = motionEvent.getEventTime();
                    if (this.mHandler.hasMessages(2) && (clickInfo = this.mLastClickInfo) != null && getDistance(clickInfo.x, clickInfo.y, motionEvent.getX(), motionEvent.getY()) > 20.0d) {
                        sendDelayedClickEvent();
                    }
                    this.mHandler.sendEmptyMessageDelayed(1, 600L);
                    Log.d(str, String.format("touchinv Action Down when EStatSingleFingerCandidate x %1.1f, y %1.1f, time %d id %d", Float.valueOf(this.mFirstFingerInitX), Float.valueOf(this.mFirstFingerInitY), Long.valueOf(this.mFirstFingerLastTimeInMils), Integer.valueOf(this.mFirstFingerId)));
                    break;
                } else if (2 == motionEvent.getActionMasked()) {
                    double distance = getDistance(this.mFirstFingerInitX, this.mFirstFingerInitY, motionEvent.getX(), motionEvent.getY());
                    Log.d(TAG, String.format("touchinv Action Move when EStatSingleFingerCandidate x %1.1f, y %1.1f, distance %1.2f", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Double.valueOf(distance)));
                    if (distance < 20.0d) {
                        if (motionEvent.getEventTime() - motionEvent.getDownTime() > 600) {
                            this.mStatus = TouchEventStatus.EStatLongPresss;
                            if (!this.mIsDisableAll && !this.mIsDisableLongPress) {
                                ArBridge.getInstance().onTouchEvent(TouchEventType.ELongPress.ordinal(), this.mFirstFingerId, motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getDownTime());
                            }
                            this.mHandler.removeMessages(1);
                        }
                    } else if (distance < 80.0d) {
                        this.mIsFirstFingnerInClickArea = false;
                    } else {
                        sendDelayedClickEvent();
                        this.mStatus = TouchEventStatus.EStatScroll;
                        if (!this.mIsDisableAll && !this.mIsDisableScroll) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EScroll.ordinal(), this.mFirstFingerId, motionEvent.getX(), motionEvent.getY(), getFirstVelX(motionEvent), getFirstVelY(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                        }
                        this.mHandler.removeMessages(1);
                    }
                    this.mFirstFingerLastX = motionEvent.getX();
                    this.mFirstFingerLastY = motionEvent.getY();
                    this.mFirstFingerLastTimeInMils = motionEvent.getEventTime();
                    break;
                } else if (1 == motionEvent.getActionMasked()) {
                    if (getDistance(this.mFirstFingerInitX, this.mFirstFingerInitY, motionEvent.getX(), motionEvent.getY()) < 20.0d && motionEvent.getEventTime() - motionEvent.getDownTime() < 300 && !this.mIsDisableAll) {
                        if (this.mIsDisableDoubleClick) {
                            if (!this.mIsDisableClick) {
                                ArBridge.getInstance().onTouchEvent(TouchEventType.EClick.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getDownTime());
                            }
                        } else if (this.mHandler.hasMessages(2)) {
                            this.mHandler.removeMessages(2);
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EDoubleClick.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getDownTime());
                        } else {
                            Message obtain = Message.obtain();
                            obtain.what = 2;
                            ClickInfo clickInfo2 = new ClickInfo();
                            clickInfo2.fingerId = motionEvent.getPointerId(0);
                            clickInfo2.x = motionEvent.getX();
                            clickInfo2.y = motionEvent.getY();
                            clickInfo2.time = motionEvent.getDownTime();
                            obtain.obj = clickInfo2;
                            this.mLastClickInfo = clickInfo2;
                            this.mHandler.sendMessageDelayed(obtain, 400L);
                        }
                    }
                    clearStatus();
                    break;
                } else if (5 == motionEvent.getActionMasked()) {
                    if (this.mIsFirstFingnerInClickArea) {
                        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.mSecFingerId = pointerId;
                        this.mSecFingerInitX = motionEvent.getX(motionEvent.findPointerIndex(pointerId));
                        this.mSecFingerInitY = motionEvent.getY(motionEvent.findPointerIndex(this.mSecFingerId));
                        this.mSecFingerLastTimeInMils = motionEvent.getEventTime();
                        this.mSecFingerLastX = this.mSecFingerInitX;
                        this.mSecFingerLastY = this.mSecFingerInitY;
                        this.mStatus = TouchEventStatus.EStatTwoFingersCandidate;
                    } else {
                        this.mStatus = TouchEventStatus.EStatUnknown;
                    }
                    sendDelayedClickEvent();
                    break;
                }
                break;
            case 2:
                if (5 == motionEvent.getActionMasked()) {
                    this.mStatus = TouchEventStatus.EStatUnknown;
                    break;
                } else if (6 == motionEvent.getActionMasked()) {
                    this.mStatus = TouchEventStatus.EStatUnknown;
                    break;
                } else if (2 == motionEvent.getActionMasked()) {
                    float firstX = getFirstX(motionEvent);
                    float firstY = getFirstY(motionEvent);
                    float secondX = getSecondX(motionEvent);
                    float secondY = getSecondY(motionEvent);
                    double distance2 = getDistance(this.mFirstFingerInitX, this.mFirstFingerInitY, firstX, firstY);
                    double distance3 = getDistance(this.mSecFingerInitX, this.mSecFingerInitY, secondX, secondY);
                    if ((distance2 > 80.0d || distance3 > 80.0d) && distance2 > 20.0d && distance3 > 20.0d) {
                        f = secondY;
                        double angleOfTwoLine = getAngleOfTwoLine(this.mFirstFingerInitX, this.mFirstFingerInitY, firstX, firstY, this.mSecFingerInitX, this.mSecFingerInitY, secondX, f);
                        Log.d("touchopt", String.format("the angle is %1.3f", Double.valueOf(angleOfTwoLine)));
                        if (angleOfTwoLine < TWO_FINGER_SCROLL_ANGLE) {
                            this.mStatus = TouchEventStatus.EStatTwoFingersScroll;
                            if (this.mIsDisableAll || this.mIsDisableTwoFingerScroll) {
                                f2 = firstY;
                                f3 = firstX;
                            } else {
                                f2 = firstY;
                                f3 = firstX;
                                ArBridge.getInstance().onTouchEvent(TouchEventType.ETwoFingerScroll.ordinal(), this.mFirstFingerId, f3, f2, getFirstVelX(motionEvent), getFirstVelY(motionEvent), this.mSecFingerId, secondX, f, getSecondVelX(motionEvent), getSecondVelY(motionEvent), motionEvent.getEventTime());
                                Log.d("touchopt", "EStatTwoFingersScroll");
                            }
                            f4 = secondX;
                        } else {
                            f2 = firstY;
                            f3 = firstX;
                            this.mStatus = TouchEventStatus.EStatPinchAndUnpinch;
                            f4 = secondX;
                            this.mLastDistance = getDistance(f3, f2, f4, f);
                        }
                    } else {
                        f = secondY;
                        f4 = secondX;
                        f2 = firstY;
                        f3 = firstX;
                    }
                    this.mFirstFingerLastX = f3;
                    this.mFirstFingerLastY = f2;
                    this.mFirstFingerLastTimeInMils = motionEvent.getEventTime();
                    this.mSecFingerLastX = f4;
                    this.mSecFingerLastY = f;
                    this.mSecFingerLastTimeInMils = motionEvent.getEventTime();
                    break;
                } else {
                    this.mStatus = TouchEventStatus.EStatUnknown;
                    break;
                }
                break;
            case 3:
                if (5 == motionEvent.getActionMasked()) {
                    this.mStatus = TouchEventStatus.EStatUnknown;
                    break;
                } else if (6 == motionEvent.getActionMasked()) {
                    this.mStatus = TouchEventStatus.EStatUnknown;
                    break;
                } else if (1 == motionEvent.getActionMasked()) {
                    clearStatus();
                    break;
                } else if (2 != motionEvent.getActionMasked()) {
                    this.mStatus = TouchEventStatus.EStatUnknown;
                    break;
                } else if (motionEvent.getEventTime() - this.mFirstFingerLastTimeInMils >= 1) {
                    float firstX2 = getFirstX(motionEvent);
                    float firstY2 = getFirstY(motionEvent);
                    if (!this.mIsDisableAll && !this.mIsDisableScroll) {
                        ArBridge.getInstance().onTouchEvent(TouchEventType.EScroll.ordinal(), this.mFirstFingerId, firstX2, firstY2, getFirstVelX(motionEvent), getFirstVelY(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                    }
                    this.mFirstFingerLastX = firstX2;
                    this.mFirstFingerLastY = firstY2;
                    this.mFirstFingerLastTimeInMils = motionEvent.getEventTime();
                    break;
                }
                break;
            case 4:
                if (5 == motionEvent.getActionMasked()) {
                    this.mStatus = TouchEventStatus.EStatUnknown;
                    break;
                } else if (6 == motionEvent.getActionMasked()) {
                    this.mStatus = TouchEventStatus.EStatUnknown;
                    break;
                } else if (2 != motionEvent.getActionMasked()) {
                    this.mStatus = TouchEventStatus.EStatUnknown;
                    break;
                } else if (motionEvent.getEventTime() - this.mFirstFingerLastTimeInMils >= 1 && motionEvent.getEventTime() - this.mSecFingerLastTimeInMils >= 1) {
                    float firstX3 = getFirstX(motionEvent);
                    float firstY3 = getFirstY(motionEvent);
                    float secondX2 = getSecondX(motionEvent);
                    float secondY2 = getSecondY(motionEvent);
                    if (!this.mIsDisableAll && !this.mIsDisableTwoFingerScroll) {
                        ArBridge.getInstance().onTouchEvent(TouchEventType.ETwoFingerScroll.ordinal(), this.mFirstFingerId, firstX3, firstY3, getFirstVelX(motionEvent), getFirstVelY(motionEvent), this.mSecFingerId, secondX2, secondY2, getSecondVelX(motionEvent), getSecondVelY(motionEvent), motionEvent.getEventTime());
                    }
                    this.mFirstFingerLastX = firstX3;
                    this.mFirstFingerLastY = firstY3;
                    this.mFirstFingerLastTimeInMils = motionEvent.getEventTime();
                    this.mSecFingerLastX = secondX2;
                    this.mSecFingerLastY = secondY2;
                    this.mSecFingerLastTimeInMils = motionEvent.getEventTime();
                    break;
                }
                break;
            case 5:
                if (5 == motionEvent.getActionMasked()) {
                    this.mStatus = TouchEventStatus.EStatUnknown;
                    break;
                } else if (6 == motionEvent.getActionMasked()) {
                    this.mStatus = TouchEventStatus.EStatUnknown;
                    break;
                } else if (2 != motionEvent.getActionMasked()) {
                    this.mStatus = TouchEventStatus.EStatUnknown;
                    break;
                } else if (motionEvent.getEventTime() - this.mFirstFingerLastTimeInMils >= 1 && motionEvent.getEventTime() - this.mSecFingerLastTimeInMils >= 1) {
                    float firstX4 = getFirstX(motionEvent);
                    float firstY4 = getFirstY(motionEvent);
                    float secondX3 = getSecondX(motionEvent);
                    float secondY3 = getSecondY(motionEvent);
                    double distance4 = getDistance(firstX4, firstY4, secondX3, secondY3);
                    if (distance4 > this.mLastDistance) {
                        if (!this.mIsDisableAll && !this.mIsDisablePinch) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EUnPinch.ordinal(), this.mFirstFingerId, firstX4, firstY4, getFirstVelX(motionEvent), getFirstVelY(motionEvent), this.mSecFingerId, secondX3, secondY3, getSecondVelX(motionEvent), getSecondVelY(motionEvent), motionEvent.getEventTime());
                        }
                    } else if (!this.mIsDisableAll && !this.mIsDisablePinch) {
                        ArBridge.getInstance().onTouchEvent(TouchEventType.EPinch.ordinal(), this.mFirstFingerId, firstX4, firstY4, getFirstVelX(motionEvent), getFirstVelY(motionEvent), this.mSecFingerId, secondX3, secondY3, getSecondVelX(motionEvent), getSecondVelY(motionEvent), motionEvent.getEventTime());
                    }
                    this.mLastDistance = distance4;
                    this.mFirstFingerLastX = firstX4;
                    this.mFirstFingerLastY = firstY4;
                    this.mFirstFingerLastTimeInMils = motionEvent.getEventTime();
                    this.mSecFingerLastX = secondX3;
                    this.mSecFingerLastY = secondY3;
                    this.mSecFingerLastTimeInMils = motionEvent.getEventTime();
                    break;
                }
                break;
            case 6:
                if (2 != motionEvent.getActionMasked()) {
                    if (1 == motionEvent.getActionMasked()) {
                        clearStatus();
                        break;
                    } else {
                        this.mStatus = TouchEventStatus.EStatUnknown;
                        break;
                    }
                } else if (getDistance(this.mFirstFingerInitX, this.mFirstFingerInitY, motionEvent.getX(), motionEvent.getY()) > 80.0d) {
                    this.mStatus = TouchEventStatus.EScrollAfterLongPress;
                    if (!this.mIsDisableAll && !this.mIsDisableScroll) {
                        ArBridge.getInstance().onTouchEvent(TouchEventType.EScrollAfterLongPress.ordinal(), this.mFirstFingerId, motionEvent.getX(), motionEvent.getY(), getFirstVelX(motionEvent), getFirstVelY(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                    }
                    this.mFirstFingerLastX = getFirstX(motionEvent);
                    this.mFirstFingerLastY = getFirstY(motionEvent);
                    this.mFirstFingerLastTimeInMils = motionEvent.getEventTime();
                    break;
                }
                break;
            case 7:
                if (2 == motionEvent.getActionMasked()) {
                    if (!this.mIsDisableAll && !this.mIsDisableScroll) {
                        ArBridge.getInstance().onTouchEvent(TouchEventType.EScrollAfterLongPress.ordinal(), this.mFirstFingerId, motionEvent.getX(), motionEvent.getY(), getFirstVelX(motionEvent), getFirstVelY(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                    }
                    this.mFirstFingerLastX = getFirstX(motionEvent);
                    this.mFirstFingerLastY = getFirstY(motionEvent);
                    this.mFirstFingerLastTimeInMils = motionEvent.getEventTime();
                    break;
                } else if (1 == motionEvent.getActionMasked()) {
                    clearStatus();
                    break;
                } else {
                    this.mStatus = TouchEventStatus.EStatUnknown;
                    break;
                }
                break;
            case 8:
            case 9:
            case 10:
                if (1 == motionEvent.getActionMasked()) {
                    clearStatus();
                    break;
                }
                break;
        }
        return onTouchEvent;
    }

    public void setFrameRate(int i) {
        mFrameRate = i;
        MyRenderer myRenderer = this.mGlRenderer;
        if (myRenderer != null) {
            myRenderer.setFrameRate(i);
        }
    }

    public void setUserInteractionEnabled(boolean z) {
        this.mUserInteractionEnabled = z;
    }

    public void startRecord(final ARRecorder aRRecorder) {
        queueEvent(new Runnable() { // from class: com.baidu.ar.npc.BaiduArView.1
            @Override // java.lang.Runnable
            public void run() {
                BaiduArView.this.mGlRenderer.setRecorder(aRRecorder);
            }
        });
    }

    public void stopRecord() {
        queueEvent(new Runnable() { // from class: com.baidu.ar.npc.BaiduArView.2
            @Override // java.lang.Runnable
            public void run() {
                BaiduArView.this.mGlRenderer.setRecorder(null);
            }
        });
    }

    public void takeSnapshot(ARPictureCallback aRPictureCallback) {
        MyRenderer myRenderer = this.mGlRenderer;
        if (myRenderer != null) {
            myRenderer.takePicture(aRPictureCallback);
        }
    }

    /* loaded from: classes7.dex */
    public static class ConfigChooser implements GLSurfaceView.EGLConfigChooser {
        private static int EGL_OPENGL_ES2_BIT = 4;
        private static int[] s_configAttribs2 = {12324, 4, 12323, 4, 12322, 4, 12352, 4, 12338, 1, 12337, 4, 12344};
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue)) {
                return this.mValue[0];
            }
            return i2;
        }

        private void printConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336};
            String[] strArr = {"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
            int[] iArr2 = new int[1];
            for (int i = 0; i < 17; i++) {
                int i2 = iArr[i];
                String str = strArr[i];
                if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, iArr2)) {
                    Log.w(BaiduArView.TAG, String.format("  %s: %d\n", str, Integer.valueOf(iArr2[0])));
                }
                do {
                } while (egl10.eglGetError() != 12288);
            }
        }

        private void printConfigs(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            int length = eGLConfigArr.length;
            Log.e(BaiduArView.TAG, String.format("%d configurations", Integer.valueOf(length)));
            for (int i = 0; i < length; i++) {
                Log.e(BaiduArView.TAG, String.format("Configuration %d:\n", Integer.valueOf(i)));
                printConfig(egl10, eGLDisplay, eGLConfigArr[i]);
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            Log.w("callseq", "chooseConfig called");
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, s_configAttribs2, null, 0, iArr);
            int i = iArr[0];
            if (i <= 0) {
                int[] iArr2 = s_configAttribs2;
                iArr2[11] = 2;
                egl10.eglChooseConfig(eGLDisplay, iArr2, null, 0, iArr);
                i = iArr[0];
                if (i <= 0) {
                    int[] iArr3 = s_configAttribs2;
                    iArr3[8] = 12344;
                    egl10.eglChooseConfig(eGLDisplay, iArr3, null, 0, iArr);
                    i = iArr[0];
                }
            }
            int i2 = i;
            if (i2 > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i2];
                egl10.eglChooseConfig(eGLDisplay, s_configAttribs2, eGLConfigArr, i2, iArr);
                if (BaiduArView.DEBUG) {
                    printConfigs(egl10, eGLDisplay, eGLConfigArr);
                }
                return chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            }
            throw new IllegalArgumentException("No configs match configSpec");
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize && findConfigAttrib >= this.mDepthSize) {
                        Log.d(BaiduArView.TAG, "get the config");
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    public BaiduArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatus = TouchEventStatus.EStatSingleFingerCandidate;
        this.mIsFirstFingnerInClickArea = true;
        this.mFirstFingerId = -1;
        this.mFirstFingerInitX = -1.0f;
        this.mFirstFingerInitY = -1.0f;
        this.mFirstFingerLastX = -1.0f;
        this.mFirstFingerLastY = -1.0f;
        this.mFirstFingerLastTimeInMils = -1L;
        this.mSecFingerId = -1;
        this.mSecFingerInitX = -1.0f;
        this.mSecFingerInitY = -1.0f;
        this.mSecFingerLastX = -1.0f;
        this.mSecFingerLastY = -1.0f;
        this.mSecFingerLastTimeInMils = -1L;
        this.mLastDistance = -1.0d;
        this.mGlRenderer = null;
        this.mIsDisableAll = false;
        this.mIsDisablePinch = true;
        this.mIsDisableClick = false;
        this.mIsDisableDoubleClick = false;
        this.mIsDisableScroll = true;
        this.mIsDisableTwoFingerScroll = true;
        this.mIsDisableLongPress = true;
        this.mUserInteractionEnabled = true;
        this.mLastClickInfo = null;
        this.mNeedDestroy = false;
        this.mUpdating = false;
        this.mMessageHandler = new ArBridge.MessageHandler() { // from class: com.baidu.ar.npc.BaiduArView.4
            @Override // com.baidu.ar.npc.ArBridge.MessageHandler
            public void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get("disable_all") != null) {
                        if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                            BaiduArView.this.mIsDisableAll = true;
                        } else {
                            BaiduArView.this.mIsDisableAll = false;
                        }
                    }
                    if (hashMap.get("disable_pinch") != null) {
                        if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                            BaiduArView.this.mIsDisablePinch = true;
                        } else {
                            BaiduArView.this.mIsDisablePinch = false;
                        }
                    }
                    if (hashMap.get("disable_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                            BaiduArView.this.mIsDisableClick = true;
                        } else {
                            BaiduArView.this.mIsDisableClick = false;
                        }
                    }
                    if (hashMap.get("disable_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                            BaiduArView.this.mIsDisableScroll = true;
                        } else {
                            BaiduArView.this.mIsDisableScroll = false;
                        }
                    }
                    if (hashMap.get("disable_long_press") != null) {
                        if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                            BaiduArView.this.mIsDisableLongPress = true;
                        } else {
                            BaiduArView.this.mIsDisableLongPress = false;
                        }
                    }
                    if (hashMap.get("disable_double_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                            BaiduArView.this.mIsDisableDoubleClick = true;
                        } else {
                            BaiduArView.this.mIsDisableDoubleClick = false;
                        }
                    }
                    if (hashMap.get("disable_two_finger_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                            BaiduArView.this.mIsDisableTwoFingerScroll = true;
                        } else {
                            BaiduArView.this.mIsDisableTwoFingerScroll = false;
                        }
                    }
                }
            }
        };
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.baidu.ar.npc.BaiduArView.5
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(final MotionEvent motionEvent) {
                BaiduArView.this.queueEvent(new Runnable() { // from class: com.baidu.ar.npc.BaiduArView.5.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.d(BaiduArView.TAG, "touch onLongPress " + motionEvent);
                        long timeInMillis = Calendar.getInstance().getTimeInMillis();
                        if (!BaiduArView.this.mIsDisableAll && !BaiduArView.this.mIsDisableLongPress) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.ELongPress.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
                        }
                    }
                });
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float f, final float f2) {
                BaiduArView.this.queueEvent(new Runnable() { // from class: com.baidu.ar.npc.BaiduArView.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.d(BaiduArView.TAG, String.format("touch onScroll begin motionevent %s and end motion event %s and speed %1.2f, %1.2f ", motionEvent.toString(), motionEvent2.toString(), Float.valueOf(f), Float.valueOf(f2)));
                        long timeInMillis = Calendar.getInstance().getTimeInMillis();
                        if (!BaiduArView.this.mIsDisableAll && BaiduArView.this.mIsDisableScroll) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EScroll.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, motionEvent2.getPointerId(0), motionEvent2.getX(), motionEvent2.getY(), f, f2, timeInMillis);
                        }
                    }
                });
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(final MotionEvent motionEvent) {
                BaiduArView.this.queueEvent(new Runnable() { // from class: com.baidu.ar.npc.BaiduArView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.d(BaiduArView.TAG, "touch on single tap with motionEvnet " + motionEvent);
                        long timeInMillis = Calendar.getInstance().getTimeInMillis();
                        Log.d(BaiduArView.TAG, "touch timeInMils " + timeInMillis);
                        if (!BaiduArView.this.mIsDisableAll && !BaiduArView.this.mIsDisableClick) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EClick.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
                        }
                    }
                });
                return false;
            }
        };
        init(true, 16, 0);
    }

    public BaiduArView(Context context, boolean z, int i, int i2) {
        super(context);
        this.mStatus = TouchEventStatus.EStatSingleFingerCandidate;
        this.mIsFirstFingnerInClickArea = true;
        this.mFirstFingerId = -1;
        this.mFirstFingerInitX = -1.0f;
        this.mFirstFingerInitY = -1.0f;
        this.mFirstFingerLastX = -1.0f;
        this.mFirstFingerLastY = -1.0f;
        this.mFirstFingerLastTimeInMils = -1L;
        this.mSecFingerId = -1;
        this.mSecFingerInitX = -1.0f;
        this.mSecFingerInitY = -1.0f;
        this.mSecFingerLastX = -1.0f;
        this.mSecFingerLastY = -1.0f;
        this.mSecFingerLastTimeInMils = -1L;
        this.mLastDistance = -1.0d;
        this.mGlRenderer = null;
        this.mIsDisableAll = false;
        this.mIsDisablePinch = true;
        this.mIsDisableClick = false;
        this.mIsDisableDoubleClick = false;
        this.mIsDisableScroll = true;
        this.mIsDisableTwoFingerScroll = true;
        this.mIsDisableLongPress = true;
        this.mUserInteractionEnabled = true;
        this.mLastClickInfo = null;
        this.mNeedDestroy = false;
        this.mUpdating = false;
        this.mMessageHandler = new ArBridge.MessageHandler() { // from class: com.baidu.ar.npc.BaiduArView.4
            @Override // com.baidu.ar.npc.ArBridge.MessageHandler
            public void handleMessage(int i3, int i22, HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get("disable_all") != null) {
                        if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                            BaiduArView.this.mIsDisableAll = true;
                        } else {
                            BaiduArView.this.mIsDisableAll = false;
                        }
                    }
                    if (hashMap.get("disable_pinch") != null) {
                        if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                            BaiduArView.this.mIsDisablePinch = true;
                        } else {
                            BaiduArView.this.mIsDisablePinch = false;
                        }
                    }
                    if (hashMap.get("disable_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                            BaiduArView.this.mIsDisableClick = true;
                        } else {
                            BaiduArView.this.mIsDisableClick = false;
                        }
                    }
                    if (hashMap.get("disable_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                            BaiduArView.this.mIsDisableScroll = true;
                        } else {
                            BaiduArView.this.mIsDisableScroll = false;
                        }
                    }
                    if (hashMap.get("disable_long_press") != null) {
                        if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                            BaiduArView.this.mIsDisableLongPress = true;
                        } else {
                            BaiduArView.this.mIsDisableLongPress = false;
                        }
                    }
                    if (hashMap.get("disable_double_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                            BaiduArView.this.mIsDisableDoubleClick = true;
                        } else {
                            BaiduArView.this.mIsDisableDoubleClick = false;
                        }
                    }
                    if (hashMap.get("disable_two_finger_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                            BaiduArView.this.mIsDisableTwoFingerScroll = true;
                        } else {
                            BaiduArView.this.mIsDisableTwoFingerScroll = false;
                        }
                    }
                }
            }
        };
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.baidu.ar.npc.BaiduArView.5
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(final MotionEvent motionEvent) {
                BaiduArView.this.queueEvent(new Runnable() { // from class: com.baidu.ar.npc.BaiduArView.5.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.d(BaiduArView.TAG, "touch onLongPress " + motionEvent);
                        long timeInMillis = Calendar.getInstance().getTimeInMillis();
                        if (!BaiduArView.this.mIsDisableAll && !BaiduArView.this.mIsDisableLongPress) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.ELongPress.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
                        }
                    }
                });
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float f, final float f2) {
                BaiduArView.this.queueEvent(new Runnable() { // from class: com.baidu.ar.npc.BaiduArView.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.d(BaiduArView.TAG, String.format("touch onScroll begin motionevent %s and end motion event %s and speed %1.2f, %1.2f ", motionEvent.toString(), motionEvent2.toString(), Float.valueOf(f), Float.valueOf(f2)));
                        long timeInMillis = Calendar.getInstance().getTimeInMillis();
                        if (!BaiduArView.this.mIsDisableAll && BaiduArView.this.mIsDisableScroll) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EScroll.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, motionEvent2.getPointerId(0), motionEvent2.getX(), motionEvent2.getY(), f, f2, timeInMillis);
                        }
                    }
                });
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(final MotionEvent motionEvent) {
                BaiduArView.this.queueEvent(new Runnable() { // from class: com.baidu.ar.npc.BaiduArView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.d(BaiduArView.TAG, "touch on single tap with motionEvnet " + motionEvent);
                        long timeInMillis = Calendar.getInstance().getTimeInMillis();
                        Log.d(BaiduArView.TAG, "touch timeInMils " + timeInMillis);
                        if (!BaiduArView.this.mIsDisableAll && !BaiduArView.this.mIsDisableClick) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EClick.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
                        }
                    }
                });
                return false;
            }
        };
        init(z, i, i2);
    }
}
