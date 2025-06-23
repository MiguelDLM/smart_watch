package com.jieli.jl_bt_ota.model.cmdHandler;

import com.jieli.jl_bt_ota.interfaces.command.ICmdHandler;

/* loaded from: classes10.dex */
public class GetDevMD5CmdHandler implements ICmdHandler {
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    @Override // com.jieli.jl_bt_ota.interfaces.command.ICmdHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.jieli.jl_bt_ota.model.base.CommandBase parseDataToCmd(com.jieli.jl_bt_ota.model.base.BasePacket r5, com.jieli.jl_bt_ota.model.base.CommandBase r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            int r1 = r5.getOpCode()
            r2 = 212(0xd4, float:2.97E-43)
            if (r1 == r2) goto Ld
            return r0
        Ld:
            byte[] r0 = r5.getParamData()
            int r1 = r5.getType()
            r2 = 1
            if (r1 != r2) goto L26
            com.jieli.jl_bt_ota.model.command.GetDevMD5Cmd r6 = new com.jieli.jl_bt_ota.model.command.GetDevMD5Cmd
            r6.<init>()
            int r5 = r5.getOpCodeSn()
            com.jieli.jl_bt_ota.model.base.CommandBase r5 = r6.setOpCodeSn(r5)
            return r5
        L26:
            if (r0 == 0) goto L38
            int r1 = r0.length
            r2 = 32
            if (r1 < r2) goto L38
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Exception -> L34
            r3 = 0
            r1.<init>(r0, r3, r2)     // Catch: java.lang.Exception -> L34
            goto L3a
        L34:
            r1 = move-exception
            r1.printStackTrace()
        L38:
            java.lang.String r1 = ""
        L3a:
            com.jieli.jl_bt_ota.model.response.GetDevMD5Response r2 = new com.jieli.jl_bt_ota.model.response.GetDevMD5Response
            r2.<init>(r1)
            r2.setRawData(r0)
            boolean r0 = r6 instanceof com.jieli.jl_bt_ota.model.command.GetDevMD5Cmd
            if (r0 == 0) goto L49
            com.jieli.jl_bt_ota.model.command.GetDevMD5Cmd r6 = (com.jieli.jl_bt_ota.model.command.GetDevMD5Cmd) r6
            goto L4e
        L49:
            com.jieli.jl_bt_ota.model.command.GetDevMD5Cmd r6 = new com.jieli.jl_bt_ota.model.command.GetDevMD5Cmd
            r6.<init>()
        L4e:
            int r0 = r5.getOpCodeSn()
            r6.setOpCodeSn(r0)
            r6.setResponse(r2)
            int r5 = r5.getStatus()
            r6.setStatus(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_bt_ota.model.cmdHandler.GetDevMD5CmdHandler.parseDataToCmd(com.jieli.jl_bt_ota.model.base.BasePacket, com.jieli.jl_bt_ota.model.base.CommandBase):com.jieli.jl_bt_ota.model.base.CommandBase");
    }
}
