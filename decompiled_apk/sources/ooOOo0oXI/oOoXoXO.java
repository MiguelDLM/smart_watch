package ooOOo0oXI;

import android.annotation.TargetApi;
import android.graphics.Path;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* loaded from: classes.dex */
public class oOoXoXO implements x0XOIxOo, xoIox {

    /* renamed from: XO, reason: collision with root package name */
    public final MergePaths f32411XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public final String f32413oxoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Path f32412oIX0oI = new Path();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Path f32409II0xO0 = new Path();

    /* renamed from: I0Io, reason: collision with root package name */
    public final Path f32408I0Io = new Path();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final List<x0XOIxOo> f32410X0o0xo = new ArrayList();

    /* loaded from: classes.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f32414oIX0oI;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f32414oIX0oI = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32414oIX0oI[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32414oIX0oI[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32414oIX0oI[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32414oIX0oI[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public oOoXoXO(MergePaths mergePaths) {
        this.f32413oxoX = mergePaths.I0Io();
        this.f32411XO = mergePaths;
    }

    @Override // ooOOo0oXI.xoIox
    public void II0xO0(ListIterator<I0Io> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            I0Io previous = listIterator.previous();
            if (previous instanceof x0XOIxOo) {
                this.f32410X0o0xo.add((x0XOIxOo) previous);
                listIterator.remove();
            }
        }
    }

    @Override // ooOOo0oXI.I0Io
    public void X0o0xo(List<I0Io> list, List<I0Io> list2) {
        for (int i = 0; i < this.f32410X0o0xo.size(); i++) {
            this.f32410X0o0xo.get(i).X0o0xo(list, list2);
        }
    }

    @TargetApi(19)
    public final void XO(Path.Op op) {
        this.f32409II0xO0.reset();
        this.f32412oIX0oI.reset();
        for (int size = this.f32410X0o0xo.size() - 1; size >= 1; size--) {
            x0XOIxOo x0xoixoo = this.f32410X0o0xo.get(size);
            if (x0xoixoo instanceof oxoX) {
                oxoX oxox = (oxoX) x0xoixoo;
                List<x0XOIxOo> xxIXOIIO2 = oxox.xxIXOIIO();
                for (int size2 = xxIXOIIO2.size() - 1; size2 >= 0; size2--) {
                    Path path = xxIXOIIO2.get(size2).getPath();
                    path.transform(oxox.xoIox());
                    this.f32409II0xO0.addPath(path);
                }
            } else {
                this.f32409II0xO0.addPath(x0xoixoo.getPath());
            }
        }
        x0XOIxOo x0xoixoo2 = this.f32410X0o0xo.get(0);
        if (x0xoixoo2 instanceof oxoX) {
            oxoX oxox2 = (oxoX) x0xoixoo2;
            List<x0XOIxOo> xxIXOIIO3 = oxox2.xxIXOIIO();
            for (int i = 0; i < xxIXOIIO3.size(); i++) {
                Path path2 = xxIXOIIO3.get(i).getPath();
                path2.transform(oxox2.xoIox());
                this.f32412oIX0oI.addPath(path2);
            }
        } else {
            this.f32412oIX0oI.set(x0xoixoo2.getPath());
        }
        this.f32408I0Io.op(this.f32412oIX0oI, this.f32409II0xO0, op);
    }

    @Override // ooOOo0oXI.I0Io
    public String getName() {
        return this.f32413oxoX;
    }

    @Override // ooOOo0oXI.x0XOIxOo
    public Path getPath() {
        this.f32408I0Io.reset();
        if (this.f32411XO.oxoX()) {
            return this.f32408I0Io;
        }
        int i = oIX0oI.f32414oIX0oI[this.f32411XO.II0xO0().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            XO(Path.Op.XOR);
                        }
                    } else {
                        XO(Path.Op.INTERSECT);
                    }
                } else {
                    XO(Path.Op.REVERSE_DIFFERENCE);
                }
            } else {
                XO(Path.Op.UNION);
            }
        } else {
            oxoX();
        }
        return this.f32408I0Io;
    }

    public final void oxoX() {
        for (int i = 0; i < this.f32410X0o0xo.size(); i++) {
            this.f32408I0Io.addPath(this.f32410X0o0xo.get(i).getPath());
        }
    }
}
