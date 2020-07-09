// pages/order/index.js
const WXAPI = require('../../wxapi/main')

var sliderWidth = 96; // 需要设置slider的宽度，用于计算中间位置
Page({

  /**
   * 页面的初始数据
   */ 
  data: {
    tabs: [
      {id:0,value:"待认领",isActive:true}, 
      {id:1,value:"待支付",isActive:false}, 
      {id:2,value:"待合箱",isActive:false},
      {id:3,value:"待签收",isActive:false},
      {id:4,value:"全部",isActive:false}],
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
    this.sysCoupons()
    this.getMyCoupons()
    this.invalidCoupons()
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
  sysCoupons: function () { // 读取可领取券列表
    var _this = this;
    WXAPI.coupons().then(function (res) {
      if (res.code == 0) {
        _this.setData({
          sysCoupons: res.data
        });
      }
    })
  },
  getCounpon: function (e) {
    const that = this
    if (e.currentTarget.dataset.pwd) {
      wx.showToast({
        title: '请通过优惠券码兑换',
        icon: 'none'
      })
      return
    }
    WXAPI.fetchCoupons({
      id: e.currentTarget.dataset.id,
      token: wx.getStorageSync('token')
    }).then(function (res) {
      if (res.code == 20001 || res.code == 20002) {
        wx.showModal({
          title: '错误',
          content: '来晚了',
          showCancel: false
        })
        return;
      }
      if (res.code == 20003) {
        wx.showModal({
          title: '错误',
          content: '你领过了，别贪心哦~',
          showCancel: false
        })
        return;
      }
      if (res.code == 30001) {
        wx.showModal({
          title: '错误',
          content: '您的积分不足',
          showCancel: false
        })
        return;
      }
      if (res.code == 20004) {
        wx.showModal({
          title: '错误',
          content: '已过期~',
          showCancel: false
        })
        return;
      }
      if (res.code == 0) {
        wx.showToast({
          title: '领取成功，赶紧去下单吧~',
          icon: 'success',
          duration: 2000
        })
      } else {
        wx.showModal({
          title: '错误',
          content: res.msg,
          showCancel: false
        })
      }
    })
  },
  getMyCoupons: function () {
    var _this = this;
    WXAPI.myCoupons({
      token: wx.getStorageSync('token'),
      status: 0
    }).then(function (res) {
      if (res.code == 0) {
        _this.setData({
          myCoupons: res.data
        })
      }
    })
  },
  invalidCoupons: function () {
    var _this = this;
    WXAPI.myCoupons({
      token: wx.getStorageSync('token'),
      status: '1,2,3'
    }).then(function (res) {
      if (res.code == 0) {
        _this.setData({
          invalidCoupons: res.data
        })
      }
    })
  },
//标题的点击事件 从子组件传递过来
handleTabsItemChange(e){
//获得被点击的标题索引
const {index}=e.detail;
//修改源数组
let {tabs}=this.data;
tabs.forEach((v,i)=>i===index?v.isActive=true:v.isActive=false)
//赋值到data中
this.setData({
  tabs
})

}


})