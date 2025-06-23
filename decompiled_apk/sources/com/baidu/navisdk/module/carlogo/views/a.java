package com.baidu.navisdk.module.carlogo.views;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.carlogo.datas.c;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public final class a extends PagerAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Context f7086a;
    private ArrayList<c> b;
    private SparseArray<BN3DCarLogoPageItem> c;
    private b d;

    /* renamed from: com.baidu.navisdk.module.carlogo.views.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class ViewOnClickListenerC0235a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7087a;

        public ViewOnClickListenerC0235a(int i) {
            this.f7087a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.d != null) {
                a.this.d.b(this.f7087a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean a();

        boolean a(int i);

        void b(int i);
    }

    public a(Context context, ArrayList<c> arrayList, b bVar) {
        this.f7086a = context;
        this.d = bVar;
        a(arrayList);
    }

    private boolean c(int i) {
        b bVar = this.d;
        if (bVar != null && bVar.a(i)) {
            return true;
        }
        return false;
    }

    @Nullable
    public BN3DCarLogoPageItem b(int i) {
        SparseArray<BN3DCarLogoPageItem> sparseArray;
        c cVar;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoAdapter", "getPageItemByCarId: " + i);
        }
        ArrayList<c> arrayList = this.b;
        if (arrayList != null && !arrayList.isEmpty()) {
            int i2 = 0;
            while (i2 < this.b.size() && ((cVar = this.b.get(i2)) == null || cVar.f7077a != i)) {
                i2++;
            }
            if (i2 != this.b.size() && (sparseArray = this.c) != null) {
                return sparseArray.get(i2);
            }
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        SparseArray<BN3DCarLogoPageItem> sparseArray = this.c;
        if (sparseArray != null) {
            sparseArray.remove(i);
        }
        if (obj instanceof BN3DCarLogoPageItem) {
            BN3DCarLogoPageItem bN3DCarLogoPageItem = (BN3DCarLogoPageItem) obj;
            viewGroup.removeView(bN3DCarLogoPageItem);
            bN3DCarLogoPageItem.setOnClickListener(null);
            bN3DCarLogoPageItem.b();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<c> arrayList = this.b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        BN3DCarLogoPageItem bN3DCarLogoPageItem = (BN3DCarLogoPageItem) LayoutInflater.from(this.f7086a).inflate(R.layout.nsdk_layout_3d_car_logo_item, viewGroup, false);
        c cVar = this.b.get(i);
        bN3DCarLogoPageItem.a(cVar.a(this.d.a()), c(i));
        if (cVar.h()) {
            bN3DCarLogoPageItem.a(cVar.q);
        }
        bN3DCarLogoPageItem.setTag(Integer.valueOf(cVar.f7077a));
        SparseArray<BN3DCarLogoPageItem> sparseArray = this.c;
        if (sparseArray != null) {
            sparseArray.put(i, bN3DCarLogoPageItem);
        }
        bN3DCarLogoPageItem.setOnClickListener(new ViewOnClickListenerC0235a(i));
        viewGroup.addView(bN3DCarLogoPageItem);
        return bN3DCarLogoPageItem;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void a(ArrayList<c> arrayList) {
        if (arrayList != null) {
            this.b = new ArrayList<>(arrayList);
        } else {
            this.b = null;
        }
        if (this.c != null || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.c = new SparseArray<>(arrayList.size());
    }

    @Nullable
    public BN3DCarLogoPageItem a(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoAdapter", "getPageItem: " + i);
        }
        SparseArray<BN3DCarLogoPageItem> sparseArray = this.c;
        if (sparseArray != null) {
            return sparseArray.get(i);
        }
        return null;
    }

    public void a() {
        SparseArray<BN3DCarLogoPageItem> sparseArray = this.c;
        if (sparseArray != null && sparseArray.size() > 0) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                BN3DCarLogoPageItem valueAt = this.c.valueAt(i);
                if (valueAt != null) {
                    valueAt.setOnClickListener(null);
                    valueAt.b();
                }
            }
            this.c.clear();
            this.c = null;
        }
        this.b = null;
        this.d = null;
        this.f7086a = null;
    }
}
