package org.apache.commons.lang3.builder;

import java.lang.reflect.Field;
import java.util.function.Function;

/* loaded from: classes6.dex */
public final /* synthetic */ class II0XooXoX implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((Field) obj).getName();
    }
}
