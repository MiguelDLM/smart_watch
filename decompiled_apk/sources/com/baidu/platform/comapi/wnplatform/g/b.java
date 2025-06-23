package com.baidu.platform.comapi.wnplatform.g;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import com.baidu.R;
import com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener;
import com.baidu.mapapi.bikenavi.model.IBRouteIconInfo;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.model.IWRouteIconInfo;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.platform.comapi.wnplatform.f;
import com.baidu.platform.comapi.wnplatform.i.c;
import com.baidu.platform.comapi.wnplatform.i.e;
import com.baidu.platform.comapi.wnplatform.p.g;
import com.baidu.platform.comjni.jninative.vibrate.IVibrateListener;
import com.baidu.platform.comjni.jninative.vibrate.VibrateHelper;

/* loaded from: classes8.dex */
public class b extends com.baidu.platform.comapi.walknavi.a implements com.baidu.platform.comapi.wnplatform.c.a, com.baidu.platform.comapi.wnplatform.i.a, com.baidu.platform.comapi.wnplatform.i.b, IVibrateListener {

    /* renamed from: a, reason: collision with root package name */
    private IWRouteGuidanceListener f9914a = null;
    private IBRouteGuidanceListener b = null;
    private Activity c;

    public b(Activity activity) {
        this.c = activity;
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(byte[] bArr) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void b(Bundle bundle) {
        String a2;
        int b;
        String c;
        int i;
        if (this.c == null) {
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide mIBRouteGuidanceListener:" + this.b);
        int i2 = bundle.getInt("simpleUpdateType");
        com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide updateType:" + i2 + "  data:" + bundle);
        if (i2 == e.a.f9918a || i2 == e.a.d) {
            return;
        }
        if (bundle.containsKey("maneuverKind") && (i = bundle.getInt("maneuverKind")) < RouteGuideKind.values().length) {
            IBRouteGuidanceListener iBRouteGuidanceListener = this.b;
            if (iBRouteGuidanceListener != null) {
                iBRouteGuidanceListener.onRouteGuideKind(RouteGuideKind.values()[i]);
            } else {
                IWRouteGuidanceListener iWRouteGuidanceListener = this.f9914a;
                if (iWRouteGuidanceListener != null) {
                    iWRouteGuidanceListener.onRouteGuideKind(RouteGuideKind.values()[i]);
                }
            }
        }
        com.baidu.platform.comapi.walknavi.h.b.a.a(bundle, 1, bundle.getInt("nRemainDist"), bundle.getInt("nStartDist"));
        if (bundle.containsKey("maneuverKind")) {
            int i3 = bundle.getInt("maneuverKind");
            if (f.a().h()) {
                a2 = c.b(RouteGuideKind.values()[i3]);
            } else {
                a2 = f.a().g() ? c.a(RouteGuideKind.values()[i3]) : "";
            }
            if (f.a().h()) {
                b = com.baidu.platform.comapi.bikenavi.c.a.a(a2);
            } else {
                b = f.a().g() ? com.baidu.platform.comapi.walknavi.h.b.c.b(a2) : 0;
            }
            if (f.a().h()) {
                c = com.baidu.platform.comapi.bikenavi.c.a.b(a2);
            } else {
                c = f.a().g() ? com.baidu.platform.comapi.walknavi.h.b.c.c(a2) : null;
            }
            if (com.baidu.platform.comapi.bikenavi.a.a.f9539a) {
                IBRouteGuidanceListener iBRouteGuidanceListener2 = this.b;
                if (iBRouteGuidanceListener2 != null) {
                    iBRouteGuidanceListener2.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, b));
                    this.b.onRouteGuideIconInfoUpdate(new IBRouteIconInfo(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, b), c));
                } else {
                    IWRouteGuidanceListener iWRouteGuidanceListener2 = this.f9914a;
                    if (iWRouteGuidanceListener2 != null) {
                        iWRouteGuidanceListener2.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, b));
                        this.f9914a.onRouteGuideIconInfoUpdate(new IWRouteIconInfo(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, b), c));
                    }
                }
            } else {
                IBRouteGuidanceListener iBRouteGuidanceListener3 = this.b;
                if (iBRouteGuidanceListener3 != null) {
                    iBRouteGuidanceListener3.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, b));
                    this.b.onRouteGuideIconInfoUpdate(new IBRouteIconInfo(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, b), c));
                } else {
                    IWRouteGuidanceListener iWRouteGuidanceListener3 = this.f9914a;
                    if (iWRouteGuidanceListener3 != null) {
                        iWRouteGuidanceListener3.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, b));
                        this.f9914a.onRouteGuideIconInfoUpdate(new IWRouteIconInfo(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, b), c));
                    }
                }
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide getResources ID:" + b);
        }
        if (bundle.containsKey("nRemainDist")) {
            String string = bundle.getString("usGuideText");
            int[] intArray = bundle.getIntArray("unIdx");
            bundle.getIntArray("unWordCnt");
            int[] intArray2 = bundle.getIntArray("unLineNo");
            bundle.getBooleanArray("bHighLight");
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            if (string.contains("@")) {
                string = string.replace("@", "...");
            }
            if (intArray.length == 0) {
                return;
            }
            int i4 = intArray2[0];
            int i5 = 0;
            while (true) {
                if (i5 >= intArray.length) {
                    break;
                }
                int i6 = intArray2[i5];
                if (i6 != i4) {
                    i4 = i5;
                    break;
                } else {
                    i5++;
                    i4 = i6;
                }
            }
            sb.append((CharSequence) string, 0, intArray[i4]);
            sb2.append((CharSequence) string, intArray[i4], string.length());
            sb2.append("");
            com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide onRoadGuideTextUpdate:" + sb.toString());
            IBRouteGuidanceListener iBRouteGuidanceListener4 = this.b;
            if (iBRouteGuidanceListener4 != null) {
                iBRouteGuidanceListener4.onRoadGuideTextUpdate(sb.toString(), sb2.toString());
                return;
            }
            IWRouteGuidanceListener iWRouteGuidanceListener4 = this.f9914a;
            if (iWRouteGuidanceListener4 != null) {
                iWRouteGuidanceListener4.onRoadGuideTextUpdate(sb.toString(), sb2.toString());
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void c(Bundle bundle) {
        int i = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalDist);
        int i2 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime);
        StringBuffer stringBuffer = new StringBuffer();
        g.a(i, g.b.ZH, stringBuffer);
        IBRouteGuidanceListener iBRouteGuidanceListener = this.b;
        if (iBRouteGuidanceListener != null) {
            iBRouteGuidanceListener.onRemainDistanceUpdate(stringBuffer.toString());
            this.b.onRemainTimeUpdate(g.a(i2, 2));
            return;
        }
        IWRouteGuidanceListener iWRouteGuidanceListener = this.f9914a;
        if (iWRouteGuidanceListener != null) {
            iWRouteGuidanceListener.onRemainDistanceUpdate(stringBuffer.toString());
            this.f9914a.onRemainTimeUpdate(g.a(i2, 2));
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void d(int i) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void e(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void f(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void g(Message message) {
        IBRouteGuidanceListener iBRouteGuidanceListener = this.b;
        if (iBRouteGuidanceListener != null) {
            iBRouteGuidanceListener.onArriveDest();
            return;
        }
        IWRouteGuidanceListener iWRouteGuidanceListener = this.f9914a;
        if (iWRouteGuidanceListener != null) {
            iWRouteGuidanceListener.onFinalEnd(message);
        }
    }

    @Override // com.baidu.platform.comjni.jninative.vibrate.IVibrateListener
    public void onVibrate() {
        IBRouteGuidanceListener iBRouteGuidanceListener = this.b;
        if (iBRouteGuidanceListener != null) {
            iBRouteGuidanceListener.onVibrate();
            return;
        }
        IWRouteGuidanceListener iWRouteGuidanceListener = this.f9914a;
        if (iWRouteGuidanceListener != null) {
            iWRouteGuidanceListener.onVibrate();
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.f9914a = null;
        this.b = null;
        if (this.c != null) {
            this.c = null;
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(Bundle bundle) {
        IBRouteGuidanceListener iBRouteGuidanceListener = this.b;
        if (iBRouteGuidanceListener != null) {
            iBRouteGuidanceListener.onGetRouteDetailInfo(a.a(bundle));
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void d(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void e(Message message) {
        IBRouteGuidanceListener iBRouteGuidanceListener = this.b;
        if (iBRouteGuidanceListener != null) {
            iBRouteGuidanceListener.onArriveDest();
            return;
        }
        IWRouteGuidanceListener iWRouteGuidanceListener = this.f9914a;
        if (iWRouteGuidanceListener != null) {
            iWRouteGuidanceListener.onArriveDest();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void f(Message message) {
        IWRouteGuidanceListener iWRouteGuidanceListener = this.f9914a;
        if (iWRouteGuidanceListener != null) {
            iWRouteGuidanceListener.onIndoorEnd(message);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void d(Message message) {
        IBRouteGuidanceListener iBRouteGuidanceListener = this.b;
        if (iBRouteGuidanceListener != null) {
            iBRouteGuidanceListener.onReRouteComplete();
            return;
        }
        IWRouteGuidanceListener iWRouteGuidanceListener = this.f9914a;
        if (iWRouteGuidanceListener != null) {
            iWRouteGuidanceListener.onReRouteComplete();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void a(Message message) {
        Activity activity = this.c;
        if (activity == null) {
            return;
        }
        IBRouteGuidanceListener iBRouteGuidanceListener = this.b;
        if (iBRouteGuidanceListener != null && message.arg1 == 0) {
            if (com.baidu.platform.comapi.bikenavi.a.a.f9539a) {
                iBRouteGuidanceListener.onGpsStatusChange(com.baidu.platform.comapi.wnplatform.p.a.a.b().getString(R.string.wsdk_string_rg_search_gps), com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, R.drawable.wn_gps));
                return;
            } else {
                iBRouteGuidanceListener.onGpsStatusChange(activity.getResources().getString(R.string.wsdk_string_rg_search_gps), this.c.getResources().getDrawable(R.drawable.wn_gps));
                return;
            }
        }
        IWRouteGuidanceListener iWRouteGuidanceListener = this.f9914a;
        if (iWRouteGuidanceListener == null || message.arg1 != 0) {
            return;
        }
        if (com.baidu.platform.comapi.bikenavi.a.a.f9539a) {
            iWRouteGuidanceListener.onGpsStatusChange(com.baidu.platform.comapi.wnplatform.p.a.a.b().getString(R.string.wsdk_string_rg_search_gps), com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, R.drawable.wn_gps));
        } else {
            iWRouteGuidanceListener.onGpsStatusChange(activity.getResources().getString(R.string.wsdk_string_rg_search_gps), this.c.getResources().getDrawable(R.drawable.wn_gps));
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void c(Message message) {
        Activity activity = this.c;
        if (activity == null) {
            return;
        }
        if (this.b != null) {
            if (com.baidu.platform.comapi.bikenavi.a.a.f9539a) {
                this.b.onRoutePlanYawing(com.baidu.platform.comapi.wnplatform.p.a.a.b().getString(R.string.wsdk_string_rg_recalcing), com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, R.drawable.wn_reroute));
                return;
            } else {
                this.b.onRoutePlanYawing(activity.getResources().getString(R.string.wsdk_string_rg_recalcing), this.c.getResources().getDrawable(R.drawable.wn_reroute));
                return;
            }
        }
        if (this.f9914a != null) {
            if (com.baidu.platform.comapi.bikenavi.a.a.f9539a) {
                this.f9914a.onRoutePlanYawing(com.baidu.platform.comapi.wnplatform.p.a.a.b().getString(R.string.wsdk_string_rg_recalcing), com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, R.drawable.wn_reroute));
            } else {
                this.f9914a.onRoutePlanYawing(activity.getResources().getString(R.string.wsdk_string_rg_recalcing), this.c.getResources().getDrawable(R.drawable.wn_reroute));
            }
        }
    }

    public void a(IWRouteGuidanceListener iWRouteGuidanceListener) {
        this.f9914a = iWRouteGuidanceListener;
        if (iWRouteGuidanceListener != null) {
            com.baidu.platform.comapi.walknavi.b.a().L().a((com.baidu.platform.comapi.wnplatform.i.a) this);
            com.baidu.platform.comapi.walknavi.b.a().L().a((com.baidu.platform.comapi.wnplatform.i.b) this);
            com.baidu.platform.comapi.walknavi.b.a().X().a(this);
            VibrateHelper.addVibrateListener(this);
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().L().b((com.baidu.platform.comapi.wnplatform.i.a) this);
        com.baidu.platform.comapi.walknavi.b.a().L().b((com.baidu.platform.comapi.wnplatform.i.b) this);
        com.baidu.platform.comapi.walknavi.b.a().X().b(this);
        VibrateHelper.removeVibrateListener(this);
    }

    public void a(IBRouteGuidanceListener iBRouteGuidanceListener) {
        this.b = iBRouteGuidanceListener;
        if (iBRouteGuidanceListener != null) {
            com.baidu.platform.comapi.walknavi.b.a().L().a((com.baidu.platform.comapi.wnplatform.i.a) this);
            com.baidu.platform.comapi.walknavi.b.a().L().a((com.baidu.platform.comapi.wnplatform.i.b) this);
            com.baidu.platform.comapi.walknavi.b.a().X().a(this);
            VibrateHelper.addVibrateListener(this);
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().L().b((com.baidu.platform.comapi.wnplatform.i.a) this);
        com.baidu.platform.comapi.walknavi.b.a().L().b((com.baidu.platform.comapi.wnplatform.i.b) this);
        com.baidu.platform.comapi.walknavi.b.a().X().b(this);
        VibrateHelper.removeVibrateListener(this);
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void b(Message message) {
        Activity activity = this.c;
        if (activity == null) {
            return;
        }
        if (this.b != null) {
            if (com.baidu.platform.comapi.bikenavi.a.a.f9539a) {
                this.b.onRouteFarAway(com.baidu.platform.comapi.wnplatform.p.a.a.b().getString(R.string.wsdk_string_rg_faraway), com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, R.drawable.wn_faraway_route));
                return;
            } else {
                this.b.onRouteFarAway(activity.getResources().getString(R.string.wsdk_string_rg_faraway), this.c.getResources().getDrawable(R.drawable.wn_faraway_route));
                return;
            }
        }
        if (this.f9914a != null) {
            if (com.baidu.platform.comapi.bikenavi.a.a.f9539a) {
                this.f9914a.onRouteFarAway(com.baidu.platform.comapi.wnplatform.p.a.a.b().getString(R.string.wsdk_string_rg_faraway), com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, R.drawable.wn_faraway_route));
            } else {
                this.f9914a.onRouteFarAway(activity.getResources().getString(R.string.wsdk_string_rg_faraway), this.c.getResources().getDrawable(R.drawable.wn_faraway_route));
            }
        }
    }
}
