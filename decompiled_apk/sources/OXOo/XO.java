package OXOo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes6.dex */
public final class XO {

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes6.dex */
    public @interface oIX0oI {
        @xoIox
        @Oo0IXI0.oxoX(prefix = "class Renderer{Object[] $childrenArray(){return ", suffix = ";}}", value = "JAVA")
        String childrenArray() default "";

        @xoIox
        @Oo0IXI0.oxoX(prefix = "class Renderer{boolean $hasChildren(){return ", suffix = ";}}", value = "JAVA")
        String hasChildren() default "";

        @xoIox
        @Oo0IXI0.oxoX(prefix = "class Renderer{String $text(){return ", suffix = ";}}", value = "JAVA")
        String text() default "";
    }

    public XO() {
        throw new AssertionError("Debug should not be instantiated");
    }
}
