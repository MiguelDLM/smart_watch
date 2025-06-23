package com.sma.smartv3.network;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class ParameterizedTypeImpl implements ParameterizedType {

    @OOXIXo
    private final Type[] args;

    @OOXIXo
    private final Class<?> raw;

    public ParameterizedTypeImpl(@OOXIXo Class<?> raw, @OOXIXo Type[] args) {
        IIX0o.x0xO0oo(raw, "raw");
        IIX0o.x0xO0oo(args, "args");
        this.raw = raw;
        this.args = args;
    }

    @Override // java.lang.reflect.ParameterizedType
    @OOXIXo
    public Type[] getActualTypeArguments() {
        return this.args;
    }

    @Override // java.lang.reflect.ParameterizedType
    @oOoXoXO
    public Type getOwnerType() {
        return null;
    }

    @Override // java.lang.reflect.ParameterizedType
    @OOXIXo
    public Type getRawType() {
        return this.raw;
    }
}
