<template>
    <body id="poster">
        <el-container>
            <el-form ref="loginFormRef" :model="loginFormRef" :rules="loginFormRules" class="login-container" label-position="left" label-width="0px">
                <h3 class= "login_title">登录</h3>
                <el-form-item prop="username">
                    <el-input type="text" v-model="loginForm.username" auto-complete="off" placeholder="用户名/邮箱号/手机号"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input type="text" v-model="loginForm.password" auto-complete="off" placeholder="请输入密码"></el-input>
                </el-form-item>
                <el-form-item style="width: 100%">
                    <el-button
                        type="primary"
                        style="width: 100%;backgroud: #505458;border: none"
                        v-on:click="login"
                        >登录</el-button>
                </el-form-item>
            </el-form>
        </el-container>
    </body>
</template>

<script>
export default {
    data () {
        return {
            //登录表单数据绑定
            loginForm: {

                username: "",
                password: "",
                imgUrl: "",
            },
            show: true,
            //表单的验证规则
            loginFormRules: {
                //验证用户名是否合法
                username: [
                    {  required: true, message: "请输入用户名", trigger: "blur" },
                    {
                        min: 3,
                        max: 10,
                        message: "用户名必须在3-10个字符之间",
                        trigger: "blur",
                    },
				],
				//	验证密码是否合法
				password: [
					{ required: true, message: "请输入密码", trigger: "blur"},
					{
						min: 6,
						max: 50,
						message: "密码必须在6-15个字符之间",
						trigger: "blur",
					}
				]
            }
        }
    }
}

</script>