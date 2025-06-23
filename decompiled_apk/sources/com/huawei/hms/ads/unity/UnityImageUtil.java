package com.huawei.hms.ads.unity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.by;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.g;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.utils.an;
import com.huawei.openalliance.ad.utils.z;

@AllApi
/* loaded from: classes10.dex */
public class UnityImageUtil {
    private static UnityImageUtil I;
    private static final byte[] V = new byte[0];

    /* renamed from: com.huawei.hms.ads.unity.UnityImageUtil$2, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[UnityImageType.values().length];
            Code = iArr;
            try {
                iArr[UnityImageType.ICON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[UnityImageType.IMAGES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[UnityImageType.CHOICESINFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private UnityImageUtil() {
    }

    private ImageInfo Code(g gVar, String str, UnityImageType unityImageType) {
        int i = AnonymousClass2.Code[unityImageType.ordinal()];
        if (i == 1) {
            ImageInfo Z = gVar.Z();
            if (TextUtils.equals(str, Z.Z())) {
                return Z;
            }
            return null;
        }
        if (i != 2) {
            return null;
        }
        for (ImageInfo imageInfo : gVar.B()) {
            if (TextUtils.equals(str, imageInfo.Z())) {
                return imageInfo;
            }
        }
        return null;
    }

    @AllApi
    public static UnityImageUtil getInstance() {
        UnityImageUtil unityImageUtil;
        synchronized (V) {
            try {
                if (I == null) {
                    I = new UnityImageUtil();
                }
                unityImageUtil = I;
            } catch (Throwable th) {
                throw th;
            }
        }
        return unityImageUtil;
    }

    @AllApi
    public void unityLoadImage(final UnityImageDelegate unityImageDelegate, Context context, NativeAd nativeAd, UnityImageType unityImageType) {
        if (unityImageDelegate == null || unityImageDelegate.getUri() == null) {
            return;
        }
        Uri uri = unityImageDelegate.getUri();
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(uri.toString());
        sourceParam.Code(52428800L);
        sourceParam.I(true);
        if (nativeAd == null || !(nativeAd instanceof by)) {
            return;
        }
        l Code = ((by) nativeAd).Code();
        final ImageInfo Code2 = Code(Code, uri.toString(), unityImageType);
        if (Code2 == null) {
            fb.Code("UnityImageUtil", "illegal image");
            return;
        }
        sourceParam.V(Code2.I());
        sourceParam.V(Code2.S());
        if (Code != null) {
            z.Code(context, sourceParam, Code.a(), Code.o(), new an() { // from class: com.huawei.hms.ads.unity.UnityImageUtil.1
                @Override // com.huawei.openalliance.ad.utils.an
                public void Code() {
                    fb.I("UnityImageUtil", "unity load image fail");
                }

                @Override // com.huawei.openalliance.ad.utils.an
                public void Code(String str, Drawable drawable) {
                    ImageInfo imageInfo = Code2;
                    if (imageInfo == null || !TextUtils.equals(str, imageInfo.Z())) {
                        return;
                    }
                    fb.Code("UnityImageUtil", "unity load image success");
                    unityImageDelegate.setDrawable(drawable);
                }
            });
        }
    }
}
