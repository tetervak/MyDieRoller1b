package sheridan.tetervak.mydieroller1a

import androidx.lifecycle.ViewModel
import sheridan.tetervak.mydieroller1a.model.Die

class MainViewModel : ViewModel(){
    val die: Die = Die()
}