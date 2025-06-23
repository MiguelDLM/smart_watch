package com.jieli.jl_rcsp.task;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.model.command.file_op.ReadFileFromDeviceCmd;

/* loaded from: classes10.dex */
public class GetFileByClusterTask extends GetFileTask {
    public final Param n;

    /* loaded from: classes10.dex */
    public static class Param {
        public int cluster;
        public int devHandler;
        public int offset;
        public String outPath;

        public Param(int i, int i2, int i3, String str) {
            this.devHandler = i;
            this.offset = i2;
            this.cluster = i3;
            this.outPath = str;
        }
    }

    public GetFileByClusterTask(RcspOpImpl rcspOpImpl, Param param) throws RuntimeException {
        super(rcspOpImpl, a(param));
        this.n = param;
    }

    public static String a(Param param) throws RuntimeException {
        if (param != null) {
            return param.outPath;
        }
        throw new RuntimeException("GetFileByClusterTask.Param can not be null");
    }

    @Override // com.jieli.jl_rcsp.task.GetFileTask
    public ReadFileFromDeviceCmd.Param createParam(BluetoothDevice bluetoothDevice) {
        Param param = this.n;
        return new ReadFileFromDeviceCmd.StartWithClusterParam(param.devHandler, param.offset, param.cluster);
    }
}
