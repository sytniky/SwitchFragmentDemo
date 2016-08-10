package edu.hillel.fragmentdemo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yuriy on 07.08.16.
 */
public class SecondFragment extends Fragment {

    private int number;
    private TextView tv;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        number = activity.getIntent().getIntExtra("extra", 0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.second_fragment, container, false);
        tv = (TextView) view.findViewById(R.id.tvText2);
        tv.setText(String.valueOf(number));
        return view;
    }

    public void setText(String txt) {
        tv.setText(txt);
    }
}
