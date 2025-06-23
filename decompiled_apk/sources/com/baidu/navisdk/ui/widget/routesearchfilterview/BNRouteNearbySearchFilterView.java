package com.baidu.navisdk.ui.widget.routesearchfilterview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.poisearch.e;
import com.baidu.navisdk.ui.widget.routesearchfilterview.BNRouteNearbySearchFilterRecyclerAdapter;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.b;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class BNRouteNearbySearchFilterView {
    private static final String TAG = "BNRouteNearbySearchFilterView";
    private BNRouteNearbySearchFilterRecyclerAdapter brandFilterRecyclerAdapter;
    private RecyclerView brandFilterRecyclerView;
    private final BNRouteNearbySearchCallback callbackInNavi;
    private String categoryName;
    private final Context context;
    private ArrayList<String> curBrandInfos;
    private View endArrowLayout;
    private ImageView endArrowView;
    private Button fastFilterButton;
    private LinearLayout fastSlowLayout;
    private LinearLayout filterBrandsLayout;
    private boolean isCategoryChanged;
    private final boolean isFromNavi;
    private boolean isOrientationChanged;
    private BNRouteNearbySearchFilterRecyclerAdapter.OnClickListener itemClickListener;
    private View mainView;
    private int orientation;
    private Button slowFilterButton;
    private View startArrowLayout;
    private ImageView startArrowView;
    private int clickPosition = -1;
    private boolean isViewEnabled = true;

    public BNRouteNearbySearchFilterView(Context context, String str, int i, BNRouteNearbySearchCallback bNRouteNearbySearchCallback, boolean z) {
        this.context = context;
        this.categoryName = str;
        this.orientation = i;
        this.callbackInNavi = bNRouteNearbySearchCallback;
        this.isFromNavi = z;
        initView();
        setData();
        setLayout();
    }

    private void destroy() {
        View view = this.mainView;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.mainView.getParent()).setVisibility(8);
            ((ViewGroup) this.mainView.getParent()).removeAllViews();
            this.mainView = null;
        }
    }

    private void initClickPosition() {
        if (TextUtils.isEmpty(e0.a(this.context).a(this.categoryName, ""))) {
            LogUtil.e(TAG, "categoryName = " + this.categoryName + ", local brandName = null");
            this.clickPosition = -1;
        } else {
            String a2 = e0.a(this.context).a(this.categoryName, "");
            LogUtil.e(TAG, "categoryName = " + this.categoryName + ", local brandName = " + a2);
            int i = 0;
            while (true) {
                if (i >= this.curBrandInfos.size()) {
                    break;
                }
                if (a2.equals(this.curBrandInfos.get(i))) {
                    this.clickPosition = i;
                    break;
                } else {
                    this.clickPosition = -1;
                    i++;
                }
            }
        }
        LogUtil.e(TAG, "clickPosition = " + this.clickPosition);
    }

    private void initListener() {
        if (this.itemClickListener == null) {
            this.itemClickListener = new BNRouteNearbySearchFilterRecyclerAdapter.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.routesearchfilterview.BNRouteNearbySearchFilterView.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.navisdk.ui.widget.routesearchfilterview.BNRouteNearbySearchFilterRecyclerAdapter.OnClickListener
                public void onItemClick(int i) {
                    if (BNRouteNearbySearchFilterView.this.brandFilterRecyclerAdapter == null) {
                        return;
                    }
                    if (!BNRouteNearbySearchFilterView.this.isViewEnabled) {
                        LogUtil.e(BNRouteNearbySearchFilterView.TAG, "nearby search is loading, cannot click!");
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    if (e0.a(BNRouteNearbySearchFilterView.this.context).a(BNRouteNearbySearchFilterView.this.categoryName, "").equals(BNRouteNearbySearchFilterView.this.curBrandInfos.get(i))) {
                        if (BNRouteNearbySearchFilterView.this.isFromNavi) {
                            b.r().a("3.5.3.7", e.a((String) BNRouteNearbySearchFilterView.this.curBrandInfos.get(i)), "2", "1");
                        } else {
                            b.r().a("2.a.6", e.a((String) BNRouteNearbySearchFilterView.this.curBrandInfos.get(i)), "2", null);
                        }
                        hashMap.put(BNRouteNearbySearchFilterView.this.categoryName, null);
                        LogUtil.e(BNRouteNearbySearchFilterView.TAG, "item click, search all brands---> categoryName : " + BNRouteNearbySearchFilterView.this.categoryName);
                        BNRouteNearbySearchFilterView.this.callbackInNavi.clickCallback(hashMap);
                        return;
                    }
                    if (BNRouteNearbySearchFilterView.this.isFromNavi) {
                        b.r().a("3.5.3.7", e.a((String) BNRouteNearbySearchFilterView.this.curBrandInfos.get(i)), "1", "1");
                    } else {
                        b.r().a("2.a.6", e.a((String) BNRouteNearbySearchFilterView.this.curBrandInfos.get(i)), "1", null);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(BNRouteNearbySearchFilterView.this.curBrandInfos.get(i));
                    hashMap.put(BNRouteNearbySearchFilterView.this.categoryName, arrayList);
                    LogUtil.e(BNRouteNearbySearchFilterView.TAG, "item click, search specific brand---> categoryName : " + BNRouteNearbySearchFilterView.this.categoryName + ", brandName : " + ((String) BNRouteNearbySearchFilterView.this.curBrandInfos.get(i)));
                    BNRouteNearbySearchFilterView.this.callbackInNavi.clickCallback(hashMap);
                }
            };
        }
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        if (this.isFromNavi) {
            if (this.orientation != 2) {
                this.mainView = JarUtils.inflate(this.context, R.layout.nsdk_layout_nearby_search_filter_in_navi_view, null);
                linearLayoutManager.setOrientation(1);
            } else {
                this.mainView = JarUtils.inflate(this.context, R.layout.nsdk_layout_nearby_search_filter_in_navi_view_land, null);
                linearLayoutManager.setOrientation(0);
            }
        } else {
            this.mainView = JarUtils.inflate(this.context, R.layout.nsdk_layout_nearby_search_filter_in_route_view, null);
            linearLayoutManager.setOrientation(1);
        }
        this.fastSlowLayout = (LinearLayout) this.mainView.findViewById(R.id.route_search_filter_fast_slow);
        this.fastFilterButton = (Button) this.mainView.findViewById(R.id.route_search_filter_category_fast);
        this.slowFilterButton = (Button) this.mainView.findViewById(R.id.route_search_filter_category_slow);
        this.startArrowLayout = this.mainView.findViewById(R.id.route_search_start_arrow_layout);
        this.endArrowLayout = this.mainView.findViewById(R.id.route_search_end_arrow_layout);
        this.startArrowView = (ImageView) this.mainView.findViewById(R.id.route_search_start_arrow);
        this.endArrowView = (ImageView) this.mainView.findViewById(R.id.route_search_end_arrow);
        this.filterBrandsLayout = (LinearLayout) this.mainView.findViewById(R.id.route_search_filter_brands);
        RecyclerView recyclerView = (RecyclerView) this.mainView.findViewById(R.id.route_search_filter_brands_recycler_view);
        this.brandFilterRecyclerView = recyclerView;
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void setAdapter() {
        BNRouteNearbySearchFilterRecyclerAdapter bNRouteNearbySearchFilterRecyclerAdapter = this.brandFilterRecyclerAdapter;
        if (bNRouteNearbySearchFilterRecyclerAdapter != null && !this.isOrientationChanged) {
            bNRouteNearbySearchFilterRecyclerAdapter.setClickPosition(this.clickPosition);
            this.brandFilterRecyclerAdapter.setBrandInfos(this.curBrandInfos);
            this.brandFilterRecyclerAdapter.notifyDataSetChanged();
        } else {
            BNRouteNearbySearchFilterRecyclerAdapter bNRouteNearbySearchFilterRecyclerAdapter2 = new BNRouteNearbySearchFilterRecyclerAdapter(this.context, this.curBrandInfos, this.orientation, this.itemClickListener, this.isFromNavi);
            this.brandFilterRecyclerAdapter = bNRouteNearbySearchFilterRecyclerAdapter2;
            bNRouteNearbySearchFilterRecyclerAdapter2.setClickPosition(this.clickPosition);
            this.brandFilterRecyclerView.setAdapter(this.brandFilterRecyclerAdapter);
        }
    }

    private void setData() {
        this.curBrandInfos = e.b(this.categoryName);
        initClickPosition();
        ArrayList<String> arrayList = this.curBrandInfos;
        if (arrayList != null && arrayList.size() != 0 && this.callbackInNavi != null) {
            if (this.brandFilterRecyclerView == null || this.mainView == null) {
                initView();
            }
            initListener();
            setAdapter();
            this.isOrientationChanged = false;
            this.isCategoryChanged = false;
            return;
        }
        destroy();
    }

    private void setLayout() {
        LinearLayout.LayoutParams layoutParams;
        this.fastSlowLayout.setVisibility(8);
        ArrayList<String> arrayList = this.curBrandInfos;
        if (arrayList != null && arrayList.size() > 0 && this.callbackInNavi != null) {
            if (this.curBrandInfos.size() <= 3) {
                View view = this.startArrowLayout;
                if (view != null && this.endArrowLayout != null) {
                    view.setVisibility(8);
                    this.endArrowLayout.setVisibility(8);
                    if (this.isFromNavi) {
                        this.brandFilterRecyclerView.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_common_cp_button_selector));
                        this.filterBrandsLayout.setBackgroundDrawable(null);
                    } else {
                        this.brandFilterRecyclerView.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.c(R.drawable.bnav_common_cp_button_selector, true));
                    }
                    this.brandFilterRecyclerView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                }
            } else {
                View view2 = this.startArrowLayout;
                if (view2 != null && this.endArrowLayout != null) {
                    view2.setVisibility(0);
                    this.endArrowLayout.setVisibility(0);
                    this.brandFilterRecyclerView.setBackgroundDrawable(null);
                    if (this.isFromNavi) {
                        if (this.orientation == 2) {
                            layoutParams = new LinearLayout.LayoutParams(ScreenUtil.getInstance().dip2px(143), -2);
                        } else {
                            layoutParams = new LinearLayout.LayoutParams(-2, ScreenUtil.getInstance().dip2px(143));
                        }
                        this.filterBrandsLayout.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_common_cp_button_selector));
                    } else {
                        layoutParams = new LinearLayout.LayoutParams(-2, ScreenUtil.getInstance().dip2px(120));
                        this.filterBrandsLayout.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.c(R.drawable.bnav_common_cp_button_selector, true));
                    }
                    this.brandFilterRecyclerView.setLayoutParams(layoutParams);
                }
            }
            this.brandFilterRecyclerView.scrollToPosition(this.clickPosition);
            return;
        }
        destroy();
    }

    public boolean getIsTrueCurDay(boolean z) {
        BNRouteNearbySearchFilterRecyclerAdapter bNRouteNearbySearchFilterRecyclerAdapter = this.brandFilterRecyclerAdapter;
        if (bNRouteNearbySearchFilterRecyclerAdapter != null) {
            return bNRouteNearbySearchFilterRecyclerAdapter.getIsTrueCurDay(z);
        }
        return false;
    }

    public View getMainView() {
        return this.mainView;
    }

    public void setCategoryName(String str) {
        if (this.categoryName != str) {
            this.categoryName = str;
            this.isCategoryChanged = true;
        }
        setData();
        setLayout();
    }

    public void setEnabled(boolean z) {
        this.isViewEnabled = z;
    }

    public void updateStyle() {
        BNRouteNearbySearchFilterRecyclerAdapter bNRouteNearbySearchFilterRecyclerAdapter;
        if (this.brandFilterRecyclerView != null && (bNRouteNearbySearchFilterRecyclerAdapter = this.brandFilterRecyclerAdapter) != null && this.startArrowView != null && this.endArrowView != null && this.filterBrandsLayout != null && this.curBrandInfos != null) {
            bNRouteNearbySearchFilterRecyclerAdapter.notifyDataSetChanged();
            if (this.orientation != 2) {
                this.startArrowView.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_nearby_search_up_arrow));
                this.endArrowView.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_nearby_search_down_arrow));
            } else {
                this.startArrowView.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_nearby_search_left_arrow));
                this.endArrowView.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_nearby_search_right_arrow));
            }
            LinearLayout linearLayout = this.filterBrandsLayout;
            int i = R.drawable.bnav_common_cp_button_selector;
            linearLayout.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(i));
            if (this.curBrandInfos.size() <= 3) {
                this.brandFilterRecyclerView.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(i));
                this.filterBrandsLayout.setBackgroundDrawable(null);
            } else {
                this.brandFilterRecyclerView.setBackgroundDrawable(null);
                this.filterBrandsLayout.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(i));
            }
        }
    }

    public void setCategoryName(String str, int i) {
        if (this.orientation != i) {
            this.orientation = i;
            this.isOrientationChanged = true;
            initView();
        }
        setCategoryName(str);
    }
}
