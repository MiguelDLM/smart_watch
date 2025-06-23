package com.facebook.devicerequests.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import androidx.core.view.ViewCompat;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.OxI;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class DeviceRequestsHelper {

    @OOXIXo
    public static final String DEVICE_INFO_DEVICE = "device";

    @OOXIXo
    public static final String DEVICE_INFO_MODEL = "model";

    @OOXIXo
    public static final String DEVICE_INFO_PARAM = "device_info";

    @OOXIXo
    public static final String DEVICE_TARGET_USER_ID = "target_user_id";

    @OOXIXo
    public static final String SDK_FLAVOR = "android";

    @OOXIXo
    public static final String SDK_HEADER = "fbsdk";

    @OOXIXo
    public static final String SERVICE_TYPE = "_fb._tcp.";

    @OOXIXo
    public static final DeviceRequestsHelper INSTANCE = new DeviceRequestsHelper();

    @oOoXoXO
    private static final String TAG = DeviceRequestsHelper.class.getCanonicalName();

    @OOXIXo
    private static final HashMap<String, NsdManager.RegistrationListener> deviceRequestsListeners = new HashMap<>();

    private DeviceRequestsHelper() {
    }

    @x0XOIxOo
    public static final void cleanUpAdvertisementService(@oOoXoXO String str) {
        if (CrashShieldHandler.isObjectCrashing(DeviceRequestsHelper.class)) {
            return;
        }
        try {
            INSTANCE.cleanUpAdvertisementServiceImpl(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, DeviceRequestsHelper.class);
        }
    }

    @TargetApi(16)
    private final void cleanUpAdvertisementServiceImpl(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            NsdManager.RegistrationListener registrationListener = deviceRequestsListeners.get(str);
            if (registrationListener != null) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Object systemService = FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
                if (systemService != null) {
                    try {
                        ((NsdManager) systemService).unregisterService(registrationListener);
                    } catch (IllegalArgumentException e) {
                        Utility utility = Utility.INSTANCE;
                        Utility.logd(TAG, e);
                    }
                    deviceRequestsListeners.remove(str);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @x0XOIxOo
    @oOoXoXO
    public static final Bitmap generateQRCode(@oOoXoXO String str) {
        int height;
        int width;
        int[] iArr;
        Bitmap createBitmap;
        int i;
        Bitmap bitmap = null;
        if (CrashShieldHandler.isObjectCrashing(DeviceRequestsHelper.class)) {
            return null;
        }
        try {
            EnumMap enumMap = new EnumMap(EncodeHintType.class);
            enumMap.put((EnumMap) EncodeHintType.MARGIN, (EncodeHintType) 2);
            try {
                BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 200, 200, enumMap);
                height = encode.getHeight();
                width = encode.getWidth();
                iArr = new int[height * width];
                if (height > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        int i4 = i2 * width;
                        if (width > 0) {
                            int i5 = 0;
                            while (true) {
                                int i6 = i5 + 1;
                                int i7 = i4 + i5;
                                if (encode.get(i5, i2)) {
                                    i = ViewCompat.MEASURED_STATE_MASK;
                                } else {
                                    i = -1;
                                }
                                iArr[i7] = i;
                                if (i6 >= width) {
                                    break;
                                }
                                i5 = i6;
                            }
                        }
                        if (i3 >= height) {
                            break;
                        }
                        i2 = i3;
                    }
                }
                createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            } catch (WriterException unused) {
            }
            try {
                createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                return createBitmap;
            } catch (WriterException unused2) {
                bitmap = createBitmap;
                return bitmap;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, DeviceRequestsHelper.class);
            return null;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final String getDeviceInfo(@oOoXoXO Map<String, String> map) {
        if (CrashShieldHandler.isObjectCrashing(DeviceRequestsHelper.class)) {
            return null;
        }
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, DeviceRequestsHelper.class);
                return null;
            }
        }
        String DEVICE = Build.DEVICE;
        IIX0o.oO(DEVICE, "DEVICE");
        map.put(DEVICE_INFO_DEVICE, DEVICE);
        String MODEL = Build.MODEL;
        IIX0o.oO(MODEL, "MODEL");
        map.put("model", MODEL);
        String jSONObject = new JSONObject(map).toString();
        IIX0o.oO(jSONObject, "JSONObject(deviceInfo as Map<*, *>).toString()");
        return jSONObject;
    }

    @x0XOIxOo
    public static final boolean isAvailable() {
        if (CrashShieldHandler.isObjectCrashing(DeviceRequestsHelper.class)) {
            return false;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                return false;
            }
            if (!appSettingsWithoutQuery.getSmartLoginOptions().contains(SmartLoginOption.Enabled)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, DeviceRequestsHelper.class);
            return false;
        }
    }

    @x0XOIxOo
    public static final boolean startAdvertisementService(@oOoXoXO String str) {
        if (CrashShieldHandler.isObjectCrashing(DeviceRequestsHelper.class)) {
            return false;
        }
        try {
            if (!isAvailable()) {
                return false;
            }
            return INSTANCE.startAdvertisementServiceImpl(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, DeviceRequestsHelper.class);
            return false;
        }
    }

    @TargetApi(16)
    private final boolean startAdvertisementServiceImpl(final String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            HashMap<String, NsdManager.RegistrationListener> hashMap = deviceRequestsListeners;
            if (hashMap.containsKey(str)) {
                return true;
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            final String str2 = "fbsdk_" + IIX0o.XIxXXX0x0("android-", OxI.oXO0oOx0(FacebookSdk.getSdkVersion(), '.', '|', false, 4, null)) + '_' + ((Object) str);
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setServiceType(SERVICE_TYPE);
            nsdServiceInfo.setServiceName(str2);
            nsdServiceInfo.setPort(80);
            Object systemService = FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
            if (systemService != null) {
                NsdManager.RegistrationListener registrationListener = new NsdManager.RegistrationListener() { // from class: com.facebook.devicerequests.internal.DeviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1
                    @Override // android.net.nsd.NsdManager.RegistrationListener
                    public void onRegistrationFailed(@OOXIXo NsdServiceInfo serviceInfo, int i) {
                        IIX0o.x0xO0oo(serviceInfo, "serviceInfo");
                        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                        DeviceRequestsHelper.cleanUpAdvertisementService(str);
                    }

                    @Override // android.net.nsd.NsdManager.RegistrationListener
                    public void onServiceRegistered(@OOXIXo NsdServiceInfo NsdServiceInfo) {
                        IIX0o.x0xO0oo(NsdServiceInfo, "NsdServiceInfo");
                        if (!IIX0o.Oxx0IOOO(str2, NsdServiceInfo.getServiceName())) {
                            DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                            DeviceRequestsHelper.cleanUpAdvertisementService(str);
                        }
                    }

                    @Override // android.net.nsd.NsdManager.RegistrationListener
                    public void onServiceUnregistered(@OOXIXo NsdServiceInfo serviceInfo) {
                        IIX0o.x0xO0oo(serviceInfo, "serviceInfo");
                    }

                    @Override // android.net.nsd.NsdManager.RegistrationListener
                    public void onUnregistrationFailed(@OOXIXo NsdServiceInfo serviceInfo, int i) {
                        IIX0o.x0xO0oo(serviceInfo, "serviceInfo");
                    }
                };
                hashMap.put(str, registrationListener);
                ((NsdManager) systemService).registerService(nsdServiceInfo, 1, registrationListener);
                return true;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final String getDeviceInfo() {
        if (CrashShieldHandler.isObjectCrashing(DeviceRequestsHelper.class)) {
            return null;
        }
        try {
            return getDeviceInfo(null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, DeviceRequestsHelper.class);
            return null;
        }
    }
}
