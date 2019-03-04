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

import com.bombo.simplefragment.R;

public class View03Fragment extends Fragment {

    public static final String TAG = View03Fragment.class.getSimpleName();

    private TextView textFragmentView03;
    private Button buttonFragmentView03;
    private Hot03ClickEventListener hot03ClickEventListener;

    public void setHot03ClickEventListener(Hot03ClickEventListener hot03ClickEventListener) {
        this.hot03ClickEventListener = hot03ClickEventListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_03, container, false);

        textFragmentView03 = view.findViewById(R.id.text_fragment_view_03);
        buttonFragmentView03 = view.findViewById(R.id.button_fragment_view_03);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonFragmentView03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hot03ClickEventListener.onHot03Click("HOT Press");
            }
        });
    }

    public interface Hot03ClickEventListener {

        void onHot03Click(String message);
    }
}
