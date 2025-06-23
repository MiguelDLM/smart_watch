package com.goodix.ble.libcomx.file;

import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.goodix.ble.libcomx.util.HexStringParser;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/* loaded from: classes9.dex */
public class SettingsStorage {
    private ILogger logger;
    private Object settings;
    private File storageFile;
    private final String TAG = getClass().getSimpleName();
    private final String LIST_HEADER = "LISTx";

    public SettingsStorage(Object obj, File file) {
        this.settings = obj;
        this.storageFile = file;
        if (obj != null) {
            if (file != null) {
                return;
            } else {
                throw new IllegalArgumentException("Storage file is null.");
            }
        }
        throw new IllegalArgumentException("Must bind with a nonnull object.");
    }

    private void onLoadField(Object obj, Field field, String str, Class<?> cls, Properties properties, ILogger iLogger) {
        String property = properties.getProperty(str, null);
        if (property != null) {
            try {
                if (Boolean.TYPE.equals(cls)) {
                    field.setBoolean(obj, Boolean.parseBoolean(property));
                } else if (Byte.TYPE.equals(cls)) {
                    field.setByte(obj, Byte.parseByte(property));
                } else if (Short.TYPE.equals(cls)) {
                    field.setShort(obj, Short.parseShort(property));
                } else if (Integer.TYPE.equals(cls)) {
                    field.setInt(obj, Integer.parseInt(property));
                } else if (Long.TYPE.equals(cls)) {
                    field.setLong(obj, Integer.parseInt(property));
                } else if (Float.TYPE.equals(cls)) {
                    field.setFloat(obj, Float.parseFloat(property));
                } else if (Double.TYPE.equals(cls)) {
                    field.setDouble(obj, Double.parseDouble(property));
                } else if (Integer.class.equals(cls)) {
                    field.set(obj, Integer.valueOf(Integer.parseInt(property)));
                } else if (Float.class.equals(cls)) {
                    field.set(obj, Float.valueOf(Float.parseFloat(property)));
                } else if (Double.class.equals(cls)) {
                    field.set(obj, Double.valueOf(Double.parseDouble(property)));
                } else {
                    if (!String.class.equals(cls) && !CharSequence.class.equals(cls)) {
                        if (byte[].class.equals(cls)) {
                            if (property.startsWith(HexStringBuilder.DEFAULT_PREFIX) && property.length() > 2) {
                                int length = (property.length() - 1) / 2;
                                byte[] bArr = new byte[length];
                                int parse = HexStringParser.parse(property, bArr, 0, length);
                                if (parse != length) {
                                    byte[] bArr2 = new byte[parse];
                                    System.arraycopy(bArr, 0, bArr2, 0, parse);
                                    bArr = bArr2;
                                }
                                field.set(obj, bArr);
                            }
                        } else if (List.class.isAssignableFrom(cls)) {
                            onLoadList(obj, field, str, cls, properties, iLogger);
                        } else {
                            processAllFields(field.get(obj), str, properties, false, iLogger);
                            property = "__OBJ__";
                        }
                    }
                    field.set(obj, property);
                }
                if (iLogger != null) {
                    iLogger.v(this.TAG, "load field: " + str + " = " + property);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (iLogger != null) {
                    iLogger.w(this.TAG, "Failed to copy " + str + ": " + e.getMessage());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01a4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void onLoadList(java.lang.Object r20, java.lang.reflect.Field r21, java.lang.String r22, java.lang.Class<?> r23, java.util.Properties r24, com.goodix.ble.libcomx.ILogger r25) throws java.lang.IllegalAccessException {
        /*
            Method dump skipped, instructions count: 427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.goodix.ble.libcomx.file.SettingsStorage.onLoadList(java.lang.Object, java.lang.reflect.Field, java.lang.String, java.lang.Class, java.util.Properties, com.goodix.ble.libcomx.ILogger):void");
    }

    private void onStoreField(Object obj, Field field, String str, Class<?> cls, Properties properties, ILogger iLogger) {
        String str2 = null;
        boolean z = false;
        try {
            if (Boolean.TYPE.equals(cls)) {
                str2 = String.valueOf(field.getBoolean(obj));
            } else if (Byte.TYPE.equals(cls)) {
                str2 = String.valueOf((int) field.getByte(obj));
            } else if (Short.TYPE.equals(cls)) {
                str2 = String.valueOf((int) field.getShort(obj));
            } else if (Integer.TYPE.equals(cls)) {
                str2 = String.valueOf(field.getInt(obj));
            } else if (Long.TYPE.equals(cls)) {
                str2 = String.valueOf(field.getLong(obj));
            } else if (Float.TYPE.equals(cls)) {
                str2 = String.valueOf(field.getFloat(obj));
            } else if (Double.TYPE.equals(cls)) {
                str2 = String.valueOf(field.getDouble(obj));
            } else if (Integer.class.equals(cls)) {
                if (field.get(obj) != null) {
                    str2 = String.valueOf(field.get(obj));
                }
            } else if (Float.class.equals(cls)) {
                if (field.get(obj) != null) {
                    str2 = String.valueOf(field.get(obj));
                }
            } else if (Double.class.equals(cls)) {
                if (field.get(obj) != null) {
                    str2 = String.valueOf(field.get(obj));
                }
            } else {
                if (!String.class.equals(cls) && !CharSequence.class.equals(cls)) {
                    if (List.class.isAssignableFrom(cls)) {
                        onStoreList((List) field.get(obj), str, properties, iLogger);
                    } else if (byte[].class.equals(cls)) {
                        byte[] bArr = (byte[]) field.get(obj);
                        if (bArr != null) {
                            str2 = new HexStringBuilder((bArr.length * 2) + 2).Ox().put(bArr).toString();
                        }
                    } else {
                        processAllFields(field.get(obj), str, properties, true, iLogger);
                    }
                    z = true;
                }
                str2 = (String) field.get(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str2 != null) {
            properties.setProperty(str, str2);
            if (iLogger != null) {
                iLogger.v(this.TAG, "store field: " + str);
                return;
            }
            return;
        }
        if (iLogger != null) {
            if (z) {
                iLogger.v(this.TAG, "store field: " + str);
                return;
            }
            iLogger.v(this.TAG, "Faild to store field: " + str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void onStoreList(java.util.List r18, java.lang.String r19, java.util.Properties r20, com.goodix.ble.libcomx.ILogger r21) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.goodix.ble.libcomx.file.SettingsStorage.onStoreList(java.util.List, java.lang.String, java.util.Properties, com.goodix.ble.libcomx.ILogger):void");
    }

    private void processAllFields(Object obj, String str, Properties properties, boolean z, ILogger iLogger) {
        if (obj != null && properties != null) {
            for (Field field : obj.getClass().getDeclaredFields()) {
                String name = field.getName();
                if (str != null) {
                    name = str + FileUtils.FILE_EXTENSION_SEPARATOR + name;
                }
                String str2 = name;
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers)) {
                    if (iLogger != null) {
                        iLogger.v(this.TAG, "skip static field: " + str2);
                    }
                } else if (Modifier.isFinal(modifiers)) {
                    if (iLogger != null) {
                        iLogger.v(this.TAG, "skip final field: " + str2);
                    }
                } else if (Modifier.isTransient(modifiers)) {
                    if (iLogger != null) {
                        iLogger.v(this.TAG, "skip transient field: " + str2);
                    }
                } else {
                    Class<?> type = field.getType();
                    if (SettingsStorage.class.equals(type)) {
                        if (iLogger != null) {
                            iLogger.v(this.TAG, "skip SettingsStorage field: " + str2);
                        }
                    } else {
                        field.setAccessible(true);
                        if (z) {
                            onStoreField(obj, field, str2, type, properties, iLogger);
                        } else {
                            onLoadField(obj, field, str2, type, properties, iLogger);
                        }
                    }
                }
            }
        }
    }

    public boolean load() {
        ILogger iLogger = this.logger;
        File file = this.storageFile;
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            if (iLogger != null) {
                iLogger.w(this.TAG, "File does not exist: " + file.getAbsolutePath());
            }
            return false;
        }
        Properties properties = new Properties();
        try {
            FileReader fileReader = new FileReader(file);
            properties.load(fileReader);
            fileReader.close();
            synchronized (this) {
                processAllFields(this.settings, null, properties, false, iLogger);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            if (iLogger != null) {
                iLogger.e(this.TAG, "Load Exception: " + e.getMessage(), e);
            }
            return false;
        }
    }

    public void setLogger(ILogger iLogger) {
        this.logger = iLogger;
    }

    public boolean store() {
        ILogger iLogger = this.logger;
        File file = this.storageFile;
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    if (iLogger != null) {
                        iLogger.e(this.TAG, "Failed to create JSON: " + file.getAbsolutePath());
                    }
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (iLogger != null) {
                    iLogger.e(this.TAG, "Failed to create JSON: " + file.getAbsolutePath(), e);
                }
                return false;
            }
        }
        Properties properties = new Properties();
        synchronized (this) {
            processAllFields(this.settings, null, properties, true, iLogger);
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
            properties.store(new PrintWriter(byteArrayOutputStream), (String) null);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));
            ArrayList arrayList = new ArrayList(1024);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            Collections.sort(arrayList);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                bufferedWriter.write((String) it.next());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            bufferedReader.close();
            byteArrayOutputStream.close();
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
