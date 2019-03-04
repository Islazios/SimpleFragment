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

public class View01Fragment extends Fragment {

    public static final String TAG = View01Fragment.class.getSimpleName();

    private TextView textFragmentView01;
    private Button buttonFragmentView01;
    private Foo01ClickEventListener foo01ClickEventListener;

    public void setFoo01ClickEventListener(Foo01ClickEventListener foo01ClickEventListener) {
        this.foo01ClickEventListener = foo01ClickEventListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_01, container, false);

        textFragmentView01 = view.findViewById(R.id.text_fragment_view_01);
        buttonFragmentView01 = view.findViewById(R.id.button_fragment_view_01);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonFragmentView01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                foo01ClickEventListener.onFoo01Click("FOO Press");
            }
        });
    }

    public interface Foo01ClickEventListener {

        void onFoo01Click(String message);
    }
}
