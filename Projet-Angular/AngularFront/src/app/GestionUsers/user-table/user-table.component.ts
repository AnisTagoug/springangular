import {Component, OnInit} from '@angular/core';
import {UserService} from "../../_services/user.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css']
})
export class UserTableComponent implements OnInit{
user:any;
role:any;
term:any;
 page:number=0;
 pages: Array<number> | undefined;
  orderHeader:String='';
  isDescOrder:boolean=true;

  constructor(private userService:UserService) {
  }

  ngOnInit(): void {
    this.afficher();
  }

  setPage(i:any,event:any){
    event.preventDefault();
    this.page=i;
    this.afficher();

  }



 /* afficher(){
    this.userService.GetAllUsers().toPromise().then((res:any)=>
    {
      console.log(res);

      this.user=res;
      console.log("role :")
    }).catch((err)=>{
      console.log("erreur a afficher les utilisateurs");
    })
  }
*/

  deleteUser(userName:any){
    if (confirm("do you really want to delete this item ?")) {
      console.log(userName);
      this.userService.deleteUser(userName).subscribe((res)=>{ this.afficher() })
    }
  }

  afficher(){
    this.userService.PaginationUsers(this.page).toPromise().then((data:any)=>
    {
      this.user=data['content'];
      this.pages=new Array(data['totalPages']);
      console.log("role :")
    }).catch((err)=>{
      console.log("erreur a afficher les utilisateurs");
    })
  }

  sort(headerName:String){
    this.isDescOrder=! this.isDescOrder;
    this.orderHeader=headerName;
  }

}
