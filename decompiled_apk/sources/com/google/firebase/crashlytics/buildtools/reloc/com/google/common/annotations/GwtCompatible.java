package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@GwtCompatible
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes10.dex */
public @interface GwtCompatible {
    boolean emulated() default false;

    boolean serializable() default false;
}
