package com.baidu.ar.databasic;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.arrender.IARRenderer;
import com.baidu.ar.kf;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class AlgoHandleController {
    private HandlerThread om;
    private a on;
    private final List<Long> oj = Collections.synchronizedList(new ArrayList());
    private boolean ok = true;
    private int mType = 0;
    private long ol = 0;

    /* loaded from: classes7.dex */
    public static final class a extends Handler {
        private boolean os;

        public a(Looper looper) {
            super(looper);
            this.os = false;
        }

        public void a(int i, Runnable runnable) {
            if (this.os) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = runnable;
            sendMessage(obtain);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1004) {
                this.os = true;
            }
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public AlgoHandleController() {
        if (this.om == null) {
            HandlerThread handlerThread = new HandlerThread("HandleHandlerThread");
            this.om = handlerThread;
            handlerThread.start();
        }
        if (this.on == null) {
            this.on = new a(this.om.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL() {
        this.ok = false;
        if (this.oj.size() > 0) {
            try {
                Iterator<Long> it = this.oj.iterator();
                while (it.hasNext()) {
                    long longValue = it.next().longValue();
                    if (longValue <= 0 || longValue != this.ol) {
                        AlgoHandleAdapter.destroyHandle(longValue);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                kf.cl("release Exception:" + e.getMessage());
            }
        }
        if (this.on != null) {
            this.on = null;
        }
        HandlerThread handlerThread = this.om;
        if (handlerThread != null) {
            handlerThread.quit();
            this.om = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(long j) {
        e(j);
        return AlgoHandleAdapter.destroyHandle(j);
    }

    private void e(long j) {
        try {
            if (this.oj.contains(Long.valueOf(j))) {
                int indexOf = this.oj.indexOf(Long.valueOf(j));
                if (indexOf >= 0) {
                    this.oj.remove(indexOf);
                    if (indexOf >= 1) {
                        s(indexOf);
                    }
                } else {
                    kf.cl("removeHandle cant find:" + j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            kf.cl("removeHandle Exception:" + e.getMessage());
        }
    }

    private void s(int i) {
        if (i > 5) {
            kf.ck("type:" + this.mType + " destroyIgnoreHandles current size:" + i);
            for (int i2 = 0; i2 < i; i2++) {
                long longValue = this.oj.get(0).longValue();
                this.oj.remove(0);
                AlgoHandleAdapter.destroyHandle(longValue);
            }
        }
    }

    public long createHandle() {
        a aVar;
        if (!this.ok) {
            return 0L;
        }
        final long createHandle = AlgoHandleAdapter.createHandle();
        HandlerThread handlerThread = this.om;
        if (handlerThread != null && handlerThread.isAlive() && (aVar = this.on) != null) {
            aVar.a(1001, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.3
                @Override // java.lang.Runnable
                public void run() {
                    AlgoHandleController.this.oj.add(Long.valueOf(createHandle));
                }
            });
        }
        return createHandle;
    }

    public int destroyHandle(final long j) {
        a aVar;
        HandlerThread handlerThread = this.om;
        if (handlerThread == null || !handlerThread.isAlive() || (aVar = this.on) == null) {
            return -1;
        }
        aVar.a(1003, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.4
            @Override // java.lang.Runnable
            public void run() {
                AlgoHandleController.this.d(j);
            }
        });
        return 0;
    }

    public byte[] getHandleMaskData(long j) {
        return AlgoHandleAdapter.getHandleMaskData(j);
    }

    public int getHandleReserveData(long j, ReserveHandleData reserveHandleData) {
        return AlgoHandleAdapter.getHandleReserveData(j, reserveHandleData);
    }

    public int getHandleType(long j) {
        return AlgoHandleAdapter.getHandleType(j);
    }

    public int increaseHandleReference(long j) {
        return AlgoHandleAdapter.increaseHandleReference(j);
    }

    public void release() {
        a aVar;
        this.ok = false;
        HandlerThread handlerThread = this.om;
        if (handlerThread == null || !handlerThread.isAlive() || (aVar = this.on) == null) {
            return;
        }
        aVar.a(1004, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.2
            @Override // java.lang.Runnable
            public void run() {
                AlgoHandleController.this.cL();
            }
        });
    }

    public void sendHandleToRenderer(final long j, final IARRenderer iARRenderer, final String str) {
        a aVar;
        HandlerThread handlerThread = this.om;
        if (handlerThread == null || !handlerThread.isAlive() || (aVar = this.on) == null) {
            return;
        }
        aVar.a(1002, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.1
            @Override // java.lang.Runnable
            public void run() {
                IARRenderer iARRenderer2 = iARRenderer;
                if (iARRenderer2 != null) {
                    iARRenderer2.setAlgoHandleData(j, str);
                }
            }
        });
    }

    public int setHandleFaceHandle(long j, long j2) {
        return AlgoHandleAdapter.setHandleFaceHandle(j, j2);
    }

    public int setHandleInput(long j, int i, long j2, int i2, int i3, int i4, boolean z, int i5, boolean z2, ByteBuffer byteBuffer) {
        this.mType = i;
        return AlgoHandleAdapter.setHandleInput(j, i, j2, i2, i3, i4, z, i5, z2, byteBuffer);
    }

    public int setHandleMaskThreshold(long j, float f) {
        return AlgoHandleAdapter.setHandleMaskThreshold(j, f);
    }

    public void setUsingHandle(long j) {
        this.ol = j;
    }
}
