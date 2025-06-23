package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_filebrowse.bean.PathData;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.command.file_op.DelDevFileCmd;
import com.jieli.jl_rcsp.model.command.file_op.DeleteFileByNameCmd;
import com.jieli.jl_rcsp.model.command.file_op.DeviceFormatCmd;
import com.jieli.jl_rcsp.model.command.file_op.NotifyFileStructureChangeCmd;
import com.jieli.jl_rcsp.model.command.file_op.StartFileBrowseCmd;
import com.jieli.jl_rcsp.model.command.file_op.StopFileBrowseCmd;
import com.jieli.jl_rcsp.model.parameter.DelDevFileParam;
import com.jieli.jl_rcsp.model.parameter.StartFileBrowseParam;
import com.jieli.jl_rcsp.model.parameter.StopFileBrowseParam;
import com.jieli.jl_rcsp.model.response.DelDevFileResponse;
import com.jieli.jl_rcsp.model.response.StartFileBrowseResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class FileBrowseCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        DelDevFileCmd delDevFileCmd;
        DeviceFormatCmd deviceFormatCmd;
        DeleteFileByNameCmd deleteFileByNameCmd;
        if (basePacket == null) {
            return null;
        }
        int opCode = basePacket.getOpCode();
        if (opCode != 12 && opCode != 13 && opCode != 31 && opCode != 35 && opCode != 34 && opCode != 242) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        byte b = -1;
        int i = 0;
        if (basePacket.getType() == 1) {
            if (opCode != 12) {
                if (opCode != 13) {
                    if (opCode == 242) {
                        return new NotifyFileStructureChangeCmd(new NotifyFileStructureChangeCmd.Param(paramData)).setOpCodeSn(basePacket.getOpCodeSn());
                    }
                } else {
                    if (paramData != null && paramData.length > 0) {
                        b = paramData[0];
                    }
                    return new StopFileBrowseCmd(new StopFileBrowseParam(b)).setOpCodeSn(basePacket.getOpCodeSn());
                }
            } else {
                PathData pathData = new PathData();
                if (paramData != null && paramData.length > 0) {
                    pathData.parse(paramData);
                }
                return new StartFileBrowseCmd(new StartFileBrowseParam(pathData)).setOpCodeSn(basePacket.getOpCodeSn());
            }
        } else {
            CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, opCode, basePacket.getOpCodeSn());
            if (opCode != 12) {
                if (opCode != 13) {
                    if (opCode != 31) {
                        if (opCode != 34) {
                            if (opCode == 35) {
                                if (command != null) {
                                    deleteFileByNameCmd = (DeleteFileByNameCmd) command;
                                } else {
                                    deleteFileByNameCmd = new DeleteFileByNameCmd(new DeleteFileByNameCmd.Param(""));
                                }
                                deleteFileByNameCmd.setResponse(new DeleteFileByNameCmd.Response());
                                deleteFileByNameCmd.setStatus(basePacket.getStatus());
                                deleteFileByNameCmd.setOpCodeSn(basePacket.getOpCodeSn());
                                return deleteFileByNameCmd;
                            }
                        } else {
                            if (command != null) {
                                deviceFormatCmd = (DeviceFormatCmd) command;
                            } else {
                                deviceFormatCmd = new DeviceFormatCmd(new DeviceFormatCmd.Param(0));
                            }
                            deviceFormatCmd.setResponse(new DeviceFormatCmd.Response(paramData[0]));
                            deviceFormatCmd.setOpCodeSn(basePacket.getOpCodeSn());
                            deviceFormatCmd.setStatus(basePacket.getStatus());
                            return deviceFormatCmd;
                        }
                    } else {
                        if (command != null) {
                            delDevFileCmd = (DelDevFileCmd) command;
                        } else {
                            delDevFileCmd = new DelDevFileCmd(new DelDevFileParam(0, (byte) 0, 0, false));
                        }
                        delDevFileCmd.setResponse(new DelDevFileResponse());
                        delDevFileCmd.setStatus(basePacket.getStatus());
                        delDevFileCmd.setOpCodeSn(basePacket.getOpCodeSn());
                        return delDevFileCmd;
                    }
                } else {
                    CommonResponse commonResponse = new CommonResponse();
                    commonResponse.setRawData(paramData);
                    if (command != null) {
                        StopFileBrowseCmd stopFileBrowseCmd = (StopFileBrowseCmd) command;
                        stopFileBrowseCmd.setStatus(basePacket.getStatus());
                        stopFileBrowseCmd.setResponse(commonResponse);
                        return stopFileBrowseCmd;
                    }
                    StopFileBrowseCmd stopFileBrowseCmd2 = new StopFileBrowseCmd(new StopFileBrowseParam((byte) -1));
                    stopFileBrowseCmd2.setOpCodeSn(basePacket.getOpCodeSn());
                    stopFileBrowseCmd2.setStatus(basePacket.getStatus());
                    stopFileBrowseCmd2.setResponse(commonResponse);
                    return stopFileBrowseCmd2;
                }
            } else {
                StartFileBrowseResponse startFileBrowseResponse = new StartFileBrowseResponse();
                startFileBrowseResponse.setRawData(paramData);
                if (paramData != null) {
                    int length = paramData.length;
                    if (length != 1) {
                        if (length != 2) {
                            if (length == 4) {
                                i = CHexConver.bytesToInt(paramData);
                            }
                        } else {
                            i = CHexConver.bytesToInt(paramData[0], paramData[1]);
                        }
                    } else {
                        i = CHexConver.byteToInt(paramData[0]);
                    }
                }
                startFileBrowseResponse.setTotalFile(i);
                if (command != null) {
                    StartFileBrowseCmd startFileBrowseCmd = (StartFileBrowseCmd) command;
                    startFileBrowseCmd.setStatus(basePacket.getStatus());
                    startFileBrowseCmd.setResponse(startFileBrowseResponse);
                    return startFileBrowseCmd;
                }
                StartFileBrowseCmd startFileBrowseCmd2 = new StartFileBrowseCmd(new StartFileBrowseParam(new PathData()));
                startFileBrowseCmd2.setOpCodeSn(basePacket.getOpCodeSn());
                startFileBrowseCmd2.setStatus(basePacket.getStatus());
                startFileBrowseCmd2.setResponse(startFileBrowseResponse);
                return startFileBrowseCmd2;
            }
        }
        return null;
    }
}
