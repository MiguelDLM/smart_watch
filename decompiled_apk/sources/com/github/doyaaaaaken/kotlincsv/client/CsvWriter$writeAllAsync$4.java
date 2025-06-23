package com.github.doyaaaaaken.kotlincsv.client;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import java.util.List;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

@IXIxx0.oxoX(c = "com.github.doyaaaaaken.kotlincsv.client.CsvWriter$writeAllAsync$4", f = "CsvWriter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
public final class CsvWriter$writeAllAsync$4 extends SuspendLambda implements x0xO0oo<I0Io, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ List<List<Object>> $rows;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CsvWriter$writeAllAsync$4(List<? extends List<? extends Object>> list, kotlin.coroutines.I0Io<? super CsvWriter$writeAllAsync$4> i0Io) {
        super(2, i0Io);
        this.$rows = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        CsvWriter$writeAllAsync$4 csvWriter$writeAllAsync$4 = new CsvWriter$writeAllAsync$4(this.$rows, i0Io);
        csvWriter$writeAllAsync$4.L$0 = obj;
        return csvWriter$writeAllAsync$4;
    }

    @Override // Oox.x0xO0oo
    @oOoXoXO
    public final Object invoke(@OOXIXo I0Io i0Io, @oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io2) {
        return ((CsvWriter$writeAllAsync$4) create(i0Io, i0Io2)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        if (this.label == 0) {
            I0oOoX.x0XOIxOo(obj);
            ((I0Io) this.L$0).I0Io(this.$rows);
            return oXIO0o0XI.f29392oIX0oI;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
