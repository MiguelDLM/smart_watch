package com.github.doyaaaaaken.kotlincsv.client;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@IXIxx0.oxoX(c = "com.github.doyaaaaaken.kotlincsv.client.CsvReader", f = "CsvReader.kt", i = {0}, l = {184}, m = "openAsync", n = {"$this$use$iv"}, s = {"L$0"})
/* loaded from: classes9.dex */
public final class CsvReader$openAsync$4<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CsvReader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CsvReader$openAsync$4(CsvReader csvReader, kotlin.coroutines.I0Io<? super CsvReader$openAsync$4> i0Io) {
        super(i0Io);
        this.this$0 = csvReader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        Object oO2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        oO2 = this.this$0.oO(null, null, this);
        return oO2;
    }
}
