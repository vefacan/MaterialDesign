package com.example.materialdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view_ve_card_view.*

class RecyclerViewVeCardView : AppCompatActivity() {

    private lateinit var ulkelerList:ArrayList<Ulkeler>
    private lateinit var adapter:RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_ve_card_view)

        rv.setHasFixedSize(true)
        //rv.layoutManager = LinearLayoutManager(this@RecyclerViewVeCardView)
        rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val u1 = Ulkeler(1,"Türkiye")
        val u2 = Ulkeler(2,"ABD")
        val u3 = Ulkeler(3,"Japonya")
        val u4 = Ulkeler(4,"Almanya")

        ulkelerList = ArrayList<Ulkeler>()
        ulkelerList.add(u1)
        ulkelerList.add(u2)
        ulkelerList.add(u3)
        ulkelerList.add(u4)

        adapter = RVAdapter(this@RecyclerViewVeCardView,ulkelerList)

        rv.adapter = adapter

        buttonToTabLayout.setOnClickListener {

            startActivity(Intent(this@RecyclerViewVeCardView,TabLayout::class.java))
        }

    }
}