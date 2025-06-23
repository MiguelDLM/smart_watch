package com.sma.smartv3.work;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.Keep;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.model.AppendObjectRequest;
import com.alibaba.sdk.android.oss.model.AppendObjectResult;
import com.alibaba.sdk.android.oss.model.HeadObjectRequest;
import com.alibaba.sdk.android.oss.model.HeadObjectResult;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.db.entity.AlipayBindInfo;
import com.sma.smartv3.db.entity.BloodOxygen;
import com.sma.smartv3.db.entity.BloodPressure;
import com.sma.smartv3.db.entity.HeartRate;
import com.sma.smartv3.db.entity.Hrv;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.Sleep;
import com.sma.smartv3.db.entity.Temperature;
import com.sma.smartv3.db.entity.Weight;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.JsonFieldContainer;
import com.sma.smartv3.model.SMADataUploadData;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.work.UploadOSSWorker;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.StringsKt__StringsKt;
import x0xO.XO;

@XX({"SMAP\nOSSWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSSWorker.kt\ncom/sma/smartv3/work/UploadOSSWorker\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 5 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,520:1\n19#2:521\n15#2:522\n93#2,2:543\n90#2:545\n19#2:566\n15#2:567\n1855#3,2:523\n1855#3,2:525\n1855#3,2:527\n1855#3,2:529\n1855#3,2:531\n1855#3,2:533\n1855#3,2:535\n1855#3,2:537\n1855#3,2:539\n1855#3,2:541\n101#4,11:546\n121#4:565\n156#5,7:557\n174#5:564\n*S KotlinDebug\n*F\n+ 1 OSSWorker.kt\ncom/sma/smartv3/work/UploadOSSWorker\n*L\n85#1:521\n85#1:522\n331#1:543,2\n331#1:545\n371#1:566\n371#1:567\n93#1:523,2\n114#1:525,2\n129#1:527,2\n145#1:529,2\n161#1:531,2\n176#1:533,2\n194#1:535,2\n211#1:537,2\n226#1:539,2\n269#1:541,2\n344#1:546,11\n344#1:565\n344#1:557,7\n344#1:564\n*E\n"})
/* loaded from: classes12.dex */
public final class UploadOSSWorker {

    /* renamed from: X0o0xo, reason: collision with root package name */
    @oOoXoXO
    public static xxxI.II0xO0<Object> f25798X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final UploadOSSWorker f25800oIX0oI = new UploadOSSWorker();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public static final StringBuffer f25797II0xO0 = new StringBuffer();

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public static final String f25796I0Io = "UploadOSSWorker";

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public static final String f25801oxoX = "OSSExpiryTime";

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public static String f25799XO = "";

    @Keep
    /* loaded from: classes12.dex */
    public static final class Credentials extends JsonFieldContainer implements Serializable {

        @OOXIXo
        private final String accessKeyId;

        @OOXIXo
        private final String accessKeySecret;

        @OOXIXo
        private final String expiration;

        @OOXIXo
        private final String securityToken;

        public Credentials() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Credentials copy$default(Credentials credentials, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = credentials.securityToken;
            }
            if ((i & 2) != 0) {
                str2 = credentials.accessKeySecret;
            }
            if ((i & 4) != 0) {
                str3 = credentials.accessKeyId;
            }
            if ((i & 8) != 0) {
                str4 = credentials.expiration;
            }
            return credentials.copy(str, str2, str3, str4);
        }

        @OOXIXo
        public final String component1() {
            return this.securityToken;
        }

        @OOXIXo
        public final String component2() {
            return this.accessKeySecret;
        }

        @OOXIXo
        public final String component3() {
            return this.accessKeyId;
        }

        @OOXIXo
        public final String component4() {
            return this.expiration;
        }

        @OOXIXo
        public final Credentials copy(@OOXIXo String securityToken, @OOXIXo String accessKeySecret, @OOXIXo String accessKeyId, @OOXIXo String expiration) {
            IIX0o.x0xO0oo(securityToken, "securityToken");
            IIX0o.x0xO0oo(accessKeySecret, "accessKeySecret");
            IIX0o.x0xO0oo(accessKeyId, "accessKeyId");
            IIX0o.x0xO0oo(expiration, "expiration");
            return new Credentials(securityToken, accessKeySecret, accessKeyId, expiration);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Credentials)) {
                return false;
            }
            Credentials credentials = (Credentials) obj;
            return IIX0o.Oxx0IOOO(this.securityToken, credentials.securityToken) && IIX0o.Oxx0IOOO(this.accessKeySecret, credentials.accessKeySecret) && IIX0o.Oxx0IOOO(this.accessKeyId, credentials.accessKeyId) && IIX0o.Oxx0IOOO(this.expiration, credentials.expiration);
        }

        @OOXIXo
        public final String getAccessKeyId() {
            return this.accessKeyId;
        }

        @OOXIXo
        public final String getAccessKeySecret() {
            return this.accessKeySecret;
        }

        @OOXIXo
        public final String getExpiration() {
            return this.expiration;
        }

        @OOXIXo
        public final String getSecurityToken() {
            return this.securityToken;
        }

        public int hashCode() {
            return (((((this.securityToken.hashCode() * 31) + this.accessKeySecret.hashCode()) * 31) + this.accessKeyId.hashCode()) * 31) + this.expiration.hashCode();
        }

        @OOXIXo
        public String toString() {
            return "Credentials(securityToken=" + this.securityToken + ", accessKeySecret=" + this.accessKeySecret + ", accessKeyId=" + this.accessKeyId + ", expiration=" + this.expiration + HexStringBuilder.COMMENT_END_CHAR;
        }

        public /* synthetic */ Credentials(String str, String str2, String str3, String str4, int i, IIXOooo iIXOooo) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
        }

        public Credentials(@OOXIXo String securityToken, @OOXIXo String accessKeySecret, @OOXIXo String accessKeyId, @OOXIXo String expiration) {
            IIX0o.x0xO0oo(securityToken, "securityToken");
            IIX0o.x0xO0oo(accessKeySecret, "accessKeySecret");
            IIX0o.x0xO0oo(accessKeyId, "accessKeyId");
            IIX0o.x0xO0oo(expiration, "expiration");
            this.securityToken = securityToken;
            this.accessKeySecret = accessKeySecret;
            this.accessKeyId = accessKeyId;
            this.expiration = expiration;
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements OSSCompletedCallback<HeadObjectRequest, HeadObjectResult> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ xxxI.II0xO0<Long> f25806oIX0oI;

        public II0xO0(xxxI.II0xO0<Long> iI0xO0) {
            this.f25806oIX0oI = iI0xO0;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@oOoXoXO HeadObjectRequest headObjectRequest, @OOXIXo HeadObjectResult result) {
            IIX0o.x0xO0oo(result, "result");
            this.f25806oIX0oI.handleResponse(Long.valueOf(result.getMetadata().getContentLength()));
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public void onFailure(@oOoXoXO HeadObjectRequest headObjectRequest, @OOXIXo ClientException clientExcepion, @OOXIXo ServiceException serviceException) {
            IIX0o.x0xO0oo(clientExcepion, "clientExcepion");
            IIX0o.x0xO0oo(serviceException, "serviceException");
            clientExcepion.printStackTrace();
            this.f25806oIX0oI.handleError(clientExcepion.toString());
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            oix0oi.oIX0oI(TokenParser.SP + UploadOSSWorker.f25796I0Io + " clientExcepion? handleError  ServiceException = " + clientExcepion);
            oix0oi.oIX0oI(TokenParser.SP + UploadOSSWorker.f25796I0Io + " serviceException? handleError  ServiceException = " + clientExcepion);
            StringBuilder sb = new StringBuilder();
            sb.append(UploadOSSWorker.f25796I0Io);
            sb.append(" ErrorCode ");
            sb.append(serviceException.getErrorCode());
            oix0oi.II0xO0(sb.toString());
            oix0oi.II0xO0(UploadOSSWorker.f25796I0Io + " RequestId " + serviceException.getRequestId());
            oix0oi.II0xO0(UploadOSSWorker.f25796I0Io + " HostId " + serviceException.getHostId());
            oix0oi.II0xO0(UploadOSSWorker.f25796I0Io + " RawMessage " + serviceException.getRawMessage());
            this.f25806oIX0oI.handleError(clientExcepion.toString());
        }
    }

    @Keep
    /* loaded from: classes12.dex */
    public static final class ResponseData extends JsonFieldContainer implements Serializable {

        @oOoXoXO
        private final Credentials credentials;

        /* JADX WARN: Multi-variable type inference failed */
        public ResponseData() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ResponseData copy$default(ResponseData responseData, Credentials credentials, int i, Object obj) {
            if ((i & 1) != 0) {
                credentials = responseData.credentials;
            }
            return responseData.copy(credentials);
        }

        @oOoXoXO
        public final Credentials component1() {
            return this.credentials;
        }

        @OOXIXo
        public final ResponseData copy(@oOoXoXO Credentials credentials) {
            return new ResponseData(credentials);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ResponseData) && IIX0o.Oxx0IOOO(this.credentials, ((ResponseData) obj).credentials);
        }

        @oOoXoXO
        public final Credentials getCredentials() {
            return this.credentials;
        }

        public int hashCode() {
            Credentials credentials = this.credentials;
            if (credentials == null) {
                return 0;
            }
            return credentials.hashCode();
        }

        @OOXIXo
        public String toString() {
            return "ResponseData(credentials=" + this.credentials + HexStringBuilder.COMMENT_END_CHAR;
        }

        public /* synthetic */ ResponseData(Credentials credentials, int i, IIXOooo iIXOooo) {
            this((i & 1) != 0 ? null : credentials);
        }

        public ResponseData(@oOoXoXO Credentials credentials) {
            this.credentials = credentials;
        }
    }

    @Keep
    /* loaded from: classes12.dex */
    public static final class StsRamData extends JsonFieldContainer implements Serializable {

        @OOXIXo
        private final String bucket;

        @OOXIXo
        private final String endPoint;

        @oOoXoXO
        private final ResponseData response;

        public StsRamData() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ StsRamData copy$default(StsRamData stsRamData, String str, String str2, ResponseData responseData, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stsRamData.bucket;
            }
            if ((i & 2) != 0) {
                str2 = stsRamData.endPoint;
            }
            if ((i & 4) != 0) {
                responseData = stsRamData.response;
            }
            return stsRamData.copy(str, str2, responseData);
        }

        @OOXIXo
        public final String component1() {
            return this.bucket;
        }

        @OOXIXo
        public final String component2() {
            return this.endPoint;
        }

        @oOoXoXO
        public final ResponseData component3() {
            return this.response;
        }

        @OOXIXo
        public final StsRamData copy(@OOXIXo String bucket, @OOXIXo String endPoint, @oOoXoXO ResponseData responseData) {
            IIX0o.x0xO0oo(bucket, "bucket");
            IIX0o.x0xO0oo(endPoint, "endPoint");
            return new StsRamData(bucket, endPoint, responseData);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StsRamData)) {
                return false;
            }
            StsRamData stsRamData = (StsRamData) obj;
            return IIX0o.Oxx0IOOO(this.bucket, stsRamData.bucket) && IIX0o.Oxx0IOOO(this.endPoint, stsRamData.endPoint) && IIX0o.Oxx0IOOO(this.response, stsRamData.response);
        }

        @OOXIXo
        public final String getBucket() {
            return this.bucket;
        }

        @OOXIXo
        public final String getEndPoint() {
            return this.endPoint;
        }

        @oOoXoXO
        public final ResponseData getResponse() {
            return this.response;
        }

        public int hashCode() {
            int hashCode = ((this.bucket.hashCode() * 31) + this.endPoint.hashCode()) * 31;
            ResponseData responseData = this.response;
            return hashCode + (responseData == null ? 0 : responseData.hashCode());
        }

        @OOXIXo
        public String toString() {
            return "StsRamData(bucket=" + this.bucket + ", endPoint=" + this.endPoint + ", response=" + this.response + HexStringBuilder.COMMENT_END_CHAR;
        }

        public /* synthetic */ StsRamData(String str, String str2, ResponseData responseData, int i, IIXOooo iIXOooo) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : responseData);
        }

        public StsRamData(@OOXIXo String bucket, @OOXIXo String endPoint, @oOoXoXO ResponseData responseData) {
            IIX0o.x0xO0oo(bucket, "bucket");
            IIX0o.x0xO0oo(endPoint, "endPoint");
            this.bucket = bucket;
            this.endPoint = endPoint;
            this.response = responseData;
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements OSSCompletedCallback<AppendObjectRequest, AppendObjectResult> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ File f25816oIX0oI;

        public oIX0oI(File file) {
            this.f25816oIX0oI = file;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@oOoXoXO AppendObjectRequest appendObjectRequest, @OOXIXo AppendObjectResult result) {
            IIX0o.x0xO0oo(result, "result");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(UploadOSSWorker.f25796I0Io + " AppendSuccess , NextPosition " + result.getNextPosition());
            if (this.f25816oIX0oI.exists()) {
                FileUtils.delete(this.f25816oIX0oI);
                xxxI.II0xO0 iI0xO0 = UploadOSSWorker.f25798X0o0xo;
                if (iI0xO0 != null) {
                    iI0xO0.handleResponse("append success");
                }
            }
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public void onFailure(@oOoXoXO AppendObjectRequest appendObjectRequest, @OOXIXo ClientException clientExcepion, @OOXIXo ServiceException serviceException) {
            IIX0o.x0xO0oo(clientExcepion, "clientExcepion");
            IIX0o.x0xO0oo(serviceException, "serviceException");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(UploadOSSWorker.f25796I0Io + " append failure request = " + appendObjectRequest);
            xxxI.II0xO0 iI0xO0 = UploadOSSWorker.f25798X0o0xo;
            if (iI0xO0 != null) {
                iI0xO0.handleResponse("append failure request = " + appendObjectRequest);
            }
        }
    }

    public static final void XO(AppendObjectRequest appendObjectRequest, long j, long j2) {
    }

    public final long II0XooXoX(long j) {
        return (j - SMADataUploadData.defaultTime) / 1000;
    }

    public final <T> void OOXIXo(@OOXIXo List<? extends T> dataList, @OOXIXo xxxI.II0xO0<Object> callback) {
        IIX0o.x0xO0oo(dataList, "dataList");
        IIX0o.x0xO0oo(callback, "callback");
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(" generateFile dataList.isEmpty() =  " + dataList.isEmpty());
        if (dataList.isEmpty()) {
            return;
        }
        String str = "";
        if (IIX0o.Oxx0IOOO(f25799XO, String.valueOf(CollectionsKt___CollectionsKt.O0O0Io00X(dataList)))) {
            oix0oi.II0xO0("generateFile   handleError -->  \nlastClass = " + f25799XO + " , \ndataList.last() = " + CollectionsKt___CollectionsKt.O0O0Io00X(dataList));
            callback.handleError("");
            return;
        }
        f25799XO = String.valueOf(CollectionsKt___CollectionsKt.O0O0Io00X(dataList));
        f25798X0o0xo = callback;
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        AppUser appUser2 = (AppUser) appUser;
        StringBuffer stringBuffer = f25797II0xO0;
        stringBuffer.delete(0, stringBuffer.length());
        if (Activity.class.isInstance(CollectionsKt___CollectionsKt.O0OOX0IIx(dataList))) {
            str = appUser2.getIdentity() + '1';
            for (T t : dataList) {
                IIX0o.x0XOIxOo(t, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Activity");
                Activity activity = (Activity) t;
                activity.setMIsSync(1);
                StringBuffer stringBuffer2 = f25797II0xO0;
                stringBuffer2.append("1");
                stringBuffer2.append('\t');
                stringBuffer2.append(f25800oIX0oI.II0XooXoX(activity.getMTime()));
                stringBuffer2.append('\t');
                stringBuffer2.append(activity.getMMode());
                stringBuffer2.append('\t');
                stringBuffer2.append(activity.getMState());
                stringBuffer2.append('\t');
                stringBuffer2.append(activity.getMStep());
                stringBuffer2.append('\t');
                stringBuffer2.append(activity.getMCalorie() / 10000);
                stringBuffer2.append('\t');
                stringBuffer2.append(activity.getMDistance() / 10000);
                stringBuffer2.append('\t');
                stringBuffer2.append(activity.getMIsDelete());
                stringBuffer2.append('\t');
                stringBuffer2.append('\n');
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            }
        } else if (HeartRate.class.isInstance(CollectionsKt___CollectionsKt.O0OOX0IIx(dataList))) {
            str = appUser2.getIdentity() + '3';
            for (T t2 : dataList) {
                IIX0o.x0XOIxOo(t2, "null cannot be cast to non-null type com.sma.smartv3.db.entity.HeartRate");
                HeartRate heartRate = (HeartRate) t2;
                heartRate.setMIsSync(1);
                StringBuffer stringBuffer3 = f25797II0xO0;
                stringBuffer3.append("3");
                stringBuffer3.append('\t');
                stringBuffer3.append(f25800oIX0oI.II0XooXoX(heartRate.getMTime()));
                stringBuffer3.append('\t');
                stringBuffer3.append(heartRate.getMBpm());
                stringBuffer3.append('\t');
                stringBuffer3.append('\n');
                oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
            }
        } else if (Hrv.class.isInstance(CollectionsKt___CollectionsKt.O0OOX0IIx(dataList))) {
            str = appUser2.getIdentity() + "10";
            for (T t3 : dataList) {
                IIX0o.x0XOIxOo(t3, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Hrv");
                Hrv hrv = (Hrv) t3;
                hrv.setMIsSync(1);
                StringBuffer stringBuffer4 = f25797II0xO0;
                stringBuffer4.append("10");
                stringBuffer4.append('\t');
                stringBuffer4.append(f25800oIX0oI.II0XooXoX(hrv.getMTime()));
                stringBuffer4.append('\t');
                stringBuffer4.append(hrv.getMValue());
                stringBuffer4.append('\t');
                stringBuffer4.append(hrv.getMAvgValue());
                stringBuffer4.append('\t');
                stringBuffer4.append('\n');
                oXIO0o0XI oxio0o0xi3 = oXIO0o0XI.f29392oIX0oI;
            }
        } else if (BloodPressure.class.isInstance(CollectionsKt___CollectionsKt.O0OOX0IIx(dataList))) {
            str = appUser2.getIdentity() + '2';
            for (T t4 : dataList) {
                IIX0o.x0XOIxOo(t4, "null cannot be cast to non-null type com.sma.smartv3.db.entity.BloodPressure");
                BloodPressure bloodPressure = (BloodPressure) t4;
                bloodPressure.setMIsSync(1);
                StringBuffer stringBuffer5 = f25797II0xO0;
                stringBuffer5.append("2");
                stringBuffer5.append('\t');
                stringBuffer5.append(f25800oIX0oI.II0XooXoX(bloodPressure.getMTime()));
                stringBuffer5.append('\t');
                stringBuffer5.append(bloodPressure.getMSystolic());
                stringBuffer5.append('\t');
                stringBuffer5.append(bloodPressure.getMDiastolic());
                stringBuffer5.append('\t');
                stringBuffer5.append('\n');
                oXIO0o0XI oxio0o0xi4 = oXIO0o0XI.f29392oIX0oI;
            }
        } else if (BloodOxygen.class.isInstance(CollectionsKt___CollectionsKt.O0OOX0IIx(dataList))) {
            str = appUser2.getIdentity() + '9';
            for (T t5 : dataList) {
                IIX0o.x0XOIxOo(t5, "null cannot be cast to non-null type com.sma.smartv3.db.entity.BloodOxygen");
                BloodOxygen bloodOxygen = (BloodOxygen) t5;
                bloodOxygen.setMIsSync(1);
                StringBuffer stringBuffer6 = f25797II0xO0;
                stringBuffer6.append("9");
                stringBuffer6.append('\t');
                stringBuffer6.append(f25800oIX0oI.II0XooXoX(bloodOxygen.getMTime()));
                stringBuffer6.append('\t');
                stringBuffer6.append(bloodOxygen.getMValue());
                stringBuffer6.append('\t');
                stringBuffer6.append('\n');
                oXIO0o0XI oxio0o0xi5 = oXIO0o0XI.f29392oIX0oI;
            }
        } else if (Location.class.isInstance(CollectionsKt___CollectionsKt.O0OOX0IIx(dataList))) {
            str = appUser2.getIdentity() + '4';
            for (T t6 : dataList) {
                IIX0o.x0XOIxOo(t6, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Location");
                Location location = (Location) t6;
                location.setMIsSync(1);
                StringBuffer stringBuffer7 = f25797II0xO0;
                stringBuffer7.append("4");
                stringBuffer7.append('\t');
                stringBuffer7.append(f25800oIX0oI.II0XooXoX(location.getMTime()));
                stringBuffer7.append('\t');
                stringBuffer7.append(location.getMAltitude());
                stringBuffer7.append('\t');
                stringBuffer7.append(location.getMLongitude());
                stringBuffer7.append('\t');
                stringBuffer7.append(location.getMLatitude());
                stringBuffer7.append('\t');
                stringBuffer7.append(location.getMSource());
                stringBuffer7.append('\t');
                stringBuffer7.append('\n');
                oXIO0o0XI oxio0o0xi6 = oXIO0o0XI.f29392oIX0oI;
            }
        } else if (Sleep.class.isInstance(CollectionsKt___CollectionsKt.O0OOX0IIx(dataList))) {
            str = appUser2.getIdentity() + '5';
            for (T t7 : dataList) {
                IIX0o.x0XOIxOo(t7, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Sleep");
                Sleep sleep = (Sleep) t7;
                sleep.setMIsSync(1);
                StringBuffer stringBuffer8 = f25797II0xO0;
                stringBuffer8.append("5");
                stringBuffer8.append('\t');
                stringBuffer8.append(f25800oIX0oI.II0XooXoX(sleep.getMTime()));
                stringBuffer8.append('\t');
                stringBuffer8.append(sleep.getMMode());
                stringBuffer8.append('\t');
                stringBuffer8.append(sleep.getMSoft());
                stringBuffer8.append('\t');
                stringBuffer8.append(sleep.getMStrong());
                stringBuffer8.append('\t');
                stringBuffer8.append('\n');
                oXIO0o0XI oxio0o0xi7 = oXIO0o0XI.f29392oIX0oI;
            }
        } else if (Weight.class.isInstance(CollectionsKt___CollectionsKt.O0OOX0IIx(dataList))) {
            str = appUser2.getIdentity() + '6';
            for (T t8 : dataList) {
                IIX0o.x0XOIxOo(t8, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Weight");
                Weight weight = (Weight) t8;
                weight.setMIsSync(1);
                StringBuffer stringBuffer9 = f25797II0xO0;
                stringBuffer9.append("6");
                stringBuffer9.append('\t');
                stringBuffer9.append(f25800oIX0oI.II0XooXoX(weight.getMTime()));
                stringBuffer9.append('\t');
                stringBuffer9.append(weight.getMWeight());
                stringBuffer9.append('\t');
                stringBuffer9.append('\n');
                oXIO0o0XI oxio0o0xi8 = oXIO0o0XI.f29392oIX0oI;
            }
        } else if (Workout.class.isInstance(CollectionsKt___CollectionsKt.O0OOX0IIx(dataList))) {
            str = appUser2.getIdentity() + '7';
            for (T t9 : dataList) {
                IIX0o.x0XOIxOo(t9, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Workout");
                Workout workout = (Workout) t9;
                workout.setMIsSync(1);
                StringBuffer stringBuffer10 = f25797II0xO0;
                stringBuffer10.append("7");
                stringBuffer10.append('\t');
                UploadOSSWorker uploadOSSWorker = f25800oIX0oI;
                stringBuffer10.append(uploadOSSWorker.II0XooXoX(workout.getMStart()));
                stringBuffer10.append('\t');
                stringBuffer10.append(uploadOSSWorker.II0XooXoX(workout.getMEnd()));
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMDuration());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMAltitude());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMAirPressure());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMSpm());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMMode());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMStep());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMDistance());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMCalorie());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMSpeed());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMPace());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMIsDelete());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMAvgBpm());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMMaxBpm());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMMinBpm());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMMaxSpm());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMMinSpm());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMMaxPace());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMMinPace());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMMaxAltitude());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMMinAltitude());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMMinStress());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMMaxStress());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMAvgStress());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMSource());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMFeel());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMPrototype());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMFirmwareFlag());
                stringBuffer10.append('\t');
                stringBuffer10.append(workout.getMBleName());
                stringBuffer10.append('\t');
                stringBuffer10.append('\n');
                oXIO0o0XI oxio0o0xi9 = oXIO0o0XI.f29392oIX0oI;
            }
        } else if (Temperature.class.isInstance(CollectionsKt___CollectionsKt.O0OOX0IIx(dataList))) {
            str = appUser2.getIdentity() + '8';
            for (T t10 : dataList) {
                IIX0o.x0XOIxOo(t10, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Temperature");
                Temperature temperature = (Temperature) t10;
                temperature.setMIsSync(1);
                StringBuffer stringBuffer11 = f25797II0xO0;
                stringBuffer11.append("8");
                stringBuffer11.append('\t');
                stringBuffer11.append(f25800oIX0oI.II0XooXoX(temperature.getMTime()));
                stringBuffer11.append('\t');
                stringBuffer11.append(temperature.getMTemperature());
                stringBuffer11.append('\t');
                stringBuffer11.append('\n');
                oXIO0o0XI oxio0o0xi10 = oXIO0o0XI.f29392oIX0oI;
            }
        } else {
            AlipayBindInfo.class.isInstance(CollectionsKt___CollectionsKt.O0OOX0IIx(dataList));
        }
        if (str.length() > 0) {
            File file = new File(IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI), str);
            StringBuffer stringBuffer12 = f25797II0xO0;
            FileIOUtils.writeFileFromString(file, stringBuffer12.toString());
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(f25796I0Io + " :  cacheFile = " + file.getPath() + "  content  :\n" + ((Object) stringBuffer12));
            try {
                Oo(file);
            } catch (Exception e) {
                callback.handleError(e.toString());
            }
        }
    }

    public final void Oo(@OOXIXo File cacheFile) {
        Credentials credentials;
        String expiration;
        IIX0o.x0xO0oo(cacheFile, "cacheFile");
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        String str = f25801oxoX;
        Object fromJson = new Gson().fromJson(XO2.getString(str + '_' + StsRamData.class.getName()), (Class<Object>) StsRamData.class);
        if (fromJson == null) {
            fromJson = StsRamData.class.newInstance();
        }
        StsRamData stsRamData = (StsRamData) fromJson;
        ResponseData response = stsRamData.getResponse();
        if (response != null && (credentials = response.getCredentials()) != null && (expiration = credentials.getExpiration()) != null && expiration.length() > 0) {
            if (xoIox(stsRamData.getResponse().getCredentials().getExpiration())) {
                x0XOIxOo(cacheFile);
                return;
            } else {
                xxIXOIIO(stsRamData, cacheFile);
                return;
            }
        }
        x0XOIxOo(cacheFile);
    }

    public final void Oxx0IOOO(@OOXIXo final String fileName, @OOXIXo final OSSClient oss, @OOXIXo final String bucket, @OOXIXo final File cacheFile) {
        IIX0o.x0xO0oo(fileName, "fileName");
        IIX0o.x0xO0oo(oss, "oss");
        IIX0o.x0xO0oo(bucket, "bucket");
        IIX0o.x0xO0oo(cacheFile, "cacheFile");
        final AppendObjectRequest appendObjectRequest = new AppendObjectRequest(bucket, "db/" + fileName, cacheFile.getPath());
        x0xO0oo(fileName, oss, bucket, new xxxI.II0xO0<Boolean>() { // from class: com.sma.smartv3.work.UploadOSSWorker$appendUpload$1
            @Override // xxxI.II0xO0
            public void handleError(@OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                xxxI.II0xO0 iI0xO0 = UploadOSSWorker.f25798X0o0xo;
                if (iI0xO0 != null) {
                    iI0xO0.handleResponse(error);
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(UploadOSSWorker.f25796I0Io + "  file is not exist, handleError  error = " + error);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@oOoXoXO Boolean bool) {
                if (!IIX0o.Oxx0IOOO(bool, Boolean.TRUE)) {
                    UploadOSSWorker.f25800oIX0oI.X0o0xo(appendObjectRequest, oss, 0L, cacheFile);
                    return;
                }
                UploadOSSWorker uploadOSSWorker = UploadOSSWorker.f25800oIX0oI;
                String str = fileName;
                final OSSClient oSSClient = oss;
                String str2 = bucket;
                final AppendObjectRequest appendObjectRequest2 = appendObjectRequest;
                final File file = cacheFile;
                uploadOSSWorker.ooOOo0oXI(str, oSSClient, str2, new xxxI.II0xO0<Long>() { // from class: com.sma.smartv3.work.UploadOSSWorker$appendUpload$1$handleResponse$1
                    @Override // xxxI.II0xO0
                    public void handleError(@OOXIXo String error) {
                        IIX0o.x0xO0oo(error, "error");
                        xxxI.II0xO0 iI0xO0 = UploadOSSWorker.f25798X0o0xo;
                        if (iI0xO0 != null) {
                            iI0xO0.handleResponse(error);
                        }
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI(UploadOSSWorker.f25796I0Io + "  fileLength  error = " + error);
                    }

                    @Override // xxxI.II0xO0
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void handleResponse(@oOoXoXO Long l) {
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI(UploadOSSWorker.f25796I0Io + "  fileLength  result = " + l);
                        UploadOSSWorker uploadOSSWorker2 = UploadOSSWorker.f25800oIX0oI;
                        AppendObjectRequest appendObjectRequest3 = AppendObjectRequest.this;
                        OSSClient oSSClient2 = oSSClient;
                        IIX0o.ooOOo0oXI(l);
                        uploadOSSWorker2.X0o0xo(appendObjectRequest3, oSSClient2, l.longValue(), file);
                    }
                });
            }
        });
    }

    public final void X0o0xo(AppendObjectRequest appendObjectRequest, OSSClient oSSClient, long j, File file) {
        appendObjectRequest.setPosition(j);
        appendObjectRequest.setProgressCallback(new OSSProgressCallback() { // from class: com.sma.smartv3.work.II0xO0
            @Override // com.alibaba.sdk.android.oss.callback.OSSProgressCallback
            public final void onProgress(Object obj, long j2, long j3) {
                UploadOSSWorker.XO((AppendObjectRequest) obj, j2, j3);
            }
        });
        IIX0o.oO(oSSClient.asyncAppendObject(appendObjectRequest, new oIX0oI(file)), "asyncAppendObject(...)");
    }

    @OOXIXo
    public final String oO() {
        return f25801oxoX;
    }

    @OOXIXo
    public final StringBuffer oOoXoXO() {
        return f25797II0xO0;
    }

    public final void ooOOo0oXI(@OOXIXo String fileName, @OOXIXo OSSClient oss, @OOXIXo String bucket, @OOXIXo xxxI.II0xO0<Long> callback) {
        IIX0o.x0xO0oo(fileName, "fileName");
        IIX0o.x0xO0oo(oss, "oss");
        IIX0o.x0xO0oo(bucket, "bucket");
        IIX0o.x0xO0oo(callback, "callback");
        IIX0o.oO(oss.asyncHeadObject(new HeadObjectRequest(bucket, "db/" + fileName), new II0xO0(callback)), "asyncHeadObject(...)");
    }

    public final void x0XOIxOo(@OOXIXo final File cacheFile) {
        IIX0o.x0xO0oo(cacheFile, "cacheFile");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap hashMap = new HashMap();
        final xxxI.II0xO0<StsRamData> iI0xO0 = new xxxI.II0xO0<StsRamData>() { // from class: com.sma.smartv3.work.UploadOSSWorker$getNetWorkUtilsSts$1
            @Override // xxxI.II0xO0
            public void handleError(@OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.II0xO0(UploadOSSWorker.f25796I0Io + " getStsError : " + error);
                xxxI.II0xO0 iI0xO02 = UploadOSSWorker.f25798X0o0xo;
                if (iI0xO02 != null) {
                    iI0xO02.handleResponse(error);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@oOoXoXO UploadOSSWorker.StsRamData stsRamData) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(UploadOSSWorker.f25796I0Io + " handleResponse : " + stsRamData);
                UploadOSSWorker uploadOSSWorker = UploadOSSWorker.f25800oIX0oI;
                uploadOSSWorker.xxIXOIIO(stsRamData, cacheFile);
                Xo0.f24349oIX0oI.XO().put(uploadOSSWorker.oO() + '_' + UploadOSSWorker.StsRamData.class.getName(), new Gson().toJson(stsRamData));
            }
        };
        final android.app.Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), "/ali/getStsRam");
        netWorkUtils.printParam(convertBaseUrl + "/ali/getStsRam", hashMap);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + "/ali/getStsRam";
        final xxxI.II0xO0<Response<StsRamData>> iI0xO02 = new xxxI.II0xO0<Response<StsRamData>>() { // from class: com.sma.smartv3.work.UploadOSSWorker$getNetWorkUtilsSts$$inlined$get$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@oOoXoXO Response<UploadOSSWorker.StsRamData> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                android.app.Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.get(str).addQueryParameter((Map<String, String>) hashMap).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, StsRamData.class), new ParsedRequestListener<Response<StsRamData>>() { // from class: com.sma.smartv3.work.UploadOSSWorker$getNetWorkUtilsSts$$inlined$get$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OOXIXo Response<UploadOSSWorker.StsRamData> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@oOoXoXO ANError aNError) {
                Integer num;
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
                    str2 = aNError.getErrorBody();
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
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void x0xO0oo(@OOXIXo String fileName, @OOXIXo OSSClient oss, @OOXIXo String bucket, @OOXIXo xxxI.II0xO0<Boolean> callback) {
        IIX0o.x0xO0oo(fileName, "fileName");
        IIX0o.x0xO0oo(oss, "oss");
        IIX0o.x0xO0oo(bucket, "bucket");
        IIX0o.x0xO0oo(callback, "callback");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f25796I0Io + "  isFileExist = " + fileName + "  bucket = " + bucket);
        try {
            if (oss.doesObjectExist(bucket, "db/" + fileName)) {
                callback.handleResponse(Boolean.TRUE);
            } else {
                callback.handleResponse(Boolean.FALSE);
            }
        } catch (ClientException e) {
            e.printStackTrace();
            callback.handleError(e.toString());
        } catch (ServiceException e2) {
            String serviceException = e2.toString();
            IIX0o.oO(serviceException, "toString(...)");
            callback.handleError(serviceException);
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            String str = f25796I0Io;
            sb.append(str);
            sb.append(" ErrorCode ");
            sb.append(e2.getErrorCode());
            oix0oi.II0xO0(sb.toString());
            oix0oi.II0xO0(str + " RequestId " + e2.getRequestId());
            oix0oi.II0xO0(str + " HostId " + e2.getHostId());
            oix0oi.II0xO0(str + " RawMessage " + e2.getRawMessage());
        }
    }

    public final boolean xoIox(@OOXIXo String iso8601String) {
        boolean z;
        IIX0o.x0xO0oo(iso8601String, "iso8601String");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date parse = simpleDateFormat.parse(iso8601String);
        IIX0o.ooOOo0oXI(parse);
        long time = parse.getTime();
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append(f25796I0Io);
        sb.append(" expiryTime = ");
        sb.append(time);
        sb.append(" ,  currentTimeMillis = ");
        sb.append(System.currentTimeMillis());
        sb.append(" ,  B = ");
        if (time < System.currentTimeMillis()) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        oix0oi.oIX0oI(sb.toString());
        if (time >= System.currentTimeMillis()) {
            return false;
        }
        return true;
    }

    public final void xxIXOIIO(@oOoXoXO StsRamData stsRamData, @OOXIXo File cacheFile) {
        String str;
        String str2;
        String str3;
        String str4;
        String endPoint;
        ResponseData response;
        Credentials credentials;
        ResponseData response2;
        Credentials credentials2;
        ResponseData response3;
        Credentials credentials3;
        IIX0o.x0xO0oo(cacheFile, "cacheFile");
        String str5 = "";
        if (stsRamData == null || (response3 = stsRamData.getResponse()) == null || (credentials3 = response3.getCredentials()) == null || (str = credentials3.getAccessKeySecret()) == null) {
            str = "";
        }
        if (stsRamData == null || (response2 = stsRamData.getResponse()) == null || (credentials2 = response2.getCredentials()) == null || (str2 = credentials2.getAccessKeyId()) == null) {
            str2 = "";
        }
        if (stsRamData == null || (response = stsRamData.getResponse()) == null || (credentials = response.getCredentials()) == null || (str3 = credentials.getSecurityToken()) == null) {
            str3 = "";
        }
        if (stsRamData == null || (str4 = stsRamData.getBucket()) == null) {
            str4 = "";
        }
        if (stsRamData != null && (endPoint = stsRamData.getEndPoint()) != null) {
            str5 = endPoint;
        }
        if (str3.length() > 0 && str.length() > 0 && str2.length() > 0 && str4.length() > 0) {
            OSSClient oSSClient = new OSSClient(Utils.getApp(), str5, new OSSStsTokenCredentialProvider(str2, str, str3));
            SPUtils XO2 = Xo0.f24349oIX0oI.XO();
            Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
            Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
            if (fromJson != null) {
                appUser = fromJson;
            }
            AppUser appUser2 = (AppUser) appUser;
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(f25796I0Io + " , onCreateOSSClient appUser.dbUrl = " + appUser2.getDbUrl());
            if (appUser2.getDbUrl().length() > 0) {
                Oxx0IOOO((String) CollectionsKt___CollectionsKt.O0O0Io00X(StringsKt__StringsKt.XXoO0oX(appUser2.getDbUrl(), new String[]{"/"}, false, 0, 6, null)), oSSClient, str4, cacheFile);
                return;
            }
            xxxI.II0xO0<Object> iI0xO0 = f25798X0o0xo;
            if (iI0xO0 != null) {
                iI0xO0.handleResponse("dbUrl = null");
                return;
            }
            return;
        }
        xxxI.II0xO0<Object> iI0xO02 = f25798X0o0xo;
        if (iI0xO02 != null) {
            iI0xO02.handleResponse("token = null");
        }
    }
}
