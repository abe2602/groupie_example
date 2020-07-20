package com.example.groupierecyclerview

import com.jakewharton.rxbinding3.view.clicks
import com.xwray.groupie.*
import kotlinx.android.synthetic.main.expandable_item_layout.view.*
import kotlinx.android.synthetic.main.item_layout.view.itemNumber

class NumbersAdapter : GroupAdapter<GroupieViewHolder>() {
    fun setData(numberList: List<Int>) {
        numberList.forEach {
            add(ExpandableGroup(ExpandableNumberItem(number = it), false).apply {
                add(NumberItem(number = it*20))
            })

           // add(NumberItem(number = it))
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

    private inner class ExpandableNumberItem(private val number: Int) : Item<GroupieViewHolder>(),
        ExpandableItem {
        override fun getLayout(): Int = R.layout.expandable_item_layout
        private lateinit var expandableGroup: ExpandableGroup

        override fun bind(viewHolder: GroupieViewHolder, position: Int) {
            with(viewHolder.itemView) {
                expandedImageView.setImageResource(getIcon())

                itemNumber.text = number.toString()
                numberItemLayout.clicks().doOnNext {
                    expandableGroup.onToggleExpanded()
                    expandedImageView.setImageResource(getIcon())
                }.subscribe()
            }
        }

        override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
            expandableGroup = onToggleListener
        }

        private fun getIcon()= if (expandableGroup.isExpanded) R.drawable.minus else R.drawable.plus
    }
}