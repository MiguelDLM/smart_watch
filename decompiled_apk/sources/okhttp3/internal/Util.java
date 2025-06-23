package okhttp3.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import X0.IIXOooo;
import XO0OX.XO;
import XO0OX.xxIXOIIO;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.collections.o0;
import kotlin.collections.oOXoIIIo;
import kotlin.io.II0xO0;
import kotlin.jvm.internal.II0XooXoX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.jvm.internal.xxX;
import kotlin.oO;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.oxoX;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Sink;
import okio.Source;
import org.apache.commons.lang3.time.xoIox;

@xxIXOIIO(name = "Util")
@XX({"SMAP\nUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Util.kt\nokhttp3/internal/Util\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,636:1\n37#2,2:637\n1627#3,6:639\n1#4:645\n1549#5:646\n1620#5,3:647\n*S KotlinDebug\n*F\n+ 1 Util.kt\nokhttp3/internal/Util\n*L\n127#1:637,2\n167#1:639,6\n300#1:646\n300#1:647,3\n*E\n"})
/* loaded from: classes6.dex */
public final class Util {

    @OOXIXo
    @XO
    public static final byte[] EMPTY_BYTE_ARRAY;

    @OOXIXo
    @XO
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);

    @OOXIXo
    @XO
    public static final RequestBody EMPTY_REQUEST;

    @OOXIXo
    @XO
    public static final ResponseBody EMPTY_RESPONSE;

    @OOXIXo
    private static final Options UNICODE_BOMS;

    @OOXIXo
    @XO
    public static final TimeZone UTC;

    @OOXIXo
    private static final Regex VERIFY_AS_IP_ADDRESS;

    @XO
    public static final boolean assertionsEnabled;

    @OOXIXo
    @XO
    public static final String okHttpName;

    @OOXIXo
    public static final String userAgent = "okhttp/4.12.0";

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        Options.Companion companion = Options.Companion;
        ByteString.Companion companion2 = ByteString.Companion;
        UNICODE_BOMS = companion.of(companion2.decodeHex("efbbbf"), companion2.decodeHex("feff"), companion2.decodeHex("fffe"), companion2.decodeHex("0000ffff"), companion2.decodeHex("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone(xoIox.f32917oIX0oI);
        IIX0o.ooOOo0oXI(timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        String name = OkHttpClient.class.getName();
        IIX0o.oO(name, "OkHttpClient::class.java.name");
        okHttpName = StringsKt__StringsKt.OxIxx0(StringsKt__StringsKt.OoI0OO(name, "okhttp3."), "Client");
    }

    public static final <E> void addIfAbsent(@OOXIXo List<E> list, E e) {
        IIX0o.x0xO0oo(list, "<this>");
        if (!list.contains(e)) {
            list.add(e);
        }
    }

    public static final int and(byte b, int i) {
        return b & i;
    }

    @OOXIXo
    public static final EventListener.Factory asFactory(@OOXIXo final EventListener eventListener) {
        IIX0o.x0xO0oo(eventListener, "<this>");
        return new EventListener.Factory() { // from class: xoxo.oIX0oI
            @Override // okhttp3.EventListener.Factory
            public final EventListener create(Call call) {
                EventListener asFactory$lambda$8;
                asFactory$lambda$8 = Util.asFactory$lambda$8(EventListener.this, call);
                return asFactory$lambda$8;
            }
        };
    }

    public static final EventListener asFactory$lambda$8(EventListener this_asFactory, Call it) {
        IIX0o.x0xO0oo(this_asFactory, "$this_asFactory");
        IIX0o.x0xO0oo(it, "it");
        return this_asFactory;
    }

    public static final void assertThreadDoesntHoldLock(@OOXIXo Object obj) {
        IIX0o.x0xO0oo(obj, "<this>");
        if (assertionsEnabled && Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + obj);
        }
    }

    public static final void assertThreadHoldsLock(@OOXIXo Object obj) {
        IIX0o.x0xO0oo(obj, "<this>");
        if (assertionsEnabled && !Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + obj);
        }
    }

    public static final boolean canParseAsIpAddress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return VERIFY_AS_IP_ADDRESS.matches(str);
    }

    public static final boolean canReuseConnectionFor(@OOXIXo HttpUrl httpUrl, @OOXIXo HttpUrl other) {
        IIX0o.x0xO0oo(httpUrl, "<this>");
        IIX0o.x0xO0oo(other, "other");
        if (IIX0o.Oxx0IOOO(httpUrl.host(), other.host()) && httpUrl.port() == other.port() && IIX0o.Oxx0IOOO(httpUrl.scheme(), other.scheme())) {
            return true;
        }
        return false;
    }

    public static final int checkDuration(@OOXIXo String name, long j, @oOoXoXO TimeUnit timeUnit) {
        IIX0o.x0xO0oo(name, "name");
        if (j >= 0) {
            if (timeUnit != null) {
                long millis = timeUnit.toMillis(j);
                if (millis <= 2147483647L) {
                    if (millis == 0 && j > 0) {
                        throw new IllegalArgumentException((name + " too small.").toString());
                    }
                    return (int) millis;
                }
                throw new IllegalArgumentException((name + " too large.").toString());
            }
            throw new IllegalStateException("unit == null");
        }
        throw new IllegalStateException((name + " < 0").toString());
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) >= 0 && j2 <= j && j - j2 >= j3) {
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(@OOXIXo Closeable closeable) {
        IIX0o.x0xO0oo(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    @OOXIXo
    public static final String[] concat(@OOXIXo String[] strArr, @OOXIXo String value) {
        IIX0o.x0xO0oo(strArr, "<this>");
        IIX0o.x0xO0oo(value, "value");
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length + 1);
        IIX0o.oO(copyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) copyOf;
        strArr2[ArraysKt___ArraysKt.o0IXO(strArr2)] = value;
        return strArr2;
    }

    public static final int delimiterOffset(@OOXIXo String str, @OOXIXo String delimiters, int i, int i2) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(delimiters, "delimiters");
        while (i < i2) {
            if (StringsKt__StringsKt.xXo(delimiters, str.charAt(i), false, 2, null)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, str2, i, i2);
    }

    public static final boolean discard(@OOXIXo Source source, int i, @OOXIXo TimeUnit timeUnit) {
        IIX0o.x0xO0oo(source, "<this>");
        IIX0o.x0xO0oo(timeUnit, "timeUnit");
        try {
            return skipAll(source, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    @OOXIXo
    public static final <T> List<T> filterList(@OOXIXo Iterable<? extends T> iterable, @OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(iterable, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        List<T> ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        for (T t : iterable) {
            if (predicate.invoke(t).booleanValue()) {
                if (ooXIXxIX2.isEmpty()) {
                    ooXIXxIX2 = new ArrayList<>();
                }
                IIX0o.x0XOIxOo(ooXIXxIX2, "null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal.Util.filterList>");
                XoX.Oxx0IOOO(ooXIXxIX2).add(t);
            }
        }
        return ooXIXxIX2;
    }

    @OOXIXo
    public static final String format(@OOXIXo String format, @OOXIXo Object... args) {
        IIX0o.x0xO0oo(format, "format");
        IIX0o.x0xO0oo(args, "args");
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        IIX0o.oO(format2, "format(locale, format, *args)");
        return format2;
    }

    public static final boolean hasIntersection(@OOXIXo String[] strArr, @oOoXoXO String[] strArr2, @OOXIXo Comparator<? super String> comparator) {
        IIX0o.x0xO0oo(strArr, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                Iterator oIX0oI2 = II0XooXoX.oIX0oI(strArr2);
                while (oIX0oI2.hasNext()) {
                    if (comparator.compare(str, (String) oIX0oI2.next()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(@OOXIXo Response response) {
        IIX0o.x0xO0oo(response, "<this>");
        String str = response.headers().get("Content-Length");
        if (str == null) {
            return -1L;
        }
        return toLongOrDefault(str, -1L);
    }

    public static final void ignoreIoExceptions(@OOXIXo oIX0oI<oXIO0o0XI> block) {
        IIX0o.x0xO0oo(block, "block");
        try {
            block.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    @OOXIXo
    public static final <T> List<T> immutableListOf(@OOXIXo T... elements) {
        IIX0o.x0xO0oo(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt__CollectionsKt.X00IoxXI(Arrays.copyOf(objArr, objArr.length)));
        IIX0o.oO(unmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int indexOf(@OOXIXo String[] strArr, @OOXIXo String value, @OOXIXo Comparator<String> comparator) {
        IIX0o.x0xO0oo(strArr, "<this>");
        IIX0o.x0xO0oo(value, "value");
        IIX0o.x0xO0oo(comparator, "comparator");
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], value) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (IIX0o.oI0IIXIo(charAt, 31) <= 0 || IIX0o.oI0IIXIo(charAt, 127) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(@OOXIXo String str, int i, int i2) {
        IIX0o.x0xO0oo(str, "<this>");
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt == '\t' || charAt == '\n' || charAt == '\f' || charAt == '\r' || charAt == ' ') {
                i++;
            } else {
                return i;
            }
        }
        return i2;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfLastNonAsciiWhitespace(@OOXIXo String str, int i, int i2) {
        IIX0o.x0xO0oo(str, "<this>");
        int i3 = i2 - 1;
        if (i <= i3) {
            while (true) {
                char charAt = str.charAt(i3);
                if (charAt == '\t' || charAt == '\n' || charAt == '\f' || charAt == '\r' || charAt == ' ') {
                    if (i3 == i) {
                        break;
                    }
                    i3--;
                } else {
                    return i3 + 1;
                }
            }
        }
        return i;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfNonWhitespace(@OOXIXo String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        int length = str.length();
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != '\t') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return indexOfNonWhitespace(str, i);
    }

    @OOXIXo
    public static final String[] intersect(@OOXIXo String[] strArr, @OOXIXo String[] other, @OOXIXo Comparator<? super String> comparator) {
        IIX0o.x0xO0oo(strArr, "<this>");
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = other.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, other[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean isCivilized(@OOXIXo FileSystem fileSystem, @OOXIXo File file) {
        IIX0o.x0xO0oo(fileSystem, "<this>");
        IIX0o.x0xO0oo(file, "file");
        Sink sink = fileSystem.sink(file);
        try {
            try {
                fileSystem.delete(file);
                II0xO0.oIX0oI(sink, null);
                return true;
            } catch (IOException unused) {
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                II0xO0.oIX0oI(sink, null);
                fileSystem.delete(file);
                return false;
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                II0xO0.oIX0oI(sink, th);
                throw th2;
            }
        }
    }

    public static final boolean isHealthy(@OOXIXo Socket socket, @OOXIXo BufferedSource source) {
        IIX0o.x0xO0oo(socket, "<this>");
        IIX0o.x0xO0oo(source, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                boolean z = !source.exhausted();
                socket.setSoTimeout(soTimeout);
                return z;
            } catch (Throwable th) {
                socket.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean isSensitiveHeader(@OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        if (OxI.oX0I0O(name, "Authorization", true) || OxI.oX0I0O(name, "Cookie", true) || OxI.oX0I0O(name, "Proxy-Authorization", true) || OxI.oX0I0O(name, "Set-Cookie", true)) {
            return true;
        }
        return false;
    }

    public static final void notify(@OOXIXo Object obj) {
        IIX0o.x0xO0oo(obj, "<this>");
        obj.notify();
    }

    public static final void notifyAll(@OOXIXo Object obj) {
        IIX0o.x0xO0oo(obj, "<this>");
        obj.notifyAll();
    }

    public static final int parseHexDigit(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' > c || c >= 'G') {
            return -1;
        }
        return c - '7';
    }

    @OOXIXo
    public static final String peerName(@OOXIXo Socket socket) {
        IIX0o.x0xO0oo(socket, "<this>");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (remoteSocketAddress instanceof InetSocketAddress) {
            String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
            IIX0o.oO(hostName, "address.hostName");
            return hostName;
        }
        return remoteSocketAddress.toString();
    }

    @OOXIXo
    public static final Charset readBomAsCharset(@OOXIXo BufferedSource bufferedSource, @OOXIXo Charset charset) throws IOException {
        IIX0o.x0xO0oo(bufferedSource, "<this>");
        IIX0o.x0xO0oo(charset, "default");
        int select = bufferedSource.select(UNICODE_BOMS);
        if (select != -1) {
            if (select != 0) {
                if (select != 1) {
                    if (select != 2) {
                        if (select != 3) {
                            if (select == 4) {
                                return oxoX.f29585oIX0oI.I0Io();
                            }
                            throw new AssertionError();
                        }
                        return oxoX.f29585oIX0oI.II0xO0();
                    }
                    Charset UTF_16LE = StandardCharsets.UTF_16LE;
                    IIX0o.oO(UTF_16LE, "UTF_16LE");
                    return UTF_16LE;
                }
                Charset UTF_16BE = StandardCharsets.UTF_16BE;
                IIX0o.oO(UTF_16BE, "UTF_16BE");
                return UTF_16BE;
            }
            Charset UTF_8 = StandardCharsets.UTF_8;
            IIX0o.oO(UTF_8, "UTF_8");
            return UTF_8;
        }
        return charset;
    }

    @oOoXoXO
    public static final <T> T readFieldOrNull(@OOXIXo Object instance, @OOXIXo Class<T> fieldType, @OOXIXo String fieldName) {
        T t;
        Object readFieldOrNull;
        IIX0o.x0xO0oo(instance, "instance");
        IIX0o.x0xO0oo(fieldType, "fieldType");
        IIX0o.x0xO0oo(fieldName, "fieldName");
        Class<?> cls = instance.getClass();
        while (true) {
            t = null;
            if (!IIX0o.Oxx0IOOO(cls, Object.class)) {
                try {
                    Field declaredField = cls.getDeclaredField(fieldName);
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(instance);
                    if (!fieldType.isInstance(obj)) {
                        break;
                    }
                    t = fieldType.cast(obj);
                    break;
                } catch (NoSuchFieldException unused) {
                    cls = cls.getSuperclass();
                    IIX0o.oO(cls, "c.superclass");
                }
            } else {
                if (IIX0o.Oxx0IOOO(fieldName, "delegate") || (readFieldOrNull = readFieldOrNull(instance, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) readFieldOrNull(readFieldOrNull, fieldType, fieldName);
            }
        }
        return t;
    }

    public static final int readMedium(@OOXIXo BufferedSource bufferedSource) throws IOException {
        IIX0o.x0xO0oo(bufferedSource, "<this>");
        return and(bufferedSource.readByte(), 255) | (and(bufferedSource.readByte(), 255) << 16) | (and(bufferedSource.readByte(), 255) << 8);
    }

    public static final boolean skipAll(@OOXIXo Source source, int i, @OOXIXo TimeUnit timeUnit) throws IOException {
        IIX0o.x0xO0oo(source, "<this>");
        IIX0o.x0xO0oo(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos(i)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, 8192L) != -1) {
                buffer.clear();
            }
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    @OOXIXo
    public static final ThreadFactory threadFactory(@OOXIXo final String name, final boolean z) {
        IIX0o.x0xO0oo(name, "name");
        return new ThreadFactory() { // from class: xoxo.II0xO0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread threadFactory$lambda$1;
                threadFactory$lambda$1 = Util.threadFactory$lambda$1(name, z, runnable);
                return threadFactory$lambda$1;
            }
        };
    }

    public static final Thread threadFactory$lambda$1(String name, boolean z, Runnable runnable) {
        IIX0o.x0xO0oo(name, "$name");
        Thread thread = new Thread(runnable, name);
        thread.setDaemon(z);
        return thread;
    }

    public static final void threadName(@OOXIXo String name, @OOXIXo oIX0oI<oXIO0o0XI> block) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(block, "block");
        Thread currentThread = Thread.currentThread();
        String name2 = currentThread.getName();
        currentThread.setName(name);
        try {
            block.invoke();
        } finally {
            xxX.oxoX(1);
            currentThread.setName(name2);
            xxX.I0Io(1);
        }
    }

    @OOXIXo
    public static final List<Header> toHeaderList(@OOXIXo Headers headers) {
        IIX0o.x0xO0oo(headers, "<this>");
        X0.oOoXoXO X00xOoXI2 = IIXOooo.X00xOoXI(0, headers.size());
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(X00xOoXI2, 10));
        Iterator<Integer> it = X00xOoXI2.iterator();
        while (it.hasNext()) {
            int nextInt = ((oOXoIIIo) it).nextInt();
            arrayList.add(new Header(headers.name(nextInt), headers.value(nextInt)));
        }
        return arrayList;
    }

    @OOXIXo
    public static final Headers toHeaders(@OOXIXo List<Header> list) {
        IIX0o.x0xO0oo(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.component1().utf8(), header.component2().utf8());
        }
        return builder.build();
    }

    @OOXIXo
    public static final String toHexString(long j) {
        String hexString = Long.toHexString(j);
        IIX0o.oO(hexString, "toHexString(this)");
        return hexString;
    }

    @OOXIXo
    public static final String toHostHeader(@OOXIXo HttpUrl httpUrl, boolean z) {
        String host;
        IIX0o.x0xO0oo(httpUrl, "<this>");
        if (StringsKt__StringsKt.o00xOoIO(httpUrl.host(), ":", false, 2, null)) {
            host = '[' + httpUrl.host() + ']';
        } else {
            host = httpUrl.host();
        }
        if (z || httpUrl.port() != HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return host + ':' + httpUrl.port();
        }
        return host;
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toHostHeader(httpUrl, z);
    }

    @OOXIXo
    public static final <T> List<T> toImmutableList(@OOXIXo List<? extends T> list) {
        IIX0o.x0xO0oo(list, "<this>");
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt___CollectionsKt.o0Xo0XII(list));
        IIX0o.oO(unmodifiableList, "unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    @OOXIXo
    public static final <K, V> Map<K, V> toImmutableMap(@OOXIXo Map<K, ? extends V> map) {
        IIX0o.x0xO0oo(map, "<this>");
        if (map.isEmpty()) {
            return o0.O0xOxO();
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        IIX0o.oO(unmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return unmodifiableMap;
    }

    public static final long toLongOrDefault(@OOXIXo String str, long j) {
        IIX0o.x0xO0oo(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static final int toNonNegativeInt(@oOoXoXO String str, int i) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    @OOXIXo
    public static final String trimSubstring(@OOXIXo String str, int i, int i2) {
        IIX0o.x0xO0oo(str, "<this>");
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i, i2);
        String substring = str.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, indexOfFirstNonAsciiWhitespace, i2));
        IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return trimSubstring(str, i, i2);
    }

    public static final void wait(@OOXIXo Object obj) {
        IIX0o.x0xO0oo(obj, "<this>");
        obj.wait();
    }

    @OOXIXo
    public static final Throwable withSuppressed(@OOXIXo Exception exc, @OOXIXo List<? extends Exception> suppressed) {
        IIX0o.x0xO0oo(exc, "<this>");
        IIX0o.x0xO0oo(suppressed, "suppressed");
        Iterator<? extends Exception> it = suppressed.iterator();
        while (it.hasNext()) {
            oO.oIX0oI(exc, it.next());
        }
        return exc;
    }

    public static final void writeMedium(@OOXIXo BufferedSink bufferedSink, int i) throws IOException {
        IIX0o.x0xO0oo(bufferedSink, "<this>");
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    public static final int and(short s, int i) {
        return s & i;
    }

    public static final int delimiterOffset(@OOXIXo String str, char c, int i, int i2) {
        IIX0o.x0xO0oo(str, "<this>");
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, c, i, i2);
    }

    @OOXIXo
    public static final String toHexString(int i) {
        String hexString = Integer.toHexString(i);
        IIX0o.oO(hexString, "toHexString(this)");
        return hexString;
    }

    public static final long and(int i, long j) {
        return i & j;
    }

    public static final void closeQuietly(@OOXIXo Socket socket) {
        IIX0o.x0xO0oo(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e2) {
            if (!IIX0o.Oxx0IOOO(e2.getMessage(), "bio == null")) {
                throw e2;
            }
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(@OOXIXo ServerSocket serverSocket) {
        IIX0o.x0xO0oo(serverSocket, "<this>");
        try {
            serverSocket.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(@OOXIXo Buffer buffer, byte b) {
        IIX0o.x0xO0oo(buffer, "<this>");
        int i = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b) {
            i++;
            buffer.readByte();
        }
        return i;
    }
}
