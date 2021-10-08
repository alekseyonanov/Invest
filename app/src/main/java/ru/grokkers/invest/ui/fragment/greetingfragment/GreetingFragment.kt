package ru.grokkers.invest.ui.fragment.greetingfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.grokkers.invest.databinding.FragmentGreetingBinding
import ru.grokkers.invest.ui.base.BaseFragment
import ru.grokkers.invest.ui.fragment.greetingfragment.adapter.MessagesAdapter

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
@AndroidEntryPoint
class GreetingFragment : BaseFragment() {

    private val viewModel by viewModels<GreetingViewModel>()

    private var _binding: FragmentGreetingBinding? = null
    private val binding: FragmentGreetingBinding
        get() = _binding!!

    private val messagesAdapter = MessagesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGreetingBinding.inflate(inflater, container, false)

        binding.apply {
            recycler.apply {
                adapter = messagesAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
        }

        viewModel.apply {
            start()
            handleFlow(messagesState, ::setMessages)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setMessages(messages: List<Pair<String, Boolean>>) {
        messagesAdapter.items = messages
    }
}