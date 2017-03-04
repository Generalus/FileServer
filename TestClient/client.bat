echo off
title File Client
cls

goto start
    write -Dclient_root_folder=... to config root folder
    write -Dserver_url=... to choose specific server URL
:start

java -jar ^
 -server ^
 -Xmx4G ^
 -Xms1G ^
 -XX:+AggressiveOpts ^
 -XX:-UseGCOverheadLimit ^
 -XX:+DoEscapeAnalysis ^
 -XX:+HeapDumpOnOutOfMemoryError ^
 -XX:+UnlockDiagnosticVMOptions ^
 -XX:+DebugNonSafepoints ^
  TestClient-1.0-SNAPSHOT-jar-with-dependencies.jar
pause
