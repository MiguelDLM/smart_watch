package com.bytedance.pangle;

import androidx.annotation.Keep;
import com.bytedance.pangle.download.IDownloaderProvider;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import com.google.android.exoplayer2.C;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Keep
/* loaded from: classes8.dex */
public class GlobalParam {
    private static GlobalParam mInstance;
    private boolean mCheckPermission;
    private boolean mCloseCrashMonitor;
    private boolean mCloseFlipped;
    private boolean mCloseHookHuaweiOnInit;
    private String mDid;
    private File mDownloadDir;
    private IDownloaderProvider mDownloaderProvider;
    private boolean mFastDex2oat;
    private String mHostUrl;
    private IZeusLogger mLogger;
    private IZeusReporter mReporter;
    private boolean hasInit = false;
    private boolean mDebug = true;
    private int mInstallThreads = 4;
    private boolean mCheckMatchHostAbi = true;
    private final Map<String, String> mRequestHeader = new HashMap();
    private final Map<String, Boolean> unInstallPluginWhenHostChange = new HashMap();
    private final Map<String, Map<String, String>> mCustomTag = new HashMap();
    private final Map<String, String> mSignature = new HashMap();
    private long mDexOptDelayTime = C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
    private boolean mPostBgDexOptByInit = true;
    private boolean mAutoFetch = true;
    private final Map<String, Integer> mRemoveApkEntry = new HashMap();
    private int mApmFlag = -1;
    private boolean mCloseBgDex2oat = false;

    private void ensureInit() {
        if (!this.hasInit) {
        } else {
            throw new RuntimeException();
        }
    }

    public static GlobalParam getInstance() {
        if (mInstance == null) {
            synchronized (GlobalParam.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new GlobalParam();
                    }
                } finally {
                }
            }
        }
        return mInstance;
    }

    public void addRequestHeader(String str, String str2) {
        ensureInit();
        this.mRequestHeader.put(str, str2);
    }

    public boolean autoFetch() {
        return this.mAutoFetch;
    }

    public boolean checkMatchHostAbi() {
        return this.mCheckMatchHostAbi;
    }

    public boolean checkPermission() {
        return this.mCheckPermission;
    }

    public void closeBgDex2oat(boolean z) {
        ensureInit();
        this.mCloseBgDex2oat = z;
    }

    public void closeCrashMonitor(boolean z) {
        ensureInit();
        this.mCloseCrashMonitor = z;
    }

    public void closeHookHuaweiOnInit(boolean z) {
        ensureInit();
        this.mCloseHookHuaweiOnInit = z;
    }

    public int getApmFlag() {
        if (this.mApmFlag == -1) {
            this.mApmFlag = 7;
        }
        return this.mApmFlag;
    }

    public Map<String, String> getCustomTag(String str) {
        return this.mCustomTag.get(str);
    }

    public long getDexOptDelayTime() {
        return this.mDexOptDelayTime;
    }

    public String getDid() {
        return this.mDid;
    }

    public File getDownloadDir() {
        return this.mDownloadDir;
    }

    public IDownloaderProvider getDownloaderProvider() {
        return this.mDownloaderProvider;
    }

    public String getHostUrl() {
        return this.mHostUrl;
    }

    public int getInstallThreads() {
        return this.mInstallThreads;
    }

    public IZeusLogger getLogger() {
        return this.mLogger;
    }

    public int getRemoveApkEntryFlag(String str) {
        Integer num = this.mRemoveApkEntry.get(str);
        if (num == null) {
            num = 0;
        }
        return num.intValue();
    }

    public IZeusReporter getReporter() {
        return this.mReporter;
    }

    public Map<String, String> getRequestHeader() {
        return this.mRequestHeader;
    }

    public String getSignature(String str) {
        return this.mSignature.get(str);
    }

    public void init() {
        this.hasInit = true;
    }

    public boolean isCloseBgDex2oat() {
        return this.mCloseBgDex2oat;
    }

    public boolean isCloseCrashMonitor() {
        return this.mCloseCrashMonitor;
    }

    public boolean isCloseFlipped() {
        return this.mCloseFlipped;
    }

    public boolean isDebug() {
        return this.mDebug;
    }

    public boolean isFastDex2oat() {
        return this.mFastDex2oat;
    }

    public boolean isPostBgDexOptByInit() {
        return this.mPostBgDexOptByInit;
    }

    public void postBgDexOptByInit(boolean z) {
        ensureInit();
        this.mPostBgDexOptByInit = this.mPostBgDexOptByInit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void removeApkEntry(String str, boolean z, boolean z2) {
        ensureInit();
        int i = z;
        if (z2) {
            i = (z ? 1 : 0) | 2;
        }
        this.mRemoveApkEntry.put(str, Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public void setApmFlag(boolean z, boolean z2, boolean z3, boolean z4) {
        ensureInit();
        ?? r1 = z;
        if (z2) {
            r1 = (z ? 1 : 0) | 2;
        }
        if (z3) {
            r1 = (r1 == true ? 1 : 0) | 4;
        }
        if (z4) {
            r1 = (r1 == true ? 1 : 0) | '\b';
        }
        this.mApmFlag = r1;
    }

    public void setAutoFetch(boolean z) {
        ensureInit();
        this.mAutoFetch = z;
    }

    public void setCheckMatchHostAbi(boolean z) {
        this.mCheckMatchHostAbi = z;
    }

    public void setCheckPermission(boolean z) {
        this.mCheckPermission = z;
    }

    public void setCloseFlipped(boolean z) {
        ensureInit();
        this.mCloseFlipped = z;
    }

    public void setCustomTag(String str, Map<String, String> map) {
        this.mCustomTag.put(str, map);
    }

    public void setDebug(boolean z) {
        ensureInit();
        this.mDebug = z;
    }

    public void setDexOptDelayTime(long j) {
        ensureInit();
        this.mDexOptDelayTime = j;
    }

    public void setDid(String str) {
        this.mDid = str;
    }

    public void setDownloadDir(File file) {
        ensureInit();
        this.mDownloadDir = file;
    }

    public void setDownloaderProvider(IDownloaderProvider iDownloaderProvider) {
        ensureInit();
        this.mDownloaderProvider = iDownloaderProvider;
    }

    public void setFastDex2oat(boolean z) {
        this.mFastDex2oat = z;
    }

    public void setHostUrl(String str) {
        ensureInit();
        this.mHostUrl = str;
    }

    public void setInstallThreads(int i) {
        ensureInit();
        this.mInstallThreads = i;
    }

    public void setLogger(IZeusLogger iZeusLogger) {
        ensureInit();
        this.mLogger = iZeusLogger;
    }

    public void setReporter(IZeusReporter iZeusReporter) {
        ensureInit();
        this.mReporter = iZeusReporter;
    }

    public void setSignature(String str, String str2) {
        ensureInit();
        this.mSignature.put(str, str2);
    }

    public void setUnInstallPluginWhenHostChange(String str, boolean z) {
        ensureInit();
        this.unInstallPluginWhenHostChange.put(str, Boolean.valueOf(z));
    }

    public boolean unInstallPluginWhenHostChange(String str) {
        Boolean bool = this.unInstallPluginWhenHostChange.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean closeHookHuaweiOnInit() {
        return this.mCloseHookHuaweiOnInit;
    }
}
