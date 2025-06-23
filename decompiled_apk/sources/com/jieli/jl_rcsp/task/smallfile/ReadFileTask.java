package com.jieli.jl_rcsp.task.smallfile;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.command.file_op.SmallFileTransferCmd;
import com.jieli.jl_rcsp.task.TaskBase;
import com.jieli.jl_rcsp.tool.DeviceStatusManager;
import com.jieli.jl_rcsp.util.CryptoUtil;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.nio.ByteBuffer;

/* loaded from: classes10.dex */
public class ReadFileTask extends TaskBase {
    public final Param b;
    public final ByteBuffer c;

    /* loaded from: classes10.dex */
    public static class Param {

        /* renamed from: a, reason: collision with root package name */
        public final byte f17994a;
        public final short b;
        public final int c;
        public final int d;
        public int e;

        public Param(byte b, short s, int i, int i2) {
            this.f17994a = b;
            this.b = s;
            this.c = i;
            this.d = i2;
        }

        public short getId() {
            return this.b;
        }

        public int getOffset() {
            return this.d;
        }

        public int getPacketSize() {
            return this.e;
        }

        public int getSize() {
            return this.c;
        }

        public byte getType() {
            return this.f17994a;
        }

        public void setPacketSize(int i) {
            this.e = i;
        }
    }

    public ReadFileTask(RcspOpImpl rcspOpImpl, Param param) throws RuntimeException {
        super(rcspOpImpl);
        if (param != null) {
            if (param.c > 0) {
                this.b = param;
                if (param.e == 0) {
                    param.e = DeviceStatusManager.getInstance().getMaxReceiveMtu(getConnectedDevice()) - 20;
                }
                this.c = ByteBuffer.allocate(param.c - param.d);
                return;
            }
            throw new RuntimeException("The size must be greater than 0");
        }
        throw new RuntimeException("ReadFileTask.Param can not be null.");
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void cancel(byte b) {
        throw new RuntimeException("can not invoke cancel method");
    }

    public byte[] getReadData() {
        return this.c.array();
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void start() {
        if (isRun()) {
            JL_Log.w(this.tag, "start", "Task is in progress.");
        } else {
            callbackBegin();
            a(this.b.d, Math.min(this.b.c, this.b.e), (short) 0);
        }
    }

    public final void a(final int i, final int i2, final short s) {
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), new SmallFileTransferCmd(new SmallFileTransferCmd.ReadFileParam(this.b.f17994a, this.b.b, (short) i, (short) i2, i == this.b.d ? (byte) 1 : (byte) 0)), new RcspCommandCallback<SmallFileTransferCmd>() { // from class: com.jieli.jl_rcsp.task.smallfile.ReadFileTask.1
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError) {
                ReadFileTask.this.callbackError(baseError.getSubCode(), baseError.getMessage());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onCommandResponse(BluetoothDevice bluetoothDevice, SmallFileTransferCmd smallFileTransferCmd) {
                if (smallFileTransferCmd.getStatus() != 0) {
                    onErrCode(bluetoothDevice, ReadFileTask.this.buildResponseBadState(smallFileTransferCmd.getId(), smallFileTransferCmd.getStatus()));
                    return;
                }
                SmallFileTransferCmd.ReadFileResponse readFileResponse = (SmallFileTransferCmd.ReadFileResponse) smallFileTransferCmd.getResponse();
                byte b = readFileResponse.ret;
                if (b != 0) {
                    onErrCode(bluetoothDevice, ReadFileTask.this.buildResponseBadResult(smallFileTransferCmd.getId(), b));
                    return;
                }
                short CRC16 = CryptoUtil.CRC16(readFileResponse.fileData, s);
                if (CRC16 == readFileResponse.crc) {
                    ReadFileTask.this.c.put(readFileResponse.fileData);
                    int i3 = i + i2;
                    ReadFileTask.this.callbackProgress((int) ((i3 * 100.0d) / ReadFileTask.this.b.c));
                    if (i3 >= ReadFileTask.this.c.capacity()) {
                        ReadFileTask.this.callbackFinish();
                        return;
                    } else {
                        ReadFileTask readFileTask = ReadFileTask.this;
                        readFileTask.a(i3, Math.min(i2, readFileTask.b.c - i3), CRC16);
                        return;
                    }
                }
                onErrCode(bluetoothDevice, new BaseError(12544, RcspUtil.formatString("app last crc = %x, app crc = %x, device crc = %x.", Short.valueOf(s), Short.valueOf(CRC16), Short.valueOf(readFileResponse.crc))));
            }
        });
    }
}
