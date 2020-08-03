// pages/home/home.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    swiperCurrent: 0,
    indicatorDots: true,
    autoplay: true,
    interval: 3000,
    duration: 800,
    circular:true,
    imgUrls: [
      'https://p3.pstatp.com/large/43700001e49d85d3ab52',
      'https://p3.pstatp.com/large/39f600038907bf3b9c96',
      'https://p3.pstatp.com/large/31fa0003ed7228adf421'
    ],
    switchItems:[
      {icon:"logistics",text:"我要转运",bindtap:"gotopage",url:"../transport/transport"},
      {icon:"refund-o",text:"我要返利",bindtap:"gotopage",url:"../rebate/index"},
      {icon:"paid",text:"我的优惠券",bindtap:"gotopage",url:"../example/coupons/index"}, 
      {icon:"balance-o",text:"服务价格",bindtap:"gotopage",url:"../service/index"},
      {icon:"location-o",text:"中转仓地址",bindtap:"gotopage",url:"../storage/index"},
      {icon:"warn-o",text:"禁运物品查询",bindtap:"gotopage",url:"../example/ban/index"},
  ],
    flowProcessList: [{name:"购物",description:"使用仓库地址购物"},{name:"预报",description:"填写需转运的包裹信息"},{name:"支付",description:"支付转运费用"},{name:"收获",description:"坐等收货"}],
    uid: "testhome",
    arrow:'https://wxmp.seelles.cn/static/images/right.png'
    
  

  },
  //轮播图的切换事件
swiperChange: function (e) {
  this.setData({
    swiperCurrent: e.detail.current
  })
},
//点击指示点切换
chuangEvent: function (e) {
  this.setData({
    swiperCurrent: e.currentTarget.id
  })
},
//点击swip图片触发事件
swipclick: function (e) {
  console.log(this.data.swiperCurrent);
  //跳转到tabbar页面
  wx.switchTab({
    url: this.data.links[this.data.swiperCurrent]
  })
},

gotopage: function (event) {
  console.log(event)
  wx.navigateTo({
    url: event.currentTarget.dataset.hi
  })
},

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      var that = this
      that.setData({
        uid:getApp().globalData.uid,
        
      })
      app.globalData.uid = this.data.uid;
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
  
      // 获取数据
      app.getUid()
      // 更改数据
      let obj = {
        uid: this.data.uid
      }
      app.updateUid(obj) 
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