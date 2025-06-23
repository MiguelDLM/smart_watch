package androidx.constraintlayout.core.state;

import OoOoXO0.xoXoI;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.parser.CLString;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ConstraintSetParser {
    private static final boolean PARSER_DEBUG = false;

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

    public static class FiniteGenerator implements GeneratedValue {
        float mCurrent = 0.0f;
        float mFrom;
        float mInitial;
        float mMax;
        String mPostfix;
        String mPrefix;
        float mStep;
        boolean mStop = false;
        float mTo;

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

    public interface GeneratedValue {
        float value();
    }

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

        public float value() {
            if (!this.mStop) {
                this.mCurrent += this.mIncrementBy;
            }
            return this.mCurrent;
        }
    }

    public static class LayoutVariables {
        HashMap<String, ArrayList<String>> mArrayIds = new HashMap<>();
        HashMap<String, GeneratedValue> mGenerators = new HashMap<>();
        HashMap<String, Integer> mMargins = new HashMap<>();

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
            } else if (obj instanceof CLNumber) {
                return ((CLNumber) obj).getFloat();
            } else {
                return 0.0f;
            }
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
            if (!this.mGenerators.containsKey(str) || !(this.mGenerators.get(str) instanceof OverrideValue)) {
                this.mGenerators.put(str, new Generator(f, f2));
            }
        }

        public void put(String str, float f, float f2, float f3, String str2, String str3) {
            if (!this.mGenerators.containsKey(str) || !(this.mGenerators.get(str) instanceof OverrideValue)) {
                FiniteGenerator finiteGenerator = new FiniteGenerator(f, f2, f3, str2, str3);
                this.mGenerators.put(str, finiteGenerator);
                this.mArrayIds.put(str, finiteGenerator.array());
            }
        }

        public void put(String str, ArrayList<String> arrayList) {
            this.mArrayIds.put(str, arrayList);
        }
    }

    public enum MotionLayoutDebugFlags {
        NONE,
        SHOW_ALL,
        UNKNOWN
    }

    public static class OverrideValue implements GeneratedValue {
        float mValue;

        public OverrideValue(float f) {
            this.mValue = f;
        }

        public float value() {
            return this.mValue;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x016d, code lost:
        if (r8.equals(com.baidu.platform.comapi.map.MapBundleKey.MapObjKey.OBJ_SL_VISI) == false) goto L_0x0164;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void applyAttribute(androidx.constraintlayout.core.state.State r8, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r9, androidx.constraintlayout.core.state.ConstraintReference r10, androidx.constraintlayout.core.parser.CLObject r11, java.lang.String r12) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = 8
            r1 = 4
            r2 = 2
            r3 = 1
            r4 = 0
            r12.hashCode()
            java.lang.String r5 = "parent"
            r6 = -1
            int r7 = r12.hashCode()
            switch(r7) {
                case -1448775240: goto L_0x0143;
                case -1364013995: goto L_0x0137;
                case -1349088399: goto L_0x012b;
                case -1249320806: goto L_0x011f;
                case -1249320805: goto L_0x0113;
                case -1249320804: goto L_0x0107;
                case -1225497657: goto L_0x00fb;
                case -1225497656: goto L_0x00ef;
                case -1225497655: goto L_0x00e1;
                case -1221029593: goto L_0x00d3;
                case -1068318794: goto L_0x00c5;
                case -987906986: goto L_0x00b7;
                case -987906985: goto L_0x00a9;
                case -908189618: goto L_0x009b;
                case -908189617: goto L_0x008d;
                case -247669061: goto L_0x0080;
                case -61505906: goto L_0x0073;
                case 92909918: goto L_0x0066;
                case 98116417: goto L_0x0059;
                case 111045711: goto L_0x004c;
                case 113126854: goto L_0x003e;
                case 398344448: goto L_0x0031;
                case 1404070310: goto L_0x0024;
                case 1941332754: goto L_0x0016;
                default: goto L_0x0013;
            }
        L_0x0013:
            r7 = -1
            goto L_0x014e
        L_0x0016:
            java.lang.String r7 = "visibility"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0020
            goto L_0x0013
        L_0x0020:
            r7 = 23
            goto L_0x014e
        L_0x0024:
            java.lang.String r7 = "centerHorizontally"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x002d
            goto L_0x0013
        L_0x002d:
            r7 = 22
            goto L_0x014e
        L_0x0031:
            java.lang.String r7 = "hWeight"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x003a
            goto L_0x0013
        L_0x003a:
            r7 = 21
            goto L_0x014e
        L_0x003e:
            java.lang.String r7 = "width"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0048
            goto L_0x0013
        L_0x0048:
            r7 = 20
            goto L_0x014e
        L_0x004c:
            java.lang.String r7 = "vBias"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0055
            goto L_0x0013
        L_0x0055:
            r7 = 19
            goto L_0x014e
        L_0x0059:
            java.lang.String r7 = "hBias"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0062
            goto L_0x0013
        L_0x0062:
            r7 = 18
            goto L_0x014e
        L_0x0066:
            java.lang.String r7 = "alpha"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x006f
            goto L_0x0013
        L_0x006f:
            r7 = 17
            goto L_0x014e
        L_0x0073:
            java.lang.String r7 = "vWeight"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x007c
            goto L_0x0013
        L_0x007c:
            r7 = 16
            goto L_0x014e
        L_0x0080:
            java.lang.String r7 = "hRtlBias"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0089
            goto L_0x0013
        L_0x0089:
            r7 = 15
            goto L_0x014e
        L_0x008d:
            java.lang.String r7 = "scaleY"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0097
            goto L_0x0013
        L_0x0097:
            r7 = 14
            goto L_0x014e
        L_0x009b:
            java.lang.String r7 = "scaleX"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x00a5
            goto L_0x0013
        L_0x00a5:
            r7 = 13
            goto L_0x014e
        L_0x00a9:
            java.lang.String r7 = "pivotY"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x00b3
            goto L_0x0013
        L_0x00b3:
            r7 = 12
            goto L_0x014e
        L_0x00b7:
            java.lang.String r7 = "pivotX"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x00c1
            goto L_0x0013
        L_0x00c1:
            r7 = 11
            goto L_0x014e
        L_0x00c5:
            java.lang.String r7 = "motion"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x00cf
            goto L_0x0013
        L_0x00cf:
            r7 = 10
            goto L_0x014e
        L_0x00d3:
            java.lang.String r7 = "height"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x00dd
            goto L_0x0013
        L_0x00dd:
            r7 = 9
            goto L_0x014e
        L_0x00e1:
            java.lang.String r7 = "translationZ"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x00eb
            goto L_0x0013
        L_0x00eb:
            r7 = 8
            goto L_0x014e
        L_0x00ef:
            java.lang.String r7 = "translationY"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x00f9
            goto L_0x0013
        L_0x00f9:
            r7 = 7
            goto L_0x014e
        L_0x00fb:
            java.lang.String r7 = "translationX"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0105
            goto L_0x0013
        L_0x0105:
            r7 = 6
            goto L_0x014e
        L_0x0107:
            java.lang.String r7 = "rotationZ"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0111
            goto L_0x0013
        L_0x0111:
            r7 = 5
            goto L_0x014e
        L_0x0113:
            java.lang.String r7 = "rotationY"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x011d
            goto L_0x0013
        L_0x011d:
            r7 = 4
            goto L_0x014e
        L_0x011f:
            java.lang.String r7 = "rotationX"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0129
            goto L_0x0013
        L_0x0129:
            r7 = 3
            goto L_0x014e
        L_0x012b:
            java.lang.String r7 = "custom"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0135
            goto L_0x0013
        L_0x0135:
            r7 = 2
            goto L_0x014e
        L_0x0137:
            java.lang.String r7 = "center"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0141
            goto L_0x0013
        L_0x0141:
            r7 = 1
            goto L_0x014e
        L_0x0143:
            java.lang.String r7 = "centerVertically"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x014d
            goto L_0x0013
        L_0x014d:
            r7 = 0
        L_0x014e:
            switch(r7) {
                case 0: goto L_0x02e0;
                case 1: goto L_0x02be;
                case 2: goto L_0x02ba;
                case 3: goto L_0x02ae;
                case 4: goto L_0x02a2;
                case 5: goto L_0x0296;
                case 6: goto L_0x0286;
                case 7: goto L_0x0275;
                case 8: goto L_0x0264;
                case 9: goto L_0x0257;
                case 10: goto L_0x024e;
                case 11: goto L_0x0241;
                case 12: goto L_0x0234;
                case 13: goto L_0x0227;
                case 14: goto L_0x021a;
                case 15: goto L_0x0203;
                case 16: goto L_0x01f6;
                case 17: goto L_0x01e9;
                case 18: goto L_0x01dc;
                case 19: goto L_0x01cf;
                case 20: goto L_0x01c2;
                case 21: goto L_0x01b5;
                case 22: goto L_0x019d;
                case 23: goto L_0x0156;
                default: goto L_0x0151;
            }
        L_0x0151:
            parseConstraint(r8, r9, r11, r10, r12)
            goto L_0x02f6
        L_0x0156:
            java.lang.String r8 = r11.getString((java.lang.String) r12)
            r8.hashCode()
            int r9 = r8.hashCode()
            switch(r9) {
                case -1901805651: goto L_0x017b;
                case 3178655: goto L_0x0170;
                case 466743410: goto L_0x0166;
                default: goto L_0x0164;
            }
        L_0x0164:
            r2 = -1
            goto L_0x0185
        L_0x0166:
            java.lang.String r9 = "visible"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0185
            goto L_0x0164
        L_0x0170:
            java.lang.String r9 = "gone"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0179
            goto L_0x0164
        L_0x0179:
            r2 = 1
            goto L_0x0185
        L_0x017b:
            java.lang.String r9 = "invisible"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0184
            goto L_0x0164
        L_0x0184:
            r2 = 0
        L_0x0185:
            switch(r2) {
                case 0: goto L_0x0194;
                case 1: goto L_0x018f;
                case 2: goto L_0x018a;
                default: goto L_0x0188;
            }
        L_0x0188:
            goto L_0x02f6
        L_0x018a:
            r10.visibility(r4)
            goto L_0x02f6
        L_0x018f:
            r10.visibility(r0)
            goto L_0x02f6
        L_0x0194:
            r10.visibility(r1)
            r8 = 0
            r10.alpha(r8)
            goto L_0x02f6
        L_0x019d:
            java.lang.String r9 = r11.getString((java.lang.String) r12)
            boolean r11 = r9.equals(r5)
            if (r11 == 0) goto L_0x01a9
            java.lang.Integer r9 = androidx.constraintlayout.core.state.State.PARENT
        L_0x01a9:
            androidx.constraintlayout.core.state.ConstraintReference r8 = r8.constraints(r9)
            r10.startToStart(r8)
            r10.endToEnd(r8)
            goto L_0x02f6
        L_0x01b5:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.setHorizontalChainWeight(r8)
            goto L_0x02f6
        L_0x01c2:
            androidx.constraintlayout.core.state.CorePixelDp r9 = r8.getDpToPixel()
            androidx.constraintlayout.core.state.Dimension r8 = parseDimension(r11, r12, r8, r9)
            r10.setWidth(r8)
            goto L_0x02f6
        L_0x01cf:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.verticalBias(r8)
            goto L_0x02f6
        L_0x01dc:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.horizontalBias(r8)
            goto L_0x02f6
        L_0x01e9:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.alpha(r8)
            goto L_0x02f6
        L_0x01f6:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.setVerticalChainWeight(r8)
            goto L_0x02f6
        L_0x0203:
            androidx.constraintlayout.core.parser.CLElement r11 = r11.get((java.lang.String) r12)
            float r9 = r9.get(r11)
            boolean r8 = r8.isRtl()
            if (r8 == 0) goto L_0x0215
            r8 = 1065353216(0x3f800000, float:1.0)
            float r9 = r8 - r9
        L_0x0215:
            r10.horizontalBias(r9)
            goto L_0x02f6
        L_0x021a:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.scaleY(r8)
            goto L_0x02f6
        L_0x0227:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.scaleX(r8)
            goto L_0x02f6
        L_0x0234:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.pivotY(r8)
            goto L_0x02f6
        L_0x0241:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.pivotX(r8)
            goto L_0x02f6
        L_0x024e:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            parseMotionProperties(r8, r10)
            goto L_0x02f6
        L_0x0257:
            androidx.constraintlayout.core.state.CorePixelDp r9 = r8.getDpToPixel()
            androidx.constraintlayout.core.state.Dimension r8 = parseDimension(r11, r12, r8, r9)
            r10.setHeight(r8)
            goto L_0x02f6
        L_0x0264:
            androidx.constraintlayout.core.parser.CLElement r11 = r11.get((java.lang.String) r12)
            float r9 = r9.get(r11)
            float r8 = toPix(r8, r9)
            r10.translationZ(r8)
            goto L_0x02f6
        L_0x0275:
            androidx.constraintlayout.core.parser.CLElement r11 = r11.get((java.lang.String) r12)
            float r9 = r9.get(r11)
            float r8 = toPix(r8, r9)
            r10.translationY(r8)
            goto L_0x02f6
        L_0x0286:
            androidx.constraintlayout.core.parser.CLElement r11 = r11.get((java.lang.String) r12)
            float r9 = r9.get(r11)
            float r8 = toPix(r8, r9)
            r10.translationX(r8)
            goto L_0x02f6
        L_0x0296:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.rotationZ(r8)
            goto L_0x02f6
        L_0x02a2:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.rotationY(r8)
            goto L_0x02f6
        L_0x02ae:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.rotationX(r8)
            goto L_0x02f6
        L_0x02ba:
            parseCustomProperties(r11, r10, r12)
            goto L_0x02f6
        L_0x02be:
            java.lang.String r9 = r11.getString((java.lang.String) r12)
            boolean r11 = r9.equals(r5)
            if (r11 == 0) goto L_0x02cf
            java.lang.Integer r9 = androidx.constraintlayout.core.state.State.PARENT
            androidx.constraintlayout.core.state.ConstraintReference r8 = r8.constraints(r9)
            goto L_0x02d3
        L_0x02cf:
            androidx.constraintlayout.core.state.ConstraintReference r8 = r8.constraints(r9)
        L_0x02d3:
            r10.startToStart(r8)
            r10.endToEnd(r8)
            r10.topToTop(r8)
            r10.bottomToBottom(r8)
            goto L_0x02f6
        L_0x02e0:
            java.lang.String r9 = r11.getString((java.lang.String) r12)
            boolean r11 = r9.equals(r5)
            if (r11 == 0) goto L_0x02ec
            java.lang.Integer r9 = androidx.constraintlayout.core.state.State.PARENT
        L_0x02ec:
            androidx.constraintlayout.core.state.ConstraintReference r8 = r8.constraints(r9)
            r10.topToTop(r8)
            r10.bottomToBottom(r8)
        L_0x02f6:
            return
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

    public static void override(CLObject cLObject, String str, CLObject cLObject2) throws CLParsingException {
        if (!cLObject.has(str)) {
            cLObject.put(str, cLObject2);
            return;
        }
        CLObject object = cLObject.getObject(str);
        Iterator<String> it = cLObject2.names().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!next.equals("clear")) {
                object.put(next, cLObject2.get(next));
            } else {
                CLArray array = cLObject2.getArray("clear");
                for (int i = 0; i < array.size(); i++) {
                    String stringOrNull = array.getStringOrNull(i);
                    if (stringOrNull != null) {
                        char c = 65535;
                        switch (stringOrNull.hashCode()) {
                            case -1727069561:
                                if (stringOrNull.equals("transforms")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case -1606703562:
                                if (stringOrNull.equals("constraints")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 414334925:
                                if (stringOrNull.equals("dimensions")) {
                                    c = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                object.remove("visibility");
                                object.remove("alpha");
                                object.remove("pivotX");
                                object.remove("pivotY");
                                object.remove("rotationX");
                                object.remove("rotationY");
                                object.remove("rotationZ");
                                object.remove("scaleX");
                                object.remove("scaleY");
                                object.remove("translationX");
                                object.remove("translationY");
                                break;
                            case 1:
                                object.remove("start");
                                object.remove("end");
                                object.remove("top");
                                object.remove("bottom");
                                object.remove("baseline");
                                object.remove(TtmlNode.CENTER);
                                object.remove("centerHorizontally");
                                object.remove("centerVertically");
                                break;
                            case 2:
                                object.remove(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                                object.remove("height");
                                break;
                            default:
                                object.remove(stringOrNull);
                                break;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void parseBarrier(androidx.constraintlayout.core.state.State r10, java.lang.String r11, androidx.constraintlayout.core.parser.CLObject r12) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = 2
            r1 = -1
            r2 = 1
            r3 = 0
            boolean r4 = r10.isRtl()
            androidx.constraintlayout.core.state.State$Direction r5 = androidx.constraintlayout.core.state.State.Direction.END
            androidx.constraintlayout.core.state.helpers.BarrierReference r11 = r10.barrier(r11, r5)
            java.util.ArrayList r5 = r12.names()
            if (r5 != 0) goto L_0x0015
            return
        L_0x0015:
            java.util.Iterator r5 = r5.iterator()
        L_0x0019:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0120
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            r6.hashCode()
            int r7 = r6.hashCode()
            switch(r7) {
                case -1081309778: goto L_0x0047;
                case -962590849: goto L_0x003c;
                case -567445985: goto L_0x0031;
                default: goto L_0x002f;
            }
        L_0x002f:
            r7 = -1
            goto L_0x0051
        L_0x0031:
            java.lang.String r7 = "contains"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x003a
            goto L_0x002f
        L_0x003a:
            r7 = 2
            goto L_0x0051
        L_0x003c:
            java.lang.String r7 = "direction"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0045
            goto L_0x002f
        L_0x0045:
            r7 = 1
            goto L_0x0051
        L_0x0047:
            java.lang.String r7 = "margin"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0050
            goto L_0x002f
        L_0x0050:
            r7 = 0
        L_0x0051:
            switch(r7) {
                case 0: goto L_0x0109;
                case 1: goto L_0x0077;
                case 2: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x0019
        L_0x0055:
            androidx.constraintlayout.core.parser.CLArray r6 = r12.getArrayOrNull(r6)
            if (r6 == 0) goto L_0x0019
            r7 = 0
        L_0x005c:
            int r8 = r6.size()
            if (r7 >= r8) goto L_0x0019
            androidx.constraintlayout.core.parser.CLElement r8 = r6.get((int) r7)
            java.lang.String r8 = r8.content()
            androidx.constraintlayout.core.state.ConstraintReference r8 = r10.constraints(r8)
            java.lang.Object[] r9 = new java.lang.Object[r2]
            r9[r3] = r8
            r11.add(r9)
            int r7 = r7 + r2
            goto L_0x005c
        L_0x0077:
            java.lang.String r6 = r12.getString((java.lang.String) r6)
            r6.hashCode()
            int r7 = r6.hashCode()
            switch(r7) {
                case -1383228885: goto L_0x00be;
                case 100571: goto L_0x00b3;
                case 115029: goto L_0x00a8;
                case 3317767: goto L_0x009d;
                case 108511772: goto L_0x0092;
                case 109757538: goto L_0x0087;
                default: goto L_0x0085;
            }
        L_0x0085:
            r6 = -1
            goto L_0x00c8
        L_0x0087:
            java.lang.String r7 = "start"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0090
            goto L_0x0085
        L_0x0090:
            r6 = 5
            goto L_0x00c8
        L_0x0092:
            java.lang.String r7 = "right"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x009b
            goto L_0x0085
        L_0x009b:
            r6 = 4
            goto L_0x00c8
        L_0x009d:
            java.lang.String r7 = "left"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00a6
            goto L_0x0085
        L_0x00a6:
            r6 = 3
            goto L_0x00c8
        L_0x00a8:
            java.lang.String r7 = "top"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00b1
            goto L_0x0085
        L_0x00b1:
            r6 = 2
            goto L_0x00c8
        L_0x00b3:
            java.lang.String r7 = "end"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00bc
            goto L_0x0085
        L_0x00bc:
            r6 = 1
            goto L_0x00c8
        L_0x00be:
            java.lang.String r7 = "bottom"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00c7
            goto L_0x0085
        L_0x00c7:
            r6 = 0
        L_0x00c8:
            switch(r6) {
                case 0: goto L_0x0102;
                case 1: goto L_0x00f2;
                case 2: goto L_0x00eb;
                case 3: goto L_0x00e4;
                case 4: goto L_0x00dd;
                case 5: goto L_0x00cd;
                default: goto L_0x00cb;
            }
        L_0x00cb:
            goto L_0x0019
        L_0x00cd:
            if (r4 != 0) goto L_0x00d6
            androidx.constraintlayout.core.state.State$Direction r6 = androidx.constraintlayout.core.state.State.Direction.LEFT
            r11.setBarrierDirection(r6)
            goto L_0x0019
        L_0x00d6:
            androidx.constraintlayout.core.state.State$Direction r6 = androidx.constraintlayout.core.state.State.Direction.RIGHT
            r11.setBarrierDirection(r6)
            goto L_0x0019
        L_0x00dd:
            androidx.constraintlayout.core.state.State$Direction r6 = androidx.constraintlayout.core.state.State.Direction.RIGHT
            r11.setBarrierDirection(r6)
            goto L_0x0019
        L_0x00e4:
            androidx.constraintlayout.core.state.State$Direction r6 = androidx.constraintlayout.core.state.State.Direction.LEFT
            r11.setBarrierDirection(r6)
            goto L_0x0019
        L_0x00eb:
            androidx.constraintlayout.core.state.State$Direction r6 = androidx.constraintlayout.core.state.State.Direction.TOP
            r11.setBarrierDirection(r6)
            goto L_0x0019
        L_0x00f2:
            if (r4 != 0) goto L_0x00fb
            androidx.constraintlayout.core.state.State$Direction r6 = androidx.constraintlayout.core.state.State.Direction.RIGHT
            r11.setBarrierDirection(r6)
            goto L_0x0019
        L_0x00fb:
            androidx.constraintlayout.core.state.State$Direction r6 = androidx.constraintlayout.core.state.State.Direction.LEFT
            r11.setBarrierDirection(r6)
            goto L_0x0019
        L_0x0102:
            androidx.constraintlayout.core.state.State$Direction r6 = androidx.constraintlayout.core.state.State.Direction.BOTTOM
            r11.setBarrierDirection(r6)
            goto L_0x0019
        L_0x0109:
            float r6 = r12.getFloatOrNaN(r6)
            boolean r7 = java.lang.Float.isNaN(r6)
            if (r7 != 0) goto L_0x0019
            float r6 = toPix(r10, r6)
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            r11.margin((java.lang.Object) r6)
            goto L_0x0019
        L_0x0120:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseBarrier(androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.parser.CLObject):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void parseChain(int r6, androidx.constraintlayout.core.state.State r7, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r8, androidx.constraintlayout.core.parser.CLArray r9) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = 0
            r1 = 1
            if (r6 != 0) goto L_0x0009
            androidx.constraintlayout.core.state.helpers.HorizontalChainReference r6 = r7.horizontalChain()
            goto L_0x000d
        L_0x0009:
            androidx.constraintlayout.core.state.helpers.VerticalChainReference r6 = r7.verticalChain()
        L_0x000d:
            androidx.constraintlayout.core.parser.CLElement r2 = r9.get((int) r1)
            boolean r3 = r2 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r3 == 0) goto L_0x00ae
            androidx.constraintlayout.core.parser.CLArray r2 = (androidx.constraintlayout.core.parser.CLArray) r2
            int r3 = r2.size()
            if (r3 >= r1) goto L_0x001f
            goto L_0x00ae
        L_0x001f:
            r3 = 0
        L_0x0020:
            int r4 = r2.size()
            if (r3 >= r4) goto L_0x0033
            java.lang.String r4 = r2.getString((int) r3)
            java.lang.Object[] r5 = new java.lang.Object[r1]
            r5[r0] = r4
            r6.add(r5)
            int r3 = r3 + r1
            goto L_0x0020
        L_0x0033:
            int r2 = r9.size()
            r3 = 2
            if (r2 <= r3) goto L_0x00ae
            androidx.constraintlayout.core.parser.CLElement r9 = r9.get((int) r3)
            boolean r2 = r9 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r2 != 0) goto L_0x0043
            return
        L_0x0043:
            androidx.constraintlayout.core.parser.CLObject r9 = (androidx.constraintlayout.core.parser.CLObject) r9
            java.util.ArrayList r2 = r9.names()
            java.util.Iterator r2 = r2.iterator()
        L_0x004d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00ae
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            r3.hashCode()
            java.lang.String r4 = "style"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x0068
            parseConstraint(r7, r8, r9, r6, r3)
            goto L_0x004d
        L_0x0068:
            androidx.constraintlayout.core.parser.CLElement r3 = r9.get((java.lang.String) r3)
            boolean r4 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r4 == 0) goto L_0x0085
            r4 = r3
            androidx.constraintlayout.core.parser.CLArray r4 = (androidx.constraintlayout.core.parser.CLArray) r4
            int r5 = r4.size()
            if (r5 <= r1) goto L_0x0085
            java.lang.String r3 = r4.getString((int) r0)
            float r4 = r4.getFloat((int) r1)
            r6.bias((float) r4)
            goto L_0x0089
        L_0x0085:
            java.lang.String r3 = r3.content()
        L_0x0089:
            r3.hashCode()
            java.lang.String r4 = "packed"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x00a8
            java.lang.String r4 = "spread_inside"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00a2
            androidx.constraintlayout.core.state.State$Chain r3 = androidx.constraintlayout.core.state.State.Chain.SPREAD
            r6.style(r3)
            goto L_0x004d
        L_0x00a2:
            androidx.constraintlayout.core.state.State$Chain r3 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE
            r6.style(r3)
            goto L_0x004d
        L_0x00a8:
            androidx.constraintlayout.core.state.State$Chain r3 = androidx.constraintlayout.core.state.State.Chain.PACKED
            r6.style(r3)
            goto L_0x004d
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseChain(int, androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLArray):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseChainType(java.lang.String r21, androidx.constraintlayout.core.state.State r22, java.lang.String r23, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r24, androidx.constraintlayout.core.parser.CLObject r25) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = r22
            r1 = r23
            r2 = r25
            r3 = 6
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            r10 = r21
            char r10 = r10.charAt(r9)
            r11 = 104(0x68, float:1.46E-43)
            if (r10 != r11) goto L_0x001c
            androidx.constraintlayout.core.state.helpers.HorizontalChainReference r10 = r22.horizontalChain()
            goto L_0x0020
        L_0x001c:
            androidx.constraintlayout.core.state.helpers.VerticalChainReference r10 = r22.verticalChain()
        L_0x0020:
            r10.setKey(r1)
            java.util.ArrayList r11 = r25.names()
            java.util.Iterator r18 = r11.iterator()
        L_0x002b:
            boolean r11 = r18.hasNext()
            if (r11 == 0) goto L_0x01fb
            java.lang.Object r11 = r18.next()
            java.lang.String r11 = (java.lang.String) r11
            r11.hashCode()
            r12 = -1
            int r13 = r11.hashCode()
            switch(r13) {
                case -1383228885: goto L_0x0091;
                case -567445985: goto L_0x0086;
                case 100571: goto L_0x007b;
                case 115029: goto L_0x0070;
                case 3317767: goto L_0x0065;
                case 108511772: goto L_0x005a;
                case 109757538: goto L_0x004f;
                case 109780401: goto L_0x0044;
                default: goto L_0x0042;
            }
        L_0x0042:
            goto L_0x009b
        L_0x0044:
            java.lang.String r13 = "style"
            boolean r13 = r11.equals(r13)
            if (r13 != 0) goto L_0x004d
            goto L_0x009b
        L_0x004d:
            r12 = 7
            goto L_0x009b
        L_0x004f:
            java.lang.String r13 = "start"
            boolean r13 = r11.equals(r13)
            if (r13 != 0) goto L_0x0058
            goto L_0x009b
        L_0x0058:
            r12 = 6
            goto L_0x009b
        L_0x005a:
            java.lang.String r13 = "right"
            boolean r13 = r11.equals(r13)
            if (r13 != 0) goto L_0x0063
            goto L_0x009b
        L_0x0063:
            r12 = 5
            goto L_0x009b
        L_0x0065:
            java.lang.String r13 = "left"
            boolean r13 = r11.equals(r13)
            if (r13 != 0) goto L_0x006e
            goto L_0x009b
        L_0x006e:
            r12 = 4
            goto L_0x009b
        L_0x0070:
            java.lang.String r13 = "top"
            boolean r13 = r11.equals(r13)
            if (r13 != 0) goto L_0x0079
            goto L_0x009b
        L_0x0079:
            r12 = 3
            goto L_0x009b
        L_0x007b:
            java.lang.String r13 = "end"
            boolean r13 = r11.equals(r13)
            if (r13 != 0) goto L_0x0084
            goto L_0x009b
        L_0x0084:
            r12 = 2
            goto L_0x009b
        L_0x0086:
            java.lang.String r13 = "contains"
            boolean r13 = r11.equals(r13)
            if (r13 != 0) goto L_0x008f
            goto L_0x009b
        L_0x008f:
            r12 = 1
            goto L_0x009b
        L_0x0091:
            java.lang.String r13 = "bottom"
            boolean r13 = r11.equals(r13)
            if (r13 != 0) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            r12 = 0
        L_0x009b:
            switch(r12) {
                case 0: goto L_0x01ef;
                case 1: goto L_0x00ea;
                case 2: goto L_0x01ef;
                case 3: goto L_0x01ef;
                case 4: goto L_0x01ef;
                case 5: goto L_0x01ef;
                case 6: goto L_0x01ef;
                case 7: goto L_0x00a4;
                default: goto L_0x009e;
            }
        L_0x009e:
            r3 = r24
            r9 = 3
            r12 = 0
            goto L_0x01f6
        L_0x00a4:
            androidx.constraintlayout.core.parser.CLElement r11 = r2.get((java.lang.String) r11)
            boolean r12 = r11 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r12 == 0) goto L_0x00c1
            r12 = r11
            androidx.constraintlayout.core.parser.CLArray r12 = (androidx.constraintlayout.core.parser.CLArray) r12
            int r13 = r12.size()
            if (r13 <= r8) goto L_0x00c1
            java.lang.String r11 = r12.getString((int) r9)
            float r12 = r12.getFloat((int) r8)
            r10.bias((float) r12)
            goto L_0x00c5
        L_0x00c1:
            java.lang.String r11 = r11.content()
        L_0x00c5:
            r11.hashCode()
            java.lang.String r12 = "packed"
            boolean r12 = r11.equals(r12)
            if (r12 != 0) goto L_0x00e4
            java.lang.String r12 = "spread_inside"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x00de
            androidx.constraintlayout.core.state.State$Chain r11 = androidx.constraintlayout.core.state.State.Chain.SPREAD
            r10.style(r11)
            goto L_0x009e
        L_0x00de:
            androidx.constraintlayout.core.state.State$Chain r11 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE
            r10.style(r11)
            goto L_0x009e
        L_0x00e4:
            androidx.constraintlayout.core.state.State$Chain r11 = androidx.constraintlayout.core.state.State.Chain.PACKED
            r10.style(r11)
            goto L_0x009e
        L_0x00ea:
            androidx.constraintlayout.core.parser.CLElement r11 = r2.get((java.lang.String) r11)
            boolean r12 = r11 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r12 == 0) goto L_0x01cc
            r15 = r11
            androidx.constraintlayout.core.parser.CLArray r15 = (androidx.constraintlayout.core.parser.CLArray) r15
            int r12 = r15.size()
            if (r12 >= r8) goto L_0x00fd
            goto L_0x01cc
        L_0x00fd:
            r14 = 0
        L_0x00fe:
            int r11 = r15.size()
            if (r14 >= r11) goto L_0x01c7
            androidx.constraintlayout.core.parser.CLElement r11 = r15.get((int) r14)
            boolean r12 = r11 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r12 == 0) goto L_0x01ad
            androidx.constraintlayout.core.parser.CLArray r11 = (androidx.constraintlayout.core.parser.CLArray) r11
            int r12 = r11.size()
            if (r12 <= 0) goto L_0x01a6
            androidx.constraintlayout.core.parser.CLElement r12 = r11.get((int) r9)
            java.lang.String r12 = r12.content()
            int r13 = r11.size()
            r16 = 2143289344(0x7fc00000, float:NaN)
            if (r13 == r7) goto L_0x018d
            if (r13 == r6) goto L_0x017c
            if (r13 == r5) goto L_0x0160
            if (r13 == r3) goto L_0x0134
            r3 = 2143289344(0x7fc00000, float:NaN)
            r6 = 2143289344(0x7fc00000, float:NaN)
            r9 = 3
            r13 = 2143289344(0x7fc00000, float:NaN)
        L_0x0131:
            r17 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x0198
        L_0x0134:
            float r13 = r11.getFloat((int) r8)
            float r3 = r11.getFloat((int) r7)
            float r3 = toPix(r0, r3)
            float r9 = r11.getFloat((int) r6)
            float r9 = toPix(r0, r9)
            float r6 = r11.getFloat((int) r5)
            float r6 = toPix(r0, r6)
            float r11 = r11.getFloat((int) r4)
            float r11 = toPix(r0, r11)
            r16 = r3
            r3 = r6
            r6 = r9
            r17 = r11
            r9 = 3
            goto L_0x0198
        L_0x0160:
            float r3 = r11.getFloat((int) r8)
            float r6 = r11.getFloat((int) r7)
            float r6 = toPix(r0, r6)
            r9 = 3
            float r11 = r11.getFloat((int) r9)
            float r11 = toPix(r0, r11)
            r13 = r3
            r16 = r6
            r6 = r11
        L_0x0179:
            r3 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x0131
        L_0x017c:
            r9 = 3
            float r3 = r11.getFloat((int) r8)
            float r6 = r11.getFloat((int) r7)
            float r6 = toPix(r0, r6)
            r13 = r3
            r16 = r6
            goto L_0x0179
        L_0x018d:
            r9 = 3
            float r3 = r11.getFloat((int) r8)
            r13 = r3
            r3 = 2143289344(0x7fc00000, float:NaN)
            r6 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x0131
        L_0x0198:
            r11 = r10
            r19 = r14
            r14 = r16
            r20 = r15
            r15 = r6
            r16 = r3
            r11.addChainElement(r12, r13, r14, r15, r16, r17)
            goto L_0x01ab
        L_0x01a6:
            r19 = r14
            r20 = r15
            r9 = 3
        L_0x01ab:
            r12 = 0
            goto L_0x01be
        L_0x01ad:
            r19 = r14
            r20 = r15
            r9 = 3
            java.lang.String r3 = r11.content()
            java.lang.Object[] r6 = new java.lang.Object[r8]
            r12 = 0
            r6[r12] = r3
            r10.add(r6)
        L_0x01be:
            int r14 = r19 + 1
            r15 = r20
            r3 = 6
            r6 = 3
            r9 = 0
            goto L_0x00fe
        L_0x01c7:
            r9 = 3
            r12 = 0
            r3 = r24
            goto L_0x01f6
        L_0x01cc:
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = " contains should be an array \""
            r2.append(r1)
            java.lang.String r1 = r11.content()
            r2.append(r1)
            java.lang.String r1 = "\""
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.println(r1)
            return
        L_0x01ef:
            r3 = r24
            r9 = 3
            r12 = 0
            parseConstraint(r0, r3, r2, r10, r11)
        L_0x01f6:
            r3 = 6
            r6 = 3
            r9 = 0
            goto L_0x002b
        L_0x01fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseChainType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    public static long parseColorString(String str) {
        if (!str.startsWith(xoXoI.f16453oxoX)) {
            return -1;
        }
        String substring = str.substring(1);
        if (substring.length() == 6) {
            substring = "FF" + substring;
        }
        return Long.parseLong(substring, 16);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01ec, code lost:
        r0 = true;
        r18 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01ef, code lost:
        if (r18 == false) goto L_0x0241;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01f1, code lost:
        r7.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01f8, code lost:
        switch(r7.hashCode()) {
            case 100571: goto L_0x0218;
            case 3317767: goto L_0x020f;
            case 108511772: goto L_0x0206;
            case 109757538: goto L_0x01fd;
            default: goto L_0x01fb;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01fb, code lost:
        r10 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0201, code lost:
        if (r7.equals("start") != false) goto L_0x0204;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0204, code lost:
        r10 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x020a, code lost:
        if (r7.equals("right") != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x020d, code lost:
        r10 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0213, code lost:
        if (r7.equals("left") != false) goto L_0x0216;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0216, code lost:
        r10 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x021c, code lost:
        if (r7.equals("end") != false) goto L_0x021f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x021f, code lost:
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0220, code lost:
        switch(r10) {
            case 0: goto L_0x022a;
            case 1: goto L_0x0223;
            case 2: goto L_0x0228;
            case 3: goto L_0x0225;
            default: goto L_0x0223;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0223, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0225, code lost:
        r7 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0228, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x022a, code lost:
        r7 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x022c, code lost:
        if (r0 == false) goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x022e, code lost:
        if (r7 == false) goto L_0x0234;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0230, code lost:
        r4.leftToLeft(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0234, code lost:
        r4.leftToRight(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0238, code lost:
        if (r7 == false) goto L_0x023e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x023a, code lost:
        r4.rightToLeft(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x023e, code lost:
        r4.rightToRight(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0241, code lost:
        r4.margin((java.lang.Object) java.lang.Float.valueOf(r22)).marginGone((java.lang.Object) java.lang.Float.valueOf(r14));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d7, code lost:
        r18 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void parseConstraint(androidx.constraintlayout.core.state.State r20, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r21, androidx.constraintlayout.core.parser.CLObject r22, androidx.constraintlayout.core.state.ConstraintReference r23, java.lang.String r24) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            java.lang.String r5 = "right"
            java.lang.String r6 = "left"
            java.lang.String r8 = "start"
            java.lang.String r9 = "end"
            java.lang.String r11 = "top"
            java.lang.String r12 = "bottom"
            java.lang.String r13 = "baseline"
            r7 = 0
            r14 = 1
            boolean r16 = r20.isRtl()
            r17 = r16 ^ 1
            androidx.constraintlayout.core.parser.CLArray r10 = r2.getArrayOrNull(r4)
            java.lang.String r15 = "parent"
            if (r10 == 0) goto L_0x0252
            int r2 = r10.size()
            if (r2 <= r14) goto L_0x0252
            java.lang.String r2 = r10.getString((int) r7)
            java.lang.String r7 = r10.getStringOrNull((int) r14)
            int r14 = r10.size()
            r19 = 0
            r3 = 2
            if (r14 <= r3) goto L_0x004c
            androidx.constraintlayout.core.parser.CLElement r14 = r10.getOrNull((int) r3)
            float r3 = r1.get(r14)
            float r3 = toPix(r0, r3)
            goto L_0x004d
        L_0x004c:
            r3 = 0
        L_0x004d:
            int r14 = r10.size()
            r22 = r3
            r3 = 3
            if (r14 <= r3) goto L_0x0063
            androidx.constraintlayout.core.parser.CLElement r14 = r10.getOrNull((int) r3)
            float r14 = r1.get(r14)
            float r14 = toPix(r0, r14)
            goto L_0x0064
        L_0x0063:
            r14 = 0
        L_0x0064:
            boolean r15 = r2.equals(r15)
            if (r15 == 0) goto L_0x0071
            java.lang.Integer r2 = androidx.constraintlayout.core.state.State.PARENT
            androidx.constraintlayout.core.state.ConstraintReference r2 = r0.constraints(r2)
            goto L_0x0075
        L_0x0071:
            androidx.constraintlayout.core.state.ConstraintReference r2 = r0.constraints(r2)
        L_0x0075:
            r24.hashCode()
            int r15 = r24.hashCode()
            switch(r15) {
                case -1720785339: goto L_0x00c2;
                case -1498085729: goto L_0x00b7;
                case -1383228885: goto L_0x00ae;
                case 100571: goto L_0x00a5;
                case 115029: goto L_0x009c;
                case 3317767: goto L_0x0093;
                case 108511772: goto L_0x008a;
                case 109757538: goto L_0x0081;
                default: goto L_0x007f;
            }
        L_0x007f:
            r4 = -1
            goto L_0x00ca
        L_0x0081:
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x0088
            goto L_0x007f
        L_0x0088:
            r4 = 7
            goto L_0x00ca
        L_0x008a:
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0091
            goto L_0x007f
        L_0x0091:
            r4 = 6
            goto L_0x00ca
        L_0x0093:
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x009a
            goto L_0x007f
        L_0x009a:
            r4 = 5
            goto L_0x00ca
        L_0x009c:
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x00a3
            goto L_0x007f
        L_0x00a3:
            r4 = 4
            goto L_0x00ca
        L_0x00a5:
            boolean r4 = r4.equals(r9)
            if (r4 != 0) goto L_0x00ac
            goto L_0x007f
        L_0x00ac:
            r4 = 3
            goto L_0x00ca
        L_0x00ae:
            boolean r4 = r4.equals(r12)
            if (r4 != 0) goto L_0x00b5
            goto L_0x007f
        L_0x00b5:
            r4 = 2
            goto L_0x00ca
        L_0x00b7:
            java.lang.String r15 = "circular"
            boolean r4 = r4.equals(r15)
            if (r4 != 0) goto L_0x00c0
            goto L_0x007f
        L_0x00c0:
            r4 = 1
            goto L_0x00ca
        L_0x00c2:
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x00c9
            goto L_0x007f
        L_0x00c9:
            r4 = 0
        L_0x00ca:
            switch(r4) {
                case 0: goto L_0x0197;
                case 1: goto L_0x0170;
                case 2: goto L_0x012d;
                case 3: goto L_0x0128;
                case 4: goto L_0x00e5;
                case 5: goto L_0x00e1;
                case 6: goto L_0x00dd;
                case 7: goto L_0x00d3;
                default: goto L_0x00cd;
            }
        L_0x00cd:
            r4 = r23
        L_0x00cf:
            r1 = 2
            r15 = 1
            goto L_0x01ec
        L_0x00d3:
            r4 = r23
            r0 = r17
        L_0x00d7:
            r1 = 2
            r15 = 1
            r18 = 1
            goto L_0x01ef
        L_0x00dd:
            r4 = r23
            r0 = 0
            goto L_0x00d7
        L_0x00e1:
            r4 = r23
            r0 = 1
            goto L_0x00d7
        L_0x00e5:
            r7.hashCode()
            int r1 = r7.hashCode()
            switch(r1) {
                case -1720785339: goto L_0x0103;
                case -1383228885: goto L_0x00fa;
                case 115029: goto L_0x00f1;
                default: goto L_0x00ef;
            }
        L_0x00ef:
            r1 = -1
            goto L_0x010b
        L_0x00f1:
            boolean r1 = r7.equals(r11)
            if (r1 != 0) goto L_0x00f8
            goto L_0x00ef
        L_0x00f8:
            r1 = 2
            goto L_0x010b
        L_0x00fa:
            boolean r1 = r7.equals(r12)
            if (r1 != 0) goto L_0x0101
            goto L_0x00ef
        L_0x0101:
            r1 = 1
            goto L_0x010b
        L_0x0103:
            boolean r1 = r7.equals(r13)
            if (r1 != 0) goto L_0x010a
            goto L_0x00ef
        L_0x010a:
            r1 = 0
        L_0x010b:
            switch(r1) {
                case 0: goto L_0x011b;
                case 1: goto L_0x0115;
                case 2: goto L_0x010f;
                default: goto L_0x010e;
            }
        L_0x010e:
            goto L_0x00cd
        L_0x010f:
            r4 = r23
            r4.topToTop(r2)
            goto L_0x00cf
        L_0x0115:
            r4 = r23
            r4.topToBottom(r2)
            goto L_0x00cf
        L_0x011b:
            r4 = r23
            java.lang.Object r1 = r2.getKey()
            r0.baselineNeededFor(r1)
            r4.topToBaseline(r2)
            goto L_0x00cf
        L_0x0128:
            r4 = r23
            r0 = r16
            goto L_0x00d7
        L_0x012d:
            r4 = r23
            r7.hashCode()
            int r1 = r7.hashCode()
            switch(r1) {
                case -1720785339: goto L_0x014d;
                case -1383228885: goto L_0x0144;
                case 115029: goto L_0x013b;
                default: goto L_0x0139;
            }
        L_0x0139:
            r1 = -1
            goto L_0x0155
        L_0x013b:
            boolean r1 = r7.equals(r11)
            if (r1 != 0) goto L_0x0142
            goto L_0x0139
        L_0x0142:
            r1 = 2
            goto L_0x0155
        L_0x0144:
            boolean r1 = r7.equals(r12)
            if (r1 != 0) goto L_0x014b
            goto L_0x0139
        L_0x014b:
            r1 = 1
            goto L_0x0155
        L_0x014d:
            boolean r1 = r7.equals(r13)
            if (r1 != 0) goto L_0x0154
            goto L_0x0139
        L_0x0154:
            r1 = 0
        L_0x0155:
            switch(r1) {
                case 0: goto L_0x0164;
                case 1: goto L_0x015f;
                case 2: goto L_0x015a;
                default: goto L_0x0158;
            }
        L_0x0158:
            goto L_0x00cf
        L_0x015a:
            r4.bottomToTop(r2)
            goto L_0x00cf
        L_0x015f:
            r4.bottomToBottom(r2)
            goto L_0x00cf
        L_0x0164:
            java.lang.Object r1 = r2.getKey()
            r0.baselineNeededFor(r1)
            r4.bottomToBaseline(r2)
            goto L_0x00cf
        L_0x0170:
            r4 = r23
            r15 = 1
            androidx.constraintlayout.core.parser.CLElement r11 = r10.get((int) r15)
            float r11 = r1.get(r11)
            int r12 = r10.size()
            r13 = 2
            if (r12 <= r13) goto L_0x0191
            androidx.constraintlayout.core.parser.CLElement r10 = r10.getOrNull((int) r13)
            float r1 = r1.get(r10)
            float r19 = toPix(r0, r1)
            r0 = r19
            goto L_0x0192
        L_0x0191:
            r0 = 0
        L_0x0192:
            r4.circularConstraint(r2, r11, r0)
            r1 = 2
            goto L_0x01ec
        L_0x0197:
            r4 = r23
            r1 = 2
            r15 = 1
            r7.hashCode()
            int r10 = r7.hashCode()
            switch(r10) {
                case -1720785339: goto L_0x01b9;
                case -1383228885: goto L_0x01b0;
                case 115029: goto L_0x01a7;
                default: goto L_0x01a5;
            }
        L_0x01a5:
            r10 = -1
            goto L_0x01c1
        L_0x01a7:
            boolean r10 = r7.equals(r11)
            if (r10 != 0) goto L_0x01ae
            goto L_0x01a5
        L_0x01ae:
            r10 = 2
            goto L_0x01c1
        L_0x01b0:
            boolean r10 = r7.equals(r12)
            if (r10 != 0) goto L_0x01b7
            goto L_0x01a5
        L_0x01b7:
            r10 = 1
            goto L_0x01c1
        L_0x01b9:
            boolean r10 = r7.equals(r13)
            if (r10 != 0) goto L_0x01c0
            goto L_0x01a5
        L_0x01c0:
            r10 = 0
        L_0x01c1:
            switch(r10) {
                case 0: goto L_0x01db;
                case 1: goto L_0x01d0;
                case 2: goto L_0x01c5;
                default: goto L_0x01c4;
            }
        L_0x01c4:
            goto L_0x01ec
        L_0x01c5:
            java.lang.Object r10 = r23.getKey()
            r0.baselineNeededFor(r10)
            r4.baselineToTop(r2)
            goto L_0x01ec
        L_0x01d0:
            java.lang.Object r10 = r23.getKey()
            r0.baselineNeededFor(r10)
            r4.baselineToBottom(r2)
            goto L_0x01ec
        L_0x01db:
            java.lang.Object r10 = r23.getKey()
            r0.baselineNeededFor(r10)
            java.lang.Object r10 = r2.getKey()
            r0.baselineNeededFor(r10)
            r4.baselineToBaseline(r2)
        L_0x01ec:
            r0 = 1
            r18 = 0
        L_0x01ef:
            if (r18 == 0) goto L_0x0241
            r7.hashCode()
            int r10 = r7.hashCode()
            switch(r10) {
                case 100571: goto L_0x0218;
                case 3317767: goto L_0x020f;
                case 108511772: goto L_0x0206;
                case 109757538: goto L_0x01fd;
                default: goto L_0x01fb;
            }
        L_0x01fb:
            r10 = -1
            goto L_0x0220
        L_0x01fd:
            boolean r1 = r7.equals(r8)
            if (r1 != 0) goto L_0x0204
            goto L_0x01fb
        L_0x0204:
            r10 = 3
            goto L_0x0220
        L_0x0206:
            boolean r3 = r7.equals(r5)
            if (r3 != 0) goto L_0x020d
            goto L_0x01fb
        L_0x020d:
            r10 = 2
            goto L_0x0220
        L_0x020f:
            boolean r1 = r7.equals(r6)
            if (r1 != 0) goto L_0x0216
            goto L_0x01fb
        L_0x0216:
            r10 = 1
            goto L_0x0220
        L_0x0218:
            boolean r1 = r7.equals(r9)
            if (r1 != 0) goto L_0x021f
            goto L_0x01fb
        L_0x021f:
            r10 = 0
        L_0x0220:
            switch(r10) {
                case 0: goto L_0x022a;
                case 1: goto L_0x0223;
                case 2: goto L_0x0228;
                case 3: goto L_0x0225;
                default: goto L_0x0223;
            }
        L_0x0223:
            r7 = 1
            goto L_0x022c
        L_0x0225:
            r7 = r17
            goto L_0x022c
        L_0x0228:
            r7 = 0
            goto L_0x022c
        L_0x022a:
            r7 = r16
        L_0x022c:
            if (r0 == 0) goto L_0x0238
            if (r7 == 0) goto L_0x0234
            r4.leftToLeft(r2)
            goto L_0x0241
        L_0x0234:
            r4.leftToRight(r2)
            goto L_0x0241
        L_0x0238:
            if (r7 == 0) goto L_0x023e
            r4.rightToLeft(r2)
            goto L_0x0241
        L_0x023e:
            r4.rightToRight(r2)
        L_0x0241:
            java.lang.Float r0 = java.lang.Float.valueOf(r22)
            androidx.constraintlayout.core.state.ConstraintReference r0 = r4.margin((java.lang.Object) r0)
            java.lang.Float r1 = java.lang.Float.valueOf(r14)
            r0.marginGone((java.lang.Object) r1)
            goto L_0x02d8
        L_0x0252:
            r2 = r3
            r1 = 2
            r3 = 3
            r5 = 1
            r6 = r22
            java.lang.String r6 = r6.getStringOrNull((java.lang.String) r4)
            if (r6 == 0) goto L_0x02d8
            boolean r7 = r6.equals(r15)
            if (r7 == 0) goto L_0x026b
            java.lang.Integer r6 = androidx.constraintlayout.core.state.State.PARENT
            androidx.constraintlayout.core.state.ConstraintReference r6 = r0.constraints(r6)
            goto L_0x026f
        L_0x026b:
            androidx.constraintlayout.core.state.ConstraintReference r6 = r0.constraints(r6)
        L_0x026f:
            r24.hashCode()
            int r7 = r24.hashCode()
            switch(r7) {
                case -1720785339: goto L_0x029f;
                case -1383228885: goto L_0x0296;
                case 100571: goto L_0x028d;
                case 115029: goto L_0x0284;
                case 109757538: goto L_0x027b;
                default: goto L_0x0279;
            }
        L_0x0279:
            r7 = -1
            goto L_0x02a7
        L_0x027b:
            boolean r1 = r4.equals(r8)
            if (r1 != 0) goto L_0x0282
            goto L_0x0279
        L_0x0282:
            r7 = 4
            goto L_0x02a7
        L_0x0284:
            boolean r1 = r4.equals(r11)
            if (r1 != 0) goto L_0x028b
            goto L_0x0279
        L_0x028b:
            r7 = 3
            goto L_0x02a7
        L_0x028d:
            boolean r3 = r4.equals(r9)
            if (r3 != 0) goto L_0x0294
            goto L_0x0279
        L_0x0294:
            r7 = 2
            goto L_0x02a7
        L_0x0296:
            boolean r1 = r4.equals(r12)
            if (r1 != 0) goto L_0x029d
            goto L_0x0279
        L_0x029d:
            r7 = 1
            goto L_0x02a7
        L_0x029f:
            boolean r1 = r4.equals(r13)
            if (r1 != 0) goto L_0x02a6
            goto L_0x0279
        L_0x02a6:
            r7 = 0
        L_0x02a7:
            switch(r7) {
                case 0: goto L_0x02c7;
                case 1: goto L_0x02c3;
                case 2: goto L_0x02b9;
                case 3: goto L_0x02b5;
                case 4: goto L_0x02ab;
                default: goto L_0x02aa;
            }
        L_0x02aa:
            goto L_0x02d8
        L_0x02ab:
            if (r16 != 0) goto L_0x02b1
            r2.leftToLeft(r6)
            goto L_0x02d8
        L_0x02b1:
            r2.rightToRight(r6)
            goto L_0x02d8
        L_0x02b5:
            r2.topToTop(r6)
            goto L_0x02d8
        L_0x02b9:
            if (r16 != 0) goto L_0x02bf
            r2.rightToRight(r6)
            goto L_0x02d8
        L_0x02bf:
            r2.leftToLeft(r6)
            goto L_0x02d8
        L_0x02c3:
            r2.bottomToBottom(r6)
            goto L_0x02d8
        L_0x02c7:
            java.lang.Object r1 = r23.getKey()
            r0.baselineNeededFor(r1)
            java.lang.Object r1 = r6.getKey()
            r0.baselineNeededFor(r1)
            r2.baselineToBaseline(r6)
        L_0x02d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseConstraint(androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.ConstraintReference, java.lang.String):void");
    }

    public static void parseConstraintSets(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names != null) {
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                String next = it.next();
                CLObject object = cLObject.getObject(next);
                String stringOrNull = object.getStringOrNull("Extends");
                if (stringOrNull == null || stringOrNull.isEmpty()) {
                    coreMotionScene.setConstraintSetContent(next, object.toJSON());
                } else {
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
                }
            }
        }
    }

    public static void parseCustomProperties(CLObject cLObject, ConstraintReference constraintReference, String str) throws CLParsingException {
        ArrayList<String> names;
        CLObject objectOrNull = cLObject.getObjectOrNull(str);
        if (objectOrNull != null && (names = objectOrNull.names()) != null) {
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
    }

    public static void parseDesignElementsJSON(String str, ArrayList<DesignElement> arrayList) throws CLParsingException {
        CLObject parse = CLParser.parse(str);
        ArrayList<String> names = parse.names();
        if (names != null && names.size() > 0) {
            String str2 = names.get(0);
            CLElement cLElement = parse.get(str2);
            str2.hashCode();
            if (str2.equals("Design") && (cLElement instanceof CLObject)) {
                CLObject cLObject = (CLObject) cLElement;
                ArrayList<String> names2 = cLObject.names();
                for (int i = 0; i < names2.size(); i++) {
                    String str3 = names2.get(i);
                    CLObject cLObject2 = (CLObject) cLObject.get(str3);
                    PrintStream printStream = System.out;
                    printStream.printf("element found " + str3 + "", new Object[0]);
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
        if (!(cLElement instanceof CLObject)) {
            return createFixed;
        }
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
        if (orNull2 == null) {
            return createFixed;
        }
        if (orNull2 instanceof CLNumber) {
            createFixed.max(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull2).getFloat()))));
            return createFixed;
        } else if (!(orNull2 instanceof CLString)) {
            return createFixed;
        } else {
            createFixed.max(Dimension.WRAP_DIMENSION);
            return createFixed;
        }
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

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0256 A[Catch:{ NumberFormatException -> 0x024b }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03bf A[Catch:{ NumberFormatException -> 0x024b }] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03ce A[Catch:{ NumberFormatException -> 0x024b }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x040b  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0418  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0425  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0455 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0455 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0455 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0455 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0243 A[Catch:{ NumberFormatException -> 0x024b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseFlowType(java.lang.String r17, androidx.constraintlayout.core.state.State r18, java.lang.String r19, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r20, androidx.constraintlayout.core.parser.CLObject r21) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = r18
            r1 = r19
            r2 = r21
            r3 = 4
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = r17
            char r8 = r8.charAt(r7)
            r9 = 118(0x76, float:1.65E-43)
            r10 = 1
            if (r8 != r9) goto L_0x0017
            r8 = 1
            goto L_0x0018
        L_0x0017:
            r8 = 0
        L_0x0018:
            androidx.constraintlayout.core.state.helpers.FlowReference r8 = r0.getFlow(r1, r8)
            java.util.ArrayList r9 = r21.names()
            java.util.Iterator r9 = r9.iterator()
        L_0x0024:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x0458
            java.lang.Object r11 = r9.next()
            java.lang.String r11 = (java.lang.String) r11
            r11.hashCode()
            r12 = 1056964608(0x3f000000, float:0.5)
            java.lang.String r13 = ""
            int r14 = r11.hashCode()
            switch(r14) {
                case -1254185091: goto L_0x00d2;
                case -1237307863: goto L_0x00c6;
                case -1198076529: goto L_0x00ba;
                case -853376977: goto L_0x00af;
                case -836499749: goto L_0x00a4;
                case -806339567: goto L_0x0099;
                case -732635235: goto L_0x008e;
                case -567445985: goto L_0x0083;
                case -488900360: goto L_0x0076;
                case 3169614: goto L_0x0069;
                case 3575610: goto L_0x005c;
                case 3586688: goto L_0x004f;
                case 3657802: goto L_0x0041;
                default: goto L_0x003e;
            }
        L_0x003e:
            r14 = -1
            goto L_0x00dd
        L_0x0041:
            java.lang.String r14 = "wrap"
            boolean r14 = r11.equals(r14)
            if (r14 != 0) goto L_0x004b
            goto L_0x003e
        L_0x004b:
            r14 = 12
            goto L_0x00dd
        L_0x004f:
            java.lang.String r14 = "vGap"
            boolean r14 = r11.equals(r14)
            if (r14 != 0) goto L_0x0058
            goto L_0x003e
        L_0x0058:
            r14 = 11
            goto L_0x00dd
        L_0x005c:
            java.lang.String r14 = "type"
            boolean r14 = r11.equals(r14)
            if (r14 != 0) goto L_0x0065
            goto L_0x003e
        L_0x0065:
            r14 = 10
            goto L_0x00dd
        L_0x0069:
            java.lang.String r14 = "hGap"
            boolean r14 = r11.equals(r14)
            if (r14 != 0) goto L_0x0072
            goto L_0x003e
        L_0x0072:
            r14 = 9
            goto L_0x00dd
        L_0x0076:
            java.lang.String r14 = "maxElement"
            boolean r14 = r11.equals(r14)
            if (r14 != 0) goto L_0x007f
            goto L_0x003e
        L_0x007f:
            r14 = 8
            goto L_0x00dd
        L_0x0083:
            java.lang.String r14 = "contains"
            boolean r14 = r11.equals(r14)
            if (r14 != 0) goto L_0x008c
            goto L_0x003e
        L_0x008c:
            r14 = 7
            goto L_0x00dd
        L_0x008e:
            java.lang.String r14 = "vFlowBias"
            boolean r14 = r11.equals(r14)
            if (r14 != 0) goto L_0x0097
            goto L_0x003e
        L_0x0097:
            r14 = 6
            goto L_0x00dd
        L_0x0099:
            java.lang.String r14 = "padding"
            boolean r14 = r11.equals(r14)
            if (r14 != 0) goto L_0x00a2
            goto L_0x003e
        L_0x00a2:
            r14 = 5
            goto L_0x00dd
        L_0x00a4:
            java.lang.String r14 = "vStyle"
            boolean r14 = r11.equals(r14)
            if (r14 != 0) goto L_0x00ad
            goto L_0x003e
        L_0x00ad:
            r14 = 4
            goto L_0x00dd
        L_0x00af:
            java.lang.String r14 = "vAlign"
            boolean r14 = r11.equals(r14)
            if (r14 != 0) goto L_0x00b8
            goto L_0x003e
        L_0x00b8:
            r14 = 3
            goto L_0x00dd
        L_0x00ba:
            java.lang.String r14 = "hFlowBias"
            boolean r14 = r11.equals(r14)
            if (r14 != 0) goto L_0x00c4
            goto L_0x003e
        L_0x00c4:
            r14 = 2
            goto L_0x00dd
        L_0x00c6:
            java.lang.String r14 = "hStyle"
            boolean r14 = r11.equals(r14)
            if (r14 != 0) goto L_0x00d0
            goto L_0x003e
        L_0x00d0:
            r14 = 1
            goto L_0x00dd
        L_0x00d2:
            java.lang.String r14 = "hAlign"
            boolean r14 = r11.equals(r14)
            if (r14 != 0) goto L_0x00dc
            goto L_0x003e
        L_0x00dc:
            r14 = 0
        L_0x00dd:
            switch(r14) {
                case 0: goto L_0x042d;
                case 1: goto L_0x03d7;
                case 2: goto L_0x036e;
                case 3: goto L_0x0321;
                case 4: goto L_0x02ca;
                case 5: goto L_0x025f;
                case 6: goto L_0x01f2;
                case 7: goto L_0x0147;
                case 8: goto L_0x0138;
                case 9: goto L_0x0129;
                case 10: goto L_0x010d;
                case 11: goto L_0x00fe;
                case 12: goto L_0x00eb;
                default: goto L_0x00e0;
            }
        L_0x00e0:
            androidx.constraintlayout.core.state.ConstraintReference r12 = r18.constraints(r19)
            r14 = r20
            applyAttribute(r0, r14, r12, r2, r11)
            goto L_0x0455
        L_0x00eb:
            r14 = r20
            androidx.constraintlayout.core.parser.CLElement r11 = r2.get((java.lang.String) r11)
            java.lang.String r11 = r11.content()
            int r11 = androidx.constraintlayout.core.state.State.Wrap.getValueByString(r11)
            r8.setWrapMode(r11)
            goto L_0x0455
        L_0x00fe:
            r14 = r20
            androidx.constraintlayout.core.parser.CLElement r11 = r2.get((java.lang.String) r11)
            int r11 = r11.getInt()
            r8.setVerticalGap(r11)
            goto L_0x0455
        L_0x010d:
            r14 = r20
            androidx.constraintlayout.core.parser.CLElement r11 = r2.get((java.lang.String) r11)
            java.lang.String r11 = r11.content()
            java.lang.String r12 = "hFlow"
            boolean r11 = r11.equals(r12)
            if (r11 == 0) goto L_0x0124
            r8.setOrientation(r7)
            goto L_0x0455
        L_0x0124:
            r8.setOrientation(r10)
            goto L_0x0455
        L_0x0129:
            r14 = r20
            androidx.constraintlayout.core.parser.CLElement r11 = r2.get((java.lang.String) r11)
            int r11 = r11.getInt()
            r8.setHorizontalGap(r11)
            goto L_0x0455
        L_0x0138:
            r14 = r20
            androidx.constraintlayout.core.parser.CLElement r11 = r2.get((java.lang.String) r11)
            int r11 = r11.getInt()
            r8.setMaxElementsWrap(r11)
            goto L_0x0455
        L_0x0147:
            r14 = r20
            androidx.constraintlayout.core.parser.CLElement r11 = r2.get((java.lang.String) r11)
            boolean r12 = r11 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r12 == 0) goto L_0x01cf
            r12 = r11
            androidx.constraintlayout.core.parser.CLArray r12 = (androidx.constraintlayout.core.parser.CLArray) r12
            int r13 = r12.size()
            if (r13 >= r10) goto L_0x015c
            goto L_0x01cf
        L_0x015c:
            r11 = 0
        L_0x015d:
            int r13 = r12.size()
            if (r11 >= r13) goto L_0x0455
            androidx.constraintlayout.core.parser.CLElement r13 = r12.get((int) r11)
            boolean r15 = r13 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r15 == 0) goto L_0x01c1
            androidx.constraintlayout.core.parser.CLArray r13 = (androidx.constraintlayout.core.parser.CLArray) r13
            int r15 = r13.size()
            if (r15 <= 0) goto L_0x01cc
            androidx.constraintlayout.core.parser.CLElement r15 = r13.get((int) r7)
            java.lang.String r15 = r15.content()
            int r4 = r13.size()
            r16 = 2143289344(0x7fc00000, float:NaN)
            if (r4 == r6) goto L_0x01b6
            if (r4 == r5) goto L_0x01a7
            if (r4 == r3) goto L_0x018e
            r3 = 2143289344(0x7fc00000, float:NaN)
            r4 = 2143289344(0x7fc00000, float:NaN)
        L_0x018b:
            r13 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x01bd
        L_0x018e:
            float r16 = r13.getFloat((int) r10)
            float r4 = r13.getFloat((int) r6)
            float r4 = toPix(r0, r4)
            float r13 = r13.getFloat((int) r5)
            float r13 = toPix(r0, r13)
            r3 = r13
            r13 = r4
        L_0x01a4:
            r4 = r16
            goto L_0x01bd
        L_0x01a7:
            float r16 = r13.getFloat((int) r10)
            float r4 = r13.getFloat((int) r6)
            float r4 = toPix(r0, r4)
            r3 = r4
            r13 = r3
            goto L_0x01a4
        L_0x01b6:
            float r4 = r13.getFloat((int) r10)
            r3 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x018b
        L_0x01bd:
            r8.addFlowElement(r15, r4, r13, r3)
            goto L_0x01cc
        L_0x01c1:
            java.lang.String r3 = r13.content()
            java.lang.Object[] r4 = new java.lang.Object[r10]
            r4[r7] = r3
            r8.add(r4)
        L_0x01cc:
            int r11 = r11 + r10
            r3 = 4
            goto L_0x015d
        L_0x01cf:
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = " contains should be an array \""
            r2.append(r1)
            java.lang.String r1 = r11.content()
            r2.append(r1)
            java.lang.String r1 = "\""
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.println(r1)
            return
        L_0x01f2:
            r14 = r20
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            java.lang.Float r4 = java.lang.Float.valueOf(r12)
            java.lang.Float r11 = java.lang.Float.valueOf(r12)
            boolean r13 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r13 == 0) goto L_0x022c
            r13 = r3
            androidx.constraintlayout.core.parser.CLArray r13 = (androidx.constraintlayout.core.parser.CLArray) r13
            int r15 = r13.size()
            if (r15 <= r10) goto L_0x022c
            float r3 = r13.getFloat((int) r7)
            java.lang.Float r4 = java.lang.Float.valueOf(r3)
            float r3 = r13.getFloat((int) r10)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            int r15 = r13.size()
            if (r15 <= r6) goto L_0x0234
            float r11 = r13.getFloat((int) r6)
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            goto L_0x0234
        L_0x022c:
            float r3 = r3.getFloat()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
        L_0x0234:
            float r3 = r3.floatValue()     // Catch:{ NumberFormatException -> 0x024b }
            r8.verticalBias(r3)     // Catch:{ NumberFormatException -> 0x024b }
            float r3 = r4.floatValue()     // Catch:{ NumberFormatException -> 0x024b }
            int r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r3 == 0) goto L_0x024e
            float r3 = r4.floatValue()     // Catch:{ NumberFormatException -> 0x024b }
            r8.setFirstVerticalBias(r3)     // Catch:{ NumberFormatException -> 0x024b }
            goto L_0x024e
        L_0x024b:
            goto L_0x0455
        L_0x024e:
            float r3 = r11.floatValue()     // Catch:{ NumberFormatException -> 0x024b }
            int r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r3 == 0) goto L_0x0455
            float r3 = r11.floatValue()     // Catch:{ NumberFormatException -> 0x024b }
            r8.setLastVerticalBias(r3)     // Catch:{ NumberFormatException -> 0x024b }
            goto L_0x0455
        L_0x025f:
            r14 = r20
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            boolean r4 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r4 == 0) goto L_0x0294
            r4 = r3
            androidx.constraintlayout.core.parser.CLArray r4 = (androidx.constraintlayout.core.parser.CLArray) r4
            int r11 = r4.size()
            if (r11 <= r10) goto L_0x0294
            int r11 = r4.getInt((int) r7)
            float r11 = (float) r11
            int r12 = r4.getInt((int) r10)
            float r12 = (float) r12
            int r13 = r4.size()
            if (r13 <= r6) goto L_0x0291
            int r4 = r4.getInt((int) r6)
            float r4 = (float) r4
            androidx.constraintlayout.core.parser.CLArray r3 = (androidx.constraintlayout.core.parser.CLArray) r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x028f }
            int r3 = r3.getInt((int) r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x028f }
            float r3 = (float) r3
            goto L_0x029c
        L_0x028f:
            r3 = 0
            goto L_0x029c
        L_0x0291:
            r4 = r11
            r3 = r12
            goto L_0x029c
        L_0x0294:
            int r3 = r3.getInt()
            float r11 = (float) r3
            r3 = r11
            r4 = r3
            r12 = r4
        L_0x029c:
            float r11 = toPix(r0, r11)
            int r11 = java.lang.Math.round(r11)
            r8.setPaddingLeft(r11)
            float r11 = toPix(r0, r12)
            int r11 = java.lang.Math.round(r11)
            r8.setPaddingTop(r11)
            float r4 = toPix(r0, r4)
            int r4 = java.lang.Math.round(r4)
            r8.setPaddingRight(r4)
            float r3 = toPix(r0, r3)
            int r3 = java.lang.Math.round(r3)
            r8.setPaddingBottom(r3)
            goto L_0x0455
        L_0x02ca:
            r14 = r20
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            boolean r4 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r4 == 0) goto L_0x02f2
            r4 = r3
            androidx.constraintlayout.core.parser.CLArray r4 = (androidx.constraintlayout.core.parser.CLArray) r4
            int r11 = r4.size()
            if (r11 <= r10) goto L_0x02f2
            java.lang.String r3 = r4.getString((int) r7)
            java.lang.String r11 = r4.getString((int) r10)
            int r12 = r4.size()
            if (r12 <= r6) goto L_0x02f0
            java.lang.String r4 = r4.getString((int) r6)
            goto L_0x02f8
        L_0x02f0:
            r4 = r13
            goto L_0x02f8
        L_0x02f2:
            java.lang.String r11 = r3.content()
            r3 = r13
            r4 = r3
        L_0x02f8:
            boolean r12 = r11.equals(r13)
            if (r12 != 0) goto L_0x0305
            int r11 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r11)
            r8.setVerticalStyle(r11)
        L_0x0305:
            boolean r11 = r3.equals(r13)
            if (r11 != 0) goto L_0x0312
            int r3 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r3)
            r8.setFirstVerticalStyle(r3)
        L_0x0312:
            boolean r3 = r4.equals(r13)
            if (r3 != 0) goto L_0x0455
            int r3 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r4)
            r8.setLastVerticalStyle(r3)
            goto L_0x0455
        L_0x0321:
            r14 = r20
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            java.lang.String r3 = r3.content()
            r3.hashCode()
            int r4 = r3.hashCode()
            switch(r4) {
                case -1720785339: goto L_0x034d;
                case -1383228885: goto L_0x0342;
                case 115029: goto L_0x0337;
                default: goto L_0x0335;
            }
        L_0x0335:
            r3 = -1
            goto L_0x0357
        L_0x0337:
            java.lang.String r4 = "top"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0340
            goto L_0x0335
        L_0x0340:
            r3 = 2
            goto L_0x0357
        L_0x0342:
            java.lang.String r4 = "bottom"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x034b
            goto L_0x0335
        L_0x034b:
            r3 = 1
            goto L_0x0357
        L_0x034d:
            java.lang.String r4 = "baseline"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0356
            goto L_0x0335
        L_0x0356:
            r3 = 0
        L_0x0357:
            switch(r3) {
                case 0: goto L_0x0369;
                case 1: goto L_0x0364;
                case 2: goto L_0x035f;
                default: goto L_0x035a;
            }
        L_0x035a:
            r8.setVerticalAlign(r6)
            goto L_0x0455
        L_0x035f:
            r8.setVerticalAlign(r7)
            goto L_0x0455
        L_0x0364:
            r8.setVerticalAlign(r10)
            goto L_0x0455
        L_0x0369:
            r8.setVerticalAlign(r5)
            goto L_0x0455
        L_0x036e:
            r14 = r20
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            java.lang.Float r4 = java.lang.Float.valueOf(r12)
            java.lang.Float r11 = java.lang.Float.valueOf(r12)
            boolean r13 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r13 == 0) goto L_0x03a8
            r13 = r3
            androidx.constraintlayout.core.parser.CLArray r13 = (androidx.constraintlayout.core.parser.CLArray) r13
            int r15 = r13.size()
            if (r15 <= r10) goto L_0x03a8
            float r3 = r13.getFloat((int) r7)
            java.lang.Float r4 = java.lang.Float.valueOf(r3)
            float r3 = r13.getFloat((int) r10)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            int r15 = r13.size()
            if (r15 <= r6) goto L_0x03b0
            float r11 = r13.getFloat((int) r6)
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            goto L_0x03b0
        L_0x03a8:
            float r3 = r3.getFloat()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
        L_0x03b0:
            float r3 = r3.floatValue()     // Catch:{ NumberFormatException -> 0x024b }
            r8.horizontalBias(r3)     // Catch:{ NumberFormatException -> 0x024b }
            float r3 = r4.floatValue()     // Catch:{ NumberFormatException -> 0x024b }
            int r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r3 == 0) goto L_0x03c6
            float r3 = r4.floatValue()     // Catch:{ NumberFormatException -> 0x024b }
            r8.setFirstHorizontalBias(r3)     // Catch:{ NumberFormatException -> 0x024b }
        L_0x03c6:
            float r3 = r11.floatValue()     // Catch:{ NumberFormatException -> 0x024b }
            int r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r3 == 0) goto L_0x0455
            float r3 = r11.floatValue()     // Catch:{ NumberFormatException -> 0x024b }
            r8.setLastHorizontalBias(r3)     // Catch:{ NumberFormatException -> 0x024b }
            goto L_0x0455
        L_0x03d7:
            r14 = r20
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            boolean r4 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r4 == 0) goto L_0x03ff
            r4 = r3
            androidx.constraintlayout.core.parser.CLArray r4 = (androidx.constraintlayout.core.parser.CLArray) r4
            int r11 = r4.size()
            if (r11 <= r10) goto L_0x03ff
            java.lang.String r3 = r4.getString((int) r7)
            java.lang.String r11 = r4.getString((int) r10)
            int r12 = r4.size()
            if (r12 <= r6) goto L_0x03fd
            java.lang.String r4 = r4.getString((int) r6)
            goto L_0x0405
        L_0x03fd:
            r4 = r13
            goto L_0x0405
        L_0x03ff:
            java.lang.String r11 = r3.content()
            r3 = r13
            r4 = r3
        L_0x0405:
            boolean r12 = r11.equals(r13)
            if (r12 != 0) goto L_0x0412
            int r11 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r11)
            r8.setHorizontalStyle(r11)
        L_0x0412:
            boolean r11 = r3.equals(r13)
            if (r11 != 0) goto L_0x041f
            int r3 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r3)
            r8.setFirstHorizontalStyle(r3)
        L_0x041f:
            boolean r3 = r4.equals(r13)
            if (r3 != 0) goto L_0x0455
            int r3 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r4)
            r8.setLastHorizontalStyle(r3)
            goto L_0x0455
        L_0x042d:
            r14 = r20
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            java.lang.String r3 = r3.content()
            r3.hashCode()
            java.lang.String r4 = "end"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x0452
            java.lang.String r4 = "start"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x044e
            r8.setHorizontalAlign(r6)
            goto L_0x0455
        L_0x044e:
            r8.setHorizontalAlign(r7)
            goto L_0x0455
        L_0x0452:
            r8.setHorizontalAlign(r10)
        L_0x0455:
            r3 = 4
            goto L_0x0024
        L_0x0458:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseFlowType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    public static void parseGenerate(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names != null) {
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
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0165  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseGridType(java.lang.String r10, androidx.constraintlayout.core.state.State r11, java.lang.String r12, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r13, androidx.constraintlayout.core.parser.CLObject r14) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = 3
            r1 = 2
            r2 = 0
            r3 = 1
            androidx.constraintlayout.core.state.helpers.GridReference r10 = r11.getGrid(r12, r10)
            java.util.ArrayList r4 = r14.names()
            java.util.Iterator r4 = r4.iterator()
        L_0x0010:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0233
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            r5.hashCode()
            java.lang.String r6 = ":"
            java.lang.String r7 = ","
            r8 = -1
            int r9 = r5.hashCode()
            switch(r9) {
                case -1439500848: goto L_0x00b2;
                case -806339567: goto L_0x00a7;
                case -567445985: goto L_0x009c;
                case 3169614: goto L_0x0091;
                case 3506649: goto L_0x0086;
                case 3586688: goto L_0x007b;
                case 97513095: goto L_0x0070;
                case 109497044: goto L_0x0065;
                case 109638249: goto L_0x0057;
                case 144441793: goto L_0x0049;
                case 949721053: goto L_0x003b;
                case 2033353925: goto L_0x002d;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x00bc
        L_0x002d:
            java.lang.String r9 = "columnWeights"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x0037
            goto L_0x00bc
        L_0x0037:
            r8 = 11
            goto L_0x00bc
        L_0x003b:
            java.lang.String r9 = "columns"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x0045
            goto L_0x00bc
        L_0x0045:
            r8 = 10
            goto L_0x00bc
        L_0x0049:
            java.lang.String r9 = "rowWeights"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x0053
            goto L_0x00bc
        L_0x0053:
            r8 = 9
            goto L_0x00bc
        L_0x0057:
            java.lang.String r9 = "spans"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x0061
            goto L_0x00bc
        L_0x0061:
            r8 = 8
            goto L_0x00bc
        L_0x0065:
            java.lang.String r9 = "skips"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x006e
            goto L_0x00bc
        L_0x006e:
            r8 = 7
            goto L_0x00bc
        L_0x0070:
            java.lang.String r9 = "flags"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x0079
            goto L_0x00bc
        L_0x0079:
            r8 = 6
            goto L_0x00bc
        L_0x007b:
            java.lang.String r9 = "vGap"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x0084
            goto L_0x00bc
        L_0x0084:
            r8 = 5
            goto L_0x00bc
        L_0x0086:
            java.lang.String r9 = "rows"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x008f
            goto L_0x00bc
        L_0x008f:
            r8 = 4
            goto L_0x00bc
        L_0x0091:
            java.lang.String r9 = "hGap"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x009a
            goto L_0x00bc
        L_0x009a:
            r8 = 3
            goto L_0x00bc
        L_0x009c:
            java.lang.String r9 = "contains"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x00a5
            goto L_0x00bc
        L_0x00a5:
            r8 = 2
            goto L_0x00bc
        L_0x00a7:
            java.lang.String r9 = "padding"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x00b0
            goto L_0x00bc
        L_0x00b0:
            r8 = 1
            goto L_0x00bc
        L_0x00b2:
            java.lang.String r9 = "orientation"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x00bb
            goto L_0x00bc
        L_0x00bb:
            r8 = 0
        L_0x00bc:
            switch(r8) {
                case 0: goto L_0x0226;
                case 1: goto L_0x01bd;
                case 2: goto L_0x019b;
                case 3: goto L_0x018a;
                case 4: goto L_0x017b;
                case 5: goto L_0x016a;
                case 6: goto L_0x012b;
                case 7: goto L_0x0116;
                case 8: goto L_0x0101;
                case 9: goto L_0x00ec;
                case 10: goto L_0x00dd;
                case 11: goto L_0x00c8;
                default: goto L_0x00bf;
            }
        L_0x00bf:
            androidx.constraintlayout.core.state.ConstraintReference r6 = r11.constraints(r12)
            applyAttribute(r11, r13, r6, r14, r5)
            goto L_0x0010
        L_0x00c8:
            androidx.constraintlayout.core.parser.CLElement r5 = r14.get((java.lang.String) r5)
            java.lang.String r5 = r5.content()
            if (r5 == 0) goto L_0x0010
            boolean r6 = r5.contains(r7)
            if (r6 == 0) goto L_0x0010
            r10.setColumnWeights(r5)
            goto L_0x0010
        L_0x00dd:
            androidx.constraintlayout.core.parser.CLElement r5 = r14.get((java.lang.String) r5)
            int r5 = r5.getInt()
            if (r5 <= 0) goto L_0x0010
            r10.setColumnsSet(r5)
            goto L_0x0010
        L_0x00ec:
            androidx.constraintlayout.core.parser.CLElement r5 = r14.get((java.lang.String) r5)
            java.lang.String r5 = r5.content()
            if (r5 == 0) goto L_0x0010
            boolean r6 = r5.contains(r7)
            if (r6 == 0) goto L_0x0010
            r10.setRowWeights(r5)
            goto L_0x0010
        L_0x0101:
            androidx.constraintlayout.core.parser.CLElement r5 = r14.get((java.lang.String) r5)
            java.lang.String r5 = r5.content()
            if (r5 == 0) goto L_0x0010
            boolean r6 = r5.contains(r6)
            if (r6 == 0) goto L_0x0010
            r10.setSpans(r5)
            goto L_0x0010
        L_0x0116:
            androidx.constraintlayout.core.parser.CLElement r5 = r14.get((java.lang.String) r5)
            java.lang.String r5 = r5.content()
            if (r5 == 0) goto L_0x0010
            boolean r6 = r5.contains(r6)
            if (r6 == 0) goto L_0x0010
            r10.setSkips(r5)
            goto L_0x0010
        L_0x012b:
            java.lang.String r6 = ""
            androidx.constraintlayout.core.parser.CLElement r5 = r14.get((java.lang.String) r5)     // Catch:{ Exception -> 0x013a }
            boolean r7 = r5 instanceof androidx.constraintlayout.core.parser.CLNumber     // Catch:{ Exception -> 0x013a }
            if (r7 == 0) goto L_0x013c
            int r5 = r5.getInt()     // Catch:{ Exception -> 0x013a }
            goto L_0x0158
        L_0x013a:
            r5 = move-exception
            goto L_0x0141
        L_0x013c:
            java.lang.String r6 = r5.content()     // Catch:{ Exception -> 0x013a }
            goto L_0x0157
        L_0x0141:
            java.io.PrintStream r7 = java.lang.System.err
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Error parsing grid flags "
            r8.append(r9)
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            r7.println(r5)
        L_0x0157:
            r5 = 0
        L_0x0158:
            if (r6 == 0) goto L_0x0165
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x0165
            r10.setFlags((java.lang.String) r6)
            goto L_0x0010
        L_0x0165:
            r10.setFlags((int) r5)
            goto L_0x0010
        L_0x016a:
            androidx.constraintlayout.core.parser.CLElement r5 = r14.get((java.lang.String) r5)
            float r5 = r5.getFloat()
            float r5 = toPix(r11, r5)
            r10.setVerticalGaps(r5)
            goto L_0x0010
        L_0x017b:
            androidx.constraintlayout.core.parser.CLElement r5 = r14.get((java.lang.String) r5)
            int r5 = r5.getInt()
            if (r5 <= 0) goto L_0x0010
            r10.setRowsSet(r5)
            goto L_0x0010
        L_0x018a:
            androidx.constraintlayout.core.parser.CLElement r5 = r14.get((java.lang.String) r5)
            float r5 = r5.getFloat()
            float r5 = toPix(r11, r5)
            r10.setHorizontalGaps(r5)
            goto L_0x0010
        L_0x019b:
            androidx.constraintlayout.core.parser.CLArray r5 = r14.getArrayOrNull(r5)
            if (r5 == 0) goto L_0x0010
            r6 = 0
        L_0x01a2:
            int r7 = r5.size()
            if (r6 >= r7) goto L_0x0010
            androidx.constraintlayout.core.parser.CLElement r7 = r5.get((int) r6)
            java.lang.String r7 = r7.content()
            androidx.constraintlayout.core.state.ConstraintReference r7 = r11.constraints(r7)
            java.lang.Object[] r8 = new java.lang.Object[r3]
            r8[r2] = r7
            r10.add(r8)
            int r6 = r6 + r3
            goto L_0x01a2
        L_0x01bd:
            androidx.constraintlayout.core.parser.CLElement r5 = r14.get((java.lang.String) r5)
            boolean r6 = r5 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r6 == 0) goto L_0x01f0
            r6 = r5
            androidx.constraintlayout.core.parser.CLArray r6 = (androidx.constraintlayout.core.parser.CLArray) r6
            int r7 = r6.size()
            if (r7 <= r3) goto L_0x01f0
            int r7 = r6.getInt((int) r2)
            float r7 = (float) r7
            int r8 = r6.getInt((int) r3)
            float r8 = (float) r8
            int r9 = r6.size()
            if (r9 <= r1) goto L_0x01ed
            int r6 = r6.getInt((int) r1)
            float r6 = (float) r6
            androidx.constraintlayout.core.parser.CLArray r5 = (androidx.constraintlayout.core.parser.CLArray) r5     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01eb }
            int r5 = r5.getInt((int) r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01eb }
            float r5 = (float) r5
            goto L_0x01f8
        L_0x01eb:
            r5 = 0
            goto L_0x01f8
        L_0x01ed:
            r6 = r7
            r5 = r8
            goto L_0x01f8
        L_0x01f0:
            int r5 = r5.getInt()
            float r7 = (float) r5
            r5 = r7
            r6 = r5
            r8 = r6
        L_0x01f8:
            float r7 = toPix(r11, r7)
            int r7 = java.lang.Math.round(r7)
            r10.setPaddingStart(r7)
            float r7 = toPix(r11, r8)
            int r7 = java.lang.Math.round(r7)
            r10.setPaddingTop(r7)
            float r6 = toPix(r11, r6)
            int r6 = java.lang.Math.round(r6)
            r10.setPaddingEnd(r6)
            float r5 = toPix(r11, r5)
            int r5 = java.lang.Math.round(r5)
            r10.setPaddingBottom(r5)
            goto L_0x0010
        L_0x0226:
            androidx.constraintlayout.core.parser.CLElement r5 = r14.get((java.lang.String) r5)
            int r5 = r5.getInt()
            r10.setOrientation(r5)
            goto L_0x0010
        L_0x0233:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseGridType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r3 = (androidx.constraintlayout.core.parser.CLObject) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void parseGuideline(int r1, androidx.constraintlayout.core.state.State r2, androidx.constraintlayout.core.parser.CLArray r3) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = 1
            androidx.constraintlayout.core.parser.CLElement r3 = r3.get((int) r0)
            boolean r0 = r3 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r0 != 0) goto L_0x000a
            return
        L_0x000a:
            androidx.constraintlayout.core.parser.CLObject r3 = (androidx.constraintlayout.core.parser.CLObject) r3
            java.lang.String r0 = "id"
            java.lang.String r0 = r3.getStringOrNull((java.lang.String) r0)
            if (r0 != 0) goto L_0x0015
            return
        L_0x0015:
            parseGuidelineParams(r1, r2, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseGuideline(int, androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.parser.CLArray):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0107, code lost:
        r14 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void parseGuidelineParams(int r18, androidx.constraintlayout.core.state.State r19, java.lang.String r20, androidx.constraintlayout.core.parser.CLObject r21) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = r19
            r1 = r21
            java.lang.String r2 = "start"
            java.lang.String r4 = "right"
            java.lang.String r6 = "left"
            java.lang.String r7 = "end"
            r8 = -1
            r9 = 0
            r10 = 1
            java.util.ArrayList r11 = r21.names()
            if (r11 != 0) goto L_0x0016
            return
        L_0x0016:
            androidx.constraintlayout.core.state.ConstraintReference r12 = r19.constraints(r20)
            if (r18 != 0) goto L_0x0020
            r19.horizontalGuideline(r20)
            goto L_0x0023
        L_0x0020:
            r19.verticalGuideline(r20)
        L_0x0023:
            boolean r13 = r19.isRtl()
            if (r13 == 0) goto L_0x002e
            if (r18 != 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r13 = 0
            goto L_0x002f
        L_0x002e:
            r13 = 1
        L_0x002f:
            androidx.constraintlayout.core.state.helpers.Facade r12 = r12.getFacade()
            androidx.constraintlayout.core.state.helpers.GuidelineReference r12 = (androidx.constraintlayout.core.state.helpers.GuidelineReference) r12
            java.util.Iterator r11 = r11.iterator()
            r14 = 0
            r15 = 0
        L_0x003b:
            r16 = 1
        L_0x003d:
            boolean r17 = r11.hasNext()
            if (r17 == 0) goto L_0x0117
            java.lang.Object r17 = r11.next()
            r3 = r17
            java.lang.String r3 = (java.lang.String) r3
            r3.hashCode()
            int r17 = r3.hashCode()
            switch(r17) {
                case -678927291: goto L_0x007d;
                case 100571: goto L_0x0074;
                case 3317767: goto L_0x006b;
                case 108511772: goto L_0x0062;
                case 109757538: goto L_0x0057;
                default: goto L_0x0055;
            }
        L_0x0055:
            r5 = -1
            goto L_0x0087
        L_0x0057:
            boolean r17 = r3.equals(r2)
            if (r17 != 0) goto L_0x005e
            goto L_0x0055
        L_0x005e:
            r17 = 4
            r5 = 4
            goto L_0x0087
        L_0x0062:
            boolean r17 = r3.equals(r4)
            if (r17 != 0) goto L_0x0069
            goto L_0x0055
        L_0x0069:
            r5 = 3
            goto L_0x0087
        L_0x006b:
            boolean r17 = r3.equals(r6)
            if (r17 != 0) goto L_0x0072
            goto L_0x0055
        L_0x0072:
            r5 = 2
            goto L_0x0087
        L_0x0074:
            boolean r17 = r3.equals(r7)
            if (r17 != 0) goto L_0x007b
            goto L_0x0055
        L_0x007b:
            r5 = 1
            goto L_0x0087
        L_0x007d:
            java.lang.String r5 = "percent"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x0086
            goto L_0x0055
        L_0x0086:
            r5 = 0
        L_0x0087:
            switch(r5) {
                case 0: goto L_0x00b9;
                case 1: goto L_0x00ad;
                case 2: goto L_0x00a3;
                case 3: goto L_0x0097;
                case 4: goto L_0x008b;
                default: goto L_0x008a;
            }
        L_0x008a:
            goto L_0x003d
        L_0x008b:
            float r3 = r1.getFloat((java.lang.String) r3)
            float r3 = toPix(r0, r3)
            r14 = r3
            r16 = r13
            goto L_0x003d
        L_0x0097:
            float r3 = r1.getFloat((java.lang.String) r3)
            float r3 = toPix(r0, r3)
            r14 = r3
        L_0x00a0:
            r16 = 0
            goto L_0x003d
        L_0x00a3:
            float r3 = r1.getFloat((java.lang.String) r3)
            float r3 = toPix(r0, r3)
            r14 = r3
            goto L_0x003b
        L_0x00ad:
            float r3 = r1.getFloat((java.lang.String) r3)
            float r3 = toPix(r0, r3)
            r16 = r13 ^ 1
            r14 = r3
            goto L_0x003d
        L_0x00b9:
            androidx.constraintlayout.core.parser.CLArray r5 = r1.getArrayOrNull(r3)
            if (r5 != 0) goto L_0x00c7
            float r3 = r1.getFloat((java.lang.String) r3)
            r14 = r3
        L_0x00c4:
            r15 = 1
            goto L_0x003b
        L_0x00c7:
            int r3 = r5.size()
            if (r3 <= r10) goto L_0x0108
            java.lang.String r3 = r5.getString((int) r9)
            float r5 = r5.getFloat((int) r10)
            r3.hashCode()
            int r14 = r3.hashCode()
            switch(r14) {
                case 100571: goto L_0x00fc;
                case 3317767: goto L_0x00f3;
                case 108511772: goto L_0x00ea;
                case 109757538: goto L_0x00e1;
                default: goto L_0x00df;
            }
        L_0x00df:
            r3 = -1
            goto L_0x0104
        L_0x00e1:
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L_0x00e8
            goto L_0x00df
        L_0x00e8:
            r3 = 3
            goto L_0x0104
        L_0x00ea:
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00f1
            goto L_0x00df
        L_0x00f1:
            r3 = 2
            goto L_0x0104
        L_0x00f3:
            boolean r3 = r3.equals(r6)
            if (r3 != 0) goto L_0x00fa
            goto L_0x00df
        L_0x00fa:
            r3 = 1
            goto L_0x0104
        L_0x00fc:
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x0103
            goto L_0x00df
        L_0x0103:
            r3 = 0
        L_0x0104:
            switch(r3) {
                case 0: goto L_0x0114;
                case 1: goto L_0x0112;
                case 2: goto L_0x010f;
                case 3: goto L_0x010b;
                default: goto L_0x0107;
            }
        L_0x0107:
            r14 = r5
        L_0x0108:
            r15 = 1
            goto L_0x003d
        L_0x010b:
            r14 = r5
            r16 = r13
            goto L_0x0108
        L_0x010f:
            r14 = r5
            r15 = 1
            goto L_0x00a0
        L_0x0112:
            r14 = r5
            goto L_0x00c4
        L_0x0114:
            r16 = r13 ^ 1
            goto L_0x0107
        L_0x0117:
            if (r15 == 0) goto L_0x0126
            if (r16 == 0) goto L_0x011f
            r12.percent(r14)
            goto L_0x0137
        L_0x011f:
            r0 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 - r14
            r12.percent(r0)
            goto L_0x0137
        L_0x0126:
            if (r16 == 0) goto L_0x0130
            java.lang.Float r0 = java.lang.Float.valueOf(r14)
            r12.start(r0)
            goto L_0x0137
        L_0x0130:
            java.lang.Float r0 = java.lang.Float.valueOf(r14)
            r12.end(r0)
        L_0x0137:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseGuidelineParams(int, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.parser.CLObject):void");
    }

    public static void parseHeader(CoreMotionScene coreMotionScene, CLObject cLObject) {
        String stringOrNull = cLObject.getStringOrNull("export");
        if (stringOrNull != null) {
            coreMotionScene.setDebugName(stringOrNull);
        }
    }

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
            if (names != null) {
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
            }
        } catch (CLParsingException e) {
            PrintStream printStream = System.err;
            printStream.println("Error parsing JSON " + e);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseMotionProperties(androidx.constraintlayout.core.parser.CLElement r13, androidx.constraintlayout.core.state.ConstraintReference r14) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            r3 = -1
            boolean r4 = r13 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r4 != 0) goto L_0x0009
            return
        L_0x0009:
            androidx.constraintlayout.core.parser.CLObject r13 = (androidx.constraintlayout.core.parser.CLObject) r13
            androidx.constraintlayout.core.motion.utils.TypedBundle r4 = new androidx.constraintlayout.core.motion.utils.TypedBundle
            r4.<init>()
            java.util.ArrayList r5 = r13.names()
            if (r5 != 0) goto L_0x0017
            return
        L_0x0017:
            java.util.Iterator r5 = r5.iterator()
        L_0x001b:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x010c
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            r6.hashCode()
            int r7 = r6.hashCode()
            switch(r7) {
                case -1897525331: goto L_0x005f;
                case -1310311125: goto L_0x0054;
                case -1285003983: goto L_0x0049;
                case -791482387: goto L_0x003e;
                case -236944793: goto L_0x0033;
                default: goto L_0x0031;
            }
        L_0x0031:
            r7 = -1
            goto L_0x0069
        L_0x0033:
            java.lang.String r7 = "relativeTo"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x003c
            goto L_0x0031
        L_0x003c:
            r7 = 4
            goto L_0x0069
        L_0x003e:
            java.lang.String r7 = "pathArc"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0047
            goto L_0x0031
        L_0x0047:
            r7 = 3
            goto L_0x0069
        L_0x0049:
            java.lang.String r7 = "quantize"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0052
            goto L_0x0031
        L_0x0052:
            r7 = 2
            goto L_0x0069
        L_0x0054:
            java.lang.String r7 = "easing"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x005d
            goto L_0x0031
        L_0x005d:
            r7 = 1
            goto L_0x0069
        L_0x005f:
            java.lang.String r7 = "stagger"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0068
            goto L_0x0031
        L_0x0068:
            r7 = 0
        L_0x0069:
            switch(r7) {
                case 0: goto L_0x0101;
                case 1: goto L_0x00f6;
                case 2: goto L_0x00bc;
                case 3: goto L_0x0077;
                case 4: goto L_0x006d;
                default: goto L_0x006c;
            }
        L_0x006c:
            goto L_0x001b
        L_0x006d:
            r7 = 605(0x25d, float:8.48E-43)
            java.lang.String r6 = r13.getString((java.lang.String) r6)
            r4.add((int) r7, (java.lang.String) r6)
            goto L_0x001b
        L_0x0077:
            java.lang.String r6 = r13.getString((java.lang.String) r6)
            java.lang.String r11 = "below"
            java.lang.String r12 = "above"
            java.lang.String r7 = "none"
            java.lang.String r8 = "startVertical"
            java.lang.String r9 = "startHorizontal"
            java.lang.String r10 = "flip"
            java.lang.String[] r7 = new java.lang.String[]{r7, r8, r9, r10, r11, r12}
            int r7 = indexOf(r6, r7)
            if (r7 != r3) goto L_0x00b5
            java.io.PrintStream r7 = java.lang.System.err
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r9 = r13.getLine()
            r8.append(r9)
            java.lang.String r9 = " pathArc = '"
            r8.append(r9)
            r8.append(r6)
            java.lang.String r6 = "'"
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.println(r6)
            goto L_0x001b
        L_0x00b5:
            r6 = 607(0x25f, float:8.5E-43)
            r4.add((int) r6, (int) r7)
            goto L_0x001b
        L_0x00bc:
            androidx.constraintlayout.core.parser.CLElement r7 = r13.get((java.lang.String) r6)
            boolean r8 = r7 instanceof androidx.constraintlayout.core.parser.CLArray
            r9 = 610(0x262, float:8.55E-43)
            if (r8 == 0) goto L_0x00ed
            androidx.constraintlayout.core.parser.CLArray r7 = (androidx.constraintlayout.core.parser.CLArray) r7
            int r6 = r7.size()
            if (r6 <= 0) goto L_0x001b
            int r8 = r7.getInt((int) r2)
            r4.add((int) r9, (int) r8)
            if (r6 <= r1) goto L_0x001b
            r8 = 611(0x263, float:8.56E-43)
            java.lang.String r9 = r7.getString((int) r1)
            r4.add((int) r8, (java.lang.String) r9)
            if (r6 <= r0) goto L_0x001b
            r6 = 602(0x25a, float:8.44E-43)
            float r7 = r7.getFloat((int) r0)
            r4.add((int) r6, (float) r7)
            goto L_0x001b
        L_0x00ed:
            int r6 = r13.getInt((java.lang.String) r6)
            r4.add((int) r9, (int) r6)
            goto L_0x001b
        L_0x00f6:
            r7 = 603(0x25b, float:8.45E-43)
            java.lang.String r6 = r13.getString((java.lang.String) r6)
            r4.add((int) r7, (java.lang.String) r6)
            goto L_0x001b
        L_0x0101:
            r7 = 600(0x258, float:8.41E-43)
            float r6 = r13.getFloat((java.lang.String) r6)
            r4.add((int) r7, (float) r6)
            goto L_0x001b
        L_0x010c:
            r14.mMotionProperties = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseMotionProperties(androidx.constraintlayout.core.parser.CLElement, androidx.constraintlayout.core.state.ConstraintReference):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005e A[Catch:{ CLParsingException -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b A[Catch:{ CLParsingException -> 0x0045 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void parseMotionSceneJSON(androidx.constraintlayout.core.state.CoreMotionScene r7, java.lang.String r8) {
        /*
            androidx.constraintlayout.core.parser.CLObject r8 = androidx.constraintlayout.core.parser.CLParser.parse(r8)     // Catch:{ CLParsingException -> 0x0045 }
            java.util.ArrayList r0 = r8.names()     // Catch:{ CLParsingException -> 0x0045 }
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            java.util.Iterator r0 = r0.iterator()     // Catch:{ CLParsingException -> 0x0045 }
        L_0x000f:
            boolean r1 = r0.hasNext()     // Catch:{ CLParsingException -> 0x0045 }
            if (r1 == 0) goto L_0x0085
            java.lang.Object r1 = r0.next()     // Catch:{ CLParsingException -> 0x0045 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ CLParsingException -> 0x0045 }
            androidx.constraintlayout.core.parser.CLElement r2 = r8.get((java.lang.String) r1)     // Catch:{ CLParsingException -> 0x0045 }
            boolean r3 = r2 instanceof androidx.constraintlayout.core.parser.CLObject     // Catch:{ CLParsingException -> 0x0045 }
            if (r3 == 0) goto L_0x000f
            androidx.constraintlayout.core.parser.CLObject r2 = (androidx.constraintlayout.core.parser.CLObject) r2     // Catch:{ CLParsingException -> 0x0045 }
            int r3 = r1.hashCode()     // Catch:{ CLParsingException -> 0x0045 }
            r4 = -2137403731(0xffffffff8099cead, float:-1.4124972E-38)
            r5 = 2
            r6 = 1
            if (r3 == r4) goto L_0x0051
            r4 = -241441378(0xfffffffff19be59e, float:-1.5439285E30)
            if (r3 == r4) goto L_0x0047
            r4 = 1101852654(0x41acefee, float:21.617153)
            if (r3 == r4) goto L_0x003b
            goto L_0x005b
        L_0x003b:
            java.lang.String r3 = "ConstraintSets"
            boolean r1 = r1.equals(r3)     // Catch:{ CLParsingException -> 0x0045 }
            if (r1 == 0) goto L_0x005b
            r1 = 0
            goto L_0x005c
        L_0x0045:
            r7 = move-exception
            goto L_0x006f
        L_0x0047:
            java.lang.String r3 = "Transitions"
            boolean r1 = r1.equals(r3)     // Catch:{ CLParsingException -> 0x0045 }
            if (r1 == 0) goto L_0x005b
            r1 = 1
            goto L_0x005c
        L_0x0051:
            java.lang.String r3 = "Header"
            boolean r1 = r1.equals(r3)     // Catch:{ CLParsingException -> 0x0045 }
            if (r1 == 0) goto L_0x005b
            r1 = 2
            goto L_0x005c
        L_0x005b:
            r1 = -1
        L_0x005c:
            if (r1 == 0) goto L_0x006b
            if (r1 == r6) goto L_0x0067
            if (r1 == r5) goto L_0x0063
            goto L_0x000f
        L_0x0063:
            parseHeader(r7, r2)     // Catch:{ CLParsingException -> 0x0045 }
            goto L_0x000f
        L_0x0067:
            parseTransitions(r7, r2)     // Catch:{ CLParsingException -> 0x0045 }
            goto L_0x000f
        L_0x006b:
            parseConstraintSets(r7, r2)     // Catch:{ CLParsingException -> 0x0045 }
            goto L_0x000f
        L_0x006f:
            java.io.PrintStream r8 = java.lang.System.err
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error parsing JSON "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.println(r7)
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseMotionSceneJSON(androidx.constraintlayout.core.state.CoreMotionScene, java.lang.String):void");
    }

    public static void parseTransitions(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names != null) {
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                String next = it.next();
                coreMotionScene.setTransitionContent(next, cLObject.getObject(next).toJSON());
            }
        }
    }

    private static void parseVariables(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names != null) {
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                String next = it.next();
                CLElement cLElement = cLObject.get(next);
                if (cLElement instanceof CLNumber) {
                    layoutVariables.put(next, cLElement.getInt());
                } else if (cLElement instanceof CLObject) {
                    CLObject cLObject2 = (CLObject) cLElement;
                    if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has("to")) {
                        float f = layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_FROM));
                        layoutVariables.put(next, f, layoutVariables.get(cLObject2.get("to")), 1.0f, cLObject2.getStringOrNull(RequestParameters.PREFIX), cLObject2.getStringOrNull("postfix"));
                    } else if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has("step")) {
                        layoutVariables.put(next, layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_FROM)), layoutVariables.get(cLObject2.get("step")));
                    } else if (cLObject2.has("ids")) {
                        CLArray array = cLObject2.getArray("ids");
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < array.size(); i++) {
                            arrayList.add(array.getString(i));
                        }
                        layoutVariables.put(next, (ArrayList<String>) arrayList);
                    } else if (cLObject2.has("tag")) {
                        layoutVariables.put(next, state.getIdsForTag(cLObject2.getString("tag")));
                    }
                }
            }
        }
    }

    public static void parseWidget(State state, LayoutVariables layoutVariables, String str, CLObject cLObject) throws CLParsingException {
        parseWidget(state, layoutVariables, state.constraints(str), cLObject);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void populateState(@androidx.annotation.NonNull androidx.constraintlayout.core.parser.CLObject r9, @androidx.annotation.NonNull androidx.constraintlayout.core.state.State r10, @androidx.annotation.NonNull androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r11) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = 2
            r1 = -1
            r2 = 1
            r3 = 0
            java.util.ArrayList r4 = r9.names()
            if (r4 != 0) goto L_0x000b
            return
        L_0x000b:
            java.util.Iterator r4 = r4.iterator()
        L_0x000f:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x012b
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            androidx.constraintlayout.core.parser.CLElement r6 = r9.get((java.lang.String) r5)
            r5.hashCode()
            int r7 = r5.hashCode()
            switch(r7) {
                case -1824489883: goto L_0x0041;
                case 1875016085: goto L_0x0036;
                case 1921490263: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            r7 = -1
            goto L_0x004b
        L_0x002b:
            java.lang.String r7 = "Variables"
            boolean r7 = r5.equals(r7)
            if (r7 != 0) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            r7 = 2
            goto L_0x004b
        L_0x0036:
            java.lang.String r7 = "Generate"
            boolean r7 = r5.equals(r7)
            if (r7 != 0) goto L_0x003f
            goto L_0x0029
        L_0x003f:
            r7 = 1
            goto L_0x004b
        L_0x0041:
            java.lang.String r7 = "Helpers"
            boolean r7 = r5.equals(r7)
            if (r7 != 0) goto L_0x004a
            goto L_0x0029
        L_0x004a:
            r7 = 0
        L_0x004b:
            switch(r7) {
                case 0: goto L_0x0120;
                case 1: goto L_0x0115;
                case 2: goto L_0x010a;
                default: goto L_0x004e;
            }
        L_0x004e:
            boolean r7 = r6 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r7 == 0) goto L_0x00fd
            androidx.constraintlayout.core.parser.CLObject r6 = (androidx.constraintlayout.core.parser.CLObject) r6
            java.lang.String r7 = lookForType(r6)
            if (r7 == 0) goto L_0x00f8
            int r8 = r7.hashCode()
            switch(r8) {
                case -1785507558: goto L_0x00cb;
                case -1354837162: goto L_0x00c0;
                case -1252464839: goto L_0x00b5;
                case -851656725: goto L_0x00aa;
                case -333143113: goto L_0x009f;
                case 113114: goto L_0x0094;
                case 3181382: goto L_0x0089;
                case 98238902: goto L_0x007e;
                case 111168196: goto L_0x0071;
                case 965681512: goto L_0x0064;
                default: goto L_0x0061;
            }
        L_0x0061:
            r8 = -1
            goto L_0x00d5
        L_0x0064:
            java.lang.String r8 = "hGuideline"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x006d
            goto L_0x0061
        L_0x006d:
            r8 = 9
            goto L_0x00d5
        L_0x0071:
            java.lang.String r8 = "vFlow"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x007a
            goto L_0x0061
        L_0x007a:
            r8 = 8
            goto L_0x00d5
        L_0x007e:
            java.lang.String r8 = "hFlow"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x0087
            goto L_0x0061
        L_0x0087:
            r8 = 7
            goto L_0x00d5
        L_0x0089:
            java.lang.String r8 = "grid"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x0092
            goto L_0x0061
        L_0x0092:
            r8 = 6
            goto L_0x00d5
        L_0x0094:
            java.lang.String r8 = "row"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x009d
            goto L_0x0061
        L_0x009d:
            r8 = 5
            goto L_0x00d5
        L_0x009f:
            java.lang.String r8 = "barrier"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x00a8
            goto L_0x0061
        L_0x00a8:
            r8 = 4
            goto L_0x00d5
        L_0x00aa:
            java.lang.String r8 = "vChain"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x00b3
            goto L_0x0061
        L_0x00b3:
            r8 = 3
            goto L_0x00d5
        L_0x00b5:
            java.lang.String r8 = "hChain"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x00be
            goto L_0x0061
        L_0x00be:
            r8 = 2
            goto L_0x00d5
        L_0x00c0:
            java.lang.String r8 = "column"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x00c9
            goto L_0x0061
        L_0x00c9:
            r8 = 1
            goto L_0x00d5
        L_0x00cb:
            java.lang.String r8 = "vGuideline"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x00d4
            goto L_0x0061
        L_0x00d4:
            r8 = 0
        L_0x00d5:
            switch(r8) {
                case 0: goto L_0x00f3;
                case 1: goto L_0x00ee;
                case 2: goto L_0x00e9;
                case 3: goto L_0x00e9;
                case 4: goto L_0x00e4;
                case 5: goto L_0x00ee;
                case 6: goto L_0x00ee;
                case 7: goto L_0x00df;
                case 8: goto L_0x00df;
                case 9: goto L_0x00da;
                default: goto L_0x00d8;
            }
        L_0x00d8:
            goto L_0x000f
        L_0x00da:
            parseGuidelineParams(r3, r10, r5, r6)
            goto L_0x000f
        L_0x00df:
            parseFlowType(r7, r10, r5, r11, r6)
            goto L_0x000f
        L_0x00e4:
            parseBarrier(r10, r5, r6)
            goto L_0x000f
        L_0x00e9:
            parseChainType(r7, r10, r5, r11, r6)
            goto L_0x000f
        L_0x00ee:
            parseGridType(r7, r10, r5, r11, r6)
            goto L_0x000f
        L_0x00f3:
            parseGuidelineParams(r2, r10, r5, r6)
            goto L_0x000f
        L_0x00f8:
            parseWidget((androidx.constraintlayout.core.state.State) r10, (androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables) r11, (java.lang.String) r5, (androidx.constraintlayout.core.parser.CLObject) r6)
            goto L_0x000f
        L_0x00fd:
            boolean r7 = r6 instanceof androidx.constraintlayout.core.parser.CLNumber
            if (r7 == 0) goto L_0x000f
            int r6 = r6.getInt()
            r11.put((java.lang.String) r5, (int) r6)
            goto L_0x000f
        L_0x010a:
            boolean r5 = r6 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r5 == 0) goto L_0x000f
            androidx.constraintlayout.core.parser.CLObject r6 = (androidx.constraintlayout.core.parser.CLObject) r6
            parseVariables(r10, r11, r6)
            goto L_0x000f
        L_0x0115:
            boolean r5 = r6 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r5 == 0) goto L_0x000f
            androidx.constraintlayout.core.parser.CLObject r6 = (androidx.constraintlayout.core.parser.CLObject) r6
            parseGenerate(r10, r11, r6)
            goto L_0x000f
        L_0x0120:
            boolean r5 = r6 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r5 == 0) goto L_0x000f
            androidx.constraintlayout.core.parser.CLArray r6 = (androidx.constraintlayout.core.parser.CLArray) r6
            parseHelpers(r10, r11, r6)
            goto L_0x000f
        L_0x012b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.populateState(androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables):void");
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
        if (names != null) {
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                applyAttribute(state, layoutVariables, constraintReference, cLObject, it.next());
            }
        }
    }

    public static void parseJSON(String str, State state, LayoutVariables layoutVariables) throws CLParsingException {
        try {
            populateState(CLParser.parse(str), state, layoutVariables);
        } catch (CLParsingException e) {
            PrintStream printStream = System.err;
            printStream.println("Error parsing JSON " + e);
        }
    }
}
