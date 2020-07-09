// pages/transport/transport.js
import Toast from '../../miniprogram_npm/@vant/weapp/toast/toast';

Page({

  /**
   * 页面的初始数据
   */
  data: {
    form: {
      store: 1,
      no: null,
      methods: 'methods1',
    },
    
    storeList: [
      { text: '中国大陆仓', value: 1 },
      { text: '其他仓', value: 2 }
    ],

    noErrorMsg: '',
    noValidated: false,

    goodsVisible: false, 
    goodsList: [], // 保存物品信息列表

    methods: 'methods1',

    isAgree: false,
    agreementVisible: false,

    address: '地址地址',

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

    // http
    // 
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