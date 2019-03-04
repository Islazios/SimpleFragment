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

public class View02Fragment extends Fragment {

    public static final String TAG = View02Fragment.class.getSimpleName();

    private TextView textFragmentView02;
    private Button buttonFragmentView02;
    private Bar02ClickEventListener bar02ClickEventListener;

    public void setBar02ClickEventListener(Bar02ClickEventListener bar02ClickEventListener) {
        this.bar02ClickEventListener = bar02ClickEventListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_02, container, false);

        textFragmentView02 = view.findViewById(R.id.text_fragment_view_02);
        buttonFragmentView02 = view.findViewById(R.id.button_fragment_view_02);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonFragmentView02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar02ClickEventListener.onBar02Click("BAR Press");
            }
        });
    }

    public interface Bar02ClickEventListener {

        void onBar02Click(String message);
    }
}
