package com.baidu.navisdk.module.futuretrip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ScrollerCompat;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;

/* loaded from: classes7.dex */
public class BNRRNumberPickerView extends View {
    private static final boolean DEFAULT_CURRENT_ITEM_INDEX_EFFECT = false;
    private static final int DEFAULT_DIVIDER_COLOR = -695533;
    private static final int DEFAULT_DIVIDER_HEIGHT = 2;
    private static final int DEFAULT_DIVIDER_MARGIN_HORIZONTAL = 0;
    private static final int DEFAULT_INTERVAL_REVISE_DURATION = 300;
    private static final int DEFAULT_ITEM_PADDING_DP_H = 5;
    private static final int DEFAULT_ITEM_PADDING_DP_V = 2;
    private static final int DEFAULT_MARGIN_END_OF_HINT_DP = 8;
    private static final int DEFAULT_MARGIN_START_OF_HINT_DP = 8;
    private static final int DEFAULT_MAX_SCROLL_BY_INDEX_DURATION = 600;
    private static final int DEFAULT_MIN_SCROLL_BY_INDEX_DURATION = 300;
    private static final boolean DEFAULT_RESPOND_CHANGE_IN_MAIN_THREAD = true;
    private static final boolean DEFAULT_RESPOND_CHANGE_ON_DETACH = false;
    private static final int DEFAULT_SHOW_COUNT = 3;
    private static final boolean DEFAULT_SHOW_DIVIDER = true;
    private static final int DEFAULT_TEXT_COLOR_NORMAL = -13421773;
    private static final int DEFAULT_TEXT_COLOR_SELECTED = -695533;
    private static final int DEFAULT_TEXT_SIZE_HINT_SP = 14;
    private static final int DEFAULT_TEXT_SIZE_NORMAL_SP = 14;
    private static final int DEFAULT_TEXT_SIZE_SELECTED_SP = 16;
    private static final boolean DEFAULT_WRAP_SELECTOR_WHEEL = true;
    private static final int HANDLER_INTERVAL_REFRESH = 32;
    private static final int HANDLER_WHAT_LISTENER_VALUE_CHANGED = 2;
    private static final int HANDLER_WHAT_REFRESH = 1;
    private static final int HANDLER_WHAT_REQUEST_LAYOUT = 3;
    private static final int LEFT_TO_RIGHT_SIDE = 0;
    private static final int MIDDLE_TO_BOTH_SIDE = 1;
    private static final int RIGHT_TO_LEFT_SIDE = 2;
    private static final String TAG = "NumberPickerView";
    private static final String TEXT_ELLIPSIZE_END = "end";
    private static final String TEXT_ELLIPSIZE_MIDDLE = "middle";
    private static final String TEXT_ELLIPSIZE_START = "start";
    private float curYPos;
    private float currY;
    private float dividerY0;
    private float dividerY1;
    private float downY;
    private float downYGlobal;
    private float downYPos;
    private String mAlterHint;
    private CharSequence[] mAlterTextArrayWithMeasureHint;
    private CharSequence[] mAlterTextArrayWithoutMeasureHint;
    private int mCurrDrawFirstItemIndex;
    private int mCurrDrawFirstItemY;
    private int mCurrDrawGlobalY;
    private boolean mCurrentItemIndexEffect;
    private String[] mDisplayedValues;
    private int mDividerColor;
    private int mDividerHeight;
    private boolean mDividerIgnorePadding;
    private int mDividerIndex0;
    private int mDividerIndex1;
    private int mDividerMarginL;
    private int mDividerMarginR;
    private String mEmptyItemHint;
    private boolean mFlagMayPress;
    private boolean mForbiddenScroll;
    private float mFriction;
    private int mGap;
    private Handler mHandlerInMainThread;
    private Handler mHandlerInNewThread;
    private HandlerThread mHandlerThread;
    private boolean mHasInit;
    private String mHintText;
    private int mIgnoreStartIndex;
    private int mInScrollingPickedNewValue;
    private int mInScrollingPickedOldValue;
    private int mItemHeight;
    private int mItemPaddingHorizontal;
    private int mItemPaddingVertical;
    private int mMarginEndOfHint;
    private int mMarginStartOfHint;
    private int mMaxHeightOfDisplayedValues;
    private int mMaxShowIndex;
    private int mMaxValue;
    private int mMaxWidthOfAlterArrayWithMeasureHint;
    private int mMaxWidthOfAlterArrayWithoutMeasureHint;
    private int mMaxWidthOfDisplayedValues;
    private int mMinShowIndex;
    private int mMinValue;
    private int mMiniVelocityFling;
    private int mNotWrapLimitYBottom;
    private int mNotWrapLimitYTop;
    private OnScrollListener mOnScrollListener;
    private OnValueChangeListener mOnValueChangeListener;
    private OnValueChangeListenerInScrolling mOnValueChangeListenerInScrolling;
    private OnValueChangeListenerRelativeToRaw mOnValueChangeListenerRaw;
    private Paint mPaintDivider;
    private Paint mPaintHint;
    private TextPaint mPaintText;
    private boolean mPendingWrapToLinear;
    private int mPrevPickedIndex;
    private boolean mRespondChangeInMainThread;
    private boolean mRespondChangeOnDetach;
    private int mScaledTouchSlop;
    private int mScrollState;
    private ScrollerCompat mScroller;
    private int mSelectScaleDirection;
    private int mShowCount;
    private boolean mShowDivider;
    private int mSpecModeH;
    private int mSpecModeW;
    private float mTextCenterX;
    private int mTextColorHint;
    private int mTextColorNormal;
    private int mTextColorSelected;
    private String mTextEllipsize;
    private int mTextSizeHint;
    private float mTextSizeHintCenterYOffset;
    private int mTextSizeNormal;
    private float mTextSizeNormalCenterYOffset;
    private int mTextSizeSelected;
    private float mTextSizeSelectedCenterYOffset;
    private VelocityTracker mVelocityTracker;
    private float mViewCenterX;
    private int mViewHeight;
    private int mViewWidth;
    private int mWidthOfAlterHint;
    private int mWidthOfHintText;
    private boolean mWrapSelectorWheel;
    private boolean mWrapSelectorWheelCheck;

    /* loaded from: classes7.dex */
    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScrollStateChange(BNRRNumberPickerView bNRRNumberPickerView, int i);
    }

    /* loaded from: classes7.dex */
    public interface OnValueChangeListener {
        void onValueChange(BNRRNumberPickerView bNRRNumberPickerView, int i, int i2);
    }

    /* loaded from: classes7.dex */
    public interface OnValueChangeListenerInScrolling {
        void onValueChangeInScrolling(BNRRNumberPickerView bNRRNumberPickerView, int i, int i2);
    }

    /* loaded from: classes7.dex */
    public interface OnValueChangeListenerRelativeToRaw {
        void onValueChangeRelativeToRaw(BNRRNumberPickerView bNRRNumberPickerView, int i, int i2, String[] strArr);
    }

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int willPickIndexByGlobalY;
            int i;
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 2) {
                    BNRRNumberPickerView.this.respondPickedValueChanged(message.arg1, message.arg2, message.obj);
                    return;
                }
                return;
            }
            int i3 = 0;
            if (!BNRRNumberPickerView.this.mScroller.isFinished()) {
                if (BNRRNumberPickerView.this.mScrollState == 0) {
                    BNRRNumberPickerView.this.onScrollStateChange(1);
                }
                BNRRNumberPickerView.this.mHandlerInNewThread.sendMessageDelayed(BNRRNumberPickerView.this.getMsg(1, 0, 0, message.obj), 32L);
                return;
            }
            if (BNRRNumberPickerView.this.mCurrDrawFirstItemY == 0) {
                BNRRNumberPickerView.this.onScrollStateChange(0);
                BNRRNumberPickerView bNRRNumberPickerView = BNRRNumberPickerView.this;
                willPickIndexByGlobalY = bNRRNumberPickerView.getWillPickIndexByGlobalY(bNRRNumberPickerView.mCurrDrawGlobalY);
            } else {
                if (BNRRNumberPickerView.this.mScrollState == 0) {
                    BNRRNumberPickerView.this.onScrollStateChange(1);
                }
                if (BNRRNumberPickerView.this.mCurrDrawFirstItemY < (-BNRRNumberPickerView.this.mItemHeight) / 2) {
                    i = (int) (((BNRRNumberPickerView.this.mItemHeight + BNRRNumberPickerView.this.mCurrDrawFirstItemY) * 300.0f) / BNRRNumberPickerView.this.mItemHeight);
                    BNRRNumberPickerView.this.mScroller.startScroll(0, BNRRNumberPickerView.this.mCurrDrawGlobalY, 0, BNRRNumberPickerView.this.mItemHeight + BNRRNumberPickerView.this.mCurrDrawFirstItemY, i * 3);
                    BNRRNumberPickerView bNRRNumberPickerView2 = BNRRNumberPickerView.this;
                    willPickIndexByGlobalY = bNRRNumberPickerView2.getWillPickIndexByGlobalY(bNRRNumberPickerView2.mCurrDrawGlobalY + BNRRNumberPickerView.this.mItemHeight + BNRRNumberPickerView.this.mCurrDrawFirstItemY);
                } else {
                    i = (int) (((-BNRRNumberPickerView.this.mCurrDrawFirstItemY) * 300.0f) / BNRRNumberPickerView.this.mItemHeight);
                    BNRRNumberPickerView.this.mScroller.startScroll(0, BNRRNumberPickerView.this.mCurrDrawGlobalY, 0, BNRRNumberPickerView.this.mCurrDrawFirstItemY, i * 3);
                    BNRRNumberPickerView bNRRNumberPickerView3 = BNRRNumberPickerView.this;
                    willPickIndexByGlobalY = bNRRNumberPickerView3.getWillPickIndexByGlobalY(bNRRNumberPickerView3.mCurrDrawGlobalY + BNRRNumberPickerView.this.mCurrDrawFirstItemY);
                }
                i3 = i;
                BNRRNumberPickerView.this.postInvalidate();
            }
            BNRRNumberPickerView bNRRNumberPickerView4 = BNRRNumberPickerView.this;
            Message msg = bNRRNumberPickerView4.getMsg(2, bNRRNumberPickerView4.mPrevPickedIndex, willPickIndexByGlobalY, message.obj);
            if (LogUtil.LOGGABLE) {
                BNRRNumberPickerView.this.log("HANDLER_WHAT_LISTENER_VALUE_CHANGED mPrevPickedIndex:" + BNRRNumberPickerView.this.mPrevPickedIndex);
                BNRRNumberPickerView.this.log("HANDLER_WHAT_LISTENER_VALUE_CHANGED willPickIndex:" + willPickIndexByGlobalY);
            }
            if (BNRRNumberPickerView.this.mRespondChangeInMainThread) {
                BNRRNumberPickerView.this.mHandlerInMainThread.sendMessageDelayed(msg, i3 * 2);
            } else {
                BNRRNumberPickerView.this.mHandlerInNewThread.sendMessageDelayed(msg, i3 * 2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 2) {
                BNRRNumberPickerView.this.respondPickedValueChanged(message.arg1, message.arg2, message.obj);
            } else if (i == 3) {
                BNRRNumberPickerView.this.requestLayout();
            }
        }
    }

    public BNRRNumberPickerView(Context context) {
        super(context);
        this.mTextColorNormal = DEFAULT_TEXT_COLOR_NORMAL;
        this.mTextColorSelected = -695533;
        this.mTextColorHint = -695533;
        this.mTextSizeNormal = 0;
        this.mTextSizeSelected = 0;
        this.mTextSizeHint = 0;
        this.mWidthOfHintText = 0;
        this.mWidthOfAlterHint = 0;
        this.mMarginStartOfHint = 0;
        this.mMarginEndOfHint = 0;
        this.mItemPaddingVertical = 0;
        this.mItemPaddingHorizontal = 0;
        this.mDividerColor = -695533;
        this.mDividerHeight = 2;
        this.mDividerMarginL = 0;
        this.mDividerMarginR = 0;
        this.mShowCount = 3;
        this.mDividerIndex0 = 0;
        this.mDividerIndex1 = 0;
        this.mMinShowIndex = -1;
        this.mMaxShowIndex = -1;
        this.mMinValue = 0;
        this.mMaxValue = 0;
        this.mMaxWidthOfDisplayedValues = 0;
        this.mMaxHeightOfDisplayedValues = 0;
        this.mMaxWidthOfAlterArrayWithMeasureHint = 0;
        this.mMaxWidthOfAlterArrayWithoutMeasureHint = 0;
        this.mPrevPickedIndex = 0;
        this.mMiniVelocityFling = 150;
        this.mScaledTouchSlop = 8;
        this.mSelectScaleDirection = 1;
        this.mDividerIgnorePadding = false;
        this.mFriction = 1.0f;
        this.mTextSizeNormalCenterYOffset = 0.0f;
        this.mTextSizeSelectedCenterYOffset = 0.0f;
        this.mTextSizeHintCenterYOffset = 0.0f;
        this.mShowDivider = true;
        this.mWrapSelectorWheel = true;
        this.mCurrentItemIndexEffect = false;
        this.mHasInit = false;
        this.mWrapSelectorWheelCheck = true;
        this.mPendingWrapToLinear = false;
        this.mRespondChangeOnDetach = false;
        this.mRespondChangeInMainThread = true;
        this.mPaintDivider = new Paint();
        this.mPaintText = new TextPaint();
        this.mPaintHint = new Paint();
        this.mScrollState = 0;
        this.mGap = 0;
        this.downYGlobal = 0.0f;
        this.downY = 0.0f;
        this.currY = 0.0f;
        this.mFlagMayPress = false;
        this.mCurrDrawFirstItemIndex = 0;
        this.mCurrDrawFirstItemY = 0;
        this.mCurrDrawGlobalY = 0;
        this.mSpecModeW = 0;
        this.mSpecModeH = 0;
        init(context);
    }

    private void calculateFirstItemParameterByGlobalY() {
        int floor = (int) Math.floor(this.mCurrDrawGlobalY / this.mItemHeight);
        this.mCurrDrawFirstItemIndex = floor;
        int i = this.mCurrDrawGlobalY;
        int i2 = this.mItemHeight;
        int i3 = -(i - (floor * i2));
        this.mCurrDrawFirstItemY = i3;
        if (this.mOnValueChangeListenerInScrolling != null) {
            if ((-i3) > i2 / 2) {
                this.mInScrollingPickedNewValue = floor + 1 + (this.mShowCount / 2);
            } else {
                this.mInScrollingPickedNewValue = floor + (this.mShowCount / 2);
            }
            int oneRecycleSize = this.mInScrollingPickedNewValue % getOneRecycleSize();
            this.mInScrollingPickedNewValue = oneRecycleSize;
            if (oneRecycleSize < 0) {
                this.mInScrollingPickedNewValue = oneRecycleSize + getOneRecycleSize();
            }
            int i4 = this.mInScrollingPickedOldValue;
            int i5 = this.mInScrollingPickedNewValue;
            if (i4 != i5) {
                respondPickedValueChangedInScrolling(i5, i4);
            }
            this.mInScrollingPickedOldValue = this.mInScrollingPickedNewValue;
        }
    }

    private void click(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        for (int i = 0; i < this.mShowCount; i++) {
            int i2 = this.mItemHeight;
            if (i2 * i <= y && y < i2 * (i + 1)) {
                clickItem(i);
                return;
            }
        }
    }

    private void clickItem(int i) {
        int i2;
        if (i >= 0 && i < (i2 = this.mShowCount)) {
            scrollByIndexSmoothly(i - (i2 / 2));
        }
    }

    private String[] convertCharSequenceArrayToStringArray(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            return null;
        }
        String[] strArr = new String[charSequenceArr.length];
        for (int i = 0; i < charSequenceArr.length; i++) {
            strArr[i] = charSequenceArr[i].toString();
        }
        return strArr;
    }

    private void correctPositionByDefaultValue(int i, boolean z) {
        int i2 = i - ((this.mShowCount - 1) / 2);
        this.mCurrDrawFirstItemIndex = i2;
        int indexByRawIndex = getIndexByRawIndex(i2, getOneRecycleSize(), z);
        this.mCurrDrawFirstItemIndex = indexByRawIndex;
        int i3 = this.mItemHeight;
        if (i3 == 0) {
            this.mCurrentItemIndexEffect = true;
            return;
        }
        this.mCurrDrawGlobalY = i3 * indexByRawIndex;
        int i4 = indexByRawIndex + (this.mShowCount / 2);
        this.mInScrollingPickedOldValue = i4;
        int oneRecycleSize = i4 % getOneRecycleSize();
        this.mInScrollingPickedOldValue = oneRecycleSize;
        if (oneRecycleSize < 0) {
            this.mInScrollingPickedOldValue = oneRecycleSize + getOneRecycleSize();
        }
        this.mInScrollingPickedNewValue = this.mInScrollingPickedOldValue;
        calculateFirstItemParameterByGlobalY();
    }

    private int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void drawContent(Canvas canvas) {
        float f;
        float f2;
        float f3;
        int i;
        float f4 = 0.0f;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < this.mShowCount + 1) {
                float f5 = this.mCurrDrawFirstItemY + (this.mItemHeight * i2);
                int i3 = this.mCurrDrawFirstItemIndex + i2;
                int oneRecycleSize = getOneRecycleSize();
                if (!this.mWrapSelectorWheel || !this.mWrapSelectorWheelCheck) {
                    z = false;
                }
                int indexByRawIndex = getIndexByRawIndex(i3, oneRecycleSize, z);
                int i4 = this.mShowCount / 2;
                if (i2 == i4) {
                    f3 = (this.mCurrDrawFirstItemY + r0) / this.mItemHeight;
                    i = getEvaluateColor(f3, this.mTextColorNormal, this.mTextColorSelected);
                    f = getEvaluateSize(f3, this.mTextSizeNormal, this.mTextSizeSelected);
                    f2 = getEvaluateSize(f3, this.mTextSizeNormalCenterYOffset, this.mTextSizeSelectedCenterYOffset);
                } else if (i2 == i4 + 1) {
                    float f6 = 1.0f - f4;
                    int evaluateColor = getEvaluateColor(f6, this.mTextColorNormal, this.mTextColorSelected);
                    float evaluateSize = getEvaluateSize(f6, this.mTextSizeNormal, this.mTextSizeSelected);
                    float evaluateSize2 = getEvaluateSize(f6, this.mTextSizeNormalCenterYOffset, this.mTextSizeSelectedCenterYOffset);
                    f3 = f4;
                    i = evaluateColor;
                    f = evaluateSize;
                    f2 = evaluateSize2;
                } else {
                    int i5 = this.mTextColorNormal;
                    f = this.mTextSizeNormal;
                    f2 = this.mTextSizeNormalCenterYOffset;
                    f3 = f4;
                    i = i5;
                }
                this.mPaintText.setColor(i);
                this.mPaintText.setTextSize(f);
                if (indexByRawIndex >= 0 && indexByRawIndex < getOneRecycleSize()) {
                    if (indexByRawIndex >= this.mIgnoreStartIndex) {
                        CharSequence charSequence = this.mDisplayedValues[indexByRawIndex + this.mMinShowIndex];
                        if (this.mTextEllipsize != null) {
                            charSequence = TextUtils.ellipsize(charSequence, this.mPaintText, getWidth() - (this.mItemPaddingHorizontal * 2), getEllipsizeType());
                        }
                        setPaintAlign();
                        setTextCenterX(charSequence.toString());
                        canvas.drawText(charSequence.toString(), this.mTextCenterX, f5 + (this.mItemHeight / 2) + f2, this.mPaintText);
                    }
                } else if (!TextUtils.isEmpty(this.mEmptyItemHint)) {
                    setPaintAlign();
                    setTextCenterX(this.mEmptyItemHint);
                    canvas.drawText(this.mEmptyItemHint, this.mTextCenterX, f5 + (this.mItemHeight / 2) + f2, this.mPaintText);
                }
                i2++;
                f4 = f3;
            } else {
                return;
            }
        }
    }

    private void drawHint(Canvas canvas) {
        if (TextUtils.isEmpty(this.mHintText)) {
            return;
        }
        canvas.drawText(this.mHintText, this.mViewCenterX + ((this.mMaxWidthOfDisplayedValues + this.mWidthOfHintText) / 2) + this.mMarginStartOfHint, ((this.dividerY0 + this.dividerY1) / 2.0f) + this.mTextSizeHintCenterYOffset, this.mPaintHint);
    }

    private void drawLine(Canvas canvas) {
        if (this.mShowDivider) {
            if (this.mDividerIgnorePadding) {
                float f = this.mDividerMarginL;
                float f2 = this.dividerY0;
                canvas.drawLine(f, f2, this.mViewWidth - this.mDividerMarginR, f2, this.mPaintDivider);
                float f3 = this.mDividerMarginL;
                float f4 = this.dividerY1;
                canvas.drawLine(f3, f4, this.mViewWidth - this.mDividerMarginR, f4, this.mPaintDivider);
                return;
            }
            canvas.drawLine(getPaddingLeft() + this.mDividerMarginL, this.dividerY0, (this.mViewWidth - getPaddingRight()) - this.mDividerMarginR, this.dividerY0, this.mPaintDivider);
            canvas.drawLine(getPaddingLeft() + this.mDividerMarginL, this.dividerY1, (this.mViewWidth - getPaddingRight()) - this.mDividerMarginR, this.dividerY1, this.mPaintDivider);
        }
    }

    private TextUtils.TruncateAt getEllipsizeType() {
        String str = this.mTextEllipsize;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1074341483:
                if (str.equals(TEXT_ELLIPSIZE_MIDDLE)) {
                    c = 0;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c = 1;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return TextUtils.TruncateAt.MIDDLE;
            case 1:
                return TextUtils.TruncateAt.END;
            case 2:
                return TextUtils.TruncateAt.START;
            default:
                throw new IllegalArgumentException("Illegal text ellipsize type.");
        }
    }

    private int getEvaluateColor(float f, int i, int i2) {
        int i3 = (i & ViewCompat.MEASURED_STATE_MASK) >>> 24;
        int i4 = (i & 16711680) >>> 16;
        int i5 = (i & 65280) >>> 8;
        return ((int) ((i & 255) + (((i2 & 255) - r9) * f))) | (((int) (i3 + (((((-16777216) & i2) >>> 24) - i3) * f))) << 24) | (((int) (i4 + ((((16711680 & i2) >>> 16) - i4) * f))) << 16) | (((int) (i5 + ((((65280 & i2) >>> 8) - i5) * f))) << 8);
    }

    private float getEvaluateSize(float f, float f2, float f3) {
        return f2 + ((f3 - f2) * f);
    }

    private int getIndexByRawIndex(int i, int i2, boolean z) {
        if (i2 <= 0) {
            return 0;
        }
        if (z) {
            int i3 = i % i2;
            if (i3 < 0) {
                return i3 + i2;
            }
            return i3;
        }
        return i;
    }

    private int getMaxWidthOfTextArray(CharSequence[] charSequenceArr, Paint paint) {
        if (charSequenceArr == null) {
            return 0;
        }
        int i = 0;
        for (CharSequence charSequence : charSequenceArr) {
            if (charSequence != null) {
                i = Math.max(getTextWidth(charSequence, paint), i);
            }
        }
        return i;
    }

    private Message getMsg(int i) {
        return getMsg(i, 0, 0, null);
    }

    private float getTextCenterYOffset(Paint.FontMetrics fontMetrics) {
        if (fontMetrics == null) {
            return 0.0f;
        }
        return Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
    }

    private int getTextWidth(CharSequence charSequence, Paint paint) {
        if (!TextUtils.isEmpty(charSequence)) {
            return (int) (paint.measureText(charSequence.toString()) + 0.5f);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWillPickIndexByGlobalY(int i) {
        int i2 = this.mItemHeight;
        boolean z = false;
        if (i2 == 0) {
            return 0;
        }
        int i3 = (i / i2) + (this.mShowCount / 2);
        int oneRecycleSize = getOneRecycleSize();
        if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
            z = true;
        }
        int indexByRawIndex = getIndexByRawIndex(i3, oneRecycleSize, z);
        if (indexByRawIndex >= 0 && indexByRawIndex < getOneRecycleSize()) {
            return indexByRawIndex + this.mMinShowIndex;
        }
        if (LogUtil.LOGGABLE) {
            log("getWillPickIndexByGlobalY illegal index : " + indexByRawIndex + " getOneRecycleSize() : " + getOneRecycleSize() + " gmWrapSelectorWheelCheck : " + this.mWrapSelectorWheelCheck + " mMinShowIndex : " + this.mMinShowIndex + " mWrapSelectorWheel : " + this.mWrapSelectorWheel);
        }
        return this.mMinShowIndex;
    }

    private void inflateDisplayedValuesIfNull() {
        if (this.mDisplayedValues == null) {
            this.mDisplayedValues = r0;
            String[] strArr = {"0"};
        }
    }

    private void init(Context context) {
        this.mScroller = ScrollerCompat.create(context);
        this.mMiniVelocityFling = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.mScaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (this.mTextSizeNormal == 0) {
            this.mTextSizeNormal = sp2px(context, 14.0f);
        }
        if (this.mTextSizeSelected == 0) {
            this.mTextSizeSelected = sp2px(context, 16.0f);
        }
        if (this.mTextSizeHint == 0) {
            this.mTextSizeHint = sp2px(context, 14.0f);
        }
        if (this.mMarginStartOfHint == 0) {
            this.mMarginStartOfHint = dp2px(context, 8.0f);
        }
        if (this.mMarginEndOfHint == 0) {
            this.mMarginEndOfHint = dp2px(context, 8.0f);
        }
        this.mPaintDivider.setColor(this.mDividerColor);
        this.mPaintDivider.setAntiAlias(true);
        this.mPaintDivider.setStyle(Paint.Style.STROKE);
        this.mPaintDivider.setStrokeWidth(this.mDividerHeight);
        this.mPaintText.setColor(this.mTextColorNormal);
        this.mPaintText.setAntiAlias(true);
        TextPaint textPaint = this.mPaintText;
        Paint.Align align = Paint.Align.CENTER;
        textPaint.setTextAlign(align);
        this.mPaintHint.setColor(this.mTextColorHint);
        this.mPaintHint.setAntiAlias(true);
        this.mPaintHint.setTextAlign(align);
        this.mPaintHint.setTextSize(this.mTextSizeHint);
        int i = this.mShowCount;
        if (i % 2 == 0) {
            this.mShowCount = i + 1;
        }
        if (this.mMinShowIndex == -1 || this.mMaxShowIndex == -1) {
            updateValueForInit();
        }
        initHandler();
    }

    private void initAttr(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NumberPickerView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.NumberPickerView_npv_ShowCount) {
                this.mShowCount = obtainStyledAttributes.getInt(index, 3);
            } else if (index == R.styleable.NumberPickerView_npv_DividerColor) {
                this.mDividerColor = obtainStyledAttributes.getColor(index, -695533);
            } else if (index == R.styleable.NumberPickerView_npv_DividerHeight) {
                this.mDividerHeight = obtainStyledAttributes.getDimensionPixelSize(index, 2);
            } else if (index == R.styleable.NumberPickerView_npv_DividerMarginLeft) {
                this.mDividerMarginL = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.NumberPickerView_npv_DividerMarginRight) {
                this.mDividerMarginR = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.NumberPickerView_npv_TextArray) {
                this.mDisplayedValues = convertCharSequenceArrayToStringArray(obtainStyledAttributes.getTextArray(index));
            } else if (index == R.styleable.NumberPickerView_npv_TextColorNormal) {
                this.mTextColorNormal = obtainStyledAttributes.getColor(index, DEFAULT_TEXT_COLOR_NORMAL);
            } else if (index == R.styleable.NumberPickerView_npv_TextColorSelected) {
                this.mTextColorSelected = obtainStyledAttributes.getColor(index, -695533);
            } else if (index == R.styleable.NumberPickerView_npv_TextColorHint) {
                this.mTextColorHint = obtainStyledAttributes.getColor(index, -695533);
            } else if (index == R.styleable.NumberPickerView_npv_TextSizeNormal) {
                this.mTextSizeNormal = obtainStyledAttributes.getDimensionPixelSize(index, sp2px(context, 14.0f));
            } else if (index == R.styleable.NumberPickerView_npv_TextSizeSelected) {
                this.mTextSizeSelected = obtainStyledAttributes.getDimensionPixelSize(index, sp2px(context, 16.0f));
            } else if (index == R.styleable.NumberPickerView_npv_TextSizeHint) {
                this.mTextSizeHint = obtainStyledAttributes.getDimensionPixelSize(index, sp2px(context, 14.0f));
            } else if (index == R.styleable.NumberPickerView_npv_MinValue) {
                this.mMinShowIndex = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.NumberPickerView_npv_MaxValue) {
                this.mMaxShowIndex = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.NumberPickerView_npv_WrapSelectorWheel) {
                this.mWrapSelectorWheel = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == R.styleable.NumberPickerView_npv_ShowDivider) {
                this.mShowDivider = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == R.styleable.NumberPickerView_npv_HintText) {
                this.mHintText = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.NumberPickerView_npv_AlternativeHint) {
                this.mAlterHint = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.NumberPickerView_npv_EmptyItemHint) {
                this.mEmptyItemHint = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.NumberPickerView_npv_MarginStartOfHint) {
                this.mMarginStartOfHint = obtainStyledAttributes.getDimensionPixelSize(index, dp2px(context, 8.0f));
            } else if (index == R.styleable.NumberPickerView_npv_MarginEndOfHint) {
                this.mMarginEndOfHint = obtainStyledAttributes.getDimensionPixelSize(index, dp2px(context, 8.0f));
            } else if (index == R.styleable.NumberPickerView_npv_ItemPaddingVertical) {
                this.mItemPaddingVertical = obtainStyledAttributes.getDimensionPixelSize(index, dp2px(context, 2.0f));
            } else if (index == R.styleable.NumberPickerView_npv_ItemPaddingHorizontal) {
                this.mItemPaddingHorizontal = obtainStyledAttributes.getDimensionPixelSize(index, dp2px(context, 5.0f));
            } else if (index == R.styleable.NumberPickerView_npv_AlternativeTextArrayWithMeasureHint) {
                this.mAlterTextArrayWithMeasureHint = obtainStyledAttributes.getTextArray(index);
            } else if (index == R.styleable.NumberPickerView_npv_AlternativeTextArrayWithoutMeasureHint) {
                this.mAlterTextArrayWithoutMeasureHint = obtainStyledAttributes.getTextArray(index);
            } else if (index == R.styleable.NumberPickerView_npv_RespondChangeOnDetached) {
                this.mRespondChangeOnDetach = obtainStyledAttributes.getBoolean(index, false);
            } else if (index == R.styleable.NumberPickerView_npv_RespondChangeInMainThread) {
                this.mRespondChangeInMainThread = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == R.styleable.NumberPickerView_npv_TextEllipsize) {
                this.mTextEllipsize = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.NumberPickerView_npv_TextGravity) {
                this.mSelectScaleDirection = obtainStyledAttributes.getInt(index, 1);
            } else if (index == R.styleable.NumberPickerView_npv_DividerIgnorePadding) {
                this.mDividerIgnorePadding = obtainStyledAttributes.getBoolean(index, false);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void initHandler() {
        HandlerThread handlerThread = new HandlerThread("HandlerThread-For-Refreshing");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandlerInNewThread = new a(this.mHandlerThread.getLooper());
        this.mHandlerInMainThread = new b();
    }

    private void internalSetWrapToLinear() {
        correctPositionByDefaultValue(getPickedIndexRelativeToRaw() - this.mMinShowIndex, false);
        this.mWrapSelectorWheel = false;
        postInvalidate();
    }

    private boolean isStringEqual(String str, String str2) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        }
        return str.equals(str2);
    }

    private int limitY(int i) {
        if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
            return i;
        }
        int i2 = this.mNotWrapLimitYBottom;
        if (i < i2 || i > (i2 = this.mNotWrapLimitYTop)) {
            return i2;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (getTag() != null) {
            LogUtil.e(TAG, "" + getTag() + HelpFormatter.DEFAULT_LONG_OPT_PREFIX + str);
        }
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        this.mSpecModeH = mode;
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom() + (this.mShowCount * (this.mMaxHeightOfDisplayedValues + (this.mItemPaddingVertical * 2)));
            if (mode == Integer.MIN_VALUE) {
                return Math.min(paddingTop, size);
            }
            return paddingTop;
        }
        return size;
    }

    private int measureWidth(int i) {
        int i2;
        int mode = View.MeasureSpec.getMode(i);
        this.mSpecModeW = mode;
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int i3 = 0;
            if (Math.max(this.mWidthOfHintText, this.mWidthOfAlterHint) == 0) {
                i2 = 0;
            } else {
                i2 = this.mMarginEndOfHint;
            }
            if (Math.max(this.mWidthOfHintText, this.mWidthOfAlterHint) != 0) {
                i3 = this.mMarginStartOfHint;
            }
            int paddingLeft = getPaddingLeft() + getPaddingRight() + Math.max(this.mMaxWidthOfAlterArrayWithMeasureHint, Math.max(this.mMaxWidthOfDisplayedValues, this.mMaxWidthOfAlterArrayWithoutMeasureHint) + ((i3 + Math.max(this.mWidthOfHintText, this.mWidthOfAlterHint) + i2 + (this.mItemPaddingHorizontal * 2)) * 2));
            if (mode == Integer.MIN_VALUE) {
                return Math.min(paddingLeft, size);
            }
            return paddingLeft;
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScrollStateChange(int i) {
        if (this.mScrollState == i) {
            return;
        }
        this.mScrollState = i;
        OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChange(this, i);
        }
    }

    private int refineValueByLimit(int i, int i2, int i3, boolean z) {
        if (z) {
            if (i > i3) {
                return (((i - i3) % getOneRecycleSize()) + i2) - 1;
            }
            if (i < i2) {
                return ((i - i2) % getOneRecycleSize()) + i3 + 1;
            }
            return i;
        }
        if (i > i3) {
            return i3;
        }
        if (i < i2) {
            return i2;
        }
        return i;
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void respondPickedValueChanged(int i, int i2, Object obj) {
        onScrollStateChange(0);
        if (LogUtil.LOGGABLE) {
            log("respondPickedValueChanged oldVal:" + i + ",newVal:" + i2);
            StringBuilder sb = new StringBuilder();
            sb.append("respondPickedValueChanged respondChange:");
            sb.append(obj);
            log(sb.toString());
            if (obj != null) {
                log("respondPickedValueChanged respondChange is boolean:" + (obj instanceof Boolean));
            }
        }
        this.mPrevPickedIndex = i2;
        if (i != i2 && (obj == null || !(obj instanceof Boolean) || ((Boolean) obj).booleanValue())) {
            OnValueChangeListener onValueChangeListener = this.mOnValueChangeListener;
            if (onValueChangeListener != null) {
                int i3 = this.mMinValue;
                onValueChangeListener.onValueChange(this, i + i3, i3 + i2);
            }
            OnValueChangeListenerRelativeToRaw onValueChangeListenerRelativeToRaw = this.mOnValueChangeListenerRaw;
            if (onValueChangeListenerRelativeToRaw != null) {
                onValueChangeListenerRelativeToRaw.onValueChangeRelativeToRaw(this, i, i2, this.mDisplayedValues);
            }
        }
        log("respondPickedValueChanged mPrevPickedIndex:" + this.mPrevPickedIndex);
        if (this.mPendingWrapToLinear) {
            this.mPendingWrapToLinear = false;
            internalSetWrapToLinear();
        }
    }

    private void respondPickedValueChangedInScrolling(int i, int i2) {
        this.mOnValueChangeListenerInScrolling.onValueChangeInScrolling(this, i, i2);
    }

    private void scrollByIndexSmoothly(int i) {
        scrollByIndexSmoothly(i, true, true);
    }

    private void setPaintAlign() {
        int i = this.mSelectScaleDirection;
        if (i == 1) {
            this.mPaintText.setTextAlign(Paint.Align.CENTER);
        } else if (i == 2) {
            this.mPaintText.setTextAlign(Paint.Align.RIGHT);
        } else {
            this.mPaintText.setTextAlign(Paint.Align.LEFT);
        }
    }

    private void setTextCenterX(String str) {
        log("setTextCenterX mViewCenterX:" + this.mViewCenterX);
        float f = this.mViewCenterX;
        int i = this.mSelectScaleDirection;
        if (i == 0) {
            this.mTextCenterX = f - (this.mMaxWidthOfDisplayedValues / 2);
        } else if (i == 2) {
            this.mTextCenterX = f + f;
        } else {
            this.mTextCenterX = f;
        }
    }

    private int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private void stopRefreshing() {
        Handler handler = this.mHandlerInNewThread;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    private void updateContent(String[] strArr) {
        this.mDisplayedValues = strArr;
        updateWrapStateByContent();
    }

    private void updateContentAndIndex(String[] strArr) {
        this.mMinShowIndex = 0;
        this.mMaxShowIndex = strArr.length - 1;
        this.mDisplayedValues = strArr;
        updateWrapStateByContent();
    }

    private void updateDividerAttr() {
        int i = this.mShowCount / 2;
        this.mDividerIndex0 = i;
        this.mDividerIndex1 = i + 1;
        int i2 = this.mViewHeight;
        this.dividerY0 = (i * i2) / r0;
        this.dividerY1 = (r2 * i2) / r0;
        if (this.mDividerMarginL < 0) {
            this.mDividerMarginL = 0;
        }
        if (this.mDividerMarginR < 0) {
            this.mDividerMarginR = 0;
        }
        if (this.mDividerMarginL + this.mDividerMarginR != 0 && getPaddingLeft() + this.mDividerMarginL >= (this.mViewWidth - getPaddingRight()) - this.mDividerMarginR) {
            int paddingLeft = getPaddingLeft() + this.mDividerMarginL + getPaddingRight();
            int i3 = this.mDividerMarginR;
            int i4 = (paddingLeft + i3) - this.mViewWidth;
            float f = this.mDividerMarginL;
            float f2 = i4;
            this.mDividerMarginL = (int) (f - ((f2 * f) / (r2 + i3)));
            float f3 = i3;
            this.mDividerMarginR = (int) (f3 - ((f2 * f3) / (r2 + i3)));
        }
    }

    private void updateFontAttr() {
        int i = this.mTextSizeNormal;
        int i2 = this.mItemHeight;
        if (i > i2) {
            this.mTextSizeNormal = i2;
        }
        if (this.mTextSizeSelected > i2) {
            this.mTextSizeSelected = i2;
        }
        Paint paint = this.mPaintHint;
        if (paint != null) {
            paint.setTextSize(this.mTextSizeHint);
            this.mTextSizeHintCenterYOffset = getTextCenterYOffset(this.mPaintHint.getFontMetrics());
            this.mWidthOfHintText = getTextWidth(this.mHintText, this.mPaintHint);
            TextPaint textPaint = this.mPaintText;
            if (textPaint != null) {
                textPaint.setTextSize(this.mTextSizeSelected);
                this.mTextSizeSelectedCenterYOffset = getTextCenterYOffset(this.mPaintText.getFontMetrics());
                this.mPaintText.setTextSize(this.mTextSizeNormal);
                this.mTextSizeNormalCenterYOffset = getTextCenterYOffset(this.mPaintText.getFontMetrics());
                return;
            }
            throw new IllegalArgumentException("mPaintText should not be null.");
        }
        throw new IllegalArgumentException("mPaintHint should not be null.");
    }

    private void updateMaxHeightOfDisplayedValues() {
        float textSize = this.mPaintText.getTextSize();
        this.mPaintText.setTextSize(this.mTextSizeSelected);
        this.mMaxHeightOfDisplayedValues = (int) ((this.mPaintText.getFontMetrics().bottom - this.mPaintText.getFontMetrics().top) + 0.5d);
        this.mPaintText.setTextSize(textSize);
    }

    private void updateMaxWHOfDisplayedValues(boolean z) {
        updateMaxWidthOfDisplayedValues();
        updateMaxHeightOfDisplayedValues();
        if (z) {
            if (this.mSpecModeW == Integer.MIN_VALUE || this.mSpecModeH == Integer.MIN_VALUE) {
                this.mHandlerInMainThread.sendEmptyMessage(3);
            }
        }
    }

    private void updateMaxWidthOfDisplayedValues() {
        float textSize = this.mPaintText.getTextSize();
        this.mPaintText.setTextSize(this.mTextSizeSelected);
        this.mMaxWidthOfDisplayedValues = getMaxWidthOfTextArray(this.mDisplayedValues, this.mPaintText);
        this.mMaxWidthOfAlterArrayWithMeasureHint = getMaxWidthOfTextArray(this.mAlterTextArrayWithMeasureHint, this.mPaintText);
        this.mMaxWidthOfAlterArrayWithoutMeasureHint = getMaxWidthOfTextArray(this.mAlterTextArrayWithoutMeasureHint, this.mPaintText);
        this.mPaintText.setTextSize(this.mTextSizeHint);
        this.mWidthOfAlterHint = getTextWidth(this.mAlterHint, this.mPaintText);
        this.mPaintText.setTextSize(textSize);
    }

    private void updateNotWrapYLimit() {
        this.mNotWrapLimitYTop = 0;
        this.mNotWrapLimitYBottom = (-this.mShowCount) * this.mItemHeight;
        if (this.mDisplayedValues != null) {
            int oneRecycleSize = getOneRecycleSize();
            int i = this.mShowCount / 2;
            int i2 = this.mItemHeight;
            this.mNotWrapLimitYTop = ((oneRecycleSize - i) - 1) * i2;
            this.mNotWrapLimitYBottom = (-i) * i2;
        }
    }

    private void updateValue() {
        inflateDisplayedValuesIfNull();
        updateWrapStateByContent();
        this.mMinShowIndex = 0;
        this.mMaxShowIndex = this.mDisplayedValues.length - 1;
    }

    private void updateValueForInit() {
        inflateDisplayedValuesIfNull();
        updateWrapStateByContent();
        if (this.mMinShowIndex == -1) {
            this.mMinShowIndex = 0;
        }
        if (this.mMaxShowIndex == -1) {
            this.mMaxShowIndex = this.mDisplayedValues.length - 1;
        }
        setMinAndMaxShowIndex(this.mMinShowIndex, this.mMaxShowIndex, false);
    }

    private void updateWrapStateByContent() {
        boolean z;
        if (this.mDisplayedValues.length <= this.mShowCount) {
            z = false;
        } else {
            z = true;
        }
        this.mWrapSelectorWheelCheck = z;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mItemHeight != 0 && this.mScroller.computeScrollOffset()) {
            this.mCurrDrawGlobalY = this.mScroller.getCurrY();
            calculateFirstItemParameterByGlobalY();
            postInvalidate();
        }
    }

    public void forbiddenScroll(boolean z) {
        this.mForbiddenScroll = z;
    }

    public String getContentByCurrValue() {
        return this.mDisplayedValues[getValue() - this.mMinValue];
    }

    public String[] getDisplayedValues() {
        return this.mDisplayedValues;
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public int getMinValue() {
        return this.mMinValue;
    }

    public int getOneRecycleSize() {
        if (LogUtil.LOGGABLE) {
            log("getOneRecycleSize mMaxShowIndex:" + this.mMaxShowIndex + ",mMinShowIndex:" + this.mMinShowIndex + ",final:" + ((this.mMaxShowIndex - this.mMinShowIndex) + 1));
        }
        return (this.mMaxShowIndex - this.mMinShowIndex) + 1;
    }

    public int getPickedIndexRelativeToRaw() {
        int i = this.mCurrDrawFirstItemY;
        if (i != 0) {
            int i2 = this.mItemHeight;
            if (i < (-i2) / 2) {
                return getWillPickIndexByGlobalY(this.mCurrDrawGlobalY + i2 + i);
            }
            return getWillPickIndexByGlobalY(this.mCurrDrawGlobalY + i);
        }
        return getWillPickIndexByGlobalY(this.mCurrDrawGlobalY);
    }

    public int getRawContentSize() {
        String[] strArr = this.mDisplayedValues;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    public int getValue() {
        return getPickedIndexRelativeToRaw() + this.mMinValue;
    }

    public boolean getWrapSelectorWheel() {
        return this.mWrapSelectorWheel;
    }

    public boolean getWrapSelectorWheelAbsolutely() {
        if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            initHandler();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandlerThread.quit();
        if (this.mItemHeight == 0) {
            return;
        }
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
            this.mCurrDrawGlobalY = this.mScroller.getCurrY();
            calculateFirstItemParameterByGlobalY();
            int i = this.mCurrDrawFirstItemY;
            if (i != 0) {
                int i2 = this.mItemHeight;
                if (i < (-i2) / 2) {
                    this.mCurrDrawGlobalY = this.mCurrDrawGlobalY + i2 + i;
                } else {
                    this.mCurrDrawGlobalY += i;
                }
                calculateFirstItemParameterByGlobalY();
            }
            onScrollStateChange(0);
        }
        int willPickIndexByGlobalY = getWillPickIndexByGlobalY(this.mCurrDrawGlobalY);
        int i3 = this.mPrevPickedIndex;
        if (willPickIndexByGlobalY != i3 && this.mRespondChangeOnDetach) {
            try {
                OnValueChangeListener onValueChangeListener = this.mOnValueChangeListener;
                if (onValueChangeListener != null) {
                    int i4 = this.mMinValue;
                    onValueChangeListener.onValueChange(this, i3 + i4, i4 + willPickIndexByGlobalY);
                }
                OnValueChangeListenerRelativeToRaw onValueChangeListenerRelativeToRaw = this.mOnValueChangeListenerRaw;
                if (onValueChangeListenerRelativeToRaw != null) {
                    onValueChangeListenerRelativeToRaw.onValueChangeRelativeToRaw(this, this.mPrevPickedIndex, willPickIndexByGlobalY, this.mDisplayedValues);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mPrevPickedIndex = willPickIndexByGlobalY;
        log("onDetachedFromWindow mPrevPickedIndex:" + this.mPrevPickedIndex);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawContent(canvas);
        drawLine(canvas);
        drawHint(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        updateMaxWHOfDisplayedValues(false);
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onSizeChanged(i, i2, i3, i4);
        this.mViewWidth = i;
        this.mViewHeight = i2;
        this.mItemHeight = i2 / this.mShowCount;
        this.mViewCenterX = ((i + getPaddingLeft()) - getPaddingRight()) / 2.0f;
        boolean z = false;
        if (getOneRecycleSize() > 1) {
            if (this.mHasInit) {
                i5 = getValue() - this.mMinValue;
            } else if (this.mCurrentItemIndexEffect) {
                i5 = this.mCurrDrawFirstItemIndex + ((this.mShowCount - 1) / 2);
            }
            if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
                z = true;
            }
            correctPositionByDefaultValue(i5, z);
            updateFontAttr();
            updateNotWrapYLimit();
            updateDividerAttr();
            this.mHasInit = true;
        }
        i5 = 0;
        if (this.mWrapSelectorWheel) {
            z = true;
        }
        correctPositionByDefaultValue(i5, z);
        updateFontAttr();
        updateNotWrapYLimit();
        updateDividerAttr();
        this.mHasInit = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x009c, code lost:
    
        if (r1 < r3) goto L40;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.futuretrip.BNRRNumberPickerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void refreshByNewDisplayedValues(String[] strArr) {
        int minValue = getMinValue();
        int maxValue = (getMaxValue() - minValue) + 1;
        int length = strArr.length - 1;
        if ((length - minValue) + 1 > maxValue) {
            setDisplayedValues(strArr);
            setMaxValue(length);
        } else {
            setMaxValue(length);
            setDisplayedValues(strArr);
        }
    }

    public void resetDisplayValues() {
        this.mDisplayedValues = null;
        this.mMaxValue = 0;
        this.mMinValue = 0;
    }

    public void resetPrevPickedIndex(int i) {
        this.mPrevPickedIndex = i;
    }

    public void setContentTextTypeface(Typeface typeface) {
        this.mPaintText.setTypeface(typeface);
    }

    public void setDisplayedValues(String[] strArr, boolean z) {
        setDisplayedValuesAndPickedIndex(strArr, 0, z);
    }

    public void setDisplayedValuesAndPickedIndex(String[] strArr, int i, boolean z) {
        boolean z2;
        stopScrolling();
        if (strArr != null) {
            if (i >= 0) {
                updateContent(strArr);
                updateMaxWHOfDisplayedValues(true);
                updateNotWrapYLimit();
                updateValue();
                this.mPrevPickedIndex = this.mMinShowIndex + i;
                log("setDisplayedValuesAndPickedIndex mPrevPickedIndex:" + this.mPrevPickedIndex);
                if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                correctPositionByDefaultValue(i, z2);
                if (z) {
                    this.mHandlerInNewThread.sendMessageDelayed(getMsg(1), 0L);
                    postInvalidate();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("pickedIndex should not be negative, now pickedIndex is " + i);
        }
        throw new IllegalArgumentException("newDisplayedValues should not be null.");
    }

    public void setDividerColor(int i) {
        if (this.mDividerColor == i) {
            return;
        }
        this.mDividerColor = i;
        this.mPaintDivider.setColor(i);
        postInvalidate();
    }

    public void setFriction(float f) {
        if (f > 0.0f) {
            ViewConfiguration.get(getContext());
            this.mFriction = ViewConfiguration.getScrollFriction() / f;
        } else {
            throw new IllegalArgumentException("you should set a a positive float friction, now friction is " + f);
        }
    }

    public void setHintText(String str) {
        if (isStringEqual(this.mHintText, str)) {
            return;
        }
        this.mHintText = str;
        this.mTextSizeHintCenterYOffset = getTextCenterYOffset(this.mPaintHint.getFontMetrics());
        this.mWidthOfHintText = getTextWidth(this.mHintText, this.mPaintHint);
        this.mHandlerInMainThread.sendEmptyMessage(3);
    }

    public void setHintTextColor(int i) {
        if (this.mTextColorHint == i) {
            return;
        }
        this.mTextColorHint = i;
        this.mPaintHint.setColor(i);
        postInvalidate();
    }

    public void setHintTextTypeface(Typeface typeface) {
        this.mPaintHint.setTypeface(typeface);
    }

    public void setIgnoreStartIndex(int i) {
        this.mIgnoreStartIndex = i;
    }

    public void setMaxValue(int i) {
        String[] strArr = this.mDisplayedValues;
        if (strArr != null) {
            int i2 = i - this.mMinValue;
            if (i2 + 1 <= strArr.length) {
                this.mMaxValue = i;
                int i3 = this.mMinShowIndex;
                int i4 = i2 + i3;
                this.mMaxShowIndex = i4;
                setMinAndMaxShowIndex(i3, i4);
                updateNotWrapYLimit();
                return;
            }
            throw new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + ((i - this.mMinValue) + 1) + " and mDisplayedValues.length is " + this.mDisplayedValues.length);
        }
        throw new NullPointerException("mDisplayedValues should not be null");
    }

    public void setMinAndMaxShowIndex(int i, int i2) {
        setMinAndMaxShowIndex(i, i2, true);
    }

    public void setMinValue(int i) {
        this.mMinValue = i;
        this.mMinShowIndex = 0;
        updateNotWrapYLimit();
    }

    public void setNormalTextColor(int i) {
        if (this.mTextColorNormal == i) {
            return;
        }
        this.mTextColorNormal = i;
        postInvalidate();
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    public void setOnValueChangeListenerInScrolling(OnValueChangeListenerInScrolling onValueChangeListenerInScrolling) {
        this.mOnValueChangeListenerInScrolling = onValueChangeListenerInScrolling;
    }

    public void setOnValueChangedListener(OnValueChangeListener onValueChangeListener) {
        this.mOnValueChangeListener = onValueChangeListener;
    }

    public void setOnValueChangedListenerRelativeToRaw(OnValueChangeListenerRelativeToRaw onValueChangeListenerRelativeToRaw) {
        this.mOnValueChangeListenerRaw = onValueChangeListenerRelativeToRaw;
    }

    public void setPickedIndexRelativeToMin(int i) {
        boolean z;
        if (i >= 0 && i < getOneRecycleSize()) {
            this.mPrevPickedIndex = this.mMinShowIndex + i;
            log("setPickedIndexRelativeToMin mPrevPickedIndex:" + this.mPrevPickedIndex);
            if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
                z = true;
            } else {
                z = false;
            }
            correctPositionByDefaultValue(i, z);
            postInvalidate();
        }
    }

    public void setPickedIndexRelativeToRaw(int i) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (LogUtil.LOGGABLE) {
            log("setPickedIndexRelativeToRaw pickedIndexToRaw:" + i);
            log("setPickedIndexRelativeToRaw mMaxShowIndex:" + this.mMaxShowIndex);
            log("setPickedIndexRelativeToRaw mMinShowIndex:" + this.mMinShowIndex);
            StringBuilder sb = new StringBuilder();
            sb.append("setPickedIndexRelativeToRaw (mMinShowIndex <= pickedIndexToRaw):");
            if (this.mMinShowIndex <= i) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            log(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setPickedIndexRelativeToRaw (pickedIndexToRaw <= mMaxShowIndex):");
            if (i <= this.mMaxShowIndex) {
                z2 = true;
            } else {
                z2 = false;
            }
            sb2.append(z2);
            log(sb2.toString());
        }
        int i2 = this.mMinShowIndex;
        if (i2 > -1 && i2 <= i && i <= this.mMaxShowIndex) {
            this.mPrevPickedIndex = i;
            log("setPickedIndexRelativeToRaw mPrevPickedIndex:" + this.mPrevPickedIndex);
            int i3 = i - this.mMinShowIndex;
            if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
                z3 = true;
            }
            correctPositionByDefaultValue(i3, z3);
            postInvalidate();
        }
        log("setPickedIndexRelativeToRaw mPrevPickedIndex:" + this.mPrevPickedIndex);
    }

    public void setSelectedTextColor(int i) {
        if (this.mTextColorSelected == i) {
            return;
        }
        this.mTextColorSelected = i;
        postInvalidate();
    }

    public void setValue(int i) {
        int i2 = this.mMinValue;
        if (i < i2) {
            if (!LogUtil.LOGGABLE) {
                i = i2;
            } else {
                throw new IllegalArgumentException("should not set a value less than mMinValue, value is " + i);
            }
        }
        int i3 = this.mMaxValue;
        if (i > i3) {
            if (!LogUtil.LOGGABLE) {
                i = i3;
            } else {
                throw new IllegalArgumentException("should not set a value greater than mMaxValue, value is " + i);
            }
        }
        setPickedIndexRelativeToRaw(i - i2);
    }

    public void setWrapSelectorWheel(boolean z) {
        if (this.mWrapSelectorWheel != z) {
            if (!z) {
                if (this.mScrollState == 0) {
                    internalSetWrapToLinear();
                    return;
                } else {
                    this.mPendingWrapToLinear = true;
                    return;
                }
            }
            this.mWrapSelectorWheel = z;
            updateWrapStateByContent();
            postInvalidate();
        }
    }

    public void smoothScrollToValue(int i) {
        smoothScrollToValue(getValue(), i, true);
    }

    public void smoothScrollToValueQuick(int i, int i2, boolean z, boolean z2) {
        boolean z3;
        int i3 = this.mMinValue;
        int i4 = this.mMaxValue;
        boolean z4 = false;
        if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
            z3 = true;
        } else {
            z3 = false;
        }
        int refineValueByLimit = refineValueByLimit(i, i3, i4, z3);
        int i5 = this.mMinValue;
        int i6 = this.mMaxValue;
        if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
            z4 = true;
        }
        int refineValueByLimit2 = refineValueByLimit(i2, i5, i6, z4);
        if (refineValueByLimit == refineValueByLimit2) {
            return;
        }
        scrollByIndexSmoothly(refineValueByLimit2 - refineValueByLimit, z, z2);
    }

    public void stopScrolling() {
        ScrollerCompat scrollerCompat = this.mScroller;
        if (scrollerCompat != null && !scrollerCompat.isFinished()) {
            ScrollerCompat scrollerCompat2 = this.mScroller;
            scrollerCompat2.startScroll(0, scrollerCompat2.getCurrY(), 0, 0, 1);
            this.mScroller.abortAnimation();
            postInvalidate();
        }
    }

    public void stopScrollingAndCorrectPosition() {
        stopScrolling();
        Handler handler = this.mHandlerInNewThread;
        if (handler != null) {
            handler.sendMessageDelayed(getMsg(1), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message getMsg(int i, int i2, int i3, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.obj = obj;
        return obtain;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x003a, code lost:
    
        if (r10 < 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void scrollByIndexSmoothly(int r10, boolean r11, boolean r12) {
        /*
            r9 = this;
            boolean r0 = r9.mWrapSelectorWheel
            if (r0 == 0) goto L8
            boolean r0 = r9.mWrapSelectorWheelCheck
            if (r0 != 0) goto L1a
        L8:
            int r0 = r9.getPickedIndexRelativeToRaw()
            int r1 = r0 + r10
            int r2 = r9.mMaxShowIndex
            if (r1 <= r2) goto L15
        L12:
            int r10 = r2 - r0
            goto L1a
        L15:
            int r2 = r9.mMinShowIndex
            if (r1 >= r2) goto L1a
            goto L12
        L1a:
            int r0 = r9.mCurrDrawFirstItemY
            int r1 = r9.mItemHeight
            int r2 = -r1
            int r2 = r2 / 2
            r3 = 1133903872(0x43960000, float:300.0)
            if (r0 >= r2) goto L33
            int r0 = r0 + r1
            float r2 = (float) r0
            float r2 = r2 * r3
            float r3 = (float) r1
            float r2 = r2 / r3
            int r2 = (int) r2
            if (r10 >= 0) goto L3d
            int r2 = -r2
        L2f:
            int r3 = r10 * 300
            int r2 = r2 - r3
            goto L40
        L33:
            int r2 = -r0
            float r2 = (float) r2
            float r2 = r2 * r3
            float r3 = (float) r1
            float r2 = r2 / r3
            int r2 = (int) r2
            if (r10 >= 0) goto L3d
            goto L2f
        L3d:
            int r3 = r10 * 300
            int r2 = r2 + r3
        L40:
            int r10 = r10 * r1
            int r7 = r0 + r10
            r10 = 300(0x12c, float:4.2E-43)
            if (r2 >= r10) goto L4a
            r2 = 300(0x12c, float:4.2E-43)
        L4a:
            r10 = 600(0x258, float:8.41E-43)
            if (r2 <= r10) goto L50
            r2 = 600(0x258, float:8.41E-43)
        L50:
            r10 = 0
            if (r12 == 0) goto L54
            goto L55
        L54:
            r2 = 0
        L55:
            androidx.core.widget.ScrollerCompat r3 = r9.mScroller
            int r5 = r9.mCurrDrawGlobalY
            r4 = 0
            r6 = 0
            r8 = r2
            r3.startScroll(r4, r5, r6, r7, r8)
            r12 = 1
            if (r11 == 0) goto L6f
            android.os.Handler r10 = r9.mHandlerInNewThread
            android.os.Message r11 = r9.getMsg(r12)
            int r2 = r2 / 4
            long r0 = (long) r2
            r10.sendMessageDelayed(r11, r0)
            goto L80
        L6f:
            android.os.Handler r0 = r9.mHandlerInNewThread
            java.lang.Boolean r1 = new java.lang.Boolean
            r1.<init>(r11)
            android.os.Message r10 = r9.getMsg(r12, r10, r10, r1)
            int r2 = r2 / 4
            long r11 = (long) r2
            r0.sendMessageDelayed(r10, r11)
        L80:
            r9.postInvalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.futuretrip.BNRRNumberPickerView.scrollByIndexSmoothly(int, boolean, boolean):void");
    }

    public void setDisplayedValues(String[] strArr) {
        stopRefreshing();
        stopScrolling();
        if (strArr == null) {
            throw new IllegalArgumentException("newDisplayedValues should not be null.");
        }
        if ((this.mMaxValue - this.mMinValue) + 1 <= strArr.length) {
            updateContent(strArr);
            updateMaxWHOfDisplayedValues(true);
            this.mPrevPickedIndex = this.mMinShowIndex;
            log("setDisplayedValues mPrevPickedIndex:" + this.mPrevPickedIndex);
            correctPositionByDefaultValue(0, this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck);
            postInvalidate();
            this.mHandlerInMainThread.sendEmptyMessage(3);
            return;
        }
        throw new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + ((this.mMaxValue - this.mMinValue) + 1) + " newDisplayedValues.length is " + strArr.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setMinAndMaxShowIndex(int r5, int r6, boolean r7) {
        /*
            r4 = this;
            boolean r0 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
            if (r0 == 0) goto L21
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "setMinAndMaxShowIndex,params,minShowIndex:"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = ",maxShowIndex:"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r4.log(r0)
        L21:
            if (r5 > r6) goto Lbc
            java.lang.String[] r0 = r4.mDisplayedValues
            if (r0 == 0) goto Lb4
            boolean r0 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
            r1 = 1
            if (r0 == 0) goto L45
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "setMinAndMaxShowIndex,mDisplayedValues.length - 1:"
            r0.append(r2)
            java.lang.String[] r2 = r4.mDisplayedValues
            int r2 = r2.length
            int r2 = r2 - r1
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r4.log(r0)
        L45:
            r0 = 0
            if (r5 >= 0) goto L49
            goto L4f
        L49:
            java.lang.String[] r2 = r4.mDisplayedValues
            int r2 = r2.length
            int r2 = r2 - r1
            if (r5 <= r2) goto L50
        L4f:
            r5 = 0
        L50:
            if (r6 >= 0) goto L57
            java.lang.String[] r6 = r4.mDisplayedValues
            int r6 = r6.length
        L55:
            int r6 = r6 - r1
            goto L5f
        L57:
            java.lang.String[] r2 = r4.mDisplayedValues
            int r3 = r2.length
            int r3 = r3 - r1
            if (r6 <= r3) goto L5f
            int r6 = r2.length
            goto L55
        L5f:
            boolean r2 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
            if (r2 == 0) goto L84
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "setMinAndMaxShowIndex,mMinShowIndex:"
            r2.append(r3)
            int r3 = r4.mMinShowIndex
            r2.append(r3)
            java.lang.String r3 = ",mMaxShowIndex:"
            r2.append(r3)
            int r3 = r4.mMaxShowIndex
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r4.log(r2)
        L84:
            r4.mMinShowIndex = r5
            r4.mMaxShowIndex = r6
            if (r7 == 0) goto Lb3
            r4.mPrevPickedIndex = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "setMinAndMaxShowIndex mPrevPickedIndex:"
            r5.append(r6)
            int r6 = r4.mPrevPickedIndex
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.log(r5)
            boolean r5 = r4.mWrapSelectorWheel
            if (r5 == 0) goto Lac
            boolean r5 = r4.mWrapSelectorWheelCheck
            if (r5 == 0) goto Lac
            goto Lad
        Lac:
            r1 = 0
        Lad:
            r4.correctPositionByDefaultValue(r0, r1)
            r4.postInvalidate()
        Lb3:
            return
        Lb4:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "mDisplayedValues should not be null, you need to set mDisplayedValues first."
            r5.<init>(r6)
            throw r5
        Lbc:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "minShowIndex should be less than maxShowIndex, minShowIndex is "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = ", maxShowIndex is "
            r0.append(r5)
            r0.append(r6)
            java.lang.String r5 = "."
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r7.<init>(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.futuretrip.BNRRNumberPickerView.setMinAndMaxShowIndex(int, int, boolean):void");
    }

    public void smoothScrollToValue(int i, boolean z) {
        smoothScrollToValue(getValue(), i, z);
    }

    public void smoothScrollToValue(int i, int i2) {
        smoothScrollToValue(i, i2, true);
    }

    public void smoothScrollToValue(int i, int i2, boolean z) {
        int i3;
        boolean z2 = false;
        int refineValueByLimit = refineValueByLimit(i, this.mMinValue, this.mMaxValue, this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck);
        int i4 = this.mMinValue;
        int i5 = this.mMaxValue;
        if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
            z2 = true;
        }
        int refineValueByLimit2 = refineValueByLimit(i2, i4, i5, z2);
        if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
            i3 = refineValueByLimit2 - refineValueByLimit;
            int oneRecycleSize = getOneRecycleSize() / 2;
            if (i3 < (-oneRecycleSize) || oneRecycleSize < i3) {
                i3 = i3 > 0 ? i3 - getOneRecycleSize() : i3 + getOneRecycleSize();
            }
        } else {
            i3 = refineValueByLimit2 - refineValueByLimit;
        }
        setValue(refineValueByLimit);
        if (refineValueByLimit == refineValueByLimit2) {
            return;
        }
        scrollByIndexSmoothly(i3, z, true);
    }

    public BNRRNumberPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTextColorNormal = DEFAULT_TEXT_COLOR_NORMAL;
        this.mTextColorSelected = -695533;
        this.mTextColorHint = -695533;
        this.mTextSizeNormal = 0;
        this.mTextSizeSelected = 0;
        this.mTextSizeHint = 0;
        this.mWidthOfHintText = 0;
        this.mWidthOfAlterHint = 0;
        this.mMarginStartOfHint = 0;
        this.mMarginEndOfHint = 0;
        this.mItemPaddingVertical = 0;
        this.mItemPaddingHorizontal = 0;
        this.mDividerColor = -695533;
        this.mDividerHeight = 2;
        this.mDividerMarginL = 0;
        this.mDividerMarginR = 0;
        this.mShowCount = 3;
        this.mDividerIndex0 = 0;
        this.mDividerIndex1 = 0;
        this.mMinShowIndex = -1;
        this.mMaxShowIndex = -1;
        this.mMinValue = 0;
        this.mMaxValue = 0;
        this.mMaxWidthOfDisplayedValues = 0;
        this.mMaxHeightOfDisplayedValues = 0;
        this.mMaxWidthOfAlterArrayWithMeasureHint = 0;
        this.mMaxWidthOfAlterArrayWithoutMeasureHint = 0;
        this.mPrevPickedIndex = 0;
        this.mMiniVelocityFling = 150;
        this.mScaledTouchSlop = 8;
        this.mSelectScaleDirection = 1;
        this.mDividerIgnorePadding = false;
        this.mFriction = 1.0f;
        this.mTextSizeNormalCenterYOffset = 0.0f;
        this.mTextSizeSelectedCenterYOffset = 0.0f;
        this.mTextSizeHintCenterYOffset = 0.0f;
        this.mShowDivider = true;
        this.mWrapSelectorWheel = true;
        this.mCurrentItemIndexEffect = false;
        this.mHasInit = false;
        this.mWrapSelectorWheelCheck = true;
        this.mPendingWrapToLinear = false;
        this.mRespondChangeOnDetach = false;
        this.mRespondChangeInMainThread = true;
        this.mPaintDivider = new Paint();
        this.mPaintText = new TextPaint();
        this.mPaintHint = new Paint();
        this.mScrollState = 0;
        this.mGap = 0;
        this.downYGlobal = 0.0f;
        this.downY = 0.0f;
        this.currY = 0.0f;
        this.mFlagMayPress = false;
        this.mCurrDrawFirstItemIndex = 0;
        this.mCurrDrawFirstItemY = 0;
        this.mCurrDrawGlobalY = 0;
        this.mSpecModeW = 0;
        this.mSpecModeH = 0;
        initAttr(context, attributeSet);
        init(context);
    }

    public BNRRNumberPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextColorNormal = DEFAULT_TEXT_COLOR_NORMAL;
        this.mTextColorSelected = -695533;
        this.mTextColorHint = -695533;
        this.mTextSizeNormal = 0;
        this.mTextSizeSelected = 0;
        this.mTextSizeHint = 0;
        this.mWidthOfHintText = 0;
        this.mWidthOfAlterHint = 0;
        this.mMarginStartOfHint = 0;
        this.mMarginEndOfHint = 0;
        this.mItemPaddingVertical = 0;
        this.mItemPaddingHorizontal = 0;
        this.mDividerColor = -695533;
        this.mDividerHeight = 2;
        this.mDividerMarginL = 0;
        this.mDividerMarginR = 0;
        this.mShowCount = 3;
        this.mDividerIndex0 = 0;
        this.mDividerIndex1 = 0;
        this.mMinShowIndex = -1;
        this.mMaxShowIndex = -1;
        this.mMinValue = 0;
        this.mMaxValue = 0;
        this.mMaxWidthOfDisplayedValues = 0;
        this.mMaxHeightOfDisplayedValues = 0;
        this.mMaxWidthOfAlterArrayWithMeasureHint = 0;
        this.mMaxWidthOfAlterArrayWithoutMeasureHint = 0;
        this.mPrevPickedIndex = 0;
        this.mMiniVelocityFling = 150;
        this.mScaledTouchSlop = 8;
        this.mSelectScaleDirection = 1;
        this.mDividerIgnorePadding = false;
        this.mFriction = 1.0f;
        this.mTextSizeNormalCenterYOffset = 0.0f;
        this.mTextSizeSelectedCenterYOffset = 0.0f;
        this.mTextSizeHintCenterYOffset = 0.0f;
        this.mShowDivider = true;
        this.mWrapSelectorWheel = true;
        this.mCurrentItemIndexEffect = false;
        this.mHasInit = false;
        this.mWrapSelectorWheelCheck = true;
        this.mPendingWrapToLinear = false;
        this.mRespondChangeOnDetach = false;
        this.mRespondChangeInMainThread = true;
        this.mPaintDivider = new Paint();
        this.mPaintText = new TextPaint();
        this.mPaintHint = new Paint();
        this.mScrollState = 0;
        this.mGap = 0;
        this.downYGlobal = 0.0f;
        this.downY = 0.0f;
        this.currY = 0.0f;
        this.mFlagMayPress = false;
        this.mCurrDrawFirstItemIndex = 0;
        this.mCurrDrawFirstItemY = 0;
        this.mCurrDrawGlobalY = 0;
        this.mSpecModeW = 0;
        this.mSpecModeH = 0;
        initAttr(context, attributeSet);
        init(context);
    }
}
