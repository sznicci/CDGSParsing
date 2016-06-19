0. Szükséges programok:
	- Apache ant
	- Java SDK

1. A program fordítása:
	ant jar

2. A program futtatása:
	java -jar build/jar/Parsing.jar <cdgs leíró fájl neve> <lookup table-t tartalmazó fájl neve> <k> <input szó>

	példa1:
		java -jar build/jar/Parsing.jar CDGS.txt lookupTab.txt 1 aabaab

	példa2:
		java -jar build/jar/Parsing.jar CDGS02.txt lookupTab02.txt 2 aabbcc


3. A CDGS-t úgy kell megadni, hogy:
	- az első sorba vesszővel, szóközzel elválasztva felsoroljuk a nemterminálisokat,
	- második sorban ugyanígy a terminálisokat,
	- harmadik sorban az axiómát,
	- a többi sorban pedig soronként 1-1 P-t, mégpedig úgy, hogy a szabályokat szintén vesszővel, szóközzel választjuk el, a szabályok alakja pedig szóközmentes, és "->"-al.
	
4. A lookup table-t úgy kell megadni, hogy:
	- az első sorba kerüljön a táblázat sorának megnevezése,
	- a második sorba a táblázat oszlopának megnevezése,
	- a harmadik sorba pedig az ezekhez tartozó P-beli szabályok, szóközökkel elválasztva,
	- ezután pedig 1 sor üres, majd újra megadva a következő összetartozó értékeket.
	

