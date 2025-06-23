package com.kwad.components.ad.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.c.a.a;
import com.kwad.sdk.n.l;

/* loaded from: classes11.dex */
public class DrawDownloadProgressBar extends FrameLayout {
    private TextProgressBar dh;
    private View di;
    private Context mContext;

    public DrawDownloadProgressBar(@NonNull Context context) {
        super(context);
        A(context);
    }

    private void A(Context context) {
        this.mContext = context;
        l.inflate(context, R.layout.ksad_draw_download_bar, this);
        this.dh = (TextProgressBar) findViewById(R.id.ksad_download_progress);
        View findViewById = findViewById(R.id.ksad_download_progress_cover);
        this.di = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.draw.view.DrawDownloadProgressBar.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    public final void e(String str, int i) {
        if (i != 0 && i != getMax()) {
            this.di.setVisibility(8);
        } else {
            this.di.setVisibility(0);
        }
        this.dh.e(str, i);
    }

    public int getMax() {
        return this.dh.getMax();
    }

    public void setTextColor(int i) {
        this.dh.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.dh.setTextDimen(a.a(getContext(), i));
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        A(context);
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        A(context);
    }
}
