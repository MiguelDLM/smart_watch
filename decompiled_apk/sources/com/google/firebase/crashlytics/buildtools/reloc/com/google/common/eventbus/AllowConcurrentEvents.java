package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.eventbus;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Beta
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes10.dex */
public @interface AllowConcurrentEvents {
}
