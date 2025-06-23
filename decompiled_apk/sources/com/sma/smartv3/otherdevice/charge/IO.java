package com.sma.smartv3.otherdevice.charge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.core.view.ViewCompat;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.garmin.fit.X0xOO;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.jieli.jl_rcsp.constant.Command;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.device.watchface.oIX0oI;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.watchface.Element;
import com.szabh.smable3.watchface.WatchFaceBuilder;
import java.io.File;
import java.util.ArrayList;

@kotlin.jvm.internal.XX({"SMAP\nCustomWatchFaceBackground.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomWatchFaceBackground.kt\ncom/sma/smartv3/otherdevice/charge/CustomWatchFaceBackground\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,218:1\n37#2,2:219\n*S KotlinDebug\n*F\n+ 1 CustomWatchFaceBackground.kt\ncom/sma/smartv3/otherdevice/charge/CustomWatchFaceBackground\n*L\n138#1:219,2\n*E\n"})
/* loaded from: classes12.dex */
public final class IO {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f20993I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f20994II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public float f20995II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public Context f20996OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f20997Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f20998X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f20999XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f21000oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public ImageView f21001oOoXoXO;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f21002oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public float f21003xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f21004xxIXOIIO;

    public IO(@OXOo.OOXIXo Context context, @OXOo.OOXIXo ImageView bgView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        kotlin.jvm.internal.IIX0o.x0xO0oo(bgView, "bgView");
        this.f21003xoIox = 10.0f;
        this.f20996OOXIXo = context;
        this.f21001oOoXoXO = bgView;
        xxIXOIIO();
    }

    public static /* synthetic */ Bitmap X0o0xo(IO io2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = R.color.dark;
        }
        return io2.oxoX(i);
    }

    public final Bitmap I0Io(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
        kotlin.jvm.internal.IIX0o.oO(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public final float II0XooXoX() {
        return this.f21003xoIox;
    }

    public final Bitmap II0xO0() {
        Bitmap bitmap$default;
        Bitmap roundCorner;
        if (this.f21000oIX0oI) {
            bitmap$default = ImageUtils.view2Bitmap(this.f21001oOoXoXO);
        } else {
            Drawable drawable = this.f21001oOoXoXO.getDrawable();
            kotlin.jvm.internal.IIX0o.oO(drawable, "getDrawable(...)");
            bitmap$default = DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null);
        }
        float width = this.f20993I0Io / bitmap$default.getWidth();
        float height = this.f21002oxoX / bitmap$default.getHeight();
        LogUtils.d("test getBgBitmap = " + bitmap$default.getWidth() + "- " + bitmap$default.getHeight() + " ; " + width + " - " + height + TokenParser.SP);
        Bitmap scale = ImageUtils.scale(bitmap$default, width, height);
        if (this.f21000oIX0oI) {
            roundCorner = ImageUtils.toRound(scale, this.f20997Oxx0IOOO, this.f20996OOXIXo.getResources().getColor(R.color.dark));
        } else {
            roundCorner = ImageUtils.toRoundCorner(scale, this.f20995II0xO0, 0.0f, this.f20996OOXIXo.getResources().getColor(R.color.dark));
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(roundCorner);
        return I0Io(roundCorner);
    }

    public final void OOXIXo(int i) {
        this.f20993I0Io = i;
    }

    public final int Oxx0IOOO() {
        return this.f20993I0Io;
    }

    public final int XO() {
        return this.f21002oxoX;
    }

    @OXOo.OOXIXo
    public final byte[] oIX0oI() {
        Bitmap II0xO02 = II0xO0();
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        File xoXoI2 = com.sma.smartv3.initializer.IXxxXO.xoXoI(oix0oi);
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
        ImageUtils.save(II0xO02, xoXoI2, compressFormat);
        ImageUtils.save(X0o0xo(this, 0, 1, null), com.sma.smartv3.initializer.IXxxXO.xxX(oix0oi), compressFormat);
        ArrayList arrayList = new ArrayList();
        oIX0oI.C0962oIX0oI c0962oIX0oI = com.sma.smartv3.ui.device.watchface.oIX0oI.f22830XI0oooXX;
        byte[] oxoX2 = oIX0oI.C0962oIX0oI.oxoX(c0962oIX0oI, com.sma.smartv3.initializer.IXxxXO.xxX(oix0oi), false, false, 4, null);
        if (oxoX2 != null) {
            arrayList.add(new Element(1, 0, this.f20998X0o0xo, this.f20999XO, 0, 4, 0, 0, 0, 0, 0, new byte[][]{oxoX2}, 1794, null));
        }
        byte[] oxoX3 = oIX0oI.C0962oIX0oI.oxoX(c0962oIX0oI, com.sma.smartv3.initializer.IXxxXO.xoXoI(oix0oi), false, false, 4, null);
        if (oxoX3 != null) {
            arrayList.add(new Element(2, 0, this.f20993I0Io, this.f21002oxoX, 9, 4, 0, 0, 0, 0, 0, new byte[][]{oxoX3}, 1794, null));
        }
        arrayList.add(new Element(22, 0, 0, 0, 0, 0, this.f20994II0XooXoX, this.f21004xxIXOIIO, 0, 0, 0, null, 3902, null));
        byte[] build = WatchFaceBuilder.INSTANCE.build((Element[]) arrayList.toArray(new Element[0]), 2);
        LogUtils.d("screensaver bytes size  " + build.length);
        return build;
    }

    public final void oOoXoXO(@OXOo.OOXIXo Bitmap bitmap) {
        Bitmap roundCorner;
        kotlin.jvm.internal.IIX0o.x0xO0oo(bitmap, "bitmap");
        ImageView imageView = this.f21001oOoXoXO;
        if (this.f21000oIX0oI) {
            roundCorner = ImageUtils.toRound(bitmap);
        } else {
            roundCorner = ImageUtils.toRoundCorner(bitmap, this.f20995II0xO0);
        }
        imageView.setImageBitmap(roundCorner);
    }

    public final void ooOOo0oXI(float f) {
        this.f21003xoIox = f;
    }

    public final Bitmap oxoX(int i) {
        Bitmap roundCorner;
        float width = this.f20998X0o0xo / r0.getWidth();
        Bitmap scale = ImageUtils.scale(II0xO0(), width, this.f20999XO / r0.getHeight());
        if (this.f21000oIX0oI) {
            roundCorner = ImageUtils.toRound(scale, this.f20997Oxx0IOOO, this.f20996OOXIXo.getResources().getColor(i));
        } else {
            roundCorner = ImageUtils.toRoundCorner(scale, this.f20995II0xO0 * width, this.f20997Oxx0IOOO, this.f20996OOXIXo.getResources().getColor(i));
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(roundCorner);
        return roundCorner;
    }

    public final void xoIox(int i) {
        this.f21002oxoX = i;
    }

    public final void xxIXOIIO() {
        String mPrototype = BleCache.INSTANCE.getMPrototype();
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(mPrototype, "X6")) {
            this.f20993I0Io = X0xOO.f13664XxXX;
            this.f21002oxoX = 240;
            this.f20998X0o0xo = 185;
            this.f20999XO = 150;
            this.f20995II0xO0 = 20.0f;
            this.f20994II0XooXoX = 40;
            this.f21004xxIXOIIO = (240 / 2) - 18;
            return;
        }
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(mPrototype, "X5L")) {
            this.f20993I0Io = 360;
            this.f21002oxoX = 360;
            this.f20998X0o0xo = Command.CMD_NOTIFY_FILE_STRUCTURE_CHANGE;
            this.f20999XO = Command.CMD_NOTIFY_FILE_STRUCTURE_CHANGE;
            this.f20995II0xO0 = 0.0f;
            this.f21000oIX0oI = true;
            return;
        }
        this.f20993I0Io = X0xOO.f13583O0o0;
        this.f21002oxoX = 172;
        this.f20998X0o0xo = 130;
        this.f20999XO = 70;
        this.f20995II0xO0 = 20.0f;
        this.f20994II0XooXoX = 40;
        this.f21004xxIXOIIO = (172 / 2) - 18;
    }
}
