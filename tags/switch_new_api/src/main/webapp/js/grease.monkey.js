// ==UserScript==
// @name           xpath
// @namespace      test
// @include        *
// ==/UserScript==

window.addEventListener('load',function() {
  if(window!= window.top) {
  	return;
  }
  var sf=document.createElement('script');
  sf.setAttribute("type","text/javascript");
  sf.setAttribute("src", "http://localhost:8080/crawler/js/crawler_loader.js");  
  document.getElementsByTagName("head")[0].appendChild(sf);  
},true);
