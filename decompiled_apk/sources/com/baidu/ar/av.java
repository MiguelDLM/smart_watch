package com.baidu.ar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.baidu.ar.arplay.core.engine.ARPEngine;

/* loaded from: classes7.dex */
public class av extends WebView {
    private a ij;
    private boolean ik;

    /* loaded from: classes7.dex */
    public static class a {
        public int gb;
        public int height;

        /* renamed from: io, reason: collision with root package name */
        public boolean f5562io;
        public String ip;
        public String url;
        public int width;
    }

    public av(Context context) {
        super(context);
        this.ik = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.ij == null || canvas == null || !this.ik) {
            return;
        }
        final ax m = ay.bl().m(this.ij.gb);
        if (m == null) {
            Log.e("GLWebView", "HtmlTextureHolder is null: mTextureId: " + this.ij.gb);
            return;
        }
        Canvas lockCanvas = m.lockCanvas();
        if (lockCanvas != null) {
            float width = lockCanvas.getWidth() / canvas.getWidth();
            lockCanvas.scale(width, width);
            lockCanvas.translate(-getScrollX(), -getScrollY());
            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.draw(lockCanvas);
        }
        m.bk();
        ARPEngine.getInstance().getARPRenderer().runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.av.1
            @Override // java.lang.Runnable
            public void run() {
                ax axVar = m;
                if (axVar != null) {
                    axVar.update();
                    av.this.ik = false;
                }
            }
        });
    }

    public a getWebViewData() {
        return this.ij;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setIsNeedRender(boolean z) {
        this.ik = z;
    }

    public void setWebViewData(a aVar) {
        this.ij = aVar;
    }
}
