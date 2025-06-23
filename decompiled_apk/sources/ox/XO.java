package ox;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.text.DecimalFormat;

/* loaded from: classes9.dex */
public class XO extends x0xO0oo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f33512II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public DecimalFormat f33513oIX0oI;

    public XO(int i) {
        this.f33512II0xO0 = i;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            }
            stringBuffer.append("0");
        }
        this.f33513oIX0oI = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // ox.x0xO0oo
    public String II0XooXoX(float f) {
        return this.f33513oIX0oI.format(f);
    }

    public int oOoXoXO() {
        return this.f33512II0xO0;
    }
}
