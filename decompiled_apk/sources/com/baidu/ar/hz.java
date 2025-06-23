package com.baidu.ar;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.ihttp.IProgressCallback;
import com.baidu.ar.remoteres.IDuMixResLoadTask;
import com.baidu.ar.remoteres.IDuMixResProcessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class hz {
    private static final String TAG = "AbstractResManager";
    public Context mContext;
    protected ie mDownloader;
    public ICallbackWith<IDuMixResLoadTask> mErrorCallback;
    protected Cif mResVersion;
    public boolean mIsChecked = false;
    protected List<Runnable> mReadyTasks = new ArrayList();
    public Map<String, String> mBusinessResUrls = new HashMap();

    public void doDownloadRes(final String str, final ICallback iCallback, final IProgressCallback iProgressCallback) {
        if (this.mContext == null || !this.mBusinessResUrls.containsKey(str)) {
            return;
        }
        this.mDownloader.fO();
        this.mDownloader.setErrorCallback(new ICallbackWith<String>() { // from class: com.baidu.ar.hz.1
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public void run(final String str2) {
                ICallbackWith<IDuMixResLoadTask> iCallbackWith = hz.this.mErrorCallback;
                if (iCallbackWith != null) {
                    iCallbackWith.run(new IDuMixResLoadTask() { // from class: com.baidu.ar.hz.1.1
                        @Override // com.baidu.ar.remoteres.IDuMixResLoadTask
                        public boolean canRetry() {
                            return true;
                        }

                        @Override // com.baidu.ar.remoteres.IDuMixResLoadTask
                        public String getError() {
                            return str2;
                        }

                        @Override // com.baidu.ar.remoteres.IDuMixResLoadTask
                        public void retry() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            hz.this.doDownloadRes(str, iCallback, iProgressCallback);
                        }
                    });
                }
            }
        });
        this.mDownloader.a(this.mBusinessResUrls.get(str), iCallback, iProgressCallback);
    }

    public void executeReadyTask() {
        if (this.mReadyTasks.isEmpty()) {
            return;
        }
        int size = this.mReadyTasks.size();
        Runnable[] runnableArr = new Runnable[size];
        this.mReadyTasks.toArray(runnableArr);
        this.mReadyTasks.clear();
        for (int i = 0; i < size; i++) {
            Runnable runnable = runnableArr[i];
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public boolean isModHasNewVersion(String str) {
        Map<String, String> map = this.mBusinessResUrls;
        if (map == null || this.mResVersion == null) {
            return false;
        }
        String str2 = map.get(str);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        kf.c(TAG, "check so new version: business:" + str + " currentVersion:" + kp.cp(str2).toLowerCase() + " oldVersion:" + this.mResVersion.by(str));
        return !r0.equals(r1);
    }

    public IDuMixResLoadTask makeErrorObj(final String str) {
        return new IDuMixResLoadTask() { // from class: com.baidu.ar.hz.2
            @Override // com.baidu.ar.remoteres.IDuMixResLoadTask
            public boolean canRetry() {
                return false;
            }

            @Override // com.baidu.ar.remoteres.IDuMixResLoadTask
            public String getError() {
                return str;
            }

            @Override // com.baidu.ar.remoteres.IDuMixResLoadTask
            public void retry() {
            }
        };
    }

    public void onReady(Runnable runnable) {
        if (this.mIsChecked) {
            runnable.run();
        } else {
            this.mReadyTasks.add(runnable);
        }
    }

    public void onRelease() {
        this.mErrorCallback = null;
        this.mContext = null;
        this.mBusinessResUrls.clear();
        this.mReadyTasks.clear();
        ie ieVar = this.mDownloader;
        if (ieVar != null) {
            ieVar.release();
        }
    }

    public void updateModResVersion(IDuMixResProcessor iDuMixResProcessor) {
        if (this.mContext != null) {
            String lowerCase = kp.cp(this.mBusinessResUrls.get(iDuMixResProcessor.getBusinessTag())).toLowerCase();
            kf.c(TAG, "update so complete: business:" + iDuMixResProcessor.getBusinessTag() + " newVersion:" + lowerCase);
            this.mResVersion.s(iDuMixResProcessor.getBusinessTag(), lowerCase);
            Cif.a(this.mContext, this.mResVersion);
        }
    }
}
