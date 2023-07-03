import { Component } from '@angular/core';
import {UserAuthService} from "../_services/user-auth.service";
import {Router} from "@angular/router";
import {UserService} from "../_services/user.service";

@Component({
  selector: 'app-navbar-admin',
  templateUrl: './navbar-admin.component.html',
  styleUrls: ['./navbar-admin.component.css']
})
export class NavbarAdminComponent {
  constructor(
    private userAuthService: UserAuthService,
    private router: Router,
    public userService: UserService
  ) {}

  ngOnInit(): void {}



  public logout() {
    this.userAuthService.clear();
    this.router.navigate(['/login']);
  }
}
