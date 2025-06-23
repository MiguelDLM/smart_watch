package com.baidu.navisdk.ugc.eventdetails.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.j;
import com.baidu.navisdk.util.jar.JarUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;

/* loaded from: classes8.dex */
public class VideoWidget extends FrameLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f8082a;
    private ImageView b;
    private String c;
    private a d;
    private int e;

    /* loaded from: classes8.dex */
    public interface a {
        void a(String str, int i);
    }

    public VideoWidget(Context context) {
        super(context);
        this.e = 1;
        a(context);
    }

    private void a(Context context) {
        JarUtils.inflate(context, R.layout.nsdk_layout_ugc_detail_video_info, this);
        this.f8082a = (ImageView) findViewById(R.id.iv_ugc_detail_video_cover);
        this.b = (ImageView) findViewById(R.id.iv_ugc_detail_video_play_btn);
        if (j.d()) {
            this.b.setOnClickListener(this);
        } else {
            this.b.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(this.c, this.e);
        }
    }

    public void setClickPlayVideoListener(a aVar) {
        this.d = aVar;
    }

    public void setFrom(int i) {
        this.e = i;
        if (i == 1) {
            int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_30dp);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            } else {
                layoutParams.height = dimensionPixelSize;
                layoutParams.width = dimensionPixelSize;
            }
            this.b.setLayoutParams(layoutParams);
        }
    }

    public VideoWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 1;
        a(context);
    }

    public VideoWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 1;
        a(context);
    }

    public void a(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            a();
            return;
        }
        setVisibility(0);
        this.c = str2;
        a(str);
        this.b.setEnabled(true);
    }

    public void a() {
        this.b.setEnabled(false);
        setVisibility(8);
        this.f8082a.setImageDrawable(null);
    }

    private void a(String str) {
        RequestBuilder<Drawable> load = Glide.with(getContext()).load(str);
        int i = R.drawable.nsdk_rc_img_default_bg;
        load.error(i).fallback(i).into(this.f8082a);
    }
}
