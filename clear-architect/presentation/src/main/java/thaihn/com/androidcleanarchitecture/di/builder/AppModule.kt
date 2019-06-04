package thaihn.com.androidcleanarchitecture.di.builder

import android.content.Context
import dagger.Module
import dagger.Provides
import thaihn.com.androidcleanarchitecture.MyApplication
import thaihn.com.data.di.RepositoryModule
import javax.inject.Singleton

@Module(includes = arrayOf(RepositoryModule::class))
class AppModule {

  @Provides
  @Singleton
  fun providerContext(app: MyApplication): Context = app
}
