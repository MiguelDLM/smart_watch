package com.baidu.mapclient.liteapp.view.WheelView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.szabh.navi.R;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import oIxOXo.oxoX;

/* loaded from: classes7.dex */
public class WheelView extends View {
    int change;
    int colorBlack;
    int colorGray;
    int colorLightGray;
    Context context;
    int firstLineY;
    private GestureDetector gestureDetector;
    int halfCircumference;
    Handler handler;
    int initPosition;
    boolean isLoop;
    List<String> items;
    int itemsVisible;
    float lineSpacingMultiplier;
    ScheduledExecutorService mExecutor;
    private ScheduledFuture<?> mFuture;
    private int mOffset;
    int maxTextHeight;
    int maxTextWidth;
    int measuredHeight;
    int measuredWidth;
    OnItemSelectedListener onItemSelectedListener;
    int paddingLeft;
    int paddingRight;
    Paint paintCenterText;
    Paint paintIndicator;
    Paint paintOuterText;
    int preCurrentIndex;
    private float previousY;
    int radius;
    private float scaleX;
    int secondLineY;
    private int selectedItem;
    long startTime;
    private Rect tempRect;
    int textSize;
    int totalScrollY;

    /* loaded from: classes7.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    public WheelView(Context context) {
        super(context);
        this.scaleX = 1.15f;
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.paddingLeft = 0;
        this.paddingRight = 0;
        this.mOffset = 0;
        this.startTime = 0L;
        this.tempRect = new Rect();
        initLoopView(context);
    }

    private int getTextX(String str, Paint paint, Rect rect) {
        paint.getTextBounds(str, 0, str.length(), rect);
        return (this.measuredWidth - ((int) (rect.width() * this.scaleX))) / 2;
    }

    private void initLoopView(Context context) {
        oxoX.f31821II0XooXoX = isInEditMode();
        this.context = context;
        this.handler = new MessageHandler(this);
        GestureDetector gestureDetector = new GestureDetector(context, new LoopViewGestureListener(this));
        this.gestureDetector = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.lineSpacingMultiplier = 2.0f;
        this.isLoop = true;
        this.itemsVisible = 7;
        this.colorGray = -5263441;
        this.colorBlack = oxoX.I0Io(context, R.color.colorAccent);
        this.colorLightGray = -3815995;
        this.totalScrollY = 0;
        this.initPosition = -1;
        initPaints();
        setTextSize(24.0f);
    }

    private void initPaints() {
        Paint paint = new Paint();
        this.paintOuterText = paint;
        paint.setColor(this.colorGray);
        this.paintOuterText.setAntiAlias(true);
        this.paintOuterText.setTextSize(this.textSize);
        Paint paint2 = new Paint();
        this.paintCenterText = paint2;
        paint2.setColor(this.colorBlack);
        this.paintCenterText.setAntiAlias(true);
        this.paintCenterText.setTextScaleX(this.scaleX);
        this.paintCenterText.setTextSize(this.textSize);
        Paint paint3 = new Paint();
        this.paintIndicator = paint3;
        paint3.setColor(this.colorLightGray);
        this.paintIndicator.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void measureTextWidthHeight() {
        for (int i = 0; i < this.items.size(); i++) {
            String str = this.items.get(i);
            this.paintCenterText.getTextBounds(str, 0, str.length(), this.tempRect);
            this.paintCenterText.getTextBounds("星期", 0, 2, this.tempRect);
            int height = this.tempRect.height();
            if (height > this.maxTextHeight) {
                this.maxTextHeight = height;
            }
        }
    }

    private void remeasure() {
        if (this.items == null) {
            return;
        }
        measureTextWidthHeight();
        int i = this.maxTextHeight;
        float f = this.lineSpacingMultiplier;
        int i2 = (int) (i * f * (this.itemsVisible - 1));
        this.halfCircumference = i2;
        int i3 = (int) ((i2 * 2) / 3.141592653589793d);
        this.measuredHeight = i3;
        this.radius = (int) (i2 / 3.141592653589793d);
        this.firstLineY = (int) ((i3 - (i * f)) / 2.0f);
        this.secondLineY = (int) ((i3 + (f * i)) / 2.0f);
        if (this.initPosition == -1) {
            if (this.isLoop) {
                this.initPosition = (this.items.size() + 1) / 2;
            } else {
                this.initPosition = 0;
            }
        }
        this.preCurrentIndex = this.initPosition;
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.mFuture;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.mFuture.cancel(true);
            this.mFuture = null;
        }
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return this.paddingLeft;
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return this.paddingRight;
    }

    public final int getSelectedItem() {
        return this.selectedItem;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        List<String> list = this.items;
        if (list == null) {
            return;
        }
        String[] strArr = new String[this.itemsVisible];
        int i = (int) (this.totalScrollY / (this.lineSpacingMultiplier * this.maxTextHeight));
        this.change = i;
        int size = this.initPosition + (i % list.size());
        this.preCurrentIndex = size;
        if (!this.isLoop) {
            if (size < 0) {
                this.preCurrentIndex = 0;
            }
            if (this.preCurrentIndex > this.items.size() - 1) {
                this.preCurrentIndex = this.items.size() - 1;
            }
        } else {
            if (size < 0) {
                this.preCurrentIndex = this.items.size() + this.preCurrentIndex;
            }
            if (this.preCurrentIndex > this.items.size() - 1) {
                this.preCurrentIndex -= this.items.size();
            }
        }
        int i2 = (int) (this.totalScrollY % (this.lineSpacingMultiplier * this.maxTextHeight));
        int i3 = 0;
        while (true) {
            int i4 = this.itemsVisible;
            if (i3 >= i4) {
                break;
            }
            int i5 = this.preCurrentIndex - ((i4 / 2) - i3);
            if (this.isLoop) {
                while (i5 < 0) {
                    i5 += this.items.size();
                }
                while (i5 > this.items.size() - 1) {
                    i5 -= this.items.size();
                }
                strArr[i3] = this.items.get(i5);
            } else if (i5 < 0) {
                strArr[i3] = "";
            } else if (i5 > this.items.size() - 1) {
                strArr[i3] = "";
            } else {
                strArr[i3] = this.items.get(i5);
            }
            i3++;
        }
        for (int i6 = 0; i6 < this.itemsVisible; i6++) {
            canvas.save();
            float f = this.maxTextHeight * this.lineSpacingMultiplier;
            double d = (((i6 * f) - i2) * 3.141592653589793d) / this.halfCircumference;
            float f2 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
            if (f2 < 90.0f && f2 > -90.0f) {
                int cos = (int) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.maxTextHeight) / 2.0d));
                canvas.translate(0.0f, cos);
                canvas.scale(1.0f, (float) Math.sin(d));
                int i7 = this.firstLineY;
                if (cos <= i7 && this.maxTextHeight + cos >= i7) {
                    canvas.save();
                    canvas.clipRect(0, 0, this.measuredWidth, this.firstLineY - cos);
                    canvas.drawText(strArr[i6], getTextX(r5, this.paintOuterText, this.tempRect), this.maxTextHeight, this.paintOuterText);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0, this.firstLineY - cos, this.measuredWidth, (int) f);
                    canvas.drawText(strArr[i6], getTextX(r4, this.paintCenterText, this.tempRect), this.maxTextHeight, this.paintCenterText);
                    canvas.restore();
                } else {
                    int i8 = this.secondLineY;
                    if (cos <= i8 && this.maxTextHeight + cos >= i8) {
                        canvas.save();
                        canvas.clipRect(0, 0, this.measuredWidth, this.secondLineY - cos);
                        canvas.drawText(strArr[i6], getTextX(r5, this.paintCenterText, this.tempRect), this.maxTextHeight, this.paintCenterText);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0, this.secondLineY - cos, this.measuredWidth, (int) f);
                        canvas.drawText(strArr[i6], getTextX(r4, this.paintOuterText, this.tempRect), this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    } else if (cos >= i7 && this.maxTextHeight + cos <= i8) {
                        canvas.clipRect(0, 0, this.measuredWidth, (int) f);
                        canvas.drawText(strArr[i6], getTextX(r4, this.paintCenterText, this.tempRect), this.maxTextHeight, this.paintCenterText);
                        this.selectedItem = this.items.indexOf(strArr[i6]);
                    } else {
                        canvas.clipRect(0, 0, this.measuredWidth, (int) f);
                        canvas.drawText(strArr[i6], getTextX(r4, this.paintOuterText, this.tempRect), this.maxTextHeight, this.paintOuterText);
                    }
                }
                canvas.restore();
            } else {
                canvas.restore();
            }
        }
    }

    public final void onItemSelected() {
        if (this.onItemSelectedListener != null) {
            postDelayed(new OnItemSelectedRunnable(this), 200L);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        remeasure();
        int measuredWidth = getMeasuredWidth();
        this.measuredWidth = measuredWidth;
        setMeasuredDimension(measuredWidth, this.measuredHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
        float f = this.lineSpacingMultiplier * this.maxTextHeight;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    int i = this.radius;
                    int acos = (int) (((Math.acos((i - y) / i) * this.radius) + (f / 2.0f)) / f);
                    this.mOffset = (int) (((acos - (this.itemsVisible / 2)) * f) - (((this.totalScrollY % f) + f) % f));
                    if (System.currentTimeMillis() - this.startTime > 120) {
                        smoothScroll(ACTION.DAGGLE);
                    } else {
                        smoothScroll(ACTION.CLICK);
                    }
                }
            } else {
                float rawY = this.previousY - motionEvent.getRawY();
                this.previousY = motionEvent.getRawY();
                this.totalScrollY = (int) (this.totalScrollY + rawY);
                if (!this.isLoop) {
                    float f2 = (-this.initPosition) * f;
                    float size = ((this.items.size() - 1) - this.initPosition) * f;
                    int i2 = this.totalScrollY;
                    if (i2 < f2) {
                        this.totalScrollY = (int) f2;
                    } else if (i2 > size) {
                        this.totalScrollY = (int) size;
                    }
                }
            }
        } else {
            this.startTime = System.currentTimeMillis();
            cancelFuture();
            this.previousY = motionEvent.getRawY();
        }
        invalidate();
        return true;
    }

    public final void scrollBy(float f) {
        cancelFuture();
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new InertiaTimerTask(this, f), 0L, 10, TimeUnit.MILLISECONDS);
    }

    public final void setInitPosition(int i) {
        this.totalScrollY = 0;
        if (i < 0) {
            this.initPosition = 0;
        } else {
            this.initPosition = i;
        }
    }

    public final void setItems(List<String> list) {
        this.items = list;
        if (this.initPosition > list.size() - 1) {
            this.initPosition = list.size() - 1;
        }
        remeasure();
        invalidate();
    }

    public final void setListener(OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public final void setNotLoop() {
        this.isLoop = false;
    }

    @Override // android.view.View
    public final void setScaleX(float f) {
        if (f > 0.0f) {
            this.scaleX = f;
            this.paintCenterText.setTextScaleX(f);
        }
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            int i = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.textSize = i;
            this.paintOuterText.setTextSize(i);
            this.paintCenterText.setTextSize(this.textSize);
        }
    }

    public void setViewPadding(int i, int i2, int i3, int i4) {
        this.paddingLeft = i;
        this.paddingRight = i3;
    }

    public void setVisibleCount(int i) {
        this.itemsVisible = i + 2;
    }

    public void smoothScroll(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = this.lineSpacingMultiplier * this.maxTextHeight;
            int i = (int) (((this.totalScrollY % f) + f) % f);
            this.mOffset = i;
            if (i > f / 2.0f) {
                this.mOffset = (int) (f - i);
            } else {
                this.mOffset = -i;
            }
        }
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scaleX = 1.15f;
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.paddingLeft = 0;
        this.paddingRight = 0;
        this.mOffset = 0;
        this.startTime = 0L;
        this.tempRect = new Rect();
        initLoopView(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.scaleX = 1.15f;
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.paddingLeft = 0;
        this.paddingRight = 0;
        this.mOffset = 0;
        this.startTime = 0L;
        this.tempRect = new Rect();
        initLoopView(context);
    }
}
