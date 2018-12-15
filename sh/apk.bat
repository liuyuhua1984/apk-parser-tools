title apk-tools
@echo off
set JAVA=java 
set jar=apk-parser-tools-1.0.0.jar
set MAIN=com.lyh.apk.App
set libs=./lib/*
set inpuPath=../app.apk 
set outputPath=../
set allPackage=1
set log=./logs
#nohup "$JAVA" -cp "$libs":"$jar" "$MAIN" ${SID} ./ ${log} -Dfile.encoding=UTF-8 >log.txt 2>&1 &
set r_host=127.0.0.1
set r_port=10002

%JAVA% -server -Xms1024m -Xmx1024m -Xmn200m -Djava.rmi.server.hostname=%r_host% -Dcom.sun.management.jmxremote.port=%r_port% -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Xss256k -Xnoclassgc -XX:+ExplicitGCInvokesConcurrent -XX:+AggressiveOpts -XX:+UseParNewGC -XX:ParallelGCThreads=8 -XX:+UseConcMarkSweepGC -XX:ParallelCMSThreads=8 -XX:+UseFastAccessorMethods -XX:+CMSParallelRemarkEnabled -XX:+UseCMSCompactAtFullCollection -XX:CMSFullGCsBeforeCompaction=0 -XX:+UseBiasedLocking -XX:CMSInitiatingOccupancyFraction=70 -XX:SoftRefLRUPolicyMSPerMB=0 -XX:+PrintClassHistogram -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintTenuringDistribution -Xloggc:log/gc.log -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=512m -cp %libs%;%jar% %MAIN% . %log% %inpuPath% %outputPath% %allPackage% -Dfile.encoding=UTF-8 >log.txt 2>&1 &

pause