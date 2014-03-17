#!/bin/bash
folder=/Users/user/Downloads/USEWOD2014/data/DBpedia
for f in $folder/dbpedia3.8 $folder/dbpedia3.9
do
	echo "============================================================================================================="
	echo "Processing dataset: $f !!"
	java -Xmx6000m -Djava.util.logging.config.file=etc/jdk14.properties -cp target/SparqlLogAnalysis.jena-0.0.1.jar:target/dependency/* Main.Java.saud.sparqlLogging.main.LogFolderPatternAnalysis $f
	purge
	echo "============================================================================================================="

done
