package com.angcyo.dsladapter;

import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public /* synthetic */ class DslAdapterItem$itemGroupExtend$2 extends FunctionReferenceImpl implements Oox.x0xO0oo<Boolean, Boolean, oXIO0o0XI> {
    public DslAdapterItem$itemGroupExtend$2(Object obj) {
        super(2, obj, DslAdapterItem.class, "onSelfItemGroupExtendChanged", "onSelfItemGroupExtendChanged(ZZ)V", 0);
    }

    @Override // Oox.x0xO0oo
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool, Boolean bool2) {
        invoke(bool.booleanValue(), bool2.booleanValue());
        return oXIO0o0XI.f29392oIX0oI;
    }

    public final void invoke(boolean z, boolean z2) {
        ((DslAdapterItem) this.receiver).onSelfItemGroupExtendChanged(z, z2);
    }
}
