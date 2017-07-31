<@page title="配置中心" description="配置中心"  keywords="配置中心" assets=[
]>
<div class="row">
    <div class="col-xs-12">
        <div class="box box-primary">
            <div class="box-header">
                <h3 class="box-title">首页</h3>
            </div>
            <!-- /.box-header -->
            <#if message?? >
                ${message}
            </#if>
            <div class="box-body table-responsive no-padding">
                <form role="form" id="fm1" onsubmit="return handleAction()" style="width:80%;margin-left:50px;height:490px;" enctype="multipart/form-data"
                    action="/file/upload" method="post">
                    <div class="form-group" style="margin-bottom:30px;margin-left:50px;width:300px;">
                        <label for="inputfile"><h3>视频文件输入</h3></label><br/>
                        <div href="javascript:;" class="a-upload" style="height:30px;" >
                            <input type="file" name="fileUpload" id="fileUpload" style="width:300px;height:20px;">点击这里上传文件
                        </div>
                    </div>
                    <input type="text" id="msg" class="form-control" value="" disabled="disabled" style="text-align:center;"/>

                    <button type="submit"  class="btn btn-default" >提交</button>
                </form>
            </div>

            <!-- /.box-body -->
        </div>
        <!-- /.box -->
    </div>
</div>
<script type="text/javascript">
    var verify = false;
    var maxSize = 30 * 1024 * 1024;
    var tipMsg = "您的浏览器暂不支持计算上传文件的大小，确保上传文件不要超过30M";
    $(document).ready(function(){

    })
    $("#fileUpload").change(function(){
        var file = $(this).val();
        var fileTail = file.substring(file.indexOf(".") + 1);
        switch (fileTail){
            case "avi": verify = true; break;
            case "mp4": verify = true; break;
            case "pdf": verify = true; break;
            default:break;
        }
        $("#msg").val(file.substring(file.lastIndexOf("\\") + 1));
    })
    function handleAction(){
        var fileSize = document.getElementById("fileUpload").files[0].size;

        if (fileSize == -1 || fileSize >= maxSize){
            alert(tipMsg);
            return false;
        }
        if (verify == true){
            return true;
        } else {
            alert("视频为空或格式不对!");
            return false;
        }
    }
</script>
<#--<script type="text/javascript" src="/static/js/main/index.js></script>-->
</@page>