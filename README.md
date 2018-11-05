<h1> Customer Project Setup </h1>
<hr>
<h2> Clone Github Project to IntelliJ </h2>
<br>
<h3>---- Installation and Configuration Part ----</h3>
<br>
<b>1.&emsp;</b>    Please install IntelliJ Java IDE from => https://www.jetbrains.com/idea/download/

<b>2.&emsp;</b>    Please install suitable Git for your OS from => https://git-scm.com/downloads

<b>3.&emsp;</b>    If you dont have Java JDK,please download it to your local. 

<b>4.&emsp;</b>    Open IntelliJ Choose Configure -> Settings -> Version Control -> Git\
 &emsp;&emsp;&nbsp; * Write path for git executable file\
 &emsp;&emsp;&nbsp;  * For Mac, path is like => "usr/local/bin/git"\
 &emsp;&emsp;&nbsp;  * For Windows, path is like => "C:\Users\<username>\AppData\Local\Programs\Git\bin\git.exe"\
 &emsp;&emsp;&nbsp;  * <b> Test path,if it is ok, Apply settings. </b>

<h3>---- Clone Part ----</h3>
<br>
<b>5.&emsp;</b>    Open => https://github.com/denizcanyilmaz/customer 

<b>6.&emsp;</b>    Select "Clone or Download Project" and Copy the url of project.\
 &emsp;&emsp;&nbsp;  (URL => https://github.com/denizcanyilmaz/customer.git)

<b>7.&emsp;</b>    Open IntelliJ and Choose "Checkout from Version Control" - "Git" in the main window.

<b>8.&emsp;</b>    Paste url link to "URL" part in "Clone Repository" window. You can test the url.\
 &emsp;&emsp;&nbsp; Also choose a valid directory to set up project in "Directory" part in "Clone Repository" window\
 &emsp;&emsp;&nbsp; Choose "Clone"

<b>9.&emsp;</b>    There will be an alert message to open pom.xml file. Select "Yes" option.    

<b>10.&emsp;</b>    Wait a little bit when project is loading<b>.........</b> :sparkles::sparkles:



<hr>
<h2> Run Customer Project </h2>
<br>



<b>11.&emsp;</b>   Find the "CustomerApplication.java" file in project.\
  &emsp;&emsp;&nbsp;  (FULL PATH => /customer/src/main/java/com/yilmazdenizcan/customer/CustomerApplication.java)
        
<b>12.&emsp;</b>  You can see an error like "Project SDK is not defined." Open Setup SDK section.\
&emsp;&emsp;&nbsp;  <b> If you dont have any JDK setup in IntelliJ please add JDK path to configuration. </b> \
&emsp;&emsp;&nbsp; After Select JDK and apply it. You can run your class now.
              
<b>13.&emsp;</b>   Click right in CuatomerApplication.java and Run this java file.  \

<h4> &emsp;   You don't need any extra setup process to download database system. Project developed with H2 RDMS. </h4>

<b>14.&emsp;</b>   Please open a browser and open => http://localhost:8081/h2_console/

<b>15.&emsp;</b>  Select "Generic Hive 5" in Saved Settings part, Write a name and "Save" in Saved Name part.\
&emsp;&emsp;&nbsp;   Driver Class shıuld be => org.apache.hive.jdbc.HiveDriver\
&emsp;&emsp;&nbsp;  JDBC URL => jdbc:h2:file:~/h2/testdb\
&emsp;&emsp;&nbsp;  Username => sa\
&emsp;&emsp;&nbsp;  No Password\
          
<b>16.&emsp;</b>    Select "Test Connection", if it is ok, choose "Connect" button

<b>17.&emsp;</b>    Go => http://localhost:8081/login

<b>18.&emsp;</b>    Create a new User in Register Form. \
 &emsp;&emsp;&nbsp;   You can login with these username and password. //Login mechanism can look for valid username and password.
                
<b>19.&emsp;</b>    You can see your customers information and manage them in http://localhost:8081/customersapp         

<h1>20.&emsp;  :point_right: Have a good day </h1>
