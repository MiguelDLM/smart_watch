package okio.internal;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@oxoX(c = "okio.internal.-FileSystem", f = "FileSystem.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {116, 135, 145}, m = "collectRecursively", n = {"$this$collectRecursively", "fileSystem", "stack", "path", "followSymlinks", "postorder", "$this$collectRecursively", "fileSystem", "stack", "path", "followSymlinks", "postorder"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1"})
/* renamed from: okio.internal.-FileSystem$collectRecursively$1, reason: invalid class name */
/* loaded from: classes6.dex */
public final class FileSystem$collectRecursively$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;

    public FileSystem$collectRecursively$1(I0Io<? super FileSystem$collectRecursively$1> i0Io) {
        super(i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FileSystem.collectRecursively(null, null, null, null, false, false, this);
    }
}
