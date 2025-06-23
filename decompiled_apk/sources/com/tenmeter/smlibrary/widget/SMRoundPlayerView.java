package com.tenmeter.smlibrary.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ui.PlayerView;
import com.tenmeter.smlibrary.R;

/* loaded from: classes13.dex */
public class SMRoundPlayerView extends PlayerView {
    public SMRoundPlayerView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Path path = new Path();
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.sm_sdk_px_15);
        path.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), dimensionPixelSize, dimensionPixelSize, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    public SMRoundPlayerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SMRoundPlayerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
