// pages/transport/transport.js
import Toast from '../../miniprogram_npm/@vant/weapp/toast/toast';
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    form: {
      store: '中国大陆仓',
      no: null,
      methods: 'methods1',
      service: '默认合箱运转',
      serviceDescription: '无',
      insurance: '无',
      direction: '法国寄往中国',
      route: '尚未选择',
    },
    aid:1,
    storeList: [
      { text: '中国大陆仓', value: '中国大陆仓' },
      { text: '其他仓', value: '其他仓' }
    ],

    serviceList: [
      { text: '中法空运快线', value: '中法空运快线' },
      { text: '中法小包快线', value: '中法小包快线' }
    ],

    insuranceList: [
      { text: '无', value: '无' },
      { text: '基本套餐', value: '基本套餐' }
    ],
    directionList: [
      { text: '法国寄往中国', value: '法国寄往中国' },
      { text: '中国寄往法国', value: '中国寄往法国' }
    ],
    routeList: [
      { text: '航空', value: '航空' },
      { text: '铁路', value: '铁路'},
      { text: '海运', value: '海运'}
    ],

    noErrorMsg: '',
    noValidated: false,

    goodsVisible: false, 
    goodsList: [], // 保存物品信息列表
    


    methods: 'methods1',

    isAgree: false,
    agreementVisible: false,

    address: '地址地址',
    serviceDescription: '无',
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
    this.data.form[name] = e.detail;
  },

  updateServiceValue(e) {
    console.log(e)
    // event.detail 为当前输入的值
    let name = e.target.dataset.name;
    this.data.form[name] = e.detail;
    console.log(e.detail)
    let nameDescription = e.target.dataset.name+"Description";
    console.log(nameDescription)
    if(e.detail=="中法空运快线"){
      console.log(1)
      this.data.form[nameDescription] ="0-0.5千克。。。。。。。。。。。。。。。。。。。。说明说明说明说明说明说明说明说明说明说明";
      console.log(this.data.form[nameDescription] )
    }else if(e.detail=="中法小包快线"){
      console.log(2)
      this.data.form[nameDescription] ="每票收30CNY。。。。。。。。。。。。。。。。。。。。说明说明说明说明说明说明";
      console.log(this.data.form[nameDescription] )
    }
  },
  updateInsuranceValue(e) {
    // event.detail 为当前输入的值
    let name = e.target.dataset.name;
    this.data.form[name] = e.detail;
  },
  
  updateDirectionValue(e) {
    // event.detail 为当前输入的值
    let name = e.target.dataset.name;
    this.data.form[name] = e.detail;
  },



  onCheckNo(e){
    let value = e.detail;
    let msg = '';
    let isValidated = false;
    if(/^[0-9a-zA-Z]{3,64}$/.test(value)){
      msg = '';
      isValidated = true;
    }else{
      msg = '请输入3-64位数字或字母';
    }
    this.setData({
      noErrorMsg: msg,
    });
    this.data.noValidated = isValidated;
    return isValidated
  },

  showGoods(){
    this.setData({
      goodsVisible: true
    })
  },

  onClose() {
    this.setData({ goodsVisible: false });
  },

  handleAddGoods(e){
    this.data.goodsList.push(e.detail);
    this.setData({
      goodsList: this.data.goodsList,
      goodsVisible: false
    })
  },

  handleRemoveGoods(e){
    let index = e.target.dataset.index;
    this.data.goodsList.splice(index, 1);
    this.setData({
      goodsList: this.data.goodsList
    })
  },

  onChangeMethods(e){
    this.data.methods = e.detail.name;
    this.data.form.methods = this.data.methods;
  },

  onChangeAgree(e){
    console.log(e);
    this.setData({
      isAgree: e.detail
    })
  },

  showAgreement(){
    this.setData({
      agreementVisible: true
    })
  },

  onSubmit(){
    if(!this.data.isAgree){
      Toast.fail('请同意《服务协议》');
      return
    }
    // 加上物品信息
    let data = JSON.parse(JSON.stringify(this.data.form));
    data.goodsList = this.data.goodsList;
    // form 表单取值，格式 e.detail.value.name(name为input中自定义name值)
    var that = this;
  
    var depotname = this.data.form.store;
    console.log("depotname:"+depotname)
    var numcn = this.data.form.no;
    console.log("numcn:"+numcn)
    if(this.data.form.methods=="methods1"){
    var typetransport = "合箱转运";
    }else if(this.data.form.methods=="methods2"){
    var typetransport = "单票转运";
    }
    console.log("typetransport:"+typetransport)
    var service = this.data.form.service;
    console.log("service:"+service)
    var insurance = this.data.form.insurance;
    console.log("insurance:"+insurance)
    var uid=getApp().globalData.uid
    console.log("uid:"+uid)
    if(app.globalData.aid!=null){
      var aid=app.globalData.aid
    }else{
      var aid=this.data.aid
    }
    console.log("app.globalData.aid:"+app.globalData.aid)
    console.log("this.data.aid:"+this.data.aid)
    console.log("aid:"+aid)
    console.log(data.goodsList)
    var direction = this.data.form.direction;
    console.log("direction:"+direction)
    var route = this.data.form.route;
    console.log("route:"+route)


    // 添加订单  
    wx.request({
      url: "http://localhost:8080/4px_logistics/CommandController/commandAdd", 
      data: { 
        'depotname': depotname,
        'numcn': numcn,
       'typetransport': typetransport,
        'service': service,
        'insurance': insurance,
        'uid':uid,
        'aid':aid,
        'direction':direction,
        'route':route,
        'parcelList':data.goodsList
      },
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
       // 'Content-Type': 'application/json'
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
          
            wx.switchTab({
              url: '../order/index' 
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
     // 添加包裹

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
  onShareAppMessage: function () {

  }
 
})