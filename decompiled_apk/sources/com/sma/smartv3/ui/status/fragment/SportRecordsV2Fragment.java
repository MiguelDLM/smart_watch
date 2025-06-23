package com.sma.smartv3.ui.status.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslAdapterStatusItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.SwipeMenuHelper;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.dsl.AdapterStatusItem;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.SportRecordData;
import com.sma.smartv3.model.SportRecordDataKt;
import com.sma.smartv3.model.SportRecordItemCommonData;
import com.sma.smartv3.ui.sport.SportDetailActivity;
import com.sma.smartv3.ui.sport.SportDetailV2Activity;
import com.sma.smartv3.ui.status.SportRecordsDetailActivity;
import com.sma.smartv3.ui.status.base.BaseRecyclerRecordsFragment;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.XX0xXo;
import com.sma.smartv3.util.Xo0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nSportRecordsV2Fragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportRecordsV2Fragment.kt\ncom/sma/smartv3/ui/status/fragment/SportRecordsV2Fragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,315:1\n19#2:316\n15#2:317\n1655#3,8:318\n*S KotlinDebug\n*F\n+ 1 SportRecordsV2Fragment.kt\ncom/sma/smartv3/ui/status/fragment/SportRecordsV2Fragment\n*L\n56#1:316\n56#1:317\n119#1:318,8\n*E\n"})
/* loaded from: classes12.dex */
public final class SportRecordsV2Fragment extends BaseRecyclerRecordsFragment<SportRecordData> {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    @OXOo.OOXIXo
    private static final String TAG = "SportRecordsV2Fragment";
    private boolean competitionSelectionTime;

    @OXOo.OOXIXo
    private final X0IIOO mTotalCalorie$delegate;

    @OXOo.OOXIXo
    private final X0IIOO mTotalCalorieUnit$delegate;

    @OXOo.OOXIXo
    private final X0IIOO mTotalDuration$delegate;

    @OXOo.OOXIXo
    private final X0IIOO mTotalDurationUnit$delegate;

    @OXOo.OOXIXo
    private final X0IIOO mTotalLayout$delegate;

    @OXOo.OOXIXo
    private final X0IIOO mTotalSize$delegate;

    @OXOo.OOXIXo
    private final X0IIOO mTotalSizeUnit$delegate;

    @OXOo.OOXIXo
    private final X0IIOO mTotalTitle$delegate;
    private int page;

    @OXOo.OOXIXo
    private ArrayList<SportRecordData> sportRecordList;

    @OXOo.OOXIXo
    private final AppUser userProfile;

    @OXOo.OOXIXo
    private final TimePeriod mTimePeriod = TimePeriod.DAY;
    private final int pageNumber = 200;

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public SportRecordsV2Fragment() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
        this.mTotalTitle$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment$mTotalTitle$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportRecordsV2Fragment.this.getMView();
                return (TextView) mView.findViewById(R.id.sport_record_total_title);
            }
        });
        this.mTotalDuration$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment$mTotalDuration$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportRecordsV2Fragment.this.getMView();
                return (TextView) mView.findViewById(R.id.sport_record_total_duration);
            }
        });
        this.mTotalDurationUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment$mTotalDurationUnit$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportRecordsV2Fragment.this.getMView();
                return (TextView) mView.findViewById(R.id.sport_record_total_duration_unit);
            }
        });
        this.mTotalLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment$mTotalLayout$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final View invoke() {
                View mView;
                mView = SportRecordsV2Fragment.this.getMView();
                return mView.findViewById(R.id.sport_record_total_layout);
            }
        });
        this.mTotalSize$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment$mTotalSize$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportRecordsV2Fragment.this.getMView();
                return (TextView) mView.findViewById(R.id.sport_record_total_size);
            }
        });
        this.mTotalSizeUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment$mTotalSizeUnit$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportRecordsV2Fragment.this.getMView();
                return (TextView) mView.findViewById(R.id.sport_record_total_size_unit);
            }
        });
        this.mTotalCalorie$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment$mTotalCalorie$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportRecordsV2Fragment.this.getMView();
                return (TextView) mView.findViewById(R.id.sport_record_total_calorie);
            }
        });
        this.mTotalCalorieUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment$mTotalCalorieUnit$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportRecordsV2Fragment.this.getMView();
                return (TextView) mView.findViewById(R.id.sport_record_total_calorie_unit);
            }
        });
        this.sportRecordList = new ArrayList<>();
        setInitUpdate(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
    public final void findData(final DslAdapter dslAdapter, ArrayList<SportRecordData> arrayList) {
        getMTotalSize().setText(String.valueOf(arrayList.size()));
        Iterator<SportRecordData> it = arrayList.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            final SportRecordData next = it.next();
            Activity mActivity = getMActivity();
            AppUser appUser = this.userProfile;
            IIX0o.ooOOo0oXI(next);
            final SportRecordItemCommonData parseSportRecordItemCommonData = SportRecordDataKt.parseSportRecordItemCommonData(mActivity, appUser, next);
            i += parseSportRecordItemCommonData.getMDuration();
            i2 += parseSportRecordItemCommonData.getMCalorie();
            LogUtils.i("SportRecordsV2Fragment itemData==" + parseSportRecordItemCommonData + TokenParser.SP);
            DslAdapterExKt.oO(dslAdapter, R.layout.status_item_sport_record_detail_v2, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment$findData$1

                /* renamed from: com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment$findData$1$1, reason: invalid class name */
                /* loaded from: classes12.dex */
                public static final class AnonymousClass1 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI> {
                    final /* synthetic */ SportRecordItemCommonData $itemData;
                    final /* synthetic */ SportRecordData $sportRecordData;
                    final /* synthetic */ DslAdapterItem $this_dslItem;
                    final /* synthetic */ DslAdapter $this_findData;
                    final /* synthetic */ SportRecordsV2Fragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(SportRecordItemCommonData sportRecordItemCommonData, SportRecordData sportRecordData, SportRecordsV2Fragment sportRecordsV2Fragment, DslAdapterItem dslAdapterItem, DslAdapter dslAdapter) {
                        super(4);
                        this.$itemData = sportRecordItemCommonData;
                        this.$sportRecordData = sportRecordData;
                        this.this$0 = sportRecordsV2Fragment;
                        this.$this_dslItem = dslAdapterItem;
                        this.$this_findData = dslAdapter;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void invoke$lambda$0(SportRecordData sportRecordData, DslAdapterItem this_dslItem, DslViewHolder itemHolder, SportRecordsV2Fragment this$0, DslAdapter this_findData, View view) {
                        TextView mTotalSize;
                        Integer num;
                        List<DslAdapterItem> dataItems;
                        List<DslAdapterItem> dataItems2;
                        IIX0o.x0xO0oo(sportRecordData, "$sportRecordData");
                        IIX0o.x0xO0oo(this_dslItem, "$this_dslItem");
                        IIX0o.x0xO0oo(itemHolder, "$itemHolder");
                        IIX0o.x0xO0oo(this$0, "this$0");
                        IIX0o.x0xO0oo(this_findData, "$this_findData");
                        SportRecordDataKt.deleteSportRecord(sportRecordData);
                        SwipeMenuHelper swipeMenuHelper = this_dslItem.get_itemSwipeMenuHelper();
                        if (swipeMenuHelper != null) {
                            swipeMenuHelper.closeSwipeMenu(itemHolder);
                        }
                        DslAdapter itemDslAdapter = this_dslItem.getItemDslAdapter();
                        if (itemDslAdapter != null) {
                            DslAdapter.removeItem$default(itemDslAdapter, this_dslItem, false, 2, null);
                        }
                        mTotalSize = this$0.getMTotalSize();
                        DslAdapter itemDslAdapter2 = this_dslItem.getItemDslAdapter();
                        if (itemDslAdapter2 != null && (dataItems2 = itemDslAdapter2.getDataItems()) != null) {
                            num = Integer.valueOf(dataItems2.size());
                        } else {
                            num = null;
                        }
                        mTotalSize.setText(String.valueOf(num));
                        DslAdapter itemDslAdapter3 = this_dslItem.getItemDslAdapter();
                        if (itemDslAdapter3 != null && (dataItems = itemDslAdapter3.getDataItems()) != null && dataItems.size() == 0) {
                            DslAdapter.setAdapterStatus$default(this_findData, 1, null, 2, null);
                        }
                        DslAdapter itemDslAdapter4 = this_dslItem.getItemDslAdapter();
                        if (itemDslAdapter4 != null) {
                            DslAdapter.updateItemDepend$default(itemDslAdapter4, null, 1, null);
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

                    public final void invoke(@OXOo.OOXIXo final DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                        AppUser appUser;
                        AppUser appUser2;
                        IIX0o.x0xO0oo(itemHolder, "itemHolder");
                        IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                        IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                        ImageView img = itemHolder.img(R.id.sportTypeIv);
                        if (img != null) {
                            img.setImageResource(this.$itemData.getWorkoutImg());
                        }
                        TextView tv = itemHolder.tv(R.id.sportName);
                        if (tv != null) {
                            tv.setText(this.$itemData.getWorkoutModeName());
                        }
                        TextView tv2 = itemHolder.tv(R.id.sportStartTime);
                        if (tv2 != null) {
                            tv2.setText(this.$itemData.getSportStartTime());
                        }
                        boolean I0Io2 = XX0xXo.f24343oIX0oI.I0Io(this.$sportRecordData.getMMode(), this.$sportRecordData.getMPlatform());
                        LogUtils.i("SportRecordsV2Fragment " + this.$itemData.getMPlatform() + TokenParser.SP + I0Io2 + TokenParser.SP + this.$sportRecordData.getMMode());
                        if (I0Io2) {
                            TextView tv3 = itemHolder.tv(R.id.sportDistance);
                            if (tv3 != null) {
                                int mDistance = this.$itemData.getMDistance();
                                appUser2 = this.this$0.userProfile;
                                tv3.setText(String.valueOf(TextConvertKt.ooOOo0oXI(mDistance, appUser2.getUnit(), false, 4, null)));
                            }
                            TextView tv4 = itemHolder.tv(R.id.sportDistance_unit);
                            if (tv4 != null) {
                                appUser = this.this$0.userProfile;
                                tv4.setText(TextConvertKt.oI0IIXIo(appUser.getUnit()));
                            }
                            this.this$0.onVisibility(itemHolder, 8);
                        } else {
                            TextView tv5 = itemHolder.tv(R.id.sportDistance);
                            if (tv5 != null) {
                                tv5.setText(String.valueOf(this.$itemData.getMCalorie() / 1000));
                            }
                            TextView tv6 = itemHolder.tv(R.id.sportDistance_unit);
                            if (tv6 != null) {
                                tv6.setText(this.this$0.getString(R.string.kcal));
                            }
                            this.this$0.onVisibility(itemHolder, 8);
                        }
                        TextView tv7 = itemHolder.tv(R.id.sportDistanceTimeTv);
                        if (tv7 != null) {
                            tv7.setText(com.sma.smartv3.util.xoIox.IoOoX(this.$itemData.getMDuration() * 1000));
                        }
                        final SportRecordData sportRecordData = this.$sportRecordData;
                        final DslAdapterItem dslAdapterItem2 = this.$this_dslItem;
                        final SportRecordsV2Fragment sportRecordsV2Fragment = this.this$0;
                        final DslAdapter dslAdapter = this.$this_findData;
                        itemHolder.click(R.id.bt_delete_sport_record, 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0130: INVOKE 
                              (r7v0 'itemHolder' com.angcyo.dsladapter.DslViewHolder)
                              (wrap:int:SGET  A[WRAPPED] com.sma.smartv3.co_fit.R.id.bt_delete_sport_record int)
                              (wrap:android.view.View$OnClickListener:0x012a: CONSTRUCTOR 
                              (r1v1 'sportRecordData' com.sma.smartv3.model.SportRecordData A[DONT_INLINE])
                              (r2v0 'dslAdapterItem2' com.angcyo.dsladapter.DslAdapterItem A[DONT_INLINE])
                              (r7v0 'itemHolder' com.angcyo.dsladapter.DslViewHolder A[DONT_INLINE])
                              (r4v0 'sportRecordsV2Fragment' com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment A[DONT_INLINE])
                              (r5v0 'dslAdapter' com.angcyo.dsladapter.DslAdapter A[DONT_INLINE])
                             A[MD:(com.sma.smartv3.model.SportRecordData, com.angcyo.dsladapter.DslAdapterItem, com.angcyo.dsladapter.DslViewHolder, com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment, com.angcyo.dsladapter.DslAdapter):void (m), WRAPPED] call: com.sma.smartv3.ui.status.fragment.xoIox.<init>(com.sma.smartv3.model.SportRecordData, com.angcyo.dsladapter.DslAdapterItem, com.angcyo.dsladapter.DslViewHolder, com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment, com.angcyo.dsladapter.DslAdapter):void type: CONSTRUCTOR)
                             VIRTUAL call: com.angcyo.dsladapter.DslViewHolder.click(int, android.view.View$OnClickListener):void A[MD:(int, android.view.View$OnClickListener):void (m)] in method: com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment$findData$1.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.status.fragment.xoIox, state: NOT_LOADED
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
                            Method dump skipped, instructions count: 325
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment$findData$1.AnonymousClass1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
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
                public final void invoke2(@OXOo.OOXIXo final DslAdapterItem dslItem) {
                    IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                    dslItem.setItemSwipeMenuFlag(4);
                    dslItem.setItemBindOverride(new AnonymousClass1(SportRecordItemCommonData.this, next, this, dslItem, dslAdapter));
                    final SportRecordData sportRecordData = next;
                    final SportRecordsV2Fragment sportRecordsV2Fragment = this;
                    dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment$findData$1.2
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
                        public final void invoke2(@OXOo.OOXIXo View it2) {
                            IIX0o.x0xO0oo(it2, "it");
                            StringBuilder sb = new StringBuilder();
                            sb.append("SportRecordsV2Fragment itemClick");
                            sb.append(SportRecordData.this.getMSource());
                            sb.append("  ");
                            ProjectManager projectManager = ProjectManager.f19822oIX0oI;
                            sb.append(projectManager.OO0());
                            LogUtils.i(sb.toString());
                            LogUtils.i("SportRecordsV2Fragment mWorkoutId==" + SportRecordData.this.getMWorkoutId() + TokenParser.SP);
                            int mSource = SportRecordData.this.getMSource();
                            if (mSource != 1) {
                                if (mSource != 2) {
                                    SportRecordsV2Fragment sportRecordsV2Fragment2 = sportRecordsV2Fragment;
                                    SportRecordData sportRecordData2 = SportRecordData.this;
                                    Bundle bundle = new Bundle();
                                    bundle.putString("mArg0", null);
                                    bundle.putParcelable("mArg2", sportRecordData2);
                                    bundle.putSerializable("mArg3", null);
                                    Intent intent = new Intent(sportRecordsV2Fragment2.getActivity(), (Class<?>) SportRecordsDetailActivity.class);
                                    intent.putExtras(bundle);
                                    sportRecordsV2Fragment2.startActivity(intent);
                                } else if (projectManager.OO0()) {
                                    SportRecordsV2Fragment sportRecordsV2Fragment3 = sportRecordsV2Fragment;
                                    int mWorkoutId = SportRecordData.this.getMWorkoutId();
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString("mArg0", null);
                                    bundle2.putInt("mArg1", mWorkoutId);
                                    bundle2.putParcelable("mArg2", null);
                                    bundle2.putSerializable("mArg3", null);
                                    Intent intent2 = new Intent(sportRecordsV2Fragment3.getActivity(), (Class<?>) SportDetailV2Activity.class);
                                    intent2.putExtras(bundle2);
                                    sportRecordsV2Fragment3.startActivity(intent2);
                                } else {
                                    SportRecordsV2Fragment sportRecordsV2Fragment4 = sportRecordsV2Fragment;
                                    int mWorkoutId2 = SportRecordData.this.getMWorkoutId();
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putString("mArg0", null);
                                    bundle3.putInt("mArg1", mWorkoutId2);
                                    bundle3.putParcelable("mArg2", null);
                                    bundle3.putSerializable("mArg3", null);
                                    Intent intent3 = new Intent(sportRecordsV2Fragment4.getActivity(), (Class<?>) SportDetailActivity.class);
                                    intent3.putExtras(bundle3);
                                    sportRecordsV2Fragment4.startActivity(intent3);
                                }
                            } else if (projectManager.OO0()) {
                                SportRecordsV2Fragment sportRecordsV2Fragment5 = sportRecordsV2Fragment;
                                int mWorkoutId3 = SportRecordData.this.getMWorkoutId();
                                Bundle bundle4 = new Bundle();
                                bundle4.putString("mArg0", null);
                                bundle4.putInt("mArg1", mWorkoutId3);
                                bundle4.putParcelable("mArg2", null);
                                bundle4.putSerializable("mArg3", null);
                                Intent intent4 = new Intent(sportRecordsV2Fragment5.getActivity(), (Class<?>) SportDetailV2Activity.class);
                                intent4.putExtras(bundle4);
                                sportRecordsV2Fragment5.startActivity(intent4);
                            } else if (projectManager.XoIxOXIXo()) {
                                SportRecordsV2Fragment sportRecordsV2Fragment6 = sportRecordsV2Fragment;
                                int mWorkoutId4 = SportRecordData.this.getMWorkoutId();
                                Bundle bundle5 = new Bundle();
                                bundle5.putString("mArg0", null);
                                bundle5.putInt("mArg1", mWorkoutId4);
                                bundle5.putParcelable("mArg2", null);
                                bundle5.putSerializable("mArg3", null);
                                Intent intent5 = new Intent(sportRecordsV2Fragment6.getActivity(), (Class<?>) SportDetailActivity.class);
                                intent5.putExtras(bundle5);
                                sportRecordsV2Fragment6.startActivity(intent5);
                            } else {
                                SportRecordsV2Fragment sportRecordsV2Fragment7 = sportRecordsV2Fragment;
                                SportRecordData sportRecordData3 = SportRecordData.this;
                                Bundle bundle6 = new Bundle();
                                bundle6.putString("mArg0", null);
                                bundle6.putParcelable("mArg2", sportRecordData3);
                                bundle6.putSerializable("mArg3", null);
                                Intent intent6 = new Intent(sportRecordsV2Fragment7.getActivity(), (Class<?>) SportRecordsDetailActivity.class);
                                intent6.putExtras(bundle6);
                                sportRecordsV2Fragment7.startActivity(intent6);
                            }
                            SwipeMenuHelper swipeMenuHelper = dslItem.get_itemSwipeMenuHelper();
                            if (swipeMenuHelper != null) {
                                SwipeMenuHelper.closeSwipeMenu$default(swipeMenuHelper, null, 1, null);
                            }
                        }
                    });
                }
            });
            getMTotalDuration().setText(com.sma.smartv3.util.xoIox.XX(i * 1000));
            getMTotalCalorie().setText(String.valueOf(i2 / 1000));
            if (arrayList.size() != 0) {
                getMTotalLayout().setVisibility(0);
            }
        }
    }

    private final TextView getMTotalCalorie() {
        return (TextView) this.mTotalCalorie$delegate.getValue();
    }

    private final TextView getMTotalCalorieUnit() {
        return (TextView) this.mTotalCalorieUnit$delegate.getValue();
    }

    private final TextView getMTotalDuration() {
        return (TextView) this.mTotalDuration$delegate.getValue();
    }

    private final TextView getMTotalDurationUnit() {
        return (TextView) this.mTotalDurationUnit$delegate.getValue();
    }

    private final View getMTotalLayout() {
        return (View) this.mTotalLayout$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getMTotalSize() {
        return (TextView) this.mTotalSize$delegate.getValue();
    }

    private final TextView getMTotalSizeUnit() {
        return (TextView) this.mTotalSizeUnit$delegate.getValue();
    }

    private final TextView getMTotalTitle() {
        return (TextView) this.mTotalTitle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onVisibility(DslViewHolder dslViewHolder, int i) {
        TextView tv = dslViewHolder.tv(R.id.sportPace);
        if (tv != null) {
            tv.setVisibility(i);
        }
        TextView tv2 = dslViewHolder.tv(R.id.sportPaceUnit);
        if (tv2 != null) {
            tv2.setVisibility(i);
        }
    }

    public static /* synthetic */ void onVisibility$default(SportRecordsV2Fragment sportRecordsV2Fragment, DslViewHolder dslViewHolder, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        sportRecordsV2Fragment.onVisibility(dslViewHolder, i);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseRecyclerRecordsFragment
    @OXOo.OOXIXo
    public DslAdapterStatusItem adapterStatusItem() {
        setAdapterStatus(new AdapterStatusItem());
        return getAdapterStatus();
    }

    public final boolean getCompetitionSelectionTime() {
        return this.competitionSelectionTime;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseStatusFragment
    @OXOo.OOXIXo
    public TimePeriod getMTimePeriod() {
        return this.mTimePeriod;
    }

    @OXOo.OOXIXo
    public final ArrayList<SportRecordData> getSportRecordList() {
        return this.sportRecordList;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseStatusFragment, com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        super.init(bundle);
        XO0.II0xO0.oxoX().x0XOIxOo(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sma.smartv3.ui.status.base.BaseRecyclerRecordsFragment, com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getMTotalDurationUnit().setText(getResources().getString(R.string.action_details) + HexStringBuilder.COMMENT_BEGIN_CHAR + getResources().getString(R.string.minute) + HexStringBuilder.COMMENT_END_CHAR);
        getMTotalSizeUnit().setText(String.valueOf(getResources().getString(R.string.number_of_times)));
        getMTotalCalorieUnit().setText(getResources().getString(R.string.quantity_of_heat) + HexStringBuilder.COMMENT_BEGIN_CHAR + getResources().getString(R.string.kcal) + HexStringBuilder.COMMENT_END_CHAR);
        if (getMArg1() > -1) {
            this.sportRecordList = SportRecordDataKt.getSportRecordListByMode(this.page, this.pageNumber, 116);
            getMTotalTitle().setText(getString(R.string.game_overview_item));
        } else {
            this.sportRecordList = SportRecordDataKt.getSportRecordList(this.page, this.pageNumber);
            getMTotalTitle().setText(getString(R.string.sports_overview));
        }
        ArrayList<SportRecordData> arrayList = this.sportRecordList;
        HashSet hashSet = new HashSet();
        ArrayList<SportRecordData> arrayList2 = new ArrayList<>();
        for (Object obj : arrayList) {
            if (hashSet.add(Long.valueOf(((SportRecordData) obj).getMStartTime()))) {
                arrayList2.add(obj);
            }
        }
        this.sportRecordList = arrayList2;
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_rv_records_v2;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<SportRecordData> data) {
        IIX0o.x0xO0oo(data, "data");
        getDslAdapter().clearAllItems();
        onInitBaseLayoutAfter();
        if (this.sportRecordList.size() == 0) {
            getMTotalLayout().setVisibility(8);
        }
    }

    @Override // com.sma.smartv3.ui.status.base.BaseStatusFragment, com.bestmafen.androidbase.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        XO0.II0xO0.oxoX().IIXOooo(this);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseRecyclerRecordsFragment
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        setAdapter();
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OXOo.OOXIXo
    public List<SportRecordData> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        this.sportRecordList.clear();
        this.competitionSelectionTime = true;
        long[] o002 = com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i);
        if (getMArg1() > -1) {
            this.sportRecordList = SportRecordDataKt.getSportRecordList(o002[0], o002[1], 116);
        } else {
            this.sportRecordList = SportRecordDataKt.getSportRecordList$default(o002[0], o002[1], 0, 4, null);
        }
        LogUtils.d("onTimePeriodChange " + o002[0] + "  " + this.sportRecordList.size());
        return this.sportRecordList;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseRecyclerRecordsFragment
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseRecyclerRecordsFragment
    public int refreshLayoutId() {
        return 0;
    }

    public final void setAdapter() {
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment$setAdapter$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter) {
                IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                DslAdapter.setAdapterStatus$default(renderAdapter, 2, null, 2, null);
                renderAdapter.getDslAdapterStatusItem().getItemStateLayoutMap().put(1, Integer.valueOf(R.layout.layout_sport_empty_v2));
                DslViewHolder dslViewHolder = SportRecordsV2Fragment.this.getDslViewHolder();
                final SportRecordsV2Fragment sportRecordsV2Fragment = SportRecordsV2Fragment.this;
                dslViewHolder.postDelay(1000L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment$setAdapter$1.1
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
                        final SportRecordsV2Fragment sportRecordsV2Fragment2 = SportRecordsV2Fragment.this;
                        sportRecordsV2Fragment2.renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment.setAdapter.1.1.1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                                invoke2(dslAdapter);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter2) {
                                IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                DslAdapter.setAdapterStatus$default(renderAdapter2, 0, null, 2, null);
                                if (SportRecordsV2Fragment.this.getSportRecordList().isEmpty()) {
                                    DslAdapter.setAdapterStatus$default(SportRecordsV2Fragment.this.getDslAdapter(), 1, null, 2, null);
                                    return;
                                }
                                SportRecordsV2Fragment sportRecordsV2Fragment3 = SportRecordsV2Fragment.this;
                                sportRecordsV2Fragment3.findData(renderAdapter2, sportRecordsV2Fragment3.getSportRecordList());
                                renderAdapter2.setLoadMoreEnable(false);
                            }
                        });
                    }
                });
            }
        });
        SwipeMenuHelper.Companion.oIX0oI((RecyclerView) getDslViewHolder().v(recyclerViewId()));
    }

    public final void setCompetitionSelectionTime(boolean z) {
        this.competitionSelectionTime = z;
    }

    public final void setSportRecordList(@OXOo.OOXIXo ArrayList<SportRecordData> arrayList) {
        IIX0o.x0xO0oo(arrayList, "<set-?>");
        this.sportRecordList = arrayList;
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24642ox)
    public final void syncDeleteSport(@OXOo.OOXIXo Object any) {
        IIX0o.x0xO0oo(any, "any");
        this.sportRecordList.clear();
        getDslAdapter().clearAllItems();
        initView();
    }
}
