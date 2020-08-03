// pages/example/rebate/index.js
const WXAPI = require('../../../wxapi/main')

var sliderWidth = 96; // 需要设置slider的宽度，用于计算中间位置
Page({

  /**
   * 页面的初始数据
   */
  data: {
    active: '好友明细',
    rebateimg:"https://wxmp.seelles.cn/static/images/rebate.jpg",
    tabs: ["好友明细", "返利明细", "返券明细"]
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
  onChange(event) {
    wx.showToast({
      title: `切换到标签 ${event.detail.name}`,
      icon: 'none',
    });
  },

  /**
   * 分享推广
   */
  onShareAppMessage: function (ops) {
    console.log(ops);
    /**https://blog.csdn.net/qq_34246850/article/details/80334978 */
    return {
      title: "这是标题",
      imageUrl: this.rebateimg, // 这是分享封面图片地址
      // path: '/pages/rebate/index', 默认是当前页面，必须是以‘/’开头的完整路径
      success: function(res) {
        console.log(res, "转发成功")
      },
      fail: function(res) {
        console.log(res, "转发失败")
      }
    }
    
  }

})