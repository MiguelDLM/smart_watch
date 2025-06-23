package com.tenmeter.smlibrary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.adapter.GameListTypeSubAdapter;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.entity.SMGameListParent;
import com.tenmeter.smlibrary.utils.SMGameClient;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes13.dex */
public class GameListTypeAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<SMGameListParent> data;
    private IGameListItemClick listener;

    /* loaded from: classes13.dex */
    public interface IGameListItemClick {
        void itemClick(SMGameInfo sMGameInfo);

        void itemMoreClick(SMGameListParent sMGameListParent);
    }

    /* loaded from: classes13.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public SMGameListParent info;
        public final RecyclerView mItemList;
        public final TextView mMore;
        public final TextView mName;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
            this.mMore = (TextView) this.itemView.findViewById(R.id.tv_more);
            this.mName = (TextView) this.itemView.findViewById(R.id.tv_name);
            this.mItemList = (RecyclerView) this.itemView.findViewById(R.id.rv_item_list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            return "ViewHolder{mView=" + this.mView + ", itemId=" + this.mName + ", itemName=" + this.mItemList + '}';
        }
    }

    public GameListTypeAdapter(Context context, List<SMGameListParent> list, IGameListItemClick iGameListItemClick) {
        this.context = context;
        this.data = list;
        this.listener = iGameListItemClick;
    }

    public void clear() {
        List<SMGameListParent> list = this.data;
        if (list != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<SMGameListParent> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setData(List<SMGameListParent> list) {
        List<SMGameListParent> list2 = this.data;
        if (list2 != null) {
            list2.clear();
        }
        this.data.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        List<SMGameInfo> gameList;
        final SMGameListParent sMGameListParent = this.data.get(i);
        viewHolder.info = sMGameListParent;
        viewHolder.mMore.setText(SMGameClient.getInstance().isChina() ? "更多" : "More");
        viewHolder.mName.setText(this.data.get(i).getTagName());
        viewHolder.mItemList.setLayoutManager(new LinearLayoutManager(this.context));
        new ArrayList();
        if (sMGameListParent.getGameList() != null && sMGameListParent.getGameList().size() > 2) {
            gameList = sMGameListParent.getGameList().subList(0, 2);
        } else if (this.data == null) {
            gameList = new ArrayList<>();
        } else {
            gameList = sMGameListParent.getGameList();
        }
        viewHolder.mItemList.setHasFixedSize(true);
        viewHolder.mItemList.setNestedScrollingEnabled(false);
        viewHolder.mItemList.setAdapter(new GameListTypeSubAdapter(this.context, gameList, new GameListTypeSubAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.adapter.GameListTypeAdapter.1
            @Override // com.tenmeter.smlibrary.adapter.GameListTypeSubAdapter.IGameListItemClick
            public void itemClick(SMGameInfo sMGameInfo) {
                if (GameListTypeAdapter.this.listener != null) {
                    GameListTypeAdapter.this.listener.itemClick(sMGameInfo);
                }
            }
        }));
        viewHolder.mMore.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.adapter.GameListTypeAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GameListTypeAdapter.this.listener != null) {
                    GameListTypeAdapter.this.listener.itemMoreClick(sMGameListParent);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sm_sdk_game_list_type, viewGroup, false));
    }
}
