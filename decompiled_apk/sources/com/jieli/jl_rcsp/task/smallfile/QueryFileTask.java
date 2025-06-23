package com.jieli.jl_rcsp.task.smallfile;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.command.file_op.SmallFileTransferCmd;
import com.jieli.jl_rcsp.task.TaskBase;
import com.jieli.jl_rcsp.util.JL_Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class QueryFileTask extends TaskBase {
    public static final byte TYPE_BLOOD_OXYGEN = 4;
    public static final byte TYPE_CALL_LOG = 8;
    public static final byte TYPE_CONTACTS = 1;
    public static final byte TYPE_HEART_RATE = 3;
    public static final byte TYPE_MESSAGE_SYNC = 6;
    public static final byte TYPE_SLEEP = 5;
    public static final byte TYPE_SPORTS_RECORD = 2;
    public static final byte TYPE_STEP = 9;
    public static final byte TYPE_WEATHER = 7;
    public final Param b;
    public List<File> c;

    /* loaded from: classes10.dex */
    public static class File {
        public short id;
        public int size;
        public byte type;

        public File(byte b, short s, int i) {
            this.id = s;
            this.size = i;
            this.type = b;
        }

        public String toString() {
            return "File{id=" + ((int) this.id) + ", size=" + this.size + ", type=" + ((int) this.type) + '}';
        }
    }

    /* loaded from: classes10.dex */
    public static class Param {
        public byte type;

        public Param(byte b) {
            this.type = b;
        }
    }

    public QueryFileTask(RcspOpImpl rcspOpImpl, Param param) {
        super(rcspOpImpl);
        if (param != null) {
            this.b = param;
            return;
        }
        throw new RuntimeException("QueryFileTask.Param can not be null.");
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void cancel(byte b) {
    }

    public List<File> getFiles() {
        return this.c;
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void start() {
        if (isRun()) {
            JL_Log.w(this.tag, "start", "Task is in progress.");
        } else {
            callbackBegin();
            this.mRcspOp.sendRcspCommand(getConnectedDevice(), new SmallFileTransferCmd(new SmallFileTransferCmd.QueryParam(this.b.type)), new RcspCommandCallback<SmallFileTransferCmd>() { // from class: com.jieli.jl_rcsp.task.smallfile.QueryFileTask.1
                @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
                public void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError) {
                    QueryFileTask.this.callbackError(baseError.getSubCode(), baseError.getMessage());
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
                public void onCommandResponse(BluetoothDevice bluetoothDevice, SmallFileTransferCmd smallFileTransferCmd) {
                    if (smallFileTransferCmd.getStatus() != 0) {
                        onErrCode(bluetoothDevice, QueryFileTask.this.buildResponseBadState(smallFileTransferCmd.getId(), smallFileTransferCmd.getStatus()));
                        return;
                    }
                    List<SmallFileTransferCmd.QueryResponse.File> files = ((SmallFileTransferCmd.QueryResponse) smallFileTransferCmd.getResponse()).getFiles();
                    QueryFileTask.this.c = new ArrayList();
                    if (files != null) {
                        for (SmallFileTransferCmd.QueryResponse.File file : files) {
                            QueryFileTask.this.c.add(new File(file.type, file.id, file.size));
                        }
                    }
                    QueryFileTask.this.callbackFinish();
                }
            });
        }
    }
}
