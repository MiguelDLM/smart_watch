package com.angcyo.dsladapter.internal;

import android.view.View;
import android.view.ViewGroup;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.LibExKt;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class Oxx0IOOO implements ViewGroup.OnHierarchyChangeListener {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public ViewGroup.OnHierarchyChangeListener f5393XO;

    /* JADX WARN: Multi-variable type inference failed */
    public Oxx0IOOO() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void I0Io(@OXOo.oOoXoXO ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f5393XO = onHierarchyChangeListener;
    }

    @OXOo.oOoXoXO
    public final ViewGroup.OnHierarchyChangeListener II0xO0() {
        return this.f5393XO;
    }

    public final int oIX0oI(@OXOo.oOoXoXO View view, @OXOo.oOoXoXO View view2) {
        if (view2 == null || !(view instanceof ViewGroup)) {
            return -1;
        }
        return ((ViewGroup) view).indexOfChild(view2);
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(@OXOo.oOoXoXO View view, @OXOo.oOoXoXO View view2) {
        DslAdapterItem O02;
        DslViewHolder xx0X02;
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f5393XO;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewAdded(view, view2);
        }
        if (view2 != null && (O02 = LibExKt.O0(view2)) != null && (xx0X02 = LibExKt.xx0X0(view2)) != null) {
            O02.getItemViewAttachedToWindow().invoke(xx0X02, Integer.valueOf(oIX0oI(view, view2)));
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(@OXOo.oOoXoXO View view, @OXOo.oOoXoXO View view2) {
        DslAdapterItem O02;
        DslViewHolder xx0X02;
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f5393XO;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewRemoved(view, view2);
        }
        if (view2 != null && (O02 = LibExKt.O0(view2)) != null && (xx0X02 = LibExKt.xx0X0(view2)) != null) {
            O02.getItemViewDetachedToWindow().invoke(xx0X02, Integer.valueOf(oIX0oI(view, view2)));
        }
    }

    public Oxx0IOOO(@OXOo.oOoXoXO ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f5393XO = onHierarchyChangeListener;
    }

    public /* synthetic */ Oxx0IOOO(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? null : onHierarchyChangeListener);
    }
}
