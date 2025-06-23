package com.baidu.mapclient.liteapp;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.PathUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ViewUtils;
import com.jieli.bmp_convert.BmpConvert;
import com.sifli.ezip.sifliEzipUtil;
import com.szabh.navi.R;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.io.File;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class NavGuideImage {
    private float roundCornerRadius;
    private int screenHeight;
    private int screenWidth;
    private final int SIZE_4 = 4;
    private final float NAV_VIEW_WIDTH = 360.0f;
    private boolean isRound = true;

    /* loaded from: classes7.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NavType.values().length];
            try {
                iArr[NavType.BIKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NavType.CAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NavGuideImage() {
        initConfig();
    }

    private final Bitmap clipBitmap(Bitmap bitmap, int i, int i2, int i3) {
        float f = i / i2;
        int width = bitmap.getWidth();
        int i4 = (int) (width / f);
        Bitmap clip = ImageUtils.clip(bitmap, 0, (bitmap.getHeight() - i4) - i3, width, i4);
        IIX0o.oO(clip, "clip(...)");
        return clip;
    }

    public static /* synthetic */ byte[] convertPng$default(NavGuideImage navGuideImage, File file, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return navGuideImage.convertPng(file, z, z2);
    }

    private final byte[] convertPngJL(File file, boolean z) {
        int i;
        String str = file.getPath() + ".bin";
        if (z) {
            i = 4;
        } else {
            i = 3;
        }
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI("convertPng type=" + i + ", pngFile=" + file + ", outFilePath=" + str);
        int bitmapConvertBlock = new BmpConvert().bitmapConvertBlock(i, file.getPath(), str);
        if (bitmapConvertBlock <= 0) {
            oix0oi.oIX0oI("convertPng error = " + bitmapConvertBlock);
            return null;
        }
        byte[] readFile2BytesByChannel = FileIOUtils.readFile2BytesByChannel(str);
        int length = readFile2BytesByChannel.length;
        int i2 = this.SIZE_4;
        int i3 = (((length + i2) - 1) / i2) * i2;
        byte[] bArr = new byte[i3];
        System.arraycopy(readFile2BytesByChannel, 0, bArr, 0, readFile2BytesByChannel.length);
        oix0oi.oIX0oI("convertPngJL outFileBytes=" + readFile2BytesByChannel.length + ", bytes=" + i3);
        return bArr;
    }

    public static /* synthetic */ byte[] convertPngJL$default(NavGuideImage navGuideImage, File file, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return navGuideImage.convertPngJL(file, z);
    }

    public static /* synthetic */ byte[] convertPngS$default(NavGuideImage navGuideImage, File file, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return navGuideImage.convertPngS(file, z, z2);
    }

    private final Bitmap getFinalBgBitmap(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
        IIX0o.oO(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    private final Bitmap getGuideViewBitmap(Bitmap bitmap, String str, NavType navType) {
        int i;
        float width = bitmap.getWidth() / bitmap.getHeight();
        View layoutId2View = ViewUtils.layoutId2View(R.layout.layout_nav_guide_info);
        ImageView imageView = (ImageView) layoutId2View.findViewById(R.id.iv_nav_type);
        int i2 = WhenMappings.$EnumSwitchMapping$0[navType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                i = R.drawable.icon_nav_type_walk;
            } else {
                i = R.drawable.icon_nav_type_car;
            }
        } else {
            i = R.drawable.icon_nav_type_bike;
        }
        imageView.setImageResource(i);
        if (this.isRound) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            IIX0o.x0XOIxOo(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams).gravity = GravityCompat.END;
        }
        ((ImageView) layoutId2View.findViewById(R.id.iv_nav_image)).setImageBitmap(bitmap);
        ((TextView) layoutId2View.findViewById(R.id.tv_guide_text)).setText(str);
        layoutId2View.measure(View.MeasureSpec.makeMeasureSpec(SizeUtils.dp2px(this.NAV_VIEW_WIDTH), 1073741824), View.MeasureSpec.makeMeasureSpec(SizeUtils.dp2px(this.NAV_VIEW_WIDTH / width), 1073741824));
        layoutId2View.layout(0, 0, layoutId2View.getMeasuredWidth(), layoutId2View.getMeasuredHeight());
        layoutId2View.requestLayout();
        IIX0o.ooOOo0oXI(layoutId2View);
        return view2Bitmap(layoutId2View);
    }

    private final Bitmap view2Bitmap(View view) {
        Bitmap createBitmap;
        boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
        boolean willNotCacheDrawing = view.willNotCacheDrawing();
        view.setDrawingCacheEnabled(true);
        view.setWillNotCacheDrawing(false);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache != null && !drawingCache.isRecycled()) {
            createBitmap = Bitmap.createBitmap(drawingCache);
            IIX0o.oO(createBitmap, "createBitmap(...)");
        } else {
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache2 = view.getDrawingCache();
            if (drawingCache2 != null && !drawingCache2.isRecycled()) {
                createBitmap = Bitmap.createBitmap(drawingCache2);
                IIX0o.oO(createBitmap, "createBitmap(...)");
            } else {
                createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.RGB_565);
                IIX0o.oO(createBitmap, "createBitmap(...)");
                view.draw(new Canvas(createBitmap));
            }
        }
        view.setWillNotCacheDrawing(willNotCacheDrawing);
        view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        return createBitmap;
    }

    @oOoXoXO
    public final byte[] convertPng(@OOXIXo File pngFile, boolean z, boolean z2) {
        IIX0o.x0xO0oo(pngFile, "pngFile");
        if (IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_JL)) {
            return convertPngJL(pngFile, z);
        }
        return convertPngS(pngFile, z, z2);
    }

    @OOXIXo
    public final byte[] convertPngS(@OOXIXo File pngFile, boolean z, boolean z2) {
        String str;
        IIX0o.x0xO0oo(pngFile, "pngFile");
        byte[] readFile2BytesByChannel = FileIOUtils.readFile2BytesByChannel(pngFile);
        if (z) {
            str = "rgb888a";
        } else {
            str = "rgb565";
        }
        byte[] pngToEzip = sifliEzipUtil.pngToEzip(readFile2BytesByChannel, str, 0, !z2 ? 1 : 0, 0);
        int length = pngToEzip.length;
        int i = this.SIZE_4;
        int i2 = (((length + i) - 1) / i) * i;
        byte[] bArr = new byte[i2];
        System.arraycopy(pngToEzip, 0, bArr, 0, pngToEzip.length);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("convertPngS outFileBytes=" + pngToEzip.length + ", bytes=" + i2);
        return bArr;
    }

    @OOXIXo
    public final Bitmap getNavGuideBitmap(@OOXIXo Bitmap bitmap, @OOXIXo String guideText, @OOXIXo NavType type, int i) {
        Bitmap roundCorner;
        IIX0o.x0xO0oo(bitmap, "bitmap");
        IIX0o.x0xO0oo(guideText, "guideText");
        IIX0o.x0xO0oo(type, "type");
        Bitmap scale = ImageUtils.scale(getGuideViewBitmap(clipBitmap(bitmap, bitmap.getWidth(), (int) (bitmap.getWidth() / (this.screenWidth / this.screenHeight)), i), guideText, type), this.screenWidth / r4.getWidth(), this.screenHeight / r4.getHeight());
        if (this.isRound) {
            roundCorner = ImageUtils.toRound(scale);
        } else {
            roundCorner = ImageUtils.toRoundCorner(scale, this.roundCornerRadius);
        }
        IIX0o.ooOOo0oXI(roundCorner);
        return getFinalBgBitmap(roundCorner);
    }

    @oOoXoXO
    public final byte[] getNavGuideByteArray(@OOXIXo Bitmap bitmap) {
        IIX0o.x0xO0oo(bitmap, "bitmap");
        File file = new File(PathUtils.getExternalAppDataPath() + "/logs/nav/navGuideBitmap.png");
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append("save -> ");
        sb.append(file);
        oix0oi.oIX0oI(sb.toString());
        ImageUtils.save(bitmap, file, Bitmap.CompressFormat.PNG);
        return convertPng$default(this, file, false, false, 4, null);
    }

    public final float getRoundCornerRadius() {
        return this.roundCornerRadius;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final int getScreenWidth() {
        return this.screenWidth;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
    
        if (r0.equals("AM02J") == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0145, code lost:
    
        r10.screenWidth = 368;
        r10.screenHeight = 448;
        r10.roundCornerRadius = 40.0f;
        r10.isRound = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
    
        if (r0.equals("AM01J") == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0069, code lost:
    
        if (r0.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_HW01) == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x010d, code lost:
    
        r10.screenWidth = 360;
        r10.screenHeight = 360;
        r10.isRound = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
    
        if (r0.equals("F13B") == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0175, code lost:
    
        r10.screenWidth = 240;
        r10.screenHeight = 286;
        r10.isRound = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bb, code lost:
    
        if (r0.equals("AM05") == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0199, code lost:
    
        r10.screenWidth = 466;
        r10.screenHeight = 466;
        r10.isRound = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c5, code lost:
    
        if (r0.equals("AM01") == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00cf, code lost:
    
        if (r0.equals("V61") == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0023, code lost:
    
        if (r0.equals("F12Pro") == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ff, code lost:
    
        if (r0.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_FT5) == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0187, code lost:
    
        r10.screenWidth = com.garmin.fit.X0xOO.f13583O0o0;
        r10.screenHeight = 386;
        r10.isRound = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0109, code lost:
    
        if (r0.equals("FC2") == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0141, code lost:
    
        if (r0.equals("F12") == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0169, code lost:
    
        if (r0.equals("A8") == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0172, code lost:
    
        if (r0.equals("A7") == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0184, code lost:
    
        if (r0.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_A8_ULTRA_PRO) == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0196, code lost:
    
        if (r0.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_SF15GUC) == false) goto L97;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0018. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void initConfig() {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapclient.liteapp.NavGuideImage.initConfig():void");
    }

    public final boolean isRound() {
        return this.isRound;
    }

    public final void setRound(boolean z) {
        this.isRound = z;
    }

    public final void setRoundCornerRadius(float f) {
        this.roundCornerRadius = f;
    }

    public final void setScreenHeight(int i) {
        this.screenHeight = i;
    }

    public final void setScreenWidth(int i) {
        this.screenWidth = i;
    }
}
