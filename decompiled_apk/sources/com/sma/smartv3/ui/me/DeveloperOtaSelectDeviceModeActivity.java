package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bestmafen.androidbase.list.BaseListActivity;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.BleFirmwareInfo;
import com.sma.smartv3.model.BleFirmwareVersionInfoList;
import com.sma.smartv3.model.FirmwareVersionList;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.BleFirmwareVersionList;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@kotlin.jvm.internal.XX({"SMAP\nDeveloperOtaSelectDeviceModeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperOtaSelectDeviceModeActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaSelectDeviceModeActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,94:1\n19#2:95\n15#2:96\n11#2,2:117\n151#3,11:97\n171#3:116\n208#4,7:108\n226#4:115\n*S KotlinDebug\n*F\n+ 1 DeveloperOtaSelectDeviceModeActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaSelectDeviceModeActivity\n*L\n37#1:95\n37#1:96\n60#1:117,2\n75#1:97,11\n75#1:116\n75#1:108,7\n75#1:115\n*E\n"})
/* loaded from: classes11.dex */
public final class DeveloperOtaSelectDeviceModeActivity extends BaseListActivity<BleFirmwareInfo> {
    private ArrayList<BleFirmwareInfo> dataList;
    private int firmwareID;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSelectRemind$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectDeviceModeActivity$tvSelectRemind$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperOtaSelectDeviceModeActivity.this.findViewById(R.id.tv_select_remind);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSelect$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectDeviceModeActivity$tvSelect$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperOtaSelectDeviceModeActivity.this.findViewById(R.id.tv_select);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btNext$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AppCompatButton>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectDeviceModeActivity$btNext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AppCompatButton invoke() {
            return (AppCompatButton) DeveloperOtaSelectDeviceModeActivity.this.findViewById(R.id.bt_next);
        }
    });

    private final AppCompatButton getBtNext() {
        return (AppCompatButton) this.btNext$delegate.getValue();
    }

    private final TextView getTvSelect() {
        return (TextView) this.tvSelect$delegate.getValue();
    }

    private final TextView getTvSelectRemind() {
        return (TextView) this.tvSelectRemind$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initItem$lambda$1$lambda$0(DeveloperOtaSelectDeviceModeActivity this$0, BleFirmwareInfo item, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
        this$0.firmwareID = item.getId();
        this$0.getTvSelect().setText(item.getBleName() + HelpFormatter.DEFAULT_LONG_OPT_PREFIX + item.getFlag() + HelpFormatter.DEFAULT_LONG_OPT_PREFIX + item.getRemark());
        com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(BleFirmwareInfo.class.getName(), new Gson().toJson(item));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        SPUtils II0xO02 = com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0();
        Object bleFirmwareVersionInfoList = new BleFirmwareVersionInfoList(0, null, 3, null);
        Object fromJson = new Gson().fromJson(II0xO02.getString(BleFirmwareVersionInfoList.class.getName()), (Class<Object>) BleFirmwareVersionInfoList.class);
        if (fromJson != null) {
            bleFirmwareVersionInfoList = fromJson;
        }
        this.dataList = ((BleFirmwareVersionInfoList) bleFirmwareVersionInfoList).getData();
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<BleFirmwareInfo> initList() {
        ArrayList<BleFirmwareInfo> arrayList = this.dataList;
        if (arrayList == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("dataList");
            return null;
        }
        return arrayList;
    }

    @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getTvSelectRemind().setText(R.string.select_remind_firmware_mode);
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return android.R.layout.simple_list_item_1;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_developer_test_ota_select_version_list;
    }

    public final void nextOnClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.firmwareID == 0) {
            ToastUtils.showLong(R.string.check_firmware_mode);
            return;
        }
        getBtNext().setVisibility(8);
        ToastUtils.showLong("Network request, please wait", new Object[0]);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> bleFirmwareVersionListBody = RequestBodyKt.getBleFirmwareVersionListBody(String.valueOf(this.firmwareID));
        final xxxI.II0xO0<FirmwareVersionList> iI0xO0 = new xxxI.II0xO0<FirmwareVersionList>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectDeviceModeActivity$nextOnClick$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                ToastUtils.showLong(R.string.already_the_latest_version);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO FirmwareVersionList firmwareVersionList) {
                com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(FirmwareVersionList.class.getName(), new Gson().toJson(firmwareVersionList));
                DeveloperOtaSelectDeviceModeActivity developerOtaSelectDeviceModeActivity = DeveloperOtaSelectDeviceModeActivity.this;
                developerOtaSelectDeviceModeActivity.startActivity(new Intent(developerOtaSelectDeviceModeActivity, (Class<?>) DeveloperOtaSelectFirmwareActivity.class));
            }
        };
        final Activity activity = null;
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), BleFirmwareVersionList.URL);
        netWorkUtils.printParam(convertBaseUrl + BleFirmwareVersionList.URL, bleFirmwareVersionListBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + BleFirmwareVersionList.URL;
        final xxxI.II0xO0<Response<FirmwareVersionList>> iI0xO02 = new xxxI.II0xO0<Response<FirmwareVersionList>>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectDeviceModeActivity$nextOnClick$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<FirmwareVersionList> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
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
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) bleFirmwareVersionListBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, FirmwareVersionList.class), new ParsedRequestListener<Response<FirmwareVersionList>>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectDeviceModeActivity$nextOnClick$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<FirmwareVersionList> response) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
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
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getBtNext().setVisibility(0);
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo final BleFirmwareInfo item, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        holder.o00(android.R.id.text1, "id:" + item.getId() + "\nbleName:" + item.getBleName() + "\nflag:" + item.getFlag() + "\nremark:" + item.getRemark());
        holder.oO(android.R.id.text1, new View.OnClickListener() { // from class: com.sma.smartv3.ui.me.XX0xXo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeveloperOtaSelectDeviceModeActivity.initItem$lambda$1$lambda$0(DeveloperOtaSelectDeviceModeActivity.this, item, view);
            }
        });
    }
}
