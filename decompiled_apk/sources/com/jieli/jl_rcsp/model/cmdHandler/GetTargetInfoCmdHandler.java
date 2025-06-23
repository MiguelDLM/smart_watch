package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.status.GetTargetInfoCmd;
import com.jieli.jl_rcsp.model.parameter.GetTargetInfoParam;
import com.jieli.jl_rcsp.model.response.TargetInfoResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.tool.datahandles.ParseHelper;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class GetTargetInfoCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        int i;
        if (basePacket == null || basePacket.getOpCode() != 3) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        byte b = 0;
        if (basePacket.getType() == 1) {
            if (paramData != null && paramData.length >= 4) {
                byte[] bArr = new byte[4];
                System.arraycopy(paramData, 0, bArr, 0, 4);
                i = CHexConver.bytesToInt(bArr);
                if (paramData.length >= 5) {
                    b = paramData[4];
                }
            } else {
                i = 0;
            }
            return new GetTargetInfoCmd(new GetTargetInfoParam(i).setPlatform(b)).setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        TargetInfoResponse targetInfoResponse = new TargetInfoResponse();
        targetInfoResponse.setRawData(paramData);
        ParseHelper.parseTargetInfo(bluetoothDevice, targetInfoResponse, basePacket);
        if (command != null) {
            GetTargetInfoCmd getTargetInfoCmd = (GetTargetInfoCmd) command;
            getTargetInfoCmd.setStatus(basePacket.getStatus());
            getTargetInfoCmd.setResponse(targetInfoResponse);
            return getTargetInfoCmd;
        }
        GetTargetInfoCmd getTargetInfoCmd2 = new GetTargetInfoCmd(new GetTargetInfoParam(0).setPlatform((byte) 0));
        getTargetInfoCmd2.setOpCodeSn(basePacket.getOpCodeSn());
        getTargetInfoCmd2.setStatus(basePacket.getStatus());
        getTargetInfoCmd2.setResponse(targetInfoResponse);
        return getTargetInfoCmd2;
    }
}
