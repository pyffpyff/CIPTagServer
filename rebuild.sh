#!/bin/bash

#this script builds some Java tag server code to native machine language
#the products are:
#	ServeTagsAllDay: Acts as a client to PLC using JUCS and a server to microgrid tag client
#	ServeModelTags: emulates ServeTagsAllDay using simulated hardware

echo 'Rebuilding shared objects and executables for the following:'
echo 'ServeTagsAllDay', 'ServeModelTags'
echo '.......................................................................'
echo 'preparing directories...'
mkdir ./bin ./src ./int
echo 'compile and assemble .jars'
echo 'starting with gticom ( 1 of 3)'
gcj --classpath=./src/gticom.jar:./src/jucs-0.8.4.jar -fjni -fPIC -o ./int/gticom.o -c ./src/gticom.jar
echo 'on to jucs (2 of 3)'
gcj --classpath=./src/gticom.jar:./src/jucs-0.8.4.jar -fjni -fPIC -o ./int/jucs.o -c ./src/jucs-0.8.4.jar
echo 'on to model (3 of 3)'
gcj --classpath=./src/model.jar -fjni -fPIC -o ./int/model.o -c ./src/model.jar
echo 'now to make them shared objects...'
echo 'starting with gticom (1 of 3)'
gcj -shared -fPIC -o ./int/gticom.o  ./int/gticom.o -o ./bin/gticom.so
echo 'on to jucs (2 of 3)'
gcj -shared -fPIC -o ./int/jucs.o ./int/jucs.o -o ./bin/jucs.so
echo 'on to model (3 of 3)'
gcj -shared -fPIC -o ./int/model.o ./int/model.o -o ./bin/model.so
echo 'and now to compile and assemble the executables...'
echo 'starting with ServeTagsAllDay (1 of 2)'
gcj --classpath=./src/gticom.jar:./src/jucs-0.8.4.jar -fjni -o ./int/ServeTagsAllDay.o -c ./src/ServeTagsAllDay.java
echo 'on to ServeModelTags (2 of 2)'
gcj --classpath=./src/model.jar -fjni -o ./int/ServeModelTags.o -c ./src/ServeModelTags.java
echo 'and now for linkage...'
echo 'starting with ServeTagsAllDay (1 of 2)'
gcj -fjni --main=ServeTagsAllDay -o ./bin/ServeTagsAllDay ./int/ServeTagsAllDay.o ./int/gticom.o ./int/jucs.o
echo 'starting with ServeModelTags (2 of 2)'
gcj -fjni --main=ServeModelTags -o ./bin/ServeModelTags ./int/ServeModelTags.o ./int/model.o

echo 'everything should be built now'
#echo 'zipping up the new files'
#echo "$1"
#7z a "$1" .
