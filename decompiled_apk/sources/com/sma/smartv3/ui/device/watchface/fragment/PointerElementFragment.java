package com.sma.smartv3.ui.device.watchface.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
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

@XX({"SMAP\nPointerElementFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PointerElementFragment.kt\ncom/sma/smartv3/ui/device/watchface/fragment/PointerElementFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,120:1\n1855#2,2:121\n1855#2,2:123\n*S KotlinDebug\n*F\n+ 1 PointerElementFragment.kt\ncom/sma/smartv3/ui/device/watchface/fragment/PointerElementFragment\n*L\n111#1:121,2\n116#1:123,2\n*E\n"})
/* loaded from: classes12.dex */
public final class PointerElementFragment extends BaseElementFragment {

    @OXOo.OOXIXo
    private final II0XooXoX<Integer> callback;
    private final boolean isRound;

    @OXOo.OOXIXo
    private final List<ResourcesIdInfo> pointers;

    @OXOo.OOXIXo
    private final X0IIOO rvPointer$delegate;

    @OXOo.OOXIXo
    private final X0IIOO rvScale$delegate;

    @OXOo.OOXIXo
    private final List<ResourcesIdInfo> scales;

    public PointerElementFragment(@OXOo.OOXIXo List<ResourcesIdInfo> pointers, @OXOo.OOXIXo List<ResourcesIdInfo> scales, boolean z, @OXOo.OOXIXo II0XooXoX<Integer> callback) {
        IIX0o.x0xO0oo(pointers, "pointers");
        IIX0o.x0xO0oo(scales, "scales");
        IIX0o.x0xO0oo(callback, "callback");
        this.pointers = pointers;
        this.scales = scales;
        this.isRound = z;
        this.callback = callback;
        this.rvPointer$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.PointerElementFragment$rvPointer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final RecyclerView invoke() {
                View mView;
                mView = PointerElementFragment.this.getMView();
                return (RecyclerView) mView.findViewById(R.id.rvPointer);
            }
        });
        this.rvScale$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.PointerElementFragment$rvScale$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final RecyclerView invoke() {
                View mView;
                mView = PointerElementFragment.this.getMView();
                return (RecyclerView) mView.findViewById(R.id.rvScale);
            }
        });
    }

    private final RecyclerView getRvPointer() {
        return (RecyclerView) this.rvPointer$delegate.getValue();
    }

    private final RecyclerView getRvScale() {
        return (RecyclerView) this.rvScale$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final II0XooXoX<Integer> getCallback() {
        return this.callback;
    }

    @OXOo.OOXIXo
    public final List<ResourcesIdInfo> getPointers() {
        return this.pointers;
    }

    @OXOo.OOXIXo
    public final List<ResourcesIdInfo> getScales() {
        return this.scales;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        RecyclerView rvPointer = getRvPointer();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(0);
        rvPointer.setLayoutManager(linearLayoutManager);
        RecyclerView rvScale = getRvScale();
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        linearLayoutManager2.setOrientation(0);
        rvScale.setLayoutManager(linearLayoutManager2);
        RecyclerView rvPointer2 = getRvPointer();
        FragmentActivity activity = getActivity();
        boolean z = this.isRound;
        int i2 = R.layout.item_watchface_pointer_select_r;
        if (z) {
            i = R.layout.item_watchface_pointer_select;
        } else {
            i = R.layout.item_watchface_pointer_select_r;
        }
        rvPointer2.setAdapter(new PointerElementFragment$initView$3(this, activity, i, this.pointers));
        RecyclerView rvScale2 = getRvScale();
        FragmentActivity activity2 = getActivity();
        if (this.isRound) {
            i2 = R.layout.item_watchface_pointer_select;
        }
        rvScale2.setAdapter(new PointerElementFragment$initView$4(this, activity2, i2, this.scales));
    }

    public final boolean isRound() {
        return this.isRound;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.layout_watchface_pointer;
    }

    @Override // com.sma.smartv3.ui.device.watchface.fragment.BaseElementFragment
    public void reset() {
        RecyclerView.Adapter adapter = getRvPointer().getAdapter();
        IIX0o.x0XOIxOo(adapter, "null cannot be cast to non-null type com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter<com.sma.smartv3.model.ResourcesIdInfo>");
        CommonAdapter commonAdapter = (CommonAdapter) adapter;
        Iterable datas = commonAdapter.getDatas();
        IIX0o.oO(datas, "getDatas(...)");
        Iterator it = datas.iterator();
        while (it.hasNext()) {
            ((ResourcesIdInfo) it.next()).setSelect(false);
        }
        commonAdapter.notifyDataSetChanged();
        RecyclerView.Adapter adapter2 = getRvScale().getAdapter();
        IIX0o.x0XOIxOo(adapter2, "null cannot be cast to non-null type com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter<com.sma.smartv3.model.ResourcesIdInfo>");
        CommonAdapter commonAdapter2 = (CommonAdapter) adapter2;
        Iterable datas2 = commonAdapter2.getDatas();
        IIX0o.oO(datas2, "getDatas(...)");
        Iterator it2 = datas2.iterator();
        while (it2.hasNext()) {
            ((ResourcesIdInfo) it2.next()).setSelect(false);
        }
        commonAdapter2.notifyDataSetChanged();
    }
}
