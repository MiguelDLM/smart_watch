package com.google.android.cameraview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import java.util.Arrays;
import java.util.Set;

/* loaded from: classes9.dex */
public class AspectRatioFragment extends DialogFragment {
    private static final String ARG_ASPECT_RATIOS = "aspect_ratios";
    private static final String ARG_CURRENT_ASPECT_RATIO = "current_aspect_ratio";
    private Listener mListener;

    /* loaded from: classes9.dex */
    public static class AspectRatioAdapter extends BaseAdapter {
        private final AspectRatio mCurrentRatio;
        private final AspectRatio[] mRatios;

        /* loaded from: classes9.dex */
        public static class ViewHolder {
            TextView text;

            private ViewHolder() {
            }
        }

        public AspectRatioAdapter(AspectRatio[] aspectRatioArr, AspectRatio aspectRatio) {
            this.mRatios = aspectRatioArr;
            this.mCurrentRatio = aspectRatio;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mRatios.length;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return getItem(i).hashCode();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.text = (TextView) view.findViewById(android.R.id.text1);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            AspectRatio item = getItem(i);
            StringBuilder sb = new StringBuilder(item.toString());
            if (item.equals(this.mCurrentRatio)) {
                sb.append(" *");
            }
            viewHolder.text.setText(sb);
            return view;
        }

        @Override // android.widget.Adapter
        public AspectRatio getItem(int i) {
            return this.mRatios[i];
        }
    }

    /* loaded from: classes9.dex */
    public interface Listener {
        void onAspectRatioSelected(@NonNull AspectRatio aspectRatio);
    }

    public static AspectRatioFragment newInstance(Set<AspectRatio> set, AspectRatio aspectRatio) {
        AspectRatioFragment aspectRatioFragment = new AspectRatioFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArray(ARG_ASPECT_RATIOS, (Parcelable[]) set.toArray(new AspectRatio[set.size()]));
        bundle.putParcelable(ARG_CURRENT_ASPECT_RATIO, aspectRatio);
        aspectRatioFragment.setArguments(bundle);
        return aspectRatioFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mListener = (Listener) context;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Bundle arguments = getArguments();
        final AspectRatio[] aspectRatioArr = (AspectRatio[]) arguments.getParcelableArray(ARG_ASPECT_RATIOS);
        if (aspectRatioArr != null) {
            Arrays.sort(aspectRatioArr);
            return new AlertDialog.Builder(getActivity()).setAdapter(new AspectRatioAdapter(aspectRatioArr, (AspectRatio) arguments.getParcelable(ARG_CURRENT_ASPECT_RATIO)), new DialogInterface.OnClickListener() { // from class: com.google.android.cameraview.AspectRatioFragment.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    AspectRatioFragment.this.mListener.onAspectRatioSelected(aspectRatioArr[i]);
                }
            }).create();
        }
        throw new RuntimeException("No ratios");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        this.mListener = null;
        super.onDetach();
    }
}
