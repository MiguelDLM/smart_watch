package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;

/* loaded from: classes11.dex */
public class KsLogoView extends LinearLayout {
    private boolean acX;
    TextView acY;
    ImageView acZ;
    private a ada;
    private SimpleImageLoadingListener ez;

    /* loaded from: classes11.dex */
    public interface a {
        void kd();
    }

    public KsLogoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static Bitmap a(KsLogoView ksLogoView) {
        int i;
        int i2;
        TextView textView = ksLogoView.getTextView();
        TextPaint paint = textView.getPaint();
        if (ksLogoView.getVisibility() == 0 && textView.getText() != null && textView.getText().length() > 0) {
            i = ((int) Math.ceil(paint.measureText(textView.getText().toString()))) + textView.getPaddingLeft() + textView.getPaddingRight();
        } else {
            i = 0;
        }
        if (ksLogoView.getIcon().getVisibility() == 0) {
            i2 = com.kwad.sdk.c.a.a.a(ksLogoView.getContext(), 18.0f);
        } else {
            i2 = 0;
        }
        int i3 = i + i2;
        int a2 = com.kwad.sdk.c.a.a.a(ksLogoView.getContext(), 16.0f);
        ksLogoView.measure(i3, a2);
        ksLogoView.layout(0, 0, i3, a2);
        Bitmap createBitmap = Bitmap.createBitmap(ksLogoView.getWidth(), ksLogoView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        ksLogoView.draw(canvas);
        return createBitmap;
    }

    private void init() {
        boolean z;
        l.inflate(getContext(), R.layout.ksad_logo_layout, this);
        this.acY = (TextView) findViewById(R.id.ksad_logo_text);
        this.acZ = (ImageView) findViewById(R.id.ksad_logo_icon);
        if (getBackground() == null) {
            z = true;
        } else {
            z = false;
        }
        this.acX = z;
        if (z) {
            this.acZ.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_gray));
            this.acY.setTextColor(-6513508);
        } else {
            this.acZ.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_white));
            this.acY.setTextColor(-1711276033);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tW() {
        int i;
        Resources resources = getContext().getResources();
        if (this.acX) {
            i = R.drawable.ksad_logo_gray;
        } else {
            i = R.drawable.ksad_logo_white;
        }
        this.acZ.setImageDrawable(resources.getDrawable(i));
    }

    public final void aE(AdTemplate adTemplate) {
        String str;
        View findViewById = findViewById(R.id.ksad_logo_container);
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        if (this.acX) {
            str = dS.adBaseInfo.adGrayMarkIcon;
        } else {
            str = dS.adBaseInfo.adMarkIcon;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(dS.adBaseInfo.adSourceDescription)) {
            this.acY.setVisibility(0);
            this.acY.setText(com.kwad.sdk.core.response.b.a.aC(dS));
            this.acZ.setVisibility(0);
            tW();
            a aVar = this.ada;
            if (aVar != null) {
                aVar.kd();
            }
        } else {
            if (!TextUtils.isEmpty(dS.adBaseInfo.adSourceDescription)) {
                this.acY.setText(com.kwad.sdk.core.response.b.a.aC(dS));
                this.acY.setVisibility(0);
            } else {
                this.acY.setVisibility(8);
                this.acY.setText("");
            }
            if (!TextUtils.isEmpty(str)) {
                KSImageLoader.loadFeeImage(this.acZ, str, adTemplate, this.ez);
                this.acZ.setVisibility(0);
            } else {
                this.acZ.setVisibility(8);
                this.acZ.setImageDrawable(null);
                a aVar2 = this.ada;
                if (aVar2 != null) {
                    aVar2.kd();
                }
            }
        }
        findViewById.setVisibility(0);
    }

    public ImageView getIcon() {
        return this.acZ;
    }

    public TextView getTextView() {
        return this.acY;
    }

    public void setLogoLoadFinishListener(a aVar) {
        this.ada = aVar;
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(l.wrapContextIfNeed(context), attributeSet, i);
        this.ez = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.ada != null) {
                    KsLogoView.this.ada.kd();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.tW();
                if (KsLogoView.this.ada != null) {
                    KsLogoView.this.ada.kd();
                }
            }
        };
        init();
    }

    public KsLogoView(Context context, boolean z) {
        super(l.wrapContextIfNeed(context));
        this.ez = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.ada != null) {
                    KsLogoView.this.ada.kd();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.tW();
                if (KsLogoView.this.ada != null) {
                    KsLogoView.this.ada.kd();
                }
            }
        };
        if (z) {
            setBackground(getResources().getDrawable(R.drawable.ksad_splash_logo_bg));
        }
        init();
    }
}
