package okio.internal;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import java.util.Iterator;
import kotlin.I0oOoX;
import kotlin.collections.xxIXOIIO;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.oXIO0o0XI;
import kotlin.sequences.oO;
import okio.FileSystem;
import okio.Path;

@oxoX(c = "okio.internal.-FileSystem$commonListRecursively$1", f = "FileSystem.kt", i = {0, 0}, l = {96}, m = "invokeSuspend", n = {"$this$sequence", "stack"}, s = {"L$0", "L$1"})
/* renamed from: okio.internal.-FileSystem$commonListRecursively$1, reason: invalid class name */
/* loaded from: classes6.dex */
public final class FileSystem$commonListRecursively$1 extends RestrictedSuspendLambda implements x0xO0oo<oO<? super Path>, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Path $dir;
    final /* synthetic */ boolean $followSymlinks;
    final /* synthetic */ FileSystem $this_commonListRecursively;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystem$commonListRecursively$1(Path path, FileSystem fileSystem, boolean z, I0Io<? super FileSystem$commonListRecursively$1> i0Io) {
        super(2, i0Io);
        this.$dir = path;
        this.$this_commonListRecursively = fileSystem;
        this.$followSymlinks = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OOXIXo
    public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
        FileSystem$commonListRecursively$1 fileSystem$commonListRecursively$1 = new FileSystem$commonListRecursively$1(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, i0Io);
        fileSystem$commonListRecursively$1.L$0 = obj;
        return fileSystem$commonListRecursively$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        oO oOVar;
        xxIXOIIO xxixoiio;
        Iterator<Path> it;
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                it = (Iterator) this.L$2;
                xxIXOIIO xxixoiio2 = (xxIXOIIO) this.L$1;
                oO oOVar2 = (oO) this.L$0;
                I0oOoX.x0XOIxOo(obj);
                xxixoiio = xxixoiio2;
                oOVar = oOVar2;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            oO oOVar3 = (oO) this.L$0;
            xxIXOIIO xxixoiio3 = new xxIXOIIO();
            xxixoiio3.addLast(this.$dir);
            oOVar = oOVar3;
            xxixoiio = xxixoiio3;
            it = this.$this_commonListRecursively.list(this.$dir).iterator();
        }
        while (it.hasNext()) {
            Path next = it.next();
            FileSystem fileSystem = this.$this_commonListRecursively;
            boolean z = this.$followSymlinks;
            this.L$0 = oOVar;
            this.L$1 = xxixoiio;
            this.L$2 = it;
            this.label = 1;
            if (FileSystem.collectRecursively(oOVar, fileSystem, xxixoiio, next, z, false, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @oOoXoXO
    public final Object invoke(@OOXIXo oO<? super Path> oOVar, @oOoXoXO I0Io<? super oXIO0o0XI> i0Io) {
        return ((FileSystem$commonListRecursively$1) create(oOVar, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
