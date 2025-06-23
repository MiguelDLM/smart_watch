package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import java.util.Arrays;

/* loaded from: classes.dex */
public class KeyParser {

    /* loaded from: classes.dex */
    public interface DataType {
        int get(int i);
    }

    /* loaded from: classes.dex */
    public interface Ids {
        int get(String str);
    }

    public static void main(String[] strArr) {
        parseAttributes("{frame:22,\ntarget:'widget1',\neasing:'easeIn',\ncurveFit:'spline',\nprogress:0.3,\nalpha:0.2,\nelevation:0.7,\nrotationZ:23,\nrotationX:25.0,\nrotationY:27.0,\npivotX:15,\npivotY:17,\npivotTarget:'32',\npathRotate:23,\nscaleX:0.5,\nscaleY:0.7,\ntranslationX:5,\ntranslationY:7,\ntranslationZ:11,\n}");
    }

    private static TypedBundle parse(String str, Ids ids, DataType dataType) {
        TypedBundle typedBundle = new TypedBundle();
        try {
            CLObject parse = CLParser.parse(str);
            int size = parse.size();
            for (int i = 0; i < size; i++) {
                CLKey cLKey = (CLKey) parse.get(i);
                String content = cLKey.content();
                CLElement value = cLKey.getValue();
                int i2 = ids.get(content);
                if (i2 == -1) {
                    System.err.println("unknown type " + content);
                } else {
                    int i3 = dataType.get(i2);
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 4) {
                                if (i3 == 8) {
                                    typedBundle.add(i2, value.content());
                                    System.out.println("parse " + content + " STRING_MASK > " + value.content());
                                }
                            } else {
                                typedBundle.add(i2, value.getFloat());
                                System.out.println("parse " + content + " FLOAT_MASK > " + value.getFloat());
                            }
                        } else {
                            typedBundle.add(i2, value.getInt());
                            System.out.println("parse " + content + " INT_MASK > " + value.getInt());
                        }
                    } else {
                        typedBundle.add(i2, parse.getBoolean(i));
                    }
                }
            }
        } catch (CLParsingException e) {
            System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
        return typedBundle;
    }

    public static TypedBundle parseAttributes(String str) {
        return parse(str, new Ids() { // from class: androidx.constraintlayout.core.motion.parse.oIX0oI
            @Override // androidx.constraintlayout.core.motion.parse.KeyParser.Ids
            public final int get(String str2) {
                return androidx.constraintlayout.core.motion.utils.oIX0oI.oIX0oI(str2);
            }
        }, new DataType() { // from class: androidx.constraintlayout.core.motion.parse.II0xO0
            @Override // androidx.constraintlayout.core.motion.parse.KeyParser.DataType
            public final int get(int i) {
                return androidx.constraintlayout.core.motion.utils.oIX0oI.II0xO0(i);
            }
        });
    }
}
