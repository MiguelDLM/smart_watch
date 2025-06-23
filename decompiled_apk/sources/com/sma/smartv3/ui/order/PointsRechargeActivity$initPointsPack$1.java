package com.sma.smartv3.ui.order;

import OXOo.OOXIXo;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.PointsPack;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import oIxOXo.oxoX;

/* loaded from: classes11.dex */
public final class PointsRechargeActivity$initPointsPack$1 extends CommonAdapter<PointsPack> {
    final /* synthetic */ PointsRechargeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointsRechargeActivity$initPointsPack$1(PointsRechargeActivity pointsRechargeActivity, List<PointsPack> list) {
        super(pointsRechargeActivity, R.layout.item_points_pack_select, list);
        this.this$0 = pointsRechargeActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$1(PointsRechargeActivity$initPointsPack$1 this$0, PointsPack item, PointsRechargeActivity this$1, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(item, "$item");
        IIX0o.x0xO0oo(this$1, "this$1");
        Iterator it = ((CommonAdapter) this$0).mDatas.iterator();
        while (it.hasNext()) {
            ((PointsPack) it.next()).setSelect(false);
        }
        item.setSelect(true);
        this$1.mSelectPointsPack = item;
        this$0.notifyDataSetChanged();
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OOXIXo ViewHolder holder, @OOXIXo final PointsPack item, int i) {
        Drawable Oxx0IOOO2;
        IIX0o.x0xO0oo(holder, "holder");
        IIX0o.x0xO0oo(item, "item");
        View view = holder.getView(R.id.selectStatusAmount);
        if (item.isSelect()) {
            Oxx0IOOO2 = oxoX.Oxx0IOOO(this.this$0, R.drawable.rectangular_background_select);
        } else {
            Oxx0IOOO2 = oxoX.Oxx0IOOO(this.this$0, R.drawable.rectangular_background);
        }
        view.setBackgroundDrawable(Oxx0IOOO2);
        holder.getView(R.id.recommendStatus).setVisibility(item.getRecommend() ? 0 : 4);
        ((TextView) holder.getView(R.id.tv_pack_name)).setText(item.getPackName());
        TextView textView = (TextView) holder.getView(R.id.tv_original_amount);
        StringBuilder sb = new StringBuilder();
        sb.append((char) 65509);
        sb.append(item.getOriginalAmount());
        textView.setText(sb.toString());
        textView.getPaint().setFlags(17);
        TextView textView2 = (TextView) holder.getView(R.id.tv_amount);
        StringBuilder sb2 = new StringBuilder();
        sb2.append((char) 65509);
        sb2.append(item.getAmount());
        textView2.setText(sb2.toString());
        View view2 = holder.getView(R.id.selectStatusAmount);
        final PointsRechargeActivity pointsRechargeActivity = this.this$0;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.order.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PointsRechargeActivity$initPointsPack$1.convert$lambda$1(PointsRechargeActivity$initPointsPack$1.this, item, pointsRechargeActivity, view3);
            }
        });
    }
}
