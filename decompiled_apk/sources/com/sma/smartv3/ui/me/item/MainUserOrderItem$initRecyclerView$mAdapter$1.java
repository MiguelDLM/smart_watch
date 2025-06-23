package com.sma.smartv3.ui.me.item;

import OXOo.OOXIXo;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bumptech.glide.Glide;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.VipBenefit;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes11.dex */
public final class MainUserOrderItem$initRecyclerView$mAdapter$1 extends CommonAdapter<VipBenefit> {
    final /* synthetic */ MainUserOrderItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainUserOrderItem$initRecyclerView$mAdapter$1(MainUserOrderItem mainUserOrderItem, Context context, List<VipBenefit> list) {
        super(context, R.layout.item_horizontal_vip_class, list);
        this.this$0 = mainUserOrderItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(MainUserOrderItem this$0, MainUserOrderItem$initRecyclerView$mAdapter$1 this$1, VipBenefit item, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(this$1, "this$1");
        IIX0o.x0xO0oo(item, "$item");
        Context mContext = ((CommonAdapter) this$1).mContext;
        IIX0o.oO(mContext, "mContext");
        this$0.toVipBenefitIntent(mContext, item.getType());
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OOXIXo ViewHolder viewHolder, @OOXIXo final VipBenefit item, int i) {
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        IIX0o.x0xO0oo(item, "item");
        viewHolder.setText(R.id.item_dial_class_tv, item.getTitle());
        Glide.with(((CommonAdapter) this).mContext).load(Integer.valueOf(item.getIvIcon())).into((ImageView) viewHolder.getView(R.id.item_dial_class_iv));
        final MainUserOrderItem mainUserOrderItem = this.this$0;
        viewHolder.setOnClickListener(R.id.item_dial_class_ll, new View.OnClickListener() { // from class: com.sma.smartv3.ui.me.item.X0o0xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainUserOrderItem$initRecyclerView$mAdapter$1.convert$lambda$0(MainUserOrderItem.this, this, item, view);
            }
        });
    }
}
