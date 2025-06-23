package com.airbnb.lottie.model.content;

import Oo.OOXIXo;
import Oo.Oxx0IOOO;

/* loaded from: classes.dex */
public class Mask {

    /* renamed from: I0Io, reason: collision with root package name */
    public final Oxx0IOOO f4841I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final OOXIXo f4842II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final MaskMode f4843oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final boolean f4844oxoX;

    /* loaded from: classes.dex */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, OOXIXo oOXIXo, Oxx0IOOO oxx0IOOO, boolean z) {
        this.f4843oIX0oI = maskMode;
        this.f4842II0xO0 = oOXIXo;
        this.f4841I0Io = oxx0IOOO;
        this.f4844oxoX = z;
    }

    public Oxx0IOOO I0Io() {
        return this.f4841I0Io;
    }

    public OOXIXo II0xO0() {
        return this.f4842II0xO0;
    }

    public MaskMode oIX0oI() {
        return this.f4843oIX0oI;
    }

    public boolean oxoX() {
        return this.f4844oxoX;
    }
}
