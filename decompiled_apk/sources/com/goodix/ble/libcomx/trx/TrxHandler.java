package com.goodix.ble.libcomx.trx;

/* loaded from: classes9.dex */
public interface TrxHandler {
    void onCreate(TrxCtx trxCtx);

    void onDestroy(TrxCtx trxCtx);

    void onException(TrxCtx trxCtx, Throwable th);

    void onPause(TrxCtx trxCtx, boolean z);

    void onPostRxComplete(TrxCtx trxCtx, Object obj);

    void onPostTxComplete(TrxCtx trxCtx, Object obj);

    void onReady(TrxCtx trxCtx, boolean z);

    void onRx(TrxCtx trxCtx, Object obj);

    void onTx(TrxCtx trxCtx, Object obj);
}
