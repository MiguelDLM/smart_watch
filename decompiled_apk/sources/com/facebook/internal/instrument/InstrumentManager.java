package com.facebook.internal.instrument;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.InstrumentManager;
import com.facebook.internal.instrument.anrreport.ANRHandler;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import com.facebook.internal.instrument.threadcheck.ThreadCheckHandler;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class InstrumentManager {

    @OOXIXo
    public static final InstrumentManager INSTANCE = new InstrumentManager();

    private InstrumentManager() {
    }

    @x0XOIxOo
    public static final void start() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!FacebookSdk.getAutoLogAppEventsEnabled()) {
            return;
        }
        FeatureManager featureManager = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.CrashReport, new FeatureManager.Callback() { // from class: XX0.II0xO0
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z) {
                InstrumentManager.m222start$lambda0(z);
            }
        });
        FeatureManager.checkFeature(FeatureManager.Feature.ErrorReport, new FeatureManager.Callback() { // from class: XX0.I0Io
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z) {
                InstrumentManager.m223start$lambda1(z);
            }
        });
        FeatureManager.checkFeature(FeatureManager.Feature.AnrReport, new FeatureManager.Callback() { // from class: XX0.oxoX
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z) {
                InstrumentManager.m224start$lambda2(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: start$lambda-0, reason: not valid java name */
    public static final void m222start$lambda0(boolean z) {
        if (z) {
            CrashHandler.Companion.enable();
            FeatureManager featureManager = FeatureManager.INSTANCE;
            if (FeatureManager.isEnabled(FeatureManager.Feature.CrashShield)) {
                ExceptionAnalyzer exceptionAnalyzer = ExceptionAnalyzer.INSTANCE;
                ExceptionAnalyzer.enable();
                CrashShieldHandler crashShieldHandler = CrashShieldHandler.INSTANCE;
                CrashShieldHandler.enable();
            }
            if (FeatureManager.isEnabled(FeatureManager.Feature.ThreadCheck)) {
                ThreadCheckHandler threadCheckHandler = ThreadCheckHandler.INSTANCE;
                ThreadCheckHandler.enable();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: start$lambda-1, reason: not valid java name */
    public static final void m223start$lambda1(boolean z) {
        if (z) {
            ErrorReportHandler errorReportHandler = ErrorReportHandler.INSTANCE;
            ErrorReportHandler.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: start$lambda-2, reason: not valid java name */
    public static final void m224start$lambda2(boolean z) {
        if (z) {
            ANRHandler aNRHandler = ANRHandler.INSTANCE;
            ANRHandler.enable();
        }
    }
}
