package com.sma.smartv3.ui.status.fragment;

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
import com.angcyo.dsladapter.DslLoadMoreItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.SwipeMenuHelper;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment;
import com.blankj.utilcode.util.SPUtils;
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
import com.sma.smartv3.util.Xo0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nSportRecordsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportRecordsFragment.kt\ncom/sma/smartv3/ui/status/fragment/SportRecordsFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,165:1\n19#2:166\n15#2:167\n*S KotlinDebug\n*F\n+ 1 SportRecordsFragment.kt\ncom/sma/smartv3/ui/status/fragment/SportRecordsFragment\n*L\n24#1:166\n24#1:167\n*E\n"})
/* loaded from: classes12.dex */
public final class SportRecordsFragment extends BaseDSLRecyclerFragment {
    private int page;
    private final int pageNumber = 30;

    @OXOo.OOXIXo
    private final AppUser userProfile;

    public SportRecordsFragment() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void findData(final DslAdapter dslAdapter, ArrayList<SportRecordData> arrayList) {
        Iterator<SportRecordData> it = arrayList.iterator();
        while (it.hasNext()) {
            final SportRecordData next = it.next();
            Activity mActivity = getMActivity();
            AppUser appUser = this.userProfile;
            IIX0o.ooOOo0oXI(next);
            final SportRecordItemCommonData parseSportRecordItemCommonData = SportRecordDataKt.parseSportRecordItemCommonData(mActivity, appUser, next);
            DslAdapterExKt.oO(dslAdapter, R.layout.status_item_sport_record_detail, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsFragment$findData$1

                /* renamed from: com.sma.smartv3.ui.status.fragment.SportRecordsFragment$findData$1$1, reason: invalid class name */
                /* loaded from: classes12.dex */
                public static final class AnonymousClass1 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI> {
                    final /* synthetic */ SportRecordItemCommonData $itemData;
                    final /* synthetic */ SportRecordData $sportRecordData;
                    final /* synthetic */ DslAdapterItem $this_dslItem;
                    final /* synthetic */ DslAdapter $this_findData;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(SportRecordData sportRecordData, SportRecordItemCommonData sportRecordItemCommonData, DslAdapterItem dslAdapterItem, DslAdapter dslAdapter) {
                        super(4);
                        this.$sportRecordData = sportRecordData;
                        this.$itemData = sportRecordItemCommonData;
                        this.$this_dslItem = dslAdapterItem;
                        this.$this_findData = dslAdapter;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void invoke$lambda$0(SportRecordData sportRecordData, DslAdapterItem this_dslItem, DslViewHolder itemHolder, DslAdapter this_findData, View view) {
                        List<DslAdapterItem> dataItems;
                        IIX0o.x0xO0oo(sportRecordData, "$sportRecordData");
                        IIX0o.x0xO0oo(this_dslItem, "$this_dslItem");
                        IIX0o.x0xO0oo(itemHolder, "$itemHolder");
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
                        DslAdapter itemDslAdapter2 = this_dslItem.getItemDslAdapter();
                        if (itemDslAdapter2 != null && (dataItems = itemDslAdapter2.getDataItems()) != null && dataItems.size() == 0) {
                            DslAdapter.setAdapterStatus$default(this_findData, 1, null, 2, null);
                        }
                        DslAdapter itemDslAdapter3 = this_dslItem.getItemDslAdapter();
                        if (itemDslAdapter3 != null) {
                            DslAdapter.updateItemDepend$default(itemDslAdapter3, null, 1, null);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final boolean invoke$lambda$2$lambda$1(DslViewHolder itemHolder, View view, MotionEvent motionEvent) {
                        IIX0o.x0xO0oo(itemHolder, "$itemHolder");
                        return itemHolder.itemView.onTouchEvent(motionEvent);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final boolean invoke$lambda$4$lambda$3(DslViewHolder itemHolder, View view, MotionEvent motionEvent) {
                        IIX0o.x0xO0oo(itemHolder, "$itemHolder");
                        return itemHolder.itemView.onTouchEvent(motionEvent);
                    }

                    @Override // Oox.Oxx0xo
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                        invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    public final void invoke(@OXOo.OOXIXo final DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                        IIX0o.x0xO0oo(itemHolder, "itemHolder");
                        IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                        IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                        ImageView img = itemHolder.img(R.id.sportSourceIv);
                        if (img != null) {
                            img.setImageResource(this.$sportRecordData.getMSource() == 2 ? R.drawable.icon_phone : R.drawable.icon_watch);
                        }
                        ImageView img2 = itemHolder.img(R.id.sportTypeIv);
                        if (img2 != null) {
                            img2.setImageResource(this.$itemData.getWorkoutImg());
                        }
                        ImageView img3 = itemHolder.img(R.id.gpsStatusIv);
                        if (img3 != null) {
                            img3.setImageResource(this.$itemData.getGpsState());
                        }
                        TextView tv = itemHolder.tv(R.id.sportName);
                        if (tv != null) {
                            tv.setText(this.$itemData.getWorkoutModeName());
                        }
                        TextView tv2 = itemHolder.tv(R.id.sportStartTime);
                        if (tv2 != null) {
                            tv2.setText(this.$itemData.getSportStartTime());
                        }
                        final SportRecordData sportRecordData = this.$sportRecordData;
                        final DslAdapterItem dslAdapterItem2 = this.$this_dslItem;
                        final DslAdapter dslAdapter = this.$this_findData;
                        itemHolder.click(R.id.bt_delete_sport_record, 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0082: INVOKE 
                              (r3v0 'itemHolder' com.angcyo.dsladapter.DslViewHolder)
                              (wrap:int:SGET  A[WRAPPED] com.sma.smartv3.co_fit.R.id.bt_delete_sport_record int)
                              (wrap:android.view.View$OnClickListener:0x007c: CONSTRUCTOR 
                              (r4v14 'sportRecordData' com.sma.smartv3.model.SportRecordData A[DONT_INLINE])
                              (r5v1 'dslAdapterItem2' com.angcyo.dsladapter.DslAdapterItem A[DONT_INLINE])
                              (r3v0 'itemHolder' com.angcyo.dsladapter.DslViewHolder A[DONT_INLINE])
                              (r6v1 'dslAdapter' com.angcyo.dsladapter.DslAdapter A[DONT_INLINE])
                             A[MD:(com.sma.smartv3.model.SportRecordData, com.angcyo.dsladapter.DslAdapterItem, com.angcyo.dsladapter.DslViewHolder, com.angcyo.dsladapter.DslAdapter):void (m), WRAPPED] call: com.sma.smartv3.ui.status.fragment.Oxx0IOOO.<init>(com.sma.smartv3.model.SportRecordData, com.angcyo.dsladapter.DslAdapterItem, com.angcyo.dsladapter.DslViewHolder, com.angcyo.dsladapter.DslAdapter):void type: CONSTRUCTOR)
                             VIRTUAL call: com.angcyo.dsladapter.DslViewHolder.click(int, android.view.View$OnClickListener):void A[MD:(int, android.view.View$OnClickListener):void (m)] in method: com.sma.smartv3.ui.status.fragment.SportRecordsFragment$findData$1.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.status.fragment.Oxx0IOOO, state: NOT_LOADED
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
                            java.lang.String r4 = "<anonymous parameter 2>"
                            kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r4)
                            java.lang.String r4 = "<anonymous parameter 3>"
                            kotlin.jvm.internal.IIX0o.x0xO0oo(r6, r4)
                            r4 = 2131367602(0x7f0a16b2, float:1.835513E38)
                            android.widget.ImageView r4 = r3.img(r4)
                            if (r4 == 0) goto L2b
                            com.sma.smartv3.model.SportRecordData r5 = r2.$sportRecordData
                            int r5 = r5.getMSource()
                            r6 = 2
                            if (r5 != r6) goto L25
                            r5 = 2131234270(0x7f080dde, float:1.80847E38)
                            goto L28
                        L25:
                            r5 = 2131234443(0x7f080e8b, float:1.8085052E38)
                        L28:
                            r4.setImageResource(r5)
                        L2b:
                            r4 = 2131367610(0x7f0a16ba, float:1.8355147E38)
                            android.widget.ImageView r4 = r3.img(r4)
                            if (r4 == 0) goto L3d
                            com.sma.smartv3.model.SportRecordItemCommonData r5 = r2.$itemData
                            int r5 = r5.getWorkoutImg()
                            r4.setImageResource(r5)
                        L3d:
                            r4 = 2131364461(0x7f0a0a6d, float:1.834876E38)
                            android.widget.ImageView r4 = r3.img(r4)
                            if (r4 == 0) goto L4f
                            com.sma.smartv3.model.SportRecordItemCommonData r5 = r2.$itemData
                            int r5 = r5.getGpsState()
                            r4.setImageResource(r5)
                        L4f:
                            r4 = 2131367536(0x7f0a1670, float:1.8354997E38)
                            android.widget.TextView r4 = r3.tv(r4)
                            if (r4 == 0) goto L61
                            com.sma.smartv3.model.SportRecordItemCommonData r5 = r2.$itemData
                            int r5 = r5.getWorkoutModeName()
                            r4.setText(r5)
                        L61:
                            r4 = 2131367604(0x7f0a16b4, float:1.8355134E38)
                            android.widget.TextView r4 = r3.tv(r4)
                            if (r4 != 0) goto L6b
                            goto L74
                        L6b:
                            com.sma.smartv3.model.SportRecordItemCommonData r5 = r2.$itemData
                            java.lang.String r5 = r5.getSportStartTime()
                            r4.setText(r5)
                        L74:
                            com.sma.smartv3.model.SportRecordData r4 = r2.$sportRecordData
                            com.angcyo.dsladapter.DslAdapterItem r5 = r2.$this_dslItem
                            com.angcyo.dsladapter.DslAdapter r6 = r2.$this_findData
                            com.sma.smartv3.ui.status.fragment.Oxx0IOOO r0 = new com.sma.smartv3.ui.status.fragment.Oxx0IOOO
                            r0.<init>(r4, r5, r3, r6)
                            r4 = 2131363392(0x7f0a0640, float:1.8346592E38)
                            r3.click(r4, r0)
                            r4 = 2131367179(0x7f0a150b, float:1.8354272E38)
                            androidx.recyclerview.widget.RecyclerView r4 = r3.rv(r4)
                            if (r4 == 0) goto Lbd
                            com.sma.smartv3.model.SportRecordItemCommonData r5 = r2.$itemData
                            androidx.recyclerview.widget.GridLayoutManager r6 = new androidx.recyclerview.widget.GridLayoutManager
                            android.content.Context r0 = r4.getContext()
                            int r1 = r5.getSpanCount()
                            r6.<init>(r0, r1)
                            r4.setLayoutManager(r6)
                            com.sma.smartv3.model.SportRecordItemAdapter r6 = new com.sma.smartv3.model.SportRecordItemAdapter
                            java.util.List r5 = r5.getContentList()
                            android.content.Context r0 = r4.getContext()
                            java.lang.String r1 = "getContext(...)"
                            kotlin.jvm.internal.IIX0o.oO(r0, r1)
                            r6.<init>(r5, r0)
                            r4.setAdapter(r6)
                            com.sma.smartv3.ui.status.fragment.II0XooXoX r5 = new com.sma.smartv3.ui.status.fragment.II0XooXoX
                            r5.<init>(r3)
                            r4.setOnTouchListener(r5)
                        Lbd:
                            r4 = 2131365907(0x7f0a1013, float:1.8351693E38)
                            android.view.View r4 = r3.view(r4)
                            if (r4 == 0) goto Lce
                            com.sma.smartv3.ui.status.fragment.xxIXOIIO r5 = new com.sma.smartv3.ui.status.fragment.xxIXOIIO
                            r5.<init>(r3)
                            r4.setOnTouchListener(r5)
                        Lce:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.status.fragment.SportRecordsFragment$findData$1.AnonymousClass1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
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
                    dslItem.setItemBindOverride(new AnonymousClass1(SportRecordData.this, parseSportRecordItemCommonData, dslItem, dslAdapter));
                    final SportRecordData sportRecordData = SportRecordData.this;
                    final SportRecordsFragment sportRecordsFragment = this;
                    dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsFragment$findData$1.2
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
                            int mSource = SportRecordData.this.getMSource();
                            if (mSource == 1) {
                                ProjectManager projectManager = ProjectManager.f19822oIX0oI;
                                if (projectManager.OO0()) {
                                    SportRecordsFragment sportRecordsFragment2 = sportRecordsFragment;
                                    int mWorkoutId = SportRecordData.this.getMWorkoutId();
                                    Bundle bundle = new Bundle();
                                    bundle.putString("mArg0", null);
                                    bundle.putInt("mArg1", mWorkoutId);
                                    bundle.putParcelable("mArg2", null);
                                    bundle.putSerializable("mArg3", null);
                                    Intent intent = new Intent(sportRecordsFragment2.getActivity(), (Class<?>) SportDetailV2Activity.class);
                                    intent.putExtras(bundle);
                                    sportRecordsFragment2.startActivity(intent);
                                } else if (projectManager.XoIxOXIXo()) {
                                    SportRecordsFragment sportRecordsFragment3 = sportRecordsFragment;
                                    int mWorkoutId2 = SportRecordData.this.getMWorkoutId();
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString("mArg0", null);
                                    bundle2.putInt("mArg1", mWorkoutId2);
                                    bundle2.putParcelable("mArg2", null);
                                    bundle2.putSerializable("mArg3", null);
                                    Intent intent2 = new Intent(sportRecordsFragment3.getActivity(), (Class<?>) SportDetailActivity.class);
                                    intent2.putExtras(bundle2);
                                    sportRecordsFragment3.startActivity(intent2);
                                } else {
                                    SportRecordsFragment sportRecordsFragment4 = sportRecordsFragment;
                                    SportRecordData sportRecordData2 = SportRecordData.this;
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putString("mArg0", null);
                                    bundle3.putParcelable("mArg2", sportRecordData2);
                                    bundle3.putSerializable("mArg3", null);
                                    Intent intent3 = new Intent(sportRecordsFragment4.getActivity(), (Class<?>) SportRecordsDetailActivity.class);
                                    intent3.putExtras(bundle3);
                                    sportRecordsFragment4.startActivity(intent3);
                                }
                            } else if (mSource != 2) {
                                SportRecordsFragment sportRecordsFragment5 = sportRecordsFragment;
                                SportRecordData sportRecordData3 = SportRecordData.this;
                                Bundle bundle4 = new Bundle();
                                bundle4.putString("mArg0", null);
                                bundle4.putParcelable("mArg2", sportRecordData3);
                                bundle4.putSerializable("mArg3", null);
                                Intent intent4 = new Intent(sportRecordsFragment5.getActivity(), (Class<?>) SportRecordsDetailActivity.class);
                                intent4.putExtras(bundle4);
                                sportRecordsFragment5.startActivity(intent4);
                            } else if (ProjectManager.f19822oIX0oI.OO0()) {
                                SportRecordsFragment sportRecordsFragment6 = sportRecordsFragment;
                                int mWorkoutId3 = SportRecordData.this.getMWorkoutId();
                                Bundle bundle5 = new Bundle();
                                bundle5.putString("mArg0", null);
                                bundle5.putInt("mArg1", mWorkoutId3);
                                bundle5.putParcelable("mArg2", null);
                                bundle5.putSerializable("mArg3", null);
                                Intent intent5 = new Intent(sportRecordsFragment6.getActivity(), (Class<?>) SportDetailV2Activity.class);
                                intent5.putExtras(bundle5);
                                sportRecordsFragment6.startActivity(intent5);
                            } else {
                                SportRecordsFragment sportRecordsFragment7 = sportRecordsFragment;
                                int mWorkoutId4 = SportRecordData.this.getMWorkoutId();
                                Bundle bundle6 = new Bundle();
                                bundle6.putString("mArg0", null);
                                bundle6.putInt("mArg1", mWorkoutId4);
                                bundle6.putParcelable("mArg2", null);
                                bundle6.putSerializable("mArg3", null);
                                Intent intent6 = new Intent(sportRecordsFragment7.getActivity(), (Class<?>) SportDetailActivity.class);
                                intent6.putExtras(bundle6);
                                sportRecordsFragment7.startActivity(intent6);
                            }
                            SwipeMenuHelper swipeMenuHelper = dslItem.get_itemSwipeMenuHelper();
                            if (swipeMenuHelper != null) {
                                SwipeMenuHelper.closeSwipeMenu$default(swipeMenuHelper, null, 1, null);
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    @OXOo.OOXIXo
    public DslAdapterStatusItem adapterStatusItem() {
        setAdapterStatus(new AdapterStatusItem());
        return getAdapterStatus();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsFragment$onInitBaseLayoutAfter$1
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
                renderAdapter.getDslAdapterStatusItem().getItemStateLayoutMap().put(1, Integer.valueOf(R.layout.layout_sport_empty));
                DslViewHolder dslViewHolder = SportRecordsFragment.this.getDslViewHolder();
                final SportRecordsFragment sportRecordsFragment = SportRecordsFragment.this;
                dslViewHolder.postDelay(1000L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsFragment$onInitBaseLayoutAfter$1.1
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
                        final SportRecordsFragment sportRecordsFragment2 = SportRecordsFragment.this;
                        sportRecordsFragment2.renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsFragment.onInitBaseLayoutAfter.1.1.1
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
                                int i;
                                int i2;
                                IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                DslAdapter.setAdapterStatus$default(renderAdapter2, 0, null, 2, null);
                                i = SportRecordsFragment.this.page;
                                i2 = SportRecordsFragment.this.pageNumber;
                                ArrayList<SportRecordData> sportRecordList = SportRecordDataKt.getSportRecordList(i, i2);
                                if (!sportRecordList.isEmpty()) {
                                    SportRecordsFragment.this.findData(renderAdapter2, sportRecordList);
                                    renderAdapter2.setLoadMoreEnable(true);
                                } else {
                                    DslAdapter.setAdapterStatus$default(SportRecordsFragment.this.getDslAdapter(), 1, null, 2, null);
                                }
                            }
                        });
                    }
                });
                DslLoadMoreItem dslLoadMoreItem = renderAdapter.getDslLoadMoreItem();
                final SportRecordsFragment sportRecordsFragment2 = SportRecordsFragment.this;
                dslLoadMoreItem.setOnLoadMore(new Oox.oOoXoXO<DslViewHolder, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsFragment$onInitBaseLayoutAfter$1.2
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2) {
                        invoke2(dslViewHolder2);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo DslViewHolder it) {
                        IIX0o.x0xO0oo(it, "it");
                        final SportRecordsFragment sportRecordsFragment3 = SportRecordsFragment.this;
                        it.postDelay(1000L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsFragment.onInitBaseLayoutAfter.1.2.1
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
                                final SportRecordsFragment sportRecordsFragment4 = SportRecordsFragment.this;
                                sportRecordsFragment4.renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.SportRecordsFragment.onInitBaseLayoutAfter.1.2.1.1
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
                                        int i;
                                        int i2;
                                        int i3;
                                        int i4;
                                        IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                        SportRecordsFragment sportRecordsFragment5 = SportRecordsFragment.this;
                                        i = sportRecordsFragment5.page;
                                        sportRecordsFragment5.page = i + 1;
                                        i2 = SportRecordsFragment.this.page;
                                        i3 = SportRecordsFragment.this.pageNumber;
                                        int i5 = (i2 * i3) - 1;
                                        i4 = SportRecordsFragment.this.pageNumber;
                                        ArrayList<SportRecordData> sportRecordList = SportRecordDataKt.getSportRecordList(i5, i4);
                                        if (!sportRecordList.isEmpty()) {
                                            SportRecordsFragment.this.findData(renderAdapter2, sportRecordList);
                                            DslAdapter.setLoadMore$default(renderAdapter2, 0, null, false, 6, null);
                                        } else {
                                            DslAdapter.setLoadMore$default(renderAdapter2, 2, null, false, 6, null);
                                        }
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
        SwipeMenuHelper.Companion.oIX0oI((RecyclerView) getDslViewHolder().v(recyclerViewId()));
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int refreshLayoutId() {
        return 0;
    }
}
