package com.zhikang.daiyan.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zhikang.daiyan.ui.components.TopAppBar

@Composable
fun MineScreen(){
    Column(modifier = Modifier) {
        TopAppBar() {
            Text("我的页面")
        }
    }

}

@Preview
@Composable
fun MineScreenPreview(){
    MineScreen()
}