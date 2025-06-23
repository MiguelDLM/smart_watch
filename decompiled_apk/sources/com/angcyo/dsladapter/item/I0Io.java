package com.angcyo.dsladapter.item;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.fragment.app.Fragment;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.item.oIX0oI;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public interface I0Io extends com.angcyo.dsladapter.item.oIX0oI {

    /* loaded from: classes7.dex */
    public static final class oIX0oI {
        public static boolean II0xO0(@OOXIXo I0Io i0Io, @OOXIXo DslAdapterItem item) {
            IIX0o.x0xO0oo(item, "item");
            return oIX0oI.C0113oIX0oI.II0xO0(i0Io, item);
        }

        public static void oIX0oI(@OOXIXo I0Io i0Io, @OOXIXo DslViewHolder itemHolder, int i, @OOXIXo DslAdapterItem adapterItem, @OOXIXo List<? extends Object> payloads) {
            IIX0o.x0xO0oo(itemHolder, "itemHolder");
            IIX0o.x0xO0oo(adapterItem, "adapterItem");
            IIX0o.x0xO0oo(payloads, "payloads");
            oIX0oI.C0113oIX0oI.oIX0oI(i0Io, itemHolder, i, adapterItem, payloads);
        }
    }

    @oOoXoXO
    Fragment II0xO0();

    void oxoX(@oOoXoXO Fragment fragment);
}
