package sheridan.tetervak.mydieroller1a

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sheridan.tetervak.mydieroller1a.model.Die

class MainViewModel : ViewModel(){

    private val die: Die = Die()
    private val _dieValue: MutableLiveData<Int> = MutableLiveData<Int>(die.value)

    val dieValue: LiveData<Int> = _dieValue

    fun roll(){
        viewModelScope.launch(Dispatchers.IO) {
            die.roll()
            _dieValue.postValue(die.value)
        }
    }
}