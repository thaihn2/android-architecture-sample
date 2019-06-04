package thaihn.com.androidcleanarchitecture.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import thaihn.com.androidcleanarchitecture.MyApplication
import thaihn.com.androidcleanarchitecture.di.builder.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): Builder

    fun build(): AppComponent
  }

  fun inject(application: MyApplication)
}