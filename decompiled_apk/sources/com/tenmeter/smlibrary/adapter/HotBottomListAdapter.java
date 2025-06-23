package com.tenmeter.smlibrary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.entity.SMIconListParent;
import java.util.List;

/* loaded from: classes13.dex */
public class HotBottomListAdapter extends RecyclerView.Adapter<ViewHolder> {
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
        public final TextView mName;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
            this.mName = (TextView) this.itemView.findViewById(R.id.tv_name);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            return "ViewHolder{mView=" + this.mView + ", itemId=" + this.mName + '}';
        }
    }

    public HotBottomListAdapter(Context context, List<SMIconListParent> list, IGameListItemClick iGameListItemClick) {
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
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.adapter.HotBottomListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotBottomListAdapter.this.listener != null) {
                    HotBottomListAdapter.this.listener.itemClick(sMIconListParent);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sm_sdk_hot_bottom_list, viewGroup, false));
    }
}
