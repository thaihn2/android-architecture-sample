package thaihn.com.domain.repository

import io.reactivex.Single
import thaihn.com.domain.model.User

interface UserRepository : Repository {

  fun getUsers(fromServer: Boolean): List<User>

  fun getUser(id: Int, fromServer: Boolean): Single<User>

  fun saveUser(user: User)
}