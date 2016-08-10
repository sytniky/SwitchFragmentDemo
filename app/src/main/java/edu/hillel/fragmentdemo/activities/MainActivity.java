package edu.hillel.fragmentdemo.activities;

import android.app.FragmentManager;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import edu.hillel.fragmentdemo.R;
import edu.hillel.fragmentdemo.fragments.FirstFragment;
import edu.hillel.fragmentdemo.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity implements FirstFragment.FirstFragmentListener {

    SecondFragment fr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fr2 = (SecondFragment) getFragmentManager().findFragmentById(R.id.fgFragment2);
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction()
                .add(R.id.flFragmentContainer, new FirstFragment(), "FirstFragment")
                .commit();
    }

    @Override
    public void onFirstFragmentInteraction(int i) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//            Intent intent = new Intent(this, SecondActivity.class);
//            intent.putExtra("extra", 1);
//            startActivity(intent);

//            SecondFragment fr2 = new SecondFragment();
//
//            Bundle args = new Bundle();
//            args.putInt("arg", i);
//            fr2.setArguments(args);

            SecondFragment fr2 = SecondFragment.getNewInstance(i);

            getFragmentManager().beginTransaction()
                    .replace(R.id.flFragmentContainer, fr2, "SecondFragment")
                    .addToBackStack("FirstFragment")
                    .commit();

        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (fr2 != null) {
                fr2.setText(String.valueOf(i));
            }
        }
    }
}
