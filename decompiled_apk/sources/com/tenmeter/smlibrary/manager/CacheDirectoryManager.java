package com.tenmeter.smlibrary.manager;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.tenmeter.smlibrary.utils.SMGameClient;
import java.io.File;

/* loaded from: classes13.dex */
public class CacheDirectoryManager {
    private static final String TAG = "CacheDirectoryManager";
    private static String appPath;
    private static CacheDirectoryManager cacheDirectoryManager;
    private static String cacheFileRootPath;
    private static String connectGifCachePath;
    private static String correctCachePath;
    private static String crashLogPath;
    private static String customExternFileRootPath;
    private static String externCacheFileRootPath;
    private static String externCacheImagePath;
    private static String normalLogPath;
    private static String resourceDownloadPath;
    private static String userStorageAudioPath;
    private static String userStorageImagePath;
    private static String userStorageVideoPath;
    private Context mContext;

    /* renamed from: com.tenmeter.smlibrary.manager.CacheDirectoryManager$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tenmeter$smlibrary$manager$CacheDirectoryManager$AppType;

        static {
            int[] iArr = new int[AppType.values().length];
            $SwitchMap$com$tenmeter$smlibrary$manager$CacheDirectoryManager$AppType = iArr;
            try {
                iArr[AppType.PHONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public enum AppType {
        PHONE
    }

    private CacheDirectoryManager(Context context) {
        this.mContext = context;
    }

    private void checkFileExitis(String str) {
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                file.mkdirs();
                return;
            }
            return;
        }
        file.mkdirs();
    }

    public static CacheDirectoryManager getInstance() {
        CacheDirectoryManager cacheDirectoryManager2;
        synchronized (CacheDirectoryManager.class) {
            try {
                if (cacheDirectoryManager == null) {
                    cacheDirectoryManager = new CacheDirectoryManager(SMGameClient.getContext());
                }
                cacheDirectoryManager2 = cacheDirectoryManager;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cacheDirectoryManager2;
    }

    private static String getSDCardDir() {
        File[] listFiles = Environment.getExternalStorageDirectory().getParentFile().listFiles();
        String str = null;
        long j = 0;
        for (int i = 0; listFiles != null && listFiles.length > 0 && i < listFiles.length; i++) {
            if (listFiles[i].canWrite()) {
                String absolutePath = listFiles[i].getAbsolutePath();
                long sDFreeSize = getSDFreeSize(absolutePath);
                if (sDFreeSize > j) {
                    str = absolutePath;
                    j = sDFreeSize;
                }
            }
        }
        return str;
    }

    public static long getSDFreeSize(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            StatFs statFs = new StatFs(str);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(TAG, "httpFrame threadName:" + Thread.currentThread().getName() + " getSDFreeSize  无法计算文件夹大小 folderPath:" + str);
            return -1L;
        }
    }

    public static String getStorageDirs(Context context) {
        String file = Environment.getExternalStorageDirectory().toString();
        if (!new File(file).canWrite()) {
            String sDCardDir = getSDCardDir();
            if (sDCardDir != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(sDCardDir);
                String str = File.separator;
                sb.append(str);
                sb.append("com.tenmeter.smlibraryrary");
                sb.append(str);
                sb.append(appPath);
                String sb2 = sb.toString();
                Log.i(TAG, "项目存储路径采用自动找寻可用存储空间的方式   storageDirectory:" + sb2);
                return sb2;
            }
            Log.e(TAG, "没有找到可用的存储路径  采用FilesDir");
            return context.getFilesDir().toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(file);
        String str2 = File.separator;
        sb3.append(str2);
        sb3.append("com.tenmeter.smlibraryrary");
        sb3.append(str2);
        sb3.append(appPath);
        String sb4 = sb3.toString();
        Log.i(TAG, "项目存储路径采用sdcard的地址   storageDirectory:" + sb4);
        return sb4;
    }

    private void initAppPath(AppType appType) {
        if (AnonymousClass1.$SwitchMap$com$tenmeter$smlibrary$manager$CacheDirectoryManager$AppType[appType.ordinal()] != 1) {
            appPath = "default";
        } else {
            appPath = "user";
        }
    }

    private void initCommonCache(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(externCacheFileRootPath);
        String str = File.separator;
        sb.append(str);
        sb.append("image");
        sb.append(str);
        String sb2 = sb.toString();
        externCacheImagePath = sb2;
        makedirs(sb2);
        String str2 = customExternFileRootPath + str + "download" + str;
        resourceDownloadPath = str2;
        makedirs(str2);
        String str3 = customExternFileRootPath + str + "error" + str;
        crashLogPath = str3;
        makedirs(str3);
        String str4 = customExternFileRootPath + str + "normal-Log" + str;
        normalLogPath = str4;
        makedirs(str4);
        String str5 = externCacheFileRootPath + str + "correct_pic" + str;
        correctCachePath = str5;
        makedirs(str5);
        String str6 = externCacheFileRootPath + str + "gif" + str;
        connectGifCachePath = str6;
        makedirs(str6);
    }

    private void initRootPath(AppType appType) {
        String file;
        initAppPath(appType);
        if (this.mContext.getFilesDir() == null) {
            file = "";
        } else {
            file = this.mContext.getFilesDir().toString();
        }
        cacheFileRootPath = file;
        externCacheFileRootPath = getExternCacheFileRootPath(this.mContext);
        customExternFileRootPath = getStorageDirs(this.mContext);
    }

    private void makedirs(String str) {
        if (!str.contains("null")) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
                return;
            }
            return;
        }
        throw null;
    }

    public static void setNormalLogPath(String str) {
        normalLogPath = str;
    }

    public String getCacheFileRootPath() {
        if (cacheFileRootPath == null) {
            initAppStoragePath(this.mContext, AppType.PHONE);
        }
        checkFileExitis(cacheFileRootPath);
        return cacheFileRootPath;
    }

    public String getConnectGifCachePath() {
        if (connectGifCachePath == null) {
            initAppStoragePath(this.mContext, AppType.PHONE);
        }
        checkFileExitis(connectGifCachePath);
        return connectGifCachePath;
    }

    public String getCorrectCachePath() {
        if (correctCachePath == null) {
            initAppStoragePath(this.mContext, AppType.PHONE);
        }
        checkFileExitis(correctCachePath);
        return correctCachePath;
    }

    public String getCrashLogPath() {
        if (crashLogPath == null) {
            initAppStoragePath(this.mContext, AppType.PHONE);
        }
        checkFileExitis(crashLogPath);
        return crashLogPath;
    }

    public String getCustomExternFileRootPath() {
        if (customExternFileRootPath == null) {
            initAppStoragePath(this.mContext, AppType.PHONE);
        }
        checkFileExitis(customExternFileRootPath);
        return customExternFileRootPath;
    }

    public String getExternCacheFileRootPath() {
        if (externCacheFileRootPath == null) {
            initAppStoragePath(this.mContext, AppType.PHONE);
        }
        checkFileExitis(externCacheFileRootPath);
        return externCacheFileRootPath;
    }

    public String getExternCacheImagePath() {
        if (externCacheImagePath == null) {
            initAppStoragePath(this.mContext, AppType.PHONE);
        }
        checkFileExitis(externCacheImagePath);
        return externCacheImagePath;
    }

    public String getNormalLogPath() {
        if (normalLogPath == null) {
            initAppStoragePath(this.mContext, AppType.PHONE);
        }
        checkFileExitis(normalLogPath);
        return normalLogPath;
    }

    public String getResourceDownloadPath() {
        if (resourceDownloadPath == null) {
            initAppStoragePath(this.mContext, AppType.PHONE);
        }
        checkFileExitis(resourceDownloadPath);
        return resourceDownloadPath;
    }

    public String getUserStorageAudioPath() {
        if (userStorageAudioPath == null) {
            initAppStoragePath(this.mContext, AppType.PHONE);
        }
        checkFileExitis(userStorageAudioPath);
        return userStorageAudioPath;
    }

    public String getUserStorageImagePath() {
        if (userStorageImagePath == null) {
            initAppStoragePath(this.mContext, AppType.PHONE);
        }
        checkFileExitis(userStorageImagePath);
        return userStorageImagePath;
    }

    public String getUserStorageVideoPath() {
        if (userStorageVideoPath == null) {
            initAppStoragePath(this.mContext, AppType.PHONE);
        }
        checkFileExitis(userStorageVideoPath);
        return userStorageVideoPath;
    }

    public synchronized void initAppStoragePath(Context context, AppType appType) {
        initRootPath(appType);
        initCommonCache(context);
    }

    public void initUserFileDirectory(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(customExternFileRootPath);
        String str = File.separator;
        sb.append(str);
        sb.append("image");
        sb.append(str);
        String sb2 = sb.toString();
        userStorageImagePath = sb2;
        makedirs(sb2);
        String str2 = customExternFileRootPath + str + "video" + str;
        userStorageVideoPath = str2;
        makedirs(str2);
        String str3 = customExternFileRootPath + str + MimeTypes.BASE_TYPE_AUDIO + str;
        userStorageAudioPath = str3;
        makedirs(str3);
    }

    public static String getExternCacheFileRootPath(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return getStorageDirs(context);
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        Log.i(TAG, "项目存储路径采用系统给的路径地址  storageDirectory:" + absolutePath);
        return absolutePath;
    }
}
