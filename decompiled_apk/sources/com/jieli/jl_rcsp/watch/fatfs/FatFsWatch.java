package com.jieli.jl_rcsp.watch.fatfs;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_fatfs.FatFileSystem;
import com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener;
import com.jieli.jl_fatfs.interfaces.OnFatFsInitListener;
import com.jieli.jl_fatfs.interfaces.OnFatFsOpResultListener;
import com.jieli.jl_fatfs.model.FatFile;
import com.jieli.jl_fatfs.utils.FatUtil;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener;
import com.jieli.jl_rcsp.interfaces.watch.IWatchManager;
import com.jieli.jl_rcsp.interfaces.watch.OnUpdateResourceCallback;
import com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback;
import com.jieli.jl_rcsp.model.WatchFileContent;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.response.ExternalFlashMsgResponse;
import com.jieli.jl_rcsp.tool.UpdateResourceThread;
import com.jieli.jl_rcsp.tool.WatchCallbackManager;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import com.jieli.jl_rcsp.util.WatchFileUtil;
import com.jieli.jl_rcsp.watch.WatchBase;
import com.jieli.jl_rcsp.watch.WatchProgressHandler;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class FatFsWatch extends WatchBase implements IWatchManager {
    public FatFileSystem e;
    public UpdateResourceThread f;

    public FatFsWatch(RcspOpImpl rcspOpImpl, WatchCallbackManager watchCallbackManager) {
        super(rcspOpImpl, watchCallbackManager);
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public boolean cancelTransfer() {
        return false;
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void createWatchFile(final String str, final boolean z, final OnFatFileProgressListener onFatFileProgressListener) {
        if (this.e == null) {
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStop(22);
            }
        } else {
            if (str == null) {
                if (onFatFileProgressListener != null) {
                    onFatFileProgressListener.onStop(5);
                    return;
                }
                return;
            }
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                jumpToUpdateResource(false, new OnWatchOpCallback<Boolean>() { // from class: com.jieli.jl_rcsp.watch.fatfs.FatFsWatch.4
                    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                    public void onFailed(BaseError baseError) {
                        JL_Log.w(((WatchBase) FatFsWatch.this).TAG, "createWatchFile", "onFailed ---> " + baseError);
                        OnFatFileProgressListener onFatFileProgressListener2 = onFatFileProgressListener;
                        if (onFatFileProgressListener2 != null) {
                            onFatFileProgressListener2.onStop(baseError.getSubCode());
                        }
                    }

                    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                    public void onSuccess(Boolean bool) {
                        FatFsWatch.this.a(str, z, onFatFileProgressListener);
                    }
                });
            } else if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStop(5);
            }
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void deleteWatchFile(final String str, final OnFatFileProgressListener onFatFileProgressListener) {
        if (this.e == null) {
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStop(22);
            }
        } else {
            if (str == null) {
                if (onFatFileProgressListener != null) {
                    onFatFileProgressListener.onStop(5);
                    return;
                }
                return;
            }
            jumpToUpdateResource(false, new OnWatchOpCallback<Boolean>() { // from class: com.jieli.jl_rcsp.watch.fatfs.FatFsWatch.5
                @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                public void onFailed(BaseError baseError) {
                    OnFatFileProgressListener onFatFileProgressListener2 = onFatFileProgressListener;
                    if (onFatFileProgressListener2 != null) {
                        onFatFileProgressListener2.onStop(baseError.getSubCode());
                    }
                }

                @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                public void onSuccess(Boolean bool) {
                    final WatchProgressHandler watchProgressHandler = new WatchProgressHandler(FatFsWatch.this, 2, onFatFileProgressListener);
                    FatFsWatch.this.deleteFileStart(str, new OnWatchOpCallback<Boolean>() { // from class: com.jieli.jl_rcsp.watch.fatfs.FatFsWatch.5.1
                        @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                        public void onFailed(BaseError baseError) {
                            watchProgressHandler.onStop(baseError.getSubCode());
                        }

                        @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                        public void onSuccess(Boolean bool2) {
                            FatFsWatch.this.e.deleteFatFile(str, watchProgressHandler);
                        }
                    });
                }
            });
        }
    }

    @Override // com.jieli.jl_rcsp.watch.WatchBase, com.jieli.jl_rcsp.interfaces.watch.IWatchManager
    public void destroy() {
        super.destroy();
        UpdateResourceThread updateResourceThread = this.f;
        if (updateResourceThread != null) {
            updateResourceThread.stopThread();
        }
        destroyFatFileSystem();
    }

    public void destroyFatFileSystem() {
        FatFileSystem fatFileSystem = this.e;
        if (fatFileSystem != null) {
            fatFileSystem.destroy();
            setSysException(false);
            this.e = null;
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public String getCurrentBrowsePath() {
        FatFileSystem fatFileSystem = this.e;
        if (fatFileSystem == null) {
            return null;
        }
        return fatFileSystem.getCurBrowsePath();
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchManager
    public FatFile getWatchFileByPath(String str) {
        FatFileSystem fatFileSystem = this.e;
        if (fatFileSystem == null) {
            return null;
        }
        return fatFileSystem.getFatFileMsg(str);
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void getWatchFileSize(String str, OnWatchOpCallback<WatchFileContent> onWatchOpCallback) {
        if (this.e == null) {
            if (onWatchOpCallback != null) {
                onWatchOpCallback.onFailed(new BaseError(22, FatUtil.getFatFsErrorCodeMsg(22)));
                return;
            }
            return;
        }
        FatFile watchFileByPath = getWatchFileByPath(str);
        if (watchFileByPath == null) {
            if (onWatchOpCallback != null) {
                onWatchOpCallback.onFailed(new BaseError(4, FatUtil.getFatFsErrorCodeMsg(4)));
            }
        } else if (onWatchOpCallback != null) {
            onWatchOpCallback.onSuccess(new WatchFileContent(watchFileByPath.getSize(), (short) 0));
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void getWatchSysLeftSize(OnWatchOpCallback<Long> onWatchOpCallback) {
        if (this.e == null) {
            if (onWatchOpCallback != null) {
                onWatchOpCallback.onFailed(new BaseError(22, FatUtil.getFatFsErrorCodeMsg(22)));
            }
        } else {
            long freeSize = r0.getFreeSize() * 4096;
            if (onWatchOpCallback != null) {
                onWatchOpCallback.onSuccess(Long.valueOf(freeSize));
            }
        }
    }

    public FatFileSystem getWatchSystem() {
        return this.e;
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchManager
    public void init() {
        a(new OnFatFsInitListener() { // from class: com.jieli.jl_rcsp.watch.fatfs.FatFsWatch.1
            @Override // com.jieli.jl_fatfs.interfaces.OnFatFsInitListener
            public void onInitFailed(int i) {
                JL_Log.w(((WatchBase) FatFsWatch.this).TAG, "init", "onInitFailed ---> code = " + i);
            }

            @Override // com.jieli.jl_fatfs.interfaces.OnFatFsInitListener
            public void onInitOk() {
                JL_Log.i(((WatchBase) FatFsWatch.this).TAG, "init", "onInitOk");
            }
        }, (OnFatFileProgressListener) null);
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchManager
    public boolean isInit() {
        if (this.e != null) {
            return true;
        }
        return false;
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void listWatchList(final OnWatchOpCallback<ArrayList<FatFile>> onWatchOpCallback) {
        FatFileSystem fatFileSystem = this.e;
        if (fatFileSystem == null) {
            onCallbackError(onWatchOpCallback, 22);
        } else {
            fatFileSystem.listFatDir("/", new OnFatFsOpResultListener() { // from class: com.jieli.jl_rcsp.watch.fatfs.II0xO0
                @Override // com.jieli.jl_fatfs.interfaces.OnFatFsOpResultListener
                public final void onResult(Object obj) {
                    FatFsWatch.this.a(onWatchOpCallback, (ArrayList) obj);
                }
            });
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void openWatchFile(String str, final OnWatchOpCallback<byte[]> onWatchOpCallback) {
        FatFileSystem fatFileSystem = this.e;
        if (fatFileSystem != null && str != null) {
            fatFileSystem.openFatFile(str, new OnFatFsOpResultListener() { // from class: com.jieli.jl_rcsp.watch.fatfs.I0Io
                @Override // com.jieli.jl_fatfs.interfaces.OnFatFsOpResultListener
                public final void onResult(Object obj) {
                    FatFsWatch.a(OnWatchOpCallback.this, (byte[]) obj);
                }
            });
        } else if (onWatchOpCallback != null) {
            onWatchOpCallback.onFailed(new BaseError(4097, "param is error."));
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void replaceWatchFile(final String str, final OnFatFileProgressListener onFatFileProgressListener) {
        if (this.e == null) {
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStop(22);
            }
        } else {
            if (!WatchFileUtil.isFileExist(str)) {
                if (onFatFileProgressListener != null) {
                    onFatFileProgressListener.onStop(5);
                    return;
                }
                return;
            }
            jumpToUpdateResource(false, new OnWatchOpCallback<Boolean>() { // from class: com.jieli.jl_rcsp.watch.fatfs.FatFsWatch.6
                @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                public void onFailed(BaseError baseError) {
                    JL_Log.w(((WatchBase) FatFsWatch.this).TAG, "replaceWatchFile", "onFailed ---> " + baseError);
                    OnFatFileProgressListener onFatFileProgressListener2 = onFatFileProgressListener;
                    if (onFatFileProgressListener2 != null) {
                        onFatFileProgressListener2.onStop(baseError.getSubCode());
                    }
                }

                @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                public void onSuccess(Boolean bool) {
                    FatFsWatch.this.e.replaceFatFile(str, new WatchProgressHandler(FatFsWatch.this, 3, onFatFileProgressListener));
                }
            });
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void restoreWatchSystem(OnFatFileProgressListener onFatFileProgressListener) {
        if (onFatFileProgressListener != null) {
            JL_Log.w(this.TAG, "restoreWatchSystem", "start. progressListener = " + onFatFileProgressListener);
            a(new OnFatFsInitListener() { // from class: com.jieli.jl_rcsp.watch.fatfs.FatFsWatch.2
                @Override // com.jieli.jl_fatfs.interfaces.OnFatFsInitListener
                public void onInitFailed(int i) {
                    JL_Log.e(((WatchBase) FatFsWatch.this).TAG, "restoreWatchSystem", "onInitFailed = " + i);
                }

                @Override // com.jieli.jl_fatfs.interfaces.OnFatFsInitListener
                public void onInitOk() {
                    JL_Log.i(((WatchBase) FatFsWatch.this).TAG, "restoreWatchSystem", "onInitOk ---> ");
                }
            }, new WatchProgressHandler(this, 4, onFatFileProgressListener));
            return;
        }
        throw new RuntimeException("OnFatFileProgressListener can not be empty.");
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void updateWatchResource(final String str, final OnUpdateResourceCallback onUpdateResourceCallback) {
        FatFileSystem fatFileSystem = this.e;
        if (fatFileSystem == null) {
            if (onUpdateResourceCallback != null) {
                onUpdateResourceCallback.onError(22, FatUtil.getFatFsErrorCodeMsg(22));
                return;
            }
            return;
        }
        fatFileSystem.listFatDir("/", new OnFatFsOpResultListener() { // from class: com.jieli.jl_rcsp.watch.fatfs.oIX0oI
            @Override // com.jieli.jl_fatfs.interfaces.OnFatFsOpResultListener
            public final void onResult(Object obj) {
                FatFsWatch.this.a(onUpdateResourceCallback, str, (ArrayList) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(OnUpdateResourceCallback onUpdateResourceCallback, String str, ArrayList arrayList) {
        if (arrayList == null) {
            if (onUpdateResourceCallback != null) {
                onUpdateResourceCallback.onError(24, FatUtil.getFatFsErrorCodeMsg(24));
                return;
            }
            return;
        }
        JL_Log.i(this.TAG, "updateWatchResource", "listFatDir >> " + arrayList.size());
        if (this.f == null) {
            UpdateResourceThread updateResourceThread = new UpdateResourceThread(this, str, onUpdateResourceCallback, new ThreadStateListener() { // from class: com.jieli.jl_rcsp.watch.fatfs.FatFsWatch.3
                @Override // com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener
                public void onFinish(long j) {
                    if (FatFsWatch.this.f != null && FatFsWatch.this.f.getId() == j) {
                        FatFsWatch.this.f = null;
                    }
                }

                @Override // com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener
                public void onStart(long j) {
                }
            });
            this.f = updateResourceThread;
            updateResourceThread.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(OnWatchOpCallback onWatchOpCallback, ArrayList arrayList) {
        if (arrayList == null) {
            onCallbackError(onWatchOpCallback, 24);
        } else if (onWatchOpCallback != null) {
            onWatchOpCallback.onSuccess(arrayList);
        }
    }

    public static /* synthetic */ void a(OnWatchOpCallback onWatchOpCallback, byte[] bArr) {
        if (bArr == null) {
            if (onWatchOpCallback != null) {
                onWatchOpCallback.onFailed(new BaseError(12289, "fatfs op error."));
            }
        } else if (onWatchOpCallback != null) {
            onWatchOpCallback.onSuccess(bArr);
        }
    }

    public final void a(final OnFatFsInitListener onFatFsInitListener, final OnFatFileProgressListener onFatFileProgressListener) {
        if (this.e == null) {
            final BluetoothDevice targetDevice = this.mRcspOp.getTargetDevice();
            if (targetDevice == null) {
                if (onFatFsInitListener != null) {
                    onFatFsInitListener.onInitFailed(8192);
                    return;
                }
                return;
            }
            ExternalFlashMsgResponse extFlashMsg = this.mStatusManager.getExtFlashMsg(targetDevice);
            JL_Log.d(this.TAG, "createFatFileSystem", "device : " + RcspUtil.printBtDeviceInfo(targetDevice) + ", " + extFlashMsg);
            if (extFlashMsg == null) {
                queryExtFlashMsg(new OnOperationCallback<ExternalFlashMsgResponse>() { // from class: com.jieli.jl_rcsp.watch.fatfs.FatFsWatch.7
                    @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                    public void onFailed(BaseError baseError) {
                        OnFatFsInitListener onFatFsInitListener2 = onFatFsInitListener;
                        if (onFatFsInitListener2 != null) {
                            onFatFsInitListener2.onInitFailed(baseError.getSubCode());
                        }
                    }

                    @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                    public void onSuccess(ExternalFlashMsgResponse externalFlashMsgResponse) {
                        if (((WatchBase) FatFsWatch.this).mStatusManager.getExtFlashMsg(targetDevice) == null) {
                            ((WatchBase) FatFsWatch.this).mStatusManager.updateExtFlashMsg(targetDevice, externalFlashMsgResponse);
                        }
                        JL_Log.d(((WatchBase) FatFsWatch.this).TAG, "createFatFileSystem", "GetExternalFlashMsg : " + externalFlashMsgResponse);
                        FatFsWatch.this.a(onFatFsInitListener, onFatFileProgressListener);
                    }
                });
                return;
            }
            JL_Log.i(this.TAG, "createFatFileSystem", "" + extFlashMsg);
            if (extFlashMsg.getSysStatus() != 0) {
                if (onFatFileProgressListener == null) {
                    if (onFatFsInitListener != null) {
                        onFatFsInitListener.onInitFailed(2);
                        return;
                    }
                    return;
                }
                setSysException(true);
            }
            this.e = new FatFileSystem(extFlashMsg.getFlashSize(), extFlashMsg.getFatSize(), extFlashMsg.getSysStatus(), extFlashMsg.getMatchVersions(), new FatFsBluetoothImp(this), new OnFatFsInitListener() { // from class: com.jieli.jl_rcsp.watch.fatfs.FatFsWatch.8
                @Override // com.jieli.jl_fatfs.interfaces.OnFatFsInitListener
                public void onInitFailed(int i) {
                    JL_Log.e(((WatchBase) FatFsWatch.this).TAG, "createFatFileSystem", "onInitFailed = " + i);
                    FatFsWatch.this.destroyFatFileSystem();
                    OnFatFsInitListener onFatFsInitListener2 = onFatFsInitListener;
                    if (onFatFsInitListener2 != null) {
                        onFatFsInitListener2.onInitFailed(i);
                    }
                    ((WatchBase) FatFsWatch.this).mWatchCallbackManager.onWatchSystemInit(i);
                }

                @Override // com.jieli.jl_fatfs.interfaces.OnFatFsInitListener
                public void onInitOk() {
                    JL_Log.i(((WatchBase) FatFsWatch.this).TAG, "createFatFileSystem", "onInitOk ====> ");
                    boolean z = false;
                    FatFsWatch.this.setSysException(false);
                    OnFatFsInitListener onFatFsInitListener2 = onFatFsInitListener;
                    if (onFatFsInitListener2 != null) {
                        onFatFsInitListener2.onInitOk();
                    }
                    ((WatchBase) FatFsWatch.this).mWatchCallbackManager.onWatchSystemInit(0);
                    BluetoothDevice targetDevice2 = ((WatchBase) FatFsWatch.this).mRcspOp.getTargetDevice();
                    if (((WatchBase) FatFsWatch.this).mStatusManager.getDeviceInfo(targetDevice2) != null) {
                        FatFsWatch fatFsWatch = FatFsWatch.this;
                        if (((WatchBase) fatFsWatch).mStatusManager.getDeviceInfo(targetDevice2).getExpandMode() == 1) {
                            z = true;
                        }
                        fatFsWatch.setOTAResource(z);
                        JL_Log.w(((WatchBase) FatFsWatch.this).TAG, "createFatFileSystem", "isOTAResource = " + ((WatchBase) FatFsWatch.this).isOTAResource);
                        if (((WatchBase) FatFsWatch.this).isOTAResource) {
                            ((WatchBase) FatFsWatch.this).mWatchCallbackManager.onResourceUpdateUnfinished(targetDevice2);
                        }
                    }
                }
            }, onFatFileProgressListener);
        }
    }

    public final void a(final String str, final boolean z, final OnFatFileProgressListener onFatFileProgressListener) {
        createFileStart(FatUtil.getFatFilePath(this.e.getCurBrowsePath(), str), (int) new File(str).length(), new OnWatchOpCallback<Boolean>() { // from class: com.jieli.jl_rcsp.watch.fatfs.FatFsWatch.9
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onFailed(BaseError baseError) {
                OnFatFileProgressListener onFatFileProgressListener2 = onFatFileProgressListener;
                if (onFatFileProgressListener2 != null) {
                    onFatFileProgressListener2.onStop(baseError.getSubCode());
                }
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onSuccess(Boolean bool) {
                FatFsWatch.this.e.createFatFile(str, z, new WatchProgressHandler(FatFsWatch.this, 1, onFatFileProgressListener));
            }
        });
    }
}
