package edu.hillel.fragmentdemo;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yuriy on 07.08.16.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        TextView tv = (TextView) view.findViewById(R.id.tvText1);
        tv.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent(getActivity(), SecondActivity.class);
            intent.putExtra("extra", 1);
            getActivity().startActivity(intent);
        } else if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            SecondFragment fr2 = (SecondFragment) getFragmentManager().findFragmentById(R.id.fgFragment2);
//            if (fr2 != null) {
//                fr2.setText("1");
//            }
            if (getActivity() instanceof MainActivity) {
                ((MainActivity)getActivity()).setSecondFragmentText("set text");
            }

        }
    }
}
