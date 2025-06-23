package x0;

import android.text.TextUtils;
import com.octopus.ad.internal.Oxx0IOOO;
import java.util.List;
import o0IXXIx.II0XooXoX;

/* loaded from: classes11.dex */
public class IO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f33680oIX0oI = "ReportEventUtil";

    public static void oIX0oI(List<String> list) {
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                II0XooXoX.oIX0oI(f33680oIX0oI, "ReportEventUtil:" + str);
                if (!TextUtils.isEmpty(str)) {
                    new Oxx0IOOO(str).XO();
                }
            }
        }
    }
}
