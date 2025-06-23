package com.facebook.internal.qualityvalidation;

import XxI.oxoX;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@oxoX(allowedTargets = {})
@Target({})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes8.dex */
public @interface Excuse {
    String reason();

    String type();
}
