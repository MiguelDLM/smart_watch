package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.text.DINCondBold;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class LevelItemViewHolder extends RecyclerView.ViewHolder {

    @OOXIXo
    private final ImageView iv;

    @OOXIXo
    private final LinearLayout llLevelPanel;

    @OOXIXo
    private final DINCondBold tv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LevelItemViewHolder(@OOXIXo View view) {
        super(view);
        IIX0o.x0xO0oo(view, "view");
        View findViewById = view.findViewById(R.id.tv);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.tv = (DINCondBold) findViewById;
        View findViewById2 = view.findViewById(R.id.iv);
        IIX0o.oO(findViewById2, "findViewById(...)");
        this.iv = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.llLevelPanel);
        IIX0o.oO(findViewById3, "findViewById(...)");
        this.llLevelPanel = (LinearLayout) findViewById3;
    }

    @OOXIXo
    public final ImageView getIv() {
        return this.iv;
    }

    @OOXIXo
    public final LinearLayout getLlLevelPanel() {
        return this.llLevelPanel;
    }

    @OOXIXo
    public final DINCondBold getTv() {
        return this.tv;
    }
}
