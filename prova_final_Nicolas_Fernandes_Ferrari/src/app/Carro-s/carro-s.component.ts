import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { Carro } from '../carro';
import { CarroService } from '../carro.service';

@Component({
  selector: 'app-carro-s',
  templateUrl: './carro-s.component.html',
  styleUrls: [ './carro-s.component.css' ]
})
export class CarroSComponent implements OnInit {
  estudante: Carro | undefined;

  constructor(
    private route: ActivatedRoute,
    private CarroService: CarroService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getCarro();
  }

  getCarro(): void {
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.CarroService.getCarro(id)
      .subscribe(carro => this.carro = carro);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    if (this.carro) {
      this.CarroService.updateCarro(this.carros)
        .subscribe(() => this.goBack());
    }
  }
}