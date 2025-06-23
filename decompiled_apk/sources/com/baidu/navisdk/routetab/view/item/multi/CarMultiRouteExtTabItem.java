package com.baidu.navisdk.routetab.view.item.multi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.routetab.view.item.RouteTabItem;
import com.baidu.navisdk.ui.widget.BNHorizontalForbidScrollView;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

/* loaded from: classes7.dex */
public class CarMultiRouteExtTabItem extends MultiRouteTabItem {
    private int l;
    private int m;
    private com.baidu.navisdk.routetab.data.a n;
    private LinearLayout o;
    private RelativeLayout p;
    private RelativeLayout q;
    private LinearLayout r;
    private RelativeLayout s;
    private LinearLayout t;
    private TextView u;
    private BNHorizontalForbidScrollView v;

    /* loaded from: classes7.dex */
    public class a extends SimpleTarget<Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7983a;

        public a(Context context) {
            this.f7983a = context;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
            PorterDuffColorFilter porterDuffColorFilter;
            if (bitmap == null) {
                ((RouteTabItem) CarMultiRouteExtTabItem.this).g.setCompoundDrawables(null, null, null, null);
                ((RouteTabItem) CarMultiRouteExtTabItem.this).g.invalidate();
                return;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f7983a.getResources(), bitmap);
            int min = Math.min(bitmap.getHeight(), ScreenUtil.getInstance().dip2px(9));
            bitmapDrawable.setBounds(0, 0, (bitmap.getWidth() * min) / bitmap.getHeight(), min);
            if (((RouteTabItem) CarMultiRouteExtTabItem.this).g.isSelected()) {
                porterDuffColorFilter = new PorterDuffColorFilter(Color.parseColor("#3377FF"), PorterDuff.Mode.SRC_ATOP);
            } else {
                porterDuffColorFilter = new PorterDuffColorFilter(Color.parseColor("#11131A"), PorterDuff.Mode.SRC_ATOP);
            }
            bitmapDrawable.setColorFilter(porterDuffColorFilter);
            ((RouteTabItem) CarMultiRouteExtTabItem.this).g.setCompoundDrawables(bitmapDrawable, null, null, null);
            ((RouteTabItem) CarMultiRouteExtTabItem.this).g.invalidate();
        }
    }

    public CarMultiRouteExtTabItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 0;
        this.m = 4;
    }

    private void f() {
        com.baidu.navisdk.routetab.data.a aVar = this.n;
        if (aVar != null) {
            if (this.e != null && !TextUtils.isEmpty(aVar.c())) {
                this.e.setText(this.n.c());
                if ("taxi".equals(this.n.f())) {
                    this.e.setTextColor(Color.parseColor("#FF6E52"));
                } else if (this.e.isSelected()) {
                    this.e.setTextColor(Color.parseColor("#3377FF"));
                } else {
                    this.e.setTextColor(Color.parseColor("#11131A"));
                }
            }
            if (this.g != null) {
                if (!TextUtils.isEmpty(this.n.d())) {
                    this.g.setVisibility(0);
                    this.g.setText(this.n.d());
                    d();
                    return;
                }
                this.g.setVisibility(8);
            }
        }
    }

    private int getTabItemPadding() {
        ScreenUtil screenUtil;
        int i;
        if (isSelected()) {
            screenUtil = ScreenUtil.getInstance();
            i = 14;
        } else {
            screenUtil = ScreenUtil.getInstance();
            i = 9;
        }
        return screenUtil.dip2px(i);
    }

    private int getTagIconWidth() {
        ImageView imageView = this.i;
        if (imageView != null && imageView.getWidth() != 0) {
            return this.i.getWidth() + ScreenUtil.getInstance().dip2px(6);
        }
        return ScreenUtil.getInstance().dip2px(12);
    }

    public int getExtTabLayoutType() {
        return this.l;
    }

    public int getExtTabState() {
        return this.m;
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public String getTAG() {
        return "CarMultiRouteExtTabItem";
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem
    public int getTabBackgroundDrawable() {
        return R.drawable.nsdk_drawable_tab_selected_bg;
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    public int getTextBackgroundDrawable() {
        return R.drawable.nsdk_drawable_car_time_text_pressed;
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public void initView() {
        super.initView();
        setGravity(16);
        this.o = (LinearLayout) findViewById(R.id.route_tab_loading_layout);
        this.p = (RelativeLayout) findViewById(R.id.route_tab_loading_expand_layout);
        this.q = (RelativeLayout) findViewById(R.id.route_tab_loading_hide_layout);
        this.r = (LinearLayout) findViewById(R.id.route_tab_retry_layout);
        this.s = (RelativeLayout) findViewById(R.id.route_tab_retry_hide_layout);
        this.t = (LinearLayout) findViewById(R.id.route_tab_retry_expend_layout);
        this.v = (BNHorizontalForbidScrollView) findViewById(R.id.route_tab_item_describe_layout);
        this.u = (TextView) findViewById(R.id.route_tab_item_describe_tv);
        this.i.setVisibility(8);
    }

    private void d() {
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (!TextUtils.isEmpty(this.n.b()) && a2 != null) {
            Glide.with(com.baidu.navisdk.framework.a.c().a()).load(this.n.b()).asBitmap().into(new a(a2));
        } else {
            this.g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.g.invalidate();
        }
    }

    private void e() {
        com.baidu.navisdk.routetab.data.a aVar;
        if (this.u == null || (aVar = this.n) == null || TextUtils.isEmpty(aVar.a())) {
            return;
        }
        this.u.setText(this.n.a());
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public int a() {
        return R.layout.nsdk_layout_car_multi_route_ext_tabs_item;
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem
    public int b(String str) {
        float tabItemPadding;
        int dip2px;
        ImageView imageView;
        float measureText = this.d.getPaint().measureText(TextUtils.isEmpty(str) ? "" : str);
        if (this.d != null) {
            if (isSelected() && (imageView = this.i) != null && imageView.getVisibility() == 0) {
                tabItemPadding = measureText + getTabItemPadding();
                dip2px = getTagIconWidth();
            } else {
                tabItemPadding = measureText + getTabItemPadding();
                dip2px = ScreenUtil.getInstance().dip2px(2);
            }
            return (int) (tabItemPadding + dip2px);
        }
        return super.b(str);
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem
    public void c() {
        if (isSelected()) {
            setPadding(ScreenUtil.getInstance().dip2px(7), ScreenUtil.getInstance().dip2px(5), ScreenUtil.getInstance().dip2px(7), ScreenUtil.getInstance().dip2px(5));
        } else {
            setPadding(ScreenUtil.getInstance().dip2px(7), ScreenUtil.getInstance().dip2px(5), ScreenUtil.getInstance().dip2px(2), ScreenUtil.getInstance().dip2px(5));
        }
    }

    public void a(com.baidu.navisdk.routetab.data.a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        this.n = aVar;
        a(z);
        f();
        e();
    }

    public CarMultiRouteExtTabItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = 0;
        this.m = 4;
    }

    private void a(boolean z) {
        com.baidu.navisdk.routetab.data.a aVar;
        if (this.d == null || (aVar = this.n) == null || TextUtils.isEmpty(aVar.e())) {
            return;
        }
        this.d.setText(this.n.e());
        if (z) {
            this.d.setTextSize(1, 17.0f);
        } else {
            this.d.setTextSize(1, 18.0f);
        }
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem
    public void a(boolean z, float f) {
        super.a(z, f);
        this.i.setVisibility(8);
        if (f > 0.0f) {
            if (z) {
                this.d.setBackgroundResource(getTextBackgroundDrawable());
            } else {
                this.d.setBackgroundResource(R.drawable.nsdk_drawable_time_text_normal);
            }
        }
        TextView textView = this.g;
        if (textView != null) {
            textView.setSelected(z);
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setSelected(z);
        }
    }
}
