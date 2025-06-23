package com.angcyo.dsladapter.filter;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslDataFilter;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public final class BatchLoadFilterInterceptorKt {
    public static /* synthetic */ BatchLoadFilterInterceptor II0xO0(DslAdapter dslAdapter, long j, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 64;
        }
        if ((i & 2) != 0) {
            oooxoxo = new oOoXoXO<BatchLoadFilterInterceptor, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.filter.BatchLoadFilterInterceptorKt$batchLoad$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo BatchLoadFilterInterceptor batchLoadFilterInterceptor) {
                    IIX0o.x0xO0oo(batchLoadFilterInterceptor, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BatchLoadFilterInterceptor batchLoadFilterInterceptor) {
                    invoke2(batchLoadFilterInterceptor);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return oIX0oI(dslAdapter, j, oooxoxo);
    }

    @OOXIXo
    public static final BatchLoadFilterInterceptor oIX0oI(@OOXIXo DslAdapter dslAdapter, long j, @OOXIXo oOoXoXO<? super BatchLoadFilterInterceptor, oXIO0o0XI> action) {
        List<xxIXOIIO> oO2;
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(action, "action");
        BatchLoadFilterInterceptor batchLoadFilterInterceptor = new BatchLoadFilterInterceptor();
        DslDataFilter dslDataFilter = dslAdapter.getDslDataFilter();
        if (dslDataFilter != null && (oO2 = dslDataFilter.oO()) != null) {
            oO2.add(batchLoadFilterInterceptor);
        }
        batchLoadFilterInterceptor.xxIXOIIO(j);
        action.invoke(batchLoadFilterInterceptor);
        return batchLoadFilterInterceptor;
    }
}
