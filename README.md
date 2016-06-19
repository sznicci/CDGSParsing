# CDGS parser algorithm

This program implements a Cooperating Distributed Grammar Systems (CDGS) parsing algorithm and reaches the theoretical optimal complexity.

## 0. Requirements:

- Apache ant
- Java SDK
- Reading the [scientific paper](http://www.sztaki.hu/tcs/gsweek04/gsw04-95-112.pdf) about the algorithm this program implements.

## 1. Compile the program:

```Bash
ant jar
```

## 2. Run the program:

```Bash
java -jar build/jar/Parsing.jar <cdgs description file name> <lookup table file name> <k> <input word>
```
- example1:
```Bash
java -jar build/jar/Parsing.jar CDGS.txt lookupTab.txt 1 aabaab
```

- example2:
```Bash
java -jar build/jar/Parsing.jar CDGS02.txt lookupTab02.txt 2 aabbcc
```

## 3. How to create the CDGS file. 

In the

- first row specify the Nonterminals separated with commas and whitespaces,
- second row specify the Terminals the same way,
- third row specify the axiom,
- remaining rows: each row is one rule set. Between the rules there are commas and whitespces, the format of the rules is `<left side>-><right side>`.
For an example see `CDGS.txt` or `CDGS02.txt`.

## 4. How to create the lookup table file.

In the

- first row specify the table row name,
- second row specify the table column name,
- third row specify the rules with commas and whitespaces which belong to this cell,
- followed by an empty row,
- the next row the next corresponding values.
For an example see `lookupTab.txt` or `lookupTab02.txt`.
