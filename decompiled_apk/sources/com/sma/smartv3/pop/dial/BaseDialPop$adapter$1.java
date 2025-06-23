package com.sma.smartv3.pop.dial;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ResourcesIdInfo;
import com.sma.smartv3.util.OOXIXo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class BaseDialPop$adapter$1 extends CommonAdapter<ResourcesIdInfo> {
    final /* synthetic */ OOXIXo<Integer> $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDialPop$adapter$1(Activity activity, List<ResourcesIdInfo> list, OOXIXo<Integer> oOXIXo) {
        super(activity, R.layout.item_color_select, list);
        this.$callback = oOXIXo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(BaseDialPop$adapter$1 this$0, ResourcesIdInfo resourcesIdInfo, OOXIXo callback, int i, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(resourcesIdInfo, "$resourcesIdInfo");
        IIX0o.x0xO0oo(callback, "$callback");
        Iterator it = ((CommonAdapter) this$0).mDatas.iterator();
        while (it.hasNext()) {
            ((ResourcesIdInfo) it.next()).setSelect(false);
        }
        resourcesIdInfo.setSelect(true);
        callback.oIX0oI(Integer.valueOf(i));
        this$0.notifyDataSetChanged();
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo final ResourcesIdInfo resourcesIdInfo, final int i) {
        IIX0o.x0xO0oo(holder, "holder");
        IIX0o.x0xO0oo(resourcesIdInfo, "resourcesIdInfo");
        ((ImageView) holder.getView(R.id.colorIv)).setImageResource(resourcesIdInfo.getResId());
        ((ImageView) holder.getView(R.id.selectStatus)).setVisibility(resourcesIdInfo.isSelect() ? 0 : 8);
        RelativeLayout relativeLayout = (RelativeLayout) holder.getView(R.id.rv);
        final OOXIXo<Integer> oOXIXo = this.$callback;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.dial.oIX0oI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseDialPop$adapter$1.convert$lambda$0(BaseDialPop$adapter$1.this, resourcesIdInfo, oOXIXo, i, view);
            }
        });
    }
}
