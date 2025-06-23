package xXo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes13.dex */
public class X0o0xo extends OxxIIOOXO<Calendar> implements x0XOIxOo<SimpleDateFormat> {

    /* renamed from: I0Io, reason: collision with root package name */
    public final xxIXOIIO f34696I0Io;

    public X0o0xo(Calendar calendar, String str, String... strArr) {
        super(calendar, str);
        com.univocity.parsers.common.I0Io.x0xO0oo("Date formats", strArr);
        this.f34696I0Io = new xxIXOIIO(strArr);
    }

    @Override // xXo.OxxIIOOXO
    /* renamed from: OOXIXo, reason: merged with bridge method [inline-methods] */
    public Calendar X0o0xo(String str) {
        Date II0xO02 = this.f34696I0Io.II0xO0(str);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(II0xO02);
        return calendar;
    }

    @Override // xXo.x0XOIxOo
    /* renamed from: oOoXoXO, reason: merged with bridge method [inline-methods] */
    public SimpleDateFormat[] I0Io() {
        return this.f34696I0Io.I0Io();
    }

    @Override // xXo.OxxIIOOXO, xXo.Oxx0IOOO
    /* renamed from: ooOOo0oXI, reason: merged with bridge method [inline-methods] */
    public String oIX0oI(Calendar calendar) {
        if (calendar == null) {
            return super.oIX0oI(null);
        }
        return this.f34696I0Io.oIX0oI(calendar.getTime());
    }

    public X0o0xo(String... strArr) {
        this(null, null, strArr);
    }
}
