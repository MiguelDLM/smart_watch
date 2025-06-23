package com.sma.smartv3.ui.device.dial.old;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ResourcesIdInfo;
import com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity;
import java.nio.ByteBuffer;
import java.util.List;
import okhttp3.internal.Util;

/* loaded from: classes12.dex */
public final class DialCustomize9Activity extends BaseDialCustomizeActivity {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO pointers$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<List<? extends ResourcesIdInfo>>() { // from class: com.sma.smartv3.ui.device.dial.old.DialCustomize9Activity$pointers$2
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final List<? extends ResourcesIdInfo> invoke() {
            return Util.immutableListOf(new ResourcesIdInfo(R.drawable.dial_customize_point_1_0, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_1_1, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_1_2, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_1_3, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_1_4, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_1_5, 0, false, 6, null));
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final void customizeDialBgItemClick$lambda$0(DialCustomize9Activity this$0, com.sma.smartv3.pop.dial.II0xO0 this_customizeDialBgItemClick, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_customizeDialBgItemClick, "$this_customizeDialBgItemClick");
        this$0.getCustomizeDialBg().setImageResource(R.drawable.dial_customize_2_0);
        this_customizeDialBgItemClick.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void customizeDialBgItemClick$lambda$1(DialCustomize9Activity this$0, com.sma.smartv3.pop.dial.II0xO0 this_customizeDialBgItemClick, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_customizeDialBgItemClick, "$this_customizeDialBgItemClick");
        this$0.getCustomizeDialBg().setImageResource(R.drawable.dial_customize_2_1);
        this_customizeDialBgItemClick.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void customizeDialBgItemClick$lambda$2(DialCustomize9Activity this$0, com.sma.smartv3.pop.dial.II0xO0 this_customizeDialBgItemClick, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_customizeDialBgItemClick, "$this_customizeDialBgItemClick");
        this$0.getCustomizeDialBg().setImageResource(R.drawable.dial_customize_2_2);
        this_customizeDialBgItemClick.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void customizeDialBgItemClick$lambda$3(DialCustomize9Activity this$0, com.sma.smartv3.pop.dial.II0xO0 this_customizeDialBgItemClick, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_customizeDialBgItemClick, "$this_customizeDialBgItemClick");
        this$0.getCustomizeDialBg().setImageResource(R.drawable.dial_customize_2_3);
        this_customizeDialBgItemClick.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void customizeDialBgItemClick$lambda$4(DialCustomize9Activity this$0, com.sma.smartv3.pop.dial.II0xO0 this_customizeDialBgItemClick, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_customizeDialBgItemClick, "$this_customizeDialBgItemClick");
        this$0.getCustomizeDialBg().setImageResource(R.drawable.dial_customize_2_4);
        this_customizeDialBgItemClick.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void customizeDialBgItemClick$lambda$5(DialCustomize9Activity this$0, com.sma.smartv3.pop.dial.II0xO0 this_customizeDialBgItemClick, View view) {
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
        iI0xO0.O0xOxO().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.old.xxIO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialCustomize9Activity.customizeDialBgItemClick$lambda$0(DialCustomize9Activity.this, iI0xO0, view);
            }
        });
        iI0xO0.X0IIOO().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.old.XX0xXo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialCustomize9Activity.customizeDialBgItemClick$lambda$1(DialCustomize9Activity.this, iI0xO0, view);
            }
        });
        iI0xO0.XI0IXoo().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.old.o0xxxXXxX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialCustomize9Activity.customizeDialBgItemClick$lambda$2(DialCustomize9Activity.this, iI0xO0, view);
            }
        });
        iI0xO0.XIxXXX0x0().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.old.O00XxXI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialCustomize9Activity.customizeDialBgItemClick$lambda$3(DialCustomize9Activity.this, iI0xO0, view);
            }
        });
        iI0xO0.xxX().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.old.XI0oooXX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialCustomize9Activity.customizeDialBgItemClick$lambda$4(DialCustomize9Activity.this, iI0xO0, view);
            }
        });
        iI0xO0.XxX0x0xxx().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.old.OOXIxO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialCustomize9Activity.customizeDialBgItemClick$lambda$5(DialCustomize9Activity.this, iI0xO0, view);
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

    @Override // com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity
    @OXOo.OOXIXo
    public List<ResourcesIdInfo> getPointers() {
        return (List) this.pointers$delegate.getValue();
    }

    @Override // com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        setScreenWidth(240);
        setScreenHeight(240);
        setScreenPreviewWidth(106);
        setScreenPreviewHeight(106);
        setControlValueInterval(1);
        setIgnoreBlack(1);
        setRound(true);
        setFileFormat("bmp");
        setImageFormat(2);
        setX_CENTER(2);
        setY_CENTER(16);
        getControlViewStep().setBottomRangeScale(0.85f);
        getControlViewHr().setBottomRangeScale(0.85f);
        getControlViewCa().setBottomRangeScale(0.85f);
        getControlViewDis().setBottomRangeScale(0.85f);
        getTimeDigitalView().setBottomRangeScale(0.85f);
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_dial_customize_2;
    }

    @Override // com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity
    public void pointerOnClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        ToastUtils.showLong(R.string.stay_tuned);
    }

    @Override // com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity
    @OXOo.OOXIXo
    public List<ResourcesIdInfo> scalesList() {
        return Util.immutableListOf(new ResourcesIdInfo(R.drawable.dial_customize_scale_2_0, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_scale_2_1, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_scale_2_2, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_scale_2_3, 0, false, 6, null));
    }

    @Override // com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity
    @OXOo.OOXIXo
    public String customizeDir() {
        return "dial_customize_7";
    }
}
