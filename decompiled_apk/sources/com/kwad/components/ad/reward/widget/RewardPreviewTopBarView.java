package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes11.dex */
public class RewardPreviewTopBarView extends KSFrameLayout implements View.OnClickListener {
    private String Bi;
    private String Bj;
    private ProgressBar Bk;
    private TextView Bl;
    private ImageView Bm;
    private long Bn;
    private long Bo;
    private boolean Bp;
    private a Bq;
    private TextView sB;

    /* loaded from: classes11.dex */
    public interface a {
        void F(boolean z);

        void G(boolean z);
    }

    public RewardPreviewTopBarView(@NonNull Context context) {
        super(context);
        this.Bi = " 秒后即可获得奖励";
        this.Bj = "恭喜你获得奖励";
        this.Bn = -1L;
        this.Bp = false;
    }

    @MainThread
    private void e(boolean z, boolean z2) {
        if (!this.Bp) {
            this.sB.setVisibility(8);
            this.Bl.setText(this.Bj);
            a aVar = this.Bq;
            if (aVar != null) {
                aVar.G(false);
            }
        } else {
            this.sB.setVisibility(0);
        }
        this.Bp = true;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super.init(context, attributeSet);
        View.inflate(getContext(), R.layout.ksad_activity_preview_topbar, this);
        this.Bk = (ProgressBar) findViewById(R.id.ksad_preview_topbar_progress);
        this.sB = (TextView) findViewById(R.id.ksad_preview_topbar_reward_tips);
        this.Bl = (TextView) findViewById(R.id.ksad_preview_topbar_reward_count);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_preview_topbar_close);
        this.Bm = imageView;
        imageView.setVisibility(8);
        this.Bm.setOnClickListener(this);
    }

    public final boolean kf() {
        return this.Bp;
    }

    @MainThread
    public final void n(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        TextView textView = this.Bl;
        if (textView != null) {
            textView.setText(ceil + this.Bi);
        }
        e(j, this.Bn);
        if (this.Bn - j >= this.Bo && this.Bm.getVisibility() != 0) {
            this.Bm.setVisibility(0);
        }
        if (ceil <= 0) {
            e(true, false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (view.equals(this.Bm) && (aVar = this.Bq) != null) {
            aVar.F(this.Bp);
        }
    }

    @MainThread
    public void setCloseBtnDelayShowDuration(long j) {
        this.Bo = j;
        if (j <= 0) {
            this.Bm.setVisibility(0);
        }
    }

    @MainThread
    public void setRewardTips(String str) {
        TextView textView = this.sB;
        if (textView != null && str != null) {
            textView.setText(str);
        }
    }

    public void setTopBarListener(a aVar) {
        this.Bq = aVar;
    }

    @MainThread
    public void setTotalCountDuration(long j) {
        this.Bn = j;
        this.Bk.setMax((int) j);
    }

    public RewardPreviewTopBarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bi = " 秒后即可获得奖励";
        this.Bj = "恭喜你获得奖励";
        this.Bn = -1L;
        this.Bp = false;
    }

    @MainThread
    private void e(long j, long j2) {
        this.Bk.setProgress((int) (j2 - j));
    }

    public RewardPreviewTopBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Bi = " 秒后即可获得奖励";
        this.Bj = "恭喜你获得奖励";
        this.Bn = -1L;
        this.Bp = false;
    }
}
