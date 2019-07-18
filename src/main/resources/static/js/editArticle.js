
function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}
function init() {
    var article_id=getQueryVariable("article_id");
    $.ajax({
        type:'post',
        dataType:'json',
        data:{article_id:article_id}, //传接收到的参数id
        url:'/api/queryArticleMap4Edit',
        success:function(data) {

            $("#nav_id").html("");
            $("#nav_id").append("<option value=''>==请选择新闻类别==</option>");
            for (var i=0;i<data.navList.length;i++){
                if (data.navList[i].nav_id==data.article.nav_id) {
                    $("#nav_id").append("<option value="+data.navList[i].nav_id+" selected='selected'>"+data.navList[i].nav_name+"</option>")
                }else {
                    $("#nav_id").append("<option value="+data.navList[i].nav_id+" >"+data.navList[i].nav_name+"</option>")
                }
            }
            $("#article_id").val(""+data.article.article_id+"");
            $("#article_title").val(""+data.article.article_title+"");
            $("#article_date").val(""+data.article.article_date+"");
            KindEditor.html("#article_content", ""+data.article.article_content+"");
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
    editArticle();
}



function editArticle() {
    var article_title=$("#article_title").val();
    var nav_id=$("#nav_id").val();
    var article_date=$("#article_date").val();
    var article_id=$("#article_id").val();
    var article_content=$("#article_content").val();
    $.ajax({
        type:'post',
        dataType:'json',
        data:{article_id:article_id,nav_id:nav_id,article_title:article_title,article_date:article_date,article_content:article_content}, //传接收到的参数id
        url:'/api/editArticle',
        success:function(data) {
            if (data){
                alert("更新成功！");
            } else {
                alert("更新失败！");
            }

        }
    })
}