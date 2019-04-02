package com.zettabyte.vexpert

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_menu.*


class MenuActivity : AppCompatActivity() {
    lateinit var login:String
    lateinit var db: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        login= intent.getStringExtra("login");
        db= FirebaseDatabase.getInstance()
        var ref:DatabaseReference=db.reference.child("experts");
        // Read from the database
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                nom.text = dataSnapshot.child("nom_complet").value.toString();

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })




    }
}
