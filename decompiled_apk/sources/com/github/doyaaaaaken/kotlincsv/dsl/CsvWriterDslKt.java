package com.github.doyaaaaaken.kotlincsv.dsl;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import com.github.doyaaaaaken.kotlincsv.client.CsvWriter;
import com.github.doyaaaaaken.kotlincsv.dsl.context.CsvWriterContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes9.dex */
public final class CsvWriterDslKt {
    public static /* synthetic */ CsvWriter II0xO0(oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = new oOoXoXO<CsvWriterContext, oXIO0o0XI>() { // from class: com.github.doyaaaaaken.kotlincsv.dsl.CsvWriterDslKt$csvWriter$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo CsvWriterContext csvWriterContext) {
                    IIX0o.x0xO0oo(csvWriterContext, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(CsvWriterContext csvWriterContext) {
                    invoke2(csvWriterContext);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return oIX0oI(oooxoxo);
    }

    @OOXIXo
    public static final CsvWriter oIX0oI(@OOXIXo oOoXoXO<? super CsvWriterContext, oXIO0o0XI> init) {
        IIX0o.x0xO0oo(init, "init");
        CsvWriterContext csvWriterContext = new CsvWriterContext();
        init.invoke(csvWriterContext);
        return new CsvWriter(csvWriterContext);
    }
}
