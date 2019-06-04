package thaihn.com.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import thaihn.com.data.entity.UserEntity
import thaihn.com.data.source.local.dao.UserDao

@Database(entities = arrayOf(UserEntity::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
  abstract fun userDao(): UserDao
}