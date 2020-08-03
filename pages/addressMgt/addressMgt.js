var app = getApp();
var config = require("../../config.js");
// pages/addressMgt/addressMgt.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    
    uid:null,
    adresses:[],
    aid:null,
    isActive:false,
    color: "#7fabfd",
    newsList: [],
    HomeIndex: 0,

  },
  onAdd() {
    wx.navigateTo({
      url: '/pages/adressAdd/index',
    })
  },
  onBack:function(event) {
    console.log(event)
    if(this.data.isActive=='true'){
      app.globalData.aid = event.currentTarget.dataset.index; 
      wx.navigateBack({
        delta: 0,
      })
    }
 
  },
  
  onDelete:function(event){
    console.log(event)
    var $this = this;
    $this.setData({
        aid:event.target.dataset.index,
      }),
   
    wx.request({
      url: "https://wxmp.seelles.cn/AdressController/adressDelete", 
      data: { 
        'aid':this.data.aid
      },
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        console.log(res)
        console.log(res.data)
       
        if (res.statusCode== 200 && res.data==true) {
          wx.showToast({
              title: '删除成功',
              icon: 'success',
              duration: 20000
            })
            setTimeout(function(){
              wx.hideToast();
            }),
          wx.navigateTo({
            url: '../addressMgt/addressMgt',
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
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options)
    console.log(this.data.isActive)
    var that = this;
    //获取地址id
    if(options.isActive!=null){
      this.setData({
        isActive:options.isActive
      }),  
      console.log(this.data.isActive)
    }
 
      
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
    url: "https://wxmp.seelles.cn/AdressController/findAdressByUid", 
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