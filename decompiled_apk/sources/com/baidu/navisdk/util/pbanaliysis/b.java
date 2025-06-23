package com.baidu.navisdk.util.pbanaliysis;

import android.text.TextUtils;
import com.baidu.entity.pb.BuildConfig;
import com.baidu.entity.pb.RepHead;
import com.baidu.navisdk.util.common.LogUtil;
import com.google.protobuf.micro.MessageMicro;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9351a = "b";
    private static Map<String, Method> b = new HashMap();

    private static Method a(ClassLoader classLoader, String str) throws ClassNotFoundException, NoSuchMethodException {
        String str2 = str + "@" + classLoader.hashCode();
        Method method = b.get(str2);
        if (method != null) {
            return method;
        }
        Method declaredMethod = Class.forName(str, true, classLoader).getDeclaredMethod("parseFrom", byte[].class);
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            b.put(str2, declaredMethod);
        }
        return declaredMethod;
    }

    public static MessageMicro a(String str, String str2, byte[] bArr, int i, int i2) {
        if (bArr != null && !TextUtils.isEmpty(str2)) {
            try {
                return (MessageMicro) a(b.class.getClassLoader(), str + FileUtils.FILE_EXTENSION_SEPARATOR + str2.replace("\\.", "\\$")).invoke(null, a(new ByteArrayInputStream(bArr, i, i2)));
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(f9351a, e.toString());
                }
            }
        }
        return null;
    }

    public static List<MessageMicro> a(byte[] bArr, String str) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (bArr != null && bArr.length != 0) {
            int i = ByteBuffer.wrap(bArr, 0, 4).order(ByteOrder.BIG_ENDIAN).getInt();
            RepHead parseFrom = RepHead.parseFrom(a(new ByteArrayInputStream(bArr, 4, i)));
            int messageHeadCount = parseFrom.getMessageHeadCount();
            int i2 = i + 4;
            for (int i3 = 0; i3 < messageHeadCount; i3++) {
                RepHead.MessageHead messageHead = parseFrom.getMessageHead(i3);
                String name = messageHead.getName();
                int length = messageHead.getLength();
                int offset = messageHead.getOffset() + i2;
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(f9351a, "调试PB解析：\nname-> " + name + "\noffset-> " + offset + "\nlen-> " + length);
                }
                if (name.equals("M")) {
                    a aVar = new a();
                    a(new ByteArrayInputStream(bArr, offset, length));
                    arrayList.add(aVar);
                } else {
                    MessageMicro a2 = a(str, name, bArr, offset, length);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
            }
            return arrayList;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(f9351a, "JNI获取引擎传递的PB数据失败！");
        }
        return arrayList;
    }

    public static List<MessageMicro> a(byte[] bArr) throws IOException {
        return a(bArr, BuildConfig.APPLICATION_ID);
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        if (!(outputStream instanceof BufferedOutputStream)) {
            outputStream = new BufferedOutputStream(outputStream);
        }
        byte[] bArr = new byte[512];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    inputStream.close();
                    outputStream.close();
                    return;
                }
            } catch (Throwable th) {
                inputStream.close();
                outputStream.close();
                throw th;
            }
        }
    }
}
