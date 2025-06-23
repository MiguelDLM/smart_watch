package com.bestmafen.androidbase.recycler;

import OXOo.OOXIXo;
import android.app.Activity;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.R;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.base.BaseFragment;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBaseRecyclerFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseRecyclerFragment.kt\ncom/bestmafen/androidbase/recycler/BaseRecyclerFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,35:1\n1#2:36\n*E\n"})
/* loaded from: classes8.dex */
public abstract class BaseRecyclerFragment<T> extends BaseFragment implements I0Io<T> {
    protected List<T> mList;
    protected CommonAdapter<T> mRecyclerAdapter;
    protected RecyclerView mRecyclerView;

    public final int getCount() {
        return getMList().size();
    }

    @OOXIXo
    public final List<T> getMList() {
        List<T> list = this.mList;
        if (list != null) {
            return list;
        }
        IIX0o.XOxIOxOx("mList");
        return null;
    }

    @OOXIXo
    public final CommonAdapter<T> getMRecyclerAdapter() {
        CommonAdapter<T> commonAdapter = this.mRecyclerAdapter;
        if (commonAdapter != null) {
            return commonAdapter;
        }
        IIX0o.XOxIOxOx("mRecyclerAdapter");
        return null;
    }

    @OOXIXo
    public final RecyclerView getMRecyclerView() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        IIX0o.XOxIOxOx("mRecyclerView");
        return null;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @CallSuper
    public void initView() {
        View findViewById = getMView().findViewById(R.id.recycler_view);
        IIX0o.x0XOIxOo(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        setMRecyclerView((RecyclerView) findViewById);
        setMList(initList());
        final Activity mActivity = getMActivity();
        final int itemLayoutId = itemLayoutId();
        final List<T> mList = getMList();
        CommonAdapter<T> commonAdapter = new CommonAdapter<T>(this, mActivity, itemLayoutId, mList) { // from class: com.bestmafen.androidbase.recycler.BaseRecyclerFragment$initView$1
            final /* synthetic */ BaseRecyclerFragment<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
            public void convert(@OOXIXo ViewHolder viewHolder, T t, int i) {
                IIX0o.x0xO0oo(viewHolder, "viewHolder");
                this.this$0.initItem(viewHolder, t, i);
            }

            @Override // com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.this$0.getCount();
            }
        };
        getMRecyclerView().setAdapter(commonAdapter);
        setMRecyclerAdapter(commonAdapter);
    }

    public final void setMList(@OOXIXo List<T> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mList = list;
    }

    public final void setMRecyclerAdapter(@OOXIXo CommonAdapter<T> commonAdapter) {
        IIX0o.x0xO0oo(commonAdapter, "<set-?>");
        this.mRecyclerAdapter = commonAdapter;
    }

    public final void setMRecyclerView(@OOXIXo RecyclerView recyclerView) {
        IIX0o.x0xO0oo(recyclerView, "<set-?>");
        this.mRecyclerView = recyclerView;
    }
}
