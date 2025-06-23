package com.jieli.jl_bt_ota.model.cmdHandler;

import com.jieli.jl_bt_ota.interfaces.command.ICmdHandler;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.command.GetTargetFeatureMapCmd;
import com.jieli.jl_bt_ota.model.response.TargetFeatureMapResponse;
import com.jieli.jl_bt_ota.util.CHexConver;

/* loaded from: classes10.dex */
public class GetTargetFeatureMapCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_bt_ota.interfaces.command.ICmdHandler
    public CommandBase parseDataToCmd(BasePacket basePacket, CommandBase commandBase) {
        GetTargetFeatureMapCmd getTargetFeatureMapCmd;
        if (basePacket == null || basePacket.getOpCode() != 2) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        if (basePacket.getType() == 1) {
            return new GetTargetFeatureMapCmd().setOpCodeSn(basePacket.getOpCodeSn());
        }
        TargetFeatureMapResponse targetFeatureMapResponse = new TargetFeatureMapResponse();
        targetFeatureMapResponse.setRawData(paramData);
        if (paramData != null && paramData.length >= 4) {
            byte[] bArr = new byte[4];
            System.arraycopy(paramData, 0, bArr, 0, 4);
            targetFeatureMapResponse.setMask(CHexConver.bytesToInt(bArr));
        }
        if (commandBase instanceof GetTargetFeatureMapCmd) {
            getTargetFeatureMapCmd = (GetTargetFeatureMapCmd) commandBase;
        } else {
            getTargetFeatureMapCmd = new GetTargetFeatureMapCmd();
        }
        getTargetFeatureMapCmd.setOpCodeSn(basePacket.getOpCodeSn());
        getTargetFeatureMapCmd.setStatus(basePacket.getStatus());
        getTargetFeatureMapCmd.setResponse(targetFeatureMapResponse);
        return getTargetFeatureMapCmd;
    }
}
