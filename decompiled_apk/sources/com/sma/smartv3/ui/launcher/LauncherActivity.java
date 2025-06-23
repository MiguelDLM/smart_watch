package com.sma.smartv3.ui.launcher;

import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.ad.ADPAppOpenAdManager;
import com.sma.smartv3.biz.ad.ADPCAppOpenAdManager;
import com.sma.smartv3.biz.ad.OnShowADPAdCompleteListener;
import com.sma.smartv3.biz.ad.OnShowADPCAdCompleteListener;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.ui.main.MainActivity;
import com.sma.smartv3.util.GifUtils;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.view.GifImageView;
import com.sma.smartv3.view.xoIox;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nLauncherActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LauncherActivity.kt\ncom/sma/smartv3/ui/launcher/LauncherActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,195:1\n19#2:196\n15#2:197\n69#3,3:198\n72#3,5:202\n69#3,3:207\n72#3,5:211\n69#3,3:216\n72#3,5:220\n1#4:201\n1#4:210\n1#4:219\n*S KotlinDebug\n*F\n+ 1 LauncherActivity.kt\ncom/sma/smartv3/ui/launcher/LauncherActivity\n*L\n114#1:196\n114#1:197\n117#1:198,3\n117#1:202,5\n119#1:207,3\n119#1:211,5\n122#1:216,3\n122#1:220,5\n117#1:201\n119#1:210\n122#1:219\n*E\n"})
/* loaded from: classes12.dex */
public final class LauncherActivity extends BaseActivity {

    /* loaded from: classes12.dex */
    public static final class I0Io implements GifImageView.oIX0oI {
        public I0Io() {
        }

        @Override // com.sma.smartv3.view.GifImageView.oIX0oI
        public /* synthetic */ void I0Io(boolean z) {
            xoIox.II0xO0(this, z);
        }

        @Override // com.sma.smartv3.view.GifImageView.oIX0oI
        public /* synthetic */ void II0xO0() {
            xoIox.I0Io(this);
        }

        @Override // com.sma.smartv3.view.GifImageView.oIX0oI
        public void oIX0oI() {
            LauncherActivity.this.delayGo(ProjectManager.f19822oIX0oI.X0IIOO());
        }

        @Override // com.sma.smartv3.view.GifImageView.oIX0oI
        public /* synthetic */ void onPlayStart() {
            xoIox.oxoX(this);
        }

        @Override // com.sma.smartv3.view.GifImageView.oIX0oI
        public /* synthetic */ void oxoX(float f) {
            xoIox.X0o0xo(this, f);
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements OnShowADPCAdCompleteListener {
        public II0xO0() {
        }

        @Override // com.sma.smartv3.biz.ad.OnShowADPCAdCompleteListener
        public void onShowAdComplete() {
            LauncherActivity.this.go();
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements OnShowADPAdCompleteListener {
        public oIX0oI() {
        }

        public void onShowAdComplete() {
            LauncherActivity.this.go();
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX implements GifUtils.oIX0oI {
        public oxoX() {
        }

        @Override // com.sma.smartv3.util.GifUtils.oIX0oI
        public void oIX0oI() {
            LauncherActivity.this.delayGo(ProjectManager.f19822oIX0oI.X0IIOO());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void delayGo(long j) {
        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.launcher.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                LauncherActivity.delayGo$lambda$0(LauncherActivity.this);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delayGo$lambda$0(LauncherActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.O0X()) {
            ADPCAppOpenAdManager aDPCAppOpenAdManager = ADPCAppOpenAdManager.INSTANCE;
            if (!aDPCAppOpenAdManager.isShowingAd() && !aDPCAppOpenAdManager.isLeftActivity()) {
                this$0.go();
                return;
            }
            return;
        }
        if (projectManager.XIXIX()) {
            ADPAppOpenAdManager aDPAppOpenAdManager = ADPAppOpenAdManager.INSTANCE;
            if (!aDPAppOpenAdManager.isShowingAd() && !aDPAppOpenAdManager.isLeftActivity()) {
                this$0.go();
                return;
            }
            return;
        }
        this$0.go();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void go() {
        Xo0 xo0 = Xo0.f24349oIX0oI;
        if (xo0.XO().getBoolean(XoI0Ixx0.f24363IO, true)) {
            SPUtils XO2 = xo0.XO();
            Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
            Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
            if (fromJson != null) {
                appUser = fromJson;
            }
            if (((AppUser) appUser).getIdentity().length() == 0) {
                startActivity(new Intent(this, (Class<?>) GuideActivity.class));
            } else {
                startActivity(new Intent(this, (Class<?>) MainActivity.class));
            }
        } else {
            startActivity(new Intent(this, (Class<?>) MainActivity.class));
        }
        finish();
    }

    private final void initADPAd() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("initADPAd");
        ADPAppOpenAdManager aDPAppOpenAdManager = ADPAppOpenAdManager.INSTANCE;
        aDPAppOpenAdManager.setShowAdCompleteListener(new oIX0oI());
        View findViewById = findViewById(R.id.splash_container);
        IIX0o.oO(findViewById, "findViewById(...)");
        String string = getString(R.string.adp_unit_open);
        IIX0o.oO(string, "getString(...)");
        aDPAppOpenAdManager.loadAd(this, (ViewGroup) findViewById, string);
    }

    private final void initADPCAd() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("initADPCAd");
        ADPCAppOpenAdManager aDPCAppOpenAdManager = ADPCAppOpenAdManager.INSTANCE;
        aDPCAppOpenAdManager.setShowAdCompleteListener(new II0xO0());
        View findViewById = findViewById(R.id.splash_container);
        IIX0o.oO(findViewById, "findViewById(...)");
        String string = getString(R.string.adpc_unit_open);
        IIX0o.oO(string, "getString(...)");
        aDPCAppOpenAdManager.loadAd(this, (ViewGroup) findViewById, string);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        BarUtils.transparentStatusBar(this);
        BarUtils.setNavBarVisibility((Activity) this, false);
        Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24400OxI, true);
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        projectManager.II0xO0();
        projectManager.I0Io();
        projectManager.Oxx0IOOO();
        View findViewById = findViewById(R.id.launcher_gif);
        if (findViewById == null) {
            delayGo(projectManager.X0IIOO());
        } else if (findViewById instanceof GifImageView) {
            ((GifImageView) findViewById).setOnPlayListener(new I0Io());
        } else if (findViewById instanceof ImageView) {
            GifUtils.f24207oIX0oI.oIX0oI(this, Integer.valueOf(oOXoIIIo.oIX0oI.oIX0oI(this, "launcher", "raw", R.drawable.launcher_image)), 1, (ImageView) findViewById, new oxoX());
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_launcher;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@oOoXoXO Bundle bundle) {
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        projectManager.xoIox();
        projectManager.X0o0xo();
        projectManager.xxIXOIIO();
        projectManager.oxoX();
        projectManager.II0XooXoX();
        super.onCreate(bundle);
        if (projectManager.O0X()) {
            initADPCAd();
        } else if (projectManager.XIXIX()) {
            initADPAd();
        }
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.O0X()) {
            ADPCAppOpenAdManager.INSTANCE.destroy();
        } else if (projectManager.XIXIX()) {
            ADPAppOpenAdManager.INSTANCE.destroy();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, @oOoXoXO KeyEvent keyEvent) {
        if (i != 3 && i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.O0X()) {
            ADPCAppOpenAdManager.INSTANCE.setLeftActivity(true);
        } else if (projectManager.XIXIX()) {
            ADPAppOpenAdManager.INSTANCE.setLeftActivity(true);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.O0X()) {
            ADPCAppOpenAdManager aDPCAppOpenAdManager = ADPCAppOpenAdManager.INSTANCE;
            if (aDPCAppOpenAdManager.isClicked() || aDPCAppOpenAdManager.isAdDismiss()) {
                go();
            }
            aDPCAppOpenAdManager.setLeftActivity(false);
            return;
        }
        if (projectManager.XIXIX()) {
            ADPAppOpenAdManager aDPAppOpenAdManager = ADPAppOpenAdManager.INSTANCE;
            if (aDPAppOpenAdManager.isClicked() || aDPAppOpenAdManager.isAdDismiss()) {
                go();
            }
            aDPAppOpenAdManager.setLeftActivity(false);
        }
    }
}
