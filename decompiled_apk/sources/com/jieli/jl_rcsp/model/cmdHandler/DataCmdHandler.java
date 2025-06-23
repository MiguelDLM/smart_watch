package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.command.data.DataCmd;
import com.jieli.jl_rcsp.model.command.data.DataHasResponseCmd;
import com.jieli.jl_rcsp.model.parameter.DataParam;
import com.jieli.jl_rcsp.tool.CommandHelper;

/* loaded from: classes10.dex */
public class DataCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket == null || basePacket.getOpCode() != 1) {
            return null;
        }
        if (basePacket.getType() == 1) {
            if (basePacket.getHasResponse() == 0) {
                return new DataCmd((DataParam) new DataParam(basePacket.getParamData()).setXmOpCode(basePacket.getXmOpCode())).setOpCodeSn(basePacket.getOpCodeSn());
            }
            return new DataHasResponseCmd((DataParam) new DataParam(basePacket.getParamData()).setXmOpCode(basePacket.getXmOpCode())).setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setRawData(basePacket.getParamData());
        commonResponse.setXmOpCode(basePacket.getXmOpCode());
        if (command != null) {
            DataHasResponseCmd dataHasResponseCmd = (DataHasResponseCmd) command;
            dataHasResponseCmd.setStatus(basePacket.getStatus());
            dataHasResponseCmd.setResponse(commonResponse);
            return dataHasResponseCmd;
        }
        DataHasResponseCmd dataHasResponseCmd2 = new DataHasResponseCmd(new DataParam(new byte[0]));
        dataHasResponseCmd2.setOpCodeSn(basePacket.getOpCodeSn());
        dataHasResponseCmd2.setStatus(basePacket.getStatus());
        dataHasResponseCmd2.setResponse(commonResponse);
        return dataHasResponseCmd2;
    }
}
