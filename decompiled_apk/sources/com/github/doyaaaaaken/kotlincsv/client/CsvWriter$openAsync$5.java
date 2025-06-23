package com.github.doyaaaaaken.kotlincsv.client;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import com.github.doyaaaaaken.kotlincsv.dsl.context.CsvWriterContext;
import java.io.Closeable;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "com.github.doyaaaaaken.kotlincsv.client.CsvWriter$openAsync$5", f = "CsvWriter.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
public final class CsvWriter$openAsync$5 extends SuspendLambda implements x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ OutputStream $ops;
    final /* synthetic */ x0xO0oo<I0Io, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> $write;
    Object L$0;
    int label;
    final /* synthetic */ CsvWriter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CsvWriter$openAsync$5(OutputStream outputStream, CsvWriter csvWriter, x0xO0oo<? super I0Io, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super CsvWriter$openAsync$5> i0Io) {
        super(2, i0Io);
        this.$ops = outputStream;
        this.this$0 = csvWriter;
        this.$write = x0xo0oo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new CsvWriter$openAsync$5(this.$ops, this.this$0, this.$write, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        CsvWriterContext csvWriterContext;
        CsvWriterContext csvWriterContext2;
        Closeable closeable;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                closeable = (Closeable) this.L$0;
                try {
                    I0oOoX.x0XOIxOo(obj);
                } catch (Throwable th) {
                    th = th;
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        kotlin.io.II0xO0.oIX0oI(closeable, th);
                        throw th2;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            OutputStream outputStream = this.$ops;
            csvWriterContext = this.this$0.f15762oIX0oI;
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, csvWriterContext.II0xO0());
            csvWriterContext2 = this.this$0.f15762oIX0oI;
            CsvFileWriter csvFileWriter = new CsvFileWriter(csvWriterContext2, new PrintWriter(outputStreamWriter));
            x0xO0oo<I0Io, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> x0xo0oo = this.$write;
            try {
                this.L$0 = csvFileWriter;
                this.label = 1;
                if (x0xo0oo.invoke(csvFileWriter, this) == oOoXoXO2) {
                    return oOoXoXO2;
                }
                closeable = csvFileWriter;
            } catch (Throwable th3) {
                th = th3;
                closeable = csvFileWriter;
                throw th;
            }
        }
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        kotlin.io.II0xO0.oIX0oI(closeable, null);
        return oxio0o0xi;
    }

    @Override // Oox.x0xO0oo
    @oOoXoXO
    public final Object invoke(@OOXIXo xII xii, @oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((CsvWriter$openAsync$5) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
