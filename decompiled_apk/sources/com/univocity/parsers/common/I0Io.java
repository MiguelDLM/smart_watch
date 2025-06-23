package com.univocity.parsers.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes13.dex */
public class I0Io {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String[] f27012oIX0oI = new String[0];

    public static int I0Io(Object[] objArr, Object obj) {
        if (objArr != null) {
            int i = 0;
            if (obj == null) {
                while (i < objArr.length) {
                    if (objArr[i] == null) {
                        return i;
                    }
                    i++;
                }
                return -1;
            }
            if ((obj instanceof String) && (objArr instanceof String[])) {
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    if (obj.toString().equalsIgnoreCase(String.valueOf(objArr[i2]))) {
                        return i2;
                    }
                }
            }
            while (i < objArr.length) {
                if (obj.equals(objArr[i])) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        throw new NullPointerException("Null array");
    }

    public static Reader II0XooXoX(InputStream inputStream, String str) {
        return xxIXOIIO(inputStream, Charset.forName(str));
    }

    public static Object[] II0xO0(Object[] objArr, Object[] objArr2) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr2) {
            if (I0Io(objArr, obj) == -1) {
                arrayList.add(obj);
            }
        }
        return arrayList.toArray();
    }

    public static char[] IIXOooo(Collection<Character> collection) {
        char[] cArr = new char[collection.size()];
        Iterator<Character> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            cArr[i] = it.next().charValue();
            i++;
        }
        return cArr;
    }

    public static void IXxxXO(Collection<String> collection) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection.size());
        for (String str : collection) {
            if (str == null) {
                linkedHashSet.add(null);
            } else {
                linkedHashSet.add(str.trim().toLowerCase());
            }
        }
        collection.clear();
        collection.addAll(linkedHashSet);
    }

    public static Writer OOXIXo(File file, String str) {
        return oOoXoXO(file, Charset.forName(str));
    }

    public static String Oo(String str) {
        if (str == null) {
            return null;
        }
        return str.trim().toLowerCase();
    }

    public static Reader Oxx0IOOO(InputStream inputStream) {
        return xxIXOIIO(inputStream, null);
    }

    public static String[] Oxx0xo(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = Oo(strArr[i]);
        }
        return strArr2;
    }

    public static String[] OxxIIOOXO(List<Enum> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = list.get(i).toString();
        }
        return strArr;
    }

    public static Reader X0o0xo(File file, String str) {
        return XO(file, Charset.forName(str));
    }

    public static Reader XO(File file, Charset charset) {
        try {
            return xxIXOIIO(new FileInputStream(file), charset);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> void oI0IIXIo(String str, T... tArr) {
        if (tArr != null) {
            if (tArr.length != 0) {
                return;
            }
            throw new IllegalArgumentException(str + " must not be empty");
        }
        throw new IllegalArgumentException(str + " must not be null");
    }

    public static Object[] oIX0oI(Object[] objArr, Collection<?> collection) {
        return II0xO0(objArr, collection.toArray());
    }

    public static Writer oO(OutputStream outputStream, Charset charset) {
        if (charset != null) {
            return new OutputStreamWriter(outputStream, charset);
        }
        return new OutputStreamWriter(outputStream);
    }

    public static Writer oOoXoXO(File file, Charset charset) {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new IllegalArgumentException("Unable to create file '" + file.getAbsolutePath() + "', please ensure your application has permission to create files in that path", e);
            }
        }
        try {
            return oO(new FileOutputStream(file), charset);
        } catch (FileNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Writer ooOOo0oXI(OutputStream outputStream) {
        return oO(outputStream, null);
    }

    public static Reader oxoX(File file) {
        return XO(file, null);
    }

    public static Writer x0XOIxOo(OutputStream outputStream, String str) {
        return oO(outputStream, Charset.forName(str));
    }

    public static <T> void x0xO0oo(String str, T... tArr) {
        oI0IIXIo(str, tArr);
        for (T t : tArr) {
            if (t == null) {
                if (tArr.length > 0) {
                    throw new IllegalArgumentException(str + " must not contain nulls");
                }
                throw new IllegalArgumentException(str + " must not be null");
            }
        }
    }

    public static Writer xoIox(File file) {
        return oOoXoXO(file, null);
    }

    public static int[] xoXoI(Collection<Integer> collection) {
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        return iArr;
    }

    public static Reader xxIXOIIO(InputStream inputStream, Charset charset) {
        if (charset != null) {
            return new InputStreamReader(inputStream, charset);
        }
        return new InputStreamReader(inputStream);
    }
}
