package okhttp3;

import OI0IXox.oIX0oI;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.Xo0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.II0XooXoX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import xx0o0O.x0XOIxOo;

/* loaded from: classes6.dex */
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, oIX0oI {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private final String[] namesAndValues;

    @XX({"SMAP\nHeaders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Headers.kt\nokhttp3/Headers$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,458:1\n1#2:459\n37#3,2:460\n*S KotlinDebug\n*F\n+ 1 Headers.kt\nokhttp3/Headers$Builder\n*L\n359#1:460,2\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class Builder {

        @OOXIXo
        private final List<String> namesAndValues = new ArrayList(20);

        @OOXIXo
        public final Builder add(@OOXIXo String line) {
            IIX0o.x0xO0oo(line, "line");
            int XxIIOXIXx2 = StringsKt__StringsKt.XxIIOXIXx(line, ':', 0, false, 6, null);
            if (XxIIOXIXx2 != -1) {
                String substring = line.substring(0, XxIIOXIXx2);
                IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String obj = StringsKt__StringsKt.oIoIXxIO(substring).toString();
                String substring2 = line.substring(XxIIOXIXx2 + 1);
                IIX0o.oO(substring2, "this as java.lang.String).substring(startIndex)");
                add(obj, substring2);
                return this;
            }
            throw new IllegalArgumentException(("Unexpected header: " + line).toString());
        }

        @OOXIXo
        public final Builder addAll(@OOXIXo Headers headers) {
            IIX0o.x0xO0oo(headers, "headers");
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                addLenient$okhttp(headers.name(i), headers.value(i));
            }
            return this;
        }

        @OOXIXo
        public final Builder addLenient$okhttp(@OOXIXo String line) {
            IIX0o.x0xO0oo(line, "line");
            int XxIIOXIXx2 = StringsKt__StringsKt.XxIIOXIXx(line, ':', 1, false, 4, null);
            if (XxIIOXIXx2 != -1) {
                String substring = line.substring(0, XxIIOXIXx2);
                IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String substring2 = line.substring(XxIIOXIXx2 + 1);
                IIX0o.oO(substring2, "this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(substring, substring2);
            } else if (line.charAt(0) == ':') {
                String substring3 = line.substring(1);
                IIX0o.oO(substring3, "this as java.lang.String).substring(startIndex)");
                addLenient$okhttp("", substring3);
            } else {
                addLenient$okhttp("", line);
            }
            return this;
        }

        @OOXIXo
        public final Builder addUnsafeNonAscii(@OOXIXo String name, @OOXIXo String value) {
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(value, "value");
            Headers.Companion.checkName(name);
            addLenient$okhttp(name, value);
            return this;
        }

        @OOXIXo
        public final Headers build() {
            return new Headers((String[]) this.namesAndValues.toArray(new String[0]), null);
        }

        @oOoXoXO
        public final String get(@OOXIXo String name) {
            IIX0o.x0xO0oo(name, "name");
            int size = this.namesAndValues.size() - 2;
            int I0Io2 = x0XOIxOo.I0Io(size, 0, -2);
            if (I0Io2 <= size) {
                while (!OxI.oX0I0O(name, this.namesAndValues.get(size), true)) {
                    if (size != I0Io2) {
                        size -= 2;
                    } else {
                        return null;
                    }
                }
                return this.namesAndValues.get(size + 1);
            }
            return null;
        }

        @OOXIXo
        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        @OOXIXo
        public final Builder removeAll(@OOXIXo String name) {
            IIX0o.x0xO0oo(name, "name");
            int i = 0;
            while (i < this.namesAndValues.size()) {
                if (OxI.oX0I0O(name, this.namesAndValues.get(i), true)) {
                    this.namesAndValues.remove(i);
                    this.namesAndValues.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        @OOXIXo
        public final Builder set(@OOXIXo String name, @OOXIXo Date value) {
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(value, "value");
            set(name, DatesKt.toHttpDateString(value));
            return this;
        }

        @OOXIXo
        @IgnoreJRERequirement
        public final Builder set(@OOXIXo String name, @OOXIXo Instant value) {
            long epochMilli;
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(value, "value");
            epochMilli = value.toEpochMilli();
            return set(name, new Date(epochMilli));
        }

        @OOXIXo
        public final Builder set(@OOXIXo String name, @OOXIXo String value) {
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(value, "value");
            Companion companion = Headers.Companion;
            companion.checkName(name);
            companion.checkValue(value, name);
            removeAll(name);
            addLenient$okhttp(name, value);
            return this;
        }

        @OOXIXo
        public final Builder add(@OOXIXo String name, @OOXIXo String value) {
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(value, "value");
            Companion companion = Headers.Companion;
            companion.checkName(name);
            companion.checkValue(value, name);
            addLenient$okhttp(name, value);
            return this;
        }

        @OOXIXo
        public final Builder add(@OOXIXo String name, @OOXIXo Date value) {
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(value, "value");
            add(name, DatesKt.toHttpDateString(value));
            return this;
        }

        @OOXIXo
        public final Builder addLenient$okhttp(@OOXIXo String name, @OOXIXo String value) {
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(value, "value");
            this.namesAndValues.add(name);
            this.namesAndValues.add(StringsKt__StringsKt.oIoIXxIO(value).toString());
            return this;
        }

        @OOXIXo
        @IgnoreJRERequirement
        public final Builder add(@OOXIXo String name, @OOXIXo Instant value) {
            long epochMilli;
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(value, "value");
            epochMilli = value.toEpochMilli();
            add(name, new Date(epochMilli));
            return this;
        }
    }

    @XX({"SMAP\nHeaders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Headers.kt\nokhttp3/Headers$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,458:1\n1#2:459\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkName(String str) {
            if (str.length() > 0) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if ('!' > charAt || charAt >= 127) {
                        throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str).toString());
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkValue(String str, String str2) {
            String str3;
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt != '\t' && (' ' > charAt || charAt >= 127)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Util.format("Unexpected char %#04x at %d in %s value", Integer.valueOf(charAt), Integer.valueOf(i), str2));
                    if (Util.isSensitiveHeader(str2)) {
                        str3 = "";
                    } else {
                        str3 = ": " + str;
                    }
                    sb.append(str3);
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String get(String[] strArr, String str) {
            int length = strArr.length - 2;
            int I0Io2 = x0XOIxOo.I0Io(length, 0, -2);
            if (I0Io2 <= length) {
                while (!OxI.oX0I0O(str, strArr[length], true)) {
                    if (length != I0Io2) {
                        length -= 2;
                    } else {
                        return null;
                    }
                }
                return strArr[length + 1];
            }
            return null;
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "function name changed", replaceWith = @kotlin.XX(expression = "headersOf(*namesAndValues)", imports = {}))
        @OOXIXo
        @xxIXOIIO(name = "-deprecated_of")
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m351deprecated_of(@OOXIXo String... namesAndValues) {
            IIX0o.x0xO0oo(namesAndValues, "namesAndValues");
            return of((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        @XO0OX.x0XOIxOo
        @OOXIXo
        @xxIXOIIO(name = MapBundleKey.MapObjKey.OBJ_OFFSET)
        public final Headers of(@OOXIXo String... namesAndValues) {
            IIX0o.x0xO0oo(namesAndValues, "namesAndValues");
            if (namesAndValues.length % 2 == 0) {
                String[] strArr = (String[]) namesAndValues.clone();
                int length = strArr.length;
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    String str = strArr[i2];
                    if (str != null) {
                        strArr[i2] = StringsKt__StringsKt.oIoIXxIO(str).toString();
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null");
                    }
                }
                int I0Io2 = x0XOIxOo.I0Io(0, strArr.length - 1, 2);
                if (I0Io2 >= 0) {
                    while (true) {
                        String str2 = strArr[i];
                        String str3 = strArr[i + 1];
                        checkName(str2);
                        checkValue(str3, str2);
                        if (i == I0Io2) {
                            break;
                        }
                        i += 2;
                    }
                }
                return new Headers(strArr, null);
            }
            throw new IllegalArgumentException("Expected alternating header names and values");
        }

        private Companion() {
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "function moved to extension", replaceWith = @kotlin.XX(expression = "headers.toHeaders()", imports = {}))
        @OOXIXo
        @xxIXOIIO(name = "-deprecated_of")
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m350deprecated_of(@OOXIXo Map<String, String> headers) {
            IIX0o.x0xO0oo(headers, "headers");
            return of(headers);
        }

        @XO0OX.x0XOIxOo
        @OOXIXo
        @xxIXOIIO(name = MapBundleKey.MapObjKey.OBJ_OFFSET)
        public final Headers of(@OOXIXo Map<String, String> map) {
            IIX0o.x0xO0oo(map, "<this>");
            String[] strArr = new String[map.size() * 2];
            int i = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                String obj = StringsKt__StringsKt.oIoIXxIO(key).toString();
                String obj2 = StringsKt__StringsKt.oIoIXxIO(value).toString();
                checkName(obj);
                checkValue(obj2, obj);
                strArr[i] = obj;
                strArr[i + 1] = obj2;
                i += 2;
            }
            return new Headers(strArr, null);
        }
    }

    public /* synthetic */ Headers(String[] strArr, IIXOooo iIXOooo) {
        this(strArr);
    }

    @XO0OX.x0XOIxOo
    @OOXIXo
    @xxIXOIIO(name = MapBundleKey.MapObjKey.OBJ_OFFSET)
    public static final Headers of(@OOXIXo Map<String, String> map) {
        return Companion.of(map);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE, imports = {}))
    @xxIXOIIO(name = "-deprecated_size")
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m349deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        for (int i = 0; i < strArr.length; i++) {
            length += this.namesAndValues[i].length();
        }
        return length;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if ((obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues)) {
            return true;
        }
        return false;
    }

    @oOoXoXO
    public final String get(@OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        return Companion.get(this.namesAndValues, name);
    }

    @oOoXoXO
    public final Date getDate(@OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        String str = get(name);
        if (str != null) {
            return DatesKt.toHttpDateOrNull(str);
        }
        return null;
    }

    @oOoXoXO
    @IgnoreJRERequirement
    public final Instant getInstant(@OOXIXo String name) {
        Instant instant;
        IIX0o.x0xO0oo(name, "name");
        Date date = getDate(name);
        if (date != null) {
            instant = date.toInstant();
            return instant;
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    @OOXIXo
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = Xo0.oIX0oI(name(i), value(i));
        }
        return II0XooXoX.oIX0oI(pairArr);
    }

    @OOXIXo
    public final String name(int i) {
        return this.namesAndValues[i * 2];
    }

    @OOXIXo
    public final Set<String> names() {
        TreeSet treeSet = new TreeSet(OxI.OOOI(oxxXoxO.f29356oIX0oI));
        int size = size();
        for (int i = 0; i < size; i++) {
            treeSet.add(name(i));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(treeSet);
        IIX0o.oO(unmodifiableSet, "unmodifiableSet(result)");
        return unmodifiableSet;
    }

    @OOXIXo
    public final Builder newBuilder() {
        Builder builder = new Builder();
        kotlin.collections.OxI.xxIO(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    @xxIXOIIO(name = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE)
    public final int size() {
        return this.namesAndValues.length / 2;
    }

    @OOXIXo
    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(OxI.OOOI(oxxXoxO.f29356oIX0oI));
        int size = size();
        for (int i = 0; i < size; i++) {
            String name = name(i);
            Locale US = Locale.US;
            IIX0o.oO(US, "US");
            String lowerCase = name.toLowerCase(US);
            IIX0o.oO(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i));
        }
        return treeMap;
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String name = name(i);
            String value = value(i);
            sb.append(name);
            sb.append(": ");
            if (Util.isSensitiveHeader(name)) {
                value = "██";
            }
            sb.append(value);
            sb.append("\n");
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @OOXIXo
    public final String value(int i) {
        return this.namesAndValues[(i * 2) + 1];
    }

    @OOXIXo
    public final List<String> values(@OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (OxI.oX0I0O(name, name(i), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i));
            }
        }
        if (arrayList != null) {
            List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
            IIX0o.oO(unmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
            return unmodifiableList;
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    @XO0OX.x0XOIxOo
    @OOXIXo
    @xxIXOIIO(name = MapBundleKey.MapObjKey.OBJ_OFFSET)
    public static final Headers of(@OOXIXo String... strArr) {
        return Companion.of(strArr);
    }
}
