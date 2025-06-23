package com.baidu.navisdk.ui.video;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.o;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.statistic.userop.b;
import com.baidu.navisdk.video.BNCloudVideoView;
import com.baidu.navisdk.video.IVoiceVideoPlayCallback;
import com.google.android.exoplayer2.util.MimeTypes;

/* loaded from: classes8.dex */
public class BNVideoActivity extends Activity implements IVoiceVideoPlayCallback, View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private BNCloudVideoView f9206a;
    private SeekBar b;
    private View c;
    private View d;
    private boolean e;
    private TextView f;
    private String g;
    private a.InterfaceC0201a h = new a();

    /* loaded from: classes8.dex */
    public class a implements a.InterfaceC0201a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f9207a = true;

        public a() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            boolean z;
            if (obj instanceof o) {
                int i = ((o) obj).f6832a;
                g gVar = g.VOICE_PAGE;
                if (gVar.d()) {
                    gVar.e("BNVideoActivity", "NetworkChangeEvent-> " + i);
                }
                if (i != 2 && i != 3) {
                    z = false;
                } else {
                    z = true;
                }
                if (this.f9207a && !z) {
                    if (i == 0) {
                        TipTool.onCreateToastDialog(BNVideoActivity.this, "当前无网络，请检查网络设置");
                    } else {
                        TipTool.onCreateToastDialog(BNVideoActivity.this, "当前为非wifi环境，请注意流量消耗");
                    }
                }
                this.f9207a = z;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.back_btn) {
            finish();
            return;
        }
        if (view.getId() == R.id.videoView) {
            if (this.f9206a.isPlaying()) {
                this.f9206a.pause();
                this.e = true;
            } else {
                this.f9206a.start();
                this.e = false;
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.navisdk.framework.message.a.a().a(this.h, o.class, new Class[0]);
        setContentView(R.layout.nsdk_activity_video);
        findViewById(R.id.back_btn).setOnClickListener(this);
        this.f = (TextView) findViewById(R.id.title_text);
        this.c = findViewById(R.id.iv_loading);
        BNCloudVideoView findViewById = findViewById(R.id.videoView);
        this.f9206a = findViewById;
        findViewById.setVideoPlayCallback(this);
        this.f9206a.setOnClickListener(this);
        this.b = (SeekBar) findViewById(R.id.seekbar);
        this.d = findViewById(R.id.iv_play);
        String stringExtra = getIntent().getStringExtra("url");
        String stringExtra2 = getIntent().getStringExtra("title");
        this.g = getIntent().getStringExtra("comfrom");
        if (!TextUtils.isEmpty(stringExtra2)) {
            this.f.setText(stringExtra2);
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f9206a.setVideoPath(stringExtra);
            this.f9206a.start();
        }
        b.r().a("23.0.1.1364", "1", stringExtra2, this.g);
        if (!z.c(this) && z.a(this)) {
            TipTool.onCreateToastDialog(this, "当前为非wifi网络，请注意流量");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f9206a.release();
        com.baidu.navisdk.framework.message.a.a().a(this.h);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f9206a.pause();
        AudioManager audioManager = (AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.e) {
            this.f9206a.start();
        }
        AudioManager audioManager = (AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager != null) {
            audioManager.requestAudioFocus(null, 3, 2);
        }
    }
}
