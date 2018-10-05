#!/bin/bash

genData(){
    # project name
    REPO=$1

    # path for project's source codes
    SRC=$2  

    # generate call graph among classes
    echo ""
    echo "begin to generate method map"
    cd GenClassCallGraph
    if [ ! -d "data/" ]; then
        mkdir data
    fi
    find $SRC -name *.java > data/${REPO}JavaFile.txt
    find ./src -name *.java > javaFile.txt
    if [ ! -d "map/" ]; then
        mkdir map
    fi
    javac -d . -cp .:./mylib/* @javaFile.txt
    java -cp .:./mylib/* adapt.codeMining.javaParser.callGraph.CallGraphGenerator ${REPO}
    cd ..

    # generate parse trees for all methods
    echo ""
    echo "begin to generate parse tree"
    cd GetParseTree
    echo repoNames=${REPO} > param.properties
    if [ ! -d "data/" ]; then
        mkdir data
    fi
    find $SRC -name *.java > data/${REPO}JavaFile.txt
    if [ ! -d "output/" ]; then
        mkdir output
    fi
    find ./src -name *.java > javaFile.txt
    javac -d . -cp .:./mylib/* @javaFile.txt
    java -cp .:./mylib/* parseTree.Main ${REPO}
    cd ..
}

LIMIT=$1

genData train ../../CodeComment_Data/Code_Jam/train/

# train the Code RNN (parse tree)
echo ""
echo "begin to train Code RNN"

echo "-- begin to generate data for training"
cd Code_RNN
if [ ! -d "data/" ]; then
    mkdir data
fi
cp ../GetParseTree/output/* data/
python gen_data.py train

echo "-- begin to train"
python train.py ${LIMIT}
cd ..

echo "-- begin to generate data for evaluation"
genData test ../../CodeComment_Data/Code_Jam/test/
cd Code_RNN
if [ ! -d "test_data/" ]; then
    mkdir test_data
fi
cp ../GetParseTree/output/* test_data/
python gen_data.py test
#echo "-- begin to test"
#python eval.py
cd ..



