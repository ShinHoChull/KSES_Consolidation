package com.m2comm.kses2019s_con.views;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.m2comm.kses2019s_con.R;
import com.m2comm.kses2019s_con.databinding.ActivityMainBinding;
import com.m2comm.kses2019s_con.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainViewModel mvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        this.binding.setMain(this);
        this.mvm = new MainViewModel(this.binding , this , this);
        this.permissionDemand();
        this.mvm.tokenRegister();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.mvm.tokenRegister();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);
    }

    public void permissionDemand () {
        int permission1 = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR);
        int permission2 = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(permission1 == PackageManager.PERMISSION_DENIED || permission2 == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_CALENDAR,Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

}