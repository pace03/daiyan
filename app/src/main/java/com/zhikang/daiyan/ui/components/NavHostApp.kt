package com.zhikang.daiyan.ui.components

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.zhikang.daiyan.ui.navigation.Destinations
import com.zhikang.daiyan.ui.screens.ArticleDetailScreen
import com.zhikang.daiyan.ui.screens.MainFrame

/**
 * 导航控制器
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavHostApp() {

    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = Destinations.HomeFrame.route
    ) {

        //首页大框架
        composable(Destinations.HomeFrame.route) {
            MainFrame(onNavigateToArticle = {
                Log.i("===", "onNavigateToArticle")
                navController.navigate(Destinations.ArticleDetail.route)
            })
        }

        //文章详情页
        composable(Destinations.ArticleDetail.route) {
            ArticleDetailScreen()
        }
    }
}