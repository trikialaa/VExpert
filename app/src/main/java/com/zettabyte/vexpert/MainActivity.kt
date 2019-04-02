package com.zettabyte.vexpert
import android.app.Activity
import android.content.Context
import android.content.Intent
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseApp
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity() {
    var login:String=""
    lateinit var fbAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        FirebaseApp.initializeApp(this)
        fbAuth = FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button.setOnClickListener({

            login=username.text.toString()
            loginWithFirebase(username.text.toString(),password.text.toString())});

    }
    fun loginWithFirebase(username:String,password:String){
        fbAuth.createUserWithEmailAndPassword(username+"@auth.com", password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }

                // ...
            }
        var mintenet= Intent(this,MenuActivity::class.java)
        mintenet.putExtra("login", login)
        startActivity(mintenet)

    }
}
