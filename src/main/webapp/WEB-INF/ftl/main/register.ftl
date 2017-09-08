<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>翻译详情</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<style type="text/css">
    #top{width: 100%;  height: 60px;}
    #mainBody{background-image: url(sky.gif) ;  width: 100%;  position: absolute;  top: 60px;  bottom: 0px;  left: 0px;}
    #detailsTable{opacity: 0.8}
    th{text-align: center}
    tr{height: 120px;font-size: 20px}
    td img{border-radius: 50%;height:100px}
</style>
<body>
<nav class="navbar navbar-inverse" id="top" role="navigation" >
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#" style="color: #00a7d0">DeepWalk手语翻译</a>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-log-in"></span>登录</a></li>
                <li><a style="color: #00a7d0">----关爱聋人，让世界充满爱</a></li>
            </ul>
        </div>
    </div>
</nav>
<div id="mainBody">

</div>
<!--下面这个div定义弹出模态框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel" align="center">
                    登录账户
                </h4>
            </div>
            <div class="modal-body"><input type="text" class="form-control" id="name" placeholder="手机号"></div>
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