package sheridan.tetervak.mydieroller1a

import androidx.lifecycle.ViewModel
import sheridan.tetervak.mydieroller1a.model.Die

class MainViewModel : ViewModel(){

    private val die: Die = Die()

    val dieValue: Int
    get() = die.value

    fun roll(){
        die.roll()
    }
}