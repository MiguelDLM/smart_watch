package com.alimm.tanx.core.ad.ad.template.rendering.splash.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Region;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class AdAnimatableImageView extends AppCompatImageView {
    private int tanxc_byte;
    private final Context tanxc_case;
    private final Set<OnAnimationEndListener> tanxc_do;
    private Paint tanxc_for;
    private boolean tanxc_if;
    private int tanxc_int;
    private int tanxc_new;
    private int tanxc_try;

    public interface OnAnimationEndListener {
        void onAnimationEnd();
    }

    public AdAnimatableImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onDraw(Canvas canvas) {
        if (this.tanxc_if) {
            canvas.save();
            canvas.translate(0.0f, (float) this.tanxc_byte);
            canvas.clipRect(0.0f, (float) this.tanxc_new, (float) getRight(), (float) this.tanxc_try, Region.Op.INTERSECT);
            super.onDraw(canvas);
            canvas.restore();
            canvas.drawRect(0.0f, 0.0f, (float) getRight(), (float) (this.tanxc_new + this.tanxc_byte), this.tanxc_for);
            canvas.drawRect(0.0f, (float) (this.tanxc_try + this.tanxc_byte), (float) getRight(), (float) this.tanxc_int, this.tanxc_for);
            return;
        }
        super.onDraw(canvas);
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public AdAnimatableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdAnimatableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tanxc_do = new CopyOnWriteArraySet();
        this.tanxc_if = false;
        this.tanxc_case = context;
    }
}
