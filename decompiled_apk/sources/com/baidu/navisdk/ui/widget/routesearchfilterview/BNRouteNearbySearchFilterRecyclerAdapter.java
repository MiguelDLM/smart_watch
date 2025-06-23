package com.baidu.navisdk.ui.widget.routesearchfilterview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class BNRouteNearbySearchFilterRecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<String> brandInfos;
    private Context context;
    private int curColor;
    private boolean isFromNavi;
    private OnClickListener itemClickListener;
    private int orientation;
    private static final int normalTextColor = R.color.nsdk_cl_text_a;
    private static final int clickTextColor = R.color.nsdk_cl_text_g;
    private int clickPosition = -1;
    private boolean mIsCurDay = true;

    /* loaded from: classes8.dex */
    public interface OnClickListener {
        void onItemClick(int i);
    }

    /* loaded from: classes8.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private View brandSplitView;
        private TextView brandText;
        private View itemView;

        public ViewHolder(View view) {
            super(view);
            this.itemView = view;
            this.brandText = (TextView) view.findViewById(R.id.route_search_filter_brand_button);
            this.brandSplitView = view.findViewById(R.id.route_search_filter_brand_split_line);
        }
    }

    public BNRouteNearbySearchFilterRecyclerAdapter(Context context, ArrayList<String> arrayList, int i, OnClickListener onClickListener, boolean z) {
        this.context = context;
        this.brandInfos = arrayList;
        this.orientation = i;
        this.itemClickListener = onClickListener;
        this.isFromNavi = z;
    }

    public boolean getIsTrueCurDay(boolean z) {
        boolean z2;
        if (this.curColor == 0) {
            return false;
        }
        if (JarUtils.getResources() != null) {
            if (this.curColor != JarUtils.getResources().getColor(normalTextColor) && this.curColor != JarUtils.getResources().getColor(clickTextColor)) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.mIsCurDay = z2;
        }
        if (z != this.mIsCurDay) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<String> arrayList = this.brandInfos;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public void setBrandInfos(ArrayList<String> arrayList) {
        this.brandInfos = arrayList;
    }

    public void setClickPosition(int i) {
        this.clickPosition = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        FrameLayout.LayoutParams layoutParams;
        if (this.brandInfos.get(i).length() > 3) {
            layoutParams = (FrameLayout.LayoutParams) viewHolder.brandText.getLayoutParams();
            layoutParams.width = ScreenUtil.getInstance().dip2px(28);
        } else {
            layoutParams = (FrameLayout.LayoutParams) viewHolder.brandText.getLayoutParams();
            layoutParams.width = ScreenUtil.getInstance().dip2px(38);
        }
        viewHolder.brandText.setLayoutParams(layoutParams);
        viewHolder.brandText.setText(this.brandInfos.get(i));
        if (i == this.clickPosition) {
            if (this.isFromNavi) {
                viewHolder.brandText.setTextColor(b.b(clickTextColor));
            } else {
                viewHolder.brandText.setTextColor(b.a(clickTextColor, true));
            }
        } else if (this.isFromNavi) {
            viewHolder.brandText.setTextColor(b.b(normalTextColor));
        } else {
            viewHolder.brandText.setTextColor(b.a(normalTextColor, true));
        }
        if (this.isFromNavi) {
            viewHolder.brandSplitView.setBackgroundColor(b.b(R.color.nsdk_cl_bg_b));
        } else {
            viewHolder.brandSplitView.setBackgroundColor(b.a(R.color.nsdk_cl_bg_b, true));
        }
        this.curColor = viewHolder.brandText.getCurrentTextColor();
        if (i == this.brandInfos.size() - 1) {
            viewHolder.brandSplitView.setVisibility(8);
        } else {
            viewHolder.brandSplitView.setVisibility(0);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.routesearchfilterview.BNRouteNearbySearchFilterRecyclerAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BNRouteNearbySearchFilterRecyclerAdapter.this.itemClickListener.onItemClick(i);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate;
        if (this.isFromNavi) {
            if (this.orientation == 2) {
                inflate = JarUtils.inflate(this.context, R.layout.nsdk_layout_route_search_filter_brand_in_navi_recycler_item_land, null);
            } else {
                inflate = JarUtils.inflate(this.context, R.layout.nsdk_layout_route_search_filter_brand_in_navi_recycler_item, null);
            }
        } else {
            inflate = JarUtils.inflate(this.context, R.layout.nsdk_layout_route_search_filter_brand_in_route_recycler_item, null);
        }
        return new ViewHolder(inflate);
    }
}
