// pages/transport/transport.js
import Toast from '../../miniprogram_npm/@vant/weapp/toast/toast';
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    aid:null,
    form: {
      aname: '尚未填写',
      atelephone: '尚未填写',
      aadress: '尚未填写',
      acp: '尚未填写',
      appartement: '尚未选择',
      city: '尚未选择',
    },
    aname: '尚未填写',
    atelephone: '尚未填写',
    aadress: '尚未填写',
    acp: '尚未填写',
    appartement: '尚未选择',
    city: '123',

    appartementList: [
      { text: 'Haute-Garone', value: 'Haute-Garone' },
      { text: 'Aquitaine', value: 'Aquitaine'},
      { text: 'Ile de France', value: 'Ile de France'}
    ],

    cityList: [
      { text: 'Paris', value: 'Paris' },
      { text: 'Toulouse', value: 'Toulouse'},
      { text: 'Bordeaux', value: 'Bordeaux'}
    ],

    noErrorMsg: '',
    noValidated: false,
    show: false,
    actions: [
      {
        name: '选项',
      },
      {
        name: '选项',
      },
      {
        name: '选项',
        subname: '副文本',
        openType: 'share',
      },
    ],
  },


  onClose() {
    this.setData({show: false});
  },

  onSelect(event) {
    console.log(event.detail);
  },

  updateValue(e) {
    // event.detail 为当前输入的值
    let name = e.target.dataset.name;
    this.data[name] = e.detail;
  },



  onCheckNo(e){
    let value = e.detail;
    let msg = '';
    let isValidated = false;
    if(/^[0-9a-zA-Z]{5,15}$/.test(value)){
      msg = '';
      isValidated = true;
    }else{
      msg = '请输入3-15位数字或字母';
    }
    this.setData({
      noErrorMsg: msg,
    });
    this.data.noValidated = isValidated;
    return isValidated
  },

  onSubmit(){
    console.log(this.data.aname)
    console.log(this.data.atelephone)
    console.log(this.data.aadress)
    console.log(this.data.acp)
    console.log(this.data.form.appartement+'\n'+this.data.form.city)
    console.log(getApp().globalData.uid)
    console.log(this.data.aid)
    // form 表单取值，格式 e.detail.value.name(name为input中自定义name值)
    // 跟新订单  
    wx.request({
      url: "http://localhost:8080/4px_logistics/AdressController/adressUpdate", 
      data: { 
        'aname': this.data.aname,
        'atelephone': this.data.atelephone,
        'aadress': this.data.aadress,
        'acp': this.data.acp,
        'adepartement': this.data.form.appartement+'\n'+this.data.form.city,
        'uid':getApp().globalData.uid,
        'aid': this.data.aid
      },
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        console.log(res)
       
        if (res.data== true) {
          wx.showToast({
              title: '提交成功',
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
    var that = this;
    //获取地址id
      this.setData({
        aid:options.aid
      }),  
      //获取地址信息
      wx.request({
        url: "http://localhost:8080/4px_logistics/AdressController/adressFindOne", 
        data: { 
          'aid': this.data.aid
        },
        method: "POST",
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        success: function (res) {
          console.log(res)
          console.log(res.statusCode)
          
          if (res.statusCode== 200) {
            wx.showToast({
                title: '提交成功',
                icon: 'success',
                duration: 20000
              })
              setTimeout(function(){
                wx.hideToast();
              }),
            that.setData({
              aname: res.data.aname,
              atelephone: res.data.atelephone,
              aadress: res.data.aadress,
              acp: res.data.acp,
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