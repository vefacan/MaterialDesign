package com.example.materialdesign

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val mContext:Context, private val ulkelerDisaridanGelenListe:List<Ulkeler>):RecyclerView.Adapter<RVAdapter.CardViewTasarimNesneleriniTutucu>() {

    inner class CardViewTasarimNesneleriniTutucu(view:View):RecyclerView.ViewHolder(view){

        var satirCardView:CardView
        var satirYazi:TextView
        var noktaResim:ImageView

        init {
            satirCardView = view.findViewById(R.id.satirCardView)
            satirYazi = view.findViewById(R.id.satirYazi)
            noktaResim = view.findViewById(R.id.noktaResim)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewTasarimNesneleriniTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_tasarimi,parent,false)
        return CardViewTasarimNesneleriniTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardViewTasarimNesneleriniTutucu, position: Int) {

        val ulke = ulkelerDisaridanGelenListe[position]

        holder.satirYazi.text = ulke.ulkeAdi
        holder.satirCardView.setOnClickListener {
            Toast.makeText(mContext,"Seçtiğiniz ülke:${ulke.ulkeAdi}",Toast.LENGTH_SHORT).show()
        }

        holder.noktaResim.setOnClickListener {

            val popup = PopupMenu(mContext,holder.noktaResim)

            popup.menuInflater.inflate(R.menu.popup_menu,popup.menu)
            popup.show()

            popup.setOnMenuItemClickListener { item->

                when(item.itemId){

                    R.id.action_sil -> {
                        Toast.makeText(mContext,"Sil:${ulke.ulkeAdi}",Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_duzenle -> {
                        Toast.makeText(mContext,"Düzenle:${ulke.ulkeAdi}",Toast.LENGTH_SHORT).show()
                        true
                    }
                    else ->false
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return ulkelerDisaridanGelenListe.size
    }
}