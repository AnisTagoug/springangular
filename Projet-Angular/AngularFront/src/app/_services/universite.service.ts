import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Universite } from '../models/universite.model';

@Injectable({
  providedIn: 'root'
})
export class UniversiteService {

  constructor(
    private http : HttpClient
  ) { }

getUniversite():Observable<Universite[]>{
  return this.http.get<Universite[]>(environment.apiUrl + 'Universite')

}

addUniversite(unicersite : Universite){
return this.http.post(environment.apiUrl + 'Universite/addUniversite',unicersite)
}

deleteUniversite(id:any){
  return this.http.delete(environment.apiUrl+ 'Universite/'+id)
}

editUniversite(universite:Universite){
  return this.http.put(environment.apiUrl+ 'Universite/editUniversite',universite)
}

}
