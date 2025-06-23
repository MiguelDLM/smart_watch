package xXo;

import com.univocity.parsers.common.DataProcessingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/* loaded from: classes13.dex */
public class xxIXOIIO extends OxxIIOOXO<Date> implements x0XOIxOo<SimpleDateFormat> {

    /* renamed from: I0Io, reason: collision with root package name */
    public final SimpleDateFormat[] f34701I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public final String[] f34702oxoX;

    public xxIXOIIO(Date date, String str, String... strArr) {
        super(date, str);
        com.univocity.parsers.common.I0Io.x0xO0oo("Date formats", strArr);
        this.f34702oxoX = (String[]) strArr.clone();
        this.f34701I0Io = new SimpleDateFormat[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            this.f34701I0Io[i] = new SimpleDateFormat(strArr[i]);
        }
    }

    @Override // xXo.OxxIIOOXO
    /* renamed from: OOXIXo, reason: merged with bridge method [inline-methods] */
    public Date X0o0xo(String str) {
        for (SimpleDateFormat simpleDateFormat : this.f34701I0Io) {
            try {
                return simpleDateFormat.parse(str);
            } catch (ParseException unused) {
            }
        }
        throw new DataProcessingException("Cannot parse '" + str + "' as a valid date. Supported formats are: " + Arrays.toString(this.f34702oxoX));
    }

    @Override // xXo.x0XOIxOo
    /* renamed from: oOoXoXO, reason: merged with bridge method [inline-methods] */
    public SimpleDateFormat[] I0Io() {
        return this.f34701I0Io;
    }

    @Override // xXo.OxxIIOOXO, xXo.Oxx0IOOO
    /* renamed from: ooOOo0oXI, reason: merged with bridge method [inline-methods] */
    public String oIX0oI(Date date) {
        if (date == null) {
            return super.oIX0oI(null);
        }
        return this.f34701I0Io[0].format(date);
    }

    public xxIXOIIO(String... strArr) {
        this(null, null, strArr);
    }
}
