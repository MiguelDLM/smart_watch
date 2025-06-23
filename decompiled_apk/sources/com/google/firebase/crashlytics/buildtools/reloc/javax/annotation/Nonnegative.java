package com.google.firebase.crashlytics.buildtools.reloc.javax.annotation;

import XIXIX.OOXIXo;
import com.google.firebase.crashlytics.buildtools.reloc.javax.annotation.meta.TypeQualifier;
import com.google.firebase.crashlytics.buildtools.reloc.javax.annotation.meta.TypeQualifierValidator;
import com.google.firebase.crashlytics.buildtools.reloc.javax.annotation.meta.When;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@TypeQualifier(applicableTo = Number.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes10.dex */
public @interface Nonnegative {

    /* loaded from: classes10.dex */
    public static class Checker implements TypeQualifierValidator<Nonnegative> {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.javax.annotation.meta.TypeQualifierValidator
        public When forConstantValue(Nonnegative nonnegative, Object obj) {
            if (!(obj instanceof Number)) {
                return When.NEVER;
            }
            Number number = (Number) obj;
            if (!(number instanceof Long) ? !(!(number instanceof Double) ? !(number instanceof Float) ? number.intValue() >= 0 : number.floatValue() >= 0.0f : number.doubleValue() >= OOXIXo.f3760XO) : number.longValue() < 0) {
                return When.NEVER;
            }
            return When.ALWAYS;
        }
    }

    When when() default When.ALWAYS;
}
