package br.com.fiap.a31scj.crud

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var user: EditText
    private lateinit var pass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.button = findViewById<Button>(R.id.btnLogin)
        this.user = findViewById<EditText>(R.id.user)
        this.pass = findViewById<EditText>(R.id.pass)

        this.button.setOnClickListener {
            if (!this@MainActivity.login()) {
                Toast.makeText(this, "Por favor, informe os dados de acesso!", Toast.LENGTH_LONG).show()
            } else {
                this@MainActivity.openView()
            }
        }
    }

    fun login (): Boolean {
        val user: String = this.user.text.toString()
        val pass: String = this.pass.text.toString()

        if (user.equals("") || pass.equals("")) {
            return false
        }

        return true
    }

    fun openView() {
        val intent = Intent(this, TelaPrincipal::class.java)
        startActivity(intent)
    }
}
