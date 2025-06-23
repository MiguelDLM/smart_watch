package com.goodix.ble.gr.libdfu.dfu;

import android.annotation.SuppressLint;
import com.goodix.ble.gr.libdfu.dfu.cmd.Cmd;
import com.goodix.ble.libcomx.transceiver.IFrameParser;
import com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx;
import java.util.HashMap;

/* loaded from: classes9.dex */
public class DfuCmdParser implements IFrameParser {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"UseSparseArrays"})
    HashMap<Integer, Class<? extends IFrameSdu4Rx>> f16075a;

    /* JADX WARN: Multi-variable type inference failed */
    public DfuCmdParser() {
        HashMap<Integer, Class<? extends IFrameSdu4Rx>> hashMap = new HashMap<>();
        this.f16075a = hashMap;
        hashMap.put(Integer.valueOf(Cmd.GetInfo.CODE), Cmd.GetInfo.getRxSdu().getClass());
        this.f16075a.put(Integer.valueOf(Cmd.Reset.CODE), Cmd.Reset.getRxSdu().getClass());
        this.f16075a.put(Integer.valueOf(Cmd.WriteRam.CODE), Cmd.WriteRam.getRxSdu().getClass());
        this.f16075a.put(Integer.valueOf(Cmd.ReadRam.CODE), Cmd.ReadRam.getRxSdu().getClass());
        this.f16075a.put(Integer.valueOf(Cmd.DumpFlash.CODE), Cmd.DumpFlash.getRxSdu().getClass());
        this.f16075a.put(Integer.valueOf(Cmd.EraseFlash.CODE), Cmd.EraseFlash.getRxSdu().getClass());
        this.f16075a.put(Integer.valueOf(Cmd.UpdateFlash.CODE), Cmd.UpdateFlash.getRxSdu().getClass());
        this.f16075a.put(Integer.valueOf(Cmd.ProgramStart.CODE), Cmd.ProgramStart.getRxSdu().getClass());
        this.f16075a.put(Integer.valueOf(Cmd.ProgramFlash.CODE), Cmd.ProgramFlash.getRxSdu().getClass());
        this.f16075a.put(Integer.valueOf(Cmd.ProgramEnd.CODE), Cmd.ProgramEnd.getRxSdu().getClass());
        this.f16075a.put(Integer.valueOf(Cmd.SystemConfig.CODE), Cmd.SystemConfig.getRxSdu().getClass());
        this.f16075a.put(Integer.valueOf(Cmd.SetNvds.CODE), Cmd.SetNvds.getRxSdu().getClass());
        this.f16075a.put(Integer.valueOf(Cmd.SetEfuse.CODE), Cmd.SetEfuse.getRxSdu().getClass());
        this.f16075a.put(Integer.valueOf(Cmd.ConfigExtFlash.CODE), Cmd.ConfigExtFlash.getRxSdu().getClass());
        this.f16075a.put(Integer.valueOf(Cmd.GetExtFlashId.CODE), Cmd.GetExtFlashId.getRxSdu().getClass());
        this.f16075a.put(Integer.valueOf(Cmd.RwReg.CODE), Cmd.RwReg.getRxSdu().getClass());
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001c  */
    @Override // com.goodix.ble.libcomx.transceiver.IFrameParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx parseSdu(int r2, com.goodix.ble.libcomx.util.HexReader r3) {
        /*
            r1 = this;
            java.util.HashMap<java.lang.Integer, java.lang.Class<? extends com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx>> r0 = r1.f16075a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r2 = r0.get(r2)
            java.lang.Class r2 = (java.lang.Class) r2
            if (r2 == 0) goto L19
            java.lang.Object r2 = r2.newInstance()     // Catch: java.lang.Exception -> L15
            com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx r2 = (com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx) r2     // Catch: java.lang.Exception -> L15
            goto L1a
        L15:
            r2 = move-exception
            r2.printStackTrace()
        L19:
            r2 = 0
        L1a:
            if (r2 == 0) goto L1f
            r2.deserialize(r3)
        L1f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.goodix.ble.gr.libdfu.dfu.DfuCmdParser.parseSdu(int, com.goodix.ble.libcomx.util.HexReader):com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx");
    }
}
