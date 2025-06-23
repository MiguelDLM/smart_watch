package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.command.file_op.NotifyFileTransferOpCmd;
import com.jieli.jl_rcsp.model.command.file_op.StartFileTransferCmd;
import com.jieli.jl_rcsp.model.command.file_op.StopFileTransferCmd;
import com.jieli.jl_rcsp.model.parameter.NotifyFileTransferParam;
import com.jieli.jl_rcsp.model.parameter.StartFileTransferParam;
import com.jieli.jl_rcsp.model.parameter.StopFileTransferParam;
import com.jieli.jl_rcsp.model.response.StartFileTranferResponse;
import com.jieli.jl_rcsp.model.response.StopFileTransferResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;
import java.nio.charset.StandardCharsets;

@Deprecated
/* loaded from: classes10.dex */
public class FileTransferCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        int i;
        String str;
        byte b;
        int i2;
        if (basePacket == null) {
            return null;
        }
        int opCode = basePacket.getOpCode();
        if (opCode == 22 || opCode == 23 || opCode == 24) {
            byte[] paramData = basePacket.getParamData();
            boolean z = true;
            int i3 = 0;
            if (basePacket.getType() == 1) {
                switch (opCode) {
                    case 22:
                        if (paramData != null && paramData.length > 5) {
                            b = paramData[0];
                            i2 = CHexConver.bytesToInt(paramData, 1, 4);
                            str = new String(paramData, 5, paramData.length - 5, StandardCharsets.UTF_8);
                        } else {
                            str = "";
                            b = 0;
                            i2 = 0;
                        }
                        StartFileTransferParam startFileTransferParam = new StartFileTransferParam(str, i2);
                        if ((b & 1) != 1) {
                            z = false;
                        }
                        startFileTransferParam.enableDataNeedResponse(z);
                        return new StartFileTransferCmd(startFileTransferParam).setOpCodeSn(basePacket.getOpCodeSn());
                    case 23:
                        if (paramData != null && paramData.length > 0) {
                            i3 = CHexConver.byteToInt(paramData[0]);
                        }
                        return new StopFileTransferCmd(new StopFileTransferParam(i3)).setOpCodeSn(basePacket.getOpCodeSn());
                    case 24:
                        if (paramData != null && paramData.length > 0) {
                            i3 = CHexConver.byteToInt(paramData[0]);
                        }
                        return new NotifyFileTransferOpCmd(new NotifyFileTransferParam(i3)).setOpCodeSn(basePacket.getOpCodeSn());
                }
            }
            CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, opCode, basePacket.getOpCodeSn());
            switch (opCode) {
                case 22:
                    StartFileTranferResponse startFileTranferResponse = new StartFileTranferResponse();
                    startFileTranferResponse.setRawData(paramData);
                    if (command != null) {
                        StartFileTransferCmd startFileTransferCmd = (StartFileTransferCmd) command;
                        startFileTransferCmd.setStatus(basePacket.getStatus());
                        startFileTransferCmd.setResponse(startFileTranferResponse);
                        return startFileTransferCmd;
                    }
                    StartFileTransferCmd startFileTransferCmd2 = new StartFileTransferCmd(new StartFileTransferParam("./", 0));
                    startFileTransferCmd2.setOpCodeSn(basePacket.getOpCodeSn());
                    startFileTransferCmd2.setStatus(basePacket.getStatus());
                    startFileTransferCmd2.setResponse(startFileTranferResponse);
                    return startFileTransferCmd2;
                case 23:
                    if (paramData != null && paramData.length > 0) {
                        i = CHexConver.byteToInt(paramData[0]);
                    } else {
                        i = 0;
                    }
                    StopFileTransferResponse stopFileTransferResponse = new StopFileTransferResponse();
                    stopFileTransferResponse.setRawData(paramData);
                    stopFileTransferResponse.setReason(i);
                    if (command != null) {
                        StopFileTransferCmd stopFileTransferCmd = (StopFileTransferCmd) command;
                        stopFileTransferCmd.setStatus(basePacket.getStatus());
                        stopFileTransferCmd.setResponse(stopFileTransferResponse);
                        return stopFileTransferCmd;
                    }
                    StopFileTransferCmd stopFileTransferCmd2 = new StopFileTransferCmd(new StopFileTransferParam(0));
                    stopFileTransferCmd2.setOpCodeSn(basePacket.getOpCodeSn());
                    stopFileTransferCmd2.setStatus(basePacket.getStatus());
                    stopFileTransferCmd2.setResponse(stopFileTransferResponse);
                    return stopFileTransferCmd2;
                case 24:
                    CommonResponse commonResponse = new CommonResponse();
                    commonResponse.setRawData(paramData);
                    if (command != null) {
                        NotifyFileTransferOpCmd notifyFileTransferOpCmd = (NotifyFileTransferOpCmd) command;
                        notifyFileTransferOpCmd.setStatus(basePacket.getStatus());
                        notifyFileTransferOpCmd.setResponse(commonResponse);
                        return notifyFileTransferOpCmd;
                    }
                    NotifyFileTransferOpCmd notifyFileTransferOpCmd2 = new NotifyFileTransferOpCmd(new NotifyFileTransferParam(0));
                    notifyFileTransferOpCmd2.setOpCodeSn(basePacket.getOpCodeSn());
                    notifyFileTransferOpCmd2.setStatus(basePacket.getStatus());
                    notifyFileTransferOpCmd2.setResponse(commonResponse);
                    return notifyFileTransferOpCmd2;
            }
        }
        return null;
    }
}
