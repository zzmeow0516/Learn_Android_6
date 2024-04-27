package com.example.learn_android_6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//参数fruitlist表示数据源
class FruitAdapter(val fruitList: List<Fruits>) :
    RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

        //定义内部类，继承自recyclerview.adapter
        //viewholder的参数view是recyclerview子项的最外层布局
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
            val fruitName: TextView = view.findViewById(R.id.fruitName)
        }

    //必须重写以下三个方法
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //加载fruit_item布局
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        //将加载的fruit_item布局传入到viewholder构造函数，从而返回一个viewholder实例
        return ViewHolder(view)
    }

    //给recyclerview的子项赋值
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruitItem = fruitList[position]
        holder.fruitImage.setImageResource(fruitItem.fruitImageId)
        holder.fruitName.text = fruitItem.name
    }

    //返回子项个数
    override fun getItemCount(): Int {
        return fruitList.size
    }




}