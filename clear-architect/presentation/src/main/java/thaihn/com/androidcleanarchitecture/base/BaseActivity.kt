package thaihn.com.androidcleanarchitecture.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import thaihn.com.androidcleanarchitecture.databinding.ActivityMainBinding

abstract class BaseActivity : AppCompatActivity() {

  abstract fun getLayoutResource(): Int

  abstract fun initVariable(savedInstanceState: Bundle?)

  abstract fun initData(savedInstanceState: Bundle?)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(getLayoutResource())
    initVariable(savedInstanceState)
    initData(savedInstanceState)
  }
}