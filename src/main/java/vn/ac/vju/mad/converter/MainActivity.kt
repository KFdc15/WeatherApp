package vn.ac.vju.mad.converter



import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtYen = findViewById<EditText>(R.id.edtYen)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        val exchangeRate = 170.5

        btnConvert.setOnClickListener {
            val yenInput = edtYen.text.toString()
            if (yenInput.isNotEmpty()) {
                val yen = yenInput.toDouble()
                val vnd = yen * exchangeRate
                txtResult.text = "Output: %.2f VND".format(vnd)
            } else {
                txtResult.text = "Enter JPY"
            }
        }
    }
}