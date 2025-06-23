package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Size;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class BNImageView extends AppCompatImageView {
    private static final String TAG = "BNImageView";
    private int paddingH;
    private int paddingV;

    public BNImageView(@NonNull Context context) {
        this(context, null);
    }

    private void init(Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNImageView);
        try {
            try {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BNImageView_android_layout_width, 0);
                int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BNImageView_android_layout_height, 0);
                int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BNImageView_nsdk_src_width, 0);
                int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BNImageView_nsdk_src_height, 0);
                g gVar = g.COMMON_UI;
                if (gVar.d()) {
                    gVar.e(TAG, "init: " + dimensionPixelSize + "," + dimensionPixelSize2);
                }
                changeSize(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
                obtainStyledAttributes.recycle();
            } catch (Exception e) {
                g gVar2 = g.PRO_NAV;
                if (gVar2.c()) {
                    gVar2.c(TAG, "init: " + e);
                }
                obtainStyledAttributes.recycle();
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void changeSize(Size size, Size size2) {
        int i;
        int i2;
        ViewGroup.LayoutParams layoutParams;
        int i3 = 0;
        if (size == null || (layoutParams = getLayoutParams()) == null) {
            i = 0;
            i2 = 0;
        } else {
            if (layoutParams.width != size.getWidth() || layoutParams.height != size.getHeight()) {
                layoutParams.width = size.getWidth();
                layoutParams.height = size.getHeight();
                i3 = 1;
            }
            int i4 = layoutParams.width;
            i2 = layoutParams.height;
            int i5 = i3;
            i3 = i4;
            i = i5;
        }
        if (((size2 == null || !changeSize(i3, i2, size2.getWidth(), size2.getHeight())) ? i : 1) != 0) {
            requestLayout();
        }
    }

    public void setPadding() {
        int i = this.paddingH;
        int i2 = this.paddingV;
        setPadding(i, i2, i, i2);
    }

    public BNImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BNImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private boolean changeSize(int i, int i2, int i3, int i4) {
        int i5 = (i - i3) / 2;
        this.paddingH = i5;
        int i6 = (i2 - i4) / 2;
        this.paddingV = i6;
        if (i5 < 0 || i6 < 0) {
            return false;
        }
        setPadding(i5, i6, i5, i6);
        return true;
    }
}
