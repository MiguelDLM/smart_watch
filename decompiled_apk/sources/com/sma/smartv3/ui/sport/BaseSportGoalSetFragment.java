package com.sma.smartv3.ui.sport;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import java.util.HashMap;
import java.util.List;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public abstract class BaseSportGoalSetFragment extends BaseDSLRecyclerFragment {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO nowGoalValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.sport.BaseSportGoalSetFragment$nowGoalValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BaseSportGoalSetFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.nowGoalValue);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO nowGoalUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.BaseSportGoalSetFragment$nowGoalUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = BaseSportGoalSetFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.nowGoalUnit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO customerGoalBt$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.sport.BaseSportGoalSetFragment$customerGoalBt$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            View mView;
            mView = BaseSportGoalSetFragment.this.getMView();
            return (Button) mView.findViewById(R.id.customerGoalBt);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO startExerciseBt$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.sport.BaseSportGoalSetFragment$startExerciseBt$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            View mView;
            mView = BaseSportGoalSetFragment.this.getMView();
            return (Button) mView.findViewById(R.id.startExerciseBt);
        }
    });

    @OXOo.OOXIXo
    private final HashMap<Integer, String> distanceItemData = new HashMap<>();

    @OXOo.OOXIXo
    private final int[] goals = new int[3];

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(BaseSportGoalSetFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.toCustomerGoal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(BaseSportGoalSetFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startExercise();
    }

    public final Button getCustomerGoalBt() {
        return (Button) this.customerGoalBt$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final HashMap<Integer, String> getDistanceItemData() {
        return this.distanceItemData;
    }

    @OXOo.OOXIXo
    public final int[] getGoals() {
        return this.goals;
    }

    public final PFMedium getNowGoalUnit() {
        return (PFMedium) this.nowGoalUnit$delegate.getValue();
    }

    public final DINCondBold getNowGoalValue() {
        return (DINCondBold) this.nowGoalValue$delegate.getValue();
    }

    public final Button getStartExerciseBt() {
        return (Button) this.startExerciseBt$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        setGoalValueItem();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getStartExerciseBt().setEnabled(false);
        getCustomerGoalBt().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.xxIXOIIO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSportGoalSetFragment.initView$lambda$0(BaseSportGoalSetFragment.this, view);
            }
        });
        getStartExerciseBt().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.xoIox
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSportGoalSetFragment.initView$lambda$1(BaseSportGoalSetFragment.this, view);
            }
        });
        getRecyclerView().setLayoutManager(new GridLayoutManager(getMActivity(), 3));
        getRecyclerView().setHasFixedSize(false);
        setInfo();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_sport_goal_set;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.BaseSportGoalSetFragment$onInitBaseLayoutAfter$1
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
                kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                renderAdapter.getItemSelectorHelper().IoOoX(1);
                DslViewHolder dslViewHolder = BaseSportGoalSetFragment.this.getDslViewHolder();
                final BaseSportGoalSetFragment baseSportGoalSetFragment = BaseSportGoalSetFragment.this;
                dslViewHolder.post(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.BaseSportGoalSetFragment$onInitBaseLayoutAfter$1.1
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
                        final BaseSportGoalSetFragment baseSportGoalSetFragment2 = BaseSportGoalSetFragment.this;
                        baseSportGoalSetFragment2.renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.BaseSportGoalSetFragment.onInitBaseLayoutAfter.1.1.1
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
                                kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                for (final int i = 0; i < 6; i++) {
                                    final BaseSportGoalSetFragment baseSportGoalSetFragment3 = BaseSportGoalSetFragment.this;
                                    DslAdapterExKt.oO(renderAdapter2, R.layout.item_sport_goal, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.BaseSportGoalSetFragment.onInitBaseLayoutAfter.1.1.1.1
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
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                            final BaseSportGoalSetFragment baseSportGoalSetFragment4 = BaseSportGoalSetFragment.this;
                                            final int i2 = i;
                                            dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.BaseSportGoalSetFragment.onInitBaseLayoutAfter.1.1.1.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(4);
                                                }

                                                @Override // Oox.Oxx0xo
                                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                    invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list);
                                                    return oXIO0o0XI.f29392oIX0oI;
                                                }

                                                public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i3, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                    TextView tv = itemHolder.tv(R.id.itemValue);
                                                    if (tv != null) {
                                                        tv.setText(BaseSportGoalSetFragment.this.getDistanceItemData().get(Integer.valueOf(i2)));
                                                    }
                                                    View view = itemHolder.view(R.id.rl_value);
                                                    if (view != null) {
                                                        view.setBackgroundResource(dslItem.getItemIsSelected() ? R.drawable.common_ripple_sport_bt : R.drawable.common_ripple_me);
                                                    }
                                                }
                                            });
                                            final BaseSportGoalSetFragment baseSportGoalSetFragment5 = BaseSportGoalSetFragment.this;
                                            final int i3 = i;
                                            dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.BaseSportGoalSetFragment.onInitBaseLayoutAfter.1.1.1.1.2
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
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                                    if (DslAdapterItem.this.getItemIsSelected()) {
                                                        return;
                                                    }
                                                    DslAdapterItem.updateItemSelector$default(DslAdapterItem.this, !r5.getItemIsSelected(), false, 2, null);
                                                    baseSportGoalSetFragment5.updateGoalValue(i3);
                                                }
                                            });
                                        }
                                    });
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int refreshLayoutId() {
        return 0;
    }

    public abstract void setGoalValueItem();

    public abstract void setInfo();

    public abstract void startExercise();

    public abstract void toCustomerGoal();

    public abstract void updateGoalValue(int i);
}
