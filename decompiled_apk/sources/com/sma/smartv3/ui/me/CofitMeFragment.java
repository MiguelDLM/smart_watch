package com.sma.smartv3.ui.me;

import android.os.Handler;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.BarUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.me.item.CofitMeAvatarItem;
import com.sma.smartv3.ui.me.item.CofitUserOrderItem;
import com.sma.smartv3.ui.me.item.MainMiddleItem;

/* loaded from: classes11.dex */
public final class CofitMeFragment extends MainMeFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefresh$lambda$0(CofitMeFragment this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getRefreshLayout().setRefreshing(false);
        this$0.getDslAdapter().notifyDataSetChanged();
    }

    @Override // com.sma.smartv3.ui.me.MainMeFragment, com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        BarUtils.addMarginTopEqualStatusBarHeight(getMView().findViewById(R.id.srf));
    }

    @Override // com.sma.smartv3.ui.me.MainMeFragment, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.cofit_fragment_me_rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public void onRefresh() {
        super.onRefresh();
        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.o00
            @Override // java.lang.Runnable
            public final void run() {
                CofitMeFragment.onRefresh$lambda$0(CofitMeFragment.this);
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @Override // com.sma.smartv3.ui.me.MainMeFragment, com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int refreshLayoutId() {
        return R.id.srf;
    }

    @Override // com.sma.smartv3.ui.me.MainMeFragment
    public void renderAdapterMethod() {
        renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.CofitMeFragment$renderAdapterMethod$1
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
                DslViewHolder dslViewHolder = CofitMeFragment.this.getDslViewHolder();
                final CofitMeFragment cofitMeFragment = CofitMeFragment.this;
                dslViewHolder.post(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.CofitMeFragment$renderAdapterMethod$1.1
                    {
                        super(0);
                    }

                    @Override // Oox.oIX0oI
                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                        invoke2();
                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        CofitMeFragment.this.getDslAdapter().clearAllItems();
                        final CofitMeFragment cofitMeFragment2 = CofitMeFragment.this;
                        cofitMeFragment2.renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.CofitMeFragment.renderAdapterMethod.1.1.1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapter dslAdapter) {
                                invoke2(dslAdapter);
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter2) {
                                BaseDslItem bannerItem;
                                kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                CofitMeAvatarItem cofitMeAvatarItem = new CofitMeAvatarItem();
                                cofitMeAvatarItem.setMOnClick(CofitMeFragment.this);
                                DslAdapterExKt.IXxxXO(renderAdapter2, cofitMeAvatarItem, null, 2, null);
                                CofitUserOrderItem cofitUserOrderItem = new CofitUserOrderItem();
                                cofitUserOrderItem.setMOnClick(CofitMeFragment.this);
                                DslAdapterExKt.IXxxXO(renderAdapter2, cofitUserOrderItem, null, 2, null);
                                MainMiddleItem mainMiddleItem = new MainMiddleItem();
                                mainMiddleItem.setMOnClick(CofitMeFragment.this);
                                DslAdapterExKt.IXxxXO(renderAdapter2, mainMiddleItem, null, 2, null);
                                DslAdapterExKt.IXxxXO(renderAdapter2, CofitMeFragment.this.getMainBottomItem(), null, 2, null);
                                if (ProductManager.f20544oIX0oI.oX000x()) {
                                    if (CofitMeFragment.this.getBannerItem() == null) {
                                        CofitMeFragment cofitMeFragment3 = CofitMeFragment.this;
                                        cofitMeFragment3.setBannerItem(cofitMeFragment3.getAdBannerItem());
                                    }
                                    if (!ProjectManager.f19822oIX0oI.IoOoX() || (bannerItem = CofitMeFragment.this.getBannerItem()) == null) {
                                        return;
                                    }
                                    DslAdapterExKt.IXxxXO(renderAdapter2, bannerItem, null, 2, null);
                                }
                            }
                        });
                    }
                });
            }
        });
    }
}
