package com.huawei.hms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.huawei.ads.R;
import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes10.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f17301a = new byte[0];
    private static final byte[] b = new byte[0];
    private static SoftReference<byte[]> c;

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final Long f17303a = 120000L;
        private static final byte[] h = new byte[0];
        private static volatile a i;
        private SharedPreferences b;
        private SharedPreferences c;
        private SharedPreferences d;
        private final byte[] e = new byte[0];
        private final byte[] f = new byte[0];
        private final byte[] g = new byte[0];
        private Context j;

        private a(Context context) {
            this.b = null;
            this.c = null;
            this.d = null;
            try {
                this.j = context.getApplicationContext();
                Context a2 = e.a(context);
                this.b = a2.getSharedPreferences("identifier_sp_story_book_file", 4);
                this.c = a2.getSharedPreferences("identifier_hiad_sp_bed_rock_file", 4);
                this.d = a2.getSharedPreferences("identifier_hiad_sp_red_stone_file", 4);
            } catch (Throwable th) {
                Log.w("Aes128", "get SharedPreference error: " + th.getClass().getSimpleName());
            }
        }

        public static a a(Context context) {
            a aVar;
            if (i != null) {
                return i;
            }
            synchronized (h) {
                try {
                    if (i == null) {
                        i = new a(context);
                    }
                    aVar = i;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVar;
        }

        public void b() {
            synchronized (this.g) {
                try {
                    SharedPreferences sharedPreferences = this.b;
                    if (sharedPreferences == null) {
                        return;
                    }
                    sharedPreferences.edit().putLong("read_first_chapter_time", System.currentTimeMillis()).apply();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c(String str) {
            synchronized (this.g) {
                try {
                    SharedPreferences sharedPreferences = this.b;
                    if (sharedPreferences == null) {
                        return;
                    }
                    sharedPreferences.edit().putString("catch_a_cat", str).commit();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void d() {
            synchronized (this.g) {
                try {
                    SharedPreferences sharedPreferences = this.b;
                    if (sharedPreferences == null) {
                        return;
                    }
                    sharedPreferences.edit().putBoolean("has_read_first_chapter", true).apply();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean e() {
            synchronized (this.g) {
                try {
                    SharedPreferences sharedPreferences = this.b;
                    if (sharedPreferences == null) {
                        return false;
                    }
                    return sharedPreferences.getBoolean("has_read_first_chapter", false);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public String f() {
            synchronized (this.e) {
                try {
                    SharedPreferences sharedPreferences = this.c;
                    if (sharedPreferences == null) {
                        return null;
                    }
                    return sharedPreferences.getString("get_a_book", null);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public String g() {
            synchronized (this.g) {
                try {
                    SharedPreferences sharedPreferences = this.b;
                    if (sharedPreferences == null) {
                        return null;
                    }
                    String string = sharedPreferences.getString("catch_a_cat", null);
                    if (string == null) {
                        string = d.a(d.a());
                        c(string);
                    }
                    return string;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public String h() {
            String string;
            synchronized (this.g) {
                string = this.b.getString("read_second_chapter", "");
            }
            return string;
        }

        public String a() {
            synchronized (this.f) {
                try {
                    SharedPreferences sharedPreferences = this.d;
                    if (sharedPreferences == null) {
                        return "";
                    }
                    String string = sharedPreferences.getString("read_first_chapter", "");
                    if (TextUtils.isEmpty(string)) {
                        return string;
                    }
                    return d.a(string, d.a(this.j));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void b(String str) {
            synchronized (this.e) {
                try {
                    SharedPreferences sharedPreferences = this.c;
                    if (sharedPreferences == null) {
                        return;
                    }
                    sharedPreferences.edit().putString("get_a_book", str).commit();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean c() {
            synchronized (this.g) {
                try {
                    SharedPreferences sharedPreferences = this.b;
                    if (sharedPreferences == null) {
                        return false;
                    }
                    long j = sharedPreferences.getLong("read_first_chapter_time", -1L);
                    if (j < 0) {
                        return false;
                    }
                    return j + f17303a.longValue() > System.currentTimeMillis();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void d(String str) {
            synchronized (this.g) {
                this.b.edit().putString("read_second_chapter", str).apply();
            }
        }

        public void a(String str) {
            synchronized (this.f) {
                try {
                    if (this.d == null) {
                        return;
                    }
                    this.d.edit().putString("read_first_chapter", d.b(str, d.a(this.j))).apply();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static String a(Context context, a aVar) {
        String a2 = a(b());
        aVar.b(b(a2, d(context)));
        return a2;
    }

    private static String b(int i) {
        try {
            SecureRandom c2 = c();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(Integer.toHexString(c2.nextInt(16)));
            }
            return sb.toString();
        } catch (Throwable th) {
            Log.w("Aes128", "generate aes key1 err:" + th.getClass().getSimpleName());
            return "";
        }
    }

    private static String c(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        Log.i("Aes128", "IV is invalid.");
        return "";
    }

    private static String d(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    private static byte[] e(Context context) {
        return a(context, f(context));
    }

    private static String f(Context context) {
        final a a2 = a.a(context);
        String h = a2.h();
        if (!TextUtils.isEmpty(h)) {
            return h;
        }
        final String b2 = b(64);
        e.f17304a.execute(new Runnable() { // from class: com.huawei.hms.ads.identifier.d.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(b2);
            }
        });
        return b2;
    }

    public static String a(String str, String str2) {
        String a2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        synchronized (f17301a) {
            try {
                try {
                    a2 = a(str, b(str2));
                } catch (Throwable th) {
                    Log.w("Aes128", "decrypt oaid ex: " + th.getClass().getSimpleName());
                    return null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return a2;
    }

    private static String b(Context context) {
        String str;
        if (context == null) {
            return "";
        }
        synchronized (b) {
            try {
                a a2 = a.a(context);
                String f = a2.f();
                if (f != null) {
                    String a3 = a(f, d(context));
                    if (!TextUtils.isEmpty(a3)) {
                        str = a3;
                    }
                }
                str = a(context, a2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    private static String c(String str, byte[] bArr) {
        byte[] a2;
        byte[] a3;
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || !d() || (a3 = a(str, bArr, (a2 = a(12)))) == null || a3.length == 0) {
            return "";
        }
        return a(a2) + a(a3);
    }

    private static String d(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16 && d()) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                String c2 = c(str);
                String d = d(str);
                if (TextUtils.isEmpty(c2) || TextUtils.isEmpty(d)) {
                    Log.i("Aes128", "ivParameter or encrypedWord is null");
                    return "";
                }
                cipher.init(2, secretKeySpec, d(a(c2)));
                return new String(cipher.doFinal(a(d)), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e = e;
                Log.e("Aes128", "GCM decrypt data exception: " + e.getMessage());
                return "";
            } catch (GeneralSecurityException e2) {
                e = e2;
                Log.e("Aes128", "GCM decrypt data exception: " + e.getMessage());
                return "";
            }
        }
        return "";
    }

    public static String a(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && str.length() >= 32 && bArr != null && bArr.length != 0) {
            try {
                if (d()) {
                    return d(str, bArr);
                }
            } catch (Throwable th) {
                Log.w("Aes128", "fail to decrypt: " + th.getClass().getSimpleName());
            }
        }
        return "";
    }

    public static String b(String str, byte[] bArr) {
        StringBuilder sb;
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length != 0) {
            try {
                if (d()) {
                    return c(str, bArr);
                }
            } catch (Exception e) {
                e = e;
                sb = new StringBuilder();
                sb.append("fail to cipher: ");
                sb.append(e.getClass().getSimpleName());
                Log.w("Aes128", sb.toString());
                return "";
            } catch (Throwable th) {
                e = th;
                sb = new StringBuilder();
                sb.append("fail to cipher: ");
                sb.append(e.getClass().getSimpleName());
                Log.w("Aes128", sb.toString());
                return "";
            }
        }
        return "";
    }

    private static SecureRandom c() {
        SecureRandom secureRandom;
        try {
            secureRandom = Build.VERSION.SDK_INT >= 26 ? SecureRandom.getInstanceStrong() : SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception e) {
            Log.w("Aes128", "getInstanceStrong, exception: " + e.getClass().getSimpleName());
            secureRandom = null;
        }
        return secureRandom == null ? new SecureRandom() : secureRandom;
    }

    private static AlgorithmParameterSpec d(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static boolean b(byte[] bArr) {
        return bArr != null && bArr.length >= 12;
    }

    private static boolean c(byte[] bArr) {
        return bArr != null && bArr.length >= 16;
    }

    private static boolean d() {
        return true;
    }

    public static byte[] a() {
        return a(16);
    }

    public static byte[] b() {
        return a(16);
    }

    private static byte[] c(Context context) {
        Log.i("Aes128", "regenerateWorkKey");
        a.a(context).b("");
        return a(b(context));
    }

    private static byte[] d(Context context) {
        String str;
        if (context == null) {
            return new byte[0];
        }
        a a2 = a.a(context);
        try {
            return a(a(e(context)).toCharArray(), a(a2.g()));
        } catch (NoSuchAlgorithmException unused) {
            str = "get userRootKey NoSuchAlgorithmException";
            Log.w("Aes128", str);
            return null;
        } catch (InvalidKeySpecException unused2) {
            str = "get userRootKey InvalidKeySpecException";
            Log.w("Aes128", str);
            return null;
        }
    }

    public static byte[] a(int i) {
        byte[] bArr = new byte[i];
        c().nextBytes(bArr);
        return bArr;
    }

    public static byte[] b(String str) throws UnsupportedEncodingException, NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = upperCase.getBytes("UTF-8");
        for (int i = 0; i < length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(HexStringBuilder.DEFAULT_PREFIX);
            int i2 = i * 2;
            sb.append(new String(new byte[]{bytes[i2]}, "UTF-8"));
            bArr[i] = (byte) (((byte) (Byte.decode(sb.toString()).byteValue() << 4)) ^ Byte.decode(HexStringBuilder.DEFAULT_PREFIX + new String(new byte[]{bytes[i2 + 1]}, "UTF-8")).byteValue());
        }
        return bArr;
    }

    public static byte[] a(Context context) {
        byte[] bArr;
        byte[] c2;
        synchronized (b) {
            SoftReference<byte[]> softReference = c;
            bArr = softReference != null ? softReference.get() : null;
            if (bArr == null) {
                try {
                    c2 = b(b(context));
                } catch (UnsupportedEncodingException unused) {
                    Log.w("Aes128", "getWorkKeyBytes UnsupportedEncodingException");
                    c2 = c(context);
                    bArr = c2;
                    c = new SoftReference<>(bArr);
                    return bArr;
                } catch (Throwable th) {
                    Log.w("Aes128", "getWorkKeyBytes " + th.getClass().getSimpleName());
                    c2 = c(context);
                    bArr = c2;
                    c = new SoftReference<>(bArr);
                    return bArr;
                }
                bArr = c2;
                c = new SoftReference<>(bArr);
            }
        }
        return bArr;
    }

    private static byte[] a(Context context, String str) {
        return a(str, context.getString(R.string.identifier_hiad_str_2), context.getString(R.string.identifier_hiad_str_3));
    }

    public static byte[] a(String str) {
        byte[] bArr = new byte[0];
        try {
            return b(str);
        } catch (Throwable th) {
            Log.e("Aes128", "hex string 2 byte: " + th.getClass().getSimpleName());
            return bArr;
        }
    }

    private static byte[] a(String str, String str2, String str3) {
        byte[] a2 = a(str);
        byte[] a3 = a(str2);
        return a(a(a2, a3), a(str3));
    }

    private static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        if (!TextUtils.isEmpty(str) && c(bArr) && b(bArr2) && d()) {
            try {
                return a(str.getBytes("UTF-8"), bArr, bArr2);
            } catch (UnsupportedEncodingException e) {
                Log.e("Aes128", "GCM encrypt data error" + e.getMessage());
            }
        } else {
            Log.i("Aes128", "gcm encrypt param is not right");
        }
        return new byte[0];
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= bArr2.length) {
            bArr2 = bArr;
            bArr = bArr2;
        }
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArr3 = new byte[length];
        int i = 0;
        while (i < length2) {
            bArr3[i] = (byte) (bArr2[i] ^ bArr[i]);
            i++;
        }
        while (i < bArr.length) {
            bArr3[i] = bArr[i];
            i++;
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        String str;
        if (bArr == null || bArr.length == 0) {
            str = "encrypt, contentBytes invalid.";
        } else if (bArr2 == null || bArr2.length < 16) {
            str = "encrypt, keyBytes invalid.";
        } else if (!d()) {
            str = "encrypt, osVersion too low.";
        } else if (bArr3 == null || bArr3.length < 12) {
            str = "encrypt, random invalid.";
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(1, secretKeySpec, d(bArr3));
                return cipher.doFinal(bArr);
            } catch (GeneralSecurityException e) {
                Log.e("Aes128", "GCM encrypt data error" + e.getMessage());
            }
        }
        Log.i("Aes128", str);
        return new byte[0];
    }

    public static byte[] a(char[] cArr, byte[] bArr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return SecretKeyFactory.getInstance(Build.VERSION.SDK_INT > 26 ? "PBKDF2WithHmacSHA256" : "PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(cArr, bArr, 10000, 256)).getEncoded();
    }
}
