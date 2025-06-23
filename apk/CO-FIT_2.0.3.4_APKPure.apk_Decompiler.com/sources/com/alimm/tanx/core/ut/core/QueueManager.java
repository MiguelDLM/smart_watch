package com.alimm.tanx.core.ut.core;

import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.ut.bean.UtBean;
import com.alimm.tanx.core.ut.core.thread.CacheAddThreadPool;
import com.alimm.tanx.core.ut.core.thread.RealTimeAddThreadPool;
import com.alimm.tanx.core.ut.core.thread.UserReportThreadPool;
import com.alimm.tanx.core.utils.FileUtil;
import com.alimm.tanx.core.utils.FileUtils;
import com.alimm.tanx.core.utils.LogUtils;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class QueueManager {
    private static final int CATCH_DELAY_TIME = 10000;
    private static final int QUEUE_SIZE = 1000;
    private static final String TAG = "QueueManager";
    private static final int defaultMaxUtCount = 5;
    private static volatile QueueManager instance;
    /* access modifiers changed from: private */
    public volatile boolean cacheRunning = false;
    /* access modifiers changed from: private */
    public volatile ConcurrentHashMap<Long, File> catchFileConcurrentHashMap = new ConcurrentHashMap<>(1000);
    private volatile AtomicBoolean destroy = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public volatile LinkedBlockingQueue<UtBean> realTimeLinkedBlockingQueue = new LinkedBlockingQueue<>(1000);
    /* access modifiers changed from: private */
    public volatile boolean realTimeQueueRunning = false;
    private volatile UtBean utBeanAssemble = null;

    public class RealTimeRunnable implements Runnable {
        private final String TAG = "RealTimeRunnable";
        private final UtBean itemUtBean;

        public RealTimeRunnable(UtBean utBean) {
            this.itemUtBean = utBean;
        }

        public void run() {
            try {
                LogUtils.d("RealTimeRunnable", "UserReport :添加addRealTimeQueue");
                if (this.itemUtBean != null) {
                    QueueManager.this.realTimeLinkedBlockingQueue.put(this.itemUtBean);
                } else {
                    LogUtils.d("RealTimeRunnable", "UserReport :添加addRealTimeQueue失败-->itemUtBean为空");
                }
            } catch (Exception e) {
                LogUtils.e("RealTimeRunnable", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addOrRemoveUtBeanAssemble(boolean r1, com.alimm.tanx.core.ut.bean.UtBean r2) {
        /*
            r0 = this;
            monitor-enter(r0)
            if (r1 == 0) goto L_0x005b
            if (r2 == 0) goto L_0x0059
            java.util.List<com.alimm.tanx.core.ut.bean.UtItemBean> r1 = r2.events     // Catch:{ Exception -> 0x0019 }
            if (r1 == 0) goto L_0x0059
            int r1 = r1.size()     // Catch:{ Exception -> 0x0019 }
            if (r1 > 0) goto L_0x0010
            goto L_0x0059
        L_0x0010:
            com.alimm.tanx.core.ut.bean.UtBean r1 = r0.utBeanAssemble     // Catch:{ Exception -> 0x0019 }
            if (r1 != 0) goto L_0x001b
            r0.utBeanAssemble = r2     // Catch:{ Exception -> 0x0019 }
            goto L_0x0024
        L_0x0017:
            r1 = move-exception
            goto L_0x0066
        L_0x0019:
            r1 = move-exception
            goto L_0x005f
        L_0x001b:
            com.alimm.tanx.core.ut.bean.UtBean r1 = r0.utBeanAssemble     // Catch:{ Exception -> 0x0019 }
            java.util.List<com.alimm.tanx.core.ut.bean.UtItemBean> r1 = r1.events     // Catch:{ Exception -> 0x0019 }
            java.util.List<com.alimm.tanx.core.ut.bean.UtItemBean> r2 = r2.events     // Catch:{ Exception -> 0x0019 }
            r1.addAll(r2)     // Catch:{ Exception -> 0x0019 }
        L_0x0024:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.destroy     // Catch:{ Exception -> 0x0019 }
            boolean r1 = r1.get()     // Catch:{ Exception -> 0x0019 }
            if (r1 == 0) goto L_0x0037
            java.lang.String r1 = "QueueManager"
            java.lang.String r2 = "UserReport :后台逻辑，取出realTimeLinkedBlockingQueue元素，保存到文件"
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0019 }
            r0.destroyIng()     // Catch:{ Exception -> 0x0019 }
            goto L_0x0064
        L_0x0037:
            com.alimm.tanx.core.ut.bean.UtBean r1 = r0.utBeanAssemble     // Catch:{ Exception -> 0x0019 }
            java.util.List<com.alimm.tanx.core.ut.bean.UtItemBean> r1 = r1.events     // Catch:{ Exception -> 0x0019 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0019 }
            int r2 = r0.getUploadMaxCount()     // Catch:{ Exception -> 0x0019 }
            if (r1 < r2) goto L_0x0064
            java.lang.String r1 = "QueueManager"
            java.lang.String r2 = "UserReport :取出realTimeLinkedBlockingQueue元素，启动上报"
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.ut.core.UtRequest r1 = com.alimm.tanx.core.ut.core.UtRequest.getInstance()     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.ut.bean.UtBean r2 = r0.utBeanAssemble     // Catch:{ Exception -> 0x0019 }
            r1.requestRealTime(r2)     // Catch:{ Exception -> 0x0019 }
            r1 = 0
            r0.utBeanAssemble = r1     // Catch:{ Exception -> 0x0019 }
            goto L_0x0064
        L_0x0059:
            monitor-exit(r0)
            return
        L_0x005b:
            r0.destroyIng()     // Catch:{ Exception -> 0x0019 }
            goto L_0x0064
        L_0x005f:
            java.lang.String r2 = "QueueManager"
            com.alimm.tanx.core.utils.LogUtils.e((java.lang.String) r2, (java.lang.Exception) r1)     // Catch:{ all -> 0x0017 }
        L_0x0064:
            monitor-exit(r0)
            return
        L_0x0066:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.ut.core.QueueManager.addOrRemoveUtBeanAssemble(boolean, com.alimm.tanx.core.ut.bean.UtBean):void");
    }

    private void destroyIng() {
        if (this.utBeanAssemble != null) {
            CacheUserReportManager.getInstance().saveFile(this.utBeanAssemble);
            this.utBeanAssemble = null;
        }
    }

    public static QueueManager getInstance() {
        if (instance == null) {
            synchronized (QueueManager.class) {
                try {
                    if (instance == null) {
                        instance = new QueueManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    /* access modifiers changed from: private */
    public int getUploadMaxCount() {
        int utUploadMaxCount = OrangeManager.getInstance().getUtUploadMaxCount();
        if (utUploadMaxCount == -1) {
            return 5;
        }
        return utUploadMaxCount;
    }

    /* access modifiers changed from: private */
    public UtBean readFile2UtBean(File file) {
        try {
            return (UtBean) JSON.parseObject(FileUtils.getStrFromFile(file), UtBean.class);
        } catch (Exception e) {
            LogUtils.e(TAG, e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void runCatchQueue() {
        UtRequest.getInstance().atomicLong.set(0);
        UserReportThreadPool.post(new Runnable() {
            public void run() {
                try {
                    LogUtils.d(QueueManager.TAG, "UserReport :启动runCatchQueue");
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(20);
                    UtBean utBean = null;
                    int i = 0;
                    for (Map.Entry entry : QueueManager.this.catchFileConcurrentHashMap.entrySet()) {
                        i++;
                        LogUtils.d(QueueManager.TAG, "UserReport :取出catchFileLinkedHashMap元素，启动上报");
                        Long l = (Long) entry.getKey();
                        File file = (File) entry.getValue();
                        concurrentHashMap.put(l, file);
                        if (!file.exists()) {
                            QueueManager.this.catchFileConcurrentHashMap.remove(l);
                        } else {
                            UtBean access$400 = QueueManager.this.readFile2UtBean(file);
                            if (access$400 == null || access$400.events.size() <= 0) {
                                QueueManager.this.catchFileConcurrentHashMap.remove(l);
                                CacheUserReportManager.getInstance().deleteFile(file);
                            } else {
                                if (utBean != null) {
                                    utBean.events.addAll(access$400.events);
                                } else {
                                    utBean = access$400;
                                }
                                if (utBean.events.size() >= QueueManager.this.getUploadMaxCount() || i >= QueueManager.this.catchFileConcurrentHashMap.size()) {
                                    QueueManager.this.uploadCatchUt(utBean, concurrentHashMap);
                                    concurrentHashMap.clear();
                                    utBean = null;
                                }
                            }
                        }
                    }
                    if (utBean != null) {
                        QueueManager.this.uploadCatchUt(utBean, concurrentHashMap);
                        concurrentHashMap.clear();
                    }
                } catch (Exception e) {
                    LogUtils.e(QueueManager.TAG, e);
                }
                boolean unused = QueueManager.this.cacheRunning = false;
            }
        });
    }

    private void runRealTimeQueue() {
        LogUtils.d(TAG, "UserReport :启动runRealTimeQueue--realTimeQueueRunning-->" + this.realTimeQueueRunning);
        if (!this.realTimeQueueRunning) {
            UserReportThreadPool.post(new Runnable() {
                public void run() {
                    try {
                        boolean unused = QueueManager.this.realTimeQueueRunning = true;
                        while (true) {
                            UtBean utBean = (UtBean) QueueManager.this.realTimeLinkedBlockingQueue.take();
                            if (utBean != null) {
                                QueueManager.this.addOrRemoveUtBeanAssemble(true, utBean);
                            } else {
                                return;
                            }
                        }
                    } catch (Exception e) {
                        LogUtils.e(QueueManager.TAG, e);
                        boolean unused2 = QueueManager.this.realTimeQueueRunning = false;
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void uploadCatchUt(UtBean utBean, ConcurrentHashMap<Long, File> concurrentHashMap) {
        if (utBean != null) {
            if (UtRequest.getInstance().requestCache(utBean)) {
                LogUtils.d(TAG, "UserReport :埋点catchFileConcurrentHashMap成功-> " + utBean.reqId);
                for (Map.Entry next : concurrentHashMap.entrySet()) {
                    this.catchFileConcurrentHashMap.remove((Long) next.getKey());
                    CacheUserReportManager.getInstance().deleteFile((File) next.getValue());
                }
                return;
            }
            LogUtils.d(TAG, "UserReport :埋点catchFileConcurrentHashMap失败");
        }
    }

    public void addCatchList(File file) {
        if (file != null) {
            try {
                this.catchFileConcurrentHashMap.put(Long.valueOf(FileUtil.getFileName(file)), file);
            } catch (Exception e) {
                LogUtils.e(TAG, e);
            }
        } else {
            LogUtils.d(TAG, "UserReport :添加catchFileLinkedHashMap失败-->itemUtBean为空");
        }
    }

    public void addRealTimeQueue(UtBean utBean) {
        RealTimeAddThreadPool.post(new RealTimeRunnable(utBean));
    }

    public void destroy() {
        RealTimeAddThreadPool.post(new Runnable() {
            public void run() {
                QueueManager.this.addOrRemoveUtBeanAssemble(false, (UtBean) null);
            }
        });
        this.destroy.set(true);
    }

    public void readCatch2Upload() {
        if (!this.cacheRunning) {
            LogUtils.d(TAG, "UserReport :延迟10000毫秒 启动readCatch2Upload,runCatchQueue");
            this.cacheRunning = true;
            CacheAddThreadPool.postDelayed(new Runnable() {
                public void run() {
                    try {
                        List<File> readCacheFileList = CacheUserReportManager.getInstance().readCacheFileList();
                        LogUtils.d(QueueManager.TAG, "UserReport :添加catchFileLinkedHashMap ->目前文件有：" + readCacheFileList.size());
                        for (int i = 0; i < readCacheFileList.size(); i++) {
                            if (readCacheFileList.get(i) != null) {
                                QueueManager.this.addCatchList(readCacheFileList.get(i));
                            }
                        }
                        QueueManager.this.runCatchQueue();
                    } catch (Exception e) {
                        LogUtils.e(QueueManager.TAG, e);
                    }
                }
            }, 10000);
            return;
        }
        LogUtils.d(TAG, "UserReport :readCatch2Upload已经启动，无需重复启动->cacheRunning->" + this.cacheRunning);
    }

    public void run() {
        LogUtils.d(TAG, "UserReport :run()");
        this.destroy.set(false);
        runRealTimeQueue();
        readCatch2Upload();
    }
}
