package okhttp3.internal.publicsuffix;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.oI0IIXIo;
import kotlin.io.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Ref;
import kotlin.oXIO0o0XI;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;

/* loaded from: classes6.dex */
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';

    @OOXIXo
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final byte[] WILDCARD_LABEL = {42};

    @OOXIXo
    private static final List<String> PREVAILING_RULE = oI0IIXIo.OOXIXo("*");

    @OOXIXo
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();

    @OOXIXo
    private final AtomicBoolean listRead = new AtomicBoolean(false);

    @OOXIXo
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            int and;
            boolean z;
            int and2;
            int length = bArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = (i3 + length) / 2;
                while (i4 > -1 && bArr[i4] != 10) {
                    i4--;
                }
                int i5 = i4 + 1;
                int i6 = 1;
                while (true) {
                    i2 = i5 + i6;
                    if (bArr[i2] == 10) {
                        break;
                    }
                    i6++;
                }
                int i7 = i2 - i5;
                int i8 = i;
                boolean z2 = false;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    if (z2) {
                        and = 46;
                        z = false;
                    } else {
                        boolean z3 = z2;
                        and = Util.and(bArr2[i8][i9], 255);
                        z = z3;
                    }
                    and2 = and - Util.and(bArr[i5 + i10], 255);
                    if (and2 != 0) {
                        break;
                    }
                    i10++;
                    i9++;
                    if (i10 == i7) {
                        break;
                    }
                    if (bArr2[i8].length == i9) {
                        if (i8 == bArr2.length - 1) {
                            break;
                        }
                        i8++;
                        z2 = true;
                        i9 = -1;
                    } else {
                        z2 = z;
                    }
                }
                if (and2 >= 0) {
                    if (and2 <= 0) {
                        int i11 = i7 - i10;
                        int length2 = bArr2[i8].length - i9;
                        int length3 = bArr2.length;
                        for (int i12 = i8 + 1; i12 < length3; i12++) {
                            length2 += bArr2[i12].length;
                        }
                        if (length2 >= i11) {
                            if (length2 <= i11) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                IIX0o.oO(UTF_8, "UTF_8");
                                return new String(bArr, i5, i7, UTF_8);
                            }
                        }
                    }
                    i3 = i2 + 1;
                }
                length = i4;
            }
            return null;
        }

        @OOXIXo
        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        private Companion() {
        }
    }

    private final List<String> findMatchingRule(List<String> list) {
        String str;
        String str2;
        String str3;
        List<String> ooXIXxIX2;
        List<String> ooXIXxIX3;
        if (!this.listRead.get() && this.listRead.compareAndSet(false, true)) {
            readTheListUninterruptibly();
        } else {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        if (this.publicSuffixListBytes != null) {
            int size = list.size();
            byte[][] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                String str4 = list.get(i);
                Charset UTF_8 = StandardCharsets.UTF_8;
                IIX0o.oO(UTF_8, "UTF_8");
                byte[] bytes = str4.getBytes(UTF_8);
                IIX0o.oO(bytes, "this as java.lang.String).getBytes(charset)");
                bArr[i] = bytes;
            }
            int i2 = 0;
            while (true) {
                str = null;
                if (i2 < size) {
                    Companion companion = Companion;
                    byte[] bArr2 = this.publicSuffixListBytes;
                    if (bArr2 == null) {
                        IIX0o.XOxIOxOx("publicSuffixListBytes");
                        bArr2 = null;
                    }
                    str2 = companion.binarySearch(bArr2, bArr, i2);
                    if (str2 != null) {
                        break;
                    }
                    i2++;
                } else {
                    str2 = null;
                    break;
                }
            }
            if (size > 1) {
                byte[][] bArr3 = (byte[][]) bArr.clone();
                int length = bArr3.length - 1;
                for (int i3 = 0; i3 < length; i3++) {
                    bArr3[i3] = WILDCARD_LABEL;
                    Companion companion2 = Companion;
                    byte[] bArr4 = this.publicSuffixListBytes;
                    if (bArr4 == null) {
                        IIX0o.XOxIOxOx("publicSuffixListBytes");
                        bArr4 = null;
                    }
                    String binarySearch = companion2.binarySearch(bArr4, bArr3, i3);
                    if (binarySearch != null) {
                        str3 = binarySearch;
                        break;
                    }
                }
            }
            str3 = null;
            if (str3 != null) {
                int i4 = size - 1;
                int i5 = 0;
                while (true) {
                    if (i5 >= i4) {
                        break;
                    }
                    Companion companion3 = Companion;
                    byte[] bArr5 = this.publicSuffixExceptionListBytes;
                    if (bArr5 == null) {
                        IIX0o.XOxIOxOx("publicSuffixExceptionListBytes");
                        bArr5 = null;
                    }
                    String binarySearch2 = companion3.binarySearch(bArr5, bArr, i5);
                    if (binarySearch2 != null) {
                        str = binarySearch2;
                        break;
                    }
                    i5++;
                }
            }
            if (str != null) {
                return StringsKt__StringsKt.Xxx0oXX('!' + str, new char[]{'.'}, false, 0, 6, null);
            }
            if (str2 == null && str3 == null) {
                return PREVAILING_RULE;
            }
            if (str2 == null || (ooXIXxIX2 = StringsKt__StringsKt.Xxx0oXX(str2, new char[]{'.'}, false, 0, 6, null)) == null) {
                ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (str3 == null || (ooXIXxIX3 = StringsKt__StringsKt.Xxx0oXX(str3, new char[]{'.'}, false, 0, 6, null)) == null) {
                ooXIXxIX3 = CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (ooXIXxIX2.size() <= ooXIXxIX3.size()) {
                return ooXIXxIX3;
            }
            return ooXIXxIX2;
        }
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, byte[]] */
    /* JADX WARN: Type inference failed for: r3v7, types: [T, byte[]] */
    private final void readTheList() throws IOException {
        try {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
            if (resourceAsStream == null) {
                return;
            }
            BufferedSource buffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
            try {
                objectRef.element = buffer.readByteArray(buffer.readInt());
                objectRef2.element = buffer.readByteArray(buffer.readInt());
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                II0xO0.oIX0oI(buffer, null);
                synchronized (this) {
                    T t = objectRef.element;
                    IIX0o.ooOOo0oXI(t);
                    this.publicSuffixListBytes = (byte[]) t;
                    T t2 = objectRef2.element;
                    IIX0o.ooOOo0oXI(t2);
                    this.publicSuffixExceptionListBytes = (byte[]) t2;
                }
            } finally {
            }
        } finally {
            this.readCompleteLatch.countDown();
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e) {
                    Platform.Companion.get().log("Failed to read public suffix list", 5, e);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> splitDomain(String str) {
        List<String> Xxx0oXX2 = StringsKt__StringsKt.Xxx0oXX(str, new char[]{'.'}, false, 0, 6, null);
        if (IIX0o.Oxx0IOOO(CollectionsKt___CollectionsKt.O0O0Io00X(Xxx0oXX2), "")) {
            return CollectionsKt___CollectionsKt.oXxx000(Xxx0oXX2, 1);
        }
        return Xxx0oXX2;
    }

    @oOoXoXO
    public final String getEffectiveTldPlusOne(@OOXIXo String domain) {
        int size;
        int size2;
        IIX0o.x0xO0oo(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        IIX0o.oO(unicodeDomain, "unicodeDomain");
        List<String> splitDomain = splitDomain(unicodeDomain);
        List<String> findMatchingRule = findMatchingRule(splitDomain);
        if (splitDomain.size() == findMatchingRule.size() && findMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (findMatchingRule.get(0).charAt(0) == '!') {
            size = splitDomain.size();
            size2 = findMatchingRule.size();
        } else {
            size = splitDomain.size();
            size2 = findMatchingRule.size() + 1;
        }
        return SequencesKt___SequencesKt.IoXIXo(SequencesKt___SequencesKt.xoxXI(CollectionsKt___CollectionsKt.OooI(splitDomain(domain)), size - size2), FileUtils.FILE_EXTENSION_SEPARATOR, null, null, 0, null, null, 62, null);
    }

    public final void setListBytes(@OOXIXo byte[] publicSuffixListBytes, @OOXIXo byte[] publicSuffixExceptionListBytes) {
        IIX0o.x0xO0oo(publicSuffixListBytes, "publicSuffixListBytes");
        IIX0o.x0xO0oo(publicSuffixExceptionListBytes, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = publicSuffixListBytes;
        this.publicSuffixExceptionListBytes = publicSuffixExceptionListBytes;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
