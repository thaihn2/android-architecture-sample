package thaihn.com.androidcleanarchitecture.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<N> : ViewModel() {

  var navigator: N? = null
  var compositeDisposable: CompositeDisposable? = null

  init {
    compositeDisposable = CompositeDisposable()
  }

  override fun onCleared() {
    compositeDisposable!!.dispose()
    super.onCleared()
  }
}