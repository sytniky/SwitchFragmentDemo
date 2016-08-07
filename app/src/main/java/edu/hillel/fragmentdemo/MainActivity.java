package edu.hillel.fragmentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SecondFragment fr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fr2 = (SecondFragment) getFragmentManager().findFragmentById(R.id.fgFragment2);
    }

    public void setSecondFragmentText(String txt) {
        if (fr2 != null) {
            fr2.setText(txt);
        }
    }
}
