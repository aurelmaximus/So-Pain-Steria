export class Compte {
    id: number; 
	version: number;
    email: string;
    password: string;
    nom: string;
    prenom: string;
    adresse:Adresse;
    type: string;
 
    constructor(id?:number, version?: number , email?: string, password?: string, nom?: string, prenom?: string, adresse?:Adresse) {
        this.id = id;
        this.version = version;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
    }
}


export class Adresse {
  
    numero:number;
    voie:string;
    ville:string;
    cp:string;

    constructor(numero?:number, voie?:string, ville?:string, cp?:string) {
       this.numero=numero;
       this.voie=voie;
       this.ville=ville;
       this.cp=cp;
       
    }
}



export class Employe extends Compte {
  
    constructor(id?:number, version?: number , email?: string, password?: string, nom?: string, prenom?: string, adresse?:Adresse) {
        super(id, version,email, password, nom, prenom, adresse);
       
    }
}


export class Client extends Compte{

    points : number;
    
constructor(id?:number, version?: number , email?: string, password?: string, nom?: string, prenom?: string, adresse?:Adresse) {
    super(id, version,email, password, nom, prenom, adresse);
   
}

}

export class AuthDTO {
    login: string;
    password: string;

    constructor(login?: string, password?: string) {
        this.login = login;
        this.password = password;
    }
}



export class Commande {
  
    numero:number;
    version: number;
    dateArrivee:string;
    heureArrive:string;
    etatcommande:string;
    client:Client;
    lignesCommande: Array<LigneCommande>;

    constructor(numero?:number, version?: number, dateArrivee?:string ,heureArrive?:string, etatcommande?:string, lignesCommande?:Array<LigneCommande>) {
       this.numero=numero;
       this.version=version;
       this.dateArrivee=dateArrivee;
       this.heureArrive=heureArrive;
       this.etatcommande=etatcommande;
       this.lignesCommande=lignesCommande;
      
       
    }
}

export enum EtatCommande {

    EnCours,Prete,Termine

}

export class LigneCommande {

    id:number;
    version:number;
    qte:number;
    total:number;
    commande:Commande;
    produit:Produit;

    constructor(id?:number, version?:number, qte?:number, total?:number, commande?:Commande, produit?:Produit) {

        this.id==id;
        this.version=version;
        this.qte=qte;
        this.total=total;
        this.commande=commande;
        this.produit=produit;
    }

}

export class Produit {
    id: number; 
	version: number;
    prix:number;
    libelle:string;
    description: string;
    image_ref: string;

    constructor(id?:number, version?: number, prix?:number, libelle?:string, description?:string, image_ref?:string) {
        this.id = id;
        this.version = version;
        this.prix = prix;
        this.libelle = libelle;
        this.description=description;
        this.image_ref=image_ref;
       
    }
}

export class Basique extends Produit {
   
    categorie:string;

    constructor(id?:number, version?: number, prix?:number, libelle?:string, categorie?:string) {
        super(id,version,prix,libelle);

    this.categorie=categorie;
    
    }

}

export class ArticleFavori {
    id: number; 
    version: number;
    client:Client;
    basique:Basique;
   

    constructor(id?:number, version?: number, client?:Client, basique?:Basique) {
        this.id = id;
        this.version = version;
        this.client=client;
        this.basique=basique;
       
       
    }
}




