package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

public class HorizontalWidgetRun extends WidgetRun {
    private static int[] sTempDimensions = new int[2];

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType[] r0 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType = r0
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.AnonymousClass1.<clinit>():void");
        }
    }

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.mType = DependencyNode.Type.LEFT;
        this.end.mType = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    private void computeInsetRatio(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 == -1) {
            int i8 = (int) ((((float) i7) * f) + 0.5f);
            int i9 = (int) ((((float) i6) / f) + 0.5f);
            if (i8 <= i6) {
                iArr[0] = i8;
                iArr[1] = i7;
            } else if (i9 <= i7) {
                iArr[0] = i6;
                iArr[1] = i9;
            }
        } else if (i5 == 0) {
            iArr[0] = (int) ((((float) i7) * f) + 0.5f);
            iArr[1] = i7;
        } else if (i5 == 1) {
            iArr[0] = i6;
            iArr[1] = (int) ((((float) i6) * f) + 0.5f);
        }
    }

    public void apply() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = this.mWidget;
        if (constraintWidget.measured) {
            this.mDimension.resolve(constraintWidget.getWidth());
        }
        if (!this.mDimension.resolved) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = this.mWidget.getHorizontalDimensionBehaviour();
            this.mDimensionBehavior = horizontalDimensionBehaviour;
            if (horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (horizontalDimensionBehaviour == dimensionBehaviour && (parent2 = this.mWidget.getParent()) != null && (parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED || parent2.getHorizontalDimensionBehaviour() == dimensionBehaviour)) {
                    int width = (parent2.getWidth() - this.mWidget.mLeft.getMargin()) - this.mWidget.mRight.getMargin();
                    addTarget(this.start, parent2.mHorizontalRun.start, this.mWidget.mLeft.getMargin());
                    addTarget(this.end, parent2.mHorizontalRun.end, -this.mWidget.mRight.getMargin());
                    this.mDimension.resolve(width);
                    return;
                } else if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.mDimension.resolve(this.mWidget.getWidth());
                }
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.mDimensionBehavior;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour2 == dimensionBehaviour3 && (parent = this.mWidget.getParent()) != null && (parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED || parent.getHorizontalDimensionBehaviour() == dimensionBehaviour3)) {
                addTarget(this.start, parent.mHorizontalRun.start, this.mWidget.mLeft.getMargin());
                addTarget(this.end, parent.mHorizontalRun.end, -this.mWidget.mRight.getMargin());
                return;
            }
        }
        DimensionDependency dimensionDependency = this.mDimension;
        if (dimensionDependency.resolved) {
            ConstraintWidget constraintWidget2 = this.mWidget;
            if (constraintWidget2.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 == null || constraintAnchorArr[1].mTarget == null) {
                    if (constraintAnchor2 != null) {
                        DependencyNode target = getTarget(constraintAnchor);
                        if (target != null) {
                            addTarget(this.start, target, this.mWidget.mListAnchors[0].getMargin());
                            addTarget(this.end, this.start, this.mDimension.value);
                            return;
                        }
                        return;
                    }
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                    if (constraintAnchor3.mTarget != null) {
                        DependencyNode target2 = getTarget(constraintAnchor3);
                        if (target2 != null) {
                            addTarget(this.end, target2, -this.mWidget.mListAnchors[1].getMargin());
                            addTarget(this.start, this.end, -this.mDimension.value);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget2 instanceof Helper) && constraintWidget2.getParent() != null && this.mWidget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                        addTarget(this.start, this.mWidget.getParent().mHorizontalRun.start, this.mWidget.getX());
                        addTarget(this.end, this.start, this.mDimension.value);
                        return;
                    } else {
                        return;
                    }
                } else if (constraintWidget2.isInHorizontalChain()) {
                    this.start.mMargin = this.mWidget.mListAnchors[0].getMargin();
                    this.end.mMargin = -this.mWidget.mListAnchors[1].getMargin();
                    return;
                } else {
                    DependencyNode target3 = getTarget(this.mWidget.mListAnchors[0]);
                    if (target3 != null) {
                        addTarget(this.start, target3, this.mWidget.mListAnchors[0].getMargin());
                    }
                    DependencyNode target4 = getTarget(this.mWidget.mListAnchors[1]);
                    if (target4 != null) {
                        addTarget(this.end, target4, -this.mWidget.mListAnchors[1].getMargin());
                    }
                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                    return;
                }
            }
        }
        if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.mWidget;
            int i = constraintWidget3.mMatchConstraintDefaultWidth;
            if (i == 2) {
                ConstraintWidget parent3 = constraintWidget3.getParent();
                if (parent3 != null) {
                    DimensionDependency dimensionDependency2 = parent3.mVerticalRun.mDimension;
                    this.mDimension.mTargets.add(dimensionDependency2);
                    dimensionDependency2.mDependencies.add(this.mDimension);
                    DimensionDependency dimensionDependency3 = this.mDimension;
                    dimensionDependency3.delegateToWidgetRun = true;
                    dimensionDependency3.mDependencies.add(this.start);
                    this.mDimension.mDependencies.add(this.end);
                }
            } else if (i == 3) {
                if (constraintWidget3.mMatchConstraintDefaultHeight == 3) {
                    this.start.updateDelegate = this;
                    this.end.updateDelegate = this;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget3.mVerticalRun;
                    verticalWidgetRun.start.updateDelegate = this;
                    verticalWidgetRun.end.updateDelegate = this;
                    dimensionDependency.updateDelegate = this;
                    if (constraintWidget3.isInVerticalChain()) {
                        this.mDimension.mTargets.add(this.mWidget.mVerticalRun.mDimension);
                        this.mWidget.mVerticalRun.mDimension.mDependencies.add(this.mDimension);
                        VerticalWidgetRun verticalWidgetRun2 = this.mWidget.mVerticalRun;
                        verticalWidgetRun2.mDimension.updateDelegate = this;
                        this.mDimension.mTargets.add(verticalWidgetRun2.start);
                        this.mDimension.mTargets.add(this.mWidget.mVerticalRun.end);
                        this.mWidget.mVerticalRun.start.mDependencies.add(this.mDimension);
                        this.mWidget.mVerticalRun.end.mDependencies.add(this.mDimension);
                    } else if (this.mWidget.isInHorizontalChain()) {
                        this.mWidget.mVerticalRun.mDimension.mTargets.add(this.mDimension);
                        this.mDimension.mDependencies.add(this.mWidget.mVerticalRun.mDimension);
                    } else {
                        this.mWidget.mVerticalRun.mDimension.mTargets.add(this.mDimension);
                    }
                } else {
                    DimensionDependency dimensionDependency4 = constraintWidget3.mVerticalRun.mDimension;
                    dimensionDependency.mTargets.add(dimensionDependency4);
                    dimensionDependency4.mDependencies.add(this.mDimension);
                    this.mWidget.mVerticalRun.start.mDependencies.add(this.mDimension);
                    this.mWidget.mVerticalRun.end.mDependencies.add(this.mDimension);
                    DimensionDependency dimensionDependency5 = this.mDimension;
                    dimensionDependency5.delegateToWidgetRun = true;
                    dimensionDependency5.mDependencies.add(this.start);
                    this.mDimension.mDependencies.add(this.end);
                    this.start.mTargets.add(this.mDimension);
                    this.end.mTargets.add(this.mDimension);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.mWidget;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.mListAnchors;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.mTarget;
        if (constraintAnchor5 == null || constraintAnchorArr2[1].mTarget == null) {
            if (constraintAnchor5 != null) {
                DependencyNode target5 = getTarget(constraintAnchor4);
                if (target5 != null) {
                    addTarget(this.start, target5, this.mWidget.mListAnchors[0].getMargin());
                    addTarget(this.end, this.start, 1, this.mDimension);
                    return;
                }
                return;
            }
            ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
            if (constraintAnchor6.mTarget != null) {
                DependencyNode target6 = getTarget(constraintAnchor6);
                if (target6 != null) {
                    addTarget(this.end, target6, -this.mWidget.mListAnchors[1].getMargin());
                    addTarget(this.start, this.end, -1, this.mDimension);
                }
            } else if (!(constraintWidget4 instanceof Helper) && constraintWidget4.getParent() != null) {
                addTarget(this.start, this.mWidget.getParent().mHorizontalRun.start, this.mWidget.getX());
                addTarget(this.end, this.start, 1, this.mDimension);
            }
        } else if (constraintWidget4.isInHorizontalChain()) {
            this.start.mMargin = this.mWidget.mListAnchors[0].getMargin();
            this.end.mMargin = -this.mWidget.mListAnchors[1].getMargin();
        } else {
            DependencyNode target7 = getTarget(this.mWidget.mListAnchors[0]);
            DependencyNode target8 = getTarget(this.mWidget.mListAnchors[1]);
            if (target7 != null) {
                target7.addDependency(this);
            }
            if (target8 != null) {
                target8.addDependency(this);
            }
            this.mRunType = WidgetRun.RunType.CENTER;
        }
    }

    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.mWidget.setX(dependencyNode.value);
        }
    }

    public void clear() {
        this.mRunGroup = null;
        this.start.clear();
        this.end.clear();
        this.mDimension.clear();
        this.mResolved = false;
    }

    public void reset() {
        this.mResolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.mDimension.resolved = false;
    }

    public boolean supportsWrapComputation() {
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.mWidget.mMatchConstraintDefaultWidth == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "HorizontalRun " + this.mWidget.getDebugName();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02bd, code lost:
        if (r14 != 1) goto L_0x0325;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(androidx.constraintlayout.core.widgets.analyzer.Dependency r17) {
        /*
            r16 = this;
            r8 = r16
            int[] r0 = androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = r8.mRunType
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 3
            r9 = 1
            r10 = 0
            if (r0 == r9) goto L_0x0029
            if (r0 == r1) goto L_0x0023
            if (r0 == r2) goto L_0x0017
            goto L_0x002e
        L_0x0017:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mRight
            r3 = r17
            r8.updateRunCenter(r3, r1, r0, r10)
            return
        L_0x0023:
            r3 = r17
            r16.updateRunEnd(r17)
            goto L_0x002e
        L_0x0029:
            r3 = r17
            r16.updateRunStart(r17)
        L_0x002e:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.mDimension
            boolean r0 = r0.resolved
            r11 = 1056964608(0x3f000000, float:0.5)
            if (r0 != 0) goto L_0x0325
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.mDimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r3) goto L_0x0325
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            int r3 = r0.mMatchConstraintDefaultWidth
            if (r3 == r1) goto L_0x0307
            if (r3 == r2) goto L_0x0046
            goto L_0x0325
        L_0x0046:
            int r1 = r0.mMatchConstraintDefaultHeight
            r3 = -1
            if (r1 == 0) goto L_0x0090
            if (r1 != r2) goto L_0x004e
            goto L_0x0090
        L_0x004e:
            int r0 = r0.getDimensionRatioSide()
            if (r0 == r3) goto L_0x007b
            if (r0 == 0) goto L_0x006c
            if (r0 == r9) goto L_0x005a
            r0 = 0
            goto L_0x0089
        L_0x005a:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r0.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.mDimension
            int r1 = r1.value
            float r1 = (float) r1
            float r0 = r0.getDimensionRatio()
        L_0x0067:
            float r1 = r1 * r0
        L_0x0069:
            float r1 = r1 + r11
            int r0 = (int) r1
            goto L_0x0089
        L_0x006c:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r0.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.mDimension
            int r1 = r1.value
            float r1 = (float) r1
            float r0 = r0.getDimensionRatio()
            float r1 = r1 / r0
            goto L_0x0069
        L_0x007b:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r0.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.mDimension
            int r1 = r1.value
            float r1 = (float) r1
            float r0 = r0.getDimensionRatio()
            goto L_0x0067
        L_0x0089:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r8.mDimension
            r1.resolve(r0)
            goto L_0x0325
        L_0x0090:
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r0.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r12 = r1.start
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r13 = r1.end
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 == 0) goto L_0x009e
            r1 = 1
            goto L_0x009f
        L_0x009e:
            r1 = 0
        L_0x009f:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x00b0
            r4 = 1
            goto L_0x00b1
        L_0x00b0:
            r4 = 0
        L_0x00b1:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x00b9
            r5 = 1
            goto L_0x00ba
        L_0x00b9:
            r5 = 0
        L_0x00ba:
            int r14 = r0.getDimensionRatioSide()
            if (r1 == 0) goto L_0x0201
            if (r2 == 0) goto L_0x0201
            if (r4 == 0) goto L_0x0201
            if (r5 == 0) goto L_0x0201
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            float r15 = r0.getDimensionRatio()
            boolean r0 = r12.resolved
            if (r0 == 0) goto L_0x012f
            boolean r0 = r13.resolved
            if (r0 == 0) goto L_0x012f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            boolean r1 = r0.readyToSolve
            if (r1 == 0) goto L_0x012e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            boolean r1 = r1.readyToSolve
            if (r1 != 0) goto L_0x00e1
            goto L_0x012e
        L_0x00e1:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.mTargets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.start
            int r1 = r1.mMargin
            int r2 = r0 + r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.mTargets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            int r1 = r1.mMargin
            int r3 = r0 - r1
            int r0 = r12.value
            int r1 = r12.mMargin
            int r4 = r0 + r1
            int r0 = r13.value
            int r1 = r13.mMargin
            int r5 = r0 - r1
            int[] r1 = sTempDimensions
            r0 = r16
            r6 = r15
            r7 = r14
            r0.computeInsetRatio(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.mDimension
            int[] r1 = sTempDimensions
            r1 = r1[r10]
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.mDimension
            int[] r1 = sTempDimensions
            r1 = r1[r9]
            r0.resolve(r1)
        L_0x012e:
            return
        L_0x012f:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            boolean r1 = r0.resolved
            if (r1 == 0) goto L_0x018c
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            boolean r2 = r1.resolved
            if (r2 == 0) goto L_0x018c
            boolean r2 = r12.readyToSolve
            if (r2 == 0) goto L_0x018b
            boolean r2 = r13.readyToSolve
            if (r2 != 0) goto L_0x0144
            goto L_0x018b
        L_0x0144:
            int r2 = r0.value
            int r0 = r0.mMargin
            int r2 = r2 + r0
            int r0 = r1.value
            int r1 = r1.mMargin
            int r3 = r0 - r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r12.mTargets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            int r1 = r12.mMargin
            int r4 = r0 + r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r13.mTargets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            int r1 = r13.mMargin
            int r5 = r0 - r1
            int[] r1 = sTempDimensions
            r0 = r16
            r6 = r15
            r7 = r14
            r0.computeInsetRatio(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.mDimension
            int[] r1 = sTempDimensions
            r1 = r1[r10]
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.mDimension
            int[] r1 = sTempDimensions
            r1 = r1[r9]
            r0.resolve(r1)
            goto L_0x018c
        L_0x018b:
            return
        L_0x018c:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            boolean r1 = r0.readyToSolve
            if (r1 == 0) goto L_0x0200
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            boolean r1 = r1.readyToSolve
            if (r1 == 0) goto L_0x0200
            boolean r1 = r12.readyToSolve
            if (r1 == 0) goto L_0x0200
            boolean r1 = r13.readyToSolve
            if (r1 != 0) goto L_0x01a1
            goto L_0x0200
        L_0x01a1:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.mTargets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.start
            int r1 = r1.mMargin
            int r2 = r0 + r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.mTargets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            int r1 = r1.mMargin
            int r3 = r0 - r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r12.mTargets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            int r1 = r12.mMargin
            int r4 = r0 + r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r13.mTargets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            int r1 = r13.mMargin
            int r5 = r0 - r1
            int[] r1 = sTempDimensions
            r0 = r16
            r6 = r15
            r7 = r14
            r0.computeInsetRatio(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.mDimension
            int[] r1 = sTempDimensions
            r1 = r1[r10]
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.mDimension
            int[] r1 = sTempDimensions
            r1 = r1[r9]
            r0.resolve(r1)
            goto L_0x0325
        L_0x0200:
            return
        L_0x0201:
            if (r1 == 0) goto L_0x028c
            if (r4 == 0) goto L_0x028c
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            boolean r0 = r0.readyToSolve
            if (r0 == 0) goto L_0x028b
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            boolean r0 = r0.readyToSolve
            if (r0 != 0) goto L_0x0213
            goto L_0x028b
        L_0x0213:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            float r0 = r0.getDimensionRatio()
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.mTargets
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.start
            int r2 = r2.mMargin
            int r1 = r1 + r2
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r2.mTargets
            java.lang.Object r2 = r2.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r8.end
            int r4 = r4.mMargin
            int r2 = r2 - r4
            if (r14 == r3) goto L_0x0267
            if (r14 == 0) goto L_0x0267
            if (r14 == r9) goto L_0x0243
            goto L_0x0325
        L_0x0243:
            int r2 = r2 - r1
            int r1 = r8.getLimitedDimension(r2, r10)
            float r2 = (float) r1
            float r2 = r2 / r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.getLimitedDimension(r2, r9)
            if (r2 == r3) goto L_0x0257
            float r1 = (float) r3
            float r1 = r1 * r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x0257:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.mDimension
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.mDimension
            r0.resolve(r3)
            goto L_0x0325
        L_0x0267:
            int r2 = r2 - r1
            int r1 = r8.getLimitedDimension(r2, r10)
            float r2 = (float) r1
            float r2 = r2 * r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.getLimitedDimension(r2, r9)
            if (r2 == r3) goto L_0x027b
            float r1 = (float) r3
            float r1 = r1 / r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x027b:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.mDimension
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.mDimension
            r0.resolve(r3)
            goto L_0x0325
        L_0x028b:
            return
        L_0x028c:
            if (r2 == 0) goto L_0x0325
            if (r5 == 0) goto L_0x0325
            boolean r0 = r12.readyToSolve
            if (r0 == 0) goto L_0x0306
            boolean r0 = r13.readyToSolve
            if (r0 != 0) goto L_0x0299
            goto L_0x0306
        L_0x0299:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            float r0 = r0.getDimensionRatio()
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r12.mTargets
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.value
            int r2 = r12.mMargin
            int r1 = r1 + r2
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r13.mTargets
            java.lang.Object r2 = r2.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.value
            int r4 = r13.mMargin
            int r2 = r2 - r4
            if (r14 == r3) goto L_0x02e3
            if (r14 == 0) goto L_0x02c0
            if (r14 == r9) goto L_0x02e3
            goto L_0x0325
        L_0x02c0:
            int r2 = r2 - r1
            int r1 = r8.getLimitedDimension(r2, r9)
            float r2 = (float) r1
            float r2 = r2 * r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.getLimitedDimension(r2, r10)
            if (r2 == r3) goto L_0x02d4
            float r1 = (float) r3
            float r1 = r1 / r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x02d4:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.mDimension
            r0.resolve(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.mDimension
            r0.resolve(r1)
            goto L_0x0325
        L_0x02e3:
            int r2 = r2 - r1
            int r1 = r8.getLimitedDimension(r2, r9)
            float r2 = (float) r1
            float r2 = r2 / r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.getLimitedDimension(r2, r10)
            if (r2 == r3) goto L_0x02f7
            float r1 = (float) r3
            float r1 = r1 * r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x02f7:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.mDimension
            r0.resolve(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.mDimension
            r0.resolve(r1)
            goto L_0x0325
        L_0x0306:
            return
        L_0x0307:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.getParent()
            if (r0 == 0) goto L_0x0325
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r0.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.mDimension
            boolean r1 = r0.resolved
            if (r1 == 0) goto L_0x0325
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r8.mWidget
            float r1 = r1.mMatchConstraintPercentWidth
            int r0 = r0.value
            float r0 = (float) r0
            float r0 = r0 * r1
            float r0 = r0 + r11
            int r0 = (int) r0
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r8.mDimension
            r1.resolve(r0)
        L_0x0325:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            boolean r1 = r0.readyToSolve
            if (r1 == 0) goto L_0x0447
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            boolean r2 = r1.readyToSolve
            if (r2 != 0) goto L_0x0333
            goto L_0x0447
        L_0x0333:
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x0342
            boolean r0 = r1.resolved
            if (r0 == 0) goto L_0x0342
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.mDimension
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x0342
            return
        L_0x0342:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.mDimension
            boolean r0 = r0.resolved
            if (r0 != 0) goto L_0x038c
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.mDimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x038c
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            int r1 = r0.mMatchConstraintDefaultWidth
            if (r1 != 0) goto L_0x038c
            boolean r0 = r0.isInHorizontalChain()
            if (r0 != 0) goto L_0x038c
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.mTargets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.mTargets
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.start
            int r3 = r2.mMargin
            int r0 = r0 + r3
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r8.end
            int r3 = r3.mMargin
            int r1 = r1 + r3
            int r3 = r1 - r0
            r2.resolve(r0)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.mDimension
            r0.resolve(r3)
            return
        L_0x038c:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.mDimension
            boolean r0 = r0.resolved
            if (r0 != 0) goto L_0x03f0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.mDimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x03f0
            int r0 = r8.matchConstraintsType
            if (r0 != r9) goto L_0x03f0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.mTargets
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03f0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.mTargets
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03f0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.mTargets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.mTargets
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.start
            int r2 = r2.mMargin
            int r0 = r0 + r2
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.end
            int r2 = r2.mMargin
            int r1 = r1 + r2
            int r1 = r1 - r0
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.mDimension
            int r0 = r0.wrapValue
            int r0 = java.lang.Math.min(r1, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r8.mWidget
            int r2 = r1.mMatchConstraintMaxWidth
            int r1 = r1.mMatchConstraintMinWidth
            int r0 = java.lang.Math.max(r1, r0)
            if (r2 <= 0) goto L_0x03eb
            int r0 = java.lang.Math.min(r2, r0)
        L_0x03eb:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r8.mDimension
            r1.resolve(r0)
        L_0x03f0:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.mDimension
            boolean r0 = r0.resolved
            if (r0 != 0) goto L_0x03f7
            return
        L_0x03f7:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.mTargets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.mTargets
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r2 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r8.start
            int r3 = r3.mMargin
            int r2 = r2 + r3
            int r3 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r8.end
            int r4 = r4.mMargin
            int r3 = r3 + r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r8.mWidget
            float r4 = r4.getHorizontalBiasPercent()
            if (r0 != r1) goto L_0x0427
            int r2 = r0.value
            int r3 = r1.value
            r4 = 1056964608(0x3f000000, float:0.5)
        L_0x0427:
            int r3 = r3 - r2
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.mDimension
            int r0 = r0.value
            int r3 = r3 - r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            float r1 = (float) r2
            float r1 = r1 + r11
            float r2 = (float) r3
            float r2 = r2 * r4
            float r1 = r1 + r2
            int r1 = (int) r1
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.start
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r8.mDimension
            int r2 = r2.value
            int r1 = r1 + r2
            r0.resolve(r1)
        L_0x0447:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.update(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }
}
