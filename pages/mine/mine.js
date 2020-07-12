// getCurrentPage是获取当前页面的实例对象。
const app = getApp()
Page({

  data: {
    uid: app.globalData.uid,
    currentbalance:0.00,
    rebate:0,
    username:"未登录",
    userInfo: {},
    userimg:"/icons/profile.png",
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    arrow:"../../image/0106arrow3x.png",

    switchItems: [{
      icon: '../../image/yuyue.png',
      text: '我的包裹',
      url:'../order/index'
    }],
    // 1.菜单栏数据
    items: [
      {
        icon: '../../image/youhui.png',
        text: '我的优惠券',
        url:"../example/coupons/index"
      },
      {
        icon: '../../image/qiandao.png',
        text: '推广返利',
        url:"../example/rebate/index"
      },
      {
        icon: '../../image/qiandao.png',
        text: '收货地址管理',
        url:"../addressMgt/addressMgt"
      },

      {
        icon: '../../image/qiandao.png',
        text: '我的中转仓库地址',
        url:"../storage/index"
      } 
    ], 
    services:[
      {
        icon: '../../image/shoucang.png',
        text: '禁运品查询',
        url:'../example/ban/index'
      },
      {
        icon: '../../image/shoucang.png',
        text: '服务理赔',
        url:'../example/compensation/index'
      },
      {
        icon: '../../image/yijan.png',
        text: '意见反馈',
        url:'../example/fdback/fdback'
      }
    ],
    logout:[
      {
        icon:'../../image/kefu.png',
        text: '退出',
        url:"../index/index"
      }
    ]
  },
//重定向我的包裹
switchtopage: function (event) {
  wx.switchTab({
    url: '/pages/order/index'
})
},

  gotopage: function (event) {
    wx.navigateTo({
    url: event.currentTarget.dataset.hi
    })
  },
  goAsset:function(){
    wx.navigateTo({
      url:"/pages/asset/index"
    })
  },
  goScore:function(){
    wx.navigateTo({
      url:"/pages/score/index"
    })
  },
  onLoad:function(options) {
    var username = getApp().globalData.username
    console.log(username)
    if (app.globalData.userInfo) {
      this.setData({
        uid:getApp().globalData.uid,
        userInfo: app.globalData.userInfo,
        username: app.globalData.username,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          username: app.globalData.username,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            username: app.globalData.username,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function (e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  //事件处理函数
  bindViewTap: function () {

    var that = this;
    wx.openSetting({
      success: function (res) { // 这里重新调用代码，比如这里的重新显示头像昵称
        res.authSetting = {
          "scope.userInfo": true,
        }
      },
      f
    })
  }
})