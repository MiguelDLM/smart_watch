package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class BNAudioPlayView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private AnimationDrawable f9098a;
    private Drawable b;
    private boolean c;

    public BNAudioPlayView(Context context) {
        super(context);
    }

    public void a(boolean z) {
        this.f9098a = (AnimationDrawable) b.c(R.drawable.nsdk_rg_audio_play_animation, z);
        Drawable f = b.f(R.drawable.nsdk_drawable_audio_play);
        this.b = f;
        if (this.c) {
            setImageDrawable(this.f9098a);
            this.f9098a.start();
        } else {
            setImageDrawable(f);
        }
    }

    public void b() {
        if (this.c) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("scenic_broadcast", "v play ");
        }
        this.c = true;
        if (this.f9098a == null) {
            this.f9098a = (AnimationDrawable) b.f(R.drawable.nsdk_rg_audio_play_animation);
        }
        setImageDrawable(this.f9098a);
        this.f9098a.start();
    }

    public void c() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("scenic_broadcast", "v stop ");
        }
        this.c = false;
        AnimationDrawable animationDrawable = this.f9098a;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        if (this.b == null) {
            this.b = b.f(R.drawable.nsdk_drawable_audio_play);
        }
        setImageDrawable(this.b);
    }

    public BNAudioPlayView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BNAudioPlayView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a() {
        AnimationDrawable animationDrawable = this.f9098a;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.f9098a.setCallback(null);
            this.f9098a = null;
        }
        this.b = null;
        setImageDrawable(null);
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }
}
