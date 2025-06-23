package com.baidu.navisdk.ui.routeguide.module.diyspeak;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class i extends Dialog implements View.OnClickListener, DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    private TextView f9015a;
    private TextView b;
    private String c;
    private boolean d;
    private TTSPlayerControl.c e;
    TTSPlayerControl.e f;

    /* loaded from: classes8.dex */
    public class a implements TTSPlayerControl.c {
        public a() {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.c
        public boolean a(String str, String str2) {
            if (!TextUtils.equals(str2, "BNDiySpeakPreviewId") && i.this.d) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("TTS", "diy_speak_is_playing, return");
                    return true;
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends TTSPlayerControl.f {
        public b() {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void a(String str) {
            if ("BNDiySpeakPreviewId".equals(str)) {
                i.this.d = true;
            }
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void onPlayEnd(String str) {
            if ("BNDiySpeakPreviewId".equals(str)) {
                i.this.b();
            }
        }
    }

    public i(Activity activity) {
        super(activity, R.style.BNDialog);
        this.c = null;
        this.d = false;
        this.e = new a();
        this.f = new b();
        FrameLayout frameLayout = new FrameLayout(activity);
        LinearLayout linearLayout = new LinearLayout(activity);
        frameLayout.addView(linearLayout);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_276dp), -2));
        linearLayout.setBackgroundResource(R.drawable.nsdk_drawable_route_result_white_round_corner_bg);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        int d = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_24dp);
        linearLayout.setPadding(d, d, d, d);
        linearLayout.setMinimumHeight(com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_140dp));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        TextView textView = new TextView(activity);
        this.f9015a = textView;
        textView.setLayoutParams(layoutParams);
        this.f9015a.setTextColor(JarUtils.getResources().getColor(R.color.bnav_newer_guide_dialog));
        this.f9015a.setTextSize(0, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_20dp));
        linearLayout.addView(this.f9015a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_180dp), com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_36dp));
        layoutParams2.topMargin = d;
        TextView textView2 = new TextView(activity);
        this.b = textView2;
        textView2.setLayoutParams(layoutParams2);
        int d2 = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_4dp);
        this.b.setPadding(d2, d2, d2, d2);
        this.b.setBackgroundDrawable(JarUtils.getResources().getDrawable(R.drawable.bnav_image_checkbox_dialog_button_selector));
        this.b.setGravity(17);
        this.b.setTextColor(-1);
        this.b.setTextSize(0, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_16dp));
        this.b.setText("点击试听");
        linearLayout.addView(this.b);
        this.b.setOnClickListener(this);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        try {
            setContentView(frameLayout);
            setOnDismissListener(this);
        } catch (Throwable unused) {
        }
    }

    private void c() {
        this.b.setText("试听中");
        this.b.setEnabled(false);
        TTSPlayerControl.addTTSBreakListener(this.e);
        TTSPlayerControl.playXDTTSTextForResult(this.c, 1, "BNDiySpeakPreviewId");
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TTSPlayerControl.stopVoiceTTSOutput();
        if (!this.d) {
            c();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.d) {
            TTSPlayerControl.stopVoiceTTSOutput();
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.d = false;
        this.b.setText("点击试听");
        this.b.setEnabled(true);
        e.f.b.a(false);
        TTSPlayerControl.removeTTSBreakListener(this.e);
        TTSPlayerControl.removeTTSPlayStateListener(this.f);
    }

    public void a(String str) {
        this.c = str;
        this.f9015a.setText(str);
    }

    private void a() {
        TTSPlayerControl.addTTSPlayStateListener(this.f);
    }
}
