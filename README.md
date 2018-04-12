# SpringTalk
Chat application using Spring Boot and Oracle Database

## Demo
watch demo.avi

## Build
```
$mvn install:install-file -Dfile="./lib/ojdbc8.jar" -DgroupId="com.oracle" -DartifactId="ojdbc8" -Dversion="12.2.0.1" -Dpackaging="jar"
$mvn install
```

## Deployment sample
### Environment
machine: Oracle VM VirtualBox 5.1.22 r115126 (Qt5.6.2)  
CPU: 2 CPUs  
RAM: 4GB  
Storage: 32GB  
OS: CentOS 7.3.1611 Basic Web Server  
DB: Oracle Database 12c Release2  
JDK: OpenJDK 1.8.0_141  
### Orace Database installation
Oracle Database 12c Release 2 (12.2.0.1) 単一インスタンス・データベース・インストレーション・ガイド Linux x86-64 版  
http://www.oracle.com/technetwork/jp/database/enterprise-edition/documentation/sidb12201-inst-linux-x64-ja-v10-3627443-ja.pdf  
  
### Create Database
```
$dbca -silent -createDatabase -templateName General_Purpose.dbc -gdbname chatdb -sid chatdb -responseFile NO_VALUE -characterSet AL32UTF8 -memoryPercentage 40 -emConfiguration LOCAL
```
  
### Set instance automatic start
```
$vi /etc/oratab
```
NをYに変更  
```
chatdb:/u01/app/oracle/product/12.2.0/dbhome_1:Y  
```
  
### Set environment variable
```
$vi /home/oracle/.bash_profile
```
追記  
```
export ORACLE_SID=chatdb  
```
### Setup Database
ユーザー作成  
sql/create_user.sql  
テーブル作成  
sql/create_table.sql  
シーケンス作成  
sql/create_sequence.sql  
権限付与  
sql/create_sequence.sql  
  
### Start instance
```
$sqlplus sys/password as sysdba
SQL>startup
$lsnrctl start
```
  
### Start application
springTalk\target\springTalk-0.0.1-SNAPSHOT.jarを適当なディレクトリに配置
```
$sudo java -jar springTalk-0.0.1-SNAPSHOT.jar
```
