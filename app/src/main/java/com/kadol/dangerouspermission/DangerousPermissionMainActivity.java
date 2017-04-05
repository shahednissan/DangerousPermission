package com.kadol.dangerouspermission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DangerousPermissionMainActivity extends AppCompatActivity {

    protected static String READ_CONTACT=Manifest.permission.READ_CONTACTS;
    protected static int Granted_code=123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangerous_permission_main);

        /** Checking whether the permission was previously granted or not */
        if(ContextCompat.checkSelfPermission(getApplicationContext(), READ_CONTACT)!= PackageManager.PERMISSION_GRANTED){

            /** Asking for the permission */
            ActivityCompat.requestPermissions(this,new String[]{READ_CONTACT},Granted_code);

            Log.v("Watch me:","Asked for the permission");
        }


    }
}
