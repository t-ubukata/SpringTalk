# SpringTalk
Chat application using Spring Boot and Oracle Database

## build
```
$mvn install:install-file -Dfile="./lib/ojdbc8.jar" -DgroupId="com.oracle" -DartifactId="ojdbc8" -Dversion="12.2.0.1" -Dpackaging="jar"
$mvn install
```

## deployment sample
machine: Oracle VM VirtualBox 5.1.22 r115126 (Qt5.6.2)
CPU: 2 CPUs
RAM: 4GB
Storage: 32GB
OS: CentOS 7.3.1611 Basic Web Server
DB: Oracle Database 12c Release2
JDK: OpenJDK 1.8.0_141

Oracle Database 12c Release 2 (12.2.0.1) �P��C���X�^���X�E�f�[�^�x�[�X�E�C���X�g���[�V�����E�K�C�h Linux x86-64 ��
http://www.oracle.com/technetwork/jp/database/enterprise-edition/documentation/sidb12201-inst-linux-x64-ja-v10-3627443-ja.pdf

DB�쐬
```
$dbca -silent -createDatabase -templateName General_Purpose.dbc -gdbname chatdb -sid chatdb -responseFile NO_VALUE -characterSet AL32UTF8 -memoryPercentage 40 -emConfiguration LOCAL
```

�����N���ݒ�
```
$vi /etc/oratab
```
N��Y�ɕύX
chatdb:/u01/app/oracle/product/12.2.0/dbhome_1:Y

oracle���[�U�[���ϐ��ǉ�
```
$vi ~/.bash_profile
```
�ǋL
$export ORACLE_SID=chatdb

sqlplus�N��
```
$sqlplus sys/password as sysdba
```

���[�U�[�쐬
doc/sql/create_user.sql

�e�[�u���쐬
doc/sql/create_table.sql

```
$sqlplus sys/password as sydba
SQL>startup
```

```
$lsnrctl start
```

springTalk\target\springTalk-0.0.1-SNAPSHOT.jar��K���ȃf�B���N�g���ɔz�u

```
$sudo java -jar springTalk-0.0.1-SNAPSHOT.jar
```
