package com.baidu.mapclient.liteapp.routeresult;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.szabh.navi.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class PreferItemsAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final String TAG = "BNPreferItemsAdapter";
    public static int numColumns = 3;
    private Context context;
    private ClickPreferListener mClickPreferListener;
    private int mCurrentPreferValue = 1;
    private List<RouteSortModel> routeSortList;

    /* loaded from: classes7.dex */
    public interface ClickPreferListener {
        void onClickPrefer(int i);
    }

    /* loaded from: classes7.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        View mHorizontalDivider;
        TextView mItemName;
        View mVerticalDivider;

        public ViewHolder(View view) {
            super(view);
            this.mItemName = (TextView) view.findViewById(R.id.nsdk_route_sort_item_tv);
            this.mVerticalDivider = view.findViewById(R.id.nsdk_route_sort_item_divider_vertical);
            this.mHorizontalDivider = view.findViewById(R.id.nsdk_route_sort_item_divider_bottom);
        }
    }

    public PreferItemsAdapter(Context context, ArrayList<RouteSortModel> arrayList) {
        this.context = context;
        this.routeSortList = arrayList;
    }

    private int getColor(int i) {
        return this.context.getResources().getColor(i);
    }

    private Drawable getDrawable(int i) {
        return this.context.getResources().getDrawable(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<RouteSortModel> list = this.routeSortList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void onDestroy() {
        this.mClickPreferListener = null;
        this.context = null;
    }

    public void setClickPreferListener(ClickPreferListener clickPreferListener) {
        this.mClickPreferListener = clickPreferListener;
    }

    public void updatePrefer(int i) {
        this.mCurrentPreferValue = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        RouteSortModel routeSortModel;
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mapclient.liteapp.routeresult.PreferItemsAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition;
                RouteSortModel routeSortModel2;
                if (view != null && PreferItemsAdapter.this.routeSortList != null && (adapterPosition = viewHolder.getAdapterPosition()) >= 0 && (routeSortModel2 = (RouteSortModel) PreferItemsAdapter.this.routeSortList.get(adapterPosition)) != null) {
                    PreferItemsAdapter.this.mCurrentPreferValue = routeSortModel2.mPreferValue;
                    if (PreferItemsAdapter.this.mClickPreferListener != null) {
                        PreferItemsAdapter.this.mClickPreferListener.onClickPrefer(routeSortModel2.mPreferValue);
                    }
                }
            }
        });
        if ((i + 1) % numColumns == 0) {
            viewHolder.mVerticalDivider.setVisibility(4);
        } else {
            viewHolder.mVerticalDivider.setVisibility(0);
        }
        if (i >= numColumns) {
            viewHolder.mHorizontalDivider.setVisibility(4);
        } else {
            viewHolder.mHorizontalDivider.setVisibility(0);
        }
        View view = viewHolder.mVerticalDivider;
        int i2 = R.color.nsdk_cl_bg_d_mm;
        view.setBackgroundColor(getColor(i2));
        viewHolder.mHorizontalDivider.setBackgroundColor(getColor(i2));
        viewHolder.itemView.setBackgroundDrawable(getDrawable(R.drawable.bnav_bt_pressed_bg));
        List<RouteSortModel> list = this.routeSortList;
        if (list != null && i >= 0 && i < list.size() && (routeSortModel = this.routeSortList.get(i)) != null) {
            viewHolder.mItemName.setText(routeSortModel.mItemName);
            if ((routeSortModel.mPreferValue & this.mCurrentPreferValue) != 0) {
                viewHolder.mItemName.setTextColor(getColor(R.color.nsdk_route_sort_setting_default));
                viewHolder.mItemName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getDrawable(routeSortModel.getPreferIconId(true)), (Drawable) null, (Drawable) null);
            } else {
                viewHolder.mItemName.setTextColor(getColor(R.color.nsdk_route_sort_item_text));
                viewHolder.mItemName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getDrawable(routeSortModel.getPreferIconId(false)), (Drawable) null, (Drawable) null);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item_prefer, (ViewGroup) null));
    }
}
