package com.example.materialdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tab_layout.*

class TabLayout : AppCompatActivity() {


    private val fragmentListesi = ArrayList<Fragment>()
    private val fragmentBaslikListesi = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        fragmentListesi.add(BirinciFragment())
        fragmentListesi.add(IkınciFragment())
        fragmentListesi.add(UcuncuFragment())

        val adaptertab = MyViewPagerAdapter(this@TabLayout)
        viewPager2.adapter = adaptertab

        fragmentBaslikListesi.add("Bir")
        fragmentBaslikListesi.add("İki")
        fragmentBaslikListesi.add("Üç")

        TabLayoutMediator(tabLayout,viewPager2){tab, position->

            tab.setText(fragmentBaslikListesi[position])
        }.attach()

        tabLayout.getTabAt(0)!!.setIcon(R.drawable.resim_nota)
    }


    inner class MyViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){

        override fun getItemCount(): Int {
            return fragmentListesi.size
        }
        override fun createFragment(position: Int): Fragment {
            return fragmentListesi[position]
        }
    }

}