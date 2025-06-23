package com.github.doyaaaaaken.kotlincsv.dsl;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import com.github.doyaaaaaken.kotlincsv.client.CsvReader;
import com.github.doyaaaaaken.kotlincsv.dsl.context.CsvReaderContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes9.dex */
public final class CsvReaderDslKt {
    public static /* synthetic */ CsvReader II0xO0(oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = new oOoXoXO<CsvReaderContext, oXIO0o0XI>() { // from class: com.github.doyaaaaaken.kotlincsv.dsl.CsvReaderDslKt$csvReader$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo CsvReaderContext csvReaderContext) {
                    IIX0o.x0xO0oo(csvReaderContext, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(CsvReaderContext csvReaderContext) {
                    invoke2(csvReaderContext);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return oIX0oI(oooxoxo);
    }

    @OOXIXo
    public static final CsvReader oIX0oI(@OOXIXo oOoXoXO<? super CsvReaderContext, oXIO0o0XI> init) {
        IIX0o.x0xO0oo(init, "init");
        CsvReaderContext csvReaderContext = new CsvReaderContext();
        init.invoke(csvReaderContext);
        return new CsvReader(csvReaderContext);
    }
}
