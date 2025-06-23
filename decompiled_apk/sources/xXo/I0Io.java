package xXo;

import com.univocity.parsers.common.DataProcessingException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes13.dex */
public class I0Io extends OxxIIOOXO<Boolean> {

    /* renamed from: I0Io, reason: collision with root package name */
    public String f34675I0Io;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final Set<String> f34676X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final Set<String> f34677XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public String f34678oxoX;

    public I0Io(String[] strArr, String[] strArr2) {
        this(null, null, strArr, strArr2);
    }

    @Override // xXo.OxxIIOOXO
    /* renamed from: OOXIXo, reason: merged with bridge method [inline-methods] */
    public Boolean X0o0xo(String str) {
        if (str != null) {
            String Oo2 = com.univocity.parsers.common.I0Io.Oo(str);
            if (this.f34676X0o0xo.contains(Oo2)) {
                return Boolean.FALSE;
            }
            if (this.f34677XO.contains(Oo2)) {
                return Boolean.TRUE;
            }
            throw new DataProcessingException("Unable to convert '" + str + "' to Boolean. Allowed Strings are: " + this.f34677XO + " for true; and " + this.f34676X0o0xo + " for false.");
        }
        return (Boolean) super.Oxx0IOOO();
    }

    @Override // xXo.OxxIIOOXO, xXo.Oxx0IOOO
    /* renamed from: oOoXoXO, reason: merged with bridge method [inline-methods] */
    public String oIX0oI(Boolean bool) {
        if (bool != null) {
            if (Boolean.FALSE.equals(bool)) {
                return this.f34678oxoX;
            }
            if (Boolean.TRUE.equals(bool)) {
                return this.f34675I0Io;
            }
        }
        return XO();
    }

    public I0Io(Boolean bool, String str, String[] strArr, String[] strArr2) {
        super(bool, str);
        HashSet<String> hashSet = new HashSet();
        this.f34676X0o0xo = hashSet;
        HashSet hashSet2 = new HashSet();
        this.f34677XO = hashSet2;
        com.univocity.parsers.common.I0Io.oI0IIXIo("Values for true", strArr);
        com.univocity.parsers.common.I0Io.oI0IIXIo("Values for false", strArr2);
        Collections.addAll(hashSet, strArr2);
        Collections.addAll(hashSet2, strArr);
        com.univocity.parsers.common.I0Io.IXxxXO(hashSet);
        com.univocity.parsers.common.I0Io.IXxxXO(hashSet2);
        for (String str2 : hashSet) {
            if (this.f34677XO.contains(str2)) {
                throw new DataProcessingException("Ambiguous string representation for both false and true values: '" + str2 + '\'');
            }
        }
        this.f34675I0Io = strArr[0];
        this.f34678oxoX = strArr2[0];
    }
}
