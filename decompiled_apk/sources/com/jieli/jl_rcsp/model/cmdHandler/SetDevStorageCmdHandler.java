package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.command.SetDevStorageCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class SetDevStorageCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        SetDevStorageCmd setDevStorageCmd;
        if (basePacket == null || basePacket.getOpCode() != 216) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        int i = 0;
        if (basePacket.getType() == 1) {
            if (paramData != null && paramData.length >= 4) {
                i = CHexConver.bytesToInt(paramData, 0, 4);
            }
            return new SetDevStorageCmd(i).setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setRawData(paramData);
        if (command != null) {
            setDevStorageCmd = (SetDevStorageCmd) command;
        } else {
            setDevStorageCmd = new SetDevStorageCmd(0);
        }
        setDevStorageCmd.setResponse(commonResponse);
        setDevStorageCmd.setOpCodeSn(basePacket.getOpCodeSn());
        setDevStorageCmd.setStatus(basePacket.getStatus());
        return setDevStorageCmd;
    }
}
