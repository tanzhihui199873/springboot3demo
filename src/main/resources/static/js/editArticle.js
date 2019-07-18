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
    document.getElementById("frm").submit();
}
