package com.goodix.ble.libcomx.trx;

/* loaded from: classes9.dex */
public class BaseTrxHandler implements TrxHandler {
    @Override // com.goodix.ble.libcomx.trx.TrxHandler
    public void onCreate(TrxCtx trxCtx) {
    }

    @Override // com.goodix.ble.libcomx.trx.TrxHandler
    public void onDestroy(TrxCtx trxCtx) {
    }

    @Override // com.goodix.ble.libcomx.trx.TrxHandler
    public void onException(TrxCtx trxCtx, Throwable th) {
        th.printStackTrace();
    }

    @Override // com.goodix.ble.libcomx.trx.TrxHandler
    public void onPause(TrxCtx trxCtx, boolean z) {
    }

    @Override // com.goodix.ble.libcomx.trx.TrxHandler
    public void onPostRxComplete(TrxCtx trxCtx, Object obj) {
        trxCtx.notifyRxComplete(obj);
    }

    @Override // com.goodix.ble.libcomx.trx.TrxHandler
    public void onPostTxComplete(TrxCtx trxCtx, Object obj) {
        trxCtx.notifyTxComplete(obj);
    }

    @Override // com.goodix.ble.libcomx.trx.TrxHandler
    public void onReady(TrxCtx trxCtx, boolean z) {
    }

    @Override // com.goodix.ble.libcomx.trx.TrxHandler
    public void onRx(TrxCtx trxCtx, Object obj) {
        trxCtx.postRx(obj);
    }

    @Override // com.goodix.ble.libcomx.trx.TrxHandler
    public void onTx(TrxCtx trxCtx, Object obj) {
        trxCtx.postTx(obj);
    }
}
