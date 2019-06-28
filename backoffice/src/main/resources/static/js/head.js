$(function () {
    setNavigation();
    var $chkboxes = $('.checkbox');
    var lastChecked = null;

    $chkboxes.click(function(e) {
        if(!lastChecked) {
            lastChecked = this;
            return;
        }

        if(e.shiftKey) {
            var start = $chkboxes.index(this);
            var end = $chkboxes.index(lastChecked);

            $chkboxes.slice(Math.min(start,end), Math.max(start,end)+ 1).prop('checked', lastChecked.checked);

        }

        lastChecked = this;
    });

    $('a[data-action="reload"]').click(function(){
      refresh_click();
    });

    $(document).on("focus", ".input-mask-datetime", function () {
      $this = this;
      $(this).datetimepicker({
         format: 'DD/MM/YYYY H:mm:ss',//use this option to display seconds
         //calendarWeeks: true,
         showClear: true,
         showClose: true,
         keepOpen: true,
         widgetParent: $('body'),
         widgetPositioning: {
            horizontal: 'left',
            vertical: 'bottom'
         },
         icons: {
          time: 'fa fa-clock-o',
          date: 'fa fa-calendar',
          up: 'fa fa-chevron-up',
          down: 'fa fa-chevron-down',
          previous: 'fa fa-chevron-left',
          next: 'fa fa-chevron-right',
          today: 'fa fa-arrows ',
          clear: 'fa fa-trash',
          close: 'fa fa-times'
         },
         locale:  moment.locale('en', {
              week: { dow: 1 }
          }),
        }).on('dp.show', function(){
            var datepicker = $("body").find('.bootstrap-datetimepicker-widget');
            if (datepicker.hasClass('top') || datepicker.hasClass('bottom')) {
                var top = $(this).offset().top + $($this).height() + 10;
                var left = $(this).offset().left;
                datepicker.css({
                                'z-index': '1060',
                                'top': top + 'px', 
                                'left': left+'px'
                            });
            }
        });
    });
    $(document).on("focus", ".input-mask-date", function () {
      //$(this).mask('dd/mm/yyyy');
      $(this).datepicker({
        format: 'dd/mm/yyyy',
        autoclose: true,
        calendarWeeks: true,
        weekStart: 1, 
        todayHighlight: true
      });
    });
    $(document).on("focus", ".start-date", function () {
      $(this).datepicker({
        format: 'dd/mm/yyyy',
        autoclose: true,
        calendarWeeks: true,
        weekStart: 1, 
        todayHighlight: true
      }).on('changeDate', function (selected) {
          var minDate = new Date(selected.date.valueOf());
          $('.end-date').datepicker('setStartDate', minDate);
      });
      $('.end-date').datepicker({
        format: 'dd/mm/yyyy',
        autoclose: true,
        calendarWeeks: true,
        weekStart: 1, 
        todayHighlight: true
      });
      
    });
    $(document).on("focus", ".end-date", function () {
      $(this).datepicker({
        format: 'dd/mm/yyyy',
        autoclose: true,
        calendarWeeks: true,
        weekStart: 1, 
        todayHighlight: true
      }).on('changeDate', function (selected) {
          var maxDate = new Date(selected.date.valueOf());
          $('.start-date').datepicker('setEndDate', maxDate);

          var from = $(".start-date").val().split("/");
          var startDate = new Date(from[2], from[1] - 1, from[0]);
          if (startDate > maxDate){
            $('.start-date').val($('.end-date').val());
          }
      });
      $('.start-date').datepicker({
        format: 'dd/mm/yyyy',
        autoclose: true,
        calendarWeeks: true,
        weekStart: 1, 
        todayHighlight: true
      });
      
    });
    $(document).on("focus", ".input-mask-phone", function () {
      $.mask.definitions['~'] = '([0-9] )?';
      $(this).mask("9999 999 999~");
    });
    $(document).on("focus", ".numbers", function () {
      $(this).inputmask("numeric", {
          radixPoint: ".",
          groupSeparator: ",",
          digits: 6,
          autoGroup: true,
          rightAlign: true,
          oncleared: function () { self.Value(''); }
      });
    });

    // DROPDOWN MENU WITH APPEND-TO-BODY
    // hold onto the drop down menu
    var dropdownMenu;
    // and when you show it, move it to the body
    $(window).on('show.bs.dropdown', function (e) {
        // grab the menu
        dropdownMenu = $(e.target).find('.multiselect-container.dropdown-menu');
        // detach it and append it to the body
        $('body').append(dropdownMenu.detach());
        // grab the new offset position
        var eOffset = $(e.target).offset();
        // make sure to place it where it would normally go (this could be improved)
        dropdownMenu.css({
            'display': 'block',
                'top': eOffset.top + $(e.target).outerHeight(),
                'left': eOffset.left
        });
    });
    // and when you hide it, reattach the drop down, and hide it normally
    $(window).on('hide.bs.dropdown', function (e) {
        $(e.target).append(dropdownMenu.detach());
        dropdownMenu.hide();
    });
});
$( document ).ajaxStart(function() {

  $("#ajax_loader").fadeIn(200);

  $('input[type="submit"]').attr('disabled',true);
  $('button[type="submit"]').attr('disabled',true);
  $('.ui-dialog-buttonset .btn-success').attr('disabled',true);

});

$( document ).ajaxComplete(function() {

  $("#ajax_loader").fadeOut(200);

  $('input[type="submit"]').attr('disabled',false);
  $('button[type="submit"]').attr('disabled',false);
  $('.ui-dialog-buttonset .btn-success').attr('disabled',false);

});
function log(data){
  console.log(data);
}
function setNavigation() {
    var path = window.location.pathname;
    path = path.replace(/\/$/, "");
    path = decodeURIComponent(path);

    $(".nav a").each(function () {
        var href = "/"+$(this).attr('data');
        if (path === href) {
            $(this).closest('li').addClass('active');
            $(this).closest('li').parents('li').addClass('active open');
        }
        if (window.location.hash == $(this).attr("data")) {
          var hrefval = $(this).attr("data");
          if(hrefval != "#") {
            $(this).closest('li').addClass('active');
            $(this).closest('li').parents('li').addClass('active');
          }
        }
        
    });
}
function exportExcel(button, table) {
  $("#"+button).click(function () {
      $("#"+table).battatech_excelexport({
          containerid: table
         , datatype: 'table'
      });
  });
}
function checkall(class_name, obj) {
    var items = document.getElementsByClassName(class_name);
    if(obj.checked == true) 
    {
      for(i=0; i < items.length ; i++)
        items[i].checked = true;
    }
    else { 
      for(i=0; i < items.length ; i++)
        items[i].checked = false;
    }
}
function searchall(page,cot,sapxep){
  var page = 1;
  var cot = cot;
  var sapxep = sapxep;
  
  var faq_search_input = "";  // Lấy giá trị search của người dùng
  var loc =    "";
  var ngaytao = "";
  var ngaytaobatdau = "";
  var batdau = "";
  var ketthuc = "";
  var trangthai = "";
  var nv = "";
  var tha = "";
  var na = "";
  var tu = "";
  var den = "";
  var xe = "";
  var vong = "";

  if($('#search-input').length)
  {
    var faq_search_input = $('#search-input').val();
  }
  if($('#chonloc').length)
  {
    var loc = $('#chonloc').val();
  }
  if($('#chonngaytao').length)
  {
    var ngaytao = $('#chonngaytao').val();
  }
  if($('#chonngaytaobatdau').length)
  {
    var ngaytaobatdau = $('#chonngaytaobatdau').val();
  }
  if($('#batdau').length)
  {
    var batdau = $('#batdau').val();
  }
  if($('#ketthuc').length)
  {
    var ketthuc = $('#ketthuc').val();
  }
  if($('#sl_status').length)
  {
    var trangthai = $('#sl_status').val();
  }
  if($('#sl_nv').length)
  {
    var nv = $('#sl_nv').val();
  }
  if($('#sl_tha').length)
  {
    var tha = $('#sl_tha').val();
  }
  if($('#sl_na').length)
  {
    var na = $('#sl_na').val();
  }
  if($('#tu').length)
  {
    var tu = $('#tu').val();
  }
  if($('#den').length)
  {
    var den = $('#den').val();
  }
  if($('#sl_vehicle').length)
  {
    var xe = $('#sl_vehicle').val();
  }
  if($('#sl_round').length)
  {
    var vong = $('#sl_round').val();
  }

    var dataString = 'keyword='+ faq_search_input+"&limit="+loc+"&page="+ page +"&order_by="+ cot +"&order="+ sapxep+"&ngaytao="+ ngaytao+"&ngaytaobatdau="+ ngaytaobatdau+"&batdau="+ batdau+"&ketthuc="+ ketthuc+"&trangthai="+ trangthai+"&nv="+nv+"&tha="+tha+"&na="+na+"&tu="+tu+"&den="+den+"&xe="+xe+"&vong="+vong; 
    
  $.ajax({
            type: "POST",                            // Phương thức gọi là GET
            url: "#",                 // File xử lý
            data: dataString,                       // Dữ liệu truyền vào
            beforeSend:  function() {               // add class "loading" cho khung nhập
                $('input#search-input').addClass('loading');
            },
            success: function(server_response)      // Khi xử lý thành công sẽ chạy hàm này
            {
              var success =  $(server_response).find('.widget-main').html();
              $('.widget-main').html(success);
                 
            }
        });
  
}
function sapxep(page,cot,sapxep){
          var sapxep        = sapxep;
        if(page==""){
          if($('.sort').attr('class') == "sort DESC"){
            $('.sort').removeClass('DESC');
            $('.sort').addClass('ASC');
            sapxep = "ASC";
          }
          else if($('.sort').attr('class') == "sort ASC"){
            $('.sort').removeClass('ASC');
            $('.sort').addClass('DESC');
            sapxep = "DESC";
          }
          else if($('.sort').attr('class') == "sort"){
            
            $('.sort').addClass('DESC');
            sapxep = "DESC";
          }
        }
          //$('#loading').html("<img src='public/images/loading.gif'/>").fadeIn(500);
          var cot        = cot;
          var keyword = "";
          var ngaytao = "";
          var loc =    $('#chonloc').val();

          if($('#search-input').length)
          {
            var keyword = $('#search-input').val() || "";
          }
          
          if($('#chonngaytao').length)
          {
            var ngaytao = $('#chonngaytao').val();
          }
          if($('#chonngaytaobatdau').length)
          {
            var ngaytaobatdau = $('#chonngaytaobatdau').val();
          }
          if($('#batdau').length)
          {
            var batdau = $('#batdau').val();
          }
          if($('#ketthuc').length)
          {
            var ketthuc = $('#ketthuc').val();
          }
          if($('#sl_status').length)
          {
            var trangthai = $('#sl_status').val();
          }
          if($('#sl_nv').length)
          {
            var nv = $('#sl_nv').val();
          }
          if($('#sl_tha').length)
          {
            var tha = $('#sl_tha').val();
          }
          if($('#sl_na').length)
          {
            var na = $('#sl_na').val();
          }
          if($('#tu').length)
          {
            var tu = $('#tu').val();
          }
          if($('#den').length)
          {
            var den = $('#den').val();
          }
          if($('#sl_vehicle').length)
          {
            var xe = $('#sl_vehicle').val();
          }
          if($('#sl_round').length)
          {
            var vong = $('#sl_round').val();
          }
          
          $.ajax({
            type: "POST", // phương thức gởi đi
            url: "#", // nơi mà dữ liệu sẽ chuyển đến khi submit
            data: "page="+ page +"&order_by="+ cot +"&order="+ sapxep+"&limit="+ loc+"&keyword="+ keyword+"&ngaytao="+ ngaytao+"&ngaytaobatdau="+ ngaytaobatdau+"&batdau="+ batdau+"&ketthuc="+ ketthuc+"&trangthai="+ trangthai+"&nv="+nv+"&tha="+tha+"&na="+na+"&tu="+tu+"&den="+den+"&xe="+xe+"&vong="+vong,
            success: function(server_response){ // if everything goes well
              
              var success =  $(server_response).find('.widget-main').html();
              $('.widget-main').html(success);
                
            }
          });
}

window.addEventListener("keydown",function (e) {
    if (e.keyCode === 114 || (e.ctrlKey && e.keyCode === 70)) { 
        e.preventDefault();
        search_click();
    }
    if (e.keyCode === 113 || (e.ctrlKey && e.keyCode === 73)) { 
        e.preventDefault();
        $( "i.fa-plus-circle" ).click();
    }
    if (e.keyCode === 115 || (e.ctrlKey && e.keyCode === 81)) { 
        e.preventDefault();
        $( "i.fa-filter" ).click();
    }
});
var preEl ;
var orgBColor;
var orgTColor;
function HighLightTR(el, backColor,textColor){
  //alert(el.id);
  if(typeof(preEl)!='undefined') {
     preEl.bgColor=orgBColor;
     try{ChangeTextColor(preEl,orgTColor);}catch(e){;}
  }
  orgBColor = el.bgColor;
  orgTColor = el.style.color;
  el.bgColor=backColor;

  try{ChangeTextColor(el,textColor);}catch(e){;}
  preEl = el;
}


function ChangeTextColor(a_obj,a_color){  ;
   for (i=0;i<a_obj.cells.length;i++)
    a_obj.cells(i).style.color=a_color;
}

/*Dùng cho bảng nhập liệu*/
function limit_change(limit,order_by,order,keyword){
  $.ajax({
      type: "POST",                            // Phương thức gọi là GET
      url: "#",                 // File xử lý
      data: 'page=1&limit='+limit+'&order_by='+order_by+'&order='+order+'&keyword='+keyword,  
      success: function(server_response)      // Khi xử lý thành công sẽ chạy hàm này
      {
          var success =  $(server_response).find('.widget-main').html();
          $('.widget-main').html(success);
          
      }
  });
}
function info_click(url,title){
  open_dialog(url,title);
}
function refresh_click(){
  location.href = window.location.href.split("#")[0];
}
function add_click(url,title){
  open_dialog(url,title);
}
function edit_click(url,title,id){
  open_dialog(url+id,title);
  $('.ui-dialog div.ui-dialog-buttonpane').append('<div class="text-center viewData"><a id="pData" data="'+id+'" class="fm-button ui-state-default ui-corner-all"><i class="ace-icon fa fa-chevron-left"></i></a><a id="nData" data="'+id+'" class="fm-button ui-state-default ui-corner-all"><i class="ace-icon fa fa-chevron-right"></i></a></div>');
  $('#pData').click(function(){
    id = parseInt($('tr#'+$(this).attr('data')).prev().attr('id'));
    if (id > 0) {
      $(".ui-dialog-content").dialog("close");
      edit_click(url,title,id);
    }
  });
  $('#nData').click(function(){
    id = parseInt($('tr#'+$(this).attr('data')).next().attr('id'));
    if (id > 0) {
      $(".ui-dialog-content").dialog("close");
      edit_click(url,title,id);
    }
  });
}
function view_click(url,title,id,display){
  if (display != "" && display != undefined) {
    open_dialog(url+id,title);
    $('.ui-dialog div.ui-dialog-buttonpane .ui-dialog-buttonset').hide();
  }
  else{
    open_dialog(url+id,title);
    $('.ui-dialog div.ui-dialog-buttonpane').append('<div class="text-center viewData"><a id="pData" data="'+id+'" class="fm-button ui-state-default ui-corner-all"><i class="ace-icon fa fa-chevron-left"></i></a><a id="nData" data="'+id+'" class="fm-button ui-state-default ui-corner-all"><i class="ace-icon fa fa-chevron-right"></i></a></div>');
    $('.ui-dialog div.ui-dialog-buttonpane .ui-dialog-buttonset').hide();
    $('#pData').click(function(){
      id = parseInt($('tr#'+$(this).attr('data')).prev().attr('id'));
      if (id > 0) {
        $(".ui-dialog-content").dialog("close");
        view_click(url,title,id);
      }
    });
    $('#nData').click(function(){
      id = parseInt($('tr#'+$(this).attr('data')).next().attr('id'));
      if (id > 0) {
        $(".ui-dialog-content").dialog("close");
        view_click(url,title,id);
      }
    });
  }
  
}

function view_click_other(url,title,id,display){
  open_dialog_other(url+id,title);
  $('.custom-ui-widget-header-accessible .ui-dialog-buttonset').hide();
  
}

function filter_click(url,title){
  open_dialog(url,title);
}
function search_click(){
  bootbox.prompt({
    title: "Tìm kiếm",
    buttons: {
        confirm: {
            label: '<i class="fa fa-search"></i> Tìm'
        },
        cancel: {
            label: '<i class="fa fa-times"></i> Hủy'
        }
    },
    callback: function (result) {
      if (result === null) {
      
      } else {
        $.ajax({
            type: "POST",                            // Phương thức gọi là GET
            url: "#",                 // File xử lý
            data: 'page=1&keyword='+result,  
            success: function(server_response)      // Khi xử lý thành công sẽ chạy hàm này
            {
               var success =  $(server_response).find('.widget-main').html();
                $('.widget-main').html(success);
                
            }
        });
      }
    }
  });
  
}

function del_click(url){
  if (url == "" || url == undefined) {
    var url = window.location.href.split("#")[0]+"/delete";
  }
  bootbox.confirm({
    title: "Bạn có chắc chắn muốn xóa không?",
    message: "<span class='error'>*Lưu ý: Việc này có thể ảnh hưởng tới các dữ liệu khác.</span>",
    buttons: {
        confirm: {
            label: '<i class="fa fa-check"></i> Đồng ý'
        },
        cancel: {
            label: '<i class="fa fa-times"></i> Hủy'
        }
    },
    callback: function (result) {
      if(result) {
        var del = [];
        ids = $('input:checkbox.checkbox:checked').map(function() { return del.push(this.value); });
        $.ajax({
          url: url,   
          type: 'POST',   
          data: "xoa="+del,   
          success:function(data){ 
            if (data.trim() != 'Bạn không có quyền thực hiện thao tác này') {
              for(var i=0; i<del.length; i++)
                 $('tr#'+del[i]).remove();
             }

            alert_form(data);
            
          }
        });
      }
    }
  });
 
}
function del(id,url)
{
  if (url == "" || url == undefined) {
    var url = window.location.href.split("#")[0]+"/delete";
  }
  bootbox.confirm({
    title: "Bạn có chắc chắn muốn xóa không?",
    message: "<span class='error'>*Lưu ý: Việc này có thể ảnh hưởng tới các dữ liệu khác.</span>",
    buttons: {
        confirm: {
            label: '<i class="fa fa-check"></i> Đồng ý'
        },
        cancel: {
            label: '<i class="fa fa-times"></i> Hủy'
        }
    },
    callback: function (result) {
      if(result) {
        $.ajax({
          url: url,   
          type: 'POST',   
          data: "data="+id,   
          success:function(data){ 
            if (data.trim() != 'Bạn không có quyền thực hiện thao tác này') {
              $('tr#'+id).remove(); 
            }
            
            alert_form(data);
            
          }
        });
      }
    }
  });
 
}
function export_click(type,id,url){
  if (url == "" || url == undefined) {
    if (type=="excel") {
      $("#"+id).battatech_excelexport({
          containerid: id
         , datatype: 'table'
      });
    }
    else if (type=="pdf") {
      $("#"+id).tableExport({type:'pdf'});
    }
    else if (type=="word") {
      $("#"+id).tableExport({type:'word'});
    }
  }

  refresh_click();
}
function import_click(url,title){
  open_dialog(url,title);
}

function alert_form(message){
  bootbox.dialog({
    message: "<i class='ace-icon fa fa-info-circle green'></i> <b>Thông báo</b>: <span class='bigger-110'>"+message+"</span>",
  });
}

function open_dialog(url, title){
  var dialog = $( "#dialog-message" ).removeClass('hide').dialog({
    autoOpen:false,
    resizable: true,
    autoResize:true,
    modal: true,
    width: "auto",
    height: "auto",
    title: "<div class='widget-header widget-header-small blue'><h4 class='smaller'> "+title+"</h4></div>",
    title_html: true,
    buttons: [
      {
        html: "<i class='ace-icon fa fa-save bigger-110'></i>&nbsp; Hoàn tất",
        "class" : "btn btn-success",
        click: function() {
          $("form").submit();
        }
      },
      {
        html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; Đóng & tải lại",
        "class" : "btn btn-danger",
        click: function() {
          $( this ).dialog( "close" );
          refresh_click();
        }
      }
    ],
    close: function(){
      $('.viewData').remove();
      $('.ui-dialog div.ui-dialog-buttonpane .ui-dialog-buttonset').show();
      $( this ).dialog( "close" );
      //$(this).dialog('destroy');
      $( "#dialog-message" ).html("");
      $('.multiselect-container').remove();
    },
    open: function () {
        if ($.ui && $.ui.dialog && !$.ui.dialog.prototype._allowInteractionRemapped && $(this).closest(".ui-dialog").length) {
            if ($.ui.dialog.prototype._allowInteraction) {
                $.ui.dialog.prototype._allowInteraction = function (e) {
                    if ($(e.target).closest('.ui-dialog, .ui-datepicker, .select2-drop, .ui-multiselect-menu').length) return true;
                    return ui_dialog_interaction.apply(this, arguments);
                };
                $.ui.dialog.prototype._allowInteractionRemapped = true;
            }
            else {
                $.error("You must upgrade jQuery UI or else.");
            }
        }
    },
    _allowInteraction: function (event) {
        return !!$(event.target).is(".select2-input") || this._super(event);
    }
  }).dialogExtend({
        "maximizable" : true,
        "minimizable" : true,
        "dblclick" : "maximize",
        "minimizeLocation" : "left"
        
      });
  dialog.load(url, function(){
     dialog.dialog('open');
 });

}

function add_click_other(url,title,id,data,form){
  open_dialog_other(url,title,id,data,form);
}
function open_dialog_other(url, title, id, data, form){
  var dialog = $( "#dialog-message-other" ).removeClass('hide').dialog({
    autoOpen:false,
    resizable: true,
    autoResize:true,
    modal: true,
    width: "auto",
    height: "auto",
    title: "<div class='widget-header widget-header-small blue'><h4 class='smaller'> "+title+"</h4></div>",
    title_html: true,
    dialogClass: 'custom-ui-widget-header-accessible',
    buttons: [
      {
        html: "<i class='ace-icon fa fa-save bigger-110'></i>&nbsp; Hoàn tất",
        "class" : "btn btn-success",
        click: function() {
          $('#'+form).submit();
        }
      },
      {
        html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; Đóng & tải lại",
        "class" : "btn btn-danger",
        click: function() {
          
          if (id.charAt(0) == ".") {
            $.ajax({
                type: "GET",
                url: data,
                success: function(answer){
                  var data = $.parseJSON(answer);
                  
                  
                    $(id).each(function(){
                      var $this = $(this);
                      var str = "";
                      $.each(data, function(index, value) {
                        var sl = $this.find(":selected").attr('value');
                        if (value.id==sl) {
                          str += '<option selected value="'+value.id+'" data="'+value.data+'">'+value.text+'</option>';
                        }
                        else{
                          str += '<option value="'+value.id+'" data="'+value.data+'">'+value.text+'</option>';
                        }
                      });
                      $this.html(str);
                    });
                }
            });
          }
          else{
            $.fn.select2.amd.define('select2/data/customAdapter', ['select2/data/array', 'select2/utils'],
                function (ArrayAdapter, Utils) {
                    function CustomDataAdapter ($element, options) {
                      CustomDataAdapter.__super__.constructor.call(this, $element, options);
                    }
                    Utils.Extend(CustomDataAdapter, ArrayAdapter);
                CustomDataAdapter.prototype.updateOptions = function (data) {
                        this.$element.find('option').remove();
                        this.addOptions(this.convertToOptions(data));
                    }        
                    return CustomDataAdapter;
                }
            );

            var customAdapter = $.fn.select2.amd.require('select2/data/customAdapter');

            var select = $('#'+id).select2({dataAdapter: customAdapter});
            if ($('.'+id).length) {
              var select_class = $('.'+id).select2({dataAdapter: customAdapter});
            }
            
            $.ajax({
                type: "GET",
                url: data,
                success: function(answer){
                  var data = $.parseJSON(answer);
                  select.data('select2').dataAdapter.updateOptions(data);
                  if (select_class) {
                    select_class.data('select2').dataAdapter.updateOptions(data);
                  }
                }
            });
          }

          $( this ).dialog( "close" );
          
        }
      }
    ],
    open: function () {
      $(this).find('.viewData').remove();
      $(this).parents(".ui-dialog:first").find(".ui-dialog-titlebar").find(".widget-header").removeClass('blue');
        $(this).parents(".ui-dialog:first").find(".ui-dialog-titlebar").find(".widget-header").css({'background':'#E5E5E5','color':'#2B7DBC'});
    },
    close: function(){
      $( this ).dialog( "close" );
      //$(this).dialog('destroy');
      $( "#dialog-message-other" ).html("");
    }
  }).dialogExtend({
        "maximizable" : true,
        "minimizable" : true,
        "dblclick" : "maximize",
        "minimizeLocation" : "left"
        
      });
  dialog.load(url, function(){
     dialog.dialog('open');
 });

}