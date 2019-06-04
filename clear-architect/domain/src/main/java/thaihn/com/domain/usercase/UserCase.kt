package thaihn.com.domain.usercase

abstract class UserCase<in Param, out T> where T : Any {
  abstract fun createObservable(params: Param? = null): T
}
