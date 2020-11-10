1. Indications particulières pour lancer l’application
Avant de lancer l’application pour la première fois, il faut se connecter à la base données. 
Pour cela il suffit de se diriger sur l’onglet ‘Services’, choisir ‘Databases’ puis sélectionner ‘Start Server’ 
avec un clic droit sur ‘JavaDB’ ou sélectionner ‘Connect...’ avec un clic droit sur ‘jdbc:derby://localhost:1527/LSI_L3_JAVA [adm on ADM]’. 
Une fois connecté à la base de données, l’application peut être lancée.


2. Choix de SGBD : Java DB ou MySQL
Nous avons choisi Java DB comme SGBD car c’est un SGBD que nous avons découvert cette année et nous voulions le mettre en application. 
De plus, MySQL est un SGBD que nous avions déjà eu l’occasion d’utiliser auparavant lors de nos précédentes études. 
Ainsi nous souhaitions privilégier la nouveauté et élargir notre champ de connaissance en matière de SGBD.


Remarques:
* Nous avons mis en place un panel générique qui est utilisé pour chaque affichage des fonctionnalités 
et on lui applique un panel spécifique à ces fonctionnalités. Lorsqu’on change de fonctionnalité, 
on fait en sorte de retirer les deux panels présents puis de ré-appliquer le panel générique et le panel 
spécifique associé à la fonctionnalité demandée.
* Pour les fonctionnalités “Modifier” et “Supprimer” on a la possibilité de rechercher un programmeur. 
Nous avons choisi que cette recherche s'effectue sur le matricule du programmeur car c’est l’élément qui est mis en avant 
dans l’interface du cahier des charges et il s’agit d’un identifiant unique pour chaque programmeur.