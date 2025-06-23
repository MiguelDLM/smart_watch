package com.sma.smartv3.ui.status;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.PaceProgressBar;
import com.sma.smartv3.view.text.DINCondBold;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class SportRecordDetailSpeedViewHolder extends RecyclerView.ViewHolder {

    @OXOo.OOXIXo
    private final DINCondBold number;

    @OXOo.OOXIXo
    private final PaceProgressBar pb;

    @OXOo.OOXIXo
    private final DINCondBold tvPace;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SportRecordDetailSpeedViewHolder(@OXOo.OOXIXo View view) {
        super(view);
        IIX0o.x0xO0oo(view, "view");
        View findViewById = view.findViewById(R.id.number);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.number = (DINCondBold) findViewById;
        View findViewById2 = view.findViewById(R.id.pb);
        IIX0o.oO(findViewById2, "findViewById(...)");
        this.pb = (PaceProgressBar) findViewById2;
        View findViewById3 = view.findViewById(R.id.tvPace);
        IIX0o.oO(findViewById3, "findViewById(...)");
        this.tvPace = (DINCondBold) findViewById3;
    }

    @OXOo.OOXIXo
    public final DINCondBold getNumber() {
        return this.number;
    }

    @OXOo.OOXIXo
    public final PaceProgressBar getPb() {
        return this.pb;
    }

    @OXOo.OOXIXo
    public final DINCondBold getTvPace() {
        return this.tvPace;
    }
}
