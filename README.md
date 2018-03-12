# Jrebel & Jet Brains License Server for Java

A license server for Jrebel & JetBrains products, it also support JRebel for Android and XRebel.

***
Thank ilanyu

NOTE: This is provided for educational purposes only. Please support genuine.
***
## Setup
Run:
```
cd /path/to/project
mvn compile 
mvn exec:java -Dexec.mainClass="com.vvvtimes.server.MainServer" -Dexec.args="-p 8081"
```
Packing a runnable jar:
```
mvn package
```
then
```
java -jar JrebelBrainsLicenseServerforJava-1.0-SNAPSHOT-jar-with-dependencies.jar -p 8081
```
default port is 8081.

## Support

Jrebel

JRebel for Android

XRebel

JetBrains Products

## Feedback

+ issue: https://gitee.com/gsls200808/JrebelLicenseServerforJava/issues
+ QQ Group: 527290836