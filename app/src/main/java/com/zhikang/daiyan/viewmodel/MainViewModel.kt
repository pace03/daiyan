package com.zhikang.daiyan.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.SmartDisplay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.zhikang.daiyan.model.entity.Category
import com.zhikang.daiyan.model.entity.DataType
import com.zhikang.daiyan.model.entity.SwiperEntity

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


    //类型数据
    val types by mutableStateOf(
        listOf(
            DataType("相关资讯", Icons.Default.Description),
            DataType("视频课程", Icons.Default.SmartDisplay)
        )
    )

    //当前类型下标
    var currentTypeIndex by mutableStateOf(0)
        private set

    /**
     * 更新类型下标
     *
     * @param index
     */
    fun updateTypeIndex(index: Int) {
        currentTypeIndex = index
    }

    //轮播图数据
    val swiperData = listOf(
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner1.webp"),
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner2.webp"),
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner3.webp"),
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner4.jpg"),
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner5.jpg")
    )
}