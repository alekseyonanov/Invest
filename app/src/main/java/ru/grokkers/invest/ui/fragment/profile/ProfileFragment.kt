package ru.grokkers.invest.ui.fragment.profile

import android.content.ActivityNotFoundException
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
import android.widget.Toast

import android.content.Intent
import android.icu.text.DecimalFormat
import android.icu.text.NumberFormat
import android.net.Uri


/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class ProfileFragment : BaseFragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding
        get() = _binding!!

    private val viewModel by viewModels<ProfileViewModel>()

    private var totalSum: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)

        binding.apply {
            share.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                val textToSend =
                    "В приложении VTB Invest game я заработал уже $totalSum Р и скоро получу бонус от ВТБ! Присоединяйся и ты"
                intent.putExtra(Intent.EXTRA_TEXT, textToSend)
                try {
                    startActivity(Intent.createChooser(intent, "Поделиться"))
                } catch (ex: ActivityNotFoundException) {
                    Toast.makeText(
                        requireContext(),
                        "Ошибка. Невозможно поделиться",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            vtbInvest.setOnClickListener {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=ru.vtb.invest&hl=ru&gl=US")
                )
                startActivity(intent)
            }

            vtbCabinet.setOnClickListener {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=ru.vtb24.mobilebanking.android&hl=ru&gl=RU")
                )
                startActivity(intent)
            }
        }

        binding.wallet.setOnClickListener {
            viewModel.onWalletClicked()
        }

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
                val formatter: NumberFormat = DecimalFormat("#,###")
                education.text = it.userType.value
                name.text = it.name
                vuz.text = it.education

                salary.text = fetchCurrency(it.userType.salary / 30, formatter)
                money.text = fetchCurrency(it.money, formatter)

                credit.text = fetchCurrency(it.creditSum, formatter)
                monthCredit.text = fetchCurrency(calculateMonthCreditSum(it.creditSum), formatter)

                age.text = it.age.toString()
                city.text = it.city
                work.text = it.workType
            }
            totalSum = it.money
        }
    }

    private fun fetchCurrency(value: Int, formatter: NumberFormat): String {
        return "${formatter.format(value)}.00 ₽"
    }
}