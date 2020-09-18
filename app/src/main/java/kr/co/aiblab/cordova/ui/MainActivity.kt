package kr.co.aiblab.cordova.ui

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import kr.co.aiblab.cordova.R
import org.apache.cordova.CordovaExtActivity

class MainActivity : CordovaExtActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            with(NavHostFragment.create(R.navigation.main_navigation)) {
                supportFragmentManager.beginTransaction()
                    .replace(fragmentContainerId, this)
                    .setPrimaryNavigationFragment(this)
                    .commitNow()
            }
        }
    }
}