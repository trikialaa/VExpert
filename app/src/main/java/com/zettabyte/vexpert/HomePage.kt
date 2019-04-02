package com.zettabyte.vexpert
import android.app.Activity
import android.os.Bundle
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class HomePage: Activity(){
    var fbAuth = FirebaseAuth.getInstance();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        loginWithFirebase("vexpert","star2019");

    }
    fun loginWithFirebase(username:String,password:String){
        fbAuth.signInWithEmailAndPassword(username+"@auth.com", password);
        if((fbAuth.currentUser)!=null){
            print("congratz");
        }
            }

    }


