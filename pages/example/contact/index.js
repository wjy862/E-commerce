Page({
  data: {
    receiver: 'FR79343962',
    address: '沙田镇西大坦启盈国际快件中心15#递四方Z集运仓#FR79343962#',
    city: 'dongguan',
    state: '广东省',
    country: '中国大陆',
    zipCode: '526533',
    tel: '8888888888',
  },

  onCopy(e) {
    let key = e.target.dataset.key;
    if(!this.data[key]){
      console.error(`Not find data.${key}`)
      return
    }
    wx.setClipboardData({
      //准备复制的数据
      data: this.data[key],
      success: function (res) {
        wx.showToast({
          title: '复制成功',
        });
      }
    });
  },
})