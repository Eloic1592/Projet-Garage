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
insert into specialite(nomspecialite,salaire_par_heure) values('vidangeur',50000);
insert into specialite(nomspecialite,salaire_par_heure) values('nettoyeur',35000);
insert into specialite(nomspecialite,salaire_par_heure) values('pneu',45000);
insert into specialite(nomspecialite,salaire_par_heure) values('controleur',75000);
insert into specialite(nomspecialite,salaire_par_heure) values('moteur',70000);
insert into specialite(nomspecialite,salaire_par_heure) values('depanneur',65000);
insert into specialite(nomspecialite,salaire_par_heure) values('remorqueur',80000);


-- 5
Create table Employe (
    idemploye serial primary key not null,
    nom varchar(50) not null,
    prenom varchar(50) not null,
    datenaissance date not null,
    idgenre int not null references genre(idgenre),
    -- idspecialite int not null references specialite(idspecialite),
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
    mdp varchar(50) not null 
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
insert into modele(modele,idmarque) values('Ranger',1);
insert into modele(modele,idmarque) values('Fiesta',1);
insert into modele(modele,idmarque) values('V8',2);
insert into modele(modele,idmarque) values('Fortuner',2);

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
    type_service varchar(50) not null,
    marge_beneficiaire float 
);

INSERT INTO Type_Service(type_service,marge_beneficiaire) values('vidange',0.2);
INSERT INTO Type_Service(type_service,marge_beneficiaire) values('nettoyage',0.15);
-- INSERT INTO Type_Service(type_service,marge_beneficiaire) values('gonflage de pneus',0.21);
-- INSERT INTO Type_Service(type_service,marge_beneficiaire) values('Controle niveau liquide',0.3);
-- INSERT INTO Type_Service(type_service,marge_beneficiaire) values('Controle moteur',0.1);
-- INSERT INTO Type_Service(type_service,marge_beneficiaire) values('Reparateur',0.19);
-- INSERT INTO Type_Service(type_service,marge_beneficiaire) values('routier',0.24);

-- 15
Create table Service_specialite(
    idtypeservice int not null references Type_Service(idtypeservice),
    idspecialite int not null references Specialite(idspecialite),
    dureetravail double precision /*  satria misy minute   */

);
--Exemple
INSERT INTO  Service_specialite(idtypeservice,idspecialite,dureetravail) VALUES(1,1,2);
INSERT INTO  Service_specialite(idtypeservice,idspecialite,dureetravail) VALUES(2,2,0.5);


-- 16 Depense
Create table Type_depense(
    idtypedepense serial primary key not null,
    type_depense varchar(50) not null
);
INSERT INTO Type_depense(Type_depense) values('jirama');
INSERT INTO Type_depense(Type_depense) values('Loyer');
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
    idtypedepense int not null references Type_depense(idtypedepense),
    prix float not null,
    date date
);


-- Degat/Gain
-- 19
Create table service_client(
    idserviceclient serial not null primary key,
    idvehiculeclient int not null references vehicule_client(idvehiculeclient),
    idclient int not null references Client(idclient),
    idtypeservice int   not null references Type_Service(idtypeservice),
    libelle TEXT not null,
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

-- Produit
-- 22
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

-- View
-- Liste employe
create or replace view liste_employe as
select idemploye, Employe.nom, Employe.prenom, genre.nom as genre , specialite.nomspecialite from Employe join genre on (Employe.idgenre=genre.idgenre) join specialite on (Employe.idspecialite=specialite.idspecialite);


select * from liste_employe;

-- Liste vehicule
create or replace view liste_vehicule as
select vc.idclient,c.nom,c.prenom,vc.immatriculation,mq.marque,m.modele from vehicule_client vc 
join modele m on vc.idmodele=m.id 
join marque mq on mq.id=m.idmarque 
join vehicule v using(idvehicule) 
join client c using(idclient);

select * from liste_vehicule;

-- liste_client
select Client.idclient, Client.nom, Client.prenom, Client.contact
from Client;

-- devis_service
create or replace view devis_service as
select tp.idtypeservice,tp.type_service,spc.nomspecialite,sp.dureetravail,spc.salaire_par_heure,(spc.salaire_par_heure*sp.dureetravail) as prix_salariale, tp.marge_beneficiaire from type_service tp 
join Service_specialite sp using(idtypeservice) 
join specialite spc using(idspecialite);

-- devis produit
Create or replace view devis_produit as
select p.idproduit,p.nomproduit,p.prix,s_p.quantite,tp.idtypeservice,tp.type_service,(p.prix*s_p.quantite) as prix_total_produit from produit p 
join Service_produit s_p using(idproduit) 
join type_service tp  using(idtypeservice); 


-- Somme total du salaire_par_heure de chaque specialites utilisees pour effectuer le x service
Create or replace view total_devis_service as
select idtypeservice,sum(ds.prix_salariale) from devis_service ds group by idtypeservice;


-- Somme total du prix des produits utilisees pour effectuer le x service
Create or replace view total_devis_produit as
select idtypeservice,sum(ds.prix_total_produit) from devis_produit ds group by idtypeservice;


-- Calcul benefice;
-- Prix de vente d'un service - depenses utilisation de produit;


-- select tp.idtypeservice,tp.type_service,spc.nomspecialite,sp.dureetravail,spc.salaire_par_heure,(spc.salaire_par_heure*sp.dureetravail+tp.marge_beneficiaire) as prix_salariale from type_service tp 
-- join Service_specialite sp using(idtypeservice) 
-- join specialite spc using(idspecialite)
-- join service_client sc using(idtypeservice);

create or replace view service as select service.idtypeservice, service.type_service, produit.sum as montant_produit, d_service.sum as montant_service, service.marge_beneficiaire
from type_service service
join total_devis_produit produit on service.idtypeservice = produit.idtypeservice 
join total_devis_service d_service on service.idtypeservice = d_service.idtypeservice;
