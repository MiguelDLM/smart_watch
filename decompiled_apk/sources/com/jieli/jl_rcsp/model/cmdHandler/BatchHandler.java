package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.BatchCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;

/* loaded from: classes10.dex */
public class BatchHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        int i;
        if (basePacket == null || basePacket.getOpCode() != 38) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        if (basePacket.getHasResponse() == 1) {
            i = 2;
        } else {
            i = 1;
        }
        if (basePacket.getType() == 1) {
            int length = paramData.length - 2;
            byte[] bArr = new byte[length];
            System.arraycopy(paramData, 2, bArr, 0, length);
            BatchCmd batchCmd = new BatchCmd(i, new BatchCmd.Param(paramData[0], bArr));
            batchCmd.setOpCodeSn(basePacket.getOpCodeSn());
            return batchCmd;
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        if (command == null) {
            command = new BatchCmd(i, new BatchCmd.Param(paramData[0], new byte[0]));
        }
        BatchCmd.Response response = new BatchCmd.Response(paramData[0], paramData[1]);
        response.setRawData(paramData);
        response.setXmOpCode(basePacket.getXmOpCode());
        BatchCmd batchCmd2 = (BatchCmd) command;
        batchCmd2.setOpCodeSn(basePacket.getOpCodeSn());
        batchCmd2.setResponse(response);
        batchCmd2.setStatus(basePacket.getStatus());
        return command;
    }
}
