package thaihn.com.data.source.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import thaihn.com.data.entity.UserEntity

interface UserApi {

  // TODO fix me
  @GET("users/{id}")
  fun getUser(@Path("id") userId: Int): Single<UserEntity>
}