package com.bombo.simplefragment.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bombo.simplefragment.R;

public class View04Fragment extends Fragment {

    private TextView textFragmentView04;
    private Button buttonFragmentView04;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_04, container, false);

        textFragmentView04 = view.findViewById(R.id.text_fragment_view_04);
        buttonFragmentView04 = view.findViewById(R.id.button_fragment_view_04);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonFragmentView04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "COLD", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
