package com.baidu.ar;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes7.dex */
public class nm {
    private int HD;
    private a HE;
    private Handler HF;
    private b HG;

    /* loaded from: classes7.dex */
    public interface a {
        void onTick();
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        private a HE;
        private int HH;
        private Handler mHandler;

        public b(Handler handler, int i, a aVar) {
            this.HH = i;
            this.mHandler = handler;
            this.HE = aVar;
        }

        public void release() {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            this.HE = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mHandler != null) {
                if (this.HE != null && nm.this.HD > 0) {
                    this.HE.onTick();
                }
                this.mHandler.postDelayed(this, this.HH);
            }
        }
    }

    public nm(int i) {
        this.HD = i;
    }

    public void iR() {
        Handler handler = this.HF;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.HF.removeCallbacks(this.HG);
            b bVar = this.HG;
            if (bVar != null) {
                bVar.release();
                this.HG = null;
            }
            this.HF = null;
            this.HD = 0;
            this.HE = null;
        }
    }

    public void startTimer() {
        Handler handler = new Handler(Looper.myLooper());
        this.HF = handler;
        b bVar = new b(handler, this.HD, this.HE);
        this.HG = bVar;
        this.HF.post(bVar);
    }

    public void a(a aVar) {
        this.HE = aVar;
    }
}
