package com.baidu.navisdk.vi;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.navisdk.comapi.base.d;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9407a = "b";
    private static Map<Integer, Set<Handler>> b = new HashMap();
    private static Map<Integer, Set<Handler>> c = new HashMap();

    public static void a(d dVar) {
        if (dVar != null) {
            a(dVar, dVar.getInterests());
        }
    }

    public static void b(d dVar) {
        if (dVar != null) {
            c(dVar, dVar.getInterests());
        }
    }

    public static void c(Handler handler, Collection<Integer> collection) {
        if (handler != null && collection != null) {
            for (Integer num : collection) {
                if (num != null) {
                    synchronized (b) {
                        try {
                            Set<Handler> set = b.get(num);
                            if (set != null) {
                                set.remove(handler);
                                if (set.isEmpty()) {
                                    b.remove(num);
                                }
                            }
                        } finally {
                        }
                    }
                    synchronized (c) {
                        try {
                            Set<Handler> set2 = c.get(num);
                            if (set2 != null) {
                                set2.remove(handler);
                                if (set2.isEmpty()) {
                                    c.remove(num);
                                }
                            }
                        } finally {
                        }
                    }
                }
            }
        }
    }

    public static void a(Handler handler, Collection<Integer> collection) {
        if (handler == null || collection == null) {
            return;
        }
        for (Integer num : collection) {
            if (num != null) {
                synchronized (b) {
                    try {
                        Set<Handler> set = b.get(num);
                        if (set != null) {
                            set.add(handler);
                        } else {
                            HashSet hashSet = new HashSet();
                            hashSet.add(handler);
                            b.put(num, hashSet);
                        }
                    } finally {
                    }
                }
            }
        }
    }

    public static void b(Handler handler, Collection<Integer> collection) {
        if (handler == null || collection == null) {
            return;
        }
        for (Integer num : collection) {
            if (num != null) {
                synchronized (c) {
                    try {
                        Set<Handler> set = c.get(num);
                        if (set != null) {
                            set.add(handler);
                        } else {
                            HashSet hashSet = new HashSet();
                            hashSet.add(handler);
                            c.put(num, hashSet);
                        }
                    } finally {
                    }
                }
            }
        }
    }

    public static void a(int i, int i2, int i3) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(f9407a, "dispatchMessage --> what = " + i + ", arg1 = " + i2 + ", arg2 = " + i3);
        }
        if (i <= 4096) {
            return;
        }
        Bundle b2 = a.b(i);
        synchronized (c) {
            Set<Handler> set = c.get(Integer.valueOf(i));
            if (set != null) {
                for (Handler handler : set) {
                    if (handler != null) {
                        try {
                            handler.sendMessage(handler.obtainMessage(i, i2, i3, b2));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        synchronized (b) {
            Set<Handler> set2 = b.get(Integer.valueOf(i));
            if (set2 != null) {
                for (Handler handler2 : set2) {
                    if (handler2 != null) {
                        try {
                            handler2.sendMessage(handler2.obtainMessage(i, i2, i3, b2));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void a(d dVar, int i) {
        if (dVar != null) {
            if (i == 0) {
                b(dVar, dVar.getInterests());
            } else {
                a(dVar, dVar.getInterests());
            }
        }
    }
}
