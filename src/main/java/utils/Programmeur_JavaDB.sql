DROP TABLE "PROGRAMMEUR";

CREATE TABLE "PROGRAMMEUR" (
	"ID" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	"MATRICULE" VARCHAR(10),
	"NOM" VARCHAR(35),
	"PRENOM" VARCHAR(35),
 	"ADRESSE" VARCHAR(150),
	"PSEUDO" VARCHAR(20),
	"RESPONSABLE" VARCHAR(30),
	"HOBBY" VARCHAR(10),
	"DATE_NAISS" DATE,
	"DATE_EMB" DATE,
	CONSTRAINT primary_key_programmeur PRIMARY KEY (ID)
);

INSERT INTO PROGRAMMEUR(MATRICULE,NOM,PRENOM,ADRESSE,PSEUDO,RESPONSABLE,HOBBY,DATE_NAISS,DATE_EMB) VALUES
('1','Torvalds','Linus','2 avenue Linux Git','linuxroot','Didier Achvar','Salsa','1969-01-12','2170-01-12'),
('2','Stroustrup','Bjarne','294 rue C++','c++1','Karim Lahlou','Voyages','1950-01-12','2466-01-12'),
('3','Gosling','James','3 bvd JVM','javapapa','Jacques Augustin','Peinture','1955-01-12','1987-01-12'),
('4','Turing','Alan','4 ruelle Enigma','robot1er','Nicolas Sicard','Maquettes','1912-01-12','2497-01-12'),
('5','Ritchie','Dennis','6 rue des Pointeurs','ccmoi','Didier Achvar','Boxe','1941-01-12','1688-01-12'),
('6','Wall','Larry','39 bvd Perl','expresso','Jacques Augustin','Aucun','1954-01-12','3822-01-12'),
('7','Hopper','Grace','140 avenue Cob','coboliator','Marc Souchet','Marche','1906-01-12','2400-01-12'),
('8','Lerdorf','Rasmus','2 rue P Hache Paix','webgourou','Christian Khoury','Dormir','1968-01-12','4210-01-12'),
('9','Fielding','Roy','2 impasse des services','grandrest','Christian Khoury','Judo','1968-01-12','3482-01-12'),
('10','Codd','Edgar Frank','2 bvd des Relations','bdd1','Lamine Bougueroua','Puzzles','1923-01-12','8541-01-12');