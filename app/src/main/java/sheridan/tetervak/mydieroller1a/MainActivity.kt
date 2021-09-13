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
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            Log.d(TAG, "The button is clicked")
            onRoll()
        }
    }

    private fun onRoll() {
        val result: TextView = findViewById(R.id.result)
        val rand: Int = (1..6).random()
        result.text = rand.toString()
        Toast.makeText(this, getString(R.string.rolled), Toast.LENGTH_LONG).show()
    }
}