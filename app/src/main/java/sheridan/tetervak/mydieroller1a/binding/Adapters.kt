package sheridan.tetervak.mydieroller1a.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import sheridan.tetervak.mydieroller1a.R

@BindingAdapter("dieValue")
fun bindDieValue(textView: TextView, dieValue: Int?){
    if(dieValue is Int && dieValue > 0){
        textView.text = dieValue.toString()
    }else{
        textView.text = textView.resources.getString(R.string.space)
    }
}