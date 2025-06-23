package com.adp.sdk;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.adp.sdk.dto.AlyLogDTO;
import com.adp.sdk.dto.SourceVO;
import com.aliyun.sls.android.producer.Log;
import com.aliyun.sls.android.producer.LogProducerCallback;
import com.aliyun.sls.android.producer.LogProducerClient;
import com.aliyun.sls.android.producer.LogProducerConfig;
import com.baidu.ar.constants.HttpConstants;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.sma.smartv3.network.BaiDu;
import java.io.File;
import xIoXXXIXo.O0xOxO;

/* loaded from: classes.dex */
public class c {
    private static c c = null;
    private static boolean d = false;

    /* renamed from: a, reason: collision with root package name */
    private LogProducerConfig f4706a;
    private LogProducerClient b;

    /* loaded from: classes.dex */
    public class a implements LogProducerCallback {
        public a(c cVar) {
        }

        @Override // com.aliyun.sls.android.producer.LogProducerCallback
        public void onCall(int i, String str, String str2, int i2, int i3) {
        }
    }

    private c() {
    }

    public static c a() {
        if (c == null) {
            c = new c();
        }
        return c;
    }

    private void b(AlyLogDTO alyLogDTO, Context context) {
        try {
            Log a2 = a(context, alyLogDTO);
            LogProducerClient logProducerClient = this.b;
            if (logProducerClient != null) {
                logProducerClient.addLog(a2, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(Context context, String str) {
        c a2 = a();
        AlyLogDTO a3 = a2.a(context, "0", null, null);
        a3.setQuantity_request("1");
        a3.setQuantity_request_valid("1");
        a3.setRequest_error(str);
        a2.b(a3, context);
    }

    public void d(Context context, String str, String str2, String str3, String str4) {
        c a2 = a();
        AlyLogDTO a3 = a2.a(context, str3, str, str4);
        a3.setReal_request_valid("1");
        a3.setShow_ad(str2);
        a2.a(a3, context);
    }

    public void e(Context context, String str, String str2, String str3, String str4) {
        c a2 = a();
        AlyLogDTO a3 = a2.a(context, str3, str, str4);
        a3.setReal_request("1");
        a3.setShow_ad(str2);
        a2.a(a3, context);
    }

    public void f(Context context, String str, String str2, String str3, String str4) {
        c a2 = a();
        AlyLogDTO a3 = a2.a(context, str3, str, str4);
        a3.setReal_reward("1");
        a3.setShow_ad(str2);
        a2.a(a3, context);
    }

    public void g(Context context, String str, String str2, String str3, String str4) {
        c a2 = a();
        AlyLogDTO a3 = a2.a(context, str3, str, str4);
        a3.setReal_show("1");
        a3.setShow_ad(str2);
        a2.a(a3, context);
    }

    public void h(Context context, String str, String str2, String str3, String str4) {
        c a2 = a();
        AlyLogDTO a3 = a2.a(context, str3, str, str4);
        a3.setQuantity_request("1");
        a3.setShow_ad(str2);
        a2.a(a3, context);
    }

    public void i(Context context, String str, String str2, String str3, String str4) {
        c a2 = a();
        AlyLogDTO a3 = a2.a(context, str3, str, str4);
        a3.setQuantity_reward("1");
        a3.setShow_ad(str2);
        a2.a(a3, context);
    }

    public void j(Context context, String str, String str2, String str3, String str4) {
        c a2 = a();
        AlyLogDTO a3 = a2.a(context, str3, str, str4);
        a3.setQuantity_show("1");
        a3.setShow_ad(str2);
        a2.a(a3, context);
    }

    public synchronized void a(Context context, String str) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (d) {
            return;
        }
        LogProducerConfig logProducerConfig = new LogProducerConfig("https://cn-guangzhou.log.aliyuncs.com", "adsplus", "adp", new String(Base64.decode("QURQTFRBSTV0NXZtdnJ4YzlqV2ZkRWVmQWg0", 0)).replace("ADP", ""), new String(Base64.decode("QURQRGJOMXRpNkp3ZXAwSlBMclZSS1E1ZG4ycGJ5MzFY", 0)).replace("ADP", ""));
        this.f4706a = logProducerConfig;
        logProducerConfig.setConnectTimeoutSec(20);
        this.f4706a.setSendTimeoutSec(20);
        this.f4706a.setPersistent(1);
        this.f4706a.setPersistentFilePath(context.getFilesDir() + File.separator + str + "adplog.dat");
        this.f4706a.setPersistentForceFlush(1);
        this.f4706a.setPersistentMaxFileCount(10);
        this.f4706a.setPersistentMaxFileSize(O0xOxO.f34202xXxxox0I);
        this.f4706a.setPersistentMaxLogCount(65536);
        this.b = new LogProducerClient(this.f4706a, new a(this));
        d = true;
    }

    public void b(Context context, String str) {
        c a2 = a();
        AlyLogDTO a3 = a2.a(context, "0", null, null);
        a3.setQuantity_request("1");
        a3.setQuantity_request_valid("0");
        a3.setRequest_error(str);
        a2.b(a3, context);
    }

    public void c(Context context, String str, String str2, String str3, String str4) {
        c a2 = a();
        AlyLogDTO a3 = a2.a(context, str3, str, str4);
        a3.setReal_click("1");
        a3.setShow_ad(str2);
        a2.a(a3, context);
    }

    public void b(Context context, String str, String str2, String str3, String str4) {
        c a2 = a();
        AlyLogDTO a3 = a2.a(context, str3, str, str4);
        a3.setQuantity_request_valid("1");
        a3.setShow_ad(str2);
        a2.a(a3, context);
    }

    private void a(AlyLogDTO alyLogDTO, Context context) {
        try {
            if (ADP.isOpenLogsBoolean) {
                Log a2 = a(context, alyLogDTO);
                LogProducerClient logProducerClient = this.b;
                if (logProducerClient != null) {
                    logProducerClient.addLog(a2, 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AlyLogDTO a(Context context, String str, String str2, String str3) {
        AlyLogDTO alyLogDTO = new AlyLogDTO();
        alyLogDTO.setSdk_version(ADP.VERSION);
        alyLogDTO.setApp_version(com.adp.sdk.utils.a.b(context));
        alyLogDTO.setClient_id(com.adp.sdk.utils.a.a(context));
        alyLogDTO.setService_id(ADP.serviceId);
        alyLogDTO.setAd_type(str);
        alyLogDTO.setApp_id(ADP.ADP_APPID);
        alyLogDTO.setSpace_id(str2);
        alyLogDTO.setSource_id(str3);
        return alyLogDTO;
    }

    private Log a(Context context, AlyLogDTO alyLogDTO) {
        Log log = new Log();
        log.putContent("sdk_version", alyLogDTO.getSdk_version());
        log.putContent(HttpConstants.APP_VERSION, alyLogDTO.getApp_version());
        log.putContent("country", (context.getResources().getConfiguration().locale.getCountry() + "").toUpperCase());
        if (alyLogDTO.getService_id() != null && alyLogDTO.getService_id().length() > 0) {
            log.putContent(BaiDu.SERVICE_ID_KEY, alyLogDTO.getService_id());
        }
        if (alyLogDTO.getClient_id() != null && (alyLogDTO.getService_id() == null || alyLogDTO.getService_id().length() == 0)) {
            log.putContent("client_id", alyLogDTO.getClient_id());
        }
        if (alyLogDTO.getApp_id() != null) {
            log.putContent("app_id", alyLogDTO.getApp_id());
        }
        if (alyLogDTO.getSource_id() != null) {
            log.putContent("source_id", alyLogDTO.getSource_id());
        }
        log.putContent("space_id", alyLogDTO.getSpace_id());
        if (alyLogDTO.getQuantity_request() != null) {
            log.putContent("quantity_request", alyLogDTO.getQuantity_request() + "");
        }
        if (alyLogDTO.getReal_request() != null) {
            log.putContent("real_request", alyLogDTO.getReal_request() + "");
        }
        if (alyLogDTO.getQuantity_request_valid() != null) {
            log.putContent("quantity_request_valid", alyLogDTO.getQuantity_request_valid() + "");
        }
        if (alyLogDTO.getQuantity_show() != null) {
            log.putContent("quantity_show", alyLogDTO.getQuantity_show() + "");
        }
        if (alyLogDTO.getQuantity_click() != null) {
            log.putContent("quantity_click", alyLogDTO.getQuantity_click() + "");
        }
        if (alyLogDTO.getReal_request_valid() != null) {
            log.putContent("real_request_valid", alyLogDTO.getReal_request_valid() + "");
        }
        if (alyLogDTO.getReal_show() != null) {
            log.putContent("real_show", alyLogDTO.getReal_show() + "");
        }
        if (alyLogDTO.getReal_click() != null) {
            log.putContent("real_click", alyLogDTO.getReal_click() + "");
        }
        if (alyLogDTO.getDevice() != null) {
            log.putContent(DeviceRequestsHelper.DEVICE_INFO_DEVICE, alyLogDTO.getDevice());
        }
        if (alyLogDTO.getAd_type() != null) {
            log.putContent(AppEventsConstants.EVENT_PARAM_AD_TYPE, alyLogDTO.getAd_type());
        }
        if (alyLogDTO.getShow_ad() != null) {
            log.putContent("show_ad", alyLogDTO.getShow_ad() + "");
        }
        if (alyLogDTO.getQuantity_reward() != null) {
            log.putContent("quantity_reward", alyLogDTO.getQuantity_reward() + "");
        }
        if (alyLogDTO.getReal_reward() != null) {
            log.putContent("real_reward", alyLogDTO.getReal_reward() + "");
        }
        if (alyLogDTO.getRequest_error() != null) {
            log.putContent("request_error", alyLogDTO.getRequest_error() + ("##" + Build.VERSION.RELEASE + " " + Build.MODEL + " " + Build.BRAND));
        }
        return log;
    }

    private boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public void a(Context context, String str, String str2, String str3, String str4) {
        c a2 = a();
        AlyLogDTO a3 = a2.a(context, str3, str, str4);
        a3.setQuantity_click("1");
        a3.setShow_ad(str2);
        a2.a(a3, context);
    }

    public void a(Context context, String str, String str2, String str3, String str4, String str5) {
        c a2 = a();
        AlyLogDTO a3 = a2.a(context, str3, str, str4);
        a3.setReal_request_valid("1");
        a3.setShow_ad(str2);
        a3.setRequest_error(str5);
        a2.a(a3, context);
    }

    public void a(Context context, String str, String str2, String str3, SourceVO sourceVO) {
        if (ADP.isErrorLogs && !a(str2)) {
            AlyLogDTO a2 = a(context, str3, str, sourceVO != null ? sourceVO.getId() : null);
            a2.setRequest_error(str2);
            a(a2, context);
            new com.adp.sdk.utils.d(context).a("splasherrorlogs", "");
        }
    }

    public void a(Context context, String str, String str2, String str3, String str4, SourceVO sourceVO) {
        if (ADP.isErrorLogs && !a(str2)) {
            AlyLogDTO a2 = a(context, str4, str, sourceVO != null ? sourceVO.getId() : null);
            a2.setShow_ad(str3);
            a2.setRequest_error(str2);
            a(a2, context);
            new com.adp.sdk.utils.d(context).a("splasherrorlogs", "");
        }
    }
}
