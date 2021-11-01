XPath Query Tool - Program to query over XML files with XPath
---------------------------------------------------------------
This program is designed to be able to query an XML with XPath. The return type must be indicated: Boolean, Number, String, Node, and Nodeset. In the case of Nodeset, a checkbox appears that allows you to see distinct values.

You can get the executable you need from: https://github.com/SeryiPZdev/xpathquerytool/tree/main/xpathquerytool-trunk/dist

There is a version for Windows x86, another for Windows x64 and the executable .jar for any other platform.

Examples of use:

You can get the example.xml from: https://github.com/SeryiPZdev/xpathquerytool/blob/main/xpathquerytool-trunk/resources/example.xml
```xpath
/employees/employee/fname/text()  (return type = NODESET)
```
//employees (return type = STRING)

//age/text()  (return type = NODESET)

count(//employee) (return type = NUMBER)

/employees/employee[department="Sales"]  (return type = BOOLEAN)

/employees/employee/department/text()  (return type = NODESET)

/employees/employee/department/text()  (return type = NODESET) and Checkbox "distinct values" checked
