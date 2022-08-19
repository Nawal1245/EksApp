package com.ekspansion.eks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatImageButton
import androidx.compose.ui.graphics.Color
import coil.load
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var resultOpenGallery = (this as ComponentActivity).registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.data!!.data == null) {
            Toast.makeText(applicationContext, R.string.no_image, Toast.LENGTH_SHORT).show()
            return@registerForActivityResult
        }
        val image = result.data!!.data
        Toast.makeText(applicationContext,R.string.image_selected,Toast.LENGTH_SHORT ).show()
        findViewById<ImageView>(R.id.imageView2).load(image){
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val colorStatus = Color.Black
        val darkIcons = false
        SystemUI(window = window).setStatusBarColor(colorStatus, darkIcons)

        findViewById<Button>(R.id.btn_edit_profile).setOnClickListener {
            startActivity(Intent(this.baseContext,ProfileActivity::class.java))
        }
        findViewById<Button>(R.id.btn_dashboard).setOnClickListener {
            startActivity(Intent(this.baseContext,DashboardActivity::class.java))
        }

        findViewById<Button>(R.id.btn_followers).setOnClickListener {
            startActivity(Intent(this.baseContext,FollowersActivity::class.java))
        }

        findViewById<AppCompatImageButton>(R.id.btn_imageView1).setOnClickListener {
            startActivity(Intent(this.baseContext,ProductDetail::class.java))
        }

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            resultOpenGallery.launch(intent)
        }
    }

}

