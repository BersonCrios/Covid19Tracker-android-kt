package br.com.bersoncrios.covid19tracker.features.splash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.bersoncrios.covid19tracker.R
import br.com.bersoncrios.covid19tracker.features.maindatas.view.ListMainDatasActivity

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 3000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        init()
    }

    private fun init() {
        Handler().postDelayed({
            startActivity(Intent(this,ListMainDatasActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}
