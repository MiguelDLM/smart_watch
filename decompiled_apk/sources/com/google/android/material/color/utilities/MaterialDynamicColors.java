package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.baidu.navisdk.util.jar.style.StyleAttr;
import java.util.function.Function;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes9.dex */
public final class MaterialDynamicColors {
    public static double findDesiredChromaByTone(double d, double d2, double d3, boolean z) {
        double d4;
        Hct from = Hct.from(d, d2, d3);
        if (from.getChroma() < d2) {
            double chroma = from.getChroma();
            Hct hct = from;
            double d5 = d3;
            while (hct.getChroma() < d2) {
                if (z) {
                    d4 = -1.0d;
                } else {
                    d4 = 1.0d;
                }
                d5 += d4;
                Hct from2 = Hct.from(d, d2, d5);
                if (chroma <= from2.getChroma() && Math.abs(from2.getChroma() - d2) >= 0.4d) {
                    if (Math.abs(from2.getChroma() - d2) < Math.abs(hct.getChroma() - d2)) {
                        hct = from2;
                    }
                    chroma = Math.max(chroma, from2.getChroma());
                } else {
                    return d5;
                }
            }
            return d5;
        }
        return d3;
    }

    private static boolean isFidelity(DynamicScheme dynamicScheme) {
        Variant variant = dynamicScheme.variant;
        if (variant != Variant.FIDELITY && variant != Variant.CONTENT) {
            return false;
        }
        return true;
    }

    private static boolean isMonochrome(DynamicScheme dynamicScheme) {
        if (dynamicScheme.variant == Variant.MONOCHROME) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$background$11(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 6.0d;
        } else {
            d = 98.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlActivated$146(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlHighlight$150(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 100.0d;
        } else {
            d = XIXIX.OOXIXo.f3760XO;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlHighlight$151(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 0.2d;
        } else {
            d = 0.12d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlNormal$148(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 30.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$error$92(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 40.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$error$93(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(errorContainer(), error(), 15.0d, TonePolarity.NEARER, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$errorContainer$98(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$errorContainer$99(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(errorContainer(), error(), 15.0d, TonePolarity.NEARER, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$inverseOnSurface$40(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 20.0d;
        } else {
            d = 95.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$inverseOnSurface$41(DynamicScheme dynamicScheme) {
        return inverseSurface();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$inversePrimary$65(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 40.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$inversePrimary$66(DynamicScheme dynamicScheme) {
        return inverseSurface();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$inverseSurface$38(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 20.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$neutralPaletteKeyColor$7(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.neutralPalette.getKeyColor().getTone());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$neutralVariantPaletteKeyColor$9(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.neutralVariantPalette.getKeyColor().getTone());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onBackground$13(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onBackground$14(DynamicScheme dynamicScheme) {
        return background();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onError$95(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 20.0d;
        } else {
            d = 100.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onError$96(DynamicScheme dynamicScheme) {
        return error();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onErrorContainer$101(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onErrorContainer$102(DynamicScheme dynamicScheme) {
        return errorContainer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onPrimary$56(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 10.0d;
            } else {
                d2 = 90.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 20.0d;
        } else {
            d = 100.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimary$57(DynamicScheme dynamicScheme) {
        return primary();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Double lambda$onPrimaryContainer$62(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        Object apply;
        if (isFidelity(dynamicScheme)) {
            apply = primaryContainer().tone.apply(dynamicScheme);
            return Double.valueOf(DynamicColor.foregroundTone(((Double) apply).doubleValue(), 4.5d));
        }
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = XIXIX.OOXIXo.f3760XO;
            } else {
                d2 = 100.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryContainer$63(DynamicScheme dynamicScheme) {
        return primaryContainer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onPrimaryFixed$110(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 100.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryFixed$111(DynamicScheme dynamicScheme) {
        return primaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryFixed$112(DynamicScheme dynamicScheme) {
        return primaryFixed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onPrimaryFixedVariant$114(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 90.0d;
        } else {
            d = 30.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryFixedVariant$115(DynamicScheme dynamicScheme) {
        return primaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryFixedVariant$116(DynamicScheme dynamicScheme) {
        return primaryFixed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSecondary$71(DynamicScheme dynamicScheme) {
        double d = 100.0d;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d = 10.0d;
            }
            return Double.valueOf(d);
        }
        if (dynamicScheme.isDark) {
            d = 20.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondary$72(DynamicScheme dynamicScheme) {
        return secondary();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Double lambda$onSecondaryContainer$77(DynamicScheme dynamicScheme) {
        Object apply;
        double d;
        if (isFidelity(dynamicScheme)) {
            apply = secondaryContainer().tone.apply(dynamicScheme);
            return Double.valueOf(DynamicColor.foregroundTone(((Double) apply).doubleValue(), 4.5d));
        }
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryContainer$78(DynamicScheme dynamicScheme) {
        return secondaryContainer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSecondaryFixed$124(DynamicScheme dynamicScheme) {
        return Double.valueOf(10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryFixed$125(DynamicScheme dynamicScheme) {
        return secondaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryFixed$126(DynamicScheme dynamicScheme) {
        return secondaryFixed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSecondaryFixedVariant$128(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 25.0d;
        } else {
            d = 30.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryFixedVariant$129(DynamicScheme dynamicScheme) {
        return secondaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryFixedVariant$130(DynamicScheme dynamicScheme) {
        return secondaryFixed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSurface$32(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSurfaceVariant$36(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 30.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onTertiary$83(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 10.0d;
            } else {
                d2 = 90.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 20.0d;
        } else {
            d = 100.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiary$84(DynamicScheme dynamicScheme) {
        return tertiary();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Double lambda$onTertiaryContainer$89(DynamicScheme dynamicScheme) {
        Object apply;
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = XIXIX.OOXIXo.f3760XO;
            } else {
                d2 = 100.0d;
            }
            return Double.valueOf(d2);
        }
        if (isFidelity(dynamicScheme)) {
            apply = tertiaryContainer().tone.apply(dynamicScheme);
            return Double.valueOf(DynamicColor.foregroundTone(((Double) apply).doubleValue(), 4.5d));
        }
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryContainer$90(DynamicScheme dynamicScheme) {
        return tertiaryContainer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onTertiaryFixed$138(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 100.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryFixed$139(DynamicScheme dynamicScheme) {
        return tertiaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryFixed$140(DynamicScheme dynamicScheme) {
        return tertiaryFixed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onTertiaryFixedVariant$142(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 90.0d;
        } else {
            d = 30.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryFixedVariant$143(DynamicScheme dynamicScheme) {
        return tertiaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryFixedVariant$144(DynamicScheme dynamicScheme) {
        return tertiaryFixed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$outline$43(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 60.0d;
        } else {
            d = 50.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$outlineVariant$45(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primary$53(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 100.0d;
            } else {
                d2 = XIXIX.OOXIXo.f3760XO;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 40.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$primary$54(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryContainer(), primary(), 15.0d, TonePolarity.NEARER, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primaryContainer$59(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(performAlbers(dynamicScheme.sourceColorHct, dynamicScheme));
        }
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 85.0d;
            } else {
                d2 = 25.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$primaryContainer$60(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryContainer(), primary(), 15.0d, TonePolarity.NEARER, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primaryFixed$104(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 40.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$primaryFixed$105(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryFixed(), primaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primaryFixedDim$107(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 30.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$primaryFixedDim$108(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryFixed(), primaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primaryPaletteKeyColor$1(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.primaryPalette.getKeyColor().getTone());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$scrim$49(DynamicScheme dynamicScheme) {
        return Double.valueOf(XIXIX.OOXIXo.f3760XO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondary$68(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 40.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$secondary$69(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryContainer(), secondary(), 15.0d, TonePolarity.NEARER, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondaryContainer$74(DynamicScheme dynamicScheme) {
        double d;
        double d2 = 30.0d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 90.0d;
        }
        if (isMonochrome(dynamicScheme)) {
            if (!dynamicScheme.isDark) {
                d2 = 85.0d;
            }
            return Double.valueOf(d2);
        }
        if (!isFidelity(dynamicScheme)) {
            return Double.valueOf(d);
        }
        return Double.valueOf(performAlbers(dynamicScheme.secondaryPalette.getHct(findDesiredChromaByTone(dynamicScheme.secondaryPalette.getHue(), dynamicScheme.secondaryPalette.getChroma(), d, !dynamicScheme.isDark)), dynamicScheme));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$secondaryContainer$75(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryContainer(), secondary(), 15.0d, TonePolarity.NEARER, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondaryFixed$118(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 80.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$secondaryFixed$119(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryFixed(), secondaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondaryFixedDim$121(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 70.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$secondaryFixedDim$122(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryFixed(), secondaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondaryPaletteKeyColor$3(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.secondaryPalette.getKeyColor().getTone());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$shadow$47(DynamicScheme dynamicScheme) {
        return Double.valueOf(XIXIX.OOXIXo.f3760XO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surface$16(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 6.0d;
        } else {
            d = 98.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceBright$20(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 24.0d;
        } else {
            d = 98.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainer$26(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 12.0d;
        } else {
            d = 94.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainerHigh$28(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 17.0d;
        } else {
            d = 92.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainerHighest$30(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 22.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainerLow$24(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 10.0d;
        } else {
            d = 96.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainerLowest$22(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 4.0d;
        } else {
            d = 100.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceDim$18(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 6.0d;
        } else {
            d = 87.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceTint$51(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 40.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceVariant$34(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiary$80(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 90.0d;
            } else {
                d2 = 25.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 40.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$tertiary$81(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryContainer(), tertiary(), 15.0d, TonePolarity.NEARER, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiaryContainer$86(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 60.0d;
            } else {
                d2 = 49.0d;
            }
            return Double.valueOf(d2);
        }
        if (!isFidelity(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d = 30.0d;
            } else {
                d = 90.0d;
            }
            return Double.valueOf(d);
        }
        return Double.valueOf(DislikeAnalyzer.fixIfDisliked(dynamicScheme.tertiaryPalette.getHct(performAlbers(dynamicScheme.tertiaryPalette.getHct(dynamicScheme.sourceColorHct.getTone()), dynamicScheme))).getTone());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$tertiaryContainer$87(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryContainer(), tertiary(), 15.0d, TonePolarity.NEARER, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiaryFixed$132(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 40.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$tertiaryFixed$133(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryFixed(), tertiaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiaryFixedDim$135(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 30.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$tertiaryFixedDim$136(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryFixed(), tertiaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiaryPaletteKeyColor$5(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.tertiaryPalette.getKeyColor().getTone());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textHintInverse$161(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 10.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textPrimaryInverse$153(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 10.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textPrimaryInverseDisableOnly$157(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 10.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textSecondaryAndTertiaryInverse$155(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textSecondaryAndTertiaryInverseDisabled$159(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 10.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    public static double performAlbers(Hct hct, DynamicScheme dynamicScheme) {
        Hct inViewingConditions = hct.inViewingConditions(viewingConditionsForAlbers(dynamicScheme));
        if (DynamicColor.tonePrefersLightForeground(hct.getTone()) && !DynamicColor.toneAllowsLightForeground(inViewingConditions.getTone())) {
            return DynamicColor.enableLightForeground(hct.getTone());
        }
        return DynamicColor.enableLightForeground(inViewingConditions.getTone());
    }

    private static ViewingConditions viewingConditionsForAlbers(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 80.0d;
        }
        return ViewingConditions.defaultWithBackgroundLstar(d);
    }

    @NonNull
    public DynamicColor background() {
        return new DynamicColor(StyleAttr.NAME_BACKGROUND, new Function() { // from class: com.google.android.material.color.utilities.xXoOI00O
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.x0OxxIOxX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$background$11;
                lambda$background$11 = MaterialDynamicColors.lambda$background$11((DynamicScheme) obj);
                return lambda$background$11;
            }
        }, true, null, null, null, null);
    }

    @NonNull
    public DynamicColor controlActivated() {
        return DynamicColor.fromPalette("control_activated", new Function() { // from class: com.google.android.material.color.utilities.I0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.ooOx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$controlActivated$146;
                lambda$controlActivated$146 = MaterialDynamicColors.lambda$controlActivated$146((DynamicScheme) obj);
                return lambda$controlActivated$146;
            }
        });
    }

    @NonNull
    public DynamicColor controlHighlight() {
        return new DynamicColor("control_highlight", new Function() { // from class: com.google.android.material.color.utilities.oOoIIO0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.IXO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$controlHighlight$150;
                lambda$controlHighlight$150 = MaterialDynamicColors.lambda$controlHighlight$150((DynamicScheme) obj);
                return lambda$controlHighlight$150;
            }
        }, false, null, null, null, null, new Function() { // from class: com.google.android.material.color.utilities.oI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$controlHighlight$151;
                lambda$controlHighlight$151 = MaterialDynamicColors.lambda$controlHighlight$151((DynamicScheme) obj);
                return lambda$controlHighlight$151;
            }
        });
    }

    @NonNull
    public DynamicColor controlNormal() {
        return DynamicColor.fromPalette("control_normal", new Function() { // from class: com.google.android.material.color.utilities.I0oOIX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralVariantPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.O00XxXI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$controlNormal$148;
                lambda$controlNormal$148 = MaterialDynamicColors.lambda$controlNormal$148((DynamicScheme) obj);
                return lambda$controlNormal$148;
            }
        });
    }

    @NonNull
    public DynamicColor error() {
        return new DynamicColor("error", new Function() { // from class: com.google.android.material.color.utilities.IoOoX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).errorPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.Xx000oIo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$error$92;
                lambda$error$92 = MaterialDynamicColors.lambda$error$92((DynamicScheme) obj);
                return lambda$error$92;
            }
        }, true, new oo0oIXo(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new Function() { // from class: com.google.android.material.color.utilities.X00IoxXI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ToneDeltaPair lambda$error$93;
                lambda$error$93 = MaterialDynamicColors.this.lambda$error$93((DynamicScheme) obj);
                return lambda$error$93;
            }
        });
    }

    @NonNull
    public DynamicColor errorContainer() {
        return new DynamicColor("error_container", new Function() { // from class: com.google.android.material.color.utilities.I0X0x0oIo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).errorPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.oX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$errorContainer$98;
                lambda$errorContainer$98 = MaterialDynamicColors.lambda$errorContainer$98((DynamicScheme) obj);
                return lambda$errorContainer$98;
            }
        }, true, new oo0oIXo(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.Xo0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ToneDeltaPair lambda$errorContainer$99;
                lambda$errorContainer$99 = MaterialDynamicColors.this.lambda$errorContainer$99((DynamicScheme) obj);
                return lambda$errorContainer$99;
            }
        });
    }

    @NonNull
    public DynamicColor highestSurface(@NonNull DynamicScheme dynamicScheme) {
        if (dynamicScheme.isDark) {
            return surfaceBright();
        }
        return surfaceDim();
    }

    @NonNull
    public DynamicColor inverseOnSurface() {
        return new DynamicColor("inverse_on_surface", new Function() { // from class: com.google.android.material.color.utilities.xoXoI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.o00
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$inverseOnSurface$40;
                lambda$inverseOnSurface$40 = MaterialDynamicColors.lambda$inverseOnSurface$40((DynamicScheme) obj);
                return lambda$inverseOnSurface$40;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.OxI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$inverseOnSurface$41;
                lambda$inverseOnSurface$41 = MaterialDynamicColors.this.lambda$inverseOnSurface$41((DynamicScheme) obj);
                return lambda$inverseOnSurface$41;
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    @NonNull
    public DynamicColor inversePrimary() {
        return new DynamicColor("inverse_primary", new Function() { // from class: com.google.android.material.color.utilities.o0IXXIx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.XoIxOXIXo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$inversePrimary$65;
                lambda$inversePrimary$65 = MaterialDynamicColors.lambda$inversePrimary$65((DynamicScheme) obj);
                return lambda$inversePrimary$65;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.OO0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$inversePrimary$66;
                lambda$inversePrimary$66 = MaterialDynamicColors.this.lambda$inversePrimary$66((DynamicScheme) obj);
                return lambda$inversePrimary$66;
            }
        }, null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    @NonNull
    public DynamicColor inverseSurface() {
        return new DynamicColor("inverse_surface", new Function() { // from class: com.google.android.material.color.utilities.XX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.I0oOoX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$inverseSurface$38;
                lambda$inverseSurface$38 = MaterialDynamicColors.lambda$inverseSurface$38((DynamicScheme) obj);
                return lambda$inverseSurface$38;
            }
        }, false, null, null, null, null);
    }

    @NonNull
    public DynamicColor neutralPaletteKeyColor() {
        return DynamicColor.fromPalette("neutral_palette_key_color", new Function() { // from class: com.google.android.material.color.utilities.oO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.X0IIOO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$neutralPaletteKeyColor$7;
                lambda$neutralPaletteKeyColor$7 = MaterialDynamicColors.lambda$neutralPaletteKeyColor$7((DynamicScheme) obj);
                return lambda$neutralPaletteKeyColor$7;
            }
        });
    }

    @NonNull
    public DynamicColor neutralVariantPaletteKeyColor() {
        return DynamicColor.fromPalette("neutral_variant_palette_key_color", new Function() { // from class: com.google.android.material.color.utilities.xOOxI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralVariantPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.xIx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$neutralVariantPaletteKeyColor$9;
                lambda$neutralVariantPaletteKeyColor$9 = MaterialDynamicColors.lambda$neutralVariantPaletteKeyColor$9((DynamicScheme) obj);
                return lambda$neutralVariantPaletteKeyColor$9;
            }
        });
    }

    @NonNull
    public DynamicColor onBackground() {
        return new DynamicColor("on_background", new Function() { // from class: com.google.android.material.color.utilities.X0xxXX0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.IO0XoXxO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onBackground$13;
                lambda$onBackground$13 = MaterialDynamicColors.lambda$onBackground$13((DynamicScheme) obj);
                return lambda$onBackground$13;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.oXxOI0oIx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onBackground$14;
                lambda$onBackground$14 = MaterialDynamicColors.this.lambda$onBackground$14((DynamicScheme) obj);
                return lambda$onBackground$14;
            }
        }, null, new ContrastCurve(3.0d, 3.0d, 4.5d, 7.0d), null);
    }

    @NonNull
    public DynamicColor onError() {
        return new DynamicColor("on_error", new Function() { // from class: com.google.android.material.color.utilities.OxXXx0X
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).errorPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.o0oxo0oI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onError$95;
                lambda$onError$95 = MaterialDynamicColors.lambda$onError$95((DynamicScheme) obj);
                return lambda$onError$95;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.X0O0I0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onError$96;
                lambda$onError$96 = MaterialDynamicColors.this.lambda$onError$96((DynamicScheme) obj);
                return lambda$onError$96;
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    @NonNull
    public DynamicColor onErrorContainer() {
        return new DynamicColor("on_error_container", new Function() { // from class: com.google.android.material.color.utilities.XoX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).errorPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.oxXx0IX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onErrorContainer$101;
                lambda$onErrorContainer$101 = MaterialDynamicColors.lambda$onErrorContainer$101((DynamicScheme) obj);
                return lambda$onErrorContainer$101;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.xo0x
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onErrorContainer$102;
                lambda$onErrorContainer$102 = MaterialDynamicColors.this.lambda$onErrorContainer$102((DynamicScheme) obj);
                return lambda$onErrorContainer$102;
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    @NonNull
    public DynamicColor onPrimary() {
        return new DynamicColor("on_primary", new Function() { // from class: com.google.android.material.color.utilities.I0xX0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.Oxx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onPrimary$56;
                lambda$onPrimary$56 = MaterialDynamicColors.lambda$onPrimary$56((DynamicScheme) obj);
                return lambda$onPrimary$56;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.oXIoO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onPrimary$57;
                lambda$onPrimary$57 = MaterialDynamicColors.this.lambda$onPrimary$57((DynamicScheme) obj);
                return lambda$onPrimary$57;
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    @NonNull
    public DynamicColor onPrimaryContainer() {
        return new DynamicColor("on_primary_container", new Function() { // from class: com.google.android.material.color.utilities.o0Xo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.X00xOoXI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onPrimaryContainer$62;
                lambda$onPrimaryContainer$62 = MaterialDynamicColors.this.lambda$onPrimaryContainer$62((DynamicScheme) obj);
                return lambda$onPrimaryContainer$62;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.OOxOI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onPrimaryContainer$63;
                lambda$onPrimaryContainer$63 = MaterialDynamicColors.this.lambda$onPrimaryContainer$63((DynamicScheme) obj);
                return lambda$onPrimaryContainer$63;
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    @NonNull
    public DynamicColor onPrimaryFixed() {
        return new DynamicColor("on_primary_fixed", new Function() { // from class: com.google.android.material.color.utilities.IIX0o
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.ooXIXxIX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onPrimaryFixed$110;
                lambda$onPrimaryFixed$110 = MaterialDynamicColors.lambda$onPrimaryFixed$110((DynamicScheme) obj);
                return lambda$onPrimaryFixed$110;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.xI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onPrimaryFixed$111;
                lambda$onPrimaryFixed$111 = MaterialDynamicColors.this.lambda$onPrimaryFixed$111((DynamicScheme) obj);
                return lambda$onPrimaryFixed$111;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.oo0xXOI0I
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onPrimaryFixed$112;
                lambda$onPrimaryFixed$112 = MaterialDynamicColors.this.lambda$onPrimaryFixed$112((DynamicScheme) obj);
                return lambda$onPrimaryFixed$112;
            }
        }, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    @NonNull
    public DynamicColor onPrimaryFixedVariant() {
        return new DynamicColor("on_primary_fixed_variant", new Function() { // from class: com.google.android.material.color.utilities.O0xxXxI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.oxOXxoXII
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onPrimaryFixedVariant$114;
                lambda$onPrimaryFixedVariant$114 = MaterialDynamicColors.lambda$onPrimaryFixedVariant$114((DynamicScheme) obj);
                return lambda$onPrimaryFixedVariant$114;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.IxX00
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onPrimaryFixedVariant$115;
                lambda$onPrimaryFixedVariant$115 = MaterialDynamicColors.this.lambda$onPrimaryFixedVariant$115((DynamicScheme) obj);
                return lambda$onPrimaryFixedVariant$115;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.XO0o
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onPrimaryFixedVariant$116;
                lambda$onPrimaryFixedVariant$116 = MaterialDynamicColors.this.lambda$onPrimaryFixedVariant$116((DynamicScheme) obj);
                return lambda$onPrimaryFixedVariant$116;
            }
        }, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    @NonNull
    public DynamicColor onSecondary() {
        return new DynamicColor("on_secondary", new Function() { // from class: com.google.android.material.color.utilities.X0o0xo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.XO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onSecondary$71;
                lambda$onSecondary$71 = MaterialDynamicColors.lambda$onSecondary$71((DynamicScheme) obj);
                return lambda$onSecondary$71;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.Oxx0IOOO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onSecondary$72;
                lambda$onSecondary$72 = MaterialDynamicColors.this.lambda$onSecondary$72((DynamicScheme) obj);
                return lambda$onSecondary$72;
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    @NonNull
    public DynamicColor onSecondaryContainer() {
        return new DynamicColor("on_secondary_container", new Function() { // from class: com.google.android.material.color.utilities.xxX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.XxX0x0xxx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onSecondaryContainer$77;
                lambda$onSecondaryContainer$77 = MaterialDynamicColors.this.lambda$onSecondaryContainer$77((DynamicScheme) obj);
                return lambda$onSecondaryContainer$77;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.xXxxox0I
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onSecondaryContainer$78;
                lambda$onSecondaryContainer$78 = MaterialDynamicColors.this.lambda$onSecondaryContainer$78((DynamicScheme) obj);
                return lambda$onSecondaryContainer$78;
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    @NonNull
    public DynamicColor onSecondaryFixed() {
        return new DynamicColor("on_secondary_fixed", new Function() { // from class: com.google.android.material.color.utilities.Oxx0xo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.oI0IIXIo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onSecondaryFixed$124;
                lambda$onSecondaryFixed$124 = MaterialDynamicColors.lambda$onSecondaryFixed$124((DynamicScheme) obj);
                return lambda$onSecondaryFixed$124;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.OxxIIOOXO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onSecondaryFixed$125;
                lambda$onSecondaryFixed$125 = MaterialDynamicColors.this.lambda$onSecondaryFixed$125((DynamicScheme) obj);
                return lambda$onSecondaryFixed$125;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.IIXOooo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onSecondaryFixed$126;
                lambda$onSecondaryFixed$126 = MaterialDynamicColors.this.lambda$onSecondaryFixed$126((DynamicScheme) obj);
                return lambda$onSecondaryFixed$126;
            }
        }, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    @NonNull
    public DynamicColor onSecondaryFixedVariant() {
        return new DynamicColor("on_secondary_fixed_variant", new Function() { // from class: com.google.android.material.color.utilities.Ioxxx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.xxIO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onSecondaryFixedVariant$128;
                lambda$onSecondaryFixedVariant$128 = MaterialDynamicColors.lambda$onSecondaryFixedVariant$128((DynamicScheme) obj);
                return lambda$onSecondaryFixedVariant$128;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.XX0xXo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onSecondaryFixedVariant$129;
                lambda$onSecondaryFixedVariant$129 = MaterialDynamicColors.this.lambda$onSecondaryFixedVariant$129((DynamicScheme) obj);
                return lambda$onSecondaryFixedVariant$129;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.o0xxxXXxX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onSecondaryFixedVariant$130;
                lambda$onSecondaryFixedVariant$130 = MaterialDynamicColors.this.lambda$onSecondaryFixedVariant$130((DynamicScheme) obj);
                return lambda$onSecondaryFixedVariant$130;
            }
        }, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    @NonNull
    public DynamicColor onSurface() {
        return new DynamicColor("on_surface", new Function() { // from class: com.google.android.material.color.utilities.XooIO0oo0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.xIOXX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onSurface$32;
                lambda$onSurface$32 = MaterialDynamicColors.lambda$onSurface$32((DynamicScheme) obj);
                return lambda$onSurface$32;
            }
        }, false, new oo0oIXo(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    @NonNull
    public DynamicColor onSurfaceVariant() {
        return new DynamicColor("on_surface_variant", new Function() { // from class: com.google.android.material.color.utilities.OI0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralVariantPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.o0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onSurfaceVariant$36;
                lambda$onSurfaceVariant$36 = MaterialDynamicColors.lambda$onSurfaceVariant$36((DynamicScheme) obj);
                return lambda$onSurfaceVariant$36;
            }
        }, false, new oo0oIXo(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    @NonNull
    public DynamicColor onTertiary() {
        return new DynamicColor("on_tertiary", new Function() { // from class: com.google.android.material.color.utilities.XOxxooXI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.OooI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onTertiary$83;
                lambda$onTertiary$83 = MaterialDynamicColors.lambda$onTertiary$83((DynamicScheme) obj);
                return lambda$onTertiary$83;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.oo00
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onTertiary$84;
                lambda$onTertiary$84 = MaterialDynamicColors.this.lambda$onTertiary$84((DynamicScheme) obj);
                return lambda$onTertiary$84;
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    @NonNull
    public DynamicColor onTertiaryContainer() {
        return new DynamicColor("on_tertiary_container", new Function() { // from class: com.google.android.material.color.utilities.O0xOxO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.XI0IXoo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onTertiaryContainer$89;
                lambda$onTertiaryContainer$89 = MaterialDynamicColors.this.lambda$onTertiaryContainer$89((DynamicScheme) obj);
                return lambda$onTertiaryContainer$89;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.XIxXXX0x0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onTertiaryContainer$90;
                lambda$onTertiaryContainer$90 = MaterialDynamicColors.this.lambda$onTertiaryContainer$90((DynamicScheme) obj);
                return lambda$onTertiaryContainer$90;
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    @NonNull
    public DynamicColor onTertiaryFixed() {
        return new DynamicColor("on_tertiary_fixed", new Function() { // from class: com.google.android.material.color.utilities.o0oIxOo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.XIXIxO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onTertiaryFixed$138;
                lambda$onTertiaryFixed$138 = MaterialDynamicColors.lambda$onTertiaryFixed$138((DynamicScheme) obj);
                return lambda$onTertiaryFixed$138;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.OIOoIIOIx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onTertiaryFixed$139;
                lambda$onTertiaryFixed$139 = MaterialDynamicColors.this.lambda$onTertiaryFixed$139((DynamicScheme) obj);
                return lambda$onTertiaryFixed$139;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.x0OIX00oO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onTertiaryFixed$140;
                lambda$onTertiaryFixed$140 = MaterialDynamicColors.this.lambda$onTertiaryFixed$140((DynamicScheme) obj);
                return lambda$onTertiaryFixed$140;
            }
        }, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    @NonNull
    public DynamicColor onTertiaryFixedVariant() {
        return new DynamicColor("on_tertiary_fixed_variant", new Function() { // from class: com.google.android.material.color.utilities.xOOOX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.XIXIX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$onTertiaryFixedVariant$142;
                lambda$onTertiaryFixedVariant$142 = MaterialDynamicColors.lambda$onTertiaryFixedVariant$142((DynamicScheme) obj);
                return lambda$onTertiaryFixedVariant$142;
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.oXIO0o0XI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onTertiaryFixedVariant$143;
                lambda$onTertiaryFixedVariant$143 = MaterialDynamicColors.this.lambda$onTertiaryFixedVariant$143((DynamicScheme) obj);
                return lambda$onTertiaryFixedVariant$143;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.oOo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor lambda$onTertiaryFixedVariant$144;
                lambda$onTertiaryFixedVariant$144 = MaterialDynamicColors.this.lambda$onTertiaryFixedVariant$144((DynamicScheme) obj);
                return lambda$onTertiaryFixedVariant$144;
            }
        }, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    @NonNull
    public DynamicColor outline() {
        return new DynamicColor("outline", new Function() { // from class: com.google.android.material.color.utilities.ooOOo0oXI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralVariantPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.x0XOIxOo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$outline$43;
                lambda$outline$43 = MaterialDynamicColors.lambda$outline$43((DynamicScheme) obj);
                return lambda$outline$43;
            }
        }, false, new oo0oIXo(this), null, new ContrastCurve(1.5d, 3.0d, 4.5d, 7.0d), null);
    }

    @NonNull
    public DynamicColor outlineVariant() {
        return new DynamicColor("outline_variant", new Function() { // from class: com.google.android.material.color.utilities.IOoo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralVariantPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.oIIxXoo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$outlineVariant$45;
                lambda$outlineVariant$45 = MaterialDynamicColors.lambda$outlineVariant$45((DynamicScheme) obj);
                return lambda$outlineVariant$45;
            }
        }, false, new oo0oIXo(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), null);
    }

    @NonNull
    public DynamicColor primary() {
        return new DynamicColor("primary", new Function() { // from class: com.google.android.material.color.utilities.IoOoo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.xoIxX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$primary$53;
                lambda$primary$53 = MaterialDynamicColors.lambda$primary$53((DynamicScheme) obj);
                return lambda$primary$53;
            }
        }, true, new oo0oIXo(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new Function() { // from class: com.google.android.material.color.utilities.x0xO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ToneDeltaPair lambda$primary$54;
                lambda$primary$54 = MaterialDynamicColors.this.lambda$primary$54((DynamicScheme) obj);
                return lambda$primary$54;
            }
        });
    }

    @NonNull
    public DynamicColor primaryContainer() {
        return new DynamicColor("primary_container", new Function() { // from class: com.google.android.material.color.utilities.O0IxXx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.IoXIXo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$primaryContainer$59;
                lambda$primaryContainer$59 = MaterialDynamicColors.lambda$primaryContainer$59((DynamicScheme) obj);
                return lambda$primaryContainer$59;
            }
        }, true, new oo0oIXo(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.xxOXOOoIX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ToneDeltaPair lambda$primaryContainer$60;
                lambda$primaryContainer$60 = MaterialDynamicColors.this.lambda$primaryContainer$60((DynamicScheme) obj);
                return lambda$primaryContainer$60;
            }
        });
    }

    @NonNull
    public DynamicColor primaryFixed() {
        return new DynamicColor("primary_fixed", new Function() { // from class: com.google.android.material.color.utilities.x0oxIIIX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.XOxoX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$primaryFixed$104;
                lambda$primaryFixed$104 = MaterialDynamicColors.lambda$primaryFixed$104((DynamicScheme) obj);
                return lambda$primaryFixed$104;
            }
        }, true, new oo0oIXo(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.xIXIOX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ToneDeltaPair lambda$primaryFixed$105;
                lambda$primaryFixed$105 = MaterialDynamicColors.this.lambda$primaryFixed$105((DynamicScheme) obj);
                return lambda$primaryFixed$105;
            }
        });
    }

    @NonNull
    public DynamicColor primaryFixedDim() {
        return new DynamicColor("primary_fixed_dim", new Function() { // from class: com.google.android.material.color.utilities.IOOoXo0Ix
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.X0IOOI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$primaryFixedDim$107;
                lambda$primaryFixedDim$107 = MaterialDynamicColors.lambda$primaryFixedDim$107((DynamicScheme) obj);
                return lambda$primaryFixedDim$107;
            }
        }, true, new oo0oIXo(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.Oxo00O
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ToneDeltaPair lambda$primaryFixedDim$108;
                lambda$primaryFixedDim$108 = MaterialDynamicColors.this.lambda$primaryFixedDim$108((DynamicScheme) obj);
                return lambda$primaryFixedDim$108;
            }
        });
    }

    @NonNull
    public DynamicColor primaryPaletteKeyColor() {
        return DynamicColor.fromPalette("primary_palette_key_color", new Function() { // from class: com.google.android.material.color.utilities.xoO0xx0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.OX00O0xII
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$primaryPaletteKeyColor$1;
                lambda$primaryPaletteKeyColor$1 = MaterialDynamicColors.lambda$primaryPaletteKeyColor$1((DynamicScheme) obj);
                return lambda$primaryPaletteKeyColor$1;
            }
        });
    }

    @NonNull
    public DynamicColor scrim() {
        return new DynamicColor("scrim", new Function() { // from class: com.google.android.material.color.utilities.OO0x0xX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.XIo0oOXIx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$scrim$49;
                lambda$scrim$49 = MaterialDynamicColors.lambda$scrim$49((DynamicScheme) obj);
                return lambda$scrim$49;
            }
        }, false, null, null, null, null);
    }

    @NonNull
    public DynamicColor secondary() {
        return new DynamicColor("secondary", new Function() { // from class: com.google.android.material.color.utilities.II0XooXoX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.xxIXOIIO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$secondary$68;
                lambda$secondary$68 = MaterialDynamicColors.lambda$secondary$68((DynamicScheme) obj);
                return lambda$secondary$68;
            }
        }, true, new oo0oIXo(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new Function() { // from class: com.google.android.material.color.utilities.xoIox
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ToneDeltaPair lambda$secondary$69;
                lambda$secondary$69 = MaterialDynamicColors.this.lambda$secondary$69((DynamicScheme) obj);
                return lambda$secondary$69;
            }
        });
    }

    @NonNull
    public DynamicColor secondaryContainer() {
        return new DynamicColor("secondary_container", new Function() { // from class: com.google.android.material.color.utilities.xx0X0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.xI0oxI00
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$secondaryContainer$74;
                lambda$secondaryContainer$74 = MaterialDynamicColors.lambda$secondaryContainer$74((DynamicScheme) obj);
                return lambda$secondaryContainer$74;
            }
        }, true, new oo0oIXo(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.oxIIX0o
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ToneDeltaPair lambda$secondaryContainer$75;
                lambda$secondaryContainer$75 = MaterialDynamicColors.this.lambda$secondaryContainer$75((DynamicScheme) obj);
                return lambda$secondaryContainer$75;
            }
        });
    }

    @NonNull
    public DynamicColor secondaryFixed() {
        return new DynamicColor("secondary_fixed", new Function() { // from class: com.google.android.material.color.utilities.OIx00oxx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.xIXX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$secondaryFixed$118;
                lambda$secondaryFixed$118 = MaterialDynamicColors.lambda$secondaryFixed$118((DynamicScheme) obj);
                return lambda$secondaryFixed$118;
            }
        }, true, new oo0oIXo(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.xOOxIO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ToneDeltaPair lambda$secondaryFixed$119;
                lambda$secondaryFixed$119 = MaterialDynamicColors.this.lambda$secondaryFixed$119((DynamicScheme) obj);
                return lambda$secondaryFixed$119;
            }
        });
    }

    @NonNull
    public DynamicColor secondaryFixedDim() {
        return new DynamicColor("secondary_fixed_dim", new Function() { // from class: com.google.android.material.color.utilities.XO00XOO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.OXXoIoXI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$secondaryFixedDim$121;
                lambda$secondaryFixedDim$121 = MaterialDynamicColors.lambda$secondaryFixedDim$121((DynamicScheme) obj);
                return lambda$secondaryFixedDim$121;
            }
        }, true, new oo0oIXo(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.OOIXx0x
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ToneDeltaPair lambda$secondaryFixedDim$122;
                lambda$secondaryFixedDim$122 = MaterialDynamicColors.this.lambda$secondaryFixedDim$122((DynamicScheme) obj);
                return lambda$secondaryFixedDim$122;
            }
        });
    }

    @NonNull
    public DynamicColor secondaryPaletteKeyColor() {
        return DynamicColor.fromPalette("secondary_palette_key_color", new Function() { // from class: com.google.android.material.color.utilities.O0X
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.IIX0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$secondaryPaletteKeyColor$3;
                lambda$secondaryPaletteKeyColor$3 = MaterialDynamicColors.lambda$secondaryPaletteKeyColor$3((DynamicScheme) obj);
                return lambda$secondaryPaletteKeyColor$3;
            }
        });
    }

    @NonNull
    public DynamicColor shadow() {
        return new DynamicColor("shadow", new Function() { // from class: com.google.android.material.color.utilities.XoOxI0ox
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.X0ooXIooI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$shadow$47;
                lambda$shadow$47 = MaterialDynamicColors.lambda$shadow$47((DynamicScheme) obj);
                return lambda$shadow$47;
            }
        }, false, null, null, null, null);
    }

    @NonNull
    public DynamicColor surface() {
        return new DynamicColor("surface", new Function() { // from class: com.google.android.material.color.utilities.oxoX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.xX0IIXIx0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$surface$16;
                lambda$surface$16 = MaterialDynamicColors.lambda$surface$16((DynamicScheme) obj);
                return lambda$surface$16;
            }
        }, true, null, null, null, null);
    }

    @NonNull
    public DynamicColor surfaceBright() {
        return new DynamicColor("surface_bright", new Function() { // from class: com.google.android.material.color.utilities.oXX0IoI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.XXXI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$surfaceBright$20;
                lambda$surfaceBright$20 = MaterialDynamicColors.lambda$surfaceBright$20((DynamicScheme) obj);
                return lambda$surfaceBright$20;
            }
        }, true, null, null, null, null);
    }

    @NonNull
    public DynamicColor surfaceContainer() {
        return new DynamicColor("surface_container", new Function() { // from class: com.google.android.material.color.utilities.x0o
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.XOxIOxOx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$surfaceContainer$26;
                lambda$surfaceContainer$26 = MaterialDynamicColors.lambda$surfaceContainer$26((DynamicScheme) obj);
                return lambda$surfaceContainer$26;
            }
        }, true, null, null, null, null);
    }

    @NonNull
    public DynamicColor surfaceContainerHigh() {
        return new DynamicColor("surface_container_high", new Function() { // from class: com.google.android.material.color.utilities.x0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.X0xII0I
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$surfaceContainerHigh$28;
                lambda$surfaceContainerHigh$28 = MaterialDynamicColors.lambda$surfaceContainerHigh$28((DynamicScheme) obj);
                return lambda$surfaceContainerHigh$28;
            }
        }, true, null, null, null, null);
    }

    @NonNull
    public DynamicColor surfaceContainerHighest() {
        return new DynamicColor("surface_container_highest", new Function() { // from class: com.google.android.material.color.utilities.oX000x
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.IxIo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$surfaceContainerHighest$30;
                lambda$surfaceContainerHighest$30 = MaterialDynamicColors.lambda$surfaceContainerHighest$30((DynamicScheme) obj);
                return lambda$surfaceContainerHighest$30;
            }
        }, true, null, null, null, null);
    }

    @NonNull
    public DynamicColor surfaceContainerLow() {
        return new DynamicColor("surface_container_low", new Function() { // from class: com.google.android.material.color.utilities.xOoOIoI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.Ox0O
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$surfaceContainerLow$24;
                lambda$surfaceContainerLow$24 = MaterialDynamicColors.lambda$surfaceContainerLow$24((DynamicScheme) obj);
                return lambda$surfaceContainerLow$24;
            }
        }, true, null, null, null, null);
    }

    @NonNull
    public DynamicColor surfaceContainerLowest() {
        return new DynamicColor("surface_container_lowest", new Function() { // from class: com.google.android.material.color.utilities.OOXIXo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.oOoXoXO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$surfaceContainerLowest$22;
                lambda$surfaceContainerLowest$22 = MaterialDynamicColors.lambda$surfaceContainerLowest$22((DynamicScheme) obj);
                return lambda$surfaceContainerLowest$22;
            }
        }, true, null, null, null, null);
    }

    @NonNull
    public DynamicColor surfaceDim() {
        return new DynamicColor("surface_dim", new Function() { // from class: com.google.android.material.color.utilities.oOXoIIIo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.oxxXoxO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$surfaceDim$18;
                lambda$surfaceDim$18 = MaterialDynamicColors.lambda$surfaceDim$18((DynamicScheme) obj);
                return lambda$surfaceDim$18;
            }
        }, true, null, null, null, null);
    }

    @NonNull
    public DynamicColor surfaceTint() {
        return new DynamicColor("surface_tint", new Function() { // from class: com.google.android.material.color.utilities.x0xO0oo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.IXxxXO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$surfaceTint$51;
                lambda$surfaceTint$51 = MaterialDynamicColors.lambda$surfaceTint$51((DynamicScheme) obj);
                return lambda$surfaceTint$51;
            }
        }, true, null, null, null, null);
    }

    @NonNull
    public DynamicColor surfaceVariant() {
        return new DynamicColor("surface_variant", new Function() { // from class: com.google.android.material.color.utilities.xIx0XO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralVariantPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.oXxx000
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$surfaceVariant$34;
                lambda$surfaceVariant$34 = MaterialDynamicColors.lambda$surfaceVariant$34((DynamicScheme) obj);
                return lambda$surfaceVariant$34;
            }
        }, true, null, null, null, null);
    }

    @NonNull
    public DynamicColor tertiary() {
        return new DynamicColor("tertiary", new Function() { // from class: com.google.android.material.color.utilities.XI0oooXX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.OOXIxO0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$tertiary$80;
                lambda$tertiary$80 = MaterialDynamicColors.lambda$tertiary$80((DynamicScheme) obj);
                return lambda$tertiary$80;
            }
        }, true, new oo0oIXo(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new Function() { // from class: com.google.android.material.color.utilities.IIxOXoOo0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ToneDeltaPair lambda$tertiary$81;
                lambda$tertiary$81 = MaterialDynamicColors.this.lambda$tertiary$81((DynamicScheme) obj);
                return lambda$tertiary$81;
            }
        });
    }

    @NonNull
    public DynamicColor tertiaryContainer() {
        return new DynamicColor("tertiary_container", new Function() { // from class: com.google.android.material.color.utilities.Ix0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.xIxooxXX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$tertiaryContainer$86;
                lambda$tertiaryContainer$86 = MaterialDynamicColors.lambda$tertiaryContainer$86((DynamicScheme) obj);
                return lambda$tertiaryContainer$86;
            }
        }, true, new oo0oIXo(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.oxIO0IIo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ToneDeltaPair lambda$tertiaryContainer$87;
                lambda$tertiaryContainer$87 = MaterialDynamicColors.this.lambda$tertiaryContainer$87((DynamicScheme) obj);
                return lambda$tertiaryContainer$87;
            }
        });
    }

    @NonNull
    public DynamicColor tertiaryFixed() {
        return new DynamicColor("tertiary_fixed", new Function() { // from class: com.google.android.material.color.utilities.XoI0Ixx0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.O0Xx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$tertiaryFixed$132;
                lambda$tertiaryFixed$132 = MaterialDynamicColors.lambda$tertiaryFixed$132((DynamicScheme) obj);
                return lambda$tertiaryFixed$132;
            }
        }, true, new oo0oIXo(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.xoxXI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ToneDeltaPair lambda$tertiaryFixed$133;
                lambda$tertiaryFixed$133 = MaterialDynamicColors.this.lambda$tertiaryFixed$133((DynamicScheme) obj);
                return lambda$tertiaryFixed$133;
            }
        });
    }

    @NonNull
    public DynamicColor tertiaryFixedDim() {
        return new DynamicColor("tertiary_fixed_dim", new Function() { // from class: com.google.android.material.color.utilities.oX0I0O
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.x00IOx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$tertiaryFixedDim$135;
                lambda$tertiaryFixedDim$135 = MaterialDynamicColors.lambda$tertiaryFixedDim$135((DynamicScheme) obj);
                return lambda$tertiaryFixedDim$135;
            }
        }, true, new oo0oIXo(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.oX0ooo0I0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ToneDeltaPair lambda$tertiaryFixedDim$136;
                lambda$tertiaryFixedDim$136 = MaterialDynamicColors.this.lambda$tertiaryFixedDim$136((DynamicScheme) obj);
                return lambda$tertiaryFixedDim$136;
            }
        });
    }

    @NonNull
    public DynamicColor tertiaryPaletteKeyColor() {
        return DynamicColor.fromPalette("tertiary_palette_key_color", new Function() { // from class: com.google.android.material.color.utilities.XXoOx0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.IxIX0I
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$tertiaryPaletteKeyColor$5;
                lambda$tertiaryPaletteKeyColor$5 = MaterialDynamicColors.lambda$tertiaryPaletteKeyColor$5((DynamicScheme) obj);
                return lambda$tertiaryPaletteKeyColor$5;
            }
        });
    }

    @NonNull
    public DynamicColor textHintInverse() {
        return DynamicColor.fromPalette("text_hint_inverse", new Function() { // from class: com.google.android.material.color.utilities.oXO0oOx0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.IIOIX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$textHintInverse$161;
                lambda$textHintInverse$161 = MaterialDynamicColors.lambda$textHintInverse$161((DynamicScheme) obj);
                return lambda$textHintInverse$161;
            }
        });
    }

    @NonNull
    public DynamicColor textPrimaryInverse() {
        return DynamicColor.fromPalette("text_primary_inverse", new Function() { // from class: com.google.android.material.color.utilities.IO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.xII
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$textPrimaryInverse$153;
                lambda$textPrimaryInverse$153 = MaterialDynamicColors.lambda$textPrimaryInverse$153((DynamicScheme) obj);
                return lambda$textPrimaryInverse$153;
            }
        });
    }

    @NonNull
    public DynamicColor textPrimaryInverseDisableOnly() {
        return DynamicColor.fromPalette("text_primary_inverse_disable_only", new Function() { // from class: com.google.android.material.color.utilities.OxO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.xxx00
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$textPrimaryInverseDisableOnly$157;
                lambda$textPrimaryInverseDisableOnly$157 = MaterialDynamicColors.lambda$textPrimaryInverseDisableOnly$157((DynamicScheme) obj);
                return lambda$textPrimaryInverseDisableOnly$157;
            }
        });
    }

    @NonNull
    public DynamicColor textSecondaryAndTertiaryInverse() {
        return DynamicColor.fromPalette("text_secondary_and_tertiary_inverse", new Function() { // from class: com.google.android.material.color.utilities.xXOx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralVariantPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.XX0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$textSecondaryAndTertiaryInverse$155;
                lambda$textSecondaryAndTertiaryInverse$155 = MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverse$155((DynamicScheme) obj);
                return lambda$textSecondaryAndTertiaryInverse$155;
            }
        });
    }

    @NonNull
    public DynamicColor textSecondaryAndTertiaryInverseDisabled() {
        return DynamicColor.fromPalette("text_secondary_and_tertiary_inverse_disabled", new Function() { // from class: com.google.android.material.color.utilities.IoIOOxIIo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.Ix00oIoI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double lambda$textSecondaryAndTertiaryInverseDisabled$159;
                lambda$textSecondaryAndTertiaryInverseDisabled$159 = MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverseDisabled$159((DynamicScheme) obj);
                return lambda$textSecondaryAndTertiaryInverseDisabled$159;
            }
        });
    }
}
