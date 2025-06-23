package com.baidu.navisdk.behavrules.scene;

/* loaded from: classes7.dex */
public interface c extends com.baidu.navisdk.behavrules.life.a {

    /* loaded from: classes7.dex */
    public enum a {
        TIME_DIFF(1),
        ENTER_PAGE(2),
        BY_SCENESET(3),
        BY_ERROR(4);


        /* renamed from: a, reason: collision with root package name */
        public int f6656a;

        a(int i) {
            this.f6656a = i;
        }

        public int a() {
            return this.f6656a;
        }
    }

    com.baidu.navisdk.behavrules.a a();

    void a(int i);

    void a(a aVar);

    void b(a aVar);

    void d();

    String f();

    String g();

    String h();

    com.baidu.navisdk.behavrules.action.a i();

    int j();

    boolean k();

    String m();

    void run();
}
