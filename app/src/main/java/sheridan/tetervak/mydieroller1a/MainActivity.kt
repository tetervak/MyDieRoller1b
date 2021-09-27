package sheridan.tetervak.mydieroller1a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import sheridan.tetervak.mydieroller1a.databinding.ActivityMainBinding
import sheridan.tetervak.mydieroller1a.model.Die

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG = "MainActivity"
        const val RESULT = "Result"
    }

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(viewModel.dieValue > 0){
            binding.result.text = viewModel.dieValue.toString()
        }

        binding.rollButton.setOnClickListener {
            Log.d(TAG, "The button is clicked")
            onRoll()
        }
    }

    private fun onRoll() {
        viewModel.roll()
        binding.result.text = viewModel.dieValue.toString()
        Toast.makeText(this, getString(R.string.rolled), Toast.LENGTH_LONG).show()
    }

}