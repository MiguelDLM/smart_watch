package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.command.NotifyPrepareEnvCmd;
import com.jieli.jl_rcsp.model.command.file_op.CancelLargeFileTransferCmd;
import com.jieli.jl_rcsp.model.command.file_op.LargeFileTransferGetNameCmd;
import com.jieli.jl_rcsp.model.command.file_op.LargeFileTransferOpCmd;
import com.jieli.jl_rcsp.model.command.file_op.StartLargeFileTransferCmd;
import com.jieli.jl_rcsp.model.command.file_op.StopLargeFileTransferCmd;
import com.jieli.jl_rcsp.model.parameter.LargeFileTransferOpParam;
import com.jieli.jl_rcsp.model.parameter.StartLargeFileTransferParam;
import com.jieli.jl_rcsp.model.response.StartLargeFileTransferResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;
import java.util.Arrays;

/* loaded from: classes10.dex */
public class LargeFileTransferCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        StartLargeFileTransferCmd startLargeFileTransferCmd;
        StopLargeFileTransferCmd stopLargeFileTransferCmd;
        LargeFileTransferOpCmd largeFileTransferOpCmd;
        CancelLargeFileTransferCmd cancelLargeFileTransferCmd;
        LargeFileTransferGetNameCmd largeFileTransferGetNameCmd;
        NotifyPrepareEnvCmd notifyPrepareEnvCmd;
        short s;
        int i;
        short s2;
        if (basePacket == null) {
            return null;
        }
        int opCode = basePacket.getOpCode();
        byte[] paramData = basePacket.getParamData();
        int i2 = 0;
        r6 = 0;
        byte b = 0;
        byte b2 = 0;
        r6 = 0;
        byte b3 = 0;
        if (basePacket.getType() == 1) {
            switch (opCode) {
                case 27:
                    byte[] bArr = new byte[0];
                    if (paramData != null && paramData.length > 5) {
                        i2 = CHexConver.bytesToInt(paramData, 0, 4);
                        s = CHexConver.bytesToShort(paramData[4], paramData[5]);
                        int length = paramData.length;
                        if (length - 6 > 0) {
                            bArr = Arrays.copyOfRange(paramData, 6, length);
                        }
                    } else {
                        s = 0;
                    }
                    return new StartLargeFileTransferCmd(new StartLargeFileTransferParam(bArr, i2, s)).setOpCodeSn(basePacket.getOpCodeSn());
                case 28:
                    if (paramData != null && paramData.length > 0) {
                        b3 = paramData[0];
                    }
                    StopLargeFileTransferCmd.Param param = new StopLargeFileTransferCmd.Param(b3);
                    param.setParamData(paramData);
                    return new StopLargeFileTransferCmd(param).setOpCodeSn(basePacket.getOpCodeSn());
                case 29:
                    if (paramData != null && paramData.length > 0) {
                        byte b4 = paramData[0];
                        if (paramData.length > 2) {
                            s2 = CHexConver.bytesToShort(paramData[1], paramData[2]);
                        } else {
                            s2 = 0;
                        }
                        if (paramData.length > 6) {
                            i = CHexConver.bytesToInt(paramData, 3, 4);
                            b2 = b4;
                        } else {
                            b2 = b4;
                            i = 0;
                        }
                    } else {
                        i = 0;
                        s2 = 0;
                    }
                    return new LargeFileTransferOpCmd(new LargeFileTransferOpParam(b2, s2, i)).setOpCodeSn(basePacket.getOpCodeSn());
                case 30:
                    return new CancelLargeFileTransferCmd().setOpCodeSn(basePacket.getOpCodeSn());
                case 32:
                    return new LargeFileTransferGetNameCmd(new LargeFileTransferGetNameCmd.Param("", 0)).setOpCodeSn(basePacket.getOpCodeSn());
                case 33:
                    if (paramData != null && paramData.length > 0) {
                        b = paramData[0];
                    }
                    return new NotifyPrepareEnvCmd(new NotifyPrepareEnvCmd.Param(b)).setOpCodeSn(basePacket.getOpCodeSn());
            }
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, opCode, basePacket.getOpCodeSn());
        switch (opCode) {
            case 27:
                StartLargeFileTransferResponse startLargeFileTransferResponse = new StartLargeFileTransferResponse();
                startLargeFileTransferResponse.setRawData(paramData);
                if (paramData.length > 1) {
                    startLargeFileTransferResponse.setTransferMtu(CHexConver.bytesToShort(paramData[0], paramData[1]));
                }
                if (command instanceof StartLargeFileTransferCmd) {
                    startLargeFileTransferCmd = (StartLargeFileTransferCmd) command;
                } else {
                    startLargeFileTransferCmd = new StartLargeFileTransferCmd(new StartLargeFileTransferParam(new byte[0], 0, (short) 0));
                }
                startLargeFileTransferCmd.setOpCodeSn(basePacket.getOpCodeSn());
                startLargeFileTransferCmd.setStatus(basePacket.getStatus());
                startLargeFileTransferCmd.setResponse(startLargeFileTransferResponse);
                return startLargeFileTransferCmd;
            case 28:
                if (command instanceof StopLargeFileTransferCmd) {
                    stopLargeFileTransferCmd = (StopLargeFileTransferCmd) command;
                } else {
                    stopLargeFileTransferCmd = new StopLargeFileTransferCmd(new StopLargeFileTransferCmd.Param(0));
                }
                CommonResponse commonResponse = new CommonResponse();
                commonResponse.setRawData(paramData);
                stopLargeFileTransferCmd.setOpCodeSn(basePacket.getOpCodeSn());
                stopLargeFileTransferCmd.setStatus(basePacket.getStatus());
                stopLargeFileTransferCmd.setResponse(commonResponse);
                return stopLargeFileTransferCmd;
            case 29:
                if (command instanceof LargeFileTransferOpCmd) {
                    largeFileTransferOpCmd = (LargeFileTransferOpCmd) command;
                } else {
                    largeFileTransferOpCmd = new LargeFileTransferOpCmd(new LargeFileTransferOpParam((byte) 0, (short) 0, 0));
                }
                largeFileTransferOpCmd.setOpCodeSn(basePacket.getOpCodeSn());
                largeFileTransferOpCmd.setStatus(basePacket.getStatus());
                return largeFileTransferOpCmd;
            case 30:
                if (command instanceof CancelLargeFileTransferCmd) {
                    cancelLargeFileTransferCmd = (CancelLargeFileTransferCmd) command;
                } else {
                    cancelLargeFileTransferCmd = new CancelLargeFileTransferCmd();
                }
                CommonResponse commonResponse2 = new CommonResponse();
                commonResponse2.setRawData(paramData);
                cancelLargeFileTransferCmd.setStatus(basePacket.getStatus());
                cancelLargeFileTransferCmd.setOpCodeSn(basePacket.getOpCodeSn());
                cancelLargeFileTransferCmd.setResponse(commonResponse2);
                return cancelLargeFileTransferCmd;
            case 32:
                if (command instanceof LargeFileTransferGetNameCmd) {
                    largeFileTransferGetNameCmd = (LargeFileTransferGetNameCmd) command;
                } else {
                    largeFileTransferGetNameCmd = new LargeFileTransferGetNameCmd(new LargeFileTransferGetNameCmd.Param("", 0));
                }
                CommonResponse commonResponse3 = new CommonResponse();
                commonResponse3.setRawData(paramData);
                largeFileTransferGetNameCmd.setStatus(basePacket.getStatus());
                largeFileTransferGetNameCmd.setOpCodeSn(basePacket.getOpCodeSn());
                largeFileTransferGetNameCmd.setResponse(commonResponse3);
                return largeFileTransferGetNameCmd;
            case 33:
                if (command instanceof NotifyPrepareEnvCmd) {
                    notifyPrepareEnvCmd = (NotifyPrepareEnvCmd) command;
                } else {
                    notifyPrepareEnvCmd = new NotifyPrepareEnvCmd(new NotifyPrepareEnvCmd.Param((byte) 0));
                }
                CommonResponse commonResponse4 = new CommonResponse();
                commonResponse4.setRawData(paramData);
                notifyPrepareEnvCmd.setOpCodeSn(basePacket.getOpCodeSn());
                notifyPrepareEnvCmd.setStatus(basePacket.getStatus());
                notifyPrepareEnvCmd.setResponse(commonResponse4);
                return notifyPrepareEnvCmd;
        }
        return null;
    }
}
