package com.example.tiendavirtualandroid.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.tiendavirtualandroid.Producto
import com.example.tiendavirtualandroid.R
import java.text.NumberFormat
import java.util.Locale
class ShoppingCartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name = view.findViewById<TextView>(R.id.shopping_title)
    val unidades = view.findViewById<TextView>(R.id.shopping__quantity)
    val image = view.findViewById<ImageView>(R.id.shopping_image)
    fun render(producto: Producto){
        name.text = producto.titulo;
        Glide.with(image.context).load(producto.imagenUrl).into(image)
        unidades.text = "Unidades: ${producto.unidades.toString()}"
    }
}