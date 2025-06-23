package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.double_connect.QueryPhoneBtInfoCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;

/* loaded from: classes10.dex */
public class QueryPhoneBtInfoCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        int opCode;
        int i;
        QueryPhoneBtInfoCmd queryPhoneBtInfoCmd;
        if (basePacket == null || (opCode = basePacket.getOpCode()) != 49) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        if (basePacket.getHasResponse() == 1) {
            i = 2;
        } else {
            i = 1;
        }
        if (basePacket.getType() == 1) {
            QueryPhoneBtInfoCmd.NotifyParam notifyParam = new QueryPhoneBtInfoCmd.NotifyParam();
            notifyParam.parseData(paramData);
            return new QueryPhoneBtInfoCmd(i, notifyParam).setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, opCode, basePacket.getOpCodeSn());
        if (command == null) {
            queryPhoneBtInfoCmd = new QueryPhoneBtInfoCmd(null);
        } else {
            queryPhoneBtInfoCmd = (QueryPhoneBtInfoCmd) command;
        }
        QueryPhoneBtInfoCmd.Response response = new QueryPhoneBtInfoCmd.Response();
        response.setRawData(paramData);
        response.parseData(paramData);
        queryPhoneBtInfoCmd.setOpCodeSn(basePacket.getOpCodeSn());
        queryPhoneBtInfoCmd.setStatus(basePacket.getStatus());
        queryPhoneBtInfoCmd.setResponse(response);
        return queryPhoneBtInfoCmd;
    }
}
