package kr.co.aiblab.embedcordova

import android.os.Bundle
import org.apache.cordova.CordovaExtActivity

class MainActivity : CordovaExtActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(fragmentContainerId, MainFragment.newInstance())
                .commit()
        }
    }
}