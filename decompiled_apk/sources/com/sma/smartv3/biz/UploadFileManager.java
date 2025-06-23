package com.sma.smartv3.biz;

import android.app.Activity;
import android.text.TextUtils;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.blankj.utilcode.util.LogUtils;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.GetTempSignedPutUrl;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nUploadFileManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UploadFileManager.kt\ncom/sma/smartv3/biz/UploadFileManager\n+ 2 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 3 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,90:1\n101#2,11:91\n121#2:110\n156#3,7:102\n174#3:109\n*S KotlinDebug\n*F\n+ 1 UploadFileManager.kt\ncom/sma/smartv3/biz/UploadFileManager\n*L\n26#1:91,11\n26#1:110\n26#1:102,7\n26#1:109\n*E\n"})
/* loaded from: classes12.dex */
public final class UploadFileManager {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final UploadFileManager f20210oIX0oI = new UploadFileManager();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20209II0xO0 = "UploadFileManager";

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void I0Io(UploadFileManager uploadFileManager, String str, String str2, xxxI.II0xO0 iI0xO0, int i, Object obj) {
        if ((i & 4) != 0) {
            iI0xO0 = null;
        }
        uploadFileManager.II0xO0(str, str2, iI0xO0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void XO(UploadFileManager uploadFileManager, String str, File file, xxxI.II0xO0 iI0xO0, int i, Object obj) {
        if ((i & 4) != 0) {
            iI0xO0 = null;
        }
        uploadFileManager.X0o0xo(str, file, iI0xO0);
    }

    public final void II0xO0(@OXOo.OOXIXo String identity, @OXOo.OOXIXo String uploadOSSFilePath, @OXOo.oOoXoXO final xxxI.II0xO0<String> iI0xO0) {
        IIX0o.x0xO0oo(identity, "identity");
        IIX0o.x0xO0oo(uploadOSSFilePath, "uploadOSSFilePath");
        LogUtils.d(f20209II0xO0 + " getTempSignedPutUrl -> " + identity + ", " + uploadOSSFilePath);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> tempSignedPutUrlBody = RequestBodyKt.getTempSignedPutUrlBody(identity, uploadOSSFilePath);
        final xxxI.II0xO0<String> iI0xO02 = new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.UploadFileManager$getTempSignedPutUrl$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d(UploadFileManager.f20210oIX0oI.oIX0oI() + " handleError -> " + error);
                xxxI.II0xO0<String> iI0xO03 = iI0xO0;
                if (iI0xO03 != null) {
                    iI0xO03.handleError(error);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
                LogUtils.d(UploadFileManager.f20210oIX0oI.oIX0oI() + " handleResponse -> " + str);
                if (TextUtils.isEmpty(str)) {
                    xxxI.II0xO0<String> iI0xO03 = iI0xO0;
                    if (iI0xO03 != null) {
                        iI0xO03.handleError("Error");
                        return;
                    }
                    return;
                }
                xxxI.II0xO0<String> iI0xO04 = iI0xO0;
                if (iI0xO04 != null) {
                    iI0xO04.handleResponse(str);
                }
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetTempSignedPutUrl.URL);
        netWorkUtils.printParam(convertBaseUrl + GetTempSignedPutUrl.URL, tempSignedPutUrlBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetTempSignedPutUrl.URL;
        final xxxI.II0xO0<Response<String>> iI0xO03 = new xxxI.II0xO0<Response<String>>() { // from class: com.sma.smartv3.biz.UploadFileManager$getTempSignedPutUrl$$inlined$get$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO02, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<String> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO04 = iI0xO02;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO04);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.get(str).addQueryParameter((Map<String, String>) tempSignedPutUrlBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, String.class), new ParsedRequestListener<Response<String>>() { // from class: com.sma.smartv3.biz.UploadFileManager$getTempSignedPutUrl$$inlined$get$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<String> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
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

    public final void X0o0xo(@OXOo.OOXIXo String identity, @OXOo.OOXIXo final File file, @OXOo.oOoXoXO final xxxI.II0xO0<String> iI0xO0) {
        IIX0o.x0xO0oo(identity, "identity");
        IIX0o.x0xO0oo(file, "file");
        LogUtils.d(f20209II0xO0 + " uploadLogFile -> " + identity + ", " + file);
        StringBuilder sb = new StringBuilder();
        sb.append("applog/Android/");
        sb.append(file.getName());
        II0xO0(identity, sb.toString(), new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.UploadFileManager$uploadLogFile$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                xxxI.II0xO0<String> iI0xO02 = iI0xO0;
                if (iI0xO02 != null) {
                    iI0xO02.handleError(error);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO final String str) {
                if (TextUtils.isEmpty(str)) {
                    xxxI.II0xO0<String> iI0xO02 = iI0xO0;
                    if (iI0xO02 != null) {
                        iI0xO02.handleError("Error");
                        return;
                    }
                    return;
                }
                ANRequest build = AndroidNetworking.put(str).setTag((Object) str).addFileBody(file).setPriority(Priority.HIGH).build();
                final xxxI.II0xO0<String> iI0xO03 = iI0xO0;
                build.getAsString(new StringRequestListener() { // from class: com.sma.smartv3.biz.UploadFileManager$uploadLogFile$1$handleResponse$1
                    @Override // com.androidnetworking.interfaces.StringRequestListener
                    public void onError(@OXOo.oOoXoXO ANError aNError) {
                        String str2;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("uploadLogFile -> ");
                        String str3 = null;
                        if (aNError != null) {
                            str2 = aNError.getErrorDetail();
                        } else {
                            str2 = null;
                        }
                        sb2.append(str2);
                        LogUtils.d(sb2.toString());
                        xxxI.II0xO0<String> iI0xO04 = iI0xO03;
                        if (iI0xO04 != null) {
                            if (aNError != null) {
                                str3 = aNError.getErrorBody();
                            }
                            if (str3 == null) {
                                str3 = "Error";
                            }
                            iI0xO04.handleError(str3);
                        }
                    }

                    @Override // com.androidnetworking.interfaces.StringRequestListener
                    public void onResponse(@OXOo.oOoXoXO String str2) {
                        xxxI.II0xO0<String> iI0xO04 = iI0xO03;
                        if (iI0xO04 != null) {
                            iI0xO04.handleResponse(str);
                        }
                    }
                });
            }
        });
    }

    @OXOo.OOXIXo
    public final String oIX0oI() {
        return f20209II0xO0;
    }

    public final boolean oxoX() {
        if (System.currentTimeMillis() - Xo0.f24349oIX0oI.XO().getLong(XoI0Ixx0.f24359IIX0) > 1800000) {
            return true;
        }
        return false;
    }
}
