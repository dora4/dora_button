package dora.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDisable = findViewById<DoraButton>(R.id.btnDisable)
        val btnLogin = findViewById<DoraButton>(R.id.btnLogin)
        val btnConfirm = findViewById<DoraButton>(R.id.btnConfirm)
        btnDisable.setOnClickListener {
            Toast.makeText(this@MainActivity, "disable", Toast.LENGTH_SHORT).show()
        }
        btnLogin.setOnClickListener {
            Toast.makeText(this@MainActivity, "login", Toast.LENGTH_SHORT).show()
        }
        btnConfirm.setOnClickListener {
            Toast.makeText(this@MainActivity, "confirm", Toast.LENGTH_SHORT).show()
        }
    }
}