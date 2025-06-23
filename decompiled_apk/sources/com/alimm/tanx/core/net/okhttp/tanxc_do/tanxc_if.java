package com.alimm.tanx.core.net.okhttp.tanxc_do;

import android.os.Handler;
import android.text.TextUtils;
import com.alimm.tanx.core.net.okhttp.callback.ResultCall;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.utils.AndroidUtils;
import com.alimm.tanx.core.utils.LogUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes.dex */
public class tanxc_if {
    private int tanxc_byte;
    private final OkHttpClient tanxc_case = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_do(false);
    private final Handler tanxc_char = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_for();
    private String tanxc_do;
    private Request tanxc_else;
    private Map<String, String> tanxc_for;
    private String tanxc_if;
    private Map<String, String> tanxc_int;
    private boolean tanxc_new;
    private int tanxc_try;

    public static /* synthetic */ int tanxc_for(tanxc_if tanxc_ifVar) {
        int i = tanxc_ifVar.tanxc_byte;
        tanxc_ifVar.tanxc_byte = i + 1;
        return i;
    }

    public tanxc_if tanxc_do() {
        Request.Builder builder = new Request.Builder();
        Map<String, String> map = this.tanxc_int;
        if (map != null) {
            builder.url(tanxc_do(this.tanxc_do, map));
        } else {
            LogUtils.i("OkHttp ", "请求接口 ==>> " + this.tanxc_do);
            builder.url(this.tanxc_do);
        }
        if (!TextUtils.isEmpty(this.tanxc_if)) {
            builder.tag(this.tanxc_if);
        }
        builder.headers(tanxc_for(this.tanxc_for));
        this.tanxc_else = builder.build();
        return this;
    }

    public tanxc_if tanxc_for(int i) {
        this.tanxc_try = i;
        return this;
    }

    public void tanxc_if() {
        if (this.tanxc_new) {
            if (!TextUtils.isEmpty(this.tanxc_if)) {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_if);
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_do);
            }
        }
    }

    private Headers tanxc_for(Map<String, String> map) {
        Headers.Builder builder = new Headers.Builder();
        if (map == null || map.isEmpty()) {
            map = new HashMap<>();
            map.put("User-Agent", AndroidUtils.getUserAgent());
        }
        for (String str : map.keySet()) {
            builder.add(str, map.get(str));
        }
        return builder.build();
    }

    public tanxc_if tanxc_if(int i) {
        if (i != 0) {
            com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_for.tanxc_do().tanxc_do(i);
        }
        return this;
    }

    public tanxc_if tanxc_if(String str) {
        this.tanxc_if = str;
        return this;
    }

    public tanxc_if tanxc_if(Map<String, String> map) {
        this.tanxc_int = map;
        return this;
    }

    public void tanxc_do(final ResultCall resultCall) {
        if (resultCall != null) {
            LogUtils.i("OkHttp ", "请求方式 ==> GET");
            this.tanxc_char.post(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.1
                @Override // java.lang.Runnable
                public void run() {
                    resultCall.onBefore();
                }
            });
        }
        if (this.tanxc_new) {
            if (!TextUtils.isEmpty(this.tanxc_if)) {
                if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_if)) {
                    if (resultCall != null) {
                        resultCall.onError(UtErrorCode.NETWORK_ONLY_ONE_NET_ERROR_EXCEPTION.getIntCode(), "onlyOneNet error tag:" + this.tanxc_if);
                        return;
                    }
                    return;
                }
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_if);
            } else {
                if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_do)) {
                    if (resultCall != null) {
                        resultCall.onError(UtErrorCode.NETWORK_ONLY_ONE_NET_ERROR_EXCEPTION.getIntCode(), "onlyOneNet error url:" + this.tanxc_do);
                        return;
                    }
                    return;
                }
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_do);
            }
        }
        this.tanxc_case.newCall(this.tanxc_else).enqueue(new Callback() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.2
            @Override // okhttp3.Callback
            public void onFailure(final Call call, final IOException iOException) {
                if (!(iOException instanceof SocketException) && tanxc_if.this.tanxc_byte < tanxc_if.this.tanxc_try && tanxc_if.this.tanxc_try > 0) {
                    tanxc_if.tanxc_for(tanxc_if.this);
                    tanxc_if.this.tanxc_case.newCall(call.request()).enqueue(this);
                } else {
                    tanxc_if.this.tanxc_if();
                    if (resultCall != null) {
                        tanxc_if.this.tanxc_char.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                UtErrorCode utErrorCode;
                                IOException iOException2 = iOException;
                                if (!(iOException2 instanceof SocketException)) {
                                    if (iOException2 instanceof ConnectException) {
                                        utErrorCode = UtErrorCode.NETWORK_CONNECT_EXCEPTION;
                                    } else if (iOException2 instanceof SocketTimeoutException) {
                                        utErrorCode = UtErrorCode.NETWORK_TIMEOUT;
                                    } else {
                                        utErrorCode = UtErrorCode.NETWORK_ERROR;
                                    }
                                    LogUtils.i("OkHttp ", "请求失败原因 ==> " + LogUtils.getStackTraceMessage(iOException));
                                    IOException iOException3 = iOException;
                                    String str = "";
                                    if (iOException3 != null && iOException3.getMessage() != null) {
                                        String message = iOException.getMessage();
                                        try {
                                            str = " --> " + call.request().url().uri().toString();
                                        } catch (Exception unused) {
                                        }
                                        str = message + str;
                                    }
                                    if (TextUtils.isEmpty(str)) {
                                        resultCall.onError(utErrorCode.getIntCode(), utErrorCode.getMsg());
                                    } else {
                                        resultCall.onError(utErrorCode.getIntCode(), str);
                                    }
                                }
                                LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
                                resultCall.onAfter();
                            }
                        }, 10L);
                    }
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                String str;
                tanxc_if.this.tanxc_if();
                int code = response.code();
                LogUtils.i("OkHttp ", "请求code ==> " + code);
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        str = response.body().string();
                    } else {
                        str = "";
                    }
                    LogUtils.i("OkHttp ", str);
                    ResultCall resultCall2 = resultCall;
                    if (resultCall2 != null) {
                        resultCall2.onSuccess(str);
                    }
                } else {
                    String response2 = response.toString();
                    ResultCall resultCall3 = resultCall;
                    if (resultCall3 != null) {
                        resultCall3.onError(code, UtErrorCode.NETWORK_HTTP_CODE_EXCEPTION.getMsg() + "   errorMsg: " + response2);
                    }
                }
                LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
                tanxc_if.this.tanxc_char.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ResultCall resultCall4 = resultCall;
                        if (resultCall4 != null) {
                            resultCall4.onAfter();
                        }
                    }
                }, 10L);
            }
        });
    }

    public tanxc_if tanxc_do(int i) {
        if (i != 0) {
            com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_if.tanxc_do().tanxc_do(i);
        }
        return this;
    }

    public tanxc_if tanxc_do(String str) {
        this.tanxc_do = str;
        return this;
    }

    public tanxc_if tanxc_do(boolean z) {
        this.tanxc_new = z;
        return this;
    }

    public tanxc_if tanxc_do(Map<String, String> map) {
        this.tanxc_for = map;
        return this;
    }

    private String tanxc_do(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (str.indexOf(LocationInfo.NA) == -1) {
            sb.append(str + LocationInfo.NA);
        } else {
            sb.append(str + "&");
        }
        if (map != null && !map.isEmpty()) {
            for (String str2 : map.keySet()) {
                sb.append(str2);
                sb.append("=");
                sb.append(map.get(str2));
                sb.append("&");
            }
        }
        StringBuilder deleteCharAt = sb.deleteCharAt(sb.length() - 1);
        LogUtils.i("OkHttp ", "请求接口 ==>> " + deleteCharAt.toString());
        return deleteCharAt.toString();
    }
}
