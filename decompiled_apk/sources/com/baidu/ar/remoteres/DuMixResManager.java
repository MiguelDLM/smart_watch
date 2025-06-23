package com.baidu.ar.remoteres;

import android.content.Context;
import com.baidu.ar.ARType;
import com.baidu.ar.DuMixController;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.fn;
import com.baidu.ar.fp;
import com.baidu.ar.hz;
import com.baidu.ar.ib;
import com.baidu.ar.id;
import com.baidu.ar.ie;
import com.baidu.ar.km;
import com.baidu.ar.kv;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes7.dex */
public class DuMixResManager extends hz implements ib {
    private static final String TAG = "DuMixResManager";
    private static final boolean USE_LOCAL_LIB = false;
    private static boolean sAREngienDownload;
    private static final Map<ARType, String> sProcessorMap;
    private File mLibDir;
    private id mMainResProc;
    private File mModelDir;
    private final Map<ARType, IDuMixResProcessor> mProcessorInstances = new HashMap();
    private boolean mIsCheckError = false;

    static {
        HashMap hashMap = new HashMap();
        sProcessorMap = hashMap;
        sAREngienDownload = false;
        hashMap.put(ARType.ON_DEVICE_IR, OnDeviceIRResProcessor.class.getName());
        hashMap.put(ARType.CLOUD_IR, CloudIRResProcessor.class.getName());
        hashMap.put(ARType.FACE, FaceResProcessor.class.getName());
    }

    public DuMixResManager(Context context) {
        this.mContext = context.getApplicationContext();
        this.mLibDir = new File(DuMixController.getSoDownLoadDir(context));
        this.mModelDir = new File(this.mLibDir, "res");
        if (!fn.isRegistered()) {
            fn.a(new fp(this.mLibDir.getAbsolutePath()));
        }
        checkResSdkVersion(context);
        km.d(this.mLibDir);
        km.d(this.mModelDir);
        this.mDownloader = new ie(context.getApplicationContext(), this.mLibDir);
        checkNewVersion();
    }

    private void checkNewVersion() {
        Map<ARType, String> map = sProcessorMap;
        int i = 1;
        String[] strArr = new String[map.size() + 1];
        strArr[0] = getMainResProcessor().getBusinessTag();
        Iterator<Map.Entry<ARType, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            strArr[i] = getResProcessor(it.next().getKey()).getBusinessTag();
            i++;
        }
        this.mIsCheckError = false;
        this.mDownloader.setErrorCallback(new ICallbackWith<String>() { // from class: com.baidu.ar.remoteres.DuMixResManager.5
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public void run(String str) {
                DuMixResManager.this.mIsCheckError = true;
                DuMixResManager duMixResManager = DuMixResManager.this;
                ICallbackWith<IDuMixResLoadTask> iCallbackWith = duMixResManager.mErrorCallback;
                if (iCallbackWith != null) {
                    iCallbackWith.run(duMixResManager.makeErrorObj(str));
                }
            }
        });
        this.mDownloader.a(strArr, new ICallbackWith<Map<String, String>>() { // from class: com.baidu.ar.remoteres.DuMixResManager.6
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void run(Map<String, String> map2) {
                DuMixResManager.this.mIsCheckError = false;
                if (map2 != null) {
                    DuMixResManager.this.mBusinessResUrls.putAll(map2);
                }
                DuMixResManager duMixResManager = DuMixResManager.this;
                duMixResManager.mIsChecked = true;
                duMixResManager.executeReadyTask();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if (r3 == null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void checkResSdkVersion(android.content.Context r3) {
        /*
            r2 = this;
            com.baidu.ar.if r3 = com.baidu.ar.Cif.i(r3)
            if (r3 == 0) goto L22
            int r0 = r3.fQ()
            int r1 = com.baidu.ar.kg.getVersionCode()
            if (r0 == r1) goto L22
            java.io.File r3 = r2.mLibDir
            r0 = 1
            com.baidu.ar.km.a(r3, r0)
            java.io.File r3 = r2.mModelDir
            com.baidu.ar.km.a(r3, r0)
        L1b:
            com.baidu.ar.if r3 = com.baidu.ar.Cif.fP()
        L1f:
            r2.mResVersion = r3
            goto L25
        L22:
            if (r3 != 0) goto L1f
            goto L1b
        L25:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.remoteres.DuMixResManager.checkResSdkVersion(android.content.Context):void");
    }

    private id getMainResProcessor() {
        if (this.mMainResProc == null) {
            this.mMainResProc = new id();
        }
        return this.mMainResProc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadRes(final IDuMixResProcessor iDuMixResProcessor, final DuMixController duMixController, final ICallback iCallback) {
        if (this.mContext == null) {
            return;
        }
        if (iDuMixResProcessor != null && !this.mIsChecked) {
            onReady(new Runnable() { // from class: com.baidu.ar.remoteres.DuMixResManager.2
                @Override // java.lang.Runnable
                public void run() {
                    DuMixResManager.this.loadRes(iDuMixResProcessor, duMixController, iCallback);
                }
            });
            if (this.mIsCheckError) {
                checkNewVersion();
                return;
            }
            return;
        }
        if (iDuMixResProcessor == null || iDuMixResProcessor.isLoaded() || (!isModHasNewVersion(iDuMixResProcessor.getBusinessTag()) && iDuMixResProcessor.isReady(this.mLibDir, this.mModelDir) && iDuMixResProcessor.load(duMixController, this.mLibDir, this.mModelDir))) {
            notifySuccess(iCallback);
        } else {
            doDownloadRes(iDuMixResProcessor.getBusinessTag(), new ICallback() { // from class: com.baidu.ar.remoteres.DuMixResManager.3
                @Override // com.baidu.ar.callback.ICallback
                public void run() {
                    DuMixResManager.this.updateModResVersion(iDuMixResProcessor);
                    if (iDuMixResProcessor.load(duMixController, DuMixResManager.this.mLibDir, DuMixResManager.this.mModelDir)) {
                        DuMixResManager.this.notifySuccess(iCallback);
                        return;
                    }
                    DuMixResManager duMixResManager = DuMixResManager.this;
                    ICallbackWith<IDuMixResLoadTask> iCallbackWith = duMixResManager.mErrorCallback;
                    if (iCallbackWith != null) {
                        iCallbackWith.run(duMixResManager.makeErrorObj("load case res fail"));
                    }
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySuccess(final ICallback iCallback) {
        if (iCallback == null || this.mContext == null) {
            return;
        }
        kv.runOnUiThread(new Runnable() { // from class: com.baidu.ar.remoteres.DuMixResManager.4
            @Override // java.lang.Runnable
            public void run() {
                ICallback iCallback2 = iCallback;
                if (iCallback2 == null || DuMixResManager.this.mContext == null) {
                    return;
                }
                iCallback2.run();
            }
        });
    }

    public static void setAREngienDownload(boolean z) {
        sAREngienDownload = z;
    }

    @Override // com.baidu.ar.ib
    public void downloadARRes(ARType aRType, final ICallback iCallback) {
        final IDuMixResProcessor resProcessor = getResProcessor(aRType);
        if (resProcessor != null) {
            onReady(new Runnable() { // from class: com.baidu.ar.remoteres.DuMixResManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DuMixResManager.this.isModHasNewVersion(resProcessor.getBusinessTag()) || !resProcessor.isReady(DuMixResManager.this.mLibDir, DuMixResManager.this.mModelDir)) {
                        DuMixResManager.this.doDownloadRes(resProcessor.getBusinessTag(), new ICallback() { // from class: com.baidu.ar.remoteres.DuMixResManager.1.1
                            @Override // com.baidu.ar.callback.ICallback
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                DuMixResManager.this.updateModResVersion(resProcessor);
                                ICallback iCallback2 = iCallback;
                                if (iCallback2 != null) {
                                    iCallback2.run();
                                }
                            }
                        }, null);
                        return;
                    }
                    ICallback iCallback2 = iCallback;
                    if (iCallback2 != null) {
                        iCallback2.run();
                    }
                }
            });
        } else if (iCallback != null) {
            iCallback.run();
        }
    }

    public String getLibRoot() {
        return this.mLibDir.getAbsolutePath();
    }

    public String getModelRoot() {
        return this.mModelDir.getAbsolutePath();
    }

    public IDuMixResProcessor getResProcessor(ARType aRType) {
        if (aRType == null) {
            aRType = DuMixARConfig.getAipAppId().equals("6") ? ARType.IMU : ARType.FACE;
        }
        if (this.mProcessorInstances.containsKey(aRType)) {
            return this.mProcessorInstances.get(aRType);
        }
        Map<ARType, String> map = sProcessorMap;
        if (map.containsKey(aRType)) {
            try {
                IDuMixResProcessor iDuMixResProcessor = (IDuMixResProcessor) Class.forName(map.get(aRType)).newInstance();
                this.mProcessorInstances.put(aRType, iDuMixResProcessor);
                return iDuMixResProcessor;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean isARResReady(ARType aRType) {
        IDuMixResProcessor resProcessor = getResProcessor(aRType);
        if (resProcessor != null) {
            return !isModHasNewVersion(resProcessor.getBusinessTag()) && resProcessor.isReady(this.mLibDir, this.mModelDir);
        }
        return true;
    }

    public boolean load(ARType aRType) {
        if (!isARResReady(aRType)) {
            return false;
        }
        String modelRoot = getModelRoot();
        String libRoot = getLibRoot();
        return getResProcessor(aRType).load(null, new File(libRoot), new File(modelRoot));
    }

    public void loadARRes(ARType aRType, DuMixController duMixController, ICallback iCallback) {
        loadRes(getResProcessor(aRType), duMixController, iCallback);
    }

    public void loadMainLib(ICallback iCallback) {
        id mainResProcessor = getMainResProcessor();
        mainResProcessor.P(sAREngienDownload);
        loadRes(mainResProcessor, null, iCallback);
    }

    public void prepareMainRes(DuMixController duMixController) {
        getMainResProcessor().b(duMixController, this.mModelDir);
    }

    public void release() {
        onRelease();
    }

    @Override // com.baidu.ar.ib
    public void setErrorCallback(ICallbackWith<IDuMixResLoadTask> iCallbackWith) {
        this.mErrorCallback = iCallbackWith;
    }
}
