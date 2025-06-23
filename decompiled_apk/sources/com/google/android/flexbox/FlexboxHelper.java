package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class FlexboxHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INITIAL_CAPACITY = 10;
    private static final long MEASURE_SPEC_WIDTH_MASK = 4294967295L;
    private boolean[] mChildrenFrozen;
    private final FlexContainer mFlexContainer;

    @Nullable
    int[] mIndexToFlexLine;

    @Nullable
    long[] mMeasureSpecCache;

    @Nullable
    private long[] mMeasuredSizeCache;

    /* loaded from: classes9.dex */
    public static class FlexLinesResult {
        int mChildState;
        List<FlexLine> mFlexLines;

        public void reset() {
            this.mFlexLines = null;
            this.mChildState = 0;
        }
    }

    /* loaded from: classes9.dex */
    public static class Order implements Comparable<Order> {
        int index;
        int order;

        private Order() {
        }

        @NonNull
        public String toString() {
            return "Order{order=" + this.order + ", index=" + this.index + '}';
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull Order another) {
            int i = this.order;
            int i2 = another.order;
            return i != i2 ? i - i2 : this.index - another.index;
        }
    }

    public FlexboxHelper(FlexContainer flexContainer) {
        this.mFlexContainer = flexContainer;
    }

    private void addFlexLine(List<FlexLine> flexLines, FlexLine flexLine, int viewIndex, int usedCrossSizeSoFar) {
        flexLine.mSumCrossSizeBefore = usedCrossSizeSoFar;
        this.mFlexContainer.onNewFlexLineAdded(flexLine);
        flexLine.mLastIndex = viewIndex;
        flexLines.add(flexLine);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void checkSizeConstraints(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.FlexItem r0 = (com.google.android.flexbox.FlexItem) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.getMinWidth()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.getMinWidth()
        L19:
            r3 = 1
            goto L27
        L1b:
            int r3 = r0.getMaxWidth()
            if (r1 <= r3) goto L26
            int r1 = r0.getMaxWidth()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.getMinHeight()
            if (r2 >= r5) goto L32
            int r2 = r0.getMinHeight()
            goto L3e
        L32:
            int r5 = r0.getMaxHeight()
            if (r2 <= r5) goto L3d
            int r2 = r0.getMaxHeight()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.updateMeasureCache(r8, r1, r0, r7)
            com.google.android.flexbox.FlexContainer r0 = r6.mFlexContainer
            r0.updateViewCache(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxHelper.checkSizeConstraints(android.view.View, int):void");
    }

    private List<FlexLine> constructFlexLinesForAlignContentCenter(List<FlexLine> flexLines, int size, int totalCrossSize) {
        int i = (size - totalCrossSize) / 2;
        ArrayList arrayList = new ArrayList();
        FlexLine flexLine = new FlexLine();
        flexLine.mCrossSize = i;
        int size2 = flexLines.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (i2 == 0) {
                arrayList.add(flexLine);
            }
            arrayList.add(flexLines.get(i2));
            if (i2 == flexLines.size() - 1) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @NonNull
    private List<Order> createOrders(int childCount) {
        ArrayList arrayList = new ArrayList(childCount);
        for (int i = 0; i < childCount; i++) {
            FlexItem flexItem = (FlexItem) this.mFlexContainer.getFlexItemAt(i).getLayoutParams();
            Order order = new Order();
            order.order = flexItem.getOrder();
            order.index = i;
            arrayList.add(order);
        }
        return arrayList;
    }

    private void ensureChildrenFrozen(int size) {
        boolean[] zArr = this.mChildrenFrozen;
        if (zArr == null) {
            this.mChildrenFrozen = new boolean[Math.max(size, 10)];
        } else if (zArr.length < size) {
            this.mChildrenFrozen = new boolean[Math.max(zArr.length * 2, size)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void evaluateMinimumSizeForCompoundButton(CompoundButton compoundButton) {
        int minimumWidth;
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int minWidth = flexItem.getMinWidth();
        int minHeight = flexItem.getMinHeight();
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
        int i = 0;
        if (buttonDrawable == null) {
            minimumWidth = 0;
        } else {
            minimumWidth = buttonDrawable.getMinimumWidth();
        }
        if (buttonDrawable != null) {
            i = buttonDrawable.getMinimumHeight();
        }
        if (minWidth == -1) {
            minWidth = minimumWidth;
        }
        flexItem.setMinWidth(minWidth);
        if (minHeight == -1) {
            minHeight = i;
        }
        flexItem.setMinHeight(minHeight);
    }

    private void expandFlexItems(int widthMeasureSpec, int heightMeasureSpec, FlexLine flexLine, int maxMainSize, int paddingAlongMainAxis, boolean calledRecursively) {
        int i;
        int i2;
        int i3;
        double d;
        int i4;
        double d2;
        float f = flexLine.mTotalFlexGrow;
        float f2 = 0.0f;
        if (f > 0.0f && maxMainSize >= (i = flexLine.mMainSize)) {
            float f3 = (maxMainSize - i) / f;
            flexLine.mMainSize = paddingAlongMainAxis + flexLine.mDividerLengthInMainSize;
            if (!calledRecursively) {
                flexLine.mCrossSize = Integer.MIN_VALUE;
            }
            int i5 = 0;
            boolean z = false;
            int i6 = 0;
            float f4 = 0.0f;
            while (i5 < flexLine.mItemCount) {
                int i7 = flexLine.mFirstIndex + i5;
                View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i7);
                if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                    i2 = i;
                } else {
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    int flexDirection = this.mFlexContainer.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int i8 = i;
                        int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                        long[] jArr = this.mMeasuredSizeCache;
                        if (jArr != null) {
                            measuredWidth = extractLowerInt(jArr[i7]);
                        }
                        int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                        long[] jArr2 = this.mMeasuredSizeCache;
                        i2 = i8;
                        if (jArr2 != null) {
                            measuredHeight = extractHigherInt(jArr2[i7]);
                        }
                        if (!this.mChildrenFrozen[i7] && flexItem.getFlexGrow() > 0.0f) {
                            float flexGrow = measuredWidth + (flexItem.getFlexGrow() * f3);
                            if (i5 == flexLine.mItemCount - 1) {
                                flexGrow += f4;
                                f4 = 0.0f;
                            }
                            int round = Math.round(flexGrow);
                            if (round > flexItem.getMaxWidth()) {
                                round = flexItem.getMaxWidth();
                                this.mChildrenFrozen[i7] = true;
                                flexLine.mTotalFlexGrow -= flexItem.getFlexGrow();
                                z = true;
                            } else {
                                f4 += flexGrow - round;
                                double d3 = f4;
                                if (d3 > 1.0d) {
                                    round++;
                                    d = d3 - 1.0d;
                                } else if (d3 < -1.0d) {
                                    round--;
                                    d = d3 + 1.0d;
                                }
                                f4 = (float) d;
                            }
                            int childHeightMeasureSpecInternal = getChildHeightMeasureSpecInternal(heightMeasureSpec, flexItem, flexLine.mSumCrossSizeBefore);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                            reorderedFlexItemAt.measure(makeMeasureSpec, childHeightMeasureSpecInternal);
                            int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                            int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                            updateMeasureCache(i7, makeMeasureSpec, childHeightMeasureSpecInternal, reorderedFlexItemAt);
                            this.mFlexContainer.updateViewCache(i7, reorderedFlexItemAt);
                            measuredWidth = measuredWidth2;
                            measuredHeight = measuredHeight2;
                        }
                        int max = Math.max(i6, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                        flexLine.mMainSize += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                        i3 = max;
                    } else {
                        int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                        long[] jArr3 = this.mMeasuredSizeCache;
                        if (jArr3 != null) {
                            measuredHeight3 = extractHigherInt(jArr3[i7]);
                        }
                        int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        long[] jArr4 = this.mMeasuredSizeCache;
                        if (jArr4 != null) {
                            measuredWidth3 = extractLowerInt(jArr4[i7]);
                        }
                        if (!this.mChildrenFrozen[i7] && flexItem.getFlexGrow() > f2) {
                            float flexGrow2 = measuredHeight3 + (flexItem.getFlexGrow() * f3);
                            if (i5 == flexLine.mItemCount - 1) {
                                flexGrow2 += f4;
                                f4 = 0.0f;
                            }
                            int round2 = Math.round(flexGrow2);
                            if (round2 > flexItem.getMaxHeight()) {
                                round2 = flexItem.getMaxHeight();
                                this.mChildrenFrozen[i7] = true;
                                flexLine.mTotalFlexGrow -= flexItem.getFlexGrow();
                                i4 = i;
                                z = true;
                            } else {
                                f4 += flexGrow2 - round2;
                                i4 = i;
                                double d4 = f4;
                                if (d4 > 1.0d) {
                                    round2++;
                                    d2 = d4 - 1.0d;
                                } else if (d4 < -1.0d) {
                                    round2--;
                                    d2 = d4 + 1.0d;
                                }
                                f4 = (float) d2;
                            }
                            int childWidthMeasureSpecInternal = getChildWidthMeasureSpecInternal(widthMeasureSpec, flexItem, flexLine.mSumCrossSizeBefore);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                            reorderedFlexItemAt.measure(childWidthMeasureSpecInternal, makeMeasureSpec2);
                            measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                            int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                            updateMeasureCache(i7, childWidthMeasureSpecInternal, makeMeasureSpec2, reorderedFlexItemAt);
                            this.mFlexContainer.updateViewCache(i7, reorderedFlexItemAt);
                            measuredHeight3 = measuredHeight4;
                        } else {
                            i4 = i;
                        }
                        i3 = Math.max(i6, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                        flexLine.mMainSize += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                        i2 = i4;
                    }
                    flexLine.mCrossSize = Math.max(flexLine.mCrossSize, i3);
                    i6 = i3;
                }
                i5++;
                i = i2;
                f2 = 0.0f;
            }
            int i9 = i;
            if (z && i9 != flexLine.mMainSize) {
                expandFlexItems(widthMeasureSpec, heightMeasureSpec, flexLine, maxMainSize, paddingAlongMainAxis, true);
            }
        }
    }

    private int getChildHeightMeasureSpecInternal(int heightMeasureSpec, FlexItem flexItem, int padding) {
        FlexContainer flexContainer = this.mFlexContainer;
        int childHeightMeasureSpec = flexContainer.getChildHeightMeasureSpec(heightMeasureSpec, flexContainer.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + padding, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(childHeightMeasureSpec);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec));
        }
        if (size < flexItem.getMinHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec));
        }
        return childHeightMeasureSpec;
    }

    private int getChildWidthMeasureSpecInternal(int widthMeasureSpec, FlexItem flexItem, int padding) {
        FlexContainer flexContainer = this.mFlexContainer;
        int childWidthMeasureSpec = flexContainer.getChildWidthMeasureSpec(widthMeasureSpec, flexContainer.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + padding, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(childWidthMeasureSpec);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec));
        }
        if (size < flexItem.getMinWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec));
        }
        return childWidthMeasureSpec;
    }

    private int getFlexItemMarginEndCross(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getMarginBottom();
        }
        return flexItem.getMarginRight();
    }

    private int getFlexItemMarginEndMain(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getMarginRight();
        }
        return flexItem.getMarginBottom();
    }

    private int getFlexItemMarginStartCross(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getMarginTop();
        }
        return flexItem.getMarginLeft();
    }

    private int getFlexItemMarginStartMain(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getMarginLeft();
        }
        return flexItem.getMarginTop();
    }

    private int getFlexItemSizeCross(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getHeight();
        }
        return flexItem.getWidth();
    }

    private int getFlexItemSizeMain(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getWidth();
        }
        return flexItem.getHeight();
    }

    private int getPaddingEndCross(boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return this.mFlexContainer.getPaddingBottom();
        }
        return this.mFlexContainer.getPaddingEnd();
    }

    private int getPaddingEndMain(boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return this.mFlexContainer.getPaddingEnd();
        }
        return this.mFlexContainer.getPaddingBottom();
    }

    private int getPaddingStartCross(boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return this.mFlexContainer.getPaddingTop();
        }
        return this.mFlexContainer.getPaddingStart();
    }

    private int getPaddingStartMain(boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return this.mFlexContainer.getPaddingStart();
        }
        return this.mFlexContainer.getPaddingTop();
    }

    private int getViewMeasuredSizeCross(View view, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int getViewMeasuredSizeMain(View view, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private boolean isLastFlexItem(int childIndex, int childCount, FlexLine flexLine) {
        if (childIndex == childCount - 1 && flexLine.getItemCountNotGone() != 0) {
            return true;
        }
        return false;
    }

    private boolean isWrapRequired(View view, int mode, int maxSize, int currentLength, int childLength, FlexItem flexItem, int index, int indexInFlexLine, int flexLinesSize) {
        if (this.mFlexContainer.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (mode == 0) {
            return false;
        }
        int maxLine = this.mFlexContainer.getMaxLine();
        if (maxLine != -1 && maxLine <= flexLinesSize + 1) {
            return false;
        }
        int decorationLengthMainAxis = this.mFlexContainer.getDecorationLengthMainAxis(view, index, indexInFlexLine);
        if (decorationLengthMainAxis > 0) {
            childLength += decorationLengthMainAxis;
        }
        if (maxSize >= currentLength + childLength) {
            return false;
        }
        return true;
    }

    private void shrinkFlexItems(int widthMeasureSpec, int heightMeasureSpec, FlexLine flexLine, int maxMainSize, int paddingAlongMainAxis, boolean calledRecursively) {
        int i;
        int i2;
        int i3;
        int i4 = flexLine.mMainSize;
        float f = flexLine.mTotalFlexShrink;
        float f2 = 0.0f;
        if (f > 0.0f && maxMainSize <= i4) {
            float f3 = (i4 - maxMainSize) / f;
            flexLine.mMainSize = paddingAlongMainAxis + flexLine.mDividerLengthInMainSize;
            if (!calledRecursively) {
                flexLine.mCrossSize = Integer.MIN_VALUE;
            }
            int i5 = 0;
            boolean z = false;
            int i6 = 0;
            float f4 = 0.0f;
            while (i5 < flexLine.mItemCount) {
                int i7 = flexLine.mFirstIndex + i5;
                View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i7);
                if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                    i = i4;
                    i2 = i5;
                } else {
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    int flexDirection = this.mFlexContainer.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        i = i4;
                        int i8 = i5;
                        int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                        long[] jArr = this.mMeasuredSizeCache;
                        if (jArr != null) {
                            measuredWidth = extractLowerInt(jArr[i7]);
                        }
                        int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                        long[] jArr2 = this.mMeasuredSizeCache;
                        if (jArr2 != null) {
                            measuredHeight = extractHigherInt(jArr2[i7]);
                        }
                        if (!this.mChildrenFrozen[i7] && flexItem.getFlexShrink() > 0.0f) {
                            float flexShrink = measuredWidth - (flexItem.getFlexShrink() * f3);
                            i2 = i8;
                            if (i2 == flexLine.mItemCount - 1) {
                                flexShrink += f4;
                                f4 = 0.0f;
                            }
                            int round = Math.round(flexShrink);
                            if (round < flexItem.getMinWidth()) {
                                round = flexItem.getMinWidth();
                                this.mChildrenFrozen[i7] = true;
                                flexLine.mTotalFlexShrink -= flexItem.getFlexShrink();
                                z = true;
                            } else {
                                f4 += flexShrink - round;
                                double d = f4;
                                if (d > 1.0d) {
                                    round++;
                                    f4 -= 1.0f;
                                } else if (d < -1.0d) {
                                    round--;
                                    f4 += 1.0f;
                                }
                            }
                            int childHeightMeasureSpecInternal = getChildHeightMeasureSpecInternal(heightMeasureSpec, flexItem, flexLine.mSumCrossSizeBefore);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                            reorderedFlexItemAt.measure(makeMeasureSpec, childHeightMeasureSpecInternal);
                            int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                            int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                            updateMeasureCache(i7, makeMeasureSpec, childHeightMeasureSpecInternal, reorderedFlexItemAt);
                            this.mFlexContainer.updateViewCache(i7, reorderedFlexItemAt);
                            measuredWidth = measuredWidth2;
                            measuredHeight = measuredHeight2;
                        } else {
                            i2 = i8;
                        }
                        int max = Math.max(i6, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                        flexLine.mMainSize += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                        i3 = max;
                    } else {
                        int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                        long[] jArr3 = this.mMeasuredSizeCache;
                        if (jArr3 != null) {
                            measuredHeight3 = extractHigherInt(jArr3[i7]);
                        }
                        int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        long[] jArr4 = this.mMeasuredSizeCache;
                        if (jArr4 != null) {
                            measuredWidth3 = extractLowerInt(jArr4[i7]);
                        }
                        if (!this.mChildrenFrozen[i7] && flexItem.getFlexShrink() > f2) {
                            float flexShrink2 = measuredHeight3 - (flexItem.getFlexShrink() * f3);
                            if (i5 == flexLine.mItemCount - 1) {
                                flexShrink2 += f4;
                                f4 = 0.0f;
                            }
                            int round2 = Math.round(flexShrink2);
                            if (round2 < flexItem.getMinHeight()) {
                                round2 = flexItem.getMinHeight();
                                this.mChildrenFrozen[i7] = true;
                                flexLine.mTotalFlexShrink -= flexItem.getFlexShrink();
                                i = i4;
                                i2 = i5;
                                z = true;
                            } else {
                                f4 += flexShrink2 - round2;
                                i = i4;
                                i2 = i5;
                                double d2 = f4;
                                if (d2 > 1.0d) {
                                    round2++;
                                    f4 -= 1.0f;
                                } else if (d2 < -1.0d) {
                                    round2--;
                                    f4 += 1.0f;
                                }
                            }
                            int childWidthMeasureSpecInternal = getChildWidthMeasureSpecInternal(widthMeasureSpec, flexItem, flexLine.mSumCrossSizeBefore);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                            reorderedFlexItemAt.measure(childWidthMeasureSpecInternal, makeMeasureSpec2);
                            measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                            int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                            updateMeasureCache(i7, childWidthMeasureSpecInternal, makeMeasureSpec2, reorderedFlexItemAt);
                            this.mFlexContainer.updateViewCache(i7, reorderedFlexItemAt);
                            measuredHeight3 = measuredHeight4;
                        } else {
                            i = i4;
                            i2 = i5;
                        }
                        i3 = Math.max(i6, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                        flexLine.mMainSize += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                    }
                    flexLine.mCrossSize = Math.max(flexLine.mCrossSize, i3);
                    i6 = i3;
                }
                i5 = i2 + 1;
                i4 = i;
                f2 = 0.0f;
            }
            int i9 = i4;
            if (z && i9 != flexLine.mMainSize) {
                shrinkFlexItems(widthMeasureSpec, heightMeasureSpec, flexLine, maxMainSize, paddingAlongMainAxis, true);
            }
        }
    }

    private int[] sortOrdersIntoReorderedIndices(int childCount, List<Order> orders, SparseIntArray orderCache) {
        Collections.sort(orders);
        orderCache.clear();
        int[] iArr = new int[childCount];
        int i = 0;
        for (Order order : orders) {
            int i2 = order.index;
            iArr[i] = i2;
            orderCache.append(i2, order.order);
            i++;
        }
        return iArr;
    }

    private void stretchViewHorizontally(View view, int crossSize, int index) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((crossSize - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.mFlexContainer.getDecorationLengthCrossAxis(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr != null) {
            measuredHeight = extractHigherInt(jArr[index]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        updateMeasureCache(index, makeMeasureSpec2, makeMeasureSpec, view);
        this.mFlexContainer.updateViewCache(index, view);
    }

    private void stretchViewVertically(View view, int crossSize, int index) {
        int measuredWidth;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((crossSize - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.mFlexContainer.getDecorationLengthCrossAxis(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr != null) {
            measuredWidth = extractLowerInt(jArr[index]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        updateMeasureCache(index, makeMeasureSpec, makeMeasureSpec2, view);
        this.mFlexContainer.updateViewCache(index, view);
    }

    private void updateMeasureCache(int index, int widthMeasureSpec, int heightMeasureSpec, View view) {
        long[] jArr = this.mMeasureSpecCache;
        if (jArr != null) {
            jArr[index] = makeCombinedLong(widthMeasureSpec, heightMeasureSpec);
        }
        long[] jArr2 = this.mMeasuredSizeCache;
        if (jArr2 != null) {
            jArr2[index] = makeCombinedLong(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public void calculateFlexLines(FlexLinesResult result, int mainMeasureSpec, int crossMeasureSpec, int needsCalcAmount, int fromIndex, int toIndex, @Nullable List<FlexLine> existingLines) {
        List<FlexLine> list;
        boolean z;
        int i;
        FlexLinesResult flexLinesResult;
        int i2;
        int i3;
        int i4;
        List<FlexLine> list2;
        int i5;
        int i6;
        View view;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z2;
        boolean z3;
        int i12;
        int i13;
        int i14;
        FlexLine flexLine;
        int i15;
        int i16 = mainMeasureSpec;
        int i17 = crossMeasureSpec;
        int i18 = toIndex;
        boolean isMainAxisDirectionHorizontal = this.mFlexContainer.isMainAxisDirectionHorizontal();
        int mode = View.MeasureSpec.getMode(mainMeasureSpec);
        int size = View.MeasureSpec.getSize(mainMeasureSpec);
        if (existingLines == null) {
            list = new ArrayList();
        } else {
            list = existingLines;
        }
        result.mFlexLines = list;
        if (i18 == -1) {
            z = true;
        } else {
            z = false;
        }
        int paddingStartMain = getPaddingStartMain(isMainAxisDirectionHorizontal);
        int paddingEndMain = getPaddingEndMain(isMainAxisDirectionHorizontal);
        int paddingStartCross = getPaddingStartCross(isMainAxisDirectionHorizontal);
        int paddingEndCross = getPaddingEndCross(isMainAxisDirectionHorizontal);
        FlexLine flexLine2 = new FlexLine();
        int i19 = fromIndex;
        flexLine2.mFirstIndex = i19;
        int i20 = paddingEndMain + paddingStartMain;
        flexLine2.mMainSize = i20;
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        boolean z4 = z;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = Integer.MIN_VALUE;
        while (true) {
            if (i19 < flexItemCount) {
                View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i19);
                if (reorderedFlexItemAt == null) {
                    if (isLastFlexItem(i19, flexItemCount, flexLine2)) {
                        addFlexLine(list, flexLine2, i19, i21);
                    }
                } else if (reorderedFlexItemAt.getVisibility() == 8) {
                    flexLine2.mGoneItemCount++;
                    flexLine2.mItemCount++;
                    if (isLastFlexItem(i19, flexItemCount, flexLine2)) {
                        addFlexLine(list, flexLine2, i19, i21);
                    }
                } else {
                    if (reorderedFlexItemAt instanceof CompoundButton) {
                        evaluateMinimumSizeForCompoundButton((CompoundButton) reorderedFlexItemAt);
                    }
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    int i25 = flexItemCount;
                    if (flexItem.getAlignSelf() == 4) {
                        flexLine2.mIndicesAlignSelfStretch.add(Integer.valueOf(i19));
                    }
                    int flexItemSizeMain = getFlexItemSizeMain(flexItem, isMainAxisDirectionHorizontal);
                    if (flexItem.getFlexBasisPercent() != -1.0f && mode == 1073741824) {
                        flexItemSizeMain = Math.round(size * flexItem.getFlexBasisPercent());
                    }
                    if (isMainAxisDirectionHorizontal) {
                        int childWidthMeasureSpec = this.mFlexContainer.getChildWidthMeasureSpec(i16, i20 + getFlexItemMarginStartMain(flexItem, true) + getFlexItemMarginEndMain(flexItem, true), flexItemSizeMain);
                        i2 = size;
                        i3 = mode;
                        int childHeightMeasureSpec = this.mFlexContainer.getChildHeightMeasureSpec(i17, paddingStartCross + paddingEndCross + getFlexItemMarginStartCross(flexItem, true) + getFlexItemMarginEndCross(flexItem, true) + i21, getFlexItemSizeCross(flexItem, true));
                        reorderedFlexItemAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                        updateMeasureCache(i19, childWidthMeasureSpec, childHeightMeasureSpec, reorderedFlexItemAt);
                        i4 = childWidthMeasureSpec;
                    } else {
                        i2 = size;
                        i3 = mode;
                        int childWidthMeasureSpec2 = this.mFlexContainer.getChildWidthMeasureSpec(i17, paddingStartCross + paddingEndCross + getFlexItemMarginStartCross(flexItem, false) + getFlexItemMarginEndCross(flexItem, false) + i21, getFlexItemSizeCross(flexItem, false));
                        int childHeightMeasureSpec2 = this.mFlexContainer.getChildHeightMeasureSpec(i16, getFlexItemMarginStartMain(flexItem, false) + i20 + getFlexItemMarginEndMain(flexItem, false), flexItemSizeMain);
                        reorderedFlexItemAt.measure(childWidthMeasureSpec2, childHeightMeasureSpec2);
                        updateMeasureCache(i19, childWidthMeasureSpec2, childHeightMeasureSpec2, reorderedFlexItemAt);
                        i4 = childHeightMeasureSpec2;
                    }
                    this.mFlexContainer.updateViewCache(i19, reorderedFlexItemAt);
                    checkSizeConstraints(reorderedFlexItemAt, i19);
                    i22 = View.combineMeasuredStates(i22, reorderedFlexItemAt.getMeasuredState());
                    int i26 = i21;
                    int i27 = i20;
                    FlexLine flexLine3 = flexLine2;
                    int i28 = i19;
                    list2 = list;
                    int i29 = i4;
                    if (isWrapRequired(reorderedFlexItemAt, i3, i2, flexLine2.mMainSize, getFlexItemMarginEndMain(flexItem, isMainAxisDirectionHorizontal) + getViewMeasuredSizeMain(reorderedFlexItemAt, isMainAxisDirectionHorizontal) + getFlexItemMarginStartMain(flexItem, isMainAxisDirectionHorizontal), flexItem, i28, i23, list.size())) {
                        if (flexLine3.getItemCountNotGone() > 0) {
                            if (i28 > 0) {
                                i15 = i28 - 1;
                                flexLine = flexLine3;
                            } else {
                                flexLine = flexLine3;
                                i15 = 0;
                            }
                            addFlexLine(list2, flexLine, i15, i26);
                            i21 = flexLine.mCrossSize + i26;
                        } else {
                            i21 = i26;
                        }
                        if (isMainAxisDirectionHorizontal) {
                            if (flexItem.getHeight() == -1) {
                                FlexContainer flexContainer = this.mFlexContainer;
                                i5 = crossMeasureSpec;
                                i8 = -1;
                                view = reorderedFlexItemAt;
                                view.measure(i29, flexContainer.getChildHeightMeasureSpec(i5, flexContainer.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i21, flexItem.getHeight()));
                                i6 = i28;
                                checkSizeConstraints(view, i6);
                            } else {
                                i5 = crossMeasureSpec;
                                i6 = i28;
                                view = reorderedFlexItemAt;
                                i8 = -1;
                            }
                        } else {
                            i5 = crossMeasureSpec;
                            i6 = i28;
                            view = reorderedFlexItemAt;
                            i8 = -1;
                            if (flexItem.getWidth() == -1) {
                                FlexContainer flexContainer2 = this.mFlexContainer;
                                view.measure(flexContainer2.getChildWidthMeasureSpec(i5, flexContainer2.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i21, flexItem.getWidth()), i29);
                                checkSizeConstraints(view, i6);
                            }
                        }
                        flexLine2 = new FlexLine();
                        i9 = 1;
                        flexLine2.mItemCount = 1;
                        i7 = i27;
                        flexLine2.mMainSize = i7;
                        flexLine2.mFirstIndex = i6;
                        i10 = 0;
                        i11 = Integer.MIN_VALUE;
                    } else {
                        i5 = crossMeasureSpec;
                        i6 = i28;
                        view = reorderedFlexItemAt;
                        flexLine2 = flexLine3;
                        i7 = i27;
                        i8 = -1;
                        i9 = 1;
                        flexLine2.mItemCount++;
                        i10 = i23 + 1;
                        i21 = i26;
                        i11 = i24;
                    }
                    boolean z5 = flexLine2.mAnyItemsHaveFlexGrow;
                    if (flexItem.getFlexGrow() != 0.0f) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    flexLine2.mAnyItemsHaveFlexGrow = z5 | z2;
                    boolean z6 = flexLine2.mAnyItemsHaveFlexShrink;
                    if (flexItem.getFlexShrink() != 0.0f) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    flexLine2.mAnyItemsHaveFlexShrink = z6 | z3;
                    int[] iArr = this.mIndexToFlexLine;
                    if (iArr != null) {
                        iArr[i6] = list2.size();
                    }
                    flexLine2.mMainSize += getViewMeasuredSizeMain(view, isMainAxisDirectionHorizontal) + getFlexItemMarginStartMain(flexItem, isMainAxisDirectionHorizontal) + getFlexItemMarginEndMain(flexItem, isMainAxisDirectionHorizontal);
                    flexLine2.mTotalFlexGrow += flexItem.getFlexGrow();
                    flexLine2.mTotalFlexShrink += flexItem.getFlexShrink();
                    this.mFlexContainer.onNewFlexItemAdded(view, i6, i10, flexLine2);
                    int max = Math.max(i11, getViewMeasuredSizeCross(view, isMainAxisDirectionHorizontal) + getFlexItemMarginStartCross(flexItem, isMainAxisDirectionHorizontal) + getFlexItemMarginEndCross(flexItem, isMainAxisDirectionHorizontal) + this.mFlexContainer.getDecorationLengthCrossAxis(view));
                    flexLine2.mCrossSize = Math.max(flexLine2.mCrossSize, max);
                    if (isMainAxisDirectionHorizontal) {
                        if (this.mFlexContainer.getFlexWrap() != 2) {
                            flexLine2.mMaxBaseline = Math.max(flexLine2.mMaxBaseline, view.getBaseline() + flexItem.getMarginTop());
                        } else {
                            flexLine2.mMaxBaseline = Math.max(flexLine2.mMaxBaseline, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.getMarginBottom());
                        }
                    }
                    i12 = i25;
                    if (isLastFlexItem(i6, i12, flexLine2)) {
                        addFlexLine(list2, flexLine2, i6, i21);
                        i21 += flexLine2.mCrossSize;
                    }
                    i13 = toIndex;
                    if (i13 != i8 && list2.size() > 0 && list2.get(list2.size() - i9).mLastIndex >= i13 && i6 >= i13 && !z4) {
                        i21 = -flexLine2.getCrossSize();
                        i14 = needsCalcAmount;
                        z4 = true;
                    } else {
                        i14 = needsCalcAmount;
                    }
                    if (i21 > i14 && z4) {
                        flexLinesResult = result;
                        i = i22;
                        break;
                    }
                    i23 = i10;
                    i24 = max;
                    i16 = mainMeasureSpec;
                    i19 = i6 + 1;
                    flexItemCount = i12;
                    i17 = i5;
                    i20 = i7;
                    list = list2;
                    size = i2;
                    mode = i3;
                    i18 = i13;
                }
                i2 = size;
                i3 = mode;
                i5 = i17;
                i13 = i18;
                i7 = i20;
                list2 = list;
                i12 = flexItemCount;
                i6 = i19;
                i16 = mainMeasureSpec;
                i19 = i6 + 1;
                flexItemCount = i12;
                i17 = i5;
                i20 = i7;
                list = list2;
                size = i2;
                mode = i3;
                i18 = i13;
            } else {
                i = i22;
                flexLinesResult = result;
                break;
            }
        }
        flexLinesResult.mChildState = i;
    }

    public void calculateHorizontalFlexLines(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec) {
        calculateFlexLines(result, widthMeasureSpec, heightMeasureSpec, Integer.MAX_VALUE, 0, -1, null);
    }

    public void calculateHorizontalFlexLinesToIndex(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int toIndex, List<FlexLine> existingLines) {
        calculateFlexLines(result, widthMeasureSpec, heightMeasureSpec, needsCalcAmount, 0, toIndex, existingLines);
    }

    public void calculateVerticalFlexLines(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec) {
        calculateFlexLines(result, heightMeasureSpec, widthMeasureSpec, Integer.MAX_VALUE, 0, -1, null);
    }

    public void calculateVerticalFlexLinesToIndex(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int toIndex, List<FlexLine> existingLines) {
        calculateFlexLines(result, heightMeasureSpec, widthMeasureSpec, needsCalcAmount, 0, toIndex, existingLines);
    }

    public void clearFlexLines(List<FlexLine> flexLines, int fromFlexItem) {
        int i = this.mIndexToFlexLine[fromFlexItem];
        if (i == -1) {
            i = 0;
        }
        if (flexLines.size() > i) {
            flexLines.subList(i, flexLines.size()).clear();
        }
        int[] iArr = this.mIndexToFlexLine;
        int length = iArr.length - 1;
        if (fromFlexItem > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, fromFlexItem, length, -1);
        }
        long[] jArr = this.mMeasureSpecCache;
        int length2 = jArr.length - 1;
        if (fromFlexItem > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, fromFlexItem, length2, 0L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] createReorderedIndices(View viewBeforeAdded, int indexForViewBeforeAdded, ViewGroup.LayoutParams paramsForViewBeforeAdded, SparseIntArray orderCache) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        List<Order> createOrders = createOrders(flexItemCount);
        Order order = new Order();
        if (viewBeforeAdded != null && (paramsForViewBeforeAdded instanceof FlexItem)) {
            order.order = ((FlexItem) paramsForViewBeforeAdded).getOrder();
        } else {
            order.order = 1;
        }
        if (indexForViewBeforeAdded != -1 && indexForViewBeforeAdded != flexItemCount) {
            if (indexForViewBeforeAdded < this.mFlexContainer.getFlexItemCount()) {
                order.index = indexForViewBeforeAdded;
                while (indexForViewBeforeAdded < flexItemCount) {
                    createOrders.get(indexForViewBeforeAdded).index++;
                    indexForViewBeforeAdded++;
                }
            } else {
                order.index = flexItemCount;
            }
        } else {
            order.index = flexItemCount;
        }
        createOrders.add(order);
        return sortOrdersIntoReorderedIndices(flexItemCount + 1, createOrders, orderCache);
    }

    public void determineCrossSize(int widthMeasureSpec, int heightMeasureSpec, int paddingAlongCrossAxis) {
        int i;
        int i2;
        int flexDirection = this.mFlexContainer.getFlexDirection();
        if (flexDirection != 0 && flexDirection != 1) {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            i = View.MeasureSpec.getMode(widthMeasureSpec);
            i2 = View.MeasureSpec.getSize(widthMeasureSpec);
        } else {
            int mode = View.MeasureSpec.getMode(heightMeasureSpec);
            int size = View.MeasureSpec.getSize(heightMeasureSpec);
            i = mode;
            i2 = size;
        }
        List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
        if (i == 1073741824) {
            int sumOfCrossSize = this.mFlexContainer.getSumOfCrossSize() + paddingAlongCrossAxis;
            int i3 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).mCrossSize = i2 - paddingAlongCrossAxis;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.mFlexContainer.getAlignContent();
                if (alignContent != 1) {
                    if (alignContent != 2) {
                        if (alignContent != 3) {
                            if (alignContent != 4) {
                                if (alignContent == 5 && sumOfCrossSize < i2) {
                                    float size2 = (i2 - sumOfCrossSize) / flexLinesInternal.size();
                                    int size3 = flexLinesInternal.size();
                                    float f = 0.0f;
                                    while (i3 < size3) {
                                        FlexLine flexLine = flexLinesInternal.get(i3);
                                        float f2 = flexLine.mCrossSize + size2;
                                        if (i3 == flexLinesInternal.size() - 1) {
                                            f2 += f;
                                            f = 0.0f;
                                        }
                                        int round = Math.round(f2);
                                        f += f2 - round;
                                        if (f > 1.0f) {
                                            round++;
                                            f -= 1.0f;
                                        } else if (f < -1.0f) {
                                            round--;
                                            f += 1.0f;
                                        }
                                        flexLine.mCrossSize = round;
                                        i3++;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (sumOfCrossSize >= i2) {
                                this.mFlexContainer.setFlexLines(constructFlexLinesForAlignContentCenter(flexLinesInternal, i2, sumOfCrossSize));
                                return;
                            }
                            int size4 = (i2 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                            ArrayList arrayList = new ArrayList();
                            FlexLine flexLine2 = new FlexLine();
                            flexLine2.mCrossSize = size4;
                            for (FlexLine flexLine3 : flexLinesInternal) {
                                arrayList.add(flexLine2);
                                arrayList.add(flexLine3);
                                arrayList.add(flexLine2);
                            }
                            this.mFlexContainer.setFlexLines(arrayList);
                            return;
                        }
                        if (sumOfCrossSize < i2) {
                            float size5 = (i2 - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                            ArrayList arrayList2 = new ArrayList();
                            int size6 = flexLinesInternal.size();
                            float f3 = 0.0f;
                            while (i3 < size6) {
                                arrayList2.add(flexLinesInternal.get(i3));
                                if (i3 != flexLinesInternal.size() - 1) {
                                    FlexLine flexLine4 = new FlexLine();
                                    if (i3 == flexLinesInternal.size() - 2) {
                                        flexLine4.mCrossSize = Math.round(f3 + size5);
                                        f3 = 0.0f;
                                    } else {
                                        flexLine4.mCrossSize = Math.round(size5);
                                    }
                                    int i4 = flexLine4.mCrossSize;
                                    f3 += size5 - i4;
                                    if (f3 > 1.0f) {
                                        flexLine4.mCrossSize = i4 + 1;
                                        f3 -= 1.0f;
                                    } else if (f3 < -1.0f) {
                                        flexLine4.mCrossSize = i4 - 1;
                                        f3 += 1.0f;
                                    }
                                    arrayList2.add(flexLine4);
                                }
                                i3++;
                            }
                            this.mFlexContainer.setFlexLines(arrayList2);
                            return;
                        }
                        return;
                    }
                    this.mFlexContainer.setFlexLines(constructFlexLinesForAlignContentCenter(flexLinesInternal, i2, sumOfCrossSize));
                    return;
                }
                int i5 = i2 - sumOfCrossSize;
                FlexLine flexLine5 = new FlexLine();
                flexLine5.mCrossSize = i5;
                flexLinesInternal.add(0, flexLine5);
            }
        }
    }

    public void determineMainSize(int widthMeasureSpec, int heightMeasureSpec) {
        determineMainSize(widthMeasureSpec, heightMeasureSpec, 0);
    }

    public void ensureIndexToFlexLine(int size) {
        int[] iArr = this.mIndexToFlexLine;
        if (iArr == null) {
            this.mIndexToFlexLine = new int[Math.max(size, 10)];
        } else if (iArr.length < size) {
            this.mIndexToFlexLine = Arrays.copyOf(this.mIndexToFlexLine, Math.max(iArr.length * 2, size));
        }
    }

    public void ensureMeasureSpecCache(int size) {
        long[] jArr = this.mMeasureSpecCache;
        if (jArr == null) {
            this.mMeasureSpecCache = new long[Math.max(size, 10)];
        } else if (jArr.length < size) {
            this.mMeasureSpecCache = Arrays.copyOf(this.mMeasureSpecCache, Math.max(jArr.length * 2, size));
        }
    }

    public void ensureMeasuredSizeCache(int size) {
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr == null) {
            this.mMeasuredSizeCache = new long[Math.max(size, 10)];
        } else if (jArr.length < size) {
            this.mMeasuredSizeCache = Arrays.copyOf(this.mMeasuredSizeCache, Math.max(jArr.length * 2, size));
        }
    }

    public int extractHigherInt(long longValue) {
        return (int) (longValue >> 32);
    }

    public int extractLowerInt(long longValue) {
        return (int) longValue;
    }

    public boolean isOrderChangedFromLastMeasurement(SparseIntArray orderCache) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        if (orderCache.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View flexItemAt = this.mFlexContainer.getFlexItemAt(i);
            if (flexItemAt != null && ((FlexItem) flexItemAt.getLayoutParams()).getOrder() != orderCache.get(i)) {
                return true;
            }
        }
        return false;
    }

    public void layoutSingleChildHorizontal(View view, FlexLine flexLine, int left, int top, int right, int bottom) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mFlexContainer.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i = flexLine.mCrossSize;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems != 2) {
                    if (alignItems != 3) {
                        if (alignItems != 4) {
                            return;
                        }
                    } else if (this.mFlexContainer.getFlexWrap() != 2) {
                        int max = Math.max(flexLine.mMaxBaseline - view.getBaseline(), flexItem.getMarginTop());
                        view.layout(left, top + max, right, bottom + max);
                        return;
                    } else {
                        int max2 = Math.max((flexLine.mMaxBaseline - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                        view.layout(left, top - max2, right, bottom - max2);
                        return;
                    }
                } else {
                    int measuredHeight = (((i - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                    if (this.mFlexContainer.getFlexWrap() != 2) {
                        int i2 = top + measuredHeight;
                        view.layout(left, i2, right, view.getMeasuredHeight() + i2);
                        return;
                    } else {
                        int i3 = top - measuredHeight;
                        view.layout(left, i3, right, view.getMeasuredHeight() + i3);
                        return;
                    }
                }
            } else if (this.mFlexContainer.getFlexWrap() != 2) {
                int i4 = top + i;
                view.layout(left, (i4 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), right, i4 - flexItem.getMarginBottom());
                return;
            } else {
                view.layout(left, (top - i) + view.getMeasuredHeight() + flexItem.getMarginTop(), right, (bottom - i) + view.getMeasuredHeight() + flexItem.getMarginTop());
                return;
            }
        }
        if (this.mFlexContainer.getFlexWrap() != 2) {
            view.layout(left, top + flexItem.getMarginTop(), right, bottom + flexItem.getMarginTop());
        } else {
            view.layout(left, top - flexItem.getMarginBottom(), right, bottom - flexItem.getMarginBottom());
        }
    }

    public void layoutSingleChildVertical(View view, FlexLine flexLine, boolean isRtl, int left, int top, int right, int bottom) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mFlexContainer.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i = flexLine.mCrossSize;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems != 2) {
                    if (alignItems != 3 && alignItems != 4) {
                        return;
                    }
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int measuredWidth = (((i - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams)) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                    if (!isRtl) {
                        view.layout(left + measuredWidth, top, right + measuredWidth, bottom);
                        return;
                    } else {
                        view.layout(left - measuredWidth, top, right - measuredWidth, bottom);
                        return;
                    }
                }
            } else if (!isRtl) {
                view.layout(((left + i) - view.getMeasuredWidth()) - flexItem.getMarginRight(), top, ((right + i) - view.getMeasuredWidth()) - flexItem.getMarginRight(), bottom);
                return;
            } else {
                view.layout((left - i) + view.getMeasuredWidth() + flexItem.getMarginLeft(), top, (right - i) + view.getMeasuredWidth() + flexItem.getMarginLeft(), bottom);
                return;
            }
        }
        if (!isRtl) {
            view.layout(left + flexItem.getMarginLeft(), top, right + flexItem.getMarginLeft(), bottom);
        } else {
            view.layout(left - flexItem.getMarginRight(), top, right - flexItem.getMarginRight(), bottom);
        }
    }

    @VisibleForTesting
    public long makeCombinedLong(int widthMeasureSpec, int heightMeasureSpec) {
        return (widthMeasureSpec & 4294967295L) | (heightMeasureSpec << 32);
    }

    public void stretchViews() {
        stretchViews(0);
    }

    public void calculateHorizontalFlexLines(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int fromIndex, @Nullable List<FlexLine> existingLines) {
        calculateFlexLines(result, widthMeasureSpec, heightMeasureSpec, needsCalcAmount, fromIndex, -1, existingLines);
    }

    public void calculateVerticalFlexLines(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int fromIndex, @Nullable List<FlexLine> existingLines) {
        calculateFlexLines(result, heightMeasureSpec, widthMeasureSpec, needsCalcAmount, fromIndex, -1, existingLines);
    }

    public void determineMainSize(int widthMeasureSpec, int heightMeasureSpec, int fromIndex) {
        int size;
        int paddingLeft;
        int paddingRight;
        ensureChildrenFrozen(this.mFlexContainer.getFlexItemCount());
        if (fromIndex >= this.mFlexContainer.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.mFlexContainer.getFlexDirection();
        int flexDirection2 = this.mFlexContainer.getFlexDirection();
        if (flexDirection2 != 0 && flexDirection2 != 1) {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode = View.MeasureSpec.getMode(heightMeasureSpec);
            size = View.MeasureSpec.getSize(heightMeasureSpec);
            if (mode != 1073741824) {
                size = this.mFlexContainer.getLargestMainSize();
            }
            paddingLeft = this.mFlexContainer.getPaddingTop();
            paddingRight = this.mFlexContainer.getPaddingBottom();
        } else {
            int mode2 = View.MeasureSpec.getMode(widthMeasureSpec);
            size = View.MeasureSpec.getSize(widthMeasureSpec);
            int largestMainSize = this.mFlexContainer.getLargestMainSize();
            if (mode2 != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.mFlexContainer.getPaddingLeft();
            paddingRight = this.mFlexContainer.getPaddingRight();
        }
        int i = paddingLeft + paddingRight;
        int[] iArr = this.mIndexToFlexLine;
        List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i2 = iArr != null ? iArr[fromIndex] : 0; i2 < size2; i2++) {
            FlexLine flexLine = flexLinesInternal.get(i2);
            int i3 = flexLine.mMainSize;
            if (i3 < size && flexLine.mAnyItemsHaveFlexGrow) {
                expandFlexItems(widthMeasureSpec, heightMeasureSpec, flexLine, size, i, false);
            } else if (i3 > size && flexLine.mAnyItemsHaveFlexShrink) {
                shrinkFlexItems(widthMeasureSpec, heightMeasureSpec, flexLine, size, i, false);
            }
        }
    }

    public void stretchViews(int fromIndex) {
        View reorderedFlexItemAt;
        if (fromIndex >= this.mFlexContainer.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.mFlexContainer.getFlexDirection();
        if (this.mFlexContainer.getAlignItems() == 4) {
            int[] iArr = this.mIndexToFlexLine;
            List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i = iArr != null ? iArr[fromIndex] : 0; i < size; i++) {
                FlexLine flexLine = flexLinesInternal.get(i);
                int i2 = flexLine.mItemCount;
                for (int i3 = 0; i3 < i2; i3++) {
                    int i4 = flexLine.mFirstIndex + i3;
                    if (i3 < this.mFlexContainer.getFlexItemCount() && (reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i4)) != null && reorderedFlexItemAt.getVisibility() != 8) {
                        FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                        if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                            if (flexDirection != 0 && flexDirection != 1) {
                                if (flexDirection != 2 && flexDirection != 3) {
                                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                                }
                                stretchViewHorizontally(reorderedFlexItemAt, flexLine.mCrossSize, i4);
                            } else {
                                stretchViewVertically(reorderedFlexItemAt, flexLine.mCrossSize, i4);
                            }
                        }
                    }
                }
            }
            return;
        }
        for (FlexLine flexLine2 : this.mFlexContainer.getFlexLinesInternal()) {
            for (Integer num : flexLine2.mIndicesAlignSelfStretch) {
                View reorderedFlexItemAt2 = this.mFlexContainer.getReorderedFlexItemAt(num.intValue());
                if (flexDirection != 0 && flexDirection != 1) {
                    if (flexDirection != 2 && flexDirection != 3) {
                        throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                    }
                    stretchViewHorizontally(reorderedFlexItemAt2, flexLine2.mCrossSize, num.intValue());
                } else {
                    stretchViewVertically(reorderedFlexItemAt2, flexLine2.mCrossSize, num.intValue());
                }
            }
        }
    }

    public int[] createReorderedIndices(SparseIntArray orderCache) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        return sortOrdersIntoReorderedIndices(flexItemCount, createOrders(flexItemCount), orderCache);
    }
}
