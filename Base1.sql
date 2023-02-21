Create database garage;
Create role garage;
Alter role garage login password 'garage';
Alter database garage owner to garage;

\c garage garage
garage

-- Supprimer toutes les tables
DO $$ DECLARE
    r RECORD;
BEGIN
    FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = current_schema()) LOOP
        EXECUTE 'DROP TABLE IF EXISTS ' || quote_ident(r.tablename) || ' CASCADE';
    END LOOP;
END $$;

-- 1
Create table Garagiste(
    idgaragiste serial primary key not null,
    email varchar(70) not null,
    mdp varchar(50) not null
);

-- 2
Create table Genre(
    idgenre serial primary key not null,
    nom varchar(12) not null
);
Insert into Genre(nom) values('Male');
Insert into Genre(nom) values('Femelle');

-- 3
Create table Niveauetude(
    idniveauetude serial primary key not null,
    niveauetude varchar(50) not null,
    niveau int
);
insert into niveauetude(niveauetude,niveau) values('bac',1);
insert into niveauetude(niveauetude,niveau) values('licence',3);
insert into niveauetude(niveauetude,niveau) values('master',5);
insert into niveauetude(niveauetude,niveau) values('doctorat',8);


-- 4
Create table Specialite(
    idspecialite serial primary key not null,
    nomspecialite varchar(50) not null,
    salaire_par_heure float not null
);

-- Exemple
insert into specialite(nomspecialite,salaire_par_heure) values('vidangeur',500000);
insert into specialite(nomspecialite,salaire_par_heure) values('nettoyeur',350000);
insert into specialite(nomspecialite,salaire_par_heure) values('pneu',1230000);
insert into specialite(nomspecialite,salaire_par_heure) values('controleur',1230000);
insert into specialite(nomspecialite,salaire_par_heure) values('moteur',1230000);
insert into specialite(nomspecialite,salaire_par_heure) values('depanneur',1230000);
insert into specialite(nomspecialite,salaire_par_heure) values('remorqueur',1230000);


-- 5
Create table Employe (
    idemploye serial primary key not null,
    nom varchar(50) not null,
    prenom varchar(50) not null,
    datenaissance date not null,
    idgenre int not null references genre(idgenre),
    idspecialite int not null references specialite(idspecialite),
    idniveauetude int not null references Niveauetude(idniveauetude)
);

-- 6
Create table Employe_Specialite(
    idemploye int not null references Employe(idemploye),
    idspecialite int not null references Specialite(idspecialite)
);



-- 8
Create table Client(
    idclient  serial primary key not null,
    nom varchar(50)  not null,
    prenom varchar(50) not null,
    email varchar(50) not null,
    contact varchar(50) not null,
    adresse varchar(50) not null,
    datenaissance DATE not null
    -- MDP A CORRIGER EN ADRESSE
);

-- 9
Create table Piece(
    idpiece serial primary key not null,
    nompiece varchar(50) not null
);

-- 9
create table marque(
    id SERIAL primary key,
    marque varchar(50)
);

-- 2 MARQUES
insert into marque(marque) values('ford');
insert into marque(marque) values('toyota');
-- 10
create table modele(
    id serial primary key,
    modele varchar(50),
    idmarque integer references marque(id)
);

-- Modele 4(2 modeles par marque)
insert into modele(modele) values('Ranger',1);
insert into modele(modele) values('Fiesta',1);
insert into modele(modele) values('V8',2);
insert into modele(modele) values('Fortuner',2);

-- 11
-- Type de vehicule
Create table Vehicule(
    idvehicule serial not null primary key,
    typevehicule  varchar(50) not null

);
insert into Vehicule(typevehicule) values('moto');
insert into Vehicule(typevehicule) values('camion');
insert into Vehicule(typevehicule) values('voiture');


-- 12
-- Vehicule du client
Create table vehicule_client(
    idvehiculeclient serial not null primary key,
    idclient int not null references client(idclient),
    idmodele int not null references modele(id),
    immatriculation varchar(50) not null,
    idvehicule int not null references vehicule(idvehicule)
);

-- 13
Create table Modele_piece (
    idmodelepiece serial primary key not null,
    idpiece int not null references Piece(idpiece),
    fonctionnalite Text not null,
    dimension float,
    prixpiece float not null,
    idvehicule int not null references Vehicule(idvehicule)
);

-- 14
Create table Type_Service(
    idtypeservice serial primary key not null,
    type_service varchar(50) not null
);

INSERT INTO Type_Service(type_service) values('vidange');
INSERT INTO Type_Service(type_service) values('nettoyage');


-- 15
Create table Service_specialite(
    idtypeservice int not null references Type_Service(idtypeservice),
    idspecialite int not null references Specialite(idspecialite),
    dureetravail double precision /*  satria misy minute   */

);
--Exemple
-- INSERT INTO  Service_specialite(idtypeservice,idspecialite,dureetravail) VALUES(1,1,2);
INSERT INTO  Service_specialite(idtypeservice,idspecialite,dureetravail) VALUES(1,1,3);
INSERT INTO  Service_specialite(idtypeservice,idspecialite,dureetravail) VALUES(2,2,0.5);


-- 16 Depense
-- Create table Type_depense(
--     idtypedepense serial primary key not null,
--     type_depense varchar(50) not null
-- );
-- INSERT INTO Type_depense(Type_depense) values('jirama');
-- INSERT INTO Type_depense(Type_depense) values('Loyer');
-- 17
Create table Achat_piece(
    idmodelepiece int not null references Modele_piece(idmodelepiece),
    quantite int default 0,
    idclient int not null references client(idclient),
    prix float,
    date_achat date
);

-- 18
Create table Depense(
    iddepense serial primary key not null,
    designation VARCHAR(100),
    prix float not null,
    date date
);


-- Degat/Gain
-- 19
Create table service_client(
    idserviceclient serial not null primary key,
    idvehicule int not null references Vehicule(idvehicule),
    idclient int not null references Client(idclient),
    idtypeservice int   not null references Type_Service(idtypeservice),
    libelle TEXT not null,
    -- prix float not null,
    dateservice date
);


-- Gain
-- 20
Create table Vente_piece(
    idmodelepiece int not null references modele_piece(idmodelepiece),
    quantite int default 0,
    idclient int not null references client(idclient),
    prix float,
    date_vente date
);


-- Devis
-- 21
Create table demandedevis(
    iddevis serial not null primary key,
    idclient int not null references Client(idclient),
    idtypeservice int not null references Type_Service(idtypeservice),
    datedevis date default now()
);

Create table Produit(
    idProduit serial not null primary key,
    nomproduit varchar(60),
    prix float not null
);

insert into Produit(nomproduit,prix) values('menaka',50000);
insert into Produit(nomproduit,prix) values('savon',12000);
insert into Produit(nomproduit,prix) values('eponge',3500);

-- 23
Create table Service_produit(
    idtypeservice int not null references Type_Service(idtypeservice),
    idProduit int not null references Produit(idProduit),
    quantite float not null
);
INSERT INTO Service_produit (idtypeservice,idProduit,quantite) VALUES(1,1,1);
INSERT INTO Service_produit (idtypeservice,idProduit,quantite) VALUES(2,2,1);
INSERT INTO Service_produit (idtypeservice,idProduit,quantite) VALUES(2,3,1);

-- Facture_mere
-- 22
create table facture_mere(
    idFactureMere serial  not null primary key,
    idclient int not null references Client(idclient),
    dates timestamp,
    remise double precision+
);

-- Details_Facture
-- 23
create table details_Facture(
    idDetailsfacture serial  not null primary key,
    idFactureMere int not null references facture_mere(idFactureMere),
    idtypeservice int not null references type_service(idtypeservice),
    prixunitaire double precision,
    quantite double precision,
    Montant double precision
);

-- Paiementfacture
-- 24
create table paiementfacture(
     idFactureMere int not null references facture_mere(idFactureMere),
     idclient int not null references Client(idclient),
     montant double precision
);

-- 24
Create table report(
    idreport serial not null primary key,
    montant double precision,
    datereport date
);


-- View

-- liste_employe
create or replace view liste_employe as
select idemploye, Employe.nom, Employe.prenom, genre.nom as genre , specialite.nomspecialite 
from Employe 
join genre on (Employe.idgenre=genre.idgenre) 
join specialite on (Employe.idspecialite=specialite.idspecialite);

-- liste_vehicule
create or replace view liste_vehicule as
select Client.idclient, Client.nom, Client.prenom , vehicule_client.immatriculation, Vehicule.typevehicule, modele.modele
from vehicule_client
join  Client on (vehicule_client.idclient =Client.idclient)
join  Vehicule on (vehicule_client.idvehicule =Vehicule.idvehicule)
join  modele on (vehicule_client.idmodele =modele.id);
select   liste_vehicule.idclient, liste_vehicule.nom, liste_vehicule.prenom , liste_vehicule.immatriculation, liste_vehicule.typevehicule, liste_vehicule.modele, marque.marque
from marque
join  liste_vehicule on marque.id =liste_vehicule.idclient;

-- liste_client
create or replace view liste_client as
select Client.idclient, Client.nom, Client.prenom, Client.contact
from Client;


-- les 5 clients les plus fideles
create or replace view Nom as
select Client.nom, count(Client.idclient)
from Client 
join  Achat_piece on (client.idclient=client.idclient)
group by nom
order by count desc
limit 5;

-- L'entretien qui se fait le plus dans le garage
create or replace view nomspecialite as
select nomspecialite,count(idspecialite)
from specialite
group by nomspecialite
order by count desc
limit 1;

-- Facture_mere_client
create or replace view Facture_mere_client as
select Client.idclient,facture_mere.idFactureMere,Client.nom,Client.prenom,facture_mere.dates
from Client
join facture_mere on (Client.idclient=facture_mere.idclient);


-- Details_facture_client 
create or replace view facture as
select facture_mere.idFactureMere,Client.idclient,Client.nom,Client.prenom, dates
from facture_mere
join Client on (facture_mere.idclient=Client.idclient);


create or replace view Details_facture_client as 
select facture.idFactureMere,facture.idclient,facture.nom,facture.prenom,
type_service.idtypeservice,type_service.type_service,details_Facture.Montant,details_Facture.prixunitaire,
details_Facture.quantite
from details_Facture
join facture on (details_Facture.idFactureMere = facture.idFactureMere)
join type_service on (details_Facture.idtypeservice=type_service.idtypeservice);









