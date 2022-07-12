package com.zhikang.daiyan

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.zhikang.daiyan.ui.screens.MainFrame
import com.zhikang.daiyan.ui.theme.带盐Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //获取状态栏高度
//        var statusBarHeight = 0
//        val resourceId = resources.getIdentifier("status_bar_height","dimen","android")
//
//        if(resourceId>0){
//            statusBarHeight = resources.getDimensionPixelSize(resourceId)
//        }
          //API已过期
//        //处理不同机型，状态栏不透明问题
//        window.statusBarColor = Color.Transparent.value.toInt()
//        //处理不同机型，导航栏遮盖内容问题
//        window.decorView.systemUiVisibility=
//            View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            带盐Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainFrame()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    带盐Theme {
        Greeting("Android")
    }
}