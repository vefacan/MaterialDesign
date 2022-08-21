package com.example.materialdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "Hoşgeldiniz"
        toolbar.subtitle="Kayıt Ekranı"
        toolbar.setLogo(R.drawable.resim_nota)
        toolbar.setTitleTextColor(resources.getColor(R.color.white))

        setSupportActionBar(toolbar)


        mainFab.setOnClickListener {

            Toast.makeText(this@MainActivity,"Merhaba.",Toast.LENGTH_SHORT).show()

        }


        buttonMainOnay.setOnClickListener {

            val ad = editTextAd.text.toString().trim()
            val tel = editTextTel.text.toString().trim()

            if(TextUtils.isEmpty(ad)){
                Toast.makeText(this@MainActivity,"Bir isim giriniz.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(TextUtils.isEmpty(tel)){
                Toast.makeText(this@MainActivity,"Bir numara giriniz.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (tel.length < 6){
                Toast.makeText(this@MainActivity,"Telefon numarası en az 6 haneli olmalıdır.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }



            Toast.makeText(this@MainActivity,"İsminiz: $ad , Numaranız: $tel",Toast.LENGTH_SHORT).show()
        }





    }
}