package com.ss.android.socialbase.downloader.d;

import XIXIX.OOXIXo;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.i;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class a {
    public static void a(DownloadTask downloadTask, BaseException baseException, int i) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            x monitorDepend = downloadTask.getMonitorDepend();
            boolean isMonitorStatus = DownloadStatus.isMonitorStatus(i);
            if (!isMonitorStatus && !(isMonitorStatus = a(downloadInfo.getExtraMonitorStatus(), i)) && monitorDepend != null && (monitorDepend instanceof com.ss.android.socialbase.downloader.depend.c)) {
                isMonitorStatus = a(((com.ss.android.socialbase.downloader.depend.c) monitorDepend).a(), i);
            }
            if (isMonitorStatus) {
                try {
                    n depend = downloadTask.getDepend();
                    if (depend != null) {
                        depend.a(downloadInfo, baseException, i);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                a(monitorDepend, downloadInfo, baseException, i);
                a(com.ss.android.socialbase.downloader.downloader.c.g(), downloadInfo, baseException, i);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private static boolean a(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void a(x xVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (xVar == null) {
            return;
        }
        try {
            String b = xVar.b();
            if (TextUtils.isEmpty(b)) {
                b = "default";
            }
            JSONObject a2 = a(b, downloadInfo, baseException, i);
            if (a2 == null) {
                a2 = new JSONObject();
            }
            xVar.a(a2);
        } catch (Throwable unused) {
        }
    }

    public static void a(b bVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (bVar == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject a2 = a(downloadInfo.getMonitorScene(), downloadInfo, baseException, i);
            if (a2 == null) {
                a2 = new JSONObject();
            }
            if (i == -1) {
                a2.put("status", baseException.getErrorCode());
                bVar.a("download_failed", a2, null, null);
            } else {
                a(i, a2, downloadInfo);
                bVar.a("download_common", a2, null, null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(int i, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        if (i == -5) {
            str = "download_uncomplete";
        } else if (i == -4) {
            str = "download_cancel";
        } else if (i == -3) {
            double downloadSpeed = downloadInfo.getDownloadSpeed();
            if (downloadSpeed >= OOXIXo.f3760XO) {
                jSONObject.put("download_speed", downloadSpeed);
            }
            str = "download_success";
        } else if (i == -2) {
            str = "download_pause";
        } else if (i == 0) {
            str = "download_create";
        } else if (i == 2) {
            str = "download_start";
        } else if (i != 6) {
            str = "";
        } else {
            str = "download_first_start";
        }
        jSONObject.put("status", str);
    }

    public static String a(String str) {
        try {
            if (TextUtils.isDigitsOnly(str)) {
                return String.valueOf(Long.valueOf(str).longValue() % 100);
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static JSONObject a(String str, DownloadInfo downloadInfo, BaseException baseException, int i) {
        String str2;
        Object obj;
        Object obj2;
        int i2;
        Object obj3;
        String str3;
        String str4;
        String str5;
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                q k = com.ss.android.socialbase.downloader.downloader.c.k();
                if (k == null) {
                    str2 = "";
                    obj = str2;
                    obj2 = obj;
                    i2 = 0;
                } else {
                    str2 = k.b();
                    obj = a(str2);
                    obj2 = k.a();
                    i2 = k.c();
                }
                if (baseException == null || !(baseException instanceof g)) {
                    obj3 = "";
                } else {
                    obj3 = ((g) baseException).a();
                }
                jSONObject2.put("event_page", str);
                jSONObject2.put("app_id", obj2);
                jSONObject2.put("device_id", str2);
                jSONObject2.put("device_id_postfix", obj);
                jSONObject2.put("update_version", i2);
                jSONObject2.put("download_status", i);
                if (downloadInfo != null) {
                    jSONObject2.put("setting_tag", com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).c("setting_tag"));
                    jSONObject2.put("download_id", downloadInfo.getId());
                    jSONObject2.put("name", downloadInfo.getName());
                    jSONObject2.put("url", downloadInfo.getUrl());
                    jSONObject2.put("save_path", downloadInfo.getSavePath());
                    jSONObject2.put("download_time", downloadInfo.getDownloadTime());
                    jSONObject2.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject2.put("total_bytes", downloadInfo.getTotalBytes());
                    jSONObject2.put("network_quality", downloadInfo.getNetworkQuality());
                    jSONObject2.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject2.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                    jSONObject2.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                    jSONObject2.put("md5", downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                    jSONObject2.put("chunk_count", downloadInfo.getChunkCount());
                    jSONObject2.put("is_force", downloadInfo.isForce() ? 1 : 0);
                    jSONObject2.put("retry_count", downloadInfo.getRetryCount());
                    jSONObject2.put("cur_retry_time", downloadInfo.getCurRetryTime());
                    jSONObject2.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                    jSONObject2.put("need_reuse_first_connection", downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                    jSONObject2.put("default_http_service_backup", downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                    jSONObject2.put("retry_delay_status", downloadInfo.getRetryDelayStatus().ordinal());
                    jSONObject2.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                    jSONObject2.put("download_byte_error_retry_status", downloadInfo.getByteInvalidRetryStatus().ordinal());
                    jSONObject2.put("forbidden_handler_status", downloadInfo.getAsyncHandleStatus().ordinal());
                    jSONObject2.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                    jSONObject2.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                    jSONObject2.put("extra", downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                    jSONObject2.put("add_listener_to_same_task", downloadInfo.isAddListenerToSameTask() ? 1 : 0);
                    jSONObject2.put("backup_url_count", downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                    jSONObject2.put("cur_backup_url_index", downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                    jSONObject2.put("forbidden_urls", downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                    jSONObject2.put("task_id", TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
                    try {
                        String url = downloadInfo.getUrl();
                        if (TextUtils.isEmpty(url)) {
                            str3 = "";
                            str4 = str3;
                            str5 = str4;
                        } else {
                            Uri parse = Uri.parse(url);
                            str4 = parse.getHost();
                            str5 = parse.getPath();
                            str3 = parse.getLastPathSegment();
                            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str3)) {
                                try {
                                    str5 = str5.substring(0, str5.length() - str3.length());
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        }
                        jSONObject2.put("url_host", str4);
                        jSONObject2.put("url_path", str5);
                        jSONObject2.put("url_last_path_segment", str3);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                jSONObject2.put("error_code", baseException != null ? baseException.getErrorCode() : 0);
                jSONObject2.put("error_msg", baseException != null ? baseException.getErrorMessage() : "");
                jSONObject2.put("request_log", obj3);
                return jSONObject2;
            } catch (JSONException e) {
                e = e;
                jSONObject = jSONObject2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:11|(4:71|72|73|(16:75|76|14|(2:52|(1:(2:60|(1:62)(2:63|64)))(1:57))|17|18|(2:22|23)|26|27|28|(1:30)|31|32|(1:44)|35|(2:39|41)(1:38)))|13|14|(0)|52|(1:54)|(0)|17|18|(3:20|22|23)|26|27|28|(0)|31|32|(0)|42|44|35|(0)|39|41) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0103, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011f, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f1 A[Catch: all -> 0x003d, JSONException -> 0x0103, TryCatch #0 {JSONException -> 0x0103, blocks: (B:28:0x00b0, B:30:0x00f1, B:31:0x0105), top: B:27:0x00b0, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x005c A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #4 {all -> 0x003d, blocks: (B:73:0x0030, B:75:0x0034, B:18:0x0082, B:20:0x0098, B:26:0x00ab, B:28:0x00b0, B:30:0x00f1, B:31:0x0105, B:39:0x0138, B:42:0x012a, B:44:0x0130, B:48:0x011f, B:52:0x004b, B:54:0x0051, B:60:0x005c, B:64:0x006a, B:68:0x0070, B:70:0x007c, B:80:0x002d, B:72:0x0026), top: B:71:0x0026, inners: #0, #1, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(@androidx.annotation.Nullable com.ss.android.socialbase.downloader.network.g r14, java.lang.String r15, java.lang.String r16, long r17, java.lang.String r19, int r20, java.io.IOException r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.d.a.a(com.ss.android.socialbase.downloader.network.g, java.lang.String, java.lang.String, long, java.lang.String, int, java.io.IOException, com.ss.android.socialbase.downloader.model.DownloadInfo):void");
    }

    public static void a(com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str, i iVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        a("download_io", aVar.b("monitor_download_io"), aVar, downloadInfo, str, null, null, iVar, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
    }

    public static void a(com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, i iVar, BaseException baseException, long j, long j2) {
        a("segment_io", aVar.b("monitor_segment_io"), aVar, downloadInfo, str, str2, str3, iVar, z, false, baseException, j, j2, false, -1L, -1L, -1L, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073 A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:6:0x0017, B:8:0x002e, B:18:0x0068, B:20:0x0073, B:22:0x0082, B:23:0x008c, B:27:0x0099, B:29:0x009d, B:30:0x00a3, B:32:0x00a7, B:34:0x00ba, B:36:0x010c, B:37:0x011d, B:39:0x012f, B:41:0x0138, B:42:0x0156, B:51:0x018a, B:54:0x0175, B:56:0x017b, B:63:0x0053, B:66:0x0064, B:67:0x0060), top: B:5:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010c A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:6:0x0017, B:8:0x002e, B:18:0x0068, B:20:0x0073, B:22:0x0082, B:23:0x008c, B:27:0x0099, B:29:0x009d, B:30:0x00a3, B:32:0x00a7, B:34:0x00ba, B:36:0x010c, B:37:0x011d, B:39:0x012f, B:41:0x0138, B:42:0x0156, B:51:0x018a, B:54:0x0175, B:56:0x017b, B:63:0x0053, B:66:0x0064, B:67:0x0060), top: B:5:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012f A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:6:0x0017, B:8:0x002e, B:18:0x0068, B:20:0x0073, B:22:0x0082, B:23:0x008c, B:27:0x0099, B:29:0x009d, B:30:0x00a3, B:32:0x00a7, B:34:0x00ba, B:36:0x010c, B:37:0x011d, B:39:0x012f, B:41:0x0138, B:42:0x0156, B:51:0x018a, B:54:0x0175, B:56:0x017b, B:63:0x0053, B:66:0x0064, B:67:0x0060), top: B:5:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0138 A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:6:0x0017, B:8:0x002e, B:18:0x0068, B:20:0x0073, B:22:0x0082, B:23:0x008c, B:27:0x0099, B:29:0x009d, B:30:0x00a3, B:32:0x00a7, B:34:0x00ba, B:36:0x010c, B:37:0x011d, B:39:0x012f, B:41:0x0138, B:42:0x0156, B:51:0x018a, B:54:0x0175, B:56:0x017b, B:63:0x0053, B:66:0x0064, B:67:0x0060), top: B:5:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0188 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017b A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:6:0x0017, B:8:0x002e, B:18:0x0068, B:20:0x0073, B:22:0x0082, B:23:0x008c, B:27:0x0099, B:29:0x009d, B:30:0x00a3, B:32:0x00a7, B:34:0x00ba, B:36:0x010c, B:37:0x011d, B:39:0x012f, B:41:0x0138, B:42:0x0156, B:51:0x018a, B:54:0x0175, B:56:0x017b, B:63:0x0053, B:66:0x0064, B:67:0x0060), top: B:5:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b4  */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.lang.String r19, int r20, com.ss.android.socialbase.downloader.g.a r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, com.ss.android.socialbase.downloader.network.i r26, boolean r27, boolean r28, com.ss.android.socialbase.downloader.exception.BaseException r29, long r30, long r32, boolean r34, long r35, long r37, long r39, org.json.JSONObject r41) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.d.a.a(java.lang.String, int, com.ss.android.socialbase.downloader.g.a, com.ss.android.socialbase.downloader.model.DownloadInfo, java.lang.String, java.lang.String, java.lang.String, com.ss.android.socialbase.downloader.network.i, boolean, boolean, com.ss.android.socialbase.downloader.exception.BaseException, long, long, boolean, long, long, long, org.json.JSONObject):void");
    }

    public static void a(DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.f.i> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segments", com.ss.android.socialbase.downloader.f.i.a(list));
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            c Q = com.ss.android.socialbase.downloader.downloader.c.Q();
            if (Q != null) {
                Q.a(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
