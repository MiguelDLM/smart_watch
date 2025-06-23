package androidx.room;

public final /* synthetic */ class OOXIXo implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ String f452Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f453XO;

    public /* synthetic */ OOXIXo(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        this.f453XO = queryInterceptorDatabase;
        this.f452Oo = str;
    }

    public final void run() {
        QueryInterceptorDatabase.execSQL$lambda$10(this.f453XO, this.f452Oo);
    }
}
