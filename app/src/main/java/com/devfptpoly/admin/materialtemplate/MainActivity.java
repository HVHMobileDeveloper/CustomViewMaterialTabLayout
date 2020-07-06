package com.devfptpoly.admin.materialtemplate;

import android.util.Log;

import androidx.databinding.DataBindingUtil;


import com.devfptpoly.admin.materialtemplate.Dagger2.DaggerMagicBox;
import com.devfptpoly.admin.materialtemplate.Dagger2.Infor;
import com.devfptpoly.admin.materialtemplate.databinding.ActivityMainBinding;

import javax.inject.Inject;


public class MainActivity extends BaseActivity {

    private ActivityMainBinding mainBinding;

    /**
     * Declare the Class with @Inject
     * On below init method, you must be call [Dagger + your class name].create().[abstract method mapping].
     * =)) That's it, really simple to use.
     */
    @Inject
    Infor infor;

    @Override
    protected void onBindingView() {
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void onHandleView() {
        DaggerMagicBox.create().poke(MainActivity.this);

        Log.e("Simple Dagger2", infor.getText());
    }

}