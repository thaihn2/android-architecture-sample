package thaihn.com.androidcleanarchitecture.screen.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import thaihn.com.androidcleanarchitecture.BR
import thaihn.com.androidcleanarchitecture.R
import thaihn.com.androidcleanarchitecture.base.BaseActivity

class MainActivity : BaseActivity() {
  override fun initVariable(savedInstanceState: Bundle?) {
  }

  override fun initData(savedInstanceState: Bundle?) {
    val binding = DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_main)
    binding.setLifecycleOwner(this)
    binding.setVariable(BR.viewModel, ViewModelProviders.of(this).get(MainViewModel::class.java))
  }

  override fun getLayoutResource(): Int {
    return R.layout.activity_main
  }

}