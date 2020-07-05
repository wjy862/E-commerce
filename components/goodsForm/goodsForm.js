Component({
  properties: {
    // 这里定义了innerText属性，属性值可以在组件使用时指定
  },
  data: {
    goods: {
      name: '',
      num: 1,
      price: null,
      type: '衣服'
    },

    typeList: ['衣服', '电子产品', '家电', '其他'],
  },
  methods: {
    updateValue(e) {
      // event.detail 为当前输入的值
      let name = e.target.dataset.name;
      this.data.goods[name] = e.detail;
    },

    onSelect(e){
      this.data.goods.type = e.detail.value;
      this.setData({
        goods: this.data.goods,
      })
    },

    handleSave(){
      //可添加检测数据合法性

      this.triggerEvent('add', this.data.goods);
      this.setData({
        goods: {
          name: '',
          num: 1,
          price: null,
          type: '衣服'
        }
      })
    }
  }
})