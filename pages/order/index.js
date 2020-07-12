// pages/order/index.js
const WXAPI = require('../../wxapi/main')
var app = getApp();
var sliderWidth = 96; // 需要设置slider的宽度，用于计算中间位置
Page({

  /**
   * 页面的初始数据
   */ 
  data: {
    commandsList:[],
    tabs: [
      {id:0,value:"待认领",isActive:false}, 
      {id:1,value:"待支付",isActive:false}, 
      {id:2,value:"待合箱",isActive:false},
      {id:3,value:"待签收",isActive:false},
      {id:4,value:"全部",isActive:true}
    ],
      steps: [
        {
          text: '待入库',
          desc: '进行中',
        },
        {
          text: '待出库',
          desc: '等待中',
        },
        {
          text: '已出库',
          desc: '等待中',
        },
        {
          text: '已签收',
          desc: '等待中',
        },
      ],
      //弹出层
      show: false,
     
   
    },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          sliderLeft: (res.windowWidth / that.data.tabs.length - sliderWidth) / 2,
          sliderOffset: res.windowWidth / that.data.tabs.length * that.data.activeIndex
        });
      }
    });
    var that = this;
    var uid=app.globalData.uid;
    console.log(uid)
      // 获得订单数据  
      wx.request({
        url: "http://localhost:8080/4px_logistics/CommandController/findCommandByUid", 
        data: { 
          'uid':uid,
        },
        method: "POST",
        header: {
          'content-type': 'application/x-www-form-urlencoded'
         // 'Content-Type': 'application/json'
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
              })
              that.setData({
                commandsList: res.data
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
    // this.sysCoupons() 
    // this.getMyCoupons()
    // this.invalidCoupons()
    // ?? 没实现这些函数报错
    this.onLoad()
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

  },
  tabClick: function (e) {
    this.setData({
      sliderOffset: e.currentTarget.offsetLeft,
      activeIndex: e.currentTarget.id
    });
  },
  //弹出层
showPopup() {
  this.setData({ show: true });
},

onClose() {
  this.setData({ show: false });
},

handleTabsItemChange(e){
  let index = e.detail.index;
  this.data.tabs.forEach((item) => item.isActive = item.id === index);
  this.setData({tabs: this.data.tabs});
}



})