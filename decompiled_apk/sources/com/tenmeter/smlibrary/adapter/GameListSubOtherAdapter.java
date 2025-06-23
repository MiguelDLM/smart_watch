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
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.utils.DisplayUtil;
import com.tenmeter.smlibrary.utils.SGlideRequestListener;
import com.tenmeter.smlibrary.utils.SMGameClient;
import java.util.List;

/* loaded from: classes13.dex */
public class GameListSubOtherAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<SMGameInfo> data;
    private IGameListItemClick listener;
    private boolean needShowBtn;

    /* loaded from: classes13.dex */
    public interface IGameListItemClick {
        void itemClick(SMGameInfo sMGameInfo);
    }

    /* loaded from: classes13.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public SMGameInfo info;
        public final ImageView mBg;
        public final TextView mLeisureStartBtn;
        public final ImageView mMask;
        public final TextView mName;
        public final TextView mNumber;
        public final TextView mNumberNext;
        public final TextView mTitle;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
            this.mName = (TextView) this.itemView.findViewById(R.id.tv_name);
            this.mTitle = (TextView) this.itemView.findViewById(R.id.tv_title);
            this.mBg = (ImageView) this.itemView.findViewById(R.id.iv_bg);
            this.mMask = (ImageView) this.itemView.findViewById(R.id.iv_mask);
            this.mLeisureStartBtn = (TextView) this.itemView.findViewById(R.id.tv_leisure_start);
            this.mNumber = (TextView) this.itemView.findViewById(R.id.tv_number);
            this.mNumberNext = (TextView) this.itemView.findViewById(R.id.tv_number_next);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            return "ViewHolder{mView=" + this.mView + ", itemId=" + this.mName + ", itemName=" + this.mBg + '}';
        }
    }

    public GameListSubOtherAdapter(Context context, List<SMGameInfo> list, IGameListItemClick iGameListItemClick) {
        this.needShowBtn = false;
        this.context = context;
        this.data = list;
        this.listener = iGameListItemClick;
    }

    public void clear() {
        List<SMGameInfo> list = this.data;
        if (list != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<SMGameInfo> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setData(List<SMGameInfo> list) {
        List<SMGameInfo> list2 = this.data;
        if (list2 != null) {
            list2.clear();
        }
        this.data.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final SMGameInfo sMGameInfo = this.data.get(i);
        viewHolder.mLeisureStartBtn.setVisibility(this.needShowBtn ? 0 : 4);
        viewHolder.mNumberNext.setText(SMGameClient.getInstance().isChina() ? "人玩过" : "people have played");
        viewHolder.mNumber.setText(String.valueOf(sMGameInfo.getPlayNum()));
        if (this.needShowBtn) {
            viewHolder.mLeisureStartBtn.setText(SMGameClient.getInstance().isChina() ? "开始" : "Start");
        } else {
            viewHolder.mLeisureStartBtn.setText("");
        }
        RequestBuilder<Drawable> load = Glide.with(this.context).load(sMGameInfo.getAngleMark());
        DiskCacheStrategy diskCacheStrategy = DiskCacheStrategy.RESOURCE;
        load.diskCacheStrategy(diskCacheStrategy).into(viewHolder.mMask);
        viewHolder.mMask.setVisibility((sMGameInfo.getAngleMark() == null || sMGameInfo.getAngleMark().length() <= 0 || "null".equals(sMGameInfo.getAngleMark())) ? 8 : 0);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.itemView.getLayoutParams();
        if (i == 0) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = DisplayUtil.dp2px(12.0f);
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = DisplayUtil.dp2px(0.0f);
        }
        viewHolder.itemView.setLayoutParams(layoutParams);
        viewHolder.info = sMGameInfo;
        viewHolder.mName.setText(this.data.get(i).getGname());
        viewHolder.mTitle.setText(this.data.get(i).getTitle());
        RequestBuilder<Drawable> load2 = Glide.with(this.context).load(sMGameInfo.getBackground());
        Context context = this.context;
        int i2 = R.drawable.default_game;
        load2.placeholder(ContextCompat.getDrawable(context, i2)).error(ContextCompat.getDrawable(this.context, i2)).override(DisplayUtil.dp2px(115.0f) * 2, DisplayUtil.dp2px(75.0f) * 2).listener(new SGlideRequestListener(viewHolder.mBg, ImageView.ScaleType.CENTER_INSIDE, ImageView.ScaleType.CENTER_CROP)).diskCacheStrategy(diskCacheStrategy).into(viewHolder.mBg);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.adapter.GameListSubOtherAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GameListSubOtherAdapter.this.listener != null) {
                    GameListSubOtherAdapter.this.listener.itemClick(sMGameInfo);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sm_sdk_game_list_sub_other, viewGroup, false));
    }

    public GameListSubOtherAdapter(Context context, List<SMGameInfo> list, IGameListItemClick iGameListItemClick, boolean z) {
        this.context = context;
        this.data = list;
        this.listener = iGameListItemClick;
        this.needShowBtn = z;
    }
}
