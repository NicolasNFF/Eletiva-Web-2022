import { Component, OnInit } from '@angular/core';

import { Observable, Subject } from 'rxjs';

import {
   debounceTime, distinctUntilChanged, switchMap
 } from 'rxjs/operators';

import { Carro } from '../carro';
import { CarroService } from '../carro.service';

@Component({
  selector: 'app-carro-listar',
  templateUrl: './carro-listar.component.html',
  styleUrls: [ './carro-listar.component.css' ]
})
export class CarroListarComponent implements OnInit {
  estudantes$!: Observable<Carro[]>;
  private searchTerms = new Subject<string>();

  constructor(private EstudanteService: CarroService) {}

  // Push a search term into the observable stream.
  search(term: string): void {
    this.searchTerms.next(term);
  }

  ngOnInit(): void {
    this.carros$ = this.searchTerms.pipe(
      // wait 300ms after each keystroke before considering the term
      debounceTime(300),

      // ignore new term if same as previous term
      distinctUntilChanged(),

      // switch to new search observable each time the term changes
      switchMap((term: string) => this.CarroService.searchcarros(term)),
    );
  }
}