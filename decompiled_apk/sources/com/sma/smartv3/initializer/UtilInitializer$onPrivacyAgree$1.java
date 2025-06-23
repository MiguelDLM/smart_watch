package com.sma.smartv3.initializer;

import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "com.sma.smartv3.initializer.UtilInitializer$onPrivacyAgree$1", f = "UtilInitializer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class UtilInitializer$onPrivacyAgree$1 extends SuspendLambda implements Oox.x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    int label;

    public UtilInitializer$onPrivacyAgree$1(kotlin.coroutines.I0Io<? super UtilInitializer$onPrivacyAgree$1> i0Io) {
        super(2, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new UtilInitializer$onPrivacyAgree$1(i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        if (this.label == 0) {
            I0oOoX.x0XOIxOo(obj);
            UtilInitializer utilInitializer = UtilInitializer.f20904XO;
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            UtilInitializer.XO(utilInitializer, IXxxXO.OOXIXo(oix0oi), 0, 2, null);
            UtilInitializer.XO(utilInitializer, IXxxXO.oxxXoxO(oix0oi), 0, 2, null);
            UtilInitializer.XO(utilInitializer, IXxxXO.Xx000oIo(oix0oi), 0, 2, null);
            UtilInitializer.XO(utilInitializer, IXxxXO.Oxx0xo(oix0oi), 0, 2, null);
            UtilInitializer.XO(utilInitializer, IXxxXO.oI0IIXIo(oix0oi), 0, 2, null);
            UtilInitializer.XO(utilInitializer, IXxxXO.I0oOoX(oix0oi), 0, 2, null);
            UtilInitializer.XO(utilInitializer, IXxxXO.OxxIIOOXO(oix0oi), 0, 2, null);
            UtilInitializer.XO(utilInitializer, IXxxXO.XoX(oix0oi), 0, 2, null);
            return oXIO0o0XI.f29392oIX0oI;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((UtilInitializer$onPrivacyAgree$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
