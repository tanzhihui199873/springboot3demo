
function init(p) {
    var nav_id=$("#nav_id").val();
    var article_title=$("#article_title").val();
    $.ajax({
        type:'post',
        dataType:'json',
        data:{p:p,nav_id:nav_id,article_title:article_title}, //传接收到的参数id
        url:'/api/queryArticleByPage',
        success:function(data){
            $("#nav_id").html("");
            $("#nav_id").append("<option value=''>==请选择新闻类别==</option>");
            for (var i=0;i<data.navList.length;i++){
                if (data.navList[i].nav_id==nav_id) {
                    $("#nav_id").append("<option value="+data.navList[i].nav_id+" selected='selected'>"+data.navList[i].nav_name+"</option>")
                }else {
                    $("#nav_id").append("<option value="+data.navList[i].nav_id+" >"+data.navList[i].nav_name+"</option>")
                }

            }
            var pagerows=10*p;
            $("#t_content").html("");
            var rows=data.rows;
            if (rows!=0){
                for (var i=0;i<data.list.length;i++) {
                    $("#t_content").append("<tr>\n" +
                        "                        <td><input type=\"radio\" name=\"rad\" /></td>\n" +
                        "                        <td>"+pagerows+++"</td>\n" +
                        "                        <td>"+data.list[i].article_title+"</td>\n" +
                        "                        <td>"+data.list[i].nav_name+"</td>\n" +
                        "                        <td>"+data.list[i].article_date+"</td>\n" +
                        "                    </tr>")
                }
            }


            $("#rows").html("总共"+data.rows+"条记录");
            $("#nowPage").html("当前为第"+(p+1)+"页");
            $("#firstPage").html("");
            $("#previousPage").html("");
            if(p>0){

                $("#firstPage").html("第一页");
                $("#previousPage").html("上一页");
                $('#firstPage').unbind("click");
                $('#previousPage').unbind("click");
                $("#firstPage").click(function(){
                    init(0);
                })
               $("#previousPage").click(function(){
                    init(p-1);
                })
            }
            var  totalPages = rows==0?1:parseInt((rows%10==0?rows/10:(rows / 10 +1)));
            $("#nextPage").html("");
            $("#lastPage").html("");
            if(p<totalPages-1&&rows!=0) {
                $("#nextPage").html("下一页");
                $("#lastPage").html("最后一页");
                $('#nextPage').unbind("click");
                $('#lastPage').unbind("click");
                $("#nextPage").click(function(){
                    init(p+1);
                })
                $("#lastPage").click(function(){
                    init(totalPages-1);
                })
            }
            $("#pageCount").html("共"+totalPages +"页");
            if(totalPages>1){

            }

        }
    })
}