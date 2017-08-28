<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>DeepWalk手语翻译</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<style type="text/css">
    #top{width: 100%;  height: 60px;}
    #mainBody{background-image: url(sky.gif);width: 100%;  position: absolute;  top: 60px;  bottom: 0px;  left: 0px;}
    a:hover{color: red}
    #videoPlace{opacity: 0.8}


</style>
<body>
<nav class="navbar navbar-inverse" id="top" role="navigation" >
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#" style="color: #00a7d0">DeepWalk手语翻译</a>
        </div>
        <div>
            <form class="navbar-form navbar-left">
                <div class="form-group" style="position: absolute;top: 0px">
                    <button type="button" class="btn btn-default navbar-btn">上传视频</button>
                    <input type="text" class="form-control" placeholder="选择文件">
                    <input type="file" style="position: absolute;left: 5px;top: 12px;height: 25px;opacity: 0">
                </div>
            </form>
            <button type="button" class="btn btn-default navbar-btn" style="position: absolute;left: 500px;top: 0px">播放视频</button>
        </div>
        <div>
            <form class="navbar-form navbar-right">
                <div>
                    <a style="color: #00a7d0">----关爱聋人，让世界充满爱</a>
                </div>
            </form>
        </div>
    </div>
</nav>
<div id="mainBody">
    <div id="middle" style=" position: absolute;top: 0px;left: 110px;right: 110px;bottom: 50px;background-color: transparent;border-radius: 5px;opacity: 1" >
        <div id="videoPlace" class="col-lg-8" style="background-color: whitesmoke;height: 100%;border: medium;">
            <video id="media" height="95%" width="96%" src="" controls style="background-color: #2f3238;position: absolute;top:10px;left:10px">

            </video>
        </div>
        <!--end of videoPlace div -->
        <div id="translationPlace" class="col-lg-4" style="background-color: black;height: 100%;border: medium">
            <div id="translationPlaceTop">
                <font color="blue" size="3" style="color: #00a7d0">翻译结果：</font>
            </div>
            <!--end of translationPlaceTop div -->
            <div id="translationPlaceMiddle">
                <textarea readonly="readonly" rows="15" cols="10" style="background-image: url(pure.jpg) ;opacity:0.8;width:100%;height: 480px;overflow-y: visible">这里是翻译的内容</textarea>

            </div>
            <!--end of translationPlaceMiddle -->
            <div id="translationPlacebottom" style="position: absolute;bottom: 20px;right: 0px;height: 20px;background-color: transparent">
                <button style="background: transparent;border: 0"><a>[下载翻译结果]</a></button>
                <button style="background: transparent;border: 0"><a>[清空]</a></button>
                <button style="background: transparent;border: 0"><a>[详情]</a></button>
                <button style="background: transparent;border: 0"><a>[训练集]</a></button>
            </div>
            <!--end of translationPlacebottom div -->
        </div>
        <!--end of translationPlace div -->
    </div>
</div>
</body>
</html>