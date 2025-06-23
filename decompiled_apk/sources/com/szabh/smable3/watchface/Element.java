package com.szabh.smable3.watchface;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.garmin.fit.xxXXXxIxo;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class Element {
    private final int bottomOffset;
    private final int gravity;
    private final int h;
    private final int hasAlpha;
    private final int ignoreBlack;

    @OOXIXo
    private final byte[][] imageBuffers;
    private final int leftOffset;
    private final int playInterval;
    private final int type;
    private final int w;
    private final int x;
    private final int y;

    public Element() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, xxXXXxIxo.f15726I0Io, null);
    }

    public final int component1() {
        return this.type;
    }

    public final int component10() {
        return this.bottomOffset;
    }

    public final int component11() {
        return this.leftOffset;
    }

    @OOXIXo
    public final byte[][] component12() {
        return this.imageBuffers;
    }

    public final int component2() {
        return this.hasAlpha;
    }

    public final int component3() {
        return this.w;
    }

    public final int component4() {
        return this.h;
    }

    public final int component5() {
        return this.gravity;
    }

    public final int component6() {
        return this.ignoreBlack;
    }

    public final int component7() {
        return this.x;
    }

    public final int component8() {
        return this.y;
    }

    public final int component9() {
        return this.playInterval;
    }

    @OOXIXo
    public final Element copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, @OOXIXo byte[][] imageBuffers) {
        IIX0o.x0xO0oo(imageBuffers, "imageBuffers");
        return new Element(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, imageBuffers);
    }

    public boolean equals(@oOoXoXO Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!IIX0o.Oxx0IOOO(Element.class, cls)) {
            return false;
        }
        IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type com.szabh.smable3.watchface.Element");
        Element element = (Element) obj;
        if (this.type == element.type && this.hasAlpha == element.hasAlpha && this.w == element.w && this.h == element.h && this.gravity == element.gravity && this.ignoreBlack == element.ignoreBlack && this.x == element.x && this.y == element.y && this.playInterval == element.playInterval && this.bottomOffset == element.bottomOffset && this.leftOffset == element.leftOffset && kotlin.collections.oOoXoXO.Oxx0IOOO(this.imageBuffers, element.imageBuffers)) {
            return true;
        }
        return false;
    }

    public final int getBottomOffset() {
        return this.bottomOffset;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final int getH() {
        return this.h;
    }

    public final int getHasAlpha() {
        return this.hasAlpha;
    }

    public final int getIgnoreBlack() {
        return this.ignoreBlack;
    }

    @OOXIXo
    public final byte[][] getImageBuffers() {
        return this.imageBuffers;
    }

    public final int getLeftOffset() {
        return this.leftOffset;
    }

    public final int getPlayInterval() {
        return this.playInterval;
    }

    public final int getType() {
        return this.type;
    }

    public final int getW() {
        return this.w;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.type * 31) + this.hasAlpha) * 31) + this.w) * 31) + this.h) * 31) + this.gravity) * 31) + this.ignoreBlack) * 31) + this.x) * 31) + this.y) * 31) + this.playInterval) * 31) + this.bottomOffset) * 31) + this.leftOffset) * 31) + kotlin.collections.OOXIXo.II0xO0(this.imageBuffers);
    }

    @OOXIXo
    public String toString() {
        return "Element(type=" + this.type + ", hasAlpha=" + this.hasAlpha + ", w=" + this.w + ", h=" + this.h + ", gravity=" + this.gravity + ", ignoreBlack=" + this.ignoreBlack + ", x=" + this.x + ", y=" + this.y + ", playInterval=" + this.playInterval + ", bottomOffset=" + this.bottomOffset + ", leftOffset=" + this.leftOffset + ", imageBuffers=" + Arrays.toString(this.imageBuffers) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public Element(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, @OOXIXo byte[][] imageBuffers) {
        IIX0o.x0xO0oo(imageBuffers, "imageBuffers");
        this.type = i;
        this.hasAlpha = i2;
        this.w = i3;
        this.h = i4;
        this.gravity = i5;
        this.ignoreBlack = i6;
        this.x = i7;
        this.y = i8;
        this.playInterval = i9;
        this.bottomOffset = i10;
        this.leftOffset = i11;
        this.imageBuffers = imageBuffers;
    }

    public /* synthetic */ Element(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, byte[][] bArr, int i12, IIXOooo iIXOooo) {
        this((i12 & 1) != 0 ? 0 : i, (i12 & 2) != 0 ? 0 : i2, (i12 & 4) != 0 ? 0 : i3, (i12 & 8) != 0 ? 0 : i4, (i12 & 16) != 0 ? 0 : i5, (i12 & 32) != 0 ? 0 : i6, (i12 & 64) != 0 ? 0 : i7, (i12 & 128) != 0 ? 0 : i8, (i12 & 256) != 0 ? 0 : i9, (i12 & 512) != 0 ? 0 : i10, (i12 & 1024) != 0 ? 0 : i11, (i12 & 2048) != 0 ? new byte[0] : bArr);
    }
}
