package com.sma.smartv3.ui.status.item;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.biz.ad.ADPAdError;
import com.sma.smartv3.biz.ad.ADPAdListener;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.ad.ADPAdContainerView;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class ADPBannerItem extends BaseDslItem {
    private ADPAdContainerView adContainerView;
    private boolean isFirstLoad;
    private boolean isLoaded;
    private boolean isLoading;

    @OXOo.OOXIXo
    private final String TAG = "ADPBannerItem";
    private final boolean initEvent = true;

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends ADPAdListener {
        public oIX0oI() {
        }

        public void onAdClose() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(ADPBannerItem.this.TAG + " -> Ad State : Closed");
            ADPBannerItem.this.isLoaded = false;
            ADPBannerItem.this.initView();
        }

        public void onAdFailed(@OXOo.OOXIXo ADPAdError error) {
            IIX0o.x0xO0oo(error, "error");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(ADPBannerItem.this.TAG + " -> Ad State : Error, Info: " + error.getCode() + ", " + error.getMsg());
            ADPBannerItem.this.isLoaded = false;
            ADPBannerItem.this.isLoading = false;
            ADPBannerItem.this.initView();
        }

        public void onAdLoaded() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(ADPBannerItem.this.TAG + " -> Ad State : Loaded");
            ADPBannerItem.this.isLoaded = true;
            ADPBannerItem.this.isLoading = false;
            ADPBannerItem.this.initView();
        }

        public void onAdOpen() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(ADPBannerItem.this.TAG + " -> Ad State : Open");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$2$lambda$0(ADPBannerItem this$0, LifecycleOwner source, Lifecycle.Event event) {
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
    public static final void bindView$lambda$2$lambda$1(ADPBannerItem this$0, ADPAdContainerView this_apply) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(this_apply, "$this_apply");
        if (!this$0.isFirstLoad) {
            this$0.isFirstLoad = true;
            this$0.isLoading = true;
            int width = this_apply.getWidth();
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.TAG + " -> Ad State : loadAdView viewWidth:" + width + ", id:" + this_apply.getAdUnitId());
            ADPAdContainerView aDPAdContainerView = this$0.adContainerView;
            if (aDPAdContainerView == null) {
                IIX0o.XOxIOxOx("adContainerView");
                aDPAdContainerView = null;
            }
            ADPAdContainerView.loadAdView$default(aDPAdContainerView, null, width, true, null, 9, null);
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.adContainerView);
        IIX0o.ooOOo0oXI(v);
        final ADPAdContainerView aDPAdContainerView = (ADPAdContainerView) v;
        this.adContainerView = aDPAdContainerView;
        if (aDPAdContainerView == null) {
            IIX0o.XOxIOxOx("adContainerView");
            aDPAdContainerView = null;
        }
        aDPAdContainerView.setAdListener(new oIX0oI());
        aDPAdContainerView.setHostActivityObserver(new LifecycleEventObserver() { // from class: com.sma.smartv3.ui.status.item.oIX0oI
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                ADPBannerItem.bindView$lambda$2$lambda$0(ADPBannerItem.this, lifecycleOwner, event);
            }
        });
        aDPAdContainerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sma.smartv3.ui.status.item.II0xO0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                ADPBannerItem.bindView$lambda$2$lambda$1(ADPBannerItem.this, aDPAdContainerView);
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
        return R.layout.status_item_banner_adp;
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
