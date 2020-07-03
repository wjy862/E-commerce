//index.js
//引入发送请求的方法，把路径补充完整
import{ request} from "../../request/index.js";
wx-Page({

  /**
   * 页面的初始数据
   */
  data: {
   //轮播图数组
   swiperList:[] ,
     //导航栏数组
     catesList:[ {image_src:'https://www.dhfapp.com/wp-content/uploads/2019/12/image-5.png',name:'1'} ,
     {image_src:'https://www.dhfapp.com/wp-content/uploads/2019/12/image-5.png',name:'2'} ,
     {image_src:'https://n.sinaimg.cn/www/crawl/93/w550h343/20190715/9175-hzuhxyp8889896.jpg',name:'3'} ,
     {image_src:'https://n.sinaimg.cn/www/crawl/93/w550h343/20190715/9175-hzuhxyp8889896.jpg',name:'4'}] ,
   /**
   movies:[
    {url:'https://www.dhfapp.com/wp-content/uploads/2019/12/image-5.png'} ,
    {url:'https://www.dhfapp.com/wp-content/uploads/2019/12/image-5.png'} ,
    {url:'https://www.dhfapp.com/wp-content/uploads/2019/12/image-5.png'} ,
    {url:'https://n.sinaimg.cn/www/crawl/93/w550h343/20190715/9175-hzuhxyp8889896.jpg'}
    ]
  */
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
    links:[
      '../user/index',
      '../cart/index',
      '../category/index'
    ],
    floorList:[
      // message:[[floor_title],[product_liste]],
       {floor_title:{name:"fasion",image_src:"https://p3.pstatp.com/large/31fa0003ed7228adf421"},product_list:[{name:"image1",image_src:"http://zh.iphone-wallpapers.at-web.org/%E8%83%8C%E6%99%AF-640-960/iphone-%E5%85%8D%E8%B4%B9%E5%A2%99%E7%BA%B8%E5%9B%BE%E5%83%8F%E7%94%B5%E8%AF%9D-%E6%A2%A6%E6%83%B3%E7%B2%BE%E8%87%B4%E7%9A%84-%E7%94%B5%E6%B1%A0%E5%A3%81%E7%BA%B8%E5%85%8D%E8%B4%B9%E4%B8%8B%E8%BD%BD-86.jpg",image_width:233,open_type:"navigate",navigator_url:"pages/goods_list/index?query=image1"},{name:"spring",image_src:"https://p3.pstatp.com/large/31fa0003ed7228adf421",image_width:233,open_type:"navigate",navigator_url:"pages/goods_list/index?query=spring"},{name:"summer",image_src:"https://p3.pstatp.com/large/31fa0003ed7228adf421",image_width:233,open_type:"navigate",navigator_url:"pages/goods_list/index?query=summer"},{name:"autumn",image_src:"https://p3.pstatp.com/large/31fa0003ed7228adf421",image_width:233,open_type:"navigate",navigator_url:"pages/goods_list/index?query=autumn"},{name:"winter",image_src:"https://p3.pstatp.com/large/31fa0003ed7228adf421",image_width:233,open_type:"navigate",navigator_url:"pages/goods_list/index?query=winter"}]},
       {floor_title:{name:"fasion",image_src:"https://p3.pstatp.com/large/31fa0003ed7228adf421"},product_list:[{name:"image1",image_src:"http://zh.iphone-wallpapers.at-web.org/%E8%83%8C%E6%99%AF-640-960/iphone-%E5%85%8D%E8%B4%B9%E5%A2%99%E7%BA%B8%E5%9B%BE%E5%83%8F%E7%94%B5%E8%AF%9D-%E6%A2%A6%E6%83%B3%E7%B2%BE%E8%87%B4%E7%9A%84-%E7%94%B5%E6%B1%A0%E5%A3%81%E7%BA%B8%E5%85%8D%E8%B4%B9%E4%B8%8B%E8%BD%BD-86.jpg",image_width:233,open_type:"navigate",navigator_url:"pages/goods_list/index?query=image1"},{name:"spring",image_src:"https://p3.pstatp.com/large/31fa0003ed7228adf421",image_width:233,open_type:"navigate",navigator_url:"pages/goods_list/index?query=spring"},{name:"summer",image_src:"https://p3.pstatp.com/large/31fa0003ed7228adf421",image_width:233,open_type:"navigate",navigator_url:"pages/goods_list/index?query=summer"},{name:"autumn",image_src:"https://p3.pstatp.com/large/31fa0003ed7228adf421",image_width:233,open_type:"navigate",navigator_url:"pages/goods_list/index?query=autumn"},{name:"winter",image_src:"https://p3.pstatp.com/large/31fa0003ed7228adf421",image_width:233,open_type:"navigate",navigator_url:"pages/goods_list/index?query=winter"}]},
       
       {floor_title:{name:"fasion",image_src:"https://p3.pstatp.com/large/31fa0003ed7228adf421"},product_list:[{name:"image1",image_src:"http://zh.iphone-wallpapers.at-web.org/%E8%83%8C%E6%99%AF-640-960/iphone-%E5%85%8D%E8%B4%B9%E5%A2%99%E7%BA%B8%E5%9B%BE%E5%83%8F%E7%94%B5%E8%AF%9D-%E6%A2%A6%E6%83%B3%E7%B2%BE%E8%87%B4%E7%9A%84-%E7%94%B5%E6%B1%A0%E5%A3%81%E7%BA%B8%E5%85%8D%E8%B4%B9%E4%B8%8B%E8%BD%BD-86.jpg",image_width:233,open_type:"navigate",navigator_url:"pages/goods_list/index?query=image1"},{name:"spring",image_src:"https://p3.pstatp.com/large/31fa0003ed7228adf421",image_width:233,open_type:"navigate",navigator_url:"pages/goods_list/index?query=spring"},{name:"summer",image_src:"https://p3.pstatp.com/large/31fa0003ed7228adf421",image_width:233,open_type:"navigate",navigator_url:"pages/goods_list/index?query=summer"},{name:"autumn",image_src:"https://p3.pstatp.com/large/31fa0003ed7228adf421",image_width:233,open_type:"navigate",navigator_url:"pages/goods_list/index?query=autumn"},{name:"winter",image_src:"https://p3.pstatp.com/large/31fa0003ed7228adf421",image_width:233,open_type:"navigate",navigator_url:"pages/goods_list/index?query=winter"}]}
       
      ],
      //objct-> items
      meta:{msg:"获取成功",status:200}
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


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
    //发送异步请求获取轮播图数据
    /*
    wx.request({
      url: 'http://api.zbztb.cn/api/public/v1/home/swiperdata',
      success: (result) => {
       // console.log(result);
       this.setData({
         swiperList:result.data.message
       })
      },
    })
  */

 
 //使用在request中封装的函数
 //this.getSwiperList();
 //this.getCateList();

},

//获取轮播图数据
getSwiperList(){
  request({url:"http://api.zbztb.cn/api/public/v1/home/swiperdata",})
 .then(result=>{
  this.setData({
    swiperList:result.data.message
  })
 })
 //同层级无限制点下去
 .then(result=>{
  this.setData({
    swiperList:result.data.message
  })
 })
},
//获取分类导航数据
getCateList(){
  request({url:"http://api.zbztb.cn/api/public/v1/home/swiperdata",})
 .then(result=>{
  this.setData({
    catesListe:result.data.message
  })
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