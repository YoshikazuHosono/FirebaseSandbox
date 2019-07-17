package com.example.firebasesandbox

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignUpWithEmailActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_with_email)
        auth = FirebaseAuth.getInstance()
    }

    fun signUpWithEmailAddr(view: View) {
        val email = findViewById<EditText>(R.id.SignUpWithEmail_inputMailAddr).text.toString()
        val password = findViewById<EditText>(R.id.SignUpWithEmail_inputMailAddr).text.toString()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                findViewById<TextView>(R.id.SignUpWithEmail_statusLabel).apply {
                    text = "ユーザー作成成功"
                }
            } else {
                findViewById<TextView>(R.id.SignUpWithEmail_statusLabel).apply {
                    text = "ユーザー作成失敗:${task.result.toString()}"
                }
            }
        }
    }
}
