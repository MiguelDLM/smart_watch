package com.baidu.navisdk.debug;

import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.navisdk.debug.e;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class SDKDebugFileUtil {
    public static final String AUTO_CHECK_LOG = "auto_check_log";
    public static final String END_GUIDE_FILENAME = "end_guide";
    public static final String FIX_ALL_LOG = "fix_log";
    public static final String HUAWEI_MM_LOCATION = "mm_location";
    private static final int MAX_LINE = 50000;
    private static final int MAX_SIZE = 10485760;
    public static final String NAVING_FLPLOC_FILENAME = "naving_flploc_debug";
    public static final String NAVING_SYSLOC_FILENAME = "naving_sysloc_debug";
    public static final String NORMAL_ALL_LOG = "normal_all_log";
    public static final String PERFORMANCE_LOG_FILENAME = "navi_perf_log";
    public static final String POWER_SAVE_LOG = "power_save_log";
    public static final String RoutePlan_FILENAME = "RoutePlan_debug";
    public static final String SYSLOC_FILENAME = "sysloc_debug";
    public static final String TTS_FILENAME = "TTS_debug";
    public static final String USEROP_FILENAME = "userop_debug";
    public static final String USER_ALL_LOG = "USER_ALL_LOG";
    public static final String VECTOR_ENLARGE_FILENAME = "vector_enlarge_debug";
    private static String sModuleFileName;
    private static String sSDCardPath;
    private long TIME_INTERVAL;
    private boolean mAddFileNameTime;
    private int mAllCoreLogLine;
    private BufferedWriter mBW;
    private e.b mChildThreadCallback;
    private BufferedWriter mCoreLogBW;
    private BufferedWriter mCoreLogBWForAllLog;
    private File mCoreLogDir;
    private int mCoreLogLine;
    private boolean mCoreLogRecordEnable;
    private SimpleDateFormat mCoreLogSDF;
    private File mFile;
    private String mFileName;
    private String mFilePath;
    private boolean mHasTime;
    private SimpleDateFormat mSDF;
    private long noNormalLastTimeGPS1;
    private long noNormalLastTimeGPS2;
    private long normalLastTimeGPS1;
    private long normalLastTimeGPS2;
    private static e mDebugFileThread = new e("DebugFileHandlerThread");
    private static Map<String, SDKDebugFileUtil> sFiles = new ConcurrentHashMap();
    private static SDKDebugFileUtil sInstance = null;
    private static String actionLogFilePath = null;

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6769a;

        public b(String str) {
            this.f6769a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (SDKDebugFileUtil.this.mBW != null) {
                try {
                    BufferedWriter bufferedWriter = SDKDebugFileUtil.this.mBW;
                    StringBuilder sb = new StringBuilder();
                    if (SDKDebugFileUtil.this.mHasTime) {
                        str = SDKDebugFileUtil.this.mSDF.format(new Date()) + " ### " + this.f6769a;
                    } else {
                        str = this.f6769a;
                    }
                    sb.append(str);
                    sb.append("\n");
                    bufferedWriter.append((CharSequence) sb.toString());
                    SDKDebugFileUtil.this.mBW.flush();
                } catch (IOException unused) {
                }
            }
        }
    }

    private SDKDebugFileUtil() {
        this.mCoreLogDir = null;
        this.mCoreLogBW = null;
        this.mCoreLogBWForAllLog = null;
        this.mCoreLogSDF = null;
        this.normalLastTimeGPS1 = 0L;
        this.noNormalLastTimeGPS1 = 0L;
        this.normalLastTimeGPS2 = 0L;
        this.noNormalLastTimeGPS2 = 0L;
        this.TIME_INTERVAL = 30000L;
        this.mAllCoreLogLine = 0;
        this.mCoreLogLine = 0;
        this.mFilePath = null;
        this.mFileName = null;
        this.mAddFileNameTime = true;
        this.mHasTime = true;
        this.mFile = null;
        this.mBW = null;
        this.mSDF = null;
        this.mCoreLogRecordEnable = true;
        a aVar = new a();
        this.mChildThreadCallback = aVar;
        mDebugFileThread.a(aVar);
    }

    private void checkAllLogFile(File file) {
        if (this.mAllCoreLogLine >= 50000 && this.mCoreLogBWForAllLog != null && file.length() > 10485760) {
            this.mAllCoreLogLine = 0;
            try {
                this.mCoreLogBWForAllLog.flush();
                this.mCoreLogBWForAllLog.close();
                this.mCoreLogBWForAllLog = null;
            } catch (IOException e) {
                this.mCoreLogBWForAllLog = null;
                g gVar = g.EYE_SPY;
                if (gVar.c()) {
                    gVar.c("checkAllLogFile", e.getLocalizedMessage());
                }
            }
        }
    }

    private void checkCoreLogFile(File file) {
        if (this.mCoreLogLine >= 50000 && this.mCoreLogBW != null && file.length() > 10485760) {
            this.mCoreLogLine = 0;
            try {
                this.mCoreLogBW.flush();
                this.mCoreLogBW.close();
                this.mCoreLogBW = null;
            } catch (IOException e) {
                this.mCoreLogBW = null;
                g gVar = g.EYE_SPY;
                if (gVar.c()) {
                    gVar.c("checkCoreLogFile", e.getLocalizedMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAddCoreLog(int i, String str) {
        File file;
        boolean z;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2;
        if (getCoreLogDir() == null) {
            return;
        }
        if (4 == i) {
            file = new File(getCoreLogDir() + File.separator + "naviAllLog");
            checkAllLogFile(file);
        } else {
            File file2 = new File(getCoreLogDir() + File.separator + "naviCoreLog_" + new SimpleDateFormat("yyyyMMdd").format(new Date()));
            checkCoreLogFile(file2);
            file = file2;
        }
        if (!file.exists()) {
            try {
                ensureFileNum();
                if (!file.createNewFile()) {
                    file = null;
                }
                z = true;
            } catch (Exception e) {
                g gVar = g.EYE_SPY;
                if (gVar.c()) {
                    gVar.c("doAddCoreLog", e.getLocalizedMessage());
                }
                file = null;
            }
            if (file == null && file.exists()) {
                if (this.mCoreLogSDF == null) {
                    this.mCoreLogSDF = new SimpleDateFormat("HH:mm:ss:SSS");
                }
                if (4 == i) {
                    if (this.mCoreLogBWForAllLog == null) {
                        try {
                            this.mAllCoreLogLine = 0;
                            this.mCoreLogBWForAllLog = new BufferedWriter(new FileWriter(file));
                        } catch (IOException e2) {
                            this.mCoreLogBWForAllLog = null;
                            g gVar2 = g.EYE_SPY;
                            if (gVar2.c()) {
                                gVar2.c("doAddCoreLog", e2.getLocalizedMessage());
                            }
                        }
                    }
                    if (this.mCoreLogSDF != null && (bufferedWriter2 = this.mCoreLogBWForAllLog) != null) {
                        try {
                            this.mAllCoreLogLine++;
                            bufferedWriter2.append((CharSequence) (this.mCoreLogSDF.format(new Date()) + " " + str + "\n"));
                            this.mCoreLogBWForAllLog.flush();
                            return;
                        } catch (IOException e3) {
                            this.mCoreLogBWForAllLog = null;
                            g gVar3 = g.EYE_SPY;
                            if (gVar3.c()) {
                                gVar3.c("doAddCoreLog", e3.getLocalizedMessage());
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (this.mCoreLogBW == null || z) {
                    try {
                        this.mCoreLogLine = 0;
                        this.mCoreLogBW = new BufferedWriter(new FileWriter(file));
                    } catch (IOException e4) {
                        this.mCoreLogBW = null;
                        g gVar4 = g.EYE_SPY;
                        if (gVar4.c()) {
                            gVar4.c("doAddCoreLog", e4.getLocalizedMessage());
                        }
                    }
                }
                if (this.mCoreLogSDF != null && (bufferedWriter = this.mCoreLogBW) != null) {
                    try {
                        bufferedWriter.append((CharSequence) (this.mCoreLogSDF.format(new Date()) + " " + str + "\n"));
                        this.mCoreLogLine = this.mCoreLogLine + 1;
                        this.mCoreLogBW.flush();
                        return;
                    } catch (IOException e5) {
                        this.mCoreLogBW = null;
                        g gVar5 = g.EYE_SPY;
                        if (gVar5.c()) {
                            gVar5.c("doAddCoreLog", e5.getLocalizedMessage());
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        z = false;
        if (file == null) {
        }
    }

    public static void end(String str) {
        end(null, str);
    }

    private void ensureFileNum() {
        try {
            File[] listFiles = new File(getCoreLogDir()).listFiles();
            if (listFiles != null && listFiles.length > 3) {
                for (int i = 0; i < listFiles.length - 3; i++) {
                    File findOldestFile = findOldestFile(getCoreLogDir());
                    if (findOldestFile != null) {
                        findOldestFile.delete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private File findOldestFile(String str) {
        File[] listFiles = new File(str).listFiles();
        File file = null;
        if (listFiles == null) {
            return null;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            Date parse = simpleDateFormat.parse("99999999");
            for (File file2 : listFiles) {
                if (file2.getName().contains("naviCoreLog")) {
                    Date parse2 = simpleDateFormat.parse(file2.getName().substring(12));
                    if (parse2.compareTo(parse) < 0) {
                        file = file2;
                        parse = parse2;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return file;
    }

    public static SDKDebugFileUtil get(String str) {
        return get(null, str, true, true);
    }

    public static String getEngineNetLogPath() {
        return sSDCardPath + File.separator + "netUrlLog.txt";
    }

    public static SDKDebugFileUtil getInstance() {
        if (sInstance == null) {
            synchronized (SDKDebugFileUtil.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new SDKDebugFileUtil();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public static List<String> getKeyFileList(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(str).listFiles();
        int length = listFiles.length;
        for (int i = 0; i < length; i++) {
            if (listFiles[i].getName().contains(str2)) {
                String absolutePath = listFiles[i].getAbsolutePath();
                String str3 = actionLogFilePath;
                if (str3 == null || !str3.equals(absolutePath)) {
                    arrayList.add(absolutePath);
                }
            }
        }
        return arrayList;
    }

    public static String getSdkLogFilePath() {
        if (!TextUtils.isEmpty(sSDCardPath)) {
            return sSDCardPath + File.separator + "log";
        }
        return null;
    }

    public static void setModuleFileName(String str) {
        sModuleFileName = str;
    }

    public static void setSDCardPath(String str) {
        sSDCardPath = str;
    }

    public void add(String str) {
        BufferedWriter bufferedWriter = this.mBW;
        if (bufferedWriter == null) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            if (this.mHasTime) {
                str = this.mSDF.format(new Date()) + " # " + str;
            }
            sb.append(str);
            sb.append("\n");
            bufferedWriter.append((CharSequence) sb.toString());
            this.mBW.flush();
        } catch (IOException unused) {
        }
    }

    public void addCoreLog(String str, String str2) {
        int i;
        if (!this.mCoreLogRecordEnable) {
            return;
        }
        g gVar = g.COMMON;
        if (gVar.a()) {
            gVar.a(str, str2);
            return;
        }
        if ("GPS: ".equals(str)) {
            i = 2;
        } else if ("TTS: ".equals(str)) {
            i = 3;
        } else if ("ALL: ".equals(str)) {
            i = 4;
        } else {
            i = 1;
        }
        if (LogUtil.LOGGABLE) {
            Log.e(str, str2);
        }
        mDebugFileThread.a(300, hashCode(), i, str + str2, 0L);
    }

    public void asyncAdd(String str) {
        String str2;
        SimpleDateFormat simpleDateFormat;
        if (this.mHasTime && (simpleDateFormat = this.mSDF) != null) {
            str2 = simpleDateFormat.format(new Date());
        } else {
            str2 = "";
        }
        String str3 = Process.myPid() + " " + Process.myTid();
        e eVar = mDebugFileThread;
        int hashCode = hashCode();
        if (!TextUtils.isEmpty(str2)) {
            str = str2 + "###" + str3 + "###" + str;
        }
        eVar.a(303, hashCode, 0, str, 0L);
    }

    public void asyncAddV2(String str) {
        mDebugFileThread.a(303, hashCode(), 0, str, 0L);
    }

    public void doAsyncAdd(String str) {
        BufferedWriter bufferedWriter = this.mBW;
        if (bufferedWriter == null) {
            return;
        }
        try {
            bufferedWriter.append((CharSequence) str).append((CharSequence) "\n");
            this.mBW.flush();
        } catch (IOException unused) {
        }
    }

    public void forceAdd(String str) {
        if (mDebugFileThread.a() != null) {
            mDebugFileThread.a().post(new b(str));
        }
    }

    public String getCoreLogDir() {
        try {
            File file = this.mCoreLogDir;
            if ((file == null || !file.exists() || !this.mCoreLogDir.isDirectory()) && !TextUtils.isEmpty(sModuleFileName)) {
                File file2 = new File(sModuleFileName + File.separator + "NaviCoreLog");
                this.mCoreLogDir = file2;
                if (!file2.exists()) {
                    this.mCoreLogDir.mkdirs();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file3 = this.mCoreLogDir;
        if (file3 != null) {
            return file3.getAbsolutePath();
        }
        return null;
    }

    public File getFile() {
        return this.mFile;
    }

    public String getKey() {
        return this.mFilePath + this.mFileName;
    }

    public boolean isShowCoreLog(int i, int i2, int i3, String str, Object obj) {
        if (!this.mCoreLogRecordEnable) {
            return false;
        }
        if (i != 2) {
            if (i != 3 || i2 != 0 || i3 == 1) {
                return false;
            }
        } else if (i2 != 0) {
            if (i2 != 1) {
                return false;
            }
            if (i3 >= 3) {
                if (System.currentTimeMillis() - this.normalLastTimeGPS2 <= this.TIME_INTERVAL) {
                    return false;
                }
                this.normalLastTimeGPS2 = System.currentTimeMillis();
                this.noNormalLastTimeGPS2 = 0L;
            } else {
                if (System.currentTimeMillis() - this.noNormalLastTimeGPS2 <= this.TIME_INTERVAL) {
                    return false;
                }
                this.noNormalLastTimeGPS2 = System.currentTimeMillis();
                this.normalLastTimeGPS2 = 0L;
            }
        } else if (i3 >= 3) {
            if (System.currentTimeMillis() - this.normalLastTimeGPS1 <= this.TIME_INTERVAL) {
                return false;
            }
            this.normalLastTimeGPS1 = System.currentTimeMillis();
            this.noNormalLastTimeGPS1 = 0L;
        } else {
            if (System.currentTimeMillis() - this.noNormalLastTimeGPS1 <= this.TIME_INTERVAL) {
                return false;
            }
            this.noNormalLastTimeGPS1 = System.currentTimeMillis();
            this.normalLastTimeGPS1 = 0L;
        }
        return true;
    }

    public boolean isValid() {
        File file = this.mFile;
        if (file != null && file.exists() && this.mFile.isFile()) {
            return true;
        }
        mDebugFileThread.b(this.mChildThreadCallback);
        return false;
    }

    public void setCoreLogRecordEnable(boolean z) {
        this.mCoreLogRecordEnable = z;
    }

    public void uploadLogFile(int i, boolean z, boolean z2, long j) {
    }

    public static void end(String str, String str2) {
        SDKDebugFileUtil sDKDebugFileUtil;
        BufferedWriter bufferedWriter;
        String key = getKey(str, str2);
        if (!sFiles.containsKey(key) || (sDKDebugFileUtil = sFiles.get(key)) == null || (bufferedWriter = sDKDebugFileUtil.mBW) == null) {
            return;
        }
        try {
            bufferedWriter.flush();
            sDKDebugFileUtil.mBW.close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            sFiles.remove(key);
            throw th;
        }
        sFiles.remove(key);
    }

    public static SDKDebugFileUtil get(String str, boolean z, boolean z2) {
        return get(null, str, z, z2);
    }

    public static String getKey(String str, String str2) {
        if ((str == null || str.length() == 0) && !TextUtils.isEmpty(sSDCardPath)) {
            str = sSDCardPath + File.separator + "log";
        }
        return str + str2;
    }

    public static SDKDebugFileUtil get(String str, String str2, boolean z) {
        return get(str, str2, true, z);
    }

    /* loaded from: classes7.dex */
    public class a extends e.b {
        public a() {
        }

        @Override // com.baidu.navisdk.debug.e.b
        public void a(Message message) {
            if (message.arg1 != SDKDebugFileUtil.this.hashCode()) {
                return;
            }
            int i = message.what;
            if (i == 300) {
                SDKDebugFileUtil.this.doAddCoreLog(message.arg2, (String) message.obj);
            } else {
                if (i != 303) {
                    return;
                }
                SDKDebugFileUtil.this.doAsyncAdd((String) message.obj);
            }
        }

        @Override // com.baidu.navisdk.debug.e.b
        public void a() {
            a(300);
            a(303);
        }
    }

    public static synchronized SDKDebugFileUtil get(String str, String str2, boolean z, boolean z2) {
        synchronized (SDKDebugFileUtil.class) {
            String key = getKey(str, str2);
            if (sFiles.containsKey(key)) {
                SDKDebugFileUtil sDKDebugFileUtil = sFiles.get(key);
                if (sDKDebugFileUtil != null && sDKDebugFileUtil.isValid()) {
                    return sDKDebugFileUtil;
                }
                sFiles.remove(key);
            }
            SDKDebugFileUtil sDKDebugFileUtil2 = new SDKDebugFileUtil(str, str2, z, z2);
            File file = sDKDebugFileUtil2.mFile;
            if (file != null) {
                actionLogFilePath = file.getAbsolutePath();
            }
            return sDKDebugFileUtil2;
        }
    }

    private SDKDebugFileUtil(String str, String str2, boolean z, boolean z2) {
        String str3;
        this.mCoreLogDir = null;
        this.mCoreLogBW = null;
        this.mCoreLogBWForAllLog = null;
        this.mCoreLogSDF = null;
        this.normalLastTimeGPS1 = 0L;
        this.noNormalLastTimeGPS1 = 0L;
        this.normalLastTimeGPS2 = 0L;
        this.noNormalLastTimeGPS2 = 0L;
        this.TIME_INTERVAL = 30000L;
        this.mAllCoreLogLine = 0;
        this.mCoreLogLine = 0;
        this.mFilePath = null;
        this.mFileName = null;
        this.mAddFileNameTime = true;
        this.mHasTime = true;
        this.mFile = null;
        this.mBW = null;
        this.mSDF = null;
        this.mCoreLogRecordEnable = true;
        this.mChildThreadCallback = new a();
        this.mFilePath = str;
        this.mFileName = str2;
        this.mAddFileNameTime = z;
        this.mHasTime = z2;
        if ((str == null || str.length() == 0) && !TextUtils.isEmpty(sSDCardPath)) {
            this.mFilePath = sSDCardPath + File.separator + "log";
        }
        if (this.mFilePath != null && this.mFileName != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HH");
            this.mSDF = simpleDateFormat;
            String format = simpleDateFormat.format(new Date());
            StringBuilder sb = new StringBuilder();
            sb.append(this.mFilePath);
            sb.append(File.separator);
            sb.append(this.mFileName);
            if (this.mAddFileNameTime) {
                str3 = "_" + format;
            } else {
                str3 = "";
            }
            sb.append(str3);
            sb.append(".txt");
            File file = new File(sb.toString());
            this.mFile = file;
            try {
                if (!file.getParentFile().exists()) {
                    this.mFile.getParentFile().mkdirs();
                }
            } catch (Exception unused) {
                this.mFile = null;
            }
            if (!this.mFile.exists()) {
                try {
                    if (!this.mFile.createNewFile()) {
                        this.mFile = null;
                    }
                } catch (IOException unused2) {
                    this.mFile = null;
                }
            }
        } else {
            this.mFile = null;
        }
        if (this.mFile != null) {
            this.mSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            try {
                this.mBW = new BufferedWriter(new FileWriter(this.mFile, true));
                sFiles.put(getKey(), this);
                mDebugFileThread.a(this.mChildThreadCallback);
            } catch (IOException unused3) {
                this.mSDF = null;
                this.mFile = null;
                this.mBW = null;
            }
        }
    }
}
