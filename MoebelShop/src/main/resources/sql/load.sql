-- ===============================================================================
-- Jede SQL-Anweisung muss in genau 1 Zeile
-- Kommentare durch -- am Zeilenanfang
-- ===============================================================================

-- Insert f�r Artikel
INSERT INTO artikel (id, bezeichnung, preis, ausgesondert, erzeugt, aktualisiert) VALUES (300,'Tisch ''Oval''',80,0,'01.08.2006 00:00:00','01.08.2006 00:00:00');
INSERT INTO artikel (id, bezeichnung, preis, ausgesondert, erzeugt, aktualisiert) VALUES (301,'Stuhl ''Sitz bequem''',10,0,'02.08.2006 00:00:00','02.08.2006 00:00:00');
INSERT INTO artikel (id, bezeichnung, preis, ausgesondert, erzeugt, aktualisiert) VALUES (302,'T�r ''Hoch und breit''',300,0,'03.08.2006 00:00:00','03.08.2006 00:00:00');
INSERT INTO artikel (id, bezeichnung, preis, ausgesondert, erzeugt, aktualisiert) VALUES (303,'Fenster ''Glasklar''',150,0,'04.08.2006 00:00:00','04.08.2006 00:00:00');
INSERT INTO artikel (id, bezeichnung, preis, ausgesondert, erzeugt, aktualisiert) VALUES (304,'Spiegel ''Mach mich sch�ner''',60,0,'05.08.2006 00:00:00','05.08.2006 00:00:00');
INSERT INTO artikel (id, bezeichnung, preis, ausgesondert, erzeugt, aktualisiert) VALUES (305,'Kleiderschrank ''Viel Platz''',500,0,'06.08.2006 00:00:00','06.08.2006 00:00:00');
INSERT INTO artikel (id, bezeichnung, preis, ausgesondert, erzeugt, aktualisiert) VALUES (306,'Bett ''Mit Holzwurm''',600,0,'07.08.2006 00:00:00','07.08.2006 00:00:00');
INSERT INTO artikel (id, bezeichnung, preis, ausgesondert, erzeugt, aktualisiert) VALUES (307,'Bette ''Mit Holzwurm''',600,0,'07.08.2006 00:00:00','07.08.2006 00:00:00');

-- Insert f�r Bestellung
--INSERT INTO bestellung (id, kunde_fk, idx, erzeugt, aktualisiert) VALUES (400,101,0,'01.08.2006 00:00:00','01.08.2006 00:00:00');
--INSERT INTO bestellung (id, kunde_fk, idx, erzeugt, aktualisiert) VALUES (401,101,1,'02.08.2006 00:00:00','02.08.2006 00:00:00');
--INSERT INTO bestellung (id, kunde_fk, idx, erzeugt, aktualisiert) VALUES (402,102,0,'03.08.2006 00:00:00','03.08.2006 00:00:00');
--INSERT INTO bestellung (id, kunde_fk, idx, erzeugt, aktualisiert) VALUES (403,102,1,'04.08.2006 00:00:00','04.08.2006 00:00:00');
--INSERT INTO bestellung (id, kunde_fk, idx, erzeugt, aktualisiert) VALUES (404,104,0,'05.08.2006 00:00:00','05.08.2006 00:00:00');

-- Insert f�r Bestellposition
--INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, idx) VALUES (500,400,300,1,0);
--INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, idx) VALUES (501,400,301,4,1);
--INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, idx) VALUES (502,401,302,5,0);
--INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, idx) VALUES (503,402,303,3,0);
--INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, idx) VALUES (504,402,304,2,1);
--INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, idx) VALUES (505,403,305,1,0);
--INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, idx) VALUES (506,404,300,5,0);
--INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, idx) VALUES (507,404,301,2,1);
--INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, idx) VALUES (508,404,302,8,2);

-- Insert f�r Geschlecht
--INSERT INTO geschlecht VALUES (0, 'MAENNLICH');
--INSERT INTO geschlecht VALUES (1, 'WEIBLICH');

-- Insert f�r Familienstand
--INSERT INTO familienstand VALUES(0, 'LEDIG');
--INSERT INTO familienstand VALUES(1, 'VERHEIRATET');
--INSERT INTO familienstand VALUES(2, 'GESCHIEDEN');
--INSERT INTO familienstand VALUES(3, 'VERWITWET');

-- Insert f�r Hobbys
--INSERT INTO hobby VALUES (0, 'SPORT');
--INSERT INTO hobby VALUES (1, 'LESEN');
--INSERT INTO hobby VALUES (2, 'REISEN');

-- Insert f�r Transportart
--INSERT INTO transport_art VALUES (0, 'STRASSE');
--INSERT INTO transport_art VALUES (1, 'SCHIENE');
--INSERT INTO transport_art VALUES (2, 'LUFT');
--INSERT INTO transport_art VALUES (3, 'WASSER');

-- Insert f�r Adresse
--INSERT INTO adresse (id, plz, ort, strasse, hausnr, kunde_fk, erzeugt, aktualisiert) VALUES (200,'76133','Karlsruhe','Moltkestra�e','30',1,'01.08.2006 00:00:00','01.08.2006 00:00:00');
--INSERT INTO adresse (id, plz, ort, strasse, hausnr, kunde_fk, erzeugt, aktualisiert) VALUES (201,'76133','Karlsruhe','Moltkestra�e','31',101,'02.08.2006 00:00:00','02.08.2006 00:00:00');
--INSERT INTO adresse (id, plz, ort, strasse, hausnr, kunde_fk, erzeugt, aktualisiert) VALUES (202,'76133','Karlsruhe','Moltkestra�e','32',102,'03.08.2006 00:00:00','03.08.2006 00:00:00');
--INSERT INTO adresse (id, plz, ort, strasse, hausnr, kunde_fk, erzeugt, aktualisiert) VALUES (203,'76133','Karlsruhe','Moltkestra�e','33',103,'04.08.2006 00:00:00','04.08.2006 00:00:00');
--INSERT INTO adresse (id, plz, ort, strasse, hausnr, kunde_fk, erzeugt, aktualisiert) VALUES (204,'76133','Karlsruhe','Moltkestra�e','34',104,'05.08.2006 00:00:00','05.08.2006 00:00:00');
--INSERT INTO adresse (id, plz, ort, strasse, hausnr, kunde_fk, erzeugt, aktualisiert) VALUES (205,'76133','Karlsruhe','Moltkestra�e','35',105,'06.08.2006 00:00:00','06.08.2006 00:00:00');

-- Insert f�r Wartungsvertrag
--INSERT INTO wartungsvertrag (nr, datum, inhalt, kunde_fk, idx, erzeugt, aktualisiert) VALUES (1,'31.01.2005','Wartungsvertrag_1_K101',101,0,'01.08.2006 00:00:00','01.08.2006 00:00:00');
--INSERT INTO wartungsvertrag (nr, datum, inhalt, kunde_fk, idx, erzeugt, aktualisiert) VALUES (2,'31.01.2006','Wartungsvertrag_2_K101',101,1,'02.08.2006 00:00:00','02.08.2006 00:00:00');
--INSERT INTO wartungsvertrag (nr, datum, inhalt, kunde_fk, idx, erzeugt, aktualisiert) VALUES (1,'30.06.2006','Wartungsvertrag_1_K102',102,0,'03.08.2006 00:00:00','03.08.2006 00:00:00');

-- Insert f�r Lieferungen
--INSERT INTO lieferung (id, liefernr, transport_art_fk, erzeugt, aktualisiert) VALUES (600,'20051005-001',0,'01.08.2006 00:00:00','01.08.2006 00:00:00');
--INSERT INTO lieferung (id, liefernr, transport_art_fk, erzeugt, aktualisiert) VALUES (601,'20051005-002',1,'02.08.2006 00:00:00','02.08.2006 00:00:00');
--INSERT INTO lieferung (id, liefernr, transport_art_fk, erzeugt, aktualisiert) VALUES (602,'20051005-003',2,'03.08.2006 00:00:00','03.08.2006 00:00:00');
--INSERT INTO lieferung (id, liefernr, transport_art_fk, erzeugt, aktualisiert) VALUES (603,'20051008-001',3,'04.08.2006 00:00:00','04.08.2006 00:00:00');

-- Insert f�r bestellung_lieferung
--INSERT INTO bestellung_lieferung (bestellung_fk, lieferung_fk) VALUES (400,600);
--INSERT INTO bestellung_lieferung (bestellung_fk, lieferung_fk) VALUES (401,600);
--INSERT INTO bestellung_lieferung (bestellung_fk, lieferung_fk) VALUES (402,601);
--INSERT INTO bestellung_lieferung (bestellung_fk, lieferung_fk) VALUES (402,602);
--INSERT INTO bestellung_lieferung (bestellung_fk, lieferung_fk) VALUES (403,602);
--INSERT INTO bestellung_lieferung (bestellung_fk, lieferung_fk) VALUES (404,603);

-- Insert f�r kunde_hobby
--INSERT INTO kunde_hobby (kunde_fk, hobby_fk) VALUES (101,0);
--INSERT INTO kunde_hobby (kunde_fk, hobby_fk) VALUES (101,1);
--INSERT INTO kunde_hobby (kunde_fk, hobby_fk) VALUES (102,0);
--INSERT INTO kunde_hobby (kunde_fk, hobby_fk) VALUES (102,2);
--INSERT INTO kunde_hobby (kunde_fk, hobby_fk) VALUES (105,1);
--INSERT INTO kunde_hobby (kunde_fk, hobby_fk) VALUES (105,2);