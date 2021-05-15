package com.example.cleanarchitecture.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.domain.entity.Answer
import com.example.cleanarchitecture.domain.entity.Answer.Maybe
import com.example.cleanarchitecture.domain.entity.Answer.No
import com.example.cleanarchitecture.domain.entity.Answer.Yes
import com.example.cleanarchitecture.domain.entity.Item
import com.example.cleanarchitecture.presentation.adapter.TasksAdapter
import com.example.cleanarchitecture.presentation.viewmodel.TasksViewModel
import kotlinx.android.synthetic.main.fragment_tasks_overview.*
import kotlinx.android.synthetic.main.fragment_tasks_overview.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TasksFragment : Fragment() {

    private val viewModel: TasksViewModel by viewModel()
    private lateinit var adapter: TasksAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_tasks_overview, container, false)

        adapter = TasksAdapter(viewModel)
        view.tasks_list.adapter = adapter

        view.add_task_fab.setOnClickListener {
            fragmentManager?.let {
                CreateTaskFragment.newInstance()
                    .show(it, CreateTaskFragment.TAG)
            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.tasks.observe(viewLifecycleOwner, Observer (::onHandleListItem))
        viewModel.answers.observe(viewLifecycleOwner, Observer(::onHandleAnswer))
    }

    private fun onHandleAnswer(answer: Answer) {
        fragmentManager?.let { fm ->
            val uri = when (answer) {
                is Yes -> answer.imageUrl
                is No -> answer.imageUrl
                Maybe -> "android.resource://${context?.packageName}/${R.drawable.maybe}"
            }.toUri()

            GifFragment.newInstance(uri)
                .show(fm, GifFragment.TAG)
        }
    }

    private fun onHandleListItem(listItem: List<Item>) {
        adapter.submitList(listItem)
        no_tasks_group.isVisible = listItem.isEmpty()
    }
}