package com.sma.smartv3.ui.device;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslAdapterStatusItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.SwipeMenuHelper;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
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
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.dsl.AdapterStatusItem;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.Stock;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.network.StockList;
import com.sma.smartv3.network.StockRemove;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleStock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

@kotlin.jvm.internal.XX({"SMAP\nStockMarketActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StockMarketActivity.kt\ncom/sma/smartv3/ui/device/StockMarketActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 7 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,300:1\n19#2:301\n15#2:302\n39#2,3:345\n42#2:351\n44#2,2:353\n151#3,11:303\n171#3:322\n151#3,11:323\n171#3:342\n208#4,7:314\n226#4:321\n208#4,7:334\n226#4:341\n1855#5,2:343\n1549#5:348\n1620#5,2:349\n1622#5:352\n140#6,5:355\n145#6,5:361\n69#6,3:366\n72#6,5:370\n1#7:360\n1#7:369\n*S KotlinDebug\n*F\n+ 1 StockMarketActivity.kt\ncom/sma/smartv3/ui/device/StockMarketActivity\n*L\n38#1:301\n38#1:302\n273#1:345,3\n273#1:351\n273#1:353,2\n93#1:303,11\n93#1:322\n121#1:323,11\n121#1:342\n93#1:314,7\n93#1:321\n121#1:334,7\n121#1:341\n258#1:343,2\n273#1:348\n273#1:349,2\n273#1:352\n286#1:355,5\n286#1:361,5\n294#1:366,3\n294#1:370,5\n286#1:360\n294#1:369\n*E\n"})
/* loaded from: classes12.dex */
public final class StockMarketActivity extends BaseDSLRecyclerActivity {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    public static final int STOCK_PICKER_REQUEST = 99;

    @OXOo.OOXIXo
    private AppUser mAppUser;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.I0X0x0oIo mLoadingPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvTip$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.StockMarketActivity$tvTip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) StockMarketActivity.this.findViewById(R.id.tv_tip);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnBottom$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.StockMarketActivity$btnBottom$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return StockMarketActivity.this.findViewById(R.id.btn_bottom);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.StockMarketActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) StockMarketActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public StockMarketActivity() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    private final void checkCount(List<Stock> list) {
        int i;
        TextView tvTip = getTvTip();
        int i2 = 0;
        if (list.isEmpty()) {
            i = 8;
        } else {
            i = 0;
        }
        tvTip.setVisibility(i);
        int xxIO2 = ProductManager.f20544oIX0oI.xxIO();
        getTvTip().setText(getString(R.string.stock_max_tip, Integer.valueOf(xxIO2)));
        View btnBottom = getBtnBottom();
        if (list.size() >= xxIO2) {
            i2 = 8;
        }
        btnBottom.setVisibility(i2);
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    private final View getBtnBottom() {
        return (View) this.btnBottom$delegate.getValue();
    }

    private final TextView getTvTip() {
        return (TextView) this.tvTip$delegate.getValue();
    }

    private final List<Stock> initList() {
        Collection ooXIXxIX2;
        try {
            JsonArray asJsonArray = JsonParser.parseString(com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(Stock.class.getName() + oOXoIIIo.XO.f32008oIX0oI)).getAsJsonArray();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), Stock.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(StockMarketActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.list();
    }

    private final void list() {
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> stockListBody = RequestBodyKt.getStockListBody(this.mAppUser.getIdentity());
        final xxxI.II0xO0<Stock[]> iI0xO0 = new xxxI.II0xO0<Stock[]>() { // from class: com.sma.smartv3.ui.device.StockMarketActivity$list$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                StockMarketActivity.this.getRefreshLayout().setRefreshing(false);
                ToastUtils.showLong(error, new Object[0]);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Stock[] stockArr) {
                StockMarketActivity.this.getRefreshLayout().setRefreshing(false);
                if (stockArr != null) {
                    com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(Stock.class.getName() + oOXoIIIo.XO.f32008oIX0oI, new Gson().toJson(ArraysKt___ArraysKt.X0XOOO(stockArr)));
                    StockMarketActivity.this.showList(ArraysKt___ArraysKt.X0XOOO(stockArr));
                }
            }
        };
        final Activity activity = null;
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), StockList.URL);
        netWorkUtils.printParam(convertBaseUrl + StockList.URL, stockListBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + StockList.URL;
        final xxxI.II0xO0<Response<Stock[]>> iI0xO02 = new xxxI.II0xO0<Response<Stock[]>>() { // from class: com.sma.smartv3.ui.device.StockMarketActivity$list$$inlined$post$default$1
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
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) stockListBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, Stock[].class), new ParsedRequestListener<Response<Stock[]>>() { // from class: com.sma.smartv3.ui.device.StockMarketActivity$list$$inlined$post$default$2
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
    public final void remove(int i) {
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
        HashMap<String, String> stockRemoveBody = RequestBodyKt.getStockRemoveBody(this.mAppUser.getIdentity(), i);
        final xxxI.II0xO0<Stock[]> iI0xO0 = new xxxI.II0xO0<Stock[]>() { // from class: com.sma.smartv3.ui.device.StockMarketActivity$remove$2
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3;
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                i0X0x0oIo3 = StockMarketActivity.this.mLoadingPopup;
                if (i0X0x0oIo3 != null) {
                    i0X0x0oIo3.dismiss();
                }
                ToastUtils.showLong(error, new Object[0]);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Stock[] stockArr) {
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3;
                i0X0x0oIo3 = StockMarketActivity.this.mLoadingPopup;
                if (i0X0x0oIo3 != null) {
                    i0X0x0oIo3.dismiss();
                }
                if (stockArr != null) {
                    com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(Stock.class.getName() + oOXoIIIo.XO.f32008oIX0oI, new Gson().toJson(ArraysKt___ArraysKt.X0XOOO(stockArr)));
                    StockMarketActivity.this.showList(ArraysKt___ArraysKt.X0XOOO(stockArr));
                    return;
                }
                ToastUtils.showLong(R.string.failed_to_delete);
            }
        };
        final Activity activity = null;
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), StockRemove.URL);
        netWorkUtils.printParam(convertBaseUrl + StockRemove.URL, stockRemoveBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + StockRemove.URL;
        final xxxI.II0xO0<Response<Stock[]>> iI0xO02 = new xxxI.II0xO0<Response<Stock[]>>() { // from class: com.sma.smartv3.ui.device.StockMarketActivity$remove$$inlined$post$default$1
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
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) stockRemoveBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, Stock[].class), new ParsedRequestListener<Response<Stock[]>>() { // from class: com.sma.smartv3.ui.device.StockMarketActivity$remove$$inlined$post$default$2
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
    public final void showList(final List<Stock> list) {
        getDslAdapter().resetItem(new ArrayList());
        renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.StockMarketActivity$showList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                if (list.isEmpty()) {
                    DslAdapter.setAdapterStatus$default(this.getDslAdapter(), 1, null, 2, null);
                    return;
                }
                DslAdapter.setAdapterStatus$default(this.getDslAdapter(), 0, null, 2, null);
                for (final Stock stock : list) {
                    DslAdapter dslAdapter = this.getDslAdapter();
                    final StockMarketActivity stockMarketActivity = this;
                    DslAdapterExKt.oO(dslAdapter, R.layout.item_stock, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.StockMarketActivity$showList$1.1

                        /* renamed from: com.sma.smartv3.ui.device.StockMarketActivity$showList$1$1$1, reason: invalid class name and collision with other inner class name */
                        /* loaded from: classes12.dex */
                        public static final class C09581 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI> {
                            final /* synthetic */ Stock $item;
                            final /* synthetic */ DslAdapterItem $this_dslItem;
                            final /* synthetic */ StockMarketActivity this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public C09581(Stock stock, StockMarketActivity stockMarketActivity, DslAdapterItem dslAdapterItem) {
                                super(4);
                                this.$item = stock;
                                this.this$0 = stockMarketActivity;
                                this.$this_dslItem = dslAdapterItem;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final void invoke$lambda$0(StockMarketActivity this$0, Stock item, DslAdapterItem this_dslItem, DslViewHolder itemHolder, View view) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                                kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
                                kotlin.jvm.internal.IIX0o.x0xO0oo(this_dslItem, "$this_dslItem");
                                kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "$itemHolder");
                                this$0.remove(item.getId());
                                SwipeMenuHelper swipeMenuHelper = this_dslItem.get_itemSwipeMenuHelper();
                                if (swipeMenuHelper != null) {
                                    swipeMenuHelper.closeSwipeMenu(itemHolder);
                                }
                            }

                            @Override // Oox.Oxx0xo
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            public final void invoke(@OXOo.OOXIXo final DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                Activity mContext;
                                Activity mContext2;
                                kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                TextView tv = itemHolder.tv(R.id.tv_name);
                                if (tv != null) {
                                    tv.setText(this.$item.getName());
                                }
                                TextView tv2 = itemHolder.tv(R.id.tv_exchange);
                                if (tv2 != null) {
                                    tv2.setText(this.$item.getExchange());
                                }
                                TextView tv3 = itemHolder.tv(R.id.tv_code);
                                if (tv3 != null) {
                                    tv3.setText(this.$item.getCode());
                                }
                                TextView tv4 = itemHolder.tv(R.id.tv_close);
                                if (tv4 != null) {
                                    tv4.setText(String.valueOf(this.$item.getRealTimeClose()));
                                }
                                TextView tv5 = itemHolder.tv(R.id.tv_change);
                                if (tv5 != null) {
                                    tv5.setText(String.valueOf(this.$item.getRealTimeChange()));
                                }
                                TextView tv6 = itemHolder.tv(R.id.tv_change_percent);
                                if (tv6 != null) {
                                    tv6.setText(String.valueOf(this.$item.getRealTimeChangePercentage()));
                                }
                                TextView tv7 = itemHolder.tv(R.id.tv_change);
                                if (tv7 != null) {
                                    mContext2 = this.this$0.getMContext();
                                    tv7.setTextColor(oIxOXo.oxoX.I0Io(mContext2, R.color.text_color));
                                }
                                TextView tv8 = itemHolder.tv(R.id.tv_change_percent);
                                if (tv8 != null) {
                                    mContext = this.this$0.getMContext();
                                    tv8.setTextColor(oIxOXo.oxoX.I0Io(mContext, R.color.text_color));
                                }
                                ImageView img = itemHolder.img(R.id.iv_change_percent);
                                if (img != null) {
                                    img.setImageDrawable(null);
                                }
                                int i2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getInt(com.sma.smartv3.util.XoI0Ixx0.f24490xoIxX);
                                if (i2 != 0) {
                                    if (i2 == 1) {
                                        if (this.$item.getRealTimeChange() > 0.0f) {
                                            TextView tv9 = itemHolder.tv(R.id.tv_change);
                                            if (tv9 != null) {
                                                tv9.setTextColor(this.this$0.getResources().getColor(R.color.stock_color_green));
                                            }
                                            TextView tv10 = itemHolder.tv(R.id.tv_change_percent);
                                            if (tv10 != null) {
                                                tv10.setTextColor(this.this$0.getResources().getColor(R.color.stock_color_green));
                                            }
                                            ImageView img2 = itemHolder.img(R.id.iv_change_percent);
                                            if (img2 != null) {
                                                img2.setImageResource(R.drawable.icon_stock_rise);
                                            }
                                            ImageView img3 = itemHolder.img(R.id.iv_change_percent);
                                            if (img3 != null) {
                                                img3.setImageTintList(this.this$0.getResources().getColorStateList(R.color.stock_color_green));
                                            }
                                        } else if (this.$item.getRealTimeChange() < 0.0f) {
                                            TextView tv11 = itemHolder.tv(R.id.tv_change);
                                            if (tv11 != null) {
                                                tv11.setTextColor(this.this$0.getResources().getColor(R.color.stock_color_red));
                                            }
                                            TextView tv12 = itemHolder.tv(R.id.tv_change_percent);
                                            if (tv12 != null) {
                                                tv12.setTextColor(this.this$0.getResources().getColor(R.color.stock_color_red));
                                            }
                                            ImageView img4 = itemHolder.img(R.id.iv_change_percent);
                                            if (img4 != null) {
                                                img4.setImageResource(R.drawable.icon_stock_fall);
                                            }
                                            ImageView img5 = itemHolder.img(R.id.iv_change_percent);
                                            if (img5 != null) {
                                                img5.setImageTintList(this.this$0.getResources().getColorStateList(R.color.stock_color_red));
                                            }
                                        }
                                    }
                                } else if (this.$item.getRealTimeChange() > 0.0f) {
                                    TextView tv13 = itemHolder.tv(R.id.tv_change);
                                    if (tv13 != null) {
                                        tv13.setTextColor(this.this$0.getResources().getColor(R.color.stock_color_red));
                                    }
                                    TextView tv14 = itemHolder.tv(R.id.tv_change_percent);
                                    if (tv14 != null) {
                                        tv14.setTextColor(this.this$0.getResources().getColor(R.color.stock_color_red));
                                    }
                                    ImageView img6 = itemHolder.img(R.id.iv_change_percent);
                                    if (img6 != null) {
                                        img6.setImageResource(R.drawable.icon_stock_rise);
                                    }
                                    ImageView img7 = itemHolder.img(R.id.iv_change_percent);
                                    if (img7 != null) {
                                        img7.setImageTintList(this.this$0.getResources().getColorStateList(R.color.stock_color_red));
                                    }
                                } else if (this.$item.getRealTimeChange() < 0.0f) {
                                    TextView tv15 = itemHolder.tv(R.id.tv_change);
                                    if (tv15 != null) {
                                        tv15.setTextColor(this.this$0.getResources().getColor(R.color.stock_color_green));
                                    }
                                    TextView tv16 = itemHolder.tv(R.id.tv_change_percent);
                                    if (tv16 != null) {
                                        tv16.setTextColor(this.this$0.getResources().getColor(R.color.stock_color_green));
                                    }
                                    ImageView img8 = itemHolder.img(R.id.iv_change_percent);
                                    if (img8 != null) {
                                        img8.setImageResource(R.drawable.icon_stock_fall);
                                    }
                                    ImageView img9 = itemHolder.img(R.id.iv_change_percent);
                                    if (img9 != null) {
                                        img9.setImageTintList(this.this$0.getResources().getColorStateList(R.color.stock_color_green));
                                    }
                                }
                                final StockMarketActivity stockMarketActivity = this.this$0;
                                final Stock stock = this.$item;
                                final DslAdapterItem dslAdapterItem2 = this.$this_dslItem;
                                itemHolder.click(R.id.bt_delete, 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x022c: INVOKE 
                                      (r8v0 'itemHolder' com.angcyo.dsladapter.DslViewHolder)
                                      (wrap:int:SGET  A[WRAPPED] com.sma.smartv3.co_fit.R.id.bt_delete int)
                                      (wrap:android.view.View$OnClickListener:0x0226: CONSTRUCTOR 
                                      (r9v21 'stockMarketActivity' com.sma.smartv3.ui.device.StockMarketActivity A[DONT_INLINE])
                                      (r10v15 'stock' com.sma.smartv3.model.Stock A[DONT_INLINE])
                                      (r11v5 'dslAdapterItem2' com.angcyo.dsladapter.DslAdapterItem A[DONT_INLINE])
                                      (r8v0 'itemHolder' com.angcyo.dsladapter.DslViewHolder A[DONT_INLINE])
                                     A[MD:(com.sma.smartv3.ui.device.StockMarketActivity, com.sma.smartv3.model.Stock, com.angcyo.dsladapter.DslAdapterItem, com.angcyo.dsladapter.DslViewHolder):void (m), WRAPPED] call: com.sma.smartv3.ui.device.xXo.<init>(com.sma.smartv3.ui.device.StockMarketActivity, com.sma.smartv3.model.Stock, com.angcyo.dsladapter.DslAdapterItem, com.angcyo.dsladapter.DslViewHolder):void type: CONSTRUCTOR)
                                     VIRTUAL call: com.angcyo.dsladapter.DslViewHolder.click(int, android.view.View$OnClickListener):void A[MD:(int, android.view.View$OnClickListener):void (m)] in method: com.sma.smartv3.ui.device.StockMarketActivity.showList.1.1.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.xXo, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 15 more
                                    */
                                /*
                                    Method dump skipped, instructions count: 560
                                    To view this dump add '--comments-level debug' option
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.StockMarketActivity$showList$1.AnonymousClass1.C09581.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                            invoke2(dslAdapterItem);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                            dslItem.setItemSwipeMenuFlag(4);
                            dslItem.setItemBindOverride(new C09581(Stock.this, stockMarketActivity, dslItem));
                        }
                    });
                }
            }
        });
        syncList(list);
        checkCount(list);
    }

    private final void syncList(List<Stock> list) {
        ArrayList arrayList = new ArrayList();
        for (Stock stock : CollectionsKt___CollectionsKt.O0o000XOX(list, ProductManager.f20544oIX0oI.xxIO())) {
            arrayList.add(new BleStock(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getInt(com.sma.smartv3.util.XoI0Ixx0.f24490xoIxX), stock.getCode(), stock.getRealTimeClose(), stock.getRealTimeChange(), stock.getRealTimeChangePercentage(), 0.0f, 32, null));
        }
        BleConnector.sendList$default(BleConnector.INSTANCE, BleKey.STOCK, BleKeyFlag.RESET, arrayList, false, false, 24, null);
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    @OXOo.OOXIXo
    public DslAdapterStatusItem adapterStatusItem() {
        setAdapterStatus(new AdapterStatusItem());
        return getAdapterStatus();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.stock_market);
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.icon_stock_set);
        getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        getDslAdapter().getDslAdapterStatusItem().getItemStateLayoutMap().put(1, Integer.valueOf(R.layout.layout_sockt_empty));
        showList(initList());
        getRefreshLayout().setRefreshing(true);
        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.o0OO0
            @Override // java.lang.Runnable
            public final void run() {
                StockMarketActivity.initView$lambda$0(StockMarketActivity.this);
            }
        }, 1000L);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_stock_market;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 99) {
            showList(initList());
        }
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivityForResult(new Intent(this, (Class<?>) StockAddActivity.class), 99);
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        SwipeMenuHelper.Companion.oIX0oI((RecyclerView) getDslViewHolder().v(recyclerViewId()));
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onRefresh() {
        list();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getDslAdapter().notifyDataSetChanged();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) StockSettingActivity.class));
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int refreshLayoutId() {
        return R.id.srf;
    }
}
