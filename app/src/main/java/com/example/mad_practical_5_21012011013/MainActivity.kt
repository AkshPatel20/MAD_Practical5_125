package com.example.mad_practical_5_21012011013
import android.content.Intent
import android.content.Intent.*
import android.graphics.Camera
import android.net.Uri
import android.os.Bundle
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import android.app.AlarmManager;


class MainActivity : AppCompatActivity() {
    lateinit var edittext2:EditText
    lateinit var calllogButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editeurl: EditText = findViewById(R.id.edittext1)
        calllogButton=findViewById(R.id.button_calllog)
        edittext2 = findViewById(R.id.edittext2)
        findViewById<Button>(R.id.button_bwroser).setOnClickListener{
            Intent(ACTION_VIEW, Uri.parse(editeurl.text.toString())).also{startActivity(it)}
        }
        findViewById<Button>(R.id.button_call).setOnClickListener{
            val number: String = edittext2.getText().toString()
            Intent(ACTION_DIAL,Uri.parse("tel: $number")).also{startActivity(it)}
        }
        findViewById<Button>(R.id.button_calllog).setOnClickListener{
            val showCallLog = Intent(ACTION_VIEW,Uri.parse("content://call_log/calls"))
            startActivity(showCallLog)
        }
        findViewById<Button>(R.id.button_gallery).setOnClickListener{
           var intent =  Intent()
            intent.setAction(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivity(intent)

        }
    }
}