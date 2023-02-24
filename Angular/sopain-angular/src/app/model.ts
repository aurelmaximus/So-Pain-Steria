export abstract class Compte {
    id: number; 
	version: number;
    email: string;
    password: string;
    nom: string;
    prenom: string;
    adresse:Adresse;
 
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
    cp:number;

    constructor(numero?:number, voie?:string, ville?:string, cp?:number) {
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
