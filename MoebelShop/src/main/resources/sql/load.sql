-- ===============================================================================
-- Jede SQL-Anweisung muss in genau 1 Zeile
-- Kommentare durch -- am Zeilenanfang
-- ===============================================================================
--Insert Tabelle Artikel
INSERT INTO artikel (id, bezeichnung, preis, ausgesondert, erzeugt, aktualisiert) VALUES (300,'Tisch ''Oval''',80,0,'01.08.2006 00:00:00','01.08.2006 00:00:00');
INSERT INTO artikel (id, bezeichnung, preis, ausgesondert, erzeugt, aktualisiert) VALUES (301,'Stuhl ''Sitz bequem''',10,0,'02.08.2006 00:00:00','02.08.2006 00:00:00');

-- Insert Tabelle Kunde
INSERT INTO kunde (id, nachname, vorname, seit, art, familienstand_fk, geschlecht_fk, newsletter, rabatt, umsatz, email, password, erzeugt, aktualisiert) VALUES (1,'Admin','Admin','01.01.2001','F',NULL,NULL,1,'0,1',0,'admin@hska.de','1','01.08.2006 00:00:00','01.08.2006 00:00:00');
INSERT INTO kunde (id, nachname, vorname, seit, art, familienstand_fk, geschlecht_fk, newsletter, rabatt, umsatz, email, password, erzeugt, aktualisiert) VALUES (101,'Alpha','Adrian','31.01.2001','P',1,0,1,'0,1','1500,5','101@hska.de','101','01.08.2006 00:00:00','01.08.2006 00:00:00');
INSERT INTO kunde (id, nachname, vorname, seit, art, familienstand_fk, geschlecht_fk, newsletter, rabatt, umsatz, email, password, erzeugt, aktualisiert) VALUES (102,'Alpha','Alfred','28.02.2002','P',0,0,1,0,'500,5','102@hska.de','102','02.08.2006 00:00:00','02.08.2006 00:00:00');
INSERT INTO kunde (id, nachname, vorname, seit, art, familienstand_fk, geschlecht_fk, newsletter, rabatt, umsatz, email, password, erzeugt, aktualisiert) VALUES (103,'Alpha','Anton','15.09.2003','F',NULL,NULL,0,'0,1','0,5','103@hska.de','103','03.08.2006 00:00:00','03.08.2006 00:00:00');
INSERT INTO kunde (id, nachname, vorname, seit, art, familienstand_fk, geschlecht_fk, newsletter, rabatt, umsatz, email, password, erzeugt, aktualisiert) VALUES (104,'Delta','Dirk','30.04.2004','F',NULL,NULL,1,'0,15','1500,5','104@hska.de','104','04.08.2006 00:00:00','04.08.2006 00:00:00');
INSERT INTO kunde (id, nachname, vorname, seit, art, familienstand_fk, geschlecht_fk, newsletter, rabatt, umsatz, email, password, erzeugt, aktualisiert) VALUES (105,'Epsilon','Emil','31.03.2005','P',2,0,0,'0,0','1500,5','105@hska.de','105','05.08.2006 00:00:00','05.08.2006 00:00:00');

--Insert Tabelle Bestellung
--INSERT INTO bestellung VALUES (100,0,301,'02.08.2006 00:00:00','02.08.2006 00:00:00');
-- 
--INSERT INTO geschlecht VALUES (0, 'MAENNLICH');
--INSERT INTO geschlecht VALUES (1, 'WEIBLICH');

--
--INSERT INTO familienstand VALUES(0, 'LEDIG');
--INSERT INTO familienstand VALUES(1, 'VERHEIRATET');
--INSERT INTO familienstand VALUES(2, 'GESCHIEDEN');
--INSERT INTO familienstand VALUES(3, 'VERWITWET');

--
--INSERT INTO hobby VALUES (0, 'SPORT');
--INSERT INTO hobby VALUES (1, 'LESEN');
--INSERT INTO hobby VALUES (2, 'REISEN');

-- 
--INSERT INTO transport_art VALUES (0, 'STRASSE');--
--INSERT INTO transport_art VALUES (1, 'SCHIENE');
--INSERT INTO transport_art VALUES (2, 'LUFT');
--INSERT INTO transport_art VALUES (3, 'WASSER');

--
--INSERT INTO lieferung (id, liefernr, transport_art_fk, erzeugt, aktualisiert) VALUES (600,'20051005-001',0,'01.08.2006 00:00:00','01.08.2006 00:00:00');
--INSERT INTO lieferung (id, liefernr, transport_art_fk, erzeugt, aktualisiert) VALUES (601,'20051005-002',1,'02.08.2006 00:00:00','02.08.2006 00:00:00');
--INSERT INTO lieferung (id, liefernr, transport_art_fk, erzeugt, aktualisiert) VALUES (602,'20051005-003',2,'03.08.2006 00:00:00','03.08.2006 00:00:00');
--INSERT INTO lieferung (id, liefernr, transport_art_fk, erzeugt, aktualisiert) VALUES (603,'20051008-001',3,'04.08.2006 00:00:00','04.08.2006 00:00:00');

--
--INSERT INTO wartungsvertrag (nr, datum, inhalt, kunde_fk, idx, erzeugt, aktualisiert) VALUES (1,'31.01.2005','Wartungsvertrag_1_K101',101,0,'01.08.2006 00:00:00','01.08.2006 00:00:00');
--INSERT INTO wartungsvertrag (nr, datum, inhalt, kunde_fk, idx, erzeugt, aktualisiert) VALUES (2,'31.01.2006','Wartungsvertrag_2_K101',101,1,'02.08.2006 00:00:00','02.08.2006 00:00:00');
--INSERT INTO wartungsvertrag (nr, datum, inhalt, kunde_fk, idx, erzeugt, aktualisiert) VALUES (1,'30.06.2006','Wartungsvertrag_1_K102',102,0,'03.08.2006 00:00:00','03.08.2006 00:00:00');