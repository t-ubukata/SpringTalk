# SpringTalk

Chat application using Spring Boot and Oracle Database

## Demo

Watch demo.avi.

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

See the installation guidebelow.  
English  
http://www.oracle.com/technetwork/jp/database/enterprise-edition/documentation/sidb12201-inst-linux-x64-ja-v10-3627443-ja.pdf  
Japanese  
http://www.oracle.com/technetwork/jp/database/enterprise-edition/documentation/sidb12201-inst-linux-x64-ja-v10-3627443-ja.pdf  

### Create database

```
$dbca -silent -createDatabase -templateName General_Purpose.dbc -gdbname chatdb -sid chatdb -responseFile NO_VALUE -characterSet AL32UTF8 -memoryPercentage 40 -emConfiguration LOCAL
```

### Set instance automatic start

```
$vi /etc/oratab
```

Change N to Y.

```
chatdb:/u01/app/oracle/product/12.2.0/dbhome_1:Y
```

### Set environment variable

```
$vi /home/oracle/.bash_profile
```

Add the line below.

```
export ORACLE_SID=chatdb
```

### Setup instance

Creeate user.  
sql/create_user.sql  
Create table.  
sql/create_table.sql  
Create sequence.  
sql/create_sequence.sql  
Grant.  
sql/grant.sql  
  
### Start instance

```
$sqlplus sys/password as sysdba
SQL>startup
$lsnrctl start
```
  
### Start application

allocate springTalk\target\springTalk-0.0.1-SNAPSHOT.jar to any directory.

```
$sudo java -jar springTalk-0.0.1-SNAPSHOT.jar
```

