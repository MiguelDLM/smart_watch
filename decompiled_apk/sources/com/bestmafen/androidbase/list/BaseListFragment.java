package com.bestmafen.androidbase.list;

import OXOo.OOXIXo;
import android.app.Activity;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.CallSuper;
import com.bestmafen.androidbase.R;
import com.bestmafen.androidbase.base.BaseFragment;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBaseListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseListFragment.kt\ncom/bestmafen/androidbase/list/BaseListFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,35:1\n1#2:36\n*E\n"})
/* loaded from: classes8.dex */
public abstract class BaseListFragment<T> extends BaseFragment implements I0Io<T> {
    protected List<T> mList;
    protected XIOOI.oIX0oI<T> mListAdapter;
    protected ListView mListView;

    /* loaded from: classes8.dex */
    public static final class oIX0oI extends XIOOI.oIX0oI<T> {

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ BaseListFragment<T> f10339Oxx0xo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public oIX0oI(BaseListFragment<T> baseListFragment, Activity activity, int i, List<T> list) {
            super(activity, i, list);
            this.f10339Oxx0xo = baseListFragment;
        }

        @Override // XIOOI.oIX0oI, XIOOI.II0xO0
        public void II0xO0(@OOXIXo XIOOI.I0Io viewHolder, T t, int i) {
            IIX0o.x0xO0oo(viewHolder, "viewHolder");
            this.f10339Oxx0xo.initItem(viewHolder, t, i);
        }

        @Override // XIOOI.II0xO0, android.widget.Adapter
        public int getCount() {
            return this.f10339Oxx0xo.getItemCount();
        }
    }

    public final int getItemCount() {
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
    public final XIOOI.oIX0oI<T> getMListAdapter() {
        XIOOI.oIX0oI<T> oix0oi = this.mListAdapter;
        if (oix0oi != null) {
            return oix0oi;
        }
        IIX0o.XOxIOxOx("mListAdapter");
        return null;
    }

    @OOXIXo
    public final ListView getMListView() {
        ListView listView = this.mListView;
        if (listView != null) {
            return listView;
        }
        IIX0o.XOxIOxOx("mListView");
        return null;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @CallSuper
    public void initView() {
        View findViewById = getMView().findViewById(R.id.list_view);
        IIX0o.x0XOIxOo(findViewById, "null cannot be cast to non-null type android.widget.ListView");
        setMListView((ListView) findViewById);
        setMList(initList());
        oIX0oI oix0oi = new oIX0oI(this, getMActivity(), itemLayoutId(), getMList());
        getMListView().setAdapter((ListAdapter) oix0oi);
        setMListAdapter(oix0oi);
    }

    public final void setMList(@OOXIXo List<T> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mList = list;
    }

    public final void setMListAdapter(@OOXIXo XIOOI.oIX0oI<T> oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<set-?>");
        this.mListAdapter = oix0oi;
    }

    public final void setMListView(@OOXIXo ListView listView) {
        IIX0o.x0xO0oo(listView, "<set-?>");
        this.mListView = listView;
    }
}
