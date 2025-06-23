package com.jieli.jl_rcsp.watch.rcsp;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.gson.GsonBuilder;
import com.jieli.jl_fatfs.FatFileSystem;
import com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener;
import com.jieli.jl_fatfs.model.FatFile;
import com.jieli.jl_fatfs.model.FileExtMsg;
import com.jieli.jl_fatfs.tool.PackResFormat;
import com.jieli.jl_fatfs.utils.FatUtil;
import com.jieli.jl_filebrowse.FileBrowseManager;
import com.jieli.jl_filebrowse.bean.FileStruct;
import com.jieli.jl_filebrowse.bean.Folder;
import com.jieli.jl_filebrowse.bean.SDCardBean;
import com.jieli.jl_filebrowse.interfaces.DeleteCallback;
import com.jieli.jl_filebrowse.interfaces.FileObserver;
import com.jieli.jl_rcsp.constant.RcspErrorCode;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.impl.NetworkOpImpl;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.impl.SettingFunctionImpl;
import com.jieli.jl_rcsp.impl.WatchOpImpl;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener;
import com.jieli.jl_rcsp.interfaces.watch.IWatchManager;
import com.jieli.jl_rcsp.interfaces.watch.OnUpdateResourceCallback;
import com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback;
import com.jieli.jl_rcsp.model.WatchConfigure;
import com.jieli.jl_rcsp.model.WatchFileContent;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CmdError;
import com.jieli.jl_rcsp.model.command.external_flash.ExternalFlashIOCtrlCmd;
import com.jieli.jl_rcsp.model.command.setting.PublicSettingsCmd;
import com.jieli.jl_rcsp.model.device.DeviceInfo;
import com.jieli.jl_rcsp.model.device.settings.v0.DialExpandInfo;
import com.jieli.jl_rcsp.model.device.settings.v0.NetworkInfo;
import com.jieli.jl_rcsp.model.response.ExternalFlashIOCtrlResponse;
import com.jieli.jl_rcsp.model.response.ExternalFlashMsgResponse;
import com.jieli.jl_rcsp.task.GetFileByClusterTask;
import com.jieli.jl_rcsp.task.GetFileTask;
import com.jieli.jl_rcsp.task.ITask;
import com.jieli.jl_rcsp.task.TaskListener;
import com.jieli.jl_rcsp.task.TransferTask;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.tool.UpdateResourceTask;
import com.jieli.jl_rcsp.tool.WatchCallbackManager;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.CommandBuilder;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.WatchFileUtil;
import com.jieli.jl_rcsp.watch.WatchBase;
import com.jieli.jl_rcsp.watch.WatchProgressHandler;
import com.jieli.jl_rcsp.watch.rcsp.RcspWatch;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes10.dex */
public class RcspWatch extends WatchBase implements IWatchManager, TaskListener {
    public static final int o = 4114;
    public OnFatFileProgressListener e;
    public OnWatchOpCallback<byte[]> f;
    public PackResFormat g;
    public ITask h;
    public UpdateResourceTask i;
    public volatile boolean j;
    public volatile boolean k;
    public ExecutorService l;
    public final Handler m;
    public final FileObserver n;

    /* renamed from: com.jieli.jl_rcsp.watch.rcsp.RcspWatch$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass1 implements OnWatchOpCallback<ArrayList<FatFile>> {

        /* renamed from: a, reason: collision with root package name */
        public int f18277a;

        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            RcspWatch.this.listWatchList(this);
        }

        @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
        public void onFailed(BaseError baseError) {
            int i;
            if (baseError.getSubCode() != 16385 || (i = this.f18277a) >= 2) {
                JL_Log.e(((WatchBase) RcspWatch.this).TAG, "MSG_INIT_WATCH#listWatchList", "onFailed ---> " + baseError);
                this.f18277a = 0;
                RcspWatch.this.b(baseError.getSubCode());
                return;
            }
            this.f18277a = i + 1;
            RcspWatch.this.m.postDelayed(new Runnable() { // from class: com.jieli.jl_rcsp.watch.rcsp.XO
                @Override // java.lang.Runnable
                public final void run() {
                    RcspWatch.AnonymousClass1.this.a();
                }
            }, 500L);
        }

        @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
        public void onSuccess(ArrayList<FatFile> arrayList) {
            JL_Log.i(((WatchBase) RcspWatch.this).TAG, "MSG_INIT_WATCH#listWatchList", "onSuccess :: " + arrayList);
            this.f18277a = 0;
            BluetoothDevice connectedDevice = RcspWatch.this.getConnectedDevice();
            WatchConfigure watchConfigure = RcspWatch.this.getWatchConfigure(connectedDevice);
            JL_Log.d(((WatchBase) RcspWatch.this).TAG, "MSG_INIT_WATCH", "" + watchConfigure);
            if (watchConfigure != null && watchConfigure.getFunctionOption().isSupportDialExpandInfo()) {
                RcspWatch.this.a(connectedDevice);
            }
            RcspWatch.this.b(0);
            if (watchConfigure != null && watchConfigure.getFunctionOption().isSupportNetworkModule()) {
                RcspWatch rcspWatch = RcspWatch.this;
                if (rcspWatch.a(((WatchBase) rcspWatch).mRcspOp.getDeviceInfo().getNetworkInfo())) {
                    JL_Log.w(((WatchBase) RcspWatch.this).TAG, "MSG_INIT_WATCH", "Network Module has exception. ");
                    return;
                }
            }
            JL_Log.w(((WatchBase) RcspWatch.this).TAG, "MSG_INIT_WATCH", "isOTAResource = " + ((WatchBase) RcspWatch.this).isOTAResource);
            if (((WatchBase) RcspWatch.this).isOTAResource) {
                ((WatchBase) RcspWatch.this).mWatchCallbackManager.onResourceUpdateUnfinished(connectedDevice);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class ListDirObserver implements FileObserver {

        /* renamed from: a, reason: collision with root package name */
        public final OnWatchOpCallback<ArrayList<FatFile>> f18290a;

        public /* synthetic */ ListDirObserver(RcspWatch rcspWatch, OnWatchOpCallback onWatchOpCallback, AnonymousClass1 anonymousClass1) {
            this(onWatchOpCallback);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void OnFlayCallback(boolean z) {
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReadFailed(int i) {
            OnWatchOpCallback<ArrayList<FatFile>> onWatchOpCallback = this.f18290a;
            if (onWatchOpCallback != null) {
                onWatchOpCallback.onFailed(RcspErrorCode.buildJsonError(13, 12293, i, null));
            }
            FileBrowseManager.getInstance().removeFileObserver(this);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReadStart() {
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReadStop(boolean z) {
            if (!z) {
                FileBrowseManager.getInstance().loadMore(RcspWatch.this.e());
            } else {
                RcspWatch.this.listWatchList(this.f18290a);
            }
            if (z) {
                FileBrowseManager.getInstance().removeFileObserver(this);
            }
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReceiver(List<FileStruct> list) {
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onSdCardStatusChange(List<SDCardBean> list) {
        }

        public ListDirObserver(OnWatchOpCallback<ArrayList<FatFile>> onWatchOpCallback) {
            this.f18290a = onWatchOpCallback;
        }
    }

    public RcspWatch(RcspOpImpl rcspOpImpl, WatchCallbackManager watchCallbackManager) {
        super(rcspOpImpl, watchCallbackManager);
        this.l = Executors.newSingleThreadExecutor();
        this.m = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.jl_rcsp.watch.rcsp.oxoX
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean a2;
                a2 = RcspWatch.this.a(message);
                return a2;
            }
        });
        this.n = new FileObserver() { // from class: com.jieli.jl_rcsp.watch.rcsp.RcspWatch.9
            @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
            public void OnFlayCallback(boolean z) {
            }

            @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
            public void onFileReadFailed(int i) {
            }

            @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
            public void onFileReadStart() {
            }

            @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
            public void onFileReadStop(boolean z) {
            }

            @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
            public void onFileReceiver(List<FileStruct> list) {
            }

            @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
            public void onSdCardStatusChange(List<SDCardBean> list) {
                RcspWatch.this.i();
            }
        };
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public boolean cancelTransfer() {
        return d();
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void createWatchFile(String str, boolean z, OnFatFileProgressListener onFatFileProgressListener) {
        if (e() == null) {
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStop(16384);
                return;
            }
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            String fatFilePath = FatUtil.getFatFilePath(str);
            JL_Log.d(this.TAG, "createWatchFile", "fatFilePath : " + fatFilePath + ", OnFatFileProgressListener = " + onFatFileProgressListener);
            a(str, z, new WatchProgressHandler(this, 1, onFatFileProgressListener));
            return;
        }
        if (onFatFileProgressListener != null) {
            onFatFileProgressListener.onStop(5);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void deleteWatchFile(String str, final OnFatFileProgressListener onFatFileProgressListener) {
        final SDCardBean e = e();
        if (e == null) {
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStop(16384);
                return;
            }
            return;
        }
        final FileStruct a2 = a(str);
        if (a2 == null) {
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStop(4);
                return;
            }
            return;
        }
        if (onFatFileProgressListener != null) {
            onFatFileProgressListener.onStart(a2.getName());
            onFatFileProgressListener.onProgress(0.0f);
        }
        deleteFileStart("/" + a2.getName(), new OnWatchOpCallback<Boolean>() { // from class: com.jieli.jl_rcsp.watch.rcsp.RcspWatch.6
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onFailed(BaseError baseError) {
                OnFatFileProgressListener onFatFileProgressListener2 = onFatFileProgressListener;
                if (onFatFileProgressListener2 != null) {
                    onFatFileProgressListener2.onStop(baseError.getSubCode());
                }
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onSuccess(Boolean bool) {
                RcspWatch.this.a(e, a2, onFatFileProgressListener);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.watch.WatchBase, com.jieli.jl_rcsp.interfaces.watch.IWatchManager
    public void destroy() {
        super.destroy();
        this.j = false;
        d();
        this.m.removeCallbacksAndMessages(null);
        if (!this.l.isShutdown()) {
            this.l.shutdownNow();
        }
        UpdateResourceTask updateResourceTask = this.i;
        if (updateResourceTask != null) {
            updateResourceTask.stopThread();
        }
        FileBrowseManager.getInstance().removeFileObserver(this.n);
        PackResFormat packResFormat = this.g;
        if (packResFormat != null) {
            packResFormat.destroy();
            this.g = null;
        }
        this.h = null;
    }

    public final void f() {
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public String getCurrentBrowsePath() {
        Folder currentReadFile;
        SDCardBean e = e();
        if (e == null || (currentReadFile = FileBrowseManager.getInstance().getCurrentReadFile(e)) == null) {
            return null;
        }
        return currentReadFile.getPathString();
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchManager
    public FatFile getWatchFileByPath(String str) {
        FileStruct a2 = a(str);
        if (a2 == null) {
            return null;
        }
        return FatFile.create(a2);
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void getWatchFileSize(String str, OnWatchOpCallback<WatchFileContent> onWatchOpCallback) {
        if (str == null) {
            if (onWatchOpCallback != null) {
                onWatchOpCallback.onFailed(new BaseError(19, FatUtil.getFatFsErrorCodeMsg(19)));
            }
        } else {
            RcspOpImpl rcspOpImpl = this.mRcspOp;
            rcspOpImpl.sendRcspCommand(rcspOpImpl.getTargetDevice(), CommandBuilder.buildExternalFlashGetFileMsgCmd(str), 5000, new WatchBase.HandleRcspCallback("getWatchFileSize", onWatchOpCallback, new IHandleResult<WatchFileContent, ExternalFlashIOCtrlCmd>() { // from class: com.jieli.jl_rcsp.watch.rcsp.RcspWatch.8
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public WatchFileContent handleResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
                    if (externalFlashIOCtrlCmd.getResponse() == 0) {
                        return null;
                    }
                    return new WatchFileContent(((ExternalFlashIOCtrlResponse) externalFlashIOCtrlCmd.getResponse()).getSize(), ((ExternalFlashIOCtrlResponse) externalFlashIOCtrlCmd.getResponse()).getCrc16());
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public int hasResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
                    if (externalFlashIOCtrlCmd == null) {
                        return 1;
                    }
                    if (externalFlashIOCtrlCmd.getStatus() != 0) {
                        return externalFlashIOCtrlCmd.getStatus();
                    }
                    if (externalFlashIOCtrlCmd.getResponse() == 0) {
                        return 1;
                    }
                    return ((ExternalFlashIOCtrlResponse) externalFlashIOCtrlCmd.getResponse()).getResult();
                }
            }));
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void getWatchSysLeftSize(OnWatchOpCallback<Long> onWatchOpCallback) {
        RcspOpImpl rcspOpImpl = this.mRcspOp;
        rcspOpImpl.sendRcspCommand(rcspOpImpl.getTargetDevice(), CommandBuilder.buildExternalFlashGetLeftSpaceCmd(), new WatchBase.HandleRcspCallback("getWatchSysLeftSize", onWatchOpCallback, new IHandleResult<Long, ExternalFlashIOCtrlCmd>() { // from class: com.jieli.jl_rcsp.watch.rcsp.RcspWatch.7
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public Long handleResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
                if (externalFlashIOCtrlCmd.getResponse() == 0) {
                    return 0L;
                }
                return Long.valueOf(((ExternalFlashIOCtrlResponse) externalFlashIOCtrlCmd.getResponse()).getSize() * 1024);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
                if (externalFlashIOCtrlCmd == null) {
                    return 1;
                }
                if (externalFlashIOCtrlCmd.getStatus() != 0) {
                    return externalFlashIOCtrlCmd.getStatus();
                }
                if (externalFlashIOCtrlCmd.getResponse() == 0) {
                    return 1;
                }
                return ((ExternalFlashIOCtrlResponse) externalFlashIOCtrlCmd.getResponse()).getResult();
            }
        }));
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchManager
    public void init() {
        boolean z;
        boolean z2 = false;
        this.j = false;
        this.k = false;
        FileBrowseManager.getInstance().addFileObserver(this.n);
        this.g = new PackResFormat();
        if (this.l.isShutdown()) {
            this.l = Executors.newSingleThreadExecutor();
        }
        BluetoothDevice connectedDevice = getConnectedDevice();
        DeviceInfo deviceInfo = this.mRcspOp.getDeviceInfo(connectedDevice);
        JL_Log.w(this.TAG, "init", "" + deviceInfo);
        if (deviceInfo == null) {
            b(8192);
            return;
        }
        ExternalFlashMsgResponse externalFlashMsg = getExternalFlashMsg(connectedDevice);
        if (externalFlashMsg != null) {
            if (externalFlashMsg.getSysStatus() != 0) {
                z = true;
            } else {
                z = false;
            }
            setSysException(z);
            JL_Log.w(this.TAG, "init", "isSysException = " + this.isSysException);
            if (this.isSysException) {
                b(externalFlashMsg.getSysStatus());
                return;
            }
        }
        if (deviceInfo.getExpandMode() == 1) {
            z2 = true;
        }
        setOTAResource(z2);
        if (deviceInfo.isSupportDevConfigure()) {
            this.k = true;
            requestDeviceConfigure(new OnWatchOpCallback<WatchConfigure>() { // from class: com.jieli.jl_rcsp.watch.rcsp.RcspWatch.2
                @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                public void onFailed(BaseError baseError) {
                    JL_Log.w(((WatchBase) RcspWatch.this).TAG, "init#requestDeviceConfigure", "onFailed ---> " + baseError);
                    RcspWatch.this.k = false;
                    RcspWatch.this.i();
                }

                @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                public void onSuccess(WatchConfigure watchConfigure) {
                    RcspWatch.this.k = false;
                    JL_Log.d(((WatchBase) RcspWatch.this).TAG, "init#requestDeviceConfigure", "" + watchConfigure);
                    if (watchConfigure == null || !watchConfigure.getFunctionOption().isSupportNetworkModule()) {
                        RcspWatch.this.i();
                    } else {
                        NetworkOpImpl.instance(((WatchBase) RcspWatch.this).mRcspOp).queryNetworkInfo(RcspWatch.this.getConnectedDevice(), new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.watch.rcsp.RcspWatch.2.1
                            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                            public void onFailed(BaseError baseError) {
                                JL_Log.w(((WatchBase) RcspWatch.this).TAG, "init#queryNetworkInfo", "onFailed ---> " + baseError);
                                RcspWatch.this.i();
                            }

                            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                            public void onSuccess(Boolean bool) {
                                NetworkInfo networkInfo = ((WatchBase) RcspWatch.this).mStatusManager.getDeviceInfo(RcspWatch.this.getConnectedDevice()).getNetworkInfo();
                                JL_Log.d(((WatchBase) RcspWatch.this).TAG, "init#queryNetworkInfo", networkInfo + ", isInit = " + RcspWatch.this.j);
                                if (!RcspWatch.this.j) {
                                    RcspWatch.this.i();
                                } else {
                                    RcspWatch.this.a(networkInfo);
                                }
                            }
                        });
                    }
                }
            });
        } else {
            i();
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchManager
    public boolean isInit() {
        ExternalFlashMsgResponse externalFlashMsg;
        if (getConnectedDevice() == null || (externalFlashMsg = getExternalFlashMsg(getConnectedDevice())) == null || externalFlashMsg.getSysStatus() != 0 || !this.j) {
            return false;
        }
        return true;
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void listWatchList(OnWatchOpCallback<ArrayList<FatFile>> onWatchOpCallback) {
        SDCardBean e = e();
        JL_Log.d(this.TAG, "listWatchList", "flash = " + e);
        if (e == null) {
            onCallbackError(onWatchOpCallback, 16384);
            return;
        }
        Folder currentReadFile = FileBrowseManager.getInstance().getCurrentReadFile(e);
        JL_Log.d(this.TAG, "listWatchList", "folder = " + currentReadFile);
        if (currentReadFile == null) {
            onCallbackError(onWatchOpCallback, 16387);
            return;
        }
        boolean isReading = FileBrowseManager.getInstance().isReading();
        JL_Log.d(this.TAG, "listWatchList", "isReading = " + isReading);
        if (isReading) {
            onCallbackError(onWatchOpCallback, 16385);
            return;
        }
        List<FileStruct> childFileStructs = currentReadFile.getChildFileStructs();
        if (!currentReadFile.isLoadFinished(false)) {
            FileBrowseManager.getInstance().addFileObserver(new ListDirObserver(this, onWatchOpCallback, null));
            FileBrowseManager.getInstance().loadMore(e);
            JL_Log.d(this.TAG, "listWatchList", "loadMore >>>> ");
            return;
        }
        ArrayList<FatFile> arrayList = new ArrayList<>();
        for (FileStruct fileStruct : childFileStructs) {
            if (!FatFileSystem.isIgnoreFile(fileStruct.getName())) {
                arrayList.add(FatFile.create(fileStruct));
            }
        }
        JL_Log.d(this.TAG, "listWatchList", "callback ----> " + arrayList.size());
        if (onWatchOpCallback != null) {
            onWatchOpCallback.onSuccess(arrayList);
        }
    }

    @Override // com.jieli.jl_rcsp.task.TaskListener
    public void onBegin() {
        c();
    }

    @Override // com.jieli.jl_rcsp.task.TaskListener
    public void onCancel(int i) {
        JL_Log.w(this.TAG, "Transfer", "onCancel ==== >>> reason = " + i);
        a(4098);
    }

    @Override // com.jieli.jl_rcsp.task.TaskListener
    public void onError(int i, String str) {
        CmdError parseCmdError;
        JL_Log.e(this.TAG, "Transfer", "onError ==== >>> code = " + i + ", message = " + str);
        if (i == 12293 && (parseCmdError = CmdError.parseCmdError(str)) != null && (parseCmdError.getCmdId() == 27 || parseCmdError.getCmdId() == 28)) {
            int subCode = parseCmdError.getSubCode();
            if (subCode != 3) {
                if (subCode == 4) {
                    i = 20;
                }
            } else {
                i = 12544;
            }
        }
        a(i);
    }

    @Override // com.jieli.jl_rcsp.task.TaskListener
    public void onFinish() {
        JL_Log.i(this.TAG, "Transfer", "onFinish ==== >>> ");
        a(0);
    }

    @Override // com.jieli.jl_rcsp.task.TaskListener
    public void onProgress(int i) {
        a(i);
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void openWatchFile(String str, OnWatchOpCallback<byte[]> onWatchOpCallback) {
        if (e() == null) {
            onCallbackError(onWatchOpCallback, 16384);
            return;
        }
        FileStruct a2 = a(str);
        if (a2 == null) {
            if (onWatchOpCallback != null) {
                onWatchOpCallback.onFailed(new BaseError(4, FatUtil.getFatFsErrorCodeMsg(4)));
            }
        } else {
            this.f = onWatchOpCallback;
            d(a2.getCluster());
        }
    }

    public void reLoadFolder(OnWatchOpCallback<ArrayList<FatFile>> onWatchOpCallback) {
        SDCardBean e = e();
        if (e != null) {
            FileBrowseManager.getInstance().cleanCache(e);
        }
        listWatchList(onWatchOpCallback);
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void replaceWatchFile(String str, OnFatFileProgressListener onFatFileProgressListener) {
        if (e() == null) {
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStop(16384);
            }
        } else {
            if (!WatchFileUtil.isFileExist(str)) {
                if (onFatFileProgressListener != null) {
                    onFatFileProgressListener.onStop(5);
                    return;
                }
                return;
            }
            createWatchFile(str, true, onFatFileProgressListener);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void restoreWatchSystem(OnFatFileProgressListener onFatFileProgressListener) {
        if (e() == null) {
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStop(16384);
            }
        } else {
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStart("/");
                onFatFileProgressListener.onProgress(0.0f);
            }
            final WatchProgressHandler watchProgressHandler = new WatchProgressHandler(this, 4, onFatFileProgressListener);
            this.mRcspOp.sendRcspCommand(getConnectedDevice(), CommandBuilder.buildExternalFlashRestoreSystemCmd(), 5000, new CustomRcspActionCallback("restoreWatchSystem", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.watch.rcsp.RcspWatch.3
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    watchProgressHandler.onStop(baseError.getSubCode());
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(Boolean bool) {
                    watchProgressHandler.onProgress(100.0f);
                    watchProgressHandler.onStop(0);
                }
            }, new IHandleResult<Boolean, ExternalFlashIOCtrlCmd>() { // from class: com.jieli.jl_rcsp.watch.rcsp.RcspWatch.4
                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public Boolean handleResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
                    return Boolean.TRUE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public int hasResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
                    ExternalFlashIOCtrlResponse externalFlashIOCtrlResponse;
                    if (externalFlashIOCtrlCmd == null || (externalFlashIOCtrlResponse = (ExternalFlashIOCtrlResponse) externalFlashIOCtrlCmd.getResponse()) == null) {
                        return -1;
                    }
                    return externalFlashIOCtrlResponse.getResult();
                }
            }));
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void updateWatchResource(final String str, final OnUpdateResourceCallback onUpdateResourceCallback) {
        if (e() == null) {
            if (onUpdateResourceCallback != null) {
                onUpdateResourceCallback.onError(16384, WatchError.getErrorDesc(16384));
                return;
            }
            return;
        }
        listWatchList(new OnWatchOpCallback<ArrayList<FatFile>>() { // from class: com.jieli.jl_rcsp.watch.rcsp.RcspWatch.5
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onFailed(BaseError baseError) {
                OnUpdateResourceCallback onUpdateResourceCallback2 = onUpdateResourceCallback;
                if (onUpdateResourceCallback2 != null) {
                    onUpdateResourceCallback2.onError(baseError.getSubCode(), WatchError.getErrorDesc(baseError.getSubCode()));
                }
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onSuccess(ArrayList<FatFile> arrayList) {
                if (RcspWatch.this.i == null) {
                    RcspWatch.this.i = new UpdateResourceTask(RcspWatch.this, str, onUpdateResourceCallback, new ThreadStateListener() { // from class: com.jieli.jl_rcsp.watch.rcsp.RcspWatch.5.1
                        @Override // com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener
                        public void onFinish(long j) {
                            if (RcspWatch.this.i != null && RcspWatch.this.i.getId() == j) {
                                RcspWatch.this.i = null;
                            }
                        }

                        @Override // com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener
                        public void onStart(long j) {
                        }
                    });
                    RcspWatch.this.i.start();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        if (this.e != null) {
            ITask iTask = this.h;
            this.e.onStart((iTask == null || !(iTask instanceof TransferTask)) ? null : ((TransferTask) iTask).getPath());
        }
    }

    public final void b(String str) {
        if (e() == null) {
            a(16384);
            return;
        }
        ITask iTask = this.h;
        if (iTask != null && iTask.isRun()) {
            if (this.h.isRun()) {
                a(4352);
                return;
            }
        } else {
            TransferTask.Param param = new TransferTask.Param();
            param.devHandler = e().getDevHandler();
            param.useFlash = true;
            this.h = new TransferTask(this.mRcspOp, str, param);
        }
        this.h.setListener(this);
        ((TransferTask) this.h).setPath(str);
        this.h.start();
    }

    public final void c() {
        this.m.post(new Runnable() { // from class: com.jieli.jl_rcsp.watch.rcsp.II0xO0
            @Override // java.lang.Runnable
            public final void run() {
                RcspWatch.this.h();
            }
        });
    }

    public final void d(int i) {
        if (e() == null) {
            a(16384);
            return;
        }
        ITask iTask = this.h;
        if (iTask != null && iTask.isRun()) {
            if (this.h.isRun()) {
                a(4352);
                return;
            }
        } else {
            this.h = new GetFileByClusterTask(this.mRcspOp, new GetFileByClusterTask.Param(e().getDevHandler(), 0, i, GetFileTask.BYTE_ARRAY_STREAM));
        }
        this.h.setListener(this);
        this.h.start();
    }

    public final SDCardBean e() {
        return a(FileBrowseManager.getInstance().getOnlineDev());
    }

    public final boolean g() {
        ITask iTask = this.h;
        return iTask != null && iTask.isRun();
    }

    public final void i() {
        if (this.j || this.k) {
            return;
        }
        SDCardBean e = e();
        this.m.removeMessages(4114);
        if (e != null && e.isOnline()) {
            this.m.sendEmptyMessage(4114);
        } else {
            this.m.sendEmptyMessageDelayed(4114, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(int i) {
        OnWatchOpCallback<byte[]> onWatchOpCallback;
        JL_Log.i(this.TAG, "callbackStop", "result = " + i);
        OnFatFileProgressListener onFatFileProgressListener = this.e;
        if (onFatFileProgressListener != null) {
            onFatFileProgressListener.onStop(i);
            this.e = null;
        }
        ITask iTask = this.h;
        if (!(iTask instanceof GetFileByClusterTask) || (onWatchOpCallback = this.f) == null) {
            return;
        }
        if (i == 0) {
            this.f.onSuccess(((GetFileByClusterTask) iTask).getCacheData());
        } else {
            onWatchOpCallback.onFailed(new BaseError(i, WatchError.getErrorDesc(i)));
        }
        this.f = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(Message message) {
        if (message.what != 4114) {
            return true;
        }
        if (this.j) {
            return false;
        }
        SDCardBean e = e();
        JL_Log.w(this.TAG, "MSG_INIT_WATCH", "flash = " + e);
        if (e != null && e.isOnline()) {
            listWatchList(new AnonymousClass1());
            return true;
        }
        b(16384);
        return true;
    }

    public final boolean d() {
        ITask iTask = this.h;
        if (iTask == null || !iTask.isRun()) {
            return false;
        }
        this.h.cancel((byte) 0);
        return true;
    }

    public final void b(int i) {
        this.j = i == 0;
        JL_Log.i(this.TAG, "callbackWatchSystemInit", "code : " + i + ", isInit = " + this.j);
        this.mWatchCallbackManager.onWatchSystemInit(i);
    }

    public final SDCardBean a(List<SDCardBean> list) {
        int[] iArr = WatchOpImpl.WATCH_STORAGE_INDEX_LIST;
        if (iArr == null) {
            return null;
        }
        for (SDCardBean sDCardBean : list) {
            for (int i : iArr) {
                if (sDCardBean.getIndex() == i) {
                    return sDCardBean;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(float f) {
        OnFatFileProgressListener onFatFileProgressListener = this.e;
        if (onFatFileProgressListener != null) {
            onFatFileProgressListener.onProgress(f);
        }
    }

    public final FileStruct a(String str) {
        String fileName = WatchFileUtil.getFileName(str);
        if (fileName == null) {
            JL_Log.w(this.TAG, "getFileStructByFlashPath", "fileName is null.");
            return null;
        }
        SDCardBean e = e();
        if (e == null) {
            JL_Log.w(this.TAG, "getFileStructByFlashPath", "flash is null.");
            return null;
        }
        Folder currentReadFile = FileBrowseManager.getInstance().getCurrentReadFile(e);
        if (currentReadFile == null) {
            JL_Log.w(this.TAG, "getFileStructByFlashPath", "folder is null.");
            return null;
        }
        List<FileStruct> childFileStructs = currentReadFile.getChildFileStructs();
        for (FileStruct fileStruct : childFileStructs) {
            if (fileName.equalsIgnoreCase(fileStruct.getName())) {
                return fileStruct;
            }
        }
        JL_Log.w(this.TAG, "getFileStructByFlashPath", "not found file info. file size = " + childFileStructs.size() + ", path = " + str);
        return null;
    }

    public final void a(SDCardBean sDCardBean, FileStruct fileStruct, final OnFatFileProgressListener onFatFileProgressListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(fileStruct);
        int deleteFile = FileBrowseManager.getInstance().deleteFile(sDCardBean, arrayList, new DeleteCallback() { // from class: com.jieli.jl_rcsp.watch.rcsp.RcspWatch.10
            @Override // com.jieli.jl_filebrowse.interfaces.DeleteCallback
            public void onError(int i, FileStruct fileStruct2) {
                JL_Log.w(((WatchBase) RcspWatch.this).TAG, "deleteFlashFile", "onError :: code = " + i + ", " + fileStruct2);
                OnFatFileProgressListener onFatFileProgressListener2 = onFatFileProgressListener;
                if (onFatFileProgressListener2 != null) {
                    onFatFileProgressListener2.onStop(i);
                }
            }

            @Override // com.jieli.jl_filebrowse.interfaces.DeleteCallback
            public void onFinish() {
            }

            @Override // com.jieli.jl_filebrowse.interfaces.DeleteCallback
            public void onSuccess(FileStruct fileStruct2) {
                JL_Log.i(((WatchBase) RcspWatch.this).TAG, "deleteFlashFile", "onSuccess :: " + fileStruct2);
                OnFatFileProgressListener onFatFileProgressListener2 = onFatFileProgressListener;
                if (onFatFileProgressListener2 != null) {
                    onFatFileProgressListener2.onProgress(100.0f);
                    onFatFileProgressListener.onStop(0);
                }
            }
        });
        JL_Log.w(this.TAG, "deleteFlashFile", "delResult = " + deleteFile);
        if (deleteFile == 0 || onFatFileProgressListener == null) {
            return;
        }
        onFatFileProgressListener.onStop(deleteFile);
    }

    public final boolean a(String str, byte[] bArr) {
        String jsonFileName = WatchFileUtil.getJsonFileName(str);
        PackResFormat packResFormat = this.g;
        if (packResFormat != null && jsonFileName != null && bArr != null && bArr.length != 0) {
            byte[] fileData = packResFormat.getFileData(bArr, jsonFileName);
            String str2 = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("data = ");
            sb.append(CHexConver.byte2HexStr(fileData));
            sb.append(", text = ");
            sb.append(fileData == null ? "" : new String(fileData));
            JL_Log.d(str2, "isMatchVersion", sb.toString());
            if (fileData == null) {
                return false;
            }
            try {
                FileExtMsg fileExtMsg = (FileExtMsg) new GsonBuilder().create().fromJson(new String(fileData).trim(), FileExtMsg.class);
                JL_Log.d(this.TAG, "isMatchVersion", "fileExtMsg = " + fileExtMsg);
                if (fileExtMsg == null) {
                    return false;
                }
                String[] matchVersions = getExternalFlashMsg(this.mRcspOp.getTargetDevice()) != null ? getExternalFlashMsg(this.mRcspOp.getTargetDevice()).getMatchVersions() : null;
                String str3 = this.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("matchVersions = ");
                sb2.append(matchVersions == null ? "null" : Arrays.toString(matchVersions));
                JL_Log.d(str3, "isMatchVersion", sb2.toString());
                if (matchVersions == null || matchVersions.length <= 0) {
                    return true;
                }
                for (String str4 : matchVersions) {
                    JL_Log.d(this.TAG, "isMatchVersion", "version = " + str4);
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

    public final void a(final String str, final boolean z, OnFatFileProgressListener onFatFileProgressListener) {
        if (!g()) {
            this.e = onFatFileProgressListener;
            this.l.submit(new Runnable() { // from class: com.jieli.jl_rcsp.watch.rcsp.oIX0oI
                @Override // java.lang.Runnable
                public final void run() {
                    RcspWatch.this.a(str, z);
                }
            });
        } else if (onFatFileProgressListener != null) {
            onFatFileProgressListener.onStop(4352);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, boolean z) {
        byte[] readFileData = WatchFileUtil.readFileData(str);
        if (readFileData != null && readFileData.length != 0) {
            if (!z && !a(str, readFileData)) {
                a(16896);
                return;
            } else {
                b(str);
                return;
            }
        }
        a(4);
    }

    public final void a(final float f) {
        this.m.post(new Runnable() { // from class: com.jieli.jl_rcsp.watch.rcsp.X0o0xo
            @Override // java.lang.Runnable
            public final void run() {
                RcspWatch.this.b(f);
            }
        });
    }

    public final void a(final int i) {
        this.m.post(new Runnable() { // from class: com.jieli.jl_rcsp.watch.rcsp.I0Io
            @Override // java.lang.Runnable
            public final void run() {
                RcspWatch.this.c(i);
            }
        });
    }

    public final boolean a(NetworkInfo networkInfo) {
        JL_Log.d(this.TAG, "checkNetworkOTAState", "networkInfo = " + networkInfo);
        if (networkInfo == null || !networkInfo.isMandatoryOTA()) {
            return false;
        }
        this.mWatchCallbackManager.onNetworkModuleException(getConnectedDevice(), networkInfo);
        return true;
    }

    public final void a(final BluetoothDevice bluetoothDevice) {
        SettingFunctionImpl.instance(this.mRcspOp).settingFunction(bluetoothDevice, new PublicSettingsCmd.Param(new DialExpandInfo()), new OnOperationCallback<PublicSettingsCmd.Response>() { // from class: com.jieli.jl_rcsp.watch.rcsp.RcspWatch.11
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                JL_Log.d(((WatchBase) RcspWatch.this).TAG, "readDialExpandInfo", "onFailed :: " + baseError);
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(PublicSettingsCmd.Response response) {
                WatchConfigure watchConfigure = RcspWatch.this.getWatchConfigure(bluetoothDevice);
                JL_Log.d(((WatchBase) RcspWatch.this).TAG, "readDialExpandInfo", "onSuccess :: " + response);
                if (watchConfigure == null || !(response.getSettingData() instanceof DialExpandInfo)) {
                    return;
                }
                watchConfigure.setDialExpandInfo((DialExpandInfo) response.getSettingData());
                ((WatchBase) RcspWatch.this).mStatusManager.updateDeviceConfigure(bluetoothDevice, watchConfigure);
            }
        });
    }
}
