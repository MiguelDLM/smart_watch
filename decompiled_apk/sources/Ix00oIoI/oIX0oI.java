package Ix00oIoI;

import com.octopus.ad.internal.animation.TransitionDirection;
import com.octopus.ad.internal.animation.TransitionType;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes11.dex */
public class oIX0oI {

    /* renamed from: Ix00oIoI.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class C0027oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f953oIX0oI;

        static {
            int[] iArr = new int[TransitionType.values().length];
            f953oIX0oI = iArr;
            try {
                iArr[TransitionType.FADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f953oIX0oI[TransitionType.PUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f953oIX0oI[TransitionType.MOVEIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f953oIX0oI[TransitionType.REVEAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static XO oIX0oI(TransitionType transitionType, long j, TransitionDirection transitionDirection) {
        TransitionType transitionType2 = TransitionType.RANDOM;
        if (transitionType == transitionType2) {
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, TransitionType.values());
            arrayList.remove(TransitionType.NONE);
            arrayList.remove(transitionType2);
            Collections.shuffle(arrayList);
            transitionType = (TransitionType) arrayList.get(0);
        }
        int i = C0027oIX0oI.f953oIX0oI[transitionType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return new X0o0xo(j, transitionDirection);
                }
                return new I0Io(j, transitionDirection);
            }
            return new oxoX(j, transitionDirection);
        }
        return new II0xO0(j);
    }
}
