package me.devilsen.czxing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.List;
import me.devilsen.czxing.ScannerManager;
import me.devilsen.czxing.code.BarcodeFormat;
import me.devilsen.czxing.code.CodeResult;
import me.devilsen.czxing.view.scanview.ScanBoxView;
import me.devilsen.czxing.view.scanview.ScanLayout;
import oI00o.II0xO0;
import oI00o.xoIox;
import oI00o.xxIXOIIO;
import oxOIoIx.oIX0oI;

/* loaded from: classes6.dex */
public class ScanActivity extends Activity implements me.devilsen.czxing.view.scanview.oIX0oI, View.OnClickListener {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f30797O0xOxO = 10;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f30798OxI = 1;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final long f30799X0IIOO = 800;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public oIX0oI.I0Io f30800IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public ScanLayout f30801IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public ImageView f30802Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public xoIox f30803Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f30804OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public TextView f30805XO;

    /* renamed from: o00, reason: collision with root package name */
    public final Handler f30806o00 = new Handler(new oIX0oI());

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f30807oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public oIX0oI.II0xO0 f30808xoXoI;

    /* loaded from: classes6.dex */
    public class oIX0oI implements Handler.Callback {
        public oIX0oI() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            ScanActivity.this.f30801IXxxXO.Oxx0xo();
            return true;
        }
    }

    @Override // me.devilsen.czxing.view.scanview.oIX0oI
    public void I0Io(@NonNull List<CodeResult> list) {
        this.f30803Oxx0xo.I0Io();
        if (list.size() == 1) {
            CodeResult codeResult = list.get(0);
            XO(codeResult.getText(), codeResult.getFormat());
        }
    }

    @Override // me.devilsen.czxing.view.scanview.oIX0oI
    public void II0xO0(CodeResult codeResult) {
        XO(codeResult.getText(), codeResult.getFormat());
    }

    public final void Oxx0IOOO() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 1);
        }
    }

    public final void X0o0xo() {
        ScannerManager.ScanOption scanOption = (ScannerManager.ScanOption) getIntent().getParcelableExtra("option");
        if (scanOption == null) {
            return;
        }
        this.f30801IXxxXO.setBarcodeFormat(scanOption.oI0IIXIo());
        this.f30801IXxxXO.setResultColor(scanOption.IIX0o());
        this.f30801IXxxXO.xoIox(scanOption.IO());
        ScanBoxView scanBox = this.f30801IXxxXO.getScanBox();
        scanBox.setMaskColor(scanOption.xXxxox0I());
        scanBox.setCornerColor(scanOption.OxI());
        scanBox.setBorderColor(scanOption.OxxIIOOXO());
        scanBox.setBorderSize(scanOption.xoXoI());
        scanBox.IXxxXO(scanOption.o00(), scanOption.IIXOooo());
        scanBox.setScanLineColor(scanOption.ooXIXxIX());
        if (scanOption.xII()) {
            scanBox.Oxx0xo();
        }
        scanBox.setFlashLightOnDrawable(scanOption.xxX());
        scanBox.setFlashLightOffDrawable(scanOption.XI0IXoo());
        scanBox.setFlashLightOnText(scanOption.XxX0x0xxx());
        scanBox.setFlashLightOffText(scanOption.XIxXXX0x0());
        if (scanOption.X00IoxXI()) {
            scanBox.oO();
        }
        scanBox.setScanNoticeText(scanOption.oo0xXOI0I());
        this.f30801IXxxXO.setFlashLightOnDrawable(scanOption.xxX());
        this.f30801IXxxXO.setFlashLightOffDrawable(scanOption.XI0IXoo());
        this.f30801IXxxXO.setFlashLightOnText(scanOption.XxX0x0xxx());
        this.f30801IXxxXO.setFlashLightOffText(scanOption.XIxXXX0x0());
        if (scanOption.X00IoxXI()) {
            this.f30801IXxxXO.oOoXoXO();
        }
        this.f30801IXxxXO.setScanNoticeText(scanOption.oo0xXOI0I());
        this.f30801IXxxXO.Oo(scanOption.X0IIOO(), scanOption.O0xOxO(), scanOption.IoOoX(), scanOption.oo());
        String oOXoIIIo2 = scanOption.oOXoIIIo();
        if (oOXoIIIo2 != null) {
            this.f30805XO.setText(oOXoIIIo2);
        }
        if (scanOption.x0o()) {
            this.f30802Oo.setVisibility(0);
        } else {
            this.f30802Oo.setVisibility(4);
            this.f30802Oo.setOnClickListener(null);
        }
        this.f30807oI0IIXIo = scanOption.Xx000oIo();
    }

    public final void XO(String str, BarcodeFormat barcodeFormat) {
        oIX0oI.I0Io i0Io = this.f30800IIXOooo;
        if (i0Io != null) {
            i0Io.oIX0oI(this, str, barcodeFormat);
        } else {
            Intent intent = new Intent(this, (Class<?>) ResultActivity.class);
            intent.putExtra("result", str);
            startActivity(intent);
        }
        if (this.f30807oI0IIXIo) {
            this.f30806o00.sendEmptyMessageDelayed(10, 800L);
            return;
        }
        this.f30801IXxxXO.oI0IIXIo();
        this.f30801IXxxXO.OxxIIOOXO();
        finish();
    }

    @Override // me.devilsen.czxing.view.scanview.oIX0oI
    public void oIX0oI() {
        Log.e("onOpenCameraError", "onOpenCameraError");
        finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        oIX0oI.II0xO0 iI0xO0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && (iI0xO0 = this.f30808xoXoI) != null) {
            iI0xO0.II0xO0(i, intent);
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        oIX0oI.II0xO0 iI0xO0;
        int id = view.getId();
        if (id == R.id.image_scan_back) {
            finish();
        } else if (id == R.id.text_view_scan_album && (iI0xO0 = this.f30808xoXoI) != null) {
            iI0xO0.oIX0oI(this);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_camera_scan);
        II0xO0.Oxx0IOOO(false);
        xxIXOIIO.II0xO0(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_scan_title);
        ImageView imageView = (ImageView) findViewById(R.id.image_scan_back);
        this.f30805XO = (TextView) findViewById(R.id.text_view_scan_title);
        this.f30802Oo = (ImageView) findViewById(R.id.text_view_scan_album);
        this.f30801IXxxXO = (ScanLayout) findViewById(R.id.surface_view_scan);
        imageView.setOnClickListener(this);
        this.f30802Oo.setOnClickListener(this);
        this.f30801IXxxXO.setOnScanListener(this);
        ((FrameLayout.LayoutParams) linearLayout.getLayoutParams()).topMargin = xxIXOIIO.oIX0oI(this);
        this.f30800IIXOooo = oxOIoIx.oIX0oI.oIX0oI().I0Io();
        this.f30808xoXoI = oxOIoIx.oIX0oI.oIX0oI().II0xO0();
        xoIox xoiox = new xoIox();
        this.f30803Oxx0xo = xoiox;
        xoiox.II0xO0(this);
        X0o0xo();
        Oxx0IOOO();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.f30801IXxxXO.ooOOo0oXI();
        this.f30803Oxx0xo.oxoX();
        super.onDestroy();
        if (this.f30804OxxIIOOXO) {
            return;
        }
        oxOIoIx.oIX0oI.oIX0oI().X0o0xo(null);
        oxOIoIx.oIX0oI.oIX0oI().oxoX(null);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f30801IXxxXO.oI0IIXIo();
        this.f30801IXxxXO.xxIXOIIO();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                this.f30801IXxxXO.oI0IIXIo();
                this.f30801IXxxXO.Oxx0xo();
                return;
            } else {
                II0xO0.I0Io("request permission error");
                return;
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f30804OxxIIOOXO = false;
        this.f30801IXxxXO.x0XOIxOo();
        this.f30801IXxxXO.Oxx0xo();
        if (this.f30807oI0IIXIo) {
            this.f30801IXxxXO.x0xO0oo();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f30804OxxIIOOXO = true;
    }
}
