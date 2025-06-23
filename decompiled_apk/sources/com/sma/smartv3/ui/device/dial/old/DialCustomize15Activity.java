package com.sma.smartv3.ui.device.dial.old;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ResourcesIdInfo;
import com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity;
import java.nio.ByteBuffer;
import java.util.List;
import okhttp3.internal.Util;

/* loaded from: classes12.dex */
public final class DialCustomize15Activity extends BaseDialCustomizeActivity {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void customizeDialBgItemClick$lambda$0(DialCustomize15Activity this$0, com.sma.smartv3.pop.dial.II0xO0 this_customizeDialBgItemClick, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_customizeDialBgItemClick, "$this_customizeDialBgItemClick");
        this$0.getCustomizeDialBg().setImageResource(R.drawable.dial_customize_2_0);
        this_customizeDialBgItemClick.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void customizeDialBgItemClick$lambda$1(DialCustomize15Activity this$0, com.sma.smartv3.pop.dial.II0xO0 this_customizeDialBgItemClick, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_customizeDialBgItemClick, "$this_customizeDialBgItemClick");
        this$0.getCustomizeDialBg().setImageResource(R.drawable.dial_customize_2_1);
        this_customizeDialBgItemClick.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void customizeDialBgItemClick$lambda$2(DialCustomize15Activity this$0, com.sma.smartv3.pop.dial.II0xO0 this_customizeDialBgItemClick, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_customizeDialBgItemClick, "$this_customizeDialBgItemClick");
        this$0.getCustomizeDialBg().setImageResource(R.drawable.dial_customize_2_2);
        this_customizeDialBgItemClick.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void customizeDialBgItemClick$lambda$3(DialCustomize15Activity this$0, com.sma.smartv3.pop.dial.II0xO0 this_customizeDialBgItemClick, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_customizeDialBgItemClick, "$this_customizeDialBgItemClick");
        this$0.getCustomizeDialBg().setImageResource(R.drawable.dial_customize_2_3);
        this_customizeDialBgItemClick.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void customizeDialBgItemClick$lambda$4(DialCustomize15Activity this$0, com.sma.smartv3.pop.dial.II0xO0 this_customizeDialBgItemClick, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_customizeDialBgItemClick, "$this_customizeDialBgItemClick");
        this$0.getCustomizeDialBg().setImageResource(R.drawable.dial_customize_2_4);
        this_customizeDialBgItemClick.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void customizeDialBgItemClick$lambda$5(DialCustomize15Activity this$0, com.sma.smartv3.pop.dial.II0xO0 this_customizeDialBgItemClick, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_customizeDialBgItemClick, "$this_customizeDialBgItemClick");
        this$0.getCustomizeDialBg().setImageResource(R.drawable.dial_customize_2_5);
        this_customizeDialBgItemClick.dismiss();
    }

    @Override // com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity
    @OXOo.OOXIXo
    public byte[] bitmap2Bytes(@OXOo.OOXIXo Bitmap finalBgBitMap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(finalBgBitMap, "finalBgBitMap");
        ByteBuffer allocate = ByteBuffer.allocate(finalBgBitMap.getByteCount());
        finalBgBitMap.copyPixelsToBuffer(allocate);
        byte[] array = allocate.array();
        String fileFormat = getFileFormat();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(array);
        return com.sma.smartv3.util.oxoX.oIX0oI(fileFormat, array, finalBgBitMap.getWidth(), 16, 0, false);
    }

    @Override // com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity
    public void customizeDialBgItemClick(@OXOo.OOXIXo final com.sma.smartv3.pop.dial.II0xO0 iI0xO0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iI0xO0, "<this>");
        iI0xO0.O0xOxO().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.old.oI0IIXIo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialCustomize15Activity.customizeDialBgItemClick$lambda$0(DialCustomize15Activity.this, iI0xO0, view);
            }
        });
        iI0xO0.X0IIOO().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.old.OxxIIOOXO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialCustomize15Activity.customizeDialBgItemClick$lambda$1(DialCustomize15Activity.this, iI0xO0, view);
            }
        });
        iI0xO0.XI0IXoo().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.old.IIXOooo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialCustomize15Activity.customizeDialBgItemClick$lambda$2(DialCustomize15Activity.this, iI0xO0, view);
            }
        });
        iI0xO0.XIxXXX0x0().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.old.xoXoI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialCustomize15Activity.customizeDialBgItemClick$lambda$3(DialCustomize15Activity.this, iI0xO0, view);
            }
        });
        iI0xO0.xxX().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.old.o00
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialCustomize15Activity.customizeDialBgItemClick$lambda$4(DialCustomize15Activity.this, iI0xO0, view);
            }
        });
        iI0xO0.XxX0x0xxx().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.old.OxI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialCustomize15Activity.customizeDialBgItemClick$lambda$5(DialCustomize15Activity.this, iI0xO0, view);
            }
        });
    }

    @Override // com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity
    @OXOo.OOXIXo
    public Bitmap getFinalBgBitmap(@OXOo.OOXIXo Bitmap bgBitMap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bgBitMap, "bgBitMap");
        Bitmap createBitmap = Bitmap.createBitmap(bgBitMap.getWidth(), bgBitMap.getHeight() + 1, Bitmap.Config.RGB_565);
        kotlin.jvm.internal.IIX0o.oO(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawBitmap(bgBitMap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    @Override // com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        String str;
        setSupportConvertPng(ProductManager.f20544oIX0oI.OXooXo());
        if (isSupportConvertPng()) {
            i = 4;
        } else {
            i = 1;
        }
        setIgnoreBlack(i);
        if (isSupportConvertPng()) {
            str = "png";
        } else {
            str = "bmp";
        }
        setFileFormat(str);
        setScreenWidth(360);
        setScreenHeight(360);
        setScreenPreviewWidth(224);
        setScreenPreviewHeight(224);
        setControlValueInterval(1);
        setControlValueRange(10);
        setRound(true);
        setImageFormat(2);
        setX_CENTER(2);
        setY_CENTER(16);
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_dial_customize_15;
    }

    @Override // com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity
    @OXOo.OOXIXo
    public List<ResourcesIdInfo> scalesList() {
        return Util.immutableListOf(new ResourcesIdInfo(R.drawable.dial_customize_scale_2_0, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_scale_2_1, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_scale_2_2, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_scale_2_3, 0, false, 6, null));
    }

    @Override // com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity
    @OXOo.OOXIXo
    public String customizeDir() {
        return "dial_customize_360";
    }
}
