package XXIoX0;

import kotlinx.coroutines.OI0;
import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes6.dex */
public final class oOoXoXO extends xxIXOIIO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public final Runnable f4060IXxxXO;

    public oOoXoXO(@OXOo.OOXIXo Runnable runnable, long j, @OXOo.OOXIXo xoIox xoiox) {
        super(j, xoiox);
        this.f4060IXxxXO = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f4060IXxxXO.run();
        } finally {
            this.f4080Oo.xxIXOIIO();
        }
    }

    @OXOo.OOXIXo
    public String toString() {
        return "Task[" + OI0.oIX0oI(this.f4060IXxxXO) + ObjectUtils.f32506oIX0oI + OI0.II0xO0(this.f4060IXxxXO) + ", " + this.f4081XO + ", " + this.f4080Oo + ']';
    }
}
