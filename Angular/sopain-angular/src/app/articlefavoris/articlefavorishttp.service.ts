import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../auth/auth.service';
import { ArticleFavori, Basique, Client } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ArticleFavorisHttpService {

  

  articlefavoris: Array<ArticleFavori> = new Array<ArticleFavori>();
  currentclient: Client;
   
  constructor(private http: HttpClient, private auth: AuthService) {
    this.load();
  }


  findAll(): Array<ArticleFavori> {
    return this.articlefavoris;
  }

  findById(id: number): Observable<ArticleFavori> {
    return this.http.get<ArticleFavori>("http://localhost:8888/articleFavoris/" + id);
  }

  create(articlefavoris: ArticleFavori): void {
    this.http.post<ArticleFavori>("http://localhost:8888/articleFavoris", articlefavoris).subscribe(resp => {
      this.load();
    });
  }

  update(articlefavoris: ArticleFavori): void {
    this.http.put<ArticleFavori>("http://localhost:8888/articleFavoris/" + articlefavoris.id, articlefavoris).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>("http://localhost:8888/articleFavoris/" + id).subscribe(resp => {
      this.load();
    });
  }

  findAllclientarticlefavoris(client: Client): Array<ArticleFavori> {
    return this.articlefavoris
  
  }

  findByIdCli(id: number): Observable<Client> {
    return this.http.get<Client>("http://localhost:8888/client/" + id);
  }
 
  private load(): void {

    this.findByIdCli(this.auth.connected.id).subscribe(resp => {
      this.currentclient=resp;
    });
   
    this.http.get<Array<ArticleFavori>>("http://localhost:8888/articleFavoris").subscribe(resp => {
      this.articlefavoris = resp;
    });
  }

}
