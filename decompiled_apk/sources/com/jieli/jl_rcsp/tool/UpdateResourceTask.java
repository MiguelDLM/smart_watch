package com.jieli.jl_rcsp.tool;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener;
import com.jieli.jl_fatfs.model.FatFile;
import com.jieli.jl_fatfs.utils.FatUtil;
import com.jieli.jl_fatfs.utils.ZipUtil;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener;
import com.jieli.jl_rcsp.interfaces.watch.OnUpdateResourceCallback;
import com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback;
import com.jieli.jl_rcsp.model.WatchFileContent;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.util.CryptoUtil;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import com.jieli.jl_rcsp.util.WatchFileUtil;
import com.jieli.jl_rcsp.watch.rcsp.RcspWatch;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes10.dex */
public class UpdateResourceTask extends Thread {
    public static final String n = "UpdateResourceTask";

    /* renamed from: a, reason: collision with root package name */
    public final RcspWatch f18037a;
    public final String b;
    public final OnUpdateResourceCallback c;
    public final ThreadStateListener d;
    public boolean f;
    public String h;
    public String i;
    public int j;
    public WatchFileContent k;
    public BaseError m;
    public final Object e = new Object();
    public final Handler g = new Handler(Looper.getMainLooper());
    public long l = 0;

    /* loaded from: classes10.dex */
    public class MyProgressListener implements OnFatFileProgressListener {

        /* renamed from: a, reason: collision with root package name */
        public final String f18043a;
        public String funcName;
        public int index;
        public String taskPath;

        public MyProgressListener() {
            this.f18043a = MyProgressListener.class.getSimpleName();
        }

        @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
        public void onProgress(float f) {
            JL_Log.d(UpdateResourceTask.n, this.f18043a, RcspUtil.formatString("(%s) onProgress ---> %.1f.", this.funcName, Float.valueOf(f)));
            UpdateResourceTask.this.b(this.index, this.taskPath, f);
        }

        @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
        public void onStart(String str) {
            JL_Log.d(UpdateResourceTask.n, this.f18043a, RcspUtil.formatString("(%s) onStart ---> %s.", this.funcName, str));
            UpdateResourceTask.this.b(this.index, this.taskPath, 0.0f);
        }

        @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
        public void onStop(int i) {
            JL_Log.e(UpdateResourceTask.n, this.f18043a, RcspUtil.formatString("(%s) onStop ---> %d.", this.funcName, Integer.valueOf(i)));
            UpdateResourceTask.this.j = i;
            if (UpdateResourceTask.this.j == 0) {
                UpdateResourceTask.this.b(this.index, this.taskPath, 100.0f);
            }
            UpdateResourceTask.this.f();
        }
    }

    /* loaded from: classes10.dex */
    public static class Task {
        public static final int OP_CREATE_FILE = 1;
        public static final int OP_REPLACE_FILE = 2;
        public String filePath;
        public long needSize;
        public int op;

        public Task() {
        }
    }

    public UpdateResourceTask(RcspWatch rcspWatch, String str, OnUpdateResourceCallback onUpdateResourceCallback, ThreadStateListener threadStateListener) {
        if (rcspWatch != null) {
            this.f18037a = rcspWatch;
            this.b = str;
            this.c = onUpdateResourceCallback;
            this.d = threadStateListener;
            return;
        }
        throw new NullPointerException("RcspWatch can not be null.");
    }

    public static String findFolder(String str, String str2) {
        File[] listFiles;
        if (str != null && str2 != null) {
            File file = new File(str);
            if (!file.exists() || (listFiles = file.listFiles()) == null) {
                return null;
            }
            for (File file2 : listFiles) {
                if (file2.isDirectory() && str2.equalsIgnoreCase(file2.getName())) {
                    return file2.getPath();
                }
            }
        }
        return null;
    }

    public final void e() {
        final String obtainUpdateFilePath = WatchFileUtil.obtainUpdateFilePath(this.h, OTAManager.OTA_FILE_SUFFIX);
        if (obtainUpdateFilePath == null) {
            if (this.f18037a.isOTAResource()) {
                this.f18037a.writeResourceOTAFlag(true, new OnWatchOpCallback<Boolean>() { // from class: com.jieli.jl_rcsp.tool.UpdateResourceTask.4
                    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                    public void onFailed(BaseError baseError) {
                        UpdateResourceTask.this.a(baseError.getSubCode());
                    }

                    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                    public void onSuccess(Boolean bool) {
                        UpdateResourceTask.this.e();
                    }
                });
                return;
            }
            WatchFileUtil.deleteFile(this.b);
        }
        WatchFileUtil.deleteFile(this.h + File.separator + WatchConstant.RES_DIR_NAME);
        this.f18037a.reLoadFolder(new OnWatchOpCallback<ArrayList<FatFile>>() { // from class: com.jieli.jl_rcsp.tool.UpdateResourceTask.5
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onFailed(BaseError baseError) {
                UpdateResourceTask.this.a(baseError.getSubCode());
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onSuccess(ArrayList<FatFile> arrayList) {
                UpdateResourceTask.this.b(obtainUpdateFilePath);
            }
        });
    }

    public final void f() {
        synchronized (this.e) {
            try {
                if (this.f) {
                    this.e.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        File file = new File(this.i);
        ArrayList<Task> arrayList = new ArrayList<>();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                try {
                    Task a2 = a(file2);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } catch (RuntimeException e) {
                    a(a(e));
                    return;
                }
            }
        }
        String str = n;
        JL_Log.i(str, "updateResource", "taskList = " + arrayList.size());
        ArrayList<Task> b = b(arrayList);
        try {
            if (!a(b)) {
                a(16897);
                return;
            }
            if (!this.f18037a.isOTAResource()) {
                this.f18037a.writeResourceOTAFlag(false, new OnWatchOpCallback<Boolean>() { // from class: com.jieli.jl_rcsp.tool.UpdateResourceTask.1
                    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                    public void onFailed(BaseError baseError) {
                        UpdateResourceTask.this.m = baseError;
                        UpdateResourceTask.this.f();
                    }

                    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                    public void onSuccess(Boolean bool) {
                        UpdateResourceTask.this.f();
                    }
                });
                d();
                if (!this.f18037a.isOTAResource()) {
                    c(b(), c());
                    return;
                }
            }
            JL_Log.i(str, "updateResource", "size : " + b.size());
            if (b.isEmpty()) {
                e();
                return;
            }
            b(this.i, b.size());
            for (int i = 0; i < b.size(); i++) {
                Task task = b.get(i);
                if (this.j != 0) {
                    break;
                }
                JL_Log.i(n, "updateResource", "task >> op = " + task.op + ", filePath = " + task.filePath);
                if (task.op == 2) {
                    MyProgressListener myProgressListener = new MyProgressListener();
                    myProgressListener.index = i;
                    String str2 = task.filePath;
                    myProgressListener.taskPath = str2;
                    myProgressListener.funcName = "replaceWatchFile";
                    this.f18037a.replaceWatchFile(str2, myProgressListener);
                    if (this.j != 0) {
                        break;
                    }
                    d();
                } else {
                    MyProgressListener myProgressListener2 = new MyProgressListener();
                    myProgressListener2.index = i;
                    String str3 = task.filePath;
                    myProgressListener2.taskPath = str3;
                    myProgressListener2.funcName = "createWatchFile";
                    this.f18037a.createWatchFile(str3, true, myProgressListener2);
                    if (this.j != 0) {
                        break;
                    }
                    d();
                }
            }
            JL_Log.e(n, "updateResource", "end ---> " + this.j);
            int i2 = this.j;
            if (i2 == 0) {
                e();
            } else {
                a(i2);
            }
        } catch (RuntimeException e2) {
            a(a(e2));
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ThreadStateListener threadStateListener = this.d;
        if (threadStateListener != null) {
            threadStateListener.onStart(getId());
        }
        if (this.b == null) {
            a(5);
            return;
        }
        File file = new File(this.b);
        if (!file.exists()) {
            a(5);
            return;
        }
        this.h = WatchFileUtil.getDirPath(this.b);
        String fileName = WatchFileUtil.getFileName(this.b);
        String str = n;
        JL_Log.i(str, str, "dirPath = " + this.h + ", fileName = " + fileName);
        if (fileName.endsWith(OTAManager.OTA_ZIP_SUFFIX)) {
            try {
                ZipUtil.unZipFolder(this.b, this.h);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.i = findFolder(this.h, WatchConstant.RES_DIR_NAME);
        } else if (file.isDirectory() && WatchConstant.RES_DIR_NAME.equalsIgnoreCase(fileName)) {
            this.i = this.b;
        }
        String str2 = n;
        JL_Log.i(str2, str2, "targetPath = " + this.i);
        if (this.i != null) {
            g();
            return;
        }
        String obtainUpdateFilePath = WatchFileUtil.obtainUpdateFilePath(this.h, OTAManager.OTA_FILE_SUFFIX);
        JL_Log.i(str2, str2, "otaFilePath = " + obtainUpdateFilePath);
        if (obtainUpdateFilePath == null) {
            a(4);
        } else {
            b(obtainUpdateFilePath);
        }
    }

    public void stopThread() {
        this.j = 4098;
        f();
    }

    public final String c() {
        BaseError baseError = this.m;
        return baseError == null ? "" : baseError.getMessage();
    }

    public final void d() {
        synchronized (this.e) {
            try {
                if (!this.f) {
                    this.f = true;
                    this.e.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.f = false;
        }
    }

    public final ArrayList<Task> b(ArrayList<Task> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            return arrayList;
        }
        ArrayList<Task> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        Iterator<Task> it = arrayList.iterator();
        while (it.hasNext()) {
            Task next = it.next();
            if (next.op == 2) {
                arrayList2.add(next);
            } else {
                arrayList3.add(next);
            }
        }
        if (!arrayList3.isEmpty()) {
            arrayList2.addAll(arrayList3);
        }
        return arrayList2;
    }

    public final void c(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            str = FatUtil.getFatFsErrorCodeMsg(i);
        }
        b(i, str);
    }

    public final Task a(File file) throws RuntimeException {
        byte[] readFileData = WatchFileUtil.readFileData(file.getPath());
        if (readFileData != null && readFileData.length >= 512) {
            FatFile watchFileByPath = this.f18037a.getWatchFileByPath(file.getPath());
            if (watchFileByPath == null) {
                Task task = new Task();
                task.filePath = file.getPath();
                task.needSize = file.length();
                task.op = 1;
                return task;
            }
            this.k = null;
            String str = n;
            JL_Log.d(str, "convertTask", "file path : " + watchFileByPath.getPath());
            this.f18037a.getWatchFileSize(watchFileByPath.getPath(), new OnWatchOpCallback<WatchFileContent>() { // from class: com.jieli.jl_rcsp.tool.UpdateResourceTask.2
                @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                public void onFailed(BaseError baseError) {
                    JL_Log.e(UpdateResourceTask.n, "convertTask", "onFailed ---> " + baseError);
                    UpdateResourceTask.this.m = baseError;
                    UpdateResourceTask.this.f();
                }

                @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                public void onSuccess(WatchFileContent watchFileContent) {
                    UpdateResourceTask.this.k = watchFileContent;
                    JL_Log.d(UpdateResourceTask.n, "convertTask", "onSuccess ---> " + watchFileContent);
                    UpdateResourceTask.this.f();
                }
            });
            d();
            WatchFileContent watchFileContent = this.k;
            if (watchFileContent != null) {
                short crc = watchFileContent.getCrc();
                long fileSize = this.k.getFileSize();
                short CRC16 = CryptoUtil.CRC16(readFileData, (short) 0);
                JL_Log.i(str, "convertTask", RcspUtil.formatString("SDK calc file crc : %d(0x%X), Device returned file crc : %d(0x%X).", Short.valueOf(CRC16), Short.valueOf(CRC16), Short.valueOf(crc), Short.valueOf(crc)));
                if (CRC16 == crc) {
                    return null;
                }
                Task task2 = new Task();
                task2.filePath = file.getPath();
                task2.needSize = file.length() - fileSize;
                task2.op = 2;
                return task2;
            }
            throw new RuntimeException(String.valueOf(b()));
        }
        JL_Log.e(n, "convertTask", "Invalid File.");
        return null;
    }

    public final int b() {
        BaseError baseError = this.m;
        if (baseError == null) {
            return 12288;
        }
        return baseError.getSubCode();
    }

    public final void b(final String str, final int i) {
        if (this.c != null) {
            this.g.post(new Runnable() { // from class: com.jieli.jl_rcsp.tool.II0XooXoX
                @Override // java.lang.Runnable
                public final void run() {
                    UpdateResourceTask.this.a(str, i);
                }
            });
        }
    }

    public final void b(final String str) {
        if (this.c != null) {
            this.g.post(new Runnable() { // from class: com.jieli.jl_rcsp.tool.Oxx0IOOO
                @Override // java.lang.Runnable
                public final void run() {
                    UpdateResourceTask.this.a(str);
                }
            });
        }
        ThreadStateListener threadStateListener = this.d;
        if (threadStateListener != null) {
            threadStateListener.onFinish(getId());
        }
    }

    public final void b(final int i, final String str) {
        JL_Log.w(n, "notifyError", RcspUtil.formatString("code : %d(0x%X), %s.", Integer.valueOf(i), Integer.valueOf(i), str));
        WatchFileUtil.deleteFile(WatchFileUtil.obtainUpdateFilePath(this.h, OTAManager.OTA_FILE_SUFFIX));
        WatchFileUtil.deleteFile(this.h + File.separator + WatchConstant.RES_DIR_NAME);
        if (this.c != null) {
            this.g.post(new Runnable() { // from class: com.jieli.jl_rcsp.tool.XO
                @Override // java.lang.Runnable
                public final void run() {
                    UpdateResourceTask.this.a(i, str);
                }
            });
        }
        ThreadStateListener threadStateListener = this.d;
        if (threadStateListener != null) {
            threadStateListener.onFinish(getId());
        }
    }

    public final void b(final int i, final String str, final float f) {
        if (this.c != null) {
            this.g.post(new Runnable() { // from class: com.jieli.jl_rcsp.tool.xxIXOIIO
                @Override // java.lang.Runnable
                public final void run() {
                    UpdateResourceTask.this.a(i, str, f);
                }
            });
        }
    }

    public final boolean a(ArrayList<Task> arrayList) throws RuntimeException {
        if (arrayList == null || arrayList.isEmpty()) {
            return true;
        }
        this.l = -1L;
        JL_Log.d(n, "hasEnoughSpace", "task size : " + arrayList.size());
        this.f18037a.getWatchSysLeftSize(new OnWatchOpCallback<Long>() { // from class: com.jieli.jl_rcsp.tool.UpdateResourceTask.3
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onFailed(BaseError baseError) {
                JL_Log.e(UpdateResourceTask.n, "hasEnoughSpace", "onFailed ---> " + baseError);
                UpdateResourceTask.this.m = baseError;
                UpdateResourceTask.this.f();
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onSuccess(Long l) {
                UpdateResourceTask.this.l = l.longValue();
                JL_Log.d(UpdateResourceTask.n, "hasEnoughSpace", "onSuccess ---> " + UpdateResourceTask.this.l);
                UpdateResourceTask.this.f();
            }
        });
        d();
        long j = this.l;
        if (j != -1) {
            Iterator<Task> it = arrayList.iterator();
            while (it.hasNext()) {
                j -= it.next().needSize;
            }
            boolean z = j >= 0;
            JL_Log.e(n, "hasEnoughSpace", "enough space : " + z + ", leftSize = " + j);
            return z;
        }
        throw new RuntimeException(String.valueOf(b()));
    }

    public final int a(RuntimeException runtimeException) {
        if (runtimeException == null) {
            return 12288;
        }
        try {
            if (TextUtils.isEmpty(runtimeException.getMessage()) || !TextUtils.isDigitsOnly(runtimeException.getMessage())) {
                return 12288;
            }
            return Integer.parseInt(runtimeException.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return 12288;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, int i) {
        this.c.onStart(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        this.c.onStop(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, String str) {
        this.c.onError(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, String str, float f) {
        this.c.onProgress(i, str, f);
    }

    public final void a(int i) {
        c(i, FatUtil.getFatFsErrorCodeMsg(i));
    }
}
