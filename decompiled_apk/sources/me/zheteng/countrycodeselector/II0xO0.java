package me.zheteng.countrycodeselector;

import OoOoXO0.xoXoI;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import xIXOoI.I0Io;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static II0xO0 f30981II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public List<Country> f30982oIX0oI;

    public II0xO0(InputStream inputStream) {
        this.f30982oIX0oI = Oxx0IOOO(inputStream);
    }

    public static II0xO0 oIX0oI(Context context) {
        if (f30981II0xO0 == null) {
            synchronized (II0xO0.class) {
                try {
                    if (f30981II0xO0 == null) {
                        f30981II0xO0 = new II0xO0(context.getResources().openRawResource(R.raw.ccs_countries));
                    }
                } finally {
                }
            }
        }
        return f30981II0xO0;
    }

    public String I0Io(String str) {
        for (Country country : this.f30982oIX0oI) {
            if (TextUtils.equals(str, country.II0xO0())) {
                return country.X0o0xo();
            }
        }
        return "中国";
    }

    public synchronized void II0XooXoX() {
        List<Country> list = this.f30982oIX0oI;
        if (list != null) {
            list.clear();
            this.f30982oIX0oI = null;
            f30981II0xO0 = null;
        }
    }

    public String II0xO0(String str) {
        for (Country country : this.f30982oIX0oI) {
            if (TextUtils.equals(str, country.II0xO0())) {
                return xoXoI.f2668X0o0xo + country.oIX0oI();
            }
        }
        return "+86";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<Country> Oxx0IOOO(InputStream inputStream) {
        try {
            I0Io i0Io = new I0Io();
            ((xIXOoI.oIX0oI) i0Io.xxIXOIIO()).oOoXoXO("\n");
            List<String[]> XI0IXoo2 = new xIXOoI.II0xO0(i0Io).XI0IXoo(inputStream);
            ArrayList arrayList = new ArrayList();
            for (String[] strArr : XI0IXoo2) {
                Country country = new Country();
                country.xoIox(strArr[0]);
                country.ooOOo0oXI(strArr[1]);
                country.xxIXOIIO(strArr[2]);
                country.OOXIXo(strArr[3]);
                country.oOoXoXO(strArr[4]);
                String str = strArr[7];
                if (str != null) {
                    country.x0xO0oo(Arrays.asList(str.split(x.aL)));
                }
                String str2 = strArr[8];
                if (str2 != null) {
                    country.oO(Arrays.asList(str2.split(x.aL)));
                }
                country.x0XOIxOo(strArr[11]);
                arrayList.add(country);
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    public String X0o0xo() {
        return II0xO0(Locale.getDefault().getCountry());
    }

    public String XO() {
        return I0Io(Locale.getDefault().getCountry());
    }

    public List<Country> oxoX(Context context) {
        List<Country> list = this.f30982oIX0oI;
        if (list != null && list.size() > 1) {
            String X0o0xo2 = this.f30982oIX0oI.get(0).X0o0xo();
            Resources resources = context.getResources();
            int i = R.string.clear_country;
            if (!X0o0xo2.equals(resources.getString(i))) {
                Country country = new Country();
                country.ooOOo0oXI(context.getResources().getString(i));
                country.xxIXOIIO("");
                country.x0XOIxOo("");
                this.f30982oIX0oI.add(0, country);
            }
        }
        return this.f30982oIX0oI;
    }
}
