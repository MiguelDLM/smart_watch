package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.data.DataTransferCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;

/* loaded from: classes10.dex */
public class DataTransferCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        int i;
        DataTransferCmd dataTransferCmd;
        if (basePacket != null && basePacket.getOpCode() == 48) {
            if (basePacket.getHasResponse() == 0) {
                i = 1;
            } else {
                i = 2;
            }
            byte[] paramData = basePacket.getParamData();
            if (basePacket.getType() == 1) {
                DataTransferCmd.Param param = new DataTransferCmd.Param(paramData);
                int op = param.getOp();
                if (op != 0) {
                    if (op != 1) {
                        if (op == 2) {
                            param = new DataTransferCmd.CancelTransferParam(paramData);
                        }
                    } else {
                        param = new DataTransferCmd.DataTransferParam(paramData);
                    }
                } else if (new DataTransferCmd.TransferParam(paramData).getWay() == 1) {
                    param = new DataTransferCmd.SendDataParam(paramData);
                } else {
                    param = new DataTransferCmd.ReadDataParam(paramData);
                }
                return new DataTransferCmd(i, param).setOpCodeSn(basePacket.getOpCodeSn());
            }
            CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
            if (command == null) {
                dataTransferCmd = new DataTransferCmd(new DataTransferCmd.Param(new byte[0]));
            } else {
                dataTransferCmd = (DataTransferCmd) command;
            }
            DataTransferCmd.Response response = new DataTransferCmd.Response(paramData);
            int op2 = response.getOp();
            if (op2 != 0) {
                if (op2 == 1) {
                    response = new DataTransferCmd.DataTransferResponse(paramData);
                }
            } else if (new DataTransferCmd.TransferParamResponse(paramData).getWay() == 1) {
                response = new DataTransferCmd.SendDataResponse(paramData);
            } else {
                response = new DataTransferCmd.ReadDataResponse(paramData);
            }
            dataTransferCmd.setResponse(response);
            dataTransferCmd.setStatus(basePacket.getStatus());
            dataTransferCmd.setOpCodeSn(basePacket.getOpCodeSn());
            return dataTransferCmd;
        }
        return null;
    }
}
