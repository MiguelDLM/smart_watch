package com.angcyo.dsladapter.internal;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.LibExKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public class x0xO0oo {
    public int I0Io(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.ViewHolder viewHolder) {
        IIX0o.x0xO0oo(recyclerView, "recyclerView");
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        DslAdapterItem oIX0oI2 = oIX0oI(recyclerView, viewHolder);
        if (oIX0oI2 != null) {
            return oIX0oI2.getItemSwipeHeight().invoke((DslViewHolder) viewHolder).intValue();
        }
        return 0;
    }

    public int II0xO0(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.ViewHolder viewHolder) {
        int i;
        IIX0o.x0xO0oo(recyclerView, "recyclerView");
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        DslAdapterItem oIX0oI2 = oIX0oI(recyclerView, viewHolder);
        if (oIX0oI2 == null) {
            return 0;
        }
        if (oIX0oI2.getItemSwipeMenuEnable()) {
            i = oIX0oI2.getItemSwipeMenuFlag();
        } else {
            i = 0;
        }
        return ItemTouchHelper.Callback.makeMovementFlags(0, i);
    }

    public void Oxx0IOOO(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.ViewHolder viewHolder, float f, float f2) {
        IIX0o.x0xO0oo(recyclerView, "recyclerView");
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        DslAdapterItem oIX0oI2 = oIX0oI(recyclerView, viewHolder);
        if (oIX0oI2 != null) {
            oIX0oI2.getItemSwipeMenuTo().invoke((DslViewHolder) viewHolder, Float.valueOf(f), Float.valueOf(f2));
        }
    }

    public float X0o0xo(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.ViewHolder viewHolder) {
        IIX0o.x0xO0oo(recyclerView, "recyclerView");
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        return 0.3f;
    }

    public float XO(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.ViewHolder viewHolder, float f) {
        IIX0o.x0xO0oo(recyclerView, "recyclerView");
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        return f;
    }

    @OXOo.oOoXoXO
    public final DslAdapterItem oIX0oI(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.ViewHolder viewHolder) {
        IIX0o.x0xO0oo(recyclerView, "recyclerView");
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        DslAdapter Io2 = LibExKt.Io(recyclerView);
        if (Io2 != null) {
            return Io2.get(viewHolder.getAdapterPosition(), true, false);
        }
        return null;
    }

    public int oxoX(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.ViewHolder viewHolder) {
        IIX0o.x0xO0oo(recyclerView, "recyclerView");
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        DslAdapterItem oIX0oI2 = oIX0oI(recyclerView, viewHolder);
        if (oIX0oI2 != null) {
            return oIX0oI2.getItemSwipeWidth().invoke((DslViewHolder) viewHolder).intValue();
        }
        return 0;
    }
}
