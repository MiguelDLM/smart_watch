package com.alimm.tanx.core.ad.browser;

import android.annotation.TargetApi;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.view.ActionMenu;
import com.alimm.tanx.core.ad.view.WebMenuDialog;
import com.alimm.tanx.core.constant.AdClickConstants;
import com.alimm.tanx.core.utils.AdClickUtAnalytics;
import com.alimm.tanx.core.utils.AdWebViewUtils;
import com.alimm.tanx.core.utils.LogUtils;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.ArrayList;

public abstract class tanxc_do extends AppCompatActivity {
    private final boolean tanxc_byte = true;
    private boolean tanxc_case = false;
    private long tanxc_char;
    protected String tanxc_do;
    /* access modifiers changed from: private */
    public OrientationEventListener tanxc_else;
    protected TextView tanxc_for;
    /* access modifiers changed from: private */
    public int tanxc_goto = -2;
    protected String tanxc_if;
    protected ProgressBar tanxc_int;
    protected final IAdWebViewCallback tanxc_new = new IAdWebViewCallback() {
        public void onHideCustomView() {
            tanxc_do.this.tanxc_do(false);
            ActionBar supportActionBar = tanxc_do.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.show();
            }
            tanxc_do tanxc_do2 = tanxc_do.this;
            if (tanxc_do2 != null) {
                tanxc_do2.setRequestedOrientation(1);
            }
        }

        public void onShowCustomView(View view) {
            tanxc_do.this.tanxc_do(true);
            ActionBar supportActionBar = tanxc_do.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.hide();
            }
            tanxc_do tanxc_do2 = tanxc_do.this;
            if (tanxc_do2 != null) {
                tanxc_do2.setRequestedOrientation(10);
            }
        }

        public void onTitleLoaded(String str) {
            TextView textView = tanxc_do.this.tanxc_for;
            if (textView != null) {
                textView.setText(str);
            }
        }
    };
    private WebMenuDialog tanxc_try;

    @TargetApi(19)
    private void tanxc_char() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(ViewCompat.MEASURED_STATE_MASK);
    }

    private void tanxc_else() {
        if (this.tanxc_try == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(ActionMenu.refresh);
            arrayList.add(ActionMenu.copy);
            arrayList.add(ActionMenu.gotoweb);
            this.tanxc_try = new WebMenuDialog(this, arrayList, new WebMenuDialog.MenuClick() {
                public void click(int i) {
                    if (i == 1012) {
                        tanxc_do.this.tanxc_new();
                    } else if (i == 1013) {
                        String tanxc_int = tanxc_do.this.tanxc_int();
                        if (!TextUtils.isEmpty(tanxc_int)) {
                            try {
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.setData(Uri.parse(tanxc_int));
                                intent.setFlags(1610612740);
                                tanxc_do.this.startActivity(intent);
                            } catch (Throwable th) {
                                LogUtils.d("BaseAdWebViewActivity", "showMenuDialog exception.", th);
                            }
                        }
                    } else if (i == 1016) {
                        String tanxc_int2 = tanxc_do.this.tanxc_int();
                        if (!TextUtils.isEmpty(tanxc_int2)) {
                            ((ClipboardManager) tanxc_do.this.getSystemService("clipboard")).setText(tanxc_int2);
                        }
                    }
                }
            });
        }
        try {
            this.tanxc_try.show();
        } catch (Throwable th) {
            LogUtils.d("BaseAdWebViewActivity", "showMenuDialog exception.", th);
        }
    }

    public void finish() {
        if (!isFinishing()) {
            setResult(-1);
            super.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        setTheme(R.style.Theme_AdClick_NoActionBar);
        if (getIntent() == null) {
            LogUtils.d("BaseAdWebViewActivity", "onCreate: intent is null.");
            AdClickUtAnalytics.recordActivityCreateFail((BidInfo) null, "BaseAdWebViewActivity", "null_intent");
            finish();
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.tanxc_if = extras.getString("url");
            LogUtils.d("BaseAdWebViewActivity", "onCreate: mUrl == " + this.tanxc_if);
            i = extras.getInt(AdClickConstants.FORCE_ORIENTATION, 1);
            this.tanxc_char = extras.getLong(AdClickConstants.ACTIVITY_LAUNCH_TIME, 0);
        } else {
            this.tanxc_if = getIntent().getDataString();
            LogUtils.d("BaseAdWebViewActivity", "onCreate:getDataString  mUrl == " + this.tanxc_if);
            i = 1;
        }
        if (TextUtils.isEmpty(this.tanxc_if)) {
            AdClickUtAnalytics.recordActivityCreateFail((BidInfo) null, "BaseAdWebViewActivity", "no_url");
            finish();
            return;
        }
        try {
            if (TextUtils.equals("1", Uri.parse(this.tanxc_if).getQueryParameter("hideRightMenu"))) {
                this.tanxc_case = true;
            }
        } catch (Exception e) {
            LogUtils.d("BaseAdWebViewActivity", "onCreate: parse url exception.", e);
        }
        this.tanxc_do = com.alimm.tanx.core.ad.interaction.tanxc_do.tanxc_do().tanxc_do(this.tanxc_if);
        LogUtils.d("BaseAdWebViewActivity", "onCreate: mUrl = " + this.tanxc_if + ", lastUrl = " + this.tanxc_do + ", mHideRightMenu = " + this.tanxc_case);
        setContentView(tanxc_if());
        if (!tanxc_for()) {
            LogUtils.d("BaseAdWebViewActivity", "onCreate: init view failed.");
            return;
        }
        tanxc_do(i);
        tanxc_char();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.show();
            supportActionBar.setDisplayShowHomeEnabled(false);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeAsUpIndicator(R.drawable.tanx_browser_close_selector);
        }
        if (!this.tanxc_case) {
            AdWebViewUtils.setShowAsAction(menu, ActionMenu.more);
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        LogUtils.d("BaseAdWebViewActivity", "onDestroy: mUrl = " + this.tanxc_if);
        OrientationEventListener orientationEventListener = this.tanxc_else;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        tanxc_case();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == ActionMenu.more.id) {
            tanxc_else();
            return true;
        } else if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            tanxc_case();
            finish();
            return true;
        }
    }

    public void onResume() {
        super.onResume();
        LogUtils.d("BaseAdWebViewActivity", "onResume: mUrl = " + this.tanxc_if);
    }

    public void onStart() {
        super.onStart();
        LogUtils.d("BaseAdWebViewActivity", "onStart: mUrl = " + this.tanxc_if);
        tanxc_try();
    }

    public void onStop() {
        super.onStop();
        LogUtils.d("BaseAdWebViewActivity", "onStop: mUrl = " + this.tanxc_if + ", mWebMenuDialog = " + this.tanxc_try);
        tanxc_byte();
        WebMenuDialog webMenuDialog = this.tanxc_try;
        if (webMenuDialog != null && webMenuDialog.isShowing()) {
            LogUtils.d("BaseAdWebViewActivity", "onStop: destroy dialog.");
            this.tanxc_try.dismiss();
            this.tanxc_try = null;
        }
    }

    public abstract void tanxc_byte();

    public abstract void tanxc_case();

    public abstract boolean tanxc_for();

    public abstract int tanxc_if();

    public abstract String tanxc_int();

    public abstract void tanxc_new();

    public abstract void tanxc_try();

    public void tanxc_do() {
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.tanx_browser_progress);
        this.tanxc_int = progressBar;
        progressBar.setVisibility(8);
        try {
            setSupportActionBar((Toolbar) findViewById(R.id.tanx_browser_toolbar));
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.tanx_browser_actionbar_bg));
                supportActionBar.setDisplayShowCustomEnabled(true);
                supportActionBar.setCustomView(View.inflate(this, R.layout.tanx_layout_browser_title, (ViewGroup) null));
                this.tanxc_for = (TextView) findViewById(R.id.tanx_browser_custom_title);
            }
        } catch (Exception e) {
            LogUtils.d("BaseAdWebViewActivity", "setToolbar exception.", e);
        }
    }

    public void tanxc_do(boolean z) {
        getWindow().setFlags(z ? 1024 : 0, 1024);
    }

    public void tanxc_do(int i) {
        if (i != 1) {
            setRequestedOrientation(i);
            this.tanxc_else = new OrientationEventListener(this) {
                public void onOrientationChanged(int i) {
                    tanxc_do tanxc_do2;
                    if (tanxc_do.this.tanxc_goto == -2) {
                        int unused = tanxc_do.this.tanxc_goto = i;
                    }
                    int abs = Math.abs(tanxc_do.this.tanxc_goto - i);
                    if (abs > 180) {
                        abs = 360 - abs;
                    }
                    if (abs > 60 && (tanxc_do2 = tanxc_do.this) != null) {
                        tanxc_do2.setRequestedOrientation(10);
                        disable();
                    }
                }
            };
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if (tanxc_do.this.tanxc_else != null) {
                        tanxc_do.this.tanxc_else.enable();
                    }
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }
}
