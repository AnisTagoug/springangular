import { Departement } from "./departement.model";

export class Universite {

  idUniv: number;
  nomUniv: string;
  departements:Departement[]=[]

  constructor(nomUniv: string, idUniv: number) {
    this.idUniv = idUniv
    this.nomUniv = nomUniv

  }
}
