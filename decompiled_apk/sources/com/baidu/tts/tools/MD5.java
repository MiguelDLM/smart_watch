package com.baidu.tts.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* loaded from: classes8.dex */
public class MD5 {
    public static volatile MD5 b;

    /* renamed from: a, reason: collision with root package name */
    public char[] f10172a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static MD5 getInstance() {
        if (b == null) {
            synchronized (MD5.class) {
                try {
                    if (b == null) {
                        b = new MD5();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public final String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            char[] cArr = this.f10172a;
            char c = cArr[(b2 & 240) >> 4];
            char c2 = cArr[b2 & 15];
            stringBuffer.append(c);
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }

    public String getBigFileMd5(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    String a2 = a(messageDigest.digest());
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return a2;
                } catch (Exception unused) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public String getFileMd5(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        FileChannel fileChannel;
        Throwable th2;
        FileChannel fileChannel2 = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            File file = new File(str);
            fileInputStream = new FileInputStream(file);
            try {
                fileChannel = fileInputStream.getChannel();
                try {
                    messageDigest.update(fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, file.length()));
                    String a2 = a(messageDigest.digest());
                    try {
                        fileChannel.close();
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return a2;
                } catch (Exception unused) {
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                } catch (Throwable th3) {
                    th2 = th3;
                    th = th2;
                    fileChannel2 = fileChannel;
                    if (fileChannel2 != null) {
                        try {
                            fileChannel2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        throw th;
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                fileChannel = null;
            } catch (Throwable th4) {
                fileChannel = null;
                th2 = th4;
            }
        } catch (Exception unused3) {
            fileInputStream = null;
            fileChannel = null;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
    }

    public String getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[digest.length * 2];
            int i = 0;
            for (byte b2 : digest) {
                int i2 = i + 1;
                char[] cArr2 = this.f10172a;
                cArr[i] = cArr2[(b2 >>> 4) & 15];
                i += 2;
                cArr[i2] = cArr2[b2 & 15];
            }
            return new String(cArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getBigFileMd5(String str) {
        return getBigFileMd5(new File(str));
    }
}
