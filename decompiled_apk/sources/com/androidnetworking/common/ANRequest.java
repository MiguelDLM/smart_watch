package com.androidnetworking.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.core.Core;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.AnalyticsListener;
import com.androidnetworking.interfaces.BitmapRequestListener;
import com.androidnetworking.interfaces.DownloadListener;
import com.androidnetworking.interfaces.DownloadProgressListener;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.OkHttpResponseAndBitmapRequestListener;
import com.androidnetworking.interfaces.OkHttpResponseAndJSONArrayRequestListener;
import com.androidnetworking.interfaces.OkHttpResponseAndJSONObjectRequestListener;
import com.androidnetworking.interfaces.OkHttpResponseAndParsedRequestListener;
import com.androidnetworking.interfaces.OkHttpResponseAndStringRequestListener;
import com.androidnetworking.interfaces.OkHttpResponseListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.androidnetworking.interfaces.UploadProgressListener;
import com.androidnetworking.internal.ANRequestQueue;
import com.androidnetworking.internal.SynchronousCall;
import com.androidnetworking.model.MultipartFileBody;
import com.androidnetworking.model.MultipartStringBody;
import com.androidnetworking.utils.ParseUtil;
import com.androidnetworking.utils.Utils;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Okio;
import org.apache.commons.text.ooOOo0oXI;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ANRequest<T extends ANRequest> {
    private static final String TAG = "ANRequest";
    private Call call;
    private MediaType customMediaType;
    private Future future;
    private boolean isCancelled;
    private boolean isDelivered;
    private boolean isRunning;
    private AnalyticsListener mAnalyticsListener;
    private String mApplicationJsonString;
    private BitmapRequestListener mBitmapRequestListener;
    private HashMap<String, String> mBodyParameterMap;
    private byte[] mByte;
    private CacheControl mCacheControl;
    private Bitmap.Config mDecodeConfig;
    private String mDirPath;
    private DownloadListener mDownloadListener;
    private DownloadProgressListener mDownloadProgressListener;
    private Executor mExecutor;
    private File mFile;
    private String mFileName;
    private HashMap<String, List<String>> mHeadersMap;
    private JSONArrayRequestListener mJSONArrayRequestListener;
    private JSONObjectRequestListener mJSONObjectRequestListener;
    private int mMaxHeight;
    private int mMaxWidth;
    private int mMethod;
    private HashMap<String, List<MultipartFileBody>> mMultiPartFileMap;
    private HashMap<String, MultipartStringBody> mMultiPartParameterMap;
    private OkHttpClient mOkHttpClient;
    private OkHttpResponseAndBitmapRequestListener mOkHttpResponseAndBitmapRequestListener;
    private OkHttpResponseAndJSONArrayRequestListener mOkHttpResponseAndJSONArrayRequestListener;
    private OkHttpResponseAndJSONObjectRequestListener mOkHttpResponseAndJSONObjectRequestListener;
    private OkHttpResponseAndParsedRequestListener mOkHttpResponseAndParsedRequestListener;
    private OkHttpResponseAndStringRequestListener mOkHttpResponseAndStringRequestListener;
    private OkHttpResponseListener mOkHttpResponseListener;
    private ParsedRequestListener mParsedRequestListener;
    private HashMap<String, String> mPathParameterMap;
    private int mPercentageThresholdForCancelling;
    private Priority mPriority;
    private int mProgress;
    private HashMap<String, List<String>> mQueryParameterMap;
    private int mRequestType;
    private ResponseType mResponseType;
    private ImageView.ScaleType mScaleType;
    private String mStringBody;
    private StringRequestListener mStringRequestListener;
    private Object mTag;
    private Type mType;
    private UploadProgressListener mUploadProgressListener;
    private String mUrl;
    private HashMap<String, String> mUrlEncodedFormBodyParameterMap;
    private String mUserAgent;
    private int sequenceNumber;
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
    private static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
    private static final Object sDecodeLock = new Object();

    /* renamed from: com.androidnetworking.common.ANRequest$9, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$com$androidnetworking$common$ResponseType;

        static {
            int[] iArr = new int[ResponseType.values().length];
            $SwitchMap$com$androidnetworking$common$ResponseType = iArr;
            try {
                iArr[ResponseType.JSON_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$androidnetworking$common$ResponseType[ResponseType.JSON_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$androidnetworking$common$ResponseType[ResponseType.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$androidnetworking$common$ResponseType[ResponseType.BITMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$androidnetworking$common$ResponseType[ResponseType.PARSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$androidnetworking$common$ResponseType[ResponseType.PREFETCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class DeleteRequestBuilder extends PostRequestBuilder {
        public DeleteRequestBuilder(String str) {
            super(str, 3);
        }
    }

    /* loaded from: classes.dex */
    public static class DownloadBuilder<T extends DownloadBuilder> implements RequestBuilder {
        private CacheControl mCacheControl;
        private String mDirPath;
        private Executor mExecutor;
        private String mFileName;
        private OkHttpClient mOkHttpClient;
        private Object mTag;
        private String mUrl;
        private String mUserAgent;
        private Priority mPriority = Priority.MEDIUM;
        private HashMap<String, List<String>> mHeadersMap = new HashMap<>();
        private HashMap<String, List<String>> mQueryParameterMap = new HashMap<>();
        private HashMap<String, String> mPathParameterMap = new HashMap<>();
        private int mPercentageThresholdForCancelling = 0;

        public DownloadBuilder(String str, String str2, String str3) {
            this.mUrl = str;
            this.mDirPath = str2;
            this.mFileName = str3;
        }

        public ANRequest build() {
            return new ANRequest(this);
        }

        public T setPercentageThresholdForCancelling(int i) {
            this.mPercentageThresholdForCancelling = i;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T doNotCacheResponse() {
            this.mCacheControl = new CacheControl.Builder().noStore().build();
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T getResponseOnlyFromNetwork() {
            this.mCacheControl = CacheControl.FORCE_NETWORK;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T getResponseOnlyIfCached() {
            this.mCacheControl = CacheControl.FORCE_CACHE;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setExecutor(Executor executor) {
            this.mExecutor = executor;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setMaxAgeCacheControl(int i, TimeUnit timeUnit) {
            this.mCacheControl = new CacheControl.Builder().maxAge(i, timeUnit).build();
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setMaxStaleCacheControl(int i, TimeUnit timeUnit) {
            this.mCacheControl = new CacheControl.Builder().maxStale(i, timeUnit).build();
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setOkHttpClient(OkHttpClient okHttpClient) {
            this.mOkHttpClient = okHttpClient;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setPriority(Priority priority) {
            this.mPriority = priority;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setUserAgent(String str) {
            this.mUserAgent = str;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder addHeaders(Map map) {
            return addHeaders((Map<String, String>) map);
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder addPathParameter(Map map) {
            return addPathParameter((Map<String, String>) map);
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder addQueryParameter(Map map) {
            return addQueryParameter((Map<String, String>) map);
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addHeaders(String str, String str2) {
            List<String> list = this.mHeadersMap.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.mHeadersMap.put(str, list);
            }
            if (!list.contains(str2)) {
                list.add(str2);
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addPathParameter(String str, String str2) {
            this.mPathParameterMap.put(str, str2);
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addQueryParameter(String str, String str2) {
            List<String> list = this.mQueryParameterMap.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.mQueryParameterMap.put(str, list);
            }
            if (!list.contains(str2)) {
                list.add(str2);
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addPathParameter(Map<String, String> map) {
            if (map != null) {
                this.mPathParameterMap.putAll(map);
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addPathParameter(Object obj) {
            if (obj != null) {
                this.mPathParameterMap.putAll(ParseUtil.getParserFactory().getStringMap(obj));
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addHeaders(Map<String, String> map) {
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    addHeaders(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addQueryParameter(Map<String, String> map) {
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    addQueryParameter(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addHeaders(Object obj) {
            return obj != null ? addHeaders((Map<String, String>) ParseUtil.getParserFactory().getStringMap(obj)) : this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addQueryParameter(Object obj) {
            return obj != null ? addQueryParameter((Map<String, String>) ParseUtil.getParserFactory().getStringMap(obj)) : this;
        }
    }

    /* loaded from: classes.dex */
    public static class DynamicRequestBuilder extends PostRequestBuilder {
        public DynamicRequestBuilder(String str, int i) {
            super(str, i);
        }
    }

    /* loaded from: classes.dex */
    public static class GetRequestBuilder<T extends GetRequestBuilder> implements RequestBuilder {
        private BitmapFactory.Options mBitmapOptions;
        private CacheControl mCacheControl;
        private Bitmap.Config mDecodeConfig;
        private Executor mExecutor;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMethod;
        private OkHttpClient mOkHttpClient;
        private ImageView.ScaleType mScaleType;
        private Object mTag;
        private String mUrl;
        private String mUserAgent;
        private Priority mPriority = Priority.MEDIUM;
        private HashMap<String, List<String>> mHeadersMap = new HashMap<>();
        private HashMap<String, List<String>> mQueryParameterMap = new HashMap<>();
        private HashMap<String, String> mPathParameterMap = new HashMap<>();

        public GetRequestBuilder(String str) {
            this.mMethod = 0;
            this.mUrl = str;
            this.mMethod = 0;
        }

        public ANRequest build() {
            return new ANRequest(this);
        }

        public T setBitmapConfig(Bitmap.Config config) {
            this.mDecodeConfig = config;
            return this;
        }

        public T setBitmapMaxHeight(int i) {
            this.mMaxHeight = i;
            return this;
        }

        public T setBitmapMaxWidth(int i) {
            this.mMaxWidth = i;
            return this;
        }

        public T setBitmapOptions(BitmapFactory.Options options) {
            this.mBitmapOptions = options;
            return this;
        }

        public T setImageScaleType(ImageView.ScaleType scaleType) {
            this.mScaleType = scaleType;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T doNotCacheResponse() {
            this.mCacheControl = new CacheControl.Builder().noStore().build();
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T getResponseOnlyFromNetwork() {
            this.mCacheControl = CacheControl.FORCE_NETWORK;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T getResponseOnlyIfCached() {
            this.mCacheControl = CacheControl.FORCE_CACHE;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setExecutor(Executor executor) {
            this.mExecutor = executor;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setMaxAgeCacheControl(int i, TimeUnit timeUnit) {
            this.mCacheControl = new CacheControl.Builder().maxAge(i, timeUnit).build();
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setMaxStaleCacheControl(int i, TimeUnit timeUnit) {
            this.mCacheControl = new CacheControl.Builder().maxStale(i, timeUnit).build();
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setOkHttpClient(OkHttpClient okHttpClient) {
            this.mOkHttpClient = okHttpClient;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setPriority(Priority priority) {
            this.mPriority = priority;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setUserAgent(String str) {
            this.mUserAgent = str;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder addHeaders(Map map) {
            return addHeaders((Map<String, String>) map);
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder addPathParameter(Map map) {
            return addPathParameter((Map<String, String>) map);
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder addQueryParameter(Map map) {
            return addQueryParameter((Map<String, String>) map);
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addHeaders(String str, String str2) {
            List<String> list = this.mHeadersMap.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.mHeadersMap.put(str, list);
            }
            if (!list.contains(str2)) {
                list.add(str2);
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addPathParameter(String str, String str2) {
            this.mPathParameterMap.put(str, str2);
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addQueryParameter(String str, String str2) {
            List<String> list = this.mQueryParameterMap.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.mQueryParameterMap.put(str, list);
            }
            if (!list.contains(str2)) {
                list.add(str2);
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addPathParameter(Map<String, String> map) {
            if (map != null) {
                this.mPathParameterMap.putAll(map);
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addPathParameter(Object obj) {
            if (obj != null) {
                this.mPathParameterMap.putAll(ParseUtil.getParserFactory().getStringMap(obj));
            }
            return this;
        }

        public GetRequestBuilder(String str, int i) {
            this.mMethod = 0;
            this.mUrl = str;
            this.mMethod = i;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addHeaders(Map<String, String> map) {
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    addHeaders(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addQueryParameter(Map<String, String> map) {
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    addQueryParameter(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addHeaders(Object obj) {
            return obj != null ? addHeaders((Map<String, String>) ParseUtil.getParserFactory().getStringMap(obj)) : this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addQueryParameter(Object obj) {
            return obj != null ? addQueryParameter((Map<String, String>) ParseUtil.getParserFactory().getStringMap(obj)) : this;
        }
    }

    /* loaded from: classes.dex */
    public static class HeadRequestBuilder extends GetRequestBuilder {
        public HeadRequestBuilder(String str) {
            super(str, 4);
        }
    }

    /* loaded from: classes.dex */
    public static class MultiPartBuilder<T extends MultiPartBuilder> implements RequestBuilder {
        private CacheControl mCacheControl;
        private String mCustomContentType;
        private Executor mExecutor;
        private OkHttpClient mOkHttpClient;
        private Object mTag;
        private String mUrl;
        private String mUserAgent;
        private Priority mPriority = Priority.MEDIUM;
        private HashMap<String, List<String>> mHeadersMap = new HashMap<>();
        private HashMap<String, List<String>> mQueryParameterMap = new HashMap<>();
        private HashMap<String, String> mPathParameterMap = new HashMap<>();
        private HashMap<String, MultipartStringBody> mMultiPartParameterMap = new HashMap<>();
        private HashMap<String, List<MultipartFileBody>> mMultiPartFileMap = new HashMap<>();
        private int mPercentageThresholdForCancelling = 0;

        public MultiPartBuilder(String str) {
            this.mUrl = str;
        }

        private void addMultipartFileWithKey(String str, MultipartFileBody multipartFileBody) {
            List<MultipartFileBody> list = this.mMultiPartFileMap.get(str);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(multipartFileBody);
            this.mMultiPartFileMap.put(str, list);
        }

        public T addMultipartFile(String str, File file) {
            return addMultipartFile(str, file, null);
        }

        public T addMultipartFileList(String str, List<File> list) {
            return addMultipartFileList(str, list, null);
        }

        public T addMultipartParameter(String str, String str2) {
            return addMultipartParameter(str, str2, null);
        }

        public ANRequest build() {
            return new ANRequest(this);
        }

        public T setContentType(String str) {
            this.mCustomContentType = str;
            return this;
        }

        public T setPercentageThresholdForCancelling(int i) {
            this.mPercentageThresholdForCancelling = i;
            return this;
        }

        public T addMultipartFile(String str, File file, String str2) {
            addMultipartFileWithKey(str, new MultipartFileBody(file, str2));
            return this;
        }

        public T addMultipartFileList(String str, List<File> list, String str2) {
            if (list != null) {
                Iterator<File> it = list.iterator();
                while (it.hasNext()) {
                    addMultipartFileWithKey(str, new MultipartFileBody(it.next(), str2));
                }
            }
            return this;
        }

        public T addMultipartParameter(String str, String str2, String str3) {
            this.mMultiPartParameterMap.put(str, new MultipartStringBody(str2, str3));
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T doNotCacheResponse() {
            this.mCacheControl = new CacheControl.Builder().noStore().build();
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T getResponseOnlyFromNetwork() {
            this.mCacheControl = CacheControl.FORCE_NETWORK;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T getResponseOnlyIfCached() {
            this.mCacheControl = CacheControl.FORCE_CACHE;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setExecutor(Executor executor) {
            this.mExecutor = executor;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setMaxAgeCacheControl(int i, TimeUnit timeUnit) {
            this.mCacheControl = new CacheControl.Builder().maxAge(i, timeUnit).build();
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setMaxStaleCacheControl(int i, TimeUnit timeUnit) {
            this.mCacheControl = new CacheControl.Builder().maxStale(i, timeUnit).build();
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setOkHttpClient(OkHttpClient okHttpClient) {
            this.mOkHttpClient = okHttpClient;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setPriority(Priority priority) {
            this.mPriority = priority;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setUserAgent(String str) {
            this.mUserAgent = str;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder addHeaders(Map map) {
            return addHeaders((Map<String, String>) map);
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder addPathParameter(Map map) {
            return addPathParameter((Map<String, String>) map);
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder addQueryParameter(Map map) {
            return addQueryParameter((Map<String, String>) map);
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addHeaders(String str, String str2) {
            List<String> list = this.mHeadersMap.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.mHeadersMap.put(str, list);
            }
            if (!list.contains(str2)) {
                list.add(str2);
            }
            return this;
        }

        public T addMultipartFile(Map<String, File> map) {
            return addMultipartFile(map, (String) null);
        }

        public T addMultipartParameter(Map<String, String> map) {
            return addMultipartParameter(map, (String) null);
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addPathParameter(String str, String str2) {
            this.mPathParameterMap.put(str, str2);
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addQueryParameter(String str, String str2) {
            List<String> list = this.mQueryParameterMap.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.mQueryParameterMap.put(str, list);
            }
            if (!list.contains(str2)) {
                list.add(str2);
            }
            return this;
        }

        public T addMultipartFile(Map<String, File> map, String str) {
            if (map != null) {
                for (Map.Entry<String, File> entry : map.entrySet()) {
                    addMultipartFileWithKey(entry.getKey(), new MultipartFileBody(entry.getValue(), str));
                }
            }
            return this;
        }

        public T addMultipartFileList(Map<String, List<File>> map) {
            return addMultipartFileList(map, (String) null);
        }

        public T addMultipartParameter(Map<String, String> map, String str) {
            if (map != null) {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    hashMap.put(entry.getKey(), new MultipartStringBody(entry.getValue(), str));
                }
                this.mMultiPartParameterMap.putAll(hashMap);
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addPathParameter(Map<String, String> map) {
            if (map != null) {
                this.mPathParameterMap.putAll(map);
            }
            return this;
        }

        public T addMultipartFileList(Map<String, List<File>> map, String str) {
            if (map != null) {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, List<File>> entry : map.entrySet()) {
                    List<File> value = entry.getValue();
                    ArrayList arrayList = new ArrayList();
                    Iterator<File> it = value.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new MultipartFileBody(it.next(), str));
                    }
                    hashMap.put(entry.getKey(), arrayList);
                }
                this.mMultiPartFileMap.putAll(hashMap);
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addPathParameter(Object obj) {
            if (obj != null) {
                this.mPathParameterMap.putAll(ParseUtil.getParserFactory().getStringMap(obj));
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addHeaders(Map<String, String> map) {
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    addHeaders(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addQueryParameter(Map<String, String> map) {
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    addQueryParameter(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public T addMultipartParameter(Object obj) {
            return addMultipartParameter(obj, (String) null);
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addHeaders(Object obj) {
            return obj != null ? addHeaders((Map<String, String>) ParseUtil.getParserFactory().getStringMap(obj)) : this;
        }

        public T addMultipartParameter(Object obj, String str) {
            if (obj != null) {
                addMultipartParameter((Map<String, String>) ParseUtil.getParserFactory().getStringMap(obj), str);
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addQueryParameter(Object obj) {
            return obj != null ? addQueryParameter((Map<String, String>) ParseUtil.getParserFactory().getStringMap(obj)) : this;
        }
    }

    /* loaded from: classes.dex */
    public static class OptionsRequestBuilder extends GetRequestBuilder {
        public OptionsRequestBuilder(String str) {
            super(str, 6);
        }
    }

    /* loaded from: classes.dex */
    public static class PatchRequestBuilder extends PostRequestBuilder {
        public PatchRequestBuilder(String str) {
            super(str, 5);
        }
    }

    /* loaded from: classes.dex */
    public static class PostRequestBuilder<T extends PostRequestBuilder> implements RequestBuilder {
        private CacheControl mCacheControl;
        private String mCustomContentType;
        private Executor mExecutor;
        private int mMethod;
        private OkHttpClient mOkHttpClient;
        private Object mTag;
        private String mUrl;
        private String mUserAgent;
        private Priority mPriority = Priority.MEDIUM;
        private String mApplicationJsonString = null;
        private String mStringBody = null;
        private byte[] mByte = null;
        private File mFile = null;
        private HashMap<String, List<String>> mHeadersMap = new HashMap<>();
        private HashMap<String, String> mBodyParameterMap = new HashMap<>();
        private HashMap<String, String> mUrlEncodedFormBodyParameterMap = new HashMap<>();
        private HashMap<String, List<String>> mQueryParameterMap = new HashMap<>();
        private HashMap<String, String> mPathParameterMap = new HashMap<>();

        public PostRequestBuilder(String str) {
            this.mMethod = 1;
            this.mUrl = str;
            this.mMethod = 1;
        }

        public T addApplicationJsonBody(Object obj) {
            if (obj != null) {
                this.mApplicationJsonString = ParseUtil.getParserFactory().getString(obj);
            }
            return this;
        }

        public T addBodyParameter(String str, String str2) {
            this.mBodyParameterMap.put(str, str2);
            return this;
        }

        public T addByteBody(byte[] bArr) {
            this.mByte = bArr;
            return this;
        }

        public T addFileBody(File file) {
            this.mFile = file;
            return this;
        }

        public T addJSONArrayBody(JSONArray jSONArray) {
            if (jSONArray != null) {
                this.mApplicationJsonString = jSONArray.toString();
            }
            return this;
        }

        public T addJSONObjectBody(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.mApplicationJsonString = jSONObject.toString();
            }
            return this;
        }

        public T addStringBody(String str) {
            this.mStringBody = str;
            return this;
        }

        public T addUrlEncodeFormBodyParameter(String str, String str2) {
            this.mUrlEncodedFormBodyParameterMap.put(str, str2);
            return this;
        }

        public ANRequest build() {
            return new ANRequest(this);
        }

        public T setContentType(String str) {
            this.mCustomContentType = str;
            return this;
        }

        public T addBodyParameter(Map<String, String> map) {
            if (map != null) {
                this.mBodyParameterMap.putAll(map);
            }
            return this;
        }

        public T addUrlEncodeFormBodyParameter(Map<String, String> map) {
            if (map != null) {
                this.mUrlEncodedFormBodyParameterMap.putAll(map);
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T doNotCacheResponse() {
            this.mCacheControl = new CacheControl.Builder().noStore().build();
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T getResponseOnlyFromNetwork() {
            this.mCacheControl = CacheControl.FORCE_NETWORK;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T getResponseOnlyIfCached() {
            this.mCacheControl = CacheControl.FORCE_CACHE;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setExecutor(Executor executor) {
            this.mExecutor = executor;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setMaxAgeCacheControl(int i, TimeUnit timeUnit) {
            this.mCacheControl = new CacheControl.Builder().maxAge(i, timeUnit).build();
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setMaxStaleCacheControl(int i, TimeUnit timeUnit) {
            this.mCacheControl = new CacheControl.Builder().maxStale(i, timeUnit).build();
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setOkHttpClient(OkHttpClient okHttpClient) {
            this.mOkHttpClient = okHttpClient;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setPriority(Priority priority) {
            this.mPriority = priority;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T setUserAgent(String str) {
            this.mUserAgent = str;
            return this;
        }

        public T addBodyParameter(Object obj) {
            if (obj != null) {
                this.mBodyParameterMap.putAll(ParseUtil.getParserFactory().getStringMap(obj));
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder addHeaders(Map map) {
            return addHeaders((Map<String, String>) map);
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder addPathParameter(Map map) {
            return addPathParameter((Map<String, String>) map);
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder addQueryParameter(Map map) {
            return addQueryParameter((Map<String, String>) map);
        }

        public T addUrlEncodeFormBodyParameter(Object obj) {
            if (obj != null) {
                this.mUrlEncodedFormBodyParameterMap.putAll(ParseUtil.getParserFactory().getStringMap(obj));
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addHeaders(String str, String str2) {
            List<String> list = this.mHeadersMap.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.mHeadersMap.put(str, list);
            }
            if (!list.contains(str2)) {
                list.add(str2);
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addPathParameter(String str, String str2) {
            this.mPathParameterMap.put(str, str2);
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addQueryParameter(String str, String str2) {
            List<String> list = this.mQueryParameterMap.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.mQueryParameterMap.put(str, list);
            }
            if (!list.contains(str2)) {
                list.add(str2);
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addPathParameter(Map<String, String> map) {
            if (map != null) {
                this.mPathParameterMap.putAll(map);
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addPathParameter(Object obj) {
            if (obj != null) {
                this.mPathParameterMap.putAll(ParseUtil.getParserFactory().getStringMap(obj));
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addHeaders(Map<String, String> map) {
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    addHeaders(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addQueryParameter(Map<String, String> map) {
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    addQueryParameter(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addHeaders(Object obj) {
            return obj != null ? addHeaders((Map<String, String>) ParseUtil.getParserFactory().getStringMap(obj)) : this;
        }

        @Override // com.androidnetworking.common.RequestBuilder
        public T addQueryParameter(Object obj) {
            return obj != null ? addQueryParameter((Map<String, String>) ParseUtil.getParserFactory().getStringMap(obj)) : this;
        }

        public PostRequestBuilder(String str, int i) {
            this.mMethod = 1;
            this.mUrl = str;
            this.mMethod = i;
        }
    }

    /* loaded from: classes.dex */
    public static class PutRequestBuilder extends PostRequestBuilder {
        public PutRequestBuilder(String str) {
            super(str, 2);
        }
    }

    public ANRequest(GetRequestBuilder getRequestBuilder) {
        this.mHeadersMap = new HashMap<>();
        this.mBodyParameterMap = new HashMap<>();
        this.mUrlEncodedFormBodyParameterMap = new HashMap<>();
        this.mMultiPartParameterMap = new HashMap<>();
        this.mQueryParameterMap = new HashMap<>();
        this.mPathParameterMap = new HashMap<>();
        this.mMultiPartFileMap = new HashMap<>();
        this.mApplicationJsonString = null;
        this.mStringBody = null;
        this.mByte = null;
        this.mFile = null;
        this.customMediaType = null;
        this.mPercentageThresholdForCancelling = 0;
        this.mCacheControl = null;
        this.mExecutor = null;
        this.mOkHttpClient = null;
        this.mUserAgent = null;
        this.mType = null;
        this.mRequestType = 0;
        this.mMethod = getRequestBuilder.mMethod;
        this.mPriority = getRequestBuilder.mPriority;
        this.mUrl = getRequestBuilder.mUrl;
        this.mTag = getRequestBuilder.mTag;
        this.mHeadersMap = getRequestBuilder.mHeadersMap;
        this.mDecodeConfig = getRequestBuilder.mDecodeConfig;
        this.mMaxHeight = getRequestBuilder.mMaxHeight;
        this.mMaxWidth = getRequestBuilder.mMaxWidth;
        this.mScaleType = getRequestBuilder.mScaleType;
        this.mQueryParameterMap = getRequestBuilder.mQueryParameterMap;
        this.mPathParameterMap = getRequestBuilder.mPathParameterMap;
        this.mCacheControl = getRequestBuilder.mCacheControl;
        this.mExecutor = getRequestBuilder.mExecutor;
        this.mOkHttpClient = getRequestBuilder.mOkHttpClient;
        this.mUserAgent = getRequestBuilder.mUserAgent;
    }

    private void deliverErrorResponse(ANError aNError) {
        JSONObjectRequestListener jSONObjectRequestListener = this.mJSONObjectRequestListener;
        if (jSONObjectRequestListener != null) {
            jSONObjectRequestListener.onError(aNError);
            return;
        }
        JSONArrayRequestListener jSONArrayRequestListener = this.mJSONArrayRequestListener;
        if (jSONArrayRequestListener != null) {
            jSONArrayRequestListener.onError(aNError);
            return;
        }
        StringRequestListener stringRequestListener = this.mStringRequestListener;
        if (stringRequestListener != null) {
            stringRequestListener.onError(aNError);
            return;
        }
        BitmapRequestListener bitmapRequestListener = this.mBitmapRequestListener;
        if (bitmapRequestListener != null) {
            bitmapRequestListener.onError(aNError);
            return;
        }
        ParsedRequestListener parsedRequestListener = this.mParsedRequestListener;
        if (parsedRequestListener != null) {
            parsedRequestListener.onError(aNError);
            return;
        }
        OkHttpResponseListener okHttpResponseListener = this.mOkHttpResponseListener;
        if (okHttpResponseListener != null) {
            okHttpResponseListener.onError(aNError);
            return;
        }
        OkHttpResponseAndJSONObjectRequestListener okHttpResponseAndJSONObjectRequestListener = this.mOkHttpResponseAndJSONObjectRequestListener;
        if (okHttpResponseAndJSONObjectRequestListener != null) {
            okHttpResponseAndJSONObjectRequestListener.onError(aNError);
            return;
        }
        OkHttpResponseAndJSONArrayRequestListener okHttpResponseAndJSONArrayRequestListener = this.mOkHttpResponseAndJSONArrayRequestListener;
        if (okHttpResponseAndJSONArrayRequestListener != null) {
            okHttpResponseAndJSONArrayRequestListener.onError(aNError);
            return;
        }
        OkHttpResponseAndStringRequestListener okHttpResponseAndStringRequestListener = this.mOkHttpResponseAndStringRequestListener;
        if (okHttpResponseAndStringRequestListener != null) {
            okHttpResponseAndStringRequestListener.onError(aNError);
            return;
        }
        OkHttpResponseAndBitmapRequestListener okHttpResponseAndBitmapRequestListener = this.mOkHttpResponseAndBitmapRequestListener;
        if (okHttpResponseAndBitmapRequestListener != null) {
            okHttpResponseAndBitmapRequestListener.onError(aNError);
            return;
        }
        OkHttpResponseAndParsedRequestListener okHttpResponseAndParsedRequestListener = this.mOkHttpResponseAndParsedRequestListener;
        if (okHttpResponseAndParsedRequestListener != null) {
            okHttpResponseAndParsedRequestListener.onError(aNError);
            return;
        }
        DownloadListener downloadListener = this.mDownloadListener;
        if (downloadListener != null) {
            downloadListener.onError(aNError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deliverSuccessResponse(ANResponse aNResponse) {
        JSONObjectRequestListener jSONObjectRequestListener = this.mJSONObjectRequestListener;
        if (jSONObjectRequestListener != null) {
            jSONObjectRequestListener.onResponse((JSONObject) aNResponse.getResult());
        } else {
            JSONArrayRequestListener jSONArrayRequestListener = this.mJSONArrayRequestListener;
            if (jSONArrayRequestListener != null) {
                jSONArrayRequestListener.onResponse((JSONArray) aNResponse.getResult());
            } else {
                StringRequestListener stringRequestListener = this.mStringRequestListener;
                if (stringRequestListener != null) {
                    stringRequestListener.onResponse((String) aNResponse.getResult());
                } else {
                    BitmapRequestListener bitmapRequestListener = this.mBitmapRequestListener;
                    if (bitmapRequestListener != null) {
                        bitmapRequestListener.onResponse((Bitmap) aNResponse.getResult());
                    } else {
                        ParsedRequestListener parsedRequestListener = this.mParsedRequestListener;
                        if (parsedRequestListener != null) {
                            parsedRequestListener.onResponse(aNResponse.getResult());
                        } else {
                            OkHttpResponseAndJSONObjectRequestListener okHttpResponseAndJSONObjectRequestListener = this.mOkHttpResponseAndJSONObjectRequestListener;
                            if (okHttpResponseAndJSONObjectRequestListener != null) {
                                okHttpResponseAndJSONObjectRequestListener.onResponse(aNResponse.getOkHttpResponse(), (JSONObject) aNResponse.getResult());
                            } else {
                                OkHttpResponseAndJSONArrayRequestListener okHttpResponseAndJSONArrayRequestListener = this.mOkHttpResponseAndJSONArrayRequestListener;
                                if (okHttpResponseAndJSONArrayRequestListener != null) {
                                    okHttpResponseAndJSONArrayRequestListener.onResponse(aNResponse.getOkHttpResponse(), (JSONArray) aNResponse.getResult());
                                } else {
                                    OkHttpResponseAndStringRequestListener okHttpResponseAndStringRequestListener = this.mOkHttpResponseAndStringRequestListener;
                                    if (okHttpResponseAndStringRequestListener != null) {
                                        okHttpResponseAndStringRequestListener.onResponse(aNResponse.getOkHttpResponse(), (String) aNResponse.getResult());
                                    } else {
                                        OkHttpResponseAndBitmapRequestListener okHttpResponseAndBitmapRequestListener = this.mOkHttpResponseAndBitmapRequestListener;
                                        if (okHttpResponseAndBitmapRequestListener != null) {
                                            okHttpResponseAndBitmapRequestListener.onResponse(aNResponse.getOkHttpResponse(), (Bitmap) aNResponse.getResult());
                                        } else {
                                            OkHttpResponseAndParsedRequestListener okHttpResponseAndParsedRequestListener = this.mOkHttpResponseAndParsedRequestListener;
                                            if (okHttpResponseAndParsedRequestListener != null) {
                                                okHttpResponseAndParsedRequestListener.onResponse(aNResponse.getOkHttpResponse(), aNResponse.getResult());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        finish();
    }

    public void cancel(boolean z) {
        if (!z) {
            try {
                int i = this.mPercentageThresholdForCancelling;
                if (i != 0 && this.mProgress >= i) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.isCancelled = true;
        this.isRunning = false;
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
        Future future = this.future;
        if (future != null) {
            future.cancel(true);
        }
        if (!this.isDelivered) {
            deliverError(new ANError());
        }
    }

    public synchronized void deliverError(ANError aNError) {
        try {
            try {
                if (!this.isDelivered) {
                    if (this.isCancelled) {
                        aNError.setCancellationMessageInError();
                        aNError.setErrorCode(0);
                    }
                    deliverErrorResponse(aNError);
                }
                this.isDelivered = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void deliverOkHttpResponse(final Response response) {
        try {
            this.isDelivered = true;
            if (!this.isCancelled) {
                Executor executor = this.mExecutor;
                if (executor != null) {
                    executor.execute(new Runnable() { // from class: com.androidnetworking.common.ANRequest.7
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ANRequest.this.mOkHttpResponseListener != null) {
                                ANRequest.this.mOkHttpResponseListener.onResponse(response);
                            }
                            ANRequest.this.finish();
                        }
                    });
                    return;
                } else {
                    Core.getInstance().getExecutorSupplier().forMainThreadTasks().execute(new Runnable() { // from class: com.androidnetworking.common.ANRequest.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ANRequest.this.mOkHttpResponseListener != null) {
                                ANRequest.this.mOkHttpResponseListener.onResponse(response);
                            }
                            ANRequest.this.finish();
                        }
                    });
                    return;
                }
            }
            ANError aNError = new ANError();
            aNError.setCancellationMessageInError();
            aNError.setErrorCode(0);
            OkHttpResponseListener okHttpResponseListener = this.mOkHttpResponseListener;
            if (okHttpResponseListener != null) {
                okHttpResponseListener.onError(aNError);
            }
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deliverResponse(final ANResponse aNResponse) {
        try {
            this.isDelivered = true;
            if (!this.isCancelled) {
                Executor executor = this.mExecutor;
                if (executor != null) {
                    executor.execute(new Runnable() { // from class: com.androidnetworking.common.ANRequest.5
                        @Override // java.lang.Runnable
                        public void run() {
                            ANRequest.this.deliverSuccessResponse(aNResponse);
                        }
                    });
                } else {
                    Core.getInstance().getExecutorSupplier().forMainThreadTasks().execute(new Runnable() { // from class: com.androidnetworking.common.ANRequest.6
                        @Override // java.lang.Runnable
                        public void run() {
                            ANRequest.this.deliverSuccessResponse(aNResponse);
                        }
                    });
                }
            } else {
                ANError aNError = new ANError();
                aNError.setCancellationMessageInError();
                aNError.setErrorCode(0);
                deliverErrorResponse(aNError);
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        this.mJSONArrayRequestListener = null;
        this.mJSONObjectRequestListener = null;
        this.mStringRequestListener = null;
        this.mBitmapRequestListener = null;
        this.mParsedRequestListener = null;
        this.mDownloadProgressListener = null;
        this.mUploadProgressListener = null;
        this.mDownloadListener = null;
        this.mAnalyticsListener = null;
    }

    public ANResponse executeForBitmap() {
        this.mResponseType = ResponseType.BITMAP;
        return SynchronousCall.execute(this);
    }

    public ANResponse executeForDownload() {
        return SynchronousCall.execute(this);
    }

    public ANResponse executeForJSONArray() {
        this.mResponseType = ResponseType.JSON_ARRAY;
        return SynchronousCall.execute(this);
    }

    public ANResponse executeForJSONObject() {
        this.mResponseType = ResponseType.JSON_OBJECT;
        return SynchronousCall.execute(this);
    }

    public ANResponse executeForObject(Class cls) {
        this.mType = cls;
        this.mResponseType = ResponseType.PARSED;
        return SynchronousCall.execute(this);
    }

    public ANResponse executeForObjectList(Class cls) {
        this.mType = C$Gson$Types.newParameterizedTypeWithOwner(null, List.class, cls);
        this.mResponseType = ResponseType.PARSED;
        return SynchronousCall.execute(this);
    }

    public ANResponse executeForOkHttpResponse() {
        this.mResponseType = ResponseType.OK_HTTP_RESPONSE;
        return SynchronousCall.execute(this);
    }

    public ANResponse executeForParsed(TypeToken typeToken) {
        this.mType = typeToken.getType();
        this.mResponseType = ResponseType.PARSED;
        return SynchronousCall.execute(this);
    }

    public ANResponse executeForString() {
        this.mResponseType = ResponseType.STRING;
        return SynchronousCall.execute(this);
    }

    public void finish() {
        destroy();
        ANRequestQueue.getInstance().finish(this);
    }

    public AnalyticsListener getAnalyticsListener() {
        return this.mAnalyticsListener;
    }

    public void getAsBitmap(BitmapRequestListener bitmapRequestListener) {
        this.mResponseType = ResponseType.BITMAP;
        this.mBitmapRequestListener = bitmapRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsJSONArray(JSONArrayRequestListener jSONArrayRequestListener) {
        this.mResponseType = ResponseType.JSON_ARRAY;
        this.mJSONArrayRequestListener = jSONArrayRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsJSONObject(JSONObjectRequestListener jSONObjectRequestListener) {
        this.mResponseType = ResponseType.JSON_OBJECT;
        this.mJSONObjectRequestListener = jSONObjectRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsObject(Class cls, ParsedRequestListener parsedRequestListener) {
        this.mType = cls;
        this.mResponseType = ResponseType.PARSED;
        this.mParsedRequestListener = parsedRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsObjectList(Class cls, ParsedRequestListener parsedRequestListener) {
        this.mType = C$Gson$Types.newParameterizedTypeWithOwner(null, List.class, cls);
        this.mResponseType = ResponseType.PARSED;
        this.mParsedRequestListener = parsedRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsOkHttpResponse(OkHttpResponseListener okHttpResponseListener) {
        this.mResponseType = ResponseType.OK_HTTP_RESPONSE;
        this.mOkHttpResponseListener = okHttpResponseListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsOkHttpResponseAndBitmap(OkHttpResponseAndBitmapRequestListener okHttpResponseAndBitmapRequestListener) {
        this.mResponseType = ResponseType.BITMAP;
        this.mOkHttpResponseAndBitmapRequestListener = okHttpResponseAndBitmapRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsOkHttpResponseAndJSONArray(OkHttpResponseAndJSONArrayRequestListener okHttpResponseAndJSONArrayRequestListener) {
        this.mResponseType = ResponseType.JSON_ARRAY;
        this.mOkHttpResponseAndJSONArrayRequestListener = okHttpResponseAndJSONArrayRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsOkHttpResponseAndJSONObject(OkHttpResponseAndJSONObjectRequestListener okHttpResponseAndJSONObjectRequestListener) {
        this.mResponseType = ResponseType.JSON_OBJECT;
        this.mOkHttpResponseAndJSONObjectRequestListener = okHttpResponseAndJSONObjectRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsOkHttpResponseAndObject(Class cls, OkHttpResponseAndParsedRequestListener okHttpResponseAndParsedRequestListener) {
        this.mType = cls;
        this.mResponseType = ResponseType.PARSED;
        this.mOkHttpResponseAndParsedRequestListener = okHttpResponseAndParsedRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsOkHttpResponseAndObjectList(Class cls, OkHttpResponseAndParsedRequestListener okHttpResponseAndParsedRequestListener) {
        this.mType = C$Gson$Types.newParameterizedTypeWithOwner(null, List.class, cls);
        this.mResponseType = ResponseType.PARSED;
        this.mOkHttpResponseAndParsedRequestListener = okHttpResponseAndParsedRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsOkHttpResponseAndParsed(TypeToken typeToken, OkHttpResponseAndParsedRequestListener okHttpResponseAndParsedRequestListener) {
        this.mType = typeToken.getType();
        this.mResponseType = ResponseType.PARSED;
        this.mOkHttpResponseAndParsedRequestListener = okHttpResponseAndParsedRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsOkHttpResponseAndString(OkHttpResponseAndStringRequestListener okHttpResponseAndStringRequestListener) {
        this.mResponseType = ResponseType.STRING;
        this.mOkHttpResponseAndStringRequestListener = okHttpResponseAndStringRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsParsed(TypeToken typeToken, ParsedRequestListener parsedRequestListener) {
        this.mType = typeToken.getType();
        this.mResponseType = ResponseType.PARSED;
        this.mParsedRequestListener = parsedRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public void getAsString(StringRequestListener stringRequestListener) {
        this.mResponseType = ResponseType.STRING;
        this.mStringRequestListener = stringRequestListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public CacheControl getCacheControl() {
        return this.mCacheControl;
    }

    public Call getCall() {
        return this.call;
    }

    public String getDirPath() {
        return this.mDirPath;
    }

    public DownloadProgressListener getDownloadProgressListener() {
        return new DownloadProgressListener() { // from class: com.androidnetworking.common.ANRequest.1
            @Override // com.androidnetworking.interfaces.DownloadProgressListener
            public void onProgress(long j, long j2) {
                if (ANRequest.this.mDownloadProgressListener != null && !ANRequest.this.isCancelled) {
                    ANRequest.this.mDownloadProgressListener.onProgress(j, j2);
                }
            }
        };
    }

    public String getFileName() {
        return this.mFileName;
    }

    public Future getFuture() {
        return this.future;
    }

    public Headers getHeaders() {
        Headers.Builder builder = new Headers.Builder();
        try {
            HashMap<String, List<String>> hashMap = this.mHeadersMap;
            if (hashMap != null) {
                for (Map.Entry<String, List<String>> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    List<String> value = entry.getValue();
                    if (value != null) {
                        Iterator<String> it = value.iterator();
                        while (it.hasNext()) {
                            builder.add(key, it.next());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.build();
    }

    public int getMethod() {
        return this.mMethod;
    }

    public RequestBody getMultiPartRequestBody() {
        MediaType parse;
        MediaType mediaType;
        MultipartBody.Builder builder = new MultipartBody.Builder();
        MediaType mediaType2 = this.customMediaType;
        if (mediaType2 == null) {
            mediaType2 = MultipartBody.FORM;
        }
        MultipartBody.Builder type = builder.setType(mediaType2);
        try {
            for (Map.Entry<String, MultipartStringBody> entry : this.mMultiPartParameterMap.entrySet()) {
                MultipartStringBody value = entry.getValue();
                String str = value.contentType;
                if (str != null) {
                    mediaType = MediaType.parse(str);
                } else {
                    mediaType = null;
                }
                type.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""), RequestBody.create(mediaType, value.value));
            }
            for (Map.Entry<String, List<MultipartFileBody>> entry2 : this.mMultiPartFileMap.entrySet()) {
                for (MultipartFileBody multipartFileBody : entry2.getValue()) {
                    String name = multipartFileBody.file.getName();
                    String str2 = multipartFileBody.contentType;
                    if (str2 != null) {
                        parse = MediaType.parse(str2);
                    } else {
                        parse = MediaType.parse(Utils.getMimeType(name));
                    }
                    type.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + entry2.getKey() + "\"; filename=\"" + name + "\""), RequestBody.create(parse, multipartFileBody.file));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return type.build();
    }

    public OkHttpClient getOkHttpClient() {
        return this.mOkHttpClient;
    }

    public Priority getPriority() {
        return this.mPriority;
    }

    public RequestBody getRequestBody() {
        String str = this.mApplicationJsonString;
        if (str != null) {
            MediaType mediaType = this.customMediaType;
            if (mediaType != null) {
                return RequestBody.create(mediaType, str);
            }
            return RequestBody.create(JSON_MEDIA_TYPE, str);
        }
        String str2 = this.mStringBody;
        if (str2 != null) {
            MediaType mediaType2 = this.customMediaType;
            if (mediaType2 != null) {
                return RequestBody.create(mediaType2, str2);
            }
            return RequestBody.create(MEDIA_TYPE_MARKDOWN, str2);
        }
        File file = this.mFile;
        if (file != null) {
            MediaType mediaType3 = this.customMediaType;
            if (mediaType3 != null) {
                return RequestBody.create(mediaType3, file);
            }
            return RequestBody.create(MEDIA_TYPE_MARKDOWN, file);
        }
        byte[] bArr = this.mByte;
        if (bArr != null) {
            MediaType mediaType4 = this.customMediaType;
            if (mediaType4 != null) {
                return RequestBody.create(mediaType4, bArr);
            }
            return RequestBody.create(MEDIA_TYPE_MARKDOWN, bArr);
        }
        FormBody.Builder builder = new FormBody.Builder();
        try {
            for (Map.Entry<String, String> entry : this.mBodyParameterMap.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
            for (Map.Entry<String, String> entry2 : this.mUrlEncodedFormBodyParameterMap.entrySet()) {
                builder.addEncoded(entry2.getKey(), entry2.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.build();
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public ResponseType getResponseAs() {
        return this.mResponseType;
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    public Object getTag() {
        return this.mTag;
    }

    public Type getType() {
        return this.mType;
    }

    public UploadProgressListener getUploadProgressListener() {
        return new UploadProgressListener() { // from class: com.androidnetworking.common.ANRequest.4
            @Override // com.androidnetworking.interfaces.UploadProgressListener
            public void onProgress(long j, long j2) {
                ANRequest.this.mProgress = (int) ((100 * j) / j2);
                if (ANRequest.this.mUploadProgressListener != null && !ANRequest.this.isCancelled) {
                    ANRequest.this.mUploadProgressListener.onProgress(j, j2);
                }
            }
        };
    }

    public String getUrl() {
        String str = this.mUrl;
        for (Map.Entry<String, String> entry : this.mPathParameterMap.entrySet()) {
            str = str.replace("{" + entry.getKey() + ooOOo0oXI.f33074oOoXoXO, String.valueOf(entry.getValue()));
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse(str).newBuilder();
        HashMap<String, List<String>> hashMap = this.mQueryParameterMap;
        if (hashMap != null) {
            for (Map.Entry<String, List<String>> entry2 : hashMap.entrySet()) {
                String key = entry2.getKey();
                List<String> value = entry2.getValue();
                if (value != null) {
                    Iterator<String> it = value.iterator();
                    while (it.hasNext()) {
                        newBuilder.addQueryParameter(key, it.next());
                    }
                }
            }
        }
        return newBuilder.build().toString();
    }

    public String getUserAgent() {
        return this.mUserAgent;
    }

    public boolean isCanceled() {
        return this.isCancelled;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public ANError parseNetworkError(ANError aNError) {
        try {
            if (aNError.getResponse() != null && aNError.getResponse().body() != null && aNError.getResponse().body().source() != null) {
                aNError.setErrorBody(Okio.buffer(aNError.getResponse().body().source()).readUtf8());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aNError;
    }

    public ANResponse parseResponse(Response response) {
        ANResponse<Bitmap> decodeBitmap;
        switch (AnonymousClass9.$SwitchMap$com$androidnetworking$common$ResponseType[this.mResponseType.ordinal()]) {
            case 1:
                try {
                    return ANResponse.success(new JSONArray(Okio.buffer(response.body().source()).readUtf8()));
                } catch (Exception e) {
                    return ANResponse.failed(Utils.getErrorForParse(new ANError(e)));
                }
            case 2:
                try {
                    return ANResponse.success(new JSONObject(Okio.buffer(response.body().source()).readUtf8()));
                } catch (Exception e2) {
                    return ANResponse.failed(Utils.getErrorForParse(new ANError(e2)));
                }
            case 3:
                try {
                    return ANResponse.success(Okio.buffer(response.body().source()).readUtf8());
                } catch (Exception e3) {
                    return ANResponse.failed(Utils.getErrorForParse(new ANError(e3)));
                }
            case 4:
                synchronized (sDecodeLock) {
                    try {
                        try {
                            decodeBitmap = Utils.decodeBitmap(response, this.mMaxWidth, this.mMaxHeight, this.mDecodeConfig, this.mScaleType);
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (Exception e4) {
                        return ANResponse.failed(Utils.getErrorForParse(new ANError(e4)));
                    }
                }
                return decodeBitmap;
            case 5:
                try {
                    return ANResponse.success(ParseUtil.getParserFactory().responseBodyParser(this.mType).convert(response.body()));
                } catch (Exception e5) {
                    return ANResponse.failed(Utils.getErrorForParse(new ANError(e5)));
                }
            case 6:
                try {
                    Okio.buffer(response.body().source()).skip(Long.MAX_VALUE);
                    return ANResponse.success(ANConstants.PREFETCH);
                } catch (Exception e6) {
                    return ANResponse.failed(Utils.getErrorForParse(new ANError(e6)));
                }
            default:
                return null;
        }
    }

    public void prefetch() {
        this.mResponseType = ResponseType.PREFETCH;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public T setAnalyticsListener(AnalyticsListener analyticsListener) {
        this.mAnalyticsListener = analyticsListener;
        return this;
    }

    public void setCall(Call call) {
        this.call = call;
    }

    public T setDownloadProgressListener(DownloadProgressListener downloadProgressListener) {
        this.mDownloadProgressListener = downloadProgressListener;
        return this;
    }

    public void setFuture(Future future) {
        this.future = future;
    }

    public void setProgress(int i) {
        this.mProgress = i;
    }

    public void setResponseAs(ResponseType responseType) {
        this.mResponseType = responseType;
    }

    public void setRunning(boolean z) {
        this.isRunning = z;
    }

    public void setSequenceNumber(int i) {
        this.sequenceNumber = i;
    }

    public void setType(Type type) {
        this.mType = type;
    }

    public T setUploadProgressListener(UploadProgressListener uploadProgressListener) {
        this.mUploadProgressListener = uploadProgressListener;
        return this;
    }

    public void setUserAgent(String str) {
        this.mUserAgent = str;
    }

    public void startDownload(DownloadListener downloadListener) {
        this.mDownloadListener = downloadListener;
        ANRequestQueue.getInstance().addRequest(this);
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.sequenceNumber + ", mMethod=" + this.mMethod + ", mPriority=" + this.mPriority + ", mRequestType=" + this.mRequestType + ", mUrl=" + this.mUrl + '}';
    }

    public void updateDownloadCompletion() {
        this.isDelivered = true;
        if (this.mDownloadListener != null) {
            if (!this.isCancelled) {
                Executor executor = this.mExecutor;
                if (executor != null) {
                    executor.execute(new Runnable() { // from class: com.androidnetworking.common.ANRequest.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ANRequest.this.mDownloadListener != null) {
                                ANRequest.this.mDownloadListener.onDownloadComplete();
                            }
                            ANRequest.this.finish();
                        }
                    });
                    return;
                } else {
                    Core.getInstance().getExecutorSupplier().forMainThreadTasks().execute(new Runnable() { // from class: com.androidnetworking.common.ANRequest.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ANRequest.this.mDownloadListener != null) {
                                ANRequest.this.mDownloadListener.onDownloadComplete();
                            }
                            ANRequest.this.finish();
                        }
                    });
                    return;
                }
            }
            deliverError(new ANError());
            finish();
            return;
        }
        finish();
    }

    public ANRequest(PostRequestBuilder postRequestBuilder) {
        this.mHeadersMap = new HashMap<>();
        this.mBodyParameterMap = new HashMap<>();
        this.mUrlEncodedFormBodyParameterMap = new HashMap<>();
        this.mMultiPartParameterMap = new HashMap<>();
        this.mQueryParameterMap = new HashMap<>();
        this.mPathParameterMap = new HashMap<>();
        this.mMultiPartFileMap = new HashMap<>();
        this.mApplicationJsonString = null;
        this.mStringBody = null;
        this.mByte = null;
        this.mFile = null;
        this.customMediaType = null;
        this.mPercentageThresholdForCancelling = 0;
        this.mCacheControl = null;
        this.mExecutor = null;
        this.mOkHttpClient = null;
        this.mUserAgent = null;
        this.mType = null;
        this.mRequestType = 0;
        this.mMethod = postRequestBuilder.mMethod;
        this.mPriority = postRequestBuilder.mPriority;
        this.mUrl = postRequestBuilder.mUrl;
        this.mTag = postRequestBuilder.mTag;
        this.mHeadersMap = postRequestBuilder.mHeadersMap;
        this.mBodyParameterMap = postRequestBuilder.mBodyParameterMap;
        this.mUrlEncodedFormBodyParameterMap = postRequestBuilder.mUrlEncodedFormBodyParameterMap;
        this.mQueryParameterMap = postRequestBuilder.mQueryParameterMap;
        this.mPathParameterMap = postRequestBuilder.mPathParameterMap;
        this.mApplicationJsonString = postRequestBuilder.mApplicationJsonString;
        this.mStringBody = postRequestBuilder.mStringBody;
        this.mFile = postRequestBuilder.mFile;
        this.mByte = postRequestBuilder.mByte;
        this.mCacheControl = postRequestBuilder.mCacheControl;
        this.mExecutor = postRequestBuilder.mExecutor;
        this.mOkHttpClient = postRequestBuilder.mOkHttpClient;
        this.mUserAgent = postRequestBuilder.mUserAgent;
        if (postRequestBuilder.mCustomContentType != null) {
            this.customMediaType = MediaType.parse(postRequestBuilder.mCustomContentType);
        }
    }

    public ANRequest(DownloadBuilder downloadBuilder) {
        this.mHeadersMap = new HashMap<>();
        this.mBodyParameterMap = new HashMap<>();
        this.mUrlEncodedFormBodyParameterMap = new HashMap<>();
        this.mMultiPartParameterMap = new HashMap<>();
        this.mQueryParameterMap = new HashMap<>();
        this.mPathParameterMap = new HashMap<>();
        this.mMultiPartFileMap = new HashMap<>();
        this.mApplicationJsonString = null;
        this.mStringBody = null;
        this.mByte = null;
        this.mFile = null;
        this.customMediaType = null;
        this.mPercentageThresholdForCancelling = 0;
        this.mCacheControl = null;
        this.mExecutor = null;
        this.mOkHttpClient = null;
        this.mUserAgent = null;
        this.mType = null;
        this.mRequestType = 1;
        this.mMethod = 0;
        this.mPriority = downloadBuilder.mPriority;
        this.mUrl = downloadBuilder.mUrl;
        this.mTag = downloadBuilder.mTag;
        this.mDirPath = downloadBuilder.mDirPath;
        this.mFileName = downloadBuilder.mFileName;
        this.mHeadersMap = downloadBuilder.mHeadersMap;
        this.mQueryParameterMap = downloadBuilder.mQueryParameterMap;
        this.mPathParameterMap = downloadBuilder.mPathParameterMap;
        this.mCacheControl = downloadBuilder.mCacheControl;
        this.mPercentageThresholdForCancelling = downloadBuilder.mPercentageThresholdForCancelling;
        this.mExecutor = downloadBuilder.mExecutor;
        this.mOkHttpClient = downloadBuilder.mOkHttpClient;
        this.mUserAgent = downloadBuilder.mUserAgent;
    }

    public ANRequest(MultiPartBuilder multiPartBuilder) {
        this.mHeadersMap = new HashMap<>();
        this.mBodyParameterMap = new HashMap<>();
        this.mUrlEncodedFormBodyParameterMap = new HashMap<>();
        this.mMultiPartParameterMap = new HashMap<>();
        this.mQueryParameterMap = new HashMap<>();
        this.mPathParameterMap = new HashMap<>();
        this.mMultiPartFileMap = new HashMap<>();
        this.mApplicationJsonString = null;
        this.mStringBody = null;
        this.mByte = null;
        this.mFile = null;
        this.customMediaType = null;
        this.mPercentageThresholdForCancelling = 0;
        this.mCacheControl = null;
        this.mExecutor = null;
        this.mOkHttpClient = null;
        this.mUserAgent = null;
        this.mType = null;
        this.mRequestType = 2;
        this.mMethod = 1;
        this.mPriority = multiPartBuilder.mPriority;
        this.mUrl = multiPartBuilder.mUrl;
        this.mTag = multiPartBuilder.mTag;
        this.mHeadersMap = multiPartBuilder.mHeadersMap;
        this.mQueryParameterMap = multiPartBuilder.mQueryParameterMap;
        this.mPathParameterMap = multiPartBuilder.mPathParameterMap;
        this.mMultiPartParameterMap = multiPartBuilder.mMultiPartParameterMap;
        this.mMultiPartFileMap = multiPartBuilder.mMultiPartFileMap;
        this.mCacheControl = multiPartBuilder.mCacheControl;
        this.mPercentageThresholdForCancelling = multiPartBuilder.mPercentageThresholdForCancelling;
        this.mExecutor = multiPartBuilder.mExecutor;
        this.mOkHttpClient = multiPartBuilder.mOkHttpClient;
        this.mUserAgent = multiPartBuilder.mUserAgent;
        if (multiPartBuilder.mCustomContentType != null) {
            this.customMediaType = MediaType.parse(multiPartBuilder.mCustomContentType);
        }
    }
}
