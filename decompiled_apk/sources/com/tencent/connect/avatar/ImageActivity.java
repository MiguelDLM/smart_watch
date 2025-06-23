package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.tencent.connect.common.oIX0oI;
import com.tencent.open.utils.HttpUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;
import xoX.OOXIXo;

/* loaded from: classes13.dex */
public class ImageActivity extends Activity {

    /* renamed from: IIX0o, reason: collision with root package name */
    public Bitmap f26660IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public b f26661IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Handler f26662IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public String f26665Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public c f26667Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public Button f26668OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public xIxooxXX.II0xO0 f26672XO;

    /* renamed from: o00, reason: collision with root package name */
    public ProgressBar f26674o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public Button f26675oI0IIXIo;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public RelativeLayout f26678ooXIXxIX;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public String f26680xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public TextView f26681xoXoI;

    /* renamed from: OxI, reason: collision with root package name */
    public int f26666OxI = 0;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public boolean f26664O0xOxO = false;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public long f26669X0IIOO = 0;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f26670XI0IXoo = 0;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public final int f26671XIxXXX0x0 = ScreenUtil.SCREEN_SIZE_Y_LARGE;

    /* renamed from: xxX, reason: collision with root package name */
    public final int f26682xxX = ScreenUtil.SCREEN_SIZE_Y_LARGE;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public Rect f26673XxX0x0xxx = new Rect();

    /* renamed from: xI, reason: collision with root package name */
    public final View.OnClickListener f26679xI = new II0xO0();

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public final View.OnClickListener f26677oo0xXOI0I = new I0Io();

    /* renamed from: oo, reason: collision with root package name */
    public final o0Oo.II0xO0 f26676oo = new X0o0xo();

    /* renamed from: IoOoX, reason: collision with root package name */
    public final o0Oo.II0xO0 f26663IoOoX = new XO();

    /* loaded from: classes13.dex */
    public class I0Io implements View.OnClickListener {
        public I0Io() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.OOXIXo("10656", System.currentTimeMillis() - ImageActivity.this.f26669X0IIOO);
            ImageActivity.this.setResult(0);
            ImageActivity.this.o00();
        }
    }

    /* loaded from: classes13.dex */
    public class II0XooXoX extends View {
        public II0XooXoX(Context context) {
            super(context);
        }

        public void II0xO0(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable x0XOIxOo2 = ImageActivity.this.x0XOIxOo("com.tencent.plus.gray_normal.png");
            Drawable x0XOIxOo3 = ImageActivity.this.x0XOIxOo("com.tencent.plus.gray_down.png");
            Drawable x0XOIxOo4 = ImageActivity.this.x0XOIxOo("com.tencent.plus.gray_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, x0XOIxOo3);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, x0XOIxOo2);
            stateListDrawable.addState(View.ENABLED_STATE_SET, x0XOIxOo2);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, x0XOIxOo2);
            stateListDrawable.addState(View.EMPTY_STATE_SET, x0XOIxOo4);
            button.setBackgroundDrawable(stateListDrawable);
        }

        public void oIX0oI(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable x0XOIxOo2 = ImageActivity.this.x0XOIxOo("com.tencent.plus.blue_normal.png");
            Drawable x0XOIxOo3 = ImageActivity.this.x0XOIxOo("com.tencent.plus.blue_down.png");
            Drawable x0XOIxOo4 = ImageActivity.this.x0XOIxOo("com.tencent.plus.blue_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, x0XOIxOo3);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, x0XOIxOo2);
            stateListDrawable.addState(View.ENABLED_STATE_SET, x0XOIxOo2);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, x0XOIxOo2);
            stateListDrawable.addState(View.EMPTY_STATE_SET, x0XOIxOo4);
            button.setBackgroundDrawable(stateListDrawable);
        }
    }

    /* loaded from: classes13.dex */
    public class II0xO0 implements View.OnClickListener {

        /* loaded from: classes13.dex */
        public class oIX0oI implements Runnable {
            public oIX0oI() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageActivity.this.oI0IIXIo();
            }
        }

        public II0xO0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.f26674o00.setVisibility(0);
            ImageActivity.this.f26668OxxIIOOXO.setEnabled(false);
            ImageActivity.this.f26668OxxIIOOXO.setTextColor(Color.rgb(21, 21, 21));
            ImageActivity.this.f26675oI0IIXIo.setEnabled(false);
            ImageActivity.this.f26675oI0IIXIo.setTextColor(Color.rgb(36, 94, 134));
            new Thread(new oIX0oI()).start();
            if (ImageActivity.this.f26664O0xOxO) {
                ImageActivity.this.OOXIXo("10657", 0L);
                return;
            }
            ImageActivity.this.OOXIXo("10655", System.currentTimeMillis() - ImageActivity.this.f26669X0IIOO);
            if (ImageActivity.this.f26667Oxx0xo.f26713xxX) {
                ImageActivity.this.OOXIXo("10654", 0L);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class Oxx0IOOO extends com.tencent.connect.common.oIX0oI {
        public Oxx0IOOO(xIxooxXX.II0xO0 iI0xO0) {
            super(iI0xO0);
        }

        public void ooOOo0oXI(Bitmap bitmap, o0Oo.II0xO0 iI0xO0) {
            Bundle II0xO02 = II0xO0();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmap.recycle();
            oIX0oI.C1086oIX0oI c1086oIX0oI = new oIX0oI.C1086oIX0oI(iI0xO0);
            II0xO02.putByteArray("picture", byteArray);
            HttpUtils.oOoXoXO(this.c, XxXX.X0o0xo.oIX0oI(), "user/set_user_face", II0xO02, "POST", c1086oIX0oI);
            OOXIXo.oIX0oI().I0Io(this.c.II0XooXoX(), this.c.X0o0xo(), com.tencent.connect.common.II0xO0.f26822Xo, com.tencent.connect.common.II0xO0.f26834o0IXXIx, com.tencent.connect.common.II0xO0.f26837o0oxo0oI, "0");
        }
    }

    /* loaded from: classes13.dex */
    public class X0o0xo implements o0Oo.II0xO0 {
        public X0o0xo() {
        }

        @Override // o0Oo.II0xO0
        public void oIX0oI(o0Oo.I0Io i0Io) {
            ImageActivity.this.f26668OxxIIOOXO.setEnabled(true);
            ImageActivity.this.f26668OxxIIOOXO.setTextColor(-1);
            ImageActivity.this.f26675oI0IIXIo.setEnabled(true);
            ImageActivity.this.f26675oI0IIXIo.setTextColor(-1);
            ImageActivity.this.f26675oI0IIXIo.setText("重试");
            ImageActivity.this.f26674o00.setVisibility(8);
            ImageActivity.this.f26664O0xOxO = true;
            ImageActivity.this.xoIox(i0Io.f31122II0xO0, 1);
            ImageActivity.this.OOXIXo("10660", 0L);
        }

        @Override // o0Oo.II0xO0
        public void onCancel() {
        }

        @Override // o0Oo.II0xO0
        public void onComplete(Object obj) {
            ImageActivity.this.f26668OxxIIOOXO.setEnabled(true);
            int i = -1;
            ImageActivity.this.f26668OxxIIOOXO.setTextColor(-1);
            ImageActivity.this.f26675oI0IIXIo.setEnabled(true);
            ImageActivity.this.f26675oI0IIXIo.setTextColor(-1);
            ImageActivity.this.f26674o00.setVisibility(8);
            JSONObject jSONObject = (JSONObject) obj;
            try {
                i = jSONObject.getInt("ret");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (i == 0) {
                ImageActivity.this.xoIox("设置成功", 0);
                ImageActivity.this.OOXIXo("10658", 0L);
                OOXIXo.oIX0oI().I0Io(ImageActivity.this.f26672XO.II0XooXoX(), ImageActivity.this.f26672XO.X0o0xo(), com.tencent.connect.common.II0xO0.f26822Xo, com.tencent.connect.common.II0xO0.f26834o0IXXIx, "3", "0");
                ImageActivity imageActivity = ImageActivity.this;
                if (imageActivity.f26665Oo != null && !"".equals(ImageActivity.this.f26665Oo)) {
                    Intent intent = new Intent();
                    intent.setClassName(imageActivity, ImageActivity.this.f26665Oo);
                    if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null) {
                        imageActivity.startActivity(intent);
                    }
                }
                ImageActivity.this.XO(0, jSONObject.toString(), null, null);
                ImageActivity.this.o00();
                return;
            }
            ImageActivity.this.xoIox("设置出错了，请重新登录再尝试下呢：）", 1);
            OOXIXo.oIX0oI().I0Io(ImageActivity.this.f26672XO.II0XooXoX(), ImageActivity.this.f26672XO.X0o0xo(), com.tencent.connect.common.II0xO0.f26822Xo, com.tencent.connect.common.II0xO0.f26834o0IXXIx, com.tencent.connect.common.II0xO0.f26837o0oxo0oI, "1");
        }
    }

    /* loaded from: classes13.dex */
    public class XO implements o0Oo.II0xO0 {

        /* loaded from: classes13.dex */
        public class oIX0oI implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ String f26691XO;

            public oIX0oI(String str) {
                this.f26691XO = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageActivity.this.OxxIIOOXO(this.f26691XO);
            }
        }

        public XO() {
        }

        public final void II0xO0(int i) {
            if (ImageActivity.this.f26666OxI < 2) {
                ImageActivity.this.O0xOxO();
            }
        }

        @Override // o0Oo.II0xO0
        public void oIX0oI(o0Oo.I0Io i0Io) {
            II0xO0(0);
        }

        @Override // o0Oo.II0xO0
        public void onCancel() {
        }

        @Override // o0Oo.II0xO0
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            int i = -1;
            try {
                i = jSONObject.getInt("ret");
                if (i == 0) {
                    ImageActivity.this.f26662IXxxXO.post(new oIX0oI(jSONObject.getString("nickname")));
                    ImageActivity.this.OOXIXo("10659", 0L);
                } else {
                    ImageActivity.this.OOXIXo("10661", 0L);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (i != 0) {
                II0xO0(i);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI implements ViewTreeObserver.OnGlobalLayoutListener {
        public oIX0oI() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ImageActivity.this.f26678ooXIXxIX.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ImageActivity imageActivity = ImageActivity.this;
            imageActivity.f26673XxX0x0xxx = imageActivity.f26661IIXOooo.oIX0oI();
            ImageActivity.this.f26667Oxx0xo.oxoX(ImageActivity.this.f26673XxX0x0xxx);
        }
    }

    /* loaded from: classes13.dex */
    public class oxoX implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ int f26694Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f26695XO;

        public oxoX(String str, int i) {
            this.f26695XO = str;
            this.f26694Oo = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageActivity.this.IXxxXO(this.f26695XO, this.f26694Oo);
        }
    }

    public final void IXxxXO(String str, int i) {
        Toast makeText = Toast.makeText(this, str, 1);
        LinearLayout linearLayout = (LinearLayout) makeText.getView();
        ((TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(XxIo.II0xO0.oIX0oI(this, 16.0f), XxIo.II0xO0.oIX0oI(this, 16.0f)));
        if (i == 0) {
            imageView.setImageDrawable(x0XOIxOo("com.tencent.plus.ic_success.png"));
        } else {
            imageView.setImageDrawable(x0XOIxOo("com.tencent.plus.ic_error.png"));
        }
        linearLayout.addView(imageView, 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        makeText.setView(linearLayout);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    public final void O0xOxO() {
        this.f26666OxI++;
        new Ix0.II0xO0(this, this.f26672XO).x0XOIxOo(this.f26663IoOoX);
    }

    public void OOXIXo(String str, long j) {
        com.tencent.open.utils.II0xO0.x0XOIxOo(this, str, j, this.f26672XO.X0o0xo());
    }

    public final void Oxx0IOOO(Bitmap bitmap) {
        new Oxx0IOOO(this.f26672XO).ooOOo0oXI(bitmap, this.f26676oo);
    }

    public final void OxxIIOOXO(String str) {
        String xoXoI2 = xoXoI(str);
        if (!"".equals(xoXoI2)) {
            this.f26681xoXoI.setText(xoXoI2);
            this.f26681xoXoI.setVisibility(0);
        }
    }

    public final void XO(int i, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra(com.tencent.connect.common.II0xO0.f26739IIX0, i);
        intent.putExtra(com.tencent.connect.common.II0xO0.f26893xOoOIoI, str2);
        intent.putExtra(com.tencent.connect.common.II0xO0.f26786Ox0O, str3);
        intent.putExtra(com.tencent.connect.common.II0xO0.f26765O0X, str);
        setResult(-1, intent);
    }

    public final void o00() {
        finish();
        int i = this.f26670XI0IXoo;
        if (i != 0) {
            overridePendingTransition(0, i);
        }
    }

    public final void oI0IIXIo() {
        int i;
        int i2;
        float width = this.f26673XxX0x0xxx.width();
        Matrix imageMatrix = this.f26667Oxx0xo.getImageMatrix();
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float f4 = 640.0f / width;
        Rect rect = this.f26673XxX0x0xxx;
        int i3 = (int) ((rect.left - f) / f3);
        if (i3 < 0) {
            i = 0;
        } else {
            i = i3;
        }
        int i4 = (int) ((rect.top - f2) / f3);
        if (i4 < 0) {
            i2 = 0;
        } else {
            i2 = i4;
        }
        Matrix matrix = new Matrix();
        matrix.set(imageMatrix);
        matrix.postScale(f4, f4);
        int i5 = (int) (650.0f / f3);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.f26660IIX0o, i, i2, Math.min(this.f26660IIX0o.getWidth() - i, i5), Math.min(this.f26660IIX0o.getHeight() - i2, i5), matrix, true);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, ScreenUtil.SCREEN_SIZE_Y_LARGE, ScreenUtil.SCREEN_SIZE_Y_LARGE);
            createBitmap.recycle();
            Oxx0IOOO(createBitmap2);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            xoIox(com.tencent.connect.common.II0xO0.f26819XX0xXo, 1);
            XO(-5, null, com.tencent.connect.common.II0xO0.f26819XX0xXo, e.getMessage());
            o00();
        }
    }

    public final Bitmap oIX0oI(String str) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        Uri parse = Uri.parse(str);
        InputStream openInputStream = getContentResolver().openInputStream(parse);
        if (openInputStream == null) {
            return null;
        }
        try {
            BitmapFactory.decodeStream(openInputStream, null, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        openInputStream.close();
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        while (i2 * i3 > 4194304) {
            i2 /= 2;
            i3 /= 2;
            i *= 2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(parse), null, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void oO() {
        Bitmap oIX0oI2;
        try {
            oIX0oI2 = oIX0oI(this.f26680xXxxox0I);
            this.f26660IIX0o = oIX0oI2;
        } catch (IOException e) {
            e.printStackTrace();
            xoIox(com.tencent.connect.common.II0xO0.f26819XX0xXo, 1);
            XO(-5, null, com.tencent.connect.common.II0xO0.f26819XX0xXo, e.getMessage());
            o00();
        }
        if (oIX0oI2 != null) {
            this.f26667Oxx0xo.setImageBitmap(oIX0oI2);
            this.f26675oI0IIXIo.setOnClickListener(this.f26679xI);
            this.f26668OxxIIOOXO.setOnClickListener(this.f26677oo0xXOI0I);
            this.f26678ooXIXxIX.getViewTreeObserver().addOnGlobalLayoutListener(new oIX0oI());
            return;
        }
        throw new IOException("cannot read picture: '" + this.f26680xXxxox0I + "'!");
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        o00();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(oxoX());
        this.f26662IXxxXO = new Handler();
        Bundle bundleExtra = getIntent().getBundleExtra(com.tencent.connect.common.II0xO0.f26852oXIO0o0XI);
        this.f26680xXxxox0I = bundleExtra.getString("picture");
        this.f26665Oo = bundleExtra.getString("return_activity");
        String string = bundleExtra.getString("appid");
        String string2 = bundleExtra.getString("access_token");
        long j = bundleExtra.getLong("expires_in");
        String string3 = bundleExtra.getString("openid");
        this.f26670XI0IXoo = bundleExtra.getInt("exitAnim");
        xIxooxXX.II0xO0 iI0xO0 = new xIxooxXX.II0xO0(string);
        this.f26672XO = iI0xO0;
        iI0xO0.x0XOIxOo(string2, ((j - System.currentTimeMillis()) / 1000) + "");
        this.f26672XO.Oo(string3);
        oO();
        O0xOxO();
        this.f26669X0IIOO = System.currentTimeMillis();
        OOXIXo("10653", 0L);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f26667Oxx0xo.setImageBitmap(null);
        Bitmap bitmap = this.f26660IIX0o;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f26660IIX0o.recycle();
        }
    }

    public final View oxoX() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f26678ooXIXxIX = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.f26678ooXIXxIX.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setLayoutParams(layoutParams3);
        this.f26678ooXIXxIX.addView(relativeLayout2);
        c cVar = new c(this);
        this.f26667Oxx0xo = cVar;
        cVar.setLayoutParams(layoutParams2);
        this.f26667Oxx0xo.setScaleType(ImageView.ScaleType.MATRIX);
        relativeLayout2.addView(this.f26667Oxx0xo);
        this.f26661IIXOooo = new b(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(layoutParams2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(15, -1);
        this.f26661IIXOooo.setLayoutParams(layoutParams4);
        relativeLayout2.addView(this.f26661IIXOooo);
        LinearLayout linearLayout = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, XxIo.II0xO0.oIX0oI(this, 80.0f));
        layoutParams5.addRule(14, -1);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.f26678ooXIXxIX.addView(linearLayout);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(XxIo.II0xO0.oIX0oI(this, 24.0f), XxIo.II0xO0.oIX0oI(this, 24.0f)));
        imageView.setImageDrawable(x0XOIxOo("com.tencent.plus.logo.png"));
        linearLayout.addView(imageView);
        this.f26681xoXoI = new TextView(this);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(layoutParams3);
        layoutParams6.leftMargin = XxIo.II0xO0.oIX0oI(this, 7.0f);
        this.f26681xoXoI.setLayoutParams(layoutParams6);
        this.f26681xoXoI.setEllipsize(TextUtils.TruncateAt.END);
        this.f26681xoXoI.setSingleLine();
        this.f26681xoXoI.setTextColor(-1);
        this.f26681xoXoI.setTextSize(24.0f);
        this.f26681xoXoI.setVisibility(8);
        linearLayout.addView(this.f26681xoXoI);
        RelativeLayout relativeLayout3 = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, XxIo.II0xO0.oIX0oI(this, 60.0f));
        layoutParams7.addRule(12, -1);
        layoutParams7.addRule(9, -1);
        relativeLayout3.setLayoutParams(layoutParams7);
        relativeLayout3.setBackgroundDrawable(x0XOIxOo("com.tencent.plus.bar.png"));
        int oIX0oI2 = XxIo.II0xO0.oIX0oI(this, 10.0f);
        relativeLayout3.setPadding(oIX0oI2, oIX0oI2, oIX0oI2, 0);
        this.f26678ooXIXxIX.addView(relativeLayout3);
        II0XooXoX iI0XooXoX = new II0XooXoX(this);
        int oIX0oI3 = XxIo.II0xO0.oIX0oI(this, 14.0f);
        int oIX0oI4 = XxIo.II0xO0.oIX0oI(this, 7.0f);
        this.f26668OxxIIOOXO = new Button(this);
        this.f26668OxxIIOOXO.setLayoutParams(new RelativeLayout.LayoutParams(XxIo.II0xO0.oIX0oI(this, 78.0f), XxIo.II0xO0.oIX0oI(this, 45.0f)));
        this.f26668OxxIIOOXO.setText("取消");
        this.f26668OxxIIOOXO.setTextColor(-1);
        this.f26668OxxIIOOXO.setTextSize(18.0f);
        this.f26668OxxIIOOXO.setPadding(oIX0oI3, oIX0oI4, oIX0oI3, oIX0oI4);
        iI0XooXoX.II0xO0(this.f26668OxxIIOOXO);
        relativeLayout3.addView(this.f26668OxxIIOOXO);
        this.f26675oI0IIXIo = new Button(this);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(XxIo.II0xO0.oIX0oI(this, 78.0f), XxIo.II0xO0.oIX0oI(this, 45.0f));
        layoutParams8.addRule(11, -1);
        this.f26675oI0IIXIo.setLayoutParams(layoutParams8);
        this.f26675oI0IIXIo.setTextColor(-1);
        this.f26675oI0IIXIo.setTextSize(18.0f);
        this.f26675oI0IIXIo.setPadding(oIX0oI3, oIX0oI4, oIX0oI3, oIX0oI4);
        this.f26675oI0IIXIo.setText("选取");
        iI0XooXoX.oIX0oI(this.f26675oI0IIXIo);
        relativeLayout3.addView(this.f26675oI0IIXIo);
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams9.addRule(13, -1);
        textView.setLayoutParams(layoutParams9);
        textView.setText("移动和缩放");
        textView.setPadding(0, XxIo.II0xO0.oIX0oI(this, 3.0f), 0, 0);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        relativeLayout3.addView(textView);
        this.f26674o00 = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams10.addRule(14, -1);
        layoutParams10.addRule(15, -1);
        this.f26674o00.setLayoutParams(layoutParams10);
        this.f26674o00.setVisibility(8);
        this.f26678ooXIXxIX.addView(this.f26674o00);
        return this.f26678ooXIXxIX;
    }

    public final Drawable x0XOIxOo(String str) {
        return com.tencent.open.utils.II0xO0.II0xO0(str, this);
    }

    public final void xoIox(String str, int i) {
        this.f26662IXxxXO.post(new oxoX(str, i));
    }

    public final String xoXoI(String str) {
        return str.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", "&");
    }
}
