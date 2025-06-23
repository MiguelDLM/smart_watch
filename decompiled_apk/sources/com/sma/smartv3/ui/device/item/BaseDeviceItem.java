package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public abstract class BaseDeviceItem extends BaseDslItem {

    @oOoXoXO
    private ImageView iv;

    @oOoXoXO
    private TextView tvLeft;

    @oOoXoXO
    private TextView tvRight;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    @CallSuper
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        this.iv = (ImageView) itemHolder.v(R.id.iv);
        this.tvLeft = (TextView) itemHolder.v(R.id.tv_left);
        this.tvRight = (TextView) itemHolder.v(R.id.tv_right);
    }

    @oOoXoXO
    public final ImageView getIv() {
        return this.iv;
    }

    @oOoXoXO
    public final TextView getTvLeft() {
        return this.tvLeft;
    }

    @oOoXoXO
    public final TextView getTvRight() {
        return this.tvRight;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void onDetach(@OOXIXo DslViewHolder itemHolder, int i) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
    }

    public final void setIv(@oOoXoXO ImageView imageView) {
        this.iv = imageView;
    }

    public final void setTvLeft(@oOoXoXO TextView textView) {
        this.tvLeft = textView;
    }

    public final void setTvRight(@oOoXoXO TextView textView) {
        this.tvRight = textView;
    }
}
