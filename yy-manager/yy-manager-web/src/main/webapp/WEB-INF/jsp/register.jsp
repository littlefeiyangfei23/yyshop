<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form class="userForm" id="userRegisterForm" name="userRegisterForm" method="post">
    <table border="1" bordercolor="blue" align="center" width="600" height="400" cellspacing="0" >
        <tr height="100" >
            <th bgcolor="crimson" style="color: darkblue;"colspan="3">欢迎注册</th>
        </tr>
        <tr align="center">
            <td>用户名：<input type="text" name="username" id="username"><span id="sp1"></span> </td>
        </tr>
        <tr align="center">
            <td>密码：<input type="text" name="upwd" id="upwd"><span id="sp2"></span></td>
        </tr>
        <tr align="center">
            <td>
                <input type="submit" name="submit1" value="注册" />
                <input type="reset" name="reset" value="重置"  />
                <br>
                <a href="login">已有账号？去登录</a>
            </td>
        </tr>

    </table>

</form>

<!-- jquery -->
<script src="js/jquery-easyui-1.5/jquery.min.js"></script>
<script>
    //ready函数
    $(function(){
        //submit里面一个回调函数
        //submit提交的时候，注册一个事件对象到e里面去
        $("#userRegisterForm").submit(function(e){
            // alert(1);
            var un=$("#username").val();
            var pw=$("#upwd").val();
//               alert(un);
            var flag1=false;
            var flag2=false;

            if(un==null ||un==""){
                $("#sp1").html("用户名不能为空").css('color','red');
            }
            else{
                $("#sp1").html("");
                flag1=true;
            }

            if(pw==null ||pw==""){
                $("#sp2").html("密码不能为空").css('color','red');
            }
            else{
                $("#sp2").html("");
                flag2=true;
            }
            //在这里，不管他有没有验证成功，都先不要提交表单，要阻止表单提交
            e.preventDefault();
            //&1个2个都可以,2个&是短路法，效率高
            if(flag1&&flag2){
                //ajax提交表单
//                alert(111111)
                var param={"username":un,"upwd":pw};


                $.ajax({
                    url:"userRegister",
                    data:param,
                    dataType:"text",
                    type:"post",
                    cache:false,
                    //写了个变量rec接收后台传过来的值
                    success:function(rec){
                        alert(rec)
                        //alert(rec.mess)

                        //alert(info)
                        if(rec==0){
                            $("#sp1").html("用户名不能为空");

                        } else if(rec==1){
                            $("#sp2").html("密码不能为空");
                            alert(321)
                        }else if(rec==2){
                            $("#sp1").html("用户名已存在");
                        }else{
                            alert("注册成功")
                            location.href="${pageContext.request.contextPath}/index"
                        }
                    },
                    error:function(){
                        alert("系统错误，注册失败")
                    }

                });

            }
        });
    })

</script>


</body>
</html>
