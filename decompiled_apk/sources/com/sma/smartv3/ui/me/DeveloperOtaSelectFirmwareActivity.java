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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.BleFirmwareInfo;
import com.sma.smartv3.model.ExtraPackageDataList;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.model.FirmwareVersionList;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.BleExtraPackVersionList;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@kotlin.jvm.internal.XX({"SMAP\nDeveloperOtaSelectFirmwareActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperOtaSelectFirmwareActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaSelectFirmwareActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 5 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,106:1\n19#2:107\n15#2:108\n19#2:109\n15#2:110\n11#2,2:140\n151#3,11:111\n171#3:130\n208#4,7:122\n226#4:129\n69#5,3:131\n72#5,5:135\n1#6:134\n*S KotlinDebug\n*F\n+ 1 DeveloperOtaSelectFirmwareActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaSelectFirmwareActivity\n*L\n39#1:107\n39#1:108\n41#1:109\n41#1:110\n64#1:140,2\n80#1:111,11\n80#1:130\n80#1:122,7\n80#1:129\n101#1:131,3\n101#1:135,5\n101#1:134\n*E\n"})
/* loaded from: classes11.dex */
public final class DeveloperOtaSelectFirmwareActivity extends BaseListActivity<FirmwareVersion> {
    private ArrayList<FirmwareVersion> dataList;
    private int firmwareID;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSelectRemind$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectFirmwareActivity$tvSelectRemind$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperOtaSelectFirmwareActivity.this.findViewById(R.id.tv_select_remind);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSelect$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectFirmwareActivity$tvSelect$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperOtaSelectFirmwareActivity.this.findViewById(R.id.tv_select);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btNext$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AppCompatButton>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectFirmwareActivity$btNext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AppCompatButton invoke() {
            return (AppCompatButton) DeveloperOtaSelectFirmwareActivity.this.findViewById(R.id.bt_next);
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
    public static final void initItem$lambda$1$lambda$0(DeveloperOtaSelectFirmwareActivity this$0, FirmwareVersion item, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
        this$0.getTvSelect().setText(item.getVersion() + "  -- " + item.getInfo());
        com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(FirmwareVersion.class.getName(), new Gson().toJson(item));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        SPUtils II0xO02 = xo0.II0xO0();
        Object firmwareVersionList = new FirmwareVersionList(0, null, 3, null);
        Object fromJson = new Gson().fromJson(II0xO02.getString(FirmwareVersionList.class.getName()), (Class<Object>) FirmwareVersionList.class);
        if (fromJson != null) {
            firmwareVersionList = fromJson;
        }
        this.dataList = ((FirmwareVersionList) firmwareVersionList).getData();
        SPUtils II0xO03 = xo0.II0xO0();
        Object bleFirmwareInfo = new BleFirmwareInfo(0, 0, null, null, null, 31, null);
        Object fromJson2 = new Gson().fromJson(II0xO03.getString(BleFirmwareInfo.class.getName()), (Class<Object>) BleFirmwareInfo.class);
        if (fromJson2 != null) {
            bleFirmwareInfo = fromJson2;
        }
        this.firmwareID = ((BleFirmwareInfo) bleFirmwareInfo).getId();
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<FirmwareVersion> initList() {
        ArrayList<FirmwareVersion> arrayList = this.dataList;
        if (arrayList == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("dataList");
            return null;
        }
        return arrayList;
    }

    @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getTvSelectRemind().setText(R.string.select_remind_firmware_info);
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
        getBtNext().setVisibility(8);
        int i = com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getInt(com.sma.smartv3.util.XoI0Ixx0.f24458oo0xXOI0I);
        if (i != 0) {
            if (i != 1 && i != 2 && i != 4) {
                if (i != 5) {
                    if (i != 6 && i != 7) {
                        return;
                    }
                }
            }
            startActivity(new Intent(this, (Class<?>) DeveloperOtaStartActivity.class));
            return;
        }
        ToastUtils.showLong("Network request, please wait", new Object[0]);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> bleFirmwareVersionListBody = RequestBodyKt.getBleFirmwareVersionListBody(String.valueOf(this.firmwareID));
        final xxxI.II0xO0<ExtraPackageDataList> iI0xO0 = new xxxI.II0xO0<ExtraPackageDataList>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectFirmwareActivity$nextOnClick$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                ToastUtils.showLong(R.string.already_the_latest_version);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO ExtraPackageDataList extraPackageDataList) {
                com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(ExtraPackageDataList.class.getName(), new Gson().toJson(extraPackageDataList));
                if (extraPackageDataList != null && extraPackageDataList.getTotal() == 0) {
                    DeveloperOtaSelectFirmwareActivity developerOtaSelectFirmwareActivity = DeveloperOtaSelectFirmwareActivity.this;
                    developerOtaSelectFirmwareActivity.startActivity(new Intent(developerOtaSelectFirmwareActivity, (Class<?>) DeveloperOtaStartActivity.class));
                } else {
                    DeveloperOtaSelectFirmwareActivity developerOtaSelectFirmwareActivity2 = DeveloperOtaSelectFirmwareActivity.this;
                    developerOtaSelectFirmwareActivity2.startActivity(new Intent(developerOtaSelectFirmwareActivity2, (Class<?>) DeveloperOtaSelectExtraPackageUIActivity.class));
                }
            }
        };
        final Activity activity = null;
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), BleExtraPackVersionList.URL);
        netWorkUtils.printParam(convertBaseUrl + BleExtraPackVersionList.URL, bleFirmwareVersionListBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + BleExtraPackVersionList.URL;
        final xxxI.II0xO0<Response<ExtraPackageDataList>> iI0xO02 = new xxxI.II0xO0<Response<ExtraPackageDataList>>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectFirmwareActivity$nextOnClick$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<ExtraPackageDataList> response) {
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
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) bleFirmwareVersionListBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, ExtraPackageDataList.class), new ParsedRequestListener<Response<ExtraPackageDataList>>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectFirmwareActivity$nextOnClick$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<ExtraPackageDataList> response) {
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
    public void initItem(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo final FirmwareVersion item, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        holder.o00(android.R.id.text1, "firmwareVersion:" + item.getVersion() + "\nfileName:" + item.getFileName() + "\ninfo:" + item.getInfo());
        holder.oO(android.R.id.text1, new View.OnClickListener() { // from class: com.sma.smartv3.ui.me.IIxOXoOo0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeveloperOtaSelectFirmwareActivity.initItem$lambda$1$lambda$0(DeveloperOtaSelectFirmwareActivity.this, item, view);
            }
        });
    }
}
