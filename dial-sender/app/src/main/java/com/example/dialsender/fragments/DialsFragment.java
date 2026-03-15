package com.example.dialsender.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dialsender.DialEditorActivity;
import com.example.dialsender.DialLibraryActivity;
import com.example.dialsender.R;

public class DialsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dials, container, false);

        RecyclerView grid = view.findViewById(R.id.dialsGrid);
        grid.setLayoutManager(new GridLayoutManager(requireContext(), 3));

        view.findViewById(R.id.btnCreateDial).setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), DialEditorActivity.class);
            startActivity(intent);
        });

        view.findViewById(R.id.tabMyDials).setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), DialLibraryActivity.class);
            startActivity(intent);
        });

        view.findViewById(R.id.tabPresets).setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), DialLibraryActivity.class);
            intent.putExtra("tab", "presets");
            startActivity(intent);
        });

        return view;
    }
}
