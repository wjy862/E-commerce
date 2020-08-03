// mineComponent/customer/customer.js
const app = getApp();
//const network = require('../../utils/network.js');

let rpx = 1;

wx.getSystemInfo({
  success(res) {
    rpx = res.windowWidth / 375;
  },
})

Component({
  /**
   * 组件的属性列表
   */
  properties: {
    list: {
      type: Array,
      value: [],
      observer: function(newVal, oldVal, changedPath) {
        // console.log(newVal);
      }
    },
    img: {
      type: String,
      value: '',
      observer: function(newVal, oldVal, changedPath) {
        // console.log(newVal);
      }
    },
    isCustomer:{
      type: Boolean,
      value: false,
      observer: function (newVal, oldVal, changedPath) {
        // console.log(newVal);
      }
    }
  },

  /**
   * 组件的初始数据
   */
  data: {
    isChoose: false,
    inputValue: ''
  },

  /**
   * 组件的方法列表
   */
  methods: {
    bindKeyInput: function(e) {
      this.setData({
        inputValue: e.detail.value
      })
    },
    chooseImg: function() {
      let vm = this;
      let x = !vm.data.isChoose;
      vm.setData({
        isChoose: x
      })
    },
    hideChooseImg: function() {
      let vm = this;
      if (vm.data.isChoose) {
        vm.setData({
          isChoose: false,
        })
      }
    },
    toSeeImg: function(e) {
      console.log(e);
      let url = e.currentTarget.dataset.url;
      wx.previewImage({
        current: '', // 当前显示图片的http链接
        urls: [url] // 需要预览的图片http链接列表
      })
    },
    // 发送消息事件
    toSend: function() {
      let vm = this;
      if (vm.data.inputValue != '') {
        let myEventDetail = {
          val: vm.data.inputValue,
          flag: '1'
        };
        let myEventOption = {};
        this.triggerEvent('send', myEventDetail, myEventOption);
      }
    },
    // 选择图片
    toChooseImg: function(e) {
      let vm = this;
      let type = e.currentTarget.dataset.flag;

      wx.chooseImage({
        count: 1,
        sourceType: [type],
        success(res) {
          // tempFilePath可以作为img标签的src属性显示图片
          const tempFilePaths = res.tempFilePaths
          vm.uploadImg(tempFilePaths);
        },
        fail(res) {
          console.log(res.errMsg)
        }
      })
    },
    toHome: function() {
      let myEventDetail = {};
      let myEventOption = {};
      this.triggerEvent('tohome', myEventDetail, myEventOption);
    },
    // 上传图片
    uploadImg: function(d) {
      let vm = this;
      let tempFilePaths = d;
      wx.uploadFile({
        url: '接口地址',
        filePath: tempFilePaths[0],
        name: 'file',
        header: {
          'Authorization': wx.getStorageSync('token')
        },
        success: function(res) {
          var data = JSON.parse(res.data);
          console.log(data);
          //do something
          if (data.Code == 200) {
            let myEventDetail = {
              val: data.Data,
              flag:'2'
            };
            let myEventOption = {};
            vm.triggerEvent('send', myEventDetail, myEventOption);
          } else {
            if (data.Code != 401) {
              wx.showToast({
                title: data.Msg,
                icon: 'none',
                duration: 2500
              });
            } else if (data.Code == 401) {
              wx.showToast({
                icon: 'none',
                title: '登录失效，请重新登录',
              });
              setTimeout(function() {
                let func = function() {
                  wx.reLaunch({
                    url: '../chooseShop/chooseShop',
                  })
                }
                app.userLogin(0, func);
              }, 2500);
            }
          }

        },
        fail:function(err){
          console.log(err);
        }
      })

    },
    // 滚动到最低部
    queryMultipleNodes() {
      let vm = this;
      vm.setData({
        inputValue: ''
      });

      const query = wx.createSelectorQuery().in(this)
      query.select('#j_page').boundingClientRect(function(res) {
        console.log(res);
        wx.pageScrollTo({
          scrollTop: res.height - 100 * rpx
        })
      }).exec()
    }
  },

})