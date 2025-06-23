package com.jd.ad.sdk.jad_sf;

import android.text.TextUtils;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.jad_ob.jad_hu;
import com.jd.ad.sdk.jad_sf.jad_bo;
import com.jd.ad.sdk.jad_vi.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes10.dex */
public final class jad_an {
    public final Map<String, Object> jad_an = new HashMap();
    public final ReadWriteLock jad_bo = new ReentrantReadWriteLock();

    /* renamed from: com.jd.ad.sdk.jad_sf.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class RunnableC0716jad_an implements Runnable {
        public final /* synthetic */ String jad_an;
        public final /* synthetic */ Object jad_bo;

        public RunnableC0716jad_an(jad_an jad_anVar, String str, Object obj) {
            this.jad_an = str;
            this.jad_bo = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_cp.jad_an((jad_dq) null, this.jad_an, this.jad_bo);
        }
    }

    /* loaded from: classes10.dex */
    public static final class jad_bo {
        public static final jad_an jad_an = new jad_an();
    }

    public boolean jad_an(String str, boolean z) {
        try {
            if (z) {
                return this.jad_an.containsKey(str);
            }
            if (jad_hu.jad_dq(com.jd.ad.sdk.jad_do.jad_bo.jad_an())) {
                return jad_bo.jad_an.jad_an.jad_an(str, z);
            }
            return jad_cp.jad_an(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public synchronized void jad_bo(String str, Object obj) {
        try {
            try {
                if (!this.jad_an.containsKey(str)) {
                    this.jad_an.put(str, obj);
                } else {
                    Object obj2 = this.jad_an.get(str);
                    if (obj2 != null && !obj2.equals(obj)) {
                        this.jad_an.put(str, obj);
                    }
                }
            } catch (Exception e) {
                Logger.w("Exception while mem: ", e.getMessage());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public int jad_cp(String str) {
        Object jad_bo2 = jad_bo.jad_an.jad_bo(str);
        if (jad_bo2 != null && (jad_bo2 instanceof Integer)) {
            return ((Integer) jad_bo2).intValue();
        }
        return -1;
    }

    public String jad_dq(String str) {
        Object jad_bo2 = jad_bo.jad_an.jad_bo(str);
        if (jad_bo2 != null && (jad_bo2 instanceof String)) {
            return (String) jad_bo2;
        }
        return "";
    }

    public void jad_an(String str, Object obj) {
        this.jad_bo.writeLock().lock();
        try {
            try {
                if (jad_hu.jad_dq(com.jd.ad.sdk.jad_do.jad_bo.jad_an())) {
                    jad_bo.jad_an.jad_an.jad_an(str, obj);
                } else {
                    WorkExecutor.execute(new RunnableC0716jad_an(this, str, obj));
                }
                this.jad_bo.writeLock().unlock();
            } catch (Exception e) {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_SAVE_CACHE_OTHER_ERROR;
                jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                this.jad_bo.writeLock().unlock();
            }
        } catch (Throwable th) {
            this.jad_bo.writeLock().unlock();
            throw th;
        }
    }

    public Object jad_bo(String str) {
        Object obj;
        this.jad_bo.readLock().lock();
        try {
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.jad_bo.readLock().unlock();
            throw th;
        }
        if (this.jad_an.containsKey(str)) {
            obj = this.jad_an.get(str);
            this.jad_bo.readLock().unlock();
            return obj;
        }
        obj = null;
        this.jad_bo.readLock().unlock();
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T jad_an(String str, Class<T> cls) {
        T t;
        this.jad_bo.readLock().lock();
        T t2 = null;
        try {
            try {
                if (jad_hu.jad_dq(com.jd.ad.sdk.jad_do.jad_bo.jad_an())) {
                    t = jad_bo.jad_an.jad_an.jad_an(str, (Class) cls);
                } else if (this.jad_an.containsKey(str)) {
                    t = jad_an(cls, this.jad_an.get(str));
                } else {
                    t = jad_an(cls, jad_cp.jad_an((jad_dq) null, str, (Class<?>) cls));
                }
                t2 = t;
            } catch (Exception e) {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_READ_CACHE_ERROR;
                jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                this.jad_bo.readLock().unlock();
            }
            return t2;
        } finally {
            this.jad_bo.readLock().unlock();
        }
    }

    public final <T> T jad_an(Class<T> cls, Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            String valueOf = String.valueOf(obj);
            if (TextUtils.isEmpty(valueOf)) {
                return null;
            }
            if (cls == String.class) {
                obj = (T) valueOf;
            } else if (cls == Integer.TYPE) {
                obj = (T) Integer.valueOf(valueOf);
            } else if (cls == Long.TYPE) {
                obj = (T) Long.valueOf(valueOf);
            } else if (cls == Float.TYPE) {
                obj = (T) Float.valueOf(valueOf);
            } else if (cls == Boolean.TYPE) {
                obj = (T) Boolean.valueOf(valueOf);
            } else if (cls == Double.TYPE) {
                obj = (T) Double.valueOf(valueOf);
            }
            return (T) obj;
        } catch (Exception e) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_READ_CACHE_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
            return null;
        }
    }

    public void jad_an(String str, String str2) {
        byte[] bytes;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String ja = ANEProxy.ja(str2);
                if (!TextUtils.isEmpty(ja) && (bytes = ja.getBytes(Charset.forName("UTF-8"))) != null && bytes.length > 0) {
                    jad_bo.jad_an.jad_an(str, (Object) new String(bytes));
                }
            }
        } catch (Exception e) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while s2ce: ");
            jad_an.append(e.getMessage());
            Logger.w(jad_an.toString(), new Object[0]);
        }
    }

    public String jad_an(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String str2 = (String) jad_bo.jad_an.jad_an(str, String.class);
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            String jb = ANEProxy.jb(str2);
            return TextUtils.isEmpty(jb) ? "" : jb;
        } catch (Exception e) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while gfcd: ");
            jad_an.append(e.getMessage());
            Logger.w(jad_an.toString(), new Object[0]);
            return "";
        }
    }
}
