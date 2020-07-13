package kr.co.aiblab.embedcordova

import android.os.Bundle
import android.view.View
import org.apache.cordova.CordovaExtFragment

class MainFragment : CordovaExtFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadUrl(launchUrl)
    }
}