package com.sma.smartv3.ui.status.item;

import android.view.View;
import android.view.ViewTreeObserver;
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

/* loaded from: classes12.dex */
public final class ADPCBannerItem extends BaseDslItem {
    private ADPCAdContainerView adContainerView;
    private boolean isFirstLoad;
    private boolean isLoaded;
    private boolean isLoading;

    @OXOo.OOXIXo
    private final String TAG = "ADPCBannerItem";
    private final boolean initEvent = true;

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends ADPCAdListener {
        public oIX0oI() {
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADClosed() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(ADPCBannerItem.this.TAG + " -> Ad State : Closed");
            ADPCBannerItem.this.isLoaded = false;
            ADPCBannerItem.this.initView();
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADError(@OXOo.OOXIXo ADPCAdError error) {
            IIX0o.x0xO0oo(error, "error");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(ADPCBannerItem.this.TAG + " -> Ad State : Error, Info: " + error.getCode() + ", " + error.getMsg());
            ADPCBannerItem.this.isLoaded = false;
            ADPCBannerItem.this.isLoading = false;
            ADPCBannerItem.this.initView();
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADPresent() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(ADPCBannerItem.this.TAG + " -> Ad State : Present");
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADReceive() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(ADPCBannerItem.this.TAG + " -> Ad State : Loaded");
            ADPCBannerItem.this.isLoaded = true;
            ADPCBannerItem.this.isLoading = false;
            ADPCBannerItem.this.initView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$2$lambda$0(ADPCBannerItem this$0, LifecycleOwner source, Lifecycle.Event event) {
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
    public static final void bindView$lambda$2$lambda$1(ADPCBannerItem this$0, ADPCAdContainerView this_apply) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(this_apply, "$this_apply");
        if (!this$0.isFirstLoad) {
            this$0.isFirstLoad = true;
            this$0.isLoading = true;
            int width = this_apply.getWidth();
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.TAG + " -> Ad State : loadAdView viewWidth:" + width + ", id:" + this_apply.getAdUnitId());
            ADPCAdContainerView aDPCAdContainerView = this$0.adContainerView;
            if (aDPCAdContainerView == null) {
                IIX0o.XOxIOxOx("adContainerView");
                aDPCAdContainerView = null;
            }
            ADPCAdContainerView.loadAdView$default(aDPCAdContainerView, null, width, true, null, 9, null);
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.adContainerView);
        IIX0o.ooOOo0oXI(v);
        final ADPCAdContainerView aDPCAdContainerView = (ADPCAdContainerView) v;
        this.adContainerView = aDPCAdContainerView;
        if (aDPCAdContainerView == null) {
            IIX0o.XOxIOxOx("adContainerView");
            aDPCAdContainerView = null;
        }
        aDPCAdContainerView.setAdListener(new oIX0oI());
        aDPCAdContainerView.setHostActivityObserver(new LifecycleEventObserver() { // from class: com.sma.smartv3.ui.status.item.I0Io
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                ADPCBannerItem.bindView$lambda$2$lambda$0(ADPCBannerItem.this, lifecycleOwner, event);
            }
        });
        aDPCAdContainerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sma.smartv3.ui.status.item.oxoX
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                ADPCBannerItem.bindView$lambda$2$lambda$1(ADPCBannerItem.this, aDPCAdContainerView);
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
        return R.layout.status_item_banner_adpc;
    }

    @XO0.XO(tag = x0xO0oo.f24576IoIOOxIIo)
    public final void onAdStateChange(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        boolean XoOxI0ox2 = ProductManager.f20544oIX0oI.XoOxI0ox();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> Ad State : onAdStateChange " + XoOxI0ox2);
        if (XoOxI0ox2) {
            this.isFirstLoad = false;
        }
    }
}
