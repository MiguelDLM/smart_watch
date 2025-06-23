package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.gf;
import com.huawei.hms.ads.kq;
import com.huawei.hms.ads.kw;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.data.p;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.w;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes10.dex */
public abstract class PlacementMediaView extends AutoScaleSizeRelativeLayout implements gf, kq, kw {
    protected boolean B;
    protected boolean C;
    protected n Code;
    protected String I;
    protected boolean S;
    protected String V;
    private p b;
    private final Set<com.huawei.openalliance.ad.media.listener.i> c;
    private int d;
    private long e;
    private long f;
    private long g;
    private long h;
    private boolean i;
    private boolean j;
    private Handler k;

    public PlacementMediaView(Context context) {
        super(context);
        this.c = new CopyOnWriteArraySet();
        this.d = 0;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.i = false;
        this.j = false;
        this.B = false;
        this.C = false;
        this.S = false;
        this.k = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PlacementMediaView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str;
                try {
                    if (1 == message.what) {
                        PlacementMediaView.this.d = (int) ((w.Code() - PlacementMediaView.this.e) - PlacementMediaView.this.h);
                        if (PlacementMediaView.this.f()) {
                            PlacementMediaView.this.e();
                        } else {
                            PlacementMediaView.this.c();
                            PlacementMediaView.this.k.removeMessages(1);
                            PlacementMediaView.this.k.sendEmptyMessageDelayed(1, 100L);
                        }
                    }
                } catch (IllegalStateException unused) {
                    str = "handleMessage IllegalStateException";
                    fb.I("PlacementMediaView", str);
                } catch (Throwable th) {
                    str = "handleMessage " + th.getClass().getSimpleName();
                    fb.I("PlacementMediaView", str);
                }
            }
        };
    }

    private void a() {
        this.d = 0;
        this.e = 0L;
        this.g = 0L;
        this.f = 0L;
        this.h = 0L;
        this.i = false;
        this.j = false;
        this.C = false;
        this.B = false;
        this.S = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.i) {
            return;
        }
        this.i = true;
        Iterator<com.huawei.openalliance.ad.media.listener.i> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().Code(this.I, this.V, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f <= 0 || this.j) {
            return;
        }
        for (com.huawei.openalliance.ad.media.listener.i iVar : this.c) {
            String str = this.I;
            String str2 = this.V;
            int i = this.d;
            iVar.Code(str, str2, (int) (i / this.f), i);
        }
    }

    private void d() {
        Iterator<com.huawei.openalliance.ad.media.listener.i> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().V(this.I, this.V, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.i = false;
        Iterator<com.huawei.openalliance.ad.media.listener.i> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().Z(this.I, this.V, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return ((long) this.d) >= this.f;
    }

    public void B() {
    }

    public abstract void Code();

    public abstract void Code(int i);

    public boolean D() {
        return false;
    }

    public void I() {
    }

    public void L() {
        this.i = false;
        this.j = true;
        Iterator<com.huawei.openalliance.ad.media.listener.i> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().Code(this.I, this.V, 0, -1, -1);
        }
    }

    public void S() {
        this.k.removeMessages(1);
        this.g = w.Code();
        d();
    }

    public abstract void V();

    public void destroyView() {
        this.k.removeMessages(1);
        this.c.clear();
        Code();
    }

    public long getDuration() {
        p S;
        n nVar = this.Code;
        if (nVar == null || (S = nVar.S()) == null) {
            return 0L;
        }
        return S.d();
    }

    public abstract ImageView getLastFrame();

    public abstract com.huawei.openalliance.ad.media.b getMediaState();

    @Override // com.huawei.hms.ads.gf
    public View getOpenMeasureView() {
        return this;
    }

    public com.huawei.openalliance.ad.inter.data.h getPlacementAd() {
        return this.Code;
    }

    @Override // com.huawei.hms.ads.kw
    public void pauseView() {
    }

    @Override // com.huawei.hms.ads.kw
    public void resumeView() {
    }

    public void setAudioFocusType(int i) {
    }

    public abstract void setMediaPlayerReleaseListener(com.huawei.openalliance.ad.media.listener.e eVar);

    public void setPlacementAd(com.huawei.openalliance.ad.inter.data.h hVar) {
        String str;
        a();
        if (hVar instanceof n) {
            n nVar = (n) hVar;
            this.Code = nVar;
            p S = nVar.S();
            this.b = S;
            this.f = S.d();
            this.V = this.b.Z();
            str = hVar.a();
        } else {
            this.Code = null;
            this.b = null;
            this.k.removeMessages(1);
            str = "";
            this.V = "";
        }
        this.I = str;
    }

    public void setSoundVolume(float f) {
    }

    public PlacementMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new CopyOnWriteArraySet();
        this.d = 0;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.i = false;
        this.j = false;
        this.B = false;
        this.C = false;
        this.S = false;
        this.k = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PlacementMediaView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str;
                try {
                    if (1 == message.what) {
                        PlacementMediaView.this.d = (int) ((w.Code() - PlacementMediaView.this.e) - PlacementMediaView.this.h);
                        if (PlacementMediaView.this.f()) {
                            PlacementMediaView.this.e();
                        } else {
                            PlacementMediaView.this.c();
                            PlacementMediaView.this.k.removeMessages(1);
                            PlacementMediaView.this.k.sendEmptyMessageDelayed(1, 100L);
                        }
                    }
                } catch (IllegalStateException unused) {
                    str = "handleMessage IllegalStateException";
                    fb.I("PlacementMediaView", str);
                } catch (Throwable th) {
                    str = "handleMessage " + th.getClass().getSimpleName();
                    fb.I("PlacementMediaView", str);
                }
            }
        };
    }

    public void C() {
    }

    public void F() {
    }

    public void I(int i) {
    }

    public PlacementMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new CopyOnWriteArraySet();
        this.d = 0;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.i = false;
        this.j = false;
        this.B = false;
        this.C = false;
        this.S = false;
        this.k = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PlacementMediaView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str;
                try {
                    if (1 == message.what) {
                        PlacementMediaView.this.d = (int) ((w.Code() - PlacementMediaView.this.e) - PlacementMediaView.this.h);
                        if (PlacementMediaView.this.f()) {
                            PlacementMediaView.this.e();
                        } else {
                            PlacementMediaView.this.c();
                            PlacementMediaView.this.k.removeMessages(1);
                            PlacementMediaView.this.k.sendEmptyMessageDelayed(1, 100L);
                        }
                    }
                } catch (IllegalStateException unused) {
                    str = "handleMessage IllegalStateException";
                    fb.I("PlacementMediaView", str);
                } catch (Throwable th) {
                    str = "handleMessage " + th.getClass().getSimpleName();
                    fb.I("PlacementMediaView", str);
                }
            }
        };
    }

    public void I(com.huawei.openalliance.ad.media.listener.i iVar) {
    }

    public void V(int i) {
    }

    public void Code(long j) {
    }

    public void V(long j) {
    }

    public void Code(com.huawei.openalliance.ad.media.listener.b bVar) {
    }

    public void V(com.huawei.openalliance.ad.media.listener.f fVar) {
    }

    public void Code(com.huawei.openalliance.ad.media.listener.c cVar) {
    }

    public void Code(com.huawei.openalliance.ad.media.listener.f fVar) {
    }

    public void Code(com.huawei.openalliance.ad.media.listener.g gVar) {
    }

    public void Code(com.huawei.openalliance.ad.media.listener.i iVar) {
        if (iVar != null) {
            this.c.add(iVar);
        }
    }

    public void Code(String str) {
    }

    public void Code(boolean z, boolean z2) {
        fb.V("PlacementMediaView", "play, mediaCached: %s, mediaAvalible: %s", Boolean.valueOf(this.B), Boolean.valueOf(this.C));
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PlacementMediaView.2
            @Override // java.lang.Runnable
            public void run() {
                PlacementMediaView placementMediaView = PlacementMediaView.this;
                if (!placementMediaView.B) {
                    placementMediaView.S = true;
                    return;
                }
                if (!placementMediaView.C) {
                    placementMediaView.L();
                    return;
                }
                placementMediaView.k.removeMessages(1);
                PlacementMediaView.this.k.sendEmptyMessage(1);
                PlacementMediaView.this.b();
                if (0 == PlacementMediaView.this.e) {
                    PlacementMediaView.this.e = w.Code();
                }
                if (PlacementMediaView.this.g != 0) {
                    PlacementMediaView.this.h += w.Code() - PlacementMediaView.this.g;
                }
            }
        }, 1L);
    }
}
