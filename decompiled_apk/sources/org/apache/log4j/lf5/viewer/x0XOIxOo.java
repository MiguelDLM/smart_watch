package org.apache.log4j.lf5.viewer;

/* loaded from: classes6.dex */
public class x0XOIxOo implements Runnable {

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ IoOoX f33434Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ int f33435XO;

    public x0XOIxOo(IoOoX ioOoX, int i) {
        this.f33434Oo = ioOoX;
        this.f33435XO = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread.yield();
        this.f33434Oo.x0xO(this.f33435XO);
        this.f33434Oo.f33371oIX0oI.setVisible(true);
    }
}
