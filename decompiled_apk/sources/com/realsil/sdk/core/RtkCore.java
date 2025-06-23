package com.realsil.sdk.core;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import com.jieli.bluetooth_connect.BuildConfig;
import com.realsil.sdk.core.a.a;
import com.realsil.sdk.core.bluetooth.BluetoothProfileManager;
import com.realsil.sdk.core.bluetooth.GlobalGatt;
import com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClientManagerImpl;
import com.realsil.sdk.core.logger.ZLogger;
import java.util.Arrays;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes11.dex */
public final class RtkCore {
    public static boolean DEBUG = false;
    public static boolean VDBG = false;

    /* renamed from: a, reason: collision with root package name */
    public static Context f19477a;

    public static String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static synchronized void initialize(Context context, @NonNull RtkConfigure rtkConfigure) {
        synchronized (RtkCore.class) {
            try {
                if (f19477a == null) {
                    f19477a = context.getApplicationContext();
                }
                ZLogger.v(true, String.format("%s:%s:%s", com.realsil.sdk.bbpro.core.BuildConfig.GROUP_ID, "rtk-core", BuildConfig.VERSION_NAME));
                DEBUG = rtkConfigure.isDebugEnabled();
                VDBG = rtkConfigure.isDevModeEnabled();
                ZLogger.initialize(rtkConfigure.getLogTag(), rtkConfigure.isPrintLog(), rtkConfigure.getGlobalLogLevel());
                ZLogger.d(rtkConfigure.toString());
                if (GlobalGatt.getInstance() == null) {
                    GlobalGatt.initial(f19477a);
                }
                if (BluetoothGattClientManagerImpl.getInstance() == null) {
                    BluetoothGattClientManagerImpl.initial(f19477a);
                }
                BluetoothProfileManager.initial(f19477a);
                StringBuilder sb = new StringBuilder();
                sb.append("DeviceInfo{");
                StringBuilder a2 = a.a("SDK_INT: ");
                a2.append(Build.VERSION.SDK_INT);
                sb.append(a2.toString());
                sb.append("\nDevice name: " + Build.DEVICE);
                sb.append("\nAndroid Version: " + Build.VERSION.RELEASE);
                sb.append("\nManufacture: " + Build.MANUFACTURER);
                sb.append("\nModel: " + Build.MODEL);
                StringBuilder a3 = a.a("\nsupportedABIS: ");
                a3.append(Arrays.toString(Build.SUPPORTED_ABIS));
                sb.append(a3.toString());
                sb.append(ooOOo0oXI.f33074oOoXoXO);
                ZLogger.d(sb.toString());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean isBluetoothSupported() {
        return BluetoothGattClientManagerImpl.getInstance().isBluetoothSupported();
    }
}
