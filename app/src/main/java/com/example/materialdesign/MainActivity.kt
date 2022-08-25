package com.example.materialdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hosgeldinizToolbar.title = "Hoşgeldiniz"
        hosgeldinizToolbar.subtitle="Kayıt Ekranı"
        hosgeldinizToolbar.setLogo(R.drawable.resim_nota)
        hosgeldinizToolbar.setTitleTextColor(resources.getColor(R.color.white))

        setSupportActionBar(hosgeldinizToolbar)


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

            startActivity(Intent(this@MainActivity,RecyclerViewVeCardView::class.java))
        }

    }

     override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.action_search ->{
                Toast.makeText(applicationContext,"Arama tuşuna basıldı.",Toast.LENGTH_SHORT).show()
                }
            R.id.action_settings ->{
                Toast.makeText(applicationContext,"Ayarlara tıklanıldı..",Toast.LENGTH_SHORT).show()
            }
            R.id.action_add ->{
                Toast.makeText(applicationContext,"Ekleme tuşuna tıklanıldı.",Toast.LENGTH_SHORT).show()
            }
            R.id.action_exit ->{
                Toast.makeText(applicationContext,"Çıkış yapıldı.",Toast.LENGTH_SHORT).show()
            }
            else -> return super.onOptionsItemSelected(item)
        }
                return super.onOptionsItemSelected(item)
    }

}