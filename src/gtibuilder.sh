#!/bin/bash

#goes through all subdirectories in a folder, compiles all .java files and puts the output 
# in a parallel file structure

expandstack="perm"

while getopts "ho:" OPTV; do
    case $OPTV in
        h)
            echo "usage: "
            echo "gtibuild.sh [options] <build directory>"
            echo "options:"
            echo "  -h:     display this help message"
            echo "  -o:     specify base output directory"
            exit 0
            ;;
        o)
            outbase=$OPTARG
            echo "output directory specified as $OPTARG"
            if [ ! -d $OPTARG ]
            then
                echo "this isn't a directory"
            fi
            
            ;;
        /?)
            echo "invalid option: - $OPTARG"
            exit 0
            ;;
        :)
            echo "option requires a parameter"
            exit 0
            ;;
    esac
done

if [ ! -v $outbase ]
then
    outbase=$(pwd)
    echo "output directory not specified, using current working directory: $outbase"
fi

initial="${!#}"
expandstack+=($initial)
echo "did I get the source directory right?: ${expandstack[1]}"


if [ -z "${expandstack[1]}" ]
then
    echo "no argument provided"
    exit 0
fi

cwd=$(pwd)
if [ ! -d ${expandstack[1]} ]
then
    echo "argument is not a directory"
    exit 0
fi

while [ ${#expandstack[@]} -gt 1 ]
do
    #go to next directory
    cd ${expandstack[-1]}
    cwd=$(pwd)
    echo "now in $cwd"
    #remove it from the expansion stack
    unset "expandstack[-1]"

    #compile any java source files found
    for file in $cwd/*.java
    do
        echo "compiling $file"
        echo
        echo "javac stuff here"
                

        #first, make directory for output file if it doesn't exist
        #if [ ! -d "$odir" ]
        #then
        #    mkdir "$odir"
        #fi
        
        #javac -sourcepath ~/Documents/GitRepositories/TagServer/CIPTagServer/src/jucs-0.8.4.jar -d $odir -source 1.7 $file

    done

    #add any directories to the expansionlist
    for folder in $cwd/*
    do
        if [ -d $folder ]
        then
            echo "adding $folder to expansion list"
            echo ${expandstack[@]}
            expandstack+=($folder)
        fi
    done
done
