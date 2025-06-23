package o0xxxXXxX;

import android.graphics.Color;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class II0xO0 extends oxoX<BarEntry> implements IIxOXoOo0.oIX0oI {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f31235O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public int f31236OxI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public float f31237X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f31238XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f31239XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public String[] f31240XxX0x0xxx;

    /* renamed from: xxX, reason: collision with root package name */
    public int f31241xxX;

    public II0xO0(List<BarEntry> list, String str) {
        super(list, str);
        this.f31236OxI = 1;
        this.f31235O0xOxO = Color.rgb(215, 215, 215);
        this.f31237X0IIOO = 0.0f;
        this.f31238XI0IXoo = ViewCompat.MEASURED_STATE_MASK;
        this.f31239XIxXXX0x0 = 120;
        this.f31241xxX = 0;
        this.f31240XxX0x0xxx = new String[]{"Stack"};
        this.f31295o00 = Color.rgb(0, 0, 0);
        OxO(list);
        o0oxo0oI(list);
    }

    @Override // IIxOXoOo0.oIX0oI
    public int IXxxXO() {
        return this.f31236OxI;
    }

    @Override // IIxOXoOo0.oIX0oI
    public float IoOoX() {
        return this.f31237X0IIOO;
    }

    public void OOxOI(float f) {
        this.f31237X0IIOO = f;
    }

    public void OXXoIoXI(int i) {
        this.f31239XIxXXX0x0 = i;
    }

    public final void OxO(List<BarEntry> list) {
        for (int i = 0; i < list.size(); i++) {
            float[] oI0IIXIo2 = list.get(i).oI0IIXIo();
            if (oI0IIXIo2 != null && oI0IIXIo2.length > this.f31236OxI) {
                this.f31236OxI = oI0IIXIo2.length;
            }
        }
    }

    public void X00xOoXI(int i) {
        this.f31238XI0IXoo = i;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    /* renamed from: X0O0I0, reason: merged with bridge method [inline-methods] */
    public void oxOXxoXII(BarEntry barEntry) {
        if (barEntry != null && !Float.isNaN(barEntry.I0Io())) {
            if (barEntry.oI0IIXIo() == null) {
                if (barEntry.I0Io() < this.f16011OxxIIOOXO) {
                    this.f16011OxxIIOOXO = barEntry.I0Io();
                }
                if (barEntry.I0Io() > this.f16012oI0IIXIo) {
                    this.f16012oI0IIXIo = barEntry.I0Io();
                }
            } else {
                if ((-barEntry.x0xO0oo()) < this.f16011OxxIIOOXO) {
                    this.f16011OxxIIOOXO = -barEntry.x0xO0oo();
                }
                if (barEntry.Oo() > this.f16012oI0IIXIo) {
                    this.f16012oI0IIXIo = barEntry.Oo();
                }
            }
            IxX00(barEntry);
        }
    }

    public void XO00XOO(int i) {
        this.f31235O0xOxO = i;
    }

    @Override // IIxOXoOo0.oIX0oI
    public boolean XoX() {
        if (this.f31236OxI > 1) {
            return true;
        }
        return false;
    }

    public void XooIO0oo0(String[] strArr) {
        this.f31240XxX0x0xxx = strArr;
    }

    public int o0Xo() {
        return this.f31241xxX;
    }

    public final void o0oxo0oI(List<BarEntry> list) {
        this.f31241xxX = 0;
        for (int i = 0; i < list.size(); i++) {
            float[] oI0IIXIo2 = list.get(i).oI0IIXIo();
            if (oI0IIXIo2 == null) {
                this.f31241xxX++;
            } else {
                this.f31241xxX += oI0IIXIo2.length;
            }
        }
    }

    @Override // IIxOXoOo0.oIX0oI
    public int oOoIIO0() {
        return this.f31235O0xOxO;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<BarEntry> oX0I0O() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f16010Oxx0xo.size(); i++) {
            arrayList.add(((BarEntry) this.f16010Oxx0xo.get(i)).Oxx0IOOO());
        }
        II0xO0 iI0xO0 = new II0xO0(arrayList, getLabel());
        xxx00(iI0xO0);
        return iI0xO0;
    }

    @Override // IIxOXoOo0.oIX0oI
    public String[] oxXx0IX() {
        return this.f31240XxX0x0xxx;
    }

    @Override // IIxOXoOo0.oIX0oI
    public int x0OxxIOxX() {
        return this.f31239XIxXXX0x0;
    }

    @Override // IIxOXoOo0.oIX0oI
    public int xoIxX() {
        return this.f31238XI0IXoo;
    }

    public void xxx00(II0xO0 iI0xO0) {
        super.OxXXx0X(iI0xO0);
        iI0xO0.f31236OxI = this.f31236OxI;
        iI0xO0.f31235O0xOxO = this.f31235O0xOxO;
        iI0xO0.f31237X0IIOO = this.f31237X0IIOO;
        iI0xO0.f31240XxX0x0xxx = this.f31240XxX0x0xxx;
        iI0xO0.f31239XIxXXX0x0 = this.f31239XIxXXX0x0;
    }
}
