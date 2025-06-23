package com.tenmeter.smlibrary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.adapter.GameListTypeSubAdapter;
import com.tenmeter.smlibrary.banner.adapter.BannerAdapter;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import java.util.List;

/* loaded from: classes13.dex */
public class GameLeisureListBannerAdapter extends BannerAdapter<List<SMGameInfo>, ViewHolder> {
    private Context context;
    private IGameListItemClick listener;

    /* loaded from: classes13.dex */
    public interface IGameListItemClick {
        void itemClick(SMGameInfo sMGameInfo);
    }

    /* loaded from: classes13.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final RecyclerView gameRv;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
            this.gameRv = (RecyclerView) this.itemView.findViewById(R.id.rv_leisure);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            return "ViewHolder{mView=" + this.mView + '}';
        }
    }

    public GameLeisureListBannerAdapter(Context context, IGameListItemClick iGameListItemClick, List<List<SMGameInfo>> list) {
        super(list);
        this.context = context;
        this.listener = iGameListItemClick;
    }

    @Override // com.tenmeter.smlibrary.banner.holder.IViewHolder
    public void onBindView(ViewHolder viewHolder, List<SMGameInfo> list, int i, int i2) {
        viewHolder.gameRv.setLayoutManager(new LinearLayoutManager(this.context));
        viewHolder.gameRv.setAdapter(new GameListTypeSubAdapter(this.context, list, new GameListTypeSubAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.adapter.GameLeisureListBannerAdapter.1
            @Override // com.tenmeter.smlibrary.adapter.GameListTypeSubAdapter.IGameListItemClick
            public void itemClick(SMGameInfo sMGameInfo) {
                if (GameLeisureListBannerAdapter.this.listener != null) {
                    GameLeisureListBannerAdapter.this.listener.itemClick(sMGameInfo);
                }
            }
        }, true));
    }

    @Override // com.tenmeter.smlibrary.banner.holder.IViewHolder
    public ViewHolder onCreateHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sm_sdk_leisure_game_list_banner, viewGroup, false);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new ViewHolder(inflate);
    }
}
