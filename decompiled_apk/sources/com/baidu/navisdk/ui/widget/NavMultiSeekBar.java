package com.baidu.navisdk.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes8.dex */
public class NavMultiSeekBar extends View {
    private static final int mTrackHeight = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_2dp);

    /* renamed from: a, reason: collision with root package name */
    private final TypedArray f9210a;
    private int defRangeColor;
    private Drawable defRangeDrawable;
    private int defThumbColor;
    private Drawable defThumbDrawable;
    LinkedList<Thumb> exactTouched;
    private AccessibilityNodeProvider mAccessibilityNodeProvider;
    private final List<Thumb> mDraggingThumbs;
    private boolean mDrawThumbsApart;
    private int mKeyProgressIncrement;
    int mMaxHeight;
    int mMaxWidth;
    int mMinHeight;
    int mMinWidth;
    boolean mMirrorForRtl;
    private OnThumbValueChangeListener mOnThumbValueChangeListener;
    private int mScaleMax;
    private int mScaleMin;
    private int mScaledTouchSlop;
    private int mStep;
    private int mStepsThumbsApart;
    private final LinkedList<Thumb> mThumbs;
    private float mTouchDownX;
    private Drawable mTrack;

    /* loaded from: classes8.dex */
    public interface OnThumbValueChangeListener {
        void onValueChanged(NavMultiSeekBar navMultiSeekBar, Thumb thumb, int i, int i2);
    }

    /* loaded from: classes8.dex */
    public static class SimpleChangeListener implements OnThumbValueChangeListener {
        @Override // com.baidu.navisdk.ui.widget.NavMultiSeekBar.OnThumbValueChangeListener
        public void onValueChanged(NavMultiSeekBar navMultiSeekBar, Thumb thumb, int i, int i2) {
        }
    }

    /* loaded from: classes8.dex */
    public class Thumb {
        int max;
        int min;
        Drawable range;
        Drawable thumb;
        int thumbOffset;
        int value;
        String tag = "thumb";
        private boolean isInvisible = false;
        private boolean isEnabled = true;

        public Thumb() {
            this.min = NavMultiSeekBar.this.mScaleMin;
            int i = NavMultiSeekBar.this.mScaleMax;
            this.max = i;
            this.value = i;
        }

        public int getMax() {
            return this.max;
        }

        public int getMin() {
            return this.min;
        }

        public int getPossibleMax() {
            return this.max - (((NavMultiSeekBar.this.mThumbs.size() - 1) - NavMultiSeekBar.this.mThumbs.indexOf(this)) * NavMultiSeekBar.this.mStepsThumbsApart);
        }

        public int getPossibleMin() {
            return this.min + (NavMultiSeekBar.this.mThumbs.indexOf(this) * NavMultiSeekBar.this.mStepsThumbsApart);
        }

        public Drawable getRange() {
            return this.range;
        }

        public String getTag() {
            return this.tag;
        }

        public Drawable getThumb() {
            return this.thumb;
        }

        public int getThumbOffset() {
            return this.thumbOffset;
        }

        public int getValue() {
            return this.value;
        }

        public boolean isEnabled() {
            if (!isInvisibleThumb() && this.isEnabled) {
                return true;
            }
            return false;
        }

        public boolean isInvisibleThumb() {
            return this.isInvisible;
        }

        public Thumb setEnabled(boolean z) {
            this.isEnabled = z;
            if (getThumb() != null) {
                if (isEnabled()) {
                    getThumb().setState(new int[]{android.R.attr.state_enabled});
                } else {
                    getThumb().setState(new int[]{-16842910});
                }
            }
            return this;
        }

        public void setInvisibleThumb(boolean z) {
            this.isInvisible = z;
        }

        public Thumb setMax(int i) {
            int i2 = this.min;
            if (i < i2) {
                i = i2;
            }
            if (i > NavMultiSeekBar.this.mScaleMax) {
                i = NavMultiSeekBar.this.mScaleMax;
            }
            if (this.max != i) {
                this.max = i;
                if (this.value > i) {
                    this.value = i;
                    NavMultiSeekBar.this.invalidate();
                }
            }
            return this;
        }

        public Thumb setMin(int i) {
            int i2 = this.max;
            if (i > i2) {
                i = i2;
            }
            if (i < NavMultiSeekBar.this.mScaleMin) {
                i = NavMultiSeekBar.this.mScaleMin;
            }
            if (this.min != i) {
                this.min = i;
                if (this.value < i) {
                    this.value = i;
                    NavMultiSeekBar.this.invalidate();
                }
            }
            return this;
        }

        public final Thumb setRange(Drawable drawable) {
            this.range = drawable;
            return this;
        }

        public Thumb setTag(String str) {
            this.tag = str;
            return this;
        }

        public Thumb setThumb(Drawable drawable) {
            this.thumb = drawable;
            return this;
        }

        public Thumb setThumbOffset(int i) {
            this.thumbOffset = i;
            return this;
        }

        public Thumb setValue(int i) {
            if (NavMultiSeekBar.this.mThumbs.contains(this)) {
                NavMultiSeekBar.this.setThumbValue(this, i, false);
            } else {
                this.value = i;
            }
            return this;
        }
    }

    @TargetApi(16)
    /* loaded from: classes8.dex */
    public class VirtualTreeProvider extends AccessibilityNodeProvider {
        static final int ACT_SET_PROGRESS = 16908349;
        final AccessibilityNodeInfo.AccessibilityAction ACTION_SET_PROGRESS = new AccessibilityNodeInfo.AccessibilityAction(16908349, null);

        public VirtualTreeProvider() {
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            if (i == -1) {
                AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(NavMultiSeekBar.this);
                NavMultiSeekBar.this.onInitializeAccessibilityNodeInfo(obtain);
                int size = NavMultiSeekBar.this.mThumbs.size();
                for (int i2 = 0; i2 < size; i2++) {
                    obtain.addChild(NavMultiSeekBar.this, i2);
                }
                if (NavMultiSeekBar.this.mThumbs.size() == 1) {
                    obtain.setScrollable(true);
                    obtain.addAction(this.ACTION_SET_PROGRESS);
                    obtain.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
                    obtain.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                    return obtain;
                }
                return obtain;
            }
            Thumb thumb = (Thumb) NavMultiSeekBar.this.mThumbs.get(i);
            if (thumb == null) {
                return null;
            }
            AccessibilityNodeInfo obtain2 = AccessibilityNodeInfo.obtain(NavMultiSeekBar.this, i);
            obtain2.setClassName(thumb.getClass().getName());
            obtain2.setParent(NavMultiSeekBar.this);
            obtain2.setSource(NavMultiSeekBar.this, i);
            obtain2.setContentDescription("Multi-Slider thumb no:" + i);
            int i3 = Build.VERSION.SDK_INT;
            obtain2.addAction(this.ACTION_SET_PROGRESS);
            if (thumb.getPossibleMax() > thumb.value) {
                obtain2.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
            }
            if (thumb.getPossibleMax() > thumb.value) {
                obtain2.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            }
            if (thumb.getThumb() != null) {
                int[] iArr = new int[2];
                NavMultiSeekBar.this.getLocationOnScreen(iArr);
                Rect copyBounds = thumb.getThumb().copyBounds();
                int i4 = copyBounds.top;
                int i5 = iArr[1];
                copyBounds.top = i4 + i5;
                int i6 = copyBounds.left;
                int i7 = iArr[0];
                copyBounds.left = i6 + i7;
                copyBounds.right += i7;
                copyBounds.bottom += i5;
                obtain2.setBoundsInScreen(copyBounds);
            }
            obtain2.setText(thumb.tag + ": " + thumb.value);
            obtain2.setEnabled(thumb.isEnabled());
            if (i3 >= 24) {
                obtain2.setImportantForAccessibility(true);
            }
            obtain2.setVisibleToUser(true);
            obtain2.setScrollable(true);
            return obtain2;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            if (TextUtils.isEmpty(str)) {
                return Collections.emptyList();
            }
            String lowerCase = str.toLowerCase();
            ArrayList arrayList = null;
            if (i == -1) {
                int size = NavMultiSeekBar.this.mThumbs.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (((Thumb) NavMultiSeekBar.this.mThumbs.get(i2)).tag.toLowerCase().contains(lowerCase)) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(createAccessibilityNodeInfo(i2));
                    }
                }
            } else {
                Thumb thumb = (Thumb) NavMultiSeekBar.this.mThumbs.get(i);
                if (thumb != null && thumb.tag.toLowerCase().contains(lowerCase)) {
                    arrayList = new ArrayList();
                    arrayList.add(createAccessibilityNodeInfo(i));
                }
            }
            if (arrayList == null) {
                return Collections.emptyList();
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            return super.findFocus(i);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            Thumb thumb;
            if (i == -1 || i >= NavMultiSeekBar.this.mThumbs.size() || (thumb = (Thumb) NavMultiSeekBar.this.mThumbs.get(i)) == null) {
                return false;
            }
            if (i2 != 4096) {
                if (i2 != 8192) {
                    if (i2 != 16908349) {
                        return false;
                    }
                    thumb.setValue(bundle.getInt("value"));
                    return true;
                }
                thumb.setValue(thumb.value - NavMultiSeekBar.this.getStep());
                return true;
            }
            thumb.setValue(thumb.value + NavMultiSeekBar.this.getStep());
            return true;
        }
    }

    public NavMultiSeekBar(Context context) {
        this(context, null);
    }

    private void attemptClaimDrag() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private int getAvailable() {
        int thumbOptOffset;
        int width = getWidth() - (JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_25dp) * 2);
        LinkedList<Thumb> linkedList = this.mThumbs;
        if (linkedList != null && linkedList.size() > 0) {
            if (isLayoutRtl() && this.mMirrorForRtl) {
                thumbOptOffset = getThumbOptOffset(this.mThumbs.getFirst());
            } else {
                thumbOptOffset = getThumbOptOffset(this.mThumbs.getLast());
            }
            return width - thumbOptOffset;
        }
        return width;
    }

    private LinkedList<Thumb> getClosestThumb(int i) {
        LinkedList<Thumb> linkedList = new LinkedList<>();
        int available = getAvailable() + 1;
        Iterator<Thumb> it = this.mThumbs.iterator();
        Thumb thumb = null;
        while (it.hasNext()) {
            Thumb next = it.next();
            if (next.getThumb() != null && next.isEnabled() && !this.mDraggingThumbs.contains(next)) {
                int intrinsicWidth = i - next.getThumb().getIntrinsicWidth();
                int intrinsicWidth2 = next.getThumb().getIntrinsicWidth() + i;
                if (next.getThumb().getBounds().centerX() >= intrinsicWidth && next.getThumb().getBounds().centerX() <= intrinsicWidth2) {
                    linkedList.add(next);
                } else if (Math.abs(next.getThumb().getBounds().centerX() - i) <= available) {
                    if (Math.abs(next.getThumb().getBounds().centerX() - i) == available) {
                        if (i > getWidth() / 2) {
                            thumb = next;
                        }
                    } else if (next.getThumb() != null) {
                        available = Math.abs(next.getThumb().getBounds().centerX() - i);
                        thumb = next;
                    }
                }
            }
        }
        if (linkedList.isEmpty() && thumb != null) {
            linkedList.add(thumb);
        }
        return linkedList;
    }

    private Thumb getMostMovable(LinkedList<Thumb> linkedList, MotionEvent motionEvent) {
        int i;
        Thumb thumb = null;
        if (linkedList != null && !linkedList.isEmpty()) {
            if (linkedList.getFirst().getValue() == getValue(motionEvent, linkedList.getFirst())) {
                return null;
            }
            Iterator<Thumb> it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Thumb next = it.next();
                if (next.getThumb() != null && next.isEnabled() && !this.mDraggingThumbs.contains(next)) {
                    if (getValue(motionEvent, linkedList.getFirst()) > next.getValue()) {
                        i = this.mScaleMax;
                    } else {
                        i = this.mScaleMin;
                    }
                    int abs = Math.abs(next.getValue() - optThumbValue(next, i));
                    if (abs > i2) {
                        thumb = next;
                        i2 = abs;
                    }
                }
            }
        }
        return thumb;
    }

    private Thumb getMostMovableThumb(MotionEvent motionEvent) {
        LinkedList<Thumb> linkedList = this.exactTouched;
        if (linkedList != null && linkedList.size() >= 1) {
            if (this.exactTouched.size() == 1) {
                return this.exactTouched.getFirst();
            }
            return getMostMovable(this.exactTouched, motionEvent);
        }
        return null;
    }

    private Drawable getTintedDrawable(Drawable drawable, int i) {
        if (drawable != null && i != 0) {
            Drawable wrap = DrawableCompat.wrap(drawable.mutate());
            DrawableCompat.setTint(wrap, i);
            return wrap;
        }
        return drawable;
    }

    private int getValue(MotionEvent motionEvent, Thumb thumb) {
        return getValue(motionEvent, motionEvent.getActionIndex(), thumb);
    }

    private boolean hasOnThumbValueChangeListener() {
        if (this.mOnThumbValueChangeListener != null) {
            return true;
        }
        return false;
    }

    private void initMultiSlider(int i) {
        this.mStep = 1;
        this.mStepsThumbsApart = 0;
        this.mDrawThumbsApart = false;
        this.mScaleMin = 0;
        this.mScaleMax = 100;
        this.mMinWidth = 24;
        this.mMaxWidth = 48;
        this.mMinHeight = 24;
        this.mMaxHeight = 48;
        for (int i2 = 0; i2 < i; i2++) {
            this.mThumbs.add(new Thumb().setMin(this.mScaleMin).setMax(this.mScaleMax).setTag("thumb " + i2));
        }
    }

    private int optThumbValue(Thumb thumb, int i) {
        if (thumb != null && thumb.getThumb() != null) {
            int indexOf = this.mThumbs.indexOf(thumb);
            int i2 = indexOf + 1;
            if (this.mThumbs.size() > i2 && i > this.mThumbs.get(i2).getValue() - (this.mStepsThumbsApart * this.mStep)) {
                i = this.mThumbs.get(i2).getValue() - (this.mStepsThumbsApart * this.mStep);
            }
            if (indexOf > 0) {
                int i3 = indexOf - 1;
                if (i < this.mThumbs.get(i3).getValue() + (this.mStepsThumbsApart * this.mStep)) {
                    i = this.mThumbs.get(i3).getValue() + (this.mStepsThumbsApart * this.mStep);
                }
            }
            int i4 = i - this.mScaleMin;
            int i5 = this.mStep;
            int i6 = i4 % i5;
            if (i6 != 0) {
                i += i5 - i6;
            }
            if (i < thumb.getMin()) {
                i = thumb.getMin();
            }
            if (i > thumb.getMax()) {
                return thumb.getMax();
            }
            return i;
        }
        return i;
    }

    private void setHotspot(float f, float f2, Thumb thumb) {
        Drawable background;
        if (thumb != null && thumb.getThumb() != null && (background = getBackground()) != null) {
            background.setHotspot(f, f2);
            Rect bounds = thumb.getThumb().getBounds();
            int paddingTop = getPaddingTop();
            background.setHotspotBounds(bounds.left, bounds.top + paddingTop, bounds.right, bounds.bottom + paddingTop);
        }
    }

    private void setRangeDrawable(Thumb thumb, Drawable drawable, int i) {
        thumb.setRange(getTintedDrawable(drawable, i));
    }

    private void setThumbDrawable(Thumb thumb, Drawable drawable, int i) {
        Drawable tintedDrawable = getTintedDrawable(drawable.getConstantState().newDrawable(), i);
        tintedDrawable.setCallback(this);
        thumb.setThumbOffset(drawable.getIntrinsicWidth() / 2);
        if (thumb.getThumb() != null && (tintedDrawable.getIntrinsicWidth() != thumb.getThumb().getIntrinsicWidth() || tintedDrawable.getIntrinsicHeight() != thumb.getThumb().getIntrinsicHeight())) {
            requestLayout();
        }
        thumb.setThumb(tintedDrawable);
        invalidate();
        if (tintedDrawable.isStateful()) {
            tintedDrawable.setState(getDrawableState());
        }
    }

    private void setThumbDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        int i;
        Drawable drawable5;
        if (drawable == null) {
            return;
        }
        Iterator<Thumb> it = this.mThumbs.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Thumb next = it.next();
            i3++;
            if (next.getThumb() != null && drawable != next.getThumb()) {
                next.getThumb().setCallback(null);
            }
            if (i3 == 1 && drawable3 != null) {
                i = this.f9210a.getColor(R.styleable.NavMultiSeekBar_nsdk_range1Color, 0);
                drawable5 = drawable3;
            } else if (i3 == 2 && drawable4 != null) {
                i = this.f9210a.getColor(R.styleable.NavMultiSeekBar_nsdk_range2Color, 0);
                drawable5 = drawable4;
            } else {
                i = this.defRangeColor;
                drawable5 = drawable2;
            }
            setRangeDrawable(next, drawable5, i);
            setThumbDrawable(next, drawable, this.defThumbColor);
            i2 = Math.max(i2, next.getThumbOffset());
        }
        setPadding(i2, getPaddingTop(), i2, getPaddingBottom());
    }

    private void setThumbPos(int i, int i2, Drawable drawable, Drawable drawable2, Drawable drawable3, float f, int i3, int i4) {
        float f2;
        int i5;
        int available = getAvailable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (getScaleSize() > 0) {
            f2 = this.mScaleMin / getScaleSize();
        } else {
            f2 = 0.0f;
        }
        float f3 = available;
        int i6 = (int) (((f * f3) - (f2 * f3)) + 0.5f);
        if (i3 == Integer.MIN_VALUE) {
            Rect bounds = drawable.getBounds();
            int i7 = bounds.top;
            i5 = bounds.bottom;
            i3 = i7;
        } else {
            i5 = intrinsicHeight + i3;
        }
        if (isLayoutRtl() && this.mMirrorForRtl) {
            i6 = available - i6;
        }
        int i8 = i6 + i4;
        drawable.setBounds(i8, i3, intrinsicWidth + i8, i5);
        getPaddingTop();
        getPaddingBottom();
        if (!isLayoutRtl() || !this.mMirrorForRtl) {
            available = 0;
        }
        if (drawable2 != null) {
            available = drawable2.getBounds().left;
        }
        if (drawable3 != null) {
            if (isLayoutRtl() && this.mMirrorForRtl) {
                int i9 = i2 / 2;
                int i10 = mTrackHeight;
                drawable3.setBounds(i8, i9 - i10, available + i4, i9 + i10);
            } else {
                int i11 = i2 / 2;
                int i12 = mTrackHeight;
                drawable3.setBounds(available, i11 - i12, i8, i11 + i12);
            }
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setThumbValue(Thumb thumb, int i, boolean z) {
        if (thumb != null) {
            try {
                if (thumb.getThumb() != null) {
                    int optThumbValue = optThumbValue(thumb, i);
                    if (optThumbValue != thumb.getValue()) {
                        thumb.value = optThumbValue;
                    }
                    if (hasOnThumbValueChangeListener()) {
                        this.mOnThumbValueChangeListener.onValueChanged(this, thumb, this.mThumbs.indexOf(thumb), thumb.getValue());
                    }
                    updateThumb(thumb, getWidth() - (JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_25dp) * 2), getHeight());
                }
            } finally {
            }
        }
    }

    private void updateThumb(Thumb thumb, int i, int i2) {
        float f;
        Drawable drawable;
        float f2;
        if (thumb == null) {
            return;
        }
        int intrinsicHeight = thumb.getThumb().getIntrinsicHeight();
        int paddingTop = (i2 - getPaddingTop()) - getPaddingBottom();
        if (getScaleSize() > 0) {
            f = thumb.getValue() / getScaleSize();
        } else {
            f = 0.0f;
        }
        int indexOf = this.mThumbs.indexOf(thumb);
        if (indexOf > 0) {
            drawable = this.mThumbs.get(indexOf - 1).getThumb();
        } else {
            drawable = null;
        }
        Drawable drawable2 = drawable;
        if (intrinsicHeight > paddingTop) {
            setThumbPos(i, i2, thumb.getThumb(), drawable2, thumb.getRange(), f, 0, getThumbOptOffset(thumb));
            Drawable drawable3 = this.mTrack;
            if (drawable3 != null) {
                int i3 = i2 / 2;
                int i4 = mTrackHeight;
                drawable3.setBounds(0, i3 - i4, i, i3 + i4);
            }
        } else {
            Drawable drawable4 = this.mTrack;
            if (drawable4 != null) {
                int i5 = i2 / 2;
                int i6 = mTrackHeight;
                drawable4.setBounds(0, i5 - i6, i, i5 + i6);
            }
            setThumbPos(i, i2, thumb.getThumb(), drawable2, thumb.getRange(), f, (paddingTop - intrinsicHeight) / 2, getThumbOptOffset(thumb));
        }
        while (true) {
            indexOf++;
            if (indexOf < this.mThumbs.size()) {
                int i7 = (paddingTop - intrinsicHeight) / 2;
                if (getScaleSize() > 0) {
                    f2 = this.mThumbs.get(indexOf).getValue() / getScaleSize();
                } else {
                    f2 = 0.0f;
                }
                setThumbPos(i, i2, this.mThumbs.get(indexOf).getThumb(), this.mThumbs.get(indexOf - 1).getThumb(), this.mThumbs.get(indexOf).getRange(), f2, i7, getThumbOptOffset(this.mThumbs.get(indexOf)));
            } else {
                return;
            }
        }
    }

    private void updateTrackBounds(int i, int i2) {
        int paddingRight = i - (getPaddingRight() + getPaddingLeft());
        int paddingTop = i2 - (getPaddingTop() + getPaddingBottom());
        Drawable drawable = this.mTrack;
        if (drawable != null) {
            int i3 = paddingTop / 2;
            int i4 = mTrackHeight;
            drawable.setBounds(0, i3 - i4, paddingRight, i3 + i4);
        }
    }

    private void updateTrackState() {
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mTrack;
        if (drawable != null && drawable.isStateful()) {
            this.mTrack.setState(drawableState);
        }
    }

    public boolean addThumb(Thumb thumb) {
        return addThumbOnPos(thumb, this.mThumbs.size());
    }

    public boolean addThumbOnPos(Thumb thumb, int i) {
        if (this.mThumbs.contains(thumb)) {
            return false;
        }
        if (thumb.getThumb() == null) {
            setThumbDrawable(thumb, this.defThumbDrawable, this.defThumbColor);
        }
        setPadding(Math.max(getPaddingLeft(), thumb.getThumbOffset()), getPaddingTop(), Math.max(getPaddingRight(), thumb.getThumbOffset()), getPaddingBottom());
        if (thumb.getRange() == null) {
            setRangeDrawable(thumb, this.defRangeDrawable, this.defRangeColor);
        }
        this.mThumbs.add(i, thumb);
        setThumbValue(thumb, thumb.value, false);
        return true;
    }

    public void clearThumbs() {
        this.mThumbs.clear();
        this.mDraggingThumbs.clear();
        invalidate();
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        synchronized (this.mDraggingThumbs) {
            try {
                if (!this.mDraggingThumbs.isEmpty()) {
                    int[] drawableState = getDrawableState();
                    for (Thumb thumb : this.mDraggingThumbs) {
                        if (thumb.getThumb() != null) {
                            thumb.getThumb().setState(drawableState);
                        }
                    }
                    Iterator<Thumb> it = this.mThumbs.iterator();
                    while (it.hasNext()) {
                        Thumb next = it.next();
                        if (!this.mDraggingThumbs.contains(next) && next.getThumb() != null && next.getThumb().isStateful()) {
                            if (next.isEnabled()) {
                                next.getThumb().setState(new int[]{android.R.attr.state_enabled, -16842919});
                            } else {
                                next.getThumb().setState(new int[]{-16842910});
                            }
                        }
                    }
                } else {
                    Iterator<Thumb> it2 = this.mThumbs.iterator();
                    while (it2.hasNext()) {
                        Thumb next2 = it2.next();
                        if (next2.getThumb() != null && next2.getThumb().isStateful()) {
                            if (next2.isEnabled()) {
                                next2.getThumb().setState(new int[]{android.R.attr.state_enabled, -16842919});
                            } else {
                                next2.getThumb().setState(new int[]{-16842910});
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        super.drawableStateChanged();
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.mAccessibilityNodeProvider == null) {
            this.mAccessibilityNodeProvider = new VirtualTreeProvider();
        }
        return this.mAccessibilityNodeProvider;
    }

    public int getKeyProgressIncrement() {
        return this.mKeyProgressIncrement;
    }

    public int getMax() {
        return this.mScaleMax;
    }

    public int getMin() {
        return this.mScaleMin;
    }

    public int getScaleSize() {
        return this.mScaleMax - this.mScaleMin;
    }

    public int getStep() {
        return this.mStep;
    }

    public int getStepsThumbsApart() {
        return this.mStepsThumbsApart;
    }

    public Thumb getThumb(int i) {
        return this.mThumbs.get(i);
    }

    public int getThumbOptOffset(Thumb thumb) {
        if (!this.mDrawThumbsApart || thumb == null || thumb.getThumb() == null) {
            return 0;
        }
        int indexOf = this.mThumbs.indexOf(thumb);
        if (isLayoutRtl() && this.mMirrorForRtl) {
            if (indexOf == this.mThumbs.size() - 1) {
                return 0;
            }
            return getThumbOptOffset(this.mThumbs.get(indexOf + 1)) + thumb.getThumb().getIntrinsicWidth();
        }
        if (indexOf == 0) {
            return 0;
        }
        return getThumbOptOffset(this.mThumbs.get(indexOf - 1)) + thumb.getThumb().getIntrinsicWidth();
    }

    public boolean isDrawThumbsApart() {
        return this.mDrawThumbsApart;
    }

    public boolean isInScrollingContainer() {
        for (ViewParent parent = getParent(); parent != null && (parent instanceof ViewGroup); parent = parent.getParent()) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public boolean isLayoutRtl() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Iterator<Thumb> it = this.mThumbs.iterator();
        while (it.hasNext()) {
            Thumb next = it.next();
            if (next.getThumb() != null) {
                next.getThumb().jumpToCurrentState();
            }
        }
    }

    @Override // android.view.View
    public synchronized void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_25dp);
            if (this.mTrack != null) {
                canvas.save();
                canvas.translate(dimensionPixelSize, getPaddingTop());
                this.mTrack.draw(canvas);
                canvas.restore();
            }
            Iterator<Thumb> it = this.mThumbs.iterator();
            while (it.hasNext()) {
                Thumb next = it.next();
                if (next.getRange() != null) {
                    canvas.save();
                    canvas.translate(dimensionPixelSize, getPaddingTop() - getPaddingBottom());
                    next.getRange().draw(canvas);
                    canvas.restore();
                }
            }
            Iterator<Thumb> it2 = this.mThumbs.iterator();
            while (it2.hasNext()) {
                Thumb next2 = it2.next();
                if (next2.getThumb() != null && !next2.isInvisibleThumb()) {
                    canvas.save();
                    canvas.translate(dimensionPixelSize - next2.getThumbOffset(), getPaddingTop());
                    next2.getThumb().draw(canvas);
                    canvas.restore();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(NavMultiSeekBar.class.getName());
    }

    @Override // android.view.View
    public synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        try {
            Iterator<Thumb> it = this.mThumbs.iterator();
            int i5 = 0;
            int i6 = 0;
            while (it.hasNext()) {
                Thumb next = it.next();
                if (next.getThumb() != null) {
                    i5 = Math.max(next.getThumb().getIntrinsicHeight(), i5);
                    i6 = Math.max(next.getThumb().getIntrinsicHeight(), i6);
                }
            }
            Drawable drawable = this.mTrack;
            if (drawable != null) {
                i3 = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, drawable.getIntrinsicWidth()));
                i4 = Math.max(i5, Math.max(i6, Math.max(this.mMinHeight, Math.min(this.mMaxHeight, this.mTrack.getIntrinsicHeight()))));
            } else {
                i3 = 0;
                i4 = 0;
            }
            setMeasuredDimension(View.resolveSizeAndState(i3 + getPaddingLeft() + getPaddingRight(), i, 0), View.resolveSizeAndState(i4 + getPaddingTop() + getPaddingBottom(), i2, 0));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        updateTrackBounds(i, i2);
        Iterator<Thumb> it = this.mThumbs.iterator();
        while (it.hasNext()) {
            updateThumb(it.next(), i - (JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_25dp) * 2), i2);
        }
    }

    public void onStartTrackingTouch(Thumb thumb) {
        if (thumb != null) {
            this.mDraggingThumbs.add(thumb);
            if (isPressed()) {
                drawableStateChanged();
            } else {
                setPressed(true);
            }
            if (thumb.getThumb() != null) {
                invalidate(thumb.getThumb().getBounds());
            }
            attemptClaimDrag();
        }
    }

    public void onStopTrackingTouch(Thumb thumb) {
        if (thumb != null) {
            this.mDraggingThumbs.remove(thumb);
            if (this.mDraggingThumbs.size() == 0) {
                setPressed(false);
            } else {
                drawableStateChanged();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00e4, code lost:
    
        if (r10 != 6) goto L89;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.widget.NavMultiSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean removeThumb(Thumb thumb) {
        this.mDraggingThumbs.remove(thumb);
        boolean remove = this.mThumbs.remove(thumb);
        invalidate();
        return remove;
    }

    public void repositionThumbs() {
        LinkedList<Thumb> linkedList = this.mThumbs;
        if (linkedList != null && !linkedList.isEmpty()) {
            if (this.mThumbs.size() > 0) {
                this.mThumbs.getFirst().setValue(this.mScaleMin);
            }
            if (this.mThumbs.size() > 1) {
                this.mThumbs.getLast().setValue(this.mScaleMax);
            }
            if (this.mThumbs.size() > 2) {
                int size = (this.mScaleMax - this.mScaleMin) / (this.mThumbs.size() - 1);
                int i = this.mScaleMax - size;
                for (int size2 = this.mThumbs.size() - 2; size2 > 0; size2--) {
                    this.mThumbs.get(size2).setValue(i);
                    i -= size;
                }
            }
        }
    }

    public void setDrawThumbsApart(boolean z) {
        this.mDrawThumbsApart = z;
    }

    public void setKeyProgressIncrement(int i) {
        if (i < 0) {
            i = -i;
        }
        this.mKeyProgressIncrement = i;
    }

    public synchronized void setMax(int i) {
        setMax(i, true, false);
    }

    public synchronized void setMin(int i) {
        setMin(i, true, false);
    }

    public NavMultiSeekBar setNumberOfThumbs(int i) {
        return setNumberOfThumbs(i, true);
    }

    public void setOnThumbValueChangeListener(OnThumbValueChangeListener onThumbValueChangeListener) {
        this.mOnThumbValueChangeListener = onThumbValueChangeListener;
    }

    public void setStep(int i) {
        this.mStep = i;
    }

    public void setStepsThumbsApart(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mStepsThumbsApart = i;
    }

    public void setThumbOffset(int i) {
        Iterator<Thumb> it = this.mThumbs.iterator();
        while (it.hasNext()) {
            it.next().setThumbOffset(i);
        }
        invalidate();
    }

    public void setTrackDrawable(Drawable drawable) {
        boolean z;
        Drawable drawable2 = this.mTrack;
        if (drawable2 != null && drawable != drawable2) {
            drawable2.setCallback(null);
            z = true;
        } else {
            z = false;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            int minimumHeight = drawable.getMinimumHeight();
            if (this.mMaxHeight < minimumHeight) {
                this.mMaxHeight = minimumHeight;
                requestLayout();
            }
        }
        this.mTrack = drawable;
        if (z) {
            updateTrackBounds(getWidth(), getHeight());
            updateTrackState();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        Iterator<Thumb> it = this.mThumbs.iterator();
        while (it.hasNext()) {
            Thumb next = it.next();
            if (next.getThumb() != null && drawable == next.getThumb()) {
                return true;
            }
        }
        if (drawable == this.mTrack || super.verifyDrawable(drawable)) {
            return true;
        }
        return false;
    }

    public NavMultiSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.nsdk_multiSeekBarStyle);
    }

    private int getValue(MotionEvent motionEvent, int i, Thumb thumb) {
        float paddingLeft;
        int i2;
        int width = getWidth();
        int available = getAvailable();
        int thumbOptOffset = getThumbOptOffset(thumb);
        int x = (int) motionEvent.getX(i);
        float f = this.mScaleMin;
        if (isLayoutRtl() && this.mMirrorForRtl) {
            if (x <= width - getPaddingRight()) {
                if (x >= getPaddingLeft()) {
                    paddingLeft = (((available - x) + getPaddingLeft()) + thumbOptOffset) / available;
                    i2 = this.mScaleMin;
                    f = i2;
                }
                paddingLeft = 1.0f;
            }
            paddingLeft = 0.0f;
        } else {
            if (x >= getPaddingLeft()) {
                if (x <= width - getPaddingRight()) {
                    paddingLeft = ((x - getPaddingLeft()) - thumbOptOffset) / available;
                    i2 = this.mScaleMin;
                    f = i2;
                }
                paddingLeft = 1.0f;
            }
            paddingLeft = 0.0f;
        }
        return Math.round(f + (paddingLeft * getScaleSize()));
    }

    public Thumb addThumb(int i) {
        Thumb thumb = new Thumb();
        addThumb(thumb);
        thumb.setValue(i);
        return thumb;
    }

    public synchronized void setMax(int i, boolean z) {
        setMax(i, z, false);
    }

    public synchronized void setMin(int i, boolean z) {
        setMin(i, z, false);
    }

    public NavMultiSeekBar setNumberOfThumbs(int i, boolean z) {
        clearThumbs();
        for (int i2 = 0; i2 < i; i2++) {
            addThumb(0);
        }
        if (z) {
            repositionThumbs();
        }
        return this;
    }

    public NavMultiSeekBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public synchronized void setMax(int i, boolean z, boolean z2) {
        try {
            if (i >= this.mScaleMin) {
                if (i != this.mScaleMax) {
                    this.mScaleMax = i;
                    Iterator<Thumb> it = this.mThumbs.iterator();
                    while (it.hasNext()) {
                        Thumb next = it.next();
                        if (z) {
                            next.setMax(i);
                        } else if (next.getMax() > i) {
                            next.setMax(i);
                        }
                        if (next.getValue() > i) {
                            setThumbValue(next, i, false);
                        }
                    }
                    if (z2) {
                        repositionThumbs();
                    }
                    postInvalidate();
                }
                int i2 = this.mKeyProgressIncrement;
                if (i2 == 0 || this.mScaleMax / i2 > 20) {
                    setKeyProgressIncrement(Math.max(1, Math.round(this.mScaleMax / 20.0f)));
                }
            } else {
                throw new IllegalArgumentException(String.format("setMax(%d) < Min(%d)", Integer.valueOf(i), Integer.valueOf(this.mScaleMin)));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setMin(int i, boolean z, boolean z2) {
        try {
            if (i <= this.mScaleMax) {
                if (i != this.mScaleMin) {
                    this.mScaleMin = i;
                    Iterator<Thumb> it = this.mThumbs.iterator();
                    while (it.hasNext()) {
                        Thumb next = it.next();
                        if (z) {
                            next.setMin(i);
                        } else if (next.getMin() < i) {
                            next.setMin(i);
                        }
                        if (next.getValue() < i) {
                            setThumbValue(next, i, false);
                        }
                    }
                    if (z2) {
                        repositionThumbs();
                    }
                    postInvalidate();
                }
                int i2 = this.mKeyProgressIncrement;
                if (i2 == 0 || this.mScaleMax / i2 > 20) {
                    setKeyProgressIncrement(Math.max(1, Math.round(this.mScaleMax / 20.0f)));
                }
            } else {
                throw new IllegalArgumentException(String.format("setMin(%d) > Max(%d)", Integer.valueOf(i), Integer.valueOf(this.mScaleMax)));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public NavMultiSeekBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.mMirrorForRtl = true;
        this.mThumbs = new LinkedList<>();
        this.mKeyProgressIncrement = 1;
        this.mDraggingThumbs = new LinkedList();
        this.exactTouched = null;
        this.defThumbColor = 0;
        this.defRangeColor = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NavMultiSeekBar, i, i2);
        this.f9210a = obtainStyledAttributes;
        initMultiSlider(obtainStyledAttributes.getInt(R.styleable.NavMultiSeekBar_nsdk_thumbNumber, 2));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.NavMultiSeekBar_android_track);
        setTrackDrawable(getTintedDrawable(drawable == null ? ContextCompat.getDrawable(getContext(), R.drawable.bnav_common_seekbar_track_bg) : drawable, obtainStyledAttributes.getColor(R.styleable.NavMultiSeekBar_nsdk_trackColor, 0)));
        setStep(obtainStyledAttributes.getInt(R.styleable.NavMultiSeekBar_nsdk_scaleStep, this.mStep));
        setStepsThumbsApart(obtainStyledAttributes.getInt(R.styleable.NavMultiSeekBar_nsdk_stepsThumbsApart, this.mStepsThumbsApart));
        setDrawThumbsApart(obtainStyledAttributes.getBoolean(R.styleable.NavMultiSeekBar_nsdk_drawThumbsApart, this.mDrawThumbsApart));
        setMax(obtainStyledAttributes.getInt(R.styleable.NavMultiSeekBar_nsdk_scaleMax, this.mScaleMax), true);
        setMin(obtainStyledAttributes.getInt(R.styleable.NavMultiSeekBar_nsdk_scaleMin, this.mScaleMin), true);
        this.mMirrorForRtl = obtainStyledAttributes.getBoolean(R.styleable.NavMultiSeekBar_nsdk_mirrorForRTL, this.mMirrorForRtl);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.NavMultiSeekBar_android_thumb);
        this.defThumbDrawable = drawable2;
        if (drawable2 == null) {
            this.defThumbDrawable = ContextCompat.getDrawable(getContext(), R.drawable.nsdk_drawable_seekbar_thumb);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.NavMultiSeekBar_nsdk_range);
        this.defRangeDrawable = drawable3;
        if (drawable3 == null) {
            this.defRangeDrawable = ContextCompat.getDrawable(getContext(), R.drawable.bnav_common_seekbar_track_bg);
        }
        Drawable drawable4 = obtainStyledAttributes.getDrawable(R.styleable.NavMultiSeekBar_nsdk_range1);
        Drawable drawable5 = obtainStyledAttributes.getDrawable(R.styleable.NavMultiSeekBar_nsdk_range2);
        this.defRangeColor = obtainStyledAttributes.getColor(R.styleable.NavMultiSeekBar_nsdk_rangeColor, 0);
        this.defThumbColor = obtainStyledAttributes.getColor(R.styleable.NavMultiSeekBar_nsdk_thumbColor, 0);
        setThumbDrawables(this.defThumbDrawable, this.defRangeDrawable, drawable4, drawable5);
        setThumbOffset(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.NavMultiSeekBar_android_thumbOffset, this.defThumbDrawable.getIntrinsicWidth() / 2));
        repositionThumbs();
        this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        obtainStyledAttributes.recycle();
    }

    public Thumb removeThumb(int i) {
        this.mDraggingThumbs.remove(this.mThumbs.get(i));
        invalidate();
        Thumb remove = this.mThumbs.remove(i);
        invalidate();
        return remove;
    }

    public Thumb addThumb() {
        Thumb thumb = new Thumb();
        addThumb(thumb);
        return thumb;
    }

    public void onStopTrackingTouch() {
        Iterator<Thumb> it = this.mDraggingThumbs.iterator();
        while (it.hasNext()) {
            this.mDraggingThumbs.remove(it.next());
        }
        setPressed(false);
    }

    private synchronized void setThumbValue(int i, int i2, boolean z) {
        setThumbValue(this.mThumbs.get(i), i2, z);
    }

    public Thumb addThumbOnPos(int i, int i2) {
        Thumb thumb = new Thumb();
        addThumbOnPos(thumb, i);
        thumb.setValue(i2);
        return thumb;
    }

    public Thumb addThumbOnPos(int i) {
        Thumb thumb = new Thumb();
        addThumbOnPos(thumb, i);
        return thumb;
    }
}
