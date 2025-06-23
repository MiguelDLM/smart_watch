package com.github.appintro.internal.viewpager;

import OXOo.OOXIXo;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.github.appintro.AppIntroPageTransformerType;
import com.github.appintro.R;
import com.github.appintro.internal.LogHelper;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.IO;

/* loaded from: classes9.dex */
public final class ViewPagerTransformer implements ViewPager.PageTransformer {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final String TAG = LogHelper.INSTANCE.makeLogTag(IO.oxoX(ViewPagerTransformer.class));
    private double descriptionPF;
    private double imagePF;
    private double titlePF;

    @OOXIXo
    private final AppIntroPageTransformerType transformType;

    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public ViewPagerTransformer(@OOXIXo AppIntroPageTransformerType transformType) {
        IIX0o.x0xO0oo(transformType, "transformType");
        this.transformType = transformType;
    }

    private final void applyParallax(View view, float f) {
        ((TextView) view.findViewById(R.id.title)).setTranslationX(computeParallax(view, f, this.titlePF));
        ((ImageView) view.findViewById(R.id.image)).setTranslationX(computeParallax(view, f, this.imagePF));
        ((TextView) view.findViewById(R.id.description)).setTranslationX(computeParallax(view, f, this.descriptionPF));
    }

    private final float computeParallax(View view, float f, double d) {
        return (float) ((-f) * (view.getWidth() / d));
    }

    private final void transformDepth(float f, View view) {
        if (f <= 0.0f || f >= 1.0f) {
            ViewPagerTransformerKt.transformDefaults(view);
            return;
        }
        float f2 = 1;
        view.setAlpha(f2 - f);
        ViewPagerTransformerKt.setScaleXY(view, ((f2 - Math.abs(f)) * 0.25f) + 0.75f);
        view.setTranslationX(view.getWidth() * (-f));
    }

    private final void transformFade(float f, View view) {
        if (f > -1.0f && f < 1.0f) {
            if (f == 0.0f) {
                view.setTranslationX(0.0f);
                view.setAlpha(1.0f);
                view.setClickable(true);
                return;
            } else {
                view.setTranslationX(view.getWidth() * (-f));
                view.setAlpha(1.0f - Math.abs(f));
                return;
            }
        }
        view.setTranslationX(view.getWidth());
        view.setAlpha(0.0f);
        view.setClickable(false);
    }

    private final void transformParallax(float f, View view) {
        if (f > -1.0f && f < 1.0f) {
            try {
                applyParallax(view, f);
            } catch (IllegalStateException e) {
                LogHelper.e(TAG, "Failed to apply parallax effect", e);
            }
        }
    }

    private final void transformSlideOver(float f, View view) {
        if (f >= 0.0f || f <= -1.0f) {
            ViewPagerTransformerKt.transformDefaults(view);
            return;
        }
        float f2 = 1;
        ViewPagerTransformerKt.setScaleXY(view, (Math.abs(Math.abs(f) - f2) * 0.14999998f) + 0.85f);
        view.setAlpha(Math.max(0.35f, f2 - Math.abs(f)));
        float f3 = -view.getWidth();
        float f4 = f * f3;
        if (f4 > f3) {
            view.setTranslationX(f4);
        } else {
            view.setTranslationX(0.0f);
        }
    }

    private final void transformZoom(float f, View view) {
        float scaleXY;
        float scaleXY2;
        float scaleXY3;
        if (f < -1.0f || f > 1.0f) {
            ViewPagerTransformerKt.transformDefaults(view);
            return;
        }
        float f2 = 1;
        ViewPagerTransformerKt.setScaleXY(view, Math.max(0.85f, f2 - Math.abs(f)));
        scaleXY = ViewPagerTransformerKt.getScaleXY(view);
        view.setAlpha((((scaleXY - 0.85f) / 0.14999998f) * 0.5f) + 0.5f);
        float height = view.getHeight();
        scaleXY2 = ViewPagerTransformerKt.getScaleXY(view);
        float f3 = height * (f2 - scaleXY2);
        float f4 = 2;
        float f5 = f3 / f4;
        float width = view.getWidth();
        scaleXY3 = ViewPagerTransformerKt.getScaleXY(view);
        float f6 = (width * (f2 - scaleXY3)) / f4;
        if (f < 0.0f) {
            view.setTranslationX(f6 - (f5 / f4));
        } else {
            view.setTranslationX((-f6) + (f5 / f4));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(@OOXIXo View page, float f) {
        IIX0o.x0xO0oo(page, "page");
        AppIntroPageTransformerType appIntroPageTransformerType = this.transformType;
        if (IIX0o.Oxx0IOOO(appIntroPageTransformerType, AppIntroPageTransformerType.Flow.INSTANCE)) {
            page.setRotationY(f * (-30.0f));
            return;
        }
        if (IIX0o.Oxx0IOOO(appIntroPageTransformerType, AppIntroPageTransformerType.SlideOver.INSTANCE)) {
            transformSlideOver(f, page);
            return;
        }
        if (IIX0o.Oxx0IOOO(appIntroPageTransformerType, AppIntroPageTransformerType.Depth.INSTANCE)) {
            transformDepth(f, page);
            return;
        }
        if (IIX0o.Oxx0IOOO(appIntroPageTransformerType, AppIntroPageTransformerType.Zoom.INSTANCE)) {
            transformZoom(f, page);
            return;
        }
        if (IIX0o.Oxx0IOOO(appIntroPageTransformerType, AppIntroPageTransformerType.Fade.INSTANCE)) {
            transformFade(f, page);
        } else if (appIntroPageTransformerType instanceof AppIntroPageTransformerType.Parallax) {
            this.titlePF = ((AppIntroPageTransformerType.Parallax) this.transformType).getTitleParallaxFactor();
            this.imagePF = ((AppIntroPageTransformerType.Parallax) this.transformType).getImageParallaxFactor();
            this.descriptionPF = ((AppIntroPageTransformerType.Parallax) this.transformType).getDescriptionParallaxFactor();
            transformParallax(f, page);
        }
    }
}
