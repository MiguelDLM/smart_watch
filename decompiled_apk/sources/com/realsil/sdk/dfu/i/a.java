package com.realsil.sdk.dfu.i;

import android.content.Context;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.internal.base.BaseDfuTask;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.m.f;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.n.c;
import com.realsil.sdk.dfu.o.d;
import com.realsil.sdk.dfu.o.e;
import com.realsil.sdk.dfu.params.QcConfig;
import com.realsil.sdk.dfu.r.g;
import com.realsil.sdk.dfu.r.h;
import com.realsil.sdk.dfu.r.i;
import com.realsil.sdk.dfu.v.l;
import com.realsil.sdk.dfu.v.n;
import com.realsil.sdk.dfu.v.o;
import com.realsil.sdk.dfu.v.p;
import com.realsil.sdk.dfu.v.q;

/* loaded from: classes11.dex */
public final class a {
    public static BaseDfuTask a(Context context, DfuConfig dfuConfig, QcConfig qcConfig, DfuThreadCallback dfuThreadCallback) {
        if (dfuConfig.getProtocolType() == 16) {
            if (dfuConfig.getOtaWorkMode() == 16) {
                return new h(context, dfuConfig, dfuThreadCallback);
            }
            if (dfuConfig.getOtaWorkMode() == 23) {
                return new i(context, dfuConfig, dfuThreadCallback);
            }
            if (dfuConfig.getOtaWorkMode() == 22) {
                return new i(context, dfuConfig, dfuThreadCallback);
            }
            return new g(context, dfuConfig, dfuThreadCallback);
        }
        if (dfuConfig.getProtocolType() == 20) {
            if (dfuConfig.getOtaWorkMode() == 16) {
                return new e(context, dfuConfig, dfuThreadCallback);
            }
            return new d(context, dfuConfig, dfuThreadCallback);
        }
        if (dfuConfig.getProtocolType() == 21) {
            if (dfuConfig.getOtaWorkMode() == 16) {
                return new com.realsil.sdk.dfu.p.e(context, dfuConfig, dfuThreadCallback);
            }
            return new com.realsil.sdk.dfu.p.d(context, dfuConfig, dfuThreadCallback);
        }
        if (dfuConfig.getProtocolType() == 17) {
            if (dfuConfig.getOtaWorkMode() == 19) {
                return new o(context, dfuConfig, dfuThreadCallback);
            }
            if (dfuConfig.getOtaWorkMode() == 20) {
                return new n(context, dfuConfig, qcConfig, dfuThreadCallback);
            }
            if (dfuConfig.getOtaWorkMode() == 21) {
                return new p(context, dfuConfig, qcConfig, dfuThreadCallback);
            }
            if (dfuConfig.getOtaWorkMode() == 23) {
                return new q(context, dfuConfig, qcConfig, dfuThreadCallback);
            }
            return new l(context, dfuConfig, qcConfig, dfuThreadCallback);
        }
        if (dfuConfig.getProtocolType() == 18) {
            if (dfuConfig.getOtaWorkMode() == 16) {
                return new f(context, dfuConfig, dfuThreadCallback);
            }
            return new com.realsil.sdk.dfu.m.e(context, dfuConfig, dfuThreadCallback);
        }
        if (dfuConfig.getProtocolType() == 19) {
            if (dfuConfig.getOtaWorkMode() == 0) {
                return new c(context, dfuConfig, dfuThreadCallback);
            }
            if (dfuConfig.getOtaWorkMode() == 17) {
                return new com.realsil.sdk.dfu.n.e(context, dfuConfig, dfuThreadCallback);
            }
            if (dfuConfig.getOtaWorkMode() == 16) {
                return new com.realsil.sdk.dfu.n.d(context, dfuConfig, dfuThreadCallback);
            }
            if (dfuConfig.getOtaWorkMode() == 18) {
                return new com.realsil.sdk.dfu.n.f(context, dfuConfig, dfuThreadCallback);
            }
            return new c(context, dfuConfig, dfuThreadCallback);
        }
        if (dfuConfig.getChannelType() == 0) {
            if (dfuConfig.getOtaWorkMode() == 0) {
                return new com.realsil.sdk.dfu.q.c(context, dfuConfig, dfuThreadCallback);
            }
            if (dfuConfig.getOtaWorkMode() == 17) {
                return new com.realsil.sdk.dfu.q.e(context, dfuConfig, dfuThreadCallback);
            }
            if (dfuConfig.getOtaWorkMode() == 16) {
                return new com.realsil.sdk.dfu.q.d(context, dfuConfig, dfuThreadCallback);
            }
            if (dfuConfig.getOtaWorkMode() == 18) {
                return new com.realsil.sdk.dfu.q.f(context, dfuConfig, dfuThreadCallback);
            }
            return new com.realsil.sdk.dfu.q.c(context, dfuConfig, dfuThreadCallback);
        }
        if (dfuConfig.getChannelType() == 1) {
            return new com.realsil.sdk.dfu.u.c(context, dfuConfig, dfuThreadCallback);
        }
        if (dfuConfig.getChannelType() == 2) {
            return new com.realsil.sdk.dfu.w.d(context, dfuConfig, dfuThreadCallback);
        }
        ZLogger.d("unknown channel:" + dfuConfig.getChannelType());
        return null;
    }
}
