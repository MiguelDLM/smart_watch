package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float endShiftRange;
    private final List<KeylineState> endStateSteps;
    private final float[] endStateStepsInterpolationPoints;
    private final float startShiftRange;
    private final List<KeylineState> startStateSteps;
    private final float[] startStateStepsInterpolationPoints;

    private KeylineStateList(@NonNull KeylineState keylineState, List<KeylineState> list, List<KeylineState> list2) {
        this.defaultState = keylineState;
        this.startStateSteps = Collections.unmodifiableList(list);
        this.endStateSteps = Collections.unmodifiableList(list2);
        float f = list.get(list.size() - 1).getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
        this.startShiftRange = f;
        float f2 = keylineState.getLastKeyline().loc - list2.get(list2.size() - 1).getLastKeyline().loc;
        this.endShiftRange = f2;
        this.startStateStepsInterpolationPoints = getStateStepInterpolationPoints(f, list, true);
        this.endStateStepsInterpolationPoints = getStateStepInterpolationPoints(f2, list2, false);
    }

    private KeylineState closestStateStepFromInterpolation(List<KeylineState> list, float f, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f, fArr);
        if (stateStepsRange[0] >= 0.5f) {
            return list.get((int) stateStepsRange[2]);
        }
        return list.get((int) stateStepsRange[1]);
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState keylineState, float f) {
        for (int lastFocalKeylineIndex = keylineState.getLastFocalKeylineIndex(); lastFocalKeylineIndex < keylineState.getKeylines().size(); lastFocalKeylineIndex++) {
            if (f == keylineState.getKeylines().get(lastFocalKeylineIndex).mask) {
                return lastFocalKeylineIndex;
            }
        }
        return keylineState.getKeylines().size() - 1;
    }

    private static int findFirstNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int i = 0; i < keylineState.getKeylines().size(); i++) {
            if (!keylineState.getKeylines().get(i).isAnchor) {
                return i;
            }
        }
        return -1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState keylineState, float f) {
        for (int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - 1; firstFocalKeylineIndex >= 0; firstFocalKeylineIndex--) {
            if (f == keylineState.getKeylines().get(firstFocalKeylineIndex).mask) {
                return firstFocalKeylineIndex;
            }
        }
        return 0;
    }

    private static int findLastNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int size = keylineState.getKeylines().size() - 1; size >= 0; size--) {
            if (!keylineState.getKeylines().get(size).isAnchor) {
                return size;
            }
        }
        return -1;
    }

    public static KeylineStateList from(Carousel carousel, KeylineState keylineState, float f, float f2, float f3) {
        return new KeylineStateList(keylineState, getStateStepsStart(carousel, keylineState, f, f2), getStateStepsEnd(carousel, keylineState, f, f3));
    }

    private static float[] getStateStepInterpolationPoints(float f, List<KeylineState> list, boolean z) {
        float f2;
        float f3;
        int size = list.size();
        float[] fArr = new float[size];
        for (int i = 1; i < size; i++) {
            int i2 = i - 1;
            KeylineState keylineState = list.get(i2);
            KeylineState keylineState2 = list.get(i);
            if (z) {
                f2 = keylineState2.getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
            } else {
                f2 = keylineState.getLastKeyline().loc - keylineState2.getLastKeyline().loc;
            }
            float f4 = f2 / f;
            if (i == size - 1) {
                f3 = 1.0f;
            } else {
                f3 = fArr[i2] + f4;
            }
            fArr[i] = f3;
        }
        return fArr;
    }

    private static List<KeylineState> getStateStepsEnd(Carousel carousel, KeylineState keylineState, float f, float f2) {
        int containerHeight;
        int i;
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int findLastNonAnchorKeylineIndex = findLastNonAnchorKeylineIndex(keylineState);
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        } else {
            containerHeight = carousel.getContainerHeight();
        }
        float f3 = containerHeight;
        if (!isLastFocalItemVisibleAtRightOfContainer(carousel, keylineState) && findLastNonAnchorKeylineIndex != -1) {
            int lastFocalKeylineIndex = findLastNonAnchorKeylineIndex - keylineState.getLastFocalKeylineIndex();
            float f4 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            if (lastFocalKeylineIndex <= 0 && keylineState.getLastFocalKeyline().cutoff > 0.0f) {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, f4 - keylineState.getLastFocalKeyline().cutoff, f3));
                return arrayList;
            }
            float f5 = 0.0f;
            int i2 = 0;
            while (i2 < lastFocalKeylineIndex) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int i3 = findLastNonAnchorKeylineIndex - i2;
                float f6 = f5 + keylineState.getKeylines().get(i3).cutoff;
                int i4 = i3 + 1;
                if (i4 < keylineState.getKeylines().size()) {
                    i = findLastIndexBeforeFirstFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i4).mask) + 1;
                } else {
                    i = 0;
                }
                int i5 = i2;
                KeylineState moveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState2, findLastNonAnchorKeylineIndex, i, f4 - f6, keylineState.getFirstFocalKeylineIndex() + i2 + 1, keylineState.getLastFocalKeylineIndex() + i2 + 1, f3);
                if (i5 == lastFocalKeylineIndex - 1 && f2 > 0.0f) {
                    moveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(moveKeylineAndCreateKeylineState, f2, f3, false, f);
                }
                arrayList.add(moveKeylineAndCreateKeylineState);
                i2 = i5 + 1;
                f5 = f6;
            }
            return arrayList;
        }
        if (f2 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState, f2, f3, false, f));
        }
        return arrayList;
    }

    private static float[] getStateStepsRange(List<KeylineState> list, float f, float[] fArr) {
        int size = list.size();
        float f2 = fArr[0];
        int i = 1;
        while (i < size) {
            float f3 = fArr[i];
            if (f <= f3) {
                return new float[]{AnimationUtils.lerp(0.0f, 1.0f, f2, f3, f), i - 1, i};
            }
            i++;
            f2 = f3;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List<KeylineState> getStateStepsStart(Carousel carousel, KeylineState keylineState, float f, float f2) {
        int containerHeight;
        int i;
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int findFirstNonAnchorKeylineIndex = findFirstNonAnchorKeylineIndex(keylineState);
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        } else {
            containerHeight = carousel.getContainerHeight();
        }
        float f3 = containerHeight;
        int i2 = 1;
        if (!isFirstFocalItemAtLeftOfContainer(keylineState) && findFirstNonAnchorKeylineIndex != -1) {
            int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - findFirstNonAnchorKeylineIndex;
            float f4 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            if (firstFocalKeylineIndex <= 0 && keylineState.getFirstFocalKeyline().cutoff > 0.0f) {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, f4 + keylineState.getFirstFocalKeyline().cutoff, f3));
                return arrayList;
            }
            float f5 = 0.0f;
            int i3 = 0;
            while (i3 < firstFocalKeylineIndex) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - i2);
                int i4 = findFirstNonAnchorKeylineIndex + i3;
                int size = keylineState.getKeylines().size() - i2;
                float f6 = f5 + keylineState.getKeylines().get(i4).cutoff;
                int i5 = i4 - i2;
                if (i5 >= 0) {
                    i = findFirstIndexAfterLastFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i5).mask) - i2;
                } else {
                    i = size;
                }
                int i6 = i3;
                KeylineState moveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState2, findFirstNonAnchorKeylineIndex, i, f4 + f6, (keylineState.getFirstFocalKeylineIndex() - i3) - 1, (keylineState.getLastFocalKeylineIndex() - i3) - 1, f3);
                if (i6 == firstFocalKeylineIndex - 1 && f2 > 0.0f) {
                    moveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(moveKeylineAndCreateKeylineState, f2, f3, true, f);
                }
                arrayList.add(moveKeylineAndCreateKeylineState);
                i3 = i6 + 1;
                f5 = f6;
                i2 = 1;
            }
            return arrayList;
        }
        if (f2 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState, f2, f3, true, f));
        }
        return arrayList;
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState keylineState) {
        if (keylineState.getFirstFocalKeyline().locOffset - (keylineState.getFirstFocalKeyline().maskedItemSize / 2.0f) >= 0.0f && keylineState.getFirstFocalKeyline() == keylineState.getFirstNonAnchorKeyline()) {
            return true;
        }
        return false;
    }

    private static boolean isLastFocalItemVisibleAtRightOfContainer(Carousel carousel, KeylineState keylineState) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        if (keylineState.getLastFocalKeyline().locOffset + (keylineState.getLastFocalKeyline().maskedItemSize / 2.0f) <= containerHeight && keylineState.getLastFocalKeyline() == keylineState.getLastNonAnchorKeyline()) {
            return true;
        }
        return false;
    }

    private static KeylineState lerp(List<KeylineState> list, float f, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f, fArr);
        return KeylineState.lerp(list.get((int) stateStepsRange[1]), list.get((int) stateStepsRange[2]), stateStepsRange[0]);
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState keylineState, int i, int i2, float f, int i3, int i4, float f2) {
        boolean z;
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        arrayList.add(i2, (KeylineState.Keyline) arrayList.remove(i));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), f2);
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i5);
            float f3 = keyline.maskedItemSize;
            float f4 = f + (f3 / 2.0f);
            if (i5 >= i3 && i5 <= i4) {
                z = true;
            } else {
                z = false;
            }
            builder.addKeyline(f4, keyline.mask, f3, z, keyline.isAnchor, keyline.cutoff);
            f += keyline.maskedItemSize;
        }
        return builder.build();
    }

    private static KeylineState shiftKeylineStateForPadding(KeylineState keylineState, float f, float f2, boolean z, float f3) {
        float f4;
        boolean z2;
        float f5;
        float f6;
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), f2);
        float numberOfNonAnchorKeylines = f / keylineState.getNumberOfNonAnchorKeylines();
        if (z) {
            f4 = f;
        } else {
            f4 = 0.0f;
        }
        float f7 = f4;
        for (int i = 0; i < arrayList.size(); i++) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i);
            if (keyline.isAnchor) {
                builder.addKeyline(keyline.locOffset, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
            } else {
                if (i >= keylineState.getFirstFocalKeylineIndex() && i <= keylineState.getLastFocalKeylineIndex()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                float f8 = keyline.maskedItemSize - numberOfNonAnchorKeylines;
                float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(f8, keylineState.getItemSize(), f3);
                float f9 = (f8 / 2.0f) + f7;
                float f10 = f9 - keyline.locOffset;
                float f11 = keyline.cutoff;
                if (z) {
                    f5 = f10;
                } else {
                    f5 = 0.0f;
                }
                if (z) {
                    f6 = 0.0f;
                } else {
                    f6 = f10;
                }
                builder.addKeyline(f9, childMaskPercentage, f8, z2, false, f11, f5, f6);
                f7 += f8;
            }
        }
        return builder.build();
    }

    private static KeylineState shiftKeylinesAndCreateKeylineState(KeylineState keylineState, float f, float f2) {
        return moveKeylineAndCreateKeylineState(keylineState, 0, 0, f, keylineState.getFirstFocalKeylineIndex(), keylineState.getLastFocalKeylineIndex(), f2);
    }

    public KeylineState getDefaultState() {
        return this.defaultState;
    }

    public KeylineState getEndState() {
        return this.endStateSteps.get(r0.size() - 1);
    }

    public Map<Integer, KeylineState> getKeylineStateForPositionMap(int i, int i2, int i3, boolean z) {
        int i4;
        int i5;
        int i6;
        float itemSize = this.defaultState.getItemSize();
        HashMap hashMap = new HashMap();
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = -1;
            if (i7 >= i) {
                break;
            }
            if (z) {
                i6 = (i - i7) - 1;
            } else {
                i6 = i7;
            }
            float f = i6 * itemSize;
            if (!z) {
                i9 = 1;
            }
            if (f * i9 > i3 - this.endShiftRange || i7 >= i - this.endStateSteps.size()) {
                Integer valueOf = Integer.valueOf(i6);
                List<KeylineState> list = this.endStateSteps;
                hashMap.put(valueOf, list.get(MathUtils.clamp(i8, 0, list.size() - 1)));
                i8++;
            }
            i7++;
        }
        int i10 = 0;
        for (int i11 = i - 1; i11 >= 0; i11--) {
            if (z) {
                i4 = (i - i11) - 1;
            } else {
                i4 = i11;
            }
            float f2 = i4 * itemSize;
            if (z) {
                i5 = -1;
            } else {
                i5 = 1;
            }
            if (f2 * i5 < i2 + this.startShiftRange || i11 < this.startStateSteps.size()) {
                Integer valueOf2 = Integer.valueOf(i4);
                List<KeylineState> list2 = this.startStateSteps;
                hashMap.put(valueOf2, list2.get(MathUtils.clamp(i10, 0, list2.size() - 1)));
                i10++;
            }
        }
        return hashMap;
    }

    public KeylineState getShiftedState(float f, float f2, float f3) {
        return getShiftedState(f, f2, f3, false);
    }

    public KeylineState getStartState() {
        return this.startStateSteps.get(r0.size() - 1);
    }

    public KeylineState getShiftedState(float f, float f2, float f3, boolean z) {
        float lerp;
        List<KeylineState> list;
        float[] fArr;
        float f4 = this.startShiftRange + f2;
        float f5 = f3 - this.endShiftRange;
        float f6 = getStartState().getFirstFocalKeyline().leftOrTopPaddingShift;
        float f7 = getEndState().getLastFocalKeyline().rightOrBottomPaddingShift;
        if (this.startShiftRange == f6) {
            f4 += f6;
        }
        if (this.endShiftRange == f7) {
            f5 -= f7;
        }
        if (f < f4) {
            lerp = AnimationUtils.lerp(1.0f, 0.0f, f2, f4, f);
            list = this.startStateSteps;
            fArr = this.startStateStepsInterpolationPoints;
        } else if (f > f5) {
            lerp = AnimationUtils.lerp(0.0f, 1.0f, f5, f3, f);
            list = this.endStateSteps;
            fArr = this.endStateStepsInterpolationPoints;
        } else {
            return this.defaultState;
        }
        if (z) {
            return closestStateStepFromInterpolation(list, lerp, fArr);
        }
        return lerp(list, lerp, fArr);
    }
}
