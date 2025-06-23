package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.status.GetTargetFeatureMapCmd;
import com.jieli.jl_rcsp.model.response.TargetFeatureMapResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class GetTargetFeatureMapCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket == null || basePacket.getOpCode() != 2) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        if (basePacket.getType() == 1) {
            return new GetTargetFeatureMapCmd().setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        TargetFeatureMapResponse targetFeatureMapResponse = new TargetFeatureMapResponse();
        targetFeatureMapResponse.setRawData(paramData);
        if (paramData != null && paramData.length >= 4) {
            byte[] bArr = new byte[4];
            System.arraycopy(paramData, 0, bArr, 0, 4);
            targetFeatureMapResponse.setMask(CHexConver.bytesToInt(bArr));
        }
        if (command != null) {
            GetTargetFeatureMapCmd getTargetFeatureMapCmd = (GetTargetFeatureMapCmd) command;
            getTargetFeatureMapCmd.setStatus(basePacket.getStatus());
            getTargetFeatureMapCmd.setResponse(targetFeatureMapResponse);
            return getTargetFeatureMapCmd;
        }
        GetTargetFeatureMapCmd getTargetFeatureMapCmd2 = new GetTargetFeatureMapCmd();
        getTargetFeatureMapCmd2.setOpCodeSn(basePacket.getOpCodeSn());
        getTargetFeatureMapCmd2.setStatus(basePacket.getStatus());
        getTargetFeatureMapCmd2.setResponse(targetFeatureMapResponse);
        return getTargetFeatureMapCmd2;
    }
}
