package kr.co.aiblab.cordova

import android.app.Application
import androidx.annotation.Nullable
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

class CordovaApp : Application() {

    override fun onCreate() {
        initLogger()
        super.onCreate()
    }

    companion object {
        private fun initLogger() {
            Logger.clearLogAdapters()
            Logger.addLogAdapter(object : AndroidLogAdapter(
                PrettyFormatStrategy.newBuilder().tag(BuildConfig.LOG_TAG).build()
            ) {
                override fun isLoggable(priority: Int, @Nullable tag: String?): Boolean {
                    return BuildConfig.DEBUG
                }
            })
        }
    }
}