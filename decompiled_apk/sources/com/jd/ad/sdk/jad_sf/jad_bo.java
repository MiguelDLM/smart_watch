package com.jd.ad.sdk.jad_sf;

import android.text.TextUtils;
import com.jd.ad.sdk.jad_vi.jad_fs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes10.dex */
public class jad_bo {
    public final Map<String, Object> jad_an = new HashMap();
    public final ReadWriteLock jad_bo = new ReentrantReadWriteLock();
    public jad_dq jad_cp;

    /* loaded from: classes10.dex */
    public static final class jad_an {
        public static final jad_bo jad_an = new jad_bo();
    }

    public void jad_an(String str, Object obj) {
        if (this.jad_cp == null) {
            this.jad_cp = jad_dq.jad_an("jadyunsdk");
        }
        this.jad_bo.writeLock().lock();
        try {
            try {
                if (!this.jad_an.containsKey(str)) {
                    if (jad_cp.jad_an(this.jad_cp, str, obj)) {
                        this.jad_an.put(str, obj);
                    }
                } else {
                    Object obj2 = this.jad_an.get(str);
                    if (obj2 != null && !obj2.equals(obj) && jad_cp.jad_an(this.jad_cp, str, obj)) {
                        this.jad_an.put(str, obj);
                    }
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

    public void jad_an(String... strArr) {
        if (this.jad_cp == null) {
            return;
        }
        this.jad_bo.writeLock().lock();
        try {
            try {
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    if (this.jad_an.containsKey(str)) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() != 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        this.jad_cp.jad_an.edit().remove((String) arrayList.get(i)).apply();
                        this.jad_an.remove(arrayList.get(i));
                    }
                }
                this.jad_bo.writeLock().unlock();
            } catch (Exception e) {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_DELETE_CACHE_ERROR;
                jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                this.jad_bo.writeLock().unlock();
            }
        } catch (Throwable th) {
            this.jad_bo.writeLock().unlock();
            throw th;
        }
    }

    public boolean jad_an(String str, boolean z) {
        if (this.jad_an.containsKey(str)) {
            return true;
        }
        if (z) {
            return false;
        }
        return this.jad_cp.jad_an.contains(str);
    }

    public <T> T jad_an(String str, Class<T> cls) {
        T t;
        this.jad_bo.readLock().lock();
        try {
            try {
                if (this.jad_an.containsKey(str)) {
                    t = (T) jad_an(cls, this.jad_an.get(str));
                } else {
                    if (this.jad_cp == null) {
                        this.jad_cp = jad_dq.jad_an("jadyunsdk");
                    }
                    t = (T) jad_an(cls, jad_cp.jad_an(this.jad_cp, str, (Class<?>) cls));
                }
                this.jad_bo.readLock().unlock();
                return t;
            } catch (Exception e) {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_READ_CACHE_ERROR;
                jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                this.jad_bo.readLock().unlock();
                return null;
            }
        } catch (Throwable th) {
            this.jad_bo.readLock().unlock();
            throw th;
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
}
