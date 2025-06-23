package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.constraintlayout.core.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.core.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.FlowReference;
import androidx.constraintlayout.core.state.helpers.GridReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import androidx.constraintlayout.core.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.core.state.helpers.VerticalChainReference;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class State {
    static final int CONSTRAINT_RATIO = 2;
    static final int CONSTRAINT_SPREAD = 0;
    static final int CONSTRAINT_WRAP = 1;
    public static final Integer PARENT = 0;
    static final int UNKNOWN = -1;
    ArrayList<Object> mBaselineNeeded;
    ArrayList<ConstraintWidget> mBaselineNeededWidgets;
    boolean mDirtyBaselineNeededWidgets;
    private CorePixelDp mDpToPixel;
    protected HashMap<Object, HelperReference> mHelperReferences = new HashMap<>();
    private boolean mIsLtr = true;
    private int mNumHelpers;
    public final ConstraintReference mParent;
    protected HashMap<Object, Reference> mReferences = new HashMap<>();
    HashMap<String, ArrayList<String>> mTags = new HashMap<>();

    public enum Chain {
        SPREAD,
        SPREAD_INSIDE,
        PACKED;
        
        public static Map<String, Chain> chainMap;
        public static Map<String, Integer> valueMap;

        static {
            Chain chain;
            Chain chain2;
            Chain chain3;
            chainMap = new HashMap();
            valueMap = new HashMap();
            chainMap.put("packed", chain3);
            chainMap.put("spread_inside", chain2);
            chainMap.put("spread", chain);
            valueMap.put("packed", 2);
            valueMap.put("spread_inside", 1);
            valueMap.put("spread", 0);
        }

        public static Chain getChainByString(String str) {
            if (chainMap.containsKey(str)) {
                return chainMap.get(str);
            }
            return null;
        }

        public static int getValueByString(String str) {
            if (valueMap.containsKey(str)) {
                return valueMap.get(str).intValue();
            }
            return -1;
        }
    }

    public enum Constraint {
        LEFT_TO_LEFT,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        RIGHT_TO_RIGHT,
        START_TO_START,
        START_TO_END,
        END_TO_START,
        END_TO_END,
        TOP_TO_TOP,
        TOP_TO_BOTTOM,
        TOP_TO_BASELINE,
        BOTTOM_TO_TOP,
        BOTTOM_TO_BOTTOM,
        BOTTOM_TO_BASELINE,
        BASELINE_TO_BASELINE,
        BASELINE_TO_TOP,
        BASELINE_TO_BOTTOM,
        CENTER_HORIZONTALLY,
        CENTER_VERTICALLY,
        CIRCULAR_CONSTRAINT
    }

    public enum Direction {
        LEFT,
        RIGHT,
        START,
        END,
        TOP,
        BOTTOM
    }

    public enum Helper {
        HORIZONTAL_CHAIN,
        VERTICAL_CHAIN,
        ALIGN_HORIZONTALLY,
        ALIGN_VERTICALLY,
        BARRIER,
        LAYER,
        HORIZONTAL_FLOW,
        VERTICAL_FLOW,
        GRID,
        ROW,
        COLUMN,
        FLOW
    }

    public enum Wrap {
        NONE,
        CHAIN,
        ALIGNED;
        
        public static Map<String, Integer> valueMap;
        public static Map<String, Wrap> wrapMap;

        static {
            Wrap wrap;
            Wrap wrap2;
            Wrap wrap3;
            wrapMap = new HashMap();
            valueMap = new HashMap();
            wrapMap.put("none", wrap);
            wrapMap.put("chain", wrap2);
            wrapMap.put("aligned", wrap3);
            valueMap.put("none", 0);
            valueMap.put("chain", 3);
            valueMap.put("aligned", 2);
        }

        public static Wrap getChainByString(String str) {
            if (wrapMap.containsKey(str)) {
                return wrapMap.get(str);
            }
            return null;
        }

        public static int getValueByString(String str) {
            if (valueMap.containsKey(str)) {
                return valueMap.get(str).intValue();
            }
            return -1;
        }
    }

    public State() {
        ConstraintReference constraintReference = new ConstraintReference(this);
        this.mParent = constraintReference;
        this.mNumHelpers = 0;
        this.mBaselineNeeded = new ArrayList<>();
        this.mBaselineNeededWidgets = new ArrayList<>();
        this.mDirtyBaselineNeededWidgets = true;
        Integer num = PARENT;
        constraintReference.setKey(num);
        this.mReferences.put(num, constraintReference);
    }

    private String createHelperKey() {
        StringBuilder sb = new StringBuilder();
        sb.append("__HELPER_KEY_");
        int i = this.mNumHelpers;
        this.mNumHelpers = i + 1;
        sb.append(i);
        sb.append("__");
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x014d, code lost:
        r1 = (androidx.constraintlayout.core.state.HelperReference) r0.getFacade();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void apply(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r8) {
        /*
            r7 = this;
            r8.removeAllChildren()
            androidx.constraintlayout.core.state.ConstraintReference r0 = r7.mParent
            androidx.constraintlayout.core.state.Dimension r0 = r0.getWidth()
            r1 = 0
            r0.apply(r7, r8, r1)
            androidx.constraintlayout.core.state.ConstraintReference r0 = r7.mParent
            androidx.constraintlayout.core.state.Dimension r0 = r0.getHeight()
            r1 = 1
            r0.apply(r7, r8, r1)
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.HelperReference> r0 = r7.mHelperReferences
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0021:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x004b
            java.lang.Object r1 = r0.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.HelperReference> r2 = r7.mHelperReferences
            java.lang.Object r2 = r2.get(r1)
            androidx.constraintlayout.core.state.HelperReference r2 = (androidx.constraintlayout.core.state.HelperReference) r2
            androidx.constraintlayout.core.widgets.HelperWidget r2 = r2.getHelperWidget()
            if (r2 == 0) goto L_0x0021
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r3 = r7.mReferences
            java.lang.Object r3 = r3.get(r1)
            androidx.constraintlayout.core.state.Reference r3 = (androidx.constraintlayout.core.state.Reference) r3
            if (r3 != 0) goto L_0x0047
            androidx.constraintlayout.core.state.ConstraintReference r3 = r7.constraints(r1)
        L_0x0047:
            r3.setConstraintWidget(r2)
            goto L_0x0021
        L_0x004b:
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r0 = r7.mReferences
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0055:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0091
            java.lang.Object r1 = r0.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r2 = r7.mReferences
            java.lang.Object r2 = r2.get(r1)
            androidx.constraintlayout.core.state.Reference r2 = (androidx.constraintlayout.core.state.Reference) r2
            androidx.constraintlayout.core.state.ConstraintReference r3 = r7.mParent
            if (r2 == r3) goto L_0x0055
            androidx.constraintlayout.core.state.helpers.Facade r3 = r2.getFacade()
            boolean r3 = r3 instanceof androidx.constraintlayout.core.state.HelperReference
            if (r3 == 0) goto L_0x0055
            androidx.constraintlayout.core.state.helpers.Facade r2 = r2.getFacade()
            androidx.constraintlayout.core.state.HelperReference r2 = (androidx.constraintlayout.core.state.HelperReference) r2
            androidx.constraintlayout.core.widgets.HelperWidget r2 = r2.getHelperWidget()
            if (r2 == 0) goto L_0x0055
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r3 = r7.mReferences
            java.lang.Object r3 = r3.get(r1)
            androidx.constraintlayout.core.state.Reference r3 = (androidx.constraintlayout.core.state.Reference) r3
            if (r3 != 0) goto L_0x008d
            androidx.constraintlayout.core.state.ConstraintReference r3 = r7.constraints(r1)
        L_0x008d:
            r3.setConstraintWidget(r2)
            goto L_0x0055
        L_0x0091:
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r0 = r7.mReferences
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x009b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00d7
            java.lang.Object r1 = r0.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r2 = r7.mReferences
            java.lang.Object r1 = r2.get(r1)
            androidx.constraintlayout.core.state.Reference r1 = (androidx.constraintlayout.core.state.Reference) r1
            androidx.constraintlayout.core.state.ConstraintReference r2 = r7.mParent
            if (r1 == r2) goto L_0x00d3
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r1.getConstraintWidget()
            java.lang.Object r3 = r1.getKey()
            java.lang.String r3 = r3.toString()
            r2.setDebugName(r3)
            r3 = 0
            r2.setParent(r3)
            androidx.constraintlayout.core.state.helpers.Facade r3 = r1.getFacade()
            boolean r3 = r3 instanceof androidx.constraintlayout.core.state.helpers.GuidelineReference
            if (r3 == 0) goto L_0x00cf
            r1.apply()
        L_0x00cf:
            r8.add((androidx.constraintlayout.core.widgets.ConstraintWidget) r2)
            goto L_0x009b
        L_0x00d3:
            r1.setConstraintWidget(r8)
            goto L_0x009b
        L_0x00d7:
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.HelperReference> r8 = r7.mHelperReferences
            java.util.Set r8 = r8.keySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x00e1:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x0125
            java.lang.Object r0 = r8.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.HelperReference> r1 = r7.mHelperReferences
            java.lang.Object r0 = r1.get(r0)
            androidx.constraintlayout.core.state.HelperReference r0 = (androidx.constraintlayout.core.state.HelperReference) r0
            androidx.constraintlayout.core.widgets.HelperWidget r1 = r0.getHelperWidget()
            if (r1 == 0) goto L_0x0121
            java.util.ArrayList<java.lang.Object> r1 = r0.mReferences
            java.util.Iterator r1 = r1.iterator()
        L_0x00ff:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x011d
            java.lang.Object r2 = r1.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r3 = r7.mReferences
            java.lang.Object r2 = r3.get(r2)
            androidx.constraintlayout.core.state.Reference r2 = (androidx.constraintlayout.core.state.Reference) r2
            androidx.constraintlayout.core.widgets.HelperWidget r3 = r0.getHelperWidget()
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r2.getConstraintWidget()
            r3.add(r2)
            goto L_0x00ff
        L_0x011d:
            r0.apply()
            goto L_0x00e1
        L_0x0121:
            r0.apply()
            goto L_0x00e1
        L_0x0125:
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r8 = r7.mReferences
            java.util.Set r8 = r8.keySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x012f:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x01a4
            java.lang.Object r0 = r8.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r1 = r7.mReferences
            java.lang.Object r0 = r1.get(r0)
            androidx.constraintlayout.core.state.Reference r0 = (androidx.constraintlayout.core.state.Reference) r0
            androidx.constraintlayout.core.state.ConstraintReference r1 = r7.mParent
            if (r0 == r1) goto L_0x012f
            androidx.constraintlayout.core.state.helpers.Facade r1 = r0.getFacade()
            boolean r1 = r1 instanceof androidx.constraintlayout.core.state.HelperReference
            if (r1 == 0) goto L_0x012f
            androidx.constraintlayout.core.state.helpers.Facade r1 = r0.getFacade()
            androidx.constraintlayout.core.state.HelperReference r1 = (androidx.constraintlayout.core.state.HelperReference) r1
            androidx.constraintlayout.core.widgets.HelperWidget r2 = r1.getHelperWidget()
            if (r2 == 0) goto L_0x012f
            java.util.ArrayList<java.lang.Object> r1 = r1.mReferences
            java.util.Iterator r1 = r1.iterator()
        L_0x015f:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x01a0
            java.lang.Object r3 = r1.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r4 = r7.mReferences
            java.lang.Object r4 = r4.get(r3)
            androidx.constraintlayout.core.state.Reference r4 = (androidx.constraintlayout.core.state.Reference) r4
            if (r4 == 0) goto L_0x017b
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r4.getConstraintWidget()
            r2.add(r3)
            goto L_0x015f
        L_0x017b:
            boolean r4 = r3 instanceof androidx.constraintlayout.core.state.Reference
            if (r4 == 0) goto L_0x0189
            androidx.constraintlayout.core.state.Reference r3 = (androidx.constraintlayout.core.state.Reference) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.getConstraintWidget()
            r2.add(r3)
            goto L_0x015f
        L_0x0189:
            java.io.PrintStream r4 = java.lang.System.out
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "couldn't find reference for "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.println(r3)
            goto L_0x015f
        L_0x01a0:
            r0.apply()
            goto L_0x012f
        L_0x01a4:
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r8 = r7.mReferences
            java.util.Set r8 = r8.keySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x01ae:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x01d2
            java.lang.Object r0 = r8.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r1 = r7.mReferences
            java.lang.Object r1 = r1.get(r0)
            androidx.constraintlayout.core.state.Reference r1 = (androidx.constraintlayout.core.state.Reference) r1
            r1.apply()
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.getConstraintWidget()
            if (r1 == 0) goto L_0x01ae
            if (r0 == 0) goto L_0x01ae
            java.lang.String r0 = r0.toString()
            r1.stringId = r0
            goto L_0x01ae
        L_0x01d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.State.apply(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):void");
    }

    public BarrierReference barrier(Object obj, Direction direction) {
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof BarrierReference)) {
            BarrierReference barrierReference = new BarrierReference(this);
            barrierReference.setBarrierDirection(direction);
            constraints.setFacade(barrierReference);
        }
        return (BarrierReference) constraints.getFacade();
    }

    public void baselineNeededFor(Object obj) {
        this.mBaselineNeeded.add(obj);
        this.mDirtyBaselineNeededWidgets = true;
    }

    public AlignHorizontallyReference centerHorizontally(Object... objArr) {
        AlignHorizontallyReference alignHorizontallyReference = (AlignHorizontallyReference) helper((Object) null, Helper.ALIGN_HORIZONTALLY);
        alignHorizontallyReference.add(objArr);
        return alignHorizontallyReference;
    }

    public AlignVerticallyReference centerVertically(Object... objArr) {
        AlignVerticallyReference alignVerticallyReference = (AlignVerticallyReference) helper((Object) null, Helper.ALIGN_VERTICALLY);
        alignVerticallyReference.add(objArr);
        return alignVerticallyReference;
    }

    public ConstraintReference constraints(Object obj) {
        Reference reference = this.mReferences.get(obj);
        if (reference == null) {
            reference = createConstraintReference(obj);
            this.mReferences.put(obj, reference);
            reference.setKey(obj);
        }
        if (reference instanceof ConstraintReference) {
            return (ConstraintReference) reference;
        }
        return null;
    }

    public int convertDimension(Object obj) {
        if (obj instanceof Float) {
            return Math.round(((Float) obj).floatValue());
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public ConstraintReference createConstraintReference(Object obj) {
        return new ConstraintReference(this);
    }

    public void directMapping() {
        for (Object next : this.mReferences.keySet()) {
            ConstraintReference constraints = constraints(next);
            if (constraints instanceof ConstraintReference) {
                constraints.setView(next);
            }
        }
    }

    public CorePixelDp getDpToPixel() {
        return this.mDpToPixel;
    }

    public FlowReference getFlow(Object obj, boolean z) {
        FlowReference flowReference;
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof FlowReference)) {
            if (z) {
                flowReference = new FlowReference(this, Helper.VERTICAL_FLOW);
            } else {
                flowReference = new FlowReference(this, Helper.HORIZONTAL_FLOW);
            }
            constraints.setFacade(flowReference);
        }
        return (FlowReference) constraints.getFacade();
    }

    @NonNull
    public GridReference getGrid(@NonNull Object obj, @NonNull String str) {
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof GridReference)) {
            Helper helper = Helper.GRID;
            if (str.charAt(0) == 'r') {
                helper = Helper.ROW;
            } else if (str.charAt(0) == 'c') {
                helper = Helper.COLUMN;
            }
            constraints.setFacade(new GridReference(this, helper));
        }
        return (GridReference) constraints.getFacade();
    }

    public FlowReference getHorizontalFlow() {
        return (FlowReference) helper((Object) null, Helper.HORIZONTAL_FLOW);
    }

    public ArrayList<String> getIdsForTag(String str) {
        if (this.mTags.containsKey(str)) {
            return this.mTags.get(str);
        }
        return null;
    }

    public FlowReference getVerticalFlow() {
        return (FlowReference) helper((Object) null, Helper.VERTICAL_FLOW);
    }

    public GuidelineReference guideline(Object obj, int i) {
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof GuidelineReference)) {
            GuidelineReference guidelineReference = new GuidelineReference(this);
            guidelineReference.setOrientation(i);
            guidelineReference.setKey(obj);
            constraints.setFacade(guidelineReference);
        }
        return (GuidelineReference) constraints.getFacade();
    }

    public State height(Dimension dimension) {
        return setHeight(dimension);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        r0.setKey(r2);
        r1.mHelperReferences.put(r2, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.core.state.HelperReference helper(java.lang.Object r2, androidx.constraintlayout.core.state.State.Helper r3) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0006
            java.lang.String r2 = r1.createHelperKey()
        L_0x0006:
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.HelperReference> r0 = r1.mHelperReferences
            java.lang.Object r0 = r0.get(r2)
            androidx.constraintlayout.core.state.HelperReference r0 = (androidx.constraintlayout.core.state.HelperReference) r0
            if (r0 != 0) goto L_0x0050
            int r0 = r3.ordinal()
            switch(r0) {
                case 0: goto L_0x0042;
                case 1: goto L_0x003c;
                case 2: goto L_0x0036;
                case 3: goto L_0x0030;
                case 4: goto L_0x0029;
                case 5: goto L_0x0017;
                case 6: goto L_0x0023;
                case 7: goto L_0x0023;
                case 8: goto L_0x001d;
                case 9: goto L_0x001d;
                case 10: goto L_0x001d;
                default: goto L_0x0017;
            }
        L_0x0017:
            androidx.constraintlayout.core.state.HelperReference r0 = new androidx.constraintlayout.core.state.HelperReference
            r0.<init>(r1, r3)
            goto L_0x0048
        L_0x001d:
            androidx.constraintlayout.core.state.helpers.GridReference r0 = new androidx.constraintlayout.core.state.helpers.GridReference
            r0.<init>(r1, r3)
            goto L_0x0048
        L_0x0023:
            androidx.constraintlayout.core.state.helpers.FlowReference r0 = new androidx.constraintlayout.core.state.helpers.FlowReference
            r0.<init>(r1, r3)
            goto L_0x0048
        L_0x0029:
            androidx.constraintlayout.core.state.helpers.BarrierReference r3 = new androidx.constraintlayout.core.state.helpers.BarrierReference
            r3.<init>(r1)
        L_0x002e:
            r0 = r3
            goto L_0x0048
        L_0x0030:
            androidx.constraintlayout.core.state.helpers.AlignVerticallyReference r3 = new androidx.constraintlayout.core.state.helpers.AlignVerticallyReference
            r3.<init>(r1)
            goto L_0x002e
        L_0x0036:
            androidx.constraintlayout.core.state.helpers.AlignHorizontallyReference r3 = new androidx.constraintlayout.core.state.helpers.AlignHorizontallyReference
            r3.<init>(r1)
            goto L_0x002e
        L_0x003c:
            androidx.constraintlayout.core.state.helpers.VerticalChainReference r3 = new androidx.constraintlayout.core.state.helpers.VerticalChainReference
            r3.<init>(r1)
            goto L_0x002e
        L_0x0042:
            androidx.constraintlayout.core.state.helpers.HorizontalChainReference r3 = new androidx.constraintlayout.core.state.helpers.HorizontalChainReference
            r3.<init>(r1)
            goto L_0x002e
        L_0x0048:
            r0.setKey(r2)
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.HelperReference> r3 = r1.mHelperReferences
            r3.put(r2, r0)
        L_0x0050:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.State.helper(java.lang.Object, androidx.constraintlayout.core.state.State$Helper):androidx.constraintlayout.core.state.HelperReference");
    }

    public HorizontalChainReference horizontalChain() {
        return (HorizontalChainReference) helper((Object) null, Helper.HORIZONTAL_CHAIN);
    }

    public GuidelineReference horizontalGuideline(Object obj) {
        return guideline(obj, 0);
    }

    public boolean isBaselineNeeded(ConstraintWidget constraintWidget) {
        if (this.mDirtyBaselineNeededWidgets) {
            this.mBaselineNeededWidgets.clear();
            Iterator<Object> it = this.mBaselineNeeded.iterator();
            while (it.hasNext()) {
                ConstraintWidget constraintWidget2 = this.mReferences.get(it.next()).getConstraintWidget();
                if (constraintWidget2 != null) {
                    this.mBaselineNeededWidgets.add(constraintWidget2);
                }
            }
            this.mDirtyBaselineNeededWidgets = false;
        }
        return this.mBaselineNeededWidgets.contains(constraintWidget);
    }

    @Deprecated
    public boolean isLtr() {
        return this.mIsLtr;
    }

    public boolean isRtl() {
        return !this.mIsLtr;
    }

    public void map(Object obj, Object obj2) {
        ConstraintReference constraints = constraints(obj);
        if (constraints != null) {
            constraints.setView(obj2);
        }
    }

    public Reference reference(Object obj) {
        return this.mReferences.get(obj);
    }

    public void reset() {
        for (Object obj : this.mReferences.keySet()) {
            this.mReferences.get(obj).getConstraintWidget().reset();
        }
        this.mReferences.clear();
        this.mReferences.put(PARENT, this.mParent);
        this.mHelperReferences.clear();
        this.mTags.clear();
        this.mBaselineNeeded.clear();
        this.mDirtyBaselineNeededWidgets = true;
    }

    public boolean sameFixedHeight(int i) {
        return this.mParent.getHeight().equalsFixedValue(i);
    }

    public boolean sameFixedWidth(int i) {
        return this.mParent.getWidth().equalsFixedValue(i);
    }

    public void setDpToPixel(CorePixelDp corePixelDp) {
        this.mDpToPixel = corePixelDp;
    }

    public State setHeight(Dimension dimension) {
        this.mParent.setHeight(dimension);
        return this;
    }

    @Deprecated
    public void setLtr(boolean z) {
        this.mIsLtr = z;
    }

    public void setRtl(boolean z) {
        this.mIsLtr = !z;
    }

    public void setTag(String str, String str2) {
        ArrayList arrayList;
        ConstraintReference constraints = constraints(str);
        if (constraints instanceof ConstraintReference) {
            constraints.setTag(str2);
            if (!this.mTags.containsKey(str2)) {
                arrayList = new ArrayList();
                this.mTags.put(str2, arrayList);
            } else {
                arrayList = this.mTags.get(str2);
            }
            arrayList.add(str);
        }
    }

    public State setWidth(Dimension dimension) {
        this.mParent.setWidth(dimension);
        return this;
    }

    public VerticalChainReference verticalChain() {
        return (VerticalChainReference) helper((Object) null, Helper.VERTICAL_CHAIN);
    }

    public GuidelineReference verticalGuideline(Object obj) {
        return guideline(obj, 1);
    }

    public State width(Dimension dimension) {
        return setWidth(dimension);
    }

    public FlowReference getHorizontalFlow(Object... objArr) {
        FlowReference flowReference = (FlowReference) helper((Object) null, Helper.HORIZONTAL_FLOW);
        flowReference.add(objArr);
        return flowReference;
    }

    public FlowReference getVerticalFlow(Object... objArr) {
        FlowReference flowReference = (FlowReference) helper((Object) null, Helper.VERTICAL_FLOW);
        flowReference.add(objArr);
        return flowReference;
    }

    public HorizontalChainReference horizontalChain(Object... objArr) {
        HorizontalChainReference horizontalChainReference = (HorizontalChainReference) helper((Object) null, Helper.HORIZONTAL_CHAIN);
        horizontalChainReference.add(objArr);
        return horizontalChainReference;
    }

    public VerticalChainReference verticalChain(Object... objArr) {
        VerticalChainReference verticalChainReference = (VerticalChainReference) helper((Object) null, Helper.VERTICAL_CHAIN);
        verticalChainReference.add(objArr);
        return verticalChainReference;
    }
}
