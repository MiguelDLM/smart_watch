package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import java.util.HashSet;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.Xo0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class FacebookSignatureValidator {

    @OXOo.OOXIXo
    public static final FacebookSignatureValidator INSTANCE = new FacebookSignatureValidator();

    @OXOo.OOXIXo
    private static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";

    @OXOo.OOXIXo
    private static final String FBR2_HASH = "cc2751449a350f668590264ed76692694a80308a";

    @OXOo.OOXIXo
    private static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";

    @OXOo.OOXIXo
    private static final String FBL_HASH = "df6b721c8b4d3b6eb44c861d4415007e5a35fc95";

    @OXOo.OOXIXo
    private static final String MSR_HASH = "9b8f518b086098de3d77736f9458a3d2f6f95a37";

    @OXOo.OOXIXo
    private static final String FBF_HASH = "2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3";

    @OXOo.OOXIXo
    private static final String IGR_HASH = "c56fb7d591ba6704df047fd98f535372fea00211";

    @OXOo.OOXIXo
    private static final HashSet<String> validAppSignatureHashes = Xo0.ooOOo0oXI(FBR_HASH, FBR2_HASH, FBI_HASH, FBL_HASH, MSR_HASH, FBF_HASH, IGR_HASH);

    private FacebookSignatureValidator() {
    }

    @XO0OX.x0XOIxOo
    public static final boolean validateSignature(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String packageName) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(packageName, "packageName");
        String brand = Build.BRAND;
        int i = context.getApplicationInfo().flags;
        IIX0o.oO(brand, "brand");
        if (kotlin.text.OxI.IOOoXo0Ix(brand, "generic", false, 2, null) && (i & 2) != 0) {
            return true;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                return false;
            }
            IIX0o.oO(signatureArr, "packageInfo.signatures");
            if (signatureArr.length == 0) {
                return false;
            }
            Signature[] signatureArr2 = packageInfo.signatures;
            IIX0o.oO(signatureArr2, "packageInfo.signatures");
            for (Signature signature : signatureArr2) {
                HashSet<String> hashSet = validAppSignatureHashes;
                Utility utility = Utility.INSTANCE;
                byte[] byteArray = signature.toByteArray();
                IIX0o.oO(byteArray, "it.toByteArray()");
                if (!CollectionsKt___CollectionsKt.X00xOoXI(hashSet, Utility.sha1hash(byteArray))) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
