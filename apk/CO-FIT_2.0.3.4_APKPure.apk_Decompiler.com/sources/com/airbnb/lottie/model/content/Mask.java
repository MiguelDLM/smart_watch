package com.airbnb.lottie.model.content;

import Oo.OOXIXo;
import Oo.Oxx0IOOO;

public class Mask {

    /* renamed from: I0Io  reason: collision with root package name */
    public final Oxx0IOOO f847I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final OOXIXo f848II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final MaskMode f849oIX0oI;

    /* renamed from: oxoX  reason: collision with root package name */
    public final boolean f850oxoX;

    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, OOXIXo oOXIXo, Oxx0IOOO oxx0IOOO, boolean z) {
        this.f849oIX0oI = maskMode;
        this.f848II0xO0 = oOXIXo;
        this.f847I0Io = oxx0IOOO;
        this.f850oxoX = z;
    }

    public Oxx0IOOO I0Io() {
        return this.f847I0Io;
    }

    public OOXIXo II0xO0() {
        return this.f848II0xO0;
    }

    public MaskMode oIX0oI() {
        return this.f849oIX0oI;
    }

    public boolean oxoX() {
        return this.f850oxoX;
    }
}
