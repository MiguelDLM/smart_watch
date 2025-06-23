package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.finsky.externalreferrer.IGetInstallReferrerService;
import com.huawei.openalliance.ad.constant.bb;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: classes.dex */
public class oIX0oI extends InstallReferrerClient {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f5175II0XooXoX = "com.google.android.finsky.externalreferrer.GetInstallReferrerService";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f5176Oxx0IOOO = "com.android.vending";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f5177X0o0xo = "InstallReferrerClient";

    /* renamed from: XO, reason: collision with root package name */
    public static final int f5178XO = 80837300;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f5179xxIXOIIO = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE";

    /* renamed from: I0Io, reason: collision with root package name */
    public IGetInstallReferrerService f5180I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Context f5181II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f5182oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public ServiceConnection f5183oxoX;

    /* loaded from: classes.dex */
    public final class I0Io implements ServiceConnection {

        /* renamed from: XO, reason: collision with root package name */
        public final InstallReferrerStateListener f5185XO;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            xxX.oIX0oI.oIX0oI(oIX0oI.f5177X0o0xo, "Install Referrer service connected.");
            oIX0oI.this.f5180I0Io = IGetInstallReferrerService.Stub.asInterface(iBinder);
            oIX0oI.this.f5182oIX0oI = 2;
            this.f5185XO.onInstallReferrerSetupFinished(0);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            xxX.oIX0oI.II0xO0(oIX0oI.f5177X0o0xo, "Install Referrer service disconnected.");
            oIX0oI.this.f5180I0Io = null;
            oIX0oI.this.f5182oIX0oI = 0;
            this.f5185XO.onInstallReferrerServiceDisconnected();
        }

        public I0Io(@NonNull InstallReferrerStateListener installReferrerStateListener) {
            if (installReferrerStateListener != null) {
                this.f5185XO = installReferrerStateListener;
                return;
            }
            throw new RuntimeException("Please specify a listener to know when setup is done.");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface II0xO0 {

        /* renamed from: OOXIXo, reason: collision with root package name */
        public static final int f5186OOXIXo = 0;

        /* renamed from: oOoXoXO, reason: collision with root package name */
        public static final int f5187oOoXoXO = 1;

        /* renamed from: ooOOo0oXI, reason: collision with root package name */
        public static final int f5188ooOOo0oXI = 2;

        /* renamed from: x0XOIxOo, reason: collision with root package name */
        public static final int f5189x0XOIxOo = 3;
    }

    public oIX0oI(@NonNull Context context) {
        this.f5181II0xO0 = context.getApplicationContext();
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public boolean I0Io() {
        if (this.f5182oIX0oI == 2 && this.f5180I0Io != null && this.f5183oxoX != null) {
            return true;
        }
        return false;
    }

    public final boolean II0XooXoX() {
        try {
            if (this.f5181II0xO0.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode < 80837300) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public ReferrerDetails II0xO0() throws RemoteException {
        if (I0Io()) {
            Bundle bundle = new Bundle();
            bundle.putString(bb.G, this.f5181II0xO0.getPackageName());
            try {
                return new ReferrerDetails(this.f5180I0Io.getInstallReferrer(bundle));
            } catch (RemoteException e) {
                xxX.oIX0oI.II0xO0(f5177X0o0xo, "RemoteException getting install referrer information");
                this.f5182oIX0oI = 0;
                throw e;
            }
        }
        throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void X0o0xo(@NonNull InstallReferrerStateListener installReferrerStateListener) {
        ServiceInfo serviceInfo;
        if (I0Io()) {
            xxX.oIX0oI.oIX0oI(f5177X0o0xo, "Service connection is valid. No need to re-initialize.");
            installReferrerStateListener.onInstallReferrerSetupFinished(0);
            return;
        }
        int i = this.f5182oIX0oI;
        if (i == 1) {
            xxX.oIX0oI.II0xO0(f5177X0o0xo, "Client is already in the process of connecting to the service.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
            return;
        }
        if (i == 3) {
            xxX.oIX0oI.II0xO0(f5177X0o0xo, "Client was already closed and can't be reused. Please create another instance.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
            return;
        }
        xxX.oIX0oI.oIX0oI(f5177X0o0xo, "Starting install referrer service setup.");
        this.f5183oxoX = new I0Io(installReferrerStateListener);
        Intent intent = new Intent(f5179xxIXOIIO);
        intent.setComponent(new ComponentName("com.android.vending", f5175II0XooXoX));
        List<ResolveInfo> queryIntentServices = this.f5181II0xO0.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty() && (serviceInfo = queryIntentServices.get(0).serviceInfo) != null) {
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if ("com.android.vending".equals(str) && str2 != null && II0XooXoX()) {
                if (this.f5181II0xO0.bindService(new Intent(intent), this.f5183oxoX, 1)) {
                    xxX.oIX0oI.oIX0oI(f5177X0o0xo, "Service was bonded successfully.");
                    return;
                }
                xxX.oIX0oI.II0xO0(f5177X0o0xo, "Connection to service is blocked.");
                this.f5182oIX0oI = 0;
                installReferrerStateListener.onInstallReferrerSetupFinished(1);
                return;
            }
            xxX.oIX0oI.II0xO0(f5177X0o0xo, "Play Store missing or incompatible. Version 8.3.73 or later required.");
            this.f5182oIX0oI = 0;
            installReferrerStateListener.onInstallReferrerSetupFinished(2);
            return;
        }
        this.f5182oIX0oI = 0;
        xxX.oIX0oI.oIX0oI(f5177X0o0xo, "Install Referrer service unavailable on device.");
        installReferrerStateListener.onInstallReferrerSetupFinished(2);
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void oIX0oI() {
        this.f5182oIX0oI = 3;
        if (this.f5183oxoX != null) {
            xxX.oIX0oI.oIX0oI(f5177X0o0xo, "Unbinding from service.");
            this.f5181II0xO0.unbindService(this.f5183oxoX);
            this.f5183oxoX = null;
        }
        this.f5180I0Io = null;
    }
}
