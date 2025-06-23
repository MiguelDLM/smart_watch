package com.sma.smartv3.ui.device.watchface.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ResourcesIdInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nTimeElementFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeElementFragment.kt\ncom/sma/smartv3/ui/device/watchface/fragment/TimeElementFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,79:1\n1855#2,2:80\n*S KotlinDebug\n*F\n+ 1 TimeElementFragment.kt\ncom/sma/smartv3/ui/device/watchface/fragment/TimeElementFragment\n*L\n74#1:80,2\n*E\n"})
/* loaded from: classes12.dex */
public class TimeElementFragment extends BaseElementFragment {

    @OXOo.OOXIXo
    private final XO<Integer> callback;

    @OXOo.OOXIXo
    private final List<ResourcesIdInfo> colors;

    @OXOo.OOXIXo
    private final X0IIOO dialSelect0$delegate;

    @OXOo.OOXIXo
    private final X0IIOO dialSelectStatus0$delegate;
    private final boolean isRound;

    @OXOo.OOXIXo
    private final X0IIOO rv$delegate;

    public TimeElementFragment(@OXOo.OOXIXo List<ResourcesIdInfo> colors, boolean z, @OXOo.OOXIXo XO<Integer> callback) {
        IIX0o.x0xO0oo(colors, "colors");
        IIX0o.x0xO0oo(callback, "callback");
        this.colors = colors;
        this.isRound = z;
        this.callback = callback;
        this.dialSelect0$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.TimeElementFragment$dialSelect0$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final RelativeLayout invoke() {
                View mView;
                mView = TimeElementFragment.this.getMView();
                return (RelativeLayout) mView.findViewById(R.id.dialSelect0);
            }
        });
        this.dialSelectStatus0$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.TimeElementFragment$dialSelectStatus0$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final ImageView invoke() {
                View mView;
                mView = TimeElementFragment.this.getMView();
                return (ImageView) mView.findViewById(R.id.dialSelectStatus0);
            }
        });
        this.rv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.TimeElementFragment$rv$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final RecyclerView invoke() {
                View mView;
                mView = TimeElementFragment.this.getMView();
                return (RecyclerView) mView.findViewById(R.id.rv);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(TimeElementFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        View.OnClickListener mOnViewClickListener = this$0.getMOnViewClickListener();
        if (mOnViewClickListener != null) {
            mOnViewClickListener.onClick(view);
        }
    }

    @OXOo.OOXIXo
    public final XO<Integer> getCallback() {
        return this.callback;
    }

    @OXOo.OOXIXo
    public final List<ResourcesIdInfo> getColors() {
        return this.colors;
    }

    public final RelativeLayout getDialSelect0() {
        return (RelativeLayout) this.dialSelect0$delegate.getValue();
    }

    public final ImageView getDialSelectStatus0() {
        return (ImageView) this.dialSelectStatus0$delegate.getValue();
    }

    public final RecyclerView getRv() {
        return (RecyclerView) this.rv$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        if (this.isRound) {
            getDialSelect0().setBackgroundResource(R.drawable.shape_dial_control_bg);
        } else {
            getDialSelect0().setBackgroundResource(R.drawable.shape_dial_control_bg_r);
        }
        RecyclerView rv = getRv();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(0);
        rv.setLayoutManager(linearLayoutManager);
        getRv().setAdapter(new TimeElementFragment$initView$2(this, getActivity(), this.colors));
        getDialSelect0().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.watchface.fragment.OOXIXo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimeElementFragment.initView$lambda$1(TimeElementFragment.this, view);
            }
        });
    }

    public final boolean isRound() {
        return this.isRound;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.layout_watchface_time;
    }

    @Override // com.sma.smartv3.ui.device.watchface.fragment.BaseElementFragment
    public void reset() {
        RecyclerView.Adapter adapter = getRv().getAdapter();
        IIX0o.x0XOIxOo(adapter, "null cannot be cast to non-null type com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter<com.sma.smartv3.model.ResourcesIdInfo>");
        CommonAdapter commonAdapter = (CommonAdapter) adapter;
        Iterable datas = commonAdapter.getDatas();
        IIX0o.oO(datas, "getDatas(...)");
        Iterator it = datas.iterator();
        while (it.hasNext()) {
            ((ResourcesIdInfo) it.next()).setSelect(false);
        }
        commonAdapter.notifyDataSetChanged();
        getDialSelectStatus0().setVisibility(8);
    }
}
