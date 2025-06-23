package com.blankj.utilcode.util;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes8.dex */
public final class ServiceUtils {
    private ServiceUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void bindService(@NonNull String str, @NonNull ServiceConnection serviceConnection, int i) {
        if (str == null) {
            throw new NullPointerException("Argument 'className' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (serviceConnection != null) {
            try {
                bindService(Class.forName(str), serviceConnection, i);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        throw new NullPointerException("Argument 'conn' of type ServiceConnection (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static Set getAllRunningServices() {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) Utils.getApp().getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningServices(Integer.MAX_VALUE);
        HashSet hashSet = new HashSet();
        if (runningServices != null && runningServices.size() != 0) {
            Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().service.getClassName());
            }
            return hashSet;
        }
        return null;
    }

    public static boolean isServiceRunning(@NonNull Class<?> cls) {
        if (cls != null) {
            return isServiceRunning(cls.getName());
        }
        throw new NullPointerException("Argument 'cls' of type Class<?> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void startService(@NonNull String str) {
        if (str != null) {
            try {
                startService(Class.forName(str));
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        throw new NullPointerException("Argument 'className' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static boolean stopService(@NonNull String str) {
        if (str != null) {
            try {
                return stopService(Class.forName(str));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        throw new NullPointerException("Argument 'className' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void unbindService(@NonNull ServiceConnection serviceConnection) {
        if (serviceConnection != null) {
            Utils.getApp().unbindService(serviceConnection);
            return;
        }
        throw new NullPointerException("Argument 'conn' of type ServiceConnection (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static boolean isServiceRunning(@NonNull String str) {
        if (str != null) {
            try {
                List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) Utils.getApp().getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningServices(Integer.MAX_VALUE);
                if (runningServices != null && runningServices.size() != 0) {
                    Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
                    while (it.hasNext()) {
                        if (str.equals(it.next().service.getClassName())) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        throw new NullPointerException("Argument 'className' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void startService(@NonNull Class<?> cls) {
        if (cls != null) {
            try {
                Intent intent = new Intent(Utils.getApp(), cls);
                intent.setFlags(32);
                if (Build.VERSION.SDK_INT >= 26) {
                    Utils.getApp().startForegroundService(intent);
                } else {
                    Utils.getApp().startService(intent);
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        throw new NullPointerException("Argument 'cls' of type Class<?> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static boolean stopService(@NonNull Class<?> cls) {
        if (cls != null) {
            return Utils.getApp().stopService(new Intent(Utils.getApp(), cls));
        }
        throw new NullPointerException("Argument 'cls' of type Class<?> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void bindService(@NonNull Class<?> cls, @NonNull ServiceConnection serviceConnection, int i) {
        if (cls == null) {
            throw new NullPointerException("Argument 'cls' of type Class<?> (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (serviceConnection != null) {
            Utils.getApp().bindService(new Intent(Utils.getApp(), cls), serviceConnection, i);
            return;
        }
        throw new NullPointerException("Argument 'conn' of type ServiceConnection (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }
}
