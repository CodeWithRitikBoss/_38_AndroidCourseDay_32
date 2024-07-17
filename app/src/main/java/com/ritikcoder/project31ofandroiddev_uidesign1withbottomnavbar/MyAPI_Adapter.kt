package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAPI_Adapter(val context: Activity, val productAPI_ArrayList: List<Product>) :
    RecyclerView.Adapter<MyAPI_Adapter.MyAPIViewHolder>() {

    //Here I am creating own interface.
    private lateinit var myAPIListener: onItemClickListener
    interface onItemClickListener {
        fun onItemClick(position: Int)

    }

    //Creating own function here.
    fun setOnItemClickListener(listener: onItemClickListener) {
        //initialization of myListener variable.
        myAPIListener= listener
    }

    class MyAPIViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        var productName: TextView
        var productImage: ShapeableImageView
        var productDescription: TextView
        var productPrice: TextView
        var cardView: CardView
         init {
             productName= itemView.findViewById(R.id.textViewForProductName)
             productImage= itemView.findViewById(R.id.imageForProduct)
             productDescription= itemView.findViewById(R.id.textViewForProductDescription)
             productPrice= itemView.findViewById(R.id.textViewForPrice)
             cardView= itemView.findViewById(R.id.cardItem)

             itemView.setOnClickListener {
                 listener.onItemClick(adapterPosition)

             }
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAPIViewHolder {
        val itemView= LayoutInflater.from(context).inflate(R.layout.each_item_view_with_api, parent, false)
        return MyAPIViewHolder(itemView, myAPIListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyAPIViewHolder, position: Int) {

        if (position% 2== 0) {
            holder.cardView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.first_item1))
        }else {
            holder.cardView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.second_item1))
        }

        val currentItem= productAPI_ArrayList[position]

        holder.productName.text= currentItem.title

        //How to show image in imageView if the image is in form of URL, using picasso 3rd party library
        //Let's user this Picasso library.
        Picasso.get().load(currentItem.thumbnail).into(holder.productImage)

        holder.productDescription.text= currentItem.description
        holder.productPrice.text= "Rs "+ currentItem.price.toString()

        //For loot in kotlin. this will print number 1 2 3 4 ...... 1000
//        for (index in 1..1000 ){
//
//        }
    }

    override fun getItemCount(): Int {
        return productAPI_ArrayList.size
    }
}