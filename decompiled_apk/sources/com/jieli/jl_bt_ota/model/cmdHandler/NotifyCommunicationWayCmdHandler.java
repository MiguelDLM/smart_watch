package com.jieli.jl_bt_ota.model.cmdHandler;

import com.jieli.jl_bt_ota.interfaces.command.ICmdHandler;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.command.NotifyCommunicationWayCmd;
import com.jieli.jl_bt_ota.model.parameter.NotifyCommunicationWayParam;
import com.jieli.jl_bt_ota.model.response.NotifyCommunicationWayResponse;
import com.jieli.jl_bt_ota.util.CHexConver;

/* loaded from: classes10.dex */
public class NotifyCommunicationWayCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_bt_ota.interfaces.command.ICmdHandler
    public CommandBase parseDataToCmd(BasePacket basePacket, CommandBase commandBase) {
        NotifyCommunicationWayCmd notifyCommunicationWayCmd;
        int i;
        if (basePacket == null || basePacket.getOpCode() != 11) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        int i2 = 0;
        if (basePacket.getType() == 1) {
            if (paramData != null && paramData.length > 0) {
                int byteToInt = CHexConver.byteToInt(paramData[0]);
                if (paramData.length > 1) {
                    i2 = byteToInt;
                    i = CHexConver.byteToInt(paramData[1]);
                    return new NotifyCommunicationWayCmd(new NotifyCommunicationWayParam(i2, i)).setOpCodeSn(basePacket.getOpCodeSn());
                }
                i2 = byteToInt;
            }
            i = 0;
            return new NotifyCommunicationWayCmd(new NotifyCommunicationWayParam(i2, i)).setOpCodeSn(basePacket.getOpCodeSn());
        }
        NotifyCommunicationWayResponse notifyCommunicationWayResponse = new NotifyCommunicationWayResponse();
        notifyCommunicationWayResponse.setRawData(paramData);
        if (paramData != null && paramData.length >= 1) {
            notifyCommunicationWayResponse.setFlag(CHexConver.byteToInt(paramData[0]));
        }
        if (commandBase instanceof NotifyCommunicationWayCmd) {
            notifyCommunicationWayCmd = (NotifyCommunicationWayCmd) commandBase;
        } else {
            notifyCommunicationWayCmd = new NotifyCommunicationWayCmd(new NotifyCommunicationWayParam(0, 0));
        }
        notifyCommunicationWayCmd.setOpCodeSn(basePacket.getOpCodeSn());
        notifyCommunicationWayCmd.setStatus(basePacket.getStatus());
        notifyCommunicationWayCmd.setResponse(notifyCommunicationWayResponse);
        return notifyCommunicationWayCmd;
    }
}
