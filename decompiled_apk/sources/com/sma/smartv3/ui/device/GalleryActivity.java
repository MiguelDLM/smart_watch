package com.sma.smartv3.ui.device;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.sma.smartv3.co_fit.R;
import java.util.List;

/* loaded from: classes12.dex */
public final class GalleryActivity extends BaseActivity {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO viewPager$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewPager>() { // from class: com.sma.smartv3.ui.device.GalleryActivity$viewPager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewPager invoke() {
            return (ViewPager) GalleryActivity.this.findViewById(R.id.view_pager);
        }
    });

    @OXOo.OOXIXo
    private final List<Uri> mUris = o00.oIX0oI();
    private final int mWidth = ScreenUtils.getAppScreenWidth();
    private final int mHeight = ScreenUtils.getAppScreenHeight();

    private final ViewPager getViewPager() {
        return (ViewPager) this.viewPager$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getViewPager().setAdapter(new PagerAdapter() { // from class: com.sma.smartv3.ui.device.GalleryActivity$initView$1
            @Override // androidx.viewpager.widget.PagerAdapter
            public void destroyItem(@OXOo.OOXIXo ViewGroup container, int i, @OXOo.OOXIXo Object object) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(container, "container");
                kotlin.jvm.internal.IIX0o.x0xO0oo(object, "object");
                container.removeView((View) object);
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                List list;
                list = GalleryActivity.this.mUris;
                return list.size();
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            @OXOo.OOXIXo
            public Object instantiateItem(@OXOo.OOXIXo ViewGroup container, int i) {
                Activity mContext;
                List list;
                int i2;
                int i3;
                kotlin.jvm.internal.IIX0o.x0xO0oo(container, "container");
                mContext = GalleryActivity.this.getMContext();
                ImageView imageView = new ImageView(mContext);
                GalleryActivity galleryActivity = GalleryActivity.this;
                RequestManager with = Glide.with((FragmentActivity) galleryActivity);
                list = galleryActivity.mUris;
                RequestBuilder<Drawable> load = with.load((Uri) list.get(i));
                i2 = galleryActivity.mWidth;
                i3 = galleryActivity.mHeight;
                load.override(i2 / 2, i3 / 2).into(imageView);
                container.addView(imageView);
                return imageView;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public boolean isViewFromObject(@OXOo.OOXIXo View view, @OXOo.OOXIXo Object object) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
                kotlin.jvm.internal.IIX0o.x0xO0oo(object, "object");
                return view == object;
            }
        });
        getViewPager().setCurrentItem(getMArg1());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_gallery;
    }
}
