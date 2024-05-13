package com.example.tiendavirtualandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tiendavirtualandroid.adapter.ProductAdapter
import com.example.tiendavirtualandroid.adapter.ShoppingCartAdapter

class ShoppingCartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)
        initRecicleView()
    }
    fun initRecicleView(){
        val recicyleView = findViewById<RecyclerView>(R.id.shopping_cart_recycle)
        recicyleView.layoutManager = LinearLayoutManager(this)
        recicyleView.adapter = ShoppingCartAdapter(ProductoProvider.productosList)
    }
}