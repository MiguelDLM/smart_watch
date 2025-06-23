package com.sma.androidnetworklib.method;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.BitmapRequestListener;
import com.androidnetworking.interfaces.DownloadListener;
import com.androidnetworking.interfaces.DownloadProgressListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.androidnetworking.interfaces.UploadProgressListener;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import org.json.JSONObject;
import xxxI.II0xO0;

/* loaded from: classes11.dex */
public final class NetWork {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final NetWork f19682oIX0oI = new NetWork();

    public static final void Oxx0IOOO(HttpProgressCallback callback, long j, long j2) {
        IIX0o.x0xO0oo(callback, "$callback");
        if (j2 != 0) {
            callback.handleProgress((int) ((j * 100) / j2));
        }
    }

    public static final void X0o0xo(HttpProgressCallback callback, long j, long j2) {
        IIX0o.x0xO0oo(callback, "$callback");
        if (j2 != 0) {
            callback.handleProgress((int) ((j * 100) / j2));
        }
    }

    public static /* synthetic */ void xoIox(NetWork netWork, String str, II0xO0 iI0xO0, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        netWork.xxIXOIIO(str, iI0xO0, i);
    }

    public final void I0Io() {
        AndroidNetworking.evictAllBitmap();
    }

    public final /* synthetic */ <T> void II0XooXoX(String url, Map<String, String> body, final II0xO0<Response<T>> callback) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        ANRequest build = AndroidNetworking.get(url).addQueryParameter(body).setTag((Object) url).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new ParsedRequestListener<Response<T>>() { // from class: com.sma.androidnetworklib.method.NetWork$get$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OOXIXo Response<T> response) {
                IIX0o.x0xO0oo(response, "response");
                callback.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@oOoXoXO ANError aNError) {
                Integer num;
                String str;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str = aNError.getErrorBody();
                } else {
                    str = null;
                }
                sb.append(str);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                callback.handleError(String.valueOf(num2));
            }
        });
    }

    public final /* synthetic */ <T> void IXxxXO(String url, String fileParameter, File file, Object body, final II0xO0<Response<T>> callback) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(fileParameter, "fileParameter");
        IIX0o.x0xO0oo(file, "file");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        ANRequest.MultiPartBuilder upload = AndroidNetworking.upload(url);
        if (file.exists()) {
            upload.addMultipartFile(fileParameter, file);
        }
        ANRequest uploadProgressListener = upload.addMultipartParameter(body).setTag((Object) url).setPriority(Priority.HIGH).build().setUploadProgressListener(new UploadProgressListener() { // from class: com.sma.androidnetworklib.method.NetWork$upload$1
            @Override // com.androidnetworking.interfaces.UploadProgressListener
            public final void onProgress(long j, long j2) {
            }
        });
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        uploadProgressListener.getAsParsed(parameterized, new ParsedRequestListener<Response<T>>() { // from class: com.sma.androidnetworklib.method.NetWork$upload$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OOXIXo Response<T> response) {
                IIX0o.x0xO0oo(response, "response");
                callback.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@oOoXoXO ANError aNError) {
                callback.handleError(String.valueOf(aNError));
            }
        });
    }

    public final <T> void OOXIXo(@OOXIXo String url, @OOXIXo final File file, @OOXIXo final II0xO0<T> callback) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(file, "file");
        IIX0o.x0xO0oo(callback, "callback");
        AndroidNetworking.get(url).setTag((Object) url).setPriority(Priority.MEDIUM).setBitmapMaxHeight(400).setBitmapMaxWidth(400).setBitmapConfig(Bitmap.Config.ARGB_8888).build().getAsBitmap(new BitmapRequestListener() { // from class: com.sma.androidnetworklib.method.NetWork$getImage$1
            @Override // com.androidnetworking.interfaces.BitmapRequestListener
            public void onError(@OOXIXo ANError error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d(error.toString());
                callback.handleError(error.toString());
            }

            @Override // com.androidnetworking.interfaces.BitmapRequestListener
            public void onResponse(@oOoXoXO Bitmap bitmap) {
                if (bitmap != null) {
                    LogUtils.d("get bitmap");
                    ImageUtils.save(bitmap, file, Bitmap.CompressFormat.JPEG);
                    callback.handleResponse(null);
                }
            }
        });
    }

    public final /* synthetic */ <T> void Oo(String url, Map<String, String> headers, Map<String, ? extends Object> body, final II0xO0<Response<T>> callback) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(headers, "headers");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        ANRequest build = AndroidNetworking.post(url).addHeaders(headers).addBodyParameter((Map<String, String>) body).setTag((Object) url).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new ParsedRequestListener<Response<T>>() { // from class: com.sma.androidnetworklib.method.NetWork$postV2$1
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OOXIXo Response<T> response) {
                IIX0o.x0xO0oo(response, "response");
                callback.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@oOoXoXO ANError aNError) {
                Integer num;
                String str;
                String str2;
                String str3;
                Response response;
                if (aNError != null) {
                    aNError.printStackTrace();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str = aNError.getErrorBody();
                } else {
                    str = null;
                }
                sb.append(str);
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str2 = aNError.getErrorDetail();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", exception:");
                if (aNError != null) {
                    str3 = aNError.getLocalizedMessage();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                callback.handleError(String.valueOf(num2));
            }
        });
    }

    public final void XO(@OOXIXo String url, @OOXIXo Map<String, String> headers, @OOXIXo String path, @OOXIXo String fileName, @OOXIXo final HttpProgressCallback<String> callback) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(headers, "headers");
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(fileName, "fileName");
        IIX0o.x0xO0oo(callback, "callback");
        AndroidNetworking.download(url, path, fileName).setTag((Object) url).addHeaders(headers).setPriority(Priority.MEDIUM).build().setDownloadProgressListener(new DownloadProgressListener() { // from class: xxxI.I0Io
            @Override // com.androidnetworking.interfaces.DownloadProgressListener
            public final void onProgress(long j, long j2) {
                NetWork.Oxx0IOOO(HttpProgressCallback.this, j, j2);
            }
        }).startDownload(new DownloadListener() { // from class: com.sma.androidnetworklib.method.NetWork$downloadV2$2
            @Override // com.androidnetworking.interfaces.DownloadListener
            public void onDownloadComplete() {
                LogUtils.d("download complete");
                callback.handleResponse("");
            }

            @Override // com.androidnetworking.interfaces.DownloadListener
            public void onError(@oOoXoXO ANError aNError) {
                callback.handleError(String.valueOf(aNError));
                LogUtils.d("download error " + aNError);
            }
        });
    }

    public final /* synthetic */ <T> T oO(String url, Object body) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        try {
            ANRequest build = AndroidNetworking.post(url).addApplicationJsonBody(body).setTag((Object) url).setPriority(Priority.HIGH).build();
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            T t = (T) build.executeForObject(Object.class).getResult();
            IIX0o.OxI(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.d(oXIO0o0XI.f29392oIX0oI);
            return null;
        }
    }

    public final /* synthetic */ <T> void oOoXoXO(String url, Map<String, String> headers, Map<String, String> body, final II0xO0<Response<T>> callback) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(headers, "headers");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        ANRequest build = AndroidNetworking.get(url).addQueryParameter(body).setTag((Object) url).addHeaders(headers).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new ParsedRequestListener<Response<T>>() { // from class: com.sma.androidnetworklib.method.NetWork$getV2$1
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OOXIXo Response<T> response) {
                IIX0o.x0xO0oo(response, "response");
                callback.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@oOoXoXO ANError aNError) {
                Integer num;
                String str;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str = aNError.getErrorBody();
                } else {
                    str = null;
                }
                sb.append(str);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                callback.handleError(String.valueOf(num2));
            }
        });
    }

    public final /* synthetic */ <T> void ooOOo0oXI(String url, Map<String, String> body, final II0xO0<Response<T>> callback) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        ANRequest build = AndroidNetworking.post(url).addBodyParameter(body).setTag((Object) url).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new ParsedRequestListener<Response<T>>() { // from class: com.sma.androidnetworklib.method.NetWork$post$1
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OOXIXo Response<T> response) {
                IIX0o.x0xO0oo(response, "response");
                callback.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@oOoXoXO ANError aNError) {
                Integer num;
                String str;
                String str2;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str = aNError.getErrorBody();
                } else {
                    str = null;
                }
                sb.append(str);
                sb.append(", ");
                if (aNError != null) {
                    str2 = aNError.getErrorDetail();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                callback.handleError(String.valueOf(num2));
            }
        });
    }

    public final void oxoX(@OOXIXo String url, @OOXIXo String path, @OOXIXo String fileName, @OOXIXo final HttpProgressCallback<String> callback) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(fileName, "fileName");
        IIX0o.x0xO0oo(callback, "callback");
        AndroidNetworking.download(url, path, fileName).setTag((Object) url).setPriority(Priority.MEDIUM).build().setDownloadProgressListener(new DownloadProgressListener() { // from class: xxxI.oxoX
            @Override // com.androidnetworking.interfaces.DownloadProgressListener
            public final void onProgress(long j, long j2) {
                NetWork.X0o0xo(HttpProgressCallback.this, j, j2);
            }
        }).startDownload(new DownloadListener() { // from class: com.sma.androidnetworklib.method.NetWork$download$2
            @Override // com.androidnetworking.interfaces.DownloadListener
            public void onDownloadComplete() {
                LogUtils.d("download complete");
                callback.handleResponse("");
            }

            @Override // com.androidnetworking.interfaces.DownloadListener
            public void onError(@oOoXoXO ANError aNError) {
                callback.handleError(String.valueOf(aNError));
                LogUtils.d("download error " + aNError);
            }
        });
    }

    public final /* synthetic */ <T> void x0XOIxOo(String url, Object body, final II0xO0<Response<T>> callback) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        ANRequest build = AndroidNetworking.post(url).addApplicationJsonBody(body).setTag((Object) url).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new ParsedRequestListener<Response<T>>() { // from class: com.sma.androidnetworklib.method.NetWork$postJson$1
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OOXIXo Response<T> response) {
                IIX0o.x0xO0oo(response, "response");
                callback.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@oOoXoXO ANError aNError) {
                callback.handleError(String.valueOf(aNError));
            }
        });
    }

    public final /* synthetic */ <T> void x0xO0oo(String url, Map<String, String> headers, Object body, final II0xO0<Response<T>> callback) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(headers, "headers");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        ANRequest build = AndroidNetworking.post(url).addHeaders(headers).addApplicationJsonBody(body).setTag((Object) url).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new ParsedRequestListener<Response<T>>() { // from class: com.sma.androidnetworklib.method.NetWork$postJsonV2$1
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OOXIXo Response<T> response) {
                IIX0o.x0xO0oo(response, "response");
                callback.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@oOoXoXO ANError aNError) {
                callback.handleError(String.valueOf(aNError));
            }
        });
    }

    public final void xxIXOIIO(@OOXIXo String url, @OOXIXo final II0xO0<JSONObject> callback, int i) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(callback, "callback");
        ANRequest.GetRequestBuilder priority = AndroidNetworking.get(url).setTag((Object) url).setPriority(Priority.HIGH);
        if (i != 0) {
            priority.setMaxAgeCacheControl(i, TimeUnit.MINUTES);
        }
        priority.build().getAsJSONObject(new JSONObjectRequestListener() { // from class: com.sma.androidnetworklib.method.NetWork$get$1
            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onError(@oOoXoXO ANError aNError) {
                callback.handleError(String.valueOf(aNError));
            }

            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onResponse(@oOoXoXO JSONObject jSONObject) {
                callback.handleResponse(jSONObject);
            }
        });
    }
}
