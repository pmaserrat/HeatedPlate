#!/bin/bash
# run: testPackage.sh [filename] [package to run]
# CSV file should provide parameters in the order d,l,r,t,b on each line
	
touch test.txt

while read p
do
	IFS=','
	read -a myParams <<< "${p}"
	java $2 -d ${myParams[0]} -l ${myParams[1]} -r ${myParams[2]} -t ${myParams[3]} -b ${myParams[4]} >> test.txt

done <$1
	
	echo -e "Tests complete. Output written to test.txt"
