package com.tenmeter.smlibrary.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.entity.SMIconListParent;
import com.tenmeter.smlibrary.utils.SGlideRequestListener;
import java.util.List;

/* loaded from: classes13.dex */
public class IconListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<SMIconListParent> data;
    private IGameListItemClick listener;

    /* loaded from: classes13.dex */
    public interface IGameListItemClick {
        void itemClick(SMIconListParent sMIconListParent);
    }

    /* loaded from: classes13.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public SMIconListParent info;
        public final ImageView mBg;
        public final TextView mName;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
            this.mName = (TextView) this.itemView.findViewById(R.id.tv_name);
            this.mBg = (ImageView) this.itemView.findViewById(R.id.iv_bg);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            return "ViewHolder{mView=" + this.mView + ", itemId=" + this.mName + ", itemName=" + this.mBg + '}';
        }
    }

    public IconListAdapter(Context context, List<SMIconListParent> list, IGameListItemClick iGameListItemClick) {
        this.context = context;
        this.data = list;
        this.listener = iGameListItemClick;
    }

    public void clear() {
        List<SMIconListParent> list = this.data;
        if (list != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<SMIconListParent> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setData(List<SMIconListParent> list) {
        List<SMIconListParent> list2 = this.data;
        if (list2 != null) {
            list2.clear();
        }
        this.data.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final SMIconListParent sMIconListParent = this.data.get(i);
        viewHolder.info = sMIconListParent;
        viewHolder.mName.setText(this.data.get(i).getIconName());
        RequestBuilder<Drawable> load = Glide.with(this.context).load(sMIconListParent.getIconUrl() + "?x-oss-process=image/resize,m_fill,h_101,w_101");
        Context context = this.context;
        int i2 = R.drawable.default_game;
        load.placeholder(ContextCompat.getDrawable(context, i2)).error(ContextCompat.getDrawable(this.context, i2)).override(Integer.MIN_VALUE, Integer.MIN_VALUE).listener(new SGlideRequestListener(viewHolder.mBg, ImageView.ScaleType.CENTER_INSIDE, ImageView.ScaleType.CENTER_CROP)).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(viewHolder.mBg);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.adapter.IconListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (IconListAdapter.this.listener != null) {
                    IconListAdapter.this.listener.itemClick(sMIconListParent);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sm_sdk_icon_list, viewGroup, false));
    }
}
