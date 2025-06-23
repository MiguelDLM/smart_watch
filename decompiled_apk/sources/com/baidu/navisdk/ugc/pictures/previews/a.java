package com.baidu.navisdk.ugc.pictures.previews;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.navisdk.imageloader.ImageLoader;
import com.baidu.navisdk.ui.util.j;
import com.baidu.navisdk.util.common.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes8.dex */
public class a extends PagerAdapter {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f8208a;
    private Context b;

    public a(Context context, ArrayList<String> arrayList, int i) {
        String arrays;
        this.f8208a = arrayList;
        this.b = context;
        g gVar = g.UGC;
        if (gVar.e()) {
            StringBuilder sb = new StringBuilder();
            sb.append("PicViewPageAdapter(), picPathArray = ");
            if (arrayList == null) {
                arrays = "null";
            } else {
                arrays = Arrays.toString(arrayList.toArray());
            }
            sb.append(arrays);
            sb.append(" index = ");
            sb.append(i);
            gVar.g("PicViewPageAdapter", sb.toString());
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        View view = (View) obj;
        ((ViewPager) viewGroup).removeView(view);
        if (view instanceof ImageView) {
            j.b((ImageView) view);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<String> arrayList = this.f8208a;
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
        ImageView imageView = new ImageView(this.b);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (com.baidu.navisdk.j.d()) {
            ImageLoader.with(this.b).load(this.f8208a.get(i)).into(imageView);
        } else {
            imageView.setImageURI(Uri.fromFile(new File(this.f8208a.get(i))));
        }
        viewGroup.addView(imageView);
        return imageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }
}
