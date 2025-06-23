package androidx.room;

import java.util.List;

public final /* synthetic */ class oO implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ List f468IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ String f469Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f470XO;

    public /* synthetic */ oO(QueryInterceptorDatabase queryInterceptorDatabase, String str, List list) {
        this.f470XO = queryInterceptorDatabase;
        this.f469Oo = str;
        this.f468IXxxXO = list;
    }

    public final void run() {
        QueryInterceptorDatabase.execSQL$lambda$12(this.f470XO, this.f469Oo, this.f468IXxxXO);
    }
}
