package org.apache.log4j.spi;

import org.apache.log4j.Level;

/* loaded from: classes6.dex */
public final class oO extends org.apache.log4j.x0xO0oo {
    public oO(Level level) {
        super("root");
        o0(level);
    }

    public final Level O0Xx() {
        return this.f33207II0xO0;
    }

    @Override // org.apache.log4j.X0o0xo
    public final void o0(Level level) {
        if (level == null) {
            org.apache.log4j.helpers.xxIXOIIO.oxoX("You have tried to set a null level to root.", new Throwable());
        } else {
            this.f33207II0xO0 = level;
        }
    }
}
