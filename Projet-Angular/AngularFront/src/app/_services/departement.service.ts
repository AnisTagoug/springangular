import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Departement } from '../models/departement.model';

@Injectable({
  providedIn: 'root'
})
export class DepartementService {

  constructor(
    private http : HttpClient
  ) { }

getDepartement():Observable<Departement[]>{
  return this.http.get<Departement[]>(environment.apiUrl + 'Departement')

}

addDepartement(departement : Departement){
return this.http.post(environment.apiUrl + 'Departement/addDepartement',departement)
}

deleteDepartement(id:any){
  return this.http.delete(environment.apiUrl+ 'Departement/'+id)
}

editDepartement(Departement:Departement){
  return this.http.put(environment.apiUrl+ 'Departement/editDepartement',Departement)
}

affecter(idDep:any,idUniv:any,departement:Departement){
  return this.http.put(environment.apiUrl+ 'Departement/AssignUniversiteToDepartement/'+ idUniv +'/'+ idDep,{})
}

}
