package com.example.groupierecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var numbersAdapter: NumbersAdapter
    private var numbersList: MutableList<Int> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(i in 0..41){
            numbersList.add(i)
        }

        numbersAdapter = NumbersAdapter()
        numberRecyclerView.layoutManager = GridLayoutManager(this, 2)
        numberRecyclerView.adapter = numbersAdapter
        numbersAdapter.setData(numbersList)

    }
}