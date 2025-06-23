package com.tenmeter.smlibrary.adapter;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
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
import com.garmin.fit.X0xOO;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.utils.DisplayUtil;
import com.tenmeter.smlibrary.utils.ExecutorUtil;
import com.tenmeter.smlibrary.utils.SGlideRequestListener;
import java.util.List;

/* loaded from: classes13.dex */
public class HotListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<SMGameInfo> data;
    private IGameListItemClick listener;
    private int type;

    /* loaded from: classes13.dex */
    public interface IGameListItemClick {
        void itemClick(SMGameInfo sMGameInfo);
    }

    /* loaded from: classes13.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public SMGameInfo info;
        public final ImageView mBg;
        public final ImageView mBgAm;
        public final TextView mTitle;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
            this.mTitle = (TextView) this.itemView.findViewById(R.id.tv_title);
            this.mBg = (ImageView) this.itemView.findViewById(R.id.iv_bg);
            this.mBgAm = (ImageView) this.itemView.findViewById(R.id.iv_bg_animation);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            return "ViewHolder{mView=" + this.mView + ", mTitle=" + this.mTitle + ", mBg=" + this.mBg + ", mBgAm=" + this.mBgAm + '}';
        }
    }

    public HotListAdapter(Context context, List<SMGameInfo> list, IGameListItemClick iGameListItemClick, int i) {
        this.context = context;
        this.data = list;
        this.listener = iGameListItemClick;
        this.type = i;
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
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final SMGameInfo sMGameInfo = this.data.get(i);
        viewHolder.info = sMGameInfo;
        viewHolder.mTitle.setText(sMGameInfo.getGname());
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.itemView.getLayoutParams();
        if (i == 0) {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = DisplayUtil.dp2px(0.0f);
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = DisplayUtil.dp2px(5.0f);
        }
        if (i == getItemCount() - 1) {
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = DisplayUtil.dp2px(22.0f);
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = DisplayUtil.dp2px(0.0f);
        }
        viewHolder.itemView.setLayoutParams(layoutParams);
        RequestBuilder<Drawable> load = Glide.with(this.context).load(sMGameInfo.getBackground() + "?x-oss-process=image/resize,m_fill,h_378,w_" + X0xOO.f13580O0OOX0IIx);
        Context context = this.context;
        int i2 = R.drawable.default_game;
        load.placeholder(ContextCompat.getDrawable(context, i2)).error(ContextCompat.getDrawable(this.context, i2)).override(Integer.MIN_VALUE, Integer.MIN_VALUE).listener(new SGlideRequestListener(viewHolder.mBg, ImageView.ScaleType.CENTER_INSIDE, ImageView.ScaleType.CENTER_CROP)).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(viewHolder.mBg);
        if (this.type == 1 && i == 0) {
            viewHolder.mBgAm.setVisibility(0);
            viewHolder.mBgAm.setBackground(ContextCompat.getDrawable(this.context, R.drawable.anim_fouce));
            final Drawable background = viewHolder.mBgAm.getBackground();
            ExecutorUtil.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.adapter.HotListAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    viewHolder.mBgAm.post(new Runnable() { // from class: com.tenmeter.smlibrary.adapter.HotListAdapter.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Drawable drawable = background;
                            if (drawable instanceof AnimationDrawable) {
                                ((AnimationDrawable) drawable).start();
                            }
                        }
                    });
                }
            });
        } else {
            viewHolder.mBgAm.setVisibility(4);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.adapter.HotListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotListAdapter.this.listener != null) {
                    HotListAdapter.this.listener.itemClick(sMGameInfo);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sm_sdk_hot_game_list, viewGroup, false));
    }
}
