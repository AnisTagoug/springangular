import { Component, Input, OnInit } from '@angular/core';
import { Universite } from 'src/app/models/universite.model';
import { UniversiteService } from 'src/app/_services/universite.service';
import { NgToastService } from 'ng-angular-popup';
@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  @Input()univ:any;

  constructor(
    private service : UniversiteService,
    private toast : NgToastService
  ) { }

  ngOnInit(): void {
  }

  updateUniv(univ:Universite){
    this.service.editUniversite(univ).subscribe(
      data =>{
        this.toast.info({detail:"SUCCESS",summary:'Votre universite est mise a jour !',duration:3000} )
      }
    )

  }

}
