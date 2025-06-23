package com.jieli.jl_rcsp.watch.fatfs;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_fatfs.FatFileSystem;
import com.jieli.jl_fatfs.interfaces.IBluetoothCtrl;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.command.external_flash.ExtFlashIOCtrlNoResponseCmd;
import com.jieli.jl_rcsp.model.command.external_flash.ExternalFlashIOCtrlCmd;
import com.jieli.jl_rcsp.model.parameter.ExternalFlashIOCtrlParam;
import com.jieli.jl_rcsp.model.response.ExternalFlashIOCtrlResponse;
import com.jieli.jl_rcsp.model.response.ExternalFlashMsgResponse;
import com.jieli.jl_rcsp.tool.DeviceStatusManager;
import com.jieli.jl_rcsp.tool.WatchCacheManager;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.CommandBuilder;
import com.jieli.jl_rcsp.util.CryptoUtil;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;

/* loaded from: classes10.dex */
public class FatFsBluetoothImp implements IBluetoothCtrl {
    public static final String e = "FatFsBluetoothImp";

    /* renamed from: a, reason: collision with root package name */
    public final RcspOpImpl f18249a;
    public final FatFsWatch b;
    public final DeviceStatusManager c = DeviceStatusManager.getInstance();
    public final WatchCacheManager d = new WatchCacheManager();

    public FatFsBluetoothImp(FatFsWatch fatFsWatch) {
        this.b = fatFsWatch;
        this.f18249a = fatFsWatch.getRcspOp();
    }

    public final int c(BluetoothDevice bluetoothDevice) {
        ExternalFlashMsgResponse extFlashMsg = this.c.getExtFlashMsg(bluetoothDevice);
        if (extFlashMsg == null) {
            return 0;
        }
        return extFlashMsg.getCluster();
    }

    public final int d(BluetoothDevice bluetoothDevice) {
        ExternalFlashMsgResponse extFlashMsg = this.c.getExtFlashMsg(bluetoothDevice);
        if (extFlashMsg == null) {
            return 0;
        }
        return extFlashMsg.getReceiveMtu();
    }

    public final FatFileSystem e(BluetoothDevice bluetoothDevice) {
        if (RcspUtil.deviceEquals(bluetoothDevice, this.f18249a.getTargetDevice())) {
            return this.b.getWatchSystem();
        }
        return null;
    }

    @Override // com.jieli.jl_fatfs.interfaces.IBluetoothCtrl
    public BluetoothDevice getConnectedDevice() {
        return this.f18249a.getTargetDevice();
    }

    @Override // com.jieli.jl_fatfs.interfaces.IBluetoothCtrl
    public void readFatDataFromDevice(BluetoothDevice bluetoothDevice, int i, int i2) {
        String str = e;
        JL_Log.d(str, "readFatDataFromDevice", RcspUtil.formatString("device = %s, offset = %d, size = %d", RcspUtil.printBtDeviceInfo(bluetoothDevice), Integer.valueOf(i), Integer.valueOf(i2)));
        FatFileSystem e2 = e(bluetoothDevice);
        if (e2 == null) {
            JL_Log.w(str, "readFatDataFromDevice", "No Fat File System.");
            a(bluetoothDevice, false, new byte[0]);
        } else {
            e2.createReadBuffer(i2);
            a(bluetoothDevice, i, i2);
        }
    }

    @Override // com.jieli.jl_fatfs.interfaces.IBluetoothCtrl
    public void release() {
        this.d.destroy();
    }

    @Override // com.jieli.jl_fatfs.interfaces.IBluetoothCtrl
    public void sendWriteFlag(final BluetoothDevice bluetoothDevice, boolean z) {
        String str = e;
        JL_Log.d(str, "sendWriteFlag", RcspUtil.formatString("device = %s, writeFlag = %s", RcspUtil.printBtDeviceInfo(bluetoothDevice), Boolean.valueOf(z)));
        if (e(bluetoothDevice) == null) {
            JL_Log.w(str, "sendWriteFlag", "No Fat File System.");
            a(bluetoothDevice, false);
        } else {
            this.b.sendWriteProtectFlag(z, new OnWatchOpCallback<Boolean>() { // from class: com.jieli.jl_rcsp.watch.fatfs.FatFsBluetoothImp.2
                @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                public void onFailed(BaseError baseError) {
                    FatFsBluetoothImp.this.a(bluetoothDevice, false);
                }

                @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                public void onSuccess(Boolean bool) {
                    FatFsBluetoothImp.this.a(bluetoothDevice, true);
                }
            });
        }
    }

    @Override // com.jieli.jl_fatfs.interfaces.IBluetoothCtrl
    public void writeFatDataToDevice(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        String str = e;
        JL_Log.d(str, "writeFatDataToDevice", RcspUtil.formatString("device = %s, offset = %d, \ndata = %s", RcspUtil.printBtDeviceInfo(bluetoothDevice), Integer.valueOf(i), CHexConver.byte2HexStr(bArr)));
        FatFileSystem e2 = e(bluetoothDevice);
        if (e2 == null) {
            a(bluetoothDevice, "writeFatDataToDevice", "No Fat File System.");
            return;
        }
        e2.setWriteBuffer(bArr);
        if (a(i)) {
            this.d.putWatchCacheByDevice(bluetoothDevice, new WatchCacheManager.WatchCache().setWriteOffset(i).setWriteLen(bArr.length).setCrc16(CryptoUtil.CRC16(bArr, (short) 0)));
        }
        if (d(bluetoothDevice) != 0) {
            int leftDevSize = e2.getLeftDevSize();
            JL_Log.i(str, "writeFatDataToDevice", "leftDevSize ==> " + leftDevSize);
            if (leftDevSize > 0) {
                e2.setNeedWriteData(leftDevSize);
                bArr = e2.getNeedSendLeftData();
            }
            b(bluetoothDevice, i, bArr);
            return;
        }
        a(bluetoothDevice, i, bArr);
    }

    public final int b(BluetoothDevice bluetoothDevice) {
        ExternalFlashMsgResponse extFlashMsg = this.c.getExtFlashMsg(bluetoothDevice);
        if (extFlashMsg == null) {
            return 0;
        }
        return extFlashMsg.getBlockSize();
    }

    public final void b(BluetoothDevice bluetoothDevice, boolean z) {
        if (RcspUtil.deviceEquals(bluetoothDevice, this.f18249a.getTargetDevice())) {
            JL_Log.w(e, "updateWriteResult", "device : " + bluetoothDevice + ", isSuccess : " + z);
            if (this.b.getWatchSystem() != null) {
                this.b.getWatchSystem().updateWriteStatus(z);
            }
        }
    }

    public final void a(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        int b = b(bluetoothDevice);
        if (b == 0) {
            a(bluetoothDevice, "handleWriteFatData", "mtu is 0.");
            return;
        }
        FatFileSystem e2 = e(bluetoothDevice);
        if (e2 != null && !e2.writeBufferIsEmpty()) {
            int i2 = 0;
            if (bArr.length > b) {
                byte[] bArr2 = new byte[b];
                System.arraycopy(bArr, 0, bArr2, 0, b);
                i2 = 1;
                bArr = bArr2;
            }
            a(bluetoothDevice, i2, i, bArr);
            return;
        }
        a(bluetoothDevice, "handleWriteFatData", "FatFs is null or write buffer is empty.");
    }

    public final void b(BluetoothDevice bluetoothDevice, int i, int i2, byte[] bArr) {
        JL_Log.d(e, "writeDataToDeviceModify", "device =" + RcspUtil.printBtDeviceInfo(bluetoothDevice) + ", offset = " + i2 + ", flag = " + i);
        this.f18249a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildExternalFlashWriteDataCmd(i, i2, bArr), new RcspCommandCallback<ExtFlashIOCtrlNoResponseCmd>() { // from class: com.jieli.jl_rcsp.watch.fatfs.FatFsBluetoothImp.4
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onErrCode(BluetoothDevice bluetoothDevice2, BaseError baseError) {
                FatFsBluetoothImp.this.a(bluetoothDevice2, "writeDataToDeviceModify", "onErrCode ---> " + baseError);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onCommandResponse(BluetoothDevice bluetoothDevice2, ExtFlashIOCtrlNoResponseCmd extFlashIOCtrlNoResponseCmd) {
                FatFileSystem e2 = FatFsBluetoothImp.this.e(bluetoothDevice2);
                if (e2 != null && !e2.writeBufferIsEmpty()) {
                    ExternalFlashIOCtrlParam externalFlashIOCtrlParam = (ExternalFlashIOCtrlParam) extFlashIOCtrlNoResponseCmd.getParam();
                    int length = externalFlashIOCtrlParam.getData().length;
                    JL_Log.d(FatFsBluetoothImp.e, "writeDataToDeviceModify", RcspUtil.formatString("device = %s, dataLen = %d, ctrlCmd = %s", RcspUtil.printBtDeviceInfo(bluetoothDevice2), Integer.valueOf(length), extFlashIOCtrlNoResponseCmd));
                    e2.callbackProgress(length);
                    int offset = externalFlashIOCtrlParam.getOffset();
                    if (externalFlashIOCtrlParam.getFlag() != 1) {
                        if (FatFsBluetoothImp.this.a(offset)) {
                            FatFsBluetoothImp.this.a(bluetoothDevice2);
                            return;
                        } else {
                            FatFsBluetoothImp.this.a(bluetoothDevice2, 1);
                            return;
                        }
                    }
                    FatFsBluetoothImp.this.b(bluetoothDevice2, offset + length, e2.getNeedSendLeftData());
                    return;
                }
                FatFsBluetoothImp.this.a(bluetoothDevice2, "writeDataToDeviceModify", "fatFs is null or write buffer is empty.");
            }
        });
    }

    public final void b(BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            int b = b(bluetoothDevice);
            if (b == 0) {
                a(bluetoothDevice, "handleWriteFatDataModify", "mtu is 0.");
                return;
            }
            final FatFileSystem e2 = e(bluetoothDevice);
            if (e2 != null && !e2.writeBufferIsEmpty()) {
                int leftDevSize = e2.getLeftDevSize();
                JL_Log.i(e, "handleWriteFatDataModify", "lefDevSize = " + leftDevSize + ", mtu = " + b + ", leftData length = " + bArr.length);
                int i2 = 1;
                if (leftDevSize < b) {
                    this.f18249a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildExternalFlashQueryWriteResultCmd(1, CryptoUtil.CRC16(e2.getNeedWriteData(), (short) 0)), new RcspCommandCallback<ExternalFlashIOCtrlCmd>() { // from class: com.jieli.jl_rcsp.watch.fatfs.FatFsBluetoothImp.5
                        @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
                        public void onErrCode(BluetoothDevice bluetoothDevice2, BaseError baseError) {
                            FatFsBluetoothImp.this.a(bluetoothDevice2, "handleWriteFatDataModify", "onErrCode ---> " + baseError);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
                        public void onCommandResponse(BluetoothDevice bluetoothDevice2, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
                            JL_Log.i(FatFsBluetoothImp.e, "handleWriteFatDataModify", "onCommandResponse = " + externalFlashIOCtrlCmd);
                            ExternalFlashIOCtrlResponse externalFlashIOCtrlResponse = (ExternalFlashIOCtrlResponse) externalFlashIOCtrlCmd.getResponse();
                            int status = externalFlashIOCtrlCmd.getStatus();
                            int result = externalFlashIOCtrlResponse.getResult();
                            if (status == 0 && result == 0) {
                                int size = externalFlashIOCtrlResponse.getSize();
                                if (size <= 0) {
                                    JL_Log.e(FatFsBluetoothImp.e, "handleWriteFatDataModify", "left size is zero. error data");
                                } else {
                                    e2.setNeedWriteData(size);
                                    FatFsBluetoothImp.this.b(bluetoothDevice2, i, bArr);
                                    return;
                                }
                            } else {
                                JL_Log.e(FatFsBluetoothImp.e, "handleWriteFatDataModify", RcspUtil.formatString("Device reply bad status(%d). result : %d.", Integer.valueOf(status), Integer.valueOf(result)));
                            }
                            FatFsBluetoothImp.this.b(bluetoothDevice2, false);
                        }
                    });
                    return;
                }
                if (bArr.length <= b) {
                    i2 = 1 ^ (e2.judgeWriteFinish(bArr.length) ? 1 : 0);
                } else {
                    byte[] bArr2 = new byte[b];
                    System.arraycopy(bArr, 0, bArr2, 0, b);
                    bArr = bArr2;
                }
                b(bluetoothDevice, i2, i, bArr);
                return;
            }
            a(bluetoothDevice, "handleWriteFatDataModify", "fatfs is null or write buffer is empty.");
            return;
        }
        a(bluetoothDevice, "handleWriteFatDataModify", "data is null.");
    }

    public final void a(BluetoothDevice bluetoothDevice, String str) {
        JL_Log.w(e, "updateWriteFailed", "device : " + bluetoothDevice + ", " + str);
        b(bluetoothDevice, false);
    }

    public final void a(BluetoothDevice bluetoothDevice, String str, String str2) {
        a(bluetoothDevice, RcspUtil.formatString("(%s) ---> %s", str, str2));
    }

    public final void a(BluetoothDevice bluetoothDevice, int i, int i2, byte[] bArr) {
        JL_Log.d(e, "writeDataToDevice", "device =" + RcspUtil.printBtDeviceInfo(bluetoothDevice) + ", offset = " + i2 + ", flag = " + i);
        this.f18249a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildExternalFlashWriteDataCmd(i, i2, bArr), new RcspCommandCallback<ExtFlashIOCtrlNoResponseCmd>() { // from class: com.jieli.jl_rcsp.watch.fatfs.FatFsBluetoothImp.3
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onErrCode(BluetoothDevice bluetoothDevice2, BaseError baseError) {
                FatFsBluetoothImp.this.a(bluetoothDevice2, "writeDataToDevice", RcspUtil.formatString("device = %s, error = %s", RcspUtil.printBtDeviceInfo(bluetoothDevice2), baseError));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onCommandResponse(BluetoothDevice bluetoothDevice2, ExtFlashIOCtrlNoResponseCmd extFlashIOCtrlNoResponseCmd) {
                FatFileSystem e2 = FatFsBluetoothImp.this.e(bluetoothDevice2);
                if (e2 != null && !e2.writeBufferIsEmpty()) {
                    ExternalFlashIOCtrlParam externalFlashIOCtrlParam = (ExternalFlashIOCtrlParam) extFlashIOCtrlNoResponseCmd.getParam();
                    int length = externalFlashIOCtrlParam.getData().length;
                    JL_Log.d(FatFsBluetoothImp.e, "writeDataToDevice", RcspUtil.formatString("device = %s, ctrlCmd = %s, dataLen = %d", RcspUtil.printBtDeviceInfo(bluetoothDevice2), extFlashIOCtrlNoResponseCmd, Integer.valueOf(length)));
                    e2.callbackProgress(length);
                    int offset = externalFlashIOCtrlParam.getOffset();
                    if (externalFlashIOCtrlParam.isFinalData()) {
                        if (FatFsBluetoothImp.this.a(offset)) {
                            FatFsBluetoothImp.this.a(bluetoothDevice2);
                            return;
                        } else {
                            FatFsBluetoothImp.this.a(bluetoothDevice2, 0);
                            return;
                        }
                    }
                    int i3 = length + offset;
                    byte[] writeLeftData = e2.getWriteLeftData();
                    JL_Log.i(FatFsBluetoothImp.e, "writeDataToDevice", RcspUtil.formatString("oldOffset = %d, offset = %d", Integer.valueOf(offset), Integer.valueOf(i3)));
                    FatFsBluetoothImp.this.a(bluetoothDevice2, i3, writeLeftData);
                    return;
                }
                FatFsBluetoothImp.this.a(bluetoothDevice2, "writeDataToDevice", "fatFs is null or write buffer is empty.");
            }
        });
    }

    public final void a(BluetoothDevice bluetoothDevice, final int i) {
        short crc16;
        int i2;
        final FatFileSystem e2 = e(bluetoothDevice);
        if (e2 == null) {
            a(bluetoothDevice, "queryWriteDataResult", "No Fat File System.");
            return;
        }
        if (i == 1) {
            crc16 = CryptoUtil.CRC16(e2.getNeedWriteData(), (short) 0);
            i2 = 1;
        } else {
            crc16 = e2.getCrc16();
            i2 = 0;
        }
        JL_Log.i(e, "queryWriteDataResult", RcspUtil.formatString("version = %d, crc16 = %d(0x%X), flag = %d.", Integer.valueOf(i), Short.valueOf(crc16), Short.valueOf(crc16), Integer.valueOf(i2)));
        this.f18249a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildExternalFlashQueryWriteResultCmd(i2, crc16), new RcspCommandCallback<ExternalFlashIOCtrlCmd>() { // from class: com.jieli.jl_rcsp.watch.fatfs.FatFsBluetoothImp.6
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onErrCode(BluetoothDevice bluetoothDevice2, BaseError baseError) {
                FatFsBluetoothImp.this.a(bluetoothDevice2, "queryWriteDataResult", "onErrCode ---> " + baseError);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onCommandResponse(BluetoothDevice bluetoothDevice2, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
                ExternalFlashIOCtrlResponse externalFlashIOCtrlResponse = (ExternalFlashIOCtrlResponse) externalFlashIOCtrlCmd.getResponse();
                JL_Log.w(FatFsBluetoothImp.e, "queryWriteDataResult", "FlashQueryWriteResultCmd  = " + externalFlashIOCtrlCmd);
                int status = externalFlashIOCtrlCmd.getStatus();
                int result = externalFlashIOCtrlResponse.getResult();
                if (status != 0 || result != 0) {
                    FatFsBluetoothImp.this.a(bluetoothDevice2, "queryWriteDataResult", RcspUtil.formatString("Device reply bad status(%d). result : %d.", Integer.valueOf(status), Integer.valueOf(result)));
                    return;
                }
                if (i == 1) {
                    e2.setNeedWriteData(externalFlashIOCtrlResponse.getSize());
                }
                FatFsBluetoothImp.this.b(bluetoothDevice2, true);
            }
        });
    }

    public final void a(BluetoothDevice bluetoothDevice) {
        FatFileSystem e2 = e(bluetoothDevice);
        if (e2 == null) {
            a(bluetoothDevice, "checkWriteDataResult", "No Fat File System.");
            return;
        }
        WatchCacheManager.WatchCache watchCacheByDevice = this.d.getWatchCacheByDevice(bluetoothDevice);
        if (watchCacheByDevice == null) {
            a(bluetoothDevice, "checkWriteDataResult", "No write data cache.");
            return;
        }
        watchCacheByDevice.setNeedCheckReadData(true);
        e2.createReadBuffer(watchCacheByDevice.getWriteLen());
        a(bluetoothDevice, watchCacheByDevice.getWriteOffset(), watchCacheByDevice.getWriteLen());
    }

    public final void a(BluetoothDevice bluetoothDevice, int i, int i2) {
        int d = d(bluetoothDevice);
        if (d == 0) {
            d = b(bluetoothDevice);
        }
        if (d == 0) {
            JL_Log.w(e, "handleReadData", "mtu is 0.");
            a(bluetoothDevice, false, new byte[0]);
            return;
        }
        JL_Log.d(e, "handleReadData", "offset = " + i + ", size = " + i2);
        if (i2 <= d) {
            a(bluetoothDevice, 0, i, i2);
        } else {
            a(bluetoothDevice, 1, i, d);
        }
    }

    public final void a(BluetoothDevice bluetoothDevice, boolean z, byte[] bArr) {
        FatFileSystem e2 = e(bluetoothDevice);
        if (e2 == null) {
            return;
        }
        String str = e;
        JL_Log.d(str, "updateReadResult", "device : " + RcspUtil.printBtDeviceInfo(bluetoothDevice) + ", isSuccess : " + z);
        if (WatchConstant.ENABLE_WRITE_DATA_CHECK && this.d.isNeedCheckReadData(bluetoothDevice)) {
            WatchCacheManager.WatchCache removeWatchCacheByDevice = this.d.removeWatchCacheByDevice(bluetoothDevice);
            if (z) {
                short CRC16 = CryptoUtil.CRC16(bArr, (short) 0);
                JL_Log.i(str, "updateReadResult", "readCrc16 : " + ((int) CRC16) + ", cacheCrc16 : " + ((int) removeWatchCacheByDevice.getCrc16()) + ", cache offset = " + removeWatchCacheByDevice.getWriteOffset());
                if (removeWatchCacheByDevice.getCrc16() == CRC16) {
                    a(bluetoothDevice, d(bluetoothDevice) != 0 ? 1 : 0);
                    return;
                }
            }
            JL_Log.w(str, "updateReadResult", "isSuccess : " + z + ", crc is error. ");
            b(bluetoothDevice, false);
            return;
        }
        e2.updateReadStatus(z, bArr);
    }

    public final void a(BluetoothDevice bluetoothDevice, int i, int i2, int i3) {
        JL_Log.d(e, "readDataFromDevice", RcspUtil.formatString("device = %s, flag = %d, offset=%d, size=%s", RcspUtil.printBtDeviceInfo(bluetoothDevice), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
        this.f18249a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildExternalFlashReadDataCmd(i, i2, i3), new RcspCommandCallback<ExternalFlashIOCtrlCmd>() { // from class: com.jieli.jl_rcsp.watch.fatfs.FatFsBluetoothImp.7
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onErrCode(BluetoothDevice bluetoothDevice2, BaseError baseError) {
                JL_Log.w(FatFsBluetoothImp.e, "readDataFromDevice", "onErrCode ---> " + baseError);
                FatFsBluetoothImp.this.a(bluetoothDevice2, false, new byte[0]);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onCommandResponse(BluetoothDevice bluetoothDevice2, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
                FatFileSystem e2 = FatFsBluetoothImp.this.e(bluetoothDevice2);
                if (e2 != null && !e2.readBufferIsEmpty()) {
                    ExternalFlashIOCtrlResponse externalFlashIOCtrlResponse = (ExternalFlashIOCtrlResponse) externalFlashIOCtrlCmd.getResponse();
                    if (externalFlashIOCtrlResponse == null) {
                        JL_Log.w(FatFsBluetoothImp.e, "readDataFromDevice", "No response.");
                        FatFsBluetoothImp.this.a(bluetoothDevice2, false, new byte[0]);
                        return;
                    }
                    JL_Log.d(FatFsBluetoothImp.e, "readDataFromDevice", RcspUtil.formatString("device = %s, ctrlCmd = %s", RcspUtil.printBtDeviceInfo(bluetoothDevice2), externalFlashIOCtrlCmd));
                    int status = externalFlashIOCtrlCmd.getStatus();
                    int result = externalFlashIOCtrlResponse.getResult();
                    if (status == 0 && result == 0) {
                        ExternalFlashIOCtrlParam externalFlashIOCtrlParam = (ExternalFlashIOCtrlParam) externalFlashIOCtrlCmd.getParam();
                        byte[] data = externalFlashIOCtrlResponse.getData();
                        int offset = externalFlashIOCtrlParam.getOffset();
                        if (data != null && data.length > 0) {
                            e2.putDataInReadBuff(data);
                            offset += data.length;
                        }
                        if (externalFlashIOCtrlParam.isFinalData()) {
                            FatFsBluetoothImp.this.a(bluetoothDevice2, true, e2.getReadBuffer());
                            return;
                        } else {
                            FatFsBluetoothImp.this.a(bluetoothDevice2, offset, e2.getReadLeftSize());
                            return;
                        }
                    }
                    JL_Log.i(FatFsBluetoothImp.e, "readDataFromDevice", RcspUtil.formatString("Device reply bad status(%d). result : %d.", Integer.valueOf(status), Integer.valueOf(result)));
                    FatFsBluetoothImp.this.a(bluetoothDevice2, false, new byte[0]);
                    return;
                }
                String str = FatFsBluetoothImp.e;
                StringBuilder sb = new StringBuilder();
                sb.append("fatfs = ");
                sb.append(e2);
                sb.append(", readBufferIsEmpty : ");
                sb.append(e2 != null && e2.readBufferIsEmpty());
                JL_Log.w(str, "readDataFromDevice", sb.toString());
                FatFsBluetoothImp.this.a(bluetoothDevice2, false, new byte[0]);
            }
        });
    }

    public final void a(BluetoothDevice bluetoothDevice, boolean z) {
        FatFileSystem e2 = e(bluetoothDevice);
        if (e2 == null) {
            return;
        }
        e2.updateFlagStatus(z);
    }

    public final boolean a(int i) {
        return WatchConstant.ENABLE_WRITE_DATA_CHECK && i >= 8192 && i <= 16384;
    }
}
