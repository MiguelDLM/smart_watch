package com.alimm.tanx.core.ut.core;

import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.ut.bean.UtBean;
import com.alimm.tanx.core.ut.bean.UtItemBean;
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

/* loaded from: classes.dex */
public class QueueManager {
    private static final int CATCH_DELAY_TIME = 10000;
    private static final int QUEUE_SIZE = 1000;
    private static final String TAG = "QueueManager";
    private static final int defaultMaxUtCount = 5;
    private static volatile QueueManager instance;
    private volatile LinkedBlockingQueue<UtBean> realTimeLinkedBlockingQueue = new LinkedBlockingQueue<>(1000);
    private volatile boolean realTimeQueueRunning = false;
    private volatile boolean cacheRunning = false;
    private volatile AtomicBoolean destroy = new AtomicBoolean(false);
    private volatile ConcurrentHashMap<Long, File> catchFileConcurrentHashMap = new ConcurrentHashMap<>(1000);
    private volatile UtBean utBeanAssemble = null;

    /* loaded from: classes.dex */
    public class RealTimeRunnable implements Runnable {
        private final String TAG = "RealTimeRunnable";
        private final UtBean itemUtBean;

        public RealTimeRunnable(UtBean utBean) {
            this.itemUtBean = utBean;
        }

        @Override // java.lang.Runnable
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

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void addOrRemoveUtBeanAssemble(boolean z, UtBean utBean) {
        List<UtItemBean> list;
        try {
            if (z) {
                if (utBean != null && (list = utBean.events) != null && list.size() > 0) {
                    if (this.utBeanAssemble == null) {
                        this.utBeanAssemble = utBean;
                    } else {
                        this.utBeanAssemble.events.addAll(utBean.events);
                    }
                    if (this.destroy.get()) {
                        LogUtils.d(TAG, "UserReport :后台逻辑，取出realTimeLinkedBlockingQueue元素，保存到文件");
                        destroyIng();
                    } else if (this.utBeanAssemble.events.size() >= getUploadMaxCount()) {
                        LogUtils.d(TAG, "UserReport :取出realTimeLinkedBlockingQueue元素，启动上报");
                        UtRequest.getInstance().requestRealTime(this.utBeanAssemble);
                        this.utBeanAssemble = null;
                    }
                }
                return;
            }
            destroyIng();
        } catch (Exception e) {
            LogUtils.e(TAG, e);
        } finally {
        }
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
                } finally {
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getUploadMaxCount() {
        int utUploadMaxCount = OrangeManager.getInstance().getUtUploadMaxCount();
        if (utUploadMaxCount == -1) {
            return 5;
        }
        return utUploadMaxCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UtBean readFile2UtBean(File file) {
        try {
            return (UtBean) JSON.parseObject(FileUtils.getStrFromFile(file), UtBean.class);
        } catch (Exception e) {
            LogUtils.e(TAG, e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runCatchQueue() {
        UtRequest.getInstance().atomicLong.set(0L);
        UserReportThreadPool.post(new Runnable() { // from class: com.alimm.tanx.core.ut.core.QueueManager.2
            @Override // java.lang.Runnable
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
                        if (file.exists()) {
                            UtBean readFile2UtBean = QueueManager.this.readFile2UtBean(file);
                            if (readFile2UtBean != null && readFile2UtBean.events.size() > 0) {
                                if (utBean != null) {
                                    utBean.events.addAll(readFile2UtBean.events);
                                } else {
                                    utBean = readFile2UtBean;
                                }
                                if (utBean.events.size() >= QueueManager.this.getUploadMaxCount() || i >= QueueManager.this.catchFileConcurrentHashMap.size()) {
                                    QueueManager.this.uploadCatchUt(utBean, concurrentHashMap);
                                    concurrentHashMap.clear();
                                    utBean = null;
                                }
                            } else {
                                QueueManager.this.catchFileConcurrentHashMap.remove(l);
                                CacheUserReportManager.getInstance().deleteFile(file);
                            }
                        } else {
                            QueueManager.this.catchFileConcurrentHashMap.remove(l);
                        }
                    }
                    if (utBean != null) {
                        QueueManager.this.uploadCatchUt(utBean, concurrentHashMap);
                        concurrentHashMap.clear();
                    }
                } catch (Exception e) {
                    LogUtils.e(QueueManager.TAG, e);
                }
                QueueManager.this.cacheRunning = false;
            }
        });
    }

    private void runRealTimeQueue() {
        LogUtils.d(TAG, "UserReport :启动runRealTimeQueue--realTimeQueueRunning-->" + this.realTimeQueueRunning);
        if (!this.realTimeQueueRunning) {
            UserReportThreadPool.post(new Runnable() { // from class: com.alimm.tanx.core.ut.core.QueueManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        QueueManager.this.realTimeQueueRunning = true;
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
                        QueueManager.this.realTimeQueueRunning = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadCatchUt(UtBean utBean, ConcurrentHashMap<Long, File> concurrentHashMap) {
        if (utBean == null) {
            return;
        }
        if (UtRequest.getInstance().requestCache(utBean)) {
            LogUtils.d(TAG, "UserReport :埋点catchFileConcurrentHashMap成功-> " + utBean.reqId);
            for (Map.Entry<Long, File> entry : concurrentHashMap.entrySet()) {
                Long key = entry.getKey();
                File value = entry.getValue();
                this.catchFileConcurrentHashMap.remove(key);
                CacheUserReportManager.getInstance().deleteFile(value);
            }
            return;
        }
        LogUtils.d(TAG, "UserReport :埋点catchFileConcurrentHashMap失败");
    }

    public void addCatchList(File file) {
        try {
            if (file != null) {
                this.catchFileConcurrentHashMap.put(Long.valueOf(FileUtil.getFileName(file)), file);
            } else {
                LogUtils.d(TAG, "UserReport :添加catchFileLinkedHashMap失败-->itemUtBean为空");
            }
        } catch (Exception e) {
            LogUtils.e(TAG, e);
        }
    }

    public void addRealTimeQueue(UtBean utBean) {
        RealTimeAddThreadPool.post(new RealTimeRunnable(utBean));
    }

    public void destroy() {
        RealTimeAddThreadPool.post(new Runnable() { // from class: com.alimm.tanx.core.ut.core.QueueManager.4
            @Override // java.lang.Runnable
            public void run() {
                QueueManager.this.addOrRemoveUtBeanAssemble(false, null);
            }
        });
        this.destroy.set(true);
    }

    public void readCatch2Upload() {
        if (!this.cacheRunning) {
            LogUtils.d(TAG, "UserReport :延迟10000毫秒 启动readCatch2Upload,runCatchQueue");
            this.cacheRunning = true;
            CacheAddThreadPool.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.ut.core.QueueManager.3
                @Override // java.lang.Runnable
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
        } else {
            LogUtils.d(TAG, "UserReport :readCatch2Upload已经启动，无需重复启动->cacheRunning->" + this.cacheRunning);
        }
    }

    public void run() {
        LogUtils.d(TAG, "UserReport :run()");
        this.destroy.set(false);
        runRealTimeQueue();
        readCatch2Upload();
    }
}
