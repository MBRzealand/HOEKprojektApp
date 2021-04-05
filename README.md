# HØK Projekt App

<p align="center">
  <img src="https://user-images.githubusercontent.com/70659124/113585090-09148800-962c-11eb-8b73-f95694290326.png" height="100" width="100" />
</p>

Det overordnede UI er ret simpelt, det indeholder nogle inputfelter man kan udfylde, nogle tomme felter der selv bliver udregnet og nogle plus ikoner hvis man vil gå til en dybere udregnings-feature:

<img src="https://i.imgur.com/SOiA6yg.png" height="550" width="240">  

### Udregn Omsætning

Udregn omsætning featuren giver mulighed for at tilføje alle ens omsætninger til en tabel, hvorefter den selv udregner den totale omsætning og smidder ind i resultatopgørelsen, funktionen giver en fejlbesked hvis brugeren ikke har udfyldt alle felterne, og har yderligere en masse convenience features, eksempelvis fjernelse af leading zeroes.  

<img src="https://i.imgur.com/RmyfVsC.png" height="550" width="240"> <img src="https://i.imgur.com/eOG2Q2C.png" height="550" width="240"> 
<img src="https://i.imgur.com/fTr2vJ1.png" height="550" width="240"> 

### Udregn Vareforbrug

Udregn vareforbrug featuren fungerer komplet identisk med udregn omsætning featuren.

<img src="https://i.imgur.com/CZ8DdL5.png" height="550" width="240"> <img src="https://i.imgur.com/fUv2AiV.png" height="550" width="240">
<img src="https://i.imgur.com/S81kV9j.png" height="550" width="240"> 

### Udregnelse af tomme felter

Hvis alle felter over et tomt felt er udfyldt, vil programmet selv udfylde det tomme felt, ligeledes ved ændring af en værdi i et inputfelt vil programmet opdatere alle relevante tal.

<img src="https://i.imgur.com/ZeUFkVO.png" height="550" width="240">

### Udregn Øvrige Kapacitetsomkostninger

Udregn øvrige kapacitetsomkostninger featuren er identisk med både udregn omsætning og udregn vareforbrug featuresne, dog består featuren kun af 2 inputfelter og en tabel med 2 kolonner, modsat de andre med 3 inputfelter og 4 kolonner.

<img src="https://i.imgur.com/o9ckGJ3.png" height="550" width="240"> <img src="https://i.imgur.com/rh0r6zv.png" height="550" width="240">
<img src="https://i.imgur.com/RLpXzmN.png" height="550" width="240"> 

### Udregn Afskrivninger

Udregn afskrivninger featuren lader en skifte mellem "Lineær Afskrivning" og "Saldometoden" ved et tryk på en knap, derefter kan man udfylde den valgte metode og få udregnet de årlige afskrivninger som derefter kan godkendes og smides ind i resultatopgørelsen.

<img src="https://i.imgur.com/rWFKtmV.png" height="550" width="240"> <img src="https://i.imgur.com/0pqmexh.png" height="550" width="240">


### Udregn Resultat

Hvis alle felter i programmet er udfyldt vil programmet undervejs også have udregnet de tomme felter, og til sidst udregne resultatet.

<img src="https://i.imgur.com/OHUmTaF.png" height="550" width="240">


# TODO

- <s>Tilføj "kr" som enhed til alle tal på main activity </s>
- Tilføj "Udregnelse af Afskrivninger" feature
- Tilføj "Vis fulde resultatopgørelse" feature
- Tilføj "exporter til pdf/xlsx" feature

- Implementer BigInteger som datatype i stedet for Long for at undgå crash ved meget store tal

- Gem tabellernes data i model-objektet så de kan tilgås igen hvis man vil ændre tal
- Gør det muligt at slette elementer fra tabellerne

- <s>Lav logo/icon til appen </s>
- Opdater README når TODO er færdig




