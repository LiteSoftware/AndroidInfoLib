package com.udfsoft.androidinfo.lib.command.display

import android.content.Context
import android.content.res.Configuration
import android.graphics.Rect
import android.os.Build
import android.util.DisplayMetrics
import android.util.Size
import android.view.Display
import android.view.WindowInsets
import android.view.WindowManager
import androidx.annotation.RequiresApi
import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.entity.DisplayInformation

class GetDisplayInformationCommand(val context: Context) :
    CommandInterface<Unit, DisplayInformation> {

    override fun invoke(param: Unit): DisplayInformation {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

        val display = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            context.display
        } else {
            windowManager.defaultDisplay
        }

        val displayId = display?.displayId
        val appVsyncOffsetNanos = display?.appVsyncOffsetNanos
        val displayName = display?.name
        val rotation = display?.rotation

        val isHdr = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            display?.isHdr
        } else {
            false
        }

        val screenRefreshRate = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            display?.mode?.refreshRate
        } else {
            null
        }

        val screenSize = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getScreenSize(windowManager)
        } else {
            getScreenSizeOld(display)
        }

        val screenSizeCategory = getScreenSizeCategory()

        return DisplayInformation(
            screenSize,
            screenSizeCategory,
            rotation,
            isHdr,
            screenRefreshRate,
            displayId,
            displayName,
            appVsyncOffsetNanos
        )
    }


    private fun getScreenSizeOld(display: Display?): Size {
        val metrics = DisplayMetrics()
        display?.getMetrics(metrics)
        val width = metrics.widthPixels
        val height = metrics.heightPixels
        return Size(width, height)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun getScreenSize(windowManager: WindowManager): Size {
        val metrics = windowManager.currentWindowMetrics
        val windowInsets: WindowInsets = metrics.windowInsets
        val insets = windowInsets.getInsetsIgnoringVisibility(
            WindowInsets.Type.navigationBars() or WindowInsets.Type.displayCutout()
        )

        val insetsWidth: Int = insets.right + insets.left
        val insetsHeight: Int = insets.top + insets.bottom

        val bounds: Rect = metrics.bounds
        return Size(
            bounds.width() - insetsWidth, bounds.height() - insetsHeight
        )
    }

    private fun getScreenSizeCategory(): String {
        val screenSize =
            context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK
        return when (screenSize) {
            Configuration.SCREENLAYOUT_SIZE_LARGE -> "Large screen"
            Configuration.SCREENLAYOUT_SIZE_NORMAL -> "Normal screen"
            Configuration.SCREENLAYOUT_SIZE_SMALL -> "Small screen"
            else -> "Screen size is neither large, normal or small"
        }
    }
}