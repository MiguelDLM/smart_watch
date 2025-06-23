package com.github.appintro;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes9.dex */
public abstract class AppIntroPageTransformerType {

    /* loaded from: classes9.dex */
    public static final class Depth extends AppIntroPageTransformerType {

        @OOXIXo
        public static final Depth INSTANCE = new Depth();

        private Depth() {
            super(null);
        }
    }

    /* loaded from: classes9.dex */
    public static final class Fade extends AppIntroPageTransformerType {

        @OOXIXo
        public static final Fade INSTANCE = new Fade();

        private Fade() {
            super(null);
        }
    }

    /* loaded from: classes9.dex */
    public static final class Flow extends AppIntroPageTransformerType {

        @OOXIXo
        public static final Flow INSTANCE = new Flow();

        private Flow() {
            super(null);
        }
    }

    /* loaded from: classes9.dex */
    public static final class Parallax extends AppIntroPageTransformerType {
        private final double descriptionParallaxFactor;
        private final double imageParallaxFactor;
        private final double titleParallaxFactor;

        public Parallax() {
            this(XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 7, null);
        }

        public final double getDescriptionParallaxFactor() {
            return this.descriptionParallaxFactor;
        }

        public final double getImageParallaxFactor() {
            return this.imageParallaxFactor;
        }

        public final double getTitleParallaxFactor() {
            return this.titleParallaxFactor;
        }

        public /* synthetic */ Parallax(double d, double d2, double d3, int i, IIXOooo iIXOooo) {
            this((i & 1) != 0 ? 1.0d : d, (i & 2) != 0 ? -1.0d : d2, (i & 4) != 0 ? 2.0d : d3);
        }

        public Parallax(double d, double d2, double d3) {
            super(null);
            this.titleParallaxFactor = d;
            this.imageParallaxFactor = d2;
            this.descriptionParallaxFactor = d3;
        }
    }

    /* loaded from: classes9.dex */
    public static final class SlideOver extends AppIntroPageTransformerType {

        @OOXIXo
        public static final SlideOver INSTANCE = new SlideOver();

        private SlideOver() {
            super(null);
        }
    }

    /* loaded from: classes9.dex */
    public static final class Zoom extends AppIntroPageTransformerType {

        @OOXIXo
        public static final Zoom INSTANCE = new Zoom();

        private Zoom() {
            super(null);
        }
    }

    public /* synthetic */ AppIntroPageTransformerType(IIXOooo iIXOooo) {
        this();
    }

    private AppIntroPageTransformerType() {
    }
}
