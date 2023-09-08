package com.lsakee.feature

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.lsakee.core_ui.base.BindingActivity
import com.lsakee.core_ui.view.UiState
import com.lsakee.domain.model.DateAndTypeDietInfo
import com.lsakee.domain.model.Diet
import com.lsakee.feature.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel by viewModels<MenuViewModel>()
    private lateinit var dateAndTypeDietInfo: List<DateAndTypeDietInfo>
    val companyMap = mutableMapOf<String, Pair<List<String>,List<String>>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCurrentDate()
        collectTagListData()

    }

    private fun collectTagListData() {

        viewModel.diet.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    dateAndTypeDietInfo = it.data.dateAndTypeDietInfo

                    for (dietInfo in it.data.dateAndTypeDietInfo) {
                        val company = dietInfo.company
                        if (company.isNotEmpty()) {
                            if (companyMap.containsKey(company)) {
                                val companyCommonMenu = companyMap[company]!!.first.toMutableList()
                                val companyMainMenu = companyMap[company]!!.second.toMutableList()
                                companyCommonMenu.addAll(dietInfo.commonMenu)
                                companyMainMenu.addAll(dietInfo.mainMenu)
                                companyMap[company] = Pair(companyCommonMenu.toList(), companyMainMenu.toList())
                            } else {
                                val companyCommonMenu = dietInfo.commonMenu.toMutableList()
                                val companyMainMenu = dietInfo.mainMenu.toMutableList()
                                companyMap[company] = Pair(companyCommonMenu.toList(), companyMainMenu.toList())
                            }
                        }
                    }
                    Timber.tag("testSak").d("${companyMap["Little Kitchen"]?.first}")
                    binding.tvAllMenu.text = companyMap["Little Kitchen"]?.first.toString().replace(", ", "\n").replace("[", "").replace("]", "")?.trim()
                    binding.tvMiddleMenu.text=companyMap["Little Kitchen"]?.second.toString().replace(", ", "\n").replace("[", "").replace("]", "")?.trim()
                }

                else -> {}
            }
        }.launchIn(lifecycleScope)
    }


    private fun setCurrentDate() {
        val currentTime = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("MM.dd (E)", Locale.KOREA)
        val formattedDate = dateFormat.format(currentTime.time)

        // 현재 날짜에서 3일을 뺍니다. Test
        currentTime.add(Calendar.DAY_OF_MONTH, -3)


        val dateFormat2 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.KOREA)
        val formattedDate2 = dateFormat2.format(currentTime.time)
        viewModel.getDiet(formattedDate2, "LUNCH")
        binding.tvMenuDate.text = formattedDate
    }


}