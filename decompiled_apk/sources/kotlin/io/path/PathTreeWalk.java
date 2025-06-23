package kotlin.io.path;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.oXIO0o0XI;

@ooOOo0oXI
/* loaded from: classes6.dex */
public final class PathTreeWalk implements kotlin.sequences.ooOOo0oXI<Path> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final PathWalkOption[] f29256II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Path f29257oIX0oI;

    public PathTreeWalk(@OXOo.OOXIXo Path start, @OXOo.OOXIXo PathWalkOption[] options) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(start, "start");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        this.f29257oIX0oI = start;
        this.f29256II0xO0 = options;
    }

    public final boolean II0XooXoX() {
        return ArraysKt___ArraysKt.OXO0oX(this.f29256II0xO0, PathWalkOption.FOLLOW_LINKS);
    }

    public final boolean OOXIXo() {
        return ArraysKt___ArraysKt.OXO0oX(this.f29256II0xO0, PathWalkOption.BREADTH_FIRST);
    }

    public final Iterator<Path> Oxx0IOOO() {
        return kotlin.sequences.IXxxXO.oIX0oI(new PathTreeWalk$dfsIterator$1(this, null));
    }

    public final Iterator<Path> XO() {
        return kotlin.sequences.IXxxXO.oIX0oI(new PathTreeWalk$bfsIterator$1(this, null));
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<Path> iterator() {
        if (OOXIXo()) {
            return XO();
        }
        return Oxx0IOOO();
    }

    public final Object oOoXoXO(kotlin.sequences.oO<? super Path> oOVar, OxxIIOOXO oxxIIOOXO, Oxx0IOOO oxx0IOOO, Oox.oOoXoXO<? super List<OxxIIOOXO>, oXIO0o0XI> oooxoxo, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        boolean isDirectory;
        LinkOption linkOption;
        boolean exists;
        boolean I0Io2;
        boolean isDirectory2;
        Path oxoX2 = oxxIIOOXO.oxoX();
        LinkOption[] xoIox2 = xoIox();
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(xoIox2, xoIox2.length);
        isDirectory = Files.isDirectory(oxoX2, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (isDirectory) {
            I0Io2 = XIxXXX0x0.I0Io(oxxIIOOXO);
            if (!I0Io2) {
                if (xxIXOIIO()) {
                    kotlin.jvm.internal.xxX.X0o0xo(0);
                    oOVar.II0xO0(oxoX2, i0Io);
                    kotlin.jvm.internal.xxX.X0o0xo(1);
                }
                LinkOption[] xoIox3 = xoIox();
                LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(xoIox3, xoIox3.length);
                isDirectory2 = Files.isDirectory(oxoX2, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length));
                if (isDirectory2) {
                    oooxoxo.invoke(oxx0IOOO.I0Io(oxxIIOOXO));
                }
            } else {
                XI0IXoo.oIX0oI();
                throw X0IIOO.oIX0oI(oxoX2.toString());
            }
        } else {
            linkOption = LinkOption.NOFOLLOW_LINKS;
            exists = Files.exists(oxoX2, (LinkOption[]) Arrays.copyOf(new LinkOption[]{linkOption}, 1));
            if (exists) {
                kotlin.jvm.internal.xxX.X0o0xo(0);
                oOVar.II0xO0(oxoX2, i0Io);
                kotlin.jvm.internal.xxX.X0o0xo(1);
                return oXIO0o0XI.f29392oIX0oI;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    public final LinkOption[] xoIox() {
        return oI0IIXIo.f29263oIX0oI.oIX0oI(II0XooXoX());
    }

    public final boolean xxIXOIIO() {
        return ArraysKt___ArraysKt.OXO0oX(this.f29256II0xO0, PathWalkOption.INCLUDE_DIRECTORIES);
    }
}
