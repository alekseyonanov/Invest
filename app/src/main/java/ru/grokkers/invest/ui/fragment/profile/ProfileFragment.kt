package ru.grokkers.invest.ui.fragment.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.data.utils.calculateMonthCreditSum
import ru.grokkers.invest.databinding.FragmentProfileBinding
import ru.grokkers.invest.ui.activity.MainActivity
import ru.grokkers.invest.ui.base.BaseFragment

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class ProfileFragment : BaseFragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding
        get() = _binding!!

    private val viewModel by viewModels<ProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)

        viewModel.apply {
            start()
            handleFlow(userState, ::setData)
        }

        (activity as MainActivity).setNavigationVisibility(true)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setData(user: User?) {
        user?.let {
            binding.apply {
                type.text = it.userType.value
                name.text = it.name
                education.text = it.education

                salary.text = (it.userType.salary / 30).toString()
                money.text = it.money.toString()

                credit.text = it.creditSum.toString()
                monthCredit.text = calculateMonthCreditSum(it.creditSum).toString()

                age.text = it.age.toString()
                city.text = it.city
                work.text = it.workType
            }
        }
    }
}