package com.kadol.dangerouspermission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DangerousPermissionMainActivity extends AppCompatActivity {

    protected static String READ_CONTACT=Manifest.permission.READ_CONTACTS;
    //protected static int GRANTED_CODE=123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangerous_permission_main);

        /** Checking whether the permission was previously granted or not */
        if(ContextCompat.checkSelfPermission(getApplicationContext(), READ_CONTACT)!= PackageManager.PERMISSION_GRANTED){

            /** Asking for the permission */
            ActivityCompat.requestPermissions(this,new String[]{READ_CONTACT},123);

            Log.v("Watch me:","Asked for the permission");
        } else {
            Log.v("Watch me:","The permission is already given");
        }
    }

    /** This following method will check what will happen based on User's behavior */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){

            case 123:{
                //if request is cancelled, then the result array will be empty
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){

                    //permission is granted Yahoo!!!!!!!!!!
                    Log.v("Watch me:","Your are in the granted permission activity");


                }
                else{
                    //permission is denied
                    Log.v("Watch me:","Your are in the granted Denied activity");
                }
                return;
            }

        }
    }

}
