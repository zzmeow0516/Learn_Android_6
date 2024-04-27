package com.example.learn_android_6

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learn_android_5.Fruits

class MainActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruits>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initFruits()

        //开始使用recyclerview
        //recyclerview使用layoutmanager来对子项进行屏幕定位
        val layoutManger = LinearLayoutManager(this)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView1)
        //实际上调用的是recyclerView.setLayoutManger
        recyclerView.layoutManager = layoutManger

        //创建FruitAdapter实例，并且把添加好的FruitList传入构造函数
        val adapter = FruitAdapter(fruitList)
        //RecyclerView的setAdapter()方法来完成适配器设置
        recyclerView.adapter = adapter
    }

    private fun initFruits() {
        repeat(10) {
            fruitList.add(Fruits("Apple", R.drawable.apple_pic))
            fruitList.add(Fruits("Banana", R.drawable.banana_pic))
            fruitList.add(Fruits("Orange", R.drawable.orange_pic))
            fruitList.add(Fruits("Watermelon", R.drawable.watermelon_pic))
            fruitList.add(Fruits("Pear", R.drawable.pear_pic))
            fruitList.add(Fruits("Grape", R.drawable.grape_pic))
            fruitList.add(Fruits("Pineapple", R.drawable.pineapple_pic))
            fruitList.add(Fruits("Strawberry", R.drawable.strawberry_pic))
            fruitList.add(Fruits("Cherry", R.drawable.cherry_pic))
            fruitList.add(Fruits("Mango", R.drawable.mango_pic))
        }
    }
}