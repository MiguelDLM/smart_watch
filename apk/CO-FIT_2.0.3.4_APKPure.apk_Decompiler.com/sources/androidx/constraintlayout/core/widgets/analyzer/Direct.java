package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.Iterator;

public class Direct {
    private static final boolean APPLY_MATCH_PARENT = false;
    private static final boolean DEBUG = false;
    private static final boolean EARLY_TERMINATION = true;
    private static int sHcount = 0;
    private static BasicMeasure.Measure sMeasure = new BasicMeasure.Measure();
    private static int sVcount = 0;

    private static boolean canMeasure(int i, ConstraintWidget constraintWidget) {
        ConstraintWidgetContainer constraintWidgetContainer;
        boolean z;
        boolean z2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidget.getVerticalDimensionBehaviour();
        if (constraintWidget.getParent() != null) {
            constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.getParent();
        } else {
            constraintWidgetContainer = null;
        }
        if (constraintWidgetContainer != null) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidgetContainer.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (constraintWidgetContainer != null) {
            ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour2 = constraintWidgetContainer.getVerticalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (horizontalDimensionBehaviour == dimensionBehaviour5 || constraintWidget.isResolvedHorizontally() || horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || ((horizontalDimensionBehaviour == (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.mMatchConstraintDefaultWidth == 0 && constraintWidget.mDimensionRatio == 0.0f && constraintWidget.hasDanglingDimension(0)) || (horizontalDimensionBehaviour == dimensionBehaviour2 && constraintWidget.mMatchConstraintDefaultWidth == 1 && constraintWidget.hasResolvedTargets(0, constraintWidget.getWidth())))) {
            z = true;
        } else {
            z = false;
        }
        if (verticalDimensionBehaviour == dimensionBehaviour5 || constraintWidget.isResolvedVertically() || verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || ((verticalDimensionBehaviour == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.mMatchConstraintDefaultHeight == 0 && constraintWidget.mDimensionRatio == 0.0f && constraintWidget.hasDanglingDimension(1)) || (verticalDimensionBehaviour == dimensionBehaviour && constraintWidget.mMatchConstraintDefaultHeight == 1 && constraintWidget.hasResolvedTargets(1, constraintWidget.getHeight())))) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (constraintWidget.mDimensionRatio > 0.0f && (z || z2)) {
            return true;
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    private static void horizontalSolvingPass(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, boolean z) {
        boolean z2;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        boolean z3;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        ConstraintWidget constraintWidget2 = constraintWidget;
        BasicMeasure.Measurer measurer2 = measurer;
        boolean z4 = z;
        if (!constraintWidget.isHorizontalSolvingPassDone()) {
            sHcount++;
            if (!(constraintWidget2 instanceof ConstraintWidgetContainer) && constraintWidget.isMeasureRequested()) {
                int i2 = i + 1;
                if (canMeasure(i2, constraintWidget2)) {
                    ConstraintWidgetContainer.measure(i2, constraintWidget2, measurer2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
            }
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT);
            int finalValue = anchor.getFinalValue();
            int finalValue2 = anchor2.getFinalValue();
            if (anchor.getDependents() != null && anchor.hasFinalValue()) {
                Iterator<ConstraintAnchor> it = anchor.getDependents().iterator();
                while (it.hasNext()) {
                    ConstraintAnchor next = it.next();
                    ConstraintWidget constraintWidget3 = next.mOwner;
                    int i3 = i + 1;
                    boolean canMeasure = canMeasure(i3, constraintWidget3);
                    if (constraintWidget3.isMeasureRequested() && canMeasure) {
                        ConstraintWidgetContainer.measure(i3, constraintWidget3, measurer2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                    }
                    if ((next != constraintWidget3.mLeft || (constraintAnchor4 = constraintWidget3.mRight.mTarget) == null || !constraintAnchor4.hasFinalValue()) && (next != constraintWidget3.mRight || (constraintAnchor3 = constraintWidget3.mLeft.mTarget) == null || !constraintAnchor3.hasFinalValue())) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget3.getHorizontalDimensionBehaviour();
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (horizontalDimensionBehaviour != dimensionBehaviour || canMeasure) {
                        if (!constraintWidget3.isMeasureRequested()) {
                            ConstraintAnchor constraintAnchor5 = constraintWidget3.mLeft;
                            if (next == constraintAnchor5 && constraintWidget3.mRight.mTarget == null) {
                                int margin = constraintAnchor5.getMargin() + finalValue;
                                constraintWidget3.setFinalHorizontal(margin, constraintWidget3.getWidth() + margin);
                                horizontalSolvingPass(i3, constraintWidget3, measurer2, z4);
                            } else {
                                ConstraintAnchor constraintAnchor6 = constraintWidget3.mRight;
                                if (next == constraintAnchor6 && constraintAnchor5.mTarget == null) {
                                    int margin2 = finalValue - constraintAnchor6.getMargin();
                                    constraintWidget3.setFinalHorizontal(margin2 - constraintWidget3.getWidth(), margin2);
                                    horizontalSolvingPass(i3, constraintWidget3, measurer2, z4);
                                } else if (z3 && !constraintWidget3.isInHorizontalChain()) {
                                    solveHorizontalCenterConstraints(i3, measurer2, constraintWidget3, z4);
                                }
                            }
                        }
                    } else if (constraintWidget3.getHorizontalDimensionBehaviour() == dimensionBehaviour && constraintWidget3.mMatchConstraintMaxWidth >= 0 && constraintWidget3.mMatchConstraintMinWidth >= 0 && ((constraintWidget3.getVisibility() == 8 || (constraintWidget3.mMatchConstraintDefaultWidth == 0 && constraintWidget3.getDimensionRatio() == 0.0f)) && !constraintWidget3.isInHorizontalChain() && !constraintWidget3.isInVirtualLayout() && z3 && !constraintWidget3.isInHorizontalChain())) {
                        solveHorizontalMatchConstraint(i3, constraintWidget2, measurer2, constraintWidget3, z4);
                    }
                }
            }
            if (!(constraintWidget2 instanceof Guideline)) {
                if (anchor2.getDependents() != null && anchor2.hasFinalValue()) {
                    Iterator<ConstraintAnchor> it2 = anchor2.getDependents().iterator();
                    while (it2.hasNext()) {
                        ConstraintAnchor next2 = it2.next();
                        ConstraintWidget constraintWidget4 = next2.mOwner;
                        int i4 = i + 1;
                        boolean canMeasure2 = canMeasure(i4, constraintWidget4);
                        if (constraintWidget4.isMeasureRequested() && canMeasure2) {
                            ConstraintWidgetContainer.measure(i4, constraintWidget4, measurer2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                        }
                        if ((next2 != constraintWidget4.mLeft || (constraintAnchor2 = constraintWidget4.mRight.mTarget) == null || !constraintAnchor2.hasFinalValue()) && (next2 != constraintWidget4.mRight || (constraintAnchor = constraintWidget4.mLeft.mTarget) == null || !constraintAnchor.hasFinalValue())) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidget4.getHorizontalDimensionBehaviour();
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (horizontalDimensionBehaviour2 != dimensionBehaviour2 || canMeasure2) {
                            if (!constraintWidget4.isMeasureRequested()) {
                                ConstraintAnchor constraintAnchor7 = constraintWidget4.mLeft;
                                if (next2 == constraintAnchor7 && constraintWidget4.mRight.mTarget == null) {
                                    int margin3 = constraintAnchor7.getMargin() + finalValue2;
                                    constraintWidget4.setFinalHorizontal(margin3, constraintWidget4.getWidth() + margin3);
                                    horizontalSolvingPass(i4, constraintWidget4, measurer2, z4);
                                } else {
                                    ConstraintAnchor constraintAnchor8 = constraintWidget4.mRight;
                                    if (next2 == constraintAnchor8 && constraintAnchor7.mTarget == null) {
                                        int margin4 = finalValue2 - constraintAnchor8.getMargin();
                                        constraintWidget4.setFinalHorizontal(margin4 - constraintWidget4.getWidth(), margin4);
                                        horizontalSolvingPass(i4, constraintWidget4, measurer2, z4);
                                    } else if (z2 && !constraintWidget4.isInHorizontalChain()) {
                                        solveHorizontalCenterConstraints(i4, measurer2, constraintWidget4, z4);
                                    }
                                }
                            }
                        } else if (constraintWidget4.getHorizontalDimensionBehaviour() == dimensionBehaviour2 && constraintWidget4.mMatchConstraintMaxWidth >= 0 && constraintWidget4.mMatchConstraintMinWidth >= 0) {
                            if ((constraintWidget4.getVisibility() == 8 || (constraintWidget4.mMatchConstraintDefaultWidth == 0 && constraintWidget4.getDimensionRatio() == 0.0f)) && !constraintWidget4.isInHorizontalChain() && !constraintWidget4.isInVirtualLayout() && z2 && !constraintWidget4.isInHorizontalChain()) {
                                solveHorizontalMatchConstraint(i4, constraintWidget2, measurer2, constraintWidget4, z4);
                            }
                        }
                    }
                }
                constraintWidget.markHorizontalSolvingPassDone();
            }
        }
    }

    public static String ls(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
        sb.append("+-(" + i + ") ");
        return sb.toString();
    }

    private static void solveBarrier(int i, Barrier barrier, BasicMeasure.Measurer measurer, int i2, boolean z) {
        if (!barrier.allSolved()) {
            return;
        }
        if (i2 == 0) {
            horizontalSolvingPass(i + 1, barrier, measurer, z);
        } else {
            verticalSolvingPass(i + 1, barrier, measurer);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01d4, code lost:
        if (r6.mOwner == r0) goto L_0x01d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
        r7 = r7.mTarget.getFinalValue() + r4.mListAnchors[r23].getMargin();
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean solveChain(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r20, androidx.constraintlayout.core.LinearSystem r21, int r22, int r23, androidx.constraintlayout.core.widgets.ChainHead r24, boolean r25, boolean r26, boolean r27) {
        /*
            r0 = 0
            if (r27 == 0) goto L_0x0004
            return r0
        L_0x0004:
            if (r22 != 0) goto L_0x000d
            boolean r1 = r20.isResolvedHorizontally()
            if (r1 != 0) goto L_0x0014
            return r0
        L_0x000d:
            boolean r1 = r20.isResolvedVertically()
            if (r1 != 0) goto L_0x0014
            return r0
        L_0x0014:
            boolean r1 = r20.isRtl()
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r24.getFirst()
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r24.getLast()
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r24.getFirstVisibleWidget()
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r24.getLastVisibleWidget()
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r24.getHead()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r2.mListAnchors
            r7 = r7[r23]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r3.mListAnchors
            int r8 = r23 + 1
            r3 = r3[r8]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r7.mTarget
            if (r9 == 0) goto L_0x022c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.mTarget
            if (r10 != 0) goto L_0x0040
            goto L_0x022c
        L_0x0040:
            boolean r9 = r9.hasFinalValue()
            if (r9 == 0) goto L_0x022c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r3.mTarget
            boolean r9 = r9.hasFinalValue()
            if (r9 != 0) goto L_0x0050
            goto L_0x022c
        L_0x0050:
            if (r4 == 0) goto L_0x022c
            if (r5 != 0) goto L_0x0056
            goto L_0x022c
        L_0x0056:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.mTarget
            int r7 = r7.getFinalValue()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r9 = r4.mListAnchors
            r9 = r9[r23]
            int r9 = r9.getMargin()
            int r7 = r7 + r9
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            int r3 = r3.getFinalValue()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r9 = r5.mListAnchors
            r9 = r9[r8]
            int r9 = r9.getMargin()
            int r3 = r3 - r9
            int r9 = r3 - r7
            if (r9 > 0) goto L_0x0079
            return r0
        L_0x0079:
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r10 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r10.<init>()
            r13 = r2
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
        L_0x0083:
            r17 = 0
            r0 = 1
            if (r11 != 0) goto L_0x0102
            boolean r18 = canMeasure(r0, r13)
            if (r18 != 0) goto L_0x0091
            r16 = 0
            return r16
        L_0x0091:
            r16 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r13.mListDimensionBehaviors
            r0 = r0[r22]
            r18 = r2
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r2) goto L_0x009e
            return r16
        L_0x009e:
            boolean r0 = r13.isMeasureRequested()
            if (r0 == 0) goto L_0x00b1
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.getMeasurer()
            int r2 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS
            r19 = r11
            r11 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.measure(r11, r13, r0, r10, r2)
            goto L_0x00b3
        L_0x00b1:
            r19 = r11
        L_0x00b3:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r23]
            int r0 = r0.getMargin()
            int r15 = r15 + r0
            if (r22 != 0) goto L_0x00c4
            int r0 = r13.getWidth()
        L_0x00c2:
            int r15 = r15 + r0
            goto L_0x00c9
        L_0x00c4:
            int r0 = r13.getHeight()
            goto L_0x00c2
        L_0x00c9:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r8]
            int r0 = r0.getMargin()
            int r15 = r15 + r0
            int r14 = r14 + 1
            int r0 = r13.getVisibility()
            r2 = 8
            if (r0 == r2) goto L_0x00de
            int r12 = r12 + 1
        L_0x00de:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r8]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 == 0) goto L_0x00f7
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.mOwner
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r0.mListAnchors
            r2 = r2[r23]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x00f7
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r2.mOwner
            if (r2 == r13) goto L_0x00f5
            goto L_0x00f7
        L_0x00f5:
            r17 = r0
        L_0x00f7:
            if (r17 == 0) goto L_0x00fe
            r13 = r17
            r11 = r19
            goto L_0x00ff
        L_0x00fe:
            r11 = 1
        L_0x00ff:
            r2 = r18
            goto L_0x0083
        L_0x0102:
            r18 = r2
            if (r12 != 0) goto L_0x0108
            r0 = 0
            return r0
        L_0x0108:
            r0 = 0
            if (r12 == r14) goto L_0x010c
            return r0
        L_0x010c:
            if (r9 >= r15) goto L_0x010f
            return r0
        L_0x010f:
            int r9 = r9 - r15
            r0 = 2
            if (r25 == 0) goto L_0x0118
            int r2 = r12 + 1
            int r9 = r9 / r2
        L_0x0116:
            r2 = 1
            goto L_0x011f
        L_0x0118:
            if (r26 == 0) goto L_0x0116
            if (r12 <= r0) goto L_0x0116
            int r9 = r9 / r12
            r2 = 1
            int r9 = r9 - r2
        L_0x011f:
            if (r12 != r2) goto L_0x0151
            if (r22 != 0) goto L_0x0128
            float r0 = r6.getHorizontalBiasPercent()
            goto L_0x012c
        L_0x0128:
            float r0 = r6.getVerticalBiasPercent()
        L_0x012c:
            r2 = 1056964608(0x3f000000, float:0.5)
            float r3 = (float) r7
            float r3 = r3 + r2
            float r2 = (float) r9
            float r2 = r2 * r0
            float r3 = r3 + r2
            int r0 = (int) r3
            if (r22 != 0) goto L_0x0140
            int r2 = r4.getWidth()
            int r2 = r2 + r0
            r4.setFinalHorizontal(r0, r2)
            goto L_0x0148
        L_0x0140:
            int r2 = r4.getHeight()
            int r2 = r2 + r0
            r4.setFinalVertical(r0, r2)
        L_0x0148:
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.getMeasurer()
            r2 = 1
            horizontalSolvingPass(r2, r4, r0, r1)
            return r2
        L_0x0151:
            if (r25 == 0) goto L_0x01e0
            int r7 = r7 + r9
            r0 = r18
            r3 = 0
        L_0x0157:
            if (r3 != 0) goto L_0x022b
            int r4 = r0.getVisibility()
            r5 = 8
            if (r4 != r5) goto L_0x017c
            if (r22 != 0) goto L_0x016e
            r0.setFinalHorizontal(r7, r7)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r4 = r20.getMeasurer()
            horizontalSolvingPass(r2, r0, r4, r1)
            goto L_0x0178
        L_0x016e:
            r0.setFinalVertical(r7, r7)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r4 = r20.getMeasurer()
            verticalSolvingPass(r2, r0, r4)
        L_0x0178:
            r2 = r21
            r4 = 0
            goto L_0x01bd
        L_0x017c:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r0.mListAnchors
            r2 = r2[r23]
            int r2 = r2.getMargin()
            int r7 = r7 + r2
            if (r22 != 0) goto L_0x019d
            int r2 = r0.getWidth()
            int r2 = r2 + r7
            r0.setFinalHorizontal(r7, r2)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r2 = r20.getMeasurer()
            r4 = 1
            horizontalSolvingPass(r4, r0, r2, r1)
            int r2 = r0.getWidth()
        L_0x019b:
            int r7 = r7 + r2
            goto L_0x01b2
        L_0x019d:
            r4 = 1
            int r2 = r0.getHeight()
            int r2 = r2 + r7
            r0.setFinalVertical(r7, r2)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r2 = r20.getMeasurer()
            verticalSolvingPass(r4, r0, r2)
            int r2 = r0.getHeight()
            goto L_0x019b
        L_0x01b2:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r0.mListAnchors
            r2 = r2[r8]
            int r2 = r2.getMargin()
            int r7 = r7 + r2
            int r7 = r7 + r9
            goto L_0x0178
        L_0x01bd:
            r0.addToSolver(r2, r4)
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r0.mListAnchors
            r4 = r4[r8]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x01d6
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r4.mOwner
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r4.mListAnchors
            r6 = r6[r23]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x01d6
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r6.mOwner
            if (r6 == r0) goto L_0x01d8
        L_0x01d6:
            r4 = r17
        L_0x01d8:
            if (r4 == 0) goto L_0x01dc
            r0 = r4
            goto L_0x01dd
        L_0x01dc:
            r3 = 1
        L_0x01dd:
            r2 = 1
            goto L_0x0157
        L_0x01e0:
            if (r26 == 0) goto L_0x022a
            if (r12 != r0) goto L_0x0228
            if (r22 != 0) goto L_0x0207
            int r0 = r4.getWidth()
            int r0 = r0 + r7
            r4.setFinalHorizontal(r7, r0)
            int r0 = r5.getWidth()
            int r0 = r3 - r0
            r5.setFinalHorizontal(r0, r3)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.getMeasurer()
            r2 = 1
            horizontalSolvingPass(r2, r4, r0, r1)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.getMeasurer()
            horizontalSolvingPass(r2, r5, r0, r1)
            goto L_0x0227
        L_0x0207:
            r2 = 1
            int r0 = r4.getHeight()
            int r0 = r0 + r7
            r4.setFinalVertical(r7, r0)
            int r0 = r5.getHeight()
            int r0 = r3 - r0
            r5.setFinalVertical(r0, r3)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.getMeasurer()
            verticalSolvingPass(r2, r4, r0)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.getMeasurer()
            verticalSolvingPass(r2, r5, r0)
        L_0x0227:
            return r2
        L_0x0228:
            r0 = 0
            return r0
        L_0x022a:
            r2 = 1
        L_0x022b:
            return r2
        L_0x022c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Direct.solveChain(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.LinearSystem, int, int, androidx.constraintlayout.core.widgets.ChainHead, boolean, boolean, boolean):boolean");
    }

    private static void solveHorizontalCenterConstraints(int i, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget, boolean z) {
        float f;
        float horizontalBiasPercent = constraintWidget.getHorizontalBiasPercent();
        int finalValue = constraintWidget.mLeft.mTarget.getFinalValue();
        int finalValue2 = constraintWidget.mRight.mTarget.getFinalValue();
        int margin = constraintWidget.mLeft.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintWidget.mRight.getMargin();
        if (finalValue == finalValue2) {
            horizontalBiasPercent = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int width = constraintWidget.getWidth();
        int i2 = (finalValue2 - finalValue) - width;
        if (finalValue > finalValue2) {
            i2 = (finalValue - finalValue2) - width;
        }
        if (i2 > 0) {
            f = (horizontalBiasPercent * ((float) i2)) + 0.5f;
        } else {
            f = horizontalBiasPercent * ((float) i2);
        }
        int i3 = ((int) f) + finalValue;
        int i4 = i3 + width;
        if (finalValue > finalValue2) {
            i4 = i3 - width;
        }
        constraintWidget.setFinalHorizontal(i3, i4);
        horizontalSolvingPass(i + 1, constraintWidget, measurer, z);
    }

    private static void solveHorizontalMatchConstraint(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2, boolean z) {
        int i2;
        float horizontalBiasPercent = constraintWidget2.getHorizontalBiasPercent();
        int finalValue = constraintWidget2.mLeft.mTarget.getFinalValue() + constraintWidget2.mLeft.getMargin();
        int finalValue2 = constraintWidget2.mRight.mTarget.getFinalValue() - constraintWidget2.mRight.getMargin();
        if (finalValue2 >= finalValue) {
            int width = constraintWidget2.getWidth();
            if (constraintWidget2.getVisibility() != 8) {
                int i3 = constraintWidget2.mMatchConstraintDefaultWidth;
                if (i3 == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        i2 = constraintWidget.getWidth();
                    } else {
                        i2 = constraintWidget.getParent().getWidth();
                    }
                    width = (int) (constraintWidget2.getHorizontalBiasPercent() * 0.5f * ((float) i2));
                } else if (i3 == 0) {
                    width = finalValue2 - finalValue;
                }
                width = Math.max(constraintWidget2.mMatchConstraintMinWidth, width);
                int i4 = constraintWidget2.mMatchConstraintMaxWidth;
                if (i4 > 0) {
                    width = Math.min(i4, width);
                }
            }
            int i5 = finalValue + ((int) ((horizontalBiasPercent * ((float) ((finalValue2 - finalValue) - width))) + 0.5f));
            constraintWidget2.setFinalHorizontal(i5, width + i5);
            horizontalSolvingPass(i + 1, constraintWidget2, measurer, z);
        }
    }

    private static void solveVerticalCenterConstraints(int i, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget) {
        float f;
        float verticalBiasPercent = constraintWidget.getVerticalBiasPercent();
        int finalValue = constraintWidget.mTop.mTarget.getFinalValue();
        int finalValue2 = constraintWidget.mBottom.mTarget.getFinalValue();
        int margin = constraintWidget.mTop.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintWidget.mBottom.getMargin();
        if (finalValue == finalValue2) {
            verticalBiasPercent = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int height = constraintWidget.getHeight();
        int i2 = (finalValue2 - finalValue) - height;
        if (finalValue > finalValue2) {
            i2 = (finalValue - finalValue2) - height;
        }
        if (i2 > 0) {
            f = (verticalBiasPercent * ((float) i2)) + 0.5f;
        } else {
            f = verticalBiasPercent * ((float) i2);
        }
        int i3 = (int) f;
        int i4 = finalValue + i3;
        int i5 = i4 + height;
        if (finalValue > finalValue2) {
            i4 = finalValue - i3;
            i5 = i4 - height;
        }
        constraintWidget.setFinalVertical(i4, i5);
        verticalSolvingPass(i + 1, constraintWidget, measurer);
    }

    private static void solveVerticalMatchConstraint(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2) {
        int i2;
        float verticalBiasPercent = constraintWidget2.getVerticalBiasPercent();
        int finalValue = constraintWidget2.mTop.mTarget.getFinalValue() + constraintWidget2.mTop.getMargin();
        int finalValue2 = constraintWidget2.mBottom.mTarget.getFinalValue() - constraintWidget2.mBottom.getMargin();
        if (finalValue2 >= finalValue) {
            int height = constraintWidget2.getHeight();
            if (constraintWidget2.getVisibility() != 8) {
                int i3 = constraintWidget2.mMatchConstraintDefaultHeight;
                if (i3 == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        i2 = constraintWidget.getHeight();
                    } else {
                        i2 = constraintWidget.getParent().getHeight();
                    }
                    height = (int) (verticalBiasPercent * 0.5f * ((float) i2));
                } else if (i3 == 0) {
                    height = finalValue2 - finalValue;
                }
                height = Math.max(constraintWidget2.mMatchConstraintMinHeight, height);
                int i4 = constraintWidget2.mMatchConstraintMaxHeight;
                if (i4 > 0) {
                    height = Math.min(i4, height);
                }
            }
            int i5 = finalValue + ((int) ((verticalBiasPercent * ((float) ((finalValue2 - finalValue) - height))) + 0.5f));
            constraintWidget2.setFinalVertical(i5, height + i5);
            verticalSolvingPass(i + 1, constraintWidget2, measurer);
        }
    }

    public static void solvingPass(ConstraintWidgetContainer constraintWidgetContainer, BasicMeasure.Measurer measurer) {
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidgetContainer.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidgetContainer.getVerticalDimensionBehaviour();
        sHcount = 0;
        sVcount = 0;
        constraintWidgetContainer.resetFinalResolution();
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        for (int i = 0; i < size; i++) {
            children.get(i).resetFinalResolution();
        }
        boolean isRtl = constraintWidgetContainer.isRtl();
        if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.setFinalHorizontal(0, constraintWidgetContainer.getWidth());
        } else {
            constraintWidgetContainer.setFinalLeft(0);
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = children.get(i2);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    if (guideline.getRelativeBegin() != -1) {
                        guideline.setFinalValue(guideline.getRelativeBegin());
                    } else if (guideline.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedHorizontally()) {
                        guideline.setFinalValue(constraintWidgetContainer.getWidth() - guideline.getRelativeEnd());
                    } else if (constraintWidgetContainer.isResolvedHorizontally()) {
                        guideline.setFinalValue((int) ((guideline.getRelativePercent() * ((float) constraintWidgetContainer.getWidth())) + 0.5f));
                    }
                    z = true;
                }
            } else if ((constraintWidget instanceof Barrier) && ((Barrier) constraintWidget).getOrientation() == 0) {
                z2 = true;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                ConstraintWidget constraintWidget2 = children.get(i3);
                if (constraintWidget2 instanceof Guideline) {
                    Guideline guideline2 = (Guideline) constraintWidget2;
                    if (guideline2.getOrientation() == 1) {
                        horizontalSolvingPass(0, guideline2, measurer, isRtl);
                    }
                }
            }
        }
        horizontalSolvingPass(0, constraintWidgetContainer, measurer, isRtl);
        if (z2) {
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget3 = children.get(i4);
                if (constraintWidget3 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget3;
                    if (barrier.getOrientation() == 0) {
                        solveBarrier(0, barrier, measurer, 0, isRtl);
                    }
                }
            }
        }
        if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.setFinalVertical(0, constraintWidgetContainer.getHeight());
        } else {
            constraintWidgetContainer.setFinalTop(0);
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget4 = children.get(i5);
            if (constraintWidget4 instanceof Guideline) {
                Guideline guideline3 = (Guideline) constraintWidget4;
                if (guideline3.getOrientation() == 0) {
                    if (guideline3.getRelativeBegin() != -1) {
                        guideline3.setFinalValue(guideline3.getRelativeBegin());
                    } else if (guideline3.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedVertically()) {
                        guideline3.setFinalValue(constraintWidgetContainer.getHeight() - guideline3.getRelativeEnd());
                    } else if (constraintWidgetContainer.isResolvedVertically()) {
                        guideline3.setFinalValue((int) ((guideline3.getRelativePercent() * ((float) constraintWidgetContainer.getHeight())) + 0.5f));
                    }
                    z3 = true;
                }
            } else if ((constraintWidget4 instanceof Barrier) && ((Barrier) constraintWidget4).getOrientation() == 1) {
                z4 = true;
            }
        }
        if (z3) {
            for (int i6 = 0; i6 < size; i6++) {
                ConstraintWidget constraintWidget5 = children.get(i6);
                if (constraintWidget5 instanceof Guideline) {
                    Guideline guideline4 = (Guideline) constraintWidget5;
                    if (guideline4.getOrientation() == 0) {
                        verticalSolvingPass(1, guideline4, measurer);
                    }
                }
            }
        }
        verticalSolvingPass(0, constraintWidgetContainer, measurer);
        if (z4) {
            for (int i7 = 0; i7 < size; i7++) {
                ConstraintWidget constraintWidget6 = children.get(i7);
                if (constraintWidget6 instanceof Barrier) {
                    Barrier barrier2 = (Barrier) constraintWidget6;
                    if (barrier2.getOrientation() == 1) {
                        solveBarrier(0, barrier2, measurer, 1, isRtl);
                    }
                }
            }
        }
        for (int i8 = 0; i8 < size; i8++) {
            ConstraintWidget constraintWidget7 = children.get(i8);
            if (constraintWidget7.isMeasureRequested() && canMeasure(0, constraintWidget7)) {
                ConstraintWidgetContainer.measure(0, constraintWidget7, measurer, sMeasure, BasicMeasure.Measure.SELF_DIMENSIONS);
                if (!(constraintWidget7 instanceof Guideline)) {
                    horizontalSolvingPass(0, constraintWidget7, measurer, isRtl);
                    verticalSolvingPass(0, constraintWidget7, measurer);
                } else if (((Guideline) constraintWidget7).getOrientation() == 0) {
                    verticalSolvingPass(0, constraintWidget7, measurer);
                } else {
                    horizontalSolvingPass(0, constraintWidget7, measurer, isRtl);
                }
            }
        }
    }

    private static void verticalSolvingPass(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer) {
        boolean z;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        boolean z2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        ConstraintWidget constraintWidget2 = constraintWidget;
        BasicMeasure.Measurer measurer2 = measurer;
        if (!constraintWidget.isVerticalSolvingPassDone()) {
            sVcount++;
            if (!(constraintWidget2 instanceof ConstraintWidgetContainer) && constraintWidget.isMeasureRequested()) {
                int i2 = i + 1;
                if (canMeasure(i2, constraintWidget2)) {
                    ConstraintWidgetContainer.measure(i2, constraintWidget2, measurer2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
            }
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor2 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM);
            int finalValue = anchor.getFinalValue();
            int finalValue2 = anchor2.getFinalValue();
            if (anchor.getDependents() != null && anchor.hasFinalValue()) {
                Iterator<ConstraintAnchor> it = anchor.getDependents().iterator();
                while (it.hasNext()) {
                    ConstraintAnchor next = it.next();
                    ConstraintWidget constraintWidget3 = next.mOwner;
                    int i3 = i + 1;
                    boolean canMeasure = canMeasure(i3, constraintWidget3);
                    if (constraintWidget3.isMeasureRequested() && canMeasure) {
                        ConstraintWidgetContainer.measure(i3, constraintWidget3, measurer2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                    }
                    if ((next != constraintWidget3.mTop || (constraintAnchor4 = constraintWidget3.mBottom.mTarget) == null || !constraintAnchor4.hasFinalValue()) && (next != constraintWidget3.mBottom || (constraintAnchor3 = constraintWidget3.mTop.mTarget) == null || !constraintAnchor3.hasFinalValue())) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidget3.getVerticalDimensionBehaviour();
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (verticalDimensionBehaviour != dimensionBehaviour || canMeasure) {
                        if (!constraintWidget3.isMeasureRequested()) {
                            ConstraintAnchor constraintAnchor5 = constraintWidget3.mTop;
                            if (next == constraintAnchor5 && constraintWidget3.mBottom.mTarget == null) {
                                int margin = constraintAnchor5.getMargin() + finalValue;
                                constraintWidget3.setFinalVertical(margin, constraintWidget3.getHeight() + margin);
                                verticalSolvingPass(i3, constraintWidget3, measurer2);
                            } else {
                                ConstraintAnchor constraintAnchor6 = constraintWidget3.mBottom;
                                if (next == constraintAnchor6 && constraintAnchor5.mTarget == null) {
                                    int margin2 = finalValue - constraintAnchor6.getMargin();
                                    constraintWidget3.setFinalVertical(margin2 - constraintWidget3.getHeight(), margin2);
                                    verticalSolvingPass(i3, constraintWidget3, measurer2);
                                } else if (z2 && !constraintWidget3.isInVerticalChain()) {
                                    solveVerticalCenterConstraints(i3, measurer2, constraintWidget3);
                                }
                            }
                        }
                    } else if (constraintWidget3.getVerticalDimensionBehaviour() == dimensionBehaviour && constraintWidget3.mMatchConstraintMaxHeight >= 0 && constraintWidget3.mMatchConstraintMinHeight >= 0) {
                        if ((constraintWidget3.getVisibility() == 8 || (constraintWidget3.mMatchConstraintDefaultHeight == 0 && constraintWidget3.getDimensionRatio() == 0.0f)) && !constraintWidget3.isInVerticalChain() && !constraintWidget3.isInVirtualLayout() && z2 && !constraintWidget3.isInVerticalChain()) {
                            solveVerticalMatchConstraint(i3, constraintWidget2, measurer2, constraintWidget3);
                        }
                    }
                }
            }
            if (!(constraintWidget2 instanceof Guideline)) {
                if (anchor2.getDependents() != null && anchor2.hasFinalValue()) {
                    Iterator<ConstraintAnchor> it2 = anchor2.getDependents().iterator();
                    while (it2.hasNext()) {
                        ConstraintAnchor next2 = it2.next();
                        ConstraintWidget constraintWidget4 = next2.mOwner;
                        int i4 = i + 1;
                        boolean canMeasure2 = canMeasure(i4, constraintWidget4);
                        if (constraintWidget4.isMeasureRequested() && canMeasure2) {
                            ConstraintWidgetContainer.measure(i4, constraintWidget4, measurer2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                        }
                        if ((next2 != constraintWidget4.mTop || (constraintAnchor2 = constraintWidget4.mBottom.mTarget) == null || !constraintAnchor2.hasFinalValue()) && (next2 != constraintWidget4.mBottom || (constraintAnchor = constraintWidget4.mTop.mTarget) == null || !constraintAnchor.hasFinalValue())) {
                            z = false;
                        } else {
                            z = true;
                        }
                        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour2 = constraintWidget4.getVerticalDimensionBehaviour();
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (verticalDimensionBehaviour2 != dimensionBehaviour2 || canMeasure2) {
                            if (!constraintWidget4.isMeasureRequested()) {
                                ConstraintAnchor constraintAnchor7 = constraintWidget4.mTop;
                                if (next2 == constraintAnchor7 && constraintWidget4.mBottom.mTarget == null) {
                                    int margin3 = constraintAnchor7.getMargin() + finalValue2;
                                    constraintWidget4.setFinalVertical(margin3, constraintWidget4.getHeight() + margin3);
                                    verticalSolvingPass(i4, constraintWidget4, measurer2);
                                } else {
                                    ConstraintAnchor constraintAnchor8 = constraintWidget4.mBottom;
                                    if (next2 == constraintAnchor8 && constraintAnchor7.mTarget == null) {
                                        int margin4 = finalValue2 - constraintAnchor8.getMargin();
                                        constraintWidget4.setFinalVertical(margin4 - constraintWidget4.getHeight(), margin4);
                                        verticalSolvingPass(i4, constraintWidget4, measurer2);
                                    } else if (z && !constraintWidget4.isInVerticalChain()) {
                                        solveVerticalCenterConstraints(i4, measurer2, constraintWidget4);
                                    }
                                }
                            }
                        } else if (constraintWidget4.getVerticalDimensionBehaviour() == dimensionBehaviour2 && constraintWidget4.mMatchConstraintMaxHeight >= 0 && constraintWidget4.mMatchConstraintMinHeight >= 0) {
                            if ((constraintWidget4.getVisibility() == 8 || (constraintWidget4.mMatchConstraintDefaultHeight == 0 && constraintWidget4.getDimensionRatio() == 0.0f)) && !constraintWidget4.isInVerticalChain() && !constraintWidget4.isInVirtualLayout() && z && !constraintWidget4.isInVerticalChain()) {
                                solveVerticalMatchConstraint(i4, constraintWidget2, measurer2, constraintWidget4);
                            }
                        }
                    }
                }
                ConstraintAnchor anchor3 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BASELINE);
                if (anchor3.getDependents() != null && anchor3.hasFinalValue()) {
                    int finalValue3 = anchor3.getFinalValue();
                    Iterator<ConstraintAnchor> it3 = anchor3.getDependents().iterator();
                    while (it3.hasNext()) {
                        ConstraintAnchor next3 = it3.next();
                        ConstraintWidget constraintWidget5 = next3.mOwner;
                        int i5 = i + 1;
                        boolean canMeasure3 = canMeasure(i5, constraintWidget5);
                        if (constraintWidget5.isMeasureRequested() && canMeasure3) {
                            ConstraintWidgetContainer.measure(i5, constraintWidget5, measurer2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                        }
                        if ((constraintWidget5.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || canMeasure3) && !constraintWidget5.isMeasureRequested() && next3 == constraintWidget5.mBaseline) {
                            constraintWidget5.setFinalBaseline(next3.getMargin() + finalValue3);
                            try {
                                verticalSolvingPass(i5, constraintWidget5, measurer2);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }
                constraintWidget.markVerticalSolvingPassDone();
            }
        }
    }
}
