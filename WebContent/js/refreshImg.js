var setCommand=function(img, command){
	img.onclick = function(){
		command.execute();
	}
}
var MenuBar = {
		refresh : function(){
			var date = new Date().getTime();
			$("#img").attr("src", "/lgmall/checkImg?time" + date);
		}
}
//刷新
var RefreshCommand = function(receiver){
	this.receiver = receiver
}
RefreshCommand.prototype.execute = function() {
	this.receiver.refresh();
}
//刷新验证码
function changeImg(){
	var img = document.getElementById("img");
	var refreshCommand = new RefreshCommand(MenuBar);
	setCommand(img, refreshCommand); //刷新
	
}