package com.facebook;

import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.util.Random;

/* loaded from: classes8.dex */
public class FacebookException extends RuntimeException {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final long serialVersionUID = 1;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public FacebookException() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0, reason: not valid java name */
    public static final void m108_init_$lambda0(String str, boolean z) {
        if (z) {
            try {
                ErrorReportHandler errorReportHandler = ErrorReportHandler.INSTANCE;
                ErrorReportHandler.save(str);
            } catch (Exception unused) {
            }
        }
    }

    @Override // java.lang.Throwable
    @OXOo.OOXIXo
    public String toString() {
        String message = getMessage();
        if (message == null) {
            return "";
        }
        return message;
    }

    public FacebookException(@OXOo.oOoXoXO final String str) {
        super(str);
        Random random = new Random();
        if (str != null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (!FacebookSdk.isInitialized() || random.nextInt(100) <= 50) {
                return;
            }
            FeatureManager featureManager = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.ErrorReport, new FeatureManager.Callback() { // from class: com.facebook.XO
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    FacebookException.m108_init_$lambda0(str, z);
                }
            });
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public FacebookException(@OXOo.oOoXoXO java.lang.String r2, @OXOo.OOXIXo java.lang.Object... r3) {
        /*
            r1 = this;
            java.lang.String r0 = "args"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            if (r2 != 0) goto L9
            r2 = 0
            goto L1c
        L9:
            int r0 = r3.length
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r0)
            int r0 = r3.length
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r0)
            java.lang.String r2 = java.lang.String.format(r2, r3)
            java.lang.String r3 = "java.lang.String.format(this, *args)"
            kotlin.jvm.internal.IIX0o.oO(r2, r3)
        L1c:
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookException.<init>(java.lang.String, java.lang.Object[]):void");
    }

    public FacebookException(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO Throwable th) {
        super(str, th);
    }

    public FacebookException(@OXOo.oOoXoXO Throwable th) {
        super(th);
    }
}
