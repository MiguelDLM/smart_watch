package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.BaseResponse;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.watch.HealthSettingCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.tool.datahandles.ParseHelper;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;

/* loaded from: classes10.dex */
public class HealthSettingCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        int i;
        BaseResponse response;
        HealthSettingCmd.Param param = null;
        if (basePacket == null || basePacket.getOpCode() != 165) {
            return null;
        }
        if (basePacket.getHasResponse() == 1) {
            i = 2;
        } else {
            i = 1;
        }
        byte[] paramData = basePacket.getParamData();
        if (basePacket.getType() == 1) {
            if (paramData == null || paramData.length == 0) {
                return null;
            }
            byte b = paramData[0];
            if (b != 0) {
                if (b != 1) {
                    if (b == 2) {
                        int length = paramData.length - 1;
                        byte[] bArr = new byte[length];
                        if (length > 0) {
                            System.arraycopy(paramData, 1, bArr, 0, length);
                        }
                        param = new HealthSettingCmd.UpdateParam(ParseHelper.coverParamDataToAttrBeans(bArr));
                    }
                } else {
                    int length2 = paramData.length - 1;
                    byte[] bArr2 = new byte[length2];
                    if (length2 > 0) {
                        System.arraycopy(paramData, 1, bArr2, 0, length2);
                    }
                    param = new HealthSettingCmd.SetParam(ParseHelper.coverParamDataToAttrBeans(bArr2));
                }
            } else {
                if (paramData.length < 5) {
                    return null;
                }
                param = new HealthSettingCmd.GetParam(CHexConver.bytesToInt(paramData, 1, 4));
            }
            return new HealthSettingCmd(i, param).setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        if (command == null) {
            JL_Log.e("HealthSettingCmdHandler", "parseDataToCmd", "invalid health setting cmd response");
            return null;
        }
        HealthSettingCmd healthSettingCmd = (HealthSettingCmd) command;
        healthSettingCmd.setOpCodeSn(basePacket.getOpCodeSn());
        healthSettingCmd.setStatus(basePacket.getStatus());
        if (basePacket.getStatus() != 0) {
            JL_Log.w("HealthSettingCmdHandler", "parseDataToCmd", "health setting cmd send fail ,status = " + basePacket.getStatus());
            healthSettingCmd.setResponse(new HealthSettingCmd.Response());
            return healthSettingCmd;
        }
        if (healthSettingCmd.getParam() instanceof HealthSettingCmd.GetParam) {
            response = new HealthSettingCmd.GetResponse(ParseHelper.coverParamDataToAttrBeans(paramData));
        } else {
            response = new HealthSettingCmd.Response();
        }
        response.setRawData(paramData);
        healthSettingCmd.setResponse(response);
        return healthSettingCmd;
    }
}
