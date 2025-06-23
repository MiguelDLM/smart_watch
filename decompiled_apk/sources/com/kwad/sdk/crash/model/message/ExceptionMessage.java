package com.kwad.sdk.crash.model.message;

import OoOoXO0.xoXoI;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.crash.utils.i;
import com.kwad.sdk.crash.utils.j;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public abstract class ExceptionMessage implements b, Serializable {
    private static final long serialVersionUID = -5338556142957298914L;
    public long mCurrentTimeStamp;
    public int mPid;
    public int mTid;
    public long mUsageTimeMills;
    public String mCrashDetail = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    public String mMemoryInfo = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    public String mDiskInfo = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    public String mProcessName = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    public int mExceptionType = 0;
    public String mCrashType = getTypeCommon();
    public String mThreadName = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    public String mIsAppOnForeground = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    public String mLogUUID = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    public String mVirtualApp = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    public String mCustomMsg = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    public String mThreadOverflow = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    public String mFdOverflow = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    public String mTaskId = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    public String mErrorMessage = "";
    public String mVersionCode = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    public boolean mVersionConflict = false;
    public String mAppVersionBeforeLastUpload = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    public String mJNIError = "";
    public String mGCInfo = "";
    public String mLockInfo = "";
    public String mMonitorInfo = "";
    public String mSlowLooper = "";
    public String mSlowOperation = "";
    public String mBuildConfigInfo = "";
    public String mAbi = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    public String mDumpsys = "";
    public int mCrashSource = 0;

    public static final String getSdkCrashVersionName(String str, int i) {
        return str + HelpFormatter.DEFAULT_OPT_PREFIX + i;
    }

    public static final String getSdkVersionNameSuffix(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return "";
                        }
                        return "-car";
                    }
                    return "-pct";
                }
                return "-ec";
            }
            return "-ct";
        }
        return "-ad";
    }

    private void setIsForeground() {
        String str;
        try {
            com.kwad.sdk.core.c.b.En();
            if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                str = "Foreground";
            } else {
                str = "Background";
            }
            this.mIsAppOnForeground = str;
        } catch (Exception unused) {
        }
    }

    public String getReportMsg() {
        return "UUID=" + this.mLogUUID + ",crashTime=" + i.aE(this.mCurrentTimeStamp) + ",customMsg=" + this.mCustomMsg;
    }

    public final String getTypeCommon() {
        return getTypePrefix() + "COMMON";
    }

    public final String getTypeFdOOM() {
        return getTypePrefix() + "FD_OOM";
    }

    public final String getTypeHeapOOM() {
        return getTypePrefix() + "HEAP_OOM";
    }

    public abstract String getTypePrefix();

    public final String getTypeThreadOOM() {
        return getTypePrefix() + "THREAD_OOM";
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mCrashDetail = jSONObject.optString("mCrashDetail");
        this.mMemoryInfo = jSONObject.optString("mMemoryInfo");
        this.mDiskInfo = jSONObject.optString("mDiskInfo");
        this.mProcessName = jSONObject.optString("mProcessName");
        this.mCrashType = jSONObject.optString("mCrashType");
        this.mThreadName = jSONObject.optString("mThreadName");
        this.mIsAppOnForeground = jSONObject.optString("mIsAppOnForeground");
        this.mLogUUID = jSONObject.optString("mLogUUID");
        this.mVirtualApp = jSONObject.optString("mVirtualApp");
        this.mCustomMsg = jSONObject.optString("mCustomMsg");
        this.mThreadOverflow = jSONObject.optString("mThreadOverflow");
        this.mFdOverflow = jSONObject.optString("mFdOverflow");
        this.mTaskId = jSONObject.optString("mTaskId");
        this.mErrorMessage = jSONObject.optString("mErrorMessage");
        this.mCurrentTimeStamp = jSONObject.optLong("mCurrentTimeStamp");
        this.mUsageTimeMills = jSONObject.optLong("mUsageTimeMills");
        this.mPid = jSONObject.optInt("mPid");
        this.mTid = jSONObject.optInt("mTid");
        this.mVersionCode = jSONObject.optString("mVersionCode");
        this.mVersionConflict = jSONObject.optBoolean("mVersionConflict");
        this.mAppVersionBeforeLastUpload = jSONObject.optString("mAppVersionBeforeLastUpload");
        this.mJNIError = jSONObject.optString("mJNIError");
        this.mGCInfo = jSONObject.optString("mGCInfo");
        this.mLockInfo = jSONObject.optString("mLockInfo");
        this.mMonitorInfo = jSONObject.optString("mMonitorInfo");
        this.mSlowLooper = jSONObject.optString("mSlowLooper");
        this.mSlowOperation = jSONObject.optString("mSlowOperation");
        this.mBuildConfigInfo = jSONObject.optString("mBuildConfigInfo");
        this.mAbi = jSONObject.optString("mAbi");
        this.mDumpsys = jSONObject.optString("mDumpsys");
        this.mCrashSource = jSONObject.optInt("mCrashSource");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "mCrashDetail", this.mCrashDetail);
        t.putValue(jSONObject, "mMemoryInfo", this.mMemoryInfo);
        t.putValue(jSONObject, "mDiskInfo", this.mDiskInfo);
        t.putValue(jSONObject, "mProcessName", this.mProcessName);
        t.putValue(jSONObject, "mCrashType", this.mCrashType);
        t.putValue(jSONObject, "mThreadName", this.mThreadName);
        setIsForeground();
        t.putValue(jSONObject, "mIsAppOnForeground", this.mIsAppOnForeground);
        t.putValue(jSONObject, "mLogUUID", this.mLogUUID);
        t.putValue(jSONObject, "mVirtualApp", this.mVirtualApp);
        t.putValue(jSONObject, "mCustomMsg", this.mCustomMsg);
        t.putValue(jSONObject, "mThreadOverflow", this.mThreadOverflow);
        t.putValue(jSONObject, "mFdOverflow", this.mFdOverflow);
        t.putValue(jSONObject, "mTaskId", this.mTaskId);
        t.putValue(jSONObject, "mErrorMessage", this.mErrorMessage);
        t.putValue(jSONObject, "mCurrentTimeStamp", this.mCurrentTimeStamp);
        t.putValue(jSONObject, "mUsageTimeMills", this.mUsageTimeMills);
        t.putValue(jSONObject, "mPid", this.mPid);
        t.putValue(jSONObject, "mTid", this.mTid);
        t.putValue(jSONObject, "mVersionCode", this.mVersionCode);
        t.putValue(jSONObject, "mVersionConflict", this.mVersionConflict);
        t.putValue(jSONObject, "mAppVersionBeforeLastUpload", this.mAppVersionBeforeLastUpload);
        t.putValue(jSONObject, "mJNIError", this.mJNIError);
        t.putValue(jSONObject, "mGCInfo", this.mGCInfo);
        t.putValue(jSONObject, "mLockInfo", this.mLockInfo);
        t.putValue(jSONObject, "mMonitorInfo", this.mMonitorInfo);
        t.putValue(jSONObject, "mSlowLooper", this.mSlowLooper);
        t.putValue(jSONObject, "mSlowOperation", this.mSlowOperation);
        t.putValue(jSONObject, "mBuildConfigInfo", this.mBuildConfigInfo);
        t.putValue(jSONObject, "mAbi", this.mAbi);
        t.putValue(jSONObject, "mDumpsys", this.mDumpsys);
        t.putValue(jSONObject, "mCrashSource", this.mCrashSource);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("异常状态汇总:\nUUID: ");
            sb.append(this.mLogUUID);
            sb.append("\nCPU架构: ");
            sb.append(this.mAbi);
            sb.append("\n异常进程: ");
            sb.append(this.mProcessName);
            sb.append(" (");
            sb.append(this.mPid);
            sb.append(")\n");
            sb.append("异常线程: ");
            sb.append(this.mThreadName);
            sb.append(" (");
            sb.append(this.mTid);
            sb.append(")\n");
            sb.append("异常类型: ");
            sb.append(this.mCrashType);
            sb.append("\n应用多开环境: ");
            sb.append(this.mVirtualApp);
            sb.append("\nTaskId: ");
            sb.append(this.mTaskId);
            sb.append("\nmTid: ");
            sb.append(this.mTid);
            sb.append("\n自定义信息: ");
            sb.append(this.mCustomMsg);
            sb.append("\n前后台状态: ");
            sb.append(this.mIsAppOnForeground);
            sb.append("\n异常发生时间: ");
            sb.append(i.aE(this.mCurrentTimeStamp));
            sb.append("\n版本号: ");
            sb.append(this.mVersionCode);
            sb.append("\n升级前版本号: ");
            sb.append(this.mAppVersionBeforeLastUpload);
            sb.append("\n使用时长: ");
            sb.append(j.aF(this.mUsageTimeMills));
            sb.append("\n异常详情: \n");
            if (this instanceof JavaExceptionMessage) {
                sb.append(this.mCrashDetail.replace("##", "\n\t").replace(xoXoI.f2670oxoX, "\n"));
            } else {
                sb.append(this.mCrashDetail);
            }
            sb.append("\n磁盘详情: \n");
            sb.append(this.mDiskInfo);
            sb.append("\n");
            if (!TextUtils.isEmpty(this.mErrorMessage)) {
                sb.append("异常上报Debug: \n");
                sb.append(this.mErrorMessage);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mBuildConfigInfo)) {
                sb.append("BuildConfig信息: \n");
                sb.append(this.mBuildConfigInfo);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mJNIError)) {
                sb.append("JNI异常: \n");
                sb.append(this.mJNIError);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mGCInfo)) {
                sb.append("GC耗时: \n");
                sb.append(this.mGCInfo);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mLockInfo)) {
                sb.append("锁耗时(dvm_lock_sample): \n");
                sb.append(this.mLockInfo);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mMonitorInfo)) {
                sb.append("锁耗时(monitor): \n");
                sb.append(this.mMonitorInfo);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mSlowLooper)) {
                sb.append("Looper耗时: \n");
                sb.append(this.mSlowLooper);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mSlowOperation)) {
                sb.append("AMS调度耗时: \n");
                sb.append(this.mSlowOperation);
                sb.append("\n");
            }
            sb.append("内存详情: \n");
            sb.append(this.mMemoryInfo);
            sb.append("\n");
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
        return sb.substring(0);
    }
}
