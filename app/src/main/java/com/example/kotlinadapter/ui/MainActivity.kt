package com.example.kotlinadapter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinadapter.R
import com.example.kotlinadapter.data.PojoClass
import com.example.kotlinadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var dataList:ArrayList<PojoClass>
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataList= ArrayList<PojoClass>()
        dataList.add(PojoClass("Krishna", "Image of Krishna", R.drawable.krishna_image));
        dataList.add(PojoClass("Krishna", "Image of Krishna", R.drawable.krishna_image));
        dataList.add(PojoClass("Krishna", "Image of Krishna", R.drawable.krishna_image));
        dataList.add(PojoClass("Krishna", "Image of Krishna", R.drawable.krishna_image));
        dataList.add(PojoClass("Krishna", "Image of Krishna", R.drawable.krishna_image));
        dataList.add(PojoClass("Krishna", "Image of Krishna", R.drawable.krishna_image));
        dataList.add(PojoClass("Krishna", "Image of Krishna", R.drawable.krishna_image));
        dataList.add(PojoClass("Krishna", "Image of Krishna", R.drawable.krishna_image));

        val mainAdapter =MainActivityAdapter(this, dataList)
        val gridLayoutManager= GridLayoutManager(this, 1)

        binding.recylerView.layoutManager=gridLayoutManager
        binding.recylerView.adapter=mainAdapter
    }
}