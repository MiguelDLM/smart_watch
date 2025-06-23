package com.baidu.platform.comjni.tools;

import android.text.TextUtils;
import com.baidu.entity.pb.BuildConfig;
import com.baidu.entity.pb.RepHead;
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
public class ProtobufUtils {
    private static final boolean DEBUG = false;
    static final String TAG = "ProtobufUtils";
    private static Map<String, Method> cachedMethodMap = new HashMap();

    /* loaded from: classes8.dex */
    public static class a {
        public a(MessageMicro messageMicro) {
            messageMicro.getClass();
        }
    }

    private static void copyStream(InputStream inputStream, OutputStream outputStream) throws IOException {
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

    public static a fromMessageLite(MessageMicro messageMicro) {
        return new a(messageMicro);
    }

    public static MessageMicro getMessageLite(ClassLoader classLoader, String str, String str2, byte[] bArr, int i, int i2) {
        if (bArr != null && !TextUtils.isEmpty(str2)) {
            try {
                return (MessageMicro) getParseFromMethod(classLoader, str + FileUtils.FILE_EXTENSION_SEPARATOR + str2.replace("\\.", "\\$")).invoke(null, readStream(new ByteArrayInputStream(bArr, i, i2)));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static List<MessageMicro> getMessageLiteList(ClassLoader classLoader, byte[] bArr, String str) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (bArr != null && bArr.length != 0) {
            int i = ByteBuffer.wrap(bArr, 0, 4).order(ByteOrder.BIG_ENDIAN).getInt();
            RepHead parseFrom = RepHead.parseFrom(readStream(new ByteArrayInputStream(bArr, 4, i)));
            int messageHeadCount = parseFrom.getMessageHeadCount();
            int i2 = i + 4;
            for (int i3 = 0; i3 < messageHeadCount; i3++) {
                RepHead.MessageHead messageHead = parseFrom.getMessageHead(i3);
                MessageMicro messageLite = getMessageLite(classLoader, str, messageHead.getName(), bArr, i2 + messageHead.getOffset(), messageHead.getLength());
                if (messageLite != null) {
                    arrayList.add(messageLite);
                }
            }
        }
        return arrayList;
    }

    private static Method getParseFromMethod(ClassLoader classLoader, String str) throws ClassNotFoundException, NoSuchMethodException {
        String str2 = str + "@" + classLoader.hashCode();
        Method method = cachedMethodMap.get(str2);
        if (method != null) {
            return method;
        }
        Method declaredMethod = Class.forName(str, true, classLoader).getDeclaredMethod("parseFrom", byte[].class);
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            cachedMethodMap.put(str2, declaredMethod);
        }
        return declaredMethod;
    }

    public static byte[] readStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copyStream(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static MessageMicro getMessageLite(String str, String str2, byte[] bArr, int i, int i2) {
        if (bArr != null && !TextUtils.isEmpty(str2)) {
            try {
                return (MessageMicro) getParseFromMethod(ProtobufUtils.class.getClassLoader(), str + FileUtils.FILE_EXTENSION_SEPARATOR + str2.replace("\\.", "\\$")).invoke(null, readStream(new ByteArrayInputStream(bArr, i, i2)));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static MessageMicro getMessageLite(ClassLoader classLoader, String str, byte[] bArr, int i, int i2) {
        return getMessageLite(classLoader, BuildConfig.APPLICATION_ID, str, bArr, i, i2);
    }

    public static MessageMicro getMessageLite(String str, byte[] bArr, int i, int i2) {
        return getMessageLite(BuildConfig.APPLICATION_ID, str, bArr, i, i2);
    }

    public static MessageMicro getMessageLite(ClassLoader classLoader, String str, String str2, byte[] bArr) {
        if (bArr != null && !TextUtils.isEmpty(str2)) {
            try {
                return (MessageMicro) getParseFromMethod(classLoader, str + FileUtils.FILE_EXTENSION_SEPARATOR + str2.replace("\\.", "\\$")).invoke(null, bArr);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static List<MessageMicro> getMessageLiteList(byte[] bArr, String str) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (bArr != null && bArr.length != 0) {
            int i = ByteBuffer.wrap(bArr, 0, 4).order(ByteOrder.BIG_ENDIAN).getInt();
            RepHead parseFrom = RepHead.parseFrom(readStream(new ByteArrayInputStream(bArr, 4, i)));
            int messageHeadCount = parseFrom.getMessageHeadCount();
            int i2 = i + 4;
            for (int i3 = 0; i3 < messageHeadCount; i3++) {
                RepHead.MessageHead messageHead = parseFrom.getMessageHead(i3);
                String name = messageHead.getName();
                int length = messageHead.getLength();
                int offset = messageHead.getOffset() + i2;
                if (name.equals("M")) {
                    MagicMsg magicMsg = new MagicMsg();
                    magicMsg.buffer = readStream(new ByteArrayInputStream(bArr, offset, length));
                    arrayList.add(magicMsg);
                } else {
                    MessageMicro messageLite = getMessageLite(str, name, bArr, offset, length);
                    if (messageLite != null) {
                        arrayList.add(messageLite);
                    }
                }
            }
        }
        return arrayList;
    }

    public static MessageMicro getMessageLite(String str, String str2, byte[] bArr) {
        if (bArr != null && !TextUtils.isEmpty(str2)) {
            try {
                return (MessageMicro) getParseFromMethod(ProtobufUtils.class.getClassLoader(), str + FileUtils.FILE_EXTENSION_SEPARATOR + str2.replace("\\.", "\\$")).invoke(null, bArr);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static MessageMicro getMessageLite(ClassLoader classLoader, String str, byte[] bArr) {
        return getMessageLite(classLoader, BuildConfig.APPLICATION_ID, str, bArr);
    }

    public static MessageMicro getMessageLite(String str, byte[] bArr) {
        return getMessageLite(BuildConfig.APPLICATION_ID, str, bArr);
    }

    public static List<MessageMicro> getMessageLiteList(ClassLoader classLoader, byte[] bArr) throws IOException {
        return getMessageLiteList(classLoader, bArr, BuildConfig.APPLICATION_ID);
    }

    public static List<MessageMicro> getMessageLiteList(byte[] bArr) throws IOException {
        return getMessageLiteList(bArr, BuildConfig.APPLICATION_ID);
    }
}
