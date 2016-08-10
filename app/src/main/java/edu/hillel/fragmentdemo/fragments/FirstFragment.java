package edu.hillel.fragmentdemo.fragments;

import android.app.Activity;
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
public class FirstFragment extends Fragment implements View.OnClickListener {

    public interface FirstFragmentListener {
        void onFirstFragmentInteraction(int i);
    }

    private FirstFragmentListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (FirstFragmentListener) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        TextView tv = (TextView) view.findViewById(R.id.tvText1);
        tv.setOnClickListener(this);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return view;
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            mListener.onFirstFragmentInteraction(7777777);
        }
    }
}
