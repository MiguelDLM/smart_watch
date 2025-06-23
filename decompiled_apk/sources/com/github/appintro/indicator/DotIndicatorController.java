package com.github.appintro.indicator;

import OXOo.OOXIXo;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.github.appintro.R;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes9.dex */
public final class DotIndicatorController extends LinearLayout implements IndicatorController {
    private int currentPosition;
    private int selectedIndicatorColor;
    private int slideCount;
    private int unselectedIndicatorColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DotIndicatorController(@OOXIXo Context context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
        this.selectedIndicatorColor = ContextCompat.getColor(context, R.color.appintro_default_selected_color);
        this.unselectedIndicatorColor = ContextCompat.getColor(context, R.color.appintro_default_unselected_color);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public int getSelectedIndicatorColor() {
        return this.selectedIndicatorColor;
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public int getUnselectedIndicatorColor() {
        return this.unselectedIndicatorColor;
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void initialize(int i) {
        this.slideCount = i;
        int i2 = 0;
        while (i2 < i) {
            i2++;
            ImageView imageView = new ImageView(getContext());
            imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_appintro_indicator));
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i == 1) {
                imageView.setVisibility(4);
            }
            addView(imageView, layoutParams);
        }
        selectPosition(0);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    @OOXIXo
    public View newInstance(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 16;
        setLayoutParams(layoutParams);
        setOrientation(0);
        setGravity(17);
        return this;
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void selectPosition(int i) {
        int unselectedIndicatorColor;
        this.currentPosition = i;
        int i2 = this.slideCount;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 + 1;
            if (i3 == i) {
                unselectedIndicatorColor = getSelectedIndicatorColor();
            } else {
                unselectedIndicatorColor = getUnselectedIndicatorColor();
            }
            View childAt = getChildAt(i3);
            if (childAt != null) {
                DrawableCompat.setTint(((ImageView) childAt).getDrawable(), unselectedIndicatorColor);
                i3 = i4;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
        }
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void setSelectedIndicatorColor(int i) {
        this.selectedIndicatorColor = i;
        selectPosition(this.currentPosition);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void setUnselectedIndicatorColor(int i) {
        this.unselectedIndicatorColor = i;
        selectPosition(this.currentPosition);
    }
}
