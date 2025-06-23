package org.apache.log4j.lf5.viewer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/* loaded from: classes6.dex */
public class IO extends KeyAdapter {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ XOxIOxOx f33350oIX0oI;

    public IO(XOxIOxOx xOxIOxOx) {
        this.f33350oIX0oI = xOxIOxOx;
    }

    public void oIX0oI(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 10) {
            this.f33350oIX0oI.hide();
        }
    }
}
