package androidx.navigation;

import Oox.oIX0oI;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavDeepLink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDeepLink.kt\nandroidx/navigation/NavDeepLink$mimeTypePattern$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,761:1\n1#2:762\n*E\n"})
public final class NavDeepLink$mimeTypePattern$2 extends Lambda implements oIX0oI<Pattern> {
    final /* synthetic */ NavDeepLink this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDeepLink$mimeTypePattern$2(NavDeepLink navDeepLink) {
        super(0);
        this.this$0 = navDeepLink;
    }

    public final Pattern invoke() {
        String access$getMimeTypeRegex$p = this.this$0.mimeTypeRegex;
        if (access$getMimeTypeRegex$p != null) {
            return Pattern.compile(access$getMimeTypeRegex$p);
        }
        return null;
    }
}
