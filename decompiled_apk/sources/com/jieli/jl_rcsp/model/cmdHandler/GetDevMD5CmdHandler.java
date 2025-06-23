package com.jieli.jl_rcsp.model.cmdHandler;

import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;

/* loaded from: classes10.dex */
public class GetDevMD5CmdHandler implements ICmdHandler {
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.jieli.jl_rcsp.model.base.CommandBase parseDataToCmd(android.bluetooth.BluetoothDevice r5, com.jieli.jl_rcsp.model.base.BasePacket r6) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            int r1 = r6.getOpCode()
            r2 = 212(0xd4, float:2.97E-43)
            if (r1 == r2) goto Ld
            return r0
        Ld:
            byte[] r0 = r6.getParamData()
            int r1 = r6.getType()
            r2 = 1
            if (r1 != r2) goto L26
            com.jieli.jl_rcsp.model.command.status.GetDevMD5Cmd r5 = new com.jieli.jl_rcsp.model.command.status.GetDevMD5Cmd
            r5.<init>()
            int r6 = r6.getOpCodeSn()
            com.jieli.jl_rcsp.model.base.CommandBase r5 = r5.setOpCodeSn(r6)
            return r5
        L26:
            com.jieli.jl_rcsp.tool.CommandHelper r1 = com.jieli.jl_rcsp.tool.CommandHelper.getInstance()
            int r2 = r6.getOpCode()
            int r3 = r6.getOpCodeSn()
            com.jieli.jl_rcsp.model.base.CommandBase r5 = r1.getCommand(r5, r2, r3)
            if (r0 == 0) goto L48
            int r1 = r0.length
            r2 = 32
            if (r1 < r2) goto L48
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Exception -> L44
            r3 = 0
            r1.<init>(r0, r3, r2)     // Catch: java.lang.Exception -> L44
            goto L4a
        L44:
            r1 = move-exception
            r1.printStackTrace()
        L48:
            java.lang.String r1 = ""
        L4a:
            com.jieli.jl_rcsp.model.response.GetDevMD5Response r2 = new com.jieli.jl_rcsp.model.response.GetDevMD5Response
            r2.<init>(r1)
            r2.setRawData(r0)
            if (r5 == 0) goto L61
            com.jieli.jl_rcsp.model.command.status.GetDevMD5Cmd r5 = (com.jieli.jl_rcsp.model.command.status.GetDevMD5Cmd) r5
            r5.setResponse(r2)
            int r6 = r6.getStatus()
            r5.setStatus(r6)
            return r5
        L61:
            com.jieli.jl_rcsp.model.command.status.GetDevMD5Cmd r5 = new com.jieli.jl_rcsp.model.command.status.GetDevMD5Cmd
            r5.<init>()
            int r0 = r6.getOpCodeSn()
            r5.setOpCodeSn(r0)
            r5.setResponse(r2)
            int r6 = r6.getStatus()
            r5.setStatus(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_rcsp.model.cmdHandler.GetDevMD5CmdHandler.parseDataToCmd(android.bluetooth.BluetoothDevice, com.jieli.jl_rcsp.model.base.BasePacket):com.jieli.jl_rcsp.model.base.CommandBase");
    }
}
