package com.sma.smartv3.ui.me.item;

import OXOo.OOXIXo;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.biz.ad.ADPCAdError;
import com.sma.smartv3.biz.ad.ADPCAdListener;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.ad.ADPCAdContainerView;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes11.dex */
public final class MeADPCBannerItem extends BaseDslItem {
    private ADPCAdContainerView adContainerView;
    private boolean isFirstLoad;
    private boolean isLoaded;
    private boolean isLoading;

    @OOXIXo
    private final String TAG = "MeADPCBannerItem";
    private final boolean initEvent = true;

    /* loaded from: classes11.dex */
    public static final class oIX0oI extends ADPCAdListener {
        public oIX0oI() {
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADClosed() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MeADPCBannerItem.this.TAG + " -> Ad State : Closed");
            MeADPCBannerItem.this.isLoaded = false;
            MeADPCBannerItem.this.initView();
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADError(@OOXIXo ADPCAdError error) {
            IIX0o.x0xO0oo(error, "error");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MeADPCBannerItem.this.TAG + " -> Ad State : Error, Info: " + error.getCode() + ", " + error.getMsg());
            MeADPCBannerItem.this.isLoaded = false;
            MeADPCBannerItem.this.isLoading = false;
            MeADPCBannerItem.this.initView();
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADPresent() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MeADPCBannerItem.this.TAG + " -> Ad State : Present");
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADReceive() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MeADPCBannerItem.this.TAG + " -> Ad State : Loaded");
            MeADPCBannerItem.this.isLoaded = true;
            MeADPCBannerItem.this.isLoading = false;
            MeADPCBannerItem.this.initView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$2$lambda$0(MeADPCBannerItem this$0, LifecycleOwner source, Lifecycle.Event event) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(event, "event");
        if (event == Lifecycle.Event.ON_RESUME) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.TAG + " -> Ad State : Lifecycle, Event: " + event + ", isLoaded: " + this$0.isLoaded + ", isLoading: " + this$0.isLoading);
            if (!this$0.isLoaded && !this$0.isLoading) {
                this$0.isFirstLoad = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$2$lambda$1(MeADPCBannerItem this$0, ADPCAdContainerView this_apply) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(this_apply, "$this_apply");
        if (!this$0.isFirstLoad) {
            this$0.isFirstLoad = true;
            this$0.isLoading = true;
            int width = this_apply.getWidth();
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.TAG + " -> Ad State : loadAdView viewWidth:" + width + ", id:" + this_apply.getAdUnitId());
            ADPCAdContainerView.loadAdView$default(this_apply, null, width, true, null, 9, null);
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.adContainerView);
        IIX0o.ooOOo0oXI(v);
        final ADPCAdContainerView aDPCAdContainerView = (ADPCAdContainerView) v;
        this.adContainerView = aDPCAdContainerView;
        ADPCAdContainerView aDPCAdContainerView2 = null;
        if (aDPCAdContainerView == null) {
            IIX0o.XOxIOxOx("adContainerView");
            aDPCAdContainerView = null;
        }
        aDPCAdContainerView.setAdListener(new oIX0oI());
        aDPCAdContainerView.setHostActivityObserver(new LifecycleEventObserver() { // from class: com.sma.smartv3.ui.me.item.xxIXOIIO
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                MeADPCBannerItem.bindView$lambda$2$lambda$0(MeADPCBannerItem.this, lifecycleOwner, event);
            }
        });
        ADPCAdContainerView aDPCAdContainerView3 = this.adContainerView;
        if (aDPCAdContainerView3 == null) {
            IIX0o.XOxIOxOx("adContainerView");
        } else {
            aDPCAdContainerView2 = aDPCAdContainerView3;
        }
        aDPCAdContainerView2.post(new Runnable() { // from class: com.sma.smartv3.ui.me.item.xoIox
            @Override // java.lang.Runnable
            public final void run() {
                MeADPCBannerItem.bindView$lambda$2$lambda$1(MeADPCBannerItem.this, aDPCAdContainerView);
            }
        });
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        setItemHidden(!this.isLoaded);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.me_item_banner_adpc;
    }

    @XO0.XO(tag = x0xO0oo.f24576IoIOOxIIo)
    public final void onAdStateChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        boolean XoOxI0ox2 = ProductManager.f20544oIX0oI.XoOxI0ox();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> Ad State : onAdStateChange " + XoOxI0ox2);
        if (XoOxI0ox2) {
            this.isFirstLoad = false;
        }
    }
}
