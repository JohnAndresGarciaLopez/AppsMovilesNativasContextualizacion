package com.example.tiendavirtualandroid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tiendavirtualandroid.Producto
import com.example.tiendavirtualandroid.R

class ShoppingCartAdapter(private val productosList: List<Producto>) :
    RecyclerView.Adapter<ShoppingCartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ShoppingCartViewHolder(
            layoutInflater.inflate(
                R.layout.card_view_shopping_cart,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return productosList.size
    }

    override fun onBindViewHolder(holder: ShoppingCartViewHolder, position: Int) {
        val item = productosList[position]
        holder.render(item)
    }
}