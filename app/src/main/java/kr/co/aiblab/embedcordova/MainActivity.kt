package kr.co.aiblab.embedcordova

import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.annotation.Nullable
import androidx.navigation.fragment.NavHostFragment
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import org.apache.cordova.CordovaExtActivity

class MainActivity : CordovaExtActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        initLogger()
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null)
            setNavHostFragment(R.navigation.main_navigation)
    }

    @Suppress("SameParameterValue")
    private fun setNavHostFragment(@NavigationRes navGraphId: Int) {
        val hostFragment = NavHostFragment.create(navGraphId)
        supportFragmentManager.beginTransaction()
            .replace(fragmentContainerId, hostFragment)
            .setPrimaryNavigationFragment(hostFragment)
            .commitNow()
    }

    private fun initLogger() {
        Logger.clearLogAdapters()
        Logger.addLogAdapter(object : AndroidLogAdapter(
            PrettyFormatStrategy.newBuilder().tag("AIB_CORDOVA").build()
        ) {
            override fun isLoggable(priority: Int, @Nullable tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }
}