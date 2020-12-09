DROP TABLE "CONTRAT";

CREATE TABLE "CONTRAT" (
	"ID" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	"MATRICULE" VARCHAR(10),
	"NOM" VARCHAR(35),
	"PRENOM" VARCHAR(35),
 	"ADRESSE" VARCHAR(150),
	"FOLLOW_UP" VARCHAR(8),
	"ENERGY_METER" VARCHAR(10),
	CONSTRAINT primary_key_programmeur PRIMARY KEY (ID)
);

INSERT INTO PROGRAMMEUR(MATRICULE,NOM,PRENOM,FOLLOW_UP, ENERGY_METER) VALUES
('0000000001','Torvalds','Linus','2 avenue Linux Git','hourly', '654645'),
('0000000010','Stroustrup','Bjarne','294 rue C++','standard', '21321'),
('0000000011','Gosling','James','3 bvd JVM','daily', '3556'),
('0000000100','Turing','Alan','4 ruelle Enigma','daily', '9961'),
('0000000101','Ritchie','Dennis','6 rue des Pointeurs','monthly', '3566468'),
('0000000110','Wall','Larry','39 bvd Perl','standard', '554'),
('0000000111','Hopper','Grace','140 avenue Cob','standard', '68651'),
('0000001000','Lerdorf','Rasmus','2 rue P Hache Paix','monthly', '15547'),
('0000001001','Fielding','Roy','2 impasse des services','hourly', '876935'),
('0000001010','Codd','Edgar Frank','2 bvd des Relations','standard', '32538');