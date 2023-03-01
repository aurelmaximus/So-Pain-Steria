import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../auth/auth.service';
import { ArticleFavori } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ArticleFavorisgcHttpService {
  

  articlefavoris: Array<ArticleFavori> = new Array<ArticleFavori>();
   
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

  findByIdEmp(id: number): Observable<ArticleFavori> {
    return this.http.get<ArticleFavori>("http://localhost:8888/articleFavoris/" + id);
  }

  private load(): void {
   
    this.http.get<Array<ArticleFavori>>("http://localhost:8888/articleFavoris").subscribe(resp => {
      this.articlefavoris = resp;
    });
  }

}
