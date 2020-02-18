var vm = new Vue({
    el: '#app',
    data: {
        user: {
            account:"A",
            password: "",
            url:"/demo/page/index"
        }
    },
    methods:{
        submit:function () {
            var _this = this;
            if(_this.user.account===""){
                alert("choose user");
                return;
            }else if(_this.user.password===""){
                alert("input pass");
                return;
            }
            var url = $("#url").text();
            if(""!==url)
                _this.user.url = url;
            $.ajax({
                url: "/demo/user/login",
                data: _this.user,
                type: "post",
                dataType:"json",
                timeout: 3*60*1000,
                success: function(result){
                    console.log(result);
                    window.location.href = result;
                },
                error: function (e) {
                    console.error(e);
                }
            });
        }
    }
});