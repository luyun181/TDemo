package com.demo.www.tdemo;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kcode.permissionslib.main.OnRequestPermissionsCallBack;
import com.kcode.permissionslib.main.PermissionCompat;

public class ZxActivity extends AppCompatActivity {
    private Button btn;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zx);
        context = this;
        btn= (Button) findViewById(R.id.btn_sc);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PermissionCompat.Builder builder = new PermissionCompat.Builder(context);
                builder.addPermissions(new String[]{Manifest.permission.CAMERA});
                builder.addPermissionRationale("say why need the permission");
                builder.addRequestPermissionsCallBack(new OnRequestPermissionsCallBack() {
                    @Override
                    public void onGrant() {
                        //do something
                       /* IntentIntegrator integrator = new IntentIntegrator(ZxActivity.this);
// 设置要扫描的条码类型，ONE_D_CODE_TYPES：一维码，QR_CODE_TYPES-二维码
                        integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
                        integrator.setPrompt("扫描条形码");
                        integrator.setCameraId(0);  // 使用默认的相机
                        integrator.setBeepEnabled(true); // 扫到码后播放提示音
//                integrator.setBarcodeImageEnabled(true);
                        integrator.initiateScan();*/
                       onScanQR();
                    }

                    @Override
                    public void onDenied(String permission) {
                        Log.e("xxx", permission + "Denied");
                        Toast.makeText(context,"请进入设置打开权限",Toast.LENGTH_LONG).show();
                    }
                });
                builder.build().request();

            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       /* IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        QRCodeManager.getInstance().with(this).onActivityResult(requestCode, resultCode, data);
        *//*if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "扫码取消！", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "扫描成功，条码值: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }*/
    }
    public void onScanQR() {
       /* QRCodeManager.getInstance()
                .with(this)
                .setReqeustType(1)//可以不设置，默认是0
                .scanningQRCode(new OnQRCodeScanCallback() {
                    @Override
                    public void onCompleted(String result) {//扫描成功之后回调，result就是扫描的结果
//                        controlLog.append("\n\n(结果)" + result);
                        Toast.makeText(context,result,Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Throwable errorMsg) {//扫描出错的时候回调
//                        controlLog.append("\n\n(错误)" + errorMsg.toString());
                        Toast.makeText(context,errorMsg.toString(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancel() {//取消扫描的时候回调
//                        controlLog.append("\n\n(取消)扫描任务取消了");
                        Toast.makeText(context,"\n\n(取消)扫描任务取消了",Toast.LENGTH_LONG).show();
                    }
                });*/
    }
}
