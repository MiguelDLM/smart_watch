package com.baidu.mapclient.liteapp.routeresult;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.adapter.struct.BNRouteDetail;
import com.szabh.navi.R;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class RouteResultAdapter extends RecyclerView.Adapter<BNHolder> {
    private ArrayList<BNRouteDetail> mRouteDetails;

    /* loaded from: classes7.dex */
    public static class BNHolder extends RecyclerView.ViewHolder {
        public final ImageView icon;
        public final TextView title;

        public BNHolder(View view) {
            super(view);
            this.icon = (ImageView) view.findViewById(R.id.iv_icon);
            this.title = (TextView) view.findViewById(R.id.tv_title);
        }
    }

    public RouteResultAdapter(ArrayList<BNRouteDetail> arrayList) {
        this.mRouteDetails = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mRouteDetails.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BNHolder bNHolder, int i) {
        bNHolder.icon.setImageResource(this.mRouteDetails.get(i).getIconId());
        bNHolder.title.setText(this.mRouteDetails.get(i).getDescription());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BNHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new BNHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_route_detail, viewGroup, false));
    }
}
