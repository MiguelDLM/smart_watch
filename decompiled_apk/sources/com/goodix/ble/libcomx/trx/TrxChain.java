package com.goodix.ble.libcomx.trx;

import com.goodix.ble.libcomx.event.Event;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes9.dex */
public class TrxChain implements ITrx {
    CopyOnWriteArrayList<TrxCtx> trxCtxList = new CopyOnWriteArrayList<>();
    boolean ready = false;
    TrxCtx trxCtxHead = null;
    TrxCtx trxCtxTail = new TrxCtx("ChainTail", new TrxChainTail(), this);
    private Event<Boolean> eventReady = new Event<>(this, -274142511);
    private Event<Object> eventTx = new Event<>(this, ITrx.EVT_TX);
    private Event<Object> eventRx = new Event<>(this, ITrx.EVT_RX);

    public TrxChain addFirst(String str, TrxHandler trxHandler) {
        CopyOnWriteArrayList<TrxCtx> copyOnWriteArrayList = this.trxCtxList;
        TrxCtx trxCtx = new TrxCtx(str, trxHandler, this);
        trxCtx.prevTrxCtx = this.trxCtxHead;
        trxCtx.nextTrxCtx = this.trxCtxTail;
        if (!copyOnWriteArrayList.isEmpty()) {
            TrxCtx trxCtx2 = copyOnWriteArrayList.get(0);
            trxCtx2.prevTrxCtx = trxCtx;
            trxCtx.nextTrxCtx = trxCtx2;
        }
        copyOnWriteArrayList.add(0, trxCtx);
        trxCtx.create();
        return this;
    }

    public TrxChain addLast(String str, TrxHandler trxHandler) {
        CopyOnWriteArrayList<TrxCtx> copyOnWriteArrayList = this.trxCtxList;
        TrxCtx trxCtx = new TrxCtx(str, trxHandler, this);
        trxCtx.prevTrxCtx = this.trxCtxHead;
        trxCtx.nextTrxCtx = this.trxCtxTail;
        if (!copyOnWriteArrayList.isEmpty()) {
            TrxCtx trxCtx2 = copyOnWriteArrayList.get(copyOnWriteArrayList.size() - 1);
            trxCtx2.nextTrxCtx = trxCtx;
            trxCtx.prevTrxCtx = trxCtx2;
        }
        copyOnWriteArrayList.add(trxCtx);
        trxCtx.create();
        return this;
    }

    public void clear() {
        CopyOnWriteArrayList<TrxCtx> copyOnWriteArrayList = this.trxCtxList;
        Iterator<TrxCtx> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        copyOnWriteArrayList.clear();
    }

    @Override // com.goodix.ble.libcomx.trx.ITrx
    public Event<Boolean> evtReady() {
        return this.eventReady;
    }

    @Override // com.goodix.ble.libcomx.trx.ITrx
    public Event<Object> evtRx() {
        return this.eventRx;
    }

    @Override // com.goodix.ble.libcomx.trx.ITrx
    public Event<Object> evtTx() {
        return this.eventTx;
    }

    public TrxCtx get(String str) {
        if (str != null) {
            Iterator<TrxCtx> it = this.trxCtxList.iterator();
            while (it.hasNext()) {
                TrxCtx next = it.next();
                if (str.equals(next.name)) {
                    return next;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.goodix.ble.libcomx.trx.ITrx
    public boolean isReady() {
        return this.ready;
    }

    @Deprecated
    public void receive(Object obj) {
        CopyOnWriteArrayList<TrxCtx> copyOnWriteArrayList = this.trxCtxList;
        if (!copyOnWriteArrayList.isEmpty()) {
            copyOnWriteArrayList.get(0).handleRx(obj);
        }
    }

    @Override // com.goodix.ble.libcomx.trx.ITrx
    public void send(Object obj) {
        CopyOnWriteArrayList<TrxCtx> copyOnWriteArrayList = this.trxCtxList;
        if (!copyOnWriteArrayList.isEmpty()) {
            copyOnWriteArrayList.get(copyOnWriteArrayList.size() - 1).handleTx(obj);
        }
    }

    public void setReady(boolean z) {
        boolean z2;
        synchronized (this) {
            try {
                if (this.ready != z) {
                    this.ready = z;
                    z2 = true;
                } else {
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            Iterator<TrxCtx> it = this.trxCtxList.iterator();
            while (it.hasNext()) {
                it.next().notifyReady(z);
            }
        }
    }
}
