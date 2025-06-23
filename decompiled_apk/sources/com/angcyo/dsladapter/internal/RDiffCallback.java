package com.angcyo.dsladapter.internal;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public class RDiffCallback<T> extends DiffUtil.Callback {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    @OXOo.oOoXoXO
    private final ooOOo0oXI<T> itemDiffCallback;

    @OXOo.OOXIXo
    private final List<T> newDataList;

    @OXOo.OOXIXo
    private final List<T> oldDataList;

    /* loaded from: classes7.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public final int oIX0oI(@OXOo.oOoXoXO List<?> list) {
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public oIX0oI() {
        }
    }

    public /* synthetic */ RDiffCallback(List list, List list2, ooOOo0oXI ooooo0oxi, int i, IIXOooo iIXOooo) {
        this(list, list2, (i & 4) != 0 ? null : ooooo0oxi);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        ooOOo0oXI<T> ooooo0oxi = this.itemDiffCallback;
        if (ooooo0oxi != null) {
            return ooooo0oxi.II0xO0(this.oldDataList.get(i), this.newDataList.get(i2), i, i2);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        ooOOo0oXI<T> ooooo0oxi = this.itemDiffCallback;
        if (ooooo0oxi != null) {
            return ooooo0oxi.I0Io(this.oldDataList.get(i), this.newDataList.get(i2), i, i2);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    @OXOo.oOoXoXO
    public Object getChangePayload(int i, int i2) {
        ooOOo0oXI<T> ooooo0oxi = this.itemDiffCallback;
        if (ooooo0oxi != null) {
            return ooooo0oxi.oIX0oI(this.oldDataList.get(i), this.newDataList.get(i2), i, i2);
        }
        return null;
    }

    @OXOo.oOoXoXO
    public final ooOOo0oXI<T> getItemDiffCallback() {
        return this.itemDiffCallback;
    }

    @OXOo.OOXIXo
    public final List<T> getNewDataList() {
        return this.newDataList;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return Companion.oIX0oI(this.newDataList);
    }

    @OXOo.OOXIXo
    public final List<T> getOldDataList() {
        return this.oldDataList;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return Companion.oIX0oI(this.oldDataList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RDiffCallback(@OXOo.OOXIXo List<? extends T> oldDataList, @OXOo.OOXIXo List<? extends T> newDataList, @OXOo.oOoXoXO ooOOo0oXI<T> ooooo0oxi) {
        IIX0o.x0xO0oo(oldDataList, "oldDataList");
        IIX0o.x0xO0oo(newDataList, "newDataList");
        this.oldDataList = oldDataList;
        this.newDataList = newDataList;
        this.itemDiffCallback = ooooo0oxi;
    }
}
