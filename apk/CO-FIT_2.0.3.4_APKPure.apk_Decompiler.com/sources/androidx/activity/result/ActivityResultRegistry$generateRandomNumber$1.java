package androidx.activity.result;

import Oox.oIX0oI;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;

public final class ActivityResultRegistry$generateRandomNumber$1 extends Lambda implements oIX0oI<Integer> {
    public static final ActivityResultRegistry$generateRandomNumber$1 INSTANCE = new ActivityResultRegistry$generateRandomNumber$1();

    public ActivityResultRegistry$generateRandomNumber$1() {
        super(0);
    }

    public final Integer invoke() {
        return Integer.valueOf(Random.Default.nextInt(2147418112) + 65536);
    }
}
