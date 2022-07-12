package com.zhikang.daiyan.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.zhikang.daiyan.model.entity.Category

class MainViewModel : ViewModel() {

    //分类数据
    val categories by mutableStateOf(
        listOf(
            Category("政治"),
            Category("数学"),
            Category("英语"),
            Category("专业课")
        )
    )

    //当前分类下标
    var categoryIndex by mutableStateOf(0)
        private set

    /**
     * 更新分类下标
     *
     * @param index
     */

    fun updateCategoryIndex(index: Int) {
        categoryIndex = index
    }

}