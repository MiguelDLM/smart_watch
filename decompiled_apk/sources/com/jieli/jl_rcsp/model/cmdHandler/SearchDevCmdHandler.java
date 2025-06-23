package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.SearchDevCmd;
import com.jieli.jl_rcsp.model.parameter.SearchDevParam;
import com.jieli.jl_rcsp.model.response.SearchDevResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class SearchDevCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        SearchDevResponse searchDevResponse;
        int i;
        int i2;
        int i3;
        int i4;
        if (basePacket == null || basePacket.getOpCode() != 25) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        int i5 = 0;
        if (basePacket.getType() == 1) {
            if (paramData != null && paramData.length > 0) {
                i = CHexConver.byteToInt(paramData[0]);
                if (paramData.length > 1) {
                    i3 = CHexConver.byteToInt(paramData[1]);
                    if (paramData.length > 3) {
                        i4 = CHexConver.bytesToInt(paramData[2], paramData[3]);
                        if (paramData.length > 4) {
                            int byteToInt = CHexConver.byteToInt(paramData[4]);
                            if (paramData.length > 5) {
                                i2 = CHexConver.byteToInt(paramData[5]);
                                i5 = byteToInt;
                                return new SearchDevCmd(new SearchDevParam(i, i3, i4).setWay(i5).setPlayer(i2)).setOpCodeSn(basePacket.getOpCodeSn());
                            }
                            i5 = byteToInt;
                        }
                        i2 = 0;
                        return new SearchDevCmd(new SearchDevParam(i, i3, i4).setWay(i5).setPlayer(i2)).setOpCodeSn(basePacket.getOpCodeSn());
                    }
                    i2 = 0;
                    i4 = 0;
                    return new SearchDevCmd(new SearchDevParam(i, i3, i4).setWay(i5).setPlayer(i2)).setOpCodeSn(basePacket.getOpCodeSn());
                }
            } else {
                i = 0;
            }
            i2 = 0;
            i3 = 0;
            i4 = 0;
            return new SearchDevCmd(new SearchDevParam(i, i3, i4).setWay(i5).setPlayer(i2)).setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        if (paramData != null && paramData.length > 0) {
            searchDevResponse = new SearchDevResponse(CHexConver.byteToInt(paramData[0]));
        } else {
            searchDevResponse = new SearchDevResponse(0);
        }
        searchDevResponse.setRawData(paramData);
        if (command != null) {
            SearchDevCmd searchDevCmd = (SearchDevCmd) command;
            searchDevCmd.setStatus(basePacket.getStatus());
            searchDevCmd.setResponse(searchDevResponse);
            return searchDevCmd;
        }
        SearchDevCmd searchDevCmd2 = new SearchDevCmd(new SearchDevParam());
        searchDevCmd2.setOpCodeSn(basePacket.getOpCodeSn());
        searchDevCmd2.setStatus(basePacket.getStatus());
        searchDevCmd2.setResponse(searchDevResponse);
        return searchDevCmd2;
    }
}
