package com.bestmafen.androidbase.dsl;

import OXOo.OOXIXo;
import Oox.x0xO0oo;
import XO0.II0xO0;
import androidx.annotation.CallSuper;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes8.dex */
public abstract class BaseDslItem extends DslAdapterItem {
    private final boolean initEvent;

    public BaseDslItem() {
        setItemLayoutId(layoutId());
        setItemViewAttachedToWindow(new x0xO0oo<DslViewHolder, Integer, oXIO0o0XI>() { // from class: com.bestmafen.androidbase.dsl.BaseDslItem.1
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num) {
                invoke(dslViewHolder, num.intValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(@OOXIXo DslViewHolder itemHolder, int i) {
                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                BaseDslItem.super.onItemViewAttachedToWindow(itemHolder, i);
                BaseDslItem.this.onAttach(itemHolder, i);
            }
        });
        setItemViewDetachedToWindow(new x0xO0oo<DslViewHolder, Integer, oXIO0o0XI>() { // from class: com.bestmafen.androidbase.dsl.BaseDslItem.2
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num) {
                invoke(dslViewHolder, num.intValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(@OOXIXo DslViewHolder itemHolder, int i) {
                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                BaseDslItem.super.onItemViewDetachedToWindow(itemHolder, i);
                BaseDslItem.this.onDetach(itemHolder, i);
            }
        });
    }

    public abstract void bindView(@OOXIXo DslViewHolder dslViewHolder);

    public boolean getInitEvent() {
        return this.initEvent;
    }

    public abstract void initView();

    public abstract int layoutId();

    @CallSuper
    public void onAttach(@OOXIXo DslViewHolder itemHolder, int i) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        try {
            initView();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getInitEvent()) {
            II0xO0.oxoX().x0XOIxOo(this);
        }
    }

    public void onDetach(@OOXIXo DslViewHolder itemHolder, int i) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        if (getInitEvent()) {
            II0xO0.oxoX().IIXOooo(this);
        }
    }

    @Override // com.angcyo.dsladapter.DslAdapterItem
    @CallSuper
    public void onItemBind(@OOXIXo DslViewHolder itemHolder, int i, @OOXIXo DslAdapterItem adapterItem) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        IIX0o.x0xO0oo(adapterItem, "adapterItem");
        super.onItemBind(itemHolder, i, adapterItem);
        bindView(itemHolder);
    }
}
