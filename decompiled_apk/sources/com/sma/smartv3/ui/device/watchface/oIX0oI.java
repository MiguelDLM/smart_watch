package com.sma.smartv3.ui.device.watchface;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Application;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.LayoutRes;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.core.view.ViewCompat;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ViewUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.jieli.bmp_convert.BmpConvert;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import com.sifli.ezip.sifliEzipUtil;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.IXxxXO;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.BleDeviceInfo;
import com.szabh.smable3.watchface.Element;
import com.szabh.smable3.watchface.WatchFaceBuilder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.StringsKt__StringsKt;
import o0oIxXOx.XIxXXX0x0;

@XX({"SMAP\nCustomWatchFace.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomWatchFace.kt\ncom/sma/smartv3/ui/device/watchface/CustomWatchFace\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2031:1\n254#2:2032\n254#2:2033\n254#2:2034\n254#2:2035\n254#2:2069\n254#2:2070\n254#2:2071\n254#2:2072\n254#2:2075\n254#2:2076\n254#2:2077\n254#2:2078\n254#2:2079\n254#2:2080\n254#2:2081\n254#2:2082\n37#3,2:2036\n37#3,2:2038\n37#3,2:2041\n37#3,2:2043\n37#3,2:2045\n37#3,2:2047\n37#3,2:2049\n37#3,2:2051\n37#3,2:2053\n37#3,2:2055\n37#3,2:2057\n37#3,2:2059\n37#3,2:2061\n37#3,2:2063\n37#3,2:2065\n37#3,2:2067\n37#3,2:2073\n1#4:2040\n*S KotlinDebug\n*F\n+ 1 CustomWatchFace.kt\ncom/sma/smartv3/ui/device/watchface/CustomWatchFace\n*L\n480#1:2032\n483#1:2033\n525#1:2034\n528#1:2035\n1062#1:2069\n1077#1:2070\n1092#1:2071\n1107#1:2072\n1130#1:2075\n1145#1:2076\n1160#1:2077\n1175#1:2078\n1384#1:2079\n1393#1:2080\n1397#1:2081\n1640#1:2082\n540#1:2036,2\n551#1:2038,2\n627#1:2041,2\n661#1:2043,2\n697#1:2045,2\n726#1:2047,2\n734#1:2049,2\n773#1:2051,2\n812#1:2053,2\n877#1:2055,2\n887#1:2057,2\n927#1:2059,2\n967#1:2061,2\n1000#1:2063,2\n1041#1:2065,2\n1060#1:2067,2\n1128#1:2073,2\n*E\n"})
/* loaded from: classes12.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public ViewGroup f22831I0Io;

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public String f22832I0X0x0oIo;

    /* renamed from: I0oOIX, reason: collision with root package name */
    public String f22833I0oOIX;

    /* renamed from: I0oOoX, reason: collision with root package name */
    public float f22834I0oOoX;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public ImageView f22835II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public ImageView f22836II0xO0;

    /* renamed from: IIX0o, reason: collision with root package name */
    public float f22837IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f22838IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    public float f22839IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f22840IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    public float f22841Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public float f22842IoOoX;

    /* renamed from: IoOoo, reason: collision with root package name */
    @OOXIXo
    public final String f22843IoOoo;

    /* renamed from: Ioxxx, reason: collision with root package name */
    @OOXIXo
    public final String f22844Ioxxx;

    /* renamed from: O00XxXI, reason: collision with root package name */
    @OOXIXo
    public Application f22845O00XxXI;

    /* renamed from: O0Xx, reason: collision with root package name */
    public String f22846O0Xx;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public float f22847O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    public float f22848OI0;

    /* renamed from: OO, reason: collision with root package name */
    public String f22849OO;

    /* renamed from: OO0x0xX, reason: collision with root package name */
    @OOXIXo
    public final String f22850OO0x0xX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public boolean f22851OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public int f22852Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f22853OxI;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public ViewGroup f22854Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f22855Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f22856OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public float f22857X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public float f22858X0IIOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public ViewGroup f22859X0o0xo;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public float f22860XI0IXoo;

    /* renamed from: XIo0oOXIx, reason: collision with root package name */
    @OOXIXo
    public final String f22861XIo0oOXIx;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public float f22862XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public ViewGroup f22863XO;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public float f22864XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    public float f22865XX;

    /* renamed from: XX0, reason: collision with root package name */
    public String f22866XX0;

    /* renamed from: XX0xXo, reason: collision with root package name */
    public boolean f22867XX0xXo;

    /* renamed from: Xo0, reason: collision with root package name */
    public String f22868Xo0;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public String f22869XoI0Ixx0;

    /* renamed from: XoX, reason: collision with root package name */
    public int f22870XoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public float f22871Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public float f22872XxX0x0xxx;

    /* renamed from: o0, reason: collision with root package name */
    public float f22873o0;

    /* renamed from: o00, reason: collision with root package name */
    public int f22874o00;

    /* renamed from: o0xxxXXxX, reason: collision with root package name */
    @OOXIXo
    public List<String> f22875o0xxxXXxX;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OOXIXo
    public String f22876oI0IIXIo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f22877oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public int f22878oO;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public float f22879oOXoIIIo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public float f22880oOoXoXO;

    /* renamed from: oX, reason: collision with root package name */
    public String f22881oX;

    /* renamed from: oo, reason: collision with root package name */
    public float f22882oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public float f22883oo0xXOI0I;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f22884ooOOo0oXI;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f22885ooXIXxIX;

    /* renamed from: ox, reason: collision with root package name */
    public View f22886ox;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public int f22887oxXx0IX;

    /* renamed from: oxoX, reason: collision with root package name */
    public ViewGroup f22888oxoX;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public float f22889oxxXoxO;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public int f22890x0XOIxOo;

    /* renamed from: x0o, reason: collision with root package name */
    public float f22891x0o;

    /* renamed from: x0xO, reason: collision with root package name */
    @OOXIXo
    public final String f22892x0xO;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public int f22893x0xO0oo;

    /* renamed from: xI, reason: collision with root package name */
    public float f22894xI;

    /* renamed from: xII, reason: collision with root package name */
    public float f22895xII;

    /* renamed from: xXOx, reason: collision with root package name */
    public String f22896xXOx;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public float f22897xXxxox0I;

    /* renamed from: xo0x, reason: collision with root package name */
    public int f22898xo0x;

    /* renamed from: xoIox, reason: collision with root package name */
    public float f22899xoIox;

    /* renamed from: xoIxX, reason: collision with root package name */
    @OOXIXo
    public final String f22900xoIxX;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f22901xoXoI;

    /* renamed from: xoxXI, reason: collision with root package name */
    public String f22902xoxXI;

    /* renamed from: xxIO, reason: collision with root package name */
    @OOXIXo
    public final String f22903xxIO;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public ImageView f22904xxIXOIIO;

    /* renamed from: xxX, reason: collision with root package name */
    public float f22905xxX;

    /* renamed from: XI0oooXX, reason: collision with root package name */
    @OOXIXo
    public static final C0962oIX0oI f22830XI0oooXX = new C0962oIX0oI(null);

    /* renamed from: OOXIxO0, reason: collision with root package name */
    public static final int f22829OOXIxO0 = 4;

    /* renamed from: com.sma.smartv3.ui.device.watchface.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C0962oIX0oI {
        public /* synthetic */ C0962oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ byte[] II0XooXoX(C0962oIX0oI c0962oIX0oI, File file, boolean z, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            return c0962oIX0oI.Oxx0IOOO(file, z, z2);
        }

        public static /* synthetic */ byte[] XO(C0962oIX0oI c0962oIX0oI, File file, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            return c0962oIX0oI.X0o0xo(file, z);
        }

        public static /* synthetic */ byte[] oxoX(C0962oIX0oI c0962oIX0oI, File file, boolean z, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            return c0962oIX0oI.I0Io(file, z, z2);
        }

        public static /* synthetic */ byte[] xoIox(C0962oIX0oI c0962oIX0oI, String str, byte[] bArr, int i, int i2, int i3, boolean z, boolean z2, int i4, int i5, Object obj) {
            int i6;
            int i7;
            boolean z3;
            boolean z4;
            int i8;
            if ((i5 & 8) != 0) {
                i6 = 16;
            } else {
                i6 = i2;
            }
            if ((i5 & 16) != 0) {
                i7 = 70;
            } else {
                i7 = i3;
            }
            if ((i5 & 32) != 0) {
                z3 = true;
            } else {
                z3 = z;
            }
            if ((i5 & 64) != 0) {
                z4 = false;
            } else {
                z4 = z2;
            }
            if ((i5 & 128) != 0) {
                i8 = 0;
            } else {
                i8 = i4;
            }
            return c0962oIX0oI.xxIXOIIO(str, bArr, i, i6, i7, z3, z4, i8);
        }

        @oOoXoXO
        public final byte[] I0Io(@OOXIXo File pngFile, boolean z, boolean z2) {
            IIX0o.x0xO0oo(pngFile, "pngFile");
            if (IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_JL)) {
                return X0o0xo(pngFile, z);
            }
            return Oxx0IOOO(pngFile, z, z2);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0054  */
        @OXOo.OOXIXo
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final android.graphics.Bitmap II0xO0(@OXOo.OOXIXo android.graphics.Bitmap r7, int r8, int r9) {
            /*
                r6 = this;
                java.lang.String r0 = "bitmap"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
                int r0 = r7.getWidth()
                int r1 = r7.getHeight()
                int r2 = r7.getWidth()
                int r3 = r7.getHeight()
                float r8 = (float) r8
                float r9 = (float) r9
                float r8 = r8 / r9
                r9 = 0
                if (r0 <= r1) goto L27
                float r2 = (float) r1
                float r2 = r2 * r8
                int r2 = (int) r2
                int r8 = r0 - r2
                int r8 = r8 / 2
            L23:
                r9 = r8
                r3 = r1
            L25:
                r8 = 0
                goto L4d
            L27:
                if (r0 >= r1) goto L32
                float r2 = (float) r0
                float r2 = r2 / r8
                int r3 = (int) r2
                int r8 = r1 - r3
                int r8 = r8 / 2
            L30:
                r2 = r0
                goto L4d
            L32:
                r4 = 1065353216(0x3f800000, float:1.0)
                int r5 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r5 <= 0) goto L40
                float r2 = (float) r0
                float r2 = r2 / r8
                int r3 = (int) r2
                int r8 = r1 - r3
                int r8 = r8 / 2
                goto L30
            L40:
                int r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r4 >= 0) goto L25
                float r2 = (float) r1
                float r2 = r2 * r8
                int r2 = (int) r2
                int r8 = r0 - r2
                int r8 = r8 / 2
                goto L23
            L4d:
                if (r2 <= r0) goto L50
                goto L51
            L50:
                r0 = r2
            L51:
                if (r3 <= r1) goto L54
                goto L55
            L54:
                r1 = r3
            L55:
                android.graphics.Bitmap r7 = com.blankj.utilcode.util.ImageUtils.clip(r7, r9, r8, r0, r1)
                java.lang.String r8 = "clip(...)"
                kotlin.jvm.internal.IIX0o.oO(r7, r8)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.watchface.oIX0oI.C0962oIX0oI.II0xO0(android.graphics.Bitmap, int, int):android.graphics.Bitmap");
        }

        public final int OOXIXo() {
            return oIX0oI.f22829OOXIxO0;
        }

        @OOXIXo
        public final byte[] Oxx0IOOO(@OOXIXo File pngFile, boolean z, boolean z2) {
            String str;
            IIX0o.x0xO0oo(pngFile, "pngFile");
            byte[] readFile2BytesByChannel = FileIOUtils.readFile2BytesByChannel(pngFile);
            if (z) {
                str = "rgb888a";
            } else {
                str = "rgb565";
            }
            byte[] pngToEzip = sifliEzipUtil.pngToEzip(readFile2BytesByChannel, str, 0, !z2 ? 1 : 0, 0);
            int length = (((pngToEzip.length + OOXIXo()) - 1) / OOXIXo()) * OOXIXo();
            byte[] bArr = new byte[length];
            System.arraycopy(pngToEzip, 0, bArr, 0, pngToEzip.length);
            LogUtils.d("convertPngS outFileBytes=" + pngToEzip.length + ", bytes=" + length);
            return bArr;
        }

        @oOoXoXO
        public final byte[] X0o0xo(@OOXIXo File pngFile, boolean z) {
            int i;
            IIX0o.x0xO0oo(pngFile, "pngFile");
            String str = pngFile.getPath() + ".bin";
            if (z) {
                i = 4;
            } else {
                i = 3;
            }
            LogUtils.d("convertPng type=" + i + ", pngFile=" + pngFile + ", outFilePath=" + str);
            int bitmapConvertBlock = new BmpConvert().bitmapConvertBlock(i, pngFile.getPath(), str);
            if (bitmapConvertBlock <= 0) {
                LogUtils.d("convertPng error = " + bitmapConvertBlock);
                return null;
            }
            byte[] readFile2BytesByChannel = FileIOUtils.readFile2BytesByChannel(str);
            int length = (((readFile2BytesByChannel.length + OOXIXo()) - 1) / OOXIXo()) * OOXIXo();
            byte[] bArr = new byte[length];
            System.arraycopy(readFile2BytesByChannel, 0, bArr, 0, readFile2BytesByChannel.length);
            LogUtils.d("convertPngJL outFileBytes=" + readFile2BytesByChannel.length + ", bytes=" + length);
            return bArr;
        }

        public final int oIX0oI(int i) {
            return (((i >> 24) & 255) << 16) + ((((i >> 16) & 255) >> 3) << 11) + ((((i >> 8) & 255) >> 2) << 5) + ((i & 255) >> 3);
        }

        @OOXIXo
        public final byte[] oOoXoXO(@OOXIXo byte[] bytes, int i, int i2) {
            IIX0o.x0xO0oo(bytes, "bytes");
            Bitmap bitmap = ImageUtils.getBitmap(bytes, 0);
            int[] iArr = new int[bitmap.getHeight() * bitmap.getWidth()];
            bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            int OOXIXo2 = ((((i * 3) + OOXIXo()) - 1) / OOXIXo()) * OOXIXo();
            int i3 = OOXIXo2 * i2;
            byte[] bArr = new byte[i3];
            for (int i4 = 0; i4 < i2; i4++) {
                byte[] bArr2 = new byte[OOXIXo2];
                for (int i5 = 0; i5 < i; i5++) {
                    int oIX0oI2 = oIX0oI(iArr[(i4 * i) + i5]);
                    int i6 = i5 * 3;
                    bArr2[i6 + 2] = (byte) (oIX0oI2 & 255);
                    bArr2[i6 + 1] = (byte) ((oIX0oI2 >> 8) & 255);
                    bArr2[i6] = (byte) ((oIX0oI2 >> 16) & 255);
                }
                System.arraycopy(bArr2, 0, bArr, i4 * OOXIXo2, OOXIXo2);
            }
            LogUtils.d("pngTo8565 -> w=" + i + ", h=" + i2 + ", rowSize=" + OOXIXo2 + ", data=" + i3);
            return bArr;
        }

        @OOXIXo
        public final Bitmap ooOOo0oXI(@OOXIXo View view) {
            Bitmap createBitmap;
            IIX0o.x0xO0oo(view, "view");
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

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Iterable, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r8v3, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r8v5, types: [java.util.List] */
        @OOXIXo
        public final byte[] xxIXOIIO(@OOXIXo String fileFormat, @OOXIXo byte[] data, int i, int i2, int i3, boolean z, boolean z2, int i4) {
            byte b;
            int i5;
            IIX0o.x0xO0oo(fileFormat, "fileFormat");
            IIX0o.x0xO0oo(data, "data");
            if (IIX0o.Oxx0IOOO(fileFormat, "bmp")) {
                if (i3 == 0) {
                    b = 0;
                } else {
                    b = data[10];
                }
                LogUtils.d("headerInfoSize " + ((int) b));
                List<Byte> o0X0 = ArraysKt___ArraysKt.o0X0(data, data.length - b);
                int i6 = (((i2 * i) + 31) / 32) * 4;
                ?? arrayList = new ArrayList();
                if (i % 2 == 0) {
                    i5 = 0;
                } else {
                    i5 = 2;
                }
                int size = o0X0.size() / i6;
                for (int i7 = 0; i7 < size; i7++) {
                    int i8 = i6 - i5;
                    byte[] bArr = new byte[i8];
                    for (int i9 = 0; i9 < i8; i9++) {
                        bArr[i9] = o0X0.get((i7 * i6) + i9).byteValue();
                    }
                    arrayList.add(bArr);
                }
                if (z) {
                    arrayList = CollectionsKt___CollectionsKt.OOoOoO0o(arrayList);
                }
                ArrayList arrayList2 = new ArrayList();
                int size2 = arrayList.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    for (int i11 = 0; i11 < ((byte[]) arrayList.get(i10)).length; i11 += 2) {
                        arrayList2.add(Byte.valueOf(((byte[]) arrayList.get(i10))[i11 + 1]));
                        arrayList2.add(Byte.valueOf(((byte[]) arrayList.get(i10))[i11]));
                    }
                }
                int size3 = arrayList2.size();
                byte[] bArr2 = new byte[size3];
                for (int i12 = 0; i12 < size3; i12++) {
                    Object obj = arrayList2.get(i12);
                    IIX0o.oO(obj, "get(...)");
                    bArr2[i12] = ((Number) obj).byteValue();
                }
                return bArr2;
            }
            if (z2) {
                return oOoXoXO(data, i, i4);
            }
            return data;
        }

        public C0962oIX0oI() {
        }
    }

    public oIX0oI(@OOXIXo Application app) {
        IIX0o.x0xO0oo(app, "app");
        this.f22899xoIox = 40.0f;
        this.f22851OOXIXo = true;
        this.f22855Oxx0xo = 9;
        this.f22876oI0IIXIo = "png";
        this.f22856OxxIIOOXO = 1;
        this.f22838IIXOooo = 4;
        this.f22901xoXoI = 32;
        this.f22843IoOoo = "am_pm";
        this.f22900xoIxX = XIxXXX0x0.f31178xoIox;
        this.f22892x0xO = "hour_minute";
        this.f22850OO0x0xX = "week";
        this.f22861XIo0oOXIx = "pointer/hour";
        this.f22844Ioxxx = "pointer/minute";
        this.f22903xxIO = "pointer/second";
        this.f22867XX0xXo = IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_JL) && !ProductManager.f20544oIX0oI.OXooXo();
        this.f22875o0xxxXXxX = CollectionsKt__CollectionsKt.ooXIXxIX();
        this.f22845O00XxXI = app;
        XIXIX();
        oXIO0o0XI();
        xOoOIoI();
    }

    public static /* synthetic */ Triple XX0(oIX0oI oix0oi, String str, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 9;
            }
            return oix0oi.xXOx(str, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNumberBuffers2");
    }

    public static /* synthetic */ Bitmap oOoXoXO(oIX0oI oix0oi, boolean z, int i, Bitmap bitmap, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = R.color.dark;
            }
            if ((i2 & 4) != 0) {
                bitmap = null;
            }
            return oix0oi.OOXIXo(z, i, bitmap);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBgBitmap");
    }

    public static /* synthetic */ Triple xo0x(oIX0oI oix0oi, String str, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 9;
            }
            return oix0oi.oxXx0IX(str, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNumberBuffers");
    }

    @OOXIXo
    public final String I0() {
        String str = this.f22877oIX0oI;
        if (str != null) {
            return str;
        }
        IIX0o.XOxIOxOx("tmpDir");
        return null;
    }

    public final void I0Io(String str, float f, float f2, Canvas canvas, boolean z) {
        float x = XI0oooXX().getX() * f;
        float y = f2 * XI0oooXX().getY();
        LogUtils.d("test timeLeft=" + x + ",  timeTop=" + y + ", timeDigitalView.width=" + XI0oooXX().getWidth() + " ,scaleWidth =" + f);
        AssetManager assets = this.f22845O00XxXI.getResources().getAssets();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(this.f22843IoOoo);
        sb.append("/pm.png");
        Bitmap bitmap = ImageUtils.getBitmap(assets.open(sb.toString()));
        Pair<Bitmap, Float> oxoX2 = oxoX(str, this.f22892x0xO, "08:30", y, bitmap.getHeight(), canvas, x, z);
        float floatValue = oxoX(str, this.f22900xoIxX, "07/08", oxoX2.component2().floatValue(), oxoX2.component1().getHeight(), canvas, x, z).component2().floatValue();
        if (z) {
            canvas.drawBitmap(bitmap, this.f22871Xx000oIo - bitmap.getWidth(), y, (Paint) null);
        }
        this.f22894xI = this.f22871Xx000oIo - bitmap.getWidth();
        this.f22883oo0xXOI0I = y;
        Bitmap bitmap2 = ImageUtils.getBitmap(this.f22845O00XxXI.getResources().getAssets().open(str + this.f22850OO0x0xX + "/4.png"));
        if (z) {
            canvas.drawBitmap(bitmap2, this.f22871Xx000oIo - bitmap2.getWidth(), floatValue, (Paint) null);
        }
        this.f22834I0oOoX = this.f22871Xx000oIo - bitmap2.getWidth();
        this.f22889oxxXoxO = floatValue;
    }

    public final void I0X0x0oIo(int i, String str, ArrayList<Element> arrayList) {
        int height;
        int height2;
        int i2;
        ArrayList arrayList2 = new ArrayList();
        AssetManager assets = this.f22845O00XxXI.getResources().getAssets();
        StringBuilder sb = new StringBuilder();
        String str2 = this.f22849OO;
        if (str2 == null) {
            IIX0o.XOxIOxOx("POINTER_DIR");
            str2 = null;
        }
        sb.append(str2);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(str);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(this.f22887oxXx0IX);
        sb.append('.');
        sb.append(this.f22876oI0IIXIo);
        Bitmap bitmap = ImageUtils.getBitmap(assets.open(sb.toString()));
        int width = bitmap.getWidth();
        if (this.f22867XX0xXo) {
            height = (int) (bitmap.getHeight() * 0.6f);
        } else {
            height = bitmap.getHeight();
        }
        int i3 = height;
        AssetManager assets2 = this.f22845O00XxXI.getResources().getAssets();
        StringBuilder sb2 = new StringBuilder();
        String str3 = this.f22849OO;
        if (str3 == null) {
            IIX0o.XOxIOxOx("POINTER_DIR");
            str3 = null;
        }
        sb2.append(str3);
        sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb2.append(str);
        sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb2.append(this.f22887oxXx0IX);
        sb2.append('.');
        sb2.append(this.f22876oI0IIXIo);
        InputStream open = assets2.open(sb2.toString());
        try {
            IIX0o.ooOOo0oXI(open);
            byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
            kotlin.io.II0xO0.oIX0oI(open, null);
            arrayList2.add(C0962oIX0oI.xoIox(f22830XI0oooXX, this.f22876oI0IIXIo, x0xO0oo2, width, 0, 0, false, this.f22867XX0xXo, i3, 56, null));
            int I0Io2 = oOXoIIIo.I0Io.I0Io(this.f22867XX0xXo);
            int i4 = this.f22853OxI;
            int i5 = (this.f22884ooOOo0oXI / 2) - 1;
            int i6 = (this.f22890x0XOIxOo / 2) - 1;
            if (IIX0o.Oxx0IOOO(this.f22876oI0IIXIo, "png") && !this.f22867XX0xXo) {
                height2 = 0;
            } else {
                height2 = i3 - (bitmap.getHeight() / 2);
            }
            if (IIX0o.Oxx0IOOO(this.f22876oI0IIXIo, "png") && !this.f22867XX0xXo) {
                i2 = 0;
            } else {
                i2 = width / 2;
            }
            arrayList.add(new Element(i, I0Io2, width, i3, 9, i4, i5, i6, 0, height2, i2, (byte[][]) arrayList2.toArray(new byte[0]), 256, null));
        } finally {
        }
    }

    public final byte[] I0oOIX() {
        Bitmap roundCorner;
        byte[] oxoX2;
        float width = this.f22878oO / r0.getWidth();
        Bitmap scale = ImageUtils.scale(oOoXoXO(this, true, 0, null, 6, null), width, this.f22893x0xO0oo / r0.getHeight());
        if (this.f22851OOXIXo) {
            roundCorner = ImageUtils.toRound(scale, this.f22874o00, this.f22845O00XxXI.getResources().getColor(R.color.dark));
        } else {
            roundCorner = ImageUtils.toRoundCorner(scale, this.f22880oOoXoXO * width, this.f22874o00, this.f22845O00XxXI.getResources().getColor(R.color.dark));
        }
        File file = new File(I0(), IXxxXO.f20878xXxxox0I);
        ImageUtils.save(roundCorner, file, Bitmap.CompressFormat.PNG);
        if (O0X() && (oxoX2 = C0962oIX0oI.oxoX(f22830XI0oooXX, file, false, false, 4, null)) != null) {
            return oxoX2;
        }
        IIX0o.ooOOo0oXI(roundCorner);
        return X0o0xo("bmp", roundCorner);
    }

    public final int I0oOoX() {
        return this.f22856OxxIIOOXO;
    }

    public final void I0xX0(int i) {
        this.f22853OxI = i;
    }

    public final float II0XooXoX() {
        return this.f22894xI;
    }

    public final Pair<Float, Float> II0xO0(String str, ViewGroup viewGroup, String str2, String str3, Canvas canvas, float f, float f2, boolean z) {
        if (viewGroup.getVisibility() == 0) {
            LogUtils.d("test addControlBitmap " + str + " , " + viewGroup.getX() + TokenParser.SP + viewGroup.getY() + TokenParser.SP + f + TokenParser.SP + f2);
            Bitmap bitmap = ImageUtils.getBitmap(this.f22845O00XxXI.getResources().getAssets().open(str));
            float x = viewGroup.getX() * f;
            float y = viewGroup.getY() * f2;
            canvas.drawBitmap(bitmap, x, y, (Paint) null);
            float width = ((float) (bitmap.getWidth() / 2)) + x;
            float height = y + ((float) bitmap.getHeight()) + ((float) this.f22840IXxxXO);
            float width2 = width - ((float) ((((ImageUtils.getBitmap(this.f22845O00XxXI.getResources().getAssets().open(str2 + str3.charAt(0) + '.' + this.f22876oI0IIXIo)).getWidth() * str3.length()) + str3.length()) - 1) / 2));
            if (z) {
                int length = str3.length();
                for (int i = 0; i < length; i++) {
                    Bitmap bitmap2 = ImageUtils.getBitmap(this.f22845O00XxXI.getResources().getAssets().open(str2 + str3.charAt(i) + ".png"));
                    canvas.drawBitmap(bitmap2, ((float) i) + width2 + ((float) (bitmap2.getWidth() * i)), height, (Paint) null);
                }
            }
            return new Pair<>(Float.valueOf(width), Float.valueOf(height + (r7.getHeight() / 2)));
        }
        return new Pair<>(Float.valueOf(0.0f), Float.valueOf(0.0f));
    }

    @LayoutRes
    public final int IIX0() {
        return Oxx0IOOO();
    }

    public final float IIX0o() {
        return this.f22882oo;
    }

    @OOXIXo
    public final ViewGroup IIXOooo() {
        ViewGroup viewGroup = this.f22859X0o0xo;
        if (viewGroup != null) {
            return viewGroup;
        }
        IIX0o.XOxIOxOx("controlViewCa");
        return null;
    }

    @OOXIXo
    public final ImageView IIxOXoOo0() {
        ImageView imageView = this.f22904xxIXOIIO;
        if (imageView != null) {
            return imageView;
        }
        IIX0o.XOxIOxOx("timeScaleView");
        return null;
    }

    public final float IO() {
        return this.f22889oxxXoxO;
    }

    public final void IO0XoXxO(int i) {
        this.f22870XoX = i;
    }

    public final void IOoo(float f) {
        this.f22872XxX0x0xxx = f;
    }

    public final void IXO(float f) {
        this.f22891x0o = f;
    }

    public final void IXxxXO(ArrayList<Element> arrayList) {
        StringBuilder sb = new StringBuilder();
        String str = this.f22846O0Xx;
        if (str == null) {
            IIX0o.XOxIOxOx("VALUE_DIR");
            str = null;
        }
        sb.append(str);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(this.f22885ooXIXxIX);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        Triple<Integer, Integer, ArrayList<byte[]>> oxXx0IX2 = oxXx0IX(sb.toString(), this.f22855Oxx0xo);
        int intValue = oxXx0IX2.getFirst().intValue();
        int intValue2 = oxXx0IX2.getSecond().intValue();
        byte[][] bArr = (byte[][]) oxXx0IX2.getThird().toArray(new byte[0]);
        if (OxI().getVisibility() == 0) {
            arrayList.add(new Element(14, oOXoIIIo.I0Io.I0Io(this.f22867XX0xXo), intValue, intValue2, this.f22838IIXOooo | this.f22901xoXoI, this.f22853OxI, (int) this.f22847O0xOxO, (int) this.f22858X0IIOO, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
        }
        if (o00().getVisibility() == 0) {
            arrayList.add(new Element(15, oOXoIIIo.I0Io.I0Io(this.f22867XX0xXo), intValue, intValue2, this.f22838IIXOooo | this.f22901xoXoI, this.f22853OxI, (int) this.f22897xXxxox0I, (int) this.f22837IIX0o, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
        }
        if (IIXOooo().getVisibility() == 0) {
            arrayList.add(new Element(16, oOXoIIIo.I0Io.I0Io(this.f22867XX0xXo), intValue, intValue2, this.f22838IIXOooo | this.f22901xoXoI, this.f22853OxI, (int) this.f22860XI0IXoo, (int) this.f22862XIxXXX0x0, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
        }
        if (xoXoI().getVisibility() == 0) {
            Element element = new Element(17, oOXoIIIo.I0Io.I0Io(this.f22867XX0xXo), intValue, intValue2, this.f22838IIXOooo | this.f22901xoXoI, this.f22853OxI, (int) this.f22905xxX, (int) this.f22872XxX0x0xxx, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null);
            LogUtils.d("test distanceValueCenterX=" + this.f22905xxX + "  distanceValueCenterY=" + this.f22872XxX0x0xxx);
            arrayList.add(element);
        }
    }

    public final float Io() {
        return this.f22897xXxxox0I;
    }

    public final void IoIOOxIIo(float f) {
        this.f22862XIxXXX0x0 = f;
    }

    public final float IoOoX() {
        return this.f22839IO;
    }

    public final int IoOoo() {
        return this.f22890x0XOIxOo;
    }

    public final void IoXIXo(float f) {
        this.f22882oo = f;
    }

    public final float Ioxxx() {
        return this.f22847O0xOxO;
    }

    public final void Ix00oIoI(float f) {
        this.f22873o0 = f;
    }

    public final void IxIX0I(float f) {
        this.f22848OI0 = f;
    }

    public final void IxX00(@OOXIXo ViewGroup viewGroup) {
        IIX0o.x0xO0oo(viewGroup, "<set-?>");
        this.f22854Oxx0IOOO = viewGroup;
    }

    public final void O0(float f) {
        this.f22883oo0xXOI0I = f;
    }

    public final void O00(int i) {
        this.f22852Oo = i;
    }

    public final void O00XxXI(ArrayList<Element> arrayList) {
        int i;
        ArrayList arrayList2 = new ArrayList();
        AssetManager assets = this.f22845O00XxXI.getResources().getAssets();
        StringBuilder sb = new StringBuilder();
        String str = this.f22902xoxXI;
        String str2 = null;
        if (str == null) {
            IIX0o.XOxIOxOx("DIGITAL_DIR");
            str = null;
        }
        sb.append(str);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(this.f22870XoX);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(this.f22843IoOoo);
        sb.append("/am.");
        sb.append(this.f22876oI0IIXIo);
        Bitmap bitmap = ImageUtils.getBitmap(assets.open(sb.toString()));
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        AssetManager assets2 = this.f22845O00XxXI.getResources().getAssets();
        StringBuilder sb2 = new StringBuilder();
        String str3 = this.f22902xoxXI;
        if (str3 == null) {
            IIX0o.XOxIOxOx("DIGITAL_DIR");
            str3 = null;
        }
        sb2.append(str3);
        sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb2.append(this.f22870XoX);
        sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb2.append(this.f22843IoOoo);
        sb2.append("/am.");
        sb2.append(this.f22876oI0IIXIo);
        InputStream open = assets2.open(sb2.toString());
        try {
            IIX0o.ooOOo0oXI(open);
            byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
            kotlin.io.II0xO0.oIX0oI(open, null);
            AssetManager assets3 = this.f22845O00XxXI.getResources().getAssets();
            StringBuilder sb3 = new StringBuilder();
            String str4 = this.f22902xoxXI;
            if (str4 == null) {
                IIX0o.XOxIOxOx("DIGITAL_DIR");
                str4 = null;
            }
            sb3.append(str4);
            sb3.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb3.append(this.f22870XoX);
            sb3.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb3.append(this.f22843IoOoo);
            sb3.append("/pm.");
            sb3.append(this.f22876oI0IIXIo);
            open = assets3.open(sb3.toString());
            try {
                IIX0o.ooOOo0oXI(open);
                byte[] x0xO0oo3 = kotlin.io.oIX0oI.x0xO0oo(open);
                kotlin.io.II0xO0.oIX0oI(open, null);
                C0962oIX0oI c0962oIX0oI = f22830XI0oooXX;
                arrayList2.add(C0962oIX0oI.xoIox(c0962oIX0oI, this.f22876oI0IIXIo, x0xO0oo2, width, 0, 0, false, this.f22867XX0xXo, height, 56, null));
                arrayList2.add(C0962oIX0oI.xoIox(c0962oIX0oI, this.f22876oI0IIXIo, x0xO0oo3, width, 0, 0, false, this.f22867XX0xXo, height, 56, null));
                arrayList.add(new Element(12, oOXoIIIo.I0Io.I0Io(this.f22867XX0xXo), width, height, 9, this.f22853OxI, (int) this.f22894xI, (int) this.f22883oo0xXOI0I, 0, 0, 0, (byte[][]) arrayList2.toArray(new byte[0]), SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
                StringBuilder sb4 = new StringBuilder();
                String str5 = this.f22902xoxXI;
                if (str5 == null) {
                    IIX0o.XOxIOxOx("DIGITAL_DIR");
                    str5 = null;
                }
                sb4.append(str5);
                sb4.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb4.append(this.f22870XoX);
                sb4.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb4.append(this.f22892x0xO);
                sb4.append(IOUtils.DIR_SEPARATOR_UNIX);
                Triple xo0x2 = xo0x(this, sb4.toString(), 0, 2, null);
                int intValue = ((Number) xo0x2.getFirst()).intValue();
                int intValue2 = ((Number) xo0x2.getSecond()).intValue();
                byte[][] bArr = (byte[][]) ((Collection) xo0x2.getThird()).toArray(new byte[0]);
                arrayList.add(new Element(9, oOXoIIIo.I0Io.I0Io(this.f22867XX0xXo), intValue, intValue2, 9, this.f22853OxI, (int) this.f22882oo, (int) this.f22842IoOoX, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
                arrayList.add(new Element(10, oOXoIIIo.I0Io.I0Io(this.f22867XX0xXo), intValue, intValue2, 9, this.f22853OxI, (int) this.f22879oOXoIIIo, (int) this.f22857X00IoxXI, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
                if (this.f22852Oo != 0) {
                    StringBuilder sb5 = new StringBuilder();
                    String str6 = this.f22902xoxXI;
                    if (str6 == null) {
                        IIX0o.XOxIOxOx("DIGITAL_DIR");
                        str6 = null;
                    }
                    sb5.append(str6);
                    sb5.append(IOUtils.DIR_SEPARATOR_UNIX);
                    sb5.append(this.f22870XoX);
                    sb5.append(IOUtils.DIR_SEPARATOR_UNIX);
                    sb5.append(this.f22892x0xO);
                    i = 0;
                    XX0xXo(sb5.toString(), 20, (int) this.f22839IO, (int) this.f22895xII, arrayList);
                } else {
                    i = 0;
                }
                StringBuilder sb6 = new StringBuilder();
                String str7 = this.f22902xoxXI;
                if (str7 == null) {
                    IIX0o.XOxIOxOx("DIGITAL_DIR");
                    str7 = null;
                }
                sb6.append(str7);
                sb6.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb6.append(this.f22870XoX);
                sb6.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb6.append(this.f22900xoIxX);
                sb6.append(IOUtils.DIR_SEPARATOR_UNIX);
                Triple xo0x3 = xo0x(this, sb6.toString(), i, 2, null);
                int intValue3 = ((Number) xo0x3.getFirst()).intValue();
                int intValue4 = ((Number) xo0x3.getSecond()).intValue();
                byte[][] bArr2 = (byte[][]) ((Collection) xo0x3.getThird()).toArray(new byte[i]);
                arrayList.add(new Element(7, oOXoIIIo.I0Io.I0Io(this.f22867XX0xXo), intValue3, intValue4, 9, this.f22853OxI, (int) this.f22891x0o, (int) this.f22864XOxIOxOx, 0, 0, 0, bArr2, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
                arrayList.add(new Element(8, oOXoIIIo.I0Io.I0Io(this.f22867XX0xXo), intValue3, intValue4, 9, this.f22853OxI, (int) this.f22848OI0, (int) this.f22841Io, 0, 0, 0, bArr2, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
                if (this.f22852Oo != 0) {
                    StringBuilder sb7 = new StringBuilder();
                    String str8 = this.f22902xoxXI;
                    if (str8 == null) {
                        IIX0o.XOxIOxOx("DIGITAL_DIR");
                        str8 = null;
                    }
                    sb7.append(str8);
                    sb7.append(IOUtils.DIR_SEPARATOR_UNIX);
                    sb7.append(this.f22870XoX);
                    sb7.append(IOUtils.DIR_SEPARATOR_UNIX);
                    sb7.append(this.f22900xoIxX);
                    XX0xXo(sb7.toString(), 21, (int) this.f22873o0, (int) this.f22865XX, arrayList);
                }
                StringBuilder sb8 = new StringBuilder();
                String str9 = this.f22902xoxXI;
                if (str9 == null) {
                    IIX0o.XOxIOxOx("DIGITAL_DIR");
                } else {
                    str2 = str9;
                }
                sb8.append(str2);
                sb8.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb8.append(this.f22870XoX);
                sb8.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb8.append(this.f22850OO0x0xX);
                sb8.append(IOUtils.DIR_SEPARATOR_UNIX);
                Triple<Integer, Integer, ArrayList<byte[]>> oxXx0IX2 = oxXx0IX(sb8.toString(), 6);
                arrayList.add(new Element(13, oOXoIIIo.I0Io.I0Io(this.f22867XX0xXo), oxXx0IX2.getFirst().intValue(), oxXx0IX2.getSecond().intValue(), 9, this.f22853OxI, (int) this.f22834I0oOoX, (int) this.f22889oxxXoxO, 0, 0, 0, (byte[][]) oxXx0IX2.getThird().toArray(new byte[i]), SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
            } finally {
            }
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }

    public final void O0IxXx(float f) {
        this.f22865XX = f;
    }

    public final boolean O0X() {
        return ProductManager.f20544oIX0oI.OXooXo();
    }

    public final int O0Xx() {
        return this.f22887oxXx0IX;
    }

    @OOXIXo
    public final ImageView O0xOxO() {
        ImageView imageView = this.f22836II0xO0;
        if (imageView != null) {
            return imageView;
        }
        IIX0o.XOxIOxOx("customizeDialBg");
        return null;
    }

    public final void O0xxXxI(float f) {
        this.f22847O0xOxO = f;
    }

    public final Bitmap OI0(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight() + 1, Bitmap.Config.RGB_565);
        IIX0o.oO(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public final void OIOoIIOIx(@OOXIXo ViewGroup viewGroup) {
        IIX0o.x0xO0oo(viewGroup, "<set-?>");
        this.f22888oxoX = viewGroup;
    }

    public final void OIx00oxx(int i) {
        this.f22890x0XOIxOo = i;
    }

    public final int OO() {
        return this.f22898xo0x;
    }

    public final void OO0(float f) {
        this.f22880oOoXoXO = f;
    }

    public final int OO0x0xX() {
        return this.f22852Oo;
    }

    public final void OOOI(int i) {
        this.f22901xoXoI = i;
    }

    public final Bitmap OOXIXo(boolean z, int i, Bitmap bitmap) {
        Bitmap bitmap$default;
        Bitmap bitmap2;
        Bitmap roundCorner;
        float f;
        float f2;
        Canvas canvas;
        if (this.f22851OOXIXo) {
            bitmap$default = f22830XI0oooXX.ooOOo0oXI(O0xOxO());
        } else {
            Drawable drawable = O0xOxO().getDrawable();
            IIX0o.oO(drawable, "getDrawable(...)");
            bitmap$default = DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null);
        }
        float width = this.f22884ooOOo0oXI / bitmap$default.getWidth();
        float height = (this.f22890x0XOIxOo - this.f22852Oo) / bitmap$default.getHeight();
        LogUtils.d("test getBgBitmap bgBitmap = " + bitmap$default.getWidth() + " - " + bitmap$default.getHeight() + "; " + width + " - " + height);
        if (bitmap == null) {
            bitmap2 = ImageUtils.scale(bitmap$default, width, height);
        } else {
            bitmap2 = bitmap;
        }
        if (this.f22851OOXIXo) {
            roundCorner = ImageUtils.toRound(bitmap2, this.f22874o00, this.f22845O00XxXI.getResources().getColor(i));
        } else {
            roundCorner = ImageUtils.toRoundCorner(bitmap2, this.f22880oOoXoXO, 0.0f, this.f22845O00XxXI.getResources().getColor(i));
        }
        Bitmap bitmap3 = roundCorner;
        if (!this.f22851OOXIXo) {
            f = this.f22884ooOOo0oXI / O0xOxO().getWidth();
            f2 = (this.f22890x0XOIxOo - this.f22852Oo) / O0xOxO().getHeight();
        } else {
            f = width;
            f2 = height;
        }
        Canvas canvas2 = new Canvas(bitmap3);
        StringBuilder sb = new StringBuilder();
        String str = this.f22832I0X0x0oIo;
        if (str == null) {
            IIX0o.XOxIOxOx("STEP_DIR");
            str = null;
        }
        sb.append(str);
        sb.append("/step_0.png");
        String sb2 = sb.toString();
        ViewGroup OxI2 = OxI();
        StringBuilder sb3 = new StringBuilder();
        String str2 = this.f22846O0Xx;
        if (str2 == null) {
            IIX0o.XOxIOxOx("VALUE_DIR");
            str2 = null;
        }
        sb3.append(str2);
        sb3.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb3.append(this.f22885ooXIXxIX);
        sb3.append(IOUtils.DIR_SEPARATOR_UNIX);
        Pair<Float, Float> II0xO02 = II0xO0(sb2, OxI2, sb3.toString(), "18564", canvas2, f, f2, z);
        float floatValue = II0xO02.component1().floatValue();
        float floatValue2 = II0xO02.component2().floatValue();
        this.f22847O0xOxO = floatValue;
        this.f22858X0IIOO = floatValue2;
        StringBuilder sb4 = new StringBuilder();
        String str3 = this.f22881oX;
        if (str3 == null) {
            IIX0o.XOxIOxOx("CALORIES_DIR");
            str3 = null;
        }
        sb4.append(str3);
        sb4.append("/calories_0.png");
        String sb5 = sb4.toString();
        ViewGroup IIXOooo2 = IIXOooo();
        StringBuilder sb6 = new StringBuilder();
        String str4 = this.f22846O0Xx;
        if (str4 == null) {
            IIX0o.XOxIOxOx("VALUE_DIR");
            str4 = null;
        }
        sb6.append(str4);
        sb6.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb6.append(this.f22885ooXIXxIX);
        sb6.append(IOUtils.DIR_SEPARATOR_UNIX);
        Pair<Float, Float> II0xO03 = II0xO0(sb5, IIXOooo2, sb6.toString(), "50", canvas2, f, f2, z);
        float floatValue3 = II0xO03.component1().floatValue();
        float floatValue4 = II0xO03.component2().floatValue();
        this.f22860XI0IXoo = floatValue3;
        this.f22862XIxXXX0x0 = floatValue4;
        StringBuilder sb7 = new StringBuilder();
        String str5 = this.f22868Xo0;
        if (str5 == null) {
            IIX0o.XOxIOxOx("DISTANCE_DIR");
            str5 = null;
        }
        sb7.append(str5);
        sb7.append("/distance_0.png");
        String sb8 = sb7.toString();
        ViewGroup xoXoI2 = xoXoI();
        StringBuilder sb9 = new StringBuilder();
        String str6 = this.f22846O0Xx;
        if (str6 == null) {
            IIX0o.XOxIOxOx("VALUE_DIR");
            str6 = null;
        }
        sb9.append(str6);
        sb9.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb9.append(this.f22885ooXIXxIX);
        sb9.append(IOUtils.DIR_SEPARATOR_UNIX);
        Pair<Float, Float> II0xO04 = II0xO0(sb8, xoXoI2, sb9.toString(), "6", canvas2, f, f2, z);
        float floatValue5 = II0xO04.component1().floatValue();
        float floatValue6 = II0xO04.component2().floatValue();
        this.f22905xxX = floatValue5;
        this.f22872XxX0x0xxx = floatValue6;
        StringBuilder sb10 = new StringBuilder();
        String str7 = this.f22869XoI0Ixx0;
        if (str7 == null) {
            IIX0o.XOxIOxOx("HEART_RATE_DIR");
            str7 = null;
        }
        sb10.append(str7);
        sb10.append("/heart_rate_0.png");
        String sb11 = sb10.toString();
        ViewGroup o002 = o00();
        StringBuilder sb12 = new StringBuilder();
        String str8 = this.f22846O0Xx;
        if (str8 == null) {
            IIX0o.XOxIOxOx("VALUE_DIR");
            str8 = null;
        }
        sb12.append(str8);
        sb12.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb12.append(this.f22885ooXIXxIX);
        sb12.append(IOUtils.DIR_SEPARATOR_UNIX);
        Pair<Float, Float> II0xO05 = II0xO0(sb11, o002, sb12.toString(), "90", canvas2, f, f2, z);
        float floatValue7 = II0xO05.component1().floatValue();
        float floatValue8 = II0xO05.component2().floatValue();
        this.f22897xXxxox0I = floatValue7;
        this.f22837IIX0o = floatValue8;
        if (XI0oooXX().getVisibility() == 0) {
            StringBuilder sb13 = new StringBuilder();
            String str9 = this.f22902xoxXI;
            if (str9 == null) {
                IIX0o.XOxIOxOx("DIGITAL_DIR");
                str9 = null;
            }
            sb13.append(str9);
            sb13.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb13.append(this.f22870XoX);
            sb13.append(IOUtils.DIR_SEPARATOR_UNIX);
            I0Io(sb13.toString(), f, f2, canvas2, z);
        }
        if (OOXIxO0().getVisibility() == 0) {
            canvas = canvas2;
            XoI0Ixx0(OOXIxO0(), z, canvas);
        } else {
            canvas = canvas2;
        }
        if (IIxOXoOo0().getVisibility() == 0) {
            XoI0Ixx0(IIxOXoOo0(), true, canvas);
        }
        if (i == R.color.dark) {
            IIX0o.ooOOo0oXI(bitmap3);
            return OI0(bitmap3);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap3.getWidth(), bitmap3.getHeight() + 1, Bitmap.Config.ARGB_8888);
        IIX0o.oO(createBitmap, "createBitmap(...)");
        new Canvas(createBitmap).drawBitmap(bitmap3, 0.0f, 0.0f, new Paint());
        return createBitmap;
    }

    @OOXIXo
    public final ImageView OOXIxO0() {
        ImageView imageView = this.f22835II0XooXoX;
        if (imageView != null) {
            return imageView;
        }
        IIX0o.XOxIOxOx("timePointView");
        return null;
    }

    public final void OX(@OOXIXo List<String> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.f22875o0xxxXXxX = list;
    }

    public final float OX00O0xII() {
        return this.f22899xoIox;
    }

    public final float Oo() {
        return this.f22862XIxXXX0x0;
    }

    public final void OoO(@OOXIXo ViewGroup viewGroup) {
        IIX0o.x0xO0oo(viewGroup, "<set-?>");
        this.f22863XO = viewGroup;
    }

    public final void OooI(int i) {
        this.f22898xo0x = i;
    }

    public final void Ox0O(float f) {
        this.f22894xI = f;
    }

    @OOXIXo
    public final ViewGroup OxI() {
        ViewGroup viewGroup = this.f22831I0Io;
        if (viewGroup != null) {
            return viewGroup;
        }
        IIX0o.XOxIOxOx("controlViewStep");
        return null;
    }

    public final void OxXXx0X(int i) {
        this.f22838IIXOooo = i;
    }

    public final void Oxx(int i) {
        this.f22856OxxIIOOXO = i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0016. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00db A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bb A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x007f A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int Oxx0IOOO() {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.watchface.oIX0oI.Oxx0IOOO():int");
    }

    public final void Oxx0xo(ArrayList<Element> arrayList) {
        StringBuilder sb = new StringBuilder();
        String str = this.f22846O0Xx;
        if (str == null) {
            IIX0o.XOxIOxOx("VALUE_DIR");
            str = null;
        }
        sb.append(str);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(this.f22885ooXIXxIX);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        Triple<Integer, Integer, ArrayList<byte[]>> xXOx2 = xXOx(sb.toString(), this.f22855Oxx0xo);
        int intValue = xXOx2.getFirst().intValue();
        int intValue2 = xXOx2.getSecond().intValue();
        byte[][] bArr = (byte[][]) xXOx2.getThird().toArray(new byte[0]);
        if (OxI().getVisibility() == 0) {
            arrayList.add(new Element(14, 1, intValue, intValue2, this.f22838IIXOooo | this.f22901xoXoI, this.f22853OxI, (int) this.f22847O0xOxO, (int) this.f22858X0IIOO, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
        }
        if (o00().getVisibility() == 0) {
            arrayList.add(new Element(15, 1, intValue, intValue2, this.f22838IIXOooo | this.f22901xoXoI, this.f22853OxI, (int) this.f22897xXxxox0I, (int) this.f22837IIX0o, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
        }
        if (IIXOooo().getVisibility() == 0) {
            arrayList.add(new Element(16, 1, intValue, intValue2, this.f22838IIXOooo | this.f22901xoXoI, this.f22853OxI, (int) this.f22860XI0IXoo, (int) this.f22862XIxXXX0x0, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
        }
        if (xoXoI().getVisibility() == 0) {
            Element element = new Element(17, 1, intValue, intValue2, this.f22838IIXOooo | this.f22901xoXoI, this.f22853OxI, (int) this.f22905xxX, (int) this.f22872XxX0x0xxx, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null);
            LogUtils.d("test distanceValueCenterX=" + this.f22905xxX + "  distanceValueCenterY=" + this.f22872XxX0x0xxx);
            arrayList.add(element);
        }
    }

    public final int OxxIIOOXO() {
        return this.f22855Oxx0xo;
    }

    public final float X00IoxXI() {
        return this.f22834I0oOoX;
    }

    public final float X0IIOO() {
        return this.f22848OI0;
    }

    public final byte[] X0o0xo(String str, Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(allocate);
        byte[] array = allocate.array();
        C0962oIX0oI c0962oIX0oI = f22830XI0oooXX;
        IIX0o.ooOOo0oXI(array);
        return C0962oIX0oI.xoIox(c0962oIX0oI, str, array, bitmap.getWidth(), 16, 0, false, false, 0, 192, null);
    }

    public final void X0xII0I(float f) {
        this.f22839IO = f;
    }

    public final void X0xxXX0(float f) {
        this.f22895xII = f;
    }

    public final void XI(float f) {
        this.f22905xxX = f;
    }

    public final float XI0IXoo() {
        return this.f22841Io;
    }

    @OOXIXo
    public final ViewGroup XI0oooXX() {
        ViewGroup viewGroup = this.f22854Oxx0IOOO;
        if (viewGroup != null) {
            return viewGroup;
        }
        IIX0o.XOxIOxOx("timeDigitalView");
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01f4, code lost:
    
        if (r1.equals("A8") == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01fd, code lost:
    
        if (r1.equals("A7") == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0217, code lost:
    
        if (r1.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_A8_ULTRA_PRO) == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0231, code lost:
    
        if (r1.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_SF15GUC) == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0041, code lost:
    
        if (r1.equals("F12Pro") == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0083, code lost:
    
        if (r1.equals("AM02J") == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01bc, code lost:
    
        r16.f22896xXOx = "dial_customize_360";
        r16.f22884ooOOo0oXI = 368;
        r16.f22890x0XOIxOo = 448;
        r16.f22878oO = 250;
        r16.f22893x0xO0oo = 304;
        r16.f22880oOoXoXO = 40.0f;
        r16.f22851OOXIXo = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x008d, code lost:
    
        if (r1.equals("AM01J") == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0097, code lost:
    
        if (r1.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_HW01) == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x016c, code lost:
    
        r16.f22896xXOx = "dial_customize_360";
        r16.f22884ooOOo0oXI = 360;
        r16.f22890x0XOIxOo = 360;
        r16.f22878oO = 224;
        r16.f22893x0xO0oo = 224;
        r16.f22851OOXIXo = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x021a, code lost:
    
        r16.f22896xXOx = "dial_customize_320";
        r16.f22884ooOOo0oXI = com.garmin.fit.X0xOO.f13583O0o0;
        r16.f22890x0XOIxOo = 386;
        r16.f22878oO = 200;
        r16.f22893x0xO0oo = 240;
        r16.f22851OOXIXo = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a1, code lost:
    
        if (r1.equals("F13B") == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0200, code lost:
    
        r16.f22896xXOx = "dial_customize_240";
        r16.f22884ooOOo0oXI = 240;
        r16.f22890x0XOIxOo = 286;
        r16.f22878oO = 150;
        r16.f22893x0xO0oo = 174;
        r16.f22851OOXIXo = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c6, code lost:
    
        if (r1.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_AM22) == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0234, code lost:
    
        r16.f22896xXOx = "dial_customize_454";
        r16.f22884ooOOo0oXI = 466;
        r16.f22890x0XOIxOo = 466;
        r16.f22878oO = 280;
        r16.f22893x0xO0oo = 280;
        r16.f22851OOXIXo = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x010c, code lost:
    
        if (r1.equals("AM05") == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0116, code lost:
    
        if (r1.equals("AM01") == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0120, code lost:
    
        if (r1.equals("V61") == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x015e, code lost:
    
        if (r1.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_FT5) == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0168, code lost:
    
        if (r1.equals("FC2") == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01b8, code lost:
    
        if (r1.equals("F12") == false) goto L100;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void XIXIX() {
        /*
            Method dump skipped, instructions count: 1024
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.watchface.oIX0oI.XIXIX():void");
    }

    public final void XIXIxO(@OOXIXo ViewGroup viewGroup) {
        IIX0o.x0xO0oo(viewGroup, "<set-?>");
        this.f22859X0o0xo = viewGroup;
    }

    public final int XIo0oOXIx() {
        return this.f22884ooOOo0oXI;
    }

    public final float XIxXXX0x0() {
        return this.f22891x0o;
    }

    @OOXIXo
    public final byte[] XO() {
        ArrayList<Element> arrayList = new ArrayList<>();
        if (O0X()) {
            arrayList.add(new Element(1, 0, this.f22878oO, this.f22893x0xO0oo, 0, this.f22853OxI, 0, 0, 0, 0, 0, new byte[][]{I0oOIX()}, 1794, null));
            BleCache bleCache = BleCache.INSTANCE;
            if (IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_SIFLI) && !this.f22875o0xxxXXxX.isEmpty()) {
                x0XOIxOo(arrayList);
            } else {
                arrayList.add(new Element(2, 0, this.f22884ooOOo0oXI, this.f22890x0XOIxOo + 1, 9, this.f22853OxI, 0, 0, 0, 0, 0, new byte[][]{xoIox()}, 1794, null));
            }
            Oxx0xo(arrayList);
            if (XI0oooXX().getVisibility() == 0) {
                ox(arrayList);
            }
            if (OOXIxO0().getVisibility() == 0) {
                if (IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL)) {
                    oX(3, this.f22861XIo0oOXIx, arrayList);
                    oX(4, this.f22844Ioxxx, arrayList);
                    oX(5, this.f22903xxIO, arrayList);
                } else {
                    Xo0(3, this.f22861XIo0oOXIx, arrayList);
                    Xo0(4, this.f22844Ioxxx, arrayList);
                    Xo0(5, this.f22903xxIO, arrayList);
                }
            }
        } else {
            arrayList.add(new Element(1, 0, this.f22878oO, this.f22893x0xO0oo, this.f22838IIXOooo | this.f22901xoXoI, 0, this.f22884ooOOo0oXI / 2, (this.f22890x0XOIxOo / 2) + 2, 0, 0, 0, new byte[][]{I0oOIX()}, 1826, null));
            byte[] xoIox2 = xoIox();
            int i = this.f22884ooOOo0oXI;
            int i2 = this.f22890x0XOIxOo;
            arrayList.add(new Element(2, 0, i, i2, this.f22838IIXOooo | this.f22901xoXoI, 0, i / 2, i2 / 2, 0, 0, 0, new byte[][]{xoIox2}, 1826, null));
            IXxxXO(arrayList);
            if (XI0oooXX().getVisibility() == 0) {
                O00XxXI(arrayList);
            }
            if (OOXIxO0().getVisibility() == 0) {
                I0X0x0oIo(3, this.f22861XIo0oOXIx, arrayList);
                I0X0x0oIo(4, this.f22844Ioxxx, arrayList);
                I0X0x0oIo(5, this.f22903xxIO, arrayList);
            }
        }
        Iterator<Element> it = arrayList.iterator();
        while (it.hasNext()) {
            LogUtils.d("customize dial length: " + ((byte[]) ArraysKt___ArraysKt.XXOXXx(it.next().getImageBuffers())).length + " KB");
        }
        byte[] build = WatchFaceBuilder.INSTANCE.build((Element[]) arrayList.toArray(new Element[0]), this.f22856OxxIIOOXO);
        LogUtils.d("customize dial bytes size  " + build.length);
        return build;
    }

    public final void XO0o(@OOXIXo ImageView imageView) {
        IIX0o.x0xO0oo(imageView, "<set-?>");
        this.f22835II0XooXoX = imageView;
    }

    @OOXIXo
    public final String XOxIOxOx() {
        return this.f22876oI0IIXIo;
    }

    public final void XOxxooXI(float f) {
        this.f22889oxxXoxO = f;
    }

    public final int XX() {
        return this.f22853OxI;
    }

    public final void XX0xXo(String str, int i, int i2, int i3, ArrayList<Element> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Bitmap bitmap = ImageUtils.getBitmap(this.f22845O00XxXI.getResources().getAssets().open(str + "/symbol." + this.f22876oI0IIXIo));
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        C0962oIX0oI c0962oIX0oI = f22830XI0oooXX;
        String str2 = this.f22876oI0IIXIo;
        InputStream open = this.f22845O00XxXI.getResources().getAssets().open(str + "/symbol." + this.f22876oI0IIXIo);
        try {
            IIX0o.ooOOo0oXI(open);
            byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
            kotlin.io.II0xO0.oIX0oI(open, null);
            arrayList2.add(C0962oIX0oI.xoIox(c0962oIX0oI, str2, x0xO0oo2, width, 0, 0, false, this.f22867XX0xXo, height, 56, null));
            arrayList.add(new Element(i, oOXoIIIo.I0Io.I0Io(this.f22867XX0xXo), width, height, 9, this.f22853OxI, i2, i3, 0, 0, 0, (byte[][]) arrayList2.toArray(new byte[0]), SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
        } finally {
        }
    }

    public final void XXXI(float f) {
        this.f22837IIX0o = f;
    }

    public final void XXoOx0(@OOXIXo ImageView imageView) {
        IIX0o.x0xO0oo(imageView, "<set-?>");
        this.f22836II0xO0 = imageView;
    }

    public final void Xo0(int i, String str, ArrayList<Element> arrayList) {
        StringBuilder sb = new StringBuilder();
        String str2 = this.f22849OO;
        if (str2 == null) {
            IIX0o.XOxIOxOx("POINTER_DIR");
            str2 = null;
        }
        sb.append(str2);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(str);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(this.f22887oxXx0IX);
        sb.append('.');
        sb.append(this.f22876oI0IIXIo);
        String sb2 = sb.toString();
        InputStream open = this.f22845O00XxXI.getResources().getAssets().open(sb2);
        try {
            IIX0o.ooOOo0oXI(open);
            byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
            kotlin.io.II0xO0.oIX0oI(open, null);
            File file = new File(IXxxXO.IoOoX(X00IoxXI.oIX0oI.f3233oIX0oI), sb2);
            FileIOUtils.writeFileFromBytesByStream(file, x0xO0oo2);
            ArrayList arrayList2 = new ArrayList();
            Bitmap bitmap = ImageUtils.getBitmap(x0xO0oo2, 0);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            byte[] oxoX2 = C0962oIX0oI.oxoX(f22830XI0oooXX, file, false, true, 2, null);
            if (oxoX2 != null) {
                arrayList2.add(oxoX2);
            }
            arrayList.add(new Element(i, 1, width, height, 9, this.f22853OxI, this.f22884ooOOo0oXI / 2, this.f22890x0XOIxOo / 2, 0, height - (bitmap.getHeight() / 2), width / 2, (byte[][]) arrayList2.toArray(new byte[0]), 256, null));
        } finally {
        }
    }

    public final void XoI0Ixx0(ImageView imageView, boolean z, Canvas canvas) {
        Bitmap bitmap$default;
        Bitmap roundCorner;
        if (this.f22851OOXIXo) {
            bitmap$default = f22830XI0oooXX.ooOOo0oXI(imageView);
        } else {
            Drawable drawable = imageView.getDrawable();
            IIX0o.oO(drawable, "getDrawable(...)");
            bitmap$default = DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null);
        }
        Bitmap scale = ImageUtils.scale(bitmap$default, this.f22884ooOOo0oXI / bitmap$default.getWidth(), (this.f22890x0XOIxOo - this.f22852Oo) / bitmap$default.getHeight());
        if (this.f22851OOXIXo) {
            roundCorner = ImageUtils.toRound(scale, 0, 0);
        } else {
            roundCorner = ImageUtils.toRoundCorner(scale, this.f22880oOoXoXO);
        }
        if (z) {
            canvas.drawBitmap(roundCorner, 0.0f, 0.0f, (Paint) null);
        }
    }

    public final void XoIxOXIXo(boolean z) {
        this.f22851OOXIXo = z;
    }

    @OOXIXo
    public final View XoX() {
        View view = this.f22886ox;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("mWatchFaceView");
        return null;
    }

    public final int Xx000oIo() {
        return this.f22870XoX;
    }

    public final float XxX0x0xxx() {
        return this.f22873o0;
    }

    public final float o0() {
        return this.f22837IIX0o;
    }

    @OOXIXo
    public final ViewGroup o00() {
        ViewGroup viewGroup = this.f22888oxoX;
        if (viewGroup != null) {
            return viewGroup;
        }
        IIX0o.XOxIOxOx("controlViewHr");
        return null;
    }

    public final void o0IXXIx(int i) {
        this.f22887oxXx0IX = i;
    }

    public final void o0oIxOo(int i) {
        this.f22855Oxx0xo = i;
    }

    public final void o0xxxXXxX(String str, int i, int i2, int i3, ArrayList<Element> arrayList) {
        String str2 = str + "/symbol." + this.f22876oI0IIXIo;
        ArrayList arrayList2 = new ArrayList();
        Bitmap bitmap = ImageUtils.getBitmap(this.f22845O00XxXI.getResources().getAssets().open(str2));
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        InputStream open = this.f22845O00XxXI.getResources().getAssets().open(str2);
        try {
            IIX0o.ooOOo0oXI(open);
            byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
            kotlin.io.II0xO0.oIX0oI(open, null);
            File file = new File(I0(), str2);
            FileIOUtils.writeFileFromBytesByStream(file, x0xO0oo2);
            byte[] oxoX2 = C0962oIX0oI.oxoX(f22830XI0oooXX, file, false, false, 6, null);
            if (oxoX2 != null) {
                arrayList2.add(oxoX2);
            }
            arrayList.add(new Element(i, 1, width, height, 9, this.f22853OxI, i2, i3, 0, 0, 0, (byte[][]) arrayList2.toArray(new byte[0]), SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
        } finally {
        }
    }

    public final void oI(float f) {
        this.f22864XOxIOxOx = f;
    }

    public final int oI0IIXIo() {
        return this.f22840IXxxXO;
    }

    public final void oIIxXoo(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f22876oI0IIXIo = str;
    }

    public final int oO() {
        return this.f22874o00;
    }

    public final float oOXoIIIo() {
        return this.f22895xII;
    }

    public final boolean oOo() {
        return this.f22851OOXIXo;
    }

    public final void oOoIIO0(float f) {
        this.f22841Io = f;
    }

    public final void oX(int i, String str, ArrayList<Element> arrayList) {
        StringBuilder sb = new StringBuilder();
        String str2 = this.f22849OO;
        if (str2 == null) {
            IIX0o.XOxIOxOx("POINTER_DIR");
            str2 = null;
        }
        sb.append(str2);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(str);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(this.f22887oxXx0IX);
        sb.append('.');
        sb.append(this.f22876oI0IIXIo);
        String sb2 = sb.toString();
        ArrayList arrayList2 = new ArrayList();
        Bitmap bitmap = ImageUtils.getBitmap(this.f22845O00XxXI.getResources().getAssets().open(sb2));
        int width = bitmap.getWidth();
        int height = (int) (bitmap.getHeight() * 0.6f);
        C0962oIX0oI c0962oIX0oI = f22830XI0oooXX;
        String str3 = this.f22876oI0IIXIo;
        InputStream open = this.f22845O00XxXI.getResources().getAssets().open(sb2);
        try {
            IIX0o.ooOOo0oXI(open);
            byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
            kotlin.io.II0xO0.oIX0oI(open, null);
            arrayList2.add(C0962oIX0oI.xoIox(c0962oIX0oI, str3, x0xO0oo2, width, 0, 0, false, true, height, 56, null));
            arrayList.add(new Element(i, 1, width, height, 9, 1, this.f22884ooOOo0oXI / 2, this.f22890x0XOIxOo / 2, 0, height - (bitmap.getHeight() / 2), width / 2, (byte[][]) arrayList2.toArray(new byte[0]), 256, null));
        } finally {
        }
    }

    public final void oX0I0O(@OOXIXo ImageView imageView) {
        IIX0o.x0xO0oo(imageView, "<set-?>");
        this.f22904xxIXOIIO = imageView;
    }

    public final void oX0ooo0I0(@OOXIXo Bitmap bitmap) {
        Bitmap roundCorner;
        IIX0o.x0xO0oo(bitmap, "bitmap");
        Bitmap II0xO02 = f22830XI0oooXX.II0xO0(bitmap, O0xOxO().getMeasuredWidth(), O0xOxO().getHeight());
        ImageView O0xOxO2 = O0xOxO();
        if (this.f22851OOXIXo) {
            roundCorner = ImageUtils.toRound(II0xO02);
        } else {
            roundCorner = ImageUtils.toRoundCorner(II0xO02, this.f22880oOoXoXO);
        }
        O0xOxO2.setImageBitmap(roundCorner);
    }

    public void oXIO0o0XI() {
        View layoutId2View = ViewUtils.layoutId2View(IIX0());
        IIX0o.oO(layoutId2View, "layoutId2View(...)");
        oXIoO(layoutId2View);
        View findViewById = XoX().findViewById(R.id.customizeDialBg);
        IIX0o.oO(findViewById, "findViewById(...)");
        XXoOx0((ImageView) findViewById);
        View findViewById2 = XoX().findViewById(R.id.controlViewStep);
        IIX0o.oO(findViewById2, "findViewById(...)");
        x0OIX00oO((ViewGroup) findViewById2);
        View findViewById3 = XoX().findViewById(R.id.controlViewHr);
        IIX0o.oO(findViewById3, "findViewById(...)");
        OIOoIIOIx((ViewGroup) findViewById3);
        View findViewById4 = XoX().findViewById(R.id.controlViewCa);
        IIX0o.oO(findViewById4, "findViewById(...)");
        XIXIxO((ViewGroup) findViewById4);
        View findViewById5 = XoX().findViewById(R.id.controlViewDis);
        IIX0o.oO(findViewById5, "findViewById(...)");
        OoO((ViewGroup) findViewById5);
        View findViewById6 = XoX().findViewById(R.id.timeDigitalView);
        IIX0o.oO(findViewById6, "findViewById(...)");
        IxX00((ViewGroup) findViewById6);
        View findViewById7 = XoX().findViewById(R.id.timePointView);
        IIX0o.oO(findViewById7, "findViewById(...)");
        XO0o((ImageView) findViewById7);
        View findViewById8 = XoX().findViewById(R.id.timeScaleView);
        IIX0o.oO(findViewById8, "findViewById(...)");
        oX0I0O((ImageView) findViewById8);
    }

    public final void oXIoO(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.f22886ox = view;
    }

    public final void oXX0IoI(float f) {
        this.f22897xXxxox0I = f;
    }

    public final void oXxOI0oIx(float f) {
        this.f22834I0oOoX = f;
    }

    public final float oo() {
        return this.f22857X00IoxXI;
    }

    public final void oo00(float f) {
        this.f22899xoIox = f;
    }

    public final float oo0xXOI0I() {
        return this.f22871Xx000oIo;
    }

    public final Triple<Integer, Integer, ArrayList<byte[]>> ooOOo0oXI(List<String> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        for (String str : list) {
            Bitmap bitmap = ImageUtils.getBitmap(str);
            if (i == 0) {
                i = bitmap.getWidth();
                i2 = bitmap.getHeight();
            }
            File file = new File(str + ".png");
            ImageUtils.save(oOoXoXO(this, false, 0, bitmap, 2, null), file, Bitmap.CompressFormat.PNG);
            byte[] oxoX2 = C0962oIX0oI.oxoX(f22830XI0oooXX, file, false, false, 4, null);
            if (oxoX2 != null) {
                arrayList.add(oxoX2);
            }
        }
        return new Triple<>(Integer.valueOf(i), Integer.valueOf(i2), arrayList);
    }

    @OOXIXo
    public final byte[] ooOx() {
        Bitmap roundCorner;
        Bitmap scale = ImageUtils.scale(oOoXoXO(this, true, R.color.transparent, null, 4, null), this.f22878oO / r0.getWidth(), this.f22893x0xO0oo / r0.getHeight());
        if (this.f22851OOXIXo) {
            roundCorner = ImageUtils.toRound(scale, this.f22874o00, this.f22845O00XxXI.getResources().getColor(R.color.transparent));
        } else {
            roundCorner = ImageUtils.toRoundCorner(scale, 30.0f, this.f22874o00, this.f22845O00XxXI.getResources().getColor(R.color.transparent));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        roundCorner.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        IIX0o.oO(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public final float ooXIXxIX() {
        return this.f22842IoOoX;
    }

    public final void ox(ArrayList<Element> arrayList) {
        int i;
        StringBuilder sb = new StringBuilder();
        String str = this.f22902xoxXI;
        String str2 = null;
        if (str == null) {
            IIX0o.XOxIOxOx("DIGITAL_DIR");
            str = null;
        }
        sb.append(str);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(this.f22870XoX);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(this.f22843IoOoo);
        sb.append("/am.");
        sb.append(this.f22876oI0IIXIo);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        String str3 = this.f22902xoxXI;
        if (str3 == null) {
            IIX0o.XOxIOxOx("DIGITAL_DIR");
            str3 = null;
        }
        sb3.append(str3);
        sb3.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb3.append(this.f22870XoX);
        sb3.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb3.append(this.f22843IoOoo);
        sb3.append("/pm.");
        sb3.append(this.f22876oI0IIXIo);
        String sb4 = sb3.toString();
        ArrayList arrayList2 = new ArrayList();
        Bitmap bitmap = ImageUtils.getBitmap(this.f22845O00XxXI.getResources().getAssets().open(sb2));
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        InputStream open = this.f22845O00XxXI.getResources().getAssets().open(sb2);
        try {
            IIX0o.ooOOo0oXI(open);
            byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
            kotlin.io.II0xO0.oIX0oI(open, null);
            open = this.f22845O00XxXI.getResources().getAssets().open(sb4);
            try {
                IIX0o.ooOOo0oXI(open);
                byte[] x0xO0oo3 = kotlin.io.oIX0oI.x0xO0oo(open);
                kotlin.io.II0xO0.oIX0oI(open, null);
                File file = new File(I0(), sb2);
                FileIOUtils.writeFileFromBytesByStream(file, x0xO0oo2);
                File file2 = new File(I0(), sb4);
                FileIOUtils.writeFileFromBytesByStream(file2, x0xO0oo3);
                C0962oIX0oI c0962oIX0oI = f22830XI0oooXX;
                byte[] oxoX2 = C0962oIX0oI.oxoX(c0962oIX0oI, file, false, false, 6, null);
                if (oxoX2 != null) {
                    arrayList2.add(oxoX2);
                }
                byte[] oxoX3 = C0962oIX0oI.oxoX(c0962oIX0oI, file2, false, false, 6, null);
                if (oxoX3 != null) {
                    arrayList2.add(oxoX3);
                }
                arrayList.add(new Element(12, 1, width, height, 9, this.f22853OxI, (int) this.f22894xI, (int) this.f22883oo0xXOI0I, 0, 0, 0, (byte[][]) arrayList2.toArray(new byte[0]), SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
                StringBuilder sb5 = new StringBuilder();
                String str4 = this.f22902xoxXI;
                if (str4 == null) {
                    IIX0o.XOxIOxOx("DIGITAL_DIR");
                    str4 = null;
                }
                sb5.append(str4);
                sb5.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb5.append(this.f22870XoX);
                sb5.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb5.append(this.f22892x0xO);
                sb5.append(IOUtils.DIR_SEPARATOR_UNIX);
                Triple XX02 = XX0(this, sb5.toString(), 0, 2, null);
                int intValue = ((Number) XX02.getFirst()).intValue();
                int intValue2 = ((Number) XX02.getSecond()).intValue();
                byte[][] bArr = (byte[][]) ((Collection) XX02.getThird()).toArray(new byte[0]);
                arrayList.add(new Element(9, 1, intValue, intValue2, 9, this.f22853OxI, (int) this.f22882oo, (int) this.f22842IoOoX, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
                arrayList.add(new Element(10, 1, intValue, intValue2, 9, this.f22853OxI, (int) this.f22879oOXoIIIo, (int) this.f22857X00IoxXI, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
                if (this.f22852Oo != 0) {
                    StringBuilder sb6 = new StringBuilder();
                    String str5 = this.f22902xoxXI;
                    if (str5 == null) {
                        IIX0o.XOxIOxOx("DIGITAL_DIR");
                        str5 = null;
                    }
                    sb6.append(str5);
                    sb6.append(IOUtils.DIR_SEPARATOR_UNIX);
                    sb6.append(this.f22870XoX);
                    sb6.append(IOUtils.DIR_SEPARATOR_UNIX);
                    sb6.append(this.f22892x0xO);
                    i = 0;
                    o0xxxXXxX(sb6.toString(), 20, (int) this.f22839IO, (int) this.f22895xII, arrayList);
                } else {
                    i = 0;
                }
                StringBuilder sb7 = new StringBuilder();
                String str6 = this.f22902xoxXI;
                if (str6 == null) {
                    IIX0o.XOxIOxOx("DIGITAL_DIR");
                    str6 = null;
                }
                sb7.append(str6);
                sb7.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb7.append(this.f22870XoX);
                sb7.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb7.append(this.f22900xoIxX);
                sb7.append(IOUtils.DIR_SEPARATOR_UNIX);
                Triple XX03 = XX0(this, sb7.toString(), i, 2, null);
                int intValue3 = ((Number) XX03.getFirst()).intValue();
                int intValue4 = ((Number) XX03.getSecond()).intValue();
                byte[][] bArr2 = (byte[][]) ((Collection) XX03.getThird()).toArray(new byte[i]);
                arrayList.add(new Element(7, 1, intValue3, intValue4, 9, this.f22853OxI, (int) this.f22891x0o, (int) this.f22864XOxIOxOx, 0, 0, 0, bArr2, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
                arrayList.add(new Element(8, 1, intValue3, intValue4, 9, this.f22853OxI, (int) this.f22848OI0, (int) this.f22841Io, 0, 0, 0, bArr2, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
                if (this.f22852Oo != 0) {
                    StringBuilder sb8 = new StringBuilder();
                    String str7 = this.f22902xoxXI;
                    if (str7 == null) {
                        IIX0o.XOxIOxOx("DIGITAL_DIR");
                        str7 = null;
                    }
                    sb8.append(str7);
                    sb8.append(IOUtils.DIR_SEPARATOR_UNIX);
                    sb8.append(this.f22870XoX);
                    sb8.append(IOUtils.DIR_SEPARATOR_UNIX);
                    sb8.append(this.f22900xoIxX);
                    o0xxxXXxX(sb8.toString(), 21, (int) this.f22873o0, (int) this.f22865XX, arrayList);
                }
                StringBuilder sb9 = new StringBuilder();
                String str8 = this.f22902xoxXI;
                if (str8 == null) {
                    IIX0o.XOxIOxOx("DIGITAL_DIR");
                } else {
                    str2 = str8;
                }
                sb9.append(str2);
                sb9.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb9.append(this.f22870XoX);
                sb9.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb9.append(this.f22850OO0x0xX);
                sb9.append(IOUtils.DIR_SEPARATOR_UNIX);
                Triple<Integer, Integer, ArrayList<byte[]>> xXOx2 = xXOx(sb9.toString(), 6);
                arrayList.add(new Element(13, 1, xXOx2.getFirst().intValue(), xXOx2.getSecond().intValue(), 9, this.f22853OxI, (int) this.f22834I0oOoX, (int) this.f22889oxxXoxO, 0, 0, 0, (byte[][]) xXOx2.getThird().toArray(new byte[i]), SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
            } finally {
            }
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }

    public final void oxIIX0o(int i) {
        this.f22840IXxxXO = i;
    }

    public final void oxOXxoXII(float f) {
        this.f22858X0IIOO = f;
    }

    public final Triple<Integer, Integer, ArrayList<byte[]>> oxXx0IX(String str, int i) {
        int i2;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        if (i >= 0) {
            int i4 = 0;
            i2 = 0;
            while (true) {
                if (i3 == 0) {
                    Bitmap bitmap = ImageUtils.getBitmap(this.f22845O00XxXI.getResources().getAssets().open(str + i4 + '.' + this.f22876oI0IIXIo));
                    int width = bitmap.getWidth();
                    i2 = bitmap.getHeight();
                    i3 = width;
                }
                InputStream open = this.f22845O00XxXI.getResources().getAssets().open(str + i4 + '.' + this.f22876oI0IIXIo);
                try {
                    IIX0o.ooOOo0oXI(open);
                    byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
                    kotlin.io.II0xO0.oIX0oI(open, null);
                    arrayList.add(C0962oIX0oI.xoIox(f22830XI0oooXX, this.f22876oI0IIXIo, x0xO0oo2, i3, 0, 0, false, this.f22867XX0xXo, i2, 56, null));
                    if (i4 == i) {
                        break;
                    }
                    i4++;
                } finally {
                }
            }
        } else {
            i2 = 0;
        }
        return new Triple<>(Integer.valueOf(i3), Integer.valueOf(i2), arrayList);
    }

    public final Pair<Bitmap, Float> oxoX(String str, String str2, String str3, float f, int i, Canvas canvas, float f2, boolean z) {
        int i2;
        String str4 = str;
        String str5 = str2;
        Bitmap bitmap = ImageUtils.getBitmap(this.f22845O00XxXI.getResources().getAssets().open(str4 + str5 + "/symbol.png"));
        AssetManager assets = this.f22845O00XxXI.getResources().getAssets();
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        sb.append(str5);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        int i3 = 0;
        sb.append(str3.charAt(0));
        sb.append(".png");
        Bitmap bitmap2 = ImageUtils.getBitmap(assets.open(sb.toString()));
        float f3 = 6;
        float f4 = f + i + f3;
        int i4 = 2;
        float height = ((bitmap2.getHeight() - bitmap.getHeight()) / 2) + f4;
        if (StringsKt__StringsKt.o00xOoIO(str5, this.f22892x0xO, false, 2, null)) {
            this.f22882oo = f2;
            this.f22842IoOoX = f4;
            this.f22839IO = (bitmap2.getWidth() * 2) + f2;
            this.f22895xII = height;
            float width = (bitmap2.getWidth() * 2) + f2 + bitmap.getWidth();
            this.f22879oOXoIIIo = width;
            this.f22857X00IoxXI = f4;
            this.f22871Xx000oIo = (width + (bitmap2.getWidth() * 2)) - f3;
        } else if (StringsKt__StringsKt.o00xOoIO(str5, this.f22900xoIxX, false, 2, null)) {
            this.f22891x0o = f2;
            this.f22864XOxIOxOx = f4;
            this.f22873o0 = (bitmap2.getWidth() * 2) + f2;
            this.f22865XX = height;
            this.f22848OI0 = (bitmap2.getWidth() * 2) + f2 + bitmap.getWidth();
            this.f22841Io = f4;
        }
        if (this.f22852Oo == 0) {
            int length = str3.length();
            int i5 = 0;
            int i6 = 0;
            while (i3 < length) {
                if (i3 == i4) {
                    canvas.drawBitmap(bitmap, (bitmap2.getWidth() * i5) + f2, height, (Paint) null);
                    i2 = length;
                    i6 = bitmap.getWidth();
                } else {
                    if (z) {
                        i2 = length;
                        canvas.drawBitmap(ImageUtils.getBitmap(this.f22845O00XxXI.getResources().getAssets().open(str4 + str5 + IOUtils.DIR_SEPARATOR_UNIX + str3.charAt(i3) + ".png")), (bitmap2.getWidth() * i5) + f2 + i6, f4, (Paint) null);
                    } else {
                        i2 = length;
                    }
                    i5++;
                }
                i3++;
                str5 = str2;
                length = i2;
                i4 = 2;
            }
        } else if (z) {
            int length2 = str3.length();
            int i7 = 0;
            int i8 = 0;
            while (i3 < length2) {
                if (i3 == 2) {
                    canvas.drawBitmap(bitmap, (bitmap2.getWidth() * i7) + f2, height, (Paint) null);
                    i8 = bitmap.getWidth();
                } else {
                    canvas.drawBitmap(ImageUtils.getBitmap(this.f22845O00XxXI.getResources().getAssets().open(str4 + str2 + IOUtils.DIR_SEPARATOR_UNIX + str3.charAt(i3) + '.' + this.f22876oI0IIXIo)), (bitmap2.getWidth() * i7) + f2 + i8, f4, (Paint) null);
                    i7++;
                }
                i3++;
                str4 = str;
            }
        }
        return new Pair<>(bitmap2, Float.valueOf(f4));
    }

    @OOXIXo
    public final List<String> oxxXoxO() {
        return this.f22875o0xxxXXxX;
    }

    public final void x0(float f) {
        this.f22857X00IoxXI = f;
    }

    public final void x00IOx(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f22877oIX0oI = str;
    }

    public final void x0OIX00oO(@OOXIXo ViewGroup viewGroup) {
        IIX0o.x0xO0oo(viewGroup, "<set-?>");
        this.f22831I0Io = viewGroup;
    }

    public final void x0OxxIOxX(float f) {
        this.f22871Xx000oIo = f;
    }

    public final void x0XOIxOo(ArrayList<Element> arrayList) {
        Triple<Integer, Integer, ArrayList<byte[]>> ooOOo0oXI2 = ooOOo0oXI(this.f22875o0xxxXXxX);
        arrayList.add(new Element(44, 0, ooOOo0oXI2.getFirst().intValue(), ooOOo0oXI2.getSecond().intValue(), 9, this.f22853OxI, 0, 0, 0, 0, 0, (byte[][]) ooOOo0oXI2.getThird().toArray(new byte[0]), 1794, null));
    }

    public final float x0o() {
        return this.f22872XxX0x0xxx;
    }

    public final int x0xO() {
        return this.f22878oO;
    }

    public final float x0xO0oo() {
        return this.f22860XI0IXoo;
    }

    public final float xI() {
        return this.f22879oOXoIIIo;
    }

    public final void xI0oxI00(float f) {
        this.f22860XI0IXoo = f;
    }

    public final float xII() {
        return this.f22905xxX;
    }

    public final void xIXX(int i) {
        this.f22893x0xO0oo = i;
    }

    public final int xOOOX() {
        return this.f22901xoXoI;
    }

    public final void xOOxIO(int i) {
        this.f22884ooOOo0oXI = i;
    }

    public final void xOoOIoI() {
        XoX().measure(View.MeasureSpec.makeMeasureSpec(ScreenUtils.getAppScreenWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ScreenUtils.getAppScreenHeight(), 1073741824));
        XoX().layout(0, 0, XoX().getMeasuredWidth(), XoX().getMeasuredHeight());
        XoX().requestLayout();
    }

    public final void xX(int i) {
        this.f22885ooXIXxIX = i;
    }

    public final int xX0IIXIx0() {
        return this.f22838IIXOooo;
    }

    public final Triple<Integer, Integer, ArrayList<byte[]>> xXOx(String str, int i) {
        int i2;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        if (i >= 0) {
            int i4 = 0;
            i2 = 0;
            while (true) {
                String str2 = str + i3 + '.' + this.f22876oI0IIXIo;
                if (i4 == 0) {
                    Bitmap bitmap = ImageUtils.getBitmap(this.f22845O00XxXI.getResources().getAssets().open(str2));
                    int width = bitmap.getWidth();
                    i2 = bitmap.getHeight();
                    i4 = width;
                }
                InputStream open = this.f22845O00XxXI.getResources().getAssets().open(str2);
                try {
                    IIX0o.ooOOo0oXI(open);
                    byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
                    kotlin.io.II0xO0.oIX0oI(open, null);
                    File file = new File(I0(), str2);
                    FileIOUtils.writeFileFromBytesByStream(file, x0xO0oo2);
                    byte[] oxoX2 = C0962oIX0oI.oxoX(f22830XI0oooXX, file, false, false, 6, null);
                    if (oxoX2 != null) {
                        arrayList.add(oxoX2);
                    }
                    if (i3 == i) {
                        break;
                    }
                    i3++;
                } finally {
                }
            }
            i3 = i4;
        } else {
            i2 = 0;
        }
        return new Triple<>(Integer.valueOf(i3), Integer.valueOf(i2), arrayList);
    }

    public final void xXoOI00O(float f) {
        this.f22879oOXoIIIo = f;
    }

    public final float xXxxox0I() {
        return this.f22865XX;
    }

    public final byte[] xoIox() {
        byte[] oxoX2;
        Bitmap oOoXoXO2 = oOoXoXO(this, false, 0, null, 6, null);
        File file = new File(I0(), IXxxXO.f20882xxX);
        ImageUtils.save(oOoXoXO2, file, Bitmap.CompressFormat.PNG);
        if (O0X() && (oxoX2 = C0962oIX0oI.oxoX(f22830XI0oooXX, file, false, false, 4, null)) != null) {
            return oxoX2;
        }
        return X0o0xo("bmp", oOoXoXO2);
    }

    public final int xoIxX() {
        return this.f22893x0xO0oo;
    }

    public final int xoO0xx0() {
        return this.f22885ooXIXxIX;
    }

    @OOXIXo
    public final ViewGroup xoXoI() {
        ViewGroup viewGroup = this.f22863XO;
        if (viewGroup != null) {
            return viewGroup;
        }
        IIX0o.XOxIOxOx("controlViewDis");
        return null;
    }

    public final float xoxXI() {
        return this.f22880oOoXoXO;
    }

    public final void xx0X0(int i) {
        this.f22874o00 = i;
    }

    public final float xxIO() {
        return this.f22858X0IIOO;
    }

    public final float xxIXOIIO() {
        return this.f22883oo0xXOI0I;
    }

    public final void xxOXOOoIX(float f) {
        this.f22842IoOoX = f;
    }

    public final float xxX() {
        return this.f22864XOxIOxOx;
    }

    public final void xxxI(int i) {
        this.f22878oO = i;
    }
}
