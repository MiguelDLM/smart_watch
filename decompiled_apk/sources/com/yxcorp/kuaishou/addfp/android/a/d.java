package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.yxcorp.kuaishou.addfp.android.b.g;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class d {
    private static volatile d e;

    /* renamed from: a, reason: collision with root package name */
    private e f27635a;
    private ConcurrentHashMap b = new ConcurrentHashMap(10);
    private Context c;
    private int d;

    private d(Context context) {
        this.f27635a = null;
        this.d = 0;
        try {
            this.c = context;
            this.f27635a = new e(context);
            if (Build.VERSION.SDK_INT >= 30) {
                this.d = this.c.getApplicationInfo().targetSdkVersion;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized Pair a() {
        byte[] bArr;
        try {
            if (this.b != null) {
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty((String) this.b.get("cache_e"))) {
                    return Pair.create(Pair.create(Boolean.TRUE, sb.toString()), this.b);
                }
            }
            this.b.clear();
            String b = this.f27635a.b();
            if (!TextUtils.isEmpty(b)) {
                try {
                    bArr = Base64.decode(b, 0);
                } catch (Throwable unused) {
                    bArr = null;
                }
                if (bArr == null) {
                    try {
                        bArr = Base64.decode(b, 8);
                    } catch (Throwable unused2) {
                    }
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(com.yxcorp.kuaishou.addfp.android.b.b.b(bArr, "20212102sjcudiab".getBytes())));
                    this.b.put("cache_e", jSONObject.optString("cache_e", ""));
                    this.b.put("cache_m", jSONObject.optString("cache_m", ""));
                    this.b.put("c_time", Long.toString(jSONObject.optLong("c_time", 0L)));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            ConcurrentHashMap concurrentHashMap = this.b;
            if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty((String) this.b.get("cache_e"))) {
                    return Pair.create(Pair.create(Boolean.TRUE, sb2.toString()), this.b);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return Pair.create(Pair.create(Boolean.TRUE, "8"), null);
    }

    public LinkedHashMap b(String str) {
        Throwable th;
        ObjectInputStream objectInputStream = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(com.yxcorp.kuaishou.addfp.android.b.b.b(Base64.decode(str.getBytes(), 0), "20212102sjcudiab".getBytes())));
                try {
                    LinkedHashMap linkedHashMap = (LinkedHashMap) objectInputStream2.readObject();
                    try {
                        objectInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return linkedHashMap;
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream = objectInputStream2;
                    try {
                        th.printStackTrace();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return new LinkedHashMap();
                    } catch (Throwable th3) {
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th3;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
        return new LinkedHashMap();
    }

    public static d a(Context context) {
        if (e == null) {
            synchronized (d.class) {
                try {
                    if (e == null) {
                        e = new d(context);
                    }
                } finally {
                }
            }
        }
        return e;
    }

    public boolean b() {
        return this.d >= 30;
    }

    public String a(String str) {
        try {
            File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(this.c, false), new String(Base64.decode(str, 0)));
            if (!file.exists()) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return sb.toString().trim();
                }
                sb.append(readLine);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private String a(HashMap hashMap) {
        ObjectOutputStream objectOutputStream;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(hashMap);
                String str = new String(Base64.encode(com.yxcorp.kuaishou.addfp.android.b.b.c(byteArrayOutputStream.toByteArray(), "20212102sjcudiab".getBytes()), 0));
                try {
                    objectOutputStream.close();
                } catch (IOException unused) {
                }
                return str;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    if (objectOutputStream == null) {
                        return "";
                    }
                    try {
                        objectOutputStream.close();
                        return "";
                    } catch (IOException unused2) {
                        return "";
                    }
                } catch (Throwable th2) {
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream = null;
        }
    }

    public static void a(Context context, String str) {
        FileWriter fileWriter;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(context, false), new String(Base64.decode("Lm91a2R0ZnQ=", 0)));
                new File(file.getParent()).mkdirs();
                fileWriter = new FileWriter(file, false);
                try {
                    fileWriter.write(str);
                    fileWriter.flush();
                    fileWriter.close();
                } catch (Throwable unused) {
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                }
            } catch (Throwable unused2) {
                fileWriter = null;
            }
        } catch (IOException unused3) {
        }
    }

    public synchronized void a(String str, String str2) {
        byte[] bArr;
        HashMap hashMap = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.b.put("c_time", Long.toString(currentTimeMillis));
            this.b.put("cache_e", str);
            this.b.put("cache_m", str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("c_time", currentTimeMillis);
            jSONObject.put("cache_e", str);
            jSONObject.put("cache_m", str2);
            byte[] c = com.yxcorp.kuaishou.addfp.android.b.b.c(jSONObject.toString().getBytes(), "20212102sjcudiab".getBytes());
            try {
                bArr = Base64.encode(c, 0);
            } catch (Throwable unused) {
                bArr = null;
            }
            if (bArr == null) {
                try {
                    bArr = Base64.encode(c, 8);
                } catch (Throwable unused2) {
                }
            }
            if (bArr != null) {
                this.f27635a.a(new String(bArr));
            }
        } catch (Throwable unused3) {
        }
        try {
            String a2 = com.yxcorp.kuaishou.addfp.c.a.a.a(this.c, "k_w_o_d_out_dtt");
            if (TextUtils.isEmpty(a2) && g.a(this.c, new String[]{com.kuaishou.weapon.p0.g.i, com.kuaishou.weapon.p0.g.j})) {
                a2 = a("Lm91a2R0ZnQ=");
            }
            if (!TextUtils.isEmpty(a2) && (hashMap = b(a2)) != null) {
                c cVar = b.f27633a;
                String a3 = cVar.a();
                if (!TextUtils.isEmpty(a3)) {
                    if (hashMap.containsKey(a3)) {
                        hashMap.remove(a3);
                    }
                    hashMap.put(cVar.a(), str);
                }
            }
            if (hashMap == null || hashMap.size() == 0) {
                hashMap = new LinkedHashMap();
                hashMap.put(b.f27633a.a(), str);
            }
            String a4 = a(hashMap);
            if (!TextUtils.isEmpty(a4)) {
                try {
                    Settings.System.putString(this.c.getContentResolver(), "k_w_o_d_out_dtt", a4);
                } catch (Throwable unused4) {
                }
                if (g.a(this.c, new String[]{com.kuaishou.weapon.p0.g.i, com.kuaishou.weapon.p0.g.j})) {
                    a(this.c, a4);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
