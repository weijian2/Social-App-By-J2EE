## Introduction
This project is a simple social web application powered by J2EE. User can register account and post blogs, other user can comment your blogs.

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

Run the imported project by “right-clicking” on the new project and selecting “Run As -> Run on Server.

## Screenshots
![](https://github.com/weijian2/Social-App-By-J2EE/raw/master/demoPics/login.png)
![](https://github.com/weijian2/Social-App-By-J2EE/raw/master/demoPics/register.png)
![](https://github.com/weijian2/Social-App-By-J2EE/raw/master/demoPics/HomePage.png)
![](https://github.com/weijian2/Social-App-By-J2EE/raw/master/demoPics/VisitorPage.png)

## Usage/Quick Start
Resister account, post blogs, comments other's blogs, enjoy!:+1:

## Known bugs
If you find any bugs, feel free to contact weijian1@andrew.cmu.edu

## Todo list
* Add Ajax call to update comments without reloading whole page

## Deployment
Deployment Environment: Amazon EC2 <br>
[demo link](https://hypermap-cmu.appspot.com) <br>
(Please contact me at weijian1@andrew.cmu.edu if this instance is not running)

## Change Log
## Licenses

## Notes
You need to have Eclipse JEE and MySQL installed in order to run this project on local machine or you can click deployed link above to run it remotely.

