import {Component, OnInit} from '@angular/core';
import {UserService} from "../../_services/user.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit{

  user= new FormGroup({
    userName: new FormControl('', [Validators.required]),
    nom: new FormControl('', [Validators.required]),
    prenom: new FormControl('', [Validators.required]),
    email : new FormControl('',[Validators.required,Validators.email]),
    password : new FormControl('',[Validators.required])

  })

  constructor(private userService:UserService) {
  }
  ngOnInit(): void {
  }

  addData(){
    this.userService.adduser(this.user.value).subscribe((res: any) => {
      alert('user added ');
      history.back();
    }, (err) => {
      console.log(err);

    })
  }

}
