package sheridan.tetervak.mydieroller1a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG = "MainActivity"
        const val RESULT = "Result"
    }

    var dieValue : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState is Bundle){
            val savedResult : Int = savedInstanceState.getInt(RESULT)
            if(savedResult > 0){
                val result: TextView = findViewById(R.id.result)
                result.text = savedResult.toString()
                dieValue = savedResult
            }
        }

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            Log.d(TAG, "The button is clicked")
            onRoll()
        }
    }

    private fun onRoll() {
        val result: TextView = findViewById(R.id.result)
        dieValue = (1..6).random()
        result.text = dieValue.toString()
        Toast.makeText(this, getString(R.string.rolled), Toast.LENGTH_LONG).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if(dieValue > 0){
            outState.putInt(RESULT, dieValue);
        }
    }
}