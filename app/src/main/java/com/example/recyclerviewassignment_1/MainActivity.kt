package com.example.recyclerviewassignment_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewassignment_1.adapter.MyCardAdapter
import com.example.recyclerviewassignment_1.model.MyCart
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MyCardAdapter.ClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mycartArrayList = arrayListOf<MyCart>()
        mycartArrayList.add(MyCart(R.drawable.fined_grain_sugar, "Fine Grain Sugar", "Price - $20.00"))
        mycartArrayList.add(MyCart(R.drawable.peanuts, "Peanuts", "Price - $20.00"))
        mycartArrayList.add(MyCart(R.drawable.dawat_rice, "Dawat Rice", "Price - $0.00"))
        mycartArrayList.add(MyCart(R.drawable.fined_grain_sugar, "Fine Grain Sugar", "Price - $20.00"))
        mycartArrayList.add(MyCart(R.drawable.peanuts, "Peanuts", "Price - $20.00"))
        mycartArrayList.add(MyCart(R.drawable.dawat_rice, "Dawat Rice", "Price - $0.00"))

        var mycardAdapter = MyCardAdapter(mycartArrayList)

        MyCartRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        MyCartRecyclerView.adapter = mycardAdapter

        mycardAdapter.setOnClickListener(this)
    }

    override fun click(mycart: MyCart) {

    }
}