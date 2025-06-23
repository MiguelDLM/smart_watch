package com.alimm.tanx.core.web.cache;

import android.text.TextUtils;
import com.alimm.tanx.core.utils.LogUtils;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HttpCacheInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String header = request.header(WebViewCacheInterceptor.KEY_CACHE);
        Response proceed = chain.proceed(request);
        try {
            if (!TextUtils.isEmpty(header)) {
                if (header.equals(CacheType.NORMAL.ordinal() + "")) {
                    return proceed;
                }
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
        return proceed.newBuilder().removeHeader("pragma").removeHeader("Cache-Control").header("Cache-Control", "max-age=3153600000").build();
    }
}
