package com.sma.smartv3.ui.sport.coach;

import OXOo.OOXIXo;
import Oox.Oxx0xo;
import Oox.oOoXoXO;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.LibExKt;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.otherdevice.jl.view.CommonDecoration;
import com.sma.smartv3.ui.sport.coach.AICoachManage;
import com.sma.smartv3.ui.sport.coach.item.PlanContentItem;
import com.sma.smartv3.ui.sport.coach.item.VitalityPlanItem;
import com.sma.smartv3.view.text.PFMedium;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nPlanConfirmActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlanConfirmActivity.kt\ncom/sma/smartv3/ui/sport/coach/PlanConfirmActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,316:1\n1855#2,2:317\n*S KotlinDebug\n*F\n+ 1 PlanConfirmActivity.kt\ncom/sma/smartv3/ui/sport/coach/PlanConfirmActivity\n*L\n123#1:317,2\n*E\n"})
/* loaded from: classes12.dex */
public final class PlanConfirmActivity extends BaseDSLRecyclerActivity {
    private int curPosition;
    private int mCurrentItem;

    @OOXIXo
    private final String ITEM_GROUPS_TAG = "plan_groups";

    @OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) PlanConfirmActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) PlanConfirmActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OOXIXo
    private final X0IIOO confirmPlanIv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity$confirmPlanIv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) PlanConfirmActivity.this.findViewById(R.id.confirm_plan_ll_img);
        }
    });

    @OOXIXo
    private final X0IIOO modifyPlan$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity$modifyPlan$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) PlanConfirmActivity.this.findViewById(R.id.coach_modify_plan);
        }
    });

    @OOXIXo
    private final X0IIOO confirmPlan$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity$confirmPlan$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) PlanConfirmActivity.this.findViewById(R.id.coach_confirm_plan);
        }
    });

    @OOXIXo
    private String curTimeDay = "";
    private int curDataPosition = -1;

    @OOXIXo
    private final List<CommonAdapter<AICoachManage.PlanGroupTitle>> mListAdapter = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public final void addGroupHead() {
        DslAdapterExKt.oO(getDslAdapter(), R.layout.ai_plan_item_group_head, new oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity$addGroupHead$1
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
                String str;
                IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                dslItem.setItemIsGroupHead(true);
                str = PlanConfirmActivity.this.ITEM_GROUPS_TAG;
                dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(str));
                dslItem.setItemIsHover(false);
                final PlanConfirmActivity planConfirmActivity = PlanConfirmActivity.this;
                dslItem.setItemBindOverride(new Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity$addGroupHead$1.1
                    {
                        super(4);
                    }

                    @Override // Oox.Oxx0xo
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                        invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    public final void invoke(@OOXIXo DslViewHolder itemHolder, int i, @OOXIXo DslAdapterItem adapterItem, @OOXIXo List<? extends Object> list) {
                        IIX0o.x0xO0oo(itemHolder, "itemHolder");
                        IIX0o.x0xO0oo(adapterItem, "adapterItem");
                        IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                        View v = itemHolder.v(R.id.plan_week_tv);
                        IIX0o.ooOOo0oXI(v);
                        final TextView textView = (TextView) v;
                        View v2 = itemHolder.v(R.id.view_pager);
                        IIX0o.ooOOo0oXI(v2);
                        final ViewPager2 viewPager2 = (ViewPager2) v2;
                        List<AICoachManage.PlanGroupTitle> Oo2 = AICoachManage.f23905XO.oIX0oI().Oo();
                        final List OxXXx0X2 = Oo2 != null ? CollectionsKt___CollectionsKt.OxXXx0X(Oo2, 7) : null;
                        viewPager2.setOffscreenPageLimit(-1);
                        StringBuilder sb = new StringBuilder();
                        sb.append(PlanConfirmActivity.this.getString(R.string.week));
                        sb.append(" (");
                        sb.append(viewPager2.getCurrentItem() + 1);
                        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                        IIX0o.ooOOo0oXI(OxXXx0X2);
                        sb.append(OxXXx0X2.size());
                        sb.append(HexStringBuilder.COMMENT_END_CHAR);
                        textView.setText(sb.toString());
                        viewPager2.setAdapter(new CommonAdapter<List<? extends AICoachManage.PlanGroupTitle>>(OxXXx0X2, viewPager2) { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity.addGroupHead.1.1.1
                            final /* synthetic */ ViewPager2 $viewPager;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(PlanConfirmActivity.this, R.layout.ai_plan_group_pager_item, OxXXx0X2);
                                this.$viewPager = viewPager2;
                            }

                            @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
                            public /* bridge */ /* synthetic */ void convert(ViewHolder viewHolder, List<? extends AICoachManage.PlanGroupTitle> list2, int i2) {
                                convert2(viewHolder, (List<AICoachManage.PlanGroupTitle>) list2, i2);
                            }

                            /* renamed from: convert, reason: avoid collision after fix types in other method */
                            public void convert2(@OOXIXo ViewHolder itemHolder2, @OOXIXo List<AICoachManage.PlanGroupTitle> time, int i2) {
                                IIX0o.x0xO0oo(itemHolder2, "itemHolder");
                                IIX0o.x0xO0oo(time, "time");
                                PlanConfirmActivity.this.addRecyclerView(itemHolder2, time, this.$viewPager);
                            }
                        });
                        viewPager2.setCurrentItem(PlanConfirmActivity.this.getMCurrentItem());
                        final PlanConfirmActivity planConfirmActivity2 = PlanConfirmActivity.this;
                        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity.addGroupHead.1.1.2
                            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                            public void onPageScrollStateChanged(int i2) {
                            }

                            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                            public void onPageScrolled(int i2, float f, int i3) {
                            }

                            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                            public void onPageSelected(int i2) {
                                textView.setText(planConfirmActivity2.getString(R.string.week) + " (" + (viewPager2.getCurrentItem() + 1) + IOUtils.DIR_SEPARATOR_UNIX + OxXXx0X2.size() + HexStringBuilder.COMMENT_END_CHAR);
                            }
                        });
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void addRecyclerView(ViewHolder viewHolder, List<AICoachManage.PlanGroupTitle> list, ViewPager2 viewPager2) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = list;
        View view = viewHolder.getView(R.id.ai_plan_item_group_head_recycle);
        IIX0o.ooOOo0oXI(view);
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new CommonDecoration(this, 0, getResources().getColor(R.color.transparent), 16));
        }
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 7));
        PlanConfirmActivity$addRecyclerView$adapter$1 planConfirmActivity$addRecyclerView$adapter$1 = new PlanConfirmActivity$addRecyclerView$adapter$1(this, objectRef);
        recyclerView.setAdapter(planConfirmActivity$addRecyclerView$adapter$1);
        this.mListAdapter.add(planConfirmActivity$addRecyclerView$adapter$1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(PlanConfirmActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.setResult(9000, new Intent());
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(PlanConfirmActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getConfirmPlan().setEnabled(false);
        this$0.setResult(-1, new Intent());
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(PlanConfirmActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        LibExKt.oxxXoxO(this$0.findViewById(R.id.create_plan_loading_layout), true);
        this$0.getConfirmPlanIv().clearAnimation();
    }

    private final void setCurSelected() {
        AICoachManage.PlanGroupTitle planGroupTitle;
        Object obj;
        List<AICoachManage.PlanGroupTitle> Oo2 = AICoachManage.f23905XO.oIX0oI().Oo();
        AICoachManage.PlanGroupTitle planGroupTitle2 = null;
        if (Oo2 != null) {
            Iterator<T> it = Oo2.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    AICoachManage.PlanGroupTitle planGroupTitle3 = (AICoachManage.PlanGroupTitle) obj;
                    if (planGroupTitle3.getMLessonIndex() != -1 && !planGroupTitle3.isCompleted() && AICoachManage.f23905XO.oIX0oI().oI0IIXIo().getDailySchedule().get(planGroupTitle3.getMLessonIndex() % 7).intValue() == 1) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            planGroupTitle = (AICoachManage.PlanGroupTitle) obj;
        } else {
            planGroupTitle = null;
        }
        if (planGroupTitle != null) {
            AICoachManage.oIX0oI oix0oi = AICoachManage.f23905XO;
            List<AICoachManage.PlanGroupTitle> Oo3 = oix0oi.oIX0oI().Oo();
            IIX0o.ooOOo0oXI(Oo3);
            int indexOf = Oo3.indexOf(planGroupTitle);
            if (indexOf <= 7) {
                this.curPosition = indexOf % 7;
                this.curTimeDay = planGroupTitle.getTimeDay();
                this.curDataPosition = planGroupTitle.getMLessonIndex();
                this.mCurrentItem = indexOf / 7;
                return;
            }
            List<AICoachManage.PlanGroupTitle> Oo4 = oix0oi.oIX0oI().Oo();
            if (Oo4 != null) {
                planGroupTitle2 = (AICoachManage.PlanGroupTitle) CollectionsKt___CollectionsKt.O0OOX0IIx(Oo4);
            }
            if (planGroupTitle2 != null) {
                this.curTimeDay = planGroupTitle2.getTimeDay();
                this.mCurrentItem = 0;
                this.curPosition = 0;
                this.curDataPosition = -1;
            }
        }
    }

    private final void showData() {
        AICoachManage.f23905XO.oIX0oI().IXxxXO();
        setCurSelected();
        renderAdapter(new oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity$showData$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo final DslAdapter renderAdapter) {
                IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                renderAdapter.clearAllItems();
                DslAdapter.setAdapterStatus$default(renderAdapter, 2, null, 2, null);
                DslViewHolder dslViewHolder = PlanConfirmActivity.this.getDslViewHolder();
                final PlanConfirmActivity planConfirmActivity = PlanConfirmActivity.this;
                dslViewHolder.postDelay(100L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity$showData$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        DslAdapterExKt.IXxxXO(DslAdapter.this, new VitalityPlanItem(), null, 2, null);
                        planConfirmActivity.addGroupHead();
                        planConfirmActivity.showPlanFunction();
                        DslAdapter.render$default(DslAdapter.this, false, null, new oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity.showData.1.1.1
                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                                invoke2(dslAdapter);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OOXIXo DslAdapter render) {
                                IIX0o.x0xO0oo(render, "$this$render");
                                DslAdapter.setAdapterStatus$default(render, 0, null, 2, null);
                            }
                        }, 3, null);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPlanFunction() {
        AICoachManage.VitalityLesson vitalityLesson;
        List<AICoachManage.VitalityDayLesson> dayLesson;
        IIXOooo iIXOooo = null;
        int i = 2;
        boolean z = false;
        if (this.curDataPosition == -1) {
            final AICoachManage.VitalityDayLesson vitalityDayLesson = new AICoachManage.VitalityDayLesson(0, null, null, 0, 0, 0.0f, null, 127, null);
            DslAdapterExKt.x0xO0oo(getDslAdapter(), new PlanContentItem(vitalityDayLesson, z, i, iIXOooo), new oOoXoXO<PlanContentItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity$showPlanFunction$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PlanContentItem planContentItem) {
                    invoke2(planContentItem);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo PlanContentItem dslItem) {
                    String str;
                    IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                    str = PlanConfirmActivity.this.ITEM_GROUPS_TAG;
                    dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(str));
                    final PlanConfirmActivity planConfirmActivity = PlanConfirmActivity.this;
                    final AICoachManage.VitalityDayLesson vitalityDayLesson2 = vitalityDayLesson;
                    dslItem.setItemClick(new oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity$showPlanFunction$1.1
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
                            PlanConfirmActivity planConfirmActivity2 = PlanConfirmActivity.this;
                            AICoachManage.VitalityDayLesson vitalityDayLesson3 = vitalityDayLesson2;
                            Bundle bundle = new Bundle();
                            bundle.putString("mArg0", null);
                            bundle.putParcelable("mArg2", null);
                            bundle.putSerializable("mArg3", vitalityDayLesson3);
                            Intent intent = new Intent(planConfirmActivity2, (Class<?>) CoachPlanDetailActivity.class);
                            intent.putExtras(bundle);
                            planConfirmActivity2.startActivity(intent);
                        }
                    });
                }
            });
            return;
        }
        List<AICoachManage.VitalityLesson> mVitalityDayLesson = AICoachManage.f23905XO.oIX0oI().oI0IIXIo().getMVitalityDayLesson();
        if (mVitalityDayLesson != null && (vitalityLesson = mVitalityDayLesson.get(this.curDataPosition % 7)) != null && (dayLesson = vitalityLesson.getDayLesson()) != null) {
            for (final AICoachManage.VitalityDayLesson vitalityDayLesson2 : dayLesson) {
                DslAdapterExKt.x0xO0oo(getDslAdapter(), new PlanContentItem(vitalityDayLesson2, z, i, iIXOooo), new oOoXoXO<PlanContentItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity$showPlanFunction$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PlanContentItem planContentItem) {
                        invoke2(planContentItem);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OOXIXo PlanContentItem dslItem) {
                        String str;
                        IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                        str = PlanConfirmActivity.this.ITEM_GROUPS_TAG;
                        dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(str));
                        final PlanConfirmActivity planConfirmActivity = PlanConfirmActivity.this;
                        final AICoachManage.VitalityDayLesson vitalityDayLesson3 = vitalityDayLesson2;
                        dslItem.setItemClick(new oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity$showPlanFunction$2$1.1
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
                                PlanConfirmActivity planConfirmActivity2 = PlanConfirmActivity.this;
                                AICoachManage.VitalityDayLesson vitalityDayLesson4 = vitalityDayLesson3;
                                Bundle bundle = new Bundle();
                                bundle.putString("mArg0", null);
                                bundle.putParcelable("mArg2", null);
                                bundle.putSerializable("mArg3", vitalityDayLesson4);
                                Intent intent = new Intent(planConfirmActivity2, (Class<?>) CoachPlanDetailActivity.class);
                                intent.putExtras(bundle);
                                planConfirmActivity2.startActivity(intent);
                            }
                        });
                    }
                });
            }
        }
    }

    public final PFMedium getAbhTitleCenter() {
        return (PFMedium) this.abhTitleCenter$delegate.getValue();
    }

    public final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    public final Button getConfirmPlan() {
        return (Button) this.confirmPlan$delegate.getValue();
    }

    public final ImageView getConfirmPlanIv() {
        return (ImageView) this.confirmPlanIv$delegate.getValue();
    }

    public final int getMCurrentItem() {
        return this.mCurrentItem;
    }

    public final Button getModifyPlan() {
        return (Button) this.modifyPlan$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getAbhTitleCenter().setText(getString(R.string.coach_create_plan_vcp_title));
        getConfirmPlan().setEnabled(true);
        getModifyPlan().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.coach.oxoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlanConfirmActivity.initView$lambda$1(PlanConfirmActivity.this, view);
            }
        });
        getConfirmPlan().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.coach.X0o0xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlanConfirmActivity.initView$lambda$2(PlanConfirmActivity.this, view);
            }
        });
        ImageView confirmPlanIv = getConfirmPlanIv();
        RotateAnimation rotateAnimation = new RotateAnimation(360.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setDuration(1800L);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        confirmPlanIv.startAnimation(rotateAnimation);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.sport.coach.XO
            @Override // java.lang.Runnable
            public final void run() {
                PlanConfirmActivity.initView$lambda$4(PlanConfirmActivity.this);
            }
        }, 1000L);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.ai_coach_confirm_plan;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        getRecyclerView().addItemDecoration(new CommonDecoration(this, 1, getResources().getColor(R.color.transparent), 16));
        showData();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getDslAdapter().notifyDataSetChanged();
    }

    public final void onTitleLeftClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        onBackPressed();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int refreshLayoutId() {
        return 0;
    }

    public final void setMCurrentItem(int i) {
        this.mCurrentItem = i;
    }
}
