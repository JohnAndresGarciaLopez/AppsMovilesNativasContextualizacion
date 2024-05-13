package com.example.tiendavirtualandroid

import ProductoProvider
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tiendavirtualandroid.adapter.ProductAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue

class ProductListActivity : AppCompatActivity() {
    val myRef = FirebaseDatabase.getInstance().getReference("productos")
    private var productArrayList = ArrayList<Producto>()

    companion object {
        private const val TAG = "KotlinActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)


        val floatingBtn = findViewById<FloatingActionButton>(R.id.fab_cart)
        floatingBtn.setOnClickListener {
            val intent = Intent(this,ShoppingCartActivity::class.java)
            startActivity(intent)
        }
        getProductos()
        initRecicleView()
    }
    fun initRecicleView(){
        val recicyleView = findViewById<RecyclerView>(R.id.product_card_layout)
        recicyleView.layoutManager = LinearLayoutManager(this)
        recicyleView.adapter = ProductAdapter(productArrayList)
    }

    fun getProductos(){
        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for ( productSnapshot in dataSnapshot.children ){
                    if(productSnapshot.exists()){
                        val item = productSnapshot.getValue(Producto::class.java)

                        productArrayList.add(item!!)

                    }

                }
                // Notifica al adaptador que los datos han cambiado
                val recicyleView = findViewById<RecyclerView>(R.id.product_card_layout)
                (recicyleView.adapter as? ProductAdapter)?.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }

}