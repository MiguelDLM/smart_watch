package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.SettingsMtuCmd;
import com.jieli.jl_rcsp.model.parameter.SettingsMtuParam;
import com.jieli.jl_rcsp.model.response.SettingsMtuResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.tool.DeviceStatusManager;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class SettingsMtuCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket == null || basePacket.getOpCode() != 209) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        if (basePacket.getType() == 1) {
            int maxCommunicationMtu = DeviceStatusManager.getInstance().getMaxCommunicationMtu(bluetoothDevice);
            if (paramData != null && paramData.length >= 2) {
                maxCommunicationMtu = CHexConver.bytesToInt(paramData[0], paramData[1]);
            }
            return new SettingsMtuCmd(new SettingsMtuParam(maxCommunicationMtu)).setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        SettingsMtuResponse settingsMtuResponse = new SettingsMtuResponse(530);
        settingsMtuResponse.setRawData(paramData);
        if (paramData != null && paramData.length >= 2) {
            settingsMtuResponse.setRealMtu(CHexConver.bytesToInt(paramData[0], paramData[1]));
        }
        if (command != null) {
            SettingsMtuCmd settingsMtuCmd = (SettingsMtuCmd) command;
            settingsMtuCmd.setStatus(basePacket.getStatus());
            settingsMtuCmd.setResponse(settingsMtuResponse);
            return settingsMtuCmd;
        }
        SettingsMtuCmd settingsMtuCmd2 = new SettingsMtuCmd(new SettingsMtuParam(530));
        settingsMtuCmd2.setOpCodeSn(basePacket.getOpCodeSn());
        settingsMtuCmd2.setStatus(basePacket.getStatus());
        settingsMtuCmd2.setResponse(settingsMtuResponse);
        return settingsMtuCmd2;
    }
}
