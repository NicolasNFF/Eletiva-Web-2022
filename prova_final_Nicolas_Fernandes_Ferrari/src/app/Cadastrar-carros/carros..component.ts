import { Component, OnInit } from '@angular/core';

import { Carros } from '../carro';
import { CarroService } from '../carro.service';

@Component({
  selector: 'app-carros',
  templateUrl: './carros.component.html',
  styleUrls: ['./carros.component.css']
})
export class CarrosComponent implements OnInit {
  carros: Carros[] = [];

  constructor(private CarroService: CarroService) { }

  ngOnInit(): void {
    this.getcarros();
  }

  getcarros(): void {
    this.CarroService.getcarros()
    .subscribe(carros => this.carros = carros);
  }

  add(codigo: any, modelo: string, preço: any, AnoFab: any): void {
    codigo = codigo.trim();
    modelo = modelo.trim();
    preço = preço.trim();
    AnoFab = AnoFab.trim();
    if (!codigo) { return; }
    this.CarroService.addCarro({ codigo } as Carros)
      .subscribe(carro => {
        this.carros.push(carro);
      });      
  } 

  delete(carro: Carros): void {
    this.carros = this.carros.filter(h => h !== carro);
    this.CarroService.deleteEstudante(carro.id).subscribe();
  }

}