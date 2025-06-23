package com.google.firebase.crashlytics.buildtools.reloc.javax.annotation;

import com.google.firebase.crashlytics.buildtools.reloc.javax.annotation.meta.TypeQualifier;
import com.google.firebase.crashlytics.buildtools.reloc.javax.annotation.meta.When;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@TypeQualifier
/* loaded from: classes10.dex */
public @interface PropertyKey {
    When when() default When.ALWAYS;
}
