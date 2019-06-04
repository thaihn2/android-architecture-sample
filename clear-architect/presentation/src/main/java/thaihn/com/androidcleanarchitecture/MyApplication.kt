package thaihn.com.androidcleanarchitecture

import android.app.Application
import thaihn.com.androidcleanarchitecture.di.component.DaggerAppComponent

class MyApplication : Application() {

  override fun onCreate() {
    super.onCreate()
    DaggerAppComponent.builder()
        .application(this)
        .build()
        .inject(this)
  }
}