package com.sma.smartv3.view.ad;

import OI0.oIX0oI;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.blankj.utilcode.util.ScreenUtils;
import com.sma.smartv3.R;
import com.sma.smartv3.biz.ad.ADPAdBanner;
import com.sma.smartv3.biz.ad.ADPAdError;
import com.sma.smartv3.biz.ad.ADPAdListener;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

@Keep
/* loaded from: classes12.dex */
public class ADPAdContainerView extends RelativeLayout {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    public static final String TAG = "ADPAdContainerView";

    @OOXIXo
    private String adUnitId;
    private boolean autoLoad;
    private boolean isAdLoaded;

    @oOoXoXO
    private ADPAdListener listener;

    @oOoXoXO
    private LifecycleEventObserver mHostActivityObserver;

    @OOXIXo
    private final String makeSureToHandleLifecycleMessage;
    private boolean parentMayHaveAListView;

    @oOoXoXO
    private ADPAdBanner showADBanner;

    @OOXIXo
    private final String showOnConditionMessage;

    @OOXIXo
    private final ColorDrawable transparent;

    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void logDebug(String str) {
            oIX0oI.f1507oIX0oI.oIX0oI("ADPAdContainerView -> " + str);
        }

        private Companion() {
        }
    }

    /* loaded from: classes12.dex */
    public final class HostActivityObserver implements LifecycleEventObserver {

        /* loaded from: classes12.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Lifecycle.Event.values().length];
                try {
                    iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public HostActivityObserver() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@OOXIXo LifecycleOwner source, @OOXIXo Lifecycle.Event event) {
            IIX0o.x0xO0oo(source, "source");
            IIX0o.x0xO0oo(event, "event");
            int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            ADPAdContainerView.this.destroyAd();
                        }
                    } else {
                        ADPAdContainerView.this.pauseAd();
                    }
                } else {
                    ADPAdContainerView.this.resumeAd();
                }
            } else if (ADPAdContainerView.this.getAutoLoad()) {
                ADPAdContainerView aDPAdContainerView = ADPAdContainerView.this;
                ADPAdContainerView.loadAdView$default(aDPAdContainerView, aDPAdContainerView.getAdUnitId$app_co_fit_v2BaiduNavRelease(), ScreenUtils.getScreenWidth(), false, null, 12, null);
            }
            LifecycleEventObserver lifecycleEventObserver = ADPAdContainerView.this.mHostActivityObserver;
            if (lifecycleEventObserver != null) {
                lifecycleEventObserver.onStateChanged(source, event);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public ADPAdContainerView(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final boolean isMainThread() {
        return IIX0o.Oxx0IOOO(Thread.currentThread(), Looper.getMainLooper().getThread());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadAdView$default(ADPAdContainerView aDPAdContainerView, String str, int i, boolean z, Oox.oIX0oI oix0oi, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = aDPAdContainerView.adUnitId;
            }
            if ((i2 & 2) != 0) {
                i = ScreenUtils.getScreenWidth();
            }
            if ((i2 & 4) != 0) {
                z = false;
            }
            if ((i2 & 8) != 0) {
                oix0oi = null;
            }
            aDPAdContainerView.loadAdView(str, i, z, oix0oi);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAdView");
    }

    public final void destroyAd() {
        this.isAdLoaded = false;
        ADPAdBanner aDPAdBanner = this.showADBanner;
        if (aDPAdBanner != null) {
            aDPAdBanner.destroy();
        }
        removeAllViews();
    }

    @OOXIXo
    public final String getAdUnitId() {
        return this.adUnitId;
    }

    @OOXIXo
    public final String getAdUnitId$app_co_fit_v2BaiduNavRelease() {
        return this.adUnitId;
    }

    public final boolean getAutoLoad() {
        return this.autoLoad;
    }

    @oOoXoXO
    public final ADPAdListener getListener() {
        return this.listener;
    }

    @OOXIXo
    public final String getMakeSureToHandleLifecycleMessage$app_co_fit_v2BaiduNavRelease() {
        return this.makeSureToHandleLifecycleMessage;
    }

    public final boolean getParentMayHaveAListView$app_co_fit_v2BaiduNavRelease() {
        return this.parentMayHaveAListView;
    }

    @OOXIXo
    public final String getShowOnConditionMessage$app_co_fit_v2BaiduNavRelease() {
        return this.showOnConditionMessage;
    }

    @OOXIXo
    public final ColorDrawable getTransparent$app_co_fit_v2BaiduNavRelease() {
        return this.transparent;
    }

    public final boolean isAdLoaded$app_co_fit_v2BaiduNavRelease() {
        return this.isAdLoaded;
    }

    public final void loadAdView(@OOXIXo String adUnitId, int i, boolean z, @oOoXoXO Oox.oIX0oI<Boolean> oix0oi) {
        IIX0o.x0xO0oo(adUnitId, "adUnitId");
        this.parentMayHaveAListView = z;
        if (oix0oi != null && !oix0oi.invoke().booleanValue()) {
            Companion.logDebug(this.showOnConditionMessage);
            ADPAdListener aDPAdListener = this.listener;
            if (aDPAdListener != null) {
                aDPAdListener.onAdFailed(new ADPAdError("-1", this.showOnConditionMessage));
                return;
            }
            return;
        }
        Context context = getContext();
        IIX0o.x0XOIxOo(context, "null cannot be cast to non-null type android.app.Activity");
        ADPAdBanner aDPAdBanner = new ADPAdBanner((Activity) context, adUnitId, i, new ADPAdListener() { // from class: com.sma.smartv3.view.ad.ADPAdContainerView$loadAdView$1
            public void onAdClicked() {
                ADPAdListener listener = ADPAdContainerView.this.getListener();
                if (listener != null) {
                    listener.onAdClicked();
                }
            }

            public void onAdClose() {
                ADPAdListener listener = ADPAdContainerView.this.getListener();
                if (listener != null) {
                    listener.onAdClose();
                }
            }

            public void onAdFailed(@OOXIXo ADPAdError error) {
                IIX0o.x0xO0oo(error, "error");
                ADPAdListener listener = ADPAdContainerView.this.getListener();
                if (listener != null) {
                    listener.onAdFailed(error);
                }
            }

            public void onAdLoaded() {
                ADPAdListener listener = ADPAdContainerView.this.getListener();
                if (listener != null) {
                    listener.onAdLoaded();
                }
            }

            public void onAdOpen() {
                ADPAdListener listener = ADPAdContainerView.this.getListener();
                if (listener != null) {
                    listener.onAdOpen();
                }
            }
        });
        this.showADBanner = aDPAdBanner;
        aDPAdBanner.loadAd(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!this.parentMayHaveAListView) {
            destroyAd();
        }
    }

    @OOXIXo
    public final Oox.oIX0oI<oXIO0o0XI> pauseAd() {
        return new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.view.ad.ADPAdContainerView$pauseAd$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }
        };
    }

    public final void removeAd() {
        destroyAd();
    }

    @OOXIXo
    public final Oox.oIX0oI<oXIO0o0XI> resumeAd() {
        return new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.view.ad.ADPAdContainerView$resumeAd$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }
        };
    }

    public final void setAdListener(@OOXIXo ADPAdListener listener) {
        IIX0o.x0xO0oo(listener, "listener");
        this.listener = listener;
    }

    public final void setAdLoaded$app_co_fit_v2BaiduNavRelease(boolean z) {
        this.isAdLoaded = z;
    }

    public final void setAdUnitId$app_co_fit_v2BaiduNavRelease(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.adUnitId = str;
    }

    public final void setAutoLoad(boolean z) {
        this.autoLoad = z;
    }

    public final void setHostActivityObserver(@OOXIXo LifecycleEventObserver lifecycleEventObserver) {
        IIX0o.x0xO0oo(lifecycleEventObserver, "lifecycleEventObserver");
        this.mHostActivityObserver = lifecycleEventObserver;
    }

    public final void setListener(@oOoXoXO ADPAdListener aDPAdListener) {
        this.listener = aDPAdListener;
    }

    public final void setParentMayHaveAListView$app_co_fit_v2BaiduNavRelease(boolean z) {
        this.parentMayHaveAListView = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public ADPAdContainerView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ ADPAdContainerView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @xoIox
    public ADPAdContainerView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.showOnConditionMessage = "showOnCondition lambda returned false, AdContainerView will not load an Ad.";
        this.makeSureToHandleLifecycleMessage = "Make sure to call the resume, pause, destroy lifecycle methods.";
        String str = "";
        this.adUnitId = "";
        this.transparent = new ColorDrawable(0);
        if (context instanceof LifecycleOwner) {
            if (isMainThread()) {
                ((LifecycleOwner) context).getLifecycle().addObserver(new HostActivityObserver());
            }
        } else {
            Companion.logDebug("Context is not a FragmentActivity. Make sure to call the resume, pause, destroy lifecycle methods.");
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AdContainerView, 0, 0);
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                str = string;
            }
            this.adUnitId = str;
            this.autoLoad = obtainStyledAttributes.getBoolean(1, false);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
