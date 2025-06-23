package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,397:1\n1789#2,3:398\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt\n*L\n19#1:398,3\n*E\n"})
/* loaded from: classes6.dex */
public final class RegexKt {
    public static final /* synthetic */ X0.oOoXoXO I0Io(MatchResult matchResult) {
        return xxIXOIIO(matchResult);
    }

    public static final x0XOIxOo II0XooXoX(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    public static final int OOXIXo(Iterable<? extends Oxx0IOOO> iterable) {
        Iterator<? extends Oxx0IOOO> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i |= it.next().getValue();
        }
        return i;
    }

    public static final /* synthetic */ <T extends Enum<T> & Oxx0IOOO> Set<T> Oxx0IOOO(final int i) {
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        EnumSet allOf = EnumSet.allOf(Enum.class);
        IIX0o.ooOOo0oXI(allOf);
        IIX0o.xoXoI();
        kotlin.collections.OxI.IoIOOxIIo(allOf, new Oox.oOoXoXO<T, Boolean>() { // from class: kotlin.text.RegexKt$fromInt$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/lang/Boolean; */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Boolean invoke(Enum r3) {
                Oxx0IOOO oxx0IOOO = (Oxx0IOOO) r3;
                return Boolean.valueOf((i & oxx0IOOO.getMask()) == oxx0IOOO.getValue());
            }
        });
        Set<T> unmodifiableSet = Collections.unmodifiableSet(allOf);
        IIX0o.oO(unmodifiableSet, "unmodifiableSet(...)");
        return unmodifiableSet;
    }

    public static final x0XOIxOo XO(Matcher matcher, int i, CharSequence charSequence) {
        if (!matcher.find(i)) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    public static final /* synthetic */ x0XOIxOo oIX0oI(Matcher matcher, int i, CharSequence charSequence) {
        return XO(matcher, i, charSequence);
    }

    public static final X0.oOoXoXO xoIox(MatchResult matchResult, int i) {
        return X0.IIXOooo.X00xOoXI(matchResult.start(i), matchResult.end(i));
    }

    public static final X0.oOoXoXO xxIXOIIO(MatchResult matchResult) {
        return X0.IIXOooo.X00xOoXI(matchResult.start(), matchResult.end());
    }
}
