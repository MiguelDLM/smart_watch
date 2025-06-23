package com.kwad.sdk;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.utils.az;

/* loaded from: classes11.dex */
public final class m {
    private static int amk;

    public static void a(final com.kwai.adclient.kscommerciallogger.model.d dVar, final String str) {
        com.kwad.sdk.utils.g.execute(new az() { // from class: com.kwad.sdk.m.6
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.ERROR_LOG, com.kwai.adclient.kscommerciallogger.model.d.this, new SDKInitMsg().setInitCount(m.amk).setErrorReason(str).setInitStatus(2));
            }
        });
    }

    public static void ac(long j) {
        final long j2;
        if (j > 0) {
            j2 = System.currentTimeMillis() - j;
        } else {
            j2 = -1;
        }
        amk++;
        com.kwad.sdk.utils.g.execute(new az() { // from class: com.kwad.sdk.m.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aUQ, new SDKInitMsg().setLaunchIntervalTime(j2).setInitCount(m.amk).setInitStatus(0));
            }
        });
    }

    public static void ad(final long j) {
        if (j > 10000) {
            j = -1;
        }
        com.kwad.sdk.utils.g.execute(new az() { // from class: com.kwad.sdk.m.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aUQ, new SDKInitMsg().setTotalDurationTime(j).setInitCount(m.amk).setInitStatus(1));
            }
        });
    }

    public static void ae(final long j) {
        if (j > 10000) {
            j = -1;
        }
        com.kwad.sdk.utils.g.execute(new az() { // from class: com.kwad.sdk.m.3
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aUQ, new SDKInitMsg().setTotalDurationTime(j).setInitCount(m.amk).setInitStatus(3));
            }
        });
    }

    public static void af(final long j) {
        if (j > 10000) {
            j = -1;
        }
        com.kwad.sdk.utils.g.execute(new az() { // from class: com.kwad.sdk.m.4
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aUQ, new SDKInitMsg().setTotalDurationTime(j).setInitCount(m.amk).setInitStatus(4));
            }
        });
    }

    public static void ag(final long j) {
        if (j > 10000) {
            j = -1;
        }
        com.kwad.sdk.utils.g.execute(new az() { // from class: com.kwad.sdk.m.5
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aUQ, new SDKInitMsg().setTotalDurationTime(j).setInitCount(m.amk).setInitStatus(5));
            }
        });
    }
}
