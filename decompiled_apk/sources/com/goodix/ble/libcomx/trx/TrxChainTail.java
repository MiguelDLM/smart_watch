package com.goodix.ble.libcomx.trx;

/* loaded from: classes9.dex */
public class TrxChainTail extends BaseTrxHandler {
    @Override // com.goodix.ble.libcomx.trx.BaseTrxHandler, com.goodix.ble.libcomx.trx.TrxHandler
    public void onPostTxComplete(TrxCtx trxCtx, Object obj) {
        trxCtx.getChain().evtTx().postEvent(obj);
    }

    @Override // com.goodix.ble.libcomx.trx.BaseTrxHandler, com.goodix.ble.libcomx.trx.TrxHandler
    public void onRx(TrxCtx trxCtx, Object obj) {
        trxCtx.getChain().evtRx().postEvent(obj);
        trxCtx.notifyRxComplete(obj);
    }
}
