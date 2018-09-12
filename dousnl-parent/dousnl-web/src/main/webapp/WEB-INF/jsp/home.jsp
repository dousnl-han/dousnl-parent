<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class=" bit-html js_active  vc_desktop  vc_transform  vc_transform  csstransforms csstransforms3d csstransitions iphorm-js js no-touch cssanimations csstransforms csstransforms3d csstransitions cssfilters mobile-false no-touch" dir="ltr" lang="zh-CN" style=""><!--<![endif]--><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- for 360 -->
	<meta name="renderer" content="webkit"> 
	<meta name="applicable-device" content="pc,mobile">
	<meta http-equiv="Cache-Control" content="no-transform">
    <meta name="MobileOptimized" content="width">
    <meta name="HandheldFriendly" content="true">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>一个新起飞页站点</title>
	<link rel="profile" href="http://gmpg.org/xfn/11">
	<link rel="pingback" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/xmlrpc.php">
	<link rel="stylesheet" href="${ctx }/resources/static/index_files/respond.css" type="text/css" media="screen">
	<link rel="stylesheet" href="${ctx }/resources/static/index_files/986920360253a78ac64e6204ea91f7f5.css" type="text/css" media="all">
	<link rel="stylesheet" id="dt-main-css" href="${ctx }/resources/static/index_files/main.css" type="text/css" media="all">
	<link rel="stylesheet" id="dt-custom-less-css" href="${ctx }/resources/static/index_files/custom-b9a5812ca6.css" type="text/css" media="all">
	<link rel="stylesheet" id="dt-bit-custom-less-css" href="${ctx }/resources/static/index_files/bit-custom-340084bd84.css" type="text/css" media="all">
	<link rel="stylesheet" id="qfy_dynamic_css-css" href="${ctx }/resources/static/index_files/qfy-custom-style.css" type="text/css" media="all">
    <style type="text/css" id="static-stylesheet"></style>
    <style type="text/css">
		#header.menuPosition #navigation #main-nav {border-bottom: 1px solid rgba(56, 56, 56, 1);
		    border-top: 1px solid rgba(56, 56, 56, 1);}
		
		#main-nav > li:first-child{margin-left: 30px;}
		
		#header.menuPosition #navigation #main-nav{max-width:400px;}
   </style>
   <link rel="stylesheet" href="${ctx }/resources/static/index_files/db5f297bda4728f9408532901855d30a.css" type="text/css" media="all"> <!-- Cache! -->
	<script type="text/javascript">
	/* <![CDATA[ */
	/* thickbox */
	var thickboxL10n = {"next":"\u4e0b\u4e00\u5f20 >","prev":"< \u4e0a\u4e00\u5f20","image":"\u56fe\u7247","of":"\/","close":"\u5173\u95ed","noiframes":"\u8fd9\u4e2a\u529f\u80fd\u9700\u8981iframe\u7684\u652f\u6301\u3002\u60a8\u53ef\u80fd\u7981\u6b62\u4e86iframe\u7684\u663e\u793a\uff0c\u6216\u60a8\u7684\u6d4f\u89c8\u5668\u4e0d\u652f\u6301\u6b64\u529f\u80fd\u3002","loadingAnimation":"\/\/fast.qifeiye.com\/FeiEditor\/bitSite\/images\/preloader.gif"};
	/* iphorm-plugin */
	var iphormL10n = {"error_submitting_form":"\u5728\u63d0\u4ea4\u8868\u5355\u65f6\u6709\u9519\u8bef","swfupload_flash_url":"http:\/\/w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com\/qfy-includes\/js\/swfupload\/swfupload.swf","swfupload_upload_url":"http:\/\/w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com\/?iphorm_swfupload=1","swfupload_too_many":"\u961f\u5217\u4e2d\u7684\u6587\u4ef6\u592a\u591a\u4e86","swfupload_file_too_big":"\u6587\u4ef6\u592a\u5927\u4e86","swfupload_file_empty":"\u4e0d\u80fd\u4e0a\u4f20\u7a7a\u6587\u4ef6","swfupload_file_type_not_allowed":"\u8be5\u6587\u4ef6\u7684\u7c7b\u578b\u662f\u4e0d\u5141\u8bb8\u4e0a\u4f20\u7684","swfupload_unknown_queue_error":"\u672a\u77e5\u961f\u5217\u9519\u8bef\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5","swfupload_upload_error":"\u4e0a\u4f20\u9519\u8bef","swfupload_upload_failed":"\u4e0a\u4f20\u5931\u8d25","swfupload_server_io":"\u670d\u52a1\u5668IO\u9519\u8bef","swfupload_security_error":"\u5b89\u5168\u9519\u8bef","swfupload_limit_exceeded":"\u4e0a\u4f20\u8d85\u8fc7\u9650\u5236","swfupload_validation_failed":"\u9a8c\u8bc1\u5931\u8d25","swfupload_upload_stopped":"\u4e0a\u4f20\u88ab\u7ec8\u6b62","swfupload_unknown_upload_error":"\u6587\u4ef6\u4e0a\u4f20\u88ab\u610f\u5916\u7ec8\u6b62","plugin_url":"http:\/\/w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com\/qfy-content\/plugins\/qfy_form","preview_no_submit":"\u5728\u9884\u89c8\u6a21\u5f0f\u4e0b\u4e0d\u80fd\u63d0\u4ea4\u8868\u5355"};
	/* rml-general */
	var rmlOpts = {"lang":{"save":"Save","close":"\u5173\u95ed","cancel":"\u53d6\u6d88","done":"\u5b8c\u6210","failed":"\u5931\u8d25","noMedia":"No media files found.","uploadingCollection":"\u7531\u4e8e\u96c6\u5408\u4e0d\u80fd\u5305\u542b\u6587\u4ef6\uff0c\u60a8\u521a\u521a\u4e0a\u4f20\u7684\u6587\u4ef6\u5df2\u7ecf\u88ab\u8f6c\u79fb\u5230\u672a\u5206\u7c7b\u6587\u4ef6\u5939\u4e2d\u4e86\u3002","uploadingGallery":"\u56fe\u5e93\u53ea\u80fd\u5305\u542b\u56fe\u7247\u3002\u60a8\u521a\u521a\u4e0a\u4f20\u7684\u6587\u4ef6\u5df2\u7ecf\u88ab\u8f6c\u79fb\u5230\u672a\u5206\u7c7b\u6587\u4ef6\u5939\u4e2d\u53bb\u4e86\u3002","deleteFailed":"\u6587\u4ef6\u5939\u4e2d\u8fd8\u6709\u5b50\u6587\u4ef6\u5939\u54e6\uff0c\u8bf7\u5148\u5220\u9664\u5b50\u6587\u4ef6\u5939\u3002","deleteRoot":"\u8fd9\u4e2a\u6587\u4ef6\u5939\u4e0d\u80fd\u88ab\u5220\u9664\u3002","deleteConfirm":"\u60a8\u786e\u8ba4\u9700\u8981\u5220\u9664\u8fd9\u4e2a\u6587\u4ef6\u5939\u5417\uff1f\u5b83\u4e0b\u9762\u7684\u6240\u6709\u6587\u4ef6\u4f1a\u88ab\u5220\u9664\uff0c\u5e76\u4e14\u4e0d\u80fd\u6062\u590d\u3002","deleteConfirmTitle":"\u8bf7\u786e\u8ba4\u7ee7\u7eed\uff1f","deleteConfirmSubmit":"\u662f","deleteConfirmCancel":"\u53d6\u6d88","moveFromAllConfirmSubmit":"\u8f6c\u79fb","moveFromAllConfirmText":"\u60a8\u53ef\u4ee5\u5c06\u4e00\u4e2a\u6216\u8005\u591a\u4e2a\u6587\u4ef6\u8f6c\u79fb\u5230\u5bf9\u5e94\u7684\u6587\u4ef6\u5939\u3002","moveSingleFile":"\u8f6c\u79fb{0} \u4e2a\u6587\u4ef6","moveMultipleFiles":"\u8f6c\u79fb{0} \u4e2a\u6587\u4ef6","renameRoot":"\u8fd9\u4e2a\u6587\u4ef6\u5939\u4e0d\u80fd\u88ab\u91cd\u547d\u540d\u3002","renamePrompt":"\u8bf7\u8f93\u5165\u65b0\u7684\u540d\u79f0\u3002","renamePromptTitle":"\u91cd\u547d\u540d\u6587\u4ef6\u5939","orderFailedFilterOn":"In the current view of uploads are filters active. Please reset these and refresh the view.","detailsFailedOn":"\u8bf7\u5230\u5a92\u4f53\u5e93\u4e2d\u6253\u5f00\u8be6\u7ec6\u4fe1\u606f\u9762\u677f","detailsFailedAlreadyOpen":"\u5df2\u7ecf\u6253\u5f00\u4e86\u4e00\u4e2a\u8be6\u7ec6\u4fe1\u606f\u9762\u677f\u3002","wipe":"\u8bf7\u786e\u8ba4\u7ee7\u7eed\uff1f","metadata":{"coverImage":{"label_add":"\u8bbe\u7f6e\u5c01\u9762\u56fe\u7247","label_replace":"\u9009\u62e9\u53e6\u4e00\u4e2a\u5c01\u9762\u56fe\u7247","label_remove":"\u65e0\u5c01\u9762\u56fe\u7247","label_modal":"\u9009\u62e9\u60ac\u6d6e\u56fe\u7247","label_button":"\u8bbe\u7f6e\u6210\u60ac\u6d6e\u56fe\u7247"}},"createTypes":{"folder":{"toolTipTitle":"\u70b9\u51fb\u8fd9\u91cc\u53ef\u4ee5\u521b\u5efa<strong>\u6587\u4ef6\u5939<\/strong>","toolTipText":"\u6587\u4ef6\u5939\u53ef\u4ee5\u5305\u542b\u6240\u6709\u7c7b\u578b\u7684\u6587\u4ef6\u548c\u96c6\u5408\uff0c\u4f46\u662f\u4e0d\u80fd\u5305\u542b\u56fe\u5e93\u3002\u5982\u679c\u60a8\u9700\u8981\u521b\u5efa\u4e00\u4e2a\u5b50\u6587\u4ef6\u5939\uff0c\u8bf7\u70b9\u51fb\u8fd9\u91cc\u3002"},"collection":{"toolTipTitle":"\u70b9\u51fb\u8fd9\u91cc\u521b\u5efa\u4e00\u4e2a<strong>\u96c6\u5408<\/strong>","toolTipText":"\u96c6\u5408\u4e0d\u53ef\u4ee5\u5305\u542b\u6587\u4ef6\u3002\u4f46\u662f\u53ef\u4ee5\u5305\u542b\u96c6\u5408\u548c\u56fe\u5e93\u3002"},"gallery":{"toolTipTitle":"\u70b9\u51fb\u8fd9\u91cc\u521b\u5efa\u4e00\u4e2a<strong>\u56fe\u5e93<\/strong>","toolTipText":"\u56fe\u5e93\u53ea\u80fd\u5305\u542b\u56fe\u7247\uff0c\u4f46\u662f\u60a8\u53ef\u4ee5\u5bf9\u56fe\u7247\u8fdb\u884c\u6392\u5e8f\u3002"}},"toolbarItems":{"order":{"toolTipTitle":"\u5bf9\u56fe\u7247\u91cd\u65b0\u6392\u5e8f","toolTipText":"\u5bf9\u56fe\u5e93\u4e2d\u7684\u56fe\u7247\u91cd\u65b0\u6392\u5e8f\u3002","toolTipTextDisabledLink":"\u8bf7\u9009\u62e9\u4e00\u4e2a <i class='mwf-gallery'><\/i> <i>\u56fe\u5e93<\/i>\u6765\u6392\u5e8f\u3002"},"refresh":{"toolTipTitle":"\u5237\u65b0","toolTipText":"\u5237\u65b0\u5f53\u524d\u6587\u4ef6\u5939"},"rename":{"toolTipTitle":"\u91cd\u547d\u540d","toolTipText":"\u91cd\u547d\u540d\u5f53\u524d\u6587\u4ef6\u5939","toolTipTextDisabledLink":"\u9009\u4e2d\u7684\u7cfb\u7edf\u6587\u4ef6\u5939\u4e0d\u80fd\u4fee\u6539\u540d\u79f0\u3002\u8bf7\u9009\u62e9\u4e00\u4e2a\u60a8\u521b\u5efa\u7684\u6587\u4ef6\u95ee\u4ef7\u3002"},"delete":{"toolTipTitle":"\u5220\u9664","toolTipText":"\u5220\u9664\u9009\u4e2d\u7684\u6587\u4ef6\u5939","toolTipTextDisabledLink":"\u7cfb\u7edf\u6587\u4ef6\u5939\u4e0d\u80fd\u88ab\u5220\u9664\uff0c\u8bf7\u9009\u62e9\u4e00\u4e2a\u7528\u6237\u6587\u4ef6\u5939\u3002"},"rearrange":{"toolTipTitle":"\u91cd\u65b0\u6392\u5e8f","toolTipText":"\u6539\u53d8\u6587\u4ef6\u5939\u7684\u6392\u5e8f"},"details":{"toolTipTitle":"\u8be6\u7ec6\u4fe1\u606f","toolTipText":"\u67e5\u770b\u9009\u4e2d\u6587\u4ef6\u5939\u7684\u8be6\u7ec6\u4fe1\u606f","toolTipTextDisabledLink":"\u8bf7\u5148\u9009\u62e9\u4e00\u4e2a\u6587\u4ef6\u5939"}},"mceButtonTooltip":"\u56fe\u5e93","mceListBoxDirsTooltip":"\u8bf7\u9009\u62e9\u4e00\u4e2a\u56fe\u5e93","mceBodyGallery":"\u6587\u4ef6\u5939","mceBodyLinkTo":"Link to","mceBodyColumns":"\u680f\u76ee","mceBodyRandomOrder":"\u968f\u673a\u987a\u5e8f","mceBodySize":"Size","mceBodyLinkToValues":[{"value":"post","text":"Attachment File"},{"value":"file","text":"\u5a92\u4f53\u6587\u4ef6"},{"value":"none","text":"\u65e0"}],"mceBodySizeValues":[{"value":"thumbnail","text":"\u7f29\u7565\u56fe"},{"value":"medium","text":"\u4e2d\u7b49"},{"value":"large","text":"\u5927"},{"value":"full","text":"\u5b8c\u6574\u5c3a\u5bf8"}]},"ajaxUrl":"http:\/\/w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com\/admin\/admin-ajax.php","namesSlug":{"names":["\u672a\u6574\u7406\u7684\u56fe\u7247"],"slugs":[-1],"types":[0]},"blogId":"1","listMode":"grid","nonces":{"bulkMove":"dcd0300b41","bulkSort":"3eb57075a3","folderCount":"7a083c03cf","folderRename":"8ab8334655","folderDelete":"0d7add9cc4","folderCreate":"e3843ab244","sidebarResize":"b9d91b06e0","treeContent":"15db298783","attachmentOrder":"732a765491","attachmentOrderResetAll":"2d8378357a","attachmentOrderReset":"850762adc1","attachmentOrderReindex":"3eaa485034","metaContent":"d4d5da1260","metaSave":"1a806edcbe","wipe":"b454bb18f9"},"wpListModeOrder":"1"};
	/* dt-plugins */
	var dtLocal = {"passText":"\u67e5\u770b\u8fd9\u4e2a\u52a0\u5bc6\u8d44\u8baf\uff0c\u8bf7\u5728\u4e0b\u9762\u8f93\u5165\u5bc6\u7801\uff1a","moreButtonAllLoadedText":"\u5168\u90e8\u5df2\u52a0\u8f7d","postID":"5365","ajaxurl":"http:\/\/w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com\/http:\/\/w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com\/admin\/admin-ajax.php","contactNonce":"c3a59f6dbf","ajaxNonce":"97f0c29c3b","pageData":{"type":"page","template":"page","layout":null},"themeSettings":{"smoothScroll":"on"}};
	
	/* ]]> */
	</script>
    <script type="text/javascript" src="${ctx }/resources/static/index_files/ec43373bbf659a9559df23d46dec62e4.js"></script>
	<link rel="EditURI" type="application/rsd+xml" title="RSD" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/xmlrpc.php?rsd">
	<link rel="wlwmanifest" type="application/wlwmanifest+xml" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/qfy-includes/wlwmanifest.xml"> 
	
	<link rel="canonical" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/">
	<link rel="shortlink" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=5365">
	<style class="style_0">.bitRightSider .widget-title,.bitLeftSider .widget-title{padding:0 0 0 10px;height:35px;line-height:35px;background-color:transparent;margin:0px;font-family:微软雅黑;font-size:16px;font-weight:bold;font-style:normal;text-decoration:none;color:#acc4ac;border-top:0;border-left:0;border-right:0;border-bottom:0;background-image:none;-webkit-border-top-left-radius: 0;-webkit-border-top-right-radius: 0;-moz-border-radius-topleft: 0;-moz-border-radius-topright: 0;border-top-left-radius: 0;border-top-right-radius: 0;} .bitRightSider .widget-title,.bitLeftSider .widget-title{border-top:0;border-left:0;border-right:0;} .bitRightSider .bitWidgetFrame,.bitLeftSider .bitWidgetFrame{border-bottom:0;border-top:0;border-left:0;border-right:0;padding:4px 10px 4px 10px;}.bitRightSider .site_tooler,.bitLeftSider .site_tooler{-webkit-box-shadow:none;box-shadow:none;}.bitRightLeftSiderWidget.site_tooler .bitWidgetFrame,.bitRightLeftSiderWidget.site_tooler .bitWidgetFrame{background-color:transparent;background-image:none;background-repeat: repeat;-webkit-border-bottom-left-radius: 0px;border-bottom-left-radius: 0px;-webkit-border-bottom-right-radius: 0px;border-bottom-right-radius: 0px;}body .bitRightSider .bitWidgetFrame,.bitLeftSider .bitWidgetFrame{padding-top:0px !important;padding-bottom:0px !important;}</style><style class="style_0">.footer .widget-title{padding:0 0 0 10px;height:28px;line-height:28px;background-color:#ffffff;margin:0px;font-family:微软雅黑;font-size:16px;font-weight:normal;font-style:normal;text-decoration:none;color:#0099cc;border-top:0px solid #024886;border-bottom:1px solid #DDDDDD;border-left:0px solid #024886;border-right:0px solid #024886;background-image:none;-webkit-border-top-left-radius: 0;-webkit-border-top-right-radius: 0;-moz-border-radius-topleft: 0;-moz-border-radius-topright: 0;border-top-left-radius: 0;border-top-right-radius: 0;} .footer  .bitWidgetFrame{border-top:0px solid #bababa;border-bottom:0px solid #bababa;border-left:0px solid #bababa;border-right:0px solid #bababa;padding:4px 10px 4px 10px;-webkit-border-bottom-left-radius: 0;-webkit-border-bottom-right-radius: 0;-moz-border-radius-bottomleft: 0;-moz-border-radius-bottomright: 0;border-bottom-left-radius: 0;border-bottom-right-radius: 0;}.footer .site_tooler{-webkit-box-shadow:none;box-shadow:none;}.footer .site_tooler .bitWidgetFrame{background-color:transparent;background-image:none;background-repeat: repeat;-webkit-border-bottom-left-radius: 0px;border-bottom-left-radius: 0px;-webkit-border-bottom-right-radius: 0px;border-bottom-right-radius: 0px;}</style><meta name="robots" content="index, follow">
			<style type="text/css">
	body {background-color: #c5dfc5;background-position:left top;background-repeat:no-repeat;background-size: cover;background-attachment: fixed;}
	#page{background-color: rgba(255,255,255,0);background-position:center top;background-repeat:repeat;background-size: cover;background-attachment: fixed;}
	.old-ie #page{background-color: #848484;background-position:center top;background-repeat:repeat;background-size: cover;background-attachment: fixed;}
	</style>
		<script type="text/javascript">
			dtGlobals.logoEnabled = 1;dtGlobals.curr_id = 5365;dtGlobals.logoURL = '';dtGlobals.logoW = '0';dtGlobals.logoH = '0';dtGlobals.qfyname = '起飞页';dtGlobals.id = '593a0512292ac';dtGlobals.language = '';smartMenu = 0;document.cookie='resolution='+Math.max(screen.width,screen.height)+'; path=/';
			dtGlobals.gallery_bgcolor = 'rgba(51,51,51,1)';dtGlobals.gallery_showthumbs = '0';dtGlobals.gallery_style = '';dtGlobals.gallery_autoplay = '0';dtGlobals.gallery_playspeed = '3';dtGlobals.gallery_imagesize = '100';dtGlobals.gallery_stopbutton = '';dtGlobals.gallery_thumbsposition = '';dtGlobals.gallery_tcolor = '#fff';dtGlobals.gallery_tsize = '16';dtGlobals.gallery_dcolor = '#fff';dtGlobals.gallery_dsize = '14';dtGlobals.gallery_tfamily = '';dtGlobals.gallery_dfamily = '';dtGlobals.gallery_blankclose = '0';dtGlobals.fm_showstyle = '';dtGlobals.fm_showspeed = '';dtGlobals.cdn_url = 'http://static.qifeiye.com';dtGlobals.qfymodel = "1";dtGlobals.viewtemplate = "";
						var socail_back_url = '';
					</script>

			

    </head>


  <body class="home page page-id-5365 page-template-default logged-in image-blur boxed-layout btn-flat wpb-js-composer js-comp-ver-4.0.1 vc_responsive no-mobile is-webkit mobilefloatmenu" backgroundsize="true" data-pid="5365" data-pkey="b9b5b39c64d6a76af058efa5a554516d" style=""><div class="dl-menuwrapper  wf-mobile-visible floatmenu floatwarpper left"><div class="dl-container"><ul data-st="0" data-sp="0" data-fh="" data-mw="" data-lh="" class="dl-menu" data-bit-menu="underline-hover" data-bit-float-menu="underline-hover"><li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-8304 menu-item-8312 first level-arrows-on"><a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?page_id=8304"><span>博客<i class="underline"></i></span></a></li><li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-7609 menu-item-7610 level-arrows-on"><a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?page_id=7609"><span>关于我<i class="underline"></i></span></a></li><li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-5434 menu-item-10042 level-arrows-on"><a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?page_id=5434"><span>和我联系<i class="underline"></i></span></a></li>
     </ul></div></div><link href="${ctx }/resources/static/index_files/jiathis_share.css" rel="stylesheet" type="text/css"><div class="jiathis_style" style="height: auto; position: fixed; z-index: 100000000; top: 150px; right: 0px; overflow: hidden; width: 26px;"><table cellpadding="0" cellspacing="0"><tbody style="background:transparent"><tr><td style="background:transparent"><img src="${ctx }/resources/static/index_files/r5.gif" style="cursor:pointer;" onmouseover="$CKE.over()" onclick="$CKE.center(this)"></td><td><div><div class="jiadiv_01"><div style="width:100%;background:#F2F2F2;border-bottom:1px solid #E5E5E5;line-height:200%;padding-left:5px;font-size:12px"><table width="100%"><tbody><tr class="jt_sharetitle"><td align="left" style="text-align:left;line-height:25px;font-size:14px;font-weight:bold;color:#000000;">分享到...</td><td align="right" style="text-align:right;"><img src="${ctx }/resources/static/index_files/img_exit.gif" border="0" style="opacity:0.5;filter:alpha(opacity=50);margin:0 10px;cursor:pointer;" onclick="$CKE.shareClose();"></td></tr></tbody></table></div><div class="jiadiv_02" style="width:100%;" id="jiathis_sers"><a href="javascript:;" onclick="jiathis_sendto(&#39;weixin&#39;);return false;" class="jiatitle"><span class="jtico jtico_weixin">微信</span></a><a href="javascript:;" onclick="jiathis_sendto(&#39;tsina&#39;);return false;" class="jiatitle"><span class="jtico jtico_tsina">微博</span></a><a href="javascript:;" onclick="jiathis_sendto(&#39;copy&#39;);return false;" class="jiatitle"><span class="jtico jtico_copy">复制网址</span></a><a href="javascript:;" onclick="jiathis_sendto(&#39;email&#39;);return false;" class="jiatitle"><span class="jtico jtico_email">邮件</span></a><a href="javascript:;" onclick="jiathis_sendto(&#39;cqq&#39;);return false;" class="jiatitle"><span class="jtico jtico_cqq">QQ好友</span></a><a href="javascript:;" onclick="jiathis_sendto(&#39;qzone&#39;);return false;" class="jiatitle"><span class="jtico jtico_qzone">QQ空间</span></a><a href="javascript:;" onclick="jiathis_sendto(&#39;renren&#39;);return false;" class="jiatitle"><span class="jtico jtico_renren">人人网</span></a><a href="javascript:;" onclick="jiathis_sendto(&#39;kaixin001&#39;);return false;" class="jiatitle"><span class="jtico jtico_kaixin001">开心网</span></a><a href="javascript:;" onclick="jiathis_sendto(&#39;evernote&#39;);return false;" class="jiatitle"><span class="jtico jtico_evernote">印象笔记</span></a><a href="javascript:;" onclick="jiathis_sendto(&#39;linkedin&#39;);return false;" class="jiatitle"><span class="jtico jtico_linkedin">领英</span></a><a href="javascript:;" onclick="jiathis_sendto(&#39;feixin&#39;);return false;" class="jiatitle"><span class="jtico jtico_feixin">飞信</span></a><a href="javascript:;" onclick="jiathis_sendto(&#39;douban&#39;);return false;" class="jiatitle"><span class="jtico jtico_douban">豆瓣</span></a><a href="javascript:;" onclick="jiathis_sendto(&#39;twitter&#39;);return false;" class="jiatitle"><span class="jtico jtico_twitter">Twitter</span></a><a href="javascript:;" onclick="jiathis_sendto(&#39;fb&#39;);return false;" class="jiatitle"><span class="jtico jtico_fb">Facebook</span></a><a href="javascript:;" onclick="jiathis_sendto(&#39;ishare&#39;);return false;" class="jiatitle"><span class="jtico jtico_ishare">一键分享</span></a><a href="javascript:;" onclick="$CKE.center(this);return false;" class="jiatitle"><span class="jtico jtico_jiathis">查看更多(96)</span></a><div style="clear:both"></div></div><div class="ckepopBottom" style="width:100%;"><div style="float:left;font-size:10px"><a href="http://www.jiathis.com/help/html/what-is-jiathis" class="link_01" style="color:#333333;display:none;" target="_blank">这是什么工具?</a></div><div style="float:right;font-size:11px;margin:0 5px 0 0;"><img src="${ctx }/resources/static/index_files/img_012.gif" align="absmiddle" border="0"><a href="http://www.jiathis.com/index2" style="color:#333333;padding:0 3px;" class="link_01" target="_blank">JiaThis</a></div><div style="clear:both"></div></div></div></div></td></tr></tbody></table></div><iframe frameborder="0" style="position: absolute; display: none;"></iframe><div class="jiathis_style" style="height: auto; position: absolute; z-index: 100000000; display: none; top: 50%; left: 50%; overflow: auto;"><div style="border:10px solid #7F7F7F; width:300px;"><div class="jiadiv_01" style="width:300px;"><div style="background:#F2F2F2;line-height:100%;height:30px;overflow:hidden;width:300px;"><table width="100%" style="margin:5px 0 0 0;"><tbody><tr class="jt_sharetitle" style="line-height:20px!important;"><td align="left" style="text-align:left;font-size:12px;">分享到各大网站</td><td align="right"><img src="${ctx }/resources/static/index_files/img_exit.gif" border="0" style="margin:0 4px;cursor:pointer;" onclick="$CKE.centerClose();"></td></tr></tbody></table></div><div class="searchTxtCont"><div style="background:url(http://v3.jiathis.com/code/images/img_so.gif) no-repeat center;height:30px; width:281px"><form onsubmit="return false;"><input class="searchTxt" name="" type="text" onclick="this.value=&#39;&#39;;this.style.color=&#39;#000&#39;;" value="输入网站名或拼音缩写" onkeyup="$CKE.choose(this);"></form></div></div><div id="jiathis_sharelist" class="jiadiv_02" style="width:300px;height:300px;overflow-y:auto;"><a href="javascript:;" onclick="jiathis_sendto(&#39;weixin&#39;);return false;" class="jiatitle"><span class="jtico jtico_weixin">微信</span><input type="hidden" value="weixin,微信,wx"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;tsina&#39;);return false;" class="jiatitle"><span class="jtico jtico_tsina">微博</span><input type="hidden" value="tsina,微博,xlwb"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;cqq&#39;);return false;" class="jiatitle"><span class="jtico jtico_cqq">QQ好友</span><input type="hidden" value="cqq,QQ好友,cqq"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;qzone&#39;);return false;" class="jiatitle"><span class="jtico jtico_qzone">QQ空间</span><input type="hidden" value="qzone,QQ空间,qqkj"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;copy&#39;);return false;" class="jiatitle"><span class="jtico jtico_copy">复制网址</span><input type="hidden" value="copy,复制网址,fzwz"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;fav&#39;);return false;" class="jiatitle"><span class="jtico jtico_fav">收藏夹</span><input type="hidden" value="fav,收藏夹,scj"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;print&#39;);return false;" class="jiatitle"><span class="jtico jtico_print">打印</span><input type="hidden" value="print,打印,dy"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;email&#39;);return false;" class="jiatitle"><span class="jtico jtico_email">邮件</span><input type="hidden" value="email,邮件,yj"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;renren&#39;);return false;" class="jiatitle"><span class="jtico jtico_renren">人人网</span><input type="hidden" value="renren,人人网,rrw"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;kaixin001&#39;);return false;" class="jiatitle"><span class="jtico jtico_kaixin001">开心网</span><input type="hidden" value="kaixin001,开心网,kxw"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;evernote&#39;);return false;" class="jiatitle"><span class="jtico jtico_evernote">印象笔记</span><input type="hidden" value="evernote,印象笔记,evernote"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;linkedin&#39;);return false;" class="jiatitle"><span class="jtico jtico_linkedin">领英</span><input type="hidden" value="linkedin,领英,linkedin"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;feixin&#39;);return false;" class="jiatitle"><span class="jtico jtico_feixin">飞信</span><input type="hidden" value="feixin,飞信,fx"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;douban&#39;);return false;" class="jiatitle"><span class="jtico jtico_douban">豆瓣</span><input type="hidden" value="douban,豆瓣,db"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;twitter&#39;);return false;" class="jiatitle"><span class="jtico jtico_twitter">Twitter</span><input type="hidden" value="twitter,Twitter,twitter"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;fb&#39;);return false;" class="jiatitle"><span class="jtico jtico_fb">Facebook</span><input type="hidden" value="fb,Facebook,facebook"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;ishare&#39;);return false;" class="jiatitle"><span class="jtico jtico_ishare">一键分享</span><input type="hidden" value="ishare,一键分享,yjfx"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;ujian&#39;);return false;" class="jiatitle"><span class="jtico jtico_ujian">猜你喜欢</span><input type="hidden" value="ujian,猜你喜欢,cnxh"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;yixin&#39;);return false;" class="jiatitle"><span class="jtico jtico_yixin">易信</span><input type="hidden" value="yixin,易信,yx"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;huaban&#39;);return false;" class="jiatitle"><span class="jtico jtico_huaban">花瓣网</span><input type="hidden" value="huaban,花瓣网,hbw"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;tqq&#39;);return false;" class="jiatitle"><span class="jtico jtico_tqq">腾讯微博</span><input type="hidden" value="tqq,腾讯微博,txwb"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;googleplus&#39;);return false;" class="jiatitle"><span class="jtico jtico_googleplus">Google+</span><input type="hidden" value="googleplus,Google+,googlej"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;alibaba&#39;);return false;" class="jiatitle"><span class="jtico jtico_alibaba">阿里巴巴</span><input type="hidden" value="alibaba,阿里巴巴,albb"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;xiaoyou&#39;);return false;" class="jiatitle"><span class="jtico jtico_xiaoyou">朋友网</span><input type="hidden" value="xiaoyou,朋友网,pyw"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;sdonote&#39;);return false;" class="jiatitle"><span class="jtico jtico_sdonote">麦库记事</span><input type="hidden" value="sdonote,麦库记事,mkjs"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;baidu&#39;);return false;" class="jiatitle"><span class="jtico jtico_baidu">百度搜藏</span><input type="hidden" value="baidu,百度搜藏,bdsc"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;gmail&#39;);return false;" class="jiatitle"><span class="jtico jtico_gmail">Gmail邮箱</span><input type="hidden" value="gmail,Gmail邮箱,gmailyx"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;ydnote&#39;);return false;" class="jiatitle"><span class="jtico jtico_ydnote">有道云笔记</span><input type="hidden" value="ydnote,有道云笔记,ydybj"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;tianya&#39;);return false;" class="jiatitle"><span class="jtico jtico_tianya">天涯社区</span><input type="hidden" value="tianya,天涯社区,tysq"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;tieba&#39;);return false;" class="jiatitle"><span class="jtico jtico_tieba">百度贴吧</span><input type="hidden" value="tieba,百度贴吧,bdtb"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;qingbiji&#39;);return false;" class="jiatitle"><span class="jtico jtico_qingbiji">轻笔记</span><input type="hidden" value="qingbiji,轻笔记,qbj"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;tifeng&#39;);return false;" class="jiatitle"><span class="jtico jtico_tifeng">凤凰微博</span><input type="hidden" value="tifeng,凤凰微博,fhwb"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;fanfou&#39;);return false;" class="jiatitle"><span class="jtico jtico_fanfou">饭否</span><input type="hidden" value="fanfou,饭否,ff"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;mingdao&#39;);return false;" class="jiatitle"><span class="jtico jtico_mingdao">明道</span><input type="hidden" value="mingdao,明道,md"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;douban9dian&#39;);return false;" class="jiatitle"><span class="jtico jtico_douban9dian">豆瓣9点</span><input type="hidden" value="douban9dian,豆瓣9点,db9d"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;google&#39;);return false;" class="jiatitle"><span class="jtico jtico_google">谷歌</span><input type="hidden" value="google,谷歌,gg"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;buzz&#39;);return false;" class="jiatitle"><span class="jtico jtico_buzz">谷歌Buzz</span><input type="hidden" value="buzz,谷歌Buzz,ggbuzz"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;youdao&#39;);return false;" class="jiatitle"><span class="jtico jtico_youdao">有道书签</span><input type="hidden" value="youdao,有道书签,ydsq"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;qq&#39;);return false;" class="jiatitle"><span class="jtico jtico_qq">QQ书签</span><input type="hidden" value="qq,QQ书签,qqsq"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;msn&#39;);return false;" class="jiatitle"><span class="jtico jtico_msn">MSN</span><input type="hidden" value="msn,MSN,msn"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;pinterest&#39;);return false;" class="jiatitle"><span class="jtico jtico_pinterest">Pinterest</span><input type="hidden" value="pinterest,Pinterest,pinterest"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;duitang&#39;);return false;" class="jiatitle"><span class="jtico jtico_duitang">堆糖</span><input type="hidden" value="duitang,堆糖,dt"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;tyaolan&#39;);return false;" class="jiatitle"><span class="jtico jtico_tyaolan">摇篮微博</span><input type="hidden" value="tyaolan,摇篮微博,ylwb"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;hi&#39;);return false;" class="jiatitle"><span class="jtico jtico_hi">百度空间</span><input type="hidden" value="hi,百度空间,bdkj"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;hotmail&#39;);return false;" class="jiatitle"><span class="jtico jtico_hotmail">Hotmail邮箱</span><input type="hidden" value="hotmail,Hotmail邮箱,hotmailyx"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;xqw&#39;);return false;" class="jiatitle"><span class="jtico jtico_xqw">雪球</span><input type="hidden" value="xqw,雪球,xqw"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;hexun&#39;);return false;" class="jiatitle"><span class="jtico jtico_hexun">和讯</span><input type="hidden" value="hexun,和讯,hx"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;139mail&#39;);return false;" class="jiatitle"><span class="jtico jtico_139mail">139邮箱</span><input type="hidden" value="139mail,139邮箱,139yx"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;189mail&#39;);return false;" class="jiatitle"><span class="jtico jtico_189mail">189邮箱</span><input type="hidden" value="189mail,189邮箱,189yx"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;189cn&#39;);return false;" class="jiatitle"><span class="jtico jtico_189cn">翼友圈</span><input type="hidden" value="189cn,翼友圈,yyq"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;tpeople&#39;);return false;" class="jiatitle"><span class="jtico jtico_tpeople">人民微博</span><input type="hidden" value="tpeople,人民微博,rmwb"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;txinhua&#39;);return false;" class="jiatitle"><span class="jtico jtico_txinhua">新华微博</span><input type="hidden" value="txinhua,新华微博,xhwb"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;translate&#39;);return false;" class="jiatitle"><span class="jtico jtico_translate">谷歌翻译</span><input type="hidden" value="translate,谷歌翻译,ggfy"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;tuita&#39;);return false;" class="jiatitle"><span class="jtico jtico_tuita">推他</span><input type="hidden" value="tuita,推他,tt"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;mop&#39;);return false;" class="jiatitle"><span class="jtico jtico_mop">猫扑推客</span><input type="hidden" value="mop,猫扑推客,mptk"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;meilishuo&#39;);return false;" class="jiatitle"><span class="jtico jtico_meilishuo">美丽说</span><input type="hidden" value="meilishuo,美丽说,mls"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;mogujie&#39;);return false;" class="jiatitle"><span class="jtico jtico_mogujie">蘑菇街</span><input type="hidden" value="mogujie,蘑菇街,mgj"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;ganniu&#39;);return false;" class="jiatitle"><span class="jtico jtico_ganniu">赶牛网</span><input type="hidden" value="ganniu,赶牛网,gnw"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;poco&#39;);return false;" class="jiatitle"><span class="jtico jtico_poco">Poco网</span><input type="hidden" value="poco,Poco网,pocow"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;leihou&#39;);return false;" class="jiatitle"><span class="jtico jtico_leihou">雷猴网</span><input type="hidden" value="leihou,雷猴网,lhw"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;thexun&#39;);return false;" class="jiatitle"><span class="jtico jtico_thexun">和讯微博</span><input type="hidden" value="thexun,和讯微博,hxwb"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;dream163&#39;);return false;" class="jiatitle"><span class="jtico jtico_dream163">游戏江湖</span><input type="hidden" value="dream163,游戏江湖,yxjh"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;jcrb&#39;);return false;" class="jiatitle"><span class="jtico jtico_jcrb">法律微博</span><input type="hidden" value="jcrb,法律微博,flwb"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;tumblr&#39;);return false;" class="jiatitle"><span class="jtico jtico_tumblr">Tumblr</span><input type="hidden" value="tumblr,Tumblr,tumblr"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;reddit&#39;);return false;" class="jiatitle"><span class="jtico jtico_reddit">Reddit</span><input type="hidden" value="reddit,Reddit,reddit"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;instapaper&#39;);return false;" class="jiatitle"><span class="jtico jtico_instapaper">Instapaper</span><input type="hidden" value="instapaper,Instapaper,instapaper"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;pocket&#39;);return false;" class="jiatitle"><span class="jtico jtico_pocket">Pocket</span><input type="hidden" value="pocket,Pocket,pocket"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;caimi&#39;);return false;" class="jiatitle"><span class="jtico jtico_caimi">财迷</span><input type="hidden" value="caimi,财迷,cm"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;iwo&#39;);return false;" class="jiatitle"><span class="jtico jtico_iwo">WO+分享</span><input type="hidden" value="iwo,WO+分享,iwo"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;waakee&#39;);return false;" class="jiatitle"><span class="jtico jtico_waakee">挖客网</span><input type="hidden" value="waakee,挖客网,wkw"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;cyzone&#39;);return false;" class="jiatitle"><span class="jtico jtico_cyzone">创业邦</span><input type="hidden" value="cyzone,创业邦,cyb"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;99earth&#39;);return false;" class="jiatitle"><span class="jtico jtico_99earth">救救地球</span><input type="hidden" value="99earth,救救地球,jjdq"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;chouti&#39;);return false;" class="jiatitle"><span class="jtico jtico_chouti">抽屉网</span><input type="hidden" value="chouti,抽屉网,ctw"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;dig24&#39;);return false;" class="jiatitle"><span class="jtico jtico_dig24">递客网</span><input type="hidden" value="dig24,递客网,dkw"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;yijee&#39;);return false;" class="jiatitle"><span class="jtico jtico_yijee">易集网</span><input type="hidden" value="yijee,易集网,yjw"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;pdfonline&#39;);return false;" class="jiatitle"><span class="jtico jtico_pdfonline">Pdf在线转换</span><input type="hidden" value="pdfonline,Pdf在线转换,pdfzxzh"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;printfriendly&#39;);return false;" class="jiatitle"><span class="jtico jtico_printfriendly">友好打印</span><input type="hidden" value="printfriendly,友好打印,yhdy"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;w3c&#39;);return false;" class="jiatitle"><span class="jtico jtico_w3c">W3c验证</span><input type="hidden" value="w3c,W3c验证,w3cyz"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;bitly&#39;);return false;" class="jiatitle"><span class="jtico jtico_bitly">Bit.ly</span><input type="hidden" value="bitly,Bit.ly,bitly"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;digg&#39;);return false;" class="jiatitle"><span class="jtico jtico_digg">Digg</span><input type="hidden" value="digg,Digg,digg"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;mailru&#39;);return false;" class="jiatitle"><span class="jtico jtico_mailru">Mail.ru</span><input type="hidden" value="mailru,Mail.ru,mail.ru"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;diigo&#39;);return false;" class="jiatitle"><span class="jtico jtico_diigo">Diigo</span><input type="hidden" value="diigo,Diigo,diigo"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;friendfeed&#39;);return false;" class="jiatitle"><span class="jtico jtico_friendfeed">FriendFeed</span><input type="hidden" value="friendfeed,FriendFeed,friendfeed"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;myspace&#39;);return false;" class="jiatitle"><span class="jtico jtico_myspace">Myspace</span><input type="hidden" value="myspace,Myspace,myspace"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;mixx&#39;);return false;" class="jiatitle"><span class="jtico jtico_mixx">Mixx</span><input type="hidden" value="mixx,Mixx,mixx"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;netlog&#39;);return false;" class="jiatitle"><span class="jtico jtico_netlog">NetLog</span><input type="hidden" value="netlog,NetLog,netlog"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;netvibes&#39;);return false;" class="jiatitle"><span class="jtico jtico_netvibes">Netvibes</span><input type="hidden" value="netvibes,Netvibes,netvibes"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;phonefavs&#39;);return false;" class="jiatitle"><span class="jtico jtico_phonefavs">Phonefavs</span><input type="hidden" value="phonefavs,Phonefavs,phonefavs"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;pingfm&#39;);return false;" class="jiatitle"><span class="jtico jtico_pingfm">Ping.fm</span><input type="hidden" value="pingfm,Ping.fm,ping.fm"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;plaxo&#39;);return false;" class="jiatitle"><span class="jtico jtico_plaxo">Plaxo</span><input type="hidden" value="plaxo,Plaxo,plaxo"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;delicious&#39;);return false;" class="jiatitle"><span class="jtico jtico_delicious">Delicious</span><input type="hidden" value="delicious,Delicious,delicious"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;wong&#39;);return false;" class="jiatitle"><span class="jtico jtico_wong">Mister Wong</span><input type="hidden" value="wong,Mister Wong,misterwong"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;stumbleupon&#39;);return false;" class="jiatitle"><span class="jtico jtico_stumbleupon">Stumbleupon</span><input type="hidden" value="stumbleupon,Stumbleupon,stumbleupon"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;plurk&#39;);return false;" class="jiatitle"><span class="jtico jtico_plurk">Plurk</span><input type="hidden" value="plurk,Plurk,plurk"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;funp&#39;);return false;" class="jiatitle"><span class="jtico jtico_funp">Funp</span><input type="hidden" value="funp,Funp,funp"></a><a href="javascript:;" onclick="jiathis_sendto(&#39;myshare&#39;);return false;" class="jiatitle"><span class="jtico jtico_myshare">Myshare</span><input type="hidden" value="myshare,Myshare,myshare"></a><div style="clear:both"></div></div><div class="centerBottom"><div style="float:left;font-size:10px;"><a href="http://www.jiathis.com/help/html/what-is-jiathis" class="link_01" style="color:#333333;display:none;" target="_blank">这是什么工具?</a></div><div style="float:right;font-size:11px;margin:0 10px 0 0;"><img src="${ctx }/resources/static/index_files/img_012.gif" align="absmiddle" border="none">&nbsp;<a href="http://www.jiathis.com/index2" style="color:#333333;" class="link_01" target="_blank">JiaThis</a></div><div style="clear:both"></div></div></div></div></div>
     <iframe frameborder="0" src="${ctx}/resources/static/index_files/jiathis_utility.html" style="display: none;"></iframe>

      <div id="page" backgroundsize="true" class=" breackall boxed ">
	      <div id="dl-menu" class="dl-menuwrapper wf-mobile-visible floatmenu left" style="right: 8px; top: 8px;">
		      <a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?qfy_preview=1#show-menu" data-padding="" data-top="8" data-right="8" rel="nofollow" id="mobile-menu" class="glyphicon glyphicon-icon-align-justify floatmenu left">
						<span class="menu-open  phone-text">首页</span>
						<span class="menu-close">关闭</span>
						<span class="menu-back">返回上一级</span>
						<span class="wf-phone-visible">&nbsp;</span>
			   </a>
		   </div>



	 <header id="header" class="logo-left-right headerPM menuPosition" role="banner"><!-- class="overlap"; class="logo-left", class="logo-center", class="logo-classic" -->
		<div class="wf-wrap">
			<div class="wf-table">

				

<div id="branding" class="wf-td bit-logo-bar" style="">
	<a class="bitem logo nomarl" style="display: table-cell;" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/"><span class="logospan"><img class="preload-me" src="${ctx }/resources/static/index_files/169f1704ebc31eb465388cf65334cddd.png" width="115" height="186" alt="一个新起飞页站点"></span></a>
		<div class="bitem text" style="display: table-cell;vertical-align: middle;"><a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/" style="text-decoration: none;"></a><div id="bit-logoText" data-margin-left="17" style="position:relative;font-size:16px;  margin-left:17px;"><a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/" style="text-decoration: none;"></a><div class="logotext_outner"><a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/" style="text-decoration: none;"></a><div class="logotext_inner"><a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/" style="text-decoration: none;"></a><div><a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/" style="text-decoration: none;"><span style="font-size: 28px;"></span></a><a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?page_id=5365" target="_blank"><span style="color:#383838;"><span style="font-size: 30px;"><strong>Marry's&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></span></span></a><span style="color:#383838;"><br>
<span style="font-size: 28px;"></span></span>
<div>
<div style="text-align:left;"><a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?page_id=5365" target="_blank"><span style="color:#383838;"><span style="font-size: 30px;"><strong>Blog</strong></span></span></a><span style="color:#FFFFFF;"><span style="font-size: 28px;"></span></span></div>
</div>
</div>
</div></div></div>	</div>
	<!-- <div id="site-title" class="assistive-text"></div>
	<div id="site-description" class="assistive-text"></div> -->
</div>
						<!-- !- Navigation -->
		<nav style="0" id="navigation" class="wf-td" bitdataaction="site_menu_container" bitdatalocation="primary">
			<ul id="main-nav" data-st="0" data-sp="0" data-fh="" data-mw="" data-lh="" class="mainmenu fancy-rollovers wf-mobile-hidden bit-menu-default underline-hover" data-bit-menu="underline-hover" data-bit-float-menu="underline-hover"><li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-8304 menu-item-8312 first level-arrows-on"><a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?page_id=8304"><span>博客<i class="underline"></i></span></a></li><li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-7609 menu-item-7610 level-arrows-on"><a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?page_id=7609"><span>关于我<i class="underline"></i></span></a></li><li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-5434 menu-item-10042 level-arrows-on"><a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?page_id=5434"><span>和我联系<i class="underline"></i></span></a></li>
</ul>
						
			<div id="dl-menu" class="dl-menuwrapper wf-mobile-visible main-mobile-menu left" style="display: none; right: 8px; top: 8px;"></div>

					</nav>
		<div style="display:none;" id="main-nav-slide">
									<div class="main-nav-slide-inner" data-class="">
				<div class="floatmenu-bar-right bit_widget_more" bitdatamarker="bitHeader-3" bitdataaction="site_fix_container" bitdatacolor="white">
					 				</div>
			</div>
		</div>
		
									<div class="wf-td assistive-info    " role="complementary" style="">
					  <div class="top-bar-right right bit_widget_more" bitdatamarker="bitHeader-2" bitdataaction="site_fix_container" bitdatacolor="white" style="">
                          <div id="search-4" style="margin-top:0px;margin-bottom:20px;" class="headerWidget_1 widget_search site_tooler"><style>
	.search_from-593a0565e678a686128 #form_search::-moz-placeholder { color:#8d9095; }
	.search_from-593a0565e678a686128 #form_search::-webkit-input-placeholder { color:#8d9095; }
</style>


<div class="bitSearchFrom bitWidgetFrame search_from-593a0565e678a686128 ">
	<form class="searchform " method="get" action="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/" style="margin-right:10px;" onsubmit="return searchResult(this);">
				<input type="hidden" name="page_id" value="6432">
				<input type="hidden" name="searchtype" value="">
				<input type="text" style="background:#ffffff;border:1px solid #e0e0e0;color:#8d9095;font-size:13px;line-height:15px;padding-top:8px;padding-bottom:8px;height:33px;" name="search" id="form_search" value="" placeholder="请输入关键字">
		<input type="submit" class="assistive-text searchsubmit" value="Go!">
		<a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?qfy_preview=1#go" style="width:auto;line-height: 33px;height: 33px;background: #fb8200 none repeat scroll 0 0;border: 0 none;border-radius: 0;color: #ffffff;cursor: pointer;font-size: 13px;font-weight: normal;margin: 0;padding: 0px 10px ;text-indent: 0;text-shadow: none;transition: all 0.2s ease 0s;right: 0;top:5px;" class="submit fa fa-search"></a>
	</form>
</div>

</div>                        </div>
					</div>
			</div><!-- #branding -->
		</div><!-- .wf-wrap -->
	</header><!-- #masthead -->

 <section class="bitBanner" id="bitBanner" bitdatamarker="bitBanner" bitdataaction="site_fix_container">
	</section>
<div id="main" class="bit_main_content">


		<div class="main-gradient"></div>

		<div class="wf-wrap">
			<div class="wf-container-main">

				

			

			<div id="content" class="content" role="main">

								<div class="main-outer-wrapper ">
		<div class="bit_row">
			
				<div class="page-wrapper twelve columns left-sidebar ">
                    <div class="bit_row">
						<section class="left-sidebar-wrapper three mobileHidden wf-mobile-hidden columns ">
							<div class="bitLeftSider wpb_row" bitdataaction="site_widget_container" bitdatamarker="bitLeftSider" style="background-color:#ffffff;">
                            <div id="bit_postlist-2" style="margin-top:0px;margin-bottom:20px;" class="bitRightLeftSiderWidget widget_text site_tooler"><div class="widget-title"><span class="bit_widget_title">博客分类</span></div><div class="bitWidgetFrame paddingleftright0"><div data-bindurl="8304" data-child="" id="listcatecontrols-593a0565e70c2582" type="post" to_qfyuuid="qfy_posts_grid_wrxxp" style="margin-top:0px;margin-bottom:0px;padding-top:0px;padding-bottom:0px;padding-right:0px;padding-left:0px;" m-padding="0px 0px 0px 0px" p-padding="0px 0px 0px 0px" css_animation_delay="0" qfyuuid="0" class="qfy-listcatecontrols  qfy-element  "><div class="list-content ">   <div class="list-content-inner" style="max-width:600px;margin-top:0px;">       <ul class="menu"><li data-id="67" class="menu-item cat-item cat-item-67"><a data-url="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?qfy_preview=1&amp;qfyuuid=qfy_posts_grid_wrxxp&amp;q_term=67&amp;q_type=post" data-bindurl="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?page_id=8304&amp;qfyuuid=qfy_posts_grid_wrxxp&amp;q_term=67&amp;q_type=post" onclick="nav_pagecate(this)" style="cursor:pointer;"><span style=" overflow: hidden;text-overflow: ellipsis;white-space: nowrap;max-width: 100%;font-size:16px ;font-weight:normal ;font-style:normal ;">人生感悟</span></a></li>
<li data-id="50" class="menu-item cat-item cat-item-50"><a data-url="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?qfy_preview=1&amp;qfyuuid=qfy_posts_grid_wrxxp&amp;q_term=50&amp;q_type=post" data-bindurl="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?page_id=8304&amp;qfyuuid=qfy_posts_grid_wrxxp&amp;q_term=50&amp;q_type=post" onclick="nav_pagecate(this)" style="cursor:pointer;"><span style=" overflow: hidden;text-overflow: ellipsis;white-space: nowrap;max-width: 100%;font-size:16px ;font-weight:normal ;font-style:normal ;">旅行日记</span></a></li>
<li data-id="49" class="menu-item cat-item cat-item-49"><a data-url="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?qfy_preview=1&amp;qfyuuid=qfy_posts_grid_wrxxp&amp;q_term=49&amp;q_type=post" data-bindurl="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?page_id=8304&amp;qfyuuid=qfy_posts_grid_wrxxp&amp;q_term=49&amp;q_type=post" onclick="nav_pagecate(this)" style="cursor:pointer;"><span style=" overflow: hidden;text-overflow: ellipsis;white-space: nowrap;max-width: 100%;font-size:16px ;font-weight:normal ;font-style:normal ;">电影推荐</span></a></li>
<li data-id="51" class="menu-item cat-item cat-item-51"><a data-url="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?qfy_preview=1&amp;qfyuuid=qfy_posts_grid_wrxxp&amp;q_term=51&amp;q_type=post" data-bindurl="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?page_id=8304&amp;qfyuuid=qfy_posts_grid_wrxxp&amp;q_term=51&amp;q_type=post" onclick="nav_pagecate(this)" style="cursor:pointer;"><span style=" overflow: hidden;text-overflow: ellipsis;white-space: nowrap;max-width: 100%;font-size:16px ;font-weight:normal ;font-style:normal ;">美食分享</span></a></li>
       </ul>   </div></div><style>#listcatecontrols-593a0565e70c2582 .list-content-inner .bitWidgetFrame{ padding:0 !important;}#listcatecontrols-593a0565e70c2582 .list-content-inner ul{background:transparent;}#listcatecontrols-593a0565e70c2582 .list-content-inner ul.menu li {background:transparent;border-top: 1px solid #fff;margin: 0;padding: 0;}#listcatecontrols-593a0565e70c2582 .list-content-inner ul.menu li a ,#listcatecontrols-593a0565e70c2582 .list-content-inner ul.menu li a:link, #listcatecontrols-593a0565e70c2582 .list-content-inner ul.menu li a:visited{background: transparent;display: inline-block;text-align:left;width:100%;}#listcatecontrols-593a0565e70c2582 .list-content-inner ul.menu li a:hover,#listcatecontrols-593a0565e70c2582 .list-content-inner ul.menu li.current-menu-item > a,#listcatecontrols-593a0565e70c2582 .list-content-inner ul.menu li.current-menu-ancestor > a{background: transparent;}#listcatecontrols-593a0565e70c2582 .list-content-inner ul.menu li a span:before{font-family: 'Glyphicons Halflings';content:'\e072';padding-right:5px;font-size:8px;}#listcatecontrols-593a0565e70c2582 .list-content-inner ul.menu li a span,#listcatecontrols-593a0565e70c2582 .list-content-inner ul.menu li a:link span, #listcatecontrols-593a0565e70c2582 .list-content-inner ul.menu li a:visited span{color: #333 !important;display: inline-block;padding:1px 0;padding-left:10px;}#listcatecontrols-593a0565e70c2582 .list-content-inner ul.sub-menu li > a > span{font-size:16px !important;font-weight:normal !important;font-style:normal !important;}#listcatecontrols-593a0565e70c2582 .list-content-inner ul.menu li.current-menu-item > a:link > span,#listcatecontrols-593a0565e70c2582 .list-content-inner ul.menu li.current-menu-item > a:visited > span,#listcatecontrols-593a0565e70c2582 .list-content-inner ul.menu li.current-menu-item > a > span,#listcatecontrols-593a0565e70c2582 .list-content-inner ul.menu li.current-menu-ancestor > a > span,#listcatecontrols-593a0565e70c2582 .list-content-inner ul.menu li > a:hover > span{color: #acc4ac !important}#listcatecontrols-593a0565e70c2582 .list-content-inner ul.sub-menu{margin-left:0px !important;}#listcatecontrols-593a0565e70c2582 .list-content-inner .menu ul.sub-menu li a span{margin-left:20px;}#listcatecontrols-593a0565e70c2582 .list-content-inner .menu ul.sub-menu  ul.sub-menu li a span{margin-left:40px;}</style></div></div></div><div id="text-33" style="margin-top:0px;margin-bottom:20px;" class="mobileHidden bitRightLeftSiderWidget widget_text site_tooler"><style class="style_text-33">#text-33 .widget-title{padding:0 0 0 10px;height:44px;line-height:44px;background-color:transparent;margin:0px;font-family:华文细黑;font-size:24px;font-weight:normal;font-style:normal;text-decoration:none;color:#444444;border-top:0;border-left:0;border-right:0;border-bottom:0;background-image: url(http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/qfy-content/plugins/bit-plugin/assets/frame/header_bg/1/bg.png);background-repeat: repeat;-webkit-border-top-left-radius: 0;-webkit-border-top-right-radius: 0;-moz-border-radius-topleft: 0;-moz-border-radius-topright: 0;border-top-left-radius: 0;border-top-right-radius: 0;} #text-33 .widget-title{border-top:0;border-left:0;border-right:0;} #text-33 .bitWidgetFrame{border-bottom:0;border-top:0;border-left:0;border-right:0;padding:4px 10px 4px 10px;}#text-33{-webkit-box-shadow:none;box-shadow:none;}#text-33 .bitWidgetFrame{background-color:transparent;background-image:none;background-repeat: repeat;-webkit-border-bottom-left-radius: 0px;border-bottom-left-radius: 0px;-webkit-border-bottom-right-radius: 0px;border-bottom-right-radius: 0px;}body #text-33 .bitWidgetFrame{padding-top:10px !important;padding-bottom:10px !important;}</style>
			<div class="textwidget ckeditorInLine bitWidgetFrame" bitrlt="text" bitkey="text" wid="text-33">
			<div style="text-align: center;">
<hr bitsize="100" class="bitLine" style="border-width: 2px 0px 0px; border-style: solid; border-color: rgb(158, 192, 159); padding: 0px; width: 100%; height: 1px; float: none; margin: 2px 2px 10px 0px;"></div>

<div><span style="font-size:26px;"><span style="font-family: 华文细黑;">关于我</span></span></div>

<div>&nbsp;</div>

<div style="text-align: center;"><img alt="" src="${ctx }/resources/static/index_files/9fbf9f9ededc0601896a2a44f3b506be.jpg" title=""></div>

<div style="text-align: center;">&nbsp;</div>

<div><span style="font-size:14px;">姓名：Marry Miller</span></div>

<div><span style="font-size:14px;">出生日期：2012-08-01</span></div>

<div><span style="font-size:14px;">星座：处女座</span></div>

<div><span style="font-size:14px;">新居城市：沈阳</span></div>

<div><span style="font-size:14px;">职业：作家</span></div>

<div><span style="font-size:14px;">爱好：美食、旅行、电影</span></div>
</div>
			</div><div id="bit_postlist-3" style="margin-top:0px;margin-bottom:20px;" class="bitRightLeftSiderWidget widget_text site_tooler"><div class="bitWidgetFrame "><div style="padding-top:0px;padding-bottom:0px;padding-right:0px;padding-left:0px;" m-padding="0px 0px 0px 0px" p-padding="0px 0px 0px 0px" css_animation_delay="0" qfyuuid="0" class="qfy-icons_list  qfy-element "><ul class="gallery_icons_list " style="text-align:left;"><li style="display:inline-block;"><span data-desc="" data-tj="1" data-ta="2" data-width="150" data-image="" style="margin-right:10px;margin-bottom:px" class="corner qfy-icon qfy-icon_24x24 weixin-icon_24x24" title=""></span></li><li style="display:inline-block;"><span data-desc="" data-tj="1" data-ta="2" data-width="150" data-image="" style="margin-right:10px;margin-bottom:px" class="corner qfy-icon qfy-icon_24x24 weibo-icon_24x24" title=""></span></li><li style="display:inline-block;"><span data-desc="" data-tj="1" data-ta="2" data-width="150" data-image="" style="margin-right:10px;margin-bottom:px" class="corner qfy-icon qfy-icon_24x24 qq-icon_24x24" title=""></span></li><li style="display:inline-block;"><span data-desc="" data-tj="1" data-ta="2" data-width="150" data-image="" style="margin-right:10px;margin-bottom:px" class="corner qfy-icon qfy-icon_24x24 phone2-icon_24x24" title=""></span></li><li style="display:inline-block;"><span data-desc="" data-tj="1" data-ta="2" data-width="150" data-image="" style="margin-right:10px;margin-bottom:px" class="corner qfy-icon qfy-icon_24x24 email-icon_24x24" title=""></span></li><li style="clear:both;"></li></ul></div></div></div><div id="text-32" style="margin-top:0px;margin-bottom:20px;" class="mobileHidden bitRightLeftSiderWidget widget_text site_tooler"><style class="style_text-32">#text-32 .widget-title{padding:0 0 0 10px;height:28px;line-height:28px;background-color:#ffffff;margin:0px;font-family:黑体;font-size:16px;font-weight:normal;font-style:normal;text-decoration:none;color:#ffffff;border-top:0;border-left:0;border-right:0;border-bottom:0;background-image:none;-webkit-border-top-left-radius: 0;-webkit-border-top-right-radius: 0;-moz-border-radius-topleft: 0;-moz-border-radius-topright: 0;border-top-left-radius: 0;border-top-right-radius: 0;} #text-32 .widget-title{border-top:0;border-left:0;border-right:0;} #text-32 .bitWidgetFrame{border-bottom:0;border-top:0;border-left:0;border-right:0;padding:4px 10px 4px 10px;}#text-32{-webkit-box-shadow:none;box-shadow:none;}#text-32 .bitWidgetFrame{background-color:#ffffff;background-image:none;background-repeat: repeat;-webkit-border-bottom-left-radius: 0px;border-bottom-left-radius: 0px;-webkit-border-bottom-right-radius: 0px;border-bottom-right-radius: 0px;}body #text-32 .bitWidgetFrame{padding-top:10px !important;padding-bottom:10px !important;}</style>
			<div class="textwidget ckeditorInLine bitWidgetFrame" bitrlt="text" bitkey="text" wid="text-32">
			<div><span style="color:#333333;"><span style="font-size: 12px;">© 2105 Marry's Blog 版权所有</span></span></div>
</div>
			</div>                            <div class="clear"></div>
							</div>
						</section>
						<section class="content-wrapper nine columns left-sidebar-content">
                             <section data-fixheight="" class="qfy-row-1-593a0565e992090933 section   contentsPadding0  no  section-text-no-shadow section-inner-no-shadow section-normal" id="bit_abn3k" style="margin-bottom:0px;border-radius:0px;color:#555555;">
    	    <div class="section-background-overlay background-overlay grid-overlay-0 " style="background-color: #ffffff;"></div>

    <div class="container">
        <div class="row wpb_row">
            <div data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="" class=" qfy-column-1-593a0565e9c3b388360 qfy-column-inner  vc_span12  text-default small-screen-center fullrow" data-dw="1/1" data-fixheight=""><div style="min-height:346px;;position:relative;;" class="column_inner "><div class=" background-overlay grid-overlay-" style="background-color:transparent;width:100%;"></div><div class="column_containter" style="z-index:3;position:relative;"><style>@media only screen and (max-width: 760px) {.thumbnail_text-593a0565ea18d798 .head{font-size: 16px !important;}.thumbnail_text-593a0565ea18d798 .content{font-size: 16px !important;}}</style>
	<div m-padding="0px 0px 0px 0px" p-padding="0px 0px 0px 0px" css_animation_delay="0" qfyuuid="0" class="qfy-element wpb_gallery wpb_content_element vc_clearfix bottom_nav">
		<div style="padding-bottom:25px;" class="wpb_wrapper "><div class="wpb_gallery_slides wpb_flexslider flexslider_slide flexslider" data-interval="5" style="border-color:transparent;box-shadow:none;border:0px;" data-flex_fx="slide" data-bottom_nav="1" data-direction="0">
			
			<!-- dousnl 自定义样式高度为0  height:301px;-->
			
			<div class="flex-viewport" style="overflow: hidden; position: relative; height: 0px;">
			   <ul class="slides" style="width: 800%; transition-duration: 0s; transform: translate3d(-1570px, 0px, 0px);">
			       <li class="clone" style="width: 785px; float: left; display: block;">
			          <a class=" bitImageAhover  " href="http://www.qifeiye.com/" target="_self">
			             <div class="qfy_image_vc_item" style="position:relative;">
			               <img org-width="1200" org-height="460" data-width="" data-height="" style="width:px;height:px;max-width:100%;" src="${ctx }/resources/static/index_files/9409615c27f3f99ef9fca4e00cc99326.jpg" class="attachment-full" alt="起飞页自助建站平台" title="" description="" data-title="起飞页自助建站平台" src-img="">
			                 <div class="thumbnail_text-593a0565ea18d798 Thumbnail_text " style="overflow:hidden;z-index:1;background-color:rgba(0,0,0,0.8);color: #fff;padding: 10px 10px 10px 10px;"><div class=""><div class="head" style="font-size: 16px;">起飞页自助建站平台</div></div>
			                 </div>
			                 <i></i>
			             </div>
			          </a>
			       </li>
			       <li class="" style="width: 785px; float: left; display: block;">
			         <a class=" bitImageAhover  " href="http://www.qifeiye.com/%E8%AE%BE%E8%AE%A1%E7%BD%91%E9%A1%B5/" target="_self">
			           <div class="qfy_image_vc_item" style="position:relative;">
			              <img org-width="1200" org-height="460" data-width="" data-height="" style="width:px;height:px;max-width:100%;" src="${ctx }/resources/static/index_files/1be10ec69aab7da4316fc8273d8678a9.jpg" class="attachment-full" alt="操作问题可以查看起飞页的教程" title="" description="" data-title="操作问题可以查看起飞页的教程" src-img="">
			                <div class="thumbnail_text-593a0565ea18d798 Thumbnail_text " style="overflow:hidden;z-index:1;background-color:rgba(0,0,0,0.8);color: #fff;padding: 10px 10px 10px 10px;">
			                <div class="">
			                  <div class="head" style="font-size: 16px;">操作问题可以查看起飞页的教程</div>
			                </div>
			                </div>
			                <i></i>
			           </div>
			         </a>
			       </li>
			       <li class="flex-active-slide" style="width: 785px; float: left; display: block;">
			          <a class=" bitImageAhover  " href="http://www.qifeiye.com/" target="_self">
			           <div class="qfy_image_vc_item" style="position:relative;">
			             <img org-width="1200" org-height="460" data-width="" data-height="" style="width:px;height:px;max-width:100%;" src="${ctx }/resources/static/index_files/9409615c27f3f99ef9fca4e00cc99326.jpg" class="attachment-full" alt="起飞页自助建站平台" title="" description="" data-title="起飞页自助建站平台" src-img="">
			               <div class="thumbnail_text-593a0565ea18d798 Thumbnail_text " style="overflow:hidden;z-index:1;background-color:rgba(0,0,0,0.8);color: #fff;padding: 10px 10px 10px 10px;">
			                 <div class="">
			                    <div class="head" style="font-size: 16px;">起飞页自助建站平台</div>
			                 </div>
			               </div>
			                 <i></i>
			            </div>
			          </a>
			       </li>
			       <li class="clone" style="width: 785px; float: left; display: block;">
			        <a class=" bitImageAhover  " href="http://www.qifeiye.com/%E8%AE%BE%E8%AE%A1%E7%BD%91%E9%A1%B5/" target="_self">
			          <div class="qfy_image_vc_item" style="position:relative;">
			            <img org-width="1200" org-height="460" data-width="" data-height="" style="width:px;height:px;max-width:100%;" src="${ctx }/resources/static/index_files/1be10ec69aab7da4316fc8273d8678a9.jpg" class="attachment-full" alt="操作问题可以查看起飞页的教程" title="" description="" data-title="操作问题可以查看起飞页的教程" src-img="">
			              <div class="thumbnail_text-593a0565ea18d798 Thumbnail_text " style="overflow:hidden;z-index:1;background-color:rgba(0,0,0,0.8);color: #fff;padding: 10px 10px 10px 10px;">
			                <div class="">
			                  <div class="head" style="font-size: 16px;">操作问题可以查看起飞页的教程
			                  </div>
			                </div>
			              </div>
			              <i></i>
			           </div>
			        </a>
			       </li>
			   </ul>
			</div>
			<!-- dousnl 自定义样式高度为0 -->
			
			
		<ol class="flex-control-nav flex-control-paging"><li><a class="">1</a></li><li><a class="flex-active">2</a></li></ol></div>
		</div> 
	</div>
	
	</div></div></div><style>.qfy-column-1-593a0565e9c3b388360 > .column_inner:hover{}.qfy-column-1-593a0565e9c3b388360 > .column_inner:hover{}.qfy-column-1-593a0565e9c3b388360 > .column_inner:hover >.background-media{}.qfy-column-1-593a0565e9c3b388360 > .column_inner:hover >.background-overlay{}@media only screen and (min-width: 992px){.qfy-column-1-593a0565e9c3b388360 > .column_inner {padding-left:0px;padding-right:0px;padding-top:0px;padding-bottom:0px;}.wpb_row .vc_span_class.qfy-column-1-593a0565e9c3b388360 {};}@media only screen and (max-width: 992px){.qfy-column-1-593a0565e9c3b388360 > .column_inner{margin:0px auto 0px !important;padding-left:0px;padding-right:0px;padding-top:px;padding-bottom:px;}.display_entire .wpb_row .vc_span_class.qfy-column-1-593a0565e9c3b388360 {}.qfy-column-1-593a0565e9c3b388360 > .column_inner> .background-overlay,.qfy-column-1-593a0565e9c3b388360 > .column_inner> .background-media{width:100% !important;left:0 !important;right:auto !important;}}</style><div data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="" class=" qfy-column-2-593a0565eb1ed66759 qfy-column-inner vc_span_class vc_span6  text-Default small-screen-Default" data-dw="1/2" data-fixheight=""><div style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;border-radius:0px;border-top:0px dotted #9ec09f;border-bottom:0px dotted #9ec09f;border-left:0px dotted #9ec09f;border-right:1px dotted #9ec09f;;position:relative;;" class="column_inner "><div class=" background-overlay grid-overlay-0" style="background-color:transparent;width:100%;"></div><div class="column_containter" style="z-index:3;position:relative;"><div id="" data-loading="" data-loading-w="" data-open="" data-post="post" data-cate="50" m-padding="0px 0px 0px 0px" p-padding="0px 0px 0px 0px" css_animation_delay="0" qfyuuid="0" class="qfy-element  UUID-POSTS-593a05660a714937524 wpb_teaser_grid wpb_content_element  wpb_grid columns_count_1 columns_count_1 wpb_teaser_grid_post " style="">
<style>.UUID-POSTS-593a05660a714937524 li:hover .post-title > i.glyphicon{color:#cccccc !important;}.UUID-POSTS-593a05660a714937524 li:hover .subtitle{color:#cccccc !important;}.UUID-POSTS-593a05660a714937524 li:hover .vc_read_more{}@media only screen and (max-width: 760px) {.UUID-POSTS-593a05660a714937524  .post_blog .blog-media{width:100% !important;}.thumbnail_text-593a05660a6ce775 .head{font-size: 16px !important;}.thumbnail_text-593a05660a6ce775 .content{font-size: 16px !important;}}.UUID-POSTS-593a05660a714937524 .qfy_item_post .price_warp .amount,.UUID-POSTS-593a05660a714937524 .qfy_item_post .price_warp del{color:#cccccc;font-size:12px;}.UUID-POSTS-593a05660a714937524 .qfy_item_post .price_warp ins .amount{color:#cccccc;font-size:12px;}.UUID-POSTS-593a05660a714937524 .qfy_item_post .price_warp {padding-top:0px;padding-bottom:0px;padding-left:0px;padding-right:0px;}.UUID-POSTS-593a05660a714937524 .qfy_item_post:hover .price_warp .amount,.UUID-POSTS-593a05660a714937524 .qfy_item_post:hover .price_warp del{color:#cccccc !important;}.UUID-POSTS-593a05660a714937524 .qfy_item_post:hover .price_warp ins .amount{color:#cccccc !important;}.UUID-POSTS-593a05660a714937524 li:hover *{transition: all .6s ease;}.UUID-POSTS-593a05660a714937524 li *{transition: all .6s ease;}</style>	<style class="style_UUID-POSTS-593a05660a714937524">.UUID-POSTS-593a05660a714937524 .wpb_heading{padding:0 0 0 10px;height:28px;line-height:28px;background-color:transparent;margin:0px;font-family:黑体;font-size:24px;font-weight:normal;font-style:normal;text-decoration:none;color:#9ec09f;border-top:0;border-left:0;border-right:0;border-bottom:0;background-image:none;-webkit-border-top-left-radius: 4px;-webkit-border-top-right-radius: 4px;-moz-border-radius-topleft: 4px;-moz-border-radius-topright: 4px;border-top-left-radius: 4px;border-top-right-radius: 4px;} .UUID-POSTS-593a05660a714937524 .wpb_heading{border-top:0;border-left:0;border-right:0;} .UUID-POSTS-593a05660a714937524  .teaser_grid_container,.UUID-POSTS-593a05660a714937524 .vc-carousel{border-bottom:0;border-top:0;border-left:0;border-right:0;padding:10px 10px 4px 10px;}.UUID-POSTS-593a05660a714937524{-webkit-box-shadow:none;box-shadow:none;}.post-title .glyphicon{  left:0px;  }  #UUID-POSTS-593a05660a714937524 .bitWidgetFrame{background-color:transparent;background-image:none;background-repeat: repeat;-webkit-border-bottom-left-radius: 4px;border-bottom-left-radius: 4px;-webkit-border-bottom-right-radius: 4px;border-bottom-right-radius: 4px;}</style>    <div class="wpb_wrapper">
        <h2 class="wpb_heading wpb_teaser_grid_heading vc_span12">旅行日记 <a class="morelink" style="float:right;margin-right:10px;font-size:12px;color:#ffffff" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?page_id=5967&amp;categories=50">更多新闻</a></h2>        <div class="teaser_grid_container noanimale" style="background-repeat: repeat;;clear:both;" data-type="post" data-cate="50" data-pcate="">
                        <ul style="min-height:60px;" class="wpb_thumbnails wpb_thumbnails-fluid vc_clearfix post_simple_list" data-layout-mode="fitRows">
                                                                                <li data-postid="10219" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-50" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10219" class="bitImageAhover   link_title" title="独自旅行的10个建议">独自旅行的10个建议</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-02 15:00:05" class="post_date post_date_text">2016-02-02&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                                <li data-postid="10213" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-50" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10213" class="bitImageAhover   link_title" title="在自己的城市旅行">在自己的城市旅行</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-02 14:58:19" class="post_date post_date_text">2016-02-02&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                                <li data-postid="10157" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-50" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10157" class="bitImageAhover   link_title" title="行走在现实里的文艺青年">行走在现实里的文艺青年</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-02 14:32:10" class="post_date post_date_text">2016-02-02&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                                <li data-postid="10150" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-50" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10150" class="bitImageAhover   link_title" title="让红包安全的飞吧">让红包安全的飞吧</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-02 14:06:55" class="post_date post_date_text">2016-02-02&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                                <li data-postid="9085" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-50" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=9085" class="bitImageAhover   link_title" title="这里是文章的标题，您可以在页面设置中更改此标题">这里是文章的标题，您可以在页面...</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2015-12-02 19:00:28" class="post_date post_date_text">2015-12-02&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                				
            </ul>
        </div>
    </div>     <div class="clear"></div>
    
        

</div> 
<div id="" data-loading="" data-loading-w="" data-open="" data-post="post" data-cate="67" m-padding="0px 0px 0px 0px" p-padding="0px 0px 0px 0px" css_animation_delay="0" qfyuuid="0" class="qfy-element  UUID-POSTS-593a05661574a247669 wpb_teaser_grid wpb_content_element  wpb_grid columns_count_1 columns_count_1 wpb_teaser_grid_post " style="margin-top:20px;">
<style>.UUID-POSTS-593a05661574a247669 li:hover .post-title > i.glyphicon{color:#cccccc !important;}.UUID-POSTS-593a05661574a247669 li:hover .subtitle{color:#cccccc !important;}.UUID-POSTS-593a05661574a247669 li:hover .vc_read_more{}@media only screen and (max-width: 760px) {.UUID-POSTS-593a05661574a247669  .post_blog .blog-media{width:100% !important;}.thumbnail_text-593a056615702397 .head{font-size: 16px !important;}.thumbnail_text-593a056615702397 .content{font-size: 16px !important;}}.UUID-POSTS-593a05661574a247669 .qfy_item_post .price_warp .amount,.UUID-POSTS-593a05661574a247669 .qfy_item_post .price_warp del{color:#cccccc;font-size:12px;}.UUID-POSTS-593a05661574a247669 .qfy_item_post .price_warp ins .amount{color:#cccccc;font-size:12px;}.UUID-POSTS-593a05661574a247669 .qfy_item_post .price_warp {padding-top:0px;padding-bottom:0px;padding-left:0px;padding-right:0px;}.UUID-POSTS-593a05661574a247669 .qfy_item_post:hover .price_warp .amount,.UUID-POSTS-593a05661574a247669 .qfy_item_post:hover .price_warp del{color:#cccccc !important;}.UUID-POSTS-593a05661574a247669 .qfy_item_post:hover .price_warp ins .amount{color:#cccccc !important;}.UUID-POSTS-593a05661574a247669 li:hover *{transition: all .6s ease;}.UUID-POSTS-593a05661574a247669 li *{transition: all .6s ease;}</style>	<style class="style_UUID-POSTS-593a05661574a247669">.UUID-POSTS-593a05661574a247669 .wpb_heading{padding:0 0 0 10px;height:50px;line-height:50px;background-color:transparent;margin:0px;font-family:黑体;font-size:24px;font-weight:normal;font-style:normal;text-decoration:none;color:#9ec09f;border-top:1px dotted #9ec09f;border-bottom:0px dotted #9ec09f;border-left:0px dotted #9ec09f;border-right:0px dotted #9ec09f;background-image:none;-webkit-border-top-left-radius: 0;-webkit-border-top-right-radius: 0;-moz-border-radius-topleft: 0;-moz-border-radius-topright: 0;border-top-left-radius: 0;border-top-right-radius: 0;} .UUID-POSTS-593a05661574a247669  .teaser_grid_container,.UUID-POSTS-593a05661574a247669 .vc-carousel{border-top:0px solid #bababa;border-bottom:0px solid #bababa;border-left:0px solid #bababa;border-right:0px solid #bababa;padding:10px 10px 4px 10px;-webkit-border-bottom-left-radius: 0;-webkit-border-bottom-right-radius: 0;-moz-border-radius-bottomleft: 0;-moz-border-radius-bottomright: 0;border-bottom-left-radius: 0;border-bottom-right-radius: 0;}.UUID-POSTS-593a05661574a247669{-webkit-box-shadow:none;box-shadow:none;}.post-title .glyphicon{  left:0px;  }  #UUID-POSTS-593a05661574a247669 .bitWidgetFrame{background-color:transparent;background-image:none;background-repeat: repeat;-webkit-border-bottom-left-radius: 0px;border-bottom-left-radius: 0px;-webkit-border-bottom-right-radius: 0px;border-bottom-right-radius: 0px;}</style>    <div class="wpb_wrapper">
        <h2 class="wpb_heading wpb_teaser_grid_heading vc_span12">人生感悟 <a class="morelink" style="float:right;margin-right:10px;font-size:12px;color:#ffffff" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?page_id=5967&amp;categories=67">更多新闻</a></h2>        <div class="teaser_grid_container noanimale" style="background-repeat: repeat;;clear:both;" data-type="post" data-cate="67" data-pcate="">
                        <ul style="min-height:60px;" class="wpb_thumbnails wpb_thumbnails-fluid vc_clearfix post_simple_list" data-layout-mode="fitRows">
                                                                                <li data-postid="10502" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-67" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10502" class="bitImageAhover   link_title" title="世界这么大是否应该出去走一走">世界这么大是否应该出去走一走</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-03 13:59:31" class="post_date post_date_text">2016-02-03&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                                <li data-postid="10500" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-67" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10500" class="bitImageAhover   link_title" title="感恩父母">感恩父母</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-03 13:58:16" class="post_date post_date_text">2016-02-03&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                                <li data-postid="10225" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-67" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10225" class="bitImageAhover   link_title" title="让自己入戏戏如人生">让自己入戏戏如人生</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-02 15:08:15" class="post_date post_date_text">2016-02-02&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                                <li data-postid="10217" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-67" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10217" class="bitImageAhover   link_title" title="生活如同一番风景">生活如同一番风景</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-02 14:58:51" class="post_date post_date_text">2016-02-02&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                                <li data-postid="10159" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-67" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10159" class="bitImageAhover   link_title" title="做人与做事">做人与做事</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-02 14:33:02" class="post_date post_date_text">2016-02-02&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                				
            </ul>
        </div>
    </div>     <div class="clear"></div>
    
        

</div> 
</div></div></div><style>.qfy-column-2-593a0565eb1ed66759 > .column_inner:hover{}.qfy-column-2-593a0565eb1ed66759 > .column_inner:hover{}.qfy-column-2-593a0565eb1ed66759 > .column_inner:hover >.background-media{}.qfy-column-2-593a0565eb1ed66759 > .column_inner:hover >.background-overlay{}@media only screen and (min-width: 992px){.qfy-column-2-593a0565eb1ed66759 > .column_inner {padding-left:0px;padding-right:0px;padding-top:0px;padding-bottom:0px;}.wpb_row .vc_span_class.qfy-column-2-593a0565eb1ed66759 {};}@media only screen and (max-width: 992px){.qfy-column-2-593a0565eb1ed66759 > .column_inner{margin:0px auto 0px !important;padding-left:0px;padding-right:0px;padding-top:0px;padding-bottom:0px;}.display_entire .wpb_row .vc_span_class.qfy-column-2-593a0565eb1ed66759 {}.qfy-column-2-593a0565eb1ed66759 > .column_inner> .background-overlay,.qfy-column-2-593a0565eb1ed66759 > .column_inner> .background-media{width:100% !important;left:0 !important;right:auto !important;}}</style><div data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="" class=" qfy-column-3-593a05661658082006 qfy-column-inner vc_span_class vc_span6  text-default small-screen-default" data-dw="1/2" data-fixheight=""><div style=";position:relative;;" class="column_inner "><div class=" background-overlay grid-overlay-" style="background-color:transparent;width:100%;"></div><div class="column_containter" style="z-index:3;position:relative;"><div id="" data-loading="" data-loading-w="" data-open="" data-post="post" data-cate="51" m-padding="0px 0px 0px 0px" p-padding="0px 0px 0px 0px" css_animation_delay="0" qfyuuid="0" class="qfy-element  UUID-POSTS-593a056620cd2117041 wpb_teaser_grid wpb_content_element  wpb_grid columns_count_1 columns_count_1 wpb_teaser_grid_post " style="">
<style>.UUID-POSTS-593a056620cd2117041 li:hover .post-title > i.glyphicon{color:#cccccc !important;}.UUID-POSTS-593a056620cd2117041 li:hover .subtitle{color:#cccccc !important;}.UUID-POSTS-593a056620cd2117041 li:hover .vc_read_more{}@media only screen and (max-width: 760px) {.UUID-POSTS-593a056620cd2117041  .post_blog .blog-media{width:100% !important;}.thumbnail_text-593a056620c8b490 .head{font-size: 16px !important;}.thumbnail_text-593a056620c8b490 .content{font-size: 16px !important;}}.UUID-POSTS-593a056620cd2117041 .qfy_item_post .price_warp .amount,.UUID-POSTS-593a056620cd2117041 .qfy_item_post .price_warp del{color:#cccccc;font-size:12px;}.UUID-POSTS-593a056620cd2117041 .qfy_item_post .price_warp ins .amount{color:#cccccc;font-size:12px;}.UUID-POSTS-593a056620cd2117041 .qfy_item_post .price_warp {padding-top:0px;padding-bottom:0px;padding-left:0px;padding-right:0px;}.UUID-POSTS-593a056620cd2117041 .qfy_item_post:hover .price_warp .amount,.UUID-POSTS-593a056620cd2117041 .qfy_item_post:hover .price_warp del{color:#cccccc !important;}.UUID-POSTS-593a056620cd2117041 .qfy_item_post:hover .price_warp ins .amount{color:#cccccc !important;}.UUID-POSTS-593a056620cd2117041 li:hover *{transition: all .6s ease;}.UUID-POSTS-593a056620cd2117041 li *{transition: all .6s ease;}</style>	<style class="style_UUID-POSTS-593a056620cd2117041">.UUID-POSTS-593a056620cd2117041 .wpb_heading{padding:0 0 0 10px;height:28px;line-height:28px;background-color:transparent;margin:0px;font-family:黑体;font-size:24px;font-weight:normal;font-style:normal;text-decoration:none;color:#9ec09f;border-top:0;border-left:0;border-right:0;border-bottom:0;background-image:none;-webkit-border-top-left-radius: 4px;-webkit-border-top-right-radius: 4px;-moz-border-radius-topleft: 4px;-moz-border-radius-topright: 4px;border-top-left-radius: 4px;border-top-right-radius: 4px;} .UUID-POSTS-593a056620cd2117041 .wpb_heading{border-top:0;border-left:0;border-right:0;} .UUID-POSTS-593a056620cd2117041  .teaser_grid_container,.UUID-POSTS-593a056620cd2117041 .vc-carousel{border-bottom:0;border-top:0;border-left:0;border-right:0;padding:10px 10px 4px 10px;}.UUID-POSTS-593a056620cd2117041{-webkit-box-shadow:none;box-shadow:none;}.post-title .glyphicon{  left:0px;  }  #UUID-POSTS-593a056620cd2117041 .bitWidgetFrame{background-color:transparent;background-image:none;background-repeat: repeat;-webkit-border-bottom-left-radius: 4px;border-bottom-left-radius: 4px;-webkit-border-bottom-right-radius: 4px;border-bottom-right-radius: 4px;}</style>    <div class="wpb_wrapper">
        <h2 class="wpb_heading wpb_teaser_grid_heading vc_span12">美食分享 <a class="morelink" style="float:right;margin-right:10px;font-size:12px;color:#ffffff" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?page_id=5967&amp;categories=51">更多新闻</a></h2>        <div class="teaser_grid_container noanimale" style="background-repeat: repeat;;clear:both;" data-type="post" data-cate="51" data-pcate="">
                        <ul style="min-height:60px;" class="wpb_thumbnails wpb_thumbnails-fluid vc_clearfix post_simple_list" data-layout-mode="fitRows">
                                                                                <li data-postid="10498" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-51" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10498" class="bitImageAhover   link_title" title="舌尖上的美味">舌尖上的美味</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-03 13:56:02" class="post_date post_date_text">2016-02-03&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                                <li data-postid="10496" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-51" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10496" class="bitImageAhover   link_title" title="陕西的特色美食">陕西的特色美食</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-03 13:55:37" class="post_date post_date_text">2016-02-03&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                                <li data-postid="10222" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-51" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10222" class="bitImageAhover   link_title" title="火车上的特色美食">火车上的特色美食</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-02 15:03:45" class="post_date post_date_text">2016-02-02&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                                <li data-postid="10166" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-51" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10166" class="bitImageAhover   link_title" title="那些与美食有关的事儿">那些与美食有关的事儿</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-02 14:39:02" class="post_date post_date_text">2016-02-02&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                                <li data-postid="10161" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-51" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10161" class="bitImageAhover   link_title" title="寺庙的美食">寺庙的美食</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-02 14:36:12" class="post_date post_date_text">2016-02-02&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                				
            </ul>
        </div>
    </div>     <div class="clear"></div>
    
        

</div> 
<div id="" data-loading="" data-loading-w="" data-open="" data-post="post" data-cate="49" m-padding="0px 0px 0px 0px" p-padding="0px 0px 0px 0px" css_animation_delay="0" qfyuuid="0" class="qfy-element  UUID-POSTS-593a05662b1a589030 wpb_teaser_grid wpb_content_element  wpb_grid columns_count_1 columns_count_1 wpb_teaser_grid_post " style="margin-top:20px;">
<style>.UUID-POSTS-593a05662b1a589030 li:hover .post-title > i.glyphicon{color:#cccccc !important;}.UUID-POSTS-593a05662b1a589030 li:hover .subtitle{color:#cccccc !important;}.UUID-POSTS-593a05662b1a589030 li:hover .vc_read_more{}@media only screen and (max-width: 760px) {.UUID-POSTS-593a05662b1a589030  .post_blog .blog-media{width:100% !important;}.thumbnail_text-593a05662b15e897 .head{font-size: 16px !important;}.thumbnail_text-593a05662b15e897 .content{font-size: 16px !important;}}.UUID-POSTS-593a05662b1a589030 .qfy_item_post .price_warp .amount,.UUID-POSTS-593a05662b1a589030 .qfy_item_post .price_warp del{color:#cccccc;font-size:12px;}.UUID-POSTS-593a05662b1a589030 .qfy_item_post .price_warp ins .amount{color:#cccccc;font-size:12px;}.UUID-POSTS-593a05662b1a589030 .qfy_item_post .price_warp {padding-top:0px;padding-bottom:0px;padding-left:0px;padding-right:0px;}.UUID-POSTS-593a05662b1a589030 .qfy_item_post:hover .price_warp .amount,.UUID-POSTS-593a05662b1a589030 .qfy_item_post:hover .price_warp del{color:#cccccc !important;}.UUID-POSTS-593a05662b1a589030 .qfy_item_post:hover .price_warp ins .amount{color:#cccccc !important;}.UUID-POSTS-593a05662b1a589030 li:hover *{transition: all .6s ease;}.UUID-POSTS-593a05662b1a589030 li *{transition: all .6s ease;}</style>	<style class="style_UUID-POSTS-593a05662b1a589030">.UUID-POSTS-593a05662b1a589030 .wpb_heading{padding:0 0 0 10px;height:50px;line-height:50px;background-color:transparent;margin:0px;font-family:黑体;font-size:24px;font-weight:normal;font-style:normal;text-decoration:none;color:#9ec09f;border-top:1px dotted #9ec09f;border-bottom:0px dotted #9ec09f;border-left:0px dotted #9ec09f;border-right:0px dotted #9ec09f;background-image:none;-webkit-border-top-left-radius: 0;-webkit-border-top-right-radius: 0;-moz-border-radius-topleft: 0;-moz-border-radius-topright: 0;border-top-left-radius: 0;border-top-right-radius: 0;} .UUID-POSTS-593a05662b1a589030  .teaser_grid_container,.UUID-POSTS-593a05662b1a589030 .vc-carousel{border-top:0px solid #bababa;border-bottom:0px solid #bababa;border-left:0px solid #bababa;border-right:0px solid #bababa;padding:10px 10px 4px 10px;-webkit-border-bottom-left-radius: 0;-webkit-border-bottom-right-radius: 0;-moz-border-radius-bottomleft: 0;-moz-border-radius-bottomright: 0;border-bottom-left-radius: 0;border-bottom-right-radius: 0;}.UUID-POSTS-593a05662b1a589030{-webkit-box-shadow:none;box-shadow:none;}.post-title .glyphicon{  left:0px;  }  #UUID-POSTS-593a05662b1a589030 .bitWidgetFrame{background-color:transparent;background-image:none;background-repeat: repeat;-webkit-border-bottom-left-radius: 0px;border-bottom-left-radius: 0px;-webkit-border-bottom-right-radius: 0px;border-bottom-right-radius: 0px;}</style>    <div class="wpb_wrapper">
        <h2 class="wpb_heading wpb_teaser_grid_heading vc_span12">电影推荐 <a class="morelink" style="float:right;margin-right:10px;font-size:12px;color:#ffffff" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?page_id=5967&amp;categories=49">更多新闻</a></h2>        <div class="teaser_grid_container noanimale" style="background-repeat: repeat;;clear:both;" data-type="post" data-cate="49" data-pcate="">
                        <ul style="min-height:60px;" class="wpb_thumbnails wpb_thumbnails-fluid vc_clearfix post_simple_list" data-layout-mode="fitRows">
                                                                                <li data-postid="10504" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-49" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10504" class="bitImageAhover   link_title" title="一部好电影《解救吾先生》">一部好电影《解救吾先生》</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-03 14:00:32" class="post_date post_date_text">2016-02-03&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                                <li data-postid="10234" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-49" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10234" class="bitImageAhover   link_title" title="推荐一部相当好看的电影《树先生》">推荐一部相当好看的电影《树先生...</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-02 15:15:19" class="post_date post_date_text">2016-02-02&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                                <li data-postid="10232" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-49" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10232" class="bitImageAhover   link_title" title="全伪纪实艺术电影《当事人》">全伪纪实艺术电影《当事人》</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-02 15:14:23" class="post_date post_date_text">2016-02-02&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                                <li data-postid="10228" data-animaleinbegin="bottom-in-view" data-animalename="qfyfadeInUp" data-delay="0" class=" isotope-item qfy_item_post vc_span12 grid-cat-49" style="max-width:99.8%;margin-bottom:-10px;padding-bottom:-10px;">
									<div class="itembody" style="">
	                    	                        	

		
		<div class="post-title" style="font-weight:normal;color:#444444;line-height:14px; vertical-align: top;  ">

			<i class="glyphicon glyphicon-play" style="color:#666666;font-size:9px;top:0px;margin-right:4px"></i>
			
	
	<a data-title="true" style="color:#444444;font-size:14px;line-height:20px" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?p=10228" class="bitImageAhover   link_title" title="电影《致我们终将失去的青春》在全国院线上映">电影《致我们终将失去的青春》在...</a>

	</div>
	

<span style="color:#686868;font-size:14px;float:right;margin-right: 10px;" data-date="2016-02-02 15:10:32" class="post_date post_date_text">2016-02-02&nbsp;</span><span style="clear:both"></span>							                    	                        	

							                    					</div>
				                </li> <div class="wf-mobile-hidden" style="clear:both"></div>                                				
            </ul>
        </div>
    </div>     <div class="clear"></div>
    
        

</div> 
</div></div></div><style>.qfy-column-3-593a05661658082006 > .column_inner:hover{}.qfy-column-3-593a05661658082006 > .column_inner:hover{}.qfy-column-3-593a05661658082006 > .column_inner:hover >.background-media{}.qfy-column-3-593a05661658082006 > .column_inner:hover >.background-overlay{}@media only screen and (min-width: 992px){.qfy-column-3-593a05661658082006 > .column_inner {padding-left:0px;padding-right:0px;padding-top:0px;padding-bottom:0px;}.wpb_row .vc_span_class.qfy-column-3-593a05661658082006 {};}@media only screen and (max-width: 992px){.qfy-column-3-593a05661658082006 > .column_inner{margin:0px auto 0px !important;padding-left:0px;padding-right:0px;padding-top:px;padding-bottom:px;}.display_entire .wpb_row .vc_span_class.qfy-column-3-593a05661658082006 {}.qfy-column-3-593a05661658082006 > .column_inner> .background-overlay,.qfy-column-3-593a05661658082006 > .column_inner> .background-media{width:100% !important;left:0 !important;right:auto !important;}}</style><div class="wf-mobile-hidden" style="clear:both;"></div>        </div>
    </div>
	<style>
	@media only screen and (min-width: 992px){
		section.section.qfy-row-1-593a0565e992090933{padding-left:20px;padding-right:20px;padding-top:20px;padding-bottom:40px;margin-top:20px;}}
		
	   	
	   @media only screen and (max-width: 992px){
		.bit-html section.section.qfy-row-1-593a0565e992090933{padding-left:15px;padding-right:15px;padding-top:20px;padding-bottom:40px;margin-top:0px;}}
	</style>
</section>                        </section>

						<div class="clear"></div>
					</div>
				<div class="clear"></div>

			</div>
			<!-- page-outer-wrapper -->

		</div>
		<!-- END .row-wrapper -->

		<div class="clear"></div>

     </div>
<!-- END .main-outer-wrapper  -->





			
			</div>
		
    			</div><!-- .wf-container -->
		</div><!-- .wf-wrap -->
	</div><!-- #main -->
	<footer id="footer" class="footer">
	<div class="wf-wrap">
		<div class="wf-container wpb_row footer1" bitdataaction="site_widget_container" bitdatamarker="sidebar_2">
					</div><!-- .wf-container -->
							</div><!-- .wf-wrap -->
	<!--  ************begin************* -->
<style type="text/css" id="static-stylesheet-footer">
#footer.footer .footer1 .widget{width: 32.3%;}#footer.footer .footer2 .widget{width: 99%;}#footer.footer .footer2 .widget.simplepage{width: 100%;}#footer.footer .footer3 .widget{width: 99%;}#footer.footer .footer3 .widget.simplepage{width: 100%;}.bit_main_content{margin-top:0px;margin-bottom:0px}
</style>
<!--  ************end************* -->
</footer>
			
	
	

<a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?qfy_preview=1#" class="scroll-top off"></a>

</div><!-- #page -->

<div style="display:none;"><!-- JiaThis Button BEGIN -->
<script type="text/javascript" src="${ctx }/resources/static/index_files/jiathis_r.js" charset="utf-8"></script><script src="${ctx }/resources/static/index_files/ckepop.js" charset="utf-8"></script><script src="${ctx }/resources/static/index_files/ckecenterpop.js" charset="utf-8"></script><script type="text/javascript" src="${ctx }/resources/static/index_files/plugin.client.js" charset="utf-8"></script>
<!-- JiaThis Button END --></div>


<div class="sogoutip" style="z-index: 2147483645; visibility: hidden; display: none;"></div><div class="sogoubottom" id="sougou_bottom" style="display: none;"></div><div id="ext_stophi" style="z-index: 2147483647;"><div class="extnoticebg"></div><div class="extnotice"><h2>关闭提示 <a href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?qfy_preview=1#" title="关闭提示" id="closenotice" class="closenotice">关闭</a></h2><p id="sogouconfirmtxt"></p>  <a id="sogouconfirm" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?qfy_preview=1#" class="extconfirm">确 认</a> <a id="sogoucancel" href="http://w-17239-77971-17533.13919614996.sites.cnfree01.qifeiye.com/?qfy_preview=1#" class="extconfirm">取 消</a></div></div><div id="ext_overlay" class="ext_overlayBG" style="display: none; z-index: 2147483646;"></div><iframe class="sogou_sugg_feedbackquan" frameborder="0" scrolling="no" src="${ctx }/resources/static/index_files/yun6.html" style="border: none; display: none; height: 84px; width: 100%; z-index: 2147483645; background: transparent;"></iframe></body></html>