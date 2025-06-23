package oX0O;

import android.media.ExifInterface;
import java.io.IOException;

/* loaded from: classes6.dex */
public class X0o0xo {
    public static int oIX0oI(String str) {
        ExifInterface exifInterface;
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e) {
            e.printStackTrace();
            exifInterface = null;
        }
        if (exifInterface == null) {
            return 0;
        }
        int attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
        if (attributeInt != 3) {
            if (attributeInt != 6) {
                if (attributeInt != 8) {
                    return 0;
                }
                return 270;
            }
            return 90;
        }
        return 180;
    }
}
