package thaihn.com.domain.usercase.user

import io.reactivex.Single
import thaihn.com.domain.model.User
import thaihn.com.domain.repository.UserRepository
import thaihn.com.domain.usercase.UserCase
import javax.inject.Inject

open class FindUserUserCase @Inject constructor(
    private val userRepository: UserRepository
) : UserCase<FindUserUserCase.Params?, Single<User>>() {

  override fun createObservable(params: Params?): Single<User> {
    return userRepository.getUser(params!!.userId, params!!.fromServer)
  }

  data class Params(val userId: Int, val fromServer: Boolean)
}