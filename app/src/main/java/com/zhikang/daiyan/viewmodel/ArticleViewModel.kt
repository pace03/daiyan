package com.zhikang.daiyan.viewmodel

import androidx.lifecycle.ViewModel
import com.zhikang.daiyan.model.entity.ArticleEntity

class ArticleViewModel : ViewModel() {

    //文章列表数据
    var list = listOf(
        ArticleEntity(
            title = "关于公布第八届材料创新、设计及应用大赛获奖名单的通知",
            source = "教务处网站",
            timestamp = "2022-07-09"
        ),
        ArticleEntity(
            title = "关于公布第十九届程序设计竞赛获奖名单的通知",
            source = "教务处网站",
            timestamp = "2022-07-09"
        ),
        ArticleEntity(
            title = "关于公布第十二届大学生节能减排社会实践与科技竞赛获奖名单的通知",
            source = "教务处网站",
            timestamp = "2022-07-09"
        ),
        ArticleEntity(
            title = "关于公布第二十二届数学竞赛获奖名单的通知",
            source = "教务处网站",
            timestamp = "2022-07-09"
        ),
        ArticleEntity(
            title = "关于公布第八届大学生用户体验设计大赛获奖名单的通知",
            source = "教务处网站",
            timestamp = "2022-07-09"
        ),
        ArticleEntity(
            title = "关于公布第十一届大学生软件设计与服务外包创新创业竞赛获奖名单的通知",
            source = "教务处网站",
            timestamp = "2022-07-09"
        ),
        ArticleEntity(
            title = "关于公布福州大学2022届本科生优秀毕业设计（论文）名单的通知",
            source = "教务处网站",
            timestamp = "2022-07-09"
        ),
        ArticleEntity(
            title = "教务处关于2022年暑假工作安排的通知",
            source = "教务处网站",
            timestamp = "2022-07-09"
        )
    )
        private set
}