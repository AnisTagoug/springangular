import { Component } from '@angular/core';
import { NgToastService } from 'ng-angular-popup';
import { Departement } from 'src/app/models/departement.model';
import { DepartementService } from 'src/app/_services/departement.service';
import { UniversiteService } from 'src/app/_services/universite.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent {
  departements:Departement []=[];
  dep:any={}
  singledep:any
  show=false;
  universite:any[]=[];
  idUniv:any;


   constructor(
     private departementService : DepartementService,
     private toast: NgToastService,
     private univ : UniversiteService
   ) { }

   ngOnInit(): void {
 this.showdep();

 this.univ.getUniversite().subscribe(
  data => {
    this.universite=data
  }
)

   }

   showdep(){
     this.departementService.getDepartement().subscribe(
       data =>{
         this.departements = data ;
         console.log(data);

       },
       error =>{
         console.log(error) }
     )
   }

   ajouterdep(){
     this.departementService.addDepartement(this.dep).subscribe(
       data =>{
         this.toast.success({detail:"SUCCESS",summary:'Votre departement est ajouté !',duration:3000} ),
         this.showdep()




       }
     )
   }
   delete(i:any){
     this.departements.splice(i,1)

   }

   deletedep(id:any,i:any){
     if (confirm("do you really want to delete this item ?"))
     {
 this.departementService.deleteDepartement(id).subscribe(),
 this.delete(i),
 this.toast.error({detail:"DELETE",summary:'Votre departement est supprimé !',duration:3000} )
     }
   }


   showFormUpdate(p:any){
     this.singledep=p;
     this.show=true;

   }




   affecter(){
    console.log("enaaaa id",this.idUniv)
    this.departementService.affecter(this.singledep.idDepart,this.idUniv,this.singledep).subscribe(data=>console.log(data))

   }



 }


