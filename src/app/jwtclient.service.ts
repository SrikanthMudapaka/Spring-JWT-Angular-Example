import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class JwtclientService {

  constructor(private http:HttpClient) { }

  public generateToken(request){

    return this.http.post("http://localhost:9090/authenticate",request,{responseType: 'text' as 'json'});

  }

  public welcome(token) {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.get<string>("http://localhost:9090/", {headers, responseType: 'text' as 'json' });
  }


}
