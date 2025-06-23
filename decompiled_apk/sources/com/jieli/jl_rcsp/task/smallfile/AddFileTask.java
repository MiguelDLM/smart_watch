package com.jieli.jl_rcsp.task.smallfile;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.command.file_op.SmallFileTransferCmd;
import com.jieli.jl_rcsp.task.TaskBase;
import com.jieli.jl_rcsp.task.smallfile.QueryFileTask;
import com.jieli.jl_rcsp.tool.DeviceStatusManager;
import com.jieli.jl_rcsp.util.CryptoUtil;
import com.jieli.jl_rcsp.util.JL_Log;

/* loaded from: classes10.dex */
public class AddFileTask extends TaskBase {
    public final Param b;
    public QueryFileTask.File c;

    /* loaded from: classes10.dex */
    public static class Param {

        /* renamed from: a, reason: collision with root package name */
        public int f17988a = 0;
        public int b;
        public byte[] c;
        protected int size;
        protected byte type;

        public Param(byte b, byte[] bArr) {
            this.type = b;
            this.size = bArr.length;
            this.c = bArr;
        }

        public byte[] getData() {
            return this.c;
        }

        public int getOffset() {
            return this.f17988a;
        }

        public int getPacketSize() {
            return this.b;
        }

        public int getSize() {
            return this.size;
        }

        public byte getType() {
            return this.type;
        }

        public void setData(byte[] bArr) {
            this.c = bArr;
        }

        public void setOffset(int i) {
            this.f17988a = i;
        }

        public void setPacketSize(int i) {
            this.b = i;
        }

        public void setSize(int i) {
            this.size = i;
        }

        public void setType(byte b) {
            this.type = b;
        }
    }

    public AddFileTask(RcspOpImpl rcspOpImpl, Param param) throws RuntimeException {
        super(rcspOpImpl);
        if (param != null) {
            this.b = param;
            if (param.b == 0) {
                param.b = DeviceStatusManager.getInstance().getMaxCommunicationMtu(getConnectedDevice()) - 20;
                return;
            }
            return;
        }
        throw new RuntimeException("AddFileTask.Param can not be null.");
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void cancel(byte b) {
        throw new RuntimeException("can not invoke cancel method");
    }

    public QueryFileTask.File getFile() {
        return this.c;
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void start() {
        if (isRun()) {
            JL_Log.w(this.tag, "start", "Task is in progress.");
        } else {
            callbackBegin();
            a(this.b.f17988a, Math.min(this.b.b, this.b.size), (short) 0);
        }
    }

    public final void a(int i, int i2, short s) {
        int min = Math.min(this.b.size - i, i2);
        byte[] bArr = new byte[min];
        System.arraycopy(this.b.c, i, bArr, 0, min);
        final int i3 = min + i;
        final short CRC16 = CryptoUtil.CRC16(bArr, s);
        final SmallFileTransferCmd.Param a2 = a((short) i, (short) this.b.size, bArr, CRC16);
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), new SmallFileTransferCmd(a2), new RcspCommandCallback<SmallFileTransferCmd>() { // from class: com.jieli.jl_rcsp.task.smallfile.AddFileTask.1
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError) {
                AddFileTask.this.callbackError(baseError.getSubCode(), baseError.getMessage());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onCommandResponse(BluetoothDevice bluetoothDevice, SmallFileTransferCmd smallFileTransferCmd) {
                if (smallFileTransferCmd.getStatus() != 0) {
                    onErrCode(bluetoothDevice, AddFileTask.this.buildResponseBadState(smallFileTransferCmd.getId(), smallFileTransferCmd.getStatus()));
                    return;
                }
                SmallFileTransferCmd.ResultResponse resultResponse = (SmallFileTransferCmd.ResultResponse) smallFileTransferCmd.getResponse();
                byte b = resultResponse.ret;
                if (b != 0) {
                    onErrCode(bluetoothDevice, AddFileTask.this.buildResponseBadResult(smallFileTransferCmd.getId(), b));
                    return;
                }
                AddFileTask.this.callbackProgress((int) ((i3 * 100.0d) / AddFileTask.this.b.size));
                if (i3 >= AddFileTask.this.b.size) {
                    if (!(a2 instanceof SmallFileTransferCmd.AddFileParam)) {
                        JL_Log.d(((TaskBase) AddFileTask.this).tag, "write", "update small file finished id = " + ((int) AddFileTask.this.c.id));
                    } else {
                        AddFileTask addFileTask = AddFileTask.this;
                        addFileTask.c = new QueryFileTask.File(addFileTask.b.type, ((SmallFileTransferCmd.AddFileResponse) resultResponse).id, AddFileTask.this.b.size);
                        JL_Log.d(((TaskBase) AddFileTask.this).tag, "write", "add small file finished id = " + ((int) AddFileTask.this.c.id));
                    }
                    AddFileTask.this.callbackFinish();
                    return;
                }
                AddFileTask addFileTask2 = AddFileTask.this;
                addFileTask2.a(i3, addFileTask2.b.b, CRC16);
            }
        });
    }

    public SmallFileTransferCmd.Param a(short s, short s2, byte[] bArr, short s3) {
        return new SmallFileTransferCmd.AddFileParam(this.b.type, s, s2, bArr, s3);
    }
}
