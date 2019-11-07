@file:Suppress("DEPRECATION")

package com.devis.squarecamerapreview

import android.content.Context
import android.content.res.Configuration
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

/**
 *
 */
@Suppress("DEPRECATION")
class CustomImagePreviewV2 : AppCompatImageView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)


    /**
     * Measure the view and its content to determine the measured width and the
     * measured height
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var height = MeasureSpec.getSize(heightMeasureSpec)
        var width = MeasureSpec.getSize(widthMeasureSpec)

        val isPortrait = resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

        if (isPortrait) {
            if (width > height * ASPECT_RATIO) {
                width = (height * ASPECT_RATIO + 0.5).toInt()
            } else {
                height = (width / ASPECT_RATIO + 0.5).toInt()
            }
        } else {
            if (height > width * ASPECT_RATIO) {
                height = (width * ASPECT_RATIO + 0.5).toInt()
            } else {
                width = (height / ASPECT_RATIO + 0.5).toInt()
            }
        }

        setMeasuredDimension(width, height)
    }

    companion object {

        val TAG: String = CustomImagePreviewV2::class.java.simpleName

        private const val ASPECT_RATIO = 3.0 / 4.0
    }


}
