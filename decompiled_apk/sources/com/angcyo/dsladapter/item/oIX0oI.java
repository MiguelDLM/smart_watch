package com.angcyo.dsladapter.item;

import OXOo.OOXIXo;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslAdapterItemExKt;
import com.angcyo.dsladapter.DslViewHolder;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public interface oIX0oI {

    /* renamed from: com.angcyo.dsladapter.item.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0113oIX0oI {
        public static boolean II0xO0(@OOXIXo oIX0oI oix0oi, @OOXIXo DslAdapterItem item) {
            IIX0o.x0xO0oo(item, "item");
            return DslAdapterItemExKt.XI0IXoo(item);
        }

        public static void oIX0oI(@OOXIXo oIX0oI oix0oi, @OOXIXo DslViewHolder itemHolder, int i, @OOXIXo DslAdapterItem adapterItem, @OOXIXo List<? extends Object> payloads) {
            IIX0o.x0xO0oo(itemHolder, "itemHolder");
            IIX0o.x0xO0oo(adapterItem, "adapterItem");
            IIX0o.x0xO0oo(payloads, "payloads");
        }
    }

    boolean I0Io(@OOXIXo DslAdapterItem dslAdapterItem);

    void oIX0oI(@OOXIXo DslViewHolder dslViewHolder, int i, @OOXIXo DslAdapterItem dslAdapterItem, @OOXIXo List<? extends Object> list);
}
