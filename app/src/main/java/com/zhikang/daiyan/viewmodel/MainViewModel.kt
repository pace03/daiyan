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
        SwiperEntity("https://img1.baidu.com/it/u=1769269289,1032280223&fm=253&fmt=auto&app=138&f=JPEG?w=1250&h=500"),
        SwiperEntity("https://img1.baidu.com/it/u=3336929827,2621756749&fm=253&fmt=auto&app=138&f=JPEG?w=1499&h=500"),
        SwiperEntity("https://img0.baidu.com/it/u=1319063400,390126700&fm=253&fmt=auto&app=138&f=JPEG?w=667&h=500"),
        SwiperEntity("https://img0.baidu.com/it/u=285122086,2800107243&fm=253&fmt=auto&app=138&f=JPEG?w=750&h=500"),
        SwiperEntity("https://img2.baidu.com/it/u=3382902867,251543546&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=331")
    )

    //通知数据
    val notifications = listOf(
        "关于公布第八届材料创新、设计及应用大赛获奖名单的通知",
        "关于公布第十九届程序设计竞赛获奖名单的通知",
        "关于公布第十二届大学生节能减排社会实践与科技竞赛获奖名单的通知",
        "关于公布第二十二届数学竞赛获奖名单的通知",
        "教务处关于2022年暑假工作安排的通知"
    )
}