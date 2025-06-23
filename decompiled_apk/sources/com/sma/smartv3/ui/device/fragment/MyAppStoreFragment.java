package com.sma.smartv3.ui.device.fragment;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.Oxx0xo;
import XO0.XO;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.SwipeMenuHelper;
import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppStoreDataItem;
import com.sma.smartv3.model.AppStoreItemList;
import com.sma.smartv3.model.FileTransmissionKt;
import com.sma.smartv3.ui.device.AppStoreActivity;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleAppOp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class MyAppStoreFragment extends BaseJLFileManageFragment {
    private int mAppNumber;

    @OOXIXo
    private final X0IIOO mDeviceStorage$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.fragment.MyAppStoreFragment$mDeviceStorage$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = MyAppStoreFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.storage_device);
        }
    });

    @OOXIXo
    private final X0IIOO mEmptyLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.fragment.MyAppStoreFragment$mEmptyLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = MyAppStoreFragment.this.getMView();
            return mView.findViewById(R.id.app_store_empty_layout);
        }
    });

    @OOXIXo
    private List<AppStoreItemList> mAppStoreItemList = new ArrayList();

    @OOXIXo
    private String mItemPositionPackageName = "";

    private final boolean getIsShowHeader(List<AppStoreDataItem> list) {
        Iterator<AppStoreDataItem> it = list.iterator();
        while (it.hasNext()) {
            if (!oOXoIIIo.I0Io.II0xO0(it.next().getBleAppInfo().getMHide())) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void setDeviceStorage$default(MyAppStoreFragment myAppStoreFragment, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            FragmentActivity activity = myAppStoreFragment.getActivity();
            IIX0o.x0XOIxOo(activity, "null cannot be cast to non-null type com.sma.smartv3.ui.device.AppStoreActivity");
            str = ((AppStoreActivity) activity).getTotalDeviceStorage();
        }
        if ((i & 2) != 0) {
            FragmentActivity activity2 = myAppStoreFragment.getActivity();
            IIX0o.x0XOIxOo(activity2, "null cannot be cast to non-null type com.sma.smartv3.ui.device.AppStoreActivity");
            str2 = ((AppStoreActivity) activity2).getFreeSizeDeviceStorage();
        }
        myAppStoreFragment.setDeviceStorage(str, str2);
    }

    @XO(tag = "add_app_store_success")
    public final void addAppStoreSuccess(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        getDslAdapter().clearAllItems();
        getDslAdapter().notifyDataChanged();
        showData();
        getDslAdapter().notifyDataChanged();
    }

    @Override // com.sma.smartv3.ui.device.fragment.BaseJLFileManageFragment
    public void confirmDeleteFile() {
        super.confirmDeleteFile();
        BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.APP_OP, BleKeyFlag.UPDATE, new BleAppOp(0, this.mItemPositionPackageName, 0, 4, null), false, false, 24, null);
        FileTransmissionKt.changAppStoreCurrentCategory(this.mItemPositionPackageName);
        x0xO0oo.oIX0oI("updata_app_store_success", this.mItemPositionPackageName);
        getDslAdapter().clearAllItems();
        showData();
        getDslAdapter().notifyDataChanged();
    }

    public final int getMAppNumber() {
        return this.mAppNumber;
    }

    @OOXIXo
    public final List<AppStoreItemList> getMAppStoreItemList() {
        return this.mAppStoreItemList;
    }

    public final PFMedium getMDeviceStorage() {
        return (PFMedium) this.mDeviceStorage$delegate.getValue();
    }

    public final View getMEmptyLayout() {
        return (View) this.mEmptyLayout$delegate.getValue();
    }

    @OOXIXo
    public final String getMItemPositionPackageName() {
        return this.mItemPositionPackageName;
    }

    @Override // com.sma.smartv3.ui.device.fragment.BaseJLFileManageFragment, com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.sma.smartv3.ui.device.fragment.BaseJLFileManageFragment, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_my_app_store;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getMActivity()));
        SwipeMenuHelper.Companion.oIX0oI((RecyclerView) getDslViewHolder().v(recyclerViewId()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setDeviceStorage$default(this, null, null, 3, null);
    }

    @Override // com.sma.smartv3.ui.device.fragment.BaseJLFileManageFragment, com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.sma.smartv3.ui.device.fragment.BaseJLFileManageFragment, com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int refreshLayoutId() {
        return 0;
    }

    public final void setDeviceStorage(@OOXIXo String total, @OOXIXo String surplus) {
        PFMedium mDeviceStorage;
        IIX0o.x0xO0oo(total, "total");
        IIX0o.x0xO0oo(surplus, "surplus");
        if (ProductManager.f20544oIX0oI.OXxx0OO() && (mDeviceStorage = getMDeviceStorage()) != null) {
            mDeviceStorage.setText(getString(R.string.app_store_title_tip_2, total, surplus));
        }
    }

    public final void setMAppNumber(int i) {
        this.mAppNumber = i;
    }

    public final void setMAppStoreItemList(@OOXIXo List<AppStoreItemList> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mAppStoreItemList = list;
    }

    public final void setMItemPositionPackageName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mItemPositionPackageName = str;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void showData() {
        List<AppStoreDataItem> list;
        getDslAdapter().resetItem(new ArrayList());
        int i = 0;
        this.mAppNumber = 0;
        for (final AppStoreItemList appStoreItemList : this.mAppStoreItemList) {
            if (!appStoreItemList.getList().isEmpty() && getIsShowHeader(appStoreItemList.getList())) {
                DslAdapterExKt.oO(getDslAdapter(), R.layout.item_app_store_title_name, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.fragment.MyAppStoreFragment$showData$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                        invoke2(dslAdapterItem);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OOXIXo DslAdapterItem dslItem) {
                        IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                        dslItem.setItemIsGroupHead(true);
                        dslItem.setItemIsHover(false);
                        dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(AppStoreItemList.this.getTypeName()));
                        final MyAppStoreFragment myAppStoreFragment = this;
                        final AppStoreItemList appStoreItemList2 = AppStoreItemList.this;
                        dslItem.setItemBindOverride(new Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.fragment.MyAppStoreFragment$showData$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                            }

                            @Override // Oox.Oxx0xo
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list2) {
                                invoke(dslViewHolder, num.intValue(), dslAdapterItem, list2);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            public final void invoke(@OOXIXo DslViewHolder itemHolder, int i2, @OOXIXo DslAdapterItem dslAdapterItem, @OOXIXo List<? extends Object> list2) {
                                String string;
                                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                IIX0o.x0xO0oo(list2, "<anonymous parameter 3>");
                                itemHolder.itemView.setPadding(0, oI00o.II0xO0.II0xO0(MyAppStoreFragment.this.getContext(), 8.0f), 0, oI00o.II0xO0.II0xO0(MyAppStoreFragment.this.getContext(), 8.0f));
                                TextView tv = itemHolder.tv(R.id.tv_name);
                                if (tv != null) {
                                    tv.setText(appStoreItemList2.getTypeName());
                                }
                                TextView tv2 = itemHolder.tv(R.id.app_store_more_tv);
                                if (tv2 != null) {
                                    if (appStoreItemList2.isShowAll()) {
                                        string = MyAppStoreFragment.this.getString(R.string.app_store_list_tip_expand);
                                    } else {
                                        string = MyAppStoreFragment.this.getString(R.string.app_store_list_tip_retract);
                                    }
                                    tv2.setText(string);
                                }
                                if (tv2 == null) {
                                    return;
                                }
                                tv2.setVisibility(appStoreItemList2.getList().size() <= 5 ? 4 : 0);
                            }
                        });
                        dslItem.setItemTag(AppStoreItemList.this.getTypeName());
                        dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.fragment.MyAppStoreFragment$showData$1.2
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OOXIXo View it) {
                                IIX0o.x0xO0oo(it, "it");
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                                invoke2(view);
                                return oXIO0o0XI.f29392oIX0oI;
                            }
                        });
                    }
                });
            }
            if (appStoreItemList.isShowAll()) {
                list = CollectionsKt___CollectionsKt.O0o000XOX(appStoreItemList.getList(), 5);
            } else {
                list = appStoreItemList.getList();
            }
            LogUtils.i("category.listFor" + list.size());
            for (final AppStoreDataItem appStoreDataItem : list) {
                if (!oOXoIIIo.I0Io.II0xO0(appStoreDataItem.getBleAppInfo().getMHide())) {
                    this.mAppNumber++;
                    DslAdapterExKt.oO(getDslAdapter(), R.layout.item_app_store, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.fragment.MyAppStoreFragment$showData$2

                        /* renamed from: com.sma.smartv3.ui.device.fragment.MyAppStoreFragment$showData$2$1, reason: invalid class name */
                        /* loaded from: classes12.dex */
                        public static final class AnonymousClass1 extends Lambda implements Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI> {
                            final /* synthetic */ AppStoreDataItem $item;
                            final /* synthetic */ DslAdapterItem $this_dslItem;
                            final /* synthetic */ MyAppStoreFragment this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass1(AppStoreDataItem appStoreDataItem, MyAppStoreFragment myAppStoreFragment, DslAdapterItem dslAdapterItem) {
                                super(4);
                                this.$item = appStoreDataItem;
                                this.this$0 = myAppStoreFragment;
                                this.$this_dslItem = dslAdapterItem;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final void invoke$lambda$0(MyAppStoreFragment this$0, AppStoreDataItem item, DslAdapterItem this_dslItem, View view) {
                                IIX0o.x0xO0oo(this$0, "this$0");
                                IIX0o.x0xO0oo(item, "$item");
                                IIX0o.x0xO0oo(this_dslItem, "$this_dslItem");
                                this$0.setMItemPositionPackageName(item.getBleAppInfo().getMPackage());
                                item.getBleAppInfo().setMHide(1);
                                this$0.showDeleteTipPopup(R.string.audio_book_delete_pop_title, R.string.app_store_delete_pop_content, R.string.audio_book_delete_pop_sure);
                                DslAdapter itemDslAdapter = this_dslItem.getItemDslAdapter();
                                if (itemDslAdapter != null) {
                                    DslAdapter.updateItemDepend$default(itemDslAdapter, null, 1, null);
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final boolean invoke$lambda$2$lambda$1(DslViewHolder itemHolder, View view, MotionEvent motionEvent) {
                                IIX0o.x0xO0oo(itemHolder, "$itemHolder");
                                return itemHolder.itemView.onTouchEvent(motionEvent);
                            }

                            @Override // Oox.Oxx0xo
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            public final void invoke(@OOXIXo final DslViewHolder itemHolder, int i, @OOXIXo DslAdapterItem adapterItem, @OOXIXo List<? extends Object> payloads) {
                                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                IIX0o.x0xO0oo(adapterItem, "adapterItem");
                                IIX0o.x0xO0oo(payloads, "payloads");
                                ImageView img = itemHolder.img(R.id.iv);
                                if (this.$item.getPath() != -1) {
                                    if (img != null) {
                                        img.setImageResource(this.$item.getPath());
                                    }
                                } else if (this.$item.getOnlinePath().length() > 0 && img != null) {
                                    Glide.with(img.getContext()).load(this.$item.getOnlinePath()).error(R.drawable.audiobook_normal_icon).into(img);
                                }
                                ImageView img2 = itemHolder.img(R.id.iv_new_icon);
                                if (img2 != null) {
                                    img2.setVisibility(this.$item.isShowNewFlag() ? 0 : 8);
                                }
                                TextView tv = itemHolder.tv(R.id.tv_name);
                                if (tv != null) {
                                    tv.setText(this.$item.getBleAppInfo().getMName());
                                }
                                TextView tv2 = itemHolder.tv(R.id.tv_size);
                                if (tv2 != null) {
                                    tv2.setText(this.$item.getBleAppInfo().getMSize() + "kb");
                                }
                                TextView tv3 = itemHolder.tv(R.id.tv_btn);
                                if (tv3 != null) {
                                    tv3.setText(this.this$0.getString(R.string.app_store_installed));
                                }
                                TextView tv4 = itemHolder.tv(R.id.tv_btn);
                                if (tv4 != null) {
                                    tv4.setEnabled(false);
                                }
                                final MyAppStoreFragment myAppStoreFragment = this.this$0;
                                final AppStoreDataItem appStoreDataItem = this.$item;
                                final DslAdapterItem dslAdapterItem = this.$this_dslItem;
                                itemHolder.click(R.id.bt_delete_record, 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00de: INVOKE 
                                      (r3v0 'itemHolder' com.angcyo.dsladapter.DslViewHolder)
                                      (wrap:int:SGET  A[WRAPPED] com.sma.smartv3.co_fit.R.id.bt_delete_record int)
                                      (wrap:android.view.View$OnClickListener:0x00d8: CONSTRUCTOR 
                                      (r4v14 'myAppStoreFragment' com.sma.smartv3.ui.device.fragment.MyAppStoreFragment A[DONT_INLINE])
                                      (r5v12 'appStoreDataItem' com.sma.smartv3.model.AppStoreDataItem A[DONT_INLINE])
                                      (r6v6 'dslAdapterItem' com.angcyo.dsladapter.DslAdapterItem A[DONT_INLINE])
                                     A[MD:(com.sma.smartv3.ui.device.fragment.MyAppStoreFragment, com.sma.smartv3.model.AppStoreDataItem, com.angcyo.dsladapter.DslAdapterItem):void (m), WRAPPED] call: com.sma.smartv3.ui.device.fragment.I0Io.<init>(com.sma.smartv3.ui.device.fragment.MyAppStoreFragment, com.sma.smartv3.model.AppStoreDataItem, com.angcyo.dsladapter.DslAdapterItem):void type: CONSTRUCTOR)
                                     VIRTUAL call: com.angcyo.dsladapter.DslViewHolder.click(int, android.view.View$OnClickListener):void A[MD:(int, android.view.View$OnClickListener):void (m)] in method: com.sma.smartv3.ui.device.fragment.MyAppStoreFragment$showData$2.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
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
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.fragment.I0Io, state: NOT_LOADED
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
                                    this = this;
                                    java.lang.String r4 = "itemHolder"
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r4)
                                    java.lang.String r4 = "adapterItem"
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r4)
                                    java.lang.String r4 = "payloads"
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r6, r4)
                                    r4 = 2131364945(0x7f0a0c51, float:1.8349741E38)
                                    android.widget.ImageView r4 = r3.img(r4)
                                    com.sma.smartv3.model.AppStoreDataItem r5 = r2.$item
                                    int r5 = r5.getPath()
                                    r6 = -1
                                    if (r5 == r6) goto L2b
                                    if (r4 == 0) goto L57
                                    com.sma.smartv3.model.AppStoreDataItem r5 = r2.$item
                                    int r5 = r5.getPath()
                                    r4.setImageResource(r5)
                                    goto L57
                                L2b:
                                    com.sma.smartv3.model.AppStoreDataItem r5 = r2.$item
                                    java.lang.String r5 = r5.getOnlinePath()
                                    int r5 = r5.length()
                                    if (r5 <= 0) goto L57
                                    if (r4 == 0) goto L57
                                    android.content.Context r5 = r4.getContext()
                                    com.bumptech.glide.RequestManager r5 = com.bumptech.glide.Glide.with(r5)
                                    com.sma.smartv3.model.AppStoreDataItem r6 = r2.$item
                                    java.lang.String r6 = r6.getOnlinePath()
                                    com.bumptech.glide.RequestBuilder r5 = r5.load(r6)
                                    r6 = 2131232383(0x7f08067f, float:1.8080874E38)
                                    com.bumptech.glide.request.BaseRequestOptions r5 = r5.error(r6)
                                    com.bumptech.glide.RequestBuilder r5 = (com.bumptech.glide.RequestBuilder) r5
                                    r5.into(r4)
                                L57:
                                    r4 = 2131365039(0x7f0a0caf, float:1.8349932E38)
                                    android.widget.ImageView r4 = r3.img(r4)
                                    r5 = 0
                                    if (r4 != 0) goto L62
                                    goto L71
                                L62:
                                    com.sma.smartv3.model.AppStoreDataItem r6 = r2.$item
                                    boolean r6 = r6.isShowNewFlag()
                                    if (r6 == 0) goto L6c
                                    r6 = 0
                                    goto L6e
                                L6c:
                                    r6 = 8
                                L6e:
                                    r4.setVisibility(r6)
                                L71:
                                    r4 = 2131368381(0x7f0a19bd, float:1.835671E38)
                                    android.widget.TextView r4 = r3.tv(r4)
                                    if (r4 != 0) goto L7b
                                    goto L88
                                L7b:
                                    com.sma.smartv3.model.AppStoreDataItem r6 = r2.$item
                                    com.szabh.smable3.entity.BleAppInfo r6 = r6.getBleAppInfo()
                                    java.lang.String r6 = r6.getMName()
                                    r4.setText(r6)
                                L88:
                                    r4 = 2131368473(0x7f0a1a19, float:1.8356897E38)
                                    android.widget.TextView r4 = r3.tv(r4)
                                    if (r4 != 0) goto L92
                                    goto Lb0
                                L92:
                                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                                    r6.<init>()
                                    com.sma.smartv3.model.AppStoreDataItem r0 = r2.$item
                                    com.szabh.smable3.entity.BleAppInfo r0 = r0.getBleAppInfo()
                                    int r0 = r0.getMSize()
                                    r6.append(r0)
                                    java.lang.String r0 = "kb"
                                    r6.append(r0)
                                    java.lang.String r6 = r6.toString()
                                    r4.setText(r6)
                                Lb0:
                                    r4 = 2131368219(0x7f0a191b, float:1.8356382E38)
                                    android.widget.TextView r6 = r3.tv(r4)
                                    if (r6 != 0) goto Lba
                                    goto Lc6
                                Lba:
                                    com.sma.smartv3.ui.device.fragment.MyAppStoreFragment r0 = r2.this$0
                                    r1 = 2132017461(0x7f140135, float:1.9673201E38)
                                    java.lang.String r0 = r0.getString(r1)
                                    r6.setText(r0)
                                Lc6:
                                    android.widget.TextView r4 = r3.tv(r4)
                                    if (r4 != 0) goto Lcd
                                    goto Ld0
                                Lcd:
                                    r4.setEnabled(r5)
                                Ld0:
                                    com.sma.smartv3.ui.device.fragment.MyAppStoreFragment r4 = r2.this$0
                                    com.sma.smartv3.model.AppStoreDataItem r5 = r2.$item
                                    com.angcyo.dsladapter.DslAdapterItem r6 = r2.$this_dslItem
                                    com.sma.smartv3.ui.device.fragment.I0Io r0 = new com.sma.smartv3.ui.device.fragment.I0Io
                                    r0.<init>(r4, r5, r6)
                                    r4 = 2131363391(0x7f0a063f, float:1.834659E38)
                                    r3.click(r4, r0)
                                    r4 = 2131365907(0x7f0a1013, float:1.8351693E38)
                                    android.view.View r4 = r3.view(r4)
                                    if (r4 == 0) goto Lf2
                                    com.sma.smartv3.ui.device.fragment.oxoX r5 = new com.sma.smartv3.ui.device.fragment.oxoX
                                    r5.<init>(r3)
                                    r4.setOnTouchListener(r5)
                                Lf2:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.fragment.MyAppStoreFragment$showData$2.AnonymousClass1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                            invoke2(dslAdapterItem);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OOXIXo final DslAdapterItem dslItem) {
                            IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                            dslItem.setItemSwipeMenuFlag(4);
                            dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(AppStoreItemList.this.getTypeName()));
                            dslItem.setItemBindOverride(new AnonymousClass1(appStoreDataItem, this, dslItem));
                            dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.fragment.MyAppStoreFragment$showData$2.2
                                {
                                    super(1);
                                }

                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                                    invoke2(view);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@OOXIXo View view) {
                                    IIX0o.x0xO0oo(view, "view");
                                    SwipeMenuHelper swipeMenuHelper = DslAdapterItem.this.get_itemSwipeMenuHelper();
                                    if (swipeMenuHelper != null) {
                                        SwipeMenuHelper.closeSwipeMenu$default(swipeMenuHelper, null, 1, null);
                                    }
                                }
                            });
                        }
                    });
                }
            }
        }
        View mEmptyLayout = getMEmptyLayout();
        if (this.mAppNumber != 0) {
            i = 8;
        }
        mEmptyLayout.setVisibility(i);
    }

    public final void upData(@OOXIXo List<AppStoreItemList> list) {
        IIX0o.x0xO0oo(list, "list");
        this.mAppStoreItemList = list;
        getDslViewHolder().postDelay(300L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.fragment.MyAppStoreFragment$upData$1
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                final MyAppStoreFragment myAppStoreFragment = MyAppStoreFragment.this;
                myAppStoreFragment.renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.fragment.MyAppStoreFragment$upData$1.1
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                        invoke2(dslAdapter);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OOXIXo DslAdapter renderAdapter) {
                        IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                        DslAdapter.setAdapterStatus$default(renderAdapter, 0, null, 2, null);
                        MyAppStoreFragment.this.showData();
                    }
                });
            }
        });
    }
}
