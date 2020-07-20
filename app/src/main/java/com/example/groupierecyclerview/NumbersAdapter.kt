package com.example.groupierecyclerview

import com.xwray.groupie.*
import kotlinx.android.synthetic.main.item_layout.view.itemNumber

class NumbersAdapter : GroupAdapter<GroupieViewHolder>() {
    fun setData(numberList: List<Int>) {
        numberList.forEach {
            add(NumberItem(number = it))
        }
    }

    private inner class NumberItem(private val number: Int) : Item<GroupieViewHolder>(){
        override fun getLayout(): Int = R.layout.item_layout

        override fun bind(viewHolder: GroupieViewHolder, position: Int) {
            with(viewHolder.itemView) {
                itemNumber.text = number.toString()
            }
        }
    }
}