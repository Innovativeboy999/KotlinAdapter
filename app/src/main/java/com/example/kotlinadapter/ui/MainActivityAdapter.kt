package com.example.kotlinadapter.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinadapter.R
import com.example.kotlinadapter.data.PojoClass
import com.example.kotlinadapter.databinding.ModelClass1Binding
import com.example.kotlinadapter.databinding.ModelClass2Binding

class MainActivityAdapter(val context: Context,val data:ArrayList<PojoClass>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val VIEW_TYPE1=1
    val VIEW_TYPE2=2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        when(viewType){
            VIEW_TYPE1 ->{
                return Model1ViewHolder(layoutInflater.inflate(R.layout.model_class1,parent,false))
            }
            VIEW_TYPE2 ->{
                return Model2ViewHolder(layoutInflater.inflate(R.layout.model_class2,parent,false))

            }
        }
        return Model1ViewHolder(layoutInflater.inflate(R.layout.model_class1,parent,false))
    }

    class Model1ViewHolder(view: View) :RecyclerView.ViewHolder(view)
    {
        lateinit var binding : ModelClass1Binding
        fun bind(dataSingle:PojoClass)
        {
            binding= ModelClass1Binding.bind(itemView.rootView)
            binding.imageViewModel.setImageResource(dataSingle.image)
            binding.textImageName.text=dataSingle.name_image
            binding.textImageDetail.text=dataSingle.image_details
        }
    }
    class Model2ViewHolder(view:View):RecyclerView.ViewHolder(view)
    {

        lateinit var binding : ModelClass2Binding
        fun bind(dataSingle:PojoClass)
        {
            binding= ModelClass2Binding.bind(itemView.rootView)
            binding.imageViewModel.setImageResource(dataSingle.image)
            binding.textImageName.text=dataSingle.name_image
            binding.textImageDetail.text="second Krishna Model"
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position)==VIEW_TYPE2)
        {
            (holder as Model2ViewHolder).bind(data.get(position))
        }
        else{
            (holder as Model1ViewHolder).bind(data.get(position))
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position%2==0) {
            VIEW_TYPE1
        } else {
            VIEW_TYPE2
        }
    }

}