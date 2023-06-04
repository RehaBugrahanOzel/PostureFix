package com.bugraoppa.posturefix

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.SurfaceTexture
import android.hardware.camera2.CameraCaptureSession
import android.hardware.camera2.CameraDevice
import android.hardware.camera2.CameraManager
import android.hardware.camera2.CaptureRequest
import android.os.*
import android.view.Surface
import android.view.TextureView
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread


lateinit var exerciseName: String
lateinit var rtspService: RTSP_Service
lateinit var textureView: TextureView
class CameraActivity : AppCompatActivity() {
    lateinit var capReq: CaptureRequest.Builder
    lateinit var handler: Handler
    lateinit var handlerThread: HandlerThread
    lateinit var cameraManager: CameraManager
    lateinit var cameraCaptureSession: CameraCaptureSession
    lateinit var cameraDevice: CameraDevice
    lateinit var captureRequest: CaptureRequest
    lateinit var capture : Button
    lateinit var timerText : TextView
    lateinit var timerText2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        timerText = findViewById(R.id.timerText)
        timerText2 = findViewById(R.id.timerText2)
        rtspService = RTSP_Service(this)



        textureView = findViewById(R.id.textureView)
        capture = findViewById(R.id.capture)
        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        handlerThread = HandlerThread("videoThread")
        handlerThread.start()
        exerciseName = intent.getStringExtra("exercise").toString()
        handler = Handler((handlerThread).looper)
        thread {
            Thread.sleep(5000)
            StartExercise().execute()
            println("exercise started going back")

        }
        capture.setOnClickListener {
            thread {
                FinishExercise().execute()
                println("exercise finished going back")
                finish()
            }
        }




        textureView.surfaceTextureListener = object: TextureView.SurfaceTextureListener{
            override fun onSurfaceTextureAvailable(p0: SurfaceTexture, p1: Int, p2: Int) {
                //openCamera()
                rtspService.stream(textureView);
            }

            override fun onSurfaceTextureSizeChanged(p0: SurfaceTexture, p1: Int, p2: Int) {

            }

            override fun onSurfaceTextureDestroyed(p0: SurfaceTexture): Boolean {
                return false
            }

            override fun onSurfaceTextureUpdated(p0: SurfaceTexture) {

            }
        }
    }

    override fun onStart() {
        super.onStart()
        val timer1 = object: CountDownTimer(6000, 1000) {
            override fun onTick(millisUntilFinished1: Long) {
                timerText2.text = (millisUntilFinished1 / 1000).toString()
            }

            override fun onFinish() {
                timerText2.visibility = View.GONE
                val timer2 = object: CountDownTimer(30000, 1000) {
                    override fun onTick(millisUntilFinished2: Long) {
                        timerText.text = (millisUntilFinished2 / 1000).toString()
                    }

                    override fun onFinish() {
                        thread {
                            FinishExercise().execute()
                            println("exercise finished going back")
                            finish()
                        }
                    }
                }
                timer2.start()
            }
        }
        timer1.start()

    }
    class FinishExercise() : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg params: Void?): String? {
            val url = URL("http://192.168.1.12:5000/stop")
            var response_code: String = ""
            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"  // optional default is GET

                println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")
                response_code = "$responseCode"
                inputStream.bufferedReader().use {
                    it.lines().forEach { line ->
                        println(line)
                    }
                }
            }
            return "basarili"
        }

        override fun onPreExecute() {
            super.onPreExecute()
            // ...
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
        }
    }

    class StartExercise() : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg params: Void?): String? {
            val url = URL("http://192.168.1.12:5000/analyze/$exerciseName")
            //val url = URL("http://www.google.com/")
            var response_code: String = ""
            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"  // optional default is GET

                println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")
                response_code = "$responseCode"
                inputStream.bufferedReader().use {
                    it.lines().forEach { line ->
                        println(line)
                    }
                }
            }
            return "basarili"
        }

        override fun onPreExecute() {
            super.onPreExecute()
            // ...
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
        }
    }
    @SuppressLint("MissingPermission")
    fun openCamera() {
        cameraManager.openCamera(cameraManager.cameraIdList[1], object: CameraDevice.StateCallback(){
            override fun onOpened(p0: CameraDevice) {
                cameraDevice = p0
                capReq = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW)
                var surface = Surface(textureView.surfaceTexture)
                capReq.addTarget(surface)
                cameraDevice.createCaptureSession(listOf(surface), object: CameraCaptureSession.StateCallback(){
                    override fun onConfigured(p0: CameraCaptureSession) {
                        cameraCaptureSession = p0
                        cameraCaptureSession.setRepeatingRequest(capReq.build(), null, null)
                    }

                    override fun onConfigureFailed(p0: CameraCaptureSession) {

                    }
                }, handler)
            }

            override fun onDisconnected(p0: CameraDevice) {

            }

            override fun onError(p0: CameraDevice, p1: Int) {

            }
        }, handler)
    }
}