# Rxjava_MVP_Retrofit
##一个小demo，RxJava MVP Retrofit 混合
# HTTP 协议

##请求
	- version
		- http/1
		- http/1.1
		- http/2
###- URL
	
		- protocol                   http
		- 分隔符 ://                 ://
		- domain                     apen.vpaidian.com
		- path                       /username/
		- query                      ?_n=star & _otype=list
		- 锚记                       #xxx

###- METHOD
	
		POST
	
		- POST 可以有body
		- GET 不可以有body
		- DELETE 不可以有body
		- PUT 可以有body
		- ... 
		
 ###- HEADER
		请求头
		键值对形式, 键可以重复，所以是  Map<String, ArrayList<String>>
		
			Content-Type: application/x-www-form-urlencoded
			Content-Length: 19
			_v: 1.0
			_r: android
			_username: 1523956
			_password: 000000
		
		
  ###- BODY
		理论上是不限制任何内容的，但是主流有以下几种，一般body的内容会在header中的content-type进行描述
		
		- form-data
			表单, 最强大的规约，不细说了，有点深, retrofit中为 Multipart
		- x-www-form-urlencoded
			我理解为简单表单，只能包含字符串键值对， retrofit中为 FormUrlEncoded
		- raw
			二进制(文件)
		- binary
			二进制(文件)

#响应

	/*
	服务器可以拿的参数(不限于以下几种):
		URL.path,
		URL.query,
		URL.锚记
		Header.XXX
		Body.N种类型
	 */


--> POST http://api.vpaidian.com/?_n=unit.star&_otype=list http/1.1
Content-Type: application/x-www-form-urlencoded
Content-Length: 19
_v: 1.0
_r: android
_username: 1523698
_password: 000000
pageid=1&pagesiz=20
--> END POST (19-byte body)
<-- 200 OK http://apen.vpaidian.com/?_n=star&_otype=list (20ms)
Date: Thu, 22 Jun 2017 11:29:13 GMT
Server: Apache/2.4.10 (Win32) OpenSSL/0.9.8zb mod_fcgid/2.3.9
X-Powered-By: PHP/5.4.33
Keep-Alive: timeout=5, max=100
Connection: Keep-Alive
Transfer-Encoding: chunked
Content-Type: application/json; charset=utf-8
{"rs":false,"mess":{"data":{"errorInfo":["<div>\u4f60\u9700\u8981\u63d0\u4f9bAPI\u7248\u672c\u53c2\u6570(_v)!<\/div>"]}}}
<-- END HTTP (121-byte body)
