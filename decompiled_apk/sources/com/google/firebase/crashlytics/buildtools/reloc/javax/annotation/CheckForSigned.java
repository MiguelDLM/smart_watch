package com.google.firebase.crashlytics.buildtools.reloc.javax.annotation;

import com.google.firebase.crashlytics.buildtools.reloc.javax.annotation.meta.TypeQualifierNickname;
import com.google.firebase.crashlytics.buildtools.reloc.javax.annotation.meta.When;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Nonnegative(when = When.MAYBE)
@TypeQualifierNickname
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes10.dex */
public @interface CheckForSigned {
}
