package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.custom.CustomCmd;
import com.jieli.jl_rcsp.model.parameter.CustomParam;
import com.jieli.jl_rcsp.model.response.CustomResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import java.io.ByteArrayOutputStream;

/* loaded from: classes10.dex */
public class CustomCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        int i;
        if (basePacket == null || basePacket.getOpCode() != 255) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        if (basePacket.getHasResponse() == 1) {
            i = 2;
        } else {
            i = 1;
        }
        if (basePacket.getType() == 1) {
            byte[] bArr = new byte[0];
            if (paramData == null || paramData.length <= 0) {
                paramData = bArr;
            }
            CustomParam customParam = new CustomParam(paramData);
            customParam.setXmOpCode(basePacket.getXmOpCode());
            CustomCmd customCmd = new CustomCmd(i, customParam);
            customCmd.setOpCodeSn(basePacket.getOpCodeSn());
            return customCmd;
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        CustomResponse customResponse = new CustomResponse();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(basePacket.getXmOpCode());
        try {
            byteArrayOutputStream.write(paramData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        customResponse.setRawData(byteArrayOutputStream.toByteArray());
        customResponse.setData(paramData);
        customResponse.setXmOpCode(basePacket.getXmOpCode());
        if (command != null) {
            CustomCmd customCmd2 = (CustomCmd) command;
            customCmd2.setStatus(basePacket.getStatus());
            customCmd2.setResponse(customResponse);
            return customCmd2;
        }
        CustomCmd customCmd3 = new CustomCmd(i, new CustomParam(new byte[0]));
        customCmd3.setOpCodeSn(basePacket.getOpCodeSn());
        customCmd3.setStatus(basePacket.getStatus());
        customCmd3.setResponse(customResponse);
        return customCmd3;
    }
}
