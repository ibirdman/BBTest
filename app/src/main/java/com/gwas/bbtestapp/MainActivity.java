package com.gwas.bbtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageInstaller;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.gwas.motioncapture.IMotionCapture;
import com.gwas.motioncapture.IMotionCaptureCallback;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate()");

/*        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay();  //为获取屏幕宽、高
        WindowManager.LayoutParams p = getWindow().getAttributes();  //获取对话框当前的参数值
        p.height = WindowManager.LayoutParams.MATCH_PARENT;
        p.width = WindowManager.LayoutParams.MATCH_PARENT;
        p.alpha = 1.0f;      //设置本身透明度
        p.dimAmount = 0.5f;      //设置窗口外黑暗度
        getWindow().setAttributes(p);*/
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d(TAG, "onConfigurationChanged()");

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d(TAG, "现在是横屏");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d(TAG, "现在是竖屏");
        }
    }

    public void onButton1Click(View v) {
        Intent intent = new Intent();
        intent.setClassName("com.gwas.bbtestapp", "com.gwas.bbtestapp.Test1Activity");
        startActivity(intent);


/*        Uri packageUri = Uri.parse("package:" + "com.gwas.bbtestapp");
        Intent intent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE, packageUri);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, 1);

        String testUri1 = DownloadManager.COLUMN_URI;
        String testUri2 = DownloadManager.COLUMN_STATUS;*/

/*        Intent intent = new Intent();
        intent.setClassName("com.gwas.tvcamera", "com.gwas.tvcamera.CameraActivity");
        intent.putExtra("targetMode", "video");
        startActivity(intent);*/

//        try {
//            Uri uri = Uri.parse("content://media/external/images/media/108");
//            Intent intent = new Intent("com.android.camera.action.REVIEW", uri);
//            //intent.putExtra("from_camera", true);
//            this.startActivity(intent);
//        } catch (ActivityNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    public void onButton2Click(View v) {
        Intent intent = new Intent();
        intent.setClassName("com.gwas.bbtestapp", "com.gwas.screenrecord.ScreenRecordActivity");
        startActivity(intent);


/*        try {
            if (mService != null){
                mService.unregister(mCallbackStub);
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        unbindService(mServiceConn);*/

/*        Intent intent = new Intent();
        intent.setClassName("com.gwas.motioncapture","com.gwas.motioncapture.service.MotionCaptureService");
        stopService(intent);*/
    }

    public void onButton3Click(View v) {
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this); //2.设置属性
        b.setTitle("提示");
        b.setMessage("Have you seen it?");
        b.setNegativeButton("确定", null);
        b.setPositiveButton("取消", null);
        b.create();
        b.show();
    }

    public void onButton4Click(View v) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    class CallbackStub extends IMotionCaptureCallback.Stub {
        @Override
        public void onGestureDetected(int gestureType) throws RemoteException {
            Log.d(TAG, "onGestureDetected: type: " + gestureType);
        }
    }

    public void onExitClick(View v) {
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause()");
    }


    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

//        outState.putInt("page", 50);

        Log.d(TAG, "onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

//        int page = savedInstanceState.getInt("page");
//        Log.d(TAG, "onRestoreInstanceState() page: " + page);

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.d(TAG, "event: " + event.toString());

        return super.dispatchKeyEvent(event);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.d(TAG, "onWindowFocusChanged: hasFocus:" + hasFocus);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0,0);
    }
}
