package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.TextView;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class a extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private Context f9834a;
    private ArrayList<String> b;
    private int c;
    private int d;

    public a(Context context, ArrayList<String> arrayList, int i, int i2) {
        super(context);
        this.f9834a = context;
        this.b = arrayList;
        this.c = i;
        this.d = i2;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        com.baidu.platform.comapi.wnplatform.d.a.a("AutoTextView.onDraw", " canvas" + canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        if (this.c == -1) {
            paint.setColor(-13400577);
        } else {
            paint.setColor(-13400577);
        }
        paint.setTextSize(b.a(this.f9834a, 22.0f));
        if (this.d != -1) {
            Bitmap decodeResource = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.p.a.a.b(), this.d);
            RectF rectF = new RectF(b.a(this.f9834a, 27.0f), b.a(this.f9834a, 21.0f), b.a(this.f9834a, 80.0f), b.a(this.f9834a, 74.0f));
            if (decodeResource != null) {
                try {
                    canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), rectF, (Paint) null);
                } catch (Exception unused) {
                }
            }
        }
        ArrayList<String> arrayList = this.b;
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                canvas.drawText(this.b.get(0), b.a(this.f9834a, 100.0f), b.a(this.f9834a, 51.0f), paint);
            } else if (this.b.size() == 2) {
                int a2 = b.a(this.f9834a, 40.0f);
                float a3 = b.a(this.f9834a, 100.0f);
                canvas.drawText(this.b.get(0), a3, a2, paint);
                paint.setTextSize(b.a(this.f9834a, 18.0f));
                canvas.drawText(this.b.get(1), a3, a2 + b.a(this.f9834a, 30.0f), paint);
            }
        }
    }
}
