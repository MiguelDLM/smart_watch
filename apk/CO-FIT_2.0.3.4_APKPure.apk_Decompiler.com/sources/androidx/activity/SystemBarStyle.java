package androidx.activity;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import android.content.res.Resources;
import androidx.annotation.ColorInt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

public final class SystemBarStyle {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    private final int darkScrim;
    @OOXIXo
    private final oOoXoXO<Resources, Boolean> detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ SystemBarStyle auto$default(Companion companion, int i, int i2, oOoXoXO oooxoxo, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                oooxoxo = SystemBarStyle$Companion$auto$1.INSTANCE;
            }
            return companion.auto(i, i2, oooxoxo);
        }

        @xoIox
        @x0XOIxOo
        @OOXIXo
        public final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2) {
            return auto$default(this, i, i2, (oOoXoXO) null, 4, (Object) null);
        }

        @x0XOIxOo
        @OOXIXo
        public final SystemBarStyle dark(@ColorInt int i) {
            return new SystemBarStyle(i, i, 2, SystemBarStyle$Companion$dark$1.INSTANCE, (IIXOooo) null);
        }

        @x0XOIxOo
        @OOXIXo
        public final SystemBarStyle light(@ColorInt int i, @ColorInt int i2) {
            return new SystemBarStyle(i, i2, 1, SystemBarStyle$Companion$light$1.INSTANCE, (IIXOooo) null);
        }

        private Companion() {
        }

        @x0XOIxOo
        @xoIox
        @OOXIXo
        public final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2, @OOXIXo oOoXoXO<? super Resources, Boolean> oooxoxo) {
            IIX0o.x0xO0oo(oooxoxo, "detectDarkMode");
            return new SystemBarStyle(i, i2, 0, oooxoxo, (IIXOooo) null);
        }
    }

    public /* synthetic */ SystemBarStyle(int i, int i2, int i3, oOoXoXO oooxoxo, IIXOooo iIXOooo) {
        this(i, i2, i3, oooxoxo);
    }

    @xoIox
    @x0XOIxOo
    @OOXIXo
    public static final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2) {
        return Companion.auto(i, i2);
    }

    @x0XOIxOo
    @OOXIXo
    public static final SystemBarStyle dark(@ColorInt int i) {
        return Companion.dark(i);
    }

    @x0XOIxOo
    @OOXIXo
    public static final SystemBarStyle light(@ColorInt int i, @ColorInt int i2) {
        return Companion.light(i, i2);
    }

    public final int getDarkScrim$activity_release() {
        return this.darkScrim;
    }

    @OOXIXo
    public final oOoXoXO<Resources, Boolean> getDetectDarkMode$activity_release() {
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

    private SystemBarStyle(int i, int i2, int i3, oOoXoXO<? super Resources, Boolean> oooxoxo) {
        this.lightScrim = i;
        this.darkScrim = i2;
        this.nightMode = i3;
        this.detectDarkMode = oooxoxo;
    }

    @x0XOIxOo
    @xoIox
    @OOXIXo
    public static final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2, @OOXIXo oOoXoXO<? super Resources, Boolean> oooxoxo) {
        return Companion.auto(i, i2, oooxoxo);
    }
}
