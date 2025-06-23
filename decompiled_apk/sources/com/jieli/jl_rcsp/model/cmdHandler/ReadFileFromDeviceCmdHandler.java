package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.BaseResponse;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.file_op.ReadFileFromDeviceCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class ReadFileFromDeviceCmdHandler implements ICmdHandler {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        byte[] paramData;
        BaseResponse startResponse;
        ReadFileFromDeviceCmd.Param param;
        if (basePacket == null || (paramData = basePacket.getParamData()) == null || paramData.length == 0) {
            return null;
        }
        int i = 0;
        byte b = 0;
        byte b2 = 0;
        if (basePacket.getType() == 1) {
            byte b3 = paramData[0];
            if (b3 == Byte.MIN_VALUE) {
                if (basePacket.getStatus() == 0) {
                    b = paramData[1];
                }
                param = new ReadFileFromDeviceCmd.StopParam(b);
            } else if (b3 == -127) {
                if (basePacket.getStatus() == 0) {
                    b2 = paramData[1];
                }
                param = new ReadFileFromDeviceCmd.CancelParam(b2);
            } else {
                param = new ReadFileFromDeviceCmd.Param((byte) -1);
            }
            ReadFileFromDeviceCmd readFileFromDeviceCmd = new ReadFileFromDeviceCmd(param);
            readFileFromDeviceCmd.setOpCodeSn(basePacket.getOpCodeSn());
            return readFileFromDeviceCmd;
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        if (command == null) {
            ReadFileFromDeviceCmd readFileFromDeviceCmd2 = new ReadFileFromDeviceCmd(null);
            readFileFromDeviceCmd2.setOpCodeSn(basePacket.getOpCodeSn());
            return readFileFromDeviceCmd2;
        }
        ReadFileFromDeviceCmd readFileFromDeviceCmd3 = (ReadFileFromDeviceCmd) command;
        byte b4 = ((ReadFileFromDeviceCmd.Param) readFileFromDeviceCmd3.getParam()).op;
        if (b4 != 0 && b4 != 1 && b4 != 2) {
            startResponse = new ReadFileFromDeviceCmd.Response();
        } else {
            if (basePacket.getStatus() == 0) {
                i = CHexConver.bytesToInt(paramData, 1, 4);
            }
            startResponse = new ReadFileFromDeviceCmd.StartResponse(i);
        }
        startResponse.setRawData(basePacket.getParamData());
        readFileFromDeviceCmd3.setStatus(basePacket.getStatus());
        readFileFromDeviceCmd3.setOpCodeSn(basePacket.getOpCodeSn());
        readFileFromDeviceCmd3.setResponse(startResponse);
        return readFileFromDeviceCmd3;
    }
}
