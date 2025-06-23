package org.apache.log4j.lf5.viewer;

import javax.swing.JComponent;

/* loaded from: classes6.dex */
public class II0xO0 implements Runnable {

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ JComponent f33346XO;

    public II0xO0(JComponent jComponent) {
        this.f33346XO = jComponent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f33346XO.repaint();
    }
}
