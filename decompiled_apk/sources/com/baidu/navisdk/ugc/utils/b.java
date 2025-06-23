package com.baidu.navisdk.ugc.utils;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.c0;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private JNIBaseMap f8330a = null;
    private c b = null;
    private Handler c = null;
    private com.baidu.navisdk.util.worker.loop.b d = new HandlerC0402b("UgcScreenShot");

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_ScreenShot", "ugc ScreenShot timeout 1.5s");
            }
            b.this.a((String) null);
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.utils.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC0402b extends com.baidu.navisdk.util.worker.loop.b {
        public HandlerC0402b(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4616);
        }

        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(Message message) {
            if (message.what == 4616) {
                if (b.this.c != null) {
                    b.this.c.removeMessages(16);
                }
                String str = null;
                try {
                    if (b.this.f8330a != null) {
                        Bundle bundle = new Bundle();
                        b.this.f8330a.getScreenShotImage(bundle);
                        Bitmap createBitmap = Bitmap.createBitmap(bundle.getIntArray("pbtImageData"), bundle.getInt("unImageWidth"), bundle.getInt("unImageHeight"), Bitmap.Config.ARGB_8888);
                        if (createBitmap != null && !createBitmap.isRecycled()) {
                            Bitmap a2 = c0.a(createBitmap, 600, 800);
                            if (a2 != null && !a2.isRecycled()) {
                                str = c0.a(a2);
                                b.this.a(a2);
                            }
                            b.this.a(createBitmap);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                    if (gVar.d()) {
                        gVar.e("UgcModule_ScreenShot", "ugc ScreenShot exception:" + e.toString());
                    }
                }
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
                if (gVar2.d()) {
                    gVar2.e("UgcModule_ScreenShot", "jni return screenshot filePath: " + str);
                }
                b.this.a(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(String str);
    }

    public void a(int i, c cVar) {
        a(i, cVar, 1500L);
    }

    public void a(int i, c cVar, long j) {
        int widthPixels;
        int heightPixels;
        if (this.f8330a == null) {
            this.f8330a = new JNIBaseMap();
        }
        com.baidu.navisdk.vi.b.a(this.d);
        this.b = cVar;
        ScreenUtil screenUtil = ScreenUtil.getInstance();
        if (i == 1) {
            widthPixels = screenUtil.getWidthPixels();
            heightPixels = screenUtil.getHeightPixels() - ScreenUtil.getInstance().dip2px(120);
        } else {
            widthPixels = (screenUtil.getWidthPixels() * 2) / 3;
            heightPixels = screenUtil.getHeightPixels();
        }
        if (!this.f8330a.setScreenShotParam(4, widthPixels, heightPixels, 0L, 0L, 0)) {
            a((String) null);
            return;
        }
        a aVar = new a("UgcScreenShot");
        this.c = aVar;
        aVar.sendEmptyMessageDelayed(16, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        if (!com.baidu.navisdk.k.f6861a || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.baidu.navisdk.util.worker.loop.b bVar = this.d;
        if (bVar != null) {
            com.baidu.navisdk.vi.b.b(bVar);
            this.d.removeCallbacksAndMessages(null);
            this.d = null;
        }
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(str);
        }
        this.b = null;
        this.f8330a = null;
        Handler handler = this.c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.c = null;
        }
    }

    public void a() {
        this.b = null;
        a((String) null);
    }
}
