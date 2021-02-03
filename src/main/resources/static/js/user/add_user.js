$(function(){ 
	$("#regForm").validate({  //表单验证
		submitHandler : function(form) {//当所有数据都验证通过之后才能提交表单
			var  formData=$("#regForm").serialize();
			 formData=decodeURIComponent(formData);
			 $.get("/sysuser/add?"+formData,{},function(data){
				  if(data){
				      alert("添加数据成功");
				  }else{
					  alert("添加数据失败");  
				  }
			 })
		},
		//如果表单验证失败时候会出现错误提示
		//element :验证不合法的input对象
		errorPlacement : function(error, element) {  
			//jq对“.”敏感，如果出现了需要替换为转义字符
			$("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
		},
		//如果出现了错误样div高亮显示为红色
		highlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1, function() {
					$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
				});
			})
		},
		//高亮显示为绿色，验证通过时候显示的
		unhighlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1,function() {
						$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
				});
			})
		},
		errorClass : "text-danger",
		messages : {   //如果对应的表单出现错误则显示这些提示信息
			"nickname" : "昵称为空或者已经存在了",
			"name":"名字不能为空",
			"pwd":"密码不能为空",
			"phone1":"电话不能为空"
		} ,
		rules : { //验证规则
			"name" : {
				required : true  //不能为空
			},
			"nickname" : { 
				required : true,  //不能为空
				remote : {  //远程验证
					url : "/sysuser/checkName", //远程验证的提交路径
					type : "post",    //请求类型
					dataType : "html",  
					data : {    //取得输入的昵称 ，发送给服务器端
						nickName : function() {
							return $("#nickname").val();
						} 
					},
					dataFilter : function(data, type) {//回调函数
						return data;
					}
				}
			},
			"pwd" : {
				required : true
			},
			"phone" : {
				required : true
			},
			"qq" : {
				required : true
			},
			"email" : {
				required : true,
				email:true
			},
			"regtime" : {
				required : true
			}
		}
	});
})