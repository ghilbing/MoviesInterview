package com.example.codepath.moviesinterview.base;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by gretel on 2/28/18.
 */

public class BaseActivity extends AppCompatActivity {
    protected String TAG_LOG = this.getClass().getCanonicalName();

    @Override
    public void setContentView(@LayoutRes int layoutResID){
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }
}
