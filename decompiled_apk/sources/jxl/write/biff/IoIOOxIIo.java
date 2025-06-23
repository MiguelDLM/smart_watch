package jxl.write.biff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class IoIOOxIIo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public HashMap f28626oIX0oI = new HashMap(100);

    /* renamed from: II0xO0, reason: collision with root package name */
    public ArrayList f28625II0xO0 = new ArrayList(100);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28624I0Io = 0;

    public int I0Io(String str) {
        Integer num = (Integer) this.f28626oIX0oI.get(str);
        if (num == null) {
            num = new Integer(this.f28626oIX0oI.size());
            this.f28626oIX0oI.put(str, num);
            this.f28625II0xO0.add(str);
        }
        this.f28624I0Io++;
        return num.intValue();
    }

    public String II0xO0(int i) {
        return (String) this.f28625II0xO0.get(i);
    }

    public final O0X oIX0oI(String str, int i, IIX0o iIX0o) throws IOException {
        O0X o0x = null;
        while (i != 0) {
            o0x = new O0X();
            if (i != str.length() && str.length() != 0) {
                i = o0x.oX(str.substring(str.length() - i), false);
            } else {
                i = o0x.oX(str, true);
            }
            if (i != 0) {
                iIX0o.XO(o0x);
                o0x = new O0X();
            }
        }
        return o0x;
    }

    public void oxoX(IIX0o iIX0o) throws IOException {
        IIX0 iix0 = new IIX0(this.f28624I0Io, this.f28625II0xO0.size());
        xxX xxx2 = new xxX(this.f28625II0xO0.size());
        int oX2 = xxx2.oX();
        Iterator it = this.f28625II0xO0.iterator();
        int i = 0;
        String str = null;
        int i2 = 0;
        while (it.hasNext() && i == 0) {
            str = (String) it.next();
            int I0X0x0oIo2 = iix0.I0X0x0oIo() + 4;
            int XX02 = iix0.XX0(str);
            if (i2 % oX2 == 0) {
                xxx2.XX0(iIX0o.I0Io(), I0X0x0oIo2);
            }
            i2++;
            i = XX02;
        }
        iIX0o.XO(iix0);
        if (i != 0 || it.hasNext()) {
            O0X oIX0oI2 = oIX0oI(str, i, iIX0o);
            while (it.hasNext()) {
                String str2 = (String) it.next();
                int I0X0x0oIo3 = oIX0oI2.I0X0x0oIo() + 4;
                int XX03 = oIX0oI2.XX0(str2);
                if (i2 % oX2 == 0) {
                    xxx2.XX0(iIX0o.I0Io(), I0X0x0oIo3);
                }
                i2++;
                if (XX03 != 0) {
                    iIX0o.XO(oIX0oI2);
                    oIX0oI2 = oIX0oI(str2, XX03, iIX0o);
                }
            }
            iIX0o.XO(oIX0oI2);
        }
        iIX0o.XO(xxx2);
    }
}
