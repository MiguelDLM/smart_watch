package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.command.FunctionCmd;
import com.jieli.jl_rcsp.model.parameter.FunctionParam;
import com.jieli.jl_rcsp.tool.CommandHelper;

/* loaded from: classes10.dex */
public class FunctionCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        byte b;
        if (basePacket == null || basePacket.getOpCode() != 14) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        byte b2 = -1;
        if (basePacket.getType() == 1) {
            byte[] bArr = new byte[0];
            if (paramData != null && paramData.length > 1) {
                b2 = paramData[0];
                b = paramData[1];
                if (paramData.length > 2) {
                    int length = paramData.length - 2;
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(paramData, 2, bArr2, 0, length);
                    bArr = bArr2;
                }
            } else {
                b = -1;
            }
            return new FunctionCmd(new FunctionParam(b2, b).setExtend(bArr)).setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setRawData(paramData);
        if (command != null) {
            FunctionCmd functionCmd = (FunctionCmd) command;
            functionCmd.setStatus(basePacket.getStatus());
            functionCmd.setResponse(commonResponse);
            return functionCmd;
        }
        FunctionCmd functionCmd2 = new FunctionCmd(new FunctionParam((byte) -1, (byte) -1));
        functionCmd2.setOpCodeSn(basePacket.getOpCodeSn());
        functionCmd2.setStatus(basePacket.getStatus());
        functionCmd2.setResponse(commonResponse);
        return functionCmd2;
    }
}
