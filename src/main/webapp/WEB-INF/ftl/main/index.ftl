<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>新用户注册</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<style type="text/css">
    #top{width: 100%;  height: 60px;}
    #mainBody{
        background-image: url(oilbackg.jpg) ;
        background-repeat:no-repeat;
        background-size: 100%;
        width: 100%;
        position: absolute;
        top: 60px;
        bottom: 0px;
        left: 0px;
    }
    #mainBody label,h2{color: yellow}


</style>
<body>
<nav class="navbar" id="top" role="navigation" style="background-color: #6442CF">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#" style="color: white">DeepWalk手语翻译</a>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li><a style="color:white">《新用户注册》</a></li>
                <li><a href="#" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-log-in" style="color: white">登录</span></a></li>
                <li><a style="color: white">----关爱聋人，让世界充满爱</a></li>
            </ul>
        </div>
    </div>
</nav>
<div id="mainBody">
    <div id="registerForm" style="text-align: center;position: absolute;left: 30%;top:10%;border-style: double">
        <form class="form-horizontal" role="form" style="opacity: 0.8;width: 550px;height:400px">
            <div><h2>我的账户</h2></div>
            <div>
                <label for="userName" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="userName"
                           placeholder="请输入用户名">
                </div>
            </div><br><br><br>

            <div>
                <label for="passwrd" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="passwrd"
                           placeholder="请输入密码">
                </div>
            </div><br><br><br>
            <div>
                <label for="surePassWrd" class="col-sm-2 control-label">确认密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="surePassWrd"
                           placeholder="请确认密码">
                </div>
            </div><br><br><br>
            <div>
                <label for="email" class="col-sm-2 control-label">邮箱</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="email"
                           placeholder="请输入邮箱">
                </div>
            </div>
            <div style="position: absolute;right: 20px;bottom:40px">
                <button type="button" class="btn btn-default " style="width: 180px;height: 40px">取消</button>
                <button type="button" class="btn btn-primary " style="width: 180px;height: 40px">确认并提交</button>
            </div>
        </form>
    </div>
</div>
<!--下面这个div定义弹出模态框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="background-image: url(oilbackg.jpg)">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel" align="center" style="color: white">
                    登录账户
                </h4>
            </div>
            <div class="modal-body"><input type="text" class="form-control" id="emailNum" placeholder="邮箱"></div>
            <div class="modal-body"><input type="password" class="form-control" id="password" placeholder="密码"></div>
            <div class="modal-body"><button type="button" class="btn btn-primary btn-lg btn-block">登录</button></div>
            <div class="modal-footer">
                <button style="background: transparent;border: 0"><a>忘记密码</a></button>
                <button style="background: transparent;border: 0"><a>新用户注册</a></button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!--模态框定义结束 -->
</body>
</html>