package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import java.util.ArrayList;

public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            i3 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = 0;
        } else {
            i3 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i2 = 2;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            if (arrayList == null || arrayList.contains(chainHead.mFirst)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i2, chainHead);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: androidx.constraintlayout.core.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: androidx.constraintlayout.core.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: androidx.constraintlayout.core.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: androidx.constraintlayout.core.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: androidx.constraintlayout.core.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v39, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX WARNING: type inference failed for: r5v10, types: [androidx.constraintlayout.core.SolverVariable] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r7 == 2) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004b, code lost:
        if (r7 == 2) goto L_0x0033;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0261 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02bf A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x03a7  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x03bc  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x03c5  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x04a0  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x04de A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x04ea  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x04f6  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x04f9  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x04ff  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0502  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0506  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0516  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x051a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x03a9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:328:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void applyChainConstraints(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r37, androidx.constraintlayout.core.LinearSystem r38, int r39, int r40, androidx.constraintlayout.core.widgets.ChainHead r41) {
        /*
            r0 = r37
            r9 = r38
            r10 = r39
            r1 = r41
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r1.mFirst
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = r1.mLast
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = r1.mFirstVisibleWidget
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = r1.mLastVisibleWidget
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r1.mHead
            float r3 = r1.mTotalWeight
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r10]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r15 = 1
            if (r4 != r5) goto L_0x001f
            r4 = 1
            goto L_0x0020
        L_0x001f:
            r4 = 0
        L_0x0020:
            r5 = 2
            if (r10 != 0) goto L_0x003d
            int r7 = r2.mHorizontalChainStyle
            if (r7 != 0) goto L_0x0029
            r8 = 1
            goto L_0x002a
        L_0x0029:
            r8 = 0
        L_0x002a:
            if (r7 != r15) goto L_0x002f
            r16 = 1
            goto L_0x0031
        L_0x002f:
            r16 = 0
        L_0x0031:
            if (r7 != r5) goto L_0x0035
        L_0x0033:
            r5 = 1
            goto L_0x0036
        L_0x0035:
            r5 = 0
        L_0x0036:
            r17 = r16
            r7 = 0
            r16 = r8
            r8 = r11
            goto L_0x004e
        L_0x003d:
            int r7 = r2.mVerticalChainStyle
            if (r7 != 0) goto L_0x0043
            r8 = 1
            goto L_0x0044
        L_0x0043:
            r8 = 0
        L_0x0044:
            if (r7 != r15) goto L_0x0049
            r16 = 1
            goto L_0x004b
        L_0x0049:
            r16 = 0
        L_0x004b:
            if (r7 != r5) goto L_0x0035
            goto L_0x0033
        L_0x004e:
            r21 = 0
            if (r7 != 0) goto L_0x0130
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r8.mListAnchors
            r6 = r6[r40]
            if (r5 == 0) goto L_0x005b
            r19 = 1
            goto L_0x005d
        L_0x005b:
            r19 = 4
        L_0x005d:
            int r23 = r6.getMargin()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r15 = r8.mListDimensionBehaviors
            r15 = r15[r10]
            r25 = r3
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r15 != r3) goto L_0x0075
            int[] r15 = r8.mResolvedMatchConstraintDefault
            r15 = r15[r10]
            if (r15 != 0) goto L_0x0075
            r26 = r7
            r15 = 1
            goto L_0x0078
        L_0x0075:
            r26 = r7
            r15 = 0
        L_0x0078:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r6.mTarget
            if (r7 == 0) goto L_0x0084
            if (r8 == r11) goto L_0x0084
            int r7 = r7.getMargin()
            int r23 = r23 + r7
        L_0x0084:
            r7 = r23
            if (r5 == 0) goto L_0x0091
            if (r8 == r11) goto L_0x0091
            if (r8 == r13) goto L_0x0091
            r23 = r2
            r19 = 8
            goto L_0x0093
        L_0x0091:
            r23 = r2
        L_0x0093:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r6.mTarget
            if (r2 == 0) goto L_0x00cd
            if (r8 != r13) goto L_0x00a4
            r27 = r11
            androidx.constraintlayout.core.SolverVariable r11 = r6.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            r1 = 6
            r9.addGreaterThan(r11, r2, r7, r1)
            goto L_0x00af
        L_0x00a4:
            r27 = r11
            androidx.constraintlayout.core.SolverVariable r1 = r6.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            r11 = 8
            r9.addGreaterThan(r1, r2, r7, r11)
        L_0x00af:
            if (r15 == 0) goto L_0x00b5
            if (r5 != 0) goto L_0x00b5
            r19 = 5
        L_0x00b5:
            if (r8 != r13) goto L_0x00c1
            if (r5 == 0) goto L_0x00c1
            boolean r1 = r8.isInBarrier(r10)
            if (r1 == 0) goto L_0x00c1
            r1 = 5
            goto L_0x00c3
        L_0x00c1:
            r1 = r19
        L_0x00c3:
            androidx.constraintlayout.core.SolverVariable r2 = r6.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.mTarget
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            r9.addEquality(r2, r6, r7, r1)
            goto L_0x00cf
        L_0x00cd:
            r27 = r11
        L_0x00cf:
            if (r4 == 0) goto L_0x0103
            int r1 = r8.getVisibility()
            r2 = 8
            if (r1 == r2) goto L_0x00f1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r8.mListDimensionBehaviors
            r1 = r1[r10]
            if (r1 != r3) goto L_0x00f1
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            int r2 = r40 + 1
            r2 = r1[r2]
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            r1 = r1[r40]
            androidx.constraintlayout.core.SolverVariable r1 = r1.mSolverVariable
            r3 = 0
            r6 = 5
            r9.addGreaterThan(r2, r1, r3, r6)
            goto L_0x00f2
        L_0x00f1:
            r3 = 0
        L_0x00f2:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            r1 = r1[r40]
            androidx.constraintlayout.core.SolverVariable r1 = r1.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r0.mListAnchors
            r2 = r2[r40]
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            r6 = 8
            r9.addGreaterThan(r1, r2, r3, r6)
        L_0x0103:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            int r2 = r40 + 1
            r1 = r1[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 == 0) goto L_0x011e
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.mOwner
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r1.mListAnchors
            r2 = r2[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x011e
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r2.mOwner
            if (r2 == r8) goto L_0x011c
            goto L_0x011e
        L_0x011c:
            r21 = r1
        L_0x011e:
            if (r21 == 0) goto L_0x0125
            r8 = r21
            r7 = r26
            goto L_0x0126
        L_0x0125:
            r7 = 1
        L_0x0126:
            r1 = r41
            r2 = r23
            r3 = r25
            r11 = r27
            goto L_0x004e
        L_0x0130:
            r23 = r2
            r25 = r3
            r27 = r11
            if (r14 == 0) goto L_0x0194
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            int r2 = r40 + 1
            r1 = r1[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 == 0) goto L_0x0194
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r14.mListAnchors
            r1 = r1[r2]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r14.mListDimensionBehaviors
            r3 = r3[r10]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r6) goto L_0x016a
            int[] r3 = r14.mResolvedMatchConstraintDefault
            r3 = r3[r10]
            if (r3 != 0) goto L_0x016a
            if (r5 != 0) goto L_0x016a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r3.mOwner
            if (r6 != r0) goto L_0x016a
            androidx.constraintlayout.core.SolverVariable r6 = r1.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
            int r7 = r1.getMargin()
            int r7 = -r7
            r8 = 5
            r9.addEquality(r6, r3, r7, r8)
            goto L_0x0180
        L_0x016a:
            r8 = 5
            if (r5 == 0) goto L_0x0180
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r3.mOwner
            if (r6 != r0) goto L_0x0180
            androidx.constraintlayout.core.SolverVariable r6 = r1.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
            int r7 = r1.getMargin()
            int r7 = -r7
            r11 = 4
            r9.addEquality(r6, r3, r7, r11)
        L_0x0180:
            androidx.constraintlayout.core.SolverVariable r3 = r1.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r12.mListAnchors
            r2 = r6[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            int r1 = r1.getMargin()
            int r1 = -r1
            r6 = 6
            r9.addLowerThan(r3, r2, r1, r6)
            goto L_0x0195
        L_0x0194:
            r8 = 5
        L_0x0195:
            if (r4 == 0) goto L_0x01ae
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            int r1 = r40 + 1
            r0 = r0[r1]
            androidx.constraintlayout.core.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r12.mListAnchors
            r1 = r2[r1]
            androidx.constraintlayout.core.SolverVariable r2 = r1.mSolverVariable
            int r1 = r1.getMargin()
            r3 = 8
            r9.addGreaterThan(r0, r2, r1, r3)
        L_0x01ae:
            r0 = r41
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r1 = r0.mWeightedMatchConstraintsWidgets
            if (r1 == 0) goto L_0x025f
            int r2 = r1.size()
            r3 = 1
            if (r2 <= r3) goto L_0x025f
            boolean r3 = r0.mHasUndefinedWeights
            if (r3 == 0) goto L_0x01c7
            boolean r3 = r0.mHasComplexMatchWeights
            if (r3 != 0) goto L_0x01c7
            int r3 = r0.mWidgetsMatchCount
            float r3 = (float) r3
            goto L_0x01c9
        L_0x01c7:
            r3 = r25
        L_0x01c9:
            r4 = 0
            r7 = r21
            r6 = 0
            r29 = 0
        L_0x01cf:
            if (r6 >= r2) goto L_0x025f
            java.lang.Object r11 = r1.get(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r11
            float[] r15 = r11.mWeight
            r15 = r15[r10]
            int r20 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r20 >= 0) goto L_0x01fb
            boolean r15 = r0.mHasComplexMatchWeights
            if (r15 == 0) goto L_0x01f6
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r11 = r11.mListAnchors
            int r15 = r40 + 1
            r15 = r11[r15]
            androidx.constraintlayout.core.SolverVariable r15 = r15.mSolverVariable
            r11 = r11[r40]
            androidx.constraintlayout.core.SolverVariable r11 = r11.mSolverVariable
            r4 = 4
            r8 = 0
            r9.addEquality(r15, r11, r8, r4)
            r4 = 0
            goto L_0x0213
        L_0x01f6:
            r4 = 4
            r15 = 1065353216(0x3f800000, float:1.0)
        L_0x01f9:
            r8 = 0
            goto L_0x01fd
        L_0x01fb:
            r4 = 4
            goto L_0x01f9
        L_0x01fd:
            int r19 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r19 != 0) goto L_0x0218
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r11 = r11.mListAnchors
            int r15 = r40 + 1
            r15 = r11[r15]
            androidx.constraintlayout.core.SolverVariable r15 = r15.mSolverVariable
            r11 = r11[r40]
            androidx.constraintlayout.core.SolverVariable r11 = r11.mSolverVariable
            r4 = 0
            r8 = 8
            r9.addEquality(r15, r11, r4, r8)
        L_0x0213:
            r25 = r1
            r18 = r2
            goto L_0x0255
        L_0x0218:
            r4 = 0
            if (r7 == 0) goto L_0x024e
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r7.mListAnchors
            r8 = r7[r40]
            androidx.constraintlayout.core.SolverVariable r8 = r8.mSolverVariable
            int r18 = r40 + 1
            r7 = r7[r18]
            androidx.constraintlayout.core.SolverVariable r7 = r7.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r11.mListAnchors
            r25 = r1
            r1 = r4[r40]
            androidx.constraintlayout.core.SolverVariable r1 = r1.mSolverVariable
            r4 = r4[r18]
            androidx.constraintlayout.core.SolverVariable r4 = r4.mSolverVariable
            r18 = r2
            androidx.constraintlayout.core.ArrayRow r2 = r38.createRow()
            r28 = r2
            r30 = r3
            r31 = r15
            r32 = r8
            r33 = r7
            r34 = r1
            r35 = r4
            r28.createRowEqualMatchDimensions(r29, r30, r31, r32, r33, r34, r35)
            r9.addConstraint(r2)
            goto L_0x0252
        L_0x024e:
            r25 = r1
            r18 = r2
        L_0x0252:
            r7 = r11
            r29 = r15
        L_0x0255:
            int r6 = r6 + 1
            r2 = r18
            r1 = r25
            r4 = 0
            r8 = 5
            goto L_0x01cf
        L_0x025f:
            if (r13 == 0) goto L_0x0268
            if (r13 == r14) goto L_0x0265
            if (r5 == 0) goto L_0x0268
        L_0x0265:
            r11 = r27
            goto L_0x026b
        L_0x0268:
            r11 = r27
            goto L_0x02bd
        L_0x026b:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r11.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            int r2 = r40 + 1
            r1 = r1[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 == 0) goto L_0x027d
            androidx.constraintlayout.core.SolverVariable r0 = r0.mSolverVariable
            r3 = r0
            goto L_0x027f
        L_0x027d:
            r3 = r21
        L_0x027f:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r1.mTarget
            if (r0 == 0) goto L_0x0287
            androidx.constraintlayout.core.SolverVariable r0 = r0.mSolverVariable
            r5 = r0
            goto L_0x0289
        L_0x0287:
            r5 = r21
        L_0x0289:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r40]
            if (r14 == 0) goto L_0x0293
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r14.mListAnchors
            r1 = r1[r2]
        L_0x0293:
            if (r3 == 0) goto L_0x04dc
            if (r5 == 0) goto L_0x04dc
            if (r10 != 0) goto L_0x029f
            r2 = r23
            float r2 = r2.mHorizontalBiasPercent
        L_0x029d:
            r4 = r2
            goto L_0x02a4
        L_0x029f:
            r2 = r23
            float r2 = r2.mVerticalBiasPercent
            goto L_0x029d
        L_0x02a4:
            int r6 = r0.getMargin()
            int r7 = r1.getMargin()
            androidx.constraintlayout.core.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r8 = r1.mSolverVariable
            r10 = 7
            r0 = r38
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04dc
        L_0x02bd:
            if (r16 == 0) goto L_0x03ae
            if (r13 == 0) goto L_0x03ae
            int r1 = r0.mWidgetsMatchCount
            if (r1 <= 0) goto L_0x02cc
            int r0 = r0.mWidgetsCount
            if (r0 != r1) goto L_0x02cc
            r24 = 1
            goto L_0x02ce
        L_0x02cc:
            r24 = 0
        L_0x02ce:
            r8 = r13
            r15 = r8
        L_0x02d0:
            if (r15 == 0) goto L_0x04dc
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r15.mNextChainWidget
            r0 = r0[r10]
            r7 = r0
        L_0x02d7:
            if (r7 == 0) goto L_0x02e6
            int r0 = r7.getVisibility()
            r6 = 8
            if (r0 != r6) goto L_0x02e8
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r7.mNextChainWidget
            r7 = r0[r10]
            goto L_0x02d7
        L_0x02e6:
            r6 = 8
        L_0x02e8:
            if (r7 != 0) goto L_0x02f5
            if (r15 != r14) goto L_0x02ed
            goto L_0x02f5
        L_0x02ed:
            r22 = r7
        L_0x02ef:
            r18 = r8
            r20 = 5
            goto L_0x039e
        L_0x02f5:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r15.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.core.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x0302
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            goto L_0x0304
        L_0x0302:
            r2 = r21
        L_0x0304:
            if (r8 == r15) goto L_0x030f
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r8.mListAnchors
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            goto L_0x031e
        L_0x030f:
            if (r15 != r13) goto L_0x031e
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x031c
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            goto L_0x031e
        L_0x031c:
            r2 = r21
        L_0x031e:
            int r0 = r0.getMargin()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r15.mListAnchors
            int r4 = r40 + 1
            r3 = r3[r4]
            int r3 = r3.getMargin()
            if (r7 == 0) goto L_0x0337
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r7.mListAnchors
            r5 = r5[r40]
            androidx.constraintlayout.core.SolverVariable r6 = r5.mSolverVariable
        L_0x0334:
            r37 = r7
            goto L_0x0346
        L_0x0337:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r12.mListAnchors
            r5 = r5[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x0342
            androidx.constraintlayout.core.SolverVariable r6 = r5.mSolverVariable
            goto L_0x0334
        L_0x0342:
            r37 = r7
            r6 = r21
        L_0x0346:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r15.mListAnchors
            r7 = r7[r4]
            androidx.constraintlayout.core.SolverVariable r7 = r7.mSolverVariable
            if (r5 == 0) goto L_0x0353
            int r5 = r5.getMargin()
            int r3 = r3 + r5
        L_0x0353:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            r5 = r5[r4]
            int r5 = r5.getMargin()
            int r0 = r0 + r5
            if (r1 == 0) goto L_0x039a
            if (r2 == 0) goto L_0x039a
            if (r6 == 0) goto L_0x039a
            if (r7 == 0) goto L_0x039a
            if (r15 != r13) goto L_0x036e
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r40]
            int r0 = r0.getMargin()
        L_0x036e:
            r5 = r0
            if (r15 != r14) goto L_0x037c
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r4]
            int r0 = r0.getMargin()
            r18 = r0
            goto L_0x037e
        L_0x037c:
            r18 = r3
        L_0x037e:
            if (r24 == 0) goto L_0x0383
            r19 = 8
            goto L_0x0385
        L_0x0383:
            r19 = 5
        L_0x0385:
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r3 = r5
            r5 = r6
            r20 = 5
            r6 = r7
            r22 = r37
            r7 = r18
            r18 = r8
            r8 = r19
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x039e
        L_0x039a:
            r22 = r37
            goto L_0x02ef
        L_0x039e:
            int r0 = r15.getVisibility()
            r8 = 8
            if (r0 == r8) goto L_0x03a7
            goto L_0x03a9
        L_0x03a7:
            r15 = r18
        L_0x03a9:
            r8 = r15
            r15 = r22
            goto L_0x02d0
        L_0x03ae:
            r8 = 8
            if (r17 == 0) goto L_0x04dc
            if (r13 == 0) goto L_0x04dc
            int r1 = r0.mWidgetsMatchCount
            if (r1 <= 0) goto L_0x03bf
            int r0 = r0.mWidgetsCount
            if (r0 != r1) goto L_0x03bf
            r24 = 1
            goto L_0x03c1
        L_0x03bf:
            r24 = 0
        L_0x03c1:
            r7 = r13
            r15 = r7
        L_0x03c3:
            if (r15 == 0) goto L_0x0487
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r15.mNextChainWidget
            r0 = r0[r10]
        L_0x03c9:
            if (r0 == 0) goto L_0x03d6
            int r1 = r0.getVisibility()
            if (r1 != r8) goto L_0x03d6
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r0.mNextChainWidget
            r0 = r0[r10]
            goto L_0x03c9
        L_0x03d6:
            if (r15 == r13) goto L_0x0470
            if (r15 == r14) goto L_0x0470
            if (r0 == 0) goto L_0x0470
            if (r0 != r14) goto L_0x03e1
            r6 = r21
            goto L_0x03e2
        L_0x03e1:
            r6 = r0
        L_0x03e2:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r15.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.core.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x03ee
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
        L_0x03ee:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r7.mListAnchors
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            int r0 = r0.getMargin()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r15.mListAnchors
            r4 = r4[r3]
            int r4 = r4.getMargin()
            if (r6 == 0) goto L_0x041b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r6.mListAnchors
            r5 = r5[r40]
            androidx.constraintlayout.core.SolverVariable r8 = r5.mSolverVariable
            r37 = r6
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r5.mTarget
            if (r6 == 0) goto L_0x0413
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            goto L_0x0415
        L_0x0413:
            r6 = r21
        L_0x0415:
            r36 = r8
            r8 = r6
            r6 = r36
            goto L_0x042e
        L_0x041b:
            r37 = r6
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r14.mListAnchors
            r5 = r5[r40]
            if (r5 == 0) goto L_0x0426
            androidx.constraintlayout.core.SolverVariable r6 = r5.mSolverVariable
            goto L_0x0428
        L_0x0426:
            r6 = r21
        L_0x0428:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r8 = r15.mListAnchors
            r8 = r8[r3]
            androidx.constraintlayout.core.SolverVariable r8 = r8.mSolverVariable
        L_0x042e:
            if (r5 == 0) goto L_0x0435
            int r5 = r5.getMargin()
            int r4 = r4 + r5
        L_0x0435:
            r18 = r4
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r7.mListAnchors
            r3 = r4[r3]
            int r3 = r3.getMargin()
            int r3 = r3 + r0
            if (r24 == 0) goto L_0x0445
            r20 = 8
            goto L_0x0447
        L_0x0445:
            r20 = 4
        L_0x0447:
            if (r1 == 0) goto L_0x0465
            if (r2 == 0) goto L_0x0465
            if (r6 == 0) goto L_0x0465
            if (r8 == 0) goto L_0x0465
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r19 = 4
            r5 = r6
            r22 = r37
            r6 = r8
            r23 = r7
            r7 = r18
            r10 = 8
            r8 = r20
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x046d
        L_0x0465:
            r22 = r37
            r23 = r7
            r10 = 8
            r19 = 4
        L_0x046d:
            r0 = r22
            goto L_0x0476
        L_0x0470:
            r23 = r7
            r10 = 8
            r19 = 4
        L_0x0476:
            int r1 = r15.getVisibility()
            if (r1 == r10) goto L_0x047e
            r7 = r15
            goto L_0x0480
        L_0x047e:
            r7 = r23
        L_0x0480:
            r10 = r39
            r15 = r0
            r8 = 8
            goto L_0x03c3
        L_0x0487:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r11.mListAnchors
            r1 = r1[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.mTarget
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            int r3 = r40 + 1
            r10 = r2[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r12.mListAnchors
            r2 = r2[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r2.mTarget
            r15 = 5
            if (r1 == 0) goto L_0x04cc
            if (r13 == r14) goto L_0x04ae
            androidx.constraintlayout.core.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r1 = r1.mSolverVariable
            int r0 = r0.getMargin()
            r9.addEquality(r2, r1, r0, r15)
            goto L_0x04cc
        L_0x04ae:
            if (r11 == 0) goto L_0x04cc
            androidx.constraintlayout.core.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r3 = r1.mSolverVariable
            int r4 = r0.getMargin()
            androidx.constraintlayout.core.SolverVariable r5 = r10.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r6 = r11.mSolverVariable
            int r7 = r10.getMargin()
            r8 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r8
            r8 = r15
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x04cc:
            if (r11 == 0) goto L_0x04dc
            if (r13 == r14) goto L_0x04dc
            androidx.constraintlayout.core.SolverVariable r0 = r10.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r1 = r11.mSolverVariable
            int r2 = r10.getMargin()
            int r2 = -r2
            r9.addEquality(r0, r1, r2, r15)
        L_0x04dc:
            if (r16 != 0) goto L_0x04e0
            if (r17 == 0) goto L_0x0539
        L_0x04e0:
            if (r13 == 0) goto L_0x0539
            if (r13 == r14) goto L_0x0539
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r1 = r0[r40]
            if (r14 != 0) goto L_0x04eb
            r14 = r13
        L_0x04eb:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            r3 = 1
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r1.mTarget
            if (r4 == 0) goto L_0x04f9
            androidx.constraintlayout.core.SolverVariable r4 = r4.mSolverVariable
            goto L_0x04fb
        L_0x04f9:
            r4 = r21
        L_0x04fb:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.mTarget
            if (r5 == 0) goto L_0x0502
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            goto L_0x0504
        L_0x0502:
            r5 = r21
        L_0x0504:
            if (r12 == r14) goto L_0x0514
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r12.mListAnchors
            r5 = r5[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x0512
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            r21 = r5
        L_0x0512:
            r5 = r21
        L_0x0514:
            if (r13 != r14) goto L_0x0518
            r2 = r0[r3]
        L_0x0518:
            if (r4 == 0) goto L_0x0539
            if (r5 == 0) goto L_0x0539
            int r6 = r1.getMargin()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r3]
            int r7 = r0.getMargin()
            androidx.constraintlayout.core.SolverVariable r1 = r1.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r8 = r2.mSolverVariable
            r10 = 5
            r11 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r2 = r4
            r3 = r6
            r4 = r11
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0539:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Chain.applyChainConstraints(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.LinearSystem, int, int, androidx.constraintlayout.core.widgets.ChainHead):void");
    }
}
