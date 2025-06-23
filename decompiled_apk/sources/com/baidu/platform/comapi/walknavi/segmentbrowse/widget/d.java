package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.widget.TextView;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class d extends TextView {
    private static final String c = "d";

    /* renamed from: a, reason: collision with root package name */
    protected int f9836a;
    protected int b;
    private Context d;
    private com.baidu.platform.comapi.walknavi.segmentbrowse.a e;
    private String f;

    public d(Context context, com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar, int i) {
        super(context);
        this.d = context;
        if (this.e == null) {
            this.e = new com.baidu.platform.comapi.walknavi.segmentbrowse.a();
        }
        this.e = aVar;
        a(-4, -3);
    }

    public void a(int i, int i2) {
        this.f9836a = i;
        this.b = i2;
    }

    public int b(Context context) {
        return b.a(context, this.f9836a + 100);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        ArrayList<c> arrayList;
        c cVar;
        Bitmap decodeResource;
        if (canvas != null && this.d != null && this.e != null) {
            canvas.save();
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setTextSize(b.a(this.d, 22.0f));
            if (!TextUtils.isEmpty(this.e.e()) && com.baidu.platform.comapi.walknavi.h.b.c.b(this.e.e()) != 0) {
                if (com.baidu.platform.comapi.wnplatform.f.a().c()) {
                    decodeResource = BitmapFactory.decodeResource(getResources(), com.baidu.platform.comapi.walknavi.h.b.c.b(this.e.e()));
                } else if (this.e.h() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.b()) {
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == null) {
                        return;
                    }
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE && com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE && com.baidu.platform.comapi.walknavi.b.a().Q() != 4) {
                        decodeResource = BitmapFactory.decodeResource(getResources(), com.baidu.platform.comapi.walknavi.h.b.c.b(this.e.e()));
                    } else {
                        decodeResource = BitmapFactory.decodeResource(getResources(), com.baidu.platform.comapi.walknavi.h.b.c.a(this.e.e()));
                    }
                } else {
                    decodeResource = BitmapFactory.decodeResource(getResources(), com.baidu.platform.comapi.walknavi.h.b.c.a(this.e.e()));
                }
                RectF a2 = a(this.d);
                if (decodeResource != null && a2 != null) {
                    try {
                        canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), a2, (Paint) null);
                    } catch (Exception unused) {
                    }
                } else {
                    return;
                }
            }
            int a3 = a(this.e);
            if (this.e.f() != null && this.e.f().size() != 0) {
                ArrayList<c> f = this.e.f();
                boolean a4 = a(f);
                int a5 = a(this.d, a3, a4);
                int size = f.size();
                if (this.e.h() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.b()) {
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE && com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE && com.baidu.platform.comapi.walknavi.b.a().Q() != 4) {
                        a(paint, -1);
                    } else {
                        a(paint, -6710887);
                    }
                } else {
                    a(paint, -6710887);
                }
                int i4 = a5;
                int i5 = 0;
                while (i5 < size) {
                    c a6 = f.get(i5).a();
                    float b = b(this.d);
                    int i6 = 0;
                    while (true) {
                        if (i6 < a6.c.length) {
                            int i7 = i6;
                            a(this.d, size, paint, a4, a6.d[i6]);
                            char[] cArr = a6.c;
                            if (cArr != null) {
                                cVar = a6;
                                i = i5;
                                i2 = i4;
                                i3 = size;
                                z = a4;
                                arrayList = f;
                                canvas.drawText(cArr, i7, 1, b, i4, paint);
                            } else {
                                cVar = a6;
                                i = i5;
                                i2 = i4;
                                i3 = size;
                                z = a4;
                                arrayList = f;
                            }
                            if (b > com.baidu.platform.comapi.wnplatform.p.h.b(this.d) - com.baidu.platform.comapi.wnplatform.p.h.a(this.d, 90)) {
                                canvas.drawText(" ...", b + paint.measureText(" ..."), i2, paint);
                                break;
                            }
                            b += paint.measureText(String.valueOf(cVar.c[i7]));
                            i4 = i2;
                            a4 = z;
                            i5 = i;
                            size = i3;
                            i6 = i7 + 1;
                            f = arrayList;
                            a6 = cVar;
                        } else {
                            i = i5;
                            i2 = i4;
                            i3 = size;
                            z = a4;
                            arrayList = f;
                            break;
                        }
                    }
                    i4 = i2 + a(this.d, z);
                    i5 = i + 1;
                    a4 = z;
                    size = i3;
                    f = arrayList;
                }
                canvas.restore();
            }
        }
    }

    public void a(com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar, String str) {
        if (this.e == null) {
            this.e = new com.baidu.platform.comapi.walknavi.segmentbrowse.a();
        }
        this.e = aVar;
        if (com.baidu.platform.comapi.wnplatform.f.a().d()) {
            this.f = str;
        } else {
            this.f = "";
        }
        postInvalidate();
    }

    public void a() {
        this.e = null;
        postInvalidate();
    }

    private void a(Paint paint, int i) {
        paint.setColor(i);
    }

    private int a(com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar) {
        if (aVar == null || aVar.f() == null) {
            return 0;
        }
        return aVar.f().size();
    }

    public RectF a(Context context) {
        return new RectF(b.a(context, this.f9836a + 27), b.a(context, this.b + 16), b.a(context, this.f9836a + 88), b.a(context, this.b + 77));
    }

    public int a(Context context, int i, boolean z) {
        if (i == 1) {
            return b.a(context, this.b + 54);
        }
        if (i != 2) {
            return 0;
        }
        if (z) {
            return b.a(context, this.b + 44);
        }
        return b.a(context, this.b + 40);
    }

    public int a(Context context, boolean z) {
        return b.a(context, 31.0f);
    }

    public boolean a(ArrayList<c> arrayList) {
        boolean z = false;
        for (int i = 0; i < arrayList.size(); i++) {
            c cVar = arrayList.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= cVar.c.length) {
                    break;
                }
                if (cVar.d[i2] == 1) {
                    z = true;
                    break;
                }
                i2++;
            }
        }
        return z;
    }

    public void a(Context context, int i, Paint paint, boolean z, int i2) {
        if (i == 1) {
            if (i2 == 1) {
                paint.setTextSize(b.a(context, 35.0f));
            } else {
                paint.setTextSize(b.a(context, 24.0f));
            }
            paint.setColor(Color.parseColor("#ffffff"));
            return;
        }
        if (!z) {
            paint.setTextSize(b.a(context, 21.0f));
            if (i2 != 5 && i2 != 3 && i2 != 4 && i2 != 6 && i2 != 7) {
                paint.setColor(Color.parseColor("#999999"));
                return;
            } else {
                paint.setColor(Color.parseColor("#ffffff"));
                return;
            }
        }
        if (i2 == 1) {
            paint.setTextSize(b.a(context, 35.0f));
            paint.setColor(Color.parseColor("#ffffff"));
            return;
        }
        paint.setTextSize(b.a(context, 18.0f));
        if (i2 != 5 && i2 != 3 && i2 != 4 && i2 != 6 && i2 != 7) {
            paint.setColor(Color.parseColor("#999999"));
        } else {
            paint.setColor(Color.parseColor("#ffffff"));
        }
    }
}
