#!/bin/bash
folder=~/usewod2013_dataset/data/CLF-server-logs/dbpedia
for f in $folder/3-3 $folder/3-4 $folder/3-5-1
do
	echo "============================================================================================================="
	echo "Processing dataset: $f !!"
	java -Xmx6000m -Djava.util.logging.config.file=etc/jdk14.properties -cp target/SparqlLogAnalysis.jena-0.0.1.jar:target/dependency/* Main.Java.saud.sparqlLogging.main.CopyOfLogFolder $f
	echo "============================================================================================================="

done
