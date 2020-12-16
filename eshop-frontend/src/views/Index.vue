<template>
  <el-container class="index-container">
    <!--        上边框-->
    <!--搜索框-->
    <el-header>
      <div class="search">
        <el-input v-model="input" placeholder="请输入内容"></el-input>
      </div>
      <!--            开启了路由模式-->
      <!--未登录状态-->
      <el-menu
        v-if="!isLogin"
        router
        class="el-menu-header"
        mode="horizontal"
        default-active="/Welcome"
      >
        <el-menu-item index="/welcome">首页</el-menu-item>
        <el-menu-item index="/login">登录</el-menu-item>
        <el-menu-item index="/userRegister">用户注册</el-menu-item>
      </el-menu>
      <!--登录状态-->
      <div class="out-button" v-if="isLogin">
        <el-menu
          router
          class="el-menu-header"
          mode="horizontal"
          default-active="/Welcome"
        >
          <el-menu-item index="/orders">我的订单</el-menu-item>
          <el-menu-item index="/shoppingCart">我的购物车</el-menu-item>
          <el-menu-item index="/personalInfo">个人信息</el-menu-item>
        </el-menu>
      </div>
    </el-header>
    <!--        主体区域-->
    <el-main>
      <!--            路由占位符-->
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      input: "",
    };
  },
};
</script>
