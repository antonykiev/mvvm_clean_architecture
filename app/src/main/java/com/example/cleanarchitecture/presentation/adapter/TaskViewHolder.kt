package com.example.cleanarchitecture.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.domain.entity.Item
import com.example.cleanarchitecture.presentation.viewmodel.TasksViewModel
import kotlinx.android.synthetic.main.item_task.view.*

class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: Item, viewModel: TasksViewModel) {
        itemView.task_text.text = item.description

        itemView.checkBox.setOnCheckedChangeListener { checkbox, _ ->
            checkbox.isChecked = false
            viewModel.delete(item)
        }

        itemView.button.setOnClickListener {
            viewModel.getAnswer()
        }
    }
}