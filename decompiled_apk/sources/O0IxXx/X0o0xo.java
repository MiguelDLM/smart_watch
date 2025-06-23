package O0IxXx;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes11.dex */
public class X0o0xo {

    /* renamed from: I0Io, reason: collision with root package name */
    public final boolean f1233I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final long f1234II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f1235oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final Pattern f1232oxoX = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final Pattern f1231X0o0xo = Pattern.compile("GET /(.*) HTTP");

    public X0o0xo(String str) {
        boolean z;
        ooOOo0oXI.oIX0oI(str);
        long oIX0oI2 = oIX0oI(str);
        this.f1234II0xO0 = Math.max(0L, oIX0oI2);
        if (oIX0oI2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        this.f1233I0Io = z;
        this.f1235oIX0oI = I0Io(str);
    }

    public static X0o0xo II0xO0(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                sb.append(readLine);
                sb.append('\n');
            } else {
                return new X0o0xo(sb.toString());
            }
        }
    }

    public final String I0Io(String str) {
        Matcher matcher = f1231X0o0xo.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public final long oIX0oI(String str) {
        Matcher matcher = f1232oxoX.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f1234II0xO0 + ", partial=" + this.f1233I0Io + ", uri='" + this.f1235oIX0oI + "'}";
    }
}
