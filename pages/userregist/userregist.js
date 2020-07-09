Page({

    /**
     * 页面的初始数据
     */
    data: {
        
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

    },
    formSubmit: function (e) {
        var that = this;
        var telephone = e.detail.value.telephone;
        var pwd = e.detail.value.pwd;
        var pwd2 = e.detail.value.pwd2;
        if(telephone == ""||pwd == ""||pwd2 == ""){
            wx.showToast({
                title: '输入不能为空',
                icon: 'loading'
            })
            return;
        }
        if (pwd != pwd2) {
            wx.showToast({
                title: '输入密码不一致',
                icon: 'loading'
            })
            return;
        }
        wx.showModal({
            title: '提示',
            content: '确定要提交吗?',
            success(res) {
                if (res.confirm) {
                    wx.request({
                        url: "http://localhost:8080/4px_logistics/UserController/userAdd",
                        data: {
                            'telephone':telephone,
                            'pwd':pwd,
                        },
                        header: {
                            'content-type': 'application/x-www-form-urlencoded'
                        },
                        success: function (res) {
                            console.log(res)
                            console.log(res.data)
                            console.log(res.data ==true)
                            console.log("true" == "true")
                            if (res.data == true) {
                                wx.showToast({
                                    title: '注册成功',
                                    duration: 3000,
                                    icon: 'success'
                                })
                            } else if (res.data == false) {
                                wx.showToast({
                                    title: '该电话已被注册，注册失败' ,
                                    duration: 3000,
                                    icon: 'loading'
                                })
                            }else {
                                wx.showToast({
                                    title: '服务器升级中',
                                    duration: 3000,
                                    icon: 'loading'
                                })
                            }
                        }
                    })
                } else if (res.cancel) {
                    console.log('用户点击取消')
                }
            }
        })

    }
})