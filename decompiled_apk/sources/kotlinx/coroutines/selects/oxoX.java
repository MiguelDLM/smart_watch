package kotlinx.coroutines.selects;

import Oox.IXxxXO;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class oxoX implements I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final IXxxXO<xoIox<?>, Object, Object, Oox.oOoXoXO<Throwable, oXIO0o0XI>> f30425I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final IXxxXO<Object, xoIox<?>, Object, oXIO0o0XI> f30426II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Object f30427oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final IXxxXO<Object, Object, Object, Object> f30428oxoX;

    /* JADX WARN: Multi-variable type inference failed */
    public oxoX(@OXOo.OOXIXo Object obj, @OXOo.OOXIXo IXxxXO<Object, ? super xoIox<?>, Object, oXIO0o0XI> iXxxXO, @OXOo.oOoXoXO IXxxXO<? super xoIox<?>, Object, Object, ? extends Oox.oOoXoXO<? super Throwable, oXIO0o0XI>> iXxxXO2) {
        IXxxXO<Object, Object, Object, Object> iXxxXO3;
        this.f30427oIX0oI = obj;
        this.f30426II0xO0 = iXxxXO;
        this.f30425I0Io = iXxxXO2;
        iXxxXO3 = SelectKt.f30416oIX0oI;
        this.f30428oxoX = iXxxXO3;
    }

    @Override // kotlinx.coroutines.selects.xxIXOIIO
    @OXOo.OOXIXo
    public IXxxXO<Object, xoIox<?>, Object, oXIO0o0XI> I0Io() {
        return this.f30426II0xO0;
    }

    @Override // kotlinx.coroutines.selects.xxIXOIIO
    @OXOo.OOXIXo
    public IXxxXO<Object, Object, Object, Object> II0xO0() {
        return this.f30428oxoX;
    }

    @Override // kotlinx.coroutines.selects.xxIXOIIO
    @OXOo.oOoXoXO
    public IXxxXO<xoIox<?>, Object, Object, Oox.oOoXoXO<Throwable, oXIO0o0XI>> oIX0oI() {
        return this.f30425I0Io;
    }

    @Override // kotlinx.coroutines.selects.xxIXOIIO
    @OXOo.OOXIXo
    public Object oxoX() {
        return this.f30427oIX0oI;
    }

    public /* synthetic */ oxoX(Object obj, IXxxXO iXxxXO, IXxxXO iXxxXO2, int i, IIXOooo iIXOooo) {
        this(obj, iXxxXO, (i & 4) != 0 ? null : iXxxXO2);
    }
}
