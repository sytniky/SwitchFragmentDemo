package edu.hillel.fragmentdemo.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.hillel.fragmentdemo.R;

/**
 * Created by yuriy on 07.08.16.
 */
public class SecondFragment extends Fragment {

    public static String ARG_1 = "arg1";
    private int mNumber;
    private TextView tv;

    public static SecondFragment getNewInstance(int value) {
        SecondFragment fr2 = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_1, value);
        fr2.setArguments(args);
        return fr2;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mNumber = args.getInt(ARG_1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.second_fragment, container, false);
        tv = (TextView) view.findViewById(R.id.tvText2);
        tv.setText(String.valueOf(mNumber));
        return view;
    }

    public void setText(String txt) {
        tv.setText(txt);
    }
}
