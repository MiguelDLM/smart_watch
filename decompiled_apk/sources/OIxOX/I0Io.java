package OIxOX;

import com.univocity.parsers.conversions.EnumSelector;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes13.dex */
public @interface I0Io {
    String customElement() default "";

    EnumSelector[] selectors() default {EnumSelector.NAME, EnumSelector.ORDINAL, EnumSelector.STRING};
}
