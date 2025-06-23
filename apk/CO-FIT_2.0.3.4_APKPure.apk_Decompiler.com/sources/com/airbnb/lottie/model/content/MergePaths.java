package com.airbnb.lottie.model.content;

import IIXOooo.XO;
import IXxxXO.II0xO0;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.oIX0oI;
import com.airbnb.lottie.xoIox;
import ooOOo0oXI.I0Io;
import ooOOo0oXI.oOoXoXO;

public class MergePaths implements II0xO0 {

    /* renamed from: I0Io  reason: collision with root package name */
    public final boolean f851I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final MergePathsMode f852II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final String f853oIX0oI;

    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i) {
            if (i == 1) {
                return MERGE;
            }
            if (i == 2) {
                return ADD;
            }
            if (i == 3) {
                return SUBTRACT;
            }
            if (i == 4) {
                return INTERSECT;
            }
            if (i != 5) {
                return MERGE;
            }
            return EXCLUDE_INTERSECTIONS;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z) {
        this.f853oIX0oI = str;
        this.f852II0xO0 = mergePathsMode;
        this.f851I0Io = z;
    }

    public String I0Io() {
        return this.f853oIX0oI;
    }

    public MergePathsMode II0xO0() {
        return this.f852II0xO0;
    }

    @Nullable
    public I0Io oIX0oI(xoIox xoiox, oIX0oI oix0oi) {
        if (xoiox.IXxxXO()) {
            return new oOoXoXO(this);
        }
        XO.X0o0xo("Animation contains merge paths but they are disabled.");
        return null;
    }

    public boolean oxoX() {
        return this.f851I0Io;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f852II0xO0 + '}';
    }
}
