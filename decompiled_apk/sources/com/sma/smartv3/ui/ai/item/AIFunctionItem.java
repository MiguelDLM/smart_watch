package com.sma.smartv3.ui.ai.item;

import OXOo.OOXIXo;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.Utils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AIFunction;
import com.sma.smartv3.util.UtilsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import oIxOXo.oxoX;

/* loaded from: classes12.dex */
public class AIFunctionItem extends BaseDslItem {
    private final int type;

    public AIFunctionItem() {
        this(0, 1, null);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        Object itemData = getItemData();
        IIX0o.x0XOIxOo(itemData, "null cannot be cast to non-null type com.sma.smartv3.model.AIFunction");
        AIFunction aIFunction = (AIFunction) itemData;
        View view = itemHolder.itemView;
        if (this.type == 0) {
            view.setBackgroundResource(aIFunction.getBg());
        }
        IIX0o.ooOOo0oXI(view);
        UtilsKt.x0o(view, Utils.getApp().getResources().getDimension(R.dimen.common_item_radius));
        ImageView img = itemHolder.img(R.id.iv);
        if (img != null) {
            img.setImageResource(aIFunction.getIcon());
        }
        TextView tv = itemHolder.tv(R.id.tv_title);
        TextView tv2 = itemHolder.tv(R.id.tv_desc);
        if (tv != null) {
            tv.setText(aIFunction.getTitle());
        }
        if (tv2 != null) {
            tv2.setText(aIFunction.getDesc());
        }
        if (aIFunction.isHot() && this.type == 0) {
            if (tv != null) {
                tv.setTextColor(oxoX.I0Io(itemHolder.getContext(), R.color.white));
            }
            if (tv2 != null) {
                tv2.setTextColor(oxoX.I0Io(itemHolder.getContext(), R.color.white));
                return;
            }
            return;
        }
        if (tv2 != null) {
            tv2.setTextColor(oxoX.I0Io(itemHolder.getContext(), R.color.line_color));
        }
    }

    public final int getType() {
        return this.type;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.ai_item_function;
    }

    public AIFunctionItem(int i) {
        this.type = i;
    }

    public /* synthetic */ AIFunctionItem(int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
