


/*$(window).load(function(){
	console.log("window");
    loadGoods();
});*/

$('document').ready(function(){
    console.log("document");
    loadGoods();

});


function loadGoods() {
    $.ajax({
        url : 'getjson',
        dataType: 'json',
        success : function(data) {

            var out = '';
            for (var key in data){
                // var vegetarian = (data[key]['vegetarian'] > 0) ? 'No' : 'Yes';
                // out+='<div>';
                // out+='<div class="thumbnail">';
                out+='<img src="http://localhost:7777/intbuffetproject/getBigImage?id='+data[key]['id']+'" class="img-responsive">';
               /* out+='<div class="caption">';
                out+='<h3>';
                out+='<a href="#">'+data[key]['name']+'</a>';
                out+='</h3>';
                out+='<p>Category: '+data[key]['category']['name']+'</p>';//????
                out+='<p>'+data[key]['description']+'</p>';
                out+='<p> Price: '+data[key]['price']+'</p>';
                out+='<p> Vegetarian: '+vegetarian+'</p>';
                out+='<p> Weight: '+data[key]['weight']+'</p>';
                out+='</div>';*/
               /* out+='</div>';
                out+='</div>';*/


            }

          console.log(out);
            localStorage.setItem("cart", JSON.stringify(data));
            $('#goods').html(out);

        }

    });
}



/*function newMyWindow(e) {
  var h = 500;
  var w = 500;
  myWindow = window.open(e, '', 'scrollbars=1,height='+Math.min(h, screen.availHeight)+',width='+Math.min(w, screen.availWidth)+',left='+Math.max(0, (screen.availWidth - w)/2)+',top='+Math.max(0, (screen.availHeight - h)/2));
  }*/



function addAjax(articul,price,quantity) {
	$.ajax({
		type: "GET",
		url : 'add_to_cart',
		data : ({idgood: articul}),
		success : function(data) {
			
			$('#total_price').html('&#8364; '+ data[0]);
			$('input[cartAttr="'+articul+'"]').val(data[1]);
			$('#totalItems').html(data[2]);
			}

});  
	
	return false;
}



function find() {
	$.ajax({
		url : 'find',
		dataType: 'json',
		data : ({categoryId: $('#categoryId').val(),vegetarian: $('#vegetarian').prop("checked")}),
		success : function(data) {
				
			var out = '';
			for (var key in data){
				var vegetarian = (data[key]['vegetarian'] > 0) ? 'No' : 'Yes';
				out+='<div>';
				out+='<div class="thumbnail">';
				out+='<img src="/intbuffetproject/getImage?id='+data[key]['id']+'" class="img-responsive">';
				out+='<div class="caption">';
				out+='<h3>';
				out+='<a href="#">'+data[key]['name']+'</a>';
				out+='</h3>';
				out+='<p>Category: '+data[key]['category']['name']+'</p>';//????
				out+='<p>'+data[key]['description']+'</p>';
				out+='<p> Price: '+data[key]['price']+'</p>';
				out+='<p> Vegetarian: '+vegetarian+'</p>';
				out+='<p> Weight: '+data[key]['weight']+'</p>';
				out+='<a target="_self" id="'+data[key]['id']+'" class="btn btn-danger" onclick="addAjax('+data[key]['id']+')"><i class="glyphicon glyphicon-shopping-cart"></i></a>'
				out+='</div>';
				out+='</div>';
				out+='</div>';
					
				 
			}
			
			$('#goods').html(out);
				
		}

	});
	}



function changeHref(id) {
	
	var category =  $('input[attr="'+id+'"]').val();
	var href="updateCategory/"+id+"/"+category;
	
	$('a[refattr="'+id+'"]').attr("href",href);
	
}

function changeHrefOrder(id) {
	
	var status =  $('select[optionAttr="'+id+'"] option:selected').text();
	var obj = {id: id,status:status}
	var href="updateOrder?"+$.param(obj);
	
	$('a[refattr="'+id+'"]').attr("href",href);
	
}

function showProfit(){
	
	var from =  $('input[dateAttr="from"]').val();
	var to =  $('input[dateAttr="to"]').val();
	
	$.ajax({
		type: "GET",
		url : 'get_revenue',
		data : ({from: from,to:to}),
		success : function(data) {
		
			 if(typeof data != "undefined"){
			$('#profit').html('<p> Profit: &#8364; '+ data+'</p>');
			 }else $('#profit').html('&#8364; '+ 0);
			}

});  
	
	return false;
}




