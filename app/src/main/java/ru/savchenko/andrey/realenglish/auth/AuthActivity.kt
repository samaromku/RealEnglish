package ru.savchenko.andrey.realenglish.auth

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import ru.savchenko.andrey.realenglish.R
import ru.savchenko.andrey.realenglish.main.MainActivity

/**
 * Created by Andrey on 26.11.2017.
 */
class AuthActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        val cls = MainActivity::class
        val intent = Intent(this, cls.java)
        btnLogin.setOnClickListener({startActivity(intent)})
    }
}