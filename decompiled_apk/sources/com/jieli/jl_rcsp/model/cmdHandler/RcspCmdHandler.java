package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommandWithParam;
import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommandWithResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.tool.datahandles.ParseHelper;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;

/* loaded from: classes10.dex */
public class RcspCmdHandler implements ICmdHandler {
    private static final String TAG = "RcspCmdHandler";

    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        boolean z;
        boolean z2;
        CommandWithParamAndResponse commandWithParamAndResponse;
        int i = 0;
        if (basePacket.getType() == 1) {
            z = true;
        } else {
            z = false;
        }
        if (basePacket.getHasResponse() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (basePacket.getParamData() != null && basePacket.getParamData().length > 0) {
            i = 1;
        }
        CommandBase commandBase = null;
        if (z) {
            if (z2) {
                if (i != 0) {
                    i = 3;
                } else {
                    i = 2;
                }
            }
        } else {
            CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
            if (command == null) {
                byte[] packSendBasePacket = ParseHelper.packSendBasePacket(basePacket);
                JL_Log.w(TAG, "parseDataToCmd", "unknown data : " + CHexConver.byte2HexStr(packSendBasePacket));
                return null;
            }
            i = command.getType();
            commandBase = command;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return new CommandBase(basePacket.getOpCode(), CommandBase.class.getSimpleName()).setOpCodeSn(basePacket.getOpCodeSn()).setStatus(basePacket.getStatus());
                }
                CommandWithResponse commandWithResponse = new CommandWithResponse(basePacket.getOpCode(), CommandWithResponse.class.getSimpleName());
                if (!z) {
                    CommonResponse commonResponse = new CommonResponse();
                    commonResponse.setRawData(basePacket.getParamData());
                    commonResponse.setXmOpCode(basePacket.getXmOpCode());
                    commandWithResponse.setResponse(commonResponse);
                }
                commandWithResponse.setOpCodeSn(basePacket.getOpCodeSn());
                commandWithResponse.setStatus(basePacket.getStatus());
                return commandWithResponse;
            }
            BaseParameter baseParameter = new BaseParameter();
            baseParameter.setXmOpCode(basePacket.getXmOpCode());
            if (z) {
                baseParameter.setParamData(basePacket.getParamData());
                commandWithParamAndResponse = new CommandWithParamAndResponse(basePacket.getOpCode(), CommandWithParamAndResponse.class.getSimpleName(), baseParameter);
            } else {
                if (commandBase.getParam() != null) {
                    baseParameter.setParamData(commandBase.getParam().getParamData());
                }
                commandWithParamAndResponse = new CommandWithParamAndResponse(basePacket.getOpCode(), CommandWithParamAndResponse.class.getSimpleName(), baseParameter);
                CommonResponse commonResponse2 = new CommonResponse();
                commonResponse2.setRawData(basePacket.getParamData());
                commonResponse2.setXmOpCode(basePacket.getXmOpCode());
                commandWithParamAndResponse.setResponse(commonResponse2);
            }
            commandWithParamAndResponse.setOpCodeSn(basePacket.getOpCodeSn());
            commandWithParamAndResponse.setStatus(basePacket.getStatus());
            return commandWithParamAndResponse;
        }
        BaseParameter baseParameter2 = new BaseParameter();
        baseParameter2.setXmOpCode(basePacket.getXmOpCode());
        baseParameter2.setParamData(basePacket.getParamData());
        CommandWithParam commandWithParam = new CommandWithParam(basePacket.getOpCode(), CommandWithParam.class.getSimpleName(), baseParameter2);
        commandWithParam.setOpCodeSn(basePacket.getOpCodeSn()).setStatus(basePacket.getStatus());
        return commandWithParam;
    }
}
