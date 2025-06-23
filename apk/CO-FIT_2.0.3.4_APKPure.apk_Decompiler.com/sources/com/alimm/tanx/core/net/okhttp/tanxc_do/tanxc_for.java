package com.alimm.tanx.core.net.okhttp.tanxc_do;

import android.os.Handler;
import android.text.TextUtils;
import com.alimm.tanx.core.net.okhttp.callback.ResultCall;
import com.alimm.tanx.core.net.okhttp.tanxc_do;
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

public class tanxc_for {
    private Map<String, String> tanxc_byte;
    private String tanxc_case;
    private boolean tanxc_char;
    private int tanxc_do = 0;
    /* access modifiers changed from: private */
    public int tanxc_else;
    private final MediaType tanxc_for = MediaType.parse("application/json;charset=utf-8");
    /* access modifiers changed from: private */
    public int tanxc_goto;
    private MediaType tanxc_if;
    private String tanxc_int;
    /* access modifiers changed from: private */
    public final OkHttpClient tanxc_long;
    private String tanxc_new;
    /* access modifiers changed from: private */
    public final Handler tanxc_this;
    private Map<String, String> tanxc_try;
    private Request tanxc_void;

    public tanxc_for(boolean z) {
        if (z) {
            this.tanxc_long = tanxc_do.tanxc_if().tanxc_do(true);
        } else {
            this.tanxc_long = tanxc_do.tanxc_do().tanxc_do(z);
        }
        this.tanxc_this = tanxc_do.tanxc_do().tanxc_for();
    }

    public static /* synthetic */ int tanxc_for(tanxc_for tanxc_for2) {
        int i = tanxc_for2.tanxc_goto;
        tanxc_for2.tanxc_goto = i + 1;
        return i;
    }

    public tanxc_for tanxc_do() {
        RequestBody requestBody;
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
            requestBody = builder2.build();
        } else if (i != 2) {
            requestBody = null;
        } else {
            LogUtils.i("OkHttp ", "请求参数  json ==> " + this.tanxc_case);
            MediaType mediaType = this.tanxc_if;
            if (mediaType == null) {
                mediaType = this.tanxc_for;
            }
            requestBody = RequestBody.create(mediaType, this.tanxc_case);
        }
        builder.post(requestBody);
        this.tanxc_void = builder.build();
        return this;
    }

    public tanxc_for tanxc_for(String str) {
        this.tanxc_case = str;
        return this;
    }

    public void tanxc_if() {
        if (!this.tanxc_char) {
            return;
        }
        if (!TextUtils.isEmpty(this.tanxc_new)) {
            tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_new);
        } else {
            tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_int);
        }
    }

    public Headers tanxc_for(Map<String, String> map) {
        Headers.Builder builder = new Headers.Builder();
        if (map == null || map.isEmpty()) {
            return null;
        }
        for (String next : map.keySet()) {
            builder.add(next, map.get(next));
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
                    if (tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_new)) {
                        return response;
                    }
                    tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_new);
                } else if (tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_int)) {
                    return response;
                } else {
                    tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_int);
                }
            }
            Response execute = this.tanxc_long.newCall(this.tanxc_void).execute();
            tanxc_if();
            LogUtils.i("OkHttp ", "请求code ==> " + execute.code());
            LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
            return execute;
        } catch (Exception e) {
            if (response != null) {
                LogUtils.e("OkHttp ", "请求异常 ==> " + response.code());
                if (z) {
                    int intCode = UtErrorCode.CRASH_ERROR.getIntCode();
                    TanxBaseUt.utError(intCode, "OkHttp ", "请求异常 ==> " + response.code() + LogUtils.getStackTraceMessage(e), "");
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
            this.tanxc_this.post(new Runnable() {
                public void run() {
                    resultCall.onBefore();
                }
            });
        }
        if (this.tanxc_char) {
            if (!TextUtils.isEmpty(this.tanxc_new)) {
                if (!tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_new)) {
                    tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_new);
                } else {
                    return;
                }
            } else if (!tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_int)) {
                tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_int);
            } else {
                return;
            }
        }
        LogUtils.d("splashTimeConsuming", "netTime onResponse1->" + (System.currentTimeMillis() - currentTimeMillis));
        this.tanxc_long.newCall(this.tanxc_void).enqueue(new Callback() {
            public void onFailure(final Call call, final IOException iOException) {
                if (!(iOException instanceof SocketException) && tanxc_for.this.tanxc_goto < tanxc_for.this.tanxc_else && tanxc_for.this.tanxc_else > 0) {
                    tanxc_for.tanxc_for(tanxc_for.this);
                    tanxc_for.this.tanxc_long.newCall(call.request()).enqueue(this);
                    return;
                }
                tanxc_for.this.tanxc_if();
                if (resultCall != null) {
                    tanxc_for.this.tanxc_this.postDelayed(new Runnable() {
                        public void run() {
                            UtErrorCode utErrorCode;
                            IOException iOException = iOException;
                            if (!(iOException instanceof SocketException)) {
                                if (iOException instanceof ConnectException) {
                                    utErrorCode = UtErrorCode.NETWORK_CONNECT_EXCEPTION;
                                } else if (iOException instanceof SocketTimeoutException) {
                                    utErrorCode = UtErrorCode.NETWORK_TIMEOUT;
                                } else {
                                    utErrorCode = UtErrorCode.NETWORK_ERROR;
                                }
                                LogUtils.i("OkHttp ", "请求失败原因 ==> " + LogUtils.getStackTraceMessage(iOException));
                                IOException iOException2 = iOException;
                                String str = "";
                                if (!(iOException2 == null || iOException2.getMessage() == null)) {
                                    try {
                                        str = " --> " + call.request().url().uri();
                                    } catch (Exception unused) {
                                    }
                                    str = iOException.getMessage() + str;
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
                    }, 10);
                }
            }

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
                    ResultCall resultCall = resultCall;
                    if (resultCall != null) {
                        resultCall.onSuccess(str);
                    }
                    LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
                    tanxc_for.this.tanxc_this.postDelayed(new Runnable() {
                        public void run() {
                            ResultCall resultCall = resultCall;
                            if (resultCall != null) {
                                resultCall.onAfter();
                            }
                        }
                    }, 10);
                    return;
                }
                String response2 = response.toString();
                ResultCall resultCall2 = resultCall;
                if (resultCall2 != null) {
                    resultCall2.onError(code, UtErrorCode.NETWORK_HTTP_CODE_EXCEPTION.getMsg() + "   errorMsg: " + response2);
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
        if (builder == null) {
            throw new IllegalArgumentException("builder can not be null .");
        } else if (map != null && !map.isEmpty()) {
            for (String next : map.keySet()) {
                builder.add(next, map.get(next));
            }
        }
    }
}
