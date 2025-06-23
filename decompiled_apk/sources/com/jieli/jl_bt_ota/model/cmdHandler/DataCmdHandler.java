package com.jieli.jl_bt_ota.model.cmdHandler;

import com.jieli.jl_bt_ota.interfaces.command.ICmdHandler;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.base.CommonResponse;
import com.jieli.jl_bt_ota.model.command.DataCmd;
import com.jieli.jl_bt_ota.model.command.DataHasResponseCmd;
import com.jieli.jl_bt_ota.model.parameter.DataParam;

/* loaded from: classes10.dex */
public class DataCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_bt_ota.interfaces.command.ICmdHandler
    public CommandBase parseDataToCmd(BasePacket basePacket, CommandBase commandBase) {
        DataHasResponseCmd dataHasResponseCmd;
        if (basePacket == null || basePacket.getOpCode() != 1) {
            return null;
        }
        if (basePacket.getType() == 1) {
            if (basePacket.getHasResponse() == 0) {
                return new DataCmd((DataParam) new DataParam(basePacket.getParamData()).setXmOpCode(basePacket.getXmOpCode())).setOpCodeSn(basePacket.getOpCodeSn());
            }
            return new DataHasResponseCmd((DataParam) new DataParam(basePacket.getParamData()).setXmOpCode(basePacket.getXmOpCode())).setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setRawData(basePacket.getParamData());
        commonResponse.setXmOpCode(basePacket.getXmOpCode());
        if (commandBase instanceof DataHasResponseCmd) {
            dataHasResponseCmd = (DataHasResponseCmd) commandBase;
        } else {
            dataHasResponseCmd = new DataHasResponseCmd(new DataParam(new byte[0]));
        }
        dataHasResponseCmd.setOpCodeSn(basePacket.getOpCodeSn());
        dataHasResponseCmd.setStatus(basePacket.getStatus());
        dataHasResponseCmd.setResponse(commonResponse);
        return dataHasResponseCmd;
    }
}
