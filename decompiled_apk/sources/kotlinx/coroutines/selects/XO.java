package kotlinx.coroutines.selects;

import Oox.IXxxXO;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class XO<Q> implements X0o0xo<Q> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final IXxxXO<Object, Object, Object, Object> f30421I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final IXxxXO<Object, xoIox<?>, Object, oXIO0o0XI> f30422II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Object f30423oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final IXxxXO<xoIox<?>, Object, Object, Oox.oOoXoXO<Throwable, oXIO0o0XI>> f30424oxoX;

    /* JADX WARN: Multi-variable type inference failed */
    public XO(@OXOo.OOXIXo Object obj, @OXOo.OOXIXo IXxxXO<Object, ? super xoIox<?>, Object, oXIO0o0XI> iXxxXO, @OXOo.OOXIXo IXxxXO<Object, Object, Object, ? extends Object> iXxxXO2, @OXOo.oOoXoXO IXxxXO<? super xoIox<?>, Object, Object, ? extends Oox.oOoXoXO<? super Throwable, oXIO0o0XI>> iXxxXO3) {
        this.f30423oIX0oI = obj;
        this.f30422II0xO0 = iXxxXO;
        this.f30421I0Io = iXxxXO2;
        this.f30424oxoX = iXxxXO3;
    }

    @Override // kotlinx.coroutines.selects.xxIXOIIO
    @OXOo.OOXIXo
    public IXxxXO<Object, xoIox<?>, Object, oXIO0o0XI> I0Io() {
        return this.f30422II0xO0;
    }

    @Override // kotlinx.coroutines.selects.xxIXOIIO
    @OXOo.OOXIXo
    public IXxxXO<Object, Object, Object, Object> II0xO0() {
        return this.f30421I0Io;
    }

    @Override // kotlinx.coroutines.selects.xxIXOIIO
    @OXOo.oOoXoXO
    public IXxxXO<xoIox<?>, Object, Object, Oox.oOoXoXO<Throwable, oXIO0o0XI>> oIX0oI() {
        return this.f30424oxoX;
    }

    @Override // kotlinx.coroutines.selects.xxIXOIIO
    @OXOo.OOXIXo
    public Object oxoX() {
        return this.f30423oIX0oI;
    }

    public /* synthetic */ XO(Object obj, IXxxXO iXxxXO, IXxxXO iXxxXO2, IXxxXO iXxxXO3, int i, IIXOooo iIXOooo) {
        this(obj, iXxxXO, iXxxXO2, (i & 8) != 0 ? null : iXxxXO3);
    }
}
