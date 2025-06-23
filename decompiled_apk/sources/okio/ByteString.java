package okio;

import XO0OX.x0XOIxOo;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.MessageDigestAlgorithms;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.DeprecationLevel;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;
import org.apache.commons.lang3.xXOx;

@XX({"SMAP\nByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteString.kt\nokio/ByteString\n+ 2 ByteString.kt\nokio/internal/-ByteString\n+ 3 Util.kt\nokio/-SegmentedByteString\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,364:1\n43#2,7:365\n53#2:372\n56#2:373\n64#2,4:374\n68#2:379\n70#2:381\n76#2,23:382\n104#2,23:405\n131#2,2:428\n133#2,9:431\n145#2:440\n148#2:441\n151#2:442\n154#2:443\n162#2:444\n172#2,3:445\n171#2:448\n185#2,2:449\n190#2:451\n194#2:452\n198#2:453\n202#2:454\n206#2,7:455\n219#2:462\n223#2,8:463\n235#2,4:471\n244#2,5:475\n253#2,6:480\n259#2,9:487\n322#2,8:496\n131#2,2:504\n133#2,9:507\n333#2,9:516\n68#3:378\n74#3:380\n74#3:486\n1#4:430\n1#4:506\n*S KotlinDebug\n*F\n+ 1 ByteString.kt\nokio/ByteString\n*L\n66#1:365,7\n71#1:372\n108#1:373\n110#1:374,4\n110#1:379\n110#1:381\n112#1:382,23\n114#1:405,23\n118#1:428,2\n118#1:431,9\n120#1:440\n129#1:441\n131#1:442\n133#1:443\n152#1:444\n159#1:445,3\n159#1:448\n166#1:449,2\n168#1:451\n170#1:452\n172#1:453\n174#1:454\n180#1:455,7\n183#1:462\n186#1:463,8\n188#1:471,4\n190#1:475,5\n192#1:480,6\n192#1:487,9\n194#1:496,8\n194#1:504,2\n194#1:507,9\n194#1:516,9\n110#1:378\n110#1:380\n192#1:486\n118#1:430\n194#1:506\n*E\n"})
/* loaded from: classes6.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    @OXOo.OOXIXo
    private final byte[] data;
    private transient int hashCode;

    @OXOo.oOoXoXO
    private transient String utf8;

    @XX({"SMAP\nByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteString.kt\nokio/ByteString$Companion\n+ 2 ByteString.kt\nokio/internal/-ByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,364:1\n271#2:365\n275#2,3:366\n282#2,3:369\n289#2,2:372\n295#2:374\n297#2,7:376\n1#3:375\n1#3:383\n*S KotlinDebug\n*F\n+ 1 ByteString.kt\nokio/ByteString$Companion\n*L\n234#1:365\n239#1:366,3\n251#1:369,3\n259#1:372,2\n262#1:374\n262#1:376,7\n262#1:375\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i, Object obj) {
            if ((i & 1) != 0) {
                charset = kotlin.text.oxoX.f29581II0xO0;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = SegmentedByteString.getDEFAULT__ByteString_size();
            }
            return companion.of(bArr, i, i2);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.XX(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        @XO0OX.xxIXOIIO(name = "-deprecated_decodeBase64")
        @OXOo.oOoXoXO
        /* renamed from: -deprecated_decodeBase64, reason: not valid java name */
        public final ByteString m440deprecated_decodeBase64(@OXOo.OOXIXo String string) {
            IIX0o.x0xO0oo(string, "string");
            return decodeBase64(string);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.XX(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = "-deprecated_decodeHex")
        /* renamed from: -deprecated_decodeHex, reason: not valid java name */
        public final ByteString m441deprecated_decodeHex(@OXOo.OOXIXo String string) {
            IIX0o.x0xO0oo(string, "string");
            return decodeHex(string);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.XX(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = "-deprecated_encodeString")
        /* renamed from: -deprecated_encodeString, reason: not valid java name */
        public final ByteString m442deprecated_encodeString(@OXOo.OOXIXo String string, @OXOo.OOXIXo Charset charset) {
            IIX0o.x0xO0oo(string, "string");
            IIX0o.x0xO0oo(charset, "charset");
            return encodeString(string, charset);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.XX(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = "-deprecated_encodeUtf8")
        /* renamed from: -deprecated_encodeUtf8, reason: not valid java name */
        public final ByteString m443deprecated_encodeUtf8(@OXOo.OOXIXo String string) {
            IIX0o.x0xO0oo(string, "string");
            return encodeUtf8(string);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.XX(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = "-deprecated_of")
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m444deprecated_of(@OXOo.OOXIXo ByteBuffer buffer) {
            IIX0o.x0xO0oo(buffer, "buffer");
            return of(buffer);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.XX(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = "-deprecated_read")
        /* renamed from: -deprecated_read, reason: not valid java name */
        public final ByteString m446deprecated_read(@OXOo.OOXIXo InputStream inputstream, int i) {
            IIX0o.x0xO0oo(inputstream, "inputstream");
            return read(inputstream, i);
        }

        @x0XOIxOo
        @OXOo.oOoXoXO
        public final ByteString decodeBase64(@OXOo.OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<this>");
            byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(str);
            if (decodeBase64ToArray != null) {
                return new ByteString(decodeBase64ToArray);
            }
            return null;
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final ByteString decodeHex(@OXOo.OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<this>");
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) ((okio.internal.ByteString.access$decodeHexDigit(str.charAt(i2)) << 4) + okio.internal.ByteString.access$decodeHexDigit(str.charAt(i2 + 1)));
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = "encodeString")
        public final ByteString encodeString(@OXOo.OOXIXo String str, @OXOo.OOXIXo Charset charset) {
            IIX0o.x0xO0oo(str, "<this>");
            IIX0o.x0xO0oo(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            IIX0o.oO(bytes, "this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final ByteString encodeUtf8(@OXOo.OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<this>");
            ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = MapBundleKey.MapObjKey.OBJ_OFFSET)
        public final ByteString of(@OXOo.OOXIXo ByteBuffer byteBuffer) {
            IIX0o.x0xO0oo(byteBuffer, "<this>");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = "read")
        public final ByteString read(@OXOo.OOXIXo InputStream inputStream, int i) throws IOException {
            IIX0o.x0xO0oo(inputStream, "<this>");
            if (i >= 0) {
                byte[] bArr = new byte[i];
                int i2 = 0;
                while (i2 < i) {
                    int read = inputStream.read(bArr, i2, i - i2);
                    if (read != -1) {
                        i2 += read;
                    } else {
                        throw new EOFException();
                    }
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("byteCount < 0: " + i).toString());
        }

        private Companion() {
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.XX(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = "-deprecated_of")
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m445deprecated_of(@OXOo.OOXIXo byte[] array, int i, int i2) {
            IIX0o.x0xO0oo(array, "array");
            return of(array, i, i2);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final ByteString of(@OXOo.OOXIXo byte... data) {
            IIX0o.x0xO0oo(data, "data");
            byte[] copyOf = Arrays.copyOf(data, data.length);
            IIX0o.oO(copyOf, "copyOf(this, size)");
            return new ByteString(copyOf);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = MapBundleKey.MapObjKey.OBJ_OFFSET)
        public final ByteString of(@OXOo.OOXIXo byte[] bArr, int i, int i2) {
            IIX0o.x0xO0oo(bArr, "<this>");
            int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(bArr, i2);
            SegmentedByteString.checkOffsetAndCount(bArr.length, i, resolveDefaultParameter);
            return new ByteString(ooOOo0oXI.xxOXOOoIX(bArr, i, resolveDefaultParameter + i));
        }
    }

    public ByteString(@OXOo.OOXIXo byte[] data) {
        IIX0o.x0xO0oo(data, "data");
        this.data = data;
    }

    public static /* synthetic */ void copyInto$default(ByteString byteString, int i, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                i = 0;
            }
            if ((i4 & 4) != 0) {
                i2 = 0;
            }
            byteString.copyInto(i, bArr, i2, i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
    }

    @x0XOIxOo
    @OXOo.oOoXoXO
    public static final ByteString decodeBase64(@OXOo.OOXIXo String str) {
        return Companion.decodeBase64(str);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final ByteString decodeHex(@OXOo.OOXIXo String str) {
        return Companion.decodeHex(str);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "encodeString")
    public static final ByteString encodeString(@OXOo.OOXIXo String str, @OXOo.OOXIXo Charset charset) {
        return Companion.encodeString(str, charset);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final ByteString encodeUtf8(@OXOo.OOXIXo String str) {
        return Companion.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return byteString.indexOf(byteString2, i);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i2 & 2) != 0) {
            i = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.lastIndexOf(byteString2, i);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = MapBundleKey.MapObjKey.OBJ_OFFSET)
    public static final ByteString of(@OXOo.OOXIXo ByteBuffer byteBuffer) {
        return Companion.of(byteBuffer);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "read")
    public static final ByteString read(@OXOo.OOXIXo InputStream inputStream, int i) throws IOException {
        return Companion.read(inputStream, i);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = Companion.read(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, read.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = SegmentedByteString.getDEFAULT__ByteString_size();
            }
            return byteString.substring(i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @kotlin.XX(expression = "this[index]", imports = {}))
    @XO0OX.xxIXOIIO(name = "-deprecated_getByte")
    /* renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m438deprecated_getByte(int i) {
        return getByte(i);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE, imports = {}))
    @XO0OX.xxIXOIIO(name = "-deprecated_size")
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m439deprecated_size() {
        return size();
    }

    @OXOo.OOXIXo
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        IIX0o.oO(asReadOnlyBuffer, "asReadOnlyBuffer(...)");
        return asReadOnlyBuffer;
    }

    @OXOo.OOXIXo
    public String base64() {
        return Base64.encodeBase64$default(getData$okio(), null, 1, null);
    }

    @OXOo.OOXIXo
    public String base64Url() {
        return Base64.encodeBase64(getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public void copyInto(int i, @OXOo.OOXIXo byte[] target, int i2, int i3) {
        IIX0o.x0xO0oo(target, "target");
        ooOOo0oXI.O00XxXI(getData$okio(), target, i2, i, i3 + i);
    }

    @OXOo.OOXIXo
    public ByteString digest$okio(@OXOo.OOXIXo String algorithm) {
        IIX0o.x0xO0oo(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.data, 0, size());
        byte[] digest = messageDigest.digest();
        IIX0o.ooOOo0oXI(digest);
        return new ByteString(digest);
    }

    public final boolean endsWith(@OXOo.OOXIXo ByteString suffix) {
        IIX0o.x0xO0oo(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    @XO0OX.xxIXOIIO(name = "getByte")
    public final byte getByte(int i) {
        return internalGet$okio(i);
    }

    @OXOo.OOXIXo
    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    @OXOo.oOoXoXO
    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio == 0) {
            int hashCode = Arrays.hashCode(getData$okio());
            setHashCode$okio(hashCode);
            return hashCode;
        }
        return hashCode$okio;
    }

    @OXOo.OOXIXo
    public String hex() {
        char[] cArr = new char[getData$okio().length * 2];
        int i = 0;
        for (byte b : getData$okio()) {
            int i2 = i + 1;
            cArr[i] = okio.internal.ByteString.getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i += 2;
            cArr[i2] = okio.internal.ByteString.getHEX_DIGIT_CHARS()[b & 15];
        }
        return OxI.I0xX0(cArr);
    }

    @OXOo.OOXIXo
    public ByteString hmac$okio(@OXOo.OOXIXo String algorithm, @OXOo.OOXIXo ByteString key) {
        IIX0o.x0xO0oo(algorithm, "algorithm");
        IIX0o.x0xO0oo(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] doFinal = mac.doFinal(this.data);
            IIX0o.oO(doFinal, "doFinal(...)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @OXOo.OOXIXo
    public ByteString hmacSha1(@OXOo.OOXIXo ByteString key) {
        IIX0o.x0xO0oo(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    @OXOo.OOXIXo
    public ByteString hmacSha256(@OXOo.OOXIXo ByteString key) {
        IIX0o.x0xO0oo(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    @OXOo.OOXIXo
    public ByteString hmacSha512(@OXOo.OOXIXo ByteString key) {
        IIX0o.x0xO0oo(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    @XO0OX.xoIox
    public final int indexOf(@OXOo.OOXIXo ByteString other) {
        IIX0o.x0xO0oo(other, "other");
        return indexOf$default(this, other, 0, 2, (Object) null);
    }

    @OXOo.OOXIXo
    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i) {
        return getData$okio()[i];
    }

    @XO0OX.xoIox
    public final int lastIndexOf(@OXOo.OOXIXo ByteString other) {
        IIX0o.x0xO0oo(other, "other");
        return lastIndexOf$default(this, other, 0, 2, (Object) null);
    }

    @OXOo.OOXIXo
    public final ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int i, @OXOo.OOXIXo ByteString other, int i2, int i3) {
        IIX0o.x0xO0oo(other, "other");
        return other.rangeEquals(i2, getData$okio(), i, i3);
    }

    public final void setHashCode$okio(int i) {
        this.hashCode = i;
    }

    public final void setUtf8$okio(@OXOo.oOoXoXO String str) {
        this.utf8 = str;
    }

    @OXOo.OOXIXo
    public final ByteString sha1() {
        return digest$okio(MessageDigestAlgorithms.SHA_1);
    }

    @OXOo.OOXIXo
    public final ByteString sha256() {
        return digest$okio(MessageDigestAlgorithms.SHA_256);
    }

    @OXOo.OOXIXo
    public final ByteString sha512() {
        return digest$okio(MessageDigestAlgorithms.SHA_512);
    }

    @XO0OX.xxIXOIIO(name = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE)
    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(@OXOo.OOXIXo ByteString prefix) {
        IIX0o.x0xO0oo(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    @OXOo.OOXIXo
    public String string(@OXOo.OOXIXo Charset charset) {
        IIX0o.x0xO0oo(charset, "charset");
        return new String(this.data, charset);
    }

    @OXOo.OOXIXo
    @XO0OX.xoIox
    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @OXOo.OOXIXo
    public ByteString toAsciiLowercase() {
        for (int i = 0; i < getData$okio().length; i++) {
            byte b = getData$okio()[i];
            if (b >= 65 && b <= 90) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                IIX0o.oO(copyOf, "copyOf(this, size)");
                copyOf[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b2 = copyOf[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        copyOf[i2] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @OXOo.OOXIXo
    public ByteString toAsciiUppercase() {
        for (int i = 0; i < getData$okio().length; i++) {
            byte b = getData$okio()[i];
            if (b >= 97 && b <= 122) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                IIX0o.oO(copyOf, "copyOf(this, size)");
                copyOf[i] = (byte) (b - 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b2 = copyOf[i2];
                    if (b2 >= 97 && b2 <= 122) {
                        copyOf[i2] = (byte) (b2 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @OXOo.OOXIXo
    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        IIX0o.oO(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @OXOo.OOXIXo
    public String toString() {
        ByteString byteString;
        String str;
        if (getData$okio().length == 0) {
            str = "[size=0]";
        } else {
            int access$codePointIndexToCharIndex = okio.internal.ByteString.access$codePointIndexToCharIndex(getData$okio(), 64);
            if (access$codePointIndexToCharIndex == -1) {
                if (getData$okio().length <= 64) {
                    str = "[hex=" + hex() + ']';
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[size=");
                    sb.append(getData$okio().length);
                    sb.append(" hex=");
                    int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, 64);
                    if (resolveDefaultParameter <= getData$okio().length) {
                        if (resolveDefaultParameter >= 0) {
                            if (resolveDefaultParameter == getData$okio().length) {
                                byteString = this;
                            } else {
                                byteString = new ByteString(ooOOo0oXI.xxOXOOoIX(getData$okio(), 0, resolveDefaultParameter));
                            }
                            sb.append(byteString.hex());
                            sb.append("…]");
                            return sb.toString();
                        }
                        throw new IllegalArgumentException("endIndex < beginIndex");
                    }
                    throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + HexStringBuilder.COMMENT_END_CHAR).toString());
                }
            } else {
                String utf8 = utf8();
                String substring = utf8.substring(0, access$codePointIndexToCharIndex);
                IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String IIOIX2 = OxI.IIOIX(OxI.IIOIX(OxI.IIOIX(substring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), xXOx.f32950X0o0xo, "\\r", false, 4, null);
                if (access$codePointIndexToCharIndex < utf8.length()) {
                    return "[size=" + getData$okio().length + " text=" + IIOIX2 + "…]";
                }
                return "[text=" + IIOIX2 + ']';
            }
        }
        return str;
    }

    @OXOo.OOXIXo
    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio == null) {
            String utf8String = _JvmPlatformKt.toUtf8String(internalArray$okio());
            setUtf8$okio(utf8String);
            return utf8String;
        }
        return utf8$okio;
    }

    public void write(@OXOo.OOXIXo OutputStream out) throws IOException {
        IIX0o.x0xO0oo(out, "out");
        out.write(this.data);
    }

    public void write$okio(@OXOo.OOXIXo Buffer buffer, int i, int i2) {
        IIX0o.x0xO0oo(buffer, "buffer");
        okio.internal.ByteString.commonWrite(this, buffer, i, i2);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return byteString.indexOf(bArr, i);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final ByteString of(@OXOo.OOXIXo byte... bArr) {
        return Companion.of(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compareTo(@OXOo.OOXIXo okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r10, r0)
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2e
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L2c
        L2a:
            r3 = -1
            goto L34
        L2c:
            r3 = 1
            goto L34
        L2e:
            if (r0 != r1) goto L31
            goto L34
        L31:
            if (r0 >= r1) goto L2c
            goto L2a
        L34:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public final boolean endsWith(@OXOo.OOXIXo byte[] suffix) {
        IIX0o.x0xO0oo(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    @XO0OX.xoIox
    public final int indexOf(@OXOo.OOXIXo byte[] other) {
        IIX0o.x0xO0oo(other, "other");
        return indexOf$default(this, other, 0, 2, (Object) null);
    }

    @XO0OX.xoIox
    public final int lastIndexOf(@OXOo.OOXIXo byte[] other) {
        IIX0o.x0xO0oo(other, "other");
        return lastIndexOf$default(this, other, 0, 2, (Object) null);
    }

    public boolean rangeEquals(int i, @OXOo.OOXIXo byte[] other, int i2, int i3) {
        IIX0o.x0xO0oo(other, "other");
        return i >= 0 && i <= getData$okio().length - i3 && i2 >= 0 && i2 <= other.length - i3 && SegmentedByteString.arrayRangeEquals(getData$okio(), i, other, i2, i3);
    }

    public final boolean startsWith(@OXOo.OOXIXo byte[] prefix) {
        IIX0o.x0xO0oo(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }

    @OXOo.OOXIXo
    @XO0OX.xoIox
    public final ByteString substring(int i) {
        return substring$default(this, i, 0, 2, null);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i2 & 2) != 0) {
            i = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.lastIndexOf(bArr, i);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = MapBundleKey.MapObjKey.OBJ_OFFSET)
    public static final ByteString of(@OXOo.OOXIXo byte[] bArr, int i, int i2) {
        return Companion.of(bArr, i, i2);
    }

    @XO0OX.xoIox
    public final int indexOf(@OXOo.OOXIXo ByteString other, int i) {
        IIX0o.x0xO0oo(other, "other");
        return indexOf(other.internalArray$okio(), i);
    }

    @XO0OX.xoIox
    public final int lastIndexOf(@OXOo.OOXIXo ByteString other, int i) {
        IIX0o.x0xO0oo(other, "other");
        return lastIndexOf(other.internalArray$okio(), i);
    }

    @OXOo.OOXIXo
    @XO0OX.xoIox
    public ByteString substring(int i, int i2) {
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, i2);
        if (i >= 0) {
            if (resolveDefaultParameter <= getData$okio().length) {
                if (resolveDefaultParameter - i >= 0) {
                    return (i == 0 && resolveDefaultParameter == getData$okio().length) ? this : new ByteString(ooOOo0oXI.xxOXOOoIX(getData$okio(), i, resolveDefaultParameter));
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + HexStringBuilder.COMMENT_END_CHAR).toString());
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    @XO0OX.xoIox
    public int indexOf(@OXOo.OOXIXo byte[] other, int i) {
        IIX0o.x0xO0oo(other, "other");
        int length = getData$okio().length - other.length;
        int max = Math.max(i, 0);
        if (max <= length) {
            while (!SegmentedByteString.arrayRangeEquals(getData$okio(), max, other, 0, other.length)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    @XO0OX.xoIox
    public int lastIndexOf(@OXOo.OOXIXo byte[] other, int i) {
        IIX0o.x0xO0oo(other, "other");
        for (int min = Math.min(SegmentedByteString.resolveDefaultParameter(this, i), getData$okio().length - other.length); -1 < min; min--) {
            if (SegmentedByteString.arrayRangeEquals(getData$okio(), min, other, 0, other.length)) {
                return min;
            }
        }
        return -1;
    }
}
