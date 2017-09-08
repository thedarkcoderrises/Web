
$(document).ready(function() {

$.ajax({
	type: "GET", 
	url : 'drawMenu',
    success : function(data) {
    	if(!$.isEmptyObject(data)){
    		updateMenu(data);
    	}
	},
	error:function () { alert("Error");}
});

});

function updateMenu(menuInfo) {
	var rootList = $("<ul id='menu'>").appendTo(".menu-container");
	var elements = {};
	$.each(menuInfo, function() {

		var parent = elements[this.subMenu.substr(0, this.subMenu
				.lastIndexOf("/"))];

		var list = parent ? parent.children("ul") : rootList;
		if (!list.length) {
			list = $("<ul class='sub'>").appendTo(parent);
		}
		var item = $("<li class='sub'>").appendTo(list);
		$("<a>").attr("href", this.menuURL).text(this.displayName)
					.appendTo(item);
		
		elements[this.subMenu] = item;

	});

}