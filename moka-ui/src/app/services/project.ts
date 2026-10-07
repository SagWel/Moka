import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Project as ProjectModel } from '../models/models';

@Injectable({
  providedIn: 'root',
})
export class Project {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/projects';

  getAllProjects(): Observable<ProjectModel[]> {
    return this.http.get<ProjectModel[]>(this.apiUrl);
  }

  createProject(project: ProjectModel): Observable<ProjectModel> {
    return this.http.post<ProjectModel>(this.apiUrl, project);
  }

  deletePrejoect(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
