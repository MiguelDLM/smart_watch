package androidx.work;

import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class InputMergerKt {

    @OXOo.OOXIXo
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("InputMerger");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"InputMerger\")");
        TAG = tagWithPrefix;
    }

    @OXOo.oOoXoXO
    public static final InputMerger fromClassName(@OXOo.OOXIXo String className) {
        IIX0o.x0xO0oo(className, "className");
        try {
            Object newInstance = Class.forName(className).getDeclaredConstructor(null).newInstance(null);
            IIX0o.x0XOIxOo(newInstance, "null cannot be cast to non-null type androidx.work.InputMerger");
            return (InputMerger) newInstance;
        } catch (Exception e) {
            Logger.get().error(TAG, "Trouble instantiating " + className, e);
            return null;
        }
    }
}
