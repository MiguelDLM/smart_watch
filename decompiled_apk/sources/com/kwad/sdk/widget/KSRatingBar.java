package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import java.math.BigDecimal;

/* loaded from: classes11.dex */
public class KSRatingBar extends LinearLayout {
    private boolean aTJ;
    private boolean aTK;
    private int aTL;
    private int aTM;
    private a aTN;
    private float aTO;
    private float aTP;
    private float aTQ;
    private Drawable aTR;
    private Drawable aTS;
    private Drawable aTT;
    private boolean aTU;
    private int y;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = 1;
        this.aTU = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.ksad_reward_apk_stars_divider));
        setShowDividers(2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSRatingBar);
        this.aTT = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starHalf);
        this.aTR = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starEmpty);
        this.aTS = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starFill);
        this.aTO = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageWidth, 60.0f);
        this.aTP = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageHeight, 120.0f);
        this.aTQ = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImagePadding, 15.0f);
        this.aTL = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_totalStarCount, 5);
        this.aTM = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_starCount, 5);
        this.aTJ = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_clickable, true);
        this.aTK = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_halfstart, false);
        for (int i = 0; i < this.aTL; i++) {
            ImageView w = w(context, this.aTU);
            w.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (KSRatingBar.this.aTJ) {
                        if (KSRatingBar.this.aTK) {
                            if (KSRatingBar.this.y % 2 == 0) {
                                KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                            } else {
                                KSRatingBar.this.setStar(r0.indexOfChild(view) + 0.5f);
                            }
                            if (KSRatingBar.this.aTN != null) {
                                if (KSRatingBar.this.y % 2 == 0) {
                                    a unused = KSRatingBar.this.aTN;
                                    KSRatingBar.this.indexOfChild(view);
                                    KSRatingBar.e(KSRatingBar.this);
                                    return;
                                } else {
                                    a unused2 = KSRatingBar.this.aTN;
                                    KSRatingBar.this.indexOfChild(view);
                                    KSRatingBar.e(KSRatingBar.this);
                                    return;
                                }
                            }
                            return;
                        }
                        KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                        if (KSRatingBar.this.aTN != null) {
                            a unused3 = KSRatingBar.this.aTN;
                            KSRatingBar.this.indexOfChild(view);
                        }
                    }
                }
            });
            addView(w);
        }
        setStar(this.aTM);
    }

    public static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i = kSRatingBar.y;
        kSRatingBar.y = i + 1;
        return i;
    }

    private ImageView w(Context context, boolean z) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.aTO), Math.round(this.aTP)));
        imageView.setPadding(0, 0, Math.round(this.aTQ), 0);
        if (z) {
            imageView.setImageDrawable(this.aTR);
        } else {
            imageView.setImageDrawable(this.aTS);
        }
        return imageView;
    }

    public void setImagePadding(float f) {
        this.aTQ = f;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.aTN = aVar;
    }

    public void setStar(float f) {
        int i = (int) f;
        float floatValue = new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Integer.toString(i))).floatValue();
        int i2 = this.aTL;
        float f2 = i > i2 ? i2 : i;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        for (int i3 = 0; i3 < f2; i3++) {
            ((ImageView) getChildAt(i3)).setImageDrawable(this.aTS);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i)).setImageDrawable(this.aTT);
            int i4 = this.aTL;
            while (true) {
                i4--;
                if (i4 >= 1.0f + f2) {
                    ((ImageView) getChildAt(i4)).setImageDrawable(this.aTR);
                } else {
                    return;
                }
            }
        } else {
            int i5 = this.aTL;
            while (true) {
                i5--;
                if (i5 >= f2) {
                    ((ImageView) getChildAt(i5)).setImageDrawable(this.aTR);
                } else {
                    return;
                }
            }
        }
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.aTR = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.aTS = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.aTT = drawable;
    }

    public void setStarImageHeight(float f) {
        this.aTP = f;
    }

    public void setStarImageWidth(float f) {
        this.aTO = f;
    }

    public void setTotalStarCount(int i) {
        this.aTL = i;
    }

    public void setmClickable(boolean z) {
        this.aTJ = z;
    }
}
