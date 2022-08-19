package com.ekspansion.eks

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import coil.load

class ProfileActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile)

        var resultOpenGallery = (this as ComponentActivity).registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.data!!.data == null) {
                Toast.makeText(applicationContext, R.string.no_image, Toast.LENGTH_SHORT).show()
                return@registerForActivityResult
            }
            val image = result.data!!.data
            Toast.makeText(applicationContext,R.string.image_selected, Toast.LENGTH_SHORT ).show()
            findViewById<ImageView>(R.id.imageView11).load(image){
            }
        }


        findViewById<Button>(R.id.btn_changePic).setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            resultOpenGallery.launch(intent)
        }

        findViewById<Button>(R.id.btn_changeBanner).setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            resultOpenGallery.launch(intent)
        }

    }

}