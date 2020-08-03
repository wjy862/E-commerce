// pages/service/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    //compensationimg:["../../image/share1.jpg","../../image/share2.jpg","../../image/share3.jpg"]
   // compensationimg:["../../image/share.jpg"],  
    //shareround:["../../image/shareround.jpg"]
    compensationimg:["https://wxmp.seelles.cn/static/images/share.jpg"],
    shareround:["https://wxmp.seelles.cn/static/images/shareround.jpg"]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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
  onShareAppMessage: function (ops) {
    console.log(ops);
    /**https://blog.csdn.net/qq_34246850/article/details/80334978 */
    return {
      title: "这是标题",
      imageUrl: this.data.shareround[0],// 这是分享封面图片地址
      path: '/pages/rebate/index',        // 默认是当前页面，必须是以‘/’开头的完整路径
      success: function(res) {
        console.log(res, "转发成功")
      },
      fail: function(res) {
        console.log(res, "转发失败")
      }
    }
    
  }
})