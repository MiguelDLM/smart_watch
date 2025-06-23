package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.command.sys.GetSysInfoCmd;
import com.jieli.jl_rcsp.model.command.sys.SetSysInfoCmd;
import com.jieli.jl_rcsp.model.command.sys.UpdateSysInfoCmd;
import com.jieli.jl_rcsp.model.parameter.GetSysInfoParam;
import com.jieli.jl_rcsp.model.parameter.SetSysInfoParam;
import com.jieli.jl_rcsp.model.parameter.UpdateSysInfoParam;
import com.jieli.jl_rcsp.model.response.SysInfoResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.tool.datahandles.ParseHelper;
import com.jieli.jl_rcsp.util.CHexConver;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class SysInfoCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        int i;
        if (basePacket == null) {
            return null;
        }
        int opCode = basePacket.getOpCode();
        if (opCode == 7 || opCode == 8 || opCode == 9) {
            byte[] paramData = basePacket.getParamData();
            byte b = -1;
            if (basePacket.getType() == 1) {
                byte b2 = 0;
                if (opCode != 7) {
                    if (opCode != 8) {
                        if (opCode == 9) {
                            byte[] bArr = new byte[0];
                            if (paramData != null && paramData.length > 0) {
                                b = paramData[0];
                                int length = paramData.length - 1;
                                byte[] bArr2 = new byte[length];
                                if (length > 0) {
                                    System.arraycopy(paramData, 1, bArr2, 0, length);
                                }
                                bArr = bArr2;
                            }
                            return new UpdateSysInfoCmd(new UpdateSysInfoParam(b, ParseHelper.coverParamDataToAttrBeans(bArr))).setOpCodeSn(basePacket.getOpCodeSn());
                        }
                    } else {
                        byte[] bArr3 = new byte[0];
                        if (paramData != null && paramData.length > 0) {
                            b = paramData[0];
                            int length2 = paramData.length - 1;
                            byte[] bArr4 = new byte[length2];
                            if (length2 > 0) {
                                System.arraycopy(paramData, 1, bArr4, 0, length2);
                            }
                            bArr3 = bArr4;
                        }
                        return new SetSysInfoCmd(new SetSysInfoParam(b, ParseHelper.coverParamDataToAttrBeans(bArr3))).setOpCodeSn(basePacket.getOpCodeSn());
                    }
                } else {
                    if (paramData != null && paramData.length >= 5) {
                        byte b3 = paramData[0];
                        byte[] bArr5 = new byte[4];
                        System.arraycopy(paramData, 1, bArr5, 0, 4);
                        i = CHexConver.bytesToInt(bArr5);
                        b2 = b3;
                    } else {
                        i = 0;
                    }
                    return new GetSysInfoCmd(new GetSysInfoParam(b2, i)).setOpCodeSn(basePacket.getOpCodeSn());
                }
            } else {
                CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, opCode, basePacket.getOpCodeSn());
                if (opCode != 7) {
                    if (opCode == 8) {
                        CommonResponse commonResponse = new CommonResponse();
                        commonResponse.setRawData(paramData);
                        if (command != null) {
                            SetSysInfoCmd setSysInfoCmd = (SetSysInfoCmd) command;
                            setSysInfoCmd.setStatus(basePacket.getStatus());
                            setSysInfoCmd.setResponse(commonResponse);
                            return setSysInfoCmd;
                        }
                        SetSysInfoCmd setSysInfoCmd2 = new SetSysInfoCmd(new SetSysInfoParam((byte) -1, new ArrayList()));
                        setSysInfoCmd2.setOpCodeSn(basePacket.getOpCodeSn());
                        setSysInfoCmd2.setStatus(basePacket.getStatus());
                        setSysInfoCmd2.setResponse(commonResponse);
                        return setSysInfoCmd2;
                    }
                } else {
                    SysInfoResponse sysInfoResponse = new SysInfoResponse();
                    sysInfoResponse.setRawData(paramData);
                    if (basePacket.getStatus() == 0) {
                        ParseHelper.parseSysInfo(sysInfoResponse, basePacket);
                    }
                    if (command != null) {
                        GetSysInfoCmd getSysInfoCmd = (GetSysInfoCmd) command;
                        getSysInfoCmd.setStatus(basePacket.getStatus());
                        getSysInfoCmd.setResponse(sysInfoResponse);
                        return getSysInfoCmd;
                    }
                    GetSysInfoCmd getSysInfoCmd2 = new GetSysInfoCmd(new GetSysInfoParam((byte) -1, 255));
                    getSysInfoCmd2.setOpCodeSn(basePacket.getOpCodeSn());
                    getSysInfoCmd2.setStatus(basePacket.getStatus());
                    getSysInfoCmd2.setResponse(sysInfoResponse);
                    return getSysInfoCmd2;
                }
            }
        }
        return null;
    }
}
