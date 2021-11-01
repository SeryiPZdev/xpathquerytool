XPath Query Tool - Program to query over XML files with XPath
---------------------------------------------------------------
This program is designed to be able to query an XML with XPath. The return type must be indicated: Boolean, Number, String, Node, and Nodeset. In the case of Nodeset, a checkbox appears that allows you to see distinct values.

You can get the executable you need from: https://github.com/SeryiPZdev/xpathquerytool/tree/main/xpathquerytool-trunk/dist

There is a version for Windows x86, another for Windows x64 and the executable .jar for any other platform.

Examples of use:

You can get the example.xml from: https://github.com/SeryiPZdev/xpathquerytool/blob/main/xpathquerytool-trunk/resources/example.xml
````
/employees/employee/fname/text()  (return type = NODESET)
````
![1](https://user-images.githubusercontent.com/93538515/139731873-6035ce88-9e41-45b4-ab03-1f49077ffcc2.jpg)
````
//employees (return type = STRING)
````
![2](https://user-images.githubusercontent.com/93538515/139731894-910766e9-da04-4f08-af7b-3ac23a96e2c0.jpg)
````
//age/text()  (return type = NODESET)
````
![3](https://user-images.githubusercontent.com/93538515/139731907-d74379c6-1b02-4a49-8e26-b72502f41634.jpg)
````
count(//employee) (return type = NUMBER)
````
![4](https://user-images.githubusercontent.com/93538515/139731923-ee547239-adf8-4e76-9f02-d72c44da726f.jpg)
````
/employees/employee[department="Sales"]  (return type = BOOLEAN)
````
![5](https://user-images.githubusercontent.com/93538515/139731931-ee7e7fe9-61a8-4d40-85e2-a4aa2d442a2e.jpg)
````
/employees/employee/department/text()  (return type = NODESET)
````
![6](https://user-images.githubusercontent.com/93538515/139731950-7ea4032e-d768-4dfe-90f1-8af237b0bc22.jpg)
````
/employees/employee/department/text()  (return type = NODESET) and Checkbox "distinct values" checked
````
![7](https://user-images.githubusercontent.com/93538515/139731957-263d8a24-3fc2-4d3a-b701-2f871b19f482.jpg)
