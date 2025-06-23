package com.sma.smartv3.work;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.blankj.utilcode.util.LogUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nDataWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataWorker.kt\ncom/sma/smartv3/work/Upload$upload$13\n*L\n1#1,947:1\n*E\n"})
/* loaded from: classes12.dex */
public final class Upload$upload$13 implements xxxI.II0xO0<Object> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ List<T> f25792II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ oIX0oI<T> f25793oIX0oI;

    /* JADX WARN: Multi-variable type inference failed */
    public Upload$upload$13(oIX0oI<T> oix0oi, List<? extends T> list) {
        this.f25793oIX0oI = oix0oi;
        this.f25792II0xO0 = list;
    }

    @Override // xxxI.II0xO0
    public void handleError(@OOXIXo String error) {
        IIX0o.x0xO0oo(error, "error");
        LogUtils.d("activity " + error);
        ((ArrayList) this.f25792II0xO0).clear();
    }

    @Override // xxxI.II0xO0
    public void handleResponse(@oOoXoXO Object obj) {
        this.f25793oIX0oI.oIX0oI((ArrayList) this.f25792II0xO0);
        ((ArrayList) this.f25792II0xO0).clear();
        ((ArrayList) this.f25792II0xO0).addAll(this.f25793oIX0oI.getList());
    }
}
