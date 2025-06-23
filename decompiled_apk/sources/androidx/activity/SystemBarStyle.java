package androidx.activity;

import android.content.res.Resources;
import androidx.annotation.ColorInt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes.dex */
public final class SystemBarStyle {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    private final int darkScrim;

    @OXOo.OOXIXo
    private final Oox.oOoXoXO<Resources, Boolean> detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SystemBarStyle auto$default(Companion companion, int i, int i2, Oox.oOoXoXO oooxoxo, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                oooxoxo = new Oox.oOoXoXO<Resources, Boolean>() { // from class: androidx.activity.SystemBarStyle$Companion$auto$1
                    @Override // Oox.oOoXoXO
                    public final Boolean invoke(Resources resources) {
                        IIX0o.x0xO0oo(resources, "resources");
                        return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
                    }
                };
            }
            return companion.auto(i, i2, oooxoxo);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xoIox
        public final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2) {
            return auto$default(this, i, i2, null, 4, null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final SystemBarStyle dark(@ColorInt int i) {
            return new SystemBarStyle(i, i, 2, new Oox.oOoXoXO<Resources, Boolean>() { // from class: androidx.activity.SystemBarStyle$Companion$dark$1
                @Override // Oox.oOoXoXO
                public final Boolean invoke(Resources resources) {
                    IIX0o.x0xO0oo(resources, "<anonymous parameter 0>");
                    return Boolean.TRUE;
                }
            }, null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final SystemBarStyle light(@ColorInt int i, @ColorInt int i2) {
            return new SystemBarStyle(i, i2, 1, new Oox.oOoXoXO<Resources, Boolean>() { // from class: androidx.activity.SystemBarStyle$Companion$light$1
                @Override // Oox.oOoXoXO
                public final Boolean invoke(Resources resources) {
                    IIX0o.x0xO0oo(resources, "<anonymous parameter 0>");
                    return Boolean.FALSE;
                }
            }, null);
        }

        private Companion() {
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xoIox
        public final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2, @OXOo.OOXIXo Oox.oOoXoXO<? super Resources, Boolean> detectDarkMode) {
            IIX0o.x0xO0oo(detectDarkMode, "detectDarkMode");
            return new SystemBarStyle(i, i2, 0, detectDarkMode, null);
        }
    }

    public /* synthetic */ SystemBarStyle(int i, int i2, int i3, Oox.oOoXoXO oooxoxo, IIXOooo iIXOooo) {
        this(i, i2, i3, oooxoxo);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xoIox
    public static final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2) {
        return Companion.auto(i, i2);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final SystemBarStyle dark(@ColorInt int i) {
        return Companion.dark(i);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final SystemBarStyle light(@ColorInt int i, @ColorInt int i2) {
        return Companion.light(i, i2);
    }

    public final int getDarkScrim$activity_release() {
        return this.darkScrim;
    }

    @OXOo.OOXIXo
    public final Oox.oOoXoXO<Resources, Boolean> getDetectDarkMode$activity_release() {
        return this.detectDarkMode;
    }

    public final int getNightMode$activity_release() {
        return this.nightMode;
    }

    public final int getScrim$activity_release(boolean z) {
        if (z) {
            return this.darkScrim;
        }
        return this.lightScrim;
    }

    public final int getScrimWithEnforcedContrast$activity_release(boolean z) {
        if (this.nightMode == 0) {
            return 0;
        }
        if (z) {
            return this.darkScrim;
        }
        return this.lightScrim;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SystemBarStyle(int i, int i2, int i3, Oox.oOoXoXO<? super Resources, Boolean> oooxoxo) {
        this.lightScrim = i;
        this.darkScrim = i2;
        this.nightMode = i3;
        this.detectDarkMode = oooxoxo;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xoIox
    public static final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2, @OXOo.OOXIXo Oox.oOoXoXO<? super Resources, Boolean> oooxoxo) {
        return Companion.auto(i, i2, oooxoxo);
    }
}
