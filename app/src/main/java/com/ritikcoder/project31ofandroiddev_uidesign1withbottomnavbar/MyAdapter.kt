package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var productArrayList: ArrayList<ProductDataClass>, var context: Fragment) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var myListener: _onItemClickListener

    //Here I am creating own interface.
    interface _onItemClickListener {
        fun onItemClick(position: Int)
    }

    //Creating of a own method is here.
    fun setOnItemClickListener(listener: _onItemClickListener) {
        //initialization of myListener variable.
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.each_item_view, parent, false)
        return MyViewHolder(itemView, myListener)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

//        if (position% 2== 0) {
//            holder.cardView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.first_item1))
//        }else {
//            holder.cardView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.second_item1))
//        }

        var currentItem = productArrayList[position]

        holder.productImage.setImageResource(currentItem.productImage)
        holder.productName.text = currentItem.productName
        holder.productDescription.text = currentItem.productDescription.subSequence(0, 50)
        holder.productPrice.text = currentItem.productPrice
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    class MyViewHolder(itemView: View, listener: MyAdapter._onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val productImage: ShapeableImageView = itemView.findViewById(R.id.imageForProduct)
        val productName: TextView = itemView.findViewById(R.id.textViewForProductName)
        val productDescription: TextView = itemView.findViewById(R.id.textViewForProductDescription)
        val productPrice: TextView = itemView.findViewById(R.id.textViewForPrice)
        val cardView: CardView= itemView.findViewById(R.id.cardItem)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

}