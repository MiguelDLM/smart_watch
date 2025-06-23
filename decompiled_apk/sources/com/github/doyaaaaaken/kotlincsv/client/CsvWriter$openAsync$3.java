package com.github.doyaaaaaken.kotlincsv.client;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "com.github.doyaaaaaken.kotlincsv.client.CsvWriter$openAsync$3", f = "CsvWriter.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
public final class CsvWriter$openAsync$3 extends SuspendLambda implements x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ boolean $append;
    final /* synthetic */ File $targetFile;
    final /* synthetic */ x0xO0oo<I0Io, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> $write;
    int label;
    final /* synthetic */ CsvWriter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CsvWriter$openAsync$3(File file, boolean z, CsvWriter csvWriter, x0xO0oo<? super I0Io, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super CsvWriter$openAsync$3> i0Io) {
        super(2, i0Io);
        this.$targetFile = file;
        this.$append = z;
        this.this$0 = csvWriter;
        this.$write = x0xo0oo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new CsvWriter$openAsync$3(this.$targetFile, this.$append, this.this$0, this.$write, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.$targetFile, this.$append), 8192);
            CsvWriter csvWriter = this.this$0;
            x0xO0oo<I0Io, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> x0xo0oo = this.$write;
            this.label = 1;
            if (csvWriter.oI0IIXIo(bufferedOutputStream, x0xo0oo, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @oOoXoXO
    public final Object invoke(@OOXIXo xII xii, @oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((CsvWriter$openAsync$3) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
