package ox;

import com.github.mikephil.charting.data.BarEntry;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.text.DecimalFormat;

/* loaded from: classes9.dex */
public class oO extends x0xO0oo {

    /* renamed from: I0Io, reason: collision with root package name */
    public DecimalFormat f33514I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f33515II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f33516oIX0oI;

    public oO(boolean z, String str, int i) {
        this.f33516oIX0oI = z;
        this.f33515II0xO0 = str;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            }
            stringBuffer.append("0");
        }
        this.f33514I0Io = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // ox.x0xO0oo
    public String X0o0xo(float f, BarEntry barEntry) {
        float[] oI0IIXIo2;
        if (!this.f33516oIX0oI && (oI0IIXIo2 = barEntry.oI0IIXIo()) != null) {
            if (oI0IIXIo2[oI0IIXIo2.length - 1] == f) {
                return this.f33514I0Io.format(barEntry.I0Io()) + this.f33515II0xO0;
            }
            return "";
        }
        return this.f33514I0Io.format(f) + this.f33515II0xO0;
    }
}
