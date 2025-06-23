package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.widget.ImageView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.UtilsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class GameStoreItem extends BaseDslItem {

    @oOoXoXO
    private ImageView itemGameImg;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        this.itemGameImg = itemHolder.img(R.id.game_store_icon);
    }

    @oOoXoXO
    public final ImageView getItemGameImg() {
        return this.itemGameImg;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        ImageView imageView;
        int i;
        setItemHidden(!ProjectManager.f19822oIX0oI.IoXIXo());
        if (!getItemHidden() && (imageView = this.itemGameImg) != null) {
            IIX0o.ooOOo0oXI(imageView);
            Context context = imageView.getContext();
            IIX0o.oO(context, "getContext(...)");
            if (UtilsKt.X00IoxXI(context)) {
                i = R.drawable.device_game_icon_entrance;
            } else {
                i = R.drawable.device_game_icon_entrance_en;
            }
            ImageView imageView2 = this.itemGameImg;
            IIX0o.ooOOo0oXI(imageView2);
            RequestBuilder<GifDrawable> load = Glide.with(imageView2.getContext()).asGif().load(Integer.valueOf(i));
            ImageView imageView3 = this.itemGameImg;
            IIX0o.ooOOo0oXI(imageView3);
            load.into(imageView3);
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_game_store;
    }

    public final void setItemGameImg(@oOoXoXO ImageView imageView) {
        this.itemGameImg = imageView;
    }
}
