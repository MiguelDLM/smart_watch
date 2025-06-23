package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.list.BaseListActivity;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.l4digital.fastscroll.FastScrollRecyclerView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.BleFirmwareVersionInfoList;
import com.sma.smartv3.model.DeviceOnlineInfo;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.BleFirmwareList;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nDeveloperOtaSelectBleNameActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperOtaSelectBleNameActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaSelectBleNameActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,193:1\n1549#2:194\n1620#2,3:195\n151#3,11:198\n171#3:217\n208#4,7:209\n226#4:216\n*S KotlinDebug\n*F\n+ 1 DeveloperOtaSelectBleNameActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaSelectBleNameActivity\n*L\n52#1:194\n52#1:195,3\n174#1:198,11\n174#1:217\n174#1:209,7\n174#1:216\n*E\n"})
/* loaded from: classes11.dex */
public final class DeveloperOtaSelectBleNameActivity extends BaseListActivity<String> {

    @OXOo.oOoXoXO
    private CommonAdapter<String> mRecyclerAdapter;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSelectRemind$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectBleNameActivity$tvSelectRemind$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperOtaSelectBleNameActivity.this.findViewById(R.id.tv_select_remind);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSelect$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectBleNameActivity$tvSelect$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperOtaSelectBleNameActivity.this.findViewById(R.id.tv_select);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btNext$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AppCompatButton>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectBleNameActivity$btNext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AppCompatButton invoke() {
            return (AppCompatButton) DeveloperOtaSelectBleNameActivity.this.findViewById(R.id.bt_next);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO toolbar$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Toolbar>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectBleNameActivity$toolbar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Toolbar invoke() {
            return (Toolbar) DeveloperOtaSelectBleNameActivity.this.findViewById(R.id.toolbar);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO searchView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<MaterialSearchView>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectBleNameActivity$searchView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final MaterialSearchView invoke() {
            return (MaterialSearchView) DeveloperOtaSelectBleNameActivity.this.findViewById(R.id.search_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO recyclerView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FastScrollRecyclerView>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectBleNameActivity$recyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FastScrollRecyclerView invoke() {
            return (FastScrollRecyclerView) DeveloperOtaSelectBleNameActivity.this.findViewById(R.id.recyclerView);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO select_group_ll$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectBleNameActivity$select_group_ll$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) DeveloperOtaSelectBleNameActivity.this.findViewById(R.id.select_group_ll);
        }
    });

    @OXOo.OOXIXo
    private final ArrayList<String> searchList = new ArrayList<>();

    @OXOo.OOXIXo
    private ArrayList<String> dataList = new ArrayList<>();

    @kotlin.jvm.internal.XX({"SMAP\nDeveloperOtaSelectBleNameActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperOtaSelectBleNameActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaSelectBleNameActivity$initView$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,193:1\n1855#2,2:194\n*S KotlinDebug\n*F\n+ 1 DeveloperOtaSelectBleNameActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaSelectBleNameActivity$initView$3\n*L\n103#1:194,2\n*E\n"})
    /* loaded from: classes11.dex */
    public static final class oIX0oI implements MaterialSearchView.II0XooXoX {
        public oIX0oI() {
        }

        @Override // com.miguelcatalan.materialsearchview.MaterialSearchView.II0XooXoX
        public boolean onQueryTextChange(@OXOo.OOXIXo String newText) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(newText, "newText");
            LogUtils.d("onQueryTextChange => " + newText);
            DeveloperOtaSelectBleNameActivity.this.searchList.clear();
            if (!TextUtils.isEmpty(newText)) {
                ArrayList<String> arrayList = DeveloperOtaSelectBleNameActivity.this.dataList;
                DeveloperOtaSelectBleNameActivity developerOtaSelectBleNameActivity = DeveloperOtaSelectBleNameActivity.this;
                for (String str : arrayList) {
                    if (StringsKt__StringsKt.ooO0oXxI(str, newText, true)) {
                        developerOtaSelectBleNameActivity.searchList.add(str);
                    }
                }
                if (!DeveloperOtaSelectBleNameActivity.this.searchList.isEmpty()) {
                    if (DeveloperOtaSelectBleNameActivity.this.getRecyclerView().getVisibility() == 8) {
                        DeveloperOtaSelectBleNameActivity.this.getRecyclerView().setVisibility(0);
                        DeveloperOtaSelectBleNameActivity.this.getSelect_group_ll().setVisibility(8);
                    }
                } else {
                    DeveloperOtaSelectBleNameActivity.this.getRecyclerView().setVisibility(8);
                    DeveloperOtaSelectBleNameActivity.this.getSelect_group_ll().setVisibility(0);
                }
                CommonAdapter commonAdapter = DeveloperOtaSelectBleNameActivity.this.mRecyclerAdapter;
                if (commonAdapter != null) {
                    commonAdapter.notifyDataSetChanged();
                }
            } else {
                DeveloperOtaSelectBleNameActivity.this.getRecyclerView().setVisibility(8);
                DeveloperOtaSelectBleNameActivity.this.getSelect_group_ll().setVisibility(0);
            }
            return false;
        }

        @Override // com.miguelcatalan.materialsearchview.MaterialSearchView.II0XooXoX
        public boolean onQueryTextSubmit(@OXOo.OOXIXo String query) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(query, "query");
            return false;
        }
    }

    private final AppCompatButton getBtNext() {
        return (AppCompatButton) this.btNext$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FastScrollRecyclerView getRecyclerView() {
        return (FastScrollRecyclerView) this.recyclerView$delegate.getValue();
    }

    private final MaterialSearchView getSearchView() {
        return (MaterialSearchView) this.searchView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout getSelect_group_ll() {
        return (LinearLayout) this.select_group_ll$delegate.getValue();
    }

    private final Toolbar getToolbar() {
        return (Toolbar) this.toolbar$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvSelect() {
        return (TextView) this.tvSelect$delegate.getValue();
    }

    private final TextView getTvSelectRemind() {
        return (TextView) this.tvSelectRemind$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initItem$lambda$3$lambda$2(DeveloperOtaSelectBleNameActivity this$0, String item, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
        this$0.getTvSelect().setText(item);
    }

    private final void setSearchIconColor(MenuItem menuItem, Integer num) {
        Drawable icon;
        if (num != null && (icon = menuItem.getIcon()) != null) {
            Drawable wrap = DrawableCompat.wrap(icon);
            DrawableCompat.setTint(wrap.mutate(), num.intValue());
            menuItem.setIcon(wrap);
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        HashSet hashSet = new HashSet();
        List<DeviceOnlineInfo> oIIxXoo2 = ProductManager.f20544oIX0oI.oIIxXoo();
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(oIIxXoo2, 10));
        Iterator<T> it = oIIxXoo2.iterator();
        while (it.hasNext()) {
            arrayList.add(((DeviceOnlineInfo) it.next()).getBleName());
        }
        hashSet.addAll(arrayList);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        hashSet.addAll(productManager.OX());
        this.dataList.addAll(CollectionsKt___CollectionsKt.oIxOXo(hashSet));
        LogUtils.d("onlines:" + arrayList.size() + ", local:" + productManager.OX().size() + ", merge：" + this.dataList.size());
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<String> initList() {
        return new ArrayList();
    }

    @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getTvSelectRemind().setText(R.string.select_remind_select_bluetooth_name);
        setSupportActionBar(getToolbar());
        DeveloperOtaSelectBleNameActivity$initView$1 developerOtaSelectBleNameActivity$initView$1 = new DeveloperOtaSelectBleNameActivity$initView$1(this, this.searchList);
        getRecyclerView().setAdapter(developerOtaSelectBleNameActivity$initView$1);
        this.mRecyclerAdapter = developerOtaSelectBleNameActivity$initView$1;
        getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        getSearchView().XI0IXoo(false);
        getSearchView().setOnQueryTextListener(new oIX0oI());
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return android.R.layout.simple_list_item_1;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_developer_test_ota_select_blename_list;
    }

    public final void nextOnClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (getTvSelect().getText().toString().length() == 0) {
            ToastUtils.showLong(R.string.select_remind_bluetooth_name);
            return;
        }
        getBtNext().setVisibility(8);
        ToastUtils.showLong("Network request, please wait", new Object[0]);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> bleFirmwareAllListBody = RequestBodyKt.getBleFirmwareAllListBody(getTvSelect().getText().toString());
        final xxxI.II0xO0<BleFirmwareVersionInfoList> iI0xO0 = new xxxI.II0xO0<BleFirmwareVersionInfoList>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectBleNameActivity$nextOnClick$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                ToastUtils.showLong(R.string.already_the_latest_version);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO BleFirmwareVersionInfoList bleFirmwareVersionInfoList) {
                com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(BleFirmwareVersionInfoList.class.getName(), new Gson().toJson(bleFirmwareVersionInfoList));
                DeveloperOtaSelectBleNameActivity developerOtaSelectBleNameActivity = DeveloperOtaSelectBleNameActivity.this;
                developerOtaSelectBleNameActivity.startActivity(new Intent(developerOtaSelectBleNameActivity, (Class<?>) DeveloperOtaSelectDeviceModeActivity.class));
            }
        };
        final Activity activity = null;
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), BleFirmwareList.URL);
        netWorkUtils.printParam(convertBaseUrl + BleFirmwareList.URL, bleFirmwareAllListBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + BleFirmwareList.URL;
        final xxxI.II0xO0<Response<BleFirmwareVersionInfoList>> iI0xO02 = new xxxI.II0xO0<Response<BleFirmwareVersionInfoList>>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectBleNameActivity$nextOnClick$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<BleFirmwareVersionInfoList> response) {
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
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) bleFirmwareAllListBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, BleFirmwareVersionInfoList.class), new ParsedRequestListener<Response<BleFirmwareVersionInfoList>>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectBleNameActivity$nextOnClick$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<BleFirmwareVersionInfoList> response) {
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

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@OXOo.OOXIXo Menu menu) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(menu, "menu");
        getMenuInflater().inflate(R.menu.pick_menu_main, menu);
        MenuItem findItem = menu.findItem(R.id.mcp_action_search);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(findItem);
        setSearchIconColor(findItem, Integer.valueOf(Color.parseColor("#333333")));
        getSearchView().setMenuItem(findItem);
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getBtNext().setVisibility(0);
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo final String item, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        holder.o00(android.R.id.text1, item);
        holder.oO(android.R.id.text1, new View.OnClickListener() { // from class: com.sma.smartv3.ui.me.Ioxxx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeveloperOtaSelectBleNameActivity.initItem$lambda$3$lambda$2(DeveloperOtaSelectBleNameActivity.this, item, view);
            }
        });
    }
}
