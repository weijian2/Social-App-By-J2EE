## Introduction
Grumblr is a simple social web application powered by J2EE. User can register account and post blogs, other user can comment your blogs.

## Tech Stack
* MVC design pattern
* HTML/CSS/JavaScript/JAVA
* JSP/JSTL/ORM
* MYSQL

## Project Architechture
> Grumblr
>> src
>>> controller<br>
>>> databean<br>
>>> formbean<br>
>>> model<br>

## Requirements
* Apache Tomat v8.5
* Eclipse JEE
* JAVA 8
* MySQL

## Installation
Clone the GitHub repository and then import Social-App-By-J2EE.war into your eclipse.

```
git clone https://github.com/weijian2/Social-App-By-J2EE
```
To import WAR file into Eclipse JEE, click on File -> Import. Select Web -> WAR File.
* **WAR** file: Provide the full pathname of the WAR file on your computer.
* **Web project**: This will pre-fill based on the WAR file name. You can change it, which is handy if
you’re experimenting.
* **Target runtime**: You will need to select “Apache Tomcat 8.5”. The first time you import a WAR
file (or create new “Dynamic Web Project”) you will need to declare the new runtime environment. Do this by clicking on “New” and filling in the form as follows:
	* **Apache Tomat v8.5**, then click “Next”
	* Provide the Tomcat installation directory by giving the full pathname of the directory
containing your unzipped version of Tomcat 8.5.
	* Click “Finished”.
* Click "Finished".

Run the imported project by “right-clicking” on the new project and selecting “Run As -> Run on Server. <br>
After Installing MySQL, create the anonymous account and the “test” database by using following code<br>
```
mysql -u root –p
alter user user() identified by '';
create user ''@'localhost' identified by password '';
grant all privileges on *.* to ''@'localhost';
create database test;
exit;
```

## Screenshots
login page
![](https://github.com/weijian2/Social-App-By-J2EE/raw/master/demoPics/login.png)
register page
![](https://github.com/weijian2/Social-App-By-J2EE/raw/master/demoPics/register.png)
home page
![](https://github.com/weijian2/Social-App-By-J2EE/raw/master/demoPics/HomePage.png)
visitor page
![](https://github.com/weijian2/Social-App-By-J2EE/raw/master/demoPics/VisitorPage.png)

## Usage/Quick Start
Resister account, post blogs, comments other's blogs, enjoy!:+1:

## Known bugs
If you find any bugs, feel free to contact weijian1@andrew.cmu.edu

## Todo list
* Add Ajax call to update comments without reloading whole page

## Deployment
Deployment Environment: Amazon EC2 <br>
[demo link](https://54.214.127.64/Social-App-By-J2EE) <br>
**Notice: since I use a self-signed certificate, browser may show that this website is not secure, just ignore that and go on.** <br>
(Please contact me at weijian1@andrew.cmu.edu if this instance is not running)

## Change Log
v1.0.0(12/01/2017)<br>
* user can register account using email
* user can post blogs
* user can comments other's blogs
* user can delete any comments comment by themselves
* user can see other's page

## Licenses
NAN

## Notes
You need to have Eclipse JEE and MySQL installed in order to run this project on local machine or you can click deployed link above to run it remotely.

