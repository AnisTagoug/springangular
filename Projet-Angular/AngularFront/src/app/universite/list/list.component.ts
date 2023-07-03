import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Universite } from 'src/app/models/universite.model';
import { UniversiteService } from 'src/app/_services/universite.service';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  universites:Universite []=[];
 univ:any={}
 singleUniv:any
 show=false;


  constructor(
    private universiteService : UniversiteService,
    private toast: NgToastService
  ) { }

  ngOnInit(): void {
this.showUniv()

  }

  showUniv(){
    this.universiteService.getUniversite().subscribe(
      data =>{
        this.universites = data ;
        console.log(data);

      },
      error =>{
        console.log(error) }
    )
  }

  ajouterUniv(){
    this.universiteService.addUniversite(this.univ).subscribe(
      data =>{
        this.toast.success({detail:"SUCCESS",summary:'Votre universite est ajouté !',duration:3000} ),
        this.showUniv()




      }
    )
  }
  delete(i:any){
    this.universites.splice(i,1)

  }

  deleteUniv(id:any,i:any){
    if (confirm("do you really want to delete this item ?"))
    {
this.universiteService.deleteUniversite(id).subscribe(),
this.delete(i),
this.toast.error({detail:"DELETE",summary:'Votre universite est supprimé !',duration:3000} )
    }
  }


  showFormUpdate(p:any){
    this.singleUniv=p;
    this.show=true;

  }



}
