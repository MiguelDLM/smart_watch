package X0IIOO;

import com.huawei.openalliance.ad.constant.x;
import java.util.Arrays;

public final class oIX0oI {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final String f227oIX0oI = "sls-android-sdk/2.6.12";

    public static String[] oIX0oI(String[] strArr, String... strArr2) {
        String[] strArr3 = (String[]) Arrays.copyOf(strArr, strArr.length + 2);
        strArr3[strArr.length] = "User-agent";
        if (strArr2 == null || strArr2.length == 0) {
            strArr3[strArr.length + 1] = f227oIX0oI;
        } else {
            StringBuilder sb = new StringBuilder(f227oIX0oI);
            for (String append : strArr2) {
                sb.append(x.aL);
                sb.append(append);
            }
            strArr3[strArr.length + 1] = sb.substring(0, sb.length());
        }
        return strArr3;
    }
}
