var vm = new Vue({
    el:"#app",
    data:{

    },
    methods:{
        loginOut:function () {
            $.ajax({
                url: "/demo/user/loginOut",
                type: "post",
                timeout: 3*60*1000,
                success:function () {
                    window.location.href = "/demo/page/login"
                },
                error:function (result) {
                    console.log(result);
                }
            });
        }
    }
});