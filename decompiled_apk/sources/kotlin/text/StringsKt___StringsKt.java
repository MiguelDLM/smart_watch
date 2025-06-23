package kotlin.text;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.IIX0;
import kotlin.Pair;
import kotlin.X00IoxXI;
import kotlin.XI0oooXX;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OI0;
import kotlin.collections.SlidingWindowKt;
import kotlin.collections.Xo0;
import kotlin.collections.oOXoIIIo;
import kotlin.collections.oX;
import kotlin.collections.oo0xXOI0I;
import kotlin.collections.xI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.oxxXoxO;
import kotlin.random.Random;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.xxIO;

@XX({"SMAP\n_Strings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,2486:1\n126#1,2:2487\n214#1,5:2489\n502#1,5:2495\n502#1,5:2500\n462#1:2505\n1183#1,2:2506\n463#1,2:2508\n1185#1:2510\n465#1:2511\n462#1:2512\n1183#1,2:2513\n463#1,2:2515\n1185#1:2517\n465#1:2518\n1183#1,3:2519\n492#1,2:2522\n492#1,2:2524\n750#1,4:2526\n719#1,4:2530\n735#1,4:2534\n782#1,4:2538\n882#1,5:2542\n923#1,3:2547\n926#1,3:2557\n941#1,3:2560\n944#1,3:2570\n1041#1,3:2587\n1011#1,4:2590\n1000#1:2594\n1183#1,2:2595\n1185#1:2598\n1001#1:2599\n1183#1,3:2600\n1032#1:2603\n1174#1:2604\n1175#1:2606\n1033#1:2607\n1174#1,2:2608\n1183#1,3:2610\n1982#1,2:2613\n1984#1,6:2616\n2006#1,2:2622\n2008#1,6:2625\n2431#1,6:2631\n2461#1,7:2637\n1#2:2494\n1#2:2597\n1#2:2605\n1#2:2615\n1#2:2624\n372#3,7:2550\n372#3,7:2563\n372#3,7:2573\n372#3,7:2580\n*S KotlinDebug\n*F\n+ 1 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n52#1:2487,2\n62#1:2489,5\n420#1:2495,5\n429#1:2500,5\n440#1:2505\n440#1:2506,2\n440#1:2508,2\n440#1:2510\n440#1:2511\n451#1:2512\n451#1:2513,2\n451#1:2515,2\n451#1:2517\n451#1:2518\n462#1:2519,3\n474#1:2522,2\n483#1:2524,2\n677#1:2526,4\n692#1:2530,4\n706#1:2534,4\n769#1:2538,4\n842#1:2542,5\n898#1:2547,3\n898#1:2557,3\n911#1:2560,3\n911#1:2570,3\n970#1:2587,3\n980#1:2590,4\n990#1:2594\n990#1:2595,2\n990#1:2598\n990#1:2599\n1000#1:2600,3\n1024#1:2603\n1024#1:2604\n1024#1:2606\n1024#1:2607\n1032#1:2608,2\n1786#1:2610,3\n2077#1:2613,2\n2077#1:2616,6\n2095#1:2622,2\n2095#1:2625,6\n2420#1:2631,6\n2448#1:2637,7\n990#1:2597\n1024#1:2605\n2077#1:2615\n2095#1:2624\n898#1:2550,7\n911#1:2563,7\n925#1:2573,7\n943#1:2580,7\n*E\n"})
/* loaded from: classes6.dex */
public class StringsKt___StringsKt extends O0xOxO {

    /* JADX INFO: Add missing generic type declarations: [K] */
    @XX({"SMAP\n_Strings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Strings.kt\nkotlin/text/StringsKt___StringsKt$groupingBy$1\n*L\n1#1,2486:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class I0Io<K> implements kotlin.collections.XxX0x0xxx<Character, K> {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO<Character, K> f29519II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ CharSequence f29520oIX0oI;

        /* JADX WARN: Multi-variable type inference failed */
        public I0Io(CharSequence charSequence, Oox.oOoXoXO<? super Character, ? extends K> oooxoxo) {
            this.f29520oIX0oI = charSequence;
            this.f29519II0xO0 = oooxoxo;
        }

        public K I0Io(char c) {
            return this.f29519II0xO0.invoke(Character.valueOf(c));
        }

        @Override // kotlin.collections.XxX0x0xxx
        @OXOo.OOXIXo
        public Iterator<Character> II0xO0() {
            return StringsKt__StringsKt.IXIxx0(this.f29520oIX0oI);
        }

        @Override // kotlin.collections.XxX0x0xxx
        public /* bridge */ /* synthetic */ Object oIX0oI(Character ch) {
            return I0Io(ch.charValue());
        }
    }

    @XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,680:1\n2483#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class II0xO0 implements kotlin.sequences.ooOOo0oXI<Character> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ CharSequence f29521oIX0oI;

        public II0xO0(CharSequence charSequence) {
            this.f29521oIX0oI = charSequence;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<Character> iterator() {
            return StringsKt__StringsKt.IXIxx0(this.f29521oIX0oI);
        }
    }

    @XX({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,70:1\n2475#2:71\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterable<Character>, OI0IXox.oIX0oI {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ CharSequence f29522XO;

        public oIX0oI(CharSequence charSequence) {
            this.f29522XO = charSequence;
        }

        @Override // java.lang.Iterable
        @OXOo.OOXIXo
        public Iterator<Character> iterator() {
            return StringsKt__StringsKt.IXIxx0(this.f29522XO);
        }
    }

    @OXOo.OOXIXo
    public static final <V> List<V> I00(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo CharSequence other, @OXOo.OOXIXo Oox.x0xO0oo<? super Character, ? super Character, ? extends V> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(charSequence.length(), other.length());
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Character.valueOf(charSequence.charAt(i)), Character.valueOf(other.charAt(i))));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final String I000X(@OXOo.OOXIXo String str, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character I00oX(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Comparator<? super Character> comparator) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            if (comparator.compare(Character.valueOf(charAt), Character.valueOf(charAt2)) > 0) {
                charAt = charAt2;
            }
        }
        return Character.valueOf(charAt);
    }

    @xx0o0O.XO
    public static final Character I0IIXxxo(CharSequence charSequence, Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                return Character.valueOf(charAt);
            }
        }
        return null;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfLong")
    @X00IoxXI
    @xx0o0O.XO
    public static final long I0OXXIoX(CharSequence charSequence, Oox.oOoXoXO<? super Character, Long> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        long j = 0;
        for (int i = 0; i < charSequence.length(); i++) {
            j += selector.invoke(Character.valueOf(charSequence.charAt(i))).longValue();
        }
        return j;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character I0o(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Comparator<? super Character> comparator) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            if (comparator.compare(Character.valueOf(charAt), Character.valueOf(charAt2)) < 0) {
                charAt = charAt2;
            }
        }
        return Character.valueOf(charAt);
    }

    @OXOo.OOXIXo
    public static String I0xoOOIx(@OXOo.OOXIXo String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        if (i >= 0) {
            int length = str.length();
            String substring = str.substring(length - X0.IIXOooo.XI0IXoo(i, length));
            IIX0o.oO(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, List<Character>> IIIo0Xo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            K invoke = keySelector.invoke(Character.valueOf(charAt));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(charAt));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.1")
    public static final <S extends CharSequence> S IIXxoXXox(@OXOo.OOXIXo S s, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(s, "<this>");
        IIX0o.x0xO0oo(action, "action");
        for (int i = 0; i < s.length(); i++) {
            action.invoke(Character.valueOf(s.charAt(i)));
        }
        return s;
    }

    @OXOo.oOoXoXO
    public static final Character IIoIIxx(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        Character ch = null;
        boolean z = false;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                if (z) {
                    return null;
                }
                ch = Character.valueOf(charAt);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return ch;
    }

    @OXOo.OOXIXo
    public static final Set<Character> IIx(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        int length = charSequence.length();
        if (length != 0) {
            if (length != 1) {
                return (Set) OIIoIo(charSequence, new LinkedHashSet(OI0.xoIox(X0.IIXOooo.XI0IXoo(charSequence.length(), 128))));
            }
            return oX.XO(Character.valueOf(charSequence.charAt(0)));
        }
        return Xo0.OOXIXo();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R IOoXX(CharSequence charSequence, Comparator<? super R> comparator, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() != 0) {
            Object obj = (R) selector.invoke(Character.valueOf(charSequence.charAt(0)));
            oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Character.valueOf(charSequence.charAt(it.nextInt())));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Character> IOxoo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.x0xO0oo<? super Character, ? super Character, Character> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        if (charSequence.length() == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        char charAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(charAt));
        int length = charSequence.length();
        int i = 1;
        while (i < length) {
            Character invoke = operation.invoke(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i)));
            char charValue = invoke.charValue();
            arrayList.add(invoke);
            i++;
            charAt = charValue;
        }
        return arrayList;
    }

    @oxxXoxO(version = "1.3")
    public static final char IX0IO(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Random random) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(random, "random");
        if (charSequence.length() != 0) {
            return charSequence.charAt(random.nextInt(charSequence.length()));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    @xx0o0O.XO
    public static final char IX0OOX(CharSequence charSequence, int i, Oox.oOoXoXO<? super Integer, Character> defaultValue) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= StringsKt__StringsKt.IXX(charSequence)) {
            return charSequence.charAt(i);
        }
        return defaultValue.invoke(Integer.valueOf(i)).charValue();
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double IXOO0X0(CharSequence charSequence, Oox.oOoXoXO<? super Character, Double> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Character.valueOf(charSequence.charAt(0))).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(Character.valueOf(charSequence.charAt(it.nextInt()))).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OXOo.OOXIXo
    public static final <R> List<R> IXXxo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < charSequence.length(); i++) {
            kotlin.collections.OxI.XIo0oOXIx(arrayList, transform.invoke(Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R IXoxO(CharSequence charSequence, Comparator<? super R> comparator, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Character.valueOf(charSequence.charAt(0)));
        oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Character.valueOf(charSequence.charAt(it.nextInt())));
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    public static final char IXx(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        int length = charSequence.length();
        if (length != 0) {
            if (length == 1) {
                return charSequence.charAt(0);
            }
            throw new IllegalArgumentException("Char sequence has more than one element.");
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C Io0OXxX(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends R> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            destination.add(transform.invoke(Character.valueOf(charSequence.charAt(i))));
        }
        return destination;
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R IoO(CharSequence charSequence, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        R invoke = selector.invoke(Character.valueOf(charSequence.charAt(0)));
        oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Character.valueOf(charSequence.charAt(it.nextInt())));
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final <R> R IoXIo(CharSequence charSequence, Oox.oOoXoXO<? super Character, ? extends R> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            R invoke = transform.invoke(Character.valueOf(charSequence.charAt(i)));
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }

    public static final boolean IoXOxx0o(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return true;
        }
        return false;
    }

    @OXOo.oOoXoXO
    public static final Character IoooXox0(@OXOo.OOXIXo CharSequence charSequence, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (i >= 0 && i <= StringsKt__StringsKt.IXX(charSequence)) {
            return Character.valueOf(charSequence.charAt(i));
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final String IoxoI0IX(@OXOo.OOXIXo String str, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
            i++;
            i2 = i3;
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float Ix(CharSequence charSequence, Oox.oOoXoXO<? super Character, Float> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() != 0) {
            float floatValue = selector.invoke(Character.valueOf(charSequence.charAt(0))).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(Character.valueOf(charSequence.charAt(it.nextInt()))).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <C extends Appendable> C Ix00(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                destination.append(charAt);
            }
        }
        return destination;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfDouble")
    @X00IoxXI
    @xx0o0O.XO
    public static final double IxIXo(CharSequence charSequence, Oox.oOoXoXO<? super Character, Double> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (int i = 0; i < charSequence.length(); i++) {
            d += selector.invoke(Character.valueOf(charSequence.charAt(i))).doubleValue();
        }
        return d;
    }

    public static final void IxoXXoXo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(action, "action");
        for (int i = 0; i < charSequence.length(); i++) {
            action.invoke(Character.valueOf(charSequence.charAt(i)));
        }
    }

    @OXOo.OOXIXo
    public static final CharSequence IxxOI(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Iterable<Integer> indices) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(indices, "indices");
        int xo0x2 = kotlin.collections.OxxIIOOXO.xo0x(indices, 10);
        if (xo0x2 == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(xo0x2);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            sb.append(charSequence.charAt(it.next().intValue()));
        }
        return sb;
    }

    @OXOo.OOXIXo
    public static final String O0OOoIox(@OXOo.OOXIXo String str, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!predicate.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
                String substring = str.substring(i);
                IIX0o.oO(substring, "substring(...)");
                return substring;
            }
        }
        return "";
    }

    public static final char O0Xo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.x0xO0oo<? super Character, ? super Character, Character> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        if (charSequence.length() != 0) {
            char charAt = charSequence.charAt(0);
            oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
            while (it.hasNext()) {
                charAt = operation.invoke(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(it.nextInt()))).charValue();
            }
            return charAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> O0o(@OXOo.OOXIXo CharSequence charSequence, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super Character, ? extends R> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        for (int i = 0; i < charSequence.length(); i++) {
            r = operation.invoke(r, Character.valueOf(charSequence.charAt(i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Pair<Character, Character>> O0o0OI00(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo CharSequence other) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(other, "other");
        int min = Math.min(charSequence.length(), other.length());
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(kotlin.Xo0.oIX0oI(Character.valueOf(charSequence.charAt(i)), Character.valueOf(other.charAt(i))));
        }
        return arrayList;
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float O0oXOX0XX(CharSequence charSequence, Oox.oOoXoXO<? super Character, Float> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        float floatValue = selector.invoke(Character.valueOf(charSequence.charAt(0))).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(Character.valueOf(charSequence.charAt(it.nextInt()))).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, ? super Character>> M O0x0XXxI(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            destination.put(keySelector.invoke(Character.valueOf(charAt)), Character.valueOf(charAt));
        }
        return destination;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character O0xOXxxx(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Random random) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(random, "random");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(random.nextInt(charSequence.length())));
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.1")
    public static final <K> kotlin.collections.XxX0x0xxx<Character, K> OI(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        return new I0Io(charSequence, keySelector);
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Character>> C OIIoIo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo C destination) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        for (int i = 0; i < charSequence.length(); i++) {
            destination.add(Character.valueOf(charSequence.charAt(i)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.2")
    public static final <R> List<R> OIIxOxx(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.x0xO0oo<? super Character, ? super Character, ? extends R> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(length);
        int i = 0;
        while (i < length) {
            Character valueOf = Character.valueOf(charSequence.charAt(i));
            i++;
            arrayList.add(transform.invoke(valueOf, Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }

    public static final char OIOxOX(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    @OXOo.OOXIXo
    public static final <R> List<R> OIXO(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends R> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < charSequence.length(); i++) {
            R invoke = transform.invoke(Character.valueOf(charSequence.charAt(i)));
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <R> List<R> OOI(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Character, ? extends R> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            int i3 = i2 + 1;
            R invoke = transform.invoke(Integer.valueOf(i2), Character.valueOf(charSequence.charAt(i)));
            if (invoke != null) {
                arrayList.add(invoke);
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    public static final char OOI00oxoO(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Character, ? super Character, Character> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        if (charSequence.length() != 0) {
            char charAt = charSequence.charAt(0);
            oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                charAt = operation.invoke(Integer.valueOf(nextInt), Character.valueOf(charAt), Character.valueOf(charSequence.charAt(nextInt))).charValue();
            }
            return charAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    @OXOo.OOXIXo
    public static String OOOxXxoO(@OXOo.OOXIXo String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        if (i >= 0) {
            return oOI0IXOO(str, X0.IIXOooo.OxxIIOOXO(str.length() - i, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static final int OOX0x(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (predicate.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @xx0o0O.XO
    public static final int OOo(CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return charSequence.length();
    }

    @XO0OX.xxIXOIIO(name = "maxByOrThrow")
    @oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> char OOxOXI0(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends R> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() != 0) {
            char charAt = charSequence.charAt(0);
            int IXX2 = StringsKt__StringsKt.IXX(charSequence);
            if (IXX2 == 0) {
                return charAt;
            }
            R invoke = selector.invoke(Character.valueOf(charAt));
            oOXoIIIo it = new X0.oOoXoXO(1, IXX2).iterator();
            while (it.hasNext()) {
                char charAt2 = charSequence.charAt(it.nextInt());
                R invoke2 = selector.invoke(Character.valueOf(charAt2));
                if (invoke.compareTo(invoke2) < 0) {
                    charAt = charAt2;
                    invoke = invoke2;
                }
            }
            return charAt;
        }
        throw new NoSuchElementException();
    }

    public static final <R> R OXI(@OXOo.OOXIXo CharSequence charSequence, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super Character, ? super R, ? extends R> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        for (int IXX2 = StringsKt__StringsKt.IXX(charSequence); IXX2 >= 0; IXX2--) {
            r = operation.invoke(Character.valueOf(charSequence.charAt(IXX2)), r);
        }
        return r;
    }

    @OXOo.OOXIXo
    public static final CharSequence OXO0(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        StringBuilder reverse = new StringBuilder(charSequence).reverse();
        IIX0o.oO(reverse, "reverse(...)");
        return reverse;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character OXO0oX(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.x0xO0oo<? super Character, ? super Character, Character> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
        while (it.hasNext()) {
            charAt = operation.invoke(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(it.nextInt()))).charValue();
        }
        return Character.valueOf(charAt);
    }

    @OXOo.oOoXoXO
    public static Character OXXxXoO(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(0));
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterable")
    @X00IoxXI
    @xx0o0O.XO
    public static final <R> List<R> OXoIOx(CharSequence charSequence, Oox.x0xO0oo<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            kotlin.collections.OxI.XIo0oOXIx(arrayList, transform.invoke(Integer.valueOf(i2), Character.valueOf(charSequence.charAt(i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final String OXoIXx(@OXOo.OOXIXo String str, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int IXX2 = StringsKt__StringsKt.IXX(str); -1 < IXX2; IXX2--) {
            if (!predicate.invoke(Character.valueOf(str.charAt(IXX2))).booleanValue()) {
                String substring = str.substring(0, IXX2 + 1);
                IIX0o.oO(substring, "substring(...)");
                return substring;
            }
        }
        return "";
    }

    @OXOo.OOXIXo
    public static final HashSet<Character> OXxXoOx(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return (HashSet) OIIoIo(charSequence, new HashSet(OI0.xoIox(X0.IIXOooo.XI0IXoo(charSequence.length(), 128))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R OoIoI0(CharSequence charSequence, Comparator<? super R> comparator, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() != 0) {
            Object obj = (R) selector.invoke(Character.valueOf(charSequence.charAt(0)));
            oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Character.valueOf(charSequence.charAt(it.nextInt())));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final String OooXX0(@OXOo.OOXIXo String str, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!predicate.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
                String substring = str.substring(0, i);
                IIX0o.oO(substring, "substring(...)");
                return substring;
            }
        }
        return str;
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double OoooxII(CharSequence charSequence, Oox.oOoXoXO<? super Character, Double> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Character.valueOf(charSequence.charAt(0))).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(Character.valueOf(charSequence.charAt(it.nextInt()))).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OXOo.oOoXoXO
    public static final Character Ox0(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                return Character.valueOf(charAt);
            }
        }
        return null;
    }

    @xx0o0O.XO
    public static final Character OxI0(CharSequence charSequence, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return IoooXox0(charSequence, i);
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C OxIXxXXI0(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends R> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            R invoke = transform.invoke(Character.valueOf(charSequence.charAt(i)));
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R OxXIoIX(CharSequence charSequence, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() != 0) {
            R invoke = selector.invoke(Character.valueOf(charSequence.charAt(0)));
            oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Character.valueOf(charSequence.charAt(it.nextInt())));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    public static final char OxXIoIxIo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        Character ch = null;
        boolean z = false;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                if (!z) {
                    ch = Character.valueOf(charAt);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Char sequence contains more than one matching element.");
                }
            }
        }
        if (z) {
            IIX0o.x0XOIxOo(ch, "null cannot be cast to non-null type kotlin.Char");
            return ch.charValue();
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.3")
    public static final <V, M extends Map<? super Character, ? super V>> M OxXXx0OX(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends V> valueSelector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(valueSelector, "valueSelector");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            destination.put(Character.valueOf(charAt), valueSelector.invoke(Character.valueOf(charAt)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, Character> OxxIXIX(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(charSequence.length()), 16));
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            linkedHashMap.put(keySelector.invoke(Character.valueOf(charAt)), Character.valueOf(charAt));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <C extends Appendable> C X0Ix00XxO(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Character.valueOf(charAt)).booleanValue()) {
                destination.append(charAt);
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfULong")
    @X00IoxXI
    @xx0o0O.XO
    public static final long X0OIo0XxO(CharSequence charSequence, Oox.oOoXoXO<? super Character, XI0oooXX> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        long oOoXoXO2 = XI0oooXX.oOoXoXO(0L);
        for (int i = 0; i < charSequence.length(); i++) {
            oOoXoXO2 = XI0oooXX.oOoXoXO(oOoXoXO2 + selector.invoke(Character.valueOf(charSequence.charAt(i))).OO());
        }
        return oOoXoXO2;
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.2")
    public static List<String> X0OXI(@OXOo.OOXIXo CharSequence charSequence, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return Xo0oxxX0(charSequence, i, i, true);
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Character X0xO(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends R> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int IXX2 = StringsKt__StringsKt.IXX(charSequence);
        if (IXX2 == 0) {
            return Character.valueOf(charAt);
        }
        R invoke = selector.invoke(Character.valueOf(charAt));
        oOXoIIIo it = new X0.oOoXoXO(1, IXX2).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            R invoke2 = selector.invoke(Character.valueOf(charAt2));
            if (invoke.compareTo(invoke2) < 0) {
                charAt = charAt2;
                invoke = invoke2;
            }
        }
        return Character.valueOf(charAt);
    }

    public static final char X0xX(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.x0xO0oo<? super Character, ? super Character, Character> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        int IXX2 = StringsKt__StringsKt.IXX(charSequence);
        if (IXX2 >= 0) {
            char charAt = charSequence.charAt(IXX2);
            for (int i = IXX2 - 1; i >= 0; i--) {
                charAt = operation.invoke(Character.valueOf(charSequence.charAt(i)), Character.valueOf(charAt)).charValue();
            }
            return charAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    @XO0OX.xxIXOIIO(name = "minWithOrThrow")
    @oxxXoxO(version = "1.7")
    public static final char X0xXOX(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Comparator<? super Character> comparator) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (charSequence.length() != 0) {
            char charAt = charSequence.charAt(0);
            oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
            while (it.hasNext()) {
                char charAt2 = charSequence.charAt(it.nextInt());
                if (comparator.compare(Character.valueOf(charAt), Character.valueOf(charAt2)) > 0) {
                    charAt = charAt2;
                }
            }
            return charAt;
        }
        throw new NoSuchElementException();
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character XI0(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            if (IIX0o.oI0IIXIo(charAt, charAt2) > 0) {
                charAt = charAt2;
            }
        }
        return Character.valueOf(charAt);
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> XIOX(@OXOo.OOXIXo CharSequence charSequence, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super Character, ? extends R> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        for (int i = 0; i < charSequence.length(); i++) {
            r = operation.invoke(r, Character.valueOf(charSequence.charAt(i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double XIOoI(CharSequence charSequence, Oox.oOoXoXO<? super Character, Double> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() != 0) {
            double doubleValue = selector.invoke(Character.valueOf(charSequence.charAt(0))).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(Character.valueOf(charSequence.charAt(it.nextInt()))).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final CharSequence XIX(@OXOo.OOXIXo CharSequence charSequence, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (i >= 0) {
            int length = charSequence.length();
            return charSequence.subSequence(length - X0.IIXOooo.XI0IXoo(i, length), length);
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    @xx0o0O.XO
    public static final Character XIoox00ox(CharSequence charSequence, Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                char charAt = charSequence.charAt(length);
                if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                    return Character.valueOf(charAt);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return null;
    }

    public static final boolean XIxoOo0oI(@OXOo.OOXIXo CharSequence charSequence) {
        boolean z;
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (charSequence.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @OXOo.OOXIXo
    public static final Pair<CharSequence, CharSequence> XOIIOIx(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            } else {
                sb2.append(charAt);
            }
        }
        return new Pair<>(sb, sb2);
    }

    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @oxxXoxO(version = "1.7")
    public static final char XOO(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (charSequence.length() != 0) {
            char charAt = charSequence.charAt(0);
            oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
            while (it.hasNext()) {
                char charAt2 = charSequence.charAt(it.nextInt());
                if (IIX0o.oI0IIXIo(charAt, charAt2) < 0) {
                    charAt = charAt2;
                }
            }
            return charAt;
        }
        throw new NoSuchElementException();
    }

    public static final char XOOI0(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                return charAt;
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    public static /* synthetic */ List XOOooo(CharSequence charSequence, int i, int i2, boolean z, Oox.oOoXoXO oooxoxo, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return oIoox0(charSequence, i, i2, z, oooxoxo);
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character XOX0XxOxI(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            if (IIX0o.oI0IIXIo(charAt, charAt2) < 0) {
                charAt = charAt2;
            }
        }
        return Character.valueOf(charAt);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfUInt")
    @X00IoxXI
    @xx0o0O.XO
    public static final int XOXo0(CharSequence charSequence, Oox.oOoXoXO<? super Character, xxIO> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        for (int i = 0; i < charSequence.length(); i++) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + selector.invoke(Character.valueOf(charSequence.charAt(i))).OO());
        }
        return oOoXoXO2;
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final double XOoI(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Double> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (int i = 0; i < charSequence.length(); i++) {
            d += selector.invoke(Character.valueOf(charSequence.charAt(i))).doubleValue();
        }
        return d;
    }

    public static final boolean XOoxOOO(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<Character> XOx0xX(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if ((charSequence instanceof String) && charSequence.length() == 0) {
            return SequencesKt__SequencesKt.Oxx0IOOO();
        }
        return new II0xO0(charSequence);
    }

    @OXOo.oOoXoXO
    public static final Character XX00xxo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            char charAt = charSequence.charAt(length);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                return Character.valueOf(charAt);
            }
            if (i >= 0) {
                length = i;
            } else {
                return null;
            }
        }
    }

    public static final int XXOOoxx0x(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R XXOo(CharSequence charSequence, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        R invoke = selector.invoke(Character.valueOf(charSequence.charAt(0)));
        oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Character.valueOf(charSequence.charAt(it.nextInt())));
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character XXXoOII(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Character, ? super Character, Character> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            charAt = operation.invoke(Integer.valueOf(nextInt), Character.valueOf(charAt), Character.valueOf(charSequence.charAt(nextInt))).charValue();
        }
        return Character.valueOf(charAt);
    }

    @OXOo.OOXIXo
    public static final CharSequence XXoOOO0I(@OXOo.OOXIXo CharSequence charSequence, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (i >= 0) {
            return charSequence.subSequence(0, X0.IIXOooo.XI0IXoo(i, charSequence.length()));
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.2")
    public static final List<String> Xo0oxxX0(@OXOo.OOXIXo CharSequence charSequence, int i, int i2, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return oIoox0(charSequence, i, i2, z, new Oox.oOoXoXO<CharSequence, String>() { // from class: kotlin.text.StringsKt___StringsKt$windowed$1
            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final String invoke(@OXOo.OOXIXo CharSequence it) {
                IIX0o.x0xO0oo(it, "it");
                return it.toString();
            }
        });
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C XoI0OoX(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            kotlin.collections.OxI.XIo0oOXIx(destination, transform.invoke(Character.valueOf(charSequence.charAt(i))));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, List<Character>>> M XoIxo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            K invoke = keySelector.invoke(Character.valueOf(charAt));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(charAt));
        }
        return destination;
    }

    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @oxxXoxO(version = "1.7")
    public static final char XoO(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (charSequence.length() != 0) {
            char charAt = charSequence.charAt(0);
            oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
            while (it.hasNext()) {
                char charAt2 = charSequence.charAt(it.nextInt());
                if (IIX0o.oI0IIXIo(charAt, charAt2) > 0) {
                    charAt = charAt2;
                }
            }
            return charAt;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C XoOOxOo0o(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Character, ? extends R> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            int i3 = i2 + 1;
            R invoke = transform.invoke(Integer.valueOf(i2), Character.valueOf(charSequence.charAt(i)));
            if (invoke != null) {
                destination.add(invoke);
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final CharSequence Xooo0Xx(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterableTo")
    @X00IoxXI
    @xx0o0O.XO
    public static final <R, C extends Collection<? super R>> C Xx0OXIoI(CharSequence charSequence, C destination, Oox.x0xO0oo<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            kotlin.collections.OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i2), Character.valueOf(charSequence.charAt(i))));
            i++;
            i2++;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final CharSequence XxIO0(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int IXX2 = StringsKt__StringsKt.IXX(charSequence); -1 < IXX2; IXX2--) {
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(IXX2))).booleanValue()) {
                return charSequence.subSequence(0, IXX2 + 1);
            }
        }
        return "";
    }

    public static final boolean XxoOI00IX(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            if (predicate.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R XxxIX(CharSequence charSequence, Comparator<? super R> comparator, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Character.valueOf(charSequence.charAt(0)));
        oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Character.valueOf(charSequence.charAt(it.nextInt())));
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @OXOo.OOXIXo
    public static final String o00Ox0xOO(@OXOo.OOXIXo String str, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int IXX2 = StringsKt__StringsKt.IXX(str); -1 < IXX2; IXX2--) {
            if (!predicate.invoke(Character.valueOf(str.charAt(IXX2))).booleanValue()) {
                String substring = str.substring(IXX2 + 1);
                IIX0o.oO(substring, "substring(...)");
                return substring;
            }
        }
        return str;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Character o0I(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends R> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int IXX2 = StringsKt__StringsKt.IXX(charSequence);
        if (IXX2 == 0) {
            return Character.valueOf(charAt);
        }
        R invoke = selector.invoke(Character.valueOf(charAt));
        oOXoIIIo it = new X0.oOoXoXO(1, IXX2).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            R invoke2 = selector.invoke(Character.valueOf(charAt2));
            if (invoke.compareTo(invoke2) > 0) {
                charAt = charAt2;
                invoke = invoke2;
            }
        }
        return Character.valueOf(charAt);
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.3")
    public static final <V> Map<Character, V> o0I0O0oXX(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends V> valueSelector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(X0.IIXOooo.XI0IXoo(charSequence.length(), 128)), 16));
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            linkedHashMap.put(Character.valueOf(charAt), valueSelector.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    public static final <R> R o0Ixx(@OXOo.OOXIXo CharSequence charSequence, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super Character, ? extends R> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        for (int i = 0; i < charSequence.length(); i++) {
            r = operation.invoke(r, Character.valueOf(charSequence.charAt(i)));
        }
        return r;
    }

    public static final int o0OoX(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final int o0Xo0XX(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Integer> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            i += selector.invoke(Character.valueOf(charSequence.charAt(i2))).intValue();
        }
        return i;
    }

    public static final boolean o0XxxOIx(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            if (predicate.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @OXOo.oOoXoXO
    public static final Character o0x0XOXx(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }

    public static /* synthetic */ kotlin.sequences.ooOOo0oXI oIIXxXIox(CharSequence charSequence, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return ox0xI00IX(charSequence, i, i2, z);
    }

    @xx0o0O.XO
    public static final String oIo0OoXIo(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return OXO0(str).toString();
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.2")
    public static final <R> List<R> oIoIxo(@OXOo.OOXIXo CharSequence charSequence, int i, @OXOo.OOXIXo Oox.oOoXoXO<? super CharSequence, ? extends R> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        return oIoox0(charSequence, i, i, true, transform);
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.2")
    public static final <R> List<R> oIoox0(@OXOo.OOXIXo CharSequence charSequence, int i, int i2, boolean z, @OXOo.OOXIXo Oox.oOoXoXO<? super CharSequence, ? extends R> transform) {
        int i3;
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        SlidingWindowKt.oIX0oI(i, i2);
        int length = charSequence.length();
        int i4 = length / i2;
        int i5 = 0;
        if (length % i2 == 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        ArrayList arrayList = new ArrayList(i4 + i3);
        while (i5 >= 0 && i5 < length) {
            int i6 = i5 + i;
            if (i6 < 0 || i6 > length) {
                if (!z) {
                    break;
                }
                i6 = length;
            }
            arrayList.add(transform.invoke(charSequence.subSequence(i5, i6)));
            i5 += i2;
        }
        return arrayList;
    }

    @xx0o0O.XO
    public static final String oIxIO(String str, Iterable<Integer> indices) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(indices, "indices");
        return IxxOI(str, indices).toString();
    }

    public static /* synthetic */ List oIxIOoOx(CharSequence charSequence, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return Xo0oxxX0(charSequence, i, i2, z);
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> oIxXX0Xo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(charSequence.length()), 16));
        for (int i = 0; i < charSequence.length(); i++) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Character.valueOf(charSequence.charAt(i)));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static String oOI0IXOO(@OXOo.OOXIXo String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        if (i >= 0) {
            String substring = str.substring(0, X0.IIXOooo.XI0IXoo(i, str.length()));
            IIX0o.oO(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> oOx0xoXI(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends V> valueTransform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(charSequence.length()), 16));
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            linkedHashMap.put(keySelector.invoke(Character.valueOf(charAt)), valueTransform.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final Iterable<Character> oOxoXxoX(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if ((charSequence instanceof String) && charSequence.length() == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return new oIX0oI(charSequence);
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double oX0Ox(CharSequence charSequence, Oox.oOoXoXO<? super Character, Double> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() != 0) {
            double doubleValue = selector.invoke(Character.valueOf(charSequence.charAt(0))).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(Character.valueOf(charSequence.charAt(it.nextInt()))).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.2")
    public static final List<Pair<Character, Character>> oXIOOxX(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(length);
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            i++;
            arrayList.add(kotlin.Xo0.oIX0oI(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }

    @XO0OX.xxIXOIIO(name = "maxWithOrThrow")
    @oxxXoxO(version = "1.7")
    public static final char oXIo0X0x(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Comparator<? super Character> comparator) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (charSequence.length() != 0) {
            char charAt = charSequence.charAt(0);
            oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
            while (it.hasNext()) {
                char charAt2 = charSequence.charAt(it.nextInt());
                if (comparator.compare(Character.valueOf(charAt), Character.valueOf(charAt2)) < 0) {
                    charAt = charAt2;
                }
            }
            return charAt;
        }
        throw new NoSuchElementException();
    }

    @OXOo.oOoXoXO
    public static final Character oXX0(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfInt")
    @X00IoxXI
    @xx0o0O.XO
    public static final int oXXI0(CharSequence charSequence, Oox.oOoXoXO<? super Character, Integer> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            i += selector.invoke(Character.valueOf(charSequence.charAt(i2))).intValue();
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final CharSequence oXXX(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(0, i);
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final char oXxo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Character, ? super Character, Character> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        int IXX2 = StringsKt__StringsKt.IXX(charSequence);
        if (IXX2 >= 0) {
            char charAt = charSequence.charAt(IXX2);
            for (int i = IXX2 - 1; i >= 0; i--) {
                charAt = operation.invoke(Integer.valueOf(i), Character.valueOf(charSequence.charAt(i)), Character.valueOf(charAt)).charValue();
            }
            return charAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character oo0(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.x0xO0oo<? super Character, ? super Character, Character> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        int IXX2 = StringsKt__StringsKt.IXX(charSequence);
        if (IXX2 < 0) {
            return null;
        }
        char charAt = charSequence.charAt(IXX2);
        for (int i = IXX2 - 1; i >= 0; i--) {
            charAt = operation.invoke(Character.valueOf(charSequence.charAt(i)), Character.valueOf(charAt)).charValue();
        }
        return Character.valueOf(charAt);
    }

    @OXOo.OOXIXo
    public static final Iterable<xI<Character>> ooOxox(@OXOo.OOXIXo final CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return new oo0xXOI0I(new Oox.oIX0oI<Iterator<? extends Character>>() { // from class: kotlin.text.StringsKt___StringsKt$withIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Iterator<? extends Character> invoke() {
                return StringsKt__StringsKt.IXIxx0(charSequence);
            }
        });
    }

    @OXOo.OOXIXo
    public static final List<Character> ooX0xXIoI(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return (List) OIIoIo(charSequence, new ArrayList(charSequence.length()));
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.2")
    public static final <R> kotlin.sequences.ooOOo0oXI<R> ooXXoOx(@OXOo.OOXIXo final CharSequence charSequence, final int i, int i2, boolean z, @OXOo.OOXIXo final Oox.oOoXoXO<? super CharSequence, ? extends R> transform) {
        X0.oOoXoXO X00xOoXI2;
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        SlidingWindowKt.oIX0oI(i, i2);
        if (z) {
            X00xOoXI2 = StringsKt__StringsKt.OIxI0O(charSequence);
        } else {
            X00xOoXI2 = X0.IIXOooo.X00xOoXI(0, (charSequence.length() - i) + 1);
        }
        return SequencesKt___SequencesKt.X0xxXX0(CollectionsKt___CollectionsKt.OooI(X0.IIXOooo.OIx00oxx(X00xOoXI2, i2)), new Oox.oOoXoXO<Integer, R>() { // from class: kotlin.text.StringsKt___StringsKt$windowedSequence$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final R invoke(int i3) {
                int i4 = i + i3;
                if (i4 < 0 || i4 > charSequence.length()) {
                    i4 = charSequence.length();
                }
                return transform.invoke(charSequence.subSequence(i3, i4));
            }
        });
    }

    @OXOo.OOXIXo
    public static final Pair<String, String> ooo(@OXOo.OOXIXo String str, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            } else {
                sb2.append(charAt);
            }
        }
        String sb3 = sb.toString();
        IIX0o.oO(sb3, "toString(...)");
        String sb4 = sb2.toString();
        IIX0o.oO(sb4, "toString(...)");
        return new Pair<>(sb3, sb4);
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M oooO0oo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Character.valueOf(charSequence.charAt(i)));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final CharSequence oox(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
            i++;
            i2 = i3;
        }
        return sb;
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.2")
    public static final kotlin.sequences.ooOOo0oXI<String> ox0xI00IX(@OXOo.OOXIXo CharSequence charSequence, int i, int i2, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return ooXXoOx(charSequence, i, i2, z, new Oox.oOoXoXO<CharSequence, String>() { // from class: kotlin.text.StringsKt___StringsKt$windowedSequence$1
            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final String invoke(@OXOo.OOXIXo CharSequence it) {
                IIX0o.x0xO0oo(it, "it");
                return it.toString();
            }
        });
    }

    public static final char oxoIOxO(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                char charAt = charSequence.charAt(length);
                if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                    return charAt;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> oxxX(@OXOo.OOXIXo CharSequence charSequence, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Character.valueOf(charSequence.charAt(i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <R> List<R> x0I0(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Character, ? extends R> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Character.valueOf(charSequence.charAt(i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static String x0Ix0O(@OXOo.OOXIXo String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        if (i >= 0) {
            String substring = str.substring(X0.IIXOooo.XI0IXoo(i, str.length()));
            IIX0o.oO(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static char x0ooOIxO(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(StringsKt__StringsKt.IXX(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static final <R> R x0x(@OXOo.OOXIXo CharSequence charSequence, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            R r2 = r;
            r = operation.invoke(Integer.valueOf(i2), r2, Character.valueOf(charSequence.charAt(i)));
            i++;
            i2++;
        }
        return r;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character xIO(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Character, ? super Character, Character> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        int IXX2 = StringsKt__StringsKt.IXX(charSequence);
        if (IXX2 < 0) {
            return null;
        }
        char charAt = charSequence.charAt(IXX2);
        for (int i = IXX2 - 1; i >= 0; i--) {
            charAt = operation.invoke(Integer.valueOf(i), Character.valueOf(charSequence.charAt(i)), Character.valueOf(charAt)).charValue();
        }
        return Character.valueOf(charAt);
    }

    @OXOo.OOXIXo
    public static final CharSequence xIOI0xO(@OXOo.OOXIXo CharSequence charSequence, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (i >= 0) {
            return charSequence.subSequence(X0.IIXOooo.XI0IXoo(i, charSequence.length()), charSequence.length());
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    public static final <C extends Appendable> C xIOOIO(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                destination.append(charAt);
            }
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final CharSequence xIXXIo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    @OXOo.OOXIXo
    public static final String xIo0xoOOx(@OXOo.OOXIXo String str, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }

    @XO0OX.xxIXOIIO(name = "minByOrThrow")
    @oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> char xO0x00ox(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends R> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() != 0) {
            char charAt = charSequence.charAt(0);
            int IXX2 = StringsKt__StringsKt.IXX(charSequence);
            if (IXX2 == 0) {
                return charAt;
            }
            R invoke = selector.invoke(Character.valueOf(charAt));
            oOXoIIIo it = new X0.oOoXoXO(1, IXX2).iterator();
            while (it.hasNext()) {
                char charAt2 = charSequence.charAt(it.nextInt());
                R invoke2 = selector.invoke(Character.valueOf(charAt2));
                if (invoke.compareTo(invoke2) > 0) {
                    charAt = charAt2;
                    invoke = invoke2;
                }
            }
            return charAt;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.2")
    public static final <R> kotlin.sequences.ooOOo0oXI<R> xOOxX(@OXOo.OOXIXo CharSequence charSequence, int i, @OXOo.OOXIXo Oox.oOoXoXO<? super CharSequence, ? extends R> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        return ooXXoOx(charSequence, i, i, true, transform);
    }

    @OXOo.OOXIXo
    public static final List<Character> xOXI(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        int length = charSequence.length();
        if (length != 0) {
            if (length != 1) {
                return ooX0xXIoI(charSequence);
            }
            return kotlin.collections.oI0IIXIo.OOXIXo(Character.valueOf(charSequence.charAt(0)));
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M xOXoxI(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends V> valueTransform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            destination.put(keySelector.invoke(Character.valueOf(charAt)), valueTransform.invoke(Character.valueOf(charAt)));
        }
        return destination;
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float xOo(CharSequence charSequence, Oox.oOoXoXO<? super Character, Float> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        float floatValue = selector.invoke(Character.valueOf(charSequence.charAt(0))).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(Character.valueOf(charSequence.charAt(it.nextInt()))).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static final String xOxxIxxI0(@OXOo.OOXIXo String str, @OXOo.OOXIXo X0.oOoXoXO indices) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return "";
        }
        return StringsKt__StringsKt.IIXOxIxOo(str, indices);
    }

    public static /* synthetic */ kotlin.sequences.ooOOo0oXI xXIO(CharSequence charSequence, int i, int i2, boolean z, Oox.oOoXoXO oooxoxo, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return ooXXoOx(charSequence, i, i2, z, oooxoxo);
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R xXIxxo0x(CharSequence charSequence, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() != 0) {
            R invoke = selector.invoke(Character.valueOf(charSequence.charAt(0)));
            oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Character.valueOf(charSequence.charAt(it.nextInt())));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    public static final <R> R xXOO(@OXOo.OOXIXo CharSequence charSequence, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Character, ? super R, ? extends R> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        for (int IXX2 = StringsKt__StringsKt.IXX(charSequence); IXX2 >= 0; IXX2--) {
            r = operation.invoke(Integer.valueOf(IXX2), Character.valueOf(charSequence.charAt(IXX2)), r);
        }
        return r;
    }

    @OXOo.OOXIXo
    public static final <R> List<R> xXXXox(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends R> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            arrayList.add(transform.invoke(Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final CharSequence xXx0x0(@OXOo.OOXIXo CharSequence charSequence, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (i >= 0) {
            return XXoOOO0I(charSequence, X0.IIXOooo.OxxIIOOXO(charSequence.length() - i, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float xXxIoIXX0(CharSequence charSequence, Oox.oOoXoXO<? super Character, Float> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() != 0) {
            float floatValue = selector.invoke(Character.valueOf(charSequence.charAt(0))).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, StringsKt__StringsKt.IXX(charSequence)).iterator();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(Character.valueOf(charSequence.charAt(it.nextInt()))).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <S extends CharSequence> S xoI(@OXOo.OOXIXo S s, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Character, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(s, "<this>");
        IIX0o.x0xO0oo(action, "action");
        int i = 0;
        int i2 = 0;
        while (i < s.length()) {
            action.invoke(Integer.valueOf(i2), Character.valueOf(s.charAt(i)));
            i++;
            i2++;
        }
        return s;
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.2")
    public static final kotlin.sequences.ooOOo0oXI<String> xoIIIOI(@OXOo.OOXIXo CharSequence charSequence, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return xOOxX(charSequence, i, new Oox.oOoXoXO<CharSequence, String>() { // from class: kotlin.text.StringsKt___StringsKt$chunkedSequence$1
            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final String invoke(@OXOo.OOXIXo CharSequence it) {
                IIX0o.x0xO0oo(it, "it");
                return it.toString();
            }
        });
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, List<V>> xoO0(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends V> valueTransform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            K invoke = keySelector.invoke(Character.valueOf(charAt));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final <R> R xoOI00O0X(CharSequence charSequence, Oox.oOoXoXO<? super Character, ? extends R> transform) {
        R r;
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        int i = 0;
        while (true) {
            if (i < charSequence.length()) {
                r = transform.invoke(Character.valueOf(charSequence.charAt(i)));
                if (r != null) {
                    break;
                }
                i++;
            } else {
                r = null;
                break;
            }
        }
        if (r != null) {
            return r;
        }
        throw new NoSuchElementException("No element of the char sequence was transformed to a non-null value.");
    }

    @OXOo.OOXIXo
    public static final CharSequence xoOX00(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo X0.oOoXoXO indices) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return "";
        }
        return StringsKt__StringsKt.OXOo(charSequence, indices);
    }

    public static final void xoOx(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Character, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(action, "action");
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            action.invoke(Integer.valueOf(i2), Character.valueOf(charSequence.charAt(i)));
            i++;
            i2++;
        }
    }

    @OXOo.OOXIXo
    public static final CharSequence xooXo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Character xoxXoXO(CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return O0xOXxxx(charSequence, Random.Default);
    }

    @OXOo.OOXIXo
    public static final CharSequence xx0XoXxI(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int IXX2 = StringsKt__StringsKt.IXX(charSequence); -1 < IXX2; IXX2--) {
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(IXX2))).booleanValue()) {
                return charSequence.subSequence(IXX2 + 1, charSequence.length());
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Character> xxI0x(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Character, ? super Character, Character> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        if (charSequence.length() == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        char charAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(charAt));
        int length = charSequence.length();
        int i = 1;
        while (i < length) {
            Character invoke = operation.invoke(Integer.valueOf(i), Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i)));
            char charValue = invoke.charValue();
            arrayList.add(invoke);
            i++;
            charAt = charValue;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C xxIOxXI(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Character, ? extends R> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            destination.add(transform.invoke(Integer.valueOf(i2), Character.valueOf(charSequence.charAt(i))));
            i++;
            i2++;
        }
        return destination;
    }

    @xx0o0O.XO
    public static final char xxX0X(CharSequence charSequence, int i, Oox.oOoXoXO<? super Integer, Character> defaultValue) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= StringsKt__StringsKt.IXX(charSequence)) {
            return charSequence.charAt(i);
        }
        return defaultValue.invoke(Integer.valueOf(i)).charValue();
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final char xxXxI(CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return IX0IO(charSequence, Random.Default);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> xxo00(@OXOo.OOXIXo CharSequence charSequence, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Character.valueOf(charSequence.charAt(i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, List<V>>> M xxxxxo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends V> valueTransform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            K invoke = keySelector.invoke(Character.valueOf(charAt));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Character.valueOf(charAt)));
        }
        return destination;
    }
}
