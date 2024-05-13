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
class ProductoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name = view.findViewById<TextView>(R.id.product_title)
    val description = view.findViewById<TextView>(R.id.product_description)
    val image = view.findViewById<ImageView>(R.id.product_image)
    val precio = view.findViewById<TextView>(R.id.product_price)
    val unidades = view.findViewById<TextView>(R.id.product_unit)
    val marca = view.findViewById<TextView>(R.id.product_brand)
    fun render(producto: Producto){
        name.text = producto.titulo;
        description.text = producto.descripcion
        Glide.with(image.context).load(producto.imagenUrl).into(image)
        val format = NumberFormat.getCurrencyInstance()
        format.setMaximumFractionDigits(0);
        precio.text = "Precio: ${format.format(producto.precio)}"
        unidades.text = "Unidades Disponibles: ${producto.unidades.toString()}"
        marca.text = "Marca: ${producto.marca}"
    }
}