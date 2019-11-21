## community
实现调用GitHub接口，使用GitHub用户登录  
## 1、创建GitHub OAuth Apps
首先，点击GitHub头像，选择Settings->Developer settings->OAuth Apps  
点击New OAuth App  
Homepage URL和Authorization callback URL：http://localhost:8887/callback
## 2、修改代码
1、进入index.html修改地址https://github.com/login/oauth/authorize?client_id=201512b6aa723b65ffbe&redirect_uri=http://localhost:8887/callback&scope=user&state=1  
更改client_id  （使用自己OAuth的client_id）  
2、进入application.properties更改github.Client_id和github.Client_secret
