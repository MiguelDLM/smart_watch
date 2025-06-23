package com.huawei.hms.ads.nativead;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.by;
import com.huawei.hms.ads.ca;
import com.huawei.hms.ads.cb;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fo;
import com.huawei.hms.ads.fp;
import com.huawei.hms.ads.kd;
import com.huawei.hms.ads.ke;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.w;
import com.huawei.openalliance.ad.views.NativeVideoView;
import com.huawei.openalliance.ad.views.NativeWindowImageView;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

@GlobalApi
/* loaded from: classes10.dex */
public final class NativeAdMonitor implements View.OnAttachStateChangeListener, fo {
    private static final String Code = "NativeAdMonitor";
    private static WeakHashMap<View, NativeAdMonitor> V = new WeakHashMap<>();
    private View B;
    private ca C;
    private ke D;
    private kd F;
    private List<View> I;
    private l L;
    private fp S;
    private List<View> Z;
    private PPSNativeView.b f;
    private PPSNativeView.e g;
    private DislikeAdListener h;

    /* renamed from: a, reason: collision with root package name */
    private boolean f17321a = true;
    private boolean b = false;
    private final String c = x.ak + hashCode();
    private final String d = x.al + hashCode();
    private boolean e = false;
    private View.OnClickListener i = new View.OnClickListener() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NativeAdMonitor.this.f17321a) {
                NativeAdMonitor.this.f17321a = false;
                fb.V(NativeAdMonitor.Code, "onClick");
                NativeAdMonitor.this.e = true;
                if (NativeAdMonitor.this.f != null) {
                    NativeAdMonitor.this.f.Code(view);
                }
                NativeAdMonitor.this.C.V();
                NativeAdMonitor.this.Code((Integer) 1, true);
                bf.Code(new Runnable() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NativeAdMonitor.this.f17321a = true;
                    }
                }, 500L);
            }
        }
    };
    private View.OnClickListener j = new View.OnClickListener() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };

    @GlobalApi
    public NativeAdMonitor(View view, Map<String, View> map, Map<String, View> map2) {
        String str;
        String str2;
        this.I = new ArrayList();
        this.Z = new ArrayList();
        if (view instanceof NativeView) {
            str = Code;
            str2 = "containerView can't be an instance of NativeView class or NativeView subclass";
        } else if (view == null) {
            str = Code;
            str2 = "containerView can't be null";
        } else {
            if (V.get(view) == null) {
                V.put(view, this);
                this.B = view;
                this.C = new cb(this.B.getContext(), this.B);
                this.S = new fp(view, this);
                this.B.addOnAttachStateChangeListener(this);
                if (map != null) {
                    this.I = new ArrayList(map.values());
                }
                if (map2 != null) {
                    this.Z = new ArrayList(map2.values());
                    return;
                }
                return;
            }
            str = Code;
            str2 = "containerView has been existed in other NativeAdMonitor object.";
        }
        fb.I(str, str2);
    }

    private MediaView Code(View view) {
        LinkedList linkedList = new LinkedList();
        if (view instanceof ViewGroup) {
            linkedList.add(view);
        }
        while (linkedList.size() > 0) {
            View view2 = (View) linkedList.poll();
            if (view2 instanceof MediaView) {
                return (MediaView) view2;
            }
            if (view2 instanceof ViewGroup) {
                int i = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    if (i < viewGroup.getChildCount()) {
                        linkedList.offer(viewGroup.getChildAt(i));
                        i++;
                    }
                }
            }
        }
        return null;
    }

    private void D() {
        if (ad.Code(this.Z)) {
            return;
        }
        for (View view : this.Z) {
            if (view != null) {
                view.setClickable(true);
            }
        }
    }

    private void F() {
        if (ad.Code(this.I)) {
            return;
        }
        for (View view : this.I) {
            if (view != null) {
                view.setOnClickListener(null);
            }
        }
    }

    private void S() {
        l lVar;
        if (!Code() || (lVar = this.L) == null || lVar.ai()) {
            return;
        }
        fb.V(Code, " maybe report show start.");
        I();
    }

    public void Z() {
        fb.V(Code, "onClose");
        Code((List<String>) null);
    }

    @Override // com.huawei.hms.ads.fo
    public void a_() {
        l lVar = this.L;
        if (lVar != null) {
            bf.Code(new Runnable() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.4
                @Override // java.lang.Runnable
                public void run() {
                    l lVar2 = NativeAdMonitor.this.L;
                    if (lVar2 != null) {
                        NativeAdMonitor.this.Code(Long.valueOf(lVar2.u()), Integer.valueOf(NativeAdMonitor.this.S.I()), null, false);
                    }
                }
            }, this.c, lVar.u());
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        fp fpVar = this.S;
        if (fpVar != null) {
            fpVar.D();
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        fb.V(Code, "onDetachedFromWindow");
        fp fpVar = this.S;
        if (fpVar != null) {
            fpVar.L();
        }
    }

    @GlobalApi
    public void setNativeAd(NativeAd nativeAd) {
        bf.Code(this.d);
        bf.Code(this.c);
        if (nativeAd == null) {
            fb.V(Code, "nativeAd is null, can't set the nativeAd now.");
            return;
        }
        if (nativeAd instanceof by) {
            ((by) nativeAd).Code(this);
        }
        Code(nativeAd);
    }

    @GlobalApi
    public void unregister() {
        bf.Code(this.d);
        bf.Code(this.c);
        l lVar = this.L;
        if (lVar != null) {
            lVar.C(false);
        }
        View view = this.B;
        if (view != null) {
            view.setOnClickListener(null);
        }
        this.L = null;
        this.S.V();
        this.C.Code((l) null);
        this.h = null;
        F();
        D();
        kd kdVar = this.F;
        if (kdVar != null) {
            kdVar.setNativeAd(null);
        }
        this.F = null;
    }

    private void C() {
        l lVar = this.L;
        if (this.B == null || lVar == null) {
            return;
        }
        bf.Code(new Runnable() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                l lVar2 = NativeAdMonitor.this.L;
                if (NativeAdMonitor.this.B == null || lVar2 == null) {
                    return;
                }
                NativeAdMonitor.this.S.a();
            }
        }, this.d, lVar.u() / 2);
    }

    @Override // com.huawei.hms.ads.fo
    public void I() {
        PPSNativeView.e eVar;
        this.b = false;
        String valueOf = String.valueOf(w.Code());
        l lVar = this.L;
        if (lVar == null) {
            fb.V(Code, "nativeAd is null, please register first");
            return;
        }
        lVar.I(false);
        this.L.B(false);
        this.L.C(true);
        if (this.e && (eVar = this.g) != null) {
            this.e = false;
            eVar.Z();
        }
        if (!this.L.ag()) {
            this.L.V(true);
        }
        this.C.Code(valueOf);
        kd kdVar = this.F;
        if (kdVar != null) {
            kdVar.Code(valueOf);
        }
        this.C.Code();
    }

    @Override // com.huawei.hms.ads.fo
    public void V(long j, int i) {
        bf.Code(this.c);
        l lVar = this.L;
        if (lVar != null) {
            lVar.C(false);
        }
        this.C.Code(j, i);
    }

    private void I(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof MediaView) {
                NativeVideoView videoView = ((MediaView) view).getVideoView();
                if (videoView != null) {
                    videoView.setCoverClickListener(this.j);
                    view = videoView.getPreviewImageView();
                    view.setOnClickListener(null);
                }
            } else if (view != null) {
                view.setClickable(false);
                view.setOnClickListener(null);
            }
        }
    }

    private void V(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof MediaView) {
                NativeVideoView videoView = ((MediaView) view).getVideoView();
                if (videoView != null) {
                    videoView.setCoverClickListener(this.i);
                    view = videoView.getPreviewImageView();
                    view.setOnClickListener(this.i);
                }
            } else if (view != null) {
                view.setOnClickListener(this.i);
            }
        }
    }

    @Override // com.huawei.hms.ads.fo
    public void Code(long j, int i) {
        bf.Code(this.c);
        if (!this.S.Code(j) || this.b) {
            return;
        }
        this.b = true;
        Code(Long.valueOf(j), Integer.valueOf(i), null, false);
    }

    public void Code(DislikeAdListener dislikeAdListener) {
        this.h = dislikeAdListener;
    }

    private void Code(NativeAd nativeAd) {
        View view = this.B;
        if (view == null || V.get(view) == null) {
            fb.V(Code, "container view is null, please add a container view first.");
            return;
        }
        if (nativeAd instanceof by) {
            l Code2 = ((by) nativeAd).Code();
            if (Code2 instanceof l) {
                this.L = Code2;
                this.S.V(Code2.u(), this.L.v());
                this.C.Code(this.L);
                this.B.setOnClickListener(this.i);
                MediaView Code3 = Code(this.B);
                if (Code3 != null) {
                    b mediaViewAdapter = Code3.getMediaViewAdapter();
                    mediaViewAdapter.Code(nativeAd);
                    VideoOperator videoOperator = nativeAd.getVideoOperator();
                    if (videoOperator instanceof c) {
                        ((c) videoOperator).Code(Code3);
                    }
                    View B = mediaViewAdapter.B();
                    if (B instanceof NativeVideoView) {
                        NativeVideoView nativeVideoView = (NativeVideoView) B;
                        this.F = nativeVideoView;
                        nativeVideoView.setCoverClickListener(this.j);
                        this.F.setNativeAd(Code2);
                    }
                    if (B instanceof NativeWindowImageView) {
                        NativeWindowImageView nativeWindowImageView = (NativeWindowImageView) B;
                        this.D = nativeWindowImageView;
                        nativeWindowImageView.setNativeAd(Code2);
                        this.D.setDisplayView(this.B);
                    }
                }
                V(this.I);
                I(this.Z);
            }
        }
        S();
        C();
    }

    public void Code(PPSNativeView.b bVar) {
        this.f = bVar;
    }

    public void Code(PPSNativeView.e eVar) {
        this.g = eVar;
        this.C.Code(eVar);
    }

    public void Code(Integer num, boolean z) {
        Code(Long.valueOf(System.currentTimeMillis() - this.S.Z()), Integer.valueOf(this.S.I()), num, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Long l, Integer num, Integer num2, boolean z) {
        l lVar = this.L;
        if (lVar == null) {
            return;
        }
        boolean Code2 = com.huawei.openalliance.ad.utils.c.Code(lVar.F(), num2);
        if (!this.L.ah() || (Code2 && !this.L.X())) {
            this.C.Code(l, num, num2, z);
            if (Code2) {
                this.L.B(true);
            }
            if (this.L.ah()) {
                return;
            }
            this.L.I(true);
            PPSNativeView.e eVar = this.g;
            if (eVar != null) {
                eVar.B();
            }
        }
    }

    public void Code(List<String> list) {
        fb.V(Code, "onClose keyWords");
        this.C.Code(list);
        Code((Integer) 3, false);
        kd kdVar = this.F;
        if (kdVar != null) {
            kdVar.S();
        }
        DislikeAdListener dislikeAdListener = this.h;
        if (dislikeAdListener != null) {
            dislikeAdListener.onAdDisliked();
        }
        unregister();
    }

    public boolean Code() {
        fp fpVar = this.S;
        if (fpVar != null) {
            return fpVar.d();
        }
        return false;
    }
}
