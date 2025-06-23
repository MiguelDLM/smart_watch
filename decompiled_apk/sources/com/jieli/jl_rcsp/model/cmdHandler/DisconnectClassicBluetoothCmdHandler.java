package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.command.DisconnectClassicBluetoothCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;

/* loaded from: classes10.dex */
public class DisconnectClassicBluetoothCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket == null || basePacket.getOpCode() != 6) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        if (basePacket.getType() == 1) {
            return new DisconnectClassicBluetoothCmd().setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setRawData(paramData);
        if (command != null) {
            DisconnectClassicBluetoothCmd disconnectClassicBluetoothCmd = (DisconnectClassicBluetoothCmd) command;
            disconnectClassicBluetoothCmd.setStatus(basePacket.getStatus());
            disconnectClassicBluetoothCmd.setResponse(commonResponse);
            return disconnectClassicBluetoothCmd;
        }
        DisconnectClassicBluetoothCmd disconnectClassicBluetoothCmd2 = new DisconnectClassicBluetoothCmd();
        disconnectClassicBluetoothCmd2.setOpCodeSn(basePacket.getOpCodeSn());
        disconnectClassicBluetoothCmd2.setStatus(basePacket.getStatus());
        disconnectClassicBluetoothCmd2.setResponse(commonResponse);
        return disconnectClassicBluetoothCmd2;
    }
}
