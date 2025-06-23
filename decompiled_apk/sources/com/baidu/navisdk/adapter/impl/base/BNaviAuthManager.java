package com.baidu.navisdk.adapter.impl.base;

import android.content.Context;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.common.l0;
import java.util.Hashtable;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class BNaviAuthManager {
    private static final int AUTH_STATUS_SUCC = 0;
    private static final String LBS_SERVICE_NAVI_SDK = "lbs_navsdk_mini";
    private static final String SDK_KEY_AK_PERMISSION = "SDK_KEY_PERMISSION";
    private static final String SDK_KEY_VERIFY_SUCCESS = "SDK_KEY_VERIFY_SUCCESS";
    private static final String TAG = "BNaviAuthManager";
    private static BNaviAuthManager sInstance;
    private com.baidu.navisdk.ui.util.a authCdt;
    private LBSAuthManagerListener mAppAuthListener;
    private LBSAuthManager mAuthManager;
    private Context mContext;
    private LBSAuthManagerListener mTokenAuthListener;
    private boolean mIsAuthSuccess = false;
    private String mToken = "";
    private int mAkPermission = -1;
    private boolean mIsFirstAuth = true;
    private final LBSAuthManagerListener mAuthManagerListener = new LBSAuthManagerListener() { // from class: com.baidu.navisdk.adapter.impl.base.BNaviAuthManager.1
        @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
        public void onAuthResult(int i, String str) {
            boolean z;
            String authStatusDesc = BNaviAuthManager.this.getAuthStatusDesc(i);
            LogUtil.out(BNaviAuthManager.TAG, "onAuthResult: status: " + i + ", desc" + authStatusDesc + ", msg: " + str);
            BNaviAuthManager bNaviAuthManager = BNaviAuthManager.this;
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            bNaviAuthManager.mIsAuthSuccess = z;
            if (BNaviAuthManager.this.mIsAuthSuccess) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("token")) {
                        BNaviAuthManager.this.mToken = jSONObject.optString("token");
                    }
                    if (jSONObject.has("ak_permission")) {
                        BNaviAuthManager.this.mAkPermission = jSONObject.optInt("ak_permission");
                    }
                    if (BNaviAuthManager.this.mAkPermission != -1) {
                        BNSettingManager.putInt("ak_permission", BNaviAuthManager.this.mAkPermission);
                    } else {
                        BNaviAuthManager.this.mAkPermission = BNSettingManager.getInt("ak_permission", -1);
                    }
                } catch (Exception e) {
                    BNaviAuthManager.this.mToken = "";
                    BNaviAuthManager.this.mAkPermission = -1;
                    if (LogUtil.LOGGABLE) {
                        e.printStackTrace();
                    }
                }
            }
            BNaviAuthManager.this.saveAuthResult();
            int fixStatusCode = BNaviAuthManager.this.fixStatusCode(i);
            if (BNaviAuthManager.this.mAppAuthListener != null) {
                BNaviAuthManager.this.mAppAuthListener.onAuthResult(fixStatusCode, str);
            }
            if (BNaviAuthManager.this.mTokenAuthListener != null) {
                if (l0.c(BNaviAuthManager.this.mToken)) {
                    BNaviAuthManager.this.initCountDown();
                    return;
                }
                if (BNaviAuthManager.this.authCdt != null) {
                    BNaviAuthManager.this.authCdt.cancel();
                    BNaviAuthManager.this.authCdt = null;
                }
                BNaviAuthManager.this.mTokenAuthListener.onAuthResult(fixStatusCode, str);
            }
        }
    };

    private BNaviAuthManager(Context context) {
        this.mContext = context;
        this.mAuthManager = LBSAuthManager.getInstance(context);
        initAuthResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fixStatusCode(int i) {
        if (i != -11 && i != -10 && i != -1 && i != 1 && i != 601 && i != 602) {
            return i;
        }
        this.mIsAuthSuccess = true;
        saveAuthResult();
        int a2 = e0.a(this.mContext).a(SDK_KEY_AK_PERMISSION, -1);
        if (a2 != -1) {
            this.mAkPermission = a2;
        } else {
            this.mAkPermission = 12;
        }
        synchronized (this) {
            try {
                if (this.mIsFirstAuth) {
                    this.mIsFirstAuth = false;
                    authenticate();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAuthStatusDesc(int i) {
        if (i == 0) {
            return "通过校验";
        }
        if (i == 2) {
            return "参数错误";
        }
        if (i == 5) {
            return "ak不存在";
        }
        if (i != 210) {
            if (i == 101) {
                return "该服务已经被开发者禁用";
            }
            if (i == 102) {
                return "mcode签名值不正确";
            }
            switch (i) {
                case 231:
                    return "用户uid，ak不存在";
                case 232:
                    return "用户、ak被封禁";
                case 233:
                    break;
                default:
                    return (i < 202 || i > 205) ? (i < 301 || i > 355) ? "未知状态码" : "配额不存在" : "无请求权限";
            }
        }
        return "无请求权限";
    }

    public static BNaviAuthManager getInstance() {
        if (sInstance == null) {
            synchronized (BNaviAuthManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new BNaviAuthManager(com.baidu.navcore.a.d().b());
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    private void initAuthResult() {
        Context context = this.mContext;
        if (context != null) {
            this.mIsAuthSuccess = e0.a(context).a(SDK_KEY_VERIFY_SUCCESS, false);
            LogUtil.out(TAG, "initAuthResult: isAuthSuccess " + this.mIsAuthSuccess);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCountDown() {
        com.baidu.navisdk.ui.util.a aVar = this.authCdt;
        if (aVar != null) {
            aVar.cancel();
            this.authCdt = null;
        }
        com.baidu.navisdk.ui.util.a aVar2 = new com.baidu.navisdk.ui.util.a(60000L) { // from class: com.baidu.navisdk.adapter.impl.base.BNaviAuthManager.2
            @Override // com.baidu.navisdk.ui.util.a
            public void onFinish() {
                BNaviAuthManager.this.authenticate();
            }
        };
        this.authCdt = aVar2;
        aVar2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAuthResult() {
        Context context = this.mContext;
        if (context != null) {
            e0.a(context).b(SDK_KEY_VERIFY_SUCCESS, this.mIsAuthSuccess);
            e0.a(this.mContext).b(SDK_KEY_AK_PERMISSION, this.mAkPermission);
        }
    }

    public void authenticate(LBSAuthManagerListener lBSAuthManagerListener) {
        this.mAppAuthListener = lBSAuthManagerListener;
        authenticate();
    }

    public String getToken() {
        return this.mToken;
    }

    public boolean hasDynamicDataPermission() {
        int i = this.mAkPermission;
        if (i > 0 && (i & 32768) == 32768) {
            return true;
        }
        return false;
    }

    public boolean hasEtcPermission() {
        int i = this.mAkPermission;
        if (i > 0 && (i & 4096) == 4096) {
            return true;
        }
        return false;
    }

    public boolean hasHdNaviPermission() {
        int i = this.mAkPermission;
        if (i > 0 && (i & 262144) == 262144) {
            return true;
        }
        return false;
    }

    public boolean hasMapTrafficLightPermission() {
        int i = this.mAkPermission;
        if (i > 0 && (i & 1048576) == 1048576) {
            return true;
        }
        return false;
    }

    public boolean hasMotorPermission() {
        int i = this.mAkPermission;
        if (i > 0 && (i & 8) == 8) {
            return true;
        }
        return false;
    }

    public boolean hasNewEnergyPermission() {
        int i = this.mAkPermission;
        if (i > 0 && (i & 16384) == 16384) {
            return true;
        }
        return false;
    }

    public boolean hasRiskTruckPermission() {
        int i = this.mAkPermission;
        if (i > 0 && (i & 8192) == 8192) {
            return true;
        }
        return false;
    }

    public boolean hasTruckPermission() {
        int i = this.mAkPermission;
        if (i > 0 && (i & 4) == 4) {
            return true;
        }
        return false;
    }

    public boolean isAuthSuccess() {
        if (LogUtil.LOGGABLE) {
            LogUtil.out(TAG, "isAuthSuccess = " + this.mIsAuthSuccess);
        }
        return this.mIsAuthSuccess;
    }

    public void refreshToken(LBSAuthManagerListener lBSAuthManagerListener) {
        this.mTokenAuthListener = lBSAuthManagerListener;
        authenticate();
    }

    public void setAuthManagerListener(LBSAuthManagerListener lBSAuthManagerListener) {
        this.mAppAuthListener = lBSAuthManagerListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void authenticate() {
        if (this.mContext == null) {
            Context a2 = com.baidu.navisdk.framework.a.c().a();
            this.mContext = a2;
            this.mAuthManager = LBSAuthManager.getInstance(a2);
        }
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("zero_auth", "1");
        int authenticate = this.mAuthManager.authenticate(false, LBS_SERVICE_NAVI_SDK, hashtable, this.mAuthManagerListener);
        LogUtil.out(TAG, "authenticate: code " + authenticate);
        if (authenticate == 0 || authenticate == 601) {
            this.mIsAuthSuccess = true;
        } else if (authenticate != 602) {
            this.mIsAuthSuccess = false;
        }
    }
}
