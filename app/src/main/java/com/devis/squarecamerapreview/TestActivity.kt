package com.devis.squarecamerapreview

import android.content.res.Configuration
import android.hardware.Camera
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_test_camera.*

/**
 * Created by devis on 2019-11-06
 */

class TestActivity : AppCompatActivity() {

    var camera: Camera? = null
    private lateinit var frameLayout: FrameLayout
    private lateinit var showCamera: CameraPreview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_camera)
    }

    override fun onResume() {
        super.onResume()
        val preview = CameraPreview(this, 0, CameraPreview.LayoutMode.FitToParent)
        val previewLayoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        camera_preview_view.addView(preview, 0, previewLayoutParams)

    }

    override fun onPause() {
        super.onPause()
    }

    private fun switchOnCamera(): Camera {
        var cameraObject: Camera? = null
        cameraObject = Camera.open()

        val parameters: Camera.Parameters = cameraObject.parameters

        if (resources.configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) {
            parameters.set("orientation", "portrait")
            cameraObject.setDisplayOrientation(90)
            parameters.setRotation(90)
        } else {
            parameters.set("orientation", "landscape")
            cameraObject.setDisplayOrientation(0)
            parameters.setRotation(0)
        }

        return cameraObject
    }

}