package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* loaded from: classes11.dex */
public class AppScoreView extends LinearLayout {
    private ImageView Iu;
    private ImageView Iv;

    public AppScoreView(Context context) {
        this(context, null);
    }

    private void initView() {
        View.inflate(getContext(), R.layout.ksad_app_score, this);
        this.Iu = (ImageView) findViewById(R.id.ksad_score_fourth);
        this.Iv = (ImageView) findViewById(R.id.ksad_score_fifth);
    }

    public void setScore(float f) {
        double d = f;
        if (d > 4.5d) {
            ImageView imageView = this.Iu;
            int i = R.drawable.ksad_star_checked;
            imageView.setImageResource(i);
            this.Iv.setImageResource(i);
            return;
        }
        if (d > 4.0d) {
            this.Iu.setImageResource(R.drawable.ksad_star_checked);
            this.Iv.setImageResource(R.drawable.ksad_star_half);
            return;
        }
        if (d > 3.5d) {
            this.Iu.setImageResource(R.drawable.ksad_star_checked);
            this.Iv.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d > 3.0d) {
            this.Iu.setImageResource(R.drawable.ksad_star_half);
            this.Iv.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d == 3.0d) {
            ImageView imageView2 = this.Iu;
            int i2 = R.drawable.ksad_star_unchecked;
            imageView2.setImageResource(i2);
            this.Iv.setImageResource(i2);
        }
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
