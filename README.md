**Regular Expressions in SPARQL Queries**
-------------------

This is a tool which has been a part of the analysis of regex patterns within SPARQL queries.

Parsing SPARQL queries is done by the Jena arq (Apache License, Version 2.0).

**To compile the code:**

> mvn clean install  
> mvn dependency:copy-dependencies


**How to use:**  
There are different tasks that can be done the logs (you may want to have a look into the paper, see below).  
I've tried to tide up the code into a generic interface.  

run and follow the help within the command.  
> ./Universal.sh

**Licensing:**  
This code is licensed under the MIT License attached in the parent directory.  


**Publication:**  
a copy of the paper is attached in the parent directory named "aljaloud_luczakrosch_chown_gibbins_usewod2014-2.pdf".  

> Aljaloud, Saud, Luczak-Rösch, Markus, Chown, Tim and Gibbins, Nicholas (2014) Get All, Filter Details - On the Use of Regular Expressions in SPARQL Queries. In, 4th Workshop on Usage Analysis and the Web of Data in ESWC'2014, Crete, GR, 25 May 2014.  


**Support:**  
Check my profile for my email.  
Helping is not guaranteed, asking is never a problem :)
  
  
  

**Output Sample:** 
From generated directory (Result)  

**Stats.txt:** 

    "Number of regexes is:  1586
    Number of lines being processed is:     115001
    Number of ingenune Queries:     495
    =======================================
    Ingenuen Regexes:       21
    Just *: 11
    Just +: 2
    .+:     0
    .*:     212
    .+?:    0
    .*?:    0
    Start-With:     537
    End-With:       81
    Average Length of entire regex: 16.629255989911726
    Average Length of regex literal:        8.502035617828376
    Max Length:     80
    Negation:       6
    URL:    567
    flag:   551
    Not English String:     14
    Exact Search:   57
    Just Letters:   559
    Just Numbers:   15

**Regexes.txt:**  

    ^Tokyo
    nfl.com
    nfl.com
	...
	...
	...
    (Fortaleza)
    Teatro
    Packers
    ^Orchard road$

From generated directory (PatternAnalysis)

**predicates.txt:**  

    http://www.w3.org/2000/01/rdf-schema#label
    http://dbpedia.org/ontology/wikiPageExternalLink
    http://dbpedia.org/ontology/wikiPageExternalLink
    http://www.w3.org/2000/01/rdf-schema#label
    http://purl.org/dc/terms/subject
    http://purl.org/dc/terms/subject
    http://dbpedia.org/property/currentteam
    http://www.w3.org/2000/01/rdf-schema#label

**stats.txt:**  

    Subjects: 229
    Predicates: 89
    Objects: 763