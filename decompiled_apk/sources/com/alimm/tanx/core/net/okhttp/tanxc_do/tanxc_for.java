package com.alimm.tanx.core.net.okhttp.tanxc_do;

import android.os.Handler;
import android.text.TextUtils;
import com.alimm.tanx.core.net.okhttp.callback.ResultCall;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: classes.dex */
public class tanxc_for {
    private Map<String, String> tanxc_byte;
    private String tanxc_case;
    private boolean tanxc_char;
    private int tanxc_else;
    private int tanxc_goto;
    private MediaType tanxc_if;
    private String tanxc_int;
    private final OkHttpClient tanxc_long;
    private String tanxc_new;
    private final Handler tanxc_this;
    private Map<String, String> tanxc_try;
    private Request tanxc_void;
    private int tanxc_do = 0;
    private final MediaType tanxc_for = MediaType.parse("application/json;charset=utf-8");

    public tanxc_for(boolean z) {
        if (z) {
            this.tanxc_long = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if().tanxc_do(true);
        } else {
            this.tanxc_long = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_do(z);
        }
        this.tanxc_this = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_for();
    }

    public static /* synthetic */ int tanxc_for(tanxc_for tanxc_forVar) {
        int i = tanxc_forVar.tanxc_goto;
        tanxc_forVar.tanxc_goto = i + 1;
        return i;
    }

    public tanxc_for tanxc_do() {
        RequestBody build;
        Request.Builder builder = new Request.Builder();
        tanxc_for();
        builder.url(this.tanxc_int);
        LogUtils.i("OkHttp ", "请求接口 ==> " + this.tanxc_int);
        if (!TextUtils.isEmpty(this.tanxc_new)) {
            builder.tag(this.tanxc_new);
        }
        Map<String, String> map = this.tanxc_try;
        if (map != null) {
            builder.headers(tanxc_for(map));
        }
        int i = this.tanxc_do;
        if (i == 1) {
            FormBody.Builder builder2 = new FormBody.Builder();
            if (this.tanxc_byte != null) {
                LogUtils.i("OkHttp ", "请求参数  键值对 ==> " + this.tanxc_byte);
            }
            tanxc_do(builder2, this.tanxc_byte);
            build = builder2.build();
        } else if (i != 2) {
            build = null;
        } else {
            LogUtils.i("OkHttp ", "请求参数  json ==> " + this.tanxc_case);
            MediaType mediaType = this.tanxc_if;
            if (mediaType == null) {
                mediaType = this.tanxc_for;
            }
            build = RequestBody.create(mediaType, this.tanxc_case);
        }
        builder.post(build);
        this.tanxc_void = builder.build();
        return this;
    }

    public tanxc_for tanxc_for(String str) {
        this.tanxc_case = str;
        return this;
    }

    public void tanxc_if() {
        if (this.tanxc_char) {
            if (!TextUtils.isEmpty(this.tanxc_new)) {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_new);
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_int);
            }
        }
    }

    public Headers tanxc_for(Map<String, String> map) {
        Headers.Builder builder = new Headers.Builder();
        if (map == null || map.isEmpty()) {
            return null;
        }
        for (String str : map.keySet()) {
            builder.add(str, map.get(str));
        }
        return builder.build();
    }

    public tanxc_for tanxc_if(boolean z) {
        this.tanxc_char = z;
        return this;
    }

    public tanxc_for tanxc_if(String str) {
        this.tanxc_new = str;
        return this;
    }

    public void tanxc_for() {
        int i;
        if (this.tanxc_byte != null) {
            this.tanxc_do = 1;
            i = 1;
        } else {
            i = 0;
        }
        if (this.tanxc_case != null) {
            this.tanxc_do = 2;
            i++;
        }
        if (i <= 0 || i > 1) {
            throw new IllegalArgumentException("the params must has one and only one .");
        }
    }

    public tanxc_for tanxc_if(Map<String, String> map) {
        this.tanxc_byte = map;
        return this;
    }

    public Response tanxc_do(boolean z) {
        LogUtils.i("OkHttp ", "请求方式 ==> SYNC_POST");
        Response response = null;
        try {
            if (this.tanxc_char) {
                if (!TextUtils.isEmpty(this.tanxc_new)) {
                    if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_new)) {
                        return null;
                    }
                    com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_new);
                } else {
                    if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_int)) {
                        return null;
                    }
                    com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_int);
                }
            }
            response = this.tanxc_long.newCall(this.tanxc_void).execute();
            tanxc_if();
            LogUtils.i("OkHttp ", "请求code ==> " + response.code());
            LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
            return response;
        } catch (Exception e) {
            if (response != null) {
                LogUtils.e("OkHttp ", "请求异常 ==> " + response.code());
                if (z) {
                    TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "OkHttp ", "请求异常 ==> " + response.code() + LogUtils.getStackTraceMessage(e), "");
                }
            } else if (z) {
                TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "OkHttp ", LogUtils.getStackTraceMessage(e), "");
            }
            LogUtils.e("OkHttp ", e);
            e.printStackTrace();
            return response;
        }
    }

    public void tanxc_do(final ResultCall resultCall) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (resultCall != null) {
            LogUtils.i("OkHttp ", "请求方式 ==> POST");
            this.tanxc_this.post(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.1
                @Override // java.lang.Runnable
                public void run() {
                    resultCall.onBefore();
                }
            });
        }
        if (this.tanxc_char) {
            if (!TextUtils.isEmpty(this.tanxc_new)) {
                if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_new)) {
                    return;
                } else {
                    com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_new);
                }
            } else if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_int)) {
                return;
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_int);
            }
        }
        LogUtils.d("splashTimeConsuming", "netTime onResponse1->" + (System.currentTimeMillis() - currentTimeMillis));
        this.tanxc_long.newCall(this.tanxc_void).enqueue(new Callback() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.2
            @Override // okhttp3.Callback
            public void onFailure(final Call call, final IOException iOException) {
                if (!(iOException instanceof SocketException) && tanxc_for.this.tanxc_goto < tanxc_for.this.tanxc_else && tanxc_for.this.tanxc_else > 0) {
                    tanxc_for.tanxc_for(tanxc_for.this);
                    tanxc_for.this.tanxc_long.newCall(call.request()).enqueue(this);
                } else {
                    tanxc_for.this.tanxc_if();
                    if (resultCall != null) {
                        tanxc_for.this.tanxc_this.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.2.1
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
                                            str = " --> " + call.request().url().uri();
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
                tanxc_for.this.tanxc_if();
                int code = response.code();
                LogUtils.i("OkHttp ", "请求code ==> " + code);
                if (response.isSuccessful()) {
                    LogUtils.d("splashTimeConsuming", "netTime onResponse2->" + (System.currentTimeMillis() - currentTimeMillis));
                    try {
                        str = response.body().string();
                    } catch (Exception e) {
                        LogUtils.e(e);
                        str = "";
                    }
                    LogUtils.i("OkHttp ", str);
                    ResultCall resultCall2 = resultCall;
                    if (resultCall2 != null) {
                        resultCall2.onSuccess(str);
                    }
                    LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
                    tanxc_for.this.tanxc_this.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ResultCall resultCall3 = resultCall;
                            if (resultCall3 != null) {
                                resultCall3.onAfter();
                            }
                        }
                    }, 10L);
                    return;
                }
                String response2 = response.toString();
                ResultCall resultCall3 = resultCall;
                if (resultCall3 != null) {
                    resultCall3.onError(code, UtErrorCode.NETWORK_HTTP_CODE_EXCEPTION.getMsg() + "   errorMsg: " + response2);
                }
            }
        });
    }

    public tanxc_for tanxc_do(int i) {
        this.tanxc_else = i;
        return this;
    }

    public tanxc_for tanxc_do(String str) {
        this.tanxc_int = str;
        return this;
    }

    public tanxc_for tanxc_do(Map<String, String> map) {
        this.tanxc_try = map;
        return this;
    }

    private void tanxc_do(FormBody.Builder builder, Map<String, String> map) {
        if (builder != null) {
            if (map == null || map.isEmpty()) {
                return;
            }
            for (String str : map.keySet()) {
                builder.add(str, map.get(str));
            }
            return;
        }
        throw new IllegalArgumentException("builder can not be null .");
    }
}
