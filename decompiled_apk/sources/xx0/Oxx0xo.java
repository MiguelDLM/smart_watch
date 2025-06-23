package xx0;

import android.text.format.Time;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.ar.util.SystemInfoUtil;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.vtrump.vtble.Oxx0IOOO;

/* loaded from: classes13.dex */
public final class Oxx0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final Oxx0xo f35204oIX0oI = new Oxx0xo();

    public String II0xO0(int i, Thread thread, long j, String str, String str2, Throwable th) {
        long j2 = j % 1000;
        Time time = new Time();
        time.set(j);
        StringBuilder sb = new StringBuilder();
        sb.append(oIX0oI(i));
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(time.format("%Y-%m-%d %H:%M:%S"));
        sb.append('.');
        if (j2 < 10) {
            sb.append("00");
        } else if (j2 < 100) {
            sb.append('0');
        }
        sb.append(j2);
        sb.append(TokenParser.SP);
        sb.append('[');
        if (thread == null) {
            sb.append(SystemInfoUtil.NA);
        } else {
            sb.append(thread.getName());
        }
        sb.append(']');
        sb.append('[');
        sb.append(str);
        sb.append(']');
        sb.append(TokenParser.SP);
        sb.append(str2);
        sb.append('\n');
        if (th != null) {
            sb.append("* Exception : \n");
            sb.append(Log.getStackTraceString(th));
            sb.append('\n');
        }
        return sb.toString();
    }

    public final String oIX0oI(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 8) {
                        if (i != 16) {
                            if (i != 32) {
                                return HelpFormatter.DEFAULT_OPT_PREFIX;
                            }
                            return "A";
                        }
                        return ExifInterface.LONGITUDE_EAST;
                    }
                    return "W";
                }
                return Oxx0IOOO.f27277xI;
            }
            return "D";
        }
        return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
    }
}
