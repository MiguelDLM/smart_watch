package com.tenmeter.smlibrary.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.garmin.fit.OxXXx0X;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.entity.SMGameListBannerParent;
import com.tenmeter.smlibrary.utils.DisplayUtil;
import com.tenmeter.smlibrary.utils.SGlideRequestListener;
import com.tenmeter.smlibrary.widget.SMRoundPlayerView;
import com.tenmeter.smlibrary.widget.SMRoundedImageView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes13.dex */
public class BannerTopNewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<SMGameListBannerParent> data;
    private IGameListItemClick listener;

    /* loaded from: classes13.dex */
    public interface IGameListItemClick {
        void itemClick(SMGameListBannerParent sMGameListBannerParent);

        void muteClick(ImageView imageView, ImageView imageView2, SMGameListBannerParent sMGameListBannerParent);

        void playOrPauseClick(ImageView imageView, SMGameListBannerParent sMGameListBannerParent);
    }

    /* loaded from: classes13.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final SMRoundedImageView mBg;
        public final FrameLayout mFlPlayerContainer;
        public final ImageView mMuteBtn;
        public final TextView mName;
        public final ImageView mPlayOrPause;
        public final SMRoundPlayerView mPlayerView;
        public final TextView mSubName;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
            this.mSubName = (TextView) this.itemView.findViewById(R.id.tv_sub_title);
            this.mName = (TextView) this.itemView.findViewById(R.id.tv_title);
            this.mBg = (SMRoundedImageView) this.itemView.findViewById(R.id.iv_bg);
            this.mPlayerView = (SMRoundPlayerView) this.itemView.findViewById(R.id.videoView);
            this.mPlayOrPause = (ImageView) this.itemView.findViewById(R.id.ivPlayOrPause);
            this.mFlPlayerContainer = (FrameLayout) this.itemView.findViewById(R.id.flPlayerContainer);
            this.mMuteBtn = (ImageView) this.itemView.findViewById(R.id.ivMute);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            return "ViewHolder{mView=" + this.mView + ", itemId=" + this.mName + ", itemName=" + this.mBg + '}';
        }
    }

    public BannerTopNewAdapter(Context context, List<SMGameListBannerParent> list, IGameListItemClick iGameListItemClick) {
        ArrayList arrayList = new ArrayList();
        this.data = arrayList;
        this.context = context;
        arrayList.clear();
        if (list != null && list.size() > 0) {
            this.data.addAll(list);
        }
        this.listener = iGameListItemClick;
    }

    public void clear() {
        List<SMGameListBannerParent> list = this.data;
        if (list != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }

    public List<SMGameListBannerParent> getData() {
        return this.data;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<SMGameListBannerParent> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setData(List<SMGameListBannerParent> list) {
        List<SMGameListBannerParent> list2 = this.data;
        if (list2 != null && list2.size() > 0) {
            this.data.clear();
        }
        this.data.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final SMGameListBannerParent sMGameListBannerParent = this.data.get(i);
        int screenWidth = (int) (((DisplayUtil.getScreenWidth() - DisplayUtil.dp2px(44.0f)) / 637.0d) * 289.0d);
        viewHolder.mSubName.setText(sMGameListBannerParent.getBannerTitle());
        viewHolder.mName.setText(sMGameListBannerParent.getBannerName());
        if (sMGameListBannerParent.getBannerType() == 99) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewHolder.mFlPlayerContainer.getLayoutParams();
            layoutParams.height = screenWidth;
            viewHolder.mFlPlayerContainer.setLayoutParams(layoutParams);
            viewHolder.mBg.setVisibility(8);
            viewHolder.mFlPlayerContainer.setVisibility(0);
            if (viewHolder.mPlayerView.getPlayer() == null || (viewHolder.mPlayerView.getPlayer() != null && !viewHolder.mPlayerView.getPlayer().isPlaying())) {
                viewHolder.mPlayOrPause.setTag("play");
                viewHolder.mPlayOrPause.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.sm_play_icon));
            }
            viewHolder.mPlayOrPause.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.adapter.BannerTopNewAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BannerTopNewAdapter.this.listener != null) {
                        BannerTopNewAdapter.this.listener.playOrPauseClick(viewHolder.mPlayOrPause, sMGameListBannerParent);
                    }
                }
            });
            viewHolder.mMuteBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.adapter.BannerTopNewAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BannerTopNewAdapter.this.listener != null) {
                        IGameListItemClick iGameListItemClick = BannerTopNewAdapter.this.listener;
                        ViewHolder viewHolder2 = viewHolder;
                        iGameListItemClick.muteClick(viewHolder2.mPlayOrPause, viewHolder2.mMuteBtn, sMGameListBannerParent);
                    }
                }
            });
            viewHolder.mPlayerView.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.adapter.BannerTopNewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BannerTopNewAdapter.this.listener != null) {
                        BannerTopNewAdapter.this.listener.itemClick(sMGameListBannerParent);
                    }
                }
            });
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) viewHolder.mBg.getLayoutParams();
        layoutParams2.height = screenWidth;
        viewHolder.mBg.setLayoutParams(layoutParams2);
        viewHolder.mBg.setVisibility(0);
        viewHolder.mFlPlayerContainer.setVisibility(8);
        RequestBuilder<Drawable> load = Glide.with(this.context).load(sMGameListBannerParent.getBannerImage() + "?x-oss-process=image/resize,m_fill,h_596,w_" + OxXXx0X.f13225xI);
        Context context = this.context;
        int i2 = R.drawable.default_game;
        load.placeholder(ContextCompat.getDrawable(context, i2)).error(ContextCompat.getDrawable(this.context, i2)).override(Integer.MIN_VALUE, Integer.MIN_VALUE).listener(new SGlideRequestListener(viewHolder.mBg, ImageView.ScaleType.CENTER_INSIDE, ImageView.ScaleType.CENTER_CROP)).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(viewHolder.mBg);
        viewHolder.mBg.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.adapter.BannerTopNewAdapter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BannerTopNewAdapter.this.listener != null) {
                    BannerTopNewAdapter.this.listener.itemClick(sMGameListBannerParent);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sm_sdk_game_list_banner, viewGroup, false));
    }
}
