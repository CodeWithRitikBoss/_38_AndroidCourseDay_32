package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyWatchesAdapter(var watchesArrayList: ArrayList<WatchesDataClass>, var context: Activity) :
    RecyclerView.Adapter<MyWatchesAdapter.MyViewHolder>() {


    //

    private lateinit var myListenerForWatches: onItemClickListenerForWatches

    //Here I am creating own interface.
    interface onItemClickListenerForWatches {
        fun onItemClick(position: Int)
    }

    //Creating of a own method is here.
    fun setOnItemClickListenerForWatches(listener: onItemClickListenerForWatches) {
        //initialization of myListener variable.
        myListenerForWatches = listener
    }

    //

    class MyViewHolder (itemView: View, listener: onItemClickListenerForWatches): RecyclerView.ViewHolder(itemView){
        val watchName: TextView= itemView.findViewById(R.id.textViewForProductName)
        val watchPrice: TextView= itemView.findViewById(R.id.textViewForPrice)
        val watchImage: ImageView= itemView.findViewById(R.id.imageForProduct)
        val cardView: CardView= itemView.findViewById(R.id.cardItem)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyWatchesAdapter.MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.each_item_view, parent, false)
        return MyViewHolder(itemView, myListenerForWatches)
    }

    override fun getItemCount(): Int {
        return watchesArrayList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyWatchesAdapter.MyViewHolder, position: Int) {

        if (position% 2== 0) {
            holder.cardView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.first_item1))
        }else {
            holder.cardView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.second_item1))
        }

        var currenItem= watchesArrayList[position]

        holder.watchName.text= "Watch"+ currenItem.watchName.toString()
        holder.watchPrice.text= "Rs "+ currenItem.watchPrice.toString()
        holder.watchImage.setImageResource(R.drawable.img_4)
    }



}