package me.devilsen.czxing.view.scanview;

import IIoX0OoI.oIX0oI;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import me.devilsen.czxing.R;
import me.devilsen.czxing.code.BarcodeFormat;
import me.devilsen.czxing.code.CodeResult;
import me.devilsen.czxing.view.PointView;
import me.devilsen.czxing.view.scanview.oIX0oI;

/* loaded from: classes6.dex */
public class ScanLayout extends FrameLayout implements oIX0oI.XO, oIX0oI.oxoX, oIX0oI.X0o0xo, View.OnClickListener {

    /* renamed from: IIX0o, reason: collision with root package name */
    public oIX0oI.InterfaceC1118oIX0oI f30940IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f30941IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public ScanBoxView f30942IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public Handler f30943O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public String f30944Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f30945OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public TextView f30946Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public View f30947OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public final List<View> f30948X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f30949XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f30950XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public String f30951XO;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public DetectView f30952XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f30953o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public ImageView f30954oI0IIXIo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f30955oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public String f30956ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public boolean f30957xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public me.devilsen.czxing.view.scanview.oIX0oI f30958xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f30959xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public boolean f30960xxX;

    /* loaded from: classes6.dex */
    public class I0Io implements Runnable {
        public I0Io() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = ScanLayout.this.f30948X0IIOO.iterator();
            while (it.hasNext()) {
                ScanLayout.this.removeView((View) it.next());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class II0xO0 implements Runnable {
        public II0xO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScanLayout.this.f30946Oxx0xo.setVisibility(8);
            ScanLayout.this.f30954oI0IIXIo.setVisibility(8);
        }
    }

    /* loaded from: classes6.dex */
    public class X0o0xo implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ FrameLayout.LayoutParams f30964Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ PointView f30965XO;

        public X0o0xo(PointView pointView, FrameLayout.LayoutParams layoutParams) {
            this.f30965XO = pointView;
            this.f30964Oo = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScanLayout.this.addView(this.f30965XO, this.f30964Oo);
        }
    }

    /* loaded from: classes6.dex */
    public interface XO {
        void oIX0oI();
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScanLayout.this.f30946Oxx0xo.setVisibility(0);
            ScanLayout.this.f30954oI0IIXIo.setVisibility(0);
        }
    }

    /* loaded from: classes6.dex */
    public class oxoX implements View.OnClickListener {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ CodeResult f30968XO;

        public oxoX(CodeResult codeResult) {
            this.f30968XO = codeResult;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScanLayout.this.f30958xXxxox0I != null) {
                ScanLayout.this.f30958xXxxox0I.II0xO0(this.f30968XO);
            }
        }
    }

    public ScanLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // IIoX0OoI.oIX0oI.XO
    public void I0Io() {
    }

    public final void II0XooXoX(CodeResult codeResult, int i) {
        int[] points = codeResult.getPoints();
        if (points != null && points.length >= 4) {
            int i2 = points[0];
            int i3 = points[1];
            int i4 = points[2];
            int i5 = points[3];
            PointView pointView = new PointView(getContext());
            if (i > 1) {
                pointView.oIX0oI();
                pointView.setOnClickListener(new oxoX(codeResult));
            }
            this.f30948X0IIOO.add(pointView);
            int i6 = this.f30950XIxXXX0x0;
            if (i6 > 0) {
                pointView.setColor(i6);
            }
            int i7 = this.f30949XI0IXoo;
            int i8 = (i5 - i7) / 2;
            int max = Math.max((i4 - i7) / 2, 0);
            int max2 = Math.max(i8, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = i2 + max;
            layoutParams.topMargin = i3 + max2;
            this.f30943O0xOxO.post(new X0o0xo(pointView, layoutParams));
        }
    }

    @Override // IIoX0OoI.oIX0oI.X0o0xo
    public void II0xO0(List<CodeResult> list) {
        Iterator<CodeResult> it = list.iterator();
        while (it.hasNext()) {
            oI00o.II0xO0.oIX0oI("result : " + it.next().toString());
        }
        me.devilsen.czxing.view.scanview.oIX0oI oix0oi = this.f30958xXxxox0I;
        if (oix0oi != null) {
            oix0oi.I0Io(list);
        }
        IXxxXO(list);
    }

    public final void IXxxXO(List<CodeResult> list) {
        if (this.f30960xxX) {
            return;
        }
        oO();
        Iterator<CodeResult> it = list.iterator();
        while (it.hasNext()) {
            II0XooXoX(it.next(), list.size());
        }
    }

    public final void OOXIXo(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_scan_layout, (ViewGroup) this, true);
        this.f30952XxX0x0xxx = (DetectView) inflate.findViewById(R.id.detect_view);
        this.f30942IXxxXO = (ScanBoxView) inflate.findViewById(R.id.scan_box);
        this.f30946Oxx0xo = (TextView) inflate.findViewById(R.id.text_scan_flashlight_notice);
        this.f30954oI0IIXIo = (ImageView) inflate.findViewById(R.id.image_scan_flashlight);
        this.f30947OxxIIOOXO = inflate.findViewById(R.id.view_scan_mask);
        this.f30951XO = getResources().getText(R.string.czxing_click_open_flash_light).toString();
        this.f30944Oo = getResources().getText(R.string.czxing_click_close_flash_light).toString();
        this.f30941IIXOooo = R.drawable.ic_highlight_open_24dp;
        this.f30959xoXoI = R.drawable.ic_highlight_close_24dp;
        this.f30943O0xOxO = new Handler(Looper.getMainLooper());
        this.f30949XI0IXoo = oI00o.II0xO0.II0xO0(context, 15.0f);
        this.f30952XxX0x0xxx.setOnDetectCodeListener(this);
        this.f30952XxX0x0xxx.setOnDetectBrightnessListener(this);
        this.f30952XxX0x0xxx.setOnFocusListener(this);
        this.f30954oI0IIXIo.setOnClickListener(this);
    }

    public void Oo(String str, String str2, String str3, String str4) {
        this.f30952XxX0x0xxx.IXxxXO(str, str2, str3, str4);
    }

    public void Oxx0xo() {
        this.f30952XxX0x0xxx.Oxx0xo();
    }

    public void OxxIIOOXO() {
        this.f30952XxX0x0xxx.oOoXoXO();
    }

    public ScanBoxView getScanBox() {
        return this.f30942IXxxXO;
    }

    public void oI0IIXIo() {
        this.f30952XxX0x0xxx.oI0IIXIo();
    }

    @Override // IIoX0OoI.oIX0oI.oxoX
    public void oIX0oI(double d) {
        oIX0oI.InterfaceC1118oIX0oI interfaceC1118oIX0oI = this.f30940IIX0o;
        if (interfaceC1118oIX0oI != null) {
            interfaceC1118oIX0oI.oIX0oI(d);
        }
        if (this.f30957xI) {
            return;
        }
        if (d < 80.0d) {
            int i = this.f30955oo0xXOI0I;
            if (i < 20) {
                this.f30955oo0xXOI0I = i + 1;
            }
        } else {
            int i2 = this.f30955oo0xXOI0I;
            if (i2 > 0) {
                this.f30955oo0xXOI0I = i2 - 1;
            }
        }
        if (this.f30955oo0xXOI0I > 10) {
            this.f30943O0xOxO.post(new oIX0oI());
        } else {
            this.f30943O0xOxO.post(new II0xO0());
        }
    }

    public final void oO() {
        try {
            this.f30943O0xOxO.post(new I0Io());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void oOoXoXO() {
        this.f30953o00 = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.image_scan_flashlight) {
            if (this.f30957xI) {
                this.f30952XxX0x0xxx.X0o0xo();
                this.f30946Oxx0xo.setText(this.f30951XO);
                this.f30954oI0IIXIo.setImageResource(this.f30959xoXoI);
                this.f30957xI = false;
                return;
            }
            this.f30952XxX0x0xxx.xxIXOIIO();
            this.f30946Oxx0xo.setText(this.f30944Oo);
            this.f30954oI0IIXIo.setImageResource(this.f30941IIXOooo);
            this.f30957xI = true;
        }
    }

    public void ooOOo0oXI() {
        Handler handler = this.f30943O0xOxO;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f30943O0xOxO = null;
        }
        ScanBoxView scanBoxView = this.f30942IXxxXO;
        if (scanBoxView != null) {
            scanBoxView.Oo();
            this.f30942IXxxXO = null;
        }
    }

    public void setAnalysisBrightnessListener(oIX0oI.InterfaceC1118oIX0oI interfaceC1118oIX0oI) {
        this.f30940IIX0o = interfaceC1118oIX0oI;
    }

    public void setBarcodeFormat(BarcodeFormat[] barcodeFormatArr) {
        this.f30952XxX0x0xxx.setBarcodeFormat(barcodeFormatArr);
    }

    public void setFlashLightOffDrawable(int i) {
        if (i == 0) {
            return;
        }
        this.f30959xoXoI = i;
        this.f30954oI0IIXIo.setImageResource(i);
    }

    public void setFlashLightOffText(String str) {
        if (str != null) {
            this.f30944Oo = str;
        }
    }

    public void setFlashLightOnDrawable(int i) {
        if (i == 0) {
            return;
        }
        this.f30941IIXOooo = i;
    }

    public void setFlashLightOnText(String str) {
        if (str != null) {
            this.f30951XO = str;
        }
    }

    public void setOnScanListener(me.devilsen.czxing.view.scanview.oIX0oI oix0oi) {
        this.f30958xXxxox0I = oix0oi;
    }

    public void setResultColor(int i) {
        this.f30950XIxXXX0x0 = i;
    }

    public void setResultMaskColor(int i) {
        if (i == 0) {
            return;
        }
        this.f30945OxI = i;
    }

    public void setScanNoticeText(String str) {
        this.f30956ooXIXxIX = str;
    }

    public void x0XOIxOo() {
        this.f30952XxX0x0xxx.II0XooXoX();
    }

    public void x0xO0oo() {
        this.f30952XxX0x0xxx.xoIox();
    }

    public void xoIox(boolean z) {
        this.f30960xxX = z;
    }

    public void xxIXOIIO() {
        this.f30952XxX0x0xxx.oxoX();
    }

    public ScanLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30948X0IIOO = new CopyOnWriteArrayList();
        OOXIXo(context);
    }
}
