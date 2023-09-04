package com.example.submissionakhiraplikasipemula

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.submissionakhiraplikasipemula.HP
import com.example.submissionakhiraplikasipemula.R

class DetailHp : AppCompatActivity() {
    companion object {
        const val EXTRA_HP = "extra_hp"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hp)

        val ivPhoto: ImageView = findViewById(R.id.iv_detail_photo)
        val namaHP: TextView = findViewById(R.id.namaHP)
        val spek: TextView = findViewById(R.id.spek)
        val harga: TextView = findViewById(R.id.harga)

        val telpon: Button = findViewById(R.id.call)
        val HP = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<HP>(EXTRA_HP, HP::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<HP>(EXTRA_HP)
        }
        if (HP != null) {
            telpon.setOnClickListener(this)
            ivPhoto.setImageResource(HP.photo)
            namaHP.text = HP.name
            spek.text = HP.description
            harga.text = HP.price
        }else{


        }

    }  override fun onClick(v: View) {
        when (v.id){
            R.id.call -> {
                val phoneNumber = "089639045469"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }

}


