import Vue from 'vue'
import VueRouter from 'vue-router'

import Index from '../views/Index'

import AdminHome from '../views/AdminHome'

import UserHome from '../views/UserHome'

import MerchantHome from '../views/MerchantHome'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: Index,
    // 访问项目时自动重定向到homePage
    redirect: '/index',
    // index页面的一些子路由
    children: [
    ]
  },
  {
    path: '/adminHome',
    component: AdminHome,
    redirect: '/adminIndex',
    children: [
    ]
  },
  {
    path: '/userHome',
    component: UserHome,
    redirect: '/userIndex',
    children: [
    ]
  },
  {
    path: '/merchantHome',
    component: MerchantHome,
    redirect: '/merchantIndex',
    children: [
    ]
  }
]

const router = new VueRouter([
  routes
])

// //挂载路由导航守卫
// router.beforeEach((to, from, next) => {
//   if (to.path === '/login' || to.path === '/studentRegister' || to.path === '/welcome') {
//     return next();
//   }
//   else {
//     //    获取token
//     let token = window.sessionStorage.getItem("token");
//     if (!token) return next("/welcome");
//     else return next();
//   }
// });

export default router
