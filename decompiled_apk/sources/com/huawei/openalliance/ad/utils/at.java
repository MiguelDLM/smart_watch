package com.huawei.openalliance.ad.utils;

import com.huawei.hms.ads.fb;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/* loaded from: classes10.dex */
public class at {
    private static final String Code = "at";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable] */
    public static Serializable Code(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        as asVar;
        String str2;
        String str3;
        Serializable serializable = null;
        try {
            try {
                fileInputStream = new FileInputStream((String) str);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                asVar = new as(fileInputStream);
                try {
                    Object readObject = asVar.readObject();
                    if (readObject instanceof Serializable) {
                        serializable = (Serializable) readObject;
                    }
                } catch (FileNotFoundException unused) {
                    fb.Z(Code, "read file FileNotFoundException");
                    ax.Code((Closeable) fileInputStream);
                    ax.Code((Closeable) asVar);
                    return serializable;
                } catch (IOException unused2) {
                    str2 = Code;
                    str3 = "read file IOException";
                    fb.I(str2, str3);
                    ax.Code((Closeable) fileInputStream);
                    ax.Code((Closeable) asVar);
                    return serializable;
                } catch (ClassNotFoundException unused3) {
                    str2 = Code;
                    str3 = "read file ClassNotFoundException";
                    fb.I(str2, str3);
                    ax.Code((Closeable) fileInputStream);
                    ax.Code((Closeable) asVar);
                    return serializable;
                }
            } catch (FileNotFoundException unused4) {
                asVar = null;
            } catch (IOException unused5) {
                asVar = null;
            } catch (ClassNotFoundException unused6) {
                asVar = null;
            } catch (Throwable th3) {
                th = th3;
                str = 0;
                ax.Code((Closeable) fileInputStream);
                ax.Code((Closeable) str);
                throw th;
            }
        } catch (FileNotFoundException unused7) {
            asVar = null;
            fileInputStream = null;
        } catch (IOException unused8) {
            asVar = null;
            fileInputStream = null;
        } catch (ClassNotFoundException unused9) {
            asVar = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            str = 0;
        }
        ax.Code((Closeable) fileInputStream);
        ax.Code((Closeable) asVar);
        return serializable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v3 */
    public static Serializable V(String str) {
        as asVar;
        String str2;
        String str3;
        Closeable closeable;
        Closeable closeable2;
        ?? Code2 = ay.Code((String) str);
        Serializable serializable = null;
        try {
            if (Code2 != 0) {
                return null;
            }
            try {
                Code2 = new ByteArrayInputStream(v.Code((String) str));
                try {
                    asVar = new as(Code2);
                    try {
                        Object readObject = asVar.readObject();
                        closeable2 = Code2;
                        if (readObject instanceof Serializable) {
                            serializable = (Serializable) readObject;
                            closeable2 = Code2;
                        }
                    } catch (UnsupportedEncodingException unused) {
                        str2 = Code;
                        str3 = "fail to get Serializable UnsupportedEncodingException";
                        closeable = Code2;
                        fb.Z(str2, str3);
                        closeable2 = closeable;
                        ax.Code((Closeable) asVar);
                        ax.Code(closeable2);
                        return serializable;
                    } catch (IOException unused2) {
                        str2 = Code;
                        str3 = "fail to get Serializable IOException";
                        closeable = Code2;
                        fb.Z(str2, str3);
                        closeable2 = closeable;
                        ax.Code((Closeable) asVar);
                        ax.Code(closeable2);
                        return serializable;
                    } catch (ClassNotFoundException unused3) {
                        str2 = Code;
                        str3 = "fail to get Serializable ClassNotFoundException";
                        closeable = Code2;
                        fb.Z(str2, str3);
                        closeable2 = closeable;
                        ax.Code((Closeable) asVar);
                        ax.Code(closeable2);
                        return serializable;
                    }
                } catch (UnsupportedEncodingException unused4) {
                    asVar = null;
                } catch (IOException unused5) {
                    asVar = null;
                } catch (ClassNotFoundException unused6) {
                    asVar = null;
                } catch (Throwable th) {
                    th = th;
                    str = 0;
                    ax.Code((Closeable) str);
                    ax.Code((Closeable) Code2);
                    throw th;
                }
            } catch (UnsupportedEncodingException unused7) {
                asVar = null;
                Code2 = 0;
            } catch (IOException unused8) {
                asVar = null;
                Code2 = 0;
            } catch (ClassNotFoundException unused9) {
                asVar = null;
                Code2 = 0;
            } catch (Throwable th2) {
                Code2 = 0;
                th = th2;
                str = 0;
            }
            ax.Code((Closeable) asVar);
            ax.Code(closeable2);
            return serializable;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String Code(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        if (serializable == null) {
            return "";
        }
        ObjectOutputStream objectOutputStream2 = null;
        byte[] bArr = null;
        objectOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
                objectOutputStream2 = objectOutputStream;
            }
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(serializable);
                    objectOutputStream.flush();
                    bArr = byteArrayOutputStream.toByteArray();
                } catch (IOException unused) {
                    fb.Z(Code, "fail to get sequence");
                    ax.Code(objectOutputStream);
                    ax.Code(byteArrayOutputStream);
                    return v.Code(bArr);
                }
            } catch (IOException unused2) {
                objectOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                ax.Code(objectOutputStream2);
                ax.Code(byteArrayOutputStream);
                throw th;
            }
        } catch (IOException unused3) {
            byteArrayOutputStream = null;
            objectOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
        ax.Code(objectOutputStream);
        ax.Code(byteArrayOutputStream);
        return v.Code(bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.io.Closeable, java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static boolean Code(Serializable serializable, String str) {
        Object obj;
        Object obj2;
        String str2;
        String str3;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File((String) str);
                if (!file.getParentFile().exists() && !r.Code(file.getParentFile())) {
                    fb.I(Code, "writeObject, mkdir failed");
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream((String) str);
                try {
                    str = new ObjectOutputStream(fileOutputStream2);
                    try {
                        str.writeObject(serializable);
                        ax.Code(fileOutputStream2);
                        ax.Code((Closeable) str);
                        return true;
                    } catch (FileNotFoundException unused) {
                        fileOutputStream = fileOutputStream2;
                        obj2 = str;
                        str2 = Code;
                        str3 = "write file FileNotFoundException";
                        str = obj2;
                        fb.I(str2, str3);
                        ax.Code(fileOutputStream);
                        ax.Code((Closeable) str);
                        return false;
                    } catch (IOException unused2) {
                        fileOutputStream = fileOutputStream2;
                        obj = str;
                        str2 = Code;
                        str3 = "write file IOException";
                        str = obj;
                        fb.I(str2, str3);
                        ax.Code(fileOutputStream);
                        ax.Code((Closeable) str);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        ax.Code(fileOutputStream);
                        ax.Code((Closeable) str);
                        throw th;
                    }
                } catch (FileNotFoundException unused3) {
                    str = 0;
                } catch (IOException unused4) {
                    str = 0;
                } catch (Throwable th2) {
                    th = th2;
                    str = 0;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException unused5) {
            obj2 = null;
        } catch (IOException unused6) {
            obj = null;
        } catch (Throwable th4) {
            th = th4;
            str = 0;
        }
    }
}
