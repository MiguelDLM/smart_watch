package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.command.file_op.StartLrcGetCmd;
import com.jieli.jl_rcsp.model.command.file_op.StopLrcGetCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;

/* loaded from: classes10.dex */
public class LrcCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket == null) {
            return null;
        }
        int opCode = basePacket.getOpCode();
        if (opCode == 15 || opCode == 16 || opCode == 17) {
            if (basePacket.getType() == 1) {
                switch (opCode) {
                    case 15:
                        return new StartLrcGetCmd().setOpCodeSn(basePacket.getOpCodeSn());
                    case 16:
                        return new StopLrcGetCmd().setOpCodeSn(basePacket.getOpCodeSn());
                    case 17:
                        return new CommandBase(opCode, "PushStartTtsCmd").setOpCodeSn(basePacket.getOpCodeSn());
                }
            }
            CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, opCode, basePacket.getOpCodeSn());
            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setRawData(basePacket.getParamData());
            if (opCode != 15) {
                if (opCode == 16) {
                    if (command != null) {
                        StopLrcGetCmd stopLrcGetCmd = (StopLrcGetCmd) command;
                        stopLrcGetCmd.setStatus(basePacket.getStatus());
                        stopLrcGetCmd.setResponse(commonResponse);
                        return stopLrcGetCmd;
                    }
                    StopLrcGetCmd stopLrcGetCmd2 = new StopLrcGetCmd();
                    stopLrcGetCmd2.setOpCodeSn(basePacket.getOpCodeSn());
                    stopLrcGetCmd2.setStatus(basePacket.getStatus());
                    stopLrcGetCmd2.setResponse(commonResponse);
                    return stopLrcGetCmd2;
                }
            } else {
                if (command != null) {
                    StartLrcGetCmd startLrcGetCmd = (StartLrcGetCmd) command;
                    startLrcGetCmd.setStatus(basePacket.getStatus());
                    startLrcGetCmd.setResponse(commonResponse);
                    return startLrcGetCmd;
                }
                StartLrcGetCmd startLrcGetCmd2 = new StartLrcGetCmd();
                startLrcGetCmd2.setOpCodeSn(basePacket.getOpCodeSn());
                startLrcGetCmd2.setStatus(basePacket.getStatus());
                startLrcGetCmd2.setResponse(commonResponse);
                return startLrcGetCmd2;
            }
        }
        return null;
    }
}
