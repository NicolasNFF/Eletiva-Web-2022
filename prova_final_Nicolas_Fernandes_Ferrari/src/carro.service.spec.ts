import { TestBed } from '@angular/core/testing';

import { CarroService } from './carro.service';

describe('CarroService', () => {
  let service: CarrosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CarroService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});