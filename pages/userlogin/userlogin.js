//获取应用实例
var util = require('../../utils/utils.js');
var app = getApp();
Page({
  data: {
    telephone: '',
    pwd: '',
    telephone: function (e) {
      var that = this;
      that.setData({
        telephone: e.detail.value
      })
    },
    pwd: function (e) {
      var that = this;
      that.setData({
        pwd: e.detail.value
      })
    },
    showTopTips: false,
    errorMsg: ""
  },
  onLoad: function () {
    var that = this;
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          windowHeight: res.windowHeight,
          windowWidth: res.windowWidth
        })
      }
    });
  },
  goToRegist: function(){
    wx.navigateTo({
      url: '/pages/userregist/userregist'
    })
  },
  formSubmit: function (e) {
    // form 表单取值，格式 e.detail.value.name(name为input中自定义name值)
    var that = this;
    var telephone = e.detail.value.telephone;
    var pwd = e.detail.value.pwd;
    // 判断账号是否为空和判断该账号名是否被注册  
    wx.request({
      url: "http://localhost:8080/4px_logistics/UserController/userLogin", 
      data: {
        'telephone': telephone,
        'pwd': pwd,
      },
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        console.log(res)
        console.log(res.data)
        console.log(res.data.uid)
        if (res.data.uid != null) {
          wx.showToast({
              title: '登录成功',
              icon: 'success',
              duration: 20000
            })
            setTimeout(function(){
              wx.hideToast();
            }),
            console.log(getApp().globalData.username)
            getApp().globalData.username = res.data.telephone;
            wx.switchTab({
              url: '../home/home'
            })
        }  else {
          wx.showToast({
            title: '账号或密码错误',
            icon: 'loading',
            duration: 2000
          })
        }
      }
    })
  }

})