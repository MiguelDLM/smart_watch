package com.baidu.ar;

import android.app.Activity;
import android.util.Log;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.mc;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.Camera;
import com.google.ar.core.CameraIntrinsics;
import com.google.ar.core.Config;
import com.google.ar.core.Session;
import com.google.ar.core.TrackingState;
import com.google.ar.core.exceptions.CameraNotAvailableException;

/* loaded from: classes7.dex */
public class md extends mc {
    private Activity Fm;
    private Session session;

    /* renamed from: com.baidu.ar.md$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Fn;

        static {
            int[] iArr = new int[ArCoreApk.InstallStatus.values().length];
            Fn = iArr;
            try {
                iArr[ArCoreApk.InstallStatus.INSTALL_REQUESTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Fn[ArCoreApk.InstallStatus.INSTALLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public md(Activity activity) {
        this.Fm = activity;
    }

    private void ai(boolean z) {
        Config config = this.session.getConfig();
        config.setFocusMode(z ? Config.FocusMode.AUTO : Config.FocusMode.FIXED);
        this.session.configure(config);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0031 A[Catch: Exception -> 0x0052, TryCatch #0 {Exception -> 0x0052, blocks: (B:7:0x002c, B:9:0x0031, B:11:0x0045), top: B:6:0x002c }] */
    @Override // com.baidu.ar.mc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean ah(boolean r6) {
        /*
            r5 = this;
            com.google.ar.core.ArCoreApk r0 = com.google.ar.core.ArCoreApk.getInstance()
            android.app.Activity r1 = r5.Fm
            com.google.ar.core.ArCoreApk$Availability r0 = r0.checkAvailability(r1)
            com.google.ar.core.ArCoreApk$Availability r1 = com.google.ar.core.ArCoreApk.Availability.SUPPORTED_APK_TOO_OLD
            java.lang.String r2 = "ARCoreAbility"
            if (r0 != r1) goto L16
            java.lang.String r0 = "SUPPORTED_APK_TOO_OLD"
        L12:
            android.util.Log.e(r2, r0)
            goto L2b
        L16:
            com.google.ar.core.ArCoreApk$Availability r1 = com.google.ar.core.ArCoreApk.Availability.SUPPORTED_INSTALLED
            if (r0 != r1) goto L1d
            java.lang.String r0 = "SUPPORTED_INSTALLED"
            goto L12
        L1d:
            com.google.ar.core.ArCoreApk$Availability r1 = com.google.ar.core.ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED
            if (r0 != r1) goto L24
            java.lang.String r0 = "SUPPORTED_NOT_INSTALLED"
            goto L12
        L24:
            com.google.ar.core.ArCoreApk$Availability r1 = com.google.ar.core.ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE
            if (r0 != r1) goto L2b
            java.lang.String r0 = "UNSUPPORTED_DEVICE_NOT_CAPABLE"
            goto L12
        L2b:
            r0 = 0
            com.google.ar.core.Session r1 = r5.session     // Catch: java.lang.Exception -> L52
            r2 = 1
            if (r1 != 0) goto L55
            int[] r1 = com.baidu.ar.md.AnonymousClass1.Fn     // Catch: java.lang.Exception -> L52
            com.google.ar.core.ArCoreApk r3 = com.google.ar.core.ArCoreApk.getInstance()     // Catch: java.lang.Exception -> L52
            android.app.Activity r4 = r5.Fm     // Catch: java.lang.Exception -> L52
            com.google.ar.core.ArCoreApk$InstallStatus r3 = r3.requestInstall(r4, r0)     // Catch: java.lang.Exception -> L52
            int r3 = r3.ordinal()     // Catch: java.lang.Exception -> L52
            r1 = r1[r3]     // Catch: java.lang.Exception -> L52
            if (r1 == r2) goto L54
            com.google.ar.core.Session r1 = new com.google.ar.core.Session     // Catch: java.lang.Exception -> L52
            android.app.Activity r3 = r5.Fm     // Catch: java.lang.Exception -> L52
            r1.<init>(r3)     // Catch: java.lang.Exception -> L52
            r5.session = r1     // Catch: java.lang.Exception -> L52
            r5.ai(r6)     // Catch: java.lang.Exception -> L52
            goto L55
        L52:
            r6 = move-exception
            goto L56
        L54:
            return r0
        L55:
            return r2
        L56:
            r6.printStackTrace()
            com.google.ar.core.Session r6 = r5.session
            if (r6 == 0) goto L63
            r6.close()
            r6 = 0
            r5.session = r6
        L63:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.md.ah(boolean):boolean");
    }

    @Override // com.baidu.ar.mt
    public void b(Texture texture) {
        Session session = this.session;
        if (session == null || texture == null) {
            return;
        }
        session.setCameraTextureName(texture.getId());
    }

    @Override // com.baidu.ar.mc
    public boolean ij() {
        Session session = this.session;
        if (session == null) {
            return true;
        }
        try {
            session.resume();
            return true;
        } catch (CameraNotAvailableException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.ar.mc
    public void ik() {
        super.ik();
        Session session = this.session;
        if (session == null) {
            return;
        }
        try {
            Camera camera = session.update().getCamera();
            CameraIntrinsics imageIntrinsics = camera.getImageIntrinsics();
            float[] principalPoint = imageIntrinsics.getPrincipalPoint();
            float[] focalLength = imageIntrinsics.getFocalLength();
            float[] fArr = {focalLength[0], 0.0f, principalPoint[0], 0.0f, focalLength[1], principalPoint[1], 0.0f, 0.0f, 1.0f};
            float[] fArr2 = new float[16];
            camera.getPose().toMatrix(fArr2, 0);
            float atan = (float) (((Math.atan(principalPoint[0] / focalLength[0]) * 2.0d) / 3.141592653589793d) * 180.0d);
            int i = camera.getTrackingState() == TrackingState.TRACKING ? 0 : 1;
            float[] fArr3 = {fArr2[0], fArr2[4], fArr2[8], fArr2[1], fArr2[5], fArr2[9], fArr2[2], fArr2[6], fArr2[10], fArr2[12], fArr2[13], fArr2[14]};
            mc.a aVar = this.Fl;
            if (aVar != null) {
                aVar.a(i, fArr, atan, fArr3, fArr2);
            }
        } catch (Exception e) {
            Log.e("ARCoreAbility", "onFrameUpdate: arcore update error.");
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.mc
    public boolean pause() {
        Session session = this.session;
        if (session != null) {
            session.pause();
        }
        return super.pause();
    }

    @Override // com.baidu.ar.mc
    public void release() {
        this.Fl = null;
        Session session = this.session;
        if (session != null) {
            session.close();
            this.session = null;
        }
    }
}
