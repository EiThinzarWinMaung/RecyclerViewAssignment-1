package com.example.recyclerviewassignment_1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewassignment_1.R
import com.example.recyclerviewassignment_1.model.MyCart
import kotlinx.android.synthetic.main.item_mycart.view.*

class MyCardAdapter(var mycartArrayList: ArrayList<MyCart>): RecyclerView.Adapter<MyCardAdapter.MyCartViewHolder>() {

    var clickListener: ClickListener? = null

    fun setOnClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    inner class MyCartViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        lateinit var mycart: MyCart

        fun bindMyCard(mycart: MyCart){
            itemView.txtItemName.text = mycart.name
            itemView.txtItemPrice.text = mycart.price
            itemView.imgItem.setImageResource(mycart.image)

            itemView.btnMinus.setOnClickListener {
                var minus:Int = itemView.txtKgNumber.text.toString().toInt()
                minus -= 1
                itemView.txtKgNumber.text = minus.toString()
            }

            itemView.btnPlus.setOnClickListener {
                var plus:Int = itemView.txtKgNumber.text.toString().toInt()
                plus += 1
                itemView.txtKgNumber.text = plus.toString()
            }
        }

        override fun onClick(p0: View?) {
            clickListener?.click(mycart)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCartViewHolder {
        var view =  LayoutInflater.from(parent.context).inflate(R.layout.item_mycart, parent, false)
        return MyCartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mycartArrayList.size
    }

    override fun onBindViewHolder(holder: MyCartViewHolder, position: Int) {
        holder.bindMyCard(mycartArrayList[position])
    }

    interface ClickListener {
        fun click(mycart: MyCart)
    }
}