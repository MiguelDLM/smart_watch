package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleBrandInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleBrandInfo.kt\ncom/szabh/smable3/entity/BrandInfoBuilder\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,251:1\n13309#2,2:252\n37#3,2:254\n37#3,2:256\n*S KotlinDebug\n*F\n+ 1 BleBrandInfo.kt\ncom/szabh/smable3/entity/BrandInfoBuilder\n*L\n233#1:252,2\n246#1:254,2\n247#1:256,2\n*E\n"})
/* loaded from: classes13.dex */
public final class BrandInfoBuilder {
    public static final int CD_BITMAP_COMPRESSION_JL = 2;
    public static final int CD_BITMAP_COMPRESSION_JL_JPEG = 3;
    public static final int CD_BITMAP_COMPRESSION_NONE = 0;
    public static final int CD_BITMAP_COMPRESSION_RLE_LINE = 1;
    public static final int CD_RGB_565 = 1;
    public static final int CD_RGB_565_BE = 2;
    public static final int CD_RGB_888 = 2;
    public static final int GRAVITY_X_CENTER = 4;
    public static final int GRAVITY_X_LEFT = 1;
    public static final int GRAVITY_X_RIGHT = 2;
    public static final int GRAVITY_Y_BOTTOM = 16;
    public static final int GRAVITY_Y_CENTER = 32;
    public static final int GRAVITY_Y_TOP = 8;

    @OOXIXo
    public static final BrandInfoBuilder INSTANCE = new BrandInfoBuilder();

    private BrandInfoBuilder() {
    }

    @OOXIXo
    public final byte[] build(@OOXIXo String bleName, @OOXIXo BrandInfoImageItem item) {
        IIX0o.x0xO0oo(bleName, "bleName");
        IIX0o.x0xO0oo(item, "item");
        BleBrandInfo bleBrandInfo = new BleBrandInfo(null, null, null, 7, null);
        bleBrandInfo.getMHeader().setMItemCount(2);
        bleBrandInfo.getMItem0().setMBleName(bleName);
        bleBrandInfo.getMItem1().setMX(item.getMX());
        bleBrandInfo.getMItem1().setMY(item.getMY());
        bleBrandInfo.getMItem1().setMAnchor(item.getMAnchor());
        bleBrandInfo.getMItem1().setMCount(item.getMImageInfos().length);
        bleBrandInfo.getMItem1().setMPlayInterval(item.getMPlayInterval());
        long mLengthToWrite = bleBrandInfo.getMHeader().getMLengthToWrite() + (bleBrandInfo.getMHeader().getMItemCount() * 4) + bleBrandInfo.getMItem0().getMLengthToWrite() + 32 + (bleBrandInfo.getMItem1().getMCount() * 16);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (BrandInfoImage brandInfoImage : item.getMImageInfos()) {
            arrayList.add(brandInfoImage.getMImageBuffer());
            arrayList2.add(new BleBrandInfoImage(BleWatchFaceId.WATCHFACE_ID_INVALID, mLengthToWrite, brandInfoImage.getMWidth(), brandInfoImage.getMHeight(), brandInfoImage.getHasAlpha(), brandInfoImage.getMCompression(), brandInfoImage.getMPixelFormat()));
            mLengthToWrite += brandInfoImage.getMImageBuffer().length;
        }
        bleBrandInfo.getMItem1().setMImageInfos((BleBrandInfoImage[]) arrayList2.toArray(new BleBrandInfoImage[0]));
        bleBrandInfo.getMItem1().setMImageBuffers((byte[][]) arrayList.toArray(new byte[0]));
        return bleBrandInfo.toByteArray();
    }
}
