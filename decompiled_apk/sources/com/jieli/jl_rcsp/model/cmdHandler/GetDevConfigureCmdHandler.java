package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.GetDevConfigureCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;

/* loaded from: classes10.dex */
public class GetDevConfigureCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        GetDevConfigureCmd getDevConfigureCmd;
        if (basePacket == null || basePacket.getOpCode() != 217) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        if (basePacket.getType() == 1) {
            return new GetDevConfigureCmd().setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        GetDevConfigureCmd.Response response = new GetDevConfigureCmd.Response();
        response.parseData(paramData);
        if (command == null) {
            getDevConfigureCmd = new GetDevConfigureCmd();
        } else {
            getDevConfigureCmd = (GetDevConfigureCmd) command;
        }
        getDevConfigureCmd.setResponse(response);
        getDevConfigureCmd.setOpCodeSn(basePacket.getOpCodeSn());
        getDevConfigureCmd.setStatus(basePacket.getStatus());
        return getDevConfigureCmd;
    }
}
