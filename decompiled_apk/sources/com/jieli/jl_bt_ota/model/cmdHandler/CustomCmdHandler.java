package com.jieli.jl_bt_ota.model.cmdHandler;

import com.jieli.jl_bt_ota.interfaces.command.ICmdHandler;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.command.CustomCmd;
import com.jieli.jl_bt_ota.model.parameter.CustomParam;
import com.jieli.jl_bt_ota.model.response.CustomResponse;
import java.io.ByteArrayOutputStream;

/* loaded from: classes10.dex */
public class CustomCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_bt_ota.interfaces.command.ICmdHandler
    public CommandBase parseDataToCmd(BasePacket basePacket, CommandBase commandBase) {
        int i;
        CustomCmd customCmd;
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
            CustomCmd customCmd2 = new CustomCmd(i, customParam);
            customCmd2.setOpCodeSn(basePacket.getOpCodeSn());
            return customCmd2;
        }
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
        if (commandBase instanceof CustomCmd) {
            customCmd = (CustomCmd) commandBase;
        } else {
            customCmd = new CustomCmd(i, new CustomParam(new byte[0]));
        }
        customCmd.setOpCodeSn(basePacket.getOpCodeSn());
        customCmd.setStatus(basePacket.getStatus());
        customCmd.setResponse(customResponse);
        return customCmd;
    }
}
