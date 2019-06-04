package thaihn.com.androidcleanarchitecture.screen.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(

) : ViewModel(){

  val text_search = MutableLiveData<String>()
  val result = MutableLiveData<String>()

  fun searchUser(input: String) {
    result.postValue(input)
  }

  fun clickSearch() {
    searchUser(text_search.value!!)
  }

}