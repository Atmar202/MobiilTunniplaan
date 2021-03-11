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
Kolmas activity näitab sellel nädalal olevaid tunniplaani muudatusi (Päev: tund ja aine) ning samuti on olemas ka eelistusnupp, mida saab välja või sisse lülitada, et saada teateid selle rühma tunniplaani muudatustest. Samuti on olemas ka back nupp, mis viib tagasi eelmisse activity.
# Tööplaan
1 Nädal:
3 Tundi | Loob projekti ja activity'id. | Noole
3 Tundi | Loob andmebaasi ja ühendab selle SQLLite'iga. | Peeduli
4 Tundi | Loob kujunduse valmis. | Rauno
1 Tundi | Projekti testimine ja märkmete tegemine. | Noole
2 Nädal:
3 Tundi | Esimese activity koodi kirjutamine. | Peeduli
4 Tundi | Esimese activity koodi täiendamine/errorite kõrvaldamine | Noole, Rauno
1 Tundi | Alustab teise activity koodi kirjutamisega. | Peeduli
1 Tundi | Projekti testimine ja märkmete tegemine. | Peeduli
3 Nädal:
3 Tundi | Loob seose andmebaasiga koos activity'itega, et päringuid oleks näha läbi andmebaasi ning kujunduse teisele activity'ile | Rauno
3 Tundi | Lõpetab teise activity koodi kirjutamise. | Peeduli
3 Tundi | Täiendab teise activity koodi/kõrvaldab erroreid | Noole
1 Tundi | Projekti testimine ja märkmete tegemine. | Rauno
4 Nädal:
5 Tundi | Kolmanda activity koodi kirjutamine ja errorite kõrvaldamine esimeses ja teises activity'is | Peeduli
3 Tundi | Kolmanda activity täiendamine ja kujunduse loomine | Peeduli, Rauno
1 Tundi | Projekti testimine ja märkmete tegemine. | Noole, Rauno
4 Tundi | Dokumentide vormistamine ja kokkuvõte | Peeduli, Rauno, Noole
