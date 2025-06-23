package X00IoxXI;

import OXOo.OOXIXo;
import android.os.Environment;
import com.sma.smartv3.initializer.IXxxXO;
import java.io.File;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.OxI;

/* loaded from: classes8.dex */
public final class II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f3231II0xO0 = new oIX0oI(null);

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public String f3232oIX0oI;

    /* loaded from: classes8.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final II0xO0 I0Io() {
            String DIRECTORY_DCIM = Environment.DIRECTORY_DCIM;
            IIX0o.oO(DIRECTORY_DCIM, "DIRECTORY_DCIM");
            return new II0xO0(DIRECTORY_DCIM);
        }

        @OOXIXo
        public final II0xO0 II0xO0() {
            return new II0xO0("databases");
        }

        @OOXIXo
        public final II0xO0 Oxx0IOOO() {
            String DIRECTORY_MUSIC = Environment.DIRECTORY_MUSIC;
            IIX0o.oO(DIRECTORY_MUSIC, "DIRECTORY_MUSIC");
            return new II0xO0(DIRECTORY_MUSIC);
        }

        @OOXIXo
        public final II0xO0 X0o0xo() {
            return new II0xO0("files");
        }

        @OOXIXo
        public final II0xO0 XO() {
            return new II0xO0(IXxxXO.f20864oIX0oI);
        }

        @OOXIXo
        public final II0xO0 oIX0oI() {
            return new II0xO0("cache");
        }

        @OOXIXo
        public final II0xO0 oxoX() {
            String DIRECTORY_DOWNLOADS = Environment.DIRECTORY_DOWNLOADS;
            IIX0o.oO(DIRECTORY_DOWNLOADS, "DIRECTORY_DOWNLOADS");
            return new II0xO0(DIRECTORY_DOWNLOADS);
        }

        public oIX0oI() {
        }
    }

    public II0xO0(@OOXIXo String startPath) {
        IIX0o.x0xO0oo(startPath, "startPath");
        String separator = File.separator;
        IIX0o.oO(separator, "separator");
        this.f3232oIX0oI = OxI.IIOIX(startPath, separator, "", false, 4, null);
    }

    @OOXIXo
    public final II0xO0 II0xO0(@OOXIXo String subPath) {
        IIX0o.x0xO0oo(subPath, "subPath");
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3232oIX0oI);
        String separator = File.separator;
        sb.append(separator);
        IIX0o.oO(separator, "separator");
        sb.append(OxI.IIOIX(subPath, separator, "", false, 4, null));
        this.f3232oIX0oI = sb.toString();
        return this;
    }

    @OOXIXo
    public final String oIX0oI() {
        return this.f3232oIX0oI;
    }
}
