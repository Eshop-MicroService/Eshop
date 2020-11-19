import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

// index页面和它的组件
import Index from '../views/Index'

// adminHome页面和它的组件
import AdminHome from '../views'

// userHome页面和它的组件
import UserHome from '../views'

// merchantHome页面和它的组件
import MerchantHome from '../views'

Vue.use(Router)

// const routes = [
//   {
//     path: '/',
//     component: Index
//     //访问项目时自动重定向到welcome页面

//   },
//   {

//   }
// ]

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    }
  ]
})
