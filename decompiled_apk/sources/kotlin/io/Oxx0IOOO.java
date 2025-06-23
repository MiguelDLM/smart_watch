package kotlin.io;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.File;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class Oxx0IOOO {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final List<File> f29219II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final File f29220oIX0oI;

    /* JADX WARN: Multi-variable type inference failed */
    public Oxx0IOOO(@OXOo.OOXIXo File root, @OXOo.OOXIXo List<? extends File> segments) {
        IIX0o.x0xO0oo(root, "root");
        IIX0o.x0xO0oo(segments, "segments");
        this.f29220oIX0oI = root;
        this.f29219II0xO0 = segments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Oxx0IOOO oxoX(Oxx0IOOO oxx0IOOO, File file, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            file = oxx0IOOO.f29220oIX0oI;
        }
        if ((i & 2) != 0) {
            list = oxx0IOOO.f29219II0xO0;
        }
        return oxx0IOOO.I0Io(file, list);
    }

    @OXOo.OOXIXo
    public final Oxx0IOOO I0Io(@OXOo.OOXIXo File root, @OXOo.OOXIXo List<? extends File> segments) {
        IIX0o.x0xO0oo(root, "root");
        IIX0o.x0xO0oo(segments, "segments");
        return new Oxx0IOOO(root, segments);
    }

    public final int II0XooXoX() {
        return this.f29219II0xO0.size();
    }

    @OXOo.OOXIXo
    public final List<File> II0xO0() {
        return this.f29219II0xO0;
    }

    @OXOo.OOXIXo
    public final List<File> Oxx0IOOO() {
        return this.f29219II0xO0;
    }

    @OXOo.OOXIXo
    public final File X0o0xo() {
        return this.f29220oIX0oI;
    }

    @OXOo.OOXIXo
    public final String XO() {
        String path = this.f29220oIX0oI.getPath();
        IIX0o.oO(path, "getPath(...)");
        return path;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Oxx0IOOO)) {
            return false;
        }
        Oxx0IOOO oxx0IOOO = (Oxx0IOOO) obj;
        return IIX0o.Oxx0IOOO(this.f29220oIX0oI, oxx0IOOO.f29220oIX0oI) && IIX0o.Oxx0IOOO(this.f29219II0xO0, oxx0IOOO.f29219II0xO0);
    }

    public int hashCode() {
        return (this.f29220oIX0oI.hashCode() * 31) + this.f29219II0xO0.hashCode();
    }

    @OXOo.OOXIXo
    public final File oIX0oI() {
        return this.f29220oIX0oI;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "FilePathComponents(root=" + this.f29220oIX0oI + ", segments=" + this.f29219II0xO0 + HexStringBuilder.COMMENT_END_CHAR;
    }

    @OXOo.OOXIXo
    public final File xoIox(int i, int i2) {
        if (i >= 0 && i <= i2 && i2 <= II0XooXoX()) {
            List<File> subList = this.f29219II0xO0.subList(i, i2);
            String separator = File.separator;
            IIX0o.oO(separator, "separator");
            return new File(CollectionsKt___CollectionsKt.OoIXo(subList, separator, null, null, 0, null, null, 62, null));
        }
        throw new IllegalArgumentException();
    }

    public final boolean xxIXOIIO() {
        String path = this.f29220oIX0oI.getPath();
        IIX0o.oO(path, "getPath(...)");
        if (path.length() > 0) {
            return true;
        }
        return false;
    }
}
