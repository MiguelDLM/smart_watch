package com.sma.smartv3.ui.device;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bestmafen.androidbase.list.BaseListActivity;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.Stock;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.network.StockAdd;
import com.sma.smartv3.network.StockSearch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

@kotlin.jvm.internal.XX({"SMAP\nStockAddActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StockAddActivity.kt\ncom/sma/smartv3/ui/device/StockAddActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 5 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 6 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 7 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,251:1\n19#2:252\n15#2:253\n39#2,3:254\n42#2:260\n44#2,2:262\n1549#3:257\n1620#3,2:258\n1622#3:261\n65#4,16:264\n93#4,3:280\n151#5,11:283\n171#5:302\n151#5,11:303\n171#5:322\n208#6,7:294\n226#6:301\n208#6,7:314\n226#6:321\n1#7:323\n*S KotlinDebug\n*F\n+ 1 StockAddActivity.kt\ncom/sma/smartv3/ui/device/StockAddActivity\n*L\n39#1:252\n39#1:253\n42#1:254,3\n42#1:260\n42#1:262,2\n42#1:257\n42#1:258,2\n42#1:261\n70#1:264,16\n70#1:280,3\n94#1:283,11\n94#1:302\n127#1:303,11\n127#1:322\n94#1:294,7\n94#1:301\n127#1:314,7\n127#1:321\n*E\n"})
/* loaded from: classes12.dex */
public final class StockAddActivity extends BaseListActivity<Stock> {

    @OXOo.OOXIXo
    private AppUser mAppUser;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.I0X0x0oIo mLoadingPopup;

    @OXOo.OOXIXo
    private final List<Stock> mSelectedList;
    private int mStockSize;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mEditText$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.device.StockAddActivity$mEditText$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) StockAddActivity.this.findViewById(R.id.stock_add_edit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mClearImg$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.StockAddActivity$mClearImg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return StockAddActivity.this.findViewById(R.id.clear_edit_tv_img);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSearchBtn$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.StockAddActivity$mSearchBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return StockAddActivity.this.findViewById(R.id.stock_search_btn);
        }
    });

    @kotlin.jvm.internal.XX({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 StockAddActivity.kt\ncom/sma/smartv3/ui/device/StockAddActivity\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n71#2,6:98\n71#3:104\n77#4:105\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oIX0oI implements TextWatcher {
        public oIX0oI() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            if (editable != null && editable.length() > 0) {
                StockAddActivity.this.getMClearImg().setVisibility(0);
            } else {
                StockAddActivity.this.getMClearImg().setVisibility(4);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public StockAddActivity() {
        Collection ooXIXxIX2;
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        SPUtils XO2 = xo0.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
        try {
            JsonArray asJsonArray = JsonParser.parseString(xo0.XO().getString(Stock.class.getName() + oOXoIIIo.XO.f32008oIX0oI)).getAsJsonArray();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), Stock.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        this.mSelectedList = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
    }

    private final void add(int i) {
        if (this.mLoadingPopup == null) {
            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = new com.sma.smartv3.pop.I0X0x0oIo(getMContext());
            i0X0x0oIo.x0xO0oo(false);
            this.mLoadingPopup = i0X0x0oIo;
        }
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo2 = this.mLoadingPopup;
        if (i0X0x0oIo2 != null) {
            i0X0x0oIo2.IIXOooo();
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> stockAddBody = RequestBodyKt.getStockAddBody(this.mAppUser.getIdentity(), i);
        final xxxI.II0xO0<Stock[]> iI0xO0 = new xxxI.II0xO0<Stock[]>() { // from class: com.sma.smartv3.ui.device.StockAddActivity$add$2
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                XIOOI.oIX0oI mListAdapter;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3;
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                mListAdapter = StockAddActivity.this.getMListAdapter();
                mListAdapter.notifyDataSetChanged();
                i0X0x0oIo3 = StockAddActivity.this.mLoadingPopup;
                if (i0X0x0oIo3 != null) {
                    i0X0x0oIo3.dismiss();
                }
                ToastUtils.showLong(error, new Object[0]);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Stock[] stockArr) {
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3;
                XIOOI.oIX0oI mListAdapter;
                boolean z;
                i0X0x0oIo3 = StockAddActivity.this.mLoadingPopup;
                if (i0X0x0oIo3 != null) {
                    i0X0x0oIo3.dismiss();
                }
                if (stockArr != null) {
                    if (stockArr.length == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        StockAddActivity.this.mStockSize = stockArr.length;
                        com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(Stock.class.getName() + oOXoIIIo.XO.f32008oIX0oI, new Gson().toJson(ArraysKt___ArraysKt.X0XOOO(stockArr)));
                        return;
                    }
                }
                mListAdapter = StockAddActivity.this.getMListAdapter();
                mListAdapter.notifyDataSetChanged();
                ToastUtils.showLong("Add error", new Object[0]);
            }
        };
        final Activity activity = null;
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), StockAdd.URL);
        netWorkUtils.printParam(convertBaseUrl + StockAdd.URL, stockAddBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + StockAdd.URL;
        final xxxI.II0xO0<Response<Stock[]>> iI0xO02 = new xxxI.II0xO0<Response<Stock[]>>() { // from class: com.sma.smartv3.ui.device.StockAddActivity$add$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<Stock[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3 = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo3 != null) {
                    i0X0x0oIo3.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) stockAddBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, Stock[].class), new ParsedRequestListener<Response<Stock[]>>() { // from class: com.sma.smartv3.ui.device.StockAddActivity$add$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<Stock[]> response) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final View getMClearImg() {
        return (View) this.mClearImg$delegate.getValue();
    }

    private final EditText getMEditText() {
        return (EditText) this.mEditText$delegate.getValue();
    }

    private final View getMSearchBtn() {
        return (View) this.mSearchBtn$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initItem$lambda$6(boolean z, StockAddActivity this$0, XIOOI.I0Io holder, Stock item, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "$holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
        if (z) {
            return;
        }
        if (this$0.mStockSize >= 5) {
            ToastUtils.showLong(this$0.getString(R.string.stock_max_tip, 5), new Object[0]);
        } else {
            ((AppCompatRadioButton) holder.X0o0xo(R.id.rbSelectedState)).setChecked(true);
            this$0.add(item.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(StockAddActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getMEditText().setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(StockAddActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        String obj = this$0.getMEditText().getText().toString();
        if (obj.length() > 0) {
            this$0.search(obj);
        } else {
            ToastUtils.showLong(R.string.search_content_tip);
        }
    }

    private final void search(String str) {
        if (this.mLoadingPopup == null) {
            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = new com.sma.smartv3.pop.I0X0x0oIo(getMContext());
            i0X0x0oIo.x0xO0oo(false);
            this.mLoadingPopup = i0X0x0oIo;
        }
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo2 = this.mLoadingPopup;
        if (i0X0x0oIo2 != null) {
            i0X0x0oIo2.IIXOooo();
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> stockSearchBody = RequestBodyKt.getStockSearchBody(this.mAppUser.getIdentity(), str);
        final xxxI.II0xO0<Stock[]> iI0xO0 = new xxxI.II0xO0<Stock[]>() { // from class: com.sma.smartv3.ui.device.StockAddActivity$search$2
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3;
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                i0X0x0oIo3 = StockAddActivity.this.mLoadingPopup;
                if (i0X0x0oIo3 != null) {
                    i0X0x0oIo3.dismiss();
                }
                ToastUtils.showLong(error, new Object[0]);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Stock[] stockArr) {
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3;
                List mList;
                List mList2;
                XIOOI.oIX0oI mListAdapter;
                StringBuilder sb = new StringBuilder();
                sb.append("stock search result -> ");
                String arrays = Arrays.toString(stockArr);
                kotlin.jvm.internal.IIX0o.oO(arrays, "toString(...)");
                sb.append(arrays);
                boolean z = true;
                LogUtils.d(sb.toString());
                i0X0x0oIo3 = StockAddActivity.this.mLoadingPopup;
                if (i0X0x0oIo3 != null) {
                    i0X0x0oIo3.dismiss();
                }
                if (stockArr != null) {
                    if (stockArr.length != 0) {
                        z = false;
                    }
                    if (!z) {
                        mList = StockAddActivity.this.getMList();
                        mList.clear();
                        mList2 = StockAddActivity.this.getMList();
                        kotlin.collections.OxI.xxIO(mList2, stockArr);
                        mListAdapter = StockAddActivity.this.getMListAdapter();
                        mListAdapter.notifyDataSetChanged();
                        return;
                    }
                }
                ToastUtils.showLong(R.string.no_data);
            }
        };
        final Activity activity = null;
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), StockSearch.URL);
        netWorkUtils.printParam(convertBaseUrl + StockSearch.URL, stockSearchBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str2 = convertBaseUrl + StockSearch.URL;
        final xxxI.II0xO0<Response<Stock[]>> iI0xO02 = new xxxI.II0xO0<Response<Stock[]>>() { // from class: com.sma.smartv3.ui.device.StockAddActivity$search$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<Stock[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3 = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo3 != null) {
                    i0X0x0oIo3.dismiss();
                }
            }
        };
        AndroidNetworking.post(str2).addBodyParameter((Map<String, String>) stockSearchBody).setTag((Object) str2).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, Stock[].class), new ParsedRequestListener<Response<Stock[]>>() { // from class: com.sma.smartv3.ui.device.StockAddActivity$search$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<Stock[]> response) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str3;
                String str4;
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
                    str3 = aNError.getErrorBody();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", ");
                if (aNError != null) {
                    str4 = aNError.getErrorDetail();
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
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<Stock> initList() {
        return new ArrayList();
    }

    @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        this.mStockSize = this.mSelectedList.size();
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.add_stock);
        getMListView().setEmptyView(findViewById(R.id.empty));
        getMClearImg().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.oO0IXx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StockAddActivity.initView$lambda$0(StockAddActivity.this, view);
            }
        });
        EditText mEditText = getMEditText();
        kotlin.jvm.internal.IIX0o.oO(mEditText, "<get-mEditText>(...)");
        mEditText.addTextChangedListener(new oIX0oI());
        getMSearchBtn().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.ooO0oXxI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StockAddActivity.initView$lambda$2(StockAddActivity.this, view);
            }
        });
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return R.layout.layout_stock_pick_item;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_stock_add;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@OXOo.oOoXoXO Bundle bundle) {
        setTheme(R.style.ContactPickerTheme);
        super.onCreate(bundle);
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        setResult(-1);
        finish();
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OXOo.OOXIXo final XIOOI.I0Io holder, @OXOo.OOXIXo final Stock item, int i) {
        Object obj;
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        ((TextView) holder.X0o0xo(R.id.tv_name)).setText(item.getName());
        ((TextView) holder.X0o0xo(R.id.tv_exchange)).setText(item.getExchange());
        ((TextView) holder.X0o0xo(R.id.tv_code)).setText(item.getCode());
        ((TextView) holder.X0o0xo(R.id.tv_exchange_name)).setText(item.getExchangeInfo());
        ((AppCompatRadioButton) holder.X0o0xo(R.id.rbSelectedState)).setButtonTintList(oIxOXo.oxoX.X0o0xo(getMContext(), R.color.text_color));
        Iterator<T> it = this.mSelectedList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((Stock) obj).getId() == item.getId()) {
                    break;
                }
            }
        }
        final boolean z = obj != null;
        ((AppCompatRadioButton) holder.X0o0xo(R.id.rbSelectedState)).setChecked(z);
        holder.II0xO0().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.I00O
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StockAddActivity.initItem$lambda$6(z, this, holder, item, view);
            }
        });
        ((TextView) holder.X0o0xo(R.id.tv_close)).setText(String.valueOf(item.getRealTimeClose()));
        ((TextView) holder.X0o0xo(R.id.tv_change)).setText(String.valueOf(item.getRealTimeChange()));
        ((TextView) holder.X0o0xo(R.id.tv_change_percent)).setText(String.valueOf(item.getRealTimeChangePercentage()));
        ((TextView) holder.X0o0xo(R.id.tv_change)).setTextColor(oIxOXo.oxoX.I0Io(getMContext(), R.color.text_color));
        ((TextView) holder.X0o0xo(R.id.tv_change_percent)).setTextColor(oIxOXo.oxoX.I0Io(getMContext(), R.color.text_color));
        ((ImageView) holder.X0o0xo(R.id.iv_change_percent)).setImageDrawable(null);
        int i2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getInt(com.sma.smartv3.util.XoI0Ixx0.f24490xoIxX);
        if (i2 == 0) {
            if (item.getRealTimeChange() > 0.0f) {
                ((TextView) holder.X0o0xo(R.id.tv_change)).setTextColor(getResources().getColor(R.color.stock_color_red));
                ((TextView) holder.X0o0xo(R.id.tv_change_percent)).setTextColor(getResources().getColor(R.color.stock_color_red));
                ((ImageView) holder.X0o0xo(R.id.iv_change_percent)).setImageResource(R.drawable.icon_stock_rise);
                ((ImageView) holder.X0o0xo(R.id.iv_change_percent)).setImageTintList(getResources().getColorStateList(R.color.stock_color_red));
                return;
            }
            if (item.getRealTimeChange() < 0.0f) {
                ((TextView) holder.X0o0xo(R.id.tv_change)).setTextColor(getResources().getColor(R.color.stock_color_green));
                ((TextView) holder.X0o0xo(R.id.tv_change_percent)).setTextColor(getResources().getColor(R.color.stock_color_green));
                ((ImageView) holder.X0o0xo(R.id.iv_change_percent)).setImageResource(R.drawable.icon_stock_fall);
                ((ImageView) holder.X0o0xo(R.id.iv_change_percent)).setImageTintList(getResources().getColorStateList(R.color.stock_color_green));
                return;
            }
            return;
        }
        if (i2 != 1) {
            return;
        }
        if (item.getRealTimeChange() > 0.0f) {
            ((TextView) holder.X0o0xo(R.id.tv_change)).setTextColor(getResources().getColor(R.color.stock_color_green));
            ((TextView) holder.X0o0xo(R.id.tv_change_percent)).setTextColor(getResources().getColor(R.color.stock_color_green));
            ((ImageView) holder.X0o0xo(R.id.iv_change_percent)).setImageResource(R.drawable.icon_stock_rise);
            ((ImageView) holder.X0o0xo(R.id.iv_change_percent)).setImageTintList(getResources().getColorStateList(R.color.stock_color_green));
            return;
        }
        if (item.getRealTimeChange() < 0.0f) {
            ((TextView) holder.X0o0xo(R.id.tv_change)).setTextColor(getResources().getColor(R.color.stock_color_red));
            ((TextView) holder.X0o0xo(R.id.tv_change_percent)).setTextColor(getResources().getColor(R.color.stock_color_red));
            ((ImageView) holder.X0o0xo(R.id.iv_change_percent)).setImageResource(R.drawable.icon_stock_fall);
            ((ImageView) holder.X0o0xo(R.id.iv_change_percent)).setImageTintList(getResources().getColorStateList(R.color.stock_color_red));
        }
    }
}
