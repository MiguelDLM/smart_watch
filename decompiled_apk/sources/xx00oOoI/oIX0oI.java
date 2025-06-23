package xx00oOoI;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlinx.android.extensions.CacheImplementation;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes6.dex */
public @interface oIX0oI {
    CacheImplementation cache() default CacheImplementation.HASH_MAP;
}
