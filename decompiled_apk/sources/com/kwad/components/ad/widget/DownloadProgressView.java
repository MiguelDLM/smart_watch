package com.kwad.components.ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;

/* loaded from: classes11.dex */
public class DownloadProgressView extends FrameLayout {
    private int IA;
    private Drawable IB;
    private Drawable IC;
    private String ID;
    protected TextView Iw;

    @ColorInt
    private int Ix;

    @ColorInt
    private int Iy;

    @ColorInt
    private int Iz;
    private final KsAppDownloadListener cx;
    protected TextProgressBar dh;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;

    public DownloadProgressView(@NonNull Context context) {
        this(context, null);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void initAttrs(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_DownloadProgressView);
        this.Ix = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadTextColor, -117146);
        this.Iy = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadLeftTextColor, -1);
        this.Iz = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadRightTextColor, -117146);
        this.IA = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DownloadProgressView_ksad_downloadTextSize, com.kwad.sdk.c.a.a.a(getContext(), 11.0f));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_progressDrawable);
        this.IB = drawable;
        if (drawable == null) {
            this.IB = getResources().getDrawable(R.drawable.ksad_feed_download_progress);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_backgroundDrawable);
        this.IC = drawable2;
        if (drawable2 == null) {
            this.IC = getResources().getDrawable(R.drawable.ksad_feed_app_download_before_bg);
        }
        String string = obtainStyledAttributes.getString(R.styleable.ksad_DownloadProgressView_ksad_downloadingFormat);
        this.ID = string;
        if (string == null) {
            this.ID = "下载中  %s%%";
        }
        obtainStyledAttributes.recycle();
    }

    private void initView() {
        l.inflate(getContext(), R.layout.ksad_download_progress_layout, this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_progress_bar);
        this.dh = textProgressBar;
        textProgressBar.setTextDimen(this.IA);
        this.dh.setTextColor(this.Iy, this.Iz);
        this.dh.setProgressDrawable(this.IB);
        TextView textView = (TextView) findViewById(R.id.ksad_normal_text);
        this.Iw = textView;
        textView.setTextColor(this.Ix);
        this.Iw.setTextSize(0, this.IA);
        this.Iw.setVisibility(0);
        this.Iw.setBackground(this.IC);
        findViewById(R.id.ksad_foreground_cover).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.widget.DownloadProgressView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    public final void aj(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo dS = e.dS(adTemplate);
        this.mAdInfo = dS;
        this.Iw.setText(com.kwad.sdk.core.response.b.a.aD(dS));
        this.dh.setVisibility(8);
        this.Iw.setVisibility(0);
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.cx;
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(l.wrapContextIfNeed(context), attributeSet, i);
        this.cx = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.widget.DownloadProgressView.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.Iw.setText(com.kwad.sdk.core.response.b.a.aD(downloadProgressView.mAdInfo));
                DownloadProgressView.this.Iw.setVisibility(0);
                DownloadProgressView.this.dh.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DownloadProgressView.this.Iw.setVisibility(8);
                DownloadProgressView.this.dh.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.dh.e(com.kwad.sdk.core.response.b.a.ca(downloadProgressView.mAdTemplate), DownloadProgressView.this.dh.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.Iw.setText(com.kwad.sdk.core.response.b.a.aD(downloadProgressView.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DownloadProgressView.this.Iw.setVisibility(8);
                DownloadProgressView.this.dh.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.dh.e(com.kwad.sdk.core.response.b.a.ab(downloadProgressView.mAdInfo), DownloadProgressView.this.dh.getMax());
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i2) {
                DownloadProgressView.this.Iw.setVisibility(8);
                DownloadProgressView.this.dh.setVisibility(0);
                DownloadProgressView.this.dh.e(com.kwad.sdk.core.response.b.a.FQ(), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                DownloadProgressView.this.Iw.setVisibility(8);
                DownloadProgressView.this.dh.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.dh.e(com.kwad.sdk.core.response.b.a.s(i2, downloadProgressView.ID), i2);
            }
        };
        initAttrs(context, attributeSet);
        initView();
    }
}
