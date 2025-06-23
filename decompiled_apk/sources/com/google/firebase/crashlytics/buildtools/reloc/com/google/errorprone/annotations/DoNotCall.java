package com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes10.dex */
public @interface DoNotCall {
    String value() default "";
}
