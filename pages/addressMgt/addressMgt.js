var app = getApp();
var config = require("../../config.js");
// pages/addressMgt/addressMgt.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    
     uid:null,
     adresses:null,
    


    courselist: [{
      imgs: [
          "../../image/Android.jpg",
          "../../image/Java.jpg"
      ]
  }],
  color: "#7fabfd",
  newsList: [],
  HomeIndex: 0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    //console.log(config.courses);
    that.setData({
        courses: config.courses
    });
    //调用应用实例的方法获取全局数据
    app.getUserInfo(function (userInfo) {
        //更新数据
        that.setData({
            userInfo: userInfo
        })
    }),
    that.setData({
      uid:getApp().globalData.uid
  }),
  console.log(this.data.uid)
  // 查询地址  
  wx.request({
    url: "http://localhost:8080/4px_logistics/AdressController/findAdressByUid", 
    data: { 
      'uid':this.data.uid
    },
    method: "POST",
    header: {
      'content-type': 'application/x-www-form-urlencoded'
    },
    success: function (res) {
      console.log(res)
      console.log(res.data)
     
      if (res.statusCode== 200) {
        wx.showToast({
            title: '查询成功',
            icon: 'success',
            duration: 20000
          })
          setTimeout(function(){
            wx.hideToast();
          }),
          that.setData({
            adresses:res.data
        })
      }  else {
        wx.showToast({
          title: '服务器升级中，请稍后联系我们 电话电话电话我是电话',
          icon: 'loading',
          duration: 2000
        })
      }
    }
  })


  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})