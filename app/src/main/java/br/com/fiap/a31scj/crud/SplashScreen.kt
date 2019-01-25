package br.com.fiap.a31scj.crud

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.content.Intent
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class SplashScreen : AppCompatActivity() {
    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        this.image = findViewById<ImageView>(R.id.imageView2)
        Glide
            .with(this)
            .load(R.drawable.megaman)
            .into(this.image)

        Handler().postDelayed(Runnable { this@SplashScreen.mostrarMainActivity() }, 3000)
    }

    private fun mostrarMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
