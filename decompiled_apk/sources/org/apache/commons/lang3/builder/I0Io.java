package org.apache.commons.lang3.builder;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class I0Io<T> implements Iterable<Diff<?>> {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final String f32641OxxIIOOXO = "differs from";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final String f32642oI0IIXIo = "";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final T f32643IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final T f32644Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final ToStringStyle f32645Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final List<Diff<?>> f32646XO;

    public I0Io(T t, T t2, List<Diff<?>> list, ToStringStyle toStringStyle) {
        xoIxX.xo0x(t, "Left hand object cannot be null", new Object[0]);
        xoIxX.xo0x(t2, "Right hand object cannot be null", new Object[0]);
        xoIxX.xo0x(list, "List of differences cannot be null", new Object[0]);
        this.f32646XO = list;
        this.f32644Oo = t;
        this.f32643IXxxXO = t2;
        if (toStringStyle == null) {
            this.f32645Oxx0xo = ToStringStyle.DEFAULT_STYLE;
        } else {
            this.f32645Oxx0xo = toStringStyle;
        }
    }

    public int I0Io() {
        return this.f32646XO.size();
    }

    public T II0xO0() {
        return this.f32644Oo;
    }

    public ToStringStyle X0o0xo() {
        return this.f32645Oxx0xo;
    }

    public String XO(ToStringStyle toStringStyle) {
        if (this.f32646XO.isEmpty()) {
            return "";
        }
        x0XOIxOo x0xoixoo = new x0XOIxOo(this.f32644Oo, toStringStyle);
        x0XOIxOo x0xoixoo2 = new x0XOIxOo(this.f32643IXxxXO, toStringStyle);
        for (Diff<?> diff : this.f32646XO) {
            x0xoixoo.x0XOIxOo(diff.getFieldName(), diff.getLeft());
            x0xoixoo2.x0XOIxOo(diff.getFieldName(), diff.getRight());
        }
        return String.format("%s %s %s", x0xoixoo.build(), f32641OxxIIOOXO, x0xoixoo2.build());
    }

    @Override // java.lang.Iterable
    public Iterator<Diff<?>> iterator() {
        return this.f32646XO.iterator();
    }

    public List<Diff<?>> oIX0oI() {
        return Collections.unmodifiableList(this.f32646XO);
    }

    public T oxoX() {
        return this.f32643IXxxXO;
    }

    public String toString() {
        return XO(this.f32645Oxx0xo);
    }
}
