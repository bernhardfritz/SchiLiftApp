SchiLiftApp
==========

Discussions @ http://piratepad.net/BHbYxNODG5

#Info zur Verwendung von git
Zum lokalen Anlegen des git repository muss einmalig
`git clone https://github.com/bernhardfritz/SchiLiftApp.git` eingegeben werden.

Zum Empfangen des aktuellen Stands genügt `git pull origin master`

Zum Senden des lokalen Stands müssen folgende 3 Befehle im git repository
Hauptverzeichnis (z.B: SchiLiftApp) verwendet werden:
- `git add --all .`
- `git commit -m "Sinnvolle Information über die vollzogenen Änderungen"`
- `git push origin master`

Achtung! Es kann sein, dass sich Daten seit dem letzten `git pull origin master`
verändert haben und dass `git push -u origin master` nicht möglich ist. Um
dieses Problem zu lösen genügt es (meist) einfach `git pull origin master`
erneut aufzurufen. Ist dies nicht möglich, heißt das, dass 2 oder mehr Leute an
gleichen Dateien arbeiten. In diesem Fall muss "gemerged" werden, dh. die
verschiedenen Versionen auf eine Version zusammengeführt werden. Normalerweise
ist git dazu in der Lage die nötigen Änderungen selbst durchzuführen, falls
nicht können Änderungen mit `git mergetool` händisch durchgeführt werden.
