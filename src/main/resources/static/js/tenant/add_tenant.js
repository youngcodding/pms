$(function(){
        //jquery.validate
        $("#tenantForm").validate({
    			errorPlacement : function(error, element) {
    				$("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
    			},
    			highlight : function(element, errorClass) {
    				$(element).fadeOut(1,function() {
    					$(element).fadeIn(1, function() {
    						$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
    					});

    				})
    			},
    			unhighlight : function(element, errorClass) {
    				$(element).fadeOut(1,function() {
    					$(element).fadeIn(1,function() {
    							$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
    					});
    				})
    			},
    			errorClass : "text-danger",
    			/* 校验规则 */
				rules : {
					companyname : "required",
					managername : "required",
					phone : "required",
					identity : "required",
					identitypositive : "required",
					identitynegative : "required"
				},
				/* 校验规则触发以后对应的提示信息:必须和上面规则对应 */
				messages : {
					companyname : "公司名称不能为空",
					managername : "公司法人不能为空",
					phone : "电话不能为空",
					identity : "身份证不能为空",
					identitypositive : "请上传身份证正面",
					identitynegative : "请上传身份证反面"
				},
				/* 校验完毕触发的事件 */
				submitHandler : function() {
					//1.序列化表单获取页面的所有表单元素的数据
					var formData = $("#tenantForm").serialize();
					console.log(formData);
					//2.使用ajaxpost提交,向后台提交数据
					$.post("/tenant/add",formData,function(data){
						//在js的if语句中 会进行隐式转换  1可以转换为true  0转换为false
							if (data) {
								//使用layer插件进行弹框提示
								//墨绿深蓝风
								layer.alert("添加成功", {
								  skin: 'layui-layer-molv' //样式类名
								}, function(index){
									layer.close(index);
									window.location.href="/tenants/add_tenant.html";
								});
							} else {
								layer.alert("添加失败", {
									  skin: 'layui-layer-molv' //样式类名
								});
							}
					});
				}
    		});
})
//身份证正面
jQuery(function() {
	    var list = $('#thelist1'), // thelist节点中添加文本  身份证正面  div添加  
	        btn = $('#ctlBtn1'), // 文件上传按钮   身份证正面 文件上传按钮
	        state = 'pending',//当前文件的状态是等待上传状态
	        uploader;
	    //初始化
	    uploader = WebUploader.create({ //对上传的基本要求配置
	        // 不压缩image
	        resize: false,
	        // 文件接收服务端,上传该文件的服务器路径
	        server: "/tenant/uploadFile",
	        // 选择文件的按钮。可选。
	        //需要上传的文件所在的div
	        pick: '#picker1' ,
  	       //只允许选择图片文件。
	        accept: {
	            title: 'Images',
	            extensions: 'jpg,jpeg,bmp,png',//允许上传的文件的格式
	            mimeTypes: 'image/*'
	        },
	        //允许上传的文件个数
	        fileNumLimit:2,
	        //单个文件最大的上传限制 1M
	        fileSingleSizeLimit : 1024 * 1024 // 1M
	    });
	    // 当有文件添加进来的时候显示的样式
	    uploader.on( 'fileQueued', function(file) {
	    	console.log(file.id)
	    	//file.id表示添加进来的文件的编号（上传组件生成的）
	    	//file.name  表示上传文件的原名称
	        list.append('<div id="' + file.id + '" class="item">' +
	            '<h4 class="info">' + file.name + '</h4>' +
	            '<p class="state">等待上传...</p>' +
	        '</div>' );
	    });
	    // 'uploadProgress'：文件上传过程中创建进度条实时显示。这是结合Bootstrap控制的样式
	    // percentage  文件上传的百分比
	    //file 上传的文件对象，是上传组件创建的
	    uploader.on( 'uploadProgress', function( file,percentage){
	        var li = $( '#'+file.id ),
	        //在$li 代表的节点查找 是否有 进度条的样式，如果有则$percent的长度大于0 否则等于0
	        percent=li.find('.progress .progress-bar');
	        // 避免重复创建  
	        if (!percent.length ) {
	        	//追加一个进度条样式
	            percent = $('<div class="progress progress-striped active">' +
	              '<div class="progress-bar" role="progressbar" style="width: 0%">' +
	              '</div>' +
	            '</div>').appendTo(li).find('.progress-bar');
//	            $('<div class="progress progress-striped active">' +
//	              '<div class="progress-bar" role="progressbar" style="width: 0%">' +
//	              '</div>' +
//	            '</div>').appendTo($li);
//	            $percent=$li.find('.progress-bar');
	        }
	        li.find('p.state').text('上传中');
	        percent.css( 'width', percentage * 100 + '%' );
	    });
	    //'uploadSuccess'：文件上传成功后  触发的事件  触发一个回调函数
	    //response 表示服务器端返回的数据
	    //response:该对象封装了服务器端返回的数据，要取得返回的数据需要用到该对象的“_raw”属性
	    //writer.print(this.getDir() + newFileName);
	    uploader.on( 'uploadSuccess', function( file,response){
	    	// 上传的图片保存的相对位置（文件上传到服务器端之后保存的路径信息）
	    	var idcard_url ="/"+ response._raw;
	    	 $("#idcard_id1").append("<br><img  src='"+idcard_url+"' style='width: 150px;height: 150px' />");
	    	 //将url 添加到  form表单的隐藏域中,方便最后提交信息的时候将文件的名称保存到数据库
	    	 $("#identitypositive").val(idcard_url);
	    	 $('#'+file.id ).find('p.state').text('已上传');
	    });
	    uploader.on( 'uploadError', function( file ) {
	        $( '#'+file.id ).find('p.state').text('上传出错');
	    });
	    uploader.on( 'uploadComplete', function( file ) {
	        $( '#'+file.id ).find('.progress').fadeOut();
	    });
	    uploader.on( 'all', function( type ) {
	        if ( type === 'startUpload' ) {
	            state = 'uploading';
	        } else if ( type === 'stopUpload' ) {
	            state = 'paused';
	        } else if ( type === 'uploadFinished' ) {
	            state = 'done';
	        }
	        if ( state === 'uploading' ) {
	            btn.text('暂停上传');
	        } else {
	            btn.text('开始上传');
	        }
	    });
	    //出错以后回调的函数
	    uploader.on("error",function(type){
	    	alert(type);
	    	if(type == "F_EXCEED_SIZE"){
	    		layer.alert('最大只能上传1M文件', {
	    			  skin: 'layui-layer-molv' //样式类名
	    		});
	    	}
	    });
	    btn.on( 'click', function() {
	        if (state === 'uploading' ) {
	            uploader.stop();
	        } else {
	            uploader.upload();
	        }
	    });
	});
 //身份证反面
	jQuery(function() {
	    var list = $('#thelist2'), // thelist节点中添加文本  身份证正面  div添加  
	        btn = $('#ctlBtn2'), // 文件上传按钮   身份证正面 文件上传按钮
	        state = 'pending',
	        uploader;
	    //初始化
	    uploader = WebUploader.create({
	        // 不压缩image
	        resize: false,
	        // 文件接收服务端。
	        server: "/tenant/uploadFile",
	        // 选择文件的按钮。可选。
	        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	        	//开始上传 按钮的id 
	        pick: '#picker2',  
	        	 // 只允许选择图片文件。
	        accept: {
	            title: 'Images',
	            extensions: 'jpg,jpeg,bmp,png',
	            mimeTypes: 'image/*'
	        },
	        //允许上传的文件个数
	        fileNumLimit:2,
	        //单个文件最大的上传限制 1M
	        fileSingleSizeLimit : 5*1024 * 1024 // 1M
	    });
	    // 当有文件添加进来的时候
	    uploader.on( 'fileQueued', function(file) {
	        list.append( '<div id="' + file.id + '" class="item">' +
	            '<h4 class="info">' + file.name + '</h4>' +
	            '<p class="state">等待上传...</p>' +
	        '</div>' );
	    });
	    // 文件上传过程中创建进度条实时显示。
	    uploader.on( 'uploadProgress', function( file, percentage ) {
	        var li = $( '#'+file.id ),
	            percent =li.find('.progress .progress-bar');
	        // 避免重复创建
	        if (!percent.length ) {
	            percent = $('<div class="progress progress-striped active">' +
	              '<div class="progress-bar" role="progressbar" style="width: 0%">' +
	              '</div>' +
	            '</div>').appendTo(li).find('.progress-bar');
	        }
	        li.find('p.state').text('上传中');
	        percent.css( 'width', percentage * 100 + '%' );
	    });
	    //文件上传成功后  触发的事件  触发一个回调函数
	    uploader.on( 'uploadSuccess', function( file,response) {
	    	// 上传的图片保存的相对位置
	    	var idcard_url = "/"+response._raw;
	    	 $("#idcard_id2").append("<img  src='"+idcard_url+"' style='width: 150px;height: 150px' />");
	    	 //将url 添加到  form表单的隐藏域中
	    	 $("#identitynegative").val(idcard_url);
	    	$( '#'+file.id ).find('p.state').text('已上传');
	    });
	    uploader.on( 'uploadError', function( file ) {
	        $( '#'+file.id ).find('p.state').text('上传出错');
	    });
	    uploader.on( 'uploading', function( file ) {
	    	$( '#'+file.id ).find('p.state').text('上传中...');
	    });
	    uploader.on( 'uploadComplete', function( file ) {
	        $( '#'+file.id ).find('.progress').fadeOut();
	    });
	    uploader.on( 'all', function( type ) {
	        if ( type === 'startUpload' ) {
	            state = 'uploading';
	        } else if ( type === 'stopUpload' ) {
	            state = 'paused';
	        } else if ( type === 'uploadFinished' ) {
	            state = 'done';
	        }
	        if ( state === 'uploading' ) {
	            btn.text('暂停上传');
	        } else {
	            btn.text('开始上传');
	        }
	    });
	  //出错以后回调的函数
	    uploader.on("error",function(type){
	    	if(type == "F_EXCEED_SIZE"){
	    		layer.alert('最大只能上传1M文件', {
	    			  skin: 'layui-layer-molv' //样式类名
	    		});
	    	}
	    });
	    btn.on( 'click', function() {
	        if ( state === 'uploading' ) {
	            uploader.stop();
	        } else {
	            uploader.upload();
	        }
	    });
	});
 
    	