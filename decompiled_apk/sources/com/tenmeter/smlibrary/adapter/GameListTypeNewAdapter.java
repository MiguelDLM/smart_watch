package com.tenmeter.smlibrary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.adapter.GameLeisureListBannerAdapter;
import com.tenmeter.smlibrary.banner.Banner;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.entity.SMGameListParent;
import com.tenmeter.smlibrary.utils.SMGameClient;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes13.dex */
public class GameListTypeNewAdapter extends RecyclerView.Adapter<ViewHolder> {
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
        public final Banner mItemList;
        public final TextView mMore;
        public final TextView mName;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
            this.mMore = (TextView) this.itemView.findViewById(R.id.tv_more);
            this.mName = (TextView) this.itemView.findViewById(R.id.tv_name);
            this.mItemList = (Banner) this.itemView.findViewById(R.id.leisure_game_banner);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            return "ViewHolder{mView=" + this.mView + ", itemId=" + this.mName + ", itemName=" + this.mItemList + '}';
        }
    }

    public GameListTypeNewAdapter(Context context, List<SMGameListParent> list, IGameListItemClick iGameListItemClick) {
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
        final SMGameListParent sMGameListParent = this.data.get(i);
        viewHolder.info = sMGameListParent;
        viewHolder.mMore.setText(SMGameClient.getInstance().isChina() ? "更多" : "More");
        viewHolder.mName.setText(this.data.get(i).getTagName());
        new ArrayList();
        if (sMGameListParent.getGameList() != null && sMGameListParent.getGameList().size() > 2) {
            sMGameListParent.getGameList().subList(0, 2);
        } else if (this.data == null) {
            new ArrayList();
        } else {
            sMGameListParent.getGameList();
        }
        ArrayList arrayList = new ArrayList();
        if (sMGameListParent.getGameList().size() > 9) {
            arrayList.add(sMGameListParent.getGameList().subList(0, 3));
            arrayList.add(sMGameListParent.getGameList().subList(3, 6));
            arrayList.add(sMGameListParent.getGameList().subList(6, 9));
        } else if (sMGameListParent.getGameList().size() > 3) {
            if (sMGameListParent.getGameList().size() > 6) {
                arrayList.add(sMGameListParent.getGameList().subList(0, 3));
                arrayList.add(sMGameListParent.getGameList().subList(3, 6));
                arrayList.add(sMGameListParent.getGameList().subList(6, sMGameListParent.getGameList().size()));
            } else {
                arrayList.add(sMGameListParent.getGameList().subList(0, 3));
                arrayList.add(sMGameListParent.getGameList().subList(3, sMGameListParent.getGameList().size()));
            }
        } else {
            arrayList.add(sMGameListParent.getGameList());
        }
        viewHolder.mItemList.setAdapter(new GameLeisureListBannerAdapter(this.context, new GameLeisureListBannerAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.adapter.GameListTypeNewAdapter.1
            @Override // com.tenmeter.smlibrary.adapter.GameLeisureListBannerAdapter.IGameListItemClick
            public void itemClick(SMGameInfo sMGameInfo) {
                if (GameListTypeNewAdapter.this.listener != null) {
                    GameListTypeNewAdapter.this.listener.itemClick(sMGameInfo);
                }
            }
        }, arrayList)).setBannerGalleryEffect(4, 23, 0, 1.0f);
        viewHolder.mMore.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.adapter.GameListTypeNewAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GameListTypeNewAdapter.this.listener != null) {
                    GameListTypeNewAdapter.this.listener.itemMoreClick(sMGameListParent);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sm_sdk_game_list_type_new, viewGroup, false));
    }
}
