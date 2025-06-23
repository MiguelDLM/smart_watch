package com.jieli.jl_bt_ota.model.cmdHandler;

import com.jieli.jl_bt_ota.interfaces.command.ICmdHandler;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.command.SettingsMtuCmd;
import com.jieli.jl_bt_ota.model.parameter.SettingsMtuParam;
import com.jieli.jl_bt_ota.model.response.SettingsMtuResponse;
import com.jieli.jl_bt_ota.util.CHexConver;

/* loaded from: classes10.dex */
public class SettingsMtuCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_bt_ota.interfaces.command.ICmdHandler
    public CommandBase parseDataToCmd(BasePacket basePacket, CommandBase commandBase) {
        SettingsMtuCmd settingsMtuCmd;
        if (basePacket == null || basePacket.getOpCode() != 209) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        int i = 530;
        if (basePacket.getType() == 1) {
            if (paramData != null && paramData.length >= 2) {
                i = CHexConver.bytesToInt(paramData[0], paramData[1]);
            }
            return new SettingsMtuCmd(new SettingsMtuParam(i)).setOpCodeSn(basePacket.getOpCodeSn());
        }
        SettingsMtuResponse settingsMtuResponse = new SettingsMtuResponse(530);
        settingsMtuResponse.setRawData(paramData);
        if (paramData != null && paramData.length >= 2) {
            settingsMtuResponse.setRealMtu(CHexConver.bytesToInt(paramData[0], paramData[1]));
        }
        if (commandBase instanceof SettingsMtuCmd) {
            settingsMtuCmd = (SettingsMtuCmd) commandBase;
        } else {
            settingsMtuCmd = new SettingsMtuCmd(new SettingsMtuParam(530));
        }
        settingsMtuCmd.setOpCodeSn(basePacket.getOpCodeSn());
        settingsMtuCmd.setStatus(basePacket.getStatus());
        settingsMtuCmd.setResponse(settingsMtuResponse);
        return settingsMtuCmd;
    }
}
