package com.airbnb.lottie.model.content;

import IIXOooo.XO;
import IXxxXO.II0xO0;
import androidx.annotation.Nullable;
import com.airbnb.lottie.xoIox;
import ooOOo0oXI.I0Io;
import ooOOo0oXI.oOoXoXO;

/* loaded from: classes.dex */
public class MergePaths implements II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final boolean f4845I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final MergePathsMode f4846II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f4847oIX0oI;

    /* loaded from: classes.dex */
    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return MERGE;
                            }
                            return EXCLUDE_INTERSECTIONS;
                        }
                        return INTERSECT;
                    }
                    return SUBTRACT;
                }
                return ADD;
            }
            return MERGE;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z) {
        this.f4847oIX0oI = str;
        this.f4846II0xO0 = mergePathsMode;
        this.f4845I0Io = z;
    }

    public String I0Io() {
        return this.f4847oIX0oI;
    }

    public MergePathsMode II0xO0() {
        return this.f4846II0xO0;
    }

    @Override // IXxxXO.II0xO0
    @Nullable
    public I0Io oIX0oI(xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi) {
        if (!xoiox.IXxxXO()) {
            XO.X0o0xo("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new oOoXoXO(this);
    }

    public boolean oxoX() {
        return this.f4845I0Io;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f4846II0xO0 + '}';
    }
}
