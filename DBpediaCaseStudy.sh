#!/bin/bash
folder=/Users/user/Downloads/usewod2013_dataset/data/CLF-server-logs/dbpedia
for f in $folder/3-3 $folder/3-4 $folder/3-5-1 $folder/3-6 $folder/3-8
do
	echo "============================================================================================================="
	echo "Processing dataset: $f !!"
	cd $f/Original
	grep -ir regex *.log | wc -l
	purge
	echo "============================================================================================================="

done
folder=/Users/user/Downloads/USEWOD2014/data/DBpedia
for f in $folder/dbpedia3.8 $folder/dbpedia3.9
do
	echo "============================================================================================================="
	echo "Processing dataset: $f !!"
	cd $f/
	grep -ir regex *.log | wc -l
	purge
	echo "============================================================================================================="

done