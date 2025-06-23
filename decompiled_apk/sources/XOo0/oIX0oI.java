package XOo0;

import java.io.IOException;

/* loaded from: classes6.dex */
public class oIX0oI implements Runnable {

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ I0Io f3941XO;

    public oIX0oI(I0Io i0Io) {
        this.f3941XO = i0Io;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            I0Io.oIX0oI(this.f3941XO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
