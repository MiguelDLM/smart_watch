package com.baidu.navisdk.ui.widget.expandlayout;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public interface IExpandItemOnClickListener {

    /* loaded from: classes8.dex */
    public static final class DefaultImpls {
        public static boolean onClickTopFixedItem(@OOXIXo IExpandItemOnClickListener iExpandItemOnClickListener, @OOXIXo View view) {
            IIX0o.x0xO0oo(view, "view");
            return false;
        }
    }

    void onClickBottomFixedItem(@oOoXoXO String str, @OOXIXo View view);

    void onClickDynamicItem(@oOoXoXO String str, @OOXIXo View view);

    boolean onClickTopFixedItem(@OOXIXo View view);
}
