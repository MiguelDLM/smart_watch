package com.alimm.tanx.core.ut.core;

import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ut.bean.UtBean;
import com.alimm.tanx.core.ut.core.thread.FileThreadPool;
import com.alimm.tanx.core.utils.FileUtil;
import com.alimm.tanx.core.utils.FileUtils;
import com.alimm.tanx.core.utils.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class CacheUserReportManager {
    private static final String TAG = "CacheUserReportManager";
    private static volatile CacheUserReportManager instance;
    public static volatile int tempFileName;
    private final int FILE_MAX_SIZE = 1000;

    @Deprecated
    private final int FILE_MERGE_SIZE = 5;
    private final File cacheDir = FileUtils.mkdir(FileUtils.getExternalDir(TanxCoreSdk.getApplication(), 0).getPath() + "/ut/");

    /* JADX INFO: Access modifiers changed from: private */
    public String createFileName() {
        return System.currentTimeMillis() + ".txt";
    }

    public static CacheUserReportManager getInstance() {
        if (instance == null) {
            synchronized (CacheUserReportManager.class) {
                try {
                    if (instance == null) {
                        instance = new CacheUserReportManager();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void judgeFileDelete() {
        try {
            File file = this.cacheDir;
            if (file != null) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    LogUtils.d(TAG, "UserReport :judgeFileDelete()文件个数->" + listFiles.length);
                    if (listFiles.length >= 1000) {
                        ArrayList arrayList = new ArrayList(Arrays.asList(listFiles));
                        Collections.sort(arrayList, new Comparator<File>() { // from class: com.alimm.tanx.core.ut.core.CacheUserReportManager.2
                            @Override // java.util.Comparator
                            public int compare(File file2, File file3) {
                                return (int) (FileUtil.getFileName(file3) - FileUtil.getFileName(file2));
                            }
                        });
                        while (arrayList.size() - 1000 >= 0) {
                            FileUtils.deleteFile((File) arrayList.get(arrayList.size() - 1));
                            arrayList.remove(arrayList.size() - 1);
                            LogUtils.d(TAG, "UserReport :judgeFileDelete(),超过文件阈值开始删除->当前文件个数" + listFiles.length);
                        }
                        return;
                    }
                    return;
                }
                LogUtils.d(TAG, "UserReport :judgeFileDelete()listFiles为空，或length为0");
            }
        } catch (Exception e) {
            LogUtils.e(IUserReport.TAG, e);
        }
    }

    public void deleteFile(final File file) {
        FileThreadPool.post(new Runnable() { // from class: com.alimm.tanx.core.ut.core.CacheUserReportManager.3
            @Override // java.lang.Runnable
            public void run() {
                FileUtils.deleteFile(file);
            }
        });
    }

    public List<File> readCacheFileList() {
        File[] listFiles = this.cacheDir.listFiles();
        ArrayList arrayList = new ArrayList();
        if (listFiles != null && listFiles.length > 0) {
            return new ArrayList(Arrays.asList(listFiles));
        }
        return arrayList;
    }

    public void saveFile(UtBean utBean) {
        saveFile(JSON.toJSONString(utBean));
    }

    public void saveFile(final String str) {
        FileThreadPool.post(new Runnable() { // from class: com.alimm.tanx.core.ut.core.CacheUserReportManager.1
            @Override // java.lang.Runnable
            public void run() {
                CacheUserReportManager.this.judgeFileDelete();
                FileUtils.saveStr2File(FileUtil.getAndCreateFile(CacheUserReportManager.this.cacheDir.getPath(), CacheUserReportManager.this.createFileName()), str);
            }
        });
    }
}
