package com.sma.smartv3.ui.me.item;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.ad.ADPAdError;
import com.sma.smartv3.biz.ad.ADPAdListener;
import com.sma.smartv3.biz.ad.ADPCAdError;
import com.sma.smartv3.biz.ad.ADPCAdListener;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.ad.ADPAdContainerView;
import com.sma.smartv3.view.ad.ADPCAdContainerView;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes11.dex */
public class MainBottomItem extends BaseDslItem {

    @oOoXoXO
    private ADPAdContainerView adpAdContainerView;

    @oOoXoXO
    private ADPCAdContainerView adpcAdContainerView;
    public View btExerciseCourse;
    public View btFeedBack;
    public View btFirmwareRepair;
    public View btFont;
    public View btPermissionSetting;
    public View btThemeSwitch;
    public View btUiRepair;
    public View btUserInfo;
    private boolean isFirstLoad;
    private boolean isLoaded;
    private boolean isLoading;
    public ImageView ivRemind;

    @oOoXoXO
    private View.OnClickListener mOnClick;

    @OOXIXo
    private final String TAG = "MainBottomItem";
    private final boolean initEvent = true;

    /* loaded from: classes11.dex */
    public static final class II0xO0 extends ADPAdListener {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ ADPAdContainerView f23523II0xO0;

        public II0xO0(ADPAdContainerView aDPAdContainerView) {
            this.f23523II0xO0 = aDPAdContainerView;
        }

        public void onAdClose() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MainBottomItem.this.TAG + " -> Ad State : Closed");
            MainBottomItem.this.isLoaded = false;
            this.f23523II0xO0.setVisibility(8);
        }

        public void onAdFailed(@OOXIXo ADPAdError error) {
            IIX0o.x0xO0oo(error, "error");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MainBottomItem.this.TAG + " -> Ad State : Error, Info: " + error.getCode() + ", " + error.getMsg());
            MainBottomItem.this.isLoaded = false;
            MainBottomItem.this.isLoading = false;
            this.f23523II0xO0.setVisibility(8);
        }

        public void onAdLoaded() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MainBottomItem.this.TAG + " -> Ad State : Loaded");
            MainBottomItem.this.isLoaded = true;
            MainBottomItem.this.isLoading = false;
            this.f23523II0xO0.setVisibility(0);
        }

        public void onAdOpen() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MainBottomItem.this.TAG + " -> Ad State : Open");
        }
    }

    /* loaded from: classes11.dex */
    public static final class oIX0oI extends ADPCAdListener {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ ADPCAdContainerView f23525II0xO0;

        public oIX0oI(ADPCAdContainerView aDPCAdContainerView) {
            this.f23525II0xO0 = aDPCAdContainerView;
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADClosed() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MainBottomItem.this.TAG + " -> Ad State : Closed");
            MainBottomItem.this.isLoaded = false;
            this.f23525II0xO0.setVisibility(8);
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADError(@OOXIXo ADPCAdError error) {
            IIX0o.x0xO0oo(error, "error");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MainBottomItem.this.TAG + " -> Ad State : Error, Info: " + error.getCode() + ", " + error.getMsg());
            MainBottomItem.this.isLoaded = false;
            MainBottomItem.this.isLoading = false;
            this.f23525II0xO0.setVisibility(8);
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADPresent() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MainBottomItem.this.TAG + " -> Ad State : Present");
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADReceive() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MainBottomItem.this.TAG + " -> Ad State : Loaded");
            MainBottomItem.this.isLoaded = true;
            MainBottomItem.this.isLoading = false;
            this.f23525II0xO0.setVisibility(0);
        }
    }

    private final void showAd() {
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (!projectManager.IoOoX() && projectManager.IIX0()) {
            final ADPCAdContainerView aDPCAdContainerView = this.adpcAdContainerView;
            if (aDPCAdContainerView != null) {
                aDPCAdContainerView.setVisibility(0);
                aDPCAdContainerView.setAdListener(new oIX0oI(aDPCAdContainerView));
                aDPCAdContainerView.setHostActivityObserver(new LifecycleEventObserver() { // from class: com.sma.smartv3.ui.me.item.oIX0oI
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        MainBottomItem.showAd$lambda$2$lambda$0(MainBottomItem.this, lifecycleOwner, event);
                    }
                });
                aDPCAdContainerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sma.smartv3.ui.me.item.II0xO0
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        MainBottomItem.showAd$lambda$2$lambda$1(MainBottomItem.this, aDPCAdContainerView);
                    }
                });
                return;
            }
            return;
        }
        if (!projectManager.IoOoX() && projectManager.oXIO0o0XI()) {
            final ADPAdContainerView aDPAdContainerView = this.adpAdContainerView;
            if (aDPAdContainerView != null) {
                aDPAdContainerView.setVisibility(0);
                aDPAdContainerView.setAdListener(new II0xO0(aDPAdContainerView));
                aDPAdContainerView.setHostActivityObserver(new LifecycleEventObserver() { // from class: com.sma.smartv3.ui.me.item.I0Io
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        MainBottomItem.showAd$lambda$5$lambda$3(MainBottomItem.this, lifecycleOwner, event);
                    }
                });
                aDPAdContainerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sma.smartv3.ui.me.item.oxoX
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        MainBottomItem.showAd$lambda$5$lambda$4(MainBottomItem.this, aDPAdContainerView);
                    }
                });
                return;
            }
            return;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> Ad State : hide");
        ADPCAdContainerView aDPCAdContainerView2 = this.adpcAdContainerView;
        if (aDPCAdContainerView2 != null) {
            aDPCAdContainerView2.setVisibility(8);
        }
        ADPAdContainerView aDPAdContainerView2 = this.adpAdContainerView;
        if (aDPAdContainerView2 != null) {
            aDPAdContainerView2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAd$lambda$2$lambda$0(MainBottomItem this$0, LifecycleOwner source, Lifecycle.Event event) {
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
    public static final void showAd$lambda$2$lambda$1(MainBottomItem this$0, ADPCAdContainerView this_apply) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAd$lambda$5$lambda$3(MainBottomItem this$0, LifecycleOwner source, Lifecycle.Event event) {
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
    public static final void showAd$lambda$5$lambda$4(MainBottomItem this$0, ADPAdContainerView this_apply) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(this_apply, "$this_apply");
        if (!this$0.isFirstLoad) {
            this$0.isFirstLoad = true;
            this$0.isLoading = true;
            int width = this_apply.getWidth();
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.TAG + " -> Ad State : loadAdView viewWidth:" + width + ", id:" + this_apply.getAdUnitId());
            ADPAdContainerView.loadAdView$default(this_apply, null, width, true, null, 9, null);
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.ivRemind);
        IIX0o.ooOOo0oXI(v);
        setIvRemind((ImageView) v);
        View v2 = itemHolder.v(R.id.btExercise);
        IIX0o.ooOOo0oXI(v2);
        setBtExerciseCourse(v2);
        View v3 = itemHolder.v(R.id.btUserInfo);
        IIX0o.ooOOo0oXI(v3);
        setBtUserInfo(v3);
        View v4 = itemHolder.v(R.id.btFirmwareRepair);
        IIX0o.ooOOo0oXI(v4);
        setBtFirmwareRepair(v4);
        View v5 = itemHolder.v(R.id.btUiRepair);
        IIX0o.ooOOo0oXI(v5);
        setBtUiRepair(v5);
        View v6 = itemHolder.v(R.id.btSwitch);
        IIX0o.ooOOo0oXI(v6);
        setBtThemeSwitch(v6);
        View v7 = itemHolder.v(R.id.btFeedBack);
        IIX0o.ooOOo0oXI(v7);
        setBtFeedBack(v7);
        View v8 = itemHolder.v(R.id.btFont);
        IIX0o.ooOOo0oXI(v8);
        setBtFont(v8);
        View v9 = itemHolder.v(R.id.btPermissionSetting);
        IIX0o.ooOOo0oXI(v9);
        setBtPermissionSetting(v9);
        itemHolder.click(R.id.btExercise, this.mOnClick);
        itemHolder.click(R.id.btUserInfo, this.mOnClick);
        itemHolder.click(R.id.btSwitch, this.mOnClick);
        itemHolder.click(R.id.btFont, this.mOnClick);
        itemHolder.click(R.id.btFirmwareRepair, this.mOnClick);
        itemHolder.click(R.id.btUiRepair, this.mOnClick);
        itemHolder.click(R.id.btSetting, this.mOnClick);
        itemHolder.click(R.id.btAbout, this.mOnClick);
        itemHolder.click(R.id.btFeedBack, this.mOnClick);
        itemHolder.click(R.id.btFont, this.mOnClick);
        itemHolder.click(R.id.btPermissionSetting, this.mOnClick);
        this.adpcAdContainerView = (ADPCAdContainerView) itemHolder.v(R.id.adpcAdContainerView);
        this.adpAdContainerView = (ADPAdContainerView) itemHolder.v(R.id.adpAdContainerView);
        showAd();
    }

    @oOoXoXO
    public final ADPAdContainerView getAdpAdContainerView() {
        return this.adpAdContainerView;
    }

    @oOoXoXO
    public final ADPCAdContainerView getAdpcAdContainerView() {
        return this.adpcAdContainerView;
    }

    @OOXIXo
    public final View getBtExerciseCourse() {
        View view = this.btExerciseCourse;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("btExerciseCourse");
        return null;
    }

    @OOXIXo
    public final View getBtFeedBack() {
        View view = this.btFeedBack;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("btFeedBack");
        return null;
    }

    @OOXIXo
    public final View getBtFirmwareRepair() {
        View view = this.btFirmwareRepair;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("btFirmwareRepair");
        return null;
    }

    @OOXIXo
    public final View getBtFont() {
        View view = this.btFont;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("btFont");
        return null;
    }

    @OOXIXo
    public final View getBtPermissionSetting() {
        View view = this.btPermissionSetting;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("btPermissionSetting");
        return null;
    }

    @OOXIXo
    public final View getBtThemeSwitch() {
        View view = this.btThemeSwitch;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("btThemeSwitch");
        return null;
    }

    @OOXIXo
    public final View getBtUiRepair() {
        View view = this.btUiRepair;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("btUiRepair");
        return null;
    }

    @OOXIXo
    public final View getBtUserInfo() {
        View view = this.btUserInfo;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("btUserInfo");
        return null;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @OOXIXo
    public final ImageView getIvRemind() {
        ImageView imageView = this.ivRemind;
        if (imageView != null) {
            return imageView;
        }
        IIX0o.XOxIOxOx("ivRemind");
        return null;
    }

    @oOoXoXO
    public final View.OnClickListener getMOnClick() {
        return this.mOnClick;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        View btThemeSwitch = getBtThemeSwitch();
        int i8 = 0;
        if (Build.VERSION.SDK_INT > 28 && ProjectManager.f19822oIX0oI.XI0oooXX()) {
            i = 0;
        } else {
            i = 8;
        }
        btThemeSwitch.setVisibility(i);
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (!projectManager.Io()) {
            View btFont = getBtFont();
            ProductManager productManager = ProductManager.f20544oIX0oI;
            if (productManager.ooOx()) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            btFont.setVisibility(i5);
            View btUiRepair = getBtUiRepair();
            if (productManager.xx0X0() && productManager.oOoIIO0()) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            btUiRepair.setVisibility(i6);
            View btFirmwareRepair = getBtFirmwareRepair();
            if (productManager.I0oOIX()) {
                i7 = 0;
            } else {
                i7 = 8;
            }
            btFirmwareRepair.setVisibility(i7);
        } else {
            getBtFont().setVisibility(8);
            getBtUiRepair().setVisibility(8);
            getBtFirmwareRepair().setVisibility(8);
        }
        View btExerciseCourse = getBtExerciseCourse();
        if (ProductManager.f20544oIX0oI.I0oOoX() != 0) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        btExerciseCourse.setVisibility(i2);
        View btUserInfo = getBtUserInfo();
        if (projectManager.IIxOXoOo0()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        btUserInfo.setVisibility(i3);
        View btPermissionSetting = getBtPermissionSetting();
        if (projectManager.Ioxxx()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        btPermissionSetting.setVisibility(i4);
        View btFeedBack = getBtFeedBack();
        if (!projectManager.O0Xx()) {
            i8 = 8;
        }
        btFeedBack.setVisibility(i8);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.me_item_bottom;
    }

    @XO0.XO(tag = x0xO0oo.f24576IoIOOxIIo)
    public final void onAdStateChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> Ad State : onAdStateChange");
        showAd();
    }

    @XO0.XO(tag = x0xO0oo.f24572IO)
    public final void onBindStateChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        initView();
    }

    @XO0.XO(tag = x0xO0oo.f24603X00IoxXI)
    public final void onNewVersionShow(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        getIvRemind().setVisibility(0);
    }

    public final void setAdpAdContainerView(@oOoXoXO ADPAdContainerView aDPAdContainerView) {
        this.adpAdContainerView = aDPAdContainerView;
    }

    public final void setAdpcAdContainerView(@oOoXoXO ADPCAdContainerView aDPCAdContainerView) {
        this.adpcAdContainerView = aDPCAdContainerView;
    }

    public final void setBtExerciseCourse(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.btExerciseCourse = view;
    }

    public final void setBtFeedBack(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.btFeedBack = view;
    }

    public final void setBtFirmwareRepair(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.btFirmwareRepair = view;
    }

    public final void setBtFont(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.btFont = view;
    }

    public final void setBtPermissionSetting(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.btPermissionSetting = view;
    }

    public final void setBtThemeSwitch(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.btThemeSwitch = view;
    }

    public final void setBtUiRepair(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.btUiRepair = view;
    }

    public final void setBtUserInfo(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.btUserInfo = view;
    }

    public final void setIvRemind(@OOXIXo ImageView imageView) {
        IIX0o.x0xO0oo(imageView, "<set-?>");
        this.ivRemind = imageView;
    }

    public final void setMOnClick(@oOoXoXO View.OnClickListener onClickListener) {
        this.mOnClick = onClickListener;
    }
}
