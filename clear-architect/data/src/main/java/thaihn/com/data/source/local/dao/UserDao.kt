package thaihn.com.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Single
import thaihn.com.data.entity.UserEntity

@Dao
interface UserDao {

  @Query("SELECT * FROM users")
  fun getAllUsers(): List<UserEntity>

  @Query("SELECT * FROM users WHERE id = :id")
  fun getUser(id: Int): Single<UserEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(userEntity: UserEntity)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertAll(entities: List<UserEntity>)

  @Query("DELETE FROM users")
  fun deleteAll()
}
