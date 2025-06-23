package com.qq.e.ads.nativ;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public class NativeUnifiedAD extends NativeAbstractAD<NUADI> {
    private AdListenerAdapter f;
    private NativeADUnifiedListener g;
    private List<Integer> h = new ArrayList();
    private List<String> i;
    private volatile int j;
    private volatile int k;
    private String l;
    private LoadAdParams m;

    /* loaded from: classes11.dex */
    public static class AdListenerAdapter implements ADListener {

        /* renamed from: a, reason: collision with root package name */
        private NativeADUnifiedListener f19419a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.f19419a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Integer num;
            if (this.f19419a != null) {
                int type = aDEvent.getType();
                if (type != 100) {
                    if (type == 101 && (num = (Integer) aDEvent.getParam(Integer.class)) != null) {
                        this.f19419a.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                }
                List list = (List) aDEvent.getParam(List.class);
                if (list == null || list.size() <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new NativeUnifiedADDataAdapter((NativeUnifiedADData) it.next()));
                }
                this.f19419a.onADLoaded(arrayList);
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        this.g = nativeADUnifiedListener;
        this.f = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str);
    }

    private void a(int i, boolean z) {
        if (a()) {
            if (!b()) {
                if (z) {
                    this.h.add(Integer.valueOf(i));
                    return;
                }
                return;
            }
            T t = this.f19399a;
            if (t != 0) {
                LoadAdParams loadAdParams = this.m;
                NUADI nuadi = (NUADI) t;
                if (loadAdParams != null) {
                    nuadi.loadData(i, loadAdParams);
                } else {
                    nuadi.loadData(i);
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        NativeADUnifiedListener nativeADUnifiedListener = this.g;
        if (nativeADUnifiedListener != null) {
            nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public String getAdNetWorkName() {
        T t = this.f19399a;
        if (t != 0) {
            return ((NUADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadData(int i) {
        a(i, true);
    }

    public void setCategories(List<String> list) {
        this.i = list;
        T t = this.f19399a;
        if (t == 0 || list == null) {
            return;
        }
        ((NUADI) t).setCategories(list);
    }

    public void setMaxVideoDuration(int i) {
        this.k = i;
        if (this.k > 0 && this.j > this.k) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.f19399a;
        if (t != 0) {
            ((NUADI) t).setMaxVideoDuration(this.k);
        }
    }

    public void setMinVideoDuration(int i) {
        this.j = i;
        if (this.k > 0 && this.j > this.k) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.f19399a;
        if (t != 0) {
            ((NUADI) t).setMinVideoDuration(this.j);
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Vast class name 不能为空");
            return;
        }
        this.l = str;
        T t = this.f19399a;
        if (t != 0) {
            ((NUADI) t).setVastClassName(str);
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener, String str2) {
        this.g = nativeADUnifiedListener;
        this.f = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.f);
    }

    public void loadData(int i, LoadAdParams loadAdParams) {
        this.m = loadAdParams;
        loadData(i);
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        NUADI nuadi = (NUADI) obj;
        nuadi.setMinVideoDuration(this.j);
        nuadi.setMaxVideoDuration(this.k);
        nuadi.setVastClassName(this.l);
        List<String> list = this.i;
        if (list != null) {
            setCategories(list);
        }
        Iterator<Integer> it = this.h.iterator();
        while (it.hasNext()) {
            a(it.next().intValue(), false);
        }
    }
}
