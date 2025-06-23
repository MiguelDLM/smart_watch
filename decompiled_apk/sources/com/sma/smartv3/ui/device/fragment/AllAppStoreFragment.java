package com.sma.smartv3.ui.device.fragment;

import OXOo.OOXIXo;
import Oox.Oxx0xo;
import Oox.oOoXoXO;
import XO0.XO;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppStoreDataItem;
import com.sma.smartv3.model.AppStoreFileManager;
import com.sma.smartv3.model.AppStoreItemList;
import com.sma.smartv3.model.AppStoreItemType;
import com.sma.smartv3.ui.device.AppStoreActivity;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleAppFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nAllAppStoreFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllAppStoreFragment.kt\ncom/sma/smartv3/ui/device/fragment/AllAppStoreFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,213:1\n1855#2,2:214\n*S KotlinDebug\n*F\n+ 1 AllAppStoreFragment.kt\ncom/sma/smartv3/ui/device/fragment/AllAppStoreFragment\n*L\n199#1:214,2\n*E\n"})
/* loaded from: classes12.dex */
public final class AllAppStoreFragment extends BaseJLFileManageFragment {
    private int mItemPosition;

    @OOXIXo
    private final X0IIOO mDeviceStorage$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.fragment.AllAppStoreFragment$mDeviceStorage$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = AllAppStoreFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.storage_device);
        }
    });

    @OOXIXo
    private List<AppStoreItemList> mAppStoreItemList = new ArrayList();

    public static /* synthetic */ void setDeviceStorage$default(AllAppStoreFragment allAppStoreFragment, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            FragmentActivity activity = allAppStoreFragment.getActivity();
            IIX0o.x0XOIxOo(activity, "null cannot be cast to non-null type com.sma.smartv3.ui.device.AppStoreActivity");
            str = ((AppStoreActivity) activity).getTotalDeviceStorage();
        }
        if ((i & 2) != 0) {
            FragmentActivity activity2 = allAppStoreFragment.getActivity();
            IIX0o.x0XOIxOo(activity2, "null cannot be cast to non-null type com.sma.smartv3.ui.device.AppStoreActivity");
            str2 = ((AppStoreActivity) activity2).getFreeSizeDeviceStorage();
        }
        allAppStoreFragment.setDeviceStorage(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showData() {
        List<AppStoreDataItem> list;
        getDslAdapter().resetItem(new ArrayList());
        for (final AppStoreItemList appStoreItemList : this.mAppStoreItemList) {
            if (!appStoreItemList.getList().isEmpty()) {
                DslAdapterExKt.oO(getDslAdapter(), R.layout.item_app_store_title_name, new oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.fragment.AllAppStoreFragment$showData$1
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
                        final AppStoreItemList appStoreItemList2 = AppStoreItemList.this;
                        final AllAppStoreFragment allAppStoreFragment = this;
                        dslItem.setItemBindOverride(new Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.fragment.AllAppStoreFragment$showData$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                            }

                            @Override // Oox.Oxx0xo
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list2) {
                                invoke(dslViewHolder, num.intValue(), dslAdapterItem, list2);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            public final void invoke(@OOXIXo DslViewHolder itemHolder, int i, @OOXIXo DslAdapterItem dslAdapterItem, @OOXIXo List<? extends Object> list2) {
                                String string;
                                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                IIX0o.x0xO0oo(list2, "<anonymous parameter 3>");
                                TextView tv = itemHolder.tv(R.id.tv_name);
                                if (tv != null) {
                                    tv.setText(AppStoreItemList.this.getTypeName());
                                }
                                TextView tv2 = itemHolder.tv(R.id.app_store_more_tv);
                                if (tv2 != null) {
                                    if (AppStoreItemList.this.isShowAll()) {
                                        string = allAppStoreFragment.getString(R.string.app_store_list_tip_expand);
                                    } else {
                                        string = allAppStoreFragment.getString(R.string.app_store_list_tip_retract);
                                    }
                                    tv2.setText(string);
                                }
                                if (tv2 == null) {
                                    return;
                                }
                                tv2.setVisibility(AppStoreItemList.this.getList().size() > 5 ? 0 : 8);
                            }
                        });
                        dslItem.setItemTag(AppStoreItemList.this.getTypeName());
                        final AppStoreItemList appStoreItemList3 = AppStoreItemList.this;
                        final AllAppStoreFragment allAppStoreFragment2 = this;
                        dslItem.setItemClick(new oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.fragment.AllAppStoreFragment$showData$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                                invoke2(view);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OOXIXo View it) {
                                IIX0o.x0xO0oo(it, "it");
                                AppStoreItemList.this.setShowAll(!r2.isShowAll());
                                allAppStoreFragment2.syncAdapterData();
                                allAppStoreFragment2.getDslAdapter().notifyDataChanged();
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
            for (final AppStoreDataItem appStoreDataItem : list) {
                DslAdapterExKt.oO(getDslAdapter(), R.layout.item_app_store, new oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.fragment.AllAppStoreFragment$showData$2

                    /* renamed from: com.sma.smartv3.ui.device.fragment.AllAppStoreFragment$showData$2$1, reason: invalid class name */
                    /* loaded from: classes12.dex */
                    public static final class AnonymousClass1 extends Lambda implements Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI> {
                        final /* synthetic */ AppStoreDataItem $item;
                        final /* synthetic */ AllAppStoreFragment this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(AppStoreDataItem appStoreDataItem, AllAppStoreFragment allAppStoreFragment) {
                            super(4);
                            this.$item = appStoreDataItem;
                            this.this$0 = allAppStoreFragment;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final void invoke$lambda$0(AppStoreDataItem item, AllAppStoreFragment this$0, int i, View view) {
                            int i2;
                            int i3;
                            IIX0o.x0xO0oo(item, "$item");
                            IIX0o.x0xO0oo(this$0, "this$0");
                            int appStoreType = item.getAppStoreType();
                            if (appStoreType == AppStoreItemType.INSTALL.getType() || appStoreType == AppStoreItemType.RENEW.getType()) {
                                this$0.syncData();
                                int i4 = 1;
                                this$0.setSync(true);
                                this$0.setMItemPosition(i);
                                if (item.getPath() != -1) {
                                    BleConnector bleConnector = BleConnector.INSTANCE;
                                    BleKey bleKey = BleKey.APP_FILE;
                                    String mPackage = item.getBleAppInfo().getMPackage();
                                    if (AppStoreItemType.RENEW.getType() == item.getAppStoreType()) {
                                        i3 = 1;
                                    } else {
                                        i3 = 0;
                                    }
                                    bleConnector.sendStream(bleKey, new BleAppFile(mPackage, i3, null, 4, null).toByteArray(), 2);
                                } else {
                                    this$0.setNeedToDownloadFile(true);
                                    AppStoreFileManager appStoreFileManager = AppStoreFileManager.INSTANCE;
                                    String binOnlinePath = item.getBinOnlinePath();
                                    String mPackage2 = item.getBleAppInfo().getMPackage();
                                    if (item.getBleAppInfo().getMIsGame() == 1) {
                                        i2 = 0;
                                    } else {
                                        i2 = 1;
                                    }
                                    if (AppStoreItemType.RENEW.getType() != item.getAppStoreType()) {
                                        i4 = 0;
                                    }
                                    appStoreFileManager.downloadAppFile(binOnlinePath, mPackage2, i2, i4);
                                }
                                item.getBleAppInfo().setMHide(0);
                                item.setAppStoreType(AppStoreItemType.INSTALLED.getType());
                                return;
                            }
                            if (appStoreType == AppStoreItemType.NOT_RENEW.getType()) {
                                ToastUtils.showLong(this$0.getString(R.string.app_store_item_not_renew_tip), new Object[0]);
                            }
                        }

                        @Override // Oox.Oxx0xo
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                            invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(@OOXIXo DslViewHolder itemHolder, final int i, @OOXIXo DslAdapterItem adapterItem, @OOXIXo List<? extends Object> payloads) {
                            String string;
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
                            TextView textView = (TextView) itemHolder.v(R.id.tv_btn);
                            if (textView != null) {
                                int appStoreType = this.$item.getAppStoreType();
                                if (appStoreType == AppStoreItemType.INSTALL.getType()) {
                                    string = this.this$0.getString(R.string.app_store_install);
                                } else {
                                    string = appStoreType == AppStoreItemType.INSTALLED.getType() ? this.this$0.getString(R.string.app_store_installed) : this.this$0.getString(R.string.app_store_item_renew);
                                }
                                textView.setText(string);
                            }
                            if (textView != null) {
                                textView.setEnabled(this.$item.getAppStoreType() != AppStoreItemType.INSTALLED.getType());
                            }
                            if (textView != null) {
                                final AppStoreDataItem appStoreDataItem = this.$item;
                                final AllAppStoreFragment allAppStoreFragment = this.this$0;
                                textView.setOnClickListener(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0112: INVOKE 
                                      (r3v2 'textView' android.widget.TextView)
                                      (wrap:android.view.View$OnClickListener:0x010f: CONSTRUCTOR 
                                      (r5v11 'appStoreDataItem' com.sma.smartv3.model.AppStoreDataItem A[DONT_INLINE])
                                      (r6v12 'allAppStoreFragment' com.sma.smartv3.ui.device.fragment.AllAppStoreFragment A[DONT_INLINE])
                                      (r4v0 'i' int A[DONT_INLINE])
                                     A[MD:(com.sma.smartv3.model.AppStoreDataItem, com.sma.smartv3.ui.device.fragment.AllAppStoreFragment, int):void (m), WRAPPED] call: com.sma.smartv3.ui.device.fragment.oIX0oI.<init>(com.sma.smartv3.model.AppStoreDataItem, com.sma.smartv3.ui.device.fragment.AllAppStoreFragment, int):void type: CONSTRUCTOR)
                                     VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.ui.device.fragment.AllAppStoreFragment$showData$2.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
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
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.fragment.oIX0oI, state: NOT_LOADED
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
                                    	... 23 more
                                    */
                                /*
                                    Method dump skipped, instructions count: 278
                                    To view this dump add '--comments-level debug' option
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.fragment.AllAppStoreFragment$showData$2.AnonymousClass1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
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
                        public final void invoke2(@OOXIXo DslAdapterItem dslItem) {
                            IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                            dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(AppStoreItemList.this.getTypeName()));
                            dslItem.setItemBindOverride(new AnonymousClass1(appStoreDataItem, this));
                        }
                    });
                }
            }
        }

        @XO(tag = "add_app_store_success")
        public final void addAppStoreSuccess(@OOXIXo Object data) {
            IIX0o.x0xO0oo(data, "data");
            getDslAdapter().notifyItemChanged(this.mItemPosition);
        }

        @OOXIXo
        public final List<AppStoreItemList> getMAppStoreItemList() {
            return this.mAppStoreItemList;
        }

        public final PFMedium getMDeviceStorage() {
            return (PFMedium) this.mDeviceStorage$delegate.getValue();
        }

        public final int getMItemPosition() {
            return this.mItemPosition;
        }

        @Override // com.sma.smartv3.ui.device.fragment.BaseJLFileManageFragment, com.bestmafen.androidbase.base.oIX0oI
        public int layoutId() {
            return R.layout.fragment_all_app_store;
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
        public void onInitBaseLayoutAfter() {
            super.onInitBaseLayoutAfter();
            getRecyclerView().setLayoutManager(new LinearLayoutManager(getMActivity()));
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

        public final void setMAppStoreItemList(@OOXIXo List<AppStoreItemList> list) {
            IIX0o.x0xO0oo(list, "<set-?>");
            this.mAppStoreItemList = list;
        }

        public final void setMItemPosition(int i) {
            this.mItemPosition = i;
        }

        public final void syncAdapterData() {
            renderAdapter(new oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.fragment.AllAppStoreFragment$syncAdapterData$1
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
                    AllAppStoreFragment.this.showData();
                }
            });
        }

        public final void upData(@OOXIXo List<AppStoreItemList> list) {
            IIX0o.x0xO0oo(list, "list");
            this.mAppStoreItemList = list;
            syncAdapterData();
        }

        @XO(tag = "updata_app_store_success")
        public final void upDataAppStoreSuccess(@OOXIXo String data) {
            IIX0o.x0xO0oo(data, "data");
            Iterator<T> it = this.mAppStoreItemList.iterator();
            while (it.hasNext()) {
                Iterator<AppStoreDataItem> it2 = ((AppStoreItemList) it.next()).getList().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        AppStoreDataItem next = it2.next();
                        if (IIX0o.Oxx0IOOO(next.getBleAppInfo().getMPackage(), data)) {
                            next.getBleAppInfo().setMHide(1);
                            break;
                        }
                    }
                }
            }
            getDslAdapter().clearAllItems();
            showData();
            getDslAdapter().notifyDataChanged();
        }
    }
