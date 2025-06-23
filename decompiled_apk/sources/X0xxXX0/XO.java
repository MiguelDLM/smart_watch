package X0xxXX0;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.octopus.ad.NativeAdResponse;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public class XO extends CustomNativeAd {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f3681I0Io = XO.class.getSimpleName();

    /* renamed from: II0xO0, reason: collision with root package name */
    public NativeAdResponse f3682II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Context f3683oIX0oI;

    /* loaded from: classes11.dex */
    public class oIX0oI implements xXoOI00O.oIX0oI {
        public oIX0oI() {
        }

        @Override // xXoOI00O.oIX0oI
        public void onADExposed() {
            Log.i(XO.f3681I0Io, "onADExposed");
            XO.this.notifyAdImpression();
        }

        @Override // xXoOI00O.oIX0oI
        public void onAdClick() {
            Log.i(XO.f3681I0Io, IAdInterListener.AdCommandType.AD_CLICK);
            XO.this.notifyAdClicked();
        }

        @Override // xXoOI00O.oIX0oI
        public void onAdClose() {
            Log.i(XO.f3681I0Io, "onAdClose");
            XO.this.notifyAdDislikeClick();
        }

        @Override // xXoOI00O.oIX0oI
        public void onAdRenderFailed(int i) {
            Log.i(XO.f3681I0Io, "onADExposed");
        }
    }

    public XO(Context context, NativeAdResponse nativeAdResponse) {
        this.f3683oIX0oI = context.getApplicationContext();
        this.f3682II0xO0 = nativeAdResponse;
        II0XooXoX();
    }

    public Bitmap I0Io() {
        NativeAdResponse nativeAdResponse = this.f3682II0xO0;
        if (nativeAdResponse != null) {
            return nativeAdResponse.X0o0xo(this.f3683oIX0oI);
        }
        return null;
    }

    public void II0XooXoX() {
        setTitle(this.f3682II0xO0.getTitle());
        setDescriptionText(this.f3682II0xO0.getDescription());
        setIconImageUrl(this.f3682II0xO0.getIconUrl());
        setMainImageUrl(this.f3682II0xO0.getImageUrl());
        setImageUrlList(this.f3682II0xO0.getImageUrls());
        setCallToActionText(this.f3682II0xO0.getButtonText());
    }

    public void II0xO0() {
        this.f3683oIX0oI = null;
        this.f3682II0xO0 = null;
    }

    public void Oxx0IOOO(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (view == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
        if (clickViewList == null) {
            clickViewList = new ArrayList<>();
            X0o0xo(clickViewList, view);
        }
        this.f3682II0xO0.oIX0oI(viewGroup, clickViewList, new oIX0oI());
    }

    public final void X0o0xo(List<View> list, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                X0o0xo(list, viewGroup.getChildAt(i));
            }
            return;
        }
        list.add(view);
    }

    public boolean XO() {
        return false;
    }

    public View oxoX(Object... objArr) {
        try {
            NativeAdResponse nativeAdResponse = this.f3682II0xO0;
            if (nativeAdResponse != null) {
                return nativeAdResponse.xxIXOIIO(this.f3683oIX0oI);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clear(View view) {
    }
}
