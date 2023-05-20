package com.example.posturefix;

import android.app.Activity;
import android.view.SurfaceView;
import android.view.TextureView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.pedro.rtplibrary.rtsp.RtspCamera1;
import com.pedro.rtsp.utils.ConnectCheckerRtsp;

public class RTSP_Service implements ConnectCheckerRtsp {

    private final Activity activity;
    private RtspCamera1 rtspCamera1;


    public RTSP_Service(Activity activity){
        this.activity = activity;
    }

    public void stream(TextureView openGlView) {
        //default

        //create builder
        //by default TCP protocol.
         rtspCamera1 = new RtspCamera1(openGlView, this);
        //start stream
        if (rtspCamera1.prepareVideo()) {
            rtspCamera1.startStream("rtsp://192.168.1.8:8554/mystream");
        } else {
            /**This device cant init encoders, this could be for 2 reasons: The encoder selected doesnt support any configuration setted or
             * your device hasnt a H264 or AAC encoder (in this case you can see log error valid encoder not found)*/
        }
        //stop stream
        //rtspCamera1.stopStream();

    }

    @Override
    public void onAuthErrorRtsp() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, "Auth error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onAuthSuccessRtsp() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, "Auth success", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onConnectionFailedRtsp(@NonNull String reason) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (rtspCamera1.reTry(5000, reason, null)) {
                    Toast.makeText(activity, "Retry", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Toast.makeText(activity, "Connection failed. " + reason, Toast.LENGTH_SHORT)
                            .show();
                    rtspCamera1.stopStream();
                }
            }
            });

    }

    @Override
    public void onConnectionStartedRtsp(@NonNull String s) {

    }

    @Override
    public void onConnectionSuccessRtsp() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity,"Connection Success",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onDisconnectRtsp() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, "Disconnected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onNewBitrateRtsp(long l) {

    }
}
