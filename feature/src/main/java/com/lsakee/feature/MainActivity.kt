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
    private val companyMap = mutableMapOf<String, Pair<List<String>, List<String>>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCurrentDate()
        collectTagListData()
        initAdapter()

        binding.chipGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.chip_1 -> handleChipClick("Little Kitchen")
                R.id.chip_2 -> handleChipClick("Mom's Cook")
                R.id.chip_3 -> handleChipClick("Chef Table")
            }
        }
    }

    private fun initAdapter() {
        menuAdapter = MenuAdapter()
        binding.rvAllMenuList.adapter = menuAdapter
        timeMenuAdapter = MenuAdapter()
        binding.rvTimeMenuList.adapter = timeMenuAdapter
    }

    private fun handleChipClick(companyName: String) {
        menuAdapter.submitList(companyMap[companyName]?.first?: listOf("오늘은 학식이 없습니다."))
        timeMenuAdapter.submitList(companyMap[companyName]?.second?: listOf("오늘은 학식이 없습니다."))
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
                    val selectedChip = when {
                        binding.chip1.isChecked -> "Little Kitchen"
                        binding.chip2.isChecked -> "Mom's Cook"
                        binding.chip3.isChecked -> "Chef Table"
                        else -> null
                    }
                    selectedChip?.let { chip ->
                        menuAdapter.submitList(companyMap[chip]?.first ?: listOf("오늘은 학식이 없습니다."))
                        timeMenuAdapter.submitList(companyMap[chip]?.second ?: listOf("오늘은 학식이 없습니다."))
                    }
                }

                else -> {}
            }
        }.launchIn(lifecycleScope)
    }


    private fun setCurrentDate() {
        //날짜 정규식 이거 개드럽네 귀찮아 죽겄다
        val dateFormat = SimpleDateFormat("MM.dd (E)", Locale.KOREA)
        val dateFormatISO = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.KOREA)
        //국제시간과 한국시간 서버가 -9시간으로 맞춰줌
        val currentTime = Calendar.getInstance()
        val formattedDate = dateFormat.format(currentTime.time)
        val formattedDateISO = dateFormatISO.format(currentTime.time)
        //초기 데이터 및 날짜 세팅
        viewModel.getDiet(formattedDateISO, "LUNCH")
        binding.tvMenuDate.text = formattedDate
        //7일전
        val sevenDaysAgo = Calendar.getInstance()
        sevenDaysAgo.add(Calendar.DAY_OF_MONTH, -7)
        //7일후
        val sevenDaysLater = Calendar.getInstance()
        sevenDaysLater.add(Calendar.DAY_OF_MONTH, 7)

        val formattedSevenDaysAgo = dateFormat.format(sevenDaysAgo.time)
        val formattedSevenDaysLater = dateFormat.format(sevenDaysLater.time)

        binding.ivRightBtn.setOnClickListener {
            currentTime.add(Calendar.DAY_OF_MONTH, +1)
            val formattedDate = dateFormat.format(currentTime.time)
            val formattedDate2 = dateFormatISO.format(currentTime.time)
            val comparisonResult = formattedDate.compareTo(formattedSevenDaysLater)
            Timber.d("$formattedDate,$formattedSevenDaysLater")
            if (comparisonResult > 0) {
                Timber.d("currentDate는 otherDate보다 이후 날짜입니다.")
                binding.ivRightBtn.isEnabled=false
            }
            binding.ivLeftBtn.isEnabled=true
            binding.tvMenuDate.text = formattedDate
            viewModel.getDiet(formattedDate2, "LUNCH")

        }

        binding.ivLeftBtn.setOnClickListener {
            currentTime.add(Calendar.DAY_OF_MONTH, -1)
            val formattedDate = dateFormat.format(currentTime.time)
            val formattedDate2 = dateFormatISO.format(currentTime.time)
            val comparisonResult = formattedDate.compareTo(formattedSevenDaysAgo)
            if (comparisonResult < 0) {
                Timber.d("currentDate는 otherDate보다 이전 날짜입니다.")
                binding.ivLeftBtn.isEnabled=false
            }
            binding.ivRightBtn.isEnabled=true
            binding.tvMenuDate.text = formattedDate
            viewModel.getDiet(formattedDate2, "LUNCH")
        }
    }


}