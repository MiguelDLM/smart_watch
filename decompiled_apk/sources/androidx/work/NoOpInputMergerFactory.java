package androidx.work;

import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class NoOpInputMergerFactory extends InputMergerFactory {

    @OXOo.OOXIXo
    public static final NoOpInputMergerFactory INSTANCE = new NoOpInputMergerFactory();

    private NoOpInputMergerFactory() {
    }

    @OXOo.oOoXoXO
    /* renamed from: createInputMerger, reason: collision with other method in class */
    public Void m39createInputMerger(@OXOo.OOXIXo String className) {
        IIX0o.x0xO0oo(className, "className");
        return null;
    }

    @Override // androidx.work.InputMergerFactory
    public /* bridge */ /* synthetic */ InputMerger createInputMerger(String str) {
        return (InputMerger) m39createInputMerger(str);
    }
}
