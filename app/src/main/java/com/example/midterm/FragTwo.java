package com.example.midterm;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragTwo extends Fragment {

    private static final String PARAM2 = "param1";
    private String receivedValue;

    public static FragTwo newInstance(String param1) {
        FragTwo fragment = new FragTwo();
        Bundle args = new Bundle();
        args.putString(PARAM2, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            receivedValue = getArguments().getString(PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        TextView textView = view.findViewById(R.id.home);
        if (receivedValue != null) {
            textView.setText(receivedValue);
        }
        return view;
    }
}
