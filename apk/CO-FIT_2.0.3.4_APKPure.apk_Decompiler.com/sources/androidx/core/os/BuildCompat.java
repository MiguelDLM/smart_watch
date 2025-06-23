package androidx.core.os;

import OXOo.OOXIXo;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import XxI.I0Io;
import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import kotlin.RequiresOptIn;
import kotlin.XX;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.IIX0o;

public final class BuildCompat {
    @XO
    @ChecksSdkIntAtLeast(extension = 1000000)
    public static final int AD_SERVICES_EXTENSION_INT;
    @OOXIXo
    public static final BuildCompat INSTANCE = new BuildCompat();
    @XO
    @ChecksSdkIntAtLeast(extension = 30)
    public static final int R_EXTENSION_INT;
    @XO
    @ChecksSdkIntAtLeast(extension = 31)
    public static final int S_EXTENSION_INT;
    @XO
    @ChecksSdkIntAtLeast(extension = 33)
    public static final int T_EXTENSION_INT;

    @RequiresApi(30)
    public static final class Api30Impl {
        @OOXIXo
        public static final Api30Impl INSTANCE = new Api30Impl();

        private Api30Impl() {
        }

        @DoNotInline
        public final int getExtensionVersion(int i) {
            return SdkExtensions.getExtensionVersion(i);
        }
    }

    @RequiresOptIn
    @I0Io(AnnotationRetention.BINARY)
    @Retention(RetentionPolicy.CLASS)
    public @interface PrereleaseSdkCheck {
    }

    static {
        int i;
        int i2;
        int i3;
        int i4 = Build.VERSION.SDK_INT;
        int i5 = 0;
        if (i4 >= 30) {
            i = Api30Impl.INSTANCE.getExtensionVersion(30);
        } else {
            i = 0;
        }
        R_EXTENSION_INT = i;
        if (i4 >= 30) {
            i2 = Api30Impl.INSTANCE.getExtensionVersion(31);
        } else {
            i2 = 0;
        }
        S_EXTENSION_INT = i2;
        if (i4 >= 30) {
            i3 = Api30Impl.INSTANCE.getExtensionVersion(33);
        } else {
            i3 = 0;
        }
        T_EXTENSION_INT = i3;
        if (i4 >= 30) {
            i5 = Api30Impl.INSTANCE.getExtensionVersion(1000000);
        }
        AD_SERVICES_EXTENSION_INT = i5;
    }

    private BuildCompat() {
    }

    @kotlin.OOXIXo(message = "Android N is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 24`.", replaceWith = @XX(expression = "android.os.Build.VERSION.SDK_INT >= 24", imports = {}))
    @x0XOIxOo
    @ChecksSdkIntAtLeast(api = 24)
    public static final boolean isAtLeastN() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    @kotlin.OOXIXo(message = "Android N MR1 is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 25`.", replaceWith = @XX(expression = "android.os.Build.VERSION.SDK_INT >= 25", imports = {}))
    @x0XOIxOo
    @ChecksSdkIntAtLeast(api = 25)
    public static final boolean isAtLeastNMR1() {
        if (Build.VERSION.SDK_INT >= 25) {
            return true;
        }
        return false;
    }

    @kotlin.OOXIXo(message = "Android O is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead use `Build.VERSION.SDK_INT >= 26`.", replaceWith = @XX(expression = "android.os.Build.VERSION.SDK_INT >= 26", imports = {}))
    @x0XOIxOo
    @ChecksSdkIntAtLeast(api = 26)
    public static final boolean isAtLeastO() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    @kotlin.OOXIXo(message = "Android O MR1 is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 27`.", replaceWith = @XX(expression = "android.os.Build.VERSION.SDK_INT >= 27", imports = {}))
    @x0XOIxOo
    @ChecksSdkIntAtLeast(api = 27)
    public static final boolean isAtLeastOMR1() {
        if (Build.VERSION.SDK_INT >= 27) {
            return true;
        }
        return false;
    }

    @kotlin.OOXIXo(message = "Android P is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 28`.", replaceWith = @XX(expression = "android.os.Build.VERSION.SDK_INT >= 28", imports = {}))
    @x0XOIxOo
    @ChecksSdkIntAtLeast(api = 28)
    public static final boolean isAtLeastP() {
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    @x0XOIxOo
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final boolean isAtLeastPreReleaseCodename(@OOXIXo String str, @OOXIXo String str2) {
        IIX0o.x0xO0oo(str, "codename");
        IIX0o.x0xO0oo(str2, "buildCodename");
        if (IIX0o.Oxx0IOOO("REL", str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = str2.toUpperCase(locale);
        IIX0o.oO(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = str.toUpperCase(locale);
        IIX0o.oO(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (upperCase.compareTo(upperCase2) >= 0) {
            return true;
        }
        return false;
    }

    @kotlin.OOXIXo(message = "Android Q is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 29`.", replaceWith = @XX(expression = "android.os.Build.VERSION.SDK_INT >= 29", imports = {}))
    @x0XOIxOo
    @ChecksSdkIntAtLeast(api = 29)
    public static final boolean isAtLeastQ() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    @kotlin.OOXIXo(message = "Android R is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 30`.", replaceWith = @XX(expression = "android.os.Build.VERSION.SDK_INT >= 30", imports = {}))
    @x0XOIxOo
    @ChecksSdkIntAtLeast(api = 30)
    public static final boolean isAtLeastR() {
        if (Build.VERSION.SDK_INT >= 30) {
            return true;
        }
        return false;
    }

    @kotlin.OOXIXo(message = "Android S is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 31`.", replaceWith = @XX(expression = "android.os.Build.VERSION.SDK_INT >= 31", imports = {}))
    @x0XOIxOo
    @ChecksSdkIntAtLeast(api = 31, codename = "S")
    public static final boolean isAtLeastS() {
        int i = Build.VERSION.SDK_INT;
        if (i < 31) {
            if (i >= 30) {
                String str = Build.VERSION.CODENAME;
                IIX0o.oO(str, "CODENAME");
                if (isAtLeastPreReleaseCodename(ExifInterface.LATITUDE_SOUTH, str)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @kotlin.OOXIXo(message = "Android Sv2 is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 32`.", replaceWith = @XX(expression = "android.os.Build.VERSION.SDK_INT >= 32", imports = {}))
    @x0XOIxOo
    @ChecksSdkIntAtLeast(api = 32, codename = "Sv2")
    public static final boolean isAtLeastSv2() {
        int i = Build.VERSION.SDK_INT;
        if (i < 32) {
            if (i >= 31) {
                String str = Build.VERSION.CODENAME;
                IIX0o.oO(str, "CODENAME");
                if (isAtLeastPreReleaseCodename("Sv2", str)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @kotlin.OOXIXo(message = "Android Tiramisu is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 33`.", replaceWith = @XX(expression = "android.os.Build.VERSION.SDK_INT >= 33", imports = {}))
    @x0XOIxOo
    @ChecksSdkIntAtLeast(api = 33, codename = "Tiramisu")
    public static final boolean isAtLeastT() {
        int i = Build.VERSION.SDK_INT;
        if (i < 33) {
            if (i >= 32) {
                String str = Build.VERSION.CODENAME;
                IIX0o.oO(str, "CODENAME");
                if (isAtLeastPreReleaseCodename("Tiramisu", str)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @kotlin.OOXIXo(message = "Android UpsideDownCase is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 34`.", replaceWith = @XX(expression = "android.os.Build.VERSION.SDK_INT >= 34", imports = {}))
    @x0XOIxOo
    @ChecksSdkIntAtLeast(api = 34, codename = "UpsideDownCake")
    public static final boolean isAtLeastU() {
        int i = Build.VERSION.SDK_INT;
        if (i < 34) {
            if (i >= 33) {
                String str = Build.VERSION.CODENAME;
                IIX0o.oO(str, "CODENAME");
                if (isAtLeastPreReleaseCodename("UpsideDownCake", str)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @x0XOIxOo
    @ChecksSdkIntAtLeast(codename = "VanillaIceCream")
    @PrereleaseSdkCheck
    public static final boolean isAtLeastV() {
        if (Build.VERSION.SDK_INT >= 34) {
            String str = Build.VERSION.CODENAME;
            IIX0o.oO(str, "CODENAME");
            if (isAtLeastPreReleaseCodename("VanillaIceCream", str)) {
                return true;
            }
        }
        return false;
    }
}
