package com.sma.smartv3.ui.status.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslAdapterStatusItem;
import com.angcyo.dsladapter.DslLoadMoreItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.SwipeMenuHelper;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.WeightDao;
import com.sma.smartv3.db.entity.Weight;
import com.sma.smartv3.dsl.AdapterStatusItem;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.WeightMeasureDataKt;
import com.sma.smartv3.ui.status.WeightMeasureReportActivity;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.Xo0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nWeightHistoryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WeightHistoryFragment.kt\ncom/sma/smartv3/ui/status/fragment/WeightHistoryFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,203:1\n19#2:204\n15#2:205\n1477#3:206\n1502#3,3:207\n1505#3,3:217\n372#4,7:210\n*S KotlinDebug\n*F\n+ 1 WeightHistoryFragment.kt\ncom/sma/smartv3/ui/status/fragment/WeightHistoryFragment\n*L\n27#1:204\n27#1:205\n107#1:206\n107#1:207,3\n107#1:217,3\n107#1:210,7\n*E\n"})
/* loaded from: classes12.dex */
public final class WeightHistoryFragment extends BaseDSLRecyclerFragment {

    @OXOo.OOXIXo
    private final AppUser mAppUser;

    @OXOo.OOXIXo
    private WeightDao mWeightDao;

    @OXOo.OOXIXo
    private final X0IIOO scrollView$delegate;
    private int pageSize = 30;
    private int pageNum = 1;

    public WeightHistoryFragment() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
        this.scrollView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NestedScrollView>() { // from class: com.sma.smartv3.ui.status.fragment.WeightHistoryFragment$scrollView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final NestedScrollView invoke() {
                View mView;
                mView = WeightHistoryFragment.this.getMView();
                return (NestedScrollView) mView.findViewById(R.id.scrollView);
            }
        });
        this.mWeightDao = MyDb.INSTANCE.getMDatabase().weightDao();
    }

    @SuppressLint({"SetTextI18n"})
    private final void doItem(List<Weight> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            String format = com.sma.smartv3.util.xoIox.xoIxX().format(Long.valueOf(((Weight) obj).getMTime()));
            Object obj2 = linkedHashMap.get(format);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(format, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (final Map.Entry entry : linkedHashMap.entrySet()) {
            if (this.pageNum == 1 || DslAdapterExKt.Io(getDslAdapter(), (String) entry.getKey(), false, 2, null) == null) {
                DslAdapterExKt.oO(getDslAdapter(), R.layout.weight_measure_history_group_item, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.WeightHistoryFragment$doItem$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                        invoke2(dslAdapterItem);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                        IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                        dslItem.setItemSwipeMenuEnable(false);
                        dslItem.setItemIsGroupHead(false);
                        dslItem.setItemIsHover(false);
                        dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(entry.getKey()));
                        final Map.Entry<String, List<Weight>> entry2 = entry;
                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.WeightHistoryFragment$doItem$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // Oox.Oxx0xo
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list2) {
                                invoke(dslViewHolder, num.intValue(), dslAdapterItem, list2);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list2) {
                                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                IIX0o.x0xO0oo(list2, "<anonymous parameter 3>");
                                TextView tv = itemHolder.tv(R.id.tv_date);
                                if (tv != null) {
                                    tv.setText(entry2.getKey());
                                }
                            }
                        });
                        dslItem.setItemTag(entry.getKey());
                    }
                });
            }
            for (final Weight weight : (List) entry.getValue()) {
                DslAdapterExKt.oO(getDslAdapter(), R.layout.weight_measure_history_item, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.WeightHistoryFragment$doItem$3

                    /* renamed from: com.sma.smartv3.ui.status.fragment.WeightHistoryFragment$doItem$3$1, reason: invalid class name */
                    /* loaded from: classes12.dex */
                    public static final class AnonymousClass1 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI> {
                        final /* synthetic */ DslAdapterItem $this_dslItem;
                        final /* synthetic */ Weight $weight;
                        final /* synthetic */ WeightHistoryFragment this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(Weight weight, WeightHistoryFragment weightHistoryFragment, DslAdapterItem dslAdapterItem) {
                            super(4);
                            this.$weight = weight;
                            this.this$0 = weightHistoryFragment;
                            this.$this_dslItem = dslAdapterItem;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final void invoke$lambda$0(Weight weight, WeightHistoryFragment this$0, DslAdapterItem this_dslItem, DslViewHolder itemHolder, View view) {
                            WeightDao weightDao;
                            IIX0o.x0xO0oo(weight, "$weight");
                            IIX0o.x0xO0oo(this$0, "this$0");
                            IIX0o.x0xO0oo(this_dslItem, "$this_dslItem");
                            IIX0o.x0xO0oo(itemHolder, "$itemHolder");
                            weight.setMIsSync(0);
                            weight.setMIsDelete(1);
                            weightDao = this$0.mWeightDao;
                            weightDao.update(CollectionsKt__CollectionsKt.XOxIOxOx(weight));
                            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24612XO, null, 2, null);
                            SwipeMenuHelper swipeMenuHelper = this_dslItem.get_itemSwipeMenuHelper();
                            if (swipeMenuHelper != null) {
                                swipeMenuHelper.closeSwipeMenu(itemHolder);
                            }
                            DslAdapter itemDslAdapter = this_dslItem.getItemDslAdapter();
                            if (itemDslAdapter != null) {
                                DslAdapter.removeItem$default(itemDslAdapter, this_dslItem, false, 2, null);
                            }
                            DslAdapter itemDslAdapter2 = this_dslItem.getItemDslAdapter();
                            if (itemDslAdapter2 != null) {
                                DslAdapter.updateItemDepend$default(itemDslAdapter2, null, 1, null);
                            }
                            this$0.removeGroup(this_dslItem.getItemGroups());
                        }

                        @Override // Oox.Oxx0xo
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                            invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(@OXOo.OOXIXo final DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                            String keepOneDecimal;
                            AppUser appUser;
                            AppUser appUser2;
                            AppUser appUser3;
                            IIX0o.x0xO0oo(itemHolder, "itemHolder");
                            IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                            IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                            TextView tv = itemHolder.tv(R.id.tv_weightValue);
                            if (tv != null) {
                                StringBuilder sb = new StringBuilder();
                                float mWeight = this.$weight.getMWeight();
                                appUser2 = this.this$0.mAppUser;
                                sb.append(TextConvertKt.xoIox(TextConvertKt.XxX0x0xxx(mWeight, appUser2.getUnit())));
                                WeightHistoryFragment weightHistoryFragment = this.this$0;
                                appUser3 = weightHistoryFragment.mAppUser;
                                sb.append(weightHistoryFragment.getString(TextConvertKt.xxX(appUser3.getUnit())));
                                tv.setText(sb.toString());
                            }
                            TextView tv2 = itemHolder.tv(R.id.tv_bmiValue);
                            if (tv2 != null) {
                                if (this.$weight.getMBmi() == XIXIX.OOXIXo.f3760XO) {
                                    float mWeight2 = this.$weight.getMWeight();
                                    appUser = this.this$0.mAppUser;
                                    keepOneDecimal = TextConvertKt.Oxx0IOOO(mWeight2, appUser.getHeight());
                                } else {
                                    keepOneDecimal = WeightMeasureDataKt.keepOneDecimal(this.$weight.getMBmi());
                                }
                                tv2.setText(keepOneDecimal);
                            }
                            if (this.$weight.getMIsMeasure() == 1) {
                                ImageView img = itemHolder.img(R.id.iv_measure_type);
                                if (img != null) {
                                    img.setImageResource(R.drawable.icon_measure_scale);
                                }
                                ImageView img2 = itemHolder.img(R.id.iv_measure_item_right);
                                if (img2 != null) {
                                    img2.setVisibility(0);
                                }
                                TextView tv3 = itemHolder.tv(R.id.tv_bfrValue);
                                if (tv3 != null) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(this.$weight.getMRatioOfFat());
                                    sb2.append(org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
                                    tv3.setText(sb2.toString());
                                }
                            } else {
                                ImageView img3 = itemHolder.img(R.id.iv_measure_type);
                                if (img3 != null) {
                                    img3.setImageResource(R.drawable.icon_measure_input);
                                }
                                ImageView img4 = itemHolder.img(R.id.iv_measure_item_right);
                                if (img4 != null) {
                                    img4.setVisibility(4);
                                }
                                TextView tv4 = itemHolder.tv(R.id.tv_bfrValue);
                                if (tv4 != null) {
                                    tv4.setText(R.string.data_none);
                                }
                            }
                            final Weight weight = this.$weight;
                            final WeightHistoryFragment weightHistoryFragment2 = this.this$0;
                            final DslAdapterItem dslAdapterItem2 = this.$this_dslItem;
                            itemHolder.click(R.id.bt_delete_weight_record, 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0108: INVOKE 
                                  (r4v0 'itemHolder' com.angcyo.dsladapter.DslViewHolder)
                                  (wrap:int:SGET  A[WRAPPED] com.sma.smartv3.co_fit.R.id.bt_delete_weight_record int)
                                  (wrap:android.view.View$OnClickListener:0x0102: CONSTRUCTOR 
                                  (r5v13 'weight' com.sma.smartv3.db.entity.Weight A[DONT_INLINE])
                                  (r6v5 'weightHistoryFragment2' com.sma.smartv3.ui.status.fragment.WeightHistoryFragment A[DONT_INLINE])
                                  (r7v2 'dslAdapterItem2' com.angcyo.dsladapter.DslAdapterItem A[DONT_INLINE])
                                  (r4v0 'itemHolder' com.angcyo.dsladapter.DslViewHolder A[DONT_INLINE])
                                 A[MD:(com.sma.smartv3.db.entity.Weight, com.sma.smartv3.ui.status.fragment.WeightHistoryFragment, com.angcyo.dsladapter.DslAdapterItem, com.angcyo.dsladapter.DslViewHolder):void (m), WRAPPED] call: com.sma.smartv3.ui.status.fragment.oOoXoXO.<init>(com.sma.smartv3.db.entity.Weight, com.sma.smartv3.ui.status.fragment.WeightHistoryFragment, com.angcyo.dsladapter.DslAdapterItem, com.angcyo.dsladapter.DslViewHolder):void type: CONSTRUCTOR)
                                 VIRTUAL call: com.angcyo.dsladapter.DslViewHolder.click(int, android.view.View$OnClickListener):void A[MD:(int, android.view.View$OnClickListener):void (m)] in method: com.sma.smartv3.ui.status.fragment.WeightHistoryFragment$doItem$3.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
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
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.status.fragment.oOoXoXO, state: NOT_LOADED
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
                                java.lang.String r5 = "itemHolder"
                                kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r5)
                                java.lang.String r5 = "<anonymous parameter 2>"
                                kotlin.jvm.internal.IIX0o.x0xO0oo(r6, r5)
                                java.lang.String r5 = "<anonymous parameter 3>"
                                kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r5)
                                r5 = 2131371645(0x7f0a267d, float:1.836333E38)
                                android.widget.TextView r5 = r4.tv(r5)
                                if (r5 != 0) goto L19
                                goto L55
                            L19:
                                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                                r6.<init>()
                                com.sma.smartv3.db.entity.Weight r7 = r3.$weight
                                float r7 = r7.getMWeight()
                                com.sma.smartv3.ui.status.fragment.WeightHistoryFragment r0 = r3.this$0
                                com.sma.smartv3.model.AppUser r0 = com.sma.smartv3.ui.status.fragment.WeightHistoryFragment.access$getMAppUser$p(r0)
                                int r0 = r0.getUnit()
                                float r7 = com.sma.smartv3.util.TextConvertKt.XxX0x0xxx(r7, r0)
                                float r7 = com.sma.smartv3.util.TextConvertKt.xoIox(r7)
                                r6.append(r7)
                                com.sma.smartv3.ui.status.fragment.WeightHistoryFragment r7 = r3.this$0
                                com.sma.smartv3.model.AppUser r0 = com.sma.smartv3.ui.status.fragment.WeightHistoryFragment.access$getMAppUser$p(r7)
                                int r0 = r0.getUnit()
                                int r0 = com.sma.smartv3.util.TextConvertKt.xxX(r0)
                                java.lang.String r7 = r7.getString(r0)
                                r6.append(r7)
                                java.lang.String r6 = r6.toString()
                                r5.setText(r6)
                            L55:
                                r5 = 2131368216(0x7f0a1918, float:1.8356376E38)
                                android.widget.TextView r5 = r4.tv(r5)
                                if (r5 != 0) goto L5f
                                goto L8d
                            L5f:
                                com.sma.smartv3.db.entity.Weight r6 = r3.$weight
                                double r6 = r6.getMBmi()
                                r0 = 0
                                int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                                if (r2 != 0) goto L80
                                com.sma.smartv3.db.entity.Weight r6 = r3.$weight
                                float r6 = r6.getMWeight()
                                com.sma.smartv3.ui.status.fragment.WeightHistoryFragment r7 = r3.this$0
                                com.sma.smartv3.model.AppUser r7 = com.sma.smartv3.ui.status.fragment.WeightHistoryFragment.access$getMAppUser$p(r7)
                                float r7 = r7.getHeight()
                                java.lang.String r6 = com.sma.smartv3.util.TextConvertKt.Oxx0IOOO(r6, r7)
                                goto L8a
                            L80:
                                com.sma.smartv3.db.entity.Weight r6 = r3.$weight
                                double r6 = r6.getMBmi()
                                java.lang.String r6 = com.sma.smartv3.model.WeightMeasureDataKt.keepOneDecimal(r6)
                            L8a:
                                r5.setText(r6)
                            L8d:
                                com.sma.smartv3.db.entity.Weight r5 = r3.$weight
                                int r5 = r5.getMIsMeasure()
                                r6 = 1
                                r7 = 2131368211(0x7f0a1913, float:1.8356366E38)
                                r0 = 2131365033(0x7f0a0ca9, float:1.834992E38)
                                r1 = 2131365034(0x7f0a0caa, float:1.8349922E38)
                                if (r5 != r6) goto Ld7
                                android.widget.ImageView r5 = r4.img(r1)
                                if (r5 == 0) goto Lab
                                r6 = 2131234243(0x7f080dc3, float:1.8084646E38)
                                r5.setImageResource(r6)
                            Lab:
                                android.widget.ImageView r5 = r4.img(r0)
                                if (r5 != 0) goto Lb2
                                goto Lb6
                            Lb2:
                                r6 = 0
                                r5.setVisibility(r6)
                            Lb6:
                                android.widget.TextView r5 = r4.tv(r7)
                                if (r5 == 0) goto Lfa
                                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                                r6.<init>()
                                com.sma.smartv3.db.entity.Weight r7 = r3.$weight
                                double r0 = r7.getMRatioOfFat()
                                r6.append(r0)
                                r7 = 37
                                r6.append(r7)
                                java.lang.String r6 = r6.toString()
                                r5.setText(r6)
                                goto Lfa
                            Ld7:
                                android.widget.ImageView r5 = r4.img(r1)
                                if (r5 == 0) goto Le3
                                r6 = 2131234242(0x7f080dc2, float:1.8084644E38)
                                r5.setImageResource(r6)
                            Le3:
                                android.widget.ImageView r5 = r4.img(r0)
                                if (r5 != 0) goto Lea
                                goto Lee
                            Lea:
                                r6 = 4
                                r5.setVisibility(r6)
                            Lee:
                                android.widget.TextView r5 = r4.tv(r7)
                                if (r5 == 0) goto Lfa
                                r6 = 2132018174(0x7f1403fe, float:1.9674647E38)
                                r5.setText(r6)
                            Lfa:
                                com.sma.smartv3.db.entity.Weight r5 = r3.$weight
                                com.sma.smartv3.ui.status.fragment.WeightHistoryFragment r6 = r3.this$0
                                com.angcyo.dsladapter.DslAdapterItem r7 = r3.$this_dslItem
                                com.sma.smartv3.ui.status.fragment.oOoXoXO r0 = new com.sma.smartv3.ui.status.fragment.oOoXoXO
                                r0.<init>(r5, r6, r7, r4)
                                r5 = 2131363393(0x7f0a0641, float:1.8346594E38)
                                r4.click(r5, r0)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.status.fragment.WeightHistoryFragment$doItem$3.AnonymousClass1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                        invoke2(dslAdapterItem);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                        IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                        dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(entry.getKey()));
                        dslItem.setItemSwipeMenuFlag(4);
                        dslItem.setItemBindOverride(new AnonymousClass1(weight, this, dslItem));
                        final Weight weight2 = weight;
                        final WeightHistoryFragment weightHistoryFragment = this;
                        dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.WeightHistoryFragment$doItem$3.2
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
                            public final void invoke2(@OXOo.OOXIXo View it) {
                                IIX0o.x0xO0oo(it, "it");
                                if (Weight.this.getMIsMeasure() == 1) {
                                    WeightHistoryFragment weightHistoryFragment2 = weightHistoryFragment;
                                    Weight weight3 = Weight.this;
                                    Bundle bundle = new Bundle();
                                    bundle.putString("mArg0", null);
                                    bundle.putInt("mArg1", 1);
                                    bundle.putParcelable("mArg2", null);
                                    bundle.putSerializable("mArg3", weight3);
                                    Intent intent = new Intent(weightHistoryFragment2.getActivity(), (Class<?>) WeightMeasureReportActivity.class);
                                    intent.putExtras(bundle);
                                    weightHistoryFragment2.startActivity(intent);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeGroup(List<String> list) {
        if (DslAdapterExKt.IO(getDslAdapter(), list, false, 2, null).size() == 1) {
            getDslAdapter().removeItem(DslAdapterExKt.IO(getDslAdapter(), list, false, 2, null));
            DslAdapter.updateItemDepend$default(getDslAdapter(), null, 1, null);
        }
        if (getDslAdapter().getDataItems().isEmpty()) {
            DslAdapter.setAdapterStatus$default(getDslAdapter(), 1, null, 2, null);
            DslAdapter.updateItemDepend$default(getDslAdapter(), null, 1, null);
        }
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    @OXOo.OOXIXo
    public DslAdapterStatusItem adapterStatusItem() {
        setAdapterStatus(new AdapterStatusItem());
        return getAdapterStatus();
    }

    public final NestedScrollView getScrollView() {
        return (NestedScrollView) this.scrollView$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_weight_history;
    }

    public final void loadData(int i) {
        WeightDao weightDao = this.mWeightDao;
        int i2 = this.pageSize;
        List<Weight> weightsDESC = weightDao.getWeightsDESC((i - 1) * i2, i2);
        getRefreshLayout().setRefreshing(false);
        if (weightsDESC.isEmpty()) {
            if (i == 1) {
                DslAdapter.setAdapterStatus$default(getDslAdapter(), 1, null, 2, null);
                return;
            } else {
                DslAdapter.setLoadMore$default(getDslAdapter(), 2, null, false, 6, null);
                return;
            }
        }
        DslAdapter.setAdapterStatus$default(getDslAdapter(), 0, null, 2, null);
        doItem(weightsDESC);
        DslAdapter.setLoadMore$default(getDslAdapter(), 0, null, false, 6, null);
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.WeightHistoryFragment$onInitBaseLayoutAfter$1
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
                renderAdapter.getDslAdapterStatusItem().getItemStateLayoutMap().put(1, Integer.valueOf(R.layout.layout_weight_history_empty));
                DslAdapter.setAdapterStatus$default(renderAdapter, 2, null, 2, null);
                DslViewHolder dslViewHolder = WeightHistoryFragment.this.getDslViewHolder();
                final WeightHistoryFragment weightHistoryFragment = WeightHistoryFragment.this;
                dslViewHolder.postDelay(1000L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.WeightHistoryFragment$onInitBaseLayoutAfter$1.1
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
                        final WeightHistoryFragment weightHistoryFragment2 = WeightHistoryFragment.this;
                        weightHistoryFragment2.renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.WeightHistoryFragment.onInitBaseLayoutAfter.1.1.1
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
                                IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                DslAdapter.setAdapterStatus$default(renderAdapter2, 0, null, 2, null);
                                renderAdapter2.setLoadMoreEnable(true);
                                WeightHistoryFragment.this.pageNum = 1;
                                WeightHistoryFragment weightHistoryFragment3 = WeightHistoryFragment.this;
                                i = weightHistoryFragment3.pageNum;
                                weightHistoryFragment3.loadData(i);
                            }
                        });
                    }
                });
                DslLoadMoreItem dslLoadMoreItem = renderAdapter.getDslLoadMoreItem();
                final WeightHistoryFragment weightHistoryFragment2 = WeightHistoryFragment.this;
                dslLoadMoreItem.setOnLoadMore(new Oox.oOoXoXO<DslViewHolder, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.WeightHistoryFragment$onInitBaseLayoutAfter$1.2
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
                        final WeightHistoryFragment weightHistoryFragment3 = WeightHistoryFragment.this;
                        it.postDelay(1000L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.WeightHistoryFragment.onInitBaseLayoutAfter.1.2.1
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
                                final WeightHistoryFragment weightHistoryFragment4 = WeightHistoryFragment.this;
                                weightHistoryFragment4.renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.WeightHistoryFragment.onInitBaseLayoutAfter.1.2.1.1
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
                                        WeightHistoryFragment weightHistoryFragment5 = WeightHistoryFragment.this;
                                        i = weightHistoryFragment5.pageNum;
                                        weightHistoryFragment5.pageNum = i + 1;
                                        WeightHistoryFragment weightHistoryFragment6 = WeightHistoryFragment.this;
                                        i2 = weightHistoryFragment6.pageNum;
                                        weightHistoryFragment6.loadData(i2);
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

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24634oOoXoXO)
    public final void onMeasureWeightChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onMeasureWeightChanged");
        getDslViewHolder().postDelay(300L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.WeightHistoryFragment$onMeasureWeightChanged$1
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
                final WeightHistoryFragment weightHistoryFragment = WeightHistoryFragment.this;
                weightHistoryFragment.renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.WeightHistoryFragment$onMeasureWeightChanged$1.1
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
                        WeightHistoryFragment.this.onRefresh();
                    }
                });
            }
        });
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public void onRefresh() {
        super.onRefresh();
        getDslAdapter().resetItem(new ArrayList());
        this.pageNum = 1;
        loadData(1);
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int refreshLayoutId() {
        return R.id.srf;
    }

    public final void share() {
        com.sma.smartv3.util.Oxx0IOOO oxx0IOOO = com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI;
        NestedScrollView scrollView = getScrollView();
        IIX0o.oO(scrollView, "<get-scrollView>(...)");
        oxx0IOOO.oxoX(getMActivity(), oxx0IOOO.I0Io(scrollView));
    }
}
