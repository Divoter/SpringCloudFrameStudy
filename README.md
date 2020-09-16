# SpringCloudFrameStudy
my first project for spring cloud frame.

###**module description:**
+ **eureka** 
>Registration Service Center
+ **order-server**
>order service for produce
>>provide some service 
>>>e.g. create(search/detele/update) order/order detail;
+ **constant-common**
>some common patrs
>>e.g.project constant /return code ...
+ ~~**mybatis-common:**~~
>~~mybatis mapper plugin~~
>>~~e.g. Mapper-Plugin/model/Service-Plugin/serviceException ...~~

>mybatis-common has some problems,it will be fixed in alater version.
+ **example**
>An example Project for mybatis mapper plugin.
>For rapid construction of database related microservices
+ **product-server**
>product service for produce
>>provide some service 
>>>e.g. create(search/detele/update) product info/master;
+ **zuul-filter**
>provid gateway service.At present, only forwarding function is provided, 
>and filtering related functions will be implemented later
+ **config-server**
>configuration center for manage profiles
