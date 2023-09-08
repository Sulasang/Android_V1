package com.lsakee.feature

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.lsakee.core_ui.base.BindingActivity
import com.lsakee.core_ui.view.UiState
import com.lsakee.domain.model.DateAndTypeDietInfo
import com.lsakee.feature.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var menuAdapter: MenuAdapter
    private lateinit var timeMenuAdapter: MenuAdapter
    private val viewModel by viewModels<MenuViewModel>()
    private lateinit var dateAndTypeDietInfo: List<DateAndTypeDietInfo>
    val companyMap = mutableMapOf<String, Pair<List<String>, List<String>>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCurrentDate()
        collectTagListData()
        initAdapter()

        binding.chip1.setOnClickListener {
            handleChipClick("Little Kitchen")
        }
        binding.chip2.setOnClickListener {
            handleChipClick("Mom's Cook")
        }
        binding.chip3.setOnClickListener {
            handleChipClick("Chef Table")
        }
    }

    private fun initAdapter() {
        menuAdapter = MenuAdapter()
        binding.rvAllMenuList.adapter = menuAdapter
        timeMenuAdapter = MenuAdapter()
        binding.rvTimeMenuList.adapter = timeMenuAdapter
    }
    private fun handleChipClick(companyName: String) {
        menuAdapter.submitList(companyMap[companyName]?.first)
        timeMenuAdapter.submitList(companyMap[companyName]?.second)
    }
    private fun collectTagListData() {

        viewModel.diet.flowWithLifecycle(lifecycle).onEach {

            when (it) {
                is UiState.Success -> {
                    companyMap.clear()
                    dateAndTypeDietInfo = it.data.dateAndTypeDietInfo
                    for (dietInfo in it.data.dateAndTypeDietInfo) {
                        val company = dietInfo.company
                        if (company.isNotEmpty()) {
                            if (companyMap.containsKey(company)) {
                                val companyCommonMenu = companyMap[company]?.first?.toMutableList()
                                val companyMainMenu = companyMap[company]?.second?.toMutableList()
                                companyCommonMenu?.addAll(dietInfo.commonMenu)
                                companyMainMenu?.addAll(dietInfo.mainMenu)
                                companyMap[company] = Pair(
                                    companyCommonMenu?.toList() ?: emptyList(),
                                    companyMainMenu?.toList() ?: emptyList()
                                )
                            } else {
                                val companyCommonMenu = dietInfo.commonMenu.toMutableList()
                                val companyMainMenu = dietInfo.mainMenu.toMutableList()
                                companyMap[company] =
                                    Pair(companyCommonMenu.toList(), companyMainMenu.toList())
                            }
                        }
                    }
                    menuAdapter.submitList(companyMap["Little Kitchen"]?.first)
                    timeMenuAdapter.submitList(companyMap["Little Kitchen"]?.second)
                }

                else -> {}
            }
        }.launchIn(lifecycleScope)
    }


    private fun setCurrentDate() {

        val currentTime = Calendar.getInstance()

        // 현재 날짜에서 3일을 뺍니다. Test
        currentTime.add(Calendar.DAY_OF_MONTH, -2)

        val dateFormat = SimpleDateFormat("MM.dd (E)", Locale.KOREA)
        val formattedDate = dateFormat.format(currentTime.time)


        val dateFormat2 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.KOREA)
        val formattedDate2 = dateFormat2.format(currentTime.time)
        viewModel.getDiet(formattedDate2, "LUNCH")
        binding.tvMenuDate.text = formattedDate

        binding.ivRightBtn.setOnClickListener {
            currentTime.add(Calendar.DAY_OF_MONTH, +1)
            val dateFormat = SimpleDateFormat("MM.dd (E)", Locale.KOREA)
            val formattedDate = dateFormat.format(currentTime.time)
            val dateFormat2 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.KOREA)
            val formattedDate2 = dateFormat2.format(currentTime.time)
            binding.tvMenuDate.text = formattedDate
            viewModel.getDiet(formattedDate2, "LUNCH")
        }

        binding.ivLeftBtn.setOnClickListener {
            currentTime.add(Calendar.DAY_OF_MONTH, -1)
            val dateFormat = SimpleDateFormat("MM.dd (E)", Locale.KOREA)
            val formattedDate = dateFormat.format(currentTime.time)
            val dateFormat2 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.KOREA)
            val formattedDate2 = dateFormat2.format(currentTime.time)
            binding.tvMenuDate.text = formattedDate
            viewModel.getDiet(formattedDate2, "LUNCH")
        }
    }


}