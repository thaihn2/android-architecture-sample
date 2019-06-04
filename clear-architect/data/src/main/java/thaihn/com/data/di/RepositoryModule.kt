package thaihn.com.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import thaihn.com.data.source.local.db.AppDatabase

@Module
class RepositoryModule {

  @Provides
  @DatabaseInfo
  fun providerDatabaseName() = "userdb"

  @Provides
  @DatabaseInfo
  fun providerAppDatabase(@DatabaseInfo dbname: String, context: Context) = Room.databaseBuilder(
      context, AppDatabase::class.java, dbname)
      .allowMainThreadQueries()
      .fallbackToDestructiveMigration()
      .build()
}