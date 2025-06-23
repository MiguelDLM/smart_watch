package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;

@kotlin.jvm.internal.XX({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/LinkFollowing\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,177:1\n26#2:178\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/LinkFollowing\n*L\n142#1:178\n*E\n"})
/* loaded from: classes6.dex */
public final class oI0IIXIo {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final LinkOption[] f29260I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final LinkOption[] f29261II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Set<FileVisitOption> f29262X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oI0IIXIo f29263oIX0oI = new oI0IIXIo();

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Set<FileVisitOption> f29264oxoX;

    static {
        LinkOption linkOption;
        FileVisitOption fileVisitOption;
        linkOption = LinkOption.NOFOLLOW_LINKS;
        f29261II0xO0 = new LinkOption[]{linkOption};
        f29260I0Io = new LinkOption[0];
        f29264oxoX = kotlin.collections.Xo0.OOXIXo();
        fileVisitOption = FileVisitOption.FOLLOW_LINKS;
        f29262X0o0xo = kotlin.collections.oX.XO(fileVisitOption);
    }

    @OXOo.OOXIXo
    public final Set<FileVisitOption> II0xO0(boolean z) {
        if (z) {
            return f29262X0o0xo;
        }
        return f29264oxoX;
    }

    @OXOo.OOXIXo
    public final LinkOption[] oIX0oI(boolean z) {
        if (z) {
            return f29260I0Io;
        }
        return f29261II0xO0;
    }
}
