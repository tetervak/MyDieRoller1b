package sheridan.tetervak.mydieroller1a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import sheridan.tetervak.mydieroller1a.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG = "MainActivity"
        const val RESULT = "Result"
    }

    private var dieValue : Int = 0

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState is Bundle){
            val savedResult : Int = savedInstanceState.getInt(RESULT)
            if(savedResult > 0){
                binding.result.text = savedResult.toString()
                dieValue = savedResult
            }
        }

        binding.rollButton.setOnClickListener {
            Log.d(TAG, "The button is clicked")
            onRoll()
        }
    }

    private fun onRoll() {
        dieValue = (1..6).random()
        binding.result.text = dieValue.toString()
        Toast.makeText(this, getString(R.string.rolled), Toast.LENGTH_LONG).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if(dieValue > 0){
            outState.putInt(RESULT, dieValue)
        }
    }
}