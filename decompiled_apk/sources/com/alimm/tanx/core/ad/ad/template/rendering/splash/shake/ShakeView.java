package com.alimm.tanx.core.ad.ad.template.rendering.splash.shake;

import XIXIX.OOXIXo;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ut.bean.UtSensor;
import com.alimm.tanx.core.ut.core.LifeCycleManager;
import com.alimm.tanx.core.utils.DimenUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ShakeView extends View implements SensorEventListener, IShakeView, NotConfused {
    private static final long ROTATE_ANIM_INTERVAL_TIME = 333;
    private static final long ROTATE_ANIM_TIME = 1000;
    private static final String TAG = "ShakeView";
    public final int GESTURE_INTERACTION_END_CLICK;
    public final int GESTURE_INTERACTION_END_FAIL;
    public final int GESTURE_INTERACTION_END_SUCCESS;
    public final int GESTURE_INTERACTION_START;
    public final int MAX_SHAKE_THRESHOLD;
    public final int MIN_SHAKE_THRESHOLD;
    int count;
    private volatile boolean isShake;

    @Nullable
    private InteractiveCallback mCallBack;

    @NonNull
    @Nullable
    private Rect mCircleImgRect;
    private int mCircleLength;
    private Context mContext;
    private int mImagePadding;
    private float[] mLastMatchedSensorValues;
    private long mLastSenorCheckTime;
    private float[] mLastSensorValues;
    private long mLastShakeTime;
    private long mLastTimeShake;
    private float mNowShakeDegree;
    private int mNowVisibility;

    @NonNull
    private Paint mPaint;
    private int[] mPhoneImgSize;

    @NonNull
    private Rect mRealShakeImgRect;
    private ValueAnimator.AnimatorUpdateListener mRotateAnimListener;

    @Nullable
    private ValueAnimator mRotateAnimation;
    Sensor mSenAccelerometer;

    @Nullable
    private SensorManager mSenSensorManager;

    @Nullable
    private Bitmap mShakeBitMap;
    private int mShakeCnt;

    @NonNull
    private Rect mShakeImgRect;
    private int mShakeViewHeight;
    private String mShowText1;
    private String mShowText2;
    private int mShowTextColor1;
    private int mShowTextColor2;
    private float mShowTextHeight1;
    private float mShowTextHeight2;
    private Rect mShowTextRect1;
    private Rect mShowTextRect2;
    private float mShowTextSize1;
    private float mShowTextSize2;
    private int mTextPadding;

    @NonNull
    private Paint mTextPaint;
    private List<UtSensor> sensorList;
    private ShakeBean shakeBean;

    public ShakeView(@NonNull Context context, ShakeBean shakeBean) {
        super(context);
        this.isShake = false;
        this.mLastTimeShake = 0L;
        this.mSenAccelerometer = null;
        this.GESTURE_INTERACTION_START = -1;
        this.GESTURE_INTERACTION_END_CLICK = 0;
        this.GESTURE_INTERACTION_END_SUCCESS = 1;
        this.GESTURE_INTERACTION_END_FAIL = 2;
        this.MIN_SHAKE_THRESHOLD = 1;
        this.MAX_SHAKE_THRESHOLD = 50;
        this.sensorList = Collections.synchronizedList(new ArrayList());
        this.count = 0;
        init(context, shakeBean);
    }

    private void drawText(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull String str, @NonNull Rect rect, float f, int i, boolean z) {
        if (z) {
            paint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            paint.setTypeface(Typeface.DEFAULT);
        }
        paint.setTextSize(f);
        paint.setColor(i);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = fontMetrics.bottom;
        canvas.drawText(str, rect.centerX(), rect.centerY() + (((f2 - fontMetrics.top) / 2.0f) - f2), paint);
    }

    private double getShakeIntensity(float[] fArr, float[] fArr2) {
        if (fArr != null && fArr2 != null && fArr.length >= 2 && fArr2.length >= 2) {
            return Math.sqrt(Math.pow(fArr[0] - fArr2[0], 2.0d) + Math.pow(fArr[1] - fArr2[1], 2.0d));
        }
        return OOXIXo.f3760XO;
    }

    private void init(Context context, ShakeBean shakeBean) {
        this.mContext = context;
        if (shakeBean != null) {
            this.shakeBean = shakeBean;
        } else {
            this.shakeBean = new ShakeBean().build(null);
        }
        LogUtils.d(TAG, "摇一摇参数：" + shakeBean.toString());
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.mSenSensorManager = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(10);
        this.mSenAccelerometer = defaultSensor;
        this.mSenSensorManager.registerListener(this, defaultSensor, 2);
        this.mShakeBitMap = BitmapFactory.decodeResource(context.getResources(), R.drawable.tanx_shake_phone);
        this.mCircleLength = DimenUtil.dp2px(context, 112.0f);
        this.mShakeViewHeight = DimenUtil.dp2px(context, 220.0f);
        this.mPhoneImgSize = new int[]{DimenUtil.dp2px(context, 79.0f), DimenUtil.dp2px(context, 71.0f)};
        this.mShowTextSize1 = DimenUtil.dp2px(context, 20.0f);
        this.mShowTextHeight1 = DimenUtil.dp2px(context, 2.0f);
        this.mPaint = new Paint();
        this.mShakeImgRect = new Rect();
        this.mRealShakeImgRect = new Rect();
        this.mCircleImgRect = new Rect();
        this.mShowTextRect1 = new Rect();
        this.mShowTextRect2 = new Rect();
        Paint paint = this.mPaint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.mPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mTextPaint = paint2;
        paint2.setStyle(style);
        this.mTextPaint.setAntiAlias(true);
        if (TextUtils.isEmpty(this.mShowText1)) {
            this.mShowText1 = "摇一摇";
        }
        this.mShowText2 = "互动跳转详情页面或第三方应用";
        this.mShowTextColor1 = Color.parseColor("#ffffff");
        this.mShowTextColor2 = Color.parseColor("#ffffff");
        startAnimation();
        LifeCycleManager.getInstance().register(TAG, new LifeCycleManager.AppVisibleCallBack() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView.1
            @Override // com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack
            public void appVisibleCallBack(boolean z, boolean z2) {
                String str;
                StringBuilder sb = new StringBuilder();
                sb.append("当前前后台状态：->");
                if (z) {
                    str = "后台";
                } else {
                    str = "前台";
                }
                sb.append(str);
                sb.append(",是否由后台切换到前台：");
                sb.append(z2);
                LogUtils.d(ShakeView.TAG, sb.toString());
                if (z) {
                    ShakeView.this.pauseShake();
                }
                if (z2 && ShakeView.this.mContext != null) {
                    ShakeView shakeView = ShakeView.this;
                    shakeView.startShake(shakeView.mContext);
                }
            }
        });
    }

    private boolean isShakeDirectionOpposite(float[] fArr, float[] fArr2) {
        if (fArr == null || fArr2 == null || fArr.length < 2 || fArr2.length < 2 || (fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]) >= 0.0f) {
            return false;
        }
        return true;
    }

    private void onLinerAccSenorChanged(SensorEvent sensorEvent) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.mLastSenorCheckTime < this.shakeBean.getShakeSensorCheckInterval()) {
            return;
        }
        onLinerAccSenorChangedInner(sensorEvent, elapsedRealtime);
        float[] fArr = sensorEvent.values;
        if (fArr != null) {
            this.mLastSensorValues = Arrays.copyOf(fArr, fArr.length);
        }
        this.mLastSenorCheckTime = elapsedRealtime;
    }

    private void onLinerAccSenorChangedInner(SensorEvent sensorEvent, long j) {
        if (getShakeIntensity(sensorEvent.values, this.mLastSensorValues) < this.shakeBean.getShakeSplash()) {
            return;
        }
        if (j - this.mLastShakeTime > this.shakeBean.getShakeSensorShakeInterval()) {
            this.mShakeCnt = 1;
            this.mLastShakeTime = j;
        } else if (!isShakeDirectionOpposite(sensorEvent.values, this.mLastMatchedSensorValues)) {
            return;
        } else {
            this.mShakeCnt++;
        }
        float[] fArr = sensorEvent.values;
        if (fArr != null) {
            this.mLastMatchedSensorValues = Arrays.copyOf(fArr, fArr.length);
        }
        if (this.mShakeCnt >= this.shakeBean.getShakeCount()) {
            this.mShakeCnt = 0;
            this.mLastShakeTime = j;
            onShake();
        }
    }

    private void onShake() {
        InteractiveCallback interactiveCallback;
        long currentTimeMillis = System.currentTimeMillis();
        if (getVisibility() == 0 && (interactiveCallback = this.mCallBack) != null && currentTimeMillis - this.mLastTimeShake > 1000) {
            this.mLastTimeShake = currentTimeMillis;
            interactiveCallback.onShake();
            this.isShake = true;
        }
    }

    private void startAnimation() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 15.0f, -5.0f, 15.0f, -5.0f, 10.0f, -5.0f);
        this.mRotateAnimation = ofFloat;
        ofFloat.setDuration(1000L);
        this.mRotateAnimation.setStartDelay(ROTATE_ANIM_INTERVAL_TIME);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setRepeatMode(1);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShakeView.this.mNowShakeDegree = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ShakeView.this.postInvalidate();
            }
        };
        this.mRotateAnimListener = animatorUpdateListener;
        this.mRotateAnimation.addUpdateListener(animatorUpdateListener);
    }

    private void startShakeAnim() {
        ValueAnimator valueAnimator = this.mRotateAnimation;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void addSensorList(float f, float f2, float f3) {
        try {
            if (this.sensorList == null) {
                this.sensorList = Collections.synchronizedList(new ArrayList());
            }
            if (this.sensorList.size() < 10) {
                this.sensorList.add(new UtSensor(f, f2, f3));
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.IShakeView
    public void load(@NonNull InteractiveCallback interactiveCallback, boolean z) {
        this.mCallBack = interactiveCallback;
        if (z) {
            this.mShakeViewHeight = DimenUtil.dp2px(getContext(), 190.0f);
        } else {
            this.mShakeViewHeight = DimenUtil.dp2px(getContext(), 160.0f);
        }
        setMeasuredDimension(getMeasuredWidth(), this.mShakeViewHeight);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startShakeAnim();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InteractiveCallback interactiveCallback = this.mCallBack;
        if (interactiveCallback != null) {
            List<UtSensor> list = this.sensorList;
            if (list != null) {
                interactiveCallback.destroy(JSON.toJSONString(list));
            } else {
                interactiveCallback.destroy("");
            }
        }
        LogUtils.d(TAG, "onDetachedFromWindow");
        recycle();
        LifeCycleManager.getInstance().unRegister(TAG);
        LogUtils.d(TAG, "onDetachedFromWindow");
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            Bitmap bitmap = this.mShakeBitMap;
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.save();
                canvas.translate(this.mShakeImgRect.centerX(), this.mShakeImgRect.centerY());
                canvas.rotate(this.mNowShakeDegree);
                canvas.drawBitmap(this.mShakeBitMap, (Rect) null, this.mRealShakeImgRect, this.mPaint);
                canvas.restore();
            }
            this.mTextPaint.setTextAlign(Paint.Align.CENTER);
            this.mTextPaint.setShadowLayer(3.0f, 2.0f, 2.0f, 1711276032);
            drawText(canvas, this.mTextPaint, this.mShowText1, this.mShowTextRect1, this.mShowTextSize1, this.mShowTextColor1, true);
        } catch (Exception e) {
            LogUtils.e(TAG, e);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int dp2px = DimenUtil.dp2px(getContext(), 10.0f);
        Rect rect = this.mCircleImgRect;
        if (rect != null) {
            int i3 = measuredWidth / 2;
            int i4 = this.mCircleLength;
            rect.set(i3 - (i4 / 2), dp2px, i3 + (i4 / 2), i4 + dp2px);
        }
        int i5 = this.mCircleLength / 2;
        int[] iArr = this.mPhoneImgSize;
        int i6 = iArr[1];
        int i7 = dp2px + (i5 - (i6 / 2));
        Rect rect2 = this.mShakeImgRect;
        if (rect2 != null) {
            int i8 = measuredWidth / 2;
            int i9 = iArr[0];
            rect2.set(i8 - (i9 / 2), i7, i8 + (i9 / 2), i6 + i7);
        }
        Rect rect3 = this.mRealShakeImgRect;
        if (rect3 != null) {
            int[] iArr2 = this.mPhoneImgSize;
            int i10 = iArr2[0];
            int i11 = iArr2[1];
            rect3.set((-i10) / 2, (-i11) / 2, i10 / 2, i11 / 2);
        }
        int dp2px2 = DimenUtil.dp2px(getContext(), 10.0f) + this.mCircleLength + this.mImagePadding;
        this.mShowTextRect1.set(getPaddingLeft(), dp2px2, measuredWidth - getPaddingRight(), ((int) this.mShowTextHeight1) + dp2px2);
        setMeasuredDimension(i, this.mShakeViewHeight);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if (this.mNowVisibility == 0 && sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            addSensorList(fArr[0], fArr[1], fArr[2]);
            if (((float) Math.sqrt((r2 * r2) + (r1 * r1) + (r0 * r0))) >= this.shakeBean.getShakeSplash()) {
                onShake();
            }
        }
        Sensor sensor2 = this.mSenAccelerometer;
        if (sensor2 != null && sensor2.getType() == 10) {
            onLinerAccSenorChanged(sensorEvent);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        this.mNowVisibility = i;
    }

    public void pauseShake() {
        SensorManager sensorManager = this.mSenSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        ValueAnimator valueAnimator = this.mRotateAnimation;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    public void recycle() {
        SensorManager sensorManager = this.mSenSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.mSenSensorManager = null;
        }
        ValueAnimator valueAnimator = this.mRotateAnimation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.mRotateAnimListener;
            if (animatorUpdateListener != null) {
                this.mRotateAnimation.removeUpdateListener(animatorUpdateListener);
            }
            this.mRotateAnimation = null;
        }
        Bitmap bitmap = this.mShakeBitMap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mShakeBitMap = null;
        }
    }

    public void setImagePadding(int i) {
        if (getContext() != null) {
            this.mImagePadding = DimenUtil.dp2px(getContext(), i);
        }
    }

    public void setMessageTextSize(float f) {
        if (getContext() != null && f > 0.0f) {
            this.mShowTextSize2 = DimenUtil.dp2px(getContext(), f);
        }
    }

    public void setTextPadding(int i) {
        if (getContext() != null) {
            this.mTextPadding = DimenUtil.dp2px(getContext(), i);
        }
    }

    public void setTitleTextSize(float f) {
        this.mShowTextSize1 = f;
    }

    public void startShake(Context context) {
        try {
            if (this.mSenSensorManager == null) {
                this.mSenSensorManager = (SensorManager) context.getSystemService("sensor");
            }
            Sensor defaultSensor = this.mSenSensorManager.getDefaultSensor(10);
            this.mSenAccelerometer = defaultSensor;
            this.mSenSensorManager.registerListener(this, defaultSensor, 2);
            ValueAnimator valueAnimator = this.mRotateAnimation;
            if (valueAnimator != null) {
                valueAnimator.resume();
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }

    public ShakeView(@NonNull Context context, String str, ShakeBean shakeBean) {
        super(context);
        this.isShake = false;
        this.mLastTimeShake = 0L;
        this.mSenAccelerometer = null;
        this.GESTURE_INTERACTION_START = -1;
        this.GESTURE_INTERACTION_END_CLICK = 0;
        this.GESTURE_INTERACTION_END_SUCCESS = 1;
        this.GESTURE_INTERACTION_END_FAIL = 2;
        this.MIN_SHAKE_THRESHOLD = 1;
        this.MAX_SHAKE_THRESHOLD = 50;
        this.sensorList = Collections.synchronizedList(new ArrayList());
        this.count = 0;
        this.mShowText1 = str;
        init(context, shakeBean);
    }
}
