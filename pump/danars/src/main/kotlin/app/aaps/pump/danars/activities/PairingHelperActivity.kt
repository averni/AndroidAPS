package app.aaps.pump.danars.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import app.aaps.core.ui.activities.TranslatedDaggerAppCompatActivity
import app.aaps.pump.danars.dialogs.PairingProgressDialog

class PairingHelperActivity : TranslatedDaggerAppCompatActivity() {

    var dialog: PairingProgressDialog? = null

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialog = PairingProgressDialog().setHelperActivity(this)
        dialog?.show(supportFragmentManager, "PairingProgress")
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onDestroy() {
        super.onDestroy()
        dialog = null
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        dialog?.resetToNewPairing()
    }

}