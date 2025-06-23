package IoXIXo;

import O0IxXx.oO;
import android.text.TextUtils;
import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes11.dex */
public class XO implements I0Io {
    @Override // IoXIXo.I0Io
    public String a(String str) {
        String oIX0oI2 = oIX0oI(str);
        String Oxx0IOOO2 = oO.Oxx0IOOO(str);
        if (!TextUtils.isEmpty(oIX0oI2)) {
            return Oxx0IOOO2 + FileUtils.FILE_EXTENSION_SEPARATOR + oIX0oI2;
        }
        return Oxx0IOOO2;
    }

    public final String oIX0oI(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        int lastIndexOf2 = str.lastIndexOf(47);
        if (lastIndexOf != -1 && lastIndexOf > lastIndexOf2 && lastIndexOf + 6 > str.length()) {
            return str.substring(lastIndexOf + 1, str.length());
        }
        return "";
    }
}
