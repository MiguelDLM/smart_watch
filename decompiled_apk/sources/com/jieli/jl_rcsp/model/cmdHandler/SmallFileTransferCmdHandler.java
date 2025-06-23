package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.BaseResponse;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.file_op.SmallFileTransferCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;

/* loaded from: classes10.dex */
public class SmallFileTransferCmdHandler implements ICmdHandler {
    private final String TAG = SmallFileTransferCmdHandler.class.getSimpleName();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        BaseResponse queryResponse;
        SmallFileTransferCmd.Param queryParam;
        if (basePacket == null || basePacket.getOpCode() != 40) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        if (basePacket.getType() == 1) {
            byte b = paramData[0];
            int length = paramData.length;
            int i = length - 1;
            byte[] bArr = new byte[i];
            System.arraycopy(paramData, 1, bArr, 0, i);
            if (b != 0) {
                if (b != 1) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b == 4) {
                                queryParam = new SmallFileTransferCmd.DeleteFileParam(bArr[0], CHexConver.bytesToShort(bArr[1], bArr[2]));
                            } else {
                                throw new RuntimeException("invalid Small file transfer cmd op");
                            }
                        } else {
                            byte b2 = bArr[0];
                            short bytesToShort = CHexConver.bytesToShort(bArr[1], bArr[2]);
                            short bytesToShort2 = CHexConver.bytesToShort(bArr[3], bArr[4]);
                            short bytesToShort3 = CHexConver.bytesToShort(bArr[5], bArr[6]);
                            short bytesToShort4 = CHexConver.bytesToShort(bArr[7], bArr[8]);
                            int i2 = length - 10;
                            byte[] bArr2 = new byte[i2];
                            System.arraycopy(bArr, 9, bArr2, 0, i2);
                            queryParam = new SmallFileTransferCmd.UpdateFileParam(b2, bytesToShort, bytesToShort2, bytesToShort3, bArr2, bytesToShort4);
                        }
                    } else {
                        byte b3 = bArr[0];
                        short bytesToShort5 = CHexConver.bytesToShort(bArr[1], bArr[2]);
                        short bytesToShort6 = CHexConver.bytesToShort(bArr[3], bArr[4]);
                        short bytesToShort7 = CHexConver.bytesToShort(bArr[5], bArr[6]);
                        int i3 = length - 8;
                        byte[] bArr3 = new byte[i3];
                        System.arraycopy(bArr, 7, bArr3, 0, i3);
                        queryParam = new SmallFileTransferCmd.AddFileParam(b3, bytesToShort5, bytesToShort6, bArr3, bytesToShort7);
                    }
                } else {
                    queryParam = new SmallFileTransferCmd.ReadFileParam(bArr[0], CHexConver.bytesToShort(bArr[1], bArr[2]), CHexConver.bytesToShort(bArr[3], bArr[4]), CHexConver.bytesToShort(bArr[5], bArr[6]), bArr[7]);
                }
            } else {
                queryParam = new SmallFileTransferCmd.QueryParam(bArr[0]);
            }
            SmallFileTransferCmd smallFileTransferCmd = new SmallFileTransferCmd(queryParam);
            smallFileTransferCmd.setOpCodeSn(basePacket.getOpCodeSn());
            return smallFileTransferCmd;
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        if (command == null) {
            JL_Log.e(this.TAG, "parseDataToCmd", "invalid small file transfer cmd response");
            return null;
        }
        SmallFileTransferCmd smallFileTransferCmd2 = (SmallFileTransferCmd) command;
        smallFileTransferCmd2.setOpCodeSn(basePacket.getOpCodeSn());
        smallFileTransferCmd2.setStatus(basePacket.getStatus());
        if (basePacket.getStatus() != 0) {
            JL_Log.w(this.TAG, "parseDataToCmd", "small file transfer cmd  send fail, status = " + basePacket.getStatus());
            smallFileTransferCmd2.setResponse(new SmallFileTransferCmd.Response());
            return smallFileTransferCmd2;
        }
        byte b4 = paramData[0];
        int length2 = paramData.length - 1;
        byte[] bArr4 = new byte[length2];
        System.arraycopy(paramData, 1, bArr4, 0, length2);
        if (b4 != 0) {
            if (b4 != 1) {
                if (b4 != 2) {
                    if (b4 != 3 && b4 != 4) {
                        queryResponse = new SmallFileTransferCmd.Response();
                    } else {
                        queryResponse = new SmallFileTransferCmd.ResultResponse(bArr4[0]);
                    }
                } else {
                    queryResponse = new SmallFileTransferCmd.AddFileResponse(bArr4);
                }
            } else {
                queryResponse = new SmallFileTransferCmd.ReadFileResponse(bArr4);
            }
        } else {
            queryResponse = new SmallFileTransferCmd.QueryResponse(((SmallFileTransferCmd.QueryParam) smallFileTransferCmd2.getParam()).data[0], bArr4);
        }
        queryResponse.setRawData(bArr4);
        smallFileTransferCmd2.setResponse(queryResponse);
        return smallFileTransferCmd2;
    }
}
