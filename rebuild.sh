#!/bin/bash

#this script builds some Java tag server code to native machine language
#the products are:
#	ServeTagsAllDay: Acts as a client to PLC using JUCS and a server to microgrid tag client
#	ServeModelTags: emulates ServeTagsAllDay using simulated hardware

echo 'Rebuilding shared objects and executables for the following:'
echo 'ServeTagsAllDay', 'ServeModelTags'
echo '.......................................................................'
echo 'preparing directories...'
mkdir ./prod ./prod/int ./prod/out
echo 'compile and assemble .jars'
echo 'starting with gticom ( 1 of 3)'
gcj --classpath=./gticom.jar:./jucs-0.8.4.jar -fjni -fPIC -o ./prod/int/gticom.o -c ./gticom.jar
echo 'on to jucs (2 of 3)'
gcj --classpath=./gticom.jar:./jucs-0.8.4.jar -fjni -fPIC -o ./prod/int/jucs.o -c ./jucs-0.8.4.jar
echo 'on to model (3 of 3)'
gcj --classpath=./model.jar -fjni -fPIC -o ./prod/int/model.o -c ./model.jar
echo 'now to make them shared objects...'
echo 'starting with gticom (1 of 3)'
gcj -shared -fPIC -o ./prod/int/gticom.o  ./prod/int/gticom.o -o ./prod/out/gticom.so
echo 'on to jucs (2 of 3)'
gcj -shared -fPIC -o ./prod/int/jucs.o ./prod/int/jucs.o -o ./prod/out/jucs.so
echo 'on to model (3 of 3)'
gcj -shared -fPIC -o ./prod/int/model.o ./prod/int/model.o -o ./prod/out/model.so
echo 'and now to compile and assemble the executables...'
echo 'starting with ServeTagsAllDay (1 of 2)'
gcj --classpath=./gticom.jar:./jucs-0.8.4.jar -fjni -o ./prod/int/ServeTagsAllDay.o -c ./ServeTagsAllDay.java
echo 'on to ServeModelTags (2 of 2)'
gcj --classpath=./model.jar -fjni -o ./prod/int/ServeModelTags.o -c ./ServeModelTags.java
echo 'and now for linkage...'
echo 'starting with ServeTagsAllDay (1 of 2)'
gcj -fjni --main=ServeTagsAllDay -o ./prod/out/ServeTagsAllDay ./prod/int/ServeTagsAllDay.o ./prod/int/gticom.o ./prod/int/jucs.o
echo 'starting with ServeModelTags (2 of 2)'
gcj -fjni --main=ServeModelTags -o ./prod/out/ServeModelTags ./prod/int/ServeModelTags.o ./prod/int/model.o

echo 'everything should be built now'
echo 'zipping up the new files'
echo "$1"
7z a "$1" ./prod/out/
