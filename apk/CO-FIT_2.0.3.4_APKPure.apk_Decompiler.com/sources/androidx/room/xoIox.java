package androidx.room;

public final /* synthetic */ class xoIox implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ Object[] f478IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ String f479Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f480XO;

    public /* synthetic */ xoIox(QueryInterceptorDatabase queryInterceptorDatabase, String str, Object[] objArr) {
        this.f480XO = queryInterceptorDatabase;
        this.f479Oo = str;
        this.f478IXxxXO = objArr;
    }

    public final void run() {
        QueryInterceptorDatabase.query$lambda$7(this.f480XO, this.f479Oo, this.f478IXxxXO);
    }
}
