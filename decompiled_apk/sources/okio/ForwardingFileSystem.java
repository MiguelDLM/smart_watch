package okio;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.o00;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.ooOOo0oXI;

@XX({"SMAP\nForwardingFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ForwardingFileSystem.kt\nokio/ForwardingFileSystem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,243:1\n1620#2,3:244\n1620#2,3:247\n*S KotlinDebug\n*F\n+ 1 ForwardingFileSystem.kt\nokio/ForwardingFileSystem\n*L\n166#1:244,3\n174#1:247,3\n*E\n"})
/* loaded from: classes6.dex */
public abstract class ForwardingFileSystem extends FileSystem {

    @OXOo.OOXIXo
    private final FileSystem delegate;

    public ForwardingFileSystem(@OXOo.OOXIXo FileSystem delegate) {
        IIX0o.x0xO0oo(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public Sink appendingSink(@OXOo.OOXIXo Path file, boolean z) throws IOException {
        IIX0o.x0xO0oo(file, "file");
        return this.delegate.appendingSink(onPathParameter(file, "appendingSink", "file"), z);
    }

    @Override // okio.FileSystem
    public void atomicMove(@OXOo.OOXIXo Path source, @OXOo.OOXIXo Path target) throws IOException {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(target, "target");
        this.delegate.atomicMove(onPathParameter(source, "atomicMove", "source"), onPathParameter(target, "atomicMove", "target"));
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public Path canonicalize(@OXOo.OOXIXo Path path) throws IOException {
        IIX0o.x0xO0oo(path, "path");
        return onPathResult(this.delegate.canonicalize(onPathParameter(path, "canonicalize", "path")), "canonicalize");
    }

    @Override // okio.FileSystem
    public void createDirectory(@OXOo.OOXIXo Path dir, boolean z) throws IOException {
        IIX0o.x0xO0oo(dir, "dir");
        this.delegate.createDirectory(onPathParameter(dir, "createDirectory", MapBundleKey.MapObjKey.OBJ_DIR), z);
    }

    @Override // okio.FileSystem
    public void createSymlink(@OXOo.OOXIXo Path source, @OXOo.OOXIXo Path target) throws IOException {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(target, "target");
        this.delegate.createSymlink(onPathParameter(source, "createSymlink", "source"), onPathParameter(target, "createSymlink", "target"));
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "delegate")
    public final FileSystem delegate() {
        return this.delegate;
    }

    @Override // okio.FileSystem
    public void delete(@OXOo.OOXIXo Path path, boolean z) throws IOException {
        IIX0o.x0xO0oo(path, "path");
        this.delegate.delete(onPathParameter(path, RequestParameters.SUBRESOURCE_DELETE, "path"), z);
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public List<Path> list(@OXOo.OOXIXo Path dir) throws IOException {
        IIX0o.x0xO0oo(dir, "dir");
        List<Path> list = this.delegate.list(onPathParameter(dir, "list", MapBundleKey.MapObjKey.OBJ_DIR));
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((Path) it.next(), "list"));
        }
        o00.IoOoo(arrayList);
        return arrayList;
    }

    @Override // okio.FileSystem
    @OXOo.oOoXoXO
    public List<Path> listOrNull(@OXOo.OOXIXo Path dir) {
        IIX0o.x0xO0oo(dir, "dir");
        List<Path> listOrNull = this.delegate.listOrNull(onPathParameter(dir, "listOrNull", MapBundleKey.MapObjKey.OBJ_DIR));
        if (listOrNull == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listOrNull.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((Path) it.next(), "listOrNull"));
        }
        o00.IoOoo(arrayList);
        return arrayList;
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public ooOOo0oXI<Path> listRecursively(@OXOo.OOXIXo Path dir, boolean z) {
        IIX0o.x0xO0oo(dir, "dir");
        return SequencesKt___SequencesKt.X0xxXX0(this.delegate.listRecursively(onPathParameter(dir, "listRecursively", MapBundleKey.MapObjKey.OBJ_DIR), z), new Oox.oOoXoXO<Path, Path>() { // from class: okio.ForwardingFileSystem$listRecursively$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Path invoke(@OXOo.OOXIXo Path it) {
                IIX0o.x0xO0oo(it, "it");
                return ForwardingFileSystem.this.onPathResult(it, "listRecursively");
            }
        });
    }

    @Override // okio.FileSystem
    @OXOo.oOoXoXO
    public FileMetadata metadataOrNull(@OXOo.OOXIXo Path path) throws IOException {
        FileMetadata copy;
        IIX0o.x0xO0oo(path, "path");
        FileMetadata metadataOrNull = this.delegate.metadataOrNull(onPathParameter(path, "metadataOrNull", "path"));
        if (metadataOrNull == null) {
            return null;
        }
        if (metadataOrNull.getSymlinkTarget() != null) {
            copy = metadataOrNull.copy((r18 & 1) != 0 ? metadataOrNull.isRegularFile : false, (r18 & 2) != 0 ? metadataOrNull.isDirectory : false, (r18 & 4) != 0 ? metadataOrNull.symlinkTarget : onPathResult(metadataOrNull.getSymlinkTarget(), "metadataOrNull"), (r18 & 8) != 0 ? metadataOrNull.size : null, (r18 & 16) != 0 ? metadataOrNull.createdAtMillis : null, (r18 & 32) != 0 ? metadataOrNull.lastModifiedAtMillis : null, (r18 & 64) != 0 ? metadataOrNull.lastAccessedAtMillis : null, (r18 & 128) != 0 ? metadataOrNull.extras : null);
            return copy;
        }
        return metadataOrNull;
    }

    @OXOo.OOXIXo
    public Path onPathParameter(@OXOo.OOXIXo Path path, @OXOo.OOXIXo String functionName, @OXOo.OOXIXo String parameterName) {
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(functionName, "functionName");
        IIX0o.x0xO0oo(parameterName, "parameterName");
        return path;
    }

    @OXOo.OOXIXo
    public Path onPathResult(@OXOo.OOXIXo Path path, @OXOo.OOXIXo String functionName) {
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(functionName, "functionName");
        return path;
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public FileHandle openReadOnly(@OXOo.OOXIXo Path file) throws IOException {
        IIX0o.x0xO0oo(file, "file");
        return this.delegate.openReadOnly(onPathParameter(file, "openReadOnly", "file"));
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public FileHandle openReadWrite(@OXOo.OOXIXo Path file, boolean z, boolean z2) throws IOException {
        IIX0o.x0xO0oo(file, "file");
        return this.delegate.openReadWrite(onPathParameter(file, "openReadWrite", "file"), z, z2);
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public Sink sink(@OXOo.OOXIXo Path file, boolean z) throws IOException {
        IIX0o.x0xO0oo(file, "file");
        return this.delegate.sink(onPathParameter(file, "sink", "file"), z);
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public Source source(@OXOo.OOXIXo Path file) throws IOException {
        IIX0o.x0xO0oo(file, "file");
        return this.delegate.source(onPathParameter(file, "source", "file"));
    }

    @OXOo.OOXIXo
    public String toString() {
        return IO.oxoX(getClass()).xoXoI() + HexStringBuilder.COMMENT_BEGIN_CHAR + this.delegate + HexStringBuilder.COMMENT_END_CHAR;
    }
}
