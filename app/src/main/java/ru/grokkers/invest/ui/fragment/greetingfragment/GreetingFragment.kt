package ru.grokkers.invest.ui.fragment.greetingfragment

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.core.view.get
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.grokkers.invest.data.utils.hideKeyboard
import ru.grokkers.invest.databinding.FragmentGreetingBinding
import ru.grokkers.invest.ui.activity.MainActivity
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
                layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false).apply {
                        stackFromEnd = true
                    }
            }

            send.setOnClickListener {
                viewModel.onSendClicked(input.text.toString())
                input.text = null
            }
        }

        (activity as MainActivity).setNavigationVisibility(false)

        viewModel.apply {
            start()
            handleFlow(messagesState, ::setMessages)
            handleFlow(newMessageState, ::addMessage)
            handleFlow(lifestyleState, ::setLifestyleVisibility)
            handleFlow(ageState, ::setNumberInput)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setMessages(messages: List<Pair<String, Boolean>>) {
        messagesAdapter.items = messages.toMutableList()
    }

    private fun addMessage(message: Pair<String, Boolean>) {
        messagesAdapter.addMessage(message)
        binding.recycler.scrollToPosition(messagesAdapter.itemCount - 1)
    }

    private fun setLifestyleVisibility(isVisible: Boolean) {
        binding.lifestyle.isVisible = isVisible
        binding.input.isFocusable = !isVisible
        binding.input.isFocusableInTouchMode = !isVisible
        if (isVisible) hideKeyboard()

        binding.lifestyle.setOnCheckedChangeListener { radioGroup, i ->
            if (i >= 0) {
                val button = radioGroup[i - 1] as RadioButton
                if (button.isChecked) {
                    binding.input.setText(button.text)
                }
            }
        }
    }

    private fun setNumberInput(isNumber: Boolean) {
        binding.input.inputType =
            if (isNumber) InputType.TYPE_CLASS_NUMBER else InputType.TYPE_CLASS_TEXT
    }
}