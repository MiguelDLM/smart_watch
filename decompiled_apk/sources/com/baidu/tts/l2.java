package com.baidu.tts;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public abstract class l2 {
    public static final l2 b;
    public static final l2 c;
    public static final /* synthetic */ l2[] d;

    /* renamed from: a, reason: collision with root package name */
    public final String f10129a;

    /* loaded from: classes8.dex */
    public enum a extends l2 {
        public a(String str, int i, String str2) {
            super(str, i, str2, null);
        }

        @Override // com.baidu.tts.l2
        public m2[] a() {
            return new m2[]{m2.OPUS_16K, m2.OPUS_32K, m2.OPUS_64K, m2.OPUS_128K};
        }
    }

    static {
        a aVar = new a("OPUS", 0, "2");
        b = aVar;
        l2 l2Var = new l2("PCM", 1, "4") { // from class: com.baidu.tts.l2.b
            {
                a aVar2 = null;
            }

            @Override // com.baidu.tts.l2
            public m2[] a() {
                return new m2[]{m2.PCM};
            }
        };
        c = l2Var;
        d = new l2[]{aVar, l2Var};
    }

    public /* synthetic */ l2(String str, int i, String str2, a aVar) {
        this(str, i, str2);
    }

    public static l2 a(String str) {
        l2[] values = values();
        for (int i = 0; i < 2; i++) {
            l2 l2Var = values[i];
            if (l2Var.f10129a.equals(str)) {
                return l2Var;
            }
        }
        return null;
    }

    public static l2 valueOf(String str) {
        return (l2) Enum.valueOf(l2.class, str);
    }

    public static l2[] values() {
        return (l2[]) d.clone();
    }

    public abstract m2[] a();

    public l2(String str, int i, String str2) {
        this.f10129a = str2;
    }
}
