package okio;

import XXO0.oIX0oI;
import java.util.ArrayList;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes6.dex */
public final class FileMetadata {

    @OXOo.oOoXoXO
    private final Long createdAtMillis;

    @OXOo.OOXIXo
    private final Map<kotlin.reflect.oxoX<?>, Object> extras;
    private final boolean isDirectory;
    private final boolean isRegularFile;

    @OXOo.oOoXoXO
    private final Long lastAccessedAtMillis;

    @OXOo.oOoXoXO
    private final Long lastModifiedAtMillis;

    @OXOo.oOoXoXO
    private final Long size;

    @OXOo.oOoXoXO
    private final Path symlinkTarget;

    public FileMetadata() {
        this(false, false, null, null, null, null, null, null, 255, null);
    }

    @OXOo.OOXIXo
    public final FileMetadata copy(boolean z, boolean z2, @OXOo.oOoXoXO Path path, @OXOo.oOoXoXO Long l, @OXOo.oOoXoXO Long l2, @OXOo.oOoXoXO Long l3, @OXOo.oOoXoXO Long l4, @OXOo.OOXIXo Map<kotlin.reflect.oxoX<?>, ? extends Object> extras) {
        IIX0o.x0xO0oo(extras, "extras");
        return new FileMetadata(z, z2, path, l, l2, l3, l4, extras);
    }

    @OXOo.oOoXoXO
    public final <T> T extra(@OXOo.OOXIXo kotlin.reflect.oxoX<? extends T> type) {
        IIX0o.x0xO0oo(type, "type");
        Object obj = this.extras.get(type);
        if (obj == null) {
            return null;
        }
        return (T) kotlin.reflect.X0o0xo.oIX0oI(type, obj);
    }

    @OXOo.oOoXoXO
    public final Long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    @OXOo.OOXIXo
    public final Map<kotlin.reflect.oxoX<?>, Object> getExtras() {
        return this.extras;
    }

    @OXOo.oOoXoXO
    public final Long getLastAccessedAtMillis() {
        return this.lastAccessedAtMillis;
    }

    @OXOo.oOoXoXO
    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    @OXOo.oOoXoXO
    public final Long getSize() {
        return this.size;
    }

    @OXOo.oOoXoXO
    public final Path getSymlinkTarget() {
        return this.symlinkTarget;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final boolean isRegularFile() {
        return this.isRegularFile;
    }

    @OXOo.OOXIXo
    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.isRegularFile) {
            arrayList.add("isRegularFile");
        }
        if (this.isDirectory) {
            arrayList.add("isDirectory");
        }
        if (this.size != null) {
            arrayList.add("byteCount=" + this.size);
        }
        if (this.createdAtMillis != null) {
            arrayList.add("createdAt=" + this.createdAtMillis);
        }
        if (this.lastModifiedAtMillis != null) {
            arrayList.add("lastModifiedAt=" + this.lastModifiedAtMillis);
        }
        if (this.lastAccessedAtMillis != null) {
            arrayList.add("lastAccessedAt=" + this.lastAccessedAtMillis);
        }
        if (!this.extras.isEmpty()) {
            arrayList.add("extras=" + this.extras);
        }
        return CollectionsKt___CollectionsKt.OoIXo(arrayList, ", ", "FileMetadata(", oIX0oI.I0Io.f4095I0Io, 0, null, null, 56, null);
    }

    public FileMetadata(boolean z, boolean z2, @OXOo.oOoXoXO Path path, @OXOo.oOoXoXO Long l, @OXOo.oOoXoXO Long l2, @OXOo.oOoXoXO Long l3, @OXOo.oOoXoXO Long l4, @OXOo.OOXIXo Map<kotlin.reflect.oxoX<?>, ? extends Object> extras) {
        IIX0o.x0xO0oo(extras, "extras");
        this.isRegularFile = z;
        this.isDirectory = z2;
        this.symlinkTarget = path;
        this.size = l;
        this.createdAtMillis = l2;
        this.lastModifiedAtMillis = l3;
        this.lastAccessedAtMillis = l4;
        this.extras = o0.OX00O0xII(extras);
    }

    public /* synthetic */ FileMetadata(boolean z, boolean z2, Path path, Long l, Long l2, Long l3, Long l4, Map map, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? false : z, (i & 2) == 0 ? z2 : false, (i & 4) != 0 ? null : path, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : l3, (i & 64) == 0 ? l4 : null, (i & 128) != 0 ? o0.O0xOxO() : map);
    }
}
