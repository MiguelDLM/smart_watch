package androidx.constraintlayout.core.state;

import OoOoXO0.xoXoI;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.parser.CLString;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.GridReference;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.android.gms.fitness.data.WorkoutExercises;
import com.huawei.openalliance.ad.constant.bn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ConstraintSetParser {
    private static final boolean PARSER_DEBUG = false;

    /* loaded from: classes.dex */
    public static class DesignElement {
        String mId;
        HashMap<String, String> mParams;
        String mType;

        public DesignElement(String str, String str2, HashMap<String, String> hashMap) {
            this.mId = str;
            this.mType = str2;
            this.mParams = hashMap;
        }

        public String getId() {
            return this.mId;
        }

        public HashMap<String, String> getParams() {
            return this.mParams;
        }

        public String getType() {
            return this.mType;
        }
    }

    /* loaded from: classes.dex */
    public static class FiniteGenerator implements GeneratedValue {
        float mFrom;
        float mInitial;
        float mMax;
        String mPostfix;
        String mPrefix;
        float mStep;
        float mTo;
        boolean mStop = false;
        float mCurrent = 0.0f;

        public FiniteGenerator(float f, float f2, float f3, String str, String str2) {
            this.mFrom = f;
            this.mTo = f2;
            this.mStep = f3;
            this.mPrefix = str == null ? "" : str;
            this.mPostfix = str2 == null ? "" : str2;
            this.mMax = f2;
            this.mInitial = f;
        }

        public ArrayList<String> array() {
            ArrayList<String> arrayList = new ArrayList<>();
            int i = (int) this.mInitial;
            int i2 = (int) this.mMax;
            int i3 = i;
            while (i <= i2) {
                arrayList.add(this.mPrefix + i3 + this.mPostfix);
                i3 += (int) this.mStep;
                i++;
            }
            return arrayList;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            float f = this.mCurrent;
            if (f >= this.mMax) {
                this.mStop = true;
            }
            if (!this.mStop) {
                this.mCurrent = f + this.mStep;
            }
            return this.mCurrent;
        }
    }

    /* loaded from: classes.dex */
    public interface GeneratedValue {
        float value();
    }

    /* loaded from: classes.dex */
    public static class Generator implements GeneratedValue {
        float mCurrent;
        float mIncrementBy;
        float mStart;
        boolean mStop = false;

        public Generator(float f, float f2) {
            this.mStart = f;
            this.mIncrementBy = f2;
            this.mCurrent = f;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            if (!this.mStop) {
                this.mCurrent += this.mIncrementBy;
            }
            return this.mCurrent;
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutVariables {
        HashMap<String, Integer> mMargins = new HashMap<>();
        HashMap<String, GeneratedValue> mGenerators = new HashMap<>();
        HashMap<String, ArrayList<String>> mArrayIds = new HashMap<>();

        public float get(Object obj) {
            if (obj instanceof CLString) {
                String content = ((CLString) obj).content();
                if (this.mGenerators.containsKey(content)) {
                    return this.mGenerators.get(content).value();
                }
                if (this.mMargins.containsKey(content)) {
                    return this.mMargins.get(content).floatValue();
                }
                return 0.0f;
            }
            if (obj instanceof CLNumber) {
                return ((CLNumber) obj).getFloat();
            }
            return 0.0f;
        }

        public ArrayList<String> getList(String str) {
            if (this.mArrayIds.containsKey(str)) {
                return this.mArrayIds.get(str);
            }
            return null;
        }

        public void put(String str, int i) {
            this.mMargins.put(str, Integer.valueOf(i));
        }

        public void putOverride(String str, float f) {
            this.mGenerators.put(str, new OverrideValue(f));
        }

        public void put(String str, float f, float f2) {
            if (this.mGenerators.containsKey(str) && (this.mGenerators.get(str) instanceof OverrideValue)) {
                return;
            }
            this.mGenerators.put(str, new Generator(f, f2));
        }

        public void put(String str, float f, float f2, float f3, String str2, String str3) {
            if (this.mGenerators.containsKey(str) && (this.mGenerators.get(str) instanceof OverrideValue)) {
                return;
            }
            FiniteGenerator finiteGenerator = new FiniteGenerator(f, f2, f3, str2, str3);
            this.mGenerators.put(str, finiteGenerator);
            this.mArrayIds.put(str, finiteGenerator.array());
        }

        public void put(String str, ArrayList<String> arrayList) {
            this.mArrayIds.put(str, arrayList);
        }
    }

    /* loaded from: classes.dex */
    public enum MotionLayoutDebugFlags {
        NONE,
        SHOW_ALL,
        UNKNOWN
    }

    /* loaded from: classes.dex */
    public static class OverrideValue implements GeneratedValue {
        float mValue;

        public OverrideValue(float f) {
            this.mValue = f;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            return this.mValue;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x016d, code lost:
    
        if (r8.equals(com.baidu.platform.comapi.map.MapBundleKey.MapObjKey.OBJ_SL_VISI) == false) goto L105;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void applyAttribute(androidx.constraintlayout.core.state.State r8, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r9, androidx.constraintlayout.core.state.ConstraintReference r10, androidx.constraintlayout.core.parser.CLObject r11, java.lang.String r12) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 934
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.applyAttribute(androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.parser.CLObject, java.lang.String):void");
    }

    private static int indexOf(String str, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public static String lookForType(CLObject cLObject) throws CLParsingException {
        Iterator<String> it = cLObject.names().iterator();
        while (it.hasNext()) {
            if (it.next().equals("type")) {
                return cLObject.getString("type");
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        switch(r5) {
            case 0: goto L36;
            case 1: goto L35;
            case 2: goto L34;
            default: goto L33;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        r7.remove(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
    
        r7.remove(com.facebook.appevents.internal.ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        r7.remove("height");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0084, code lost:
    
        r7.remove("start");
        r7.remove("end");
        r7.remove("top");
        r7.remove("bottom");
        r7.remove("baseline");
        r7.remove(com.google.android.exoplayer2.text.ttml.TtmlNode.CENTER);
        r7.remove("centerHorizontally");
        r7.remove("centerVertically");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ad, code lost:
    
        r7.remove("visibility");
        r7.remove("alpha");
        r7.remove("pivotX");
        r7.remove("pivotY");
        r7.remove("rotationX");
        r7.remove("rotationY");
        r7.remove("rotationZ");
        r7.remove("scaleX");
        r7.remove("scaleY");
        r7.remove("translationX");
        r7.remove("translationY");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void override(androidx.constraintlayout.core.parser.CLObject r7, java.lang.String r8, androidx.constraintlayout.core.parser.CLObject r9) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = 1
            r1 = 0
            boolean r2 = r7.has(r8)
            if (r2 != 0) goto Ld
            r7.put(r8, r9)
            goto Le8
        Ld:
            androidx.constraintlayout.core.parser.CLObject r7 = r7.getObject(r8)
            java.util.ArrayList r8 = r9.names()
            java.util.Iterator r8 = r8.iterator()
        L19:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Le8
            java.lang.Object r2 = r8.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "clear"
            boolean r4 = r2.equals(r3)
            if (r4 != 0) goto L35
            androidx.constraintlayout.core.parser.CLElement r3 = r9.get(r2)
            r7.put(r2, r3)
            goto L19
        L35:
            androidx.constraintlayout.core.parser.CLArray r2 = r9.getArray(r3)
            r3 = 0
        L3a:
            int r4 = r2.size()
            if (r3 >= r4) goto L19
            java.lang.String r4 = r2.getStringOrNull(r3)
            if (r4 != 0) goto L48
            goto Le5
        L48:
            r5 = -1
            int r6 = r4.hashCode()
            switch(r6) {
                case -1727069561: goto L67;
                case -1606703562: goto L5c;
                case 414334925: goto L51;
                default: goto L50;
            }
        L50:
            goto L71
        L51:
            java.lang.String r6 = "dimensions"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L5a
            goto L71
        L5a:
            r5 = 2
            goto L71
        L5c:
            java.lang.String r6 = "constraints"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L65
            goto L71
        L65:
            r5 = 1
            goto L71
        L67:
            java.lang.String r6 = "transforms"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L70
            goto L71
        L70:
            r5 = 0
        L71:
            switch(r5) {
                case 0: goto Lad;
                case 1: goto L84;
                case 2: goto L78;
                default: goto L74;
            }
        L74:
            r7.remove(r4)
            goto Le5
        L78:
            java.lang.String r4 = "width"
            r7.remove(r4)
            java.lang.String r4 = "height"
            r7.remove(r4)
            goto Le5
        L84:
            java.lang.String r4 = "start"
            r7.remove(r4)
            java.lang.String r4 = "end"
            r7.remove(r4)
            java.lang.String r4 = "top"
            r7.remove(r4)
            java.lang.String r4 = "bottom"
            r7.remove(r4)
            java.lang.String r4 = "baseline"
            r7.remove(r4)
            java.lang.String r4 = "center"
            r7.remove(r4)
            java.lang.String r4 = "centerHorizontally"
            r7.remove(r4)
            java.lang.String r4 = "centerVertically"
            r7.remove(r4)
            goto Le5
        Lad:
            java.lang.String r4 = "visibility"
            r7.remove(r4)
            java.lang.String r4 = "alpha"
            r7.remove(r4)
            java.lang.String r4 = "pivotX"
            r7.remove(r4)
            java.lang.String r4 = "pivotY"
            r7.remove(r4)
            java.lang.String r4 = "rotationX"
            r7.remove(r4)
            java.lang.String r4 = "rotationY"
            r7.remove(r4)
            java.lang.String r4 = "rotationZ"
            r7.remove(r4)
            java.lang.String r4 = "scaleX"
            r7.remove(r4)
            java.lang.String r4 = "scaleY"
            r7.remove(r4)
            java.lang.String r4 = "translationX"
            r7.remove(r4)
            java.lang.String r4 = "translationY"
            r7.remove(r4)
        Le5:
            int r3 = r3 + r0
            goto L3a
        Le8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.override(androidx.constraintlayout.core.parser.CLObject, java.lang.String, androidx.constraintlayout.core.parser.CLObject):void");
    }

    public static void parseBarrier(State state, String str, CLObject cLObject) throws CLParsingException {
        char c;
        char c2;
        boolean isRtl = state.isRtl();
        BarrierReference barrier = state.barrier(str, State.Direction.END);
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            next.hashCode();
            switch (next.hashCode()) {
                case -1081309778:
                    if (next.equals("margin")) {
                        c = 0;
                        break;
                    }
                    break;
                case -962590849:
                    if (next.equals("direction")) {
                        c = 1;
                        break;
                    }
                    break;
                case -567445985:
                    if (next.equals("contains")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    float floatOrNaN = cLObject.getFloatOrNaN(next);
                    if (Float.isNaN(floatOrNaN)) {
                        break;
                    } else {
                        barrier.margin(Float.valueOf(toPix(state, floatOrNaN)));
                        break;
                    }
                case 1:
                    String string = cLObject.getString(next);
                    string.hashCode();
                    switch (string.hashCode()) {
                        case -1383228885:
                            if (string.equals("bottom")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 100571:
                            if (string.equals("end")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 115029:
                            if (string.equals("top")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 3317767:
                            if (string.equals("left")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 108511772:
                            if (string.equals("right")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 109757538:
                            if (string.equals("start")) {
                                c2 = 5;
                                break;
                            }
                            break;
                    }
                    c2 = 65535;
                    switch (c2) {
                        case 0:
                            barrier.setBarrierDirection(State.Direction.BOTTOM);
                            break;
                        case 1:
                            if (!isRtl) {
                                barrier.setBarrierDirection(State.Direction.RIGHT);
                                break;
                            } else {
                                barrier.setBarrierDirection(State.Direction.LEFT);
                                break;
                            }
                        case 2:
                            barrier.setBarrierDirection(State.Direction.TOP);
                            break;
                        case 3:
                            barrier.setBarrierDirection(State.Direction.LEFT);
                            break;
                        case 4:
                            barrier.setBarrierDirection(State.Direction.RIGHT);
                            break;
                        case 5:
                            if (!isRtl) {
                                barrier.setBarrierDirection(State.Direction.LEFT);
                                break;
                            } else {
                                barrier.setBarrierDirection(State.Direction.RIGHT);
                                break;
                            }
                    }
                case 2:
                    CLArray arrayOrNull = cLObject.getArrayOrNull(next);
                    if (arrayOrNull != null) {
                        for (int i = 0; i < arrayOrNull.size(); i++) {
                            barrier.add(state.constraints(arrayOrNull.get(i).content()));
                        }
                        break;
                    } else {
                        break;
                    }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0094 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void parseChain(int r6, androidx.constraintlayout.core.state.State r7, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r8, androidx.constraintlayout.core.parser.CLArray r9) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = 0
            r1 = 1
            if (r6 != 0) goto L9
            androidx.constraintlayout.core.state.helpers.HorizontalChainReference r6 = r7.horizontalChain()
            goto Ld
        L9:
            androidx.constraintlayout.core.state.helpers.VerticalChainReference r6 = r7.verticalChain()
        Ld:
            androidx.constraintlayout.core.parser.CLElement r2 = r9.get(r1)
            boolean r3 = r2 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r3 == 0) goto Lae
            androidx.constraintlayout.core.parser.CLArray r2 = (androidx.constraintlayout.core.parser.CLArray) r2
            int r3 = r2.size()
            if (r3 >= r1) goto L1f
            goto Lae
        L1f:
            r3 = 0
        L20:
            int r4 = r2.size()
            if (r3 >= r4) goto L33
            java.lang.String r4 = r2.getString(r3)
            java.lang.Object[] r5 = new java.lang.Object[r1]
            r5[r0] = r4
            r6.add(r5)
            int r3 = r3 + r1
            goto L20
        L33:
            int r2 = r9.size()
            r3 = 2
            if (r2 <= r3) goto Lae
            androidx.constraintlayout.core.parser.CLElement r9 = r9.get(r3)
            boolean r2 = r9 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r2 != 0) goto L43
            return
        L43:
            androidx.constraintlayout.core.parser.CLObject r9 = (androidx.constraintlayout.core.parser.CLObject) r9
            java.util.ArrayList r2 = r9.names()
            java.util.Iterator r2 = r2.iterator()
        L4d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto Lae
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            r3.hashCode()
            java.lang.String r4 = "style"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L68
            parseConstraint(r7, r8, r9, r6, r3)
            goto L4d
        L68:
            androidx.constraintlayout.core.parser.CLElement r3 = r9.get(r3)
            boolean r4 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r4 == 0) goto L85
            r4 = r3
            androidx.constraintlayout.core.parser.CLArray r4 = (androidx.constraintlayout.core.parser.CLArray) r4
            int r5 = r4.size()
            if (r5 <= r1) goto L85
            java.lang.String r3 = r4.getString(r0)
            float r4 = r4.getFloat(r1)
            r6.bias(r4)
            goto L89
        L85:
            java.lang.String r3 = r3.content()
        L89:
            r3.hashCode()
            java.lang.String r4 = "packed"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto La8
            java.lang.String r4 = "spread_inside"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto La2
            androidx.constraintlayout.core.state.State$Chain r3 = androidx.constraintlayout.core.state.State.Chain.SPREAD
            r6.style(r3)
            goto L4d
        La2:
            androidx.constraintlayout.core.state.State$Chain r3 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE
            r6.style(r3)
            goto L4d
        La8:
            androidx.constraintlayout.core.state.State$Chain r3 = androidx.constraintlayout.core.state.State.Chain.PACKED
            r6.style(r3)
            goto L4d
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseChain(int, androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLArray):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:33:0x009b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void parseChainType(java.lang.String r21, androidx.constraintlayout.core.state.State r22, java.lang.String r23, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r24, androidx.constraintlayout.core.parser.CLObject r25) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseChainType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    public static long parseColorString(String str) {
        if (str.startsWith(xoXoI.f2670oxoX)) {
            String substring = str.substring(1);
            if (substring.length() == 6) {
                substring = "FF" + substring;
            }
            return Long.parseLong(substring, 16);
        }
        return -1L;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public static void parseConstraint(androidx.constraintlayout.core.state.State r20, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r21, androidx.constraintlayout.core.parser.CLObject r22, androidx.constraintlayout.core.state.ConstraintReference r23, java.lang.String r24) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseConstraint(androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.ConstraintReference, java.lang.String):void");
    }

    public static void parseConstraintSets(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLObject object = cLObject.getObject(next);
            String stringOrNull = object.getStringOrNull("Extends");
            if (stringOrNull != null && !stringOrNull.isEmpty()) {
                String constraintSet = coreMotionScene.getConstraintSet(stringOrNull);
                if (constraintSet != null) {
                    CLObject parse = CLParser.parse(constraintSet);
                    ArrayList<String> names2 = object.names();
                    if (names2 != null) {
                        Iterator<String> it2 = names2.iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            CLElement cLElement = object.get(next2);
                            if (cLElement instanceof CLObject) {
                                override(parse, next2, (CLObject) cLElement);
                            }
                        }
                        coreMotionScene.setConstraintSetContent(next, parse.toJSON());
                    }
                }
            } else {
                coreMotionScene.setConstraintSetContent(next, object.toJSON());
            }
        }
    }

    public static void parseCustomProperties(CLObject cLObject, ConstraintReference constraintReference, String str) throws CLParsingException {
        ArrayList<String> names;
        CLObject objectOrNull = cLObject.getObjectOrNull(str);
        if (objectOrNull == null || (names = objectOrNull.names()) == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLElement cLElement = objectOrNull.get(next);
            if (cLElement instanceof CLNumber) {
                constraintReference.addCustomFloat(next, cLElement.getFloat());
            } else if (cLElement instanceof CLString) {
                long parseColorString = parseColorString(cLElement.content());
                if (parseColorString != -1) {
                    constraintReference.addCustomColor(next, (int) parseColorString);
                }
            }
        }
    }

    public static void parseDesignElementsJSON(String str, ArrayList<DesignElement> arrayList) throws CLParsingException {
        CLObject parse = CLParser.parse(str);
        ArrayList<String> names = parse.names();
        if (names != null && names.size() > 0) {
            String str2 = names.get(0);
            CLElement cLElement = parse.get(str2);
            str2.hashCode();
            if (!str2.equals("Design") || !(cLElement instanceof CLObject)) {
                return;
            }
            CLObject cLObject = (CLObject) cLElement;
            ArrayList<String> names2 = cLObject.names();
            for (int i = 0; i < names2.size(); i++) {
                String str3 = names2.get(i);
                CLObject cLObject2 = (CLObject) cLObject.get(str3);
                System.out.printf("element found " + str3 + "", new Object[0]);
                String stringOrNull = cLObject2.getStringOrNull("type");
                if (stringOrNull != null) {
                    HashMap hashMap = new HashMap();
                    int size = cLObject2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        CLKey cLKey = (CLKey) cLObject2.get(i);
                        String content = cLKey.content();
                        String content2 = cLKey.getValue().content();
                        if (content2 != null) {
                            hashMap.put(content, content2);
                        }
                    }
                    arrayList.add(new DesignElement(str2, stringOrNull, hashMap));
                }
            }
        }
    }

    public static Dimension parseDimension(CLObject cLObject, String str, State state, CorePixelDp corePixelDp) throws CLParsingException {
        CLElement cLElement = cLObject.get(str);
        Dimension createFixed = Dimension.createFixed(0);
        if (cLElement instanceof CLString) {
            return parseDimensionMode(cLElement.content());
        }
        if (cLElement instanceof CLNumber) {
            return Dimension.createFixed(state.convertDimension(Float.valueOf(corePixelDp.toPixels(cLObject.getFloat(str)))));
        }
        if (cLElement instanceof CLObject) {
            CLObject cLObject2 = (CLObject) cLElement;
            String stringOrNull = cLObject2.getStringOrNull("value");
            if (stringOrNull != null) {
                createFixed = parseDimensionMode(stringOrNull);
            }
            CLElement orNull = cLObject2.getOrNull("min");
            if (orNull != null) {
                if (orNull instanceof CLNumber) {
                    createFixed.min(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull).getFloat()))));
                } else if (orNull instanceof CLString) {
                    createFixed.min(Dimension.WRAP_DIMENSION);
                }
            }
            CLElement orNull2 = cLObject2.getOrNull("max");
            if (orNull2 != null) {
                if (orNull2 instanceof CLNumber) {
                    createFixed.max(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull2).getFloat()))));
                    return createFixed;
                }
                if (orNull2 instanceof CLString) {
                    createFixed.max(Dimension.WRAP_DIMENSION);
                    return createFixed;
                }
                return createFixed;
            }
            return createFixed;
        }
        return createFixed;
    }

    public static Dimension parseDimensionMode(String str) {
        Dimension createFixed = Dimension.createFixed(0);
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1460244870:
                if (str.equals("preferWrap")) {
                    c = 0;
                    break;
                }
                break;
            case -995424086:
                if (str.equals("parent")) {
                    c = 1;
                    break;
                }
                break;
            case -895684237:
                if (str.equals("spread")) {
                    c = 2;
                    break;
                }
                break;
            case 3657802:
                if (str.equals("wrap")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Dimension.createSuggested(Dimension.WRAP_DIMENSION);
            case 1:
                return Dimension.createParent();
            case 2:
                return Dimension.createSuggested(Dimension.SPREAD_DIMENSION);
            case 3:
                return Dimension.createWrap();
            default:
                if (str.endsWith("%")) {
                    return Dimension.createPercent(0, Float.parseFloat(str.substring(0, str.indexOf(37))) / 100.0f).suggested(0);
                }
                if (str.contains(":")) {
                    return Dimension.createRatio(str).suggested(Dimension.SPREAD_DIMENSION);
                }
                return createFixed;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0455 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03bf A[Catch: NumberFormatException -> 0x024b, TryCatch #1 {NumberFormatException -> 0x024b, blocks: (B:69:0x0234, B:71:0x0243, B:72:0x024e, B:74:0x0256, B:145:0x03b0, B:147:0x03bf, B:148:0x03c6, B:150:0x03ce), top: B:68:0x0234 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03ce A[Catch: NumberFormatException -> 0x024b, TRY_LEAVE, TryCatch #1 {NumberFormatException -> 0x024b, blocks: (B:69:0x0234, B:71:0x0243, B:72:0x024e, B:74:0x0256, B:145:0x03b0, B:147:0x03bf, B:148:0x03c6, B:150:0x03ce), top: B:68:0x0234 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0455 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0455 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0243 A[Catch: NumberFormatException -> 0x024b, TryCatch #1 {NumberFormatException -> 0x024b, blocks: (B:69:0x0234, B:71:0x0243, B:72:0x024e, B:74:0x0256, B:145:0x03b0, B:147:0x03bf, B:148:0x03c6, B:150:0x03ce), top: B:68:0x0234 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0256 A[Catch: NumberFormatException -> 0x024b, TRY_LEAVE, TryCatch #1 {NumberFormatException -> 0x024b, blocks: (B:69:0x0234, B:71:0x0243, B:72:0x024e, B:74:0x0256, B:145:0x03b0, B:147:0x03bf, B:148:0x03c6, B:150:0x03ce), top: B:68:0x0234 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0455 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void parseFlowType(java.lang.String r17, androidx.constraintlayout.core.state.State r18, java.lang.String r19, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r20, androidx.constraintlayout.core.parser.CLObject r21) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 1222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseFlowType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    public static void parseGenerate(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLElement cLElement = cLObject.get(next);
            ArrayList<String> list = layoutVariables.getList(next);
            if (list != null && (cLElement instanceof CLObject)) {
                Iterator<String> it2 = list.iterator();
                while (it2.hasNext()) {
                    parseWidget(state, layoutVariables, it2.next(), (CLObject) cLElement);
                }
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0028. Please report as an issue. */
    private static void parseGridType(String str, State state, String str2, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        float f;
        float f2;
        float f3;
        float f4;
        int i;
        CLElement cLElement;
        GridReference grid = state.getGrid(str2, str);
        Iterator<String> it = cLObject.names().iterator();
        while (it.hasNext()) {
            String next = it.next();
            next.hashCode();
            char c = 65535;
            switch (next.hashCode()) {
                case -1439500848:
                    if (next.equals(bn.f.V)) {
                        c = 0;
                        break;
                    }
                    break;
                case -806339567:
                    if (next.equals("padding")) {
                        c = 1;
                        break;
                    }
                    break;
                case -567445985:
                    if (next.equals("contains")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3169614:
                    if (next.equals("hGap")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3506649:
                    if (next.equals("rows")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3586688:
                    if (next.equals("vGap")) {
                        c = 5;
                        break;
                    }
                    break;
                case 97513095:
                    if (next.equals(bn.f.y)) {
                        c = 6;
                        break;
                    }
                    break;
                case 109497044:
                    if (next.equals("skips")) {
                        c = 7;
                        break;
                    }
                    break;
                case 109638249:
                    if (next.equals("spans")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 144441793:
                    if (next.equals("rowWeights")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 949721053:
                    if (next.equals("columns")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 2033353925:
                    if (next.equals("columnWeights")) {
                        c = 11;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    grid.setOrientation(cLObject.get(next).getInt());
                    break;
                case 1:
                    CLElement cLElement2 = cLObject.get(next);
                    if (cLElement2 instanceof CLArray) {
                        CLArray cLArray = (CLArray) cLElement2;
                        if (cLArray.size() > 1) {
                            f = cLArray.getInt(0);
                            f4 = cLArray.getInt(1);
                            if (cLArray.size() > 2) {
                                f3 = cLArray.getInt(2);
                                try {
                                    f2 = ((CLArray) cLElement2).getInt(3);
                                } catch (ArrayIndexOutOfBoundsException unused) {
                                    f2 = 0.0f;
                                }
                            } else {
                                f3 = f;
                                f2 = f4;
                            }
                            grid.setPaddingStart(Math.round(toPix(state, f)));
                            grid.setPaddingTop(Math.round(toPix(state, f4)));
                            grid.setPaddingEnd(Math.round(toPix(state, f3)));
                            grid.setPaddingBottom(Math.round(toPix(state, f2)));
                            break;
                        }
                    }
                    f = cLElement2.getInt();
                    f2 = f;
                    f3 = f2;
                    f4 = f3;
                    grid.setPaddingStart(Math.round(toPix(state, f)));
                    grid.setPaddingTop(Math.round(toPix(state, f4)));
                    grid.setPaddingEnd(Math.round(toPix(state, f3)));
                    grid.setPaddingBottom(Math.round(toPix(state, f2)));
                case 2:
                    CLArray arrayOrNull = cLObject.getArrayOrNull(next);
                    if (arrayOrNull != null) {
                        for (int i2 = 0; i2 < arrayOrNull.size(); i2++) {
                            grid.add(state.constraints(arrayOrNull.get(i2).content()));
                        }
                        break;
                    } else {
                        break;
                    }
                case 3:
                    grid.setHorizontalGaps(toPix(state, cLObject.get(next).getFloat()));
                    break;
                case 4:
                    int i3 = cLObject.get(next).getInt();
                    if (i3 > 0) {
                        grid.setRowsSet(i3);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    grid.setVerticalGaps(toPix(state, cLObject.get(next).getFloat()));
                    break;
                case 6:
                    String str3 = "";
                    try {
                        cLElement = cLObject.get(next);
                    } catch (Exception e) {
                        System.err.println("Error parsing grid flags " + e);
                    }
                    if (cLElement instanceof CLNumber) {
                        i = cLElement.getInt();
                        if (str3 == null && !str3.isEmpty()) {
                            grid.setFlags(str3);
                            break;
                        } else {
                            grid.setFlags(i);
                            break;
                        }
                    } else {
                        str3 = cLElement.content();
                        i = 0;
                        if (str3 == null) {
                        }
                        grid.setFlags(i);
                    }
                case 7:
                    String content = cLObject.get(next).content();
                    if (content != null && content.contains(":")) {
                        grid.setSkips(content);
                        break;
                    }
                    break;
                case '\b':
                    String content2 = cLObject.get(next).content();
                    if (content2 != null && content2.contains(":")) {
                        grid.setSpans(content2);
                        break;
                    }
                    break;
                case '\t':
                    String content3 = cLObject.get(next).content();
                    if (content3 != null && content3.contains(",")) {
                        grid.setRowWeights(content3);
                        break;
                    }
                    break;
                case '\n':
                    int i4 = cLObject.get(next).getInt();
                    if (i4 > 0) {
                        grid.setColumnsSet(i4);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    String content4 = cLObject.get(next).content();
                    if (content4 != null && content4.contains(",")) {
                        grid.setColumnWeights(content4);
                        break;
                    }
                    break;
                default:
                    applyAttribute(state, layoutVariables, state.constraints(str2), cLObject, next);
                    break;
            }
        }
    }

    public static void parseGuideline(int i, State state, CLArray cLArray) throws CLParsingException {
        CLObject cLObject;
        String stringOrNull;
        CLElement cLElement = cLArray.get(1);
        if (!(cLElement instanceof CLObject) || (stringOrNull = (cLObject = (CLObject) cLElement).getStringOrNull("id")) == null) {
            return;
        }
        parseGuidelineParams(i, state, stringOrNull, cLObject);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0087. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:43:0x0104. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void parseGuidelineParams(int r18, androidx.constraintlayout.core.state.State r19, java.lang.String r20, androidx.constraintlayout.core.parser.CLObject r21) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseGuidelineParams(int, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.parser.CLObject):void");
    }

    public static void parseHeader(CoreMotionScene coreMotionScene, CLObject cLObject) {
        String stringOrNull = cLObject.getStringOrNull("export");
        if (stringOrNull != null) {
            coreMotionScene.setDebugName(stringOrNull);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0025. Please report as an issue. */
    public static void parseHelpers(State state, LayoutVariables layoutVariables, CLArray cLArray) throws CLParsingException {
        for (int i = 0; i < cLArray.size(); i++) {
            CLElement cLElement = cLArray.get(i);
            if (cLElement instanceof CLArray) {
                CLArray cLArray2 = (CLArray) cLElement;
                if (cLArray2.size() > 1) {
                    String string = cLArray2.getString(0);
                    string.hashCode();
                    char c = 65535;
                    switch (string.hashCode()) {
                        case -1785507558:
                            if (string.equals("vGuideline")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1252464839:
                            if (string.equals("hChain")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -851656725:
                            if (string.equals("vChain")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 965681512:
                            if (string.equals("hGuideline")) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            parseGuideline(1, state, cLArray2);
                            break;
                        case 1:
                            parseChain(0, state, layoutVariables, cLArray2);
                            break;
                        case 2:
                            parseChain(1, state, layoutVariables, cLArray2);
                            break;
                        case 3:
                            parseGuideline(0, state, cLArray2);
                            break;
                    }
                }
            }
        }
    }

    public static void parseJSON(String str, Transition transition, int i) {
        CLObject objectOrNull;
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names == null) {
                return;
            }
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                String next = it.next();
                CLElement cLElement = parse.get(next);
                if ((cLElement instanceof CLObject) && (objectOrNull = ((CLObject) cLElement).getObjectOrNull("custom")) != null) {
                    Iterator<String> it2 = objectOrNull.names().iterator();
                    while (it2.hasNext()) {
                        String next2 = it2.next();
                        CLElement cLElement2 = objectOrNull.get(next2);
                        if (cLElement2 instanceof CLNumber) {
                            transition.addCustomFloat(i, next, next2, cLElement2.getFloat());
                        } else if (cLElement2 instanceof CLString) {
                            long parseColorString = parseColorString(cLElement2.content());
                            if (parseColorString != -1) {
                                transition.addCustomColor(i, next, next2, (int) parseColorString);
                            }
                        }
                    }
                }
            }
        } catch (CLParsingException e) {
            System.err.println("Error parsing JSON " + e);
        }
    }

    private static void parseMotionProperties(CLElement cLElement, ConstraintReference constraintReference) throws CLParsingException {
        char c;
        if (!(cLElement instanceof CLObject)) {
            return;
        }
        CLObject cLObject = (CLObject) cLElement;
        TypedBundle typedBundle = new TypedBundle();
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            next.hashCode();
            switch (next.hashCode()) {
                case -1897525331:
                    if (next.equals("stagger")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1310311125:
                    if (next.equals("easing")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1285003983:
                    if (next.equals("quantize")) {
                        c = 2;
                        break;
                    }
                    break;
                case -791482387:
                    if (next.equals("pathArc")) {
                        c = 3;
                        break;
                    }
                    break;
                case -236944793:
                    if (next.equals("relativeTo")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    typedBundle.add(600, cLObject.getFloat(next));
                    break;
                case 1:
                    typedBundle.add(603, cLObject.getString(next));
                    break;
                case 2:
                    CLElement cLElement2 = cLObject.get(next);
                    if (cLElement2 instanceof CLArray) {
                        CLArray cLArray = (CLArray) cLElement2;
                        int size = cLArray.size();
                        if (size <= 0) {
                            break;
                        } else {
                            typedBundle.add(610, cLArray.getInt(0));
                            if (size <= 1) {
                                break;
                            } else {
                                typedBundle.add(611, cLArray.getString(1));
                                if (size <= 2) {
                                    break;
                                } else {
                                    typedBundle.add(602, cLArray.getFloat(2));
                                    break;
                                }
                            }
                        }
                    } else {
                        typedBundle.add(610, cLObject.getInt(next));
                        break;
                    }
                case 3:
                    String string = cLObject.getString(next);
                    int indexOf = indexOf(string, "none", "startVertical", "startHorizontal", "flip", "below", "above");
                    if (indexOf == -1) {
                        System.err.println(cLObject.getLine() + " pathArc = '" + string + "'");
                        break;
                    } else {
                        typedBundle.add(TypedValues.MotionType.TYPE_PATHMOTION_ARC, indexOf);
                        break;
                    }
                case 4:
                    typedBundle.add(TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, cLObject.getString(next));
                    break;
            }
        }
        constraintReference.mMotionProperties = typedBundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void parseMotionSceneJSON(androidx.constraintlayout.core.state.CoreMotionScene r7, java.lang.String r8) {
        /*
            androidx.constraintlayout.core.parser.CLObject r8 = androidx.constraintlayout.core.parser.CLParser.parse(r8)     // Catch: androidx.constraintlayout.core.parser.CLParsingException -> L45
            java.util.ArrayList r0 = r8.names()     // Catch: androidx.constraintlayout.core.parser.CLParsingException -> L45
            if (r0 != 0) goto Lb
            return
        Lb:
            java.util.Iterator r0 = r0.iterator()     // Catch: androidx.constraintlayout.core.parser.CLParsingException -> L45
        Lf:
            boolean r1 = r0.hasNext()     // Catch: androidx.constraintlayout.core.parser.CLParsingException -> L45
            if (r1 == 0) goto L85
            java.lang.Object r1 = r0.next()     // Catch: androidx.constraintlayout.core.parser.CLParsingException -> L45
            java.lang.String r1 = (java.lang.String) r1     // Catch: androidx.constraintlayout.core.parser.CLParsingException -> L45
            androidx.constraintlayout.core.parser.CLElement r2 = r8.get(r1)     // Catch: androidx.constraintlayout.core.parser.CLParsingException -> L45
            boolean r3 = r2 instanceof androidx.constraintlayout.core.parser.CLObject     // Catch: androidx.constraintlayout.core.parser.CLParsingException -> L45
            if (r3 == 0) goto Lf
            androidx.constraintlayout.core.parser.CLObject r2 = (androidx.constraintlayout.core.parser.CLObject) r2     // Catch: androidx.constraintlayout.core.parser.CLParsingException -> L45
            int r3 = r1.hashCode()     // Catch: androidx.constraintlayout.core.parser.CLParsingException -> L45
            r4 = -2137403731(0xffffffff8099cead, float:-1.4124972E-38)
            r5 = 2
            r6 = 1
            if (r3 == r4) goto L51
            r4 = -241441378(0xfffffffff19be59e, float:-1.5439285E30)
            if (r3 == r4) goto L47
            r4 = 1101852654(0x41acefee, float:21.617153)
            if (r3 == r4) goto L3b
            goto L5b
        L3b:
            java.lang.String r3 = "ConstraintSets"
            boolean r1 = r1.equals(r3)     // Catch: androidx.constraintlayout.core.parser.CLParsingException -> L45
            if (r1 == 0) goto L5b
            r1 = 0
            goto L5c
        L45:
            r7 = move-exception
            goto L6f
        L47:
            java.lang.String r3 = "Transitions"
            boolean r1 = r1.equals(r3)     // Catch: androidx.constraintlayout.core.parser.CLParsingException -> L45
            if (r1 == 0) goto L5b
            r1 = 1
            goto L5c
        L51:
            java.lang.String r3 = "Header"
            boolean r1 = r1.equals(r3)     // Catch: androidx.constraintlayout.core.parser.CLParsingException -> L45
            if (r1 == 0) goto L5b
            r1 = 2
            goto L5c
        L5b:
            r1 = -1
        L5c:
            if (r1 == 0) goto L6b
            if (r1 == r6) goto L67
            if (r1 == r5) goto L63
            goto Lf
        L63:
            parseHeader(r7, r2)     // Catch: androidx.constraintlayout.core.parser.CLParsingException -> L45
            goto Lf
        L67:
            parseTransitions(r7, r2)     // Catch: androidx.constraintlayout.core.parser.CLParsingException -> L45
            goto Lf
        L6b:
            parseConstraintSets(r7, r2)     // Catch: androidx.constraintlayout.core.parser.CLParsingException -> L45
            goto Lf
        L6f:
            java.io.PrintStream r8 = java.lang.System.err
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error parsing JSON "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.println(r7)
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseMotionSceneJSON(androidx.constraintlayout.core.state.CoreMotionScene, java.lang.String):void");
    }

    public static void parseTransitions(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            coreMotionScene.setTransitionContent(next, cLObject.getObject(next).toJSON());
        }
    }

    private static void parseVariables(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLElement cLElement = cLObject.get(next);
            if (cLElement instanceof CLNumber) {
                layoutVariables.put(next, cLElement.getInt());
            } else if (cLElement instanceof CLObject) {
                CLObject cLObject2 = (CLObject) cLElement;
                if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has("to")) {
                    layoutVariables.put(next, layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_FROM)), layoutVariables.get(cLObject2.get("to")), 1.0f, cLObject2.getStringOrNull(RequestParameters.PREFIX), cLObject2.getStringOrNull("postfix"));
                } else if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has("step")) {
                    layoutVariables.put(next, layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_FROM)), layoutVariables.get(cLObject2.get("step")));
                } else if (cLObject2.has("ids")) {
                    CLArray array = cLObject2.getArray("ids");
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (int i = 0; i < array.size(); i++) {
                        arrayList.add(array.getString(i));
                    }
                    layoutVariables.put(next, arrayList);
                } else if (cLObject2.has("tag")) {
                    layoutVariables.put(next, state.getIdsForTag(cLObject2.getString("tag")));
                }
            }
        }
    }

    public static void parseWidget(State state, LayoutVariables layoutVariables, String str, CLObject cLObject) throws CLParsingException {
        parseWidget(state, layoutVariables, state.constraints(str), cLObject);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void populateState(@NonNull CLObject cLObject, @NonNull State state, @NonNull LayoutVariables layoutVariables) throws CLParsingException {
        char c;
        char c2;
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLElement cLElement = cLObject.get(next);
            next.hashCode();
            switch (next.hashCode()) {
                case -1824489883:
                    if (next.equals("Helpers")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1875016085:
                    if (next.equals("Generate")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1921490263:
                    if (next.equals("Variables")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    if (!(cLElement instanceof CLArray)) {
                        break;
                    } else {
                        parseHelpers(state, layoutVariables, (CLArray) cLElement);
                        break;
                    }
                case 1:
                    if (!(cLElement instanceof CLObject)) {
                        break;
                    } else {
                        parseGenerate(state, layoutVariables, (CLObject) cLElement);
                        break;
                    }
                case 2:
                    if (!(cLElement instanceof CLObject)) {
                        break;
                    } else {
                        parseVariables(state, layoutVariables, (CLObject) cLElement);
                        break;
                    }
                default:
                    if (cLElement instanceof CLObject) {
                        CLObject cLObject2 = (CLObject) cLElement;
                        String lookForType = lookForType(cLObject2);
                        if (lookForType != null) {
                            switch (lookForType.hashCode()) {
                                case -1785507558:
                                    if (lookForType.equals("vGuideline")) {
                                        c2 = 0;
                                        break;
                                    }
                                    break;
                                case -1354837162:
                                    if (lookForType.equals(XXooOOI.oIX0oI.f4124x0xO0oo)) {
                                        c2 = 1;
                                        break;
                                    }
                                    break;
                                case -1252464839:
                                    if (lookForType.equals("hChain")) {
                                        c2 = 2;
                                        break;
                                    }
                                    break;
                                case -851656725:
                                    if (lookForType.equals("vChain")) {
                                        c2 = 3;
                                        break;
                                    }
                                    break;
                                case -333143113:
                                    if (lookForType.equals("barrier")) {
                                        c2 = 4;
                                        break;
                                    }
                                    break;
                                case 113114:
                                    if (lookForType.equals(WorkoutExercises.ROW)) {
                                        c2 = 5;
                                        break;
                                    }
                                    break;
                                case 3181382:
                                    if (lookForType.equals("grid")) {
                                        c2 = 6;
                                        break;
                                    }
                                    break;
                                case 98238902:
                                    if (lookForType.equals("hFlow")) {
                                        c2 = 7;
                                        break;
                                    }
                                    break;
                                case 111168196:
                                    if (lookForType.equals("vFlow")) {
                                        c2 = '\b';
                                        break;
                                    }
                                    break;
                                case 965681512:
                                    if (lookForType.equals("hGuideline")) {
                                        c2 = '\t';
                                        break;
                                    }
                                    break;
                            }
                            c2 = 65535;
                            switch (c2) {
                                case 0:
                                    parseGuidelineParams(1, state, next, cLObject2);
                                    break;
                                case 1:
                                case 5:
                                case 6:
                                    parseGridType(lookForType, state, next, layoutVariables, cLObject2);
                                    break;
                                case 2:
                                case 3:
                                    parseChainType(lookForType, state, next, layoutVariables, cLObject2);
                                    break;
                                case 4:
                                    parseBarrier(state, next, cLObject2);
                                    break;
                                case 7:
                                case '\b':
                                    parseFlowType(lookForType, state, next, layoutVariables, cLObject2);
                                    break;
                                case '\t':
                                    parseGuidelineParams(0, state, next, cLObject2);
                                    break;
                            }
                        } else {
                            parseWidget(state, layoutVariables, next, cLObject2);
                            break;
                        }
                    } else if (!(cLElement instanceof CLNumber)) {
                        break;
                    } else {
                        layoutVariables.put(next, cLElement.getInt());
                        break;
                    }
            }
        }
    }

    private static float toPix(State state, float f) {
        return state.getDpToPixel().toPixels(f);
    }

    public static void parseWidget(State state, LayoutVariables layoutVariables, ConstraintReference constraintReference, CLObject cLObject) throws CLParsingException {
        if (constraintReference.getWidth() == null) {
            constraintReference.setWidth(Dimension.createWrap());
        }
        if (constraintReference.getHeight() == null) {
            constraintReference.setHeight(Dimension.createWrap());
        }
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            applyAttribute(state, layoutVariables, constraintReference, cLObject, it.next());
        }
    }

    public static void parseJSON(String str, State state, LayoutVariables layoutVariables) throws CLParsingException {
        try {
            populateState(CLParser.parse(str), state, layoutVariables);
        } catch (CLParsingException e) {
            System.err.println("Error parsing JSON " + e);
        }
    }
}
