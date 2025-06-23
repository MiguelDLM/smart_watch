package com.sma.smartv3.model;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.app.Activity;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.AppStoreFileListSearch;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleAppFile;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.o0;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import x0xO.XO;
import xxxI.II0xO0;

@XX({"SMAP\nFileTransmission.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTransmission.kt\ncom/sma/smartv3/model/AppStoreFileManager\n+ 2 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 3 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,243:1\n173#2,12:244\n194#2:265\n173#2,12:266\n194#2:287\n234#3,8:256\n254#3:264\n234#3,8:278\n254#3:286\n*S KotlinDebug\n*F\n+ 1 FileTransmission.kt\ncom/sma/smartv3/model/AppStoreFileManager\n*L\n170#1:244,12\n170#1:265\n189#1:266,12\n189#1:287\n170#1:256,8\n170#1:264\n189#1:278,8\n189#1:286\n*E\n"})
/* loaded from: classes12.dex */
public final class AppStoreFileManager {

    @OOXIXo
    public static final AppStoreFileManager INSTANCE = new AppStoreFileManager();

    private AppStoreFileManager() {
    }

    public static /* synthetic */ void downloadAppFile$default(AppStoreFileManager appStoreFileManager, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        appStoreFileManager.downloadAppFile(str, str2, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getAppStoreFileList$default(AppStoreFileManager appStoreFileManager, String str, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "1";
        }
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        appStoreFileManager.getAppStoreFileList(str, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getAudioBookFileList$default(AppStoreFileManager appStoreFileManager, String str, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "2";
        }
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        appStoreFileManager.getAudioBookFileList(str, oooxoxo);
    }

    public final void downloadAppFile(@OOXIXo String path, @OOXIXo final String fileName, final int i, final int i2) {
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(fileName, "fileName");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("appStore downloadAppFile path = " + path + "  , fileName = " + fileName + " , mBleAppFile -> " + i + "  , mOpType = " + i2);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        String absolutePath = IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI).getAbsolutePath();
        IIX0o.oO(absolutePath, "getAbsolutePath(...)");
        netWorkUtils.download(path, absolutePath, fileName, new HttpProgressCallback<String>() { // from class: com.sma.smartv3.model.AppStoreFileManager$downloadAppFile$1
            @Override // xxxI.II0xO0
            public void handleError(@OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                ToastUtils.showLong("Download error  \n  " + error, new Object[0]);
            }

            @Override // com.sma.androidnetworklib.method.HttpProgressCallback
            public void handleProgress(int i3) {
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO String str) {
                BleConnector.INSTANCE.sendStream(BleKey.APP_FILE, new BleAppFile(fileName, i2, FilesKt__FileReadWriteKt.IIXOooo(new File(IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI).getAbsolutePath(), fileName))).toByteArray(), i);
            }
        });
    }

    public final void getAppStoreFileList(@OOXIXo String appModuleId, @OXOo.oOoXoXO final oOoXoXO<? super List<AppStoreFileList>, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(appModuleId, "appModuleId");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> appStoreFileListBody = RequestBodyKt.getAppStoreFileListBody(appModuleId);
        final II0xO0<AppStoreFileList[]> iI0xO0 = new II0xO0<AppStoreFileList[]>() { // from class: com.sma.smartv3.model.AppStoreFileManager$getAppStoreFileList$1
            @Override // xxxI.II0xO0
            public void handleError(@OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getAppStoreFileList error -> " + error);
                ToastUtils.showLong(error, new Object[0]);
                oOoXoXO<List<AppStoreFileList>, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(null);
                }
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO AppStoreFileList[] appStoreFileListArr) {
                StringBuilder sb = new StringBuilder();
                sb.append("getAppStoreFileList -> ");
                sb.append(appStoreFileListArr != null ? Integer.valueOf(appStoreFileListArr.length) : null);
                LogUtils.d(sb.toString());
                oOoXoXO<List<AppStoreFileList>, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(appStoreFileListArr != null ? ArraysKt___ArraysKt.X0XOOO(appStoreFileListArr) : null);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), AppStoreFileListSearch.URL);
        netWorkUtils.printParam(convertBaseUrl + AppStoreFileListSearch.URL, o0.xoIxX(appStoreFileListBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + AppStoreFileListSearch.URL;
        final II0xO0<Response<AppStoreFileList[]>> iI0xO02 = new II0xO0<Response<AppStoreFileList[]>>() { // from class: com.sma.smartv3.model.AppStoreFileManager$getAppStoreFileList$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO Response<AppStoreFileList[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                II0xO0 iI0xO03 = iI0xO0;
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) appStoreFileListBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, AppStoreFileList[].class), new ParsedRequestListener<Response<AppStoreFileList[]>>() { // from class: com.sma.smartv3.model.AppStoreFileManager$getAppStoreFileList$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                String str4;
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
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", exception:");
                if (aNError != null) {
                    str4 = aNError.getLocalizedMessage();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                II0xO0.this.handleError(String.valueOf(num2));
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onResponse(@OOXIXo Response<AppStoreFileList[]> response) {
                IIX0o.x0xO0oo(response, "response");
                II0xO0.this.handleResponse(response);
            }
        });
    }

    public final void getAudioBookFileList(@OOXIXo String appModuleId, @OXOo.oOoXoXO final oOoXoXO<? super List<AppFileDetail>, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(appModuleId, "appModuleId");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> appStoreFileListBody = RequestBodyKt.getAppStoreFileListBody(appModuleId);
        final II0xO0<AppFileDetail[]> iI0xO0 = new II0xO0<AppFileDetail[]>() { // from class: com.sma.smartv3.model.AppStoreFileManager$getAudioBookFileList$1
            @Override // xxxI.II0xO0
            public void handleError(@OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getAppStoreFileList error -> " + error);
                ToastUtils.showLong(error, new Object[0]);
                oOoXoXO<List<AppFileDetail>, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(null);
                }
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO AppFileDetail[] appFileDetailArr) {
                StringBuilder sb = new StringBuilder();
                sb.append("getAppStoreFileList -> ");
                sb.append(appFileDetailArr != null ? Integer.valueOf(appFileDetailArr.length) : null);
                LogUtils.d(sb.toString());
                if (appFileDetailArr != null) {
                    if (!(appFileDetailArr.length == 0)) {
                        oOoXoXO<List<AppFileDetail>, oXIO0o0XI> oooxoxo2 = oooxoxo;
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(ArraysKt___ArraysKt.X0XOOO(appFileDetailArr));
                            return;
                        }
                        return;
                    }
                }
                oOoXoXO<List<AppFileDetail>, oXIO0o0XI> oooxoxo3 = oooxoxo;
                if (oooxoxo3 != null) {
                    oooxoxo3.invoke(null);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), AppStoreFileListSearch.URL);
        netWorkUtils.printParam(convertBaseUrl + AppStoreFileListSearch.URL, o0.xoIxX(appStoreFileListBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + AppStoreFileListSearch.URL;
        final II0xO0<Response<AppFileDetail[]>> iI0xO02 = new II0xO0<Response<AppFileDetail[]>>() { // from class: com.sma.smartv3.model.AppStoreFileManager$getAudioBookFileList$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO Response<AppFileDetail[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                II0xO0 iI0xO03 = iI0xO0;
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) appStoreFileListBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, AppFileDetail[].class), new ParsedRequestListener<Response<AppFileDetail[]>>() { // from class: com.sma.smartv3.model.AppStoreFileManager$getAudioBookFileList$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                String str4;
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
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", exception:");
                if (aNError != null) {
                    str4 = aNError.getLocalizedMessage();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                II0xO0.this.handleError(String.valueOf(num2));
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onResponse(@OOXIXo Response<AppFileDetail[]> response) {
                IIX0o.x0xO0oo(response, "response");
                II0xO0.this.handleResponse(response);
            }
        });
    }
}
