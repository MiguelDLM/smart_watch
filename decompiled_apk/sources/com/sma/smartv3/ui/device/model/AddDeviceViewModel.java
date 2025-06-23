package com.sma.smartv3.ui.device.model;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.app.Activity;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.LogUtils;
import com.github.doyaaaaaken.kotlincsv.client.CsvFileReader;
import com.github.doyaaaaaken.kotlincsv.dsl.CsvReaderDslKt;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.DeviceOnlineInfo;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.GetNewDeviceListObject;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.sequences.ooOOo0oXI;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.xoIox;
import x0xO.XO;
import xxxI.II0xO0;

@XX({"SMAP\nAddDeviceViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AddDeviceViewModel.kt\ncom/sma/smartv3/ui/device/model/AddDeviceViewModel\n+ 2 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 3 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 4 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,124:1\n151#2,11:125\n171#2:144\n208#3,7:136\n226#3:143\n35#4,2:145\n*S KotlinDebug\n*F\n+ 1 AddDeviceViewModel.kt\ncom/sma/smartv3/ui/device/model/AddDeviceViewModel\n*L\n34#1:125,11\n34#1:144\n34#1:136,7\n34#1:143\n115#1:145,2\n*E\n"})
/* loaded from: classes12.dex */
public final class AddDeviceViewModel extends ViewModel {
    /* JADX INFO: Access modifiers changed from: private */
    public final void getFileData(String str, oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        LogUtils.i("DeviceOnlineInfo" + new File(str).exists());
        if (new File(str).exists()) {
            final ArrayList arrayList = new ArrayList();
            try {
                CsvReaderDslKt.II0xO0(null, 1, null).x0XOIxOo(str, new oOoXoXO<CsvFileReader, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.model.AddDeviceViewModel$getFileData$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(CsvFileReader csvFileReader) {
                        invoke2(csvFileReader);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OOXIXo CsvFileReader open) {
                        IIX0o.x0xO0oo(open, "$this$open");
                        ooOOo0oXI<Map<String, String>> xxIXOIIO2 = open.xxIXOIIO();
                        ArrayList<DeviceOnlineInfo> arrayList2 = arrayList;
                        Iterator<Map<String, String>> it = xxIXOIIO2.iterator();
                        while (it.hasNext()) {
                            String str2 = "";
                            String str3 = "0";
                            int i = 0;
                            for (Object obj : it.next().values()) {
                                int i2 = i + 1;
                                if (i < 0) {
                                    CollectionsKt__CollectionsKt.XoX();
                                }
                                String str4 = (String) obj;
                                if (i == 0) {
                                    str2 = str4;
                                }
                                if (i == 2) {
                                    str3 = str4;
                                }
                                i = i2;
                            }
                            LogUtils.i("DeviceOnlineInfo" + str2);
                            LogUtils.i("DeviceOnlineInfo" + str3);
                            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                                IIX0o.ooOOo0oXI(str2);
                                IIX0o.ooOOo0oXI(str3);
                                arrayList2.add(new DeviceOnlineInfo(str2, Integer.parseInt(str3)));
                            }
                        }
                    }
                });
                Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24393OOXIxO0, new Gson().toJson(arrayList));
                if (oooxoxo != null) {
                    oooxoxo.invoke(Boolean.TRUE);
                }
            } catch (Exception e) {
                LogUtils.d("getFileData error -> " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getFileData$default(AddDeviceViewModel addDeviceViewModel, String str, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        addDeviceViewModel.getFileData(str, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getNewDeviceListObject$default(AddDeviceViewModel addDeviceViewModel, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = null;
        }
        addDeviceViewModel.getNewDeviceListObject(oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onDownload$default(AddDeviceViewModel addDeviceViewModel, String str, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        addDeviceViewModel.onDownload(str, oooxoxo);
    }

    public final void getNewDeviceListObject(@OXOo.oOoXoXO final oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        final Activity activity = null;
        HashMap newDeviceListObjectBody$default = RequestBodyKt.getNewDeviceListObjectBody$default(null, 1, null);
        final II0xO0<String> iI0xO0 = new II0xO0<String>() { // from class: com.sma.smartv3.ui.device.model.AddDeviceViewModel$getNewDeviceListObject$1
            @Override // xxxI.II0xO0
            public void handleError(@OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("getNewDeviceListObject -> error = " + error);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("getNewDeviceListObject -> " + str);
                if (!TextUtils.isEmpty(str)) {
                    AddDeviceViewModel addDeviceViewModel = AddDeviceViewModel.this;
                    IIX0o.ooOOo0oXI(str);
                    addDeviceViewModel.onDownload(str, oooxoxo);
                }
            }
        };
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetNewDeviceListObject.URL);
        netWorkUtils.printParam(convertBaseUrl + GetNewDeviceListObject.URL, newDeviceListObjectBody$default);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetNewDeviceListObject.URL;
        final II0xO0<Response<String>> iI0xO02 = new II0xO0<Response<String>>() { // from class: com.sma.smartv3.ui.device.model.AddDeviceViewModel$getNewDeviceListObject$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<String> response) {
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
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) newDeviceListObjectBody$default).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, String.class), new ParsedRequestListener<Response<String>>() { // from class: com.sma.smartv3.ui.device.model.AddDeviceViewModel$getNewDeviceListObject$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OOXIXo Response<String> response) {
                IIX0o.x0xO0oo(response, "response");
                II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
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
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
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
                II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void onDownload(@OOXIXo String fileUrl, @OXOo.oOoXoXO final oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(fileUrl, "fileUrl");
        List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(fileUrl, new String[]{"/"}, false, 0, 6, null);
        if (!XXoO0oX2.isEmpty()) {
            String str = "device_info" + ((String) XXoO0oX2.get(XXoO0oX2.size() - 1));
            StringBuilder sb = new StringBuilder();
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            sb.append(IXxxXO.IIXOooo(oix0oi).getPath());
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(str);
            final String sb2 = sb.toString();
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("mFilePath== " + sb2);
            NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
            String str2 = fileUrl + "?time=" + System.currentTimeMillis();
            String path = IXxxXO.IIXOooo(oix0oi).getPath();
            IIX0o.oO(path, "getPath(...)");
            netWorkUtils.download(str2, path, str, new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.model.AddDeviceViewModel$onDownload$1
                @Override // xxxI.II0xO0
                public void handleError(@OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                    LogUtils.d("download firmware error -> " + error);
                }

                @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                public void handleProgress(int i) {
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO String str3) {
                    LogUtils.i("DeviceOnlineInfo handleResponse");
                    xoIox.XO(ViewModelKt.getViewModelScope(AddDeviceViewModel.this), kotlinx.coroutines.Xo0.I0Io(), null, new AddDeviceViewModel$onDownload$1$handleResponse$1(AddDeviceViewModel.this, sb2, oooxoxo, null), 2, null);
                }
            });
        }
    }
}
