<template>
  <div id="banner">
    <el-row class="typeNav">
      <el-col :span="12">
        <h5>全部商品分类</h5>
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
        >
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>运动户外、箱包</span>
            </template>
          </el-submenu>
          <el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <span slot="title">家用电器</span>
          </el-menu-item>
          <el-menu-item index="3" disabled>
            <i class="el-icon-document"></i>
            <span slot="title">手机、数码、充值</span>
          </el-menu-item>
          <el-menu-item index="4">
            <i class="el-icon-setting"></i>
            <span slot="title">服饰内衣</span>
          </el-menu-item>
          <el-menu-item index="5">
            <i class="el-icon-menu"></i>
            <span slot="title">个护化妆</span>
          </el-menu-item>
          <el-menu-item index="6" disabled>
            <i class="el-icon-document"></i>
            <span slot="title">家居、家装</span>
          </el-menu-item>
          <el-menu-item index="7">
            <i class="el-icon-setting"></i>
            <span slot="title">母婴、玩具</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>

    <div class="block">
      <el-carousel height="150px">
        <el-carousel-item v-for="(img, item) in imgList" :key="item">
          <img v-bind: src="img.url" />
        </el-carousel-item>
      </el-carousel>
    </div>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      imgList: [
        { url: require("./assets/1.png") },
        { url: require("./assets/2.png") },
      ],
    };
  },
};
</script>

<style>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}
.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>
