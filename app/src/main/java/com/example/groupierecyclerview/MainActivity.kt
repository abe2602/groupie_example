package com.example.groupierecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var numbersAdapter: NumbersAdapter
    private val numbersList: List<Int> =
            listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numbersAdapter = NumbersAdapter()
        numberRecyclerView.layoutManager = LinearLayoutManager(this)
        numberRecyclerView.adapter = numbersAdapter
        numbersAdapter.setData(numbersList)

    }
}