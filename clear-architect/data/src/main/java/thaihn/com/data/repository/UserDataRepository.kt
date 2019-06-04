package thaihn.com.data.repository

import io.reactivex.Single
import thaihn.com.data.entity.MapperUserEntity
import thaihn.com.data.entity.UserEntity
import thaihn.com.data.source.local.db.AppDatabase
import thaihn.com.data.source.remote.UserApi
import thaihn.com.domain.model.User
import thaihn.com.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDataRepository @Inject constructor(
    private val mUserApi: UserApi,
    private val mAppDatabase: AppDatabase,
    private val mMapper: MapperUserEntity
) : UserRepository {

  override fun getUsers(fromServer: Boolean): List<User> {
    var userList = ArrayList<User>()
    if (!fromServer) {
      mAppDatabase.userDao().getAllUsers().map { userEntity ->
        userList.add(mMapper.mapToModel(userEntity))
      }
    }
    return userList
  }

  override fun getUser(id: Int, fromServer: Boolean): Single<User> = when (fromServer) {
    false -> mAppDatabase.userDao().getUser(id).map { t -> mMapper.mapToModel(t) }
    true -> mUserApi.getUser(id).map { t -> mMapper.mapToModel(t) }
  }

  override fun saveUser(user: User) {
    setData(mMapper.mapToEntity(user))
  }

  private fun setData(userEntity: UserEntity) = mAppDatabase.userDao().insert(userEntity)
}
