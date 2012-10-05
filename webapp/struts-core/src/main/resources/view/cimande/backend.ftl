<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title><@s.text name="frontend.title" /></title>
		
		<script type="text/javascript" src="<@s.url value="/scripts/jquery/jquery.min.js" />"></script>
		<script type="text/javascript" src="<@s.url value="/scripts/jquery/jquery.address.min.js" />"></script>
		<script type="text/javascript" src="<@s.url value="/scripts/map/leaflet/leaflet.js" />"></script>
		<script type="text/javascript" src="<@s.url value="/scripts/cimande-popup.js" />"></script>
		<script type="text/javascript" src="<@s.url value="/scripts/inca.ext.js" />"></script>
		
		<link rel="stylesheet" type="text/css" href="<@s.url value="/styles/map/leaflet/leaflet.css" />" />
		
		<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
		<!--[if lt IE 9]>
		<link rel="stylesheet" type="text/css" href="<@s.url value="/styles/map/leaflet/leaflet.ie.css" />" />
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<@sb.head compressed="true" />
		<@s.url value="" forceAddSchemeHostAndPort="true" var="ctx" />
		<style type="text/css">
			body {
				/* padding-top: 80px; */
			}
			button.btn, input.btn { min-width: 100px; }
			.navbar-fixed-top .brand { 
				color: #FFF; 
				float: left; 
				margin-right: 10px; 
				text-shadow: 0 px 0 rgba(100,100,100,.1), 0 0 30px rgba(100,100,100,.125); 
			}
			header { margin-bottom: 18px; border-bottom: 2px solid #777; }
			header h1 { font-size: 150%; margin-bottom: 5px; }
			.required{
				color: red;
			}
		</style>
	</head>
	<body>
		<#include "/view/cimande/navbar.ftl" />
		<div class="modal hide fade in" id="popup-dialog">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3 id="popup-header"></h3>
			</div>
			<div class="modal-body" style="height: 400px;">
				<form method="get" class="form-inline" id="popup-search" style="width: 100%">
					<div class="input-append" style="width: 100%">
						<input type="text" name="q" value="" placeholder="Search..." style="width: 80%;">
						<button value="Search" class="btn" style="min-width: 0; width: 15%;">
							&nbsp;<i class="icon-search"></i>&nbsp;
						</button>
					</div>
				</form>
				<div id="popup-data"></div>
			</div>
		</div>
		<#--
		<input type="text" title="Add Module Function" class="span3 openpopup" id="module-id" object-name="moduleFunctions|name" field-target="module-id|module-name" href="<@s.url value="http://localhost:8080/backend/module_function" />" />
		-->
		<div class="container content" id="content">
			<#if !request.servletPath?ends_with("/backend")>
			<h2>
				<@s.text name="module.header.title" />
				<small><@s.text name="module.header.description" /></small>
			</h2>
			<hr />
			</#if>
			${body}
		</div>
		<@s.url id="localeEN" namespace="/" action="home" >
   			<@s.param name="request_locale" >en</@s.param>
		</@s.url>
		<@s.url id="localezhID" namespace="/" action="home" >
   			<@s.param name="request_locale" >in_ID</@s.param>
		</@s.url>
		<footer class="footer">
			<div class="container">
				<div class="span3"><@s.text name="frontend.footer.text" /></div>
				<div class="span8" style="text-align: right;">
					<a href="#">About SUMS</a> &nbsp; 
					<a href="/term">Term & Conditions</a> &nbsp; 
					<a href="#">Licencing</a> &nbsp; 
					<a href="#">Privasi</a> &nbsp; 
					<a href="/about"><@s.text name="footer.about.us.text" /></a> &nbsp; 
					<a href="#">Feedback</a> &nbsp; 
					<a href="${localezhID}">English</a> &nbsp; 
					<a href="${localeEN}">Indonesia</a>
				</div>
				</div>
			</div>
		</footer>
		<script>
			$(function() {
				$('#login-anchor').click(function(e) {
					e.preventDefault();
					$('#login-dialog').modal('show');
				});
			});
			
			$(document).ready(function(){
			  	$("span.required").each(function() {
	  				var parent = $(this).parent();
	  				$(this).prependTo(parent);
	  			});
			});
		</script>
	</body>
</html>