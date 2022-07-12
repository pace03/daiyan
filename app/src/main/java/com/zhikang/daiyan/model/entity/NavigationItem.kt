package com.zhikang.daiyan.model.entity

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * 导航栏对象
 *
 * @property title 导航栏的标题
 * @property icon 导航栏的图标
 */
data class NavigationItem(
    val title:String,//导航栏的标题
    val icon:ImageVector//导航栏的图标

)
