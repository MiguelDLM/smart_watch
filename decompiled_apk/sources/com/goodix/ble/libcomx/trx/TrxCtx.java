package com.goodix.ble.libcomx.trx;

/* loaded from: classes9.dex */
public class TrxCtx {
    private boolean available;
    private final TrxHandler handler;
    final String name;
    TrxCtx nextTrxCtx;
    private boolean pause;
    TrxCtx prevTrxCtx;
    private final TrxChain trxChain;

    public TrxCtx(String str, TrxHandler trxHandler, TrxChain trxChain) {
        this.name = str;
        this.handler = trxHandler;
        this.trxChain = trxChain;
    }

    public void create() {
        boolean z;
        synchronized (this) {
            try {
                if (!this.available) {
                    z = true;
                    this.available = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            this.handler.onCreate(this);
        }
    }

    public synchronized void destroy() {
        boolean z;
        synchronized (this) {
            try {
                z = false;
                if (this.available) {
                    this.available = false;
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            this.handler.onDestroy(this);
        }
    }

    public TrxChain getChain() {
        return this.trxChain;
    }

    public TrxHandler getHandler() {
        return this.handler;
    }

    public void handlePostRxComplete(Object obj) {
        if (this.pause) {
            notifyRxComplete(obj);
            return;
        }
        try {
            this.handler.onPostRxComplete(this, obj);
        } catch (Throwable th) {
            this.handler.onException(this, th);
        }
    }

    public void handlePostTxComplete(Object obj) {
        if (this.pause) {
            notifyTxComplete(obj);
            return;
        }
        try {
            this.handler.onPostTxComplete(this, obj);
        } catch (Throwable th) {
            this.handler.onException(this, th);
        }
    }

    public void handleRx(Object obj) {
        if (this.pause) {
            postRx(obj);
            return;
        }
        try {
            this.handler.onRx(this, obj);
        } catch (Throwable th) {
            this.handler.onException(this, th);
        }
    }

    public void handleTx(Object obj) {
        if (this.pause) {
            postTx(obj);
            return;
        }
        try {
            this.handler.onTx(this, obj);
        } catch (Throwable th) {
            this.handler.onException(this, th);
        }
    }

    public boolean isAvailable() {
        return this.available;
    }

    public boolean isPause() {
        return this.pause;
    }

    public void notifyReady(boolean z) {
        this.handler.onReady(this, z);
    }

    public void notifyRxComplete(Object obj) {
        TrxCtx trxCtx = this.prevTrxCtx;
        if (trxCtx != null) {
            trxCtx.handlePostRxComplete(obj);
        }
    }

    public void notifyTxComplete(Object obj) {
        TrxCtx trxCtx = this.nextTrxCtx;
        if (trxCtx != null) {
            trxCtx.handlePostTxComplete(obj);
        }
    }

    public void postRx(Object obj) {
        TrxCtx trxCtx = this.nextTrxCtx;
        if (trxCtx != null) {
            trxCtx.handleRx(obj);
        } else {
            notifyRxComplete(obj);
        }
    }

    public void postTx(Object obj) {
        TrxCtx trxCtx = this.prevTrxCtx;
        if (trxCtx != null) {
            trxCtx.handleTx(obj);
        } else {
            notifyTxComplete(obj);
        }
    }

    public void send(Object obj) {
        this.trxChain.send(obj);
    }

    public void setPause(boolean z) {
        this.pause = z;
        this.handler.onPause(this, z);
    }
}
