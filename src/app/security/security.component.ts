import { Component, OnInit } from '@angular/core';
import { JwtclientService } from '../jwtclient.service';
import { tokenName } from '@angular/compiler';

@Component({
  selector: 'app-security',
  templateUrl: './security.component.html',
  styleUrls: ['./security.component.css']
})
export class SecurityComponent implements OnInit {

  authrequest :any={
    "name":"storm",
    "password":"99991"
  }

  
  response:any;

  constructor(private service:JwtclientService) { }

  ngOnInit() {
    this.getAccessToken(this.authrequest);
  }

  public getAccessToken(authRequest){
let resp=this.service.generateToken(authRequest);
resp.subscribe(data=>this.accessApi(data));
  }


  public accessApi(token){
let resp=this.service.welcome(token);
resp.subscribe(data=>this.response=data);
  }

}
