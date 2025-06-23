package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.command.NotifyAppInfoCmd;
import com.jieli.jl_rcsp.model.parameter.NotifyAppInfoParam;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class NotifyAppInfoCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket == null || basePacket.getOpCode() != 208) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        int i = 0;
        if (basePacket.getType() == 1) {
            if (paramData != null && paramData.length > 0) {
                i = CHexConver.byteToInt(paramData[0]);
            }
            return new NotifyAppInfoCmd(new NotifyAppInfoParam(i)).setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setRawData(paramData);
        if (command != null) {
            NotifyAppInfoCmd notifyAppInfoCmd = (NotifyAppInfoCmd) command;
            notifyAppInfoCmd.setStatus(basePacket.getStatus());
            notifyAppInfoCmd.setResponse(commonResponse);
            return notifyAppInfoCmd;
        }
        NotifyAppInfoCmd notifyAppInfoCmd2 = new NotifyAppInfoCmd(new NotifyAppInfoParam(0));
        notifyAppInfoCmd2.setOpCodeSn(basePacket.getOpCodeSn());
        notifyAppInfoCmd2.setStatus(basePacket.getStatus());
        notifyAppInfoCmd2.setResponse(commonResponse);
        return notifyAppInfoCmd2;
    }
}
