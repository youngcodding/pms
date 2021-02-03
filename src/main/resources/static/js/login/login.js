$(function() {
	 //实现验证码刷新
	$("#imgCode").on("click",function(){
		 $("#code").attr("src","imgCode?p=" + Math.random()) ;  /\s+/g
	});
	 //实现表单验证，失去焦点事件
	 $("#uname").blur(function(){
		 //正则 \s+ 表示空格字符   g表示全局验证
		 var uname = $("#uname").val().replace(/\s+/g,"");   
		 if(uname.length==0){
			 $("#u_inputErrorid").css("display","block");
			 return false;
		 }else{
			 $("#u_inputErrorid").css("display","none");
		 }
	 })
	 $("#pwd").blur(function(){
		 var pwd = $("#pwd").val().replace(/\s+/g,"");;
		 if(pwd.length==0){
			 $("#p_inputErrorid").css("display","block");
			 return false;
		 }else{
			 $("#p_inputErrorid").css("display","none");
		 }
	 })
	  $("#ran").blur(function(){
		 var pwd = $("#ran").val().replace(/\s+/g,"");;
		 if(pwd.length==0){
			 $("#r_inputErrorid").css("display","block");
			 return false;
		 }else{
			 $("#r_inputErrorid").css("display","none");
		 }
	 })
})
