package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.file_op.DeviceExtendParamCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;

/* loaded from: classes10.dex */
public class DeviceExtendParamCmdHandler implements ICmdHandler {
    private final String tag = getClass().getSimpleName();

    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        DeviceExtendParamCmd deviceExtendParamCmd;
        DeviceExtendParamCmd.Response response;
        byte[] paramData = basePacket.getParamData();
        DeviceExtendParamCmd.Param param = null;
        if (paramData != null && paramData.length >= 1) {
            if (basePacket.getType() == 1) {
                byte b = paramData[0];
                if (b != 0) {
                    if (b != 1) {
                        if (b == 2) {
                            param = new DeviceExtendParamCmd.ReadFileParam(paramData);
                        }
                    } else {
                        param = new DeviceExtendParamCmd.DeleteFileParam(paramData);
                    }
                } else {
                    param = new DeviceExtendParamCmd.FileTransferParam(paramData);
                }
                return new DeviceExtendParamCmd(param);
            }
            CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
            if (command != null) {
                deviceExtendParamCmd = (DeviceExtendParamCmd) command;
            } else {
                deviceExtendParamCmd = new DeviceExtendParamCmd(new DeviceExtendParamCmd.Param(paramData[0]));
            }
            byte b2 = paramData[0];
            if (b2 == 0) {
                response = new DeviceExtendParamCmd.FileTransferResponse(paramData);
            } else {
                response = new DeviceExtendParamCmd.Response(b2);
            }
            response.setRawData(paramData);
            deviceExtendParamCmd.setStatus(basePacket.getStatus());
            deviceExtendParamCmd.setOpCodeSn(basePacket.getOpCodeSn());
            deviceExtendParamCmd.setResponse(response);
            return deviceExtendParamCmd;
        }
        JL_Log.e(this.tag, "parseDataToCmd", "异常：数据包内容为空，cmd id = " + RcspUtil.formatString("%02x", Integer.valueOf(basePacket.getOpCode())));
        return null;
    }
}
