package com.example.sqlliteandroid_stones


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private lateinit var nametext: EditText
    private lateinit var emailtext: EditText
    private lateinit var idtext: EditText
    private lateinit var savebtn: Button
    private lateinit var viewbtn: Button
    private lateinit var deletebtn: Button
    private lateinit var db:SQLiteDatabase
    



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nametext = findViewById(R.id.edtname)
        emailtext = findViewById(R.id.edtemail)
        idtext = findViewById(R.id.edtNumber)
        savebtn = findViewById(R.id.btnsave)
        viewbtn = findViewById(R.id.btnview)
        deletebtn = findViewById(R.id.btndelete)
        
        
        //Creating our database
        db = openOrCreateDatabase("StonesDB", Context.MODE_PRIVATE, null)
        
        //creating our table
        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR, arafa VARCHAR, kitambulisho VARCHAR)")
        
        
        savebtn.setOnClickListener { 
            
            var jinaedt = nametext.text.toString().trim()
            var arafaedt = emailtext.text.toString().trim()
            var kitambulishoedt = idtext.text.toString().trim()
            
            
            //Validate your edit texts

            if(jinaedt.isEmpty() || arafaedt.isEmpty() || kitambulishoedt.isEmpty()) {

                Toast.makeText(this, "Cannot submit an Empty field", Toast.LENGTH_SHORT).show()

            }else {
                
                //insert data
                
                db.execSQL("INSERT INTO users VALUES(  '\"+jinaedt\"' , '\"+arafaedt\"' , '\"+kitambulishoedt\"')")


                Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show()
                
               
                


            }    
            
        }
        




    }
}