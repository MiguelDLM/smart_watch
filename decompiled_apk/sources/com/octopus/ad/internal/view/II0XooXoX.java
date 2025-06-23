package com.octopus.ad.internal.view;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.core.view.ViewCompat;
import x0.I0oOoX;

/* loaded from: classes11.dex */
public class II0XooXoX extends com.octopus.ad.internal.view.oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public Context f18988I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public FrameLayout f18989II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public AdWebView f18990X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public WebChromeClient.CustomViewCallback f18991oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public AdViewImpl f18992oxoX;

    /* loaded from: classes11.dex */
    public class I0Io implements DialogInterface.OnClickListener {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f18994Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ GeolocationPermissions.Callback f18995XO;

        public I0Io(GeolocationPermissions.Callback callback, String str) {
            this.f18995XO = callback;
            this.f18994Oo = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f18995XO.invoke(this.f18994Oo, false, false);
        }
    }

    /* loaded from: classes11.dex */
    public class II0xO0 implements DialogInterface.OnClickListener {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f18997Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ GeolocationPermissions.Callback f18998XO;

        public II0xO0(GeolocationPermissions.Callback callback, String str) {
            this.f18998XO = callback;
            this.f18997Oo = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f18998XO.invoke(this.f18997Oo, true, true);
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements View.OnClickListener {
        public oIX0oI() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            II0XooXoX.this.onHideCustomView();
        }
    }

    public II0XooXoX(Activity activity) {
        this.f18988I0Io = activity;
    }

    public final void oIX0oI(FrameLayout frameLayout) {
        ImageButton imageButton = new ImageButton(this.f18988I0Io);
        imageButton.setImageDrawable(this.f18988I0Io.getResources().getDrawable(R.drawable.ic_menu_close_clear_cancel));
        imageButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 53));
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(new oIX0oI());
        frameLayout.addView(imageButton);
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        AdViewImpl adViewImpl = this.f18992oxoX;
        if (adViewImpl != null && !adViewImpl.xoxXI() && !this.f18992oxoX.XIxXXX0x0()) {
            this.f18992oxoX.getAdDispatcher().a();
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        Context context;
        AdWebView adWebView = this.f18990X0o0xo;
        if (adWebView != null) {
            context = I0oOoX.OxxIIOOXO(adWebView);
        } else {
            context = this.f18988I0Io;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(String.format(this.f18988I0Io.getResources().getString(com.octopus.ad.R.string.html5_geo_permission_prompt_title), str));
        builder.setMessage(com.octopus.ad.R.string.html5_geo_permission_prompt);
        builder.setPositiveButton(com.octopus.ad.R.string.allow, new II0xO0(callback, str));
        builder.setNegativeButton(com.octopus.ad.R.string.deny, new I0Io(callback, str));
        builder.create().show();
        AdViewImpl adViewImpl = this.f18992oxoX;
        if (adViewImpl != null && !adViewImpl.xoxXI() && !this.f18992oxoX.XIxXXX0x0()) {
            this.f18992oxoX.getAdDispatcher().b();
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        ViewGroup viewGroup;
        super.onHideCustomView();
        Context context = this.f18988I0Io;
        if (context != null && this.f18989II0xO0 != null) {
            AdWebView adWebView = this.f18990X0o0xo;
            if (adWebView != null) {
                viewGroup = (ViewGroup) adWebView.getRootView().findViewById(R.id.content);
            } else if (context instanceof Activity) {
                viewGroup = (ViewGroup) ((Activity) context).findViewById(R.id.content);
            } else {
                viewGroup = null;
            }
            if (viewGroup == null) {
                com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(com.octopus.ad.R.string.fullscreen_video_hide_error));
                return;
            }
            viewGroup.removeView(this.f18989II0xO0);
            WebChromeClient.CustomViewCallback customViewCallback = this.f18991oIX0oI;
            if (customViewCallback != null) {
                try {
                    customViewCallback.onCustomViewHidden();
                    return;
                } catch (NullPointerException e) {
                    com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Exception calling customViewCallback  onCustomViewHidden: " + e.getMessage());
                    return;
                }
            }
            return;
        }
        com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(com.octopus.ad.R.string.fullscreen_video_hide_error));
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        ViewGroup viewGroup;
        super.onShowCustomView(view, customViewCallback);
        Context context = this.f18988I0Io;
        if (context == null) {
            com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(com.octopus.ad.R.string.fullscreen_video_show_error));
            return;
        }
        AdWebView adWebView = this.f18990X0o0xo;
        if (adWebView != null) {
            viewGroup = (ViewGroup) adWebView.getRootView().findViewById(R.id.content);
        } else {
            viewGroup = context instanceof Activity ? (ViewGroup) ((Activity) context).findViewById(R.id.content) : null;
        }
        if (viewGroup == null) {
            com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(com.octopus.ad.R.string.fullscreen_video_show_error));
            return;
        }
        this.f18991oIX0oI = customViewCallback;
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            this.f18989II0xO0 = frameLayout;
            frameLayout.setClickable(true);
            this.f18989II0xO0.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            try {
                oIX0oI(this.f18989II0xO0);
                viewGroup.addView(this.f18989II0xO0, new ViewGroup.LayoutParams(-1, -1));
                return;
            } catch (Exception e) {
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, e.toString());
                return;
            }
        }
        this.f18989II0xO0 = null;
    }

    public II0XooXoX(AdWebView adWebView) {
        this.f18988I0Io = adWebView.getContextFromMutableContext();
        this.f18990X0o0xo = adWebView;
        this.f18992oxoX = adWebView.f18916Oo;
    }
}
