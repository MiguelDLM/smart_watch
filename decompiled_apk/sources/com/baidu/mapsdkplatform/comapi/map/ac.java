package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mapapi.common.SysOSUtil;

/* loaded from: classes7.dex */
public class ac extends LinearLayout implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f6176a;
    private ImageView b;
    private Context c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap g;
    private Bitmap h;
    private Bitmap i;
    private Bitmap j;
    private Bitmap k;
    private int l;
    private boolean m;
    private boolean n;

    @Deprecated
    public ac(Context context) {
        super(context);
        this.m = false;
        this.n = false;
        this.c = context;
        c();
        if (this.d == null || this.e == null || this.f == null || this.g == null) {
            return;
        }
        this.f6176a = new ImageView(this.c);
        this.b = new ImageView(this.c);
        this.f6176a.setImageBitmap(this.d);
        this.b.setImageBitmap(this.f);
        this.l = a(this.f.getHeight() / 6);
        a(this.f6176a, "main_topbtn_up.9.png");
        a(this.b, "main_bottombtn_up.9.png");
        this.f6176a.setId(0);
        this.b.setId(1);
        this.f6176a.setClickable(true);
        this.b.setClickable(true);
        this.f6176a.setOnTouchListener(this);
        this.b.setOnTouchListener(this);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f6176a);
        addView(this.b);
        this.n = true;
    }

    private void c() {
        this.d = a("main_icon_zoomin.png");
        this.e = a("main_icon_zoomin_dis.png");
        this.f = a("main_icon_zoomout.png");
        this.g = a("main_icon_zoomout_dis.png");
    }

    private void d() {
        this.h = a("wear_zoom_in.png");
        this.i = a("wear_zoom_in_pressed.png");
        this.j = a("wear_zoon_out.png");
        this.k = a("wear_zoom_out_pressed.png");
    }

    public boolean a() {
        return this.n;
    }

    public void b(boolean z) {
        ImageView imageView = this.b;
        if (imageView == null) {
            return;
        }
        imageView.setEnabled(z);
        if (!z) {
            this.b.setImageBitmap(this.g);
        } else {
            this.b.setImageBitmap(this.f);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view instanceof ImageView) {
            int id = ((ImageView) view).getId();
            if (id != 0) {
                if (id == 1) {
                    if (motionEvent.getAction() == 0) {
                        if (!this.m) {
                            a(this.b, "main_bottombtn_down.9.png");
                            return false;
                        }
                        this.b.setImageBitmap(this.k);
                        return false;
                    }
                    if (motionEvent.getAction() == 1) {
                        if (!this.m) {
                            a(this.b, "main_bottombtn_up.9.png");
                            return false;
                        }
                        this.b.setImageBitmap(this.j);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            if (motionEvent.getAction() == 0) {
                if (!this.m) {
                    a(this.f6176a, "main_topbtn_down.9.png");
                    return false;
                }
                this.f6176a.setImageBitmap(this.i);
                return false;
            }
            if (motionEvent.getAction() == 1) {
                if (!this.m) {
                    a(this.f6176a, "main_topbtn_up.9.png");
                    return false;
                }
                this.f6176a.setImageBitmap(this.h);
                return false;
            }
            return false;
        }
        return false;
    }

    private void a(View view, String str) {
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.c);
        byte[] ninePatchChunk = a2.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        view.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
        int i = this.l;
        view.setPadding(i, i, i, i);
    }

    public void b(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    public void b() {
        Bitmap bitmap = this.d;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.d.recycle();
            this.d = null;
        }
        Bitmap bitmap2 = this.e;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.e.recycle();
            this.e = null;
        }
        Bitmap bitmap3 = this.f;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            this.f.recycle();
            this.f = null;
        }
        Bitmap bitmap4 = this.g;
        if (bitmap4 != null && !bitmap4.isRecycled()) {
            this.g.recycle();
            this.g = null;
        }
        Bitmap bitmap5 = this.h;
        if (bitmap5 != null && !bitmap5.isRecycled()) {
            this.h.recycle();
            this.h = null;
        }
        Bitmap bitmap6 = this.i;
        if (bitmap6 != null && !bitmap6.isRecycled()) {
            this.i.recycle();
            this.i = null;
        }
        Bitmap bitmap7 = this.j;
        if (bitmap7 != null && !bitmap7.isRecycled()) {
            this.j.recycle();
            this.j = null;
        }
        Bitmap bitmap8 = this.k;
        if (bitmap8 == null || bitmap8.isRecycled()) {
            return;
        }
        this.k.recycle();
        this.k = null;
    }

    public void a(boolean z) {
        ImageView imageView = this.f6176a;
        if (imageView == null) {
            return;
        }
        imageView.setEnabled(z);
        if (!z) {
            this.f6176a.setImageBitmap(this.e);
        } else {
            this.f6176a.setImageBitmap(this.d);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.f6176a.setOnClickListener(onClickListener);
    }

    private Bitmap a(String str) {
        Matrix matrix = new Matrix();
        int densityDpi = SysOSUtil.getDensityDpi();
        if (densityDpi > 480) {
            matrix.postScale(1.8f, 1.8f);
        } else if (densityDpi > 320 && densityDpi <= 480) {
            matrix.postScale(1.5f, 1.5f);
        } else {
            matrix.postScale(1.2f, 1.2f);
        }
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.c);
        if (a2 == null) {
            return null;
        }
        return Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
    }

    private int a(int i) {
        return (int) ((this.c.getResources().getDisplayMetrics().density * i) + 0.5f);
    }

    public ac(Context context, boolean z) {
        super(context);
        this.n = false;
        this.c = context;
        this.m = z;
        this.f6176a = new ImageView(this.c);
        this.b = new ImageView(this.c);
        if (z) {
            d();
            if (this.h == null || this.i == null || this.j == null || this.k == null) {
                return;
            }
            this.f6176a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f6176a.setImageBitmap(this.h);
            this.b.setImageBitmap(this.j);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(0);
        } else {
            c();
            Bitmap bitmap = this.d;
            if (bitmap == null || this.e == null || this.f == null || this.g == null) {
                return;
            }
            this.f6176a.setImageBitmap(bitmap);
            this.b.setImageBitmap(this.f);
            this.l = a(this.f.getHeight() / 6);
            a(this.f6176a, "main_topbtn_up.9.png");
            a(this.b, "main_bottombtn_up.9.png");
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(1);
        }
        this.f6176a.setId(0);
        this.b.setId(1);
        this.f6176a.setClickable(true);
        this.b.setClickable(true);
        this.f6176a.setOnTouchListener(this);
        this.b.setOnTouchListener(this);
        addView(this.f6176a);
        addView(this.b);
        this.n = true;
    }
}
