package com.sma.smartv3.ui.ai.item;

import OXOo.OOXIXo;
import XO0.XO;
import android.widget.TextView;
import com.angcyo.dsladapter.DslViewHolder;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.biz.AIManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.x0xO0oo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class Hot1AIFunctionItem extends AIFunctionItem {
    private final boolean initEvent;
    public TextView title;

    public Hot1AIFunctionItem() {
        super(0, 1, null);
        this.initEvent = true;
    }

    @Override // com.sma.smartv3.ui.ai.item.AIFunctionItem, com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        super.bindView(itemHolder);
        TextView tv = itemHolder.tv(R.id.tv_title);
        IIX0o.ooOOo0oXI(tv);
        setTitle(tv);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @OOXIXo
    public final TextView getTitle() {
        TextView textView = this.title;
        if (textView != null) {
            return textView;
        }
        IIX0o.XOxIOxOx("title");
        return null;
    }

    @Override // com.sma.smartv3.ui.ai.item.AIFunctionItem, com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        super.initView();
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.xox().length() > 0) {
            setTitle(productManager.xox());
        } else {
            setTitle(AIManager.x0XOIxOo(AIManager.f19833oIX0oI, 0, 1, null));
        }
    }

    @Override // com.sma.smartv3.ui.ai.item.AIFunctionItem, com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.ai_item_function_hot1;
    }

    @XO(tag = x0xO0oo.f24572IO)
    public final void onBindStateChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onBindStateChange");
        initView();
    }

    public final void setTitle(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.title = textView;
    }

    @XO(tag = x0xO0oo.f24618Xo0)
    public final void switchAIServe(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        initView();
    }

    public final void setTitle(@OOXIXo String titleStr) {
        IIX0o.x0xO0oo(titleStr, "titleStr");
        getTitle().setText(AIManager.f19833oIX0oI.XOxIOxOx(titleStr));
    }
}
