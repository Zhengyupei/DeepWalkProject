<!--details Page-->
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
    @-webkit-keyframes  shineBlue {
        from { -webkit-box-shadow: 0 0 5px #bbb; }
        50% { -webkit-box-shadow: 0 0 20px blue; }
        to { -webkit-box-shadow: 0 0 5px #bbb; }
    }
    .shine_blue{
        -webkit-animation-name: shineBlue;
        -webkit-animation-duration: 4s;
        -webkit-animation-iteration-count: infinite;
    }
    #top{width: 100%;  height: 60px;}
    #picturemainBody{
        background-image: url(static/image/oilback.jpg) ;
        background-repeat:no-repeat;
        background-size: 100%;
        width: 100%;
        position: absolute;
        top: 60px;
        bottom: 0px;
        left: 0px;
        overflow-y: scroll;
    }
    .rahmen{
        width: 200px;
        background: #DD8CB1;
        position:absolute;
        border-style: double;
    }
    .film{
        background-color: #D7CEFF;
        width:150px;
        position:absolute;
        text-align: center;
        margin-left: 20px;
        margin-top: 15px;
    }
    .film img{
        height:130px;
        width: 150px
    }
    .film div{
        position: absolute;
        margin-top: 10%
    }
    .film h3{
        color:red
    }
</style>


<body>
<nav class="navbar" id="top" role="navigation" style="background-color: #6442CF">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#" style="color: white">DeepWalk手语翻译</a>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li><a style="color: white">《翻译详情页》</a></li>
                <li><a href="#" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-log-in" style="color: white">登录</span></a></li>
                <li><a style="color: white">----关爱聋人，让世界充满爱</a></li>
            </ul>
        </div>
    </div>
</nav>

<!--end of nav above-->
<div id="picturemainBody">
</div>
<script type="text/javascript">
    function loadPictureWall(){
        //   for (Span span : Spans){}
        var NORMALCOUNT=6;
        var ranArr=new Array([NORMALCOUNT]);
        var marginLeft=new Array([NORMALCOUNT]);marginLeft[0]=40;marginLeft[1]=260;marginLeft[2]=480;marginLeft[3]=700;marginLeft[4]=920;marginLeft[5]=1140;
        var bigHtml='';var row=0;var placedPictures=0;
        //产生一组大div height随机数组
        for(var i=0;i<NORMALCOUNT;i++){
            var random =Math.floor(230+Math.random()*60);
            ranArr[i]=random;
        }
        while(placedPictures<100){//暂且假设有这么多张照片
            var totalInnerHtml='';
            for(var k=0;k<6 && placedPictures<100;k++){
                marginT=ranArr[k];marginL=k*190;
                var preFix='<div class="rahmen shine_blue" style="height:'+ranArr[k]+'px;margin-left:'+marginLeft[k]+'px;margin-top:'+row*(ranArr[k]+10)+'px">';
                var templatetop='<div class="film" style="height:'+(ranArr[k]-40)+'px"><div><img src="example.png"><h3>'+'我'+'</h3></div></div></div>';
                totalInnerHtml+=(preFix+templatetop);
                placedPictures++;
            }
            totalInnerHtml+='<br>';
            row++;
            bigHtml+=totalInnerHtml;
        }
        document.getElementById("picturemainBody").innerHTML=bigHtml;
    }
    document.ready(loadPictureWall());
</script>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="background-image: url(static/image/oilbackg.jpg)">
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
</body>
</html>