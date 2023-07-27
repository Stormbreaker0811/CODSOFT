package com.codsoft.flashlighttask;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleFlashlight;
    private boolean isFlashlightOn = false;
    private CameraManager cameraManager;
    private String cameraId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleFlashlight = findViewById(R.id.toggleFlashlight);
        toggleFlashlight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    turnFlashlightOn();
                } else{
                    turnFlashlightOff();
                }
            }
        });
    }

    private void turnFlashlightOff() {
        cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
        try{
            cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
            isFlashlightOn = false;
            Toast.makeText(this, "Flashlight is off!!", Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            Toast.makeText(this, "Failed To turn off Flashlight.", Toast.LENGTH_SHORT).show();
            Log.e("Flashlight Error", e.toString());
        }
    }

    private void turnFlashlightOn() {
        cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
        try{
            cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
            isFlashlightOn = true;
            Toast.makeText(this, "Flashlight is on!!", Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            Toast.makeText(this, "Failed To turn on Flashlight.", Toast.LENGTH_SHORT).show();
            Log.e("Flashlight Error", e.toString());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isFlashlightOn){
            turnFlashlightOff();
        }
    }
}