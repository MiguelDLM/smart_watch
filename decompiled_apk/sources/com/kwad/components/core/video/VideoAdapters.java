package com.kwad.components.core.video;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes11.dex */
public final class VideoAdapters {

    /* renamed from: com.kwad.components.core.video.VideoAdapters$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Vz;

        static {
            int[] iArr = new int[AdaptType.values().length];
            Vz = iArr;
            try {
                iArr[AdaptType.PORTRAIT_VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Vz[AdaptType.LANDSCAPE_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Vz[AdaptType.PORTRAIT_HORIZONTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Vz[AdaptType.LANDSCAPE_VERTICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public enum AdaptType {
        PORTRAIT_VERTICAL,
        PORTRAIT_HORIZONTAL,
        LANDSCAPE_VERTICAL,
        LANDSCAPE_HORIZONTAL
    }

    /* loaded from: classes11.dex */
    public static abstract class a implements com.kwad.components.core.video.c {
        private static boolean b(View view, View view2, int i, int i2) {
            if (view == null || i == 0 || i2 == 0 || view2 == null) {
                return false;
            }
            int width = view2.getWidth();
            int height = view2.getHeight();
            if (width == 0 || height == 0) {
                return false;
            }
            return true;
        }

        @Override // com.kwad.components.core.video.c
        public final void a(View view, View view2, int i, int i2) {
            AdaptType adaptType;
            if (!b(view, view2, i, i2)) {
                com.kwad.sdk.core.e.c.d("AbstractVideoViewAdapter", "adaptVideo checkArguments invalid");
                return;
            }
            d dVar = new d(view2.getWidth(), view2.getHeight());
            d dVar2 = new d(i, i2);
            boolean z = dVar2.getRatio() >= 1.0f;
            boolean z2 = dVar.getRatio() >= 1.0f;
            if (z2 && z) {
                adaptType = AdaptType.PORTRAIT_VERTICAL;
            } else if (z2) {
                adaptType = AdaptType.PORTRAIT_HORIZONTAL;
            } else if (z) {
                adaptType = AdaptType.LANDSCAPE_VERTICAL;
            } else {
                adaptType = AdaptType.LANDSCAPE_HORIZONTAL;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            a(adaptType, layoutParams, dVar, dVar2);
            view.setLayoutParams(layoutParams);
        }

        public abstract void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2);
    }

    /* loaded from: classes11.dex */
    public static class b extends a {
        private float VA = 0.8f;
        private float VB = 0.9375f;
        private float VC = 1.1046f;

        @Override // com.kwad.components.core.video.VideoAdapters.a
        public final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float st;
            float f;
            float su = dVar.su();
            float su2 = dVar2.su();
            float st2 = dVar.st();
            float ss = dVar.ss();
            com.kwad.sdk.core.e.c.d("FullHeightAdapter", "onAdaptVideo containerSize: " + ss + ", " + st2);
            int i = AnonymousClass1.Vz[adaptType.ordinal()];
            if (i != 1 && i != 2) {
                if (i != 3 && i != 4) {
                    st = -2.1474836E9f;
                    f = -2.1474836E9f;
                } else {
                    f = st2 * this.VC;
                    st = f / su2;
                }
            } else if (su > su2) {
                float ss2 = dVar.ss();
                float f2 = ss2 / su2;
                float f3 = st2 / f2;
                float f4 = this.VA;
                if (f3 >= f4) {
                    f = ss2;
                    st = f2;
                } else {
                    st = st2 / f4;
                    f = st * su2;
                }
            } else {
                st = dVar.st();
                f = su2 * st;
                float f5 = ss / f;
                float f6 = this.VB;
                if (f5 < f6) {
                    f = ss / f6;
                    st = f / su2;
                }
            }
            com.kwad.sdk.core.e.c.d("FullHeightAdapter", "onAdaptVideo result: " + f + ", " + st);
            if (f != -2.1474836E9f && st != -2.1474836E9f) {
                if (dVar2.getHeight() >= dVar2.getWidth()) {
                    layoutParams.width = (int) st;
                    layoutParams.height = (int) f;
                } else {
                    layoutParams.height = (int) st;
                    layoutParams.width = (int) f;
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class c extends a {
        @Override // com.kwad.components.core.video.VideoAdapters.a
        public final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float ss;
            float st;
            float su = dVar.su();
            float su2 = dVar2.su();
            int i = AnonymousClass1.Vz[adaptType.ordinal()];
            if (i != 1 && i != 2) {
                if (i != 3 && i != 4) {
                    ss = 0.0f;
                    st = -2.1474836E9f;
                } else {
                    ss = dVar.st();
                    st = ss / su2;
                }
            } else if (su >= su2) {
                st = dVar.st();
                ss = st * su2;
            } else {
                ss = dVar.ss();
                st = ss / su2;
            }
            if (st != -2.1474836E9f && ss != -2.1474836E9f) {
                if (dVar2.getHeight() > dVar2.getWidth()) {
                    layoutParams.width = (int) st;
                    layoutParams.height = (int) ss;
                } else {
                    layoutParams.height = (int) st;
                    layoutParams.width = (int) ss;
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class d {
        float VD;
        float height;
        float width;

        public d(float f, float f2) {
            this.VD = -1.0f;
            this.width = f;
            this.height = f2;
            if (f > 0.0f && f2 > 0.0f) {
                this.VD = f2 / f;
            }
        }

        private boolean isValid() {
            if (this.width > 0.0f && this.height > 0.0f) {
                return true;
            }
            return false;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getRatio() {
            return this.VD;
        }

        public final float getWidth() {
            return this.width;
        }

        public final float ss() {
            if (!isValid()) {
                return -1.0f;
            }
            return Math.max(this.width, this.height);
        }

        public final float st() {
            if (!isValid()) {
                return -1.0f;
            }
            return Math.min(this.width, this.height);
        }

        public final float su() {
            if (!isValid()) {
                return -1.0f;
            }
            float f = this.height;
            float f2 = this.width;
            if (f > f2) {
                return f / f2;
            }
            return f2 / f;
        }

        public final String toString() {
            return "ViewSize{width=" + this.width + ", height=" + this.height + ", ratio=" + this.VD + '}';
        }
    }
}
