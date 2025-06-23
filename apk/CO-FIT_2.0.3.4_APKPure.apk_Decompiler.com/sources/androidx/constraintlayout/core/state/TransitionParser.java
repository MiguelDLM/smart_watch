package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLContainer;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import java.lang.reflect.Array;

public class TransitionParser {
    private static int map(String str, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                return i;
            }
        }
        return 0;
    }

    @Deprecated
    public static void parse(CLObject cLObject, Transition transition, CorePixelDp corePixelDp) throws CLParsingException {
        parse(cLObject, transition);
    }

    private static void parseKeyAttribute(CLObject cLObject, Transition transition) throws CLParsingException {
        CLArray arrayOrNull;
        CustomVariable[][] customVariableArr;
        CustomVariable[] customVariableArr2;
        CLObject cLObject2;
        int i;
        int i2;
        CLObject cLObject3 = cLObject;
        Transition transition2 = transition;
        int i3 = 9;
        int i4 = 1;
        CLArray arrayOrNull2 = cLObject3.getArrayOrNull("target");
        if (arrayOrNull2 != null && (arrayOrNull = cLObject3.getArrayOrNull("frames")) != null) {
            String stringOrNull = cLObject3.getStringOrNull("transitionEasing");
            String[] strArr = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha"};
            int[] iArr = {311, 312, 304, 305, 306, 308, 309, 310, 303};
            boolean[] zArr = {false, false, true, true, true, false, false, false, false};
            int size = arrayOrNull.size();
            TypedBundle[] typedBundleArr = new TypedBundle[size];
            for (int i5 = 0; i5 < arrayOrNull.size(); i5++) {
                typedBundleArr[i5] = new TypedBundle();
            }
            int i6 = 0;
            while (i6 < i3) {
                String str = strArr[i6];
                int i7 = iArr[i6];
                boolean z = zArr[i6];
                CLArray arrayOrNull3 = cLObject3.getArrayOrNull(str);
                if (arrayOrNull3 == null || arrayOrNull3.size() == size) {
                    if (arrayOrNull3 != null) {
                        for (int i8 = 0; i8 < size; i8++) {
                            float f = arrayOrNull3.getFloat(i8);
                            if (z) {
                                f = transition2.mToPixel.toPixels(f);
                            }
                            typedBundleArr[i8].add(i7, f);
                            i4 = 1;
                        }
                    } else {
                        float floatOrNaN = cLObject3.getFloatOrNaN(str);
                        if (!Float.isNaN(floatOrNaN)) {
                            if (z) {
                                floatOrNaN = transition2.mToPixel.toPixels(floatOrNaN);
                            }
                            for (int i9 = 0; i9 < size; i9++) {
                                typedBundleArr[i9].add(i7, floatOrNaN);
                            }
                        }
                        i4 = 1;
                    }
                    i6 += i4;
                    i3 = 9;
                } else {
                    throw new CLParsingException("incorrect size for " + str + " array, not matching targets array!", cLObject3);
                }
            }
            CLElement orNull = cLObject3.getOrNull("custom");
            if (orNull == null || !(orNull instanceof CLObject)) {
                customVariableArr = null;
            } else {
                CLObject cLObject4 = (CLObject) orNull;
                int size2 = cLObject4.size();
                int size3 = arrayOrNull.size();
                int[] iArr2 = new int[2];
                iArr2[1] = size2;
                iArr2[0] = size3;
                customVariableArr = (CustomVariable[][]) Array.newInstance(CustomVariable.class, iArr2);
                int i10 = 0;
                while (i10 < size2) {
                    CLKey cLKey = (CLKey) cLObject4.get(i10);
                    String content = cLKey.content();
                    if (cLKey.getValue() instanceof CLArray) {
                        CLArray cLArray = (CLArray) cLKey.getValue();
                        int size4 = cLArray.size();
                        if (size4 == size && size4 > 0) {
                            if (cLArray.get(0) instanceof CLNumber) {
                                int i11 = 0;
                                while (i11 < size) {
                                    customVariableArr[i11][i10] = new CustomVariable(content, 901, cLArray.get(i11).getFloat());
                                    i11++;
                                    cLObject4 = cLObject4;
                                }
                            } else {
                                cLObject2 = cLObject4;
                                int i12 = 0;
                                while (i12 < size) {
                                    long parseColorString = ConstraintSetParser.parseColorString(cLArray.get(i12).content());
                                    if (parseColorString != -1) {
                                        i2 = size2;
                                        customVariableArr[i12][i10] = new CustomVariable(content, 902, (int) parseColorString);
                                    } else {
                                        i2 = size2;
                                    }
                                    i12++;
                                    size2 = i2;
                                }
                                i = size2;
                            }
                        }
                        cLObject2 = cLObject4;
                        i = size2;
                    } else {
                        cLObject2 = cLObject4;
                        i = size2;
                        CLElement value = cLKey.getValue();
                        if (value instanceof CLNumber) {
                            float f2 = value.getFloat();
                            for (int i13 = 0; i13 < size; i13++) {
                                customVariableArr[i13][i10] = new CustomVariable(content, 901, f2);
                            }
                        } else {
                            long parseColorString2 = ConstraintSetParser.parseColorString(value.content());
                            if (parseColorString2 != -1) {
                                int i14 = 0;
                                while (i14 < size) {
                                    customVariableArr[i14][i10] = new CustomVariable(content, 902, (int) parseColorString2);
                                    i14++;
                                    parseColorString2 = parseColorString2;
                                }
                            }
                        }
                    }
                    i10++;
                    cLObject4 = cLObject2;
                    size2 = i;
                }
            }
            String stringOrNull2 = cLObject3.getStringOrNull("curveFit");
            for (int i15 = 0; i15 < arrayOrNull2.size(); i15++) {
                for (int i16 = 0; i16 < size; i16++) {
                    String string = arrayOrNull2.getString(i15);
                    TypedBundle typedBundle = typedBundleArr[i16];
                    if (stringOrNull2 != null) {
                        typedBundle.add(508, map(stringOrNull2, "spline", "linear"));
                    }
                    typedBundle.addIfNotNull(501, stringOrNull);
                    typedBundle.add(100, arrayOrNull.getInt(i16));
                    if (customVariableArr != null) {
                        customVariableArr2 = customVariableArr[i16];
                    } else {
                        customVariableArr2 = null;
                    }
                    transition2.addKeyAttribute(string, typedBundle, customVariableArr2);
                }
            }
        }
    }

    private static void parseKeyCycle(CLObject cLObject, Transition transition) throws CLParsingException {
        int[] iArr;
        CLObject cLObject2 = cLObject;
        Transition transition2 = transition;
        CLArray array = cLObject2.getArray("target");
        CLArray array2 = cLObject2.getArray("frames");
        String stringOrNull = cLObject2.getStringOrNull("transitionEasing");
        String[] strArr = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha", TypedValues.CycleType.S_WAVE_PERIOD, TypedValues.CycleType.S_WAVE_OFFSET, TypedValues.CycleType.S_WAVE_PHASE};
        int i = 12;
        int[] iArr2 = {311, 312, 304, 305, 306, 308, 309, 310, 403, 423, 424, 425};
        int[] iArr3 = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 2, 0};
        int size = array2.size();
        TypedBundle[] typedBundleArr = new TypedBundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            typedBundleArr[i2] = new TypedBundle();
        }
        boolean z = false;
        for (int i3 = 0; i3 < 12; i3++) {
            if (cLObject2.has(strArr[i3]) && iArr3[i3] == 1) {
                z = true;
            }
        }
        int i4 = 0;
        while (i4 < i) {
            String str = strArr[i4];
            int i5 = iArr2[i4];
            int i6 = iArr3[i4];
            CLArray arrayOrNull = cLObject2.getArrayOrNull(str);
            String[] strArr2 = strArr;
            if (arrayOrNull == null || arrayOrNull.size() == size) {
                if (arrayOrNull != null) {
                    int i7 = 0;
                    while (i7 < size) {
                        float f = arrayOrNull.getFloat(i7);
                        int[] iArr4 = iArr2;
                        if (i6 == 1) {
                            f = transition2.mToPixel.toPixels(f);
                        } else if (i6 == 2 && z) {
                            f = transition2.mToPixel.toPixels(f);
                        }
                        typedBundleArr[i7].add(i5, f);
                        i7++;
                        iArr2 = iArr4;
                    }
                    iArr = iArr2;
                } else {
                    iArr = iArr2;
                    float floatOrNaN = cLObject2.getFloatOrNaN(str);
                    if (!Float.isNaN(floatOrNaN)) {
                        if (i6 == 1) {
                            floatOrNaN = transition2.mToPixel.toPixels(floatOrNaN);
                        } else if (i6 == 2 && z) {
                            floatOrNaN = transition2.mToPixel.toPixels(floatOrNaN);
                        }
                        for (int i8 = 0; i8 < size; i8++) {
                            typedBundleArr[i8].add(i5, floatOrNaN);
                        }
                        i4++;
                        strArr = strArr2;
                        iArr2 = iArr;
                        i = 12;
                    }
                }
                i4++;
                strArr = strArr2;
                iArr2 = iArr;
                i = 12;
            } else {
                throw new CLParsingException("incorrect size for $attrName array, not matching targets array!", cLObject2);
            }
        }
        String stringOrNull2 = cLObject2.getStringOrNull("curveFit");
        String stringOrNull3 = cLObject2.getStringOrNull("easing");
        String stringOrNull4 = cLObject2.getStringOrNull("waveShape");
        String stringOrNull5 = cLObject2.getStringOrNull(TypedValues.CycleType.S_CUSTOM_WAVE_SHAPE);
        for (int i9 = 0; i9 < array.size(); i9++) {
            for (int i10 = 0; i10 < size; i10++) {
                String string = array.getString(i9);
                TypedBundle typedBundle = typedBundleArr[i10];
                if (stringOrNull2 != null) {
                    if (stringOrNull2.equals("linear")) {
                        typedBundle.add(401, 1);
                    } else if (stringOrNull2.equals("spline")) {
                        typedBundle.add(401, 0);
                    }
                }
                typedBundle.addIfNotNull(501, stringOrNull);
                if (stringOrNull3 != null) {
                    typedBundle.add(420, stringOrNull3);
                }
                if (stringOrNull4 != null) {
                    typedBundle.add(421, stringOrNull4);
                }
                if (stringOrNull5 != null) {
                    typedBundle.add(422, stringOrNull5);
                }
                typedBundle.add(100, array2.getInt(i10));
                transition2.addKeyCycle(string, typedBundle);
            }
        }
    }

    public static void parseKeyFrames(CLObject cLObject, Transition transition) throws CLParsingException {
        CLObject objectOrNull = cLObject.getObjectOrNull("KeyFrames");
        if (objectOrNull != null) {
            CLArray arrayOrNull = objectOrNull.getArrayOrNull("KeyPositions");
            if (arrayOrNull != null) {
                for (int i = 0; i < arrayOrNull.size(); i++) {
                    CLElement cLElement = arrayOrNull.get(i);
                    if (cLElement instanceof CLObject) {
                        parseKeyPosition((CLObject) cLElement, transition);
                    }
                }
            }
            CLArray arrayOrNull2 = objectOrNull.getArrayOrNull(TypedValues.AttributesType.NAME);
            if (arrayOrNull2 != null) {
                for (int i2 = 0; i2 < arrayOrNull2.size(); i2++) {
                    CLElement cLElement2 = arrayOrNull2.get(i2);
                    if (cLElement2 instanceof CLObject) {
                        parseKeyAttribute((CLObject) cLElement2, transition);
                    }
                }
            }
            CLArray arrayOrNull3 = objectOrNull.getArrayOrNull("KeyCycles");
            if (arrayOrNull3 != null) {
                for (int i3 = 0; i3 < arrayOrNull3.size(); i3++) {
                    CLElement cLElement3 = arrayOrNull3.get(i3);
                    if (cLElement3 instanceof CLObject) {
                        parseKeyCycle((CLObject) cLElement3, transition);
                    }
                }
            }
        }
    }

    private static void parseKeyPosition(CLObject cLObject, Transition transition) throws CLParsingException {
        CLObject cLObject2 = cLObject;
        TypedBundle typedBundle = new TypedBundle();
        CLArray array = cLObject2.getArray("target");
        CLArray array2 = cLObject2.getArray("frames");
        CLArray arrayOrNull = cLObject2.getArrayOrNull("percentX");
        CLArray arrayOrNull2 = cLObject2.getArrayOrNull("percentY");
        CLArray arrayOrNull3 = cLObject2.getArrayOrNull("percentWidth");
        CLArray arrayOrNull4 = cLObject2.getArrayOrNull("percentHeight");
        String stringOrNull = cLObject2.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        String stringOrNull2 = cLObject2.getStringOrNull("transitionEasing");
        String stringOrNull3 = cLObject2.getStringOrNull("curveFit");
        String stringOrNull4 = cLObject2.getStringOrNull("type");
        if (stringOrNull4 == null) {
            stringOrNull4 = "parentRelative";
        }
        if (arrayOrNull != null && array2.size() != arrayOrNull.size()) {
            return;
        }
        if (arrayOrNull2 == null || array2.size() == arrayOrNull2.size()) {
            int i = 0;
            while (i < array.size()) {
                String string = array.getString(i);
                int map = map(stringOrNull4, "deltaRelative", "pathRelative", "parentRelative");
                typedBundle.clear();
                typedBundle.add(510, map);
                if (stringOrNull3 != null) {
                    map(typedBundle, 508, stringOrNull3, "spline", "linear");
                }
                typedBundle.addIfNotNull(501, stringOrNull2);
                if (stringOrNull != null) {
                    map(typedBundle, 509, stringOrNull, "none", "startVertical", "startHorizontal", "flip", "below", "above");
                }
                int i2 = 0;
                while (i2 < array2.size()) {
                    typedBundle.add(100, array2.getInt(i2));
                    set(typedBundle, 506, arrayOrNull, i2);
                    set(typedBundle, 507, arrayOrNull2, i2);
                    set(typedBundle, 503, arrayOrNull3, i2);
                    set(typedBundle, 504, arrayOrNull4, i2);
                    transition.addKeyPosition(string, typedBundle);
                    i2++;
                    stringOrNull4 = stringOrNull4;
                }
                String str = stringOrNull4;
                Transition transition2 = transition;
                i++;
                stringOrNull4 = str;
            }
        }
    }

    private static void parseOnSwipe(CLContainer cLContainer, Transition transition) {
        CLContainer cLContainer2 = cLContainer;
        String stringOrNull = cLContainer2.getStringOrNull("anchor");
        int map = map(cLContainer2.getStringOrNull("side"), Transition.OnSwipe.SIDES);
        int map2 = map(cLContainer2.getStringOrNull("direction"), Transition.OnSwipe.DIRECTIONS);
        float floatOrNaN = cLContainer2.getFloatOrNaN("scale");
        float floatOrNaN2 = cLContainer2.getFloatOrNaN("threshold");
        float floatOrNaN3 = cLContainer2.getFloatOrNaN("maxVelocity");
        float floatOrNaN4 = cLContainer2.getFloatOrNaN("maxAccel");
        String stringOrNull2 = cLContainer2.getStringOrNull("limitBounds");
        int map3 = map(cLContainer2.getStringOrNull("mode"), Transition.OnSwipe.MODE);
        int map4 = map(cLContainer2.getStringOrNull("touchUp"), Transition.OnSwipe.TOUCH_UP);
        float floatOrNaN5 = cLContainer2.getFloatOrNaN("springMass");
        float floatOrNaN6 = cLContainer2.getFloatOrNaN("springStiffness");
        float floatOrNaN7 = cLContainer2.getFloatOrNaN("springDamping");
        float floatOrNaN8 = cLContainer2.getFloatOrNaN("stopThreshold");
        int map5 = map(cLContainer2.getStringOrNull("springBoundary"), Transition.OnSwipe.BOUNDARY);
        String stringOrNull3 = cLContainer2.getStringOrNull("around");
        Transition.OnSwipe createOnSwipe = transition.createOnSwipe();
        createOnSwipe.setAnchorId(stringOrNull);
        createOnSwipe.setAnchorSide(map);
        createOnSwipe.setDragDirection(map2);
        createOnSwipe.setDragScale(floatOrNaN);
        createOnSwipe.setDragThreshold(floatOrNaN2);
        createOnSwipe.setMaxVelocity(floatOrNaN3);
        createOnSwipe.setMaxAcceleration(floatOrNaN4);
        createOnSwipe.setLimitBoundsTo(stringOrNull2);
        createOnSwipe.setAutoCompleteMode(map3);
        createOnSwipe.setOnTouchUp(map4);
        createOnSwipe.setSpringMass(floatOrNaN5);
        createOnSwipe.setSpringStiffness(floatOrNaN6);
        createOnSwipe.setSpringDamping(floatOrNaN7);
        createOnSwipe.setSpringStopThreshold(floatOrNaN8);
        createOnSwipe.setSpringBoundary(map5);
        createOnSwipe.setRotationCenterId(stringOrNull3);
    }

    private static void set(TypedBundle typedBundle, int i, CLArray cLArray, int i2) throws CLParsingException {
        if (cLArray != null) {
            typedBundle.add(i, cLArray.getFloat(i2));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void parse(@NonNull CLObject cLObject, @NonNull Transition transition) throws CLParsingException {
        transition.resetProperties();
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        TypedBundle typedBundle = new TypedBundle();
        boolean z = true;
        boolean z2 = false;
        if (stringOrNull != null) {
            char c = 65535;
            switch (stringOrNull.hashCode()) {
                case -1857024520:
                    if (stringOrNull.equals("startVertical")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1007052250:
                    if (stringOrNull.equals("startHorizontal")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3145837:
                    if (stringOrNull.equals("flip")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3387192:
                    if (stringOrNull.equals("none")) {
                        c = 3;
                        break;
                    }
                    break;
                case 92611485:
                    if (stringOrNull.equals("above")) {
                        c = 4;
                        break;
                    }
                    break;
                case 93621297:
                    if (stringOrNull.equals("below")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    typedBundle.add(509, 1);
                    break;
                case 1:
                    typedBundle.add(509, 2);
                    break;
                case 2:
                    typedBundle.add(509, 3);
                    break;
                case 3:
                    typedBundle.add(509, 0);
                    break;
                case 4:
                    typedBundle.add(509, 5);
                    break;
                case 5:
                    typedBundle.add(509, 4);
                    break;
            }
            z2 = true;
        }
        String stringOrNull2 = cLObject.getStringOrNull("interpolator");
        if (stringOrNull2 != null) {
            typedBundle.add(705, stringOrNull2);
            z2 = true;
        }
        float floatOrNaN = cLObject.getFloatOrNaN(TypedValues.TransitionType.S_STAGGERED);
        if (!Float.isNaN(floatOrNaN)) {
            typedBundle.add(706, floatOrNaN);
        } else {
            z = z2;
        }
        if (z) {
            transition.setTransitionProperties(typedBundle);
        }
        CLObject objectOrNull = cLObject.getObjectOrNull("onSwipe");
        if (objectOrNull != null) {
            parseOnSwipe(objectOrNull, transition);
        }
        parseKeyFrames(cLObject, transition);
    }

    private static void map(TypedBundle typedBundle, int i, String str, String... strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (strArr[i2].equals(str)) {
                typedBundle.add(i, i2);
            }
        }
    }
}
