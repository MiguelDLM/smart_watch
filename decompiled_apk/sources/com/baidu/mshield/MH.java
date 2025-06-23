package com.baidu.mshield;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mshield.rp.Receiver;
import com.baidu.mshield.utility.g;
import com.baidu.mshield.x0.EngineImpl;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class MH {
    private static boolean isLoad = false;
    private static Receiver sdkRceiver;

    private MH() {
    }

    public static String getVersion(Context context) {
        return "4.2.2";
    }

    public static String gz(Context context) {
        return com.baidu.mshield.core.a.d(context);
    }

    public static String gzfi(Context context, String str, int i, String str2, HashMap<String, String> hashMap) {
        try {
            if (com.baidu.mshield.utility.a.g(context) == 1) {
                if (!isLoad) {
                    init(context, hashMap);
                }
                return com.baidu.mshield.core.a.a(context, str, i, str2);
            }
            Bundle bundle = new Bundle();
            bundle.putString("accountId", str);
            bundle.putInt("scene", i);
            bundle.putString("para", str2);
            bundle.putBundle("property", obtainBundleFromProperties(hashMap));
            return g.a(context, "gzfi", bundle).getString("result", "");
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return "";
        }
    }

    public static String init(Context context, HashMap<String, String> hashMap) {
        try {
            if (com.baidu.mshield.utility.a.g(context) == 1) {
                if (!isLoad) {
                    initPlugin(context, hashMap);
                    isLoad = true;
                }
                return gz(context);
            }
            return g.a(context, "init", obtainBundleFromProperties(hashMap)).getString("result", "");
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean initAppkey(Context context) {
        boolean z;
        String[] c = com.baidu.mshield.utility.a.c(context);
        if (c != null && c.length == 2 && !TextUtils.isEmpty(c[0]) && !TextUtils.isEmpty(c[1])) {
            z = false;
        } else {
            z = true;
        }
        if (!z || com.baidu.mshield.key.a.a(context)) {
            return true;
        }
        return false;
    }

    private static void initPlugin(Context context, HashMap<String, String> hashMap) {
        new Thread(new a(context, hashMap)).start();
    }

    private static Bundle obtainBundleFromProperties(HashMap<String, String> hashMap) {
        Bundle bundle = new Bundle();
        if (hashMap != null) {
            try {
                for (String str : hashMap.keySet()) {
                    bundle.putString(str, hashMap.get(str));
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void registerSDKReceiver(Context context) {
        try {
            sdkRceiver = new Receiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.b.r.p");
            context.registerReceiver(sdkRceiver, intentFilter);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public static void setAgreePolicy(Context context, boolean z) {
        try {
            if (com.baidu.mshield.utility.a.g(context) == 1) {
                com.baidu.mshield.core.a.a(z);
            } else {
                Bundle bundle = new Bundle();
                bundle.putBoolean("_agree_policy", z);
                g.a(context, "setAgreePolicy", bundle);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public static void setAppStatus(Context context, boolean z) {
        try {
            if (com.baidu.mshield.utility.a.g(context) == 1) {
                if (isLoad) {
                    com.baidu.mshield.core.a.b(z);
                }
            } else {
                Bundle bundle = new Bundle();
                bundle.putBoolean("_app_status", z);
                g.a(context, "setAppStatus", bundle);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public static void ud(Context context, HashMap<String, String> hashMap) {
        try {
            if (com.baidu.mshield.utility.a.g(context) == 1) {
                if (isLoad) {
                    com.baidu.mshield.core.a.a(context, hashMap);
                }
            } else {
                g.a(context, "ud", obtainBundleFromProperties(hashMap));
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public static void unInitPlugin(Context context) {
        try {
            unregisterSDKReceiver(context);
            EngineImpl.getInstance(context).unload();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    private static void unregisterSDKReceiver(Context context) {
        try {
            Receiver receiver = sdkRceiver;
            if (receiver != null) {
                context.unregisterReceiver(receiver);
                sdkRceiver = null;
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public static String gzfi(Context context, String str, int i, HashMap<String, String> hashMap) {
        return gzfi(context, str, i, null, hashMap);
    }
}
