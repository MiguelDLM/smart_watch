package com.jieli.jl_fatfs;

import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jieli.jl_fatfs.FatFileSystem;
import com.jieli.jl_fatfs.interfaces.IBluetoothCtrl;
import com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener;
import com.jieli.jl_fatfs.interfaces.OnFatFsInitListener;
import com.jieli.jl_fatfs.interfaces.OnFatFsOpResultListener;
import com.jieli.jl_fatfs.model.FatFile;
import com.jieli.jl_fatfs.model.FatOpParam;
import com.jieli.jl_fatfs.model.FatWriteOp;
import com.jieli.jl_fatfs.model.FileExtMsg;
import com.jieli.jl_fatfs.tool.PackResFormat;
import com.jieli.jl_fatfs.utils.FatUtil;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.CryptoUtil;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import com.jieli.jl_rcsp.util.WatchFileUtil;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes10.dex */
public class FatFileSystem {
    public static final String u = "FatFileSystem";
    public static final String[] v;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f17816a;
    public volatile long b;
    public final ExecutorService c;
    public final IBluetoothCtrl d;
    public final Handler e;
    public final Map<String, ArrayList<FatFile>> f;
    public String g;
    public byte[] h;
    public int i;
    public short j;
    public int k;
    public byte[] l;
    public int m;
    public byte[] n;
    public int o;
    public final OnFatFsInitListener p;
    public FatOpParam q;
    public PackResFormat r;
    public Gson s;
    public final String[] t;

    static {
        try {
            System.loadLibrary("jl_fatfs");
        } catch (Exception e) {
            e.printStackTrace();
        }
        v = new String[]{BleDeviceInfo.PLATFORM_JL, "FONT", "SIDEBAR"};
    }

    public FatFileSystem(int i, int i2, final int i3, String[] strArr, IBluetoothCtrl iBluetoothCtrl, OnFatFsInitListener onFatFsInitListener, OnFatFileProgressListener onFatFileProgressListener) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.c = newSingleThreadExecutor;
        this.e = new Handler(Looper.getMainLooper());
        this.f = new HashMap();
        this.g = "/";
        this.h = null;
        this.i = 0;
        this.j = (short) 0;
        this.n = null;
        this.o = 0;
        this.t = strArr;
        this.d = iBluetoothCtrl;
        this.p = onFatFsInitListener;
        if (iBluetoothCtrl != null) {
            this.b = libInit(i > i2 ? i2 : i, i2);
            if (this.b != 0) {
                a(false);
                updateSysStatus(this.b, i3);
                if (i3 != 0 && onFatFileProgressListener != null) {
                    this.q = new FatOpParam().setOp(255).setFilePath("/").setTotalSize(8192L).setProgressListener(onFatFileProgressListener);
                }
                newSingleThreadExecutor.submit(new Runnable() { // from class: OoO.Oxx0IOOO
                    @Override // java.lang.Runnable
                    public final void run() {
                        FatFileSystem.this.g(i3);
                    }
                });
                return;
            }
            throw new RuntimeException("init lib failed.");
        }
        throw new RuntimeException("IBluetoothCtrl cannot be null.");
    }

    public static /* synthetic */ void a(OnFatFsOpResultListener onFatFsOpResultListener, int i) {
        if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final OnFatFsOpResultListener onFatFsOpResultListener) {
        final int mountDevice = mountDevice(this.b);
        if (mountDevice == 0) {
            JL_Log.w(u, "mount", "FatFs mount ok.");
        }
        this.e.post(new Runnable() { // from class: OoO.OOXIXo
            @Override // java.lang.Runnable
            public final void run() {
                FatFileSystem.a(OnFatFsOpResultListener.this, mountDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str, final OnFatFsOpResultListener onFatFsOpResultListener) {
        final byte[] openFile = openFile(str);
        JL_Log.w(u, "openFatFile", "file data : " + CHexConver.byte2HexStr(openFile));
        this.e.post(new Runnable() { // from class: OoO.x0xO0oo
            @Override // java.lang.Runnable
            public final void run() {
                FatFileSystem.b(OnFatFsOpResultListener.this, openFile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        OnFatFsInitListener onFatFsInitListener = this.p;
        if (onFatFsInitListener != null) {
            onFatFsInitListener.onInitOk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        FatOpParam fatOpParam = this.q;
        if (fatOpParam == null || fatOpParam.getProgressListener() == null) {
            return;
        }
        this.q.getProgressListener().onStart(this.q.getFilePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i) {
        b();
        int initDiskOp = initDiskOp();
        if (initDiskOp == 0) {
            JL_Log.w(u, "init", "FatFs init ok.");
            if (i != 0) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                updateSysStatus(0);
            }
            int mountDevice = mountDevice(this.b);
            a(mountDevice == 0);
            if (this.f17816a) {
                JL_Log.w(u, "init", "FatFs mount ok.");
                a();
                listFatDir("/", null);
                this.r = new PackResFormat();
                this.s = new GsonBuilder().create();
                return;
            }
            JL_Log.e(u, "init", "FatFs mount failed. res = " + mountDevice);
            a(mountDevice);
            return;
        }
        JL_Log.e(u, "init", "FatFs init error. ret = " + initDiskOp);
        a(initDiskOp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        FatOpParam fatOpParam = this.q;
        if (fatOpParam == null) {
            b(4097);
            return;
        }
        byte[] readFileData = WatchFileUtil.readFileData(fatOpParam.getFilePath());
        if (readFileData != null && readFileData.length != 0) {
            if (this.d.getConnectedDevice() == null) {
                b(8192);
                return;
            }
            this.q.setTotalSize(readFileData.length + 32768);
            String fatFilePath = FatUtil.getFatFilePath(this.g, this.q.getFilePath());
            if (d(readFileData.length)) {
                b();
                int replaceFatFile = replaceFatFile(fatFilePath, readFileData);
                JL_Log.w(u, "replaceFatFile", "replaceFatFile ---> " + replaceFatFile);
                b(replaceFatFile);
                return;
            }
            b();
            int deleteFile = deleteFile(fatFilePath);
            String str = u;
            JL_Log.d(str, "replaceFatFile", "deleteFile ---> " + deleteFile);
            if (deleteFile != 0) {
                b(deleteFile);
                return;
            }
            int createNewFile = createNewFile(fatFilePath, readFileData);
            JL_Log.w(str, "replaceFatFile", "createNewFile ---> " + createNewFile);
            b(createNewFile);
            return;
        }
        b(4);
    }

    public static boolean isIgnoreFile(String str) {
        String[] strArr;
        if (str == null || (strArr = v) == null || strArr.length == 0) {
            return false;
        }
        for (String str2 : strArr) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public void callbackProgress(int i) {
        if (this.q != null) {
            a(c(i));
        }
        this.i += i;
        this.k -= i;
        this.m += i;
    }

    public void createFatFile(final String str, final boolean z, final OnFatFileProgressListener onFatFileProgressListener) {
        if (this.f17816a && !this.c.isShutdown()) {
            if (this.q != null) {
                JL_Log.w(u, "createFatFile", "An operation is in progress. " + this.q);
                if (onFatFileProgressListener != null) {
                    onFatFileProgressListener.onStop(4352);
                    return;
                }
                return;
            }
            this.q = new FatOpParam().setOp(2).setFilePath(str).setProgressListener(onFatFileProgressListener);
            this.c.submit(new Runnable() { // from class: OoO.I0Io
                @Override // java.lang.Runnable
                public final void run() {
                    FatFileSystem.this.a(z, str, onFatFileProgressListener);
                }
            });
            return;
        }
        if (onFatFileProgressListener != null) {
            onFatFileProgressListener.onStop(22);
        }
    }

    public native int createNewFile(String str, byte[] bArr);

    public void createReadBuffer(int i) {
        this.n = new byte[i];
        this.o = 0;
    }

    public final long d() {
        return getFreeSize() * 4096;
    }

    public void deleteFatFile(String str, OnFatFileProgressListener onFatFileProgressListener) {
        if (this.f17816a && !this.c.isShutdown()) {
            if (this.q != null) {
                JL_Log.w(u, "deleteFatFile", "An operation is in progress. " + this.q);
                if (onFatFileProgressListener != null) {
                    onFatFileProgressListener.onStop(4352);
                    return;
                }
                return;
            }
            this.q = new FatOpParam().setOp(3).setFilePath(str).setProgressListener(onFatFileProgressListener).setTotalSize(16384L);
            this.c.submit(new Runnable() { // from class: OoO.X0o0xo
                @Override // java.lang.Runnable
                public final void run() {
                    FatFileSystem.this.g();
                }
            });
            return;
        }
        if (onFatFileProgressListener != null) {
            onFatFileProgressListener.onStop(22);
        }
    }

    public native int deleteFile(String str);

    public void destroy() {
        JL_Log.w(u, "destroy", "");
        j();
        i();
        if (!this.c.isShutdown()) {
            this.c.shutdownNow();
        }
        this.f.clear();
        PackResFormat packResFormat = this.r;
        if (packResFormat != null) {
            packResFormat.destroy();
            this.r = null;
        }
        this.d.release();
        libDestroy(this.b);
        this.b = 0L;
        this.s = null;
        a(false);
    }

    public short getCrc16() {
        return this.j;
    }

    public String getCurBrowsePath() {
        return this.g;
    }

    public FatFile getFatFileMsg(String str) {
        String str2;
        FatFile fatFile = null;
        if (str != null && !this.f.isEmpty()) {
            String str3 = u;
            JL_Log.d(str3, "getFatFileMsg", "filePath = " + str);
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf == -1) {
                return null;
            }
            if (lastIndexOf <= 0) {
                str2 = "/";
            } else {
                str2 = str.substring(0, lastIndexOf);
            }
            JL_Log.d(str3, "getFatFileMsg", "key = " + str2);
            ArrayList<FatFile> arrayList = this.f.get(str2);
            if (arrayList == null) {
                arrayList = this.f.get(str2 + "/");
            }
            if (arrayList != null) {
                Iterator<FatFile> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FatFile next = it.next();
                    JL_Log.d(u, "getFatFileMsg", "" + next);
                    if (str.equalsIgnoreCase(next.getPath())) {
                        fatFile = next;
                        break;
                    }
                }
            }
            JL_Log.d(u, "getFatFileMsg", "fatFile = " + fatFile);
        }
        return fatFile;
    }

    public void getFatFsFreeSize(final OnFatFsOpResultListener<Long> onFatFsOpResultListener) {
        if (this.f17816a && !this.c.isShutdown()) {
            this.c.submit(new Runnable() { // from class: OoO.xxIXOIIO
                @Override // java.lang.Runnable
                public final void run() {
                    FatFileSystem.this.a(onFatFsOpResultListener);
                }
            });
        } else if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(0L);
        }
    }

    public native byte[] getFileHead(String str);

    public void getFileHeadData(final String str, final OnFatFsOpResultListener<byte[]> onFatFsOpResultListener) {
        if (this.f17816a && !this.c.isShutdown()) {
            this.c.submit(new Runnable() { // from class: OoO.x0XOIxOo
                @Override // java.lang.Runnable
                public final void run() {
                    FatFileSystem.this.a(str, onFatFsOpResultListener);
                }
            });
        } else if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(null);
        }
    }

    public int getFlagStatus() {
        return getFlagStatus(this.b);
    }

    public native int getFlagStatus(long j);

    public native int getFreeSize();

    public int getLeftDevSize() {
        return this.k;
    }

    public byte[] getNeedSendLeftData() {
        byte[] bArr = this.l;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        int i = this.m;
        int i2 = length - i;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public byte[] getNeedWriteData() {
        byte[] bArr = this.l;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public byte[] getReadBuffer() {
        byte[] bArr = this.n;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public int getReadLeftSize() {
        byte[] bArr = this.n;
        if (bArr == null) {
            return 0;
        }
        return bArr.length - this.o;
    }

    public int getReadStatus() {
        return getReadStatus(this.b);
    }

    public native int getReadStatus(long j);

    public byte[] getWriteLeftData() {
        byte[] bArr = this.h;
        int length = bArr.length;
        int i = this.i;
        int i2 = length - i;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public int getWriteStatus() {
        return getWriteStatus(this.b);
    }

    public native int getWriteStatus(long j);

    public final void i() {
        this.n = null;
        this.o = 0;
    }

    public native int initDiskOp();

    public boolean isMatchVersion(String str, byte[] bArr) {
        String str2;
        String arrays;
        String jsonFileName = WatchFileUtil.getJsonFileName(str);
        if (this.r != null && jsonFileName != null && bArr != null && bArr.length != 0) {
            String str3 = u;
            JL_Log.d(str3, "isMatchVersion", "filePath = " + str + ", jsonFileName = " + jsonFileName + ", file size = " + bArr.length);
            byte[] fileData = this.r.getFileData(bArr, jsonFileName);
            StringBuilder sb = new StringBuilder();
            sb.append("data = ");
            sb.append(CHexConver.byte2HexStr(fileData));
            sb.append(", text = ");
            if (fileData == null) {
                str2 = "";
            } else {
                str2 = new String(fileData);
            }
            sb.append(str2);
            JL_Log.d(str3, "isMatchVersion", sb.toString());
            if (fileData == null) {
                return false;
            }
            try {
                FileExtMsg fileExtMsg = (FileExtMsg) c().fromJson(new String(fileData).trim(), FileExtMsg.class);
                JL_Log.d(str3, "isMatchVersion", "fileExtMsg = " + fileExtMsg);
                if (fileExtMsg == null) {
                    return false;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("matchVersions = ");
                String[] strArr = this.t;
                if (strArr == null) {
                    arrays = "null";
                } else {
                    arrays = Arrays.toString(strArr);
                }
                sb2.append(arrays);
                JL_Log.d(str3, "isMatchVersion", sb2.toString());
                String[] strArr2 = this.t;
                if (strArr2 == null || strArr2.length <= 0) {
                    return true;
                }
                for (String str4 : strArr2) {
                    JL_Log.d(u, "isMatchVersion", "version = " + str4);
                    if (str4.equalsIgnoreCase(fileExtMsg.getVersionID())) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final void j() {
        this.h = null;
        this.j = (short) 0;
        this.i = 0;
        this.k = 0;
        this.m = 0;
        this.l = null;
    }

    public boolean judgeWriteFinish(int i) {
        byte[] bArr = this.h;
        if (bArr != null && this.i + i >= bArr.length) {
            return true;
        }
        return false;
    }

    public native void libDestroy(long j);

    public native long libInit(int i, int i2);

    public native ArrayList<FatFile> listDir(String str);

    public void listFatDir(final String str, final OnFatFsOpResultListener<ArrayList<FatFile>> onFatFsOpResultListener) {
        if (this.f17816a && !this.c.isShutdown()) {
            this.c.submit(new Runnable() { // from class: OoO.Oxx0xo
                @Override // java.lang.Runnable
                public final void run() {
                    FatFileSystem.this.b(str, onFatFsOpResultListener);
                }
            });
        } else if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(null);
        }
    }

    public void mount(final OnFatFsOpResultListener<Integer> onFatFsOpResultListener) {
        if (this.c.isShutdown()) {
            if (onFatFsOpResultListener != null) {
                onFatFsOpResultListener.onResult(8);
                return;
            }
            return;
        }
        this.c.submit(new Runnable() { // from class: OoO.oxoX
            @Override // java.lang.Runnable
            public final void run() {
                FatFileSystem.this.b(onFatFsOpResultListener);
            }
        });
    }

    public native int mountDevice(long j);

    public void onReadDataNotify(int i, int i2) {
        IBluetoothCtrl iBluetoothCtrl = this.d;
        iBluetoothCtrl.readFatDataFromDevice(iBluetoothCtrl.getConnectedDevice(), i, i2);
    }

    public void onWriteDataNotify(byte[] bArr, int i) {
        IBluetoothCtrl iBluetoothCtrl = this.d;
        iBluetoothCtrl.writeFatDataToDevice(iBluetoothCtrl.getConnectedDevice(), i, bArr);
    }

    public void onWriteFailed(ArrayList<FatWriteOp> arrayList) {
    }

    public void onWriteFlagNotify(boolean z) {
        IBluetoothCtrl iBluetoothCtrl = this.d;
        iBluetoothCtrl.sendWriteFlag(iBluetoothCtrl.getConnectedDevice(), z);
    }

    public void openFatFile(final String str, final OnFatFsOpResultListener<byte[]> onFatFsOpResultListener) {
        if (this.f17816a && !this.c.isShutdown()) {
            this.c.submit(new Runnable() { // from class: OoO.II0XooXoX
                @Override // java.lang.Runnable
                public final void run() {
                    FatFileSystem.this.c(str, onFatFsOpResultListener);
                }
            });
        } else if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(null);
        }
    }

    public native byte[] openFile(String str);

    public void putDataInReadBuff(byte[] bArr) {
        byte[] bArr2;
        if (bArr != null && bArr.length != 0 && (bArr2 = this.n) != null) {
            int length = bArr.length;
            int i = this.o;
            if (length + i <= bArr2.length) {
                System.arraycopy(bArr, 0, bArr2, i, bArr.length);
                this.o += bArr.length;
                return;
            }
        }
        JL_Log.e(u, "putDataInReadBuff", "readBuffer no enough space.");
    }

    public boolean readBufferIsEmpty() {
        if (this.n == null) {
            return true;
        }
        return false;
    }

    public native int replaceFatFile(String str, byte[] bArr);

    public void replaceFatFile(String str, OnFatFileProgressListener onFatFileProgressListener) {
        if (!this.f17816a || this.c.isShutdown()) {
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStop(22);
            }
        } else {
            if (this.q != null) {
                JL_Log.w(u, "replaceFatFile", "An operation is in progress. " + this.q);
                if (onFatFileProgressListener != null) {
                    onFatFileProgressListener.onStop(4352);
                    return;
                }
                return;
            }
            this.q = new FatOpParam().setOp(4).setFilePath(str).setProgressListener(onFatFileProgressListener);
            this.c.submit(new Runnable() { // from class: OoO.oO
                @Override // java.lang.Runnable
                public final void run() {
                    FatFileSystem.this.h();
                }
            });
        }
    }

    public void setNeedWriteData(int i) {
        byte[] bArr = this.h;
        if (bArr != null) {
            int length = bArr.length;
            int i2 = this.i;
            if (length >= i2 + i) {
                this.l = new byte[i];
            } else {
                this.l = new byte[length - i2];
            }
            byte[] bArr2 = this.l;
            System.arraycopy(bArr, i2, bArr2, 0, bArr2.length);
            this.m = 0;
        }
        this.k = i;
    }

    public void setWriteBuffer(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            byte[] bArr2 = (byte[]) bArr.clone();
            this.h = bArr2;
            short CRC16 = CryptoUtil.CRC16(bArr2, (short) 0);
            this.j = CRC16;
            this.i = 0;
            this.m = 0;
            this.l = null;
            JL_Log.d(u, "setWriteBuffer", RcspUtil.formatString("crc16 : %d(0x%X)", Short.valueOf(CRC16), Short.valueOf(this.j)));
            return;
        }
        this.h = null;
        this.i = 0;
    }

    public native void updateFlagStatus(long j, int i);

    public void updateFlagStatus(boolean z) {
        updateFlagStatus(this.b, z ? 1 : 0);
    }

    public native void updateReadStatus(long j, int i, byte[] bArr);

    public void updateReadStatus(boolean z, byte[] bArr) {
        updateReadStatus(this.b, z ? 1 : 0, bArr);
    }

    public void updateSysStatus(int i) {
        updateSysStatus(this.b, i);
    }

    public native void updateSysStatus(long j, int i);

    public native void updateWriteStatus(long j, int i);

    public void updateWriteStatus(boolean z) {
        if (!z) {
            j();
        }
        updateWriteStatus(this.b, z ? 1 : 0);
    }

    public boolean writeBufferIsEmpty() {
        if (this.h == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, String str, OnFatFileProgressListener onFatFileProgressListener) {
        int i;
        FatOpParam fatOpParam = this.q;
        if (fatOpParam == null) {
            b(4097);
            return;
        }
        byte[] readFileData = WatchFileUtil.readFileData(fatOpParam.getFilePath());
        if (readFileData != null && readFileData.length != 0) {
            if (this.d.getConnectedDevice() == null) {
                b(8192);
                return;
            }
            this.q.setTotalSize(readFileData.length + 16384);
            if (!z && !isMatchVersion(this.q.getFilePath(), readFileData)) {
                b(16896);
                return;
            }
            String fatFilePath = FatUtil.getFatFilePath(this.g, this.q.getFilePath());
            FatFile fatFileMsg = getFatFileMsg(fatFilePath);
            if (d(readFileData.length)) {
                b();
                if (fatFileMsg != null) {
                    i = deleteFile(fatFilePath);
                    JL_Log.w(u, "createFatFile", "deleteFile ---> " + i + ", fatFilePath = " + fatFilePath);
                } else {
                    i = 0;
                }
                if (i == 0 || i == 4 || i == 5) {
                    i = createNewFile(fatFilePath, readFileData);
                }
                JL_Log.w(u, "createFatFile", "createNewFile ---> " + i);
                b(i);
                if (i == 0) {
                    listFatDir("/", null);
                    return;
                }
                return;
            }
            if (fatFileMsg != null) {
                long d = d() + fatFileMsg.getSize();
                JL_Log.w(u, "createFatFile", "freeSize = " + d + ", file data size = " + readFileData.length);
                if (d >= readFileData.length) {
                    this.q = null;
                    replaceFatFile(str, onFatFileProgressListener);
                    return;
                }
            }
            b(20);
            return;
        }
        b(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(int i) {
        OnFatFsInitListener onFatFsInitListener = this.p;
        if (onFatFsInitListener != null) {
            onFatFsInitListener.onInitFailed(i);
        }
    }

    public final boolean d(int i) {
        long d = d();
        JL_Log.d(u, "hasEnoughSpace", "fatFsFreeSize = " + d + ", dataLen = " + i);
        return d - ((long) i) >= 0;
    }

    public static /* synthetic */ void b(OnFatFsOpResultListener onFatFsOpResultListener, byte[] bArr) {
        if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(int i) {
        JL_Log.i(u, "callbackStop", "result : " + i + ", " + this.q);
        FatOpParam fatOpParam = this.q;
        if (fatOpParam != null) {
            OnFatFileProgressListener progressListener = fatOpParam.getProgressListener();
            j();
            this.q = null;
            if (progressListener != null) {
                progressListener.onStop(WatchError.fatfsToWatchErr(i));
            }
        }
    }

    public final float c(int i) {
        FatOpParam fatOpParam = this.q;
        if (fatOpParam == null || fatOpParam.getTotalSize() == 0) {
            return 0.0f;
        }
        int sumFileDataLen = this.q.getSumFileDataLen() + i;
        this.q.setSumFileDataLen(sumFileDataLen);
        float totalSize = (sumFileDataLen * 100.0f) / ((float) this.q.getTotalSize());
        if (totalSize > 100.0f) {
            return 100.0f;
        }
        return totalSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, final OnFatFsOpResultListener onFatFsOpResultListener) {
        ArrayList<FatFile> listDir = listDir(str);
        if (listDir != null) {
            if (!this.g.equalsIgnoreCase(str)) {
                if (this.g.equalsIgnoreCase("/")) {
                    this.g += str;
                } else {
                    this.g += "/" + str;
                }
            }
            JL_Log.i(u, "listFatDir", "put list in cache. curBrowsePath = " + this.g + ", fatFiles size = " + listDir.size());
            this.f.put(this.g, listDir);
        }
        final ArrayList<FatFile> a2 = a(listDir);
        this.e.post(new Runnable() { // from class: OoO.ooOOo0oXI
            @Override // java.lang.Runnable
            public final void run() {
                FatFileSystem.a(OnFatFsOpResultListener.this, a2);
            }
        });
    }

    public final Gson c() {
        if (this.s == null) {
            this.s = new GsonBuilder().create();
        }
        return this.s;
    }

    public final void b() {
        FatOpParam fatOpParam = this.q;
        if (fatOpParam != null) {
            fatOpParam.setSumFileDataLen(0);
        }
        this.e.post(new Runnable() { // from class: OoO.xoIox
            @Override // java.lang.Runnable
            public final void run() {
                FatFileSystem.this.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(float f) {
        FatOpParam fatOpParam = this.q;
        if (fatOpParam == null || fatOpParam.getProgressListener() == null) {
            return;
        }
        this.q.getProgressListener().onProgress(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        if (this.q == null) {
            b(4097);
            return;
        }
        if (this.d.getConnectedDevice() == null) {
            b(8192);
            return;
        }
        b();
        int deleteFile = deleteFile(this.q.getFilePath());
        JL_Log.w(u, "deleteFatFile", "deleteFile ---> " + deleteFile + ", FilePath : " + this.q.getFilePath());
        b(deleteFile);
        if (deleteFile == 0) {
            listFatDir("/", null);
        }
    }

    public final void b(final int i) {
        this.e.post(new Runnable() { // from class: OoO.II0xO0
            @Override // java.lang.Runnable
            public final void run() {
                FatFileSystem.this.f(i);
            }
        });
    }

    public static /* synthetic */ void a(OnFatFsOpResultListener onFatFsOpResultListener, ArrayList arrayList) {
        if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final OnFatFsOpResultListener onFatFsOpResultListener) {
        final long d = d();
        this.e.post(new Runnable() { // from class: OoO.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                FatFileSystem.a(OnFatFsOpResultListener.this, d);
            }
        });
    }

    public static /* synthetic */ void a(OnFatFsOpResultListener onFatFsOpResultListener, long j) {
        if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(Long.valueOf(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, final OnFatFsOpResultListener onFatFsOpResultListener) {
        final byte[] fileHead = getFileHead(str);
        if (onFatFsOpResultListener != null) {
            this.e.post(new Runnable() { // from class: OoO.oOoXoXO
                @Override // java.lang.Runnable
                public final void run() {
                    OnFatFsOpResultListener.this.onResult(fileHead);
                }
            });
        }
    }

    public final void a(final float f) {
        this.e.post(new Runnable() { // from class: OoO.XO
            @Override // java.lang.Runnable
            public final void run() {
                FatFileSystem.this.b(f);
            }
        });
    }

    public final void a() {
        this.e.post(new Runnable() { // from class: OoO.oI0IIXIo
            @Override // java.lang.Runnable
            public final void run() {
                FatFileSystem.this.e();
            }
        });
        JL_Log.d(u, "callbackInitOk", "" + this.q);
        if (this.q != null) {
            b(0);
        }
    }

    public final void a(final int i) {
        JL_Log.e(u, "callbackInitFailed", RcspUtil.formatString("code : %d(0x%X), %s", Integer.valueOf(i), Integer.valueOf(i), this.q));
        if (this.q != null) {
            b(i);
        }
        this.e.post(new Runnable() { // from class: OoO.IXxxXO
            @Override // java.lang.Runnable
            public final void run() {
                FatFileSystem.this.e(i);
            }
        });
    }

    public final void a(boolean z) {
        this.f17816a = z;
    }

    public final ArrayList<FatFile> a(ArrayList<FatFile> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return arrayList;
        }
        ArrayList<FatFile> arrayList2 = new ArrayList<>();
        Iterator<FatFile> it = arrayList.iterator();
        while (it.hasNext()) {
            FatFile next = it.next();
            if (!isIgnoreFile(next.getName())) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public final boolean a(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }
}
