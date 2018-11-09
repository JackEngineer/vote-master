/**
 * Created by slipkinem on 7/4/2017 at 9:38 AM.
 */
'use strict';
+function (global) {
  if (global.navList || global.contentList) {
    throw new Error("navList或者contentList已经存在，请更改名称")
  }
    global.navList = [
        {
            superNav: {
                name: '综合管理',
            },
            subNav: [
                {
                    name: '培训机构管理',
                    href: 'app.company'
                },
                {
                    name: '学生管理',
                    href: 'app.student'
                },
                {
                    name: '活动管理',
                    href: 'app.active'
                },
                {
                    name: '活动图片管理',
                    href: 'app.activeImg'
                }
            ]
        },
        {
            superNav: {
                name: '礼物管理',
            },
            subNav: [
                {
                    name: '礼物管理',
                    href: 'app.gift'
                },
                {
                    name: '奖品管理',
                    href: 'app.prize'
                }
            ]
        },
        {
            superNav: {
                name: '账单查询',
            },
            subNav: [
                {
                    name: '账单查询',
                    href: 'app.weChat'
                },
                {
                    name: '记录查询',
                    href: 'app.ticket'
                }
            ]

        }
    ]
}(window);
