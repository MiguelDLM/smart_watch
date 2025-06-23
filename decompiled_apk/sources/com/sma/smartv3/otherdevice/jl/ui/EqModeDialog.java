package com.sma.smartv3.otherdevice.jl.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter;
import com.jieli.jl_rcsp.model.device.EqInfo;
import com.jieli.jl_rcsp.model.device.EqPresetInfo;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.otherdevice.jl.adapter.EqModeAdapter;
import com.sma.smartv3.otherdevice.jl.ui.EqModeDialog;
import com.sma.smartv3.otherdevice.jl.view.CommonDecoration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes12.dex */
public class EqModeDialog extends DialogFragment {
    private EqInfo mEqInfo;
    private II0xO0 mOnSelectedChange;

    /* loaded from: classes12.dex */
    public interface II0xO0 {
        void oIX0oI(EqInfo eqInfo);
    }

    /* loaded from: classes12.dex */
    public class oIX0oI implements MultiItemTypeAdapter.I0Io {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ EqModeAdapter f21091oIX0oI;

        public oIX0oI(final EqModeAdapter val$eqModeAdapter) {
            this.f21091oIX0oI = val$eqModeAdapter;
        }

        @Override // com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter.I0Io
        public boolean II0xO0(View view, RecyclerView.ViewHolder holder, int position) {
            return false;
        }

        @Override // com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter.I0Io
        public void oIX0oI(View view, RecyclerView.ViewHolder holder, int position) {
            this.f21091oIX0oI.select(position);
            EqModeDialog.this.dismiss();
            if (EqModeDialog.this.getActivity() != null && EqModeDialog.this.mOnSelectedChange != null) {
                EqInfo copy = this.f21091oIX0oI.getDatas().get(position).copy();
                if (copy.getMode() == 6) {
                    byte[] bArr = new byte[copy.getCount()];
                    Arrays.fill(bArr, Byte.MAX_VALUE);
                    copy.setValue(bArr);
                }
                EqModeDialog.this.mOnSelectedChange.oIX0oI(copy);
            }
        }
    }

    private List<EqInfo> getData() {
        EqPresetInfo OOXIXo2 = oo00.oIX0oI.OOXIXo();
        if (OOXIXo2 == null) {
            return new ArrayList();
        }
        return OOXIXo2.getEqInfos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        dismiss();
    }

    public static EqModeDialog newInstance(II0xO0 onSelectedChange) {
        EqModeDialog eqModeDialog = new EqModeDialog();
        eqModeDialog.setArguments(new Bundle());
        eqModeDialog.mOnSelectedChange = onSelectedChange;
        return eqModeDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window = requireDialog().getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.horizontalMargin = 0.0f;
            window.setAttributes(attributes);
        }
        View inflate = inflater.inflate(R.layout.dialog_eq_mode_dialog, container, false);
        EqModeAdapter eqModeAdapter = new EqModeAdapter(getContext(), getData());
        EqInfo Oxx0IOOO2 = oo00.oIX0oI.Oxx0IOOO();
        this.mEqInfo = Oxx0IOOO2;
        eqModeAdapter.select(Oxx0IOOO2.getMode());
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_eq_mode);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(eqModeAdapter);
        recyclerView.addItemDecoration(new CommonDecoration(requireContext(), 1, requireContext().getResources().getColor(R.color.gray_eeeeee), 1));
        eqModeAdapter.setOnItemClickListener(new oIX0oI(eqModeAdapter));
        inflate.findViewById(R.id.tv_eq_mode_cancel).setOnClickListener(new View.OnClickListener() { // from class: oX0ooo0I0.oIX0oI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EqModeDialog.this.lambda$onCreateView$0(view);
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
            window.setBackgroundDrawable(null);
        }
    }
}
