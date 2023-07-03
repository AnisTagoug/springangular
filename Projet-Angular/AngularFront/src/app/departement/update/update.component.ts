import { Component, Input } from '@angular/core';
import { NgToastService } from 'ng-angular-popup';
import { Departement } from 'src/app/models/departement.model';
import { DepartementService } from 'src/app/_services/departement.service';
import { UniversiteService } from 'src/app/_services/universite.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent {

  @Input()dep:any;
  universite:any[]=[]

  constructor(
    private service : DepartementService,
    private univ: UniversiteService,
    private toast : NgToastService
  ) { }

  ngOnInit(): void {
 

  }

  updateUniv(univ:Departement){
    this.service.editDepartement(univ).subscribe(
      data =>{
        this.toast.info({detail:"SUCCESS",summary:'Votre departement est mise a jour !',duration:3000} )
      }
    )

  }

}
