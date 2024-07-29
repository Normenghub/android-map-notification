package campus.tech.kakao.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import campus.tech.kakao.map.R
import campus.tech.kakao.map.databinding.ActivitySplashScreenBinding
import campus.tech.kakao.viewmodel.SplashViewModel

class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.navigateToMain.observe(this, Observer { shouldNavigate ->
            if (shouldNavigate) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        })
    }
}