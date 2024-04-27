package com.example.learn_android_6

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruits>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initFruits()

        //开始使用recyclerview
        //recyclerview使用layoutmanager来对子项进行屏幕定位
        //val layoutManger = LinearLayoutManager(this)
        //实现RecyclerView的横向滚动
        //实际上调用的是LinearLayoutManager.setOrientation,对recyclerview的布局进行横向排列
        //layoutManger.orientation = LinearLayoutManager.HORIZONTAL

        //实现RecyclerView的瀑布流滚动
        val layoutManger = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)

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
            fruitList.add(Fruits(getRandomFrequencyString("Apple"), R.drawable.apple_pic))
            fruitList.add(Fruits(getRandomFrequencyString("Banana"), R.drawable.banana_pic))
            fruitList.add(Fruits(getRandomFrequencyString("Orange"), R.drawable.orange_pic))
            fruitList.add(Fruits(getRandomFrequencyString("Watermelon"), R.drawable.watermelon_pic))
            fruitList.add(Fruits(getRandomFrequencyString("Pear"), R.drawable.pear_pic))
            fruitList.add(Fruits(getRandomFrequencyString("Grape"), R.drawable.grape_pic))
            fruitList.add(Fruits(getRandomFrequencyString("Pineapple"), R.drawable.pineapple_pic))
            fruitList.add(Fruits(getRandomFrequencyString("Strawberry"), R.drawable.strawberry_pic))
            fruitList.add(Fruits(getRandomFrequencyString("Cherry"), R.drawable.cherry_pic))
            fruitList.add(Fruits(getRandomFrequencyString("Mango"), R.drawable.mango_pic))
        }
    }

    private fun getRandomFrequencyString(string: String): String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            ///每次迭代都调用 StringBuilder.append 将输入的字符串 string 附加 到 builder 的尾部
            builder.append(string)
        }
        //将Builder构建好的字符串转换成String对象并返回
        return builder.toString()
    }
}