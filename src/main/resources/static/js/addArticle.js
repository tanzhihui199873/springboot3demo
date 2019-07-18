
function init() {
    $.ajax({
        type:'post',
        dataType:'json',
        url:'/api/queryNavAll',
        success:function(data) {
            $("#nav_id").html("");
            $("#nav_id").append("<option value=''>==请选择新闻类别==</option>");
            for (var i = 0; i < data.length; i++) {
                if (data[i].nav_id == nav_id) {
                    $("#nav_id").append("<option value=" + data[i].nav_id + " selected='selected'>" + data[i].nav_name + "</option>")
                } else {
                    $("#nav_id").append("<option value=" + data[i].nav_id + " >" + data[i].nav_name + "</option>")
                }

            }
        }
    })
}

function valiInput(id,msg,n){
    var val = document.getElementById(id).value;
    if(val=="" || val.length<n){
        document.getElementById("err_"+id).innerHTML="<span class='err'>"+msg+"</span>";
        return false;
    }else{
        document.getElementById("err_"+id).innerHTML="<span class='success'>验证通过。</span>";
        return true;
    }
}
function startPost(){
    var ipts=["article_title","nav_id","article_date"];
    var lens=[2,1,10];
    var msg=["请输入标题，至少两个字符。","请选择新闻类别","请输入发布时间"];
    var flag=true;
    for(var i=0;i<ipts.length;i++){
        flag = valiInput(ipts[i],msg[i],lens[i])&&flag;
    }
    if(!flag)return;
    insertArticle();
}

function insertArticle() {
    var article_title=$("#article_title").val();
    var nav_id=$("#nav_id").val();
    var article_date=$("#article_date").val();
    var article_content=$("#article_content").val();
    $.ajax({
        type:'post',
        dataType:'json',
        data:{nav_id:nav_id,article_title:article_title,article_date:article_date,article_content:article_content}, //传接收到的参数id
        url:'/api/insertArticle',
        success:function(data) {
            if (data){
                alert("添加成功！");
            } else {
                alert("添加失败！");
            }

        }
    })
}
