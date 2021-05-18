# Mobiilirakendus Tunniplaan (TTHK)
TTHK tunniplaanide nägemine läbi telefoni rakenduse.
# Töövahendid:
Android Studio
# Ülesande Püstitus
Rakendusel saab otsida rühma kirjutades või saab kasutada ribamenüüd, kus on olemas kõik rühmad ja on võimalik valida seal.
Valides rühma tuleb ette selle rühma tunniplaani, kus on võimalik valida ribamenüült päeva või nädala.
Rakendusega saab näha maksimaalselt nelja nädala vanuseid tunniplaane - kõige uuemad ja vanemad, ülejäänud automatseelt kustutakse või veel ei lisata.
Menüüribal default setting päeva jaoks on: esmaspäev, kus on näha mis kellaajal algab täpne tund, millal lõppeb see tund, millal lõppeb koolipäev ja millal toimuvad söögivahetunnid.
Samuti on võimalik end registreerida selle rühma jaoks, et automaatselt saada teatiseid tunniplaani muudatusest, mis on seotud selle rühmaga.
# Prototüüp
Esimesel activity'il on olemas: editText, nupp ja menüüriba. Menüüriba tagastab rühma listi, nupuga saab leida üles rühma läbi selle, mida oli kirjutatud editTexti või mida oli valitud menüüribast. 
Kui on valitud menüüribast rühm ja editTextile on lisatud tekst, siis programm otsib ainult läbi menüüriba.
Nupu vajutusel viib teise activity, kus on andmed, mis on saadud läbi andmebaasi (Tund: Aine nimi / Klass / Õpetaja nimi).
Üleval paremal nurgas on olemas menüüriba, mis toob ette kaskaadimenüü, millega saab valida kas päeva sellel nädalal või täiesti teise nädala.
On olemas ka back nupp, mis viib tagasi esimesse activity ja muudatuste nupp, mis viib kolmandasse activity.
Kolmas activity näitab sellel nädalal olevaid tunniplaani muudatusi (Päev: tund ja aine) ning samuti on olemas ka eelistusnupp, mis viib neljandasse activityisse, kust saab valida eelistus nagu: märguannete sisse või välja lülitamine, et saada teateid selle rühma tunniplaani muudatustest ja ka ekraani theme muutmine. Samuti on olemas ka igal activity'il back nupp, mis viib tagasi eelmisse activity.
# Tööplaan
![589ee2628d1d102ceff0a47d1db2f132](https://user-images.githubusercontent.com/71074700/110799453-d7560e80-8283-11eb-93b9-a61856b65af3.png)
