package com.baidu.navisdk.ui.routeguide.tts;

/* loaded from: classes8.dex */
public enum b {
    DEFAULT_VOLUME(9, null),
    VOLUME_12(12, "音量150%，按+键继续提高音量"),
    VOLUME_15(15, "音量200%，已提高到最大音量");


    /* renamed from: a, reason: collision with root package name */
    private int f9143a;
    private String b;
    private b c;
    private b d;

    static {
        b bVar = DEFAULT_VOLUME;
        b bVar2 = VOLUME_12;
        b bVar3 = VOLUME_15;
        bVar.a(bVar2, null);
        bVar2.a(bVar3, bVar);
        bVar3.a(null, bVar);
    }

    b(int i, String str) {
        this.f9143a = i;
        this.b = str;
    }

    public void a(b bVar, b bVar2) {
        this.c = bVar;
        this.d = bVar2;
    }

    public String b() {
        return this.b;
    }

    public b c() {
        return this.d;
    }

    public b d() {
        return this.c;
    }

    public int a() {
        return this.f9143a;
    }
}
