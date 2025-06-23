package ox;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.text.DecimalFormat;

/* loaded from: classes9.dex */
public class II0XooXoX extends x0xO0oo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f33510II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public DecimalFormat f33511oIX0oI;

    public II0XooXoX(int i) {
        ooOOo0oXI(i);
    }

    @Override // ox.x0xO0oo
    public String II0XooXoX(float f) {
        return this.f33511oIX0oI.format(f);
    }

    public int oOoXoXO() {
        return this.f33510II0xO0;
    }

    public void ooOOo0oXI(int i) {
        this.f33510II0xO0 = i;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            }
            stringBuffer.append("0");
        }
        this.f33511oIX0oI = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }
}
