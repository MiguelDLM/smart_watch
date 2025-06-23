package com.sma.smartv3.ui.ai.fragment;

import OI0.oIX0oI;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.Oxx0xo;
import XO0.XO;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.tabs.TabLayout;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AIFunction;
import com.sma.smartv3.model.AIFunctionCat;
import com.sma.smartv3.model.AIFunctionDataKt;
import com.sma.smartv3.ui.ai.item.AIADPBannerItem;
import com.sma.smartv3.ui.ai.item.AIADPCBannerItem;
import com.sma.smartv3.ui.ai.item.AIFunctionItem;
import com.sma.smartv3.ui.ai.item.AITopItem;
import com.sma.smartv3.ui.ai.item.Hot1AIFunctionItem;
import com.sma.smartv3.ui.ai.item.HotAIFunctionItem;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.x0xO0oo;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nAIFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIFragment.kt\ncom/sma/smartv3/ui/ai/fragment/AIFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,169:1\n1855#2,2:170\n*S KotlinDebug\n*F\n+ 1 AIFragment.kt\ncom/sma/smartv3/ui/ai/fragment/AIFragment\n*L\n151#1:170,2\n*E\n"})
/* loaded from: classes12.dex */
public class AIFragment extends BaseDSLRecyclerFragment {

    @oOoXoXO
    private BaseDslItem bannerItem;

    @OOXIXo
    private final String ITEM_GROUPS_TAG = "groups";

    @OOXIXo
    private AIFunctionCat mCurCat = AIFunctionCat.LIFE;

    @oOoXoXO
    public final BaseDslItem getAdBannerItem() {
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.oOo()) {
            return new AIADPCBannerItem();
        }
        if (projectManager.xOOOX()) {
            return new AIADPBannerItem();
        }
        return null;
    }

    @oOoXoXO
    public final BaseDslItem getBannerItem() {
        return this.bannerItem;
    }

    @OOXIXo
    public final String getITEM_GROUPS_TAG() {
        return this.ITEM_GROUPS_TAG;
    }

    @OOXIXo
    public final AIFunctionCat getMCurCat() {
        return this.mCurCat;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.ai_fragment_rv;
    }

    @XO(tag = x0xO0oo.f24576IoIOOxIIo)
    public final void onAdStateChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        oIX0oI oix0oi = oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append("AI Ad State -> ");
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        sb.append(projectManager.oXIO0o0XI());
        sb.append(", ");
        sb.append(projectManager.IIX0());
        oix0oi.oIX0oI(sb.toString());
        showData();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        showData();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int refreshLayoutId() {
        return 0;
    }

    public final void setBannerItem(@oOoXoXO BaseDslItem baseDslItem) {
        this.bannerItem = baseDslItem;
    }

    public final void setMCurCat(@OOXIXo AIFunctionCat aIFunctionCat) {
        IIX0o.x0xO0oo(aIFunctionCat, "<set-?>");
        this.mCurCat = aIFunctionCat;
    }

    public final void showAIFunction(@OOXIXo AIFunctionCat cat) {
        IIX0o.x0xO0oo(cat, "cat");
        for (final AIFunction aIFunction : AIFunctionDataKt.getAIFunctionByCat(cat)) {
            DslAdapterExKt.x0xO0oo(getDslAdapter(), new AIFunctionItem(0, 1, null), new Oox.oOoXoXO<AIFunctionItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.ai.fragment.AIFragment$showAIFunction$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(AIFunctionItem aIFunctionItem) {
                    invoke2(aIFunctionItem);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo AIFunctionItem dslItem) {
                    IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                    dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(AIFragment.this.getITEM_GROUPS_TAG()));
                    dslItem.setItemData(aIFunction);
                    final AIFragment aIFragment = AIFragment.this;
                    final AIFunction aIFunction2 = aIFunction;
                    dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.ai.fragment.AIFragment$showAIFunction$1$1.1
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
                            Activity mActivity;
                            IIX0o.x0xO0oo(it, "it");
                            mActivity = AIFragment.this.getMActivity();
                            AIFunctionDataKt.toAIFunction(mActivity, aIFunction2);
                        }
                    });
                }
            });
        }
    }

    public void showData() {
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.ai.fragment.AIFragment$showData$1
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
                DslViewHolder dslViewHolder = AIFragment.this.getDslViewHolder();
                final AIFragment aIFragment = AIFragment.this;
                dslViewHolder.postDelay(100L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.ai.fragment.AIFragment$showData$1.1
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
                        DslAdapterExKt.x0xO0oo(DslAdapter.this, new AITopItem(), new Oox.oOoXoXO<AITopItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.ai.fragment.AIFragment.showData.1.1.1
                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(AITopItem aITopItem) {
                                invoke2(aITopItem);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OOXIXo AITopItem dslItem) {
                                IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                dslItem.setItemSpanCount(-1);
                            }
                        });
                        List<AIFunction> hotAIFunction = AIFunctionDataKt.getHotAIFunction();
                        DslAdapter dslAdapter = DslAdapter.this;
                        final AIFragment aIFragment2 = aIFragment;
                        int i = 0;
                        for (Object obj : hotAIFunction) {
                            int i2 = i + 1;
                            if (i < 0) {
                                CollectionsKt__CollectionsKt.XoX();
                            }
                            final AIFunction aIFunction = (AIFunction) obj;
                            DslAdapterExKt.x0xO0oo(dslAdapter, i == 0 ? new Hot1AIFunctionItem() : new HotAIFunctionItem(), new Oox.oOoXoXO<AIFunctionItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.ai.fragment.AIFragment$showData$1$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(AIFunctionItem aIFunctionItem) {
                                    invoke2(aIFunctionItem);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@OOXIXo AIFunctionItem dslItem) {
                                    IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                    dslItem.setItemData(AIFunction.this);
                                    final AIFragment aIFragment3 = aIFragment2;
                                    final AIFunction aIFunction2 = AIFunction.this;
                                    dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.ai.fragment.AIFragment$showData$1$1$2$1.1
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
                                            Activity mActivity;
                                            IIX0o.x0xO0oo(it, "it");
                                            mActivity = AIFragment.this.getMActivity();
                                            AIFunctionDataKt.toAIFunction(mActivity, aIFunction2);
                                        }
                                    });
                                }
                            });
                            i = i2;
                        }
                        if (ProductManager.f20544oIX0oI.oX000x()) {
                            if (aIFragment.getBannerItem() == null) {
                                AIFragment aIFragment3 = aIFragment;
                                aIFragment3.setBannerItem(aIFragment3.getAdBannerItem());
                            }
                            BaseDslItem bannerItem = aIFragment.getBannerItem();
                            if (bannerItem != null) {
                            }
                        }
                        DslAdapter dslAdapter2 = DslAdapter.this;
                        final AIFragment aIFragment4 = aIFragment;
                        DslAdapterExKt.oO(dslAdapter2, R.layout.ai_item_group_head, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.ai.fragment.AIFragment.showData.1.1.4
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
                                dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(AIFragment.this.getITEM_GROUPS_TAG()));
                                dslItem.setItemIsHover(false);
                                final AIFragment aIFragment5 = AIFragment.this;
                                dslItem.setItemBindOverride(new Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.ai.fragment.AIFragment.showData.1.1.4.1
                                    {
                                        super(4);
                                    }

                                    @Override // Oox.Oxx0xo
                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                        invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list);
                                        return oXIO0o0XI.f29392oIX0oI;
                                    }

                                    public final void invoke(@OOXIXo DslViewHolder itemHolder, int i3, @OOXIXo DslAdapterItem adapterItem, @OOXIXo List<? extends Object> list) {
                                        IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                        IIX0o.x0xO0oo(adapterItem, "adapterItem");
                                        IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                        View itemView = itemHolder.itemView;
                                        IIX0o.oO(itemView, "itemView");
                                        UtilsKt.x0o(itemView, Utils.getApp().getResources().getDimension(R.dimen.common_item_radius));
                                        TabLayout tabLayout = (TabLayout) itemHolder.v(R.id.table);
                                        if (tabLayout != null) {
                                            final AIFragment aIFragment6 = AIFragment.this;
                                            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.sma.smartv3.ui.ai.fragment.AIFragment.showData.1.1.4.1.1
                                                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                                                public void onTabReselected(@oOoXoXO TabLayout.Tab tab) {
                                                }

                                                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                                                public void onTabSelected(@OOXIXo TabLayout.Tab tab) {
                                                    AIFunctionCat aIFunctionCat;
                                                    IIX0o.x0xO0oo(tab, "tab");
                                                    AIFragment aIFragment7 = AIFragment.this;
                                                    int position = tab.getPosition();
                                                    if (position != 0) {
                                                        if (position != 1) {
                                                            aIFunctionCat = AIFunctionCat.AMUSEMENT;
                                                        } else {
                                                            aIFunctionCat = AIFunctionCat.WORK;
                                                        }
                                                    } else {
                                                        aIFunctionCat = AIFunctionCat.LIFE;
                                                    }
                                                    aIFragment7.setMCurCat(aIFunctionCat);
                                                    ArrayList arrayList = new ArrayList();
                                                    List<DslAdapterItem> dataItems = AIFragment.this.getDslAdapter().getDataItems();
                                                    AIFragment aIFragment8 = AIFragment.this;
                                                    for (DslAdapterItem dslAdapterItem : dataItems) {
                                                        if (!dslAdapterItem.getItemIsGroupHead() && IIX0o.Oxx0IOOO(dslAdapterItem.getItemGroups(), CollectionsKt__CollectionsKt.XOxIOxOx(aIFragment8.getITEM_GROUPS_TAG()))) {
                                                            arrayList.add(dslAdapterItem);
                                                        }
                                                    }
                                                    AIFragment.this.getDslAdapter().removeItem(arrayList);
                                                    DslAdapter.updateItemDepend$default(AIFragment.this.getDslAdapter(), null, 1, null);
                                                    AIFragment aIFragment9 = AIFragment.this;
                                                    aIFragment9.showAIFunction(aIFragment9.getMCurCat());
                                                    DslAdapter.render$default(AIFragment.this.getDslAdapter(), false, null, new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.ai.fragment.AIFragment$showData$1$1$4$1$1$onTabSelected$2
                                                        @Override // Oox.oOoXoXO
                                                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter3) {
                                                            invoke2(dslAdapter3);
                                                            return oXIO0o0XI.f29392oIX0oI;
                                                        }

                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(@OOXIXo DslAdapter render) {
                                                            IIX0o.x0xO0oo(render, "$this$render");
                                                            DslAdapter.setAdapterStatus$default(render, 0, null, 2, null);
                                                        }
                                                    }, 3, null);
                                                }

                                                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                                                public void onTabUnselected(@oOoXoXO TabLayout.Tab tab) {
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        });
                        AIFragment aIFragment5 = aIFragment;
                        aIFragment5.showAIFunction(aIFragment5.getMCurCat());
                        DslAdapter.render$default(DslAdapter.this, false, null, new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.ai.fragment.AIFragment.showData.1.1.5
                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter3) {
                                invoke2(dslAdapter3);
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
}
